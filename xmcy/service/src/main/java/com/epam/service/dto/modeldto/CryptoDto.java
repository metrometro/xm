package com.epam.service.dto.modeldto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CryptoDto {

    private Long id;
    @CsvBindByName(required = true)
    private Long timestamp;
    @CsvBindByName(required = true)
    private String symbol;
    @CsvBindByName(required = true)
    private BigDecimal price;
}