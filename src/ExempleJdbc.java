import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExempleJdbc {
    void loadDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }
    public Connection newConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost/dbessai";
        Connection conn = DriverManager.getConnection(url, "root", "");
        return conn;
    }
    public void ajouterDonnees(String cin ,String nom, String prenom, int age) {

        try {
            Connection conn = newConnection();
            // Remplacez "votre_table" par le nom de votre table dans la base de données
            String query = "INSERT INTO personne (cin,nom, prenom, age) VALUES (?,?, ?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, cin);
                preparedStatement.setString(2, nom);
                preparedStatement.setString(3, prenom);
                preparedStatement.setInt(4, age);

                preparedStatement.executeUpdate();
                System.out.println("Données ajoutées avec succès à la base de données.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(String cin,String nom, String prenom, int age){

    }

    public void listPersons() throws SQLException {
        Connection conn = null;
        List<Object[]> rowDataList = new ArrayList<>();
        try {
// create new connection and statement
            conn = newConnection();
            Statement st = conn.createStatement();
            String query = "SELECT cin, nom,prenom,age FROM personne ORDER BY age";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                int age = rs.getInt("age");

                // Ajouter les données de chaque ligne à la liste
                Object[] rowData = {nom, prenom, age};
                rowDataList.add(rowData);
            }
            Object[][] data = new Object[rowDataList.size()][];
            rowDataList.toArray(data);

            // Créer une instance de la classe Table en passant les données
            Table tableFrame = new Table(data);
        } finally {
// close result, statement and connection
            if (conn != null) conn.close();
        }
}

}
