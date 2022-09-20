package com.epam.repository.jparepository;

import com.epam.repository.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CryptoEntityRepository extends JpaRepository<Crypto, Long> {

    @Query(value = "select t1.id, t1.price, t1.date, t1.timestamp, t1.symbol from crypto t1 left join crypto t2 on t1.symbol = t2.symbol AND t1.timestamp < t2.timestamp and EXTRACT(MONTH FROM t1.date) = ?1 where t2.timestamp is null", nativeQuery = true)
    List<Crypto> findOldestByMonth(Integer month);

    @Query(value = "select t1.id, t1.price, t1.date, t1.timestamp, t1.symbol from crypto t1 left join crypto t2 on t1.symbol = t2.symbol AND t1.timestamp > t2.timestamp where t2.timestamp is null and EXTRACT(MONTH FROM t1.date) = ?1", nativeQuery = true)
    List<Crypto> findNewestByMonth(Integer month);

    @Query(value = "select t1.id, t1.price, t1.date, t1.timestamp, t1.symbol from crypto t1 left join crypto t2 on t1.symbol = t2.symbol AND t1.price < t2.price where t2.price is null and EXTRACT(MONTH FROM t1.date) = ?1", nativeQuery = true)
    List<Crypto> findMaxByMonth(Integer month);

    @Query(value = "select t1.id, t1.price, t1.date, t1.timestamp, t1.symbol from crypto t1 left join crypto t2 on t1.symbol = t2.symbol AND t1.price > t2.price where t2.price is null and EXTRACT(MONTH FROM t1.date) = ?1", nativeQuery = true)
    List<Crypto> findMinByMonth(Integer month);

    @Query(value = "select t1.id, t1.price, t1.date, t1.timestamp, t1.symbol from crypto t1 left join crypto t2 on t1.symbol = t2.symbol AND t1.timestamp < t2.timestamp and EXTRACT(MONTH FROM t1.date) = ?1 where t2.timestamp is null and t1.symbol = ?2", nativeQuery = true)
    List<Crypto> findOldestByMonthSymbol(Integer month, String symbol);

    @Query(value = "select t1.id, t1.price, t1.date, t1.timestamp, t1.symbol from crypto t1 left join crypto t2 on t1.symbol = t2.symbol AND t1.timestamp > t2.timestamp where t2.timestamp is null and EXTRACT(MONTH FROM t1.date) = ?1 and t1.symbol = ?2", nativeQuery = true)
    List<Crypto> findNewestByMonthSymbol(Integer month, String symbol);

    @Query(value = "select t1.id, t1.price, t1.date, t1.timestamp, t1.symbol from crypto t1 left join crypto t2 on t1.symbol = t2.symbol AND t1.price < t2.price where t2.price is null and EXTRACT(MONTH FROM t1.date) = ?1 and t1.symbol = ?2", nativeQuery = true)
    List<Crypto> findMaxByMonthSymbol(Integer month, String symbol);

    @Query(value = "select t1.id, t1.price, t1.date, t1.timestamp, t1.symbol from crypto t1 left join crypto t2 on t1.symbol = t2.symbol AND t1.price > t2.price where t2.price is null and EXTRACT(MONTH FROM t1.date) = ?1 and t1.symbol = ?2", nativeQuery = true)
    List<Crypto> findMinByMonthSymbol(Integer month, String symbol);
}