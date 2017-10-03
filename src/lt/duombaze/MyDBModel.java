package lt.duombaze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDBModel {
    public static final String DB_HOST_NAME = "jdbc:mysql://localhost:3306/praktika";
    public static final String DB_USER_NAME = "root";
    public static final String DB_PASSWORD = "";

    private Connection _connection;

    public MyDBModel() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            _connection = DriverManager.getConnection(DB_HOST_NAME, DB_USER_NAME, DB_PASSWORD);
        } catch (Exception klaida) {
            System.out.println("Sum ting wong " + klaida.getMessage());
        }
    }

    public void simplePrint(String uzklausa) {
        try {
            // is connection pasiruosti statement
            System.out.println("===============================================");
            System.out.println(uzklausa);
            System.out.println("===============================================");

            Statement statement = _connection.createStatement();

            // statement ivykdyti ir pasiimti rezultatus
            ResultSet resultSet = statement.executeQuery(uzklausa);
            // suzinoti kiek lenteleje yra stulpeliu
            int columnCount = resultSet.getMetaData().getColumnCount();
            // pereiti per visas eilutes
            while (resultSet.next()) {
                // kiekvienos eilutes stulpelius atspausdinti
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i));
                    System.out.print("\t\t");
                }
                System.out.print("\n");
            }
            System.out.println("_______________________________________________");
        } catch (Exception klaida) {
            System.out.println(klaida.getMessage());
        }

    }
    public void simpleExecute(String uzklausa){
        try {
            Statement statement = _connection.createStatement();
            statement.execute(uzklausa);
        }catch (Exception klaida){
            System.out.println(klaida.getMessage());
        }
    }

}
