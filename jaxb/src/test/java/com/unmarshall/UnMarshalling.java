package com.unmarshall;

import com.jaxb.model.Customer;
import com.jaxb.model.Customers;
import com.marshall.Marshalling;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Slf4j
public class UnMarshalling {

    /**
     * Create customer object from xml
     * Execute @see{{@link Marshalling#customerObjectToXml()}} to generate xml
     */
    @Test
    public void customerXmlToCustomObject(){
        try{
            File file = new File("C:\\Java-Prep\\practice-projects\\core-java-practice\\jaxb\\files\\customer-1.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);

            log.info("customer name={}, age={}, id={}", customer.getName(), customer.getAge(), customer.getId());
        }catch(JAXBException e){
          log.error("Exception while unmarshelling custom xml file", e);
        }
    }

    @Test
    public void convertCustomersXmlToListOfCustomers(){
        try{
            File file = new File("C:\\Java-Prep\\practice-projects\\core-java-practice\\jaxb\\files\\customers-1.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Customers customers = (Customers) unmarshaller.unmarshal(file);

            log.info("customers={}, number of customers={}", customers, customers.getCustomers().size());
            customers.getCustomers().stream().forEach(customer -> {
                log.info("name={}, age={}, id={}", customer.getName(), customer.getAge(), customer.getId());
            });
        }catch (JAXBException e){
            log.error("Exception while unmarshalling customers xml", e);
        }
    }
}
