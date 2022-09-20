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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long timestamp;
    private Date date;
    @Enumerated(EnumType.STRING)
    private CryptoType symbol;
    private BigDecimal price;
}
