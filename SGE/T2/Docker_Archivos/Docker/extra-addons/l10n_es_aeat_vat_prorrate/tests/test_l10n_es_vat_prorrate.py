# Copyright 2016-2020 Tecnativa - Pedro M. Baeza
# License AGPL-3 - See https://www.gnu.org/licenses/agpl-3.0

from odoo.addons.l10n_es_aeat_mod303.tests.test_l10n_es_aeat_mod303 import (
    TestL10nEsAeatMod303Base,
)


class TestL10nEsAeatVatProrrateBase(TestL10nEsAeatMod303Base):
    @classmethod
    def setUpClass(cls):
        super().setUpClass()
        cls.taxes_sale = {
            # tax code: (base, tax_amount)
            "S_IVA21B": (1400, 294),
            "S_IVA21B//neg": (-140, -29.4),
            "S_IVA0": (200, 0),
        }
        cls.taxes_purchase = {
            # tax code: (base, tax_amount)
            "P_IVA4_BC": (240, 9.6),
            "P_IVA10_BC": (250, 25),
            "P_IVA21_BC": (260, 54.6),
        }
        cls.invoice_purchase = cls._invoice_purchase_create("2017-01-03")
        cls.invoice_sale = cls._invoice_sale_create("2017-01-13")
        cls.journal = cls.env["account.journal"].create(
            {"name": "Test journal", "code": "TEST", "type": "general"}
        )
        cls.account_type = cls.env["account.account.type"].create(
            {"name": "Test account type", "type": "other", "internal_group": "expense"}
        )
        cls.counterpart_account = cls.env["account.account"].create(
            {
                "name": "Test counterpart account",
                "code": "COUNTERPART",
                "user_type_id": cls.account_type.id,
            }
        )
        cls.prorrate_regul_account = cls.env["account.account"].search(
            [
                ("code", "like", "6391%"),
                ("company_id", "=", cls.model303.company_id.id),
            ],
            limit=1,
        )
        if not cls.prorrate_regul_account:
            cls.prorrate_regul_account = cls.env["account.account"].create(
                {
                    "name": "Test prorrate regularization account",
                    "code": "6391000",
                    "user_type_id": cls.account_type.id,
                }
            )
        cls.model303.write(
            {
                "vat_prorrate_type": "general",
                "vat_prorrate_percent": 80,
                "journal_id": cls.journal.id,
            }
        )
        cls.model303_4t.write(
            {
                "vat_prorrate_type": "general",
                "vat_prorrate_percent": 80,
                "journal_id": cls.journal.id,
            }
        )


class TestL10nEsAeatVatProrrate(TestL10nEsAeatVatProrrateBase):
    def test_vat_prorrate(self):
        # First trimester
        self.model303.button_calculate()
        self.model303.counterpart_account_id = self.counterpart_account.id
        self.assertAlmostEqual(self.model303.total_deducir, 71.36, 2)
        self.model303.create_regularization_move()
        self.assertAlmostEqual(len(self.model303.move_id.line_ids), 6, 2)
        lines = self.model303.move_id.line_ids
        line_counterpart = lines.filtered(
            lambda x: x.account_id == self.counterpart_account
        )
        self.assertAlmostEqual(line_counterpart.credit, 193.24, 2)
        # Last trimester
        wizard = (
            self.env["l10n.es.aeat.compute.vat.prorrate"]
            .with_context(active_id=self.model303_4t.id)
            .create({"year": 2017})
        )
        wizard.button_compute()
        self.assertAlmostEqual(self.model303_4t.vat_prorrate_percent, 87, 2)
        self.model303_4t.button_calculate()
        self.assertAlmostEqual(self.model303_4t.casilla_44, 6.24, 2)
        self.assertEqual(
            self.model303_4t.prorrate_regularization_account_id,
            self.prorrate_regul_account,
        )
        self.model303_4t.create_regularization_move()
        lines = self.model303_4t.move_id.line_ids
        line_prorrate_regularization = lines.filtered(
            lambda x: x.account_id == self.prorrate_regul_account
        )
        self.assertAlmostEqual(line_prorrate_regularization.credit, 6.24, 2)
