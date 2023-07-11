package br.senac.model;

import br.senac.banco.ConexaoMysql;

import java.sql.*;
import java.util.ArrayList;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String cargo;
    private int nivelAcesso;

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void salvar() throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement start = null;

        try {
            start = con.prepareStatement("INSERT INTO usuario (login, senha, cargo, nivel_acesso) VALUES (?, ?, ?, ?)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        start.setString(1, this.login);
        start.setString(2, this.senha);
        start.setString(3, this.cargo);
        start.setInt(4, this.nivelAcesso);

        start.executeUpdate();
    }

    public void atualizar() throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement start = null;

        start = con.prepareStatement("UPDATE usuario SET login = ?, senha = ?, cargo = ?, nivel_acesso = ? WHERE id = ?");
        start.setString(1, login);
        start.setString(2, senha);
        start.setString(3, cargo);
        start.setInt(4, nivelAcesso);
        start.setInt(5, id);

        start.executeUpdate();
    }

    public void deletar(int id) throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public ArrayList<Usuario> obterTodosUsuarios() throws SQLException, ClassNotFoundException {
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        Connection con = conexaoMysql.obterConexao();
        PreparedStatement stmt = null;

        stmt = con.prepareStatement("SELECT id, login, senha, cargo, nivel_acesso FROM usuario");
        ResultSet rs = stmt.executeQuery();

        ArrayList<Usuario> usuarioslist = new ArrayList<>();

        while (rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setCargo(rs.getString("cargo"));
            usuario.setNivelAcesso((rs.getInt("nivel_acesso")));

            usuarioslist.add((usuario));
        }
        return usuarioslist;
    }
}