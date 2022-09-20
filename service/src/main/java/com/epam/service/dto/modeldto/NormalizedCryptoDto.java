/**
 * EntityDto class with field <b>max</b> <b>min</b> <b>normalizedRate</b> <b>symbol</b>
 * @author Ryhor Pishchyk
 * */

package com.epam.service.dto.modeldto;

import com.epam.repository.type.CryptoType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NormalizedCryptoDto implements Comparable<NormalizedCryptoDto> {

    /**Field maximal price*/
    private BigDecimal max;
    /**Field minimal price*/
    private BigDecimal min;
    /**Field normalizer rate*/
    private BigDecimal normalizedRate;
    /**Field type of cryptocurrency*/
    private CryptoType symbol;

    @Override
    public int compareTo(NormalizedCryptoDto o) {
        return Double.compare(this.normalizedRate.doubleValue(), o.getNormalizedRate().doubleValue());
    }
}