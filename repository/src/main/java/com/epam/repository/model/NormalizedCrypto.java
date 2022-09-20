/**
 * Entity class with field <b>id</b> <b>max</b> <b>min</b> <b>symbol</b>
 * */

package com.epam.repository.model;

import com.epam.repository.type.CryptoType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "normalized")
public class NormalizedCrypto {

    /**Field id number*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**Field maximal price*/
    private BigDecimal max;
    /**Field minimal price*/
    private BigDecimal min;
    @Enumerated(EnumType.STRING)
    /**Field type of cryptocurrency*/
    private CryptoType symbol;
}
