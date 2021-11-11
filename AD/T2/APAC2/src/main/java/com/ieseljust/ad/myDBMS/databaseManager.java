package com.ieseljust.ad.myDBMS;

import java.sql.*;
import java.util.Scanner;

import java.util.ArrayList;

class databaseManager {

String server;
String port;
String user;
String pass;
String dbname;

databaseManager() {
  // TODO: Inicialització dels atributs de la classe per defecte
}

databaseManager(String server, String port, String user, String pass, String dbname) {
  // TODO: Inicialització dels atributs de la classe amb els valors indicats
}

public Connection connectDatabase() {
  // TODO: Crea una connexió a la base de dades, i retorna aquesta o null, si no s'ha pogut connectar.
  
  // Passos:
  // 1. Carreguem el driver JDBC
  // 2. Crear la connexió a la BD
  // 3. Retornar la connexió
  
  // Recordeu el tractament d'errors
  
  return null;
}

public void showTables() {
  // TODO: Mostra un llistat amb les taules de la base de dades
  
  // Passos:
  // 1. Establir la connexió a la BD
  // 2. Obtenir les metadades
  // 3. Recórrer el resultset resultant mostrant els resultats
  // 4. Tancar la connexió
  
  // Recordeu el tractament d'errors
}

public void insertIntoTable(String table) {
  // TODO: Afig informació a la taula indicada
  
  // Passos
  // 1. Estableix la connexió amb la BD
  // 2. Obtenim les columnes que formen la taula (ens interessa el nom de la columna i el tipus de dada)
  // 3. Demanem a l'usuari el valor per a cada columna de la taula
  // 4. Construim la sentència d'inserció a partir de les dades obtingudes
  //    i els valors proporcionats per l'usuari
  
  // Caldrà tenir en compte:
  // - Els tipus de dada de cada camp
  // - Si es tracta de columnes generades automàticament per la BD (Autoincrement)
  //   i no demanar-les
  // - Gestionar els diferents errors
  // - Si la clau primària de la taula és autoincremental, que ens mostre el valor d'aquesta quan acabe.
  
}

public void showDescTable(String table) {
  // TODO: Mostra la descripció de la taula indicada,
  //        mostrant: nom, tipus de dada i si pot tindre valor no nul
  //        Informeu també de les Claus Primàries i externes
  
}

public void startShell() {
  // TODO: Inicia la shell del mode base de dades
  
}
}