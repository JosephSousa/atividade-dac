package ifpb.ads.infraestrutura;

import ifpb.ads.autor.Autor;
import ifpb.ads.livro.Livro;
import ifpb.ads.livro.LivroDao;
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
 * @since 19/06/2017 , 22:35:37
 */
public class LivroJDBC implements LivroDao{

    private final ConexaoBD conex = new ConexaoBD();

    private final Connection connection;

    public LivroJDBC() {
        connection = conex.getConnection();
    }

    @Override
    public boolean salvar(Livro livro) {
         try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT into livro(descricao,edicao,isbn)VALUES (?,?,?)");
            prepareStatement.setString(1, livro.getDescricao());
            prepareStatement.setString(2, livro.getEdicao());
            prepareStatement.setString(3, livro.getISBN());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Livro livro) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM livro WHERE id=?");
            prepareStatement.setInt(1, livro.getId());
            prepareStatement.execute();
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Livro livro) {
         try {
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE livro set descricao=?, edicao=?,isbn=? WHERE id=?");
           prepareStatement.setString(1, livro.getDescricao());
            prepareStatement.setString(2, livro.getEdicao());
            prepareStatement.setString(3, livro.getISBN());
            prepareStatement.setInt(4, livro.getId());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Livro> todosOsLivros() {
        try {
            List<Livro> livros = new ArrayList<>();

            ResultSet result = consultarTodosOsLivros();

            while (result.next()) {
               livros.add(criarLivro(result));
            }
            return livros;

        } catch (SQLException ex) {
            Logger.getLogger(AutorJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }
    
    private ResultSet consultarTodosOsLivros() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from livro");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }
    
    private Livro criarLivro(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String descricao = result.getString("descricao");
        String edicao=result.getString("edicao");
        String isbn=result.getString("isbn");
        return new Livro(id, descricao, isbn, edicao);
    }

    @Override
    public boolean adicionarAutores(List<Autor> autores,Livro livro) {
        for (Autor autor : autores) {
            try {
                PreparedStatement prepareStatement = connection.prepareStatement("INSERT into autorlivro(cpfautor,isbnlivro)VALUES (?,?)");
                prepareStatement.setString(1, String.valueOf(autor.getCpf()));
                prepareStatement.setString(3, livro.getISBN());
                return prepareStatement.executeUpdate() > 0;
            } catch (SQLException ex) {
                Logger.getLogger(LivroJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
}
