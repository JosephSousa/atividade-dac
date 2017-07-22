package ifpb.ads.autor;

import ifpb.ads.infraestrutura.AutorJDBC;
import java.util.List;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 20/06/2017 , 19:39:38
 */
public class AutorService {

    private final AutorDao autor = new AutorJDBC();

    public void salvar(Autor autor) {
        this.autor.salvar(autor);
    }

    public void remover(Autor autor) {
        this.autor.remover(autor);
    }

    public void atualizar(Autor autor) {
        this.autor.atualizar(autor);
    }

    public List<Autor> todosOsAutores() {
        return this.autor.todosOsAutores();
    }
}
