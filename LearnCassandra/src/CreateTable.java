/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class CreateTable {
     public static void main(String[] args) {
        try {
            DBConnection connector = new DBConnection();
            connector.connectdb("localhost", 9042);

            final String createmovieTable = "CREATE TABLE IF NOT EXISTS lab4_keyspace.countries"
                    + "(namekaz varchar,id int, code varchar, namerus varchar, PRIMARY KEY (id,code))";

            connector.getSession().execute(createmovieTable);
            
            connector.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
