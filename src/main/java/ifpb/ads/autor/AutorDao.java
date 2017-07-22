package ifpb.ads.autor;

import java.util.List;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 19/06/2017 , 22:02:20
 */
public interface AutorDao {
     public boolean salvar(Autor autor);

    public boolean remover(Autor autor);

    public boolean atualizar(Autor autor);

    public List<Autor> todosOsAutores();
}
