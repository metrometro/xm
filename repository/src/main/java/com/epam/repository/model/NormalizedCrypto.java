package com.epam.repository.model;

import com.epam.repository.type.CryptoType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "test2")
public class NormalizedCrypto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal max;
    private BigDecimal min;
    @Enumerated(EnumType.STRING)
    private CryptoType symbol;
}
