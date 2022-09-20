package com.epam.repository.jparepository;

import com.epam.repository.model.NormalizedCrypto;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@DataJpaTest
class NormalizedCryptoEntityRepositoryTest {

    @Autowired
    private NormalizedCryptoEntityRepository repository;

    @Test
    void testGivenRepository_whenFindByMonth_therReturnNormalizedList() {
        NormalizedCrypto normalizedCrypto = new NormalizedCrypto();
        normalizedCrypto.setMax(BigDecimal.valueOf(32276.69));
        List<NormalizedCrypto> expected = Collections.singletonList(normalizedCrypto);
        List<NormalizedCrypto> actual = repository.findNormalizedByMonth(1);
        Assertions.assertEquals(expected.get(0).getMax(), actual.get(0).getMax());
    }

    @Test
    void testGivenRepository_whenFindByMonthDay_therReturnNormalizedList() {
        NormalizedCrypto normalizedCrypto = new NormalizedCrypto();
        normalizedCrypto.setMax(BigDecimal.valueOf(47722.66));
        List<NormalizedCrypto> expected = Collections.singletonList(normalizedCrypto);
        List<NormalizedCrypto> actual = repository.findNormalizedByMonthDay(1, 1);
        Assertions.assertEquals(expected.get(0).getMax(), actual.get(0).getMax());
    }
}