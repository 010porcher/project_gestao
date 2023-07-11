package br.senac.principal;

import br.senac.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class tstTesteObter {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        ArrayList<Usuario> lista = usuario.obterTodosUsuarios();

        for(Usuario u : lista){
            System.out.println("--------------------------------");
            System.out.println("ID: " +u.getId());
            System.out.println("Login: " +u.getLogin());
            System.out.println("Senha: " +u.getSenha());
            System.out.println("Cargo: " +u.getCargo());
            System.out.println("Nivel de Acesso: " +u.getNivelAcesso());
            System.out.println("--------------------------------");
        }
    }
}
