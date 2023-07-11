package br.senac.principal;

import br.senac.model.Usuario;

import java.sql.SQLException;

public class tstUsuarioInsert {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        usuario.setLogin("10porcher");
        usuario.setSenha("arthur2023");
        usuario.setCargo("Aluno");
        usuario.setNivelAcesso(1);

        System.out.println("INSERINDO USUÁRIO");
        try {
            usuario.salvar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}