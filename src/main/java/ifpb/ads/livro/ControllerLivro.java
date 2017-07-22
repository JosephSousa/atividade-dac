package ifpb.ads.livro;

import ifpb.ads.autor.Autor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 21/06/2017 , 22:18:32
 */
@Named
@SessionScoped
public class ControllerLivro implements Serializable{

    private Livro livro = new Livro();
    private final LivroService service = new LivroService();
    private List<Autor> autores = new ArrayList<>();
    private boolean editando = false;

    public String salvarLivro() {
        this.service.salvar(livro);
        this.livro = new Livro();
        return null;
    }
    
    public void addAutor(Autor autor){
        this.autores.add(autor);
    }
 
    public String removerLivro(Livro livroRemover) {
        this.service.remover(livroRemover);
        return null;
    }

    public String atualizar() {
        this.service.atualizar(livro);
        this.livro = new Livro();
        this.editando = false;
        return null;
    }

    public String editarLivro(Livro livroAtualizar) {
        this.livro = livroAtualizar;
        this.editando = true;
        return null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getTodosOsLivros() { 
        return this.service.todosOsLivros();
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
}
