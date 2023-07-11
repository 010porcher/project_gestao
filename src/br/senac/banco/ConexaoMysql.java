package br.senac.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {
    private String nomeServidor = "127.0.0.1";
    private String usuario = "root";
    private String senha = "Arthur2022";
    private String nomeBancoDados = "gestaodb";

    public Connection obterConexao() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://" + this.nomeServidor +":3306/" + this.nomeBancoDados;

        Connection connection = null;

        connection = DriverManager.getConnection(url, usuario, senha);
        return connection;
    }
}
