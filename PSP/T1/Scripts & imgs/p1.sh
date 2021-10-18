#!/bin/bash
MYVAR="Variable";
echo "Hola, soc el procés 1, i tinc definida la variable $MYVAR"
echo "Invoque a p2.sh i m'espere que acabe:"
./p2.sh
echo "p2.sh ha finalitzat amb eixida $?"
echo "Estat dels processos:"
ps -o pid,ppid,cmd,state