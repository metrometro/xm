package com.epam.service.dto.modeldto;

import com.epam.repository.type.CryptoType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NormalizedCryptoDto implements Comparable<NormalizedCryptoDto> {

    private BigDecimal max;
    private BigDecimal min;
    private BigDecimal normalizedRate;
    private CryptoType symbol;

    @Override
    public int compareTo(NormalizedCryptoDto o) {
        return Double.compare(this.normalizedRate.doubleValue(), o.getNormalizedRate().doubleValue());
    }
}