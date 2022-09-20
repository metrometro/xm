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

    @Autowired
    private NormalizedCryptoEntityRepository repository;
    private final NormalizedCryptoMapper mapper;

    public NormalizedCryptoServiceImpl(NormalizedCryptoMapper mapper) {
        this.mapper = mapper;
    }

    public List<NormalizedCryptoDto> findNormalizedByMonth(String month) {
        return repository.findNormalizedByMonth(findCurrentNumberOfMonth(month)).stream().map(mapper::toDto)
                .peek(x -> x.setNormalizedRate((x.getMax().subtract(x.getMin())).divide(x.getMin(), 2, RoundingMode.HALF_UP)))
                .sorted(NormalizedCryptoDto::compareTo).collect(Collectors.toList());
    }

    public List<NormalizedCryptoDto> findNormalizedByMonthDay(String month, Integer day) {
        NormalizedCryptoDto normalizedCryptoDto =repository.findNormalizedByMonthDay(findCurrentNumberOfMonth(month), day).stream().map(mapper::toDto)
                .peek(x -> x.setNormalizedRate((x.getMax().subtract(x.getMin())).divide(x.getMin(), 2, RoundingMode.HALF_UP)))
                .max(NormalizedCryptoDto::compareTo).get();
        return Collections.singletonList(normalizedCryptoDto);
    }
}