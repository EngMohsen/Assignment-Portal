package com.segula.portal.data.entity;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "interest")
public class Interest {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}