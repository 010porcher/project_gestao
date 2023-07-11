package br.senac.principal;

import br.senac.model.Usuario;

import java.sql.SQLException;

public class tstUsuarioDelete {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        usuario.deletar(1);
        System.out.println("USUARIO DELETADO");
    }
}
