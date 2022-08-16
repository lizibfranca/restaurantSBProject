package com.example.demo.adress;

import com.example.demo.city.City;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable//pode ser entidade
public class Adress {

    private String zipCode;
    private String street;
    private String number;
    private String addressComplement;
    private  String neighborhood;
    @OneToOne
    private City city;
}
