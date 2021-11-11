package com.ieseljust.ad.myDBMS;

// Imports per a entrada de dades

import java.util.Scanner;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
// Imports per a entrada de dades
import java.util.Scanner;

import static com.ieseljust.ad.myDBMS.ConsoleColors.*;


public class DBMan {
  /*
  Esta és la classe llançadora de l'aplicació
  Conté el mètode main que recull la informació del servidor
  i inicia una instància de connectionManager per
  gestionar les connexions
  */

public static void main(String[] args) {
  System.out.println("-------------------------------\n");
  String user, pass, server, port;
  
  do {
    
    server = Utilidades.leerTexto(GREEN_BOLD_BRIGHT + "# Server: " + RESET);
    port = Utilidades.leerTexto(GREEN_BOLD_BRIGHT + "# Port: " + RESET);
    user = Utilidades.leerTexto(GREEN_BOLD_BRIGHT + "# Username: " + RESET);
    pass = Utilidades.leerTexto(GREEN_BOLD_BRIGHT + "# Password: " + BLACK);
    System.out.print(RESET);
    
  } while (connectionManager.connectDBMS(server, port, user, pass) == null);
  
  connectionManager.startShell();
}

}
