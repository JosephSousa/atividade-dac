package ifpb.ads.infraestrutura;

import ifpb.ads.autor.Autor;
import ifpb.ads.autor.AutorDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 19/06/2017 , 21:26:26
 */
public class AutorJDBC implements AutorDao{

    private final ConexaoBD conex = new ConexaoBD();

    private final Connection connection;

    public AutorJDBC() {
        connection = conex.getConnection();
    }

    @Override
    public boolean salvar(Autor autor) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT into autor(nome,cpf,email)VALUES (?,?,?)");
            prepareStatement.setString(1, autor.getNome());
            prepareStatement.setString(2, String.valueOf(autor.getCpf()));
            prepareStatement.setString(3, autor.getEmail());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Autor autor) {
           try {
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM autor WHERE id=?");
            prepareStatement.setInt(1, autor.getId());
            prepareStatement.execute();
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Autor autor) {
          try {
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE autor set nome=?, cpf=?,email=? WHERE id=?");
            prepareStatement.setString(1, autor.getNome());
            prepareStatement.setString(2, String.valueOf(autor.getCpf()));
            prepareStatement.setString(3, autor.getEmail());
            prepareStatement.setInt(4, autor.getId());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Autor> todosOsAutores() {
        try {
            List<Autor> autores = new ArrayList<>();

            ResultSet result = consultarTodosOsAutores();

            while (result.next()) {
               autores.add(criarAutor(result));
            }
            return autores;

        } catch (SQLException ex) {
            Logger.getLogger(AutorJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    private ResultSet consultarTodosOsAutores() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from autor");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }
    
    private Autor criarAutor(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String cpf=result.getString("cpf");
        String email=result.getString("email");
        return new Autor(id,nome,email,cpf);
    }
    
    
}
