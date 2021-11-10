package com.ieseljust.ad.myDBMS;

import java.sql.*;
import java.util.Scanner;

import static com.ieseljust.ad.myDBMS.ConsoleColors.*;

class connectionManager {

String server;
String port;
String user;
String pass;

connectionManager() {
  // TO-DO: Inicialització dels atributs de la classe per defecte
  
}

connectionManager(String server, String port, String user, String pass) {
  // TO-DO:   Inicialització dels atributs de la classe amb els valors indicats
}

public Connection connectDBMS() {
  // TO-DO:   Crea una connexió a la base de dades, i retorna aquesta o null, si no s'ha pogut connectar.
  
  // Passos:
  // 1. Carreguem el driver JDBC
  // 2. Crear la connexió a la BD
  // 3. Retornar la connexió
  
  // Recordeu el tractament d'errors
  
  return null;
  
}

public void showInfo() {
  // TO-DO: Mostra la informació del servidor a partir de les metadades
  // - Nom del SGBD
  // - Driver utilitzat
  // - URL de connexió
  // - Nom de l'usuari connectat
  
  // Recordeu el tractament d'errors
}

public void showDatabases() {
  // TO-DO: Mostrem les bases de dades del servidor, bé des del catàleg o amb una consulta
  
  // Recordeu el tractament d'errors
}

public void startShell() {
  
  Scanner keyboard = new Scanner(System.in);
  String command;
  
  do {
    
    System.out.print(GREEN_BOLD_BRIGHT + "# (" + this.user + ") on " + this.server + ":" + this.port + "> " + RESET);
    command = keyboard.nextLine();
    
    
    switch (command) {
      case "sh db":
      case "show databases":
        this.showDatabases();
        break;
      
      case "info":
        this.showInfo();
        break;
      
      case "quit":
        break;
      
      default:
        // Com que no podem utilitzar expressions
        // regulars en un case (per capturar un "use *")
        // busquem aquest cas en el default:
        String[] subcommand = command.split(" ");
        switch (subcommand[0]) {
          case "use":
            // TO-DO:
            // Creem un objecte de tipus databaseManager per connectar-nos a
            // la base de dades i iniciar una shell de manipulació de BD..
            System.out.println("use");
            break;
          
          case "test":
            System.out.println("test");
            break;
          
          default:
            System.out.println(RED + "Unknown option" + RESET);
            break;
        }
    }
    
  } while (!command.equals("quit"));
  
}
}