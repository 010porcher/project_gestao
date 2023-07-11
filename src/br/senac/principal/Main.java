package br.senac.principal;

import br.senac.banco.ConexaoMysql;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.printf("======== INSERINDO DADDOS NO BANCO ========");

        ConexaoMysql conexao = new ConexaoMysql();

        Connection conn = conexao.obterConexao();
        if (conn != null){
            System.out.println("CONECTADO");
        } else {
            System.out.println("NÃO CONECTADO");
        }
    }
}
