package ifpb.ads.autor;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 20/06/2017 , 19:43:11
 */
@Named
@SessionScoped
public class ControllerAutor implements Serializable{
    
    private Autor autor = new Autor();
    private final AutorService service = new AutorService();

    private boolean editando = false;

    public String salvarAutor() {
        this.service.salvar(autor);
        this.autor = new Autor();
        return null;
    }

 
    public String removerAutor(Autor autorRemover) {
        this.service.remover(autorRemover);
        return null;
    }

    public String atualizar() {
        this.service.atualizar(autor);
        this.autor = new Autor();
        this.editando = false;
        return null;
    }

    public String editarAutor(Autor autorAtualizar) {
        this.autor = autorAtualizar;
        this.editando = true;
        return null;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Autor> getTodosOsAutores() { 
        return this.service.todosOsAutores();
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
}
