package ifpb.ads.livro;

import ifpb.ads.infraestrutura.LivroJDBC;
import java.util.List;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 21/06/2017 , 22:18:17
 */
public class LivroService {
    private final LivroDao autor = new LivroJDBC();

    public void salvar(Livro livro) {
        this.autor.salvar(livro);
    }

    public void remover(Livro livro) {
        this.autor.remover(livro);
    }

    public void atualizar(Livro livro) {
        this.autor.atualizar(livro);
    }

    public List<Livro> todosOsLivros() {
        return this.autor.todosOsLivros();
    }
}
