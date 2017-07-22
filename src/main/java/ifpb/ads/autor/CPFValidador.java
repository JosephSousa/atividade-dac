package ifpb.ads.autor;

import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Joseph Sousa
 * @mail Jsantos.te@gmail.com
 * @since 19/06/2017 , 21:31:32
 */
@FacesValidator("validador.CPFValidador")
public class CPFValidador implements Validator {

    @Override
    public void validate(
            FacesContext context, 
            UIComponent component, 
            Object value) throws ValidatorException {


        CPF cpf = (CPF) value;
        
        if(!cpf.isValid()){
            FacesMessage message = new FacesMessage("CPF inválido. Tamanho incorreto!");
            FacesMessage message2 = new FacesMessage("CPF inválido. Valor incorreto");
            List<FacesMessage> list = Arrays.asList(message,message2);
            throw  new ValidatorException(list);
        }
     
    }
}
