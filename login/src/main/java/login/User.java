package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public Connection conectarDB(){
        Connection conn = null;                                                     //1

        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();                //1
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";    //1
            conn = DriverManager.getConnection(url);                                //1
        } catch(Exception e) { }                                                    //2

        return conn;                                                                //3
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha){
        String sql = "";                                                            //4
        Connection conn = conectarDB();                                             //4
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";                                        //5
        sql += "where login = " + "'" + login + "'";                                //5
        sql += " and senha = " + "'" + senha + "';";                                //5
        try{
            Statement st = conn.createStatement();                                  //5
            ResultSet rs = st.executeQuery(sql);                                    //5
            if (rs.next()){                                                         //6
                result = true;                                                      //7
                nome = rs.getString("nome");                                        //7
            }
        } catch (Exception e) { }                                                   //8
        return result;                                                              //9
    }
}
