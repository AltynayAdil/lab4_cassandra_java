import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class SearchData {
    public static void main(String[] args) {
        try {
            DBConnection connector = new DBConnection();
            connector.connectdb("localhost", 9042);

            final String selectQuery = "SELECT * FROM lab4_keyspace.countries WHERE id=? ";

            PreparedStatement psSelect = connector.getSession().prepare(selectQuery);
            BoundStatement bsSelect = psSelect.bind(3);
            ResultSet rs = connector.getSession().execute(bsSelect);

            rs.forEach(rr -> {
                System.out.println("Код страны : " + rr.getString("code"));
                System.out.println("Наименование страны на русском : " + rr.getString("namerus"));
                System.out.println("Наименование страны на казахском : " + rr.getString("namekaz"));
            });

            connector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
