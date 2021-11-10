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
  
  connectionManager cm;
  Scanner keyboard = new Scanner(System.in);
  String user, pass, ip, port;
  
  do {
    
    System.out.print(GREEN_BOLD_BRIGHT + "# Server: " + RESET);
    ip = keyboard.nextLine();
    
    System.out.print(GREEN_BOLD_BRIGHT + "# Port: " + RESET);
    port = keyboard.nextLine();
    
    System.out.print(GREEN_BOLD_BRIGHT + "# Username: " + RESET);
    user = keyboard.nextLine();
    
    System.out.print(GREEN_BOLD_BRIGHT + "# Password: " + BLACK);
    pass = keyboard.nextLine();
    System.out.print(RESET);
    
    cm = new connectionManager(ip, port, user, pass);
    
  } while (cm.connectDBMS() == null);
  
  cm.startShell();
}

}
