package com.set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee implements  Comparable{
    private String name;
    private String designation;

    @Override
    public int hashCode(){
        return name.hashCode() + designation.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Employee){
            Employee that = (Employee) obj;
            return this.name.equals(that.getName()) && this.designation.equals(that.getDesignation());
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof  Employee){
            Employee that = (Employee) o;
            return  this.getDesignation().compareTo(that.getDesignation());
        }
        return 0;
    }
}
