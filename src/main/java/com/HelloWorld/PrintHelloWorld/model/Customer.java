package com.HelloWorld.PrintHelloWorld.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    //@Column(name="Customer ID")
    private int customerId;
    @JsonProperty("firstName")
   // @Column(name="Customer First Name")
    private String custFirstName;
    @JsonProperty("lastName")
    //@Column(name="Customer Last Name")
    private String custLastName;
    @JsonProperty("email")
   // @Column(name="Customer Email Address")
    private String custEmail;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
}
