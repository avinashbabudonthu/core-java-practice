package com.jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
public class Customers {

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    @XmlElement(name = "customer")
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
