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
public class UpdateData {
    public static void main(String[] args) {
        try {
            DBConnection connector = new DBConnection();
            connector.connectdb("localhost", 9042);

            final String updateQuery = "UPDATE lab4_keyspace.countries SET namerus= ? , namekaz =? WHERE "
                    + "id=? and code=?";

            PreparedStatement psUpdate = connector.getSession().prepare(updateQuery);
            BoundStatement bsUpdate = psUpdate.bind("Россия","Ресей", 2, "RU");
            connector.getSession().execute(bsUpdate);

            connector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
