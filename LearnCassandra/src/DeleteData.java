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
public class DeleteData {
     public static void main(String[] args) {
        try {
            DBConnection connector = new DBConnection();
            connector.connectdb("localhost", 9042);

            final String deleteQuery = "Delete FROM lab4_keyspace.countries WHERE id=? AND code= ?";

            PreparedStatement psDelete = connector.getSession().prepare(deleteQuery);
            BoundStatement bsDelete = psDelete.bind(1, "KZ");
            connector.getSession().execute(bsDelete);

            connector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
