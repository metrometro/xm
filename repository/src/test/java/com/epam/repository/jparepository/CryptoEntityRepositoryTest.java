package com.epam.repository.jparepository;

import com.epam.repository.model.Crypto;
import junit.framework.TestCase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
public class CryptoEntityRepositoryTest extends TestCase {

    @Autowired
    private CryptoEntityRepository repository;

    public void testFindOldestByMonth() {
        Crypto crypto = new Crypto();
        crypto.setPrice(BigDecimal.valueOf(38415.79));
        List<Crypto> actual = repository.findOldestByMonth(1);
        Assert.assertEquals(crypto.getPrice(), actual.get(0).getPrice());
    }

    public void testFindNewestByMonth() {
        Crypto crypto = new Crypto();
        crypto.setPrice(BigDecimal.valueOf(46813.21));
        List<Crypto> actual = repository.findNewestByMonth(1);
        Assert.assertEquals(crypto.getPrice(), actual.get(0).getPrice());
    }

    public void testFindMaxByMonth() {
        Crypto crypto = new Crypto();
        crypto.setPrice(BigDecimal.valueOf(33276.59));
        List<Crypto> actual = repository.findMaxByMonth(1);
        Assert.assertEquals(crypto.getPrice(), actual.get(0).getPrice());
    }

    public void testFindMinByMonth() {
        Crypto crypto = new Crypto();
        crypto.setPrice(BigDecimal.valueOf(47722.66));
        List<Crypto> actual = repository.findMinByMonth(1);
        Assert.assertEquals(crypto.getPrice(), actual.get(0).getPrice());
    }

    public void testFindOldestByMonthSymbol() {
        Crypto crypto = new Crypto();
        crypto.setPrice(BigDecimal.valueOf(38415.79));
        List<Crypto> actual = repository.findOldestByMonthSymbol(1, "BTC");
        Assert.assertEquals(crypto.getPrice(), actual.get(0).getPrice());
    }

    public void testFindNewestByMonthSymbol() {
        Crypto crypto = new Crypto();
        crypto.setPrice(BigDecimal.valueOf(46813.21));
        List<Crypto> actual = repository.findNewestByMonthSymbol(1, "BTC");
        Assert.assertEquals(crypto.getPrice(), actual.get(0).getPrice());
    }

    public void testFindMaxByMonthSymbol() {
        Crypto crypto = new Crypto();
        crypto.setPrice(BigDecimal.valueOf(33276.59));
        List<Crypto> actual = repository.findMaxByMonthSymbol(1, "BTC");
        Assert.assertEquals(crypto.getPrice(), actual.get(0).getPrice());
    }

    public void testFindMinByMonthSymbol() {
        Crypto crypto = new Crypto();
        crypto.setPrice(BigDecimal.valueOf(47722.66));
        List<Crypto> actual = repository.findMinByMonthSymbol(1, "BTC");
        Assert.assertEquals(crypto.getPrice(), actual.get(0).getPrice());
    }
}