/**
 * Entity class with field <b>id</b> <b>timestamp</b> <b>date</b> <b>symbol</b> <b>price</b>
 * @author Ryhor Pishchyk
 * */

package com.epam.repository.model;

import com.epam.repository.type.CryptoType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@Table(name = "crypto")
public class Crypto {

    /**Field id number*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**Field timestamp in millisecond*/
    private Long timestamp;
    /**Field date*/
    private Date date;
    /**Field type of cryptocurrency*/
    @Enumerated(EnumType.STRING)
    private CryptoType symbol;
    /**Field price of cryptocurrency*/
    private BigDecimal price;
}
