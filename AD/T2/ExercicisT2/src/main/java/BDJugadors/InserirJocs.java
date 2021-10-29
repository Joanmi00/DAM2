package BDJugadors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirJocs {
public static void main(String[] args) {
  Connection conn = null;
  Statement st = null;
  String sentSQL;
  
  try {
    // Carreguem el driver JDBC
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Creem la connexió a la base de dades
    String connectionUrl = "jdbc:mysql://localhost:3308/BDJocs" +
                           "?useUnicode=true&characterEncoding=UTF-8" +
                           "&user=root" +
                           "&password=root";
    
    conn = DriverManager.getConnection(connectionUrl);
    
    st = conn.createStatement();
    
    sentSQL = "INSERT INTO Joc VALUES (1, 'Double Dragon', 'Dos germans bessons experts en arts marcials s`han de fer camí en un escenari urbà on membres de bandes rivals volen deixar -los fora de combat. ', 1);";
    st.executeUpdate(sentSQL);
    
    sentSQL = "INSERT INTO Joc VALUES (2, 'Tetris', 'Tetris és un videojoc de tipus trencaclosques inventat per l`enginyer informàtic rus Aleksei Pàjitnov l`any 1985 mentre treballava a l`Académia de Ciéncies de Moscou ', 4);";
    st.executeUpdate(sentSQL);
    
  } catch (SQLException ex) {
    System.out.println("Error " + ex.getMessage());
  } catch (ClassNotFoundException ex) {
    System.out.println("No s'ha trobat el controlador JDBC (" + ex.getMessage() + ")");
    
  } finally {
    try {
      if (st != null && !st.isClosed()) st.close();
    } catch (SQLException ex) {
      System.out.println("No s'ha pogut tancar el Statement");
    }
    
    try {
      if (conn != null && !conn.isClosed()) conn.close();
    } catch (SQLException ex) {
      System.out.println("No s'ha pogut tancar la connexió");
    }
  }
}
}
