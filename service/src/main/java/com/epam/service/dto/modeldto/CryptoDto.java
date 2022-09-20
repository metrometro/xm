/**
 * EntityDto class with field <b>id</b> <b>timestamp</b> <b>symbol</b> <b>price</b>
 * @author Ryhor Pishchyk
 * */

package com.epam.service.dto.modeldto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CryptoDto {
    /**Field id number*/
    private Long id;
    @CsvBindByName(required = true)
    /**Field millisecond timestamp*/
    private Long timestamp;
    @CsvBindByName(required = true)
    /**Field type of cryptocurrency*/
    private String symbol;
    @CsvBindByName(required = true)
    /**Field price of cryptocurrency*/
    private BigDecimal price;
}