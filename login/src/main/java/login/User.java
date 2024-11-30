package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** 
 * Essa classe contém métodos para conectar com o banco de dados e verificar a existência de um usuário. 
 * @author Rafael Lourenço Ribeiro Francisco, RA 223646
 * @version 1.0 
*/
public class User {
    /**
     * Conecta com o banco de dados utilizando connection string padrão. Não retorna exceções.
     * @return uma conexão com o banco de dados, com tipo java.sql.Connection, ou null quando caso não seja possível completar a conexão
     */
    public Connection conectarDB(){
        Connection conn = null;

        try{
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "fdbc:mysql://127.0.0.1/test?=user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch(Exception e) { }

        return conn;
    }

    /**
     * Nome do usuário encontrado no banco de dados, "" quando não encontrado.
     */
    public String nome = "";

    /**
     * true quando a consulta no banco de dados encontra um usuário compatível, false quando não encontrado ou não pesquisado.
     */
    public boolean result = false;


    /**
     * Verifica se o login e senha informados são compatíveis com algum usuário no banco de dados.
     * @param login
     * @param senha
     * @return boolean, true para usuário encontrado, false para não encontrado ou falha na pesquisa. 
     */
    public boolean verificarUsuario(String login, String senha){
        String sql = "";
        Connection conn = conectarDB();
        // INSTRUÇÃO SQL
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) { }
        return result;
    }
}
