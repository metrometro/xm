/**
 * Service class for NormalizedCryptoDto entity
 * @author Ryhor Pishchyk
 * */

package com.epam.service.servicedto.impl;

import com.epam.repository.jparepository.NormalizedCryptoEntityRepository;
import com.epam.service.dto.mapper.NormalizedCryptoMapper;
import com.epam.service.dto.modeldto.NormalizedCryptoDto;
import com.epam.service.servicedto.ServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static com.epam.service.util.MonthUtil.findCurrentNumberOfMonth;

@Service
@Transactional
public class NormalizedCryptoServiceImpl implements ServiceDto {

    /**Field NormalizedCryptoEntityRepository*/
    @Autowired
    private NormalizedCryptoEntityRepository repository;
    /**Field NormalizedCryptoMapper*/
    private final NormalizedCryptoMapper mapper;

    /**Constructor for creating object*/
    public NormalizedCryptoServiceImpl(NormalizedCryptoMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * Method to get descending sorted list of all the cryptos, comparing the normalized range
     * @param month - needed mont
     * @return list of objects
     * @see NormalizedCryptoEntityRepository#findNormalizedByMonth(Integer)
     * */
    public List<NormalizedCryptoDto> findNormalizedByMonth(String month) {
        return repository.findNormalizedByMonth(findCurrentNumberOfMonth(month)).stream().map(mapper::toDto)
                .peek(x -> x.setNormalizedRate((x.getMax().subtract(x.getMin())).divide(x.getMin(), 2, RoundingMode.HALF_UP)))
                .sorted(NormalizedCryptoDto::compareTo).collect(Collectors.toList());
    }

    /**
     * Method to get crypto with the highest normalized range for a specific day
     * @param month - needed mont
     * @param day - needed day
     * @return list of objects
     * @see NormalizedCryptoEntityRepository#findNormalizedByMonthDay(Integer, Integer)
     * */
    public List<NormalizedCryptoDto> findNormalizedByMonthDay(String month, Integer day) {
        NormalizedCryptoDto normalizedCryptoDto =repository.findNormalizedByMonthDay(findCurrentNumberOfMonth(month), day).stream().map(mapper::toDto)
                .peek(x -> x.setNormalizedRate((x.getMax().subtract(x.getMin())).divide(x.getMin(), 2, RoundingMode.HALF_UP)))
                .max(NormalizedCryptoDto::compareTo).get();
        return Collections.singletonList(normalizedCryptoDto);
    }
}