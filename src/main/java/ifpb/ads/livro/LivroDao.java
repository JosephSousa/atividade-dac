package ifpb.ads.livro;

import ifpb.ads.autor.Autor;
import java.util.List;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 19/06/2017 , 22:34:06
 */
public interface LivroDao {
    
    public boolean salvar(Livro livro);

    public boolean remover(Livro livro);

    public boolean atualizar(Livro livro);

    public List<Livro> todosOsLivros();
    
    public boolean adicionarAutores(List<Autor> autores,Livro livro);
}
