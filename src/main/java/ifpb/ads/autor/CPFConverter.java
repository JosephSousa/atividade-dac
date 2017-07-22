/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.autor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author joseph
 */
@FacesConverter("converter.CpfConverter")
public class CPFConverter implements Converter   {
    
    @Override
    public Object getAsObject(
            FacesContext context,
            UIComponent component,
            String value) {
        if (value == null) {
            return new CPF("");
        }
        return new CPF(value);
    }

    @Override
    public String getAsString(
            FacesContext context,
            UIComponent component,
            Object value) {
        if (value == null) {
            return "";
        }
        CPF cpf = (CPF) value;
        return cpf.getValor();
}
}