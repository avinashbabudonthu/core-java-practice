package com.marshall;

import com.jaxb.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

@Slf4j
public class Marshalling {

    /**
     * Convert Customer object to customer-1.xml
     */
    @Test
    public void customerObjectToXml(){
        Customer customer = new Customer();
        customer.setName("jack");
        customer.setAge(21);
        customer.setId(100);

        try{
            File file = new File("C:\\Java-Prep\\practice-projects\\core-java-practice\\jaxb\\files\\customer-1.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // marshall to xml file
            jaxbMarshaller.marshal(customer, file);

            // marshall to console
            jaxbMarshaller.marshal(customer, System.out);
        }catch (JAXBException e){
            log.error("Exception while marshalling custom object", e);
        }
    }
}
