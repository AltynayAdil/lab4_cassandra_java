import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class InsertData {
    public static void main(String[] args) {
        try {
            DBConnection connector = new DBConnection();
            connector.connectdb("localhost", 9042);

            final String insertQuery = "INSERT INTO lab4_keyspace.countries (namekaz,id,code,namerus) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement psInsert = connector.getSession().prepare(insertQuery);
            BoundStatement bsInsert = psInsert.bind("Қытай", 3, "СH", "Китай");
            connector.getSession().execute(bsInsert);

            connector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
