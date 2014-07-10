package com.sai.java.jaxb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
 
public class JavaToXML {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Product.class);
 
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
        Product object = new Product();
        object.setCode("WI1");
        object.setName("Widget Number One");
        object.setPrice(BigDecimal.valueOf(300.00));
        List<Property> lst = new ArrayList<>();
        lst.add(new Property("double", "height", "20.0"));
        lst.add(new Property("integer", "width", "40.0"));
        lst.add(new Property("string", "name", "book"));
        
        object.setProperties(lst);
        
        m.marshal(object, System.out);
    }
}