package com.sai.java.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
 
public class XMLToJava {
 
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Product.class);
            Unmarshaller u = jc.createUnmarshaller();
 
            File f = new File("src\\com\\sai\\java\\jaxb\\product.xml");
            Product product = (Product) u.unmarshal(f);
 
            System.out.println(product.getCode());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getProperties().size());
            for (Property prop : product.getProperties()) {
            	System.out.println(prop.getName()+" : "+prop.getType()+" : "+prop.getValue());
			}
            
         } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}