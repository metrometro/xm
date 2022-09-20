package com.epam.repository.jparepository;

import com.epam.repository.model.NormalizedCrypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NormalizedCryptoEntityRepository extends JpaRepository<NormalizedCrypto, Long> {

    @Query(value = "select count(id) id, min(price), max(price), symbol from crypto WHERE EXTRACT(MONTH FROM date) = ?1 group by symbol", nativeQuery = true)
    List<NormalizedCrypto> findNormalizedByMonth(Integer month);

    @Query(value = "select count(id) id, min(price), max(price), symbol from crypto WHERE EXTRACT(MONTH FROM date) = ?1 and EXTRACT(Day FROM date) = ?2 group by symbol", nativeQuery = true)
    List<NormalizedCrypto> findNormalizedByMonthDay(Integer month, Integer day);
}