package br.senac.principal;
import br.senac.model.Usuario;
import java.sql.SQLException;

public class tstUsuarioUpdate {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        usuario.setLogin("010porcher");
        usuario.setSenha("arthur2023");
        usuario.setCargo("Aluno");
        usuario.setNivelAcesso(1);
        usuario.setId(1);

        System.out.println("ATUALIZANDO USUÁRIO");
        usuario.atualizar();
    }
}
