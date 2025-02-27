package devguideocp.Part5_C22to26.A24_1_DatabaseConn;

/**
 * @author hatzp
 **/
public class Details {

//    try {
//        /* execute JDBC operations */
//    } catch (SQLException e) {
//        String state = e.getSQLState();
//        int code = e.getErrorCode();
//    }


    //try {
    //  /* establish database connection     */
    //  /* create and execute SQL statements */
    //  /* process results                   */
    //} catch (SQLException e) {
    //  /* handle any errors */
    //} finally {
    //  /* close result sets */
    //  /* close statements  */
    //  /* close connection  */
    //}


    //try (/* establish database connection     */
    //     /* create and execute SQL statements */)
    //{
    //  /* process results */
    //} catch (SQLException e) {
    //  /* handle any exceptions */
    //} /* implicit finally block closes resources*/


//final String jdbcURL = "jdbc:derby:musicDB";
//try (Connection connection = DriverManager.getConnection(jdbcURL);
//     Statement statement
//         = connection.createStatement()) {      // Obtain a Statement object.
//  String sql = "select * from compositions";    // SELECT query: select all rows.
//  boolean isSelectStmt = statement.execute(sql);          // (1) Execute the query
//  System.out.println("SELECT statement? " + isSelectStmt);// (2) SELECT statement?
//                                                          //     true
//} catch (SQLException e) {
//  e.printStackTrace();
//}


    //boolean isSelectStmt = statement.execute(sql);
    //if (isSelectStmt) {
    //  try (ResultSet resultSet
    //           = statement.getResultSet()) { // SELECT statement: retrieve ResultSet.
    //    System.out.println("SELECT statement: processing ResultSet");
    //  }
    //} else {                                               // Update statement:
    //  int rowCount = statement.getUpdateCount();           // Retrieve the number of
    //                                                       // rows affected.
    //  System.out.println("Update statement: Rows affected " + rowCount);
    //}

    //try (Connection connection = DriverManager.getConnection(jdbcURL);
    //     Statement statement
    //         = connection.createStatement()) {         // Obtain a Statement object.
    //  String sql = "select * from compositions";       // SQL query: select all rows.
    //
    //  try (ResultSet resultSet
    //           = statement.executeQuery(sql)) {    // (1) Nested try-with-resources
    //   System.out.println("Processing ResultSet");
    //  }
    //} catch (SQLException e) {
    //  e.printStackTrace();
    //}


    //Create a Connection with the DriverManager.getConnection() method.
    //
    //Obtain a Statement from the connection by calling its createStatement() method.
    //
    //Formulate a SQL operation.
    //
    //Call the appropriate execute method of the statement, passing the SQL operation as the String parameter.
    //see below

    //try (Connection connection = DriverManager.getConnection(jdbcURL);     // (1)
    //     Statement statement = connection.createStatement()) {             // (2)
    //  String sql = "update compositions set duration = duration * 2";      // (3)
    //  int count = statement.executeUpdate(sql);                            // (4)
    //  System.out.println("Rows modified: " + count);
    //} catch (SQLException e) {
    //  e.printStackTrace();
    //}

//demo
    //comments below are number related to the code below them
    //Formulate a SQL operation with marker parameters.
    //
    //Create a Connection with the DriverManager.getConnection() method.
    //
    //Create a PreparedStatement from the connection by calling its prepareStatement() method and passing the SQL operation as a parameter.
    //
    //Set the values of all marker parameters.
    //
    //Call the appropriate execute method of the prepared statement.

    //import java.sql.*;
    //
    //public class XQTPreparedStatement {
    //  public static void main(String[] args) {
    //    final String jdbcURL = "jdbc:derby:musicDB";
    //    String sql = "select * from compositions where duration > ?";           // (1)
    //    try (Connection connection = DriverManager.getConnection(jdbcURL);      // (2)
    //        PreparedStatement pStatement = connection.prepareStatement(sql);) { // (3)
    //      pStatement.setInt(1, 200);                                            // (4)
    //      boolean result = pStatement.execute();                                // (5)
    //      System.out.println(result);
    //    } catch (SQLException e) {
    //      e.printStackTrace();
    //    }
    //  }
    //}



    //example
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class PreparedStatementExecuteUpdate {
//  public static void main(String[] args) {
//
//    final String insSql = "insert into compositions VALUES(?, ?, ?)";
//    final String updSql = "update compositions set title = ? where title = ?";
//    final String delSql = "delete from compositions where duration = ?";
//
//    final String jdbcURL = "jdbc:derby:musicDB";
//    try (var connection = DriverManager.getConnection(jdbcURL);
//        var pStatement1 = connection.prepareStatement(insSql);
//        var pStatement2 = connection.prepareStatement(updSql);
//        var pStatement3 = connection.prepareStatement(delSql)) {
//
//        pStatement1.setInt(3, 150);
//        pStatement1.setString(2, "Java Jazz");
//        pStatement1.setString(1, "ushm91736991");
//        int result1 = pStatement1.executeUpdate();
//        System.out.println(result1);
//
//        pStatement2.setString(1, "Java Jive");
//        pStatement2.setString(2, "Java Jazz");
//        int result2 = pStatement2.executeUpdate();
//        System.out.println(result2);
//
//        pStatement3.setInt(1, 200);
//        int result3 = pStatement3.executeUpdate();
//        System.out.println(result3);
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//  }
//}












}
