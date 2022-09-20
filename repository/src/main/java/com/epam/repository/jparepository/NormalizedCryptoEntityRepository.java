/**
 * Interface  to make query of NormalizedCrypto.class type
 * @author Ryhor Pishchyk
 * */

package com.epam.repository.jparepository;

import com.epam.repository.model.NormalizedCrypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NormalizedCryptoEntityRepository extends JpaRepository<NormalizedCrypto, Long> {

    /**
     * Method realized query to get descending sorted list of all the cryptos, comparing the normalized range
     * @param month - needed mont
     * @return list of objects
     * */
    @Query(value = "select count(id) id, min(price), max(price), symbol from crypto WHERE EXTRACT(MONTH FROM date) = ?1 group by symbol", nativeQuery = true)
    List<NormalizedCrypto> findNormalizedByMonth(Integer month);

    /**
     * Method realized query to get crypto with the highest normalized range for a specific day
     * @param month - needed mont
     * @param day - needed day
     * @return list of objects
     * */
    @Query(value = "select count(id) id, min(price), max(price), symbol from crypto WHERE EXTRACT(MONTH FROM date) = ?1 and EXTRACT(Day FROM date) = ?2 group by symbol", nativeQuery = true)
    List<NormalizedCrypto> findNormalizedByMonthDay(Integer month, Integer day);
}