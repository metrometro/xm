package com.epam.service.servicedto.impl;

import com.epam.repository.jparepository.NormalizedCryptoEntityRepository;
import com.epam.repository.model.NormalizedCrypto;
import com.epam.repository.type.CryptoType;
import com.epam.service.dto.mapper.NormalizedCryptoMapper;
import com.epam.service.dto.modeldto.NormalizedCryptoDto;
import junit.framework.TestCase;
import org.modelmapper.ModelMapper;
import org.powermock.reflect.Whitebox;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@EnableJpaRepositories
public class NormalizedCryptoServiceImplTest extends TestCase {

    private final NormalizedCryptoEntityRepository repository = mock(NormalizedCryptoEntityRepository.class);
    private final NormalizedCryptoMapper mapper;
    private final NormalizedCryptoServiceImpl service;

    {
        mapper = new NormalizedCryptoMapper(new ModelMapper());
        service = new NormalizedCryptoServiceImpl(mapper);

        Whitebox.setInternalState(service, "repository", repository);
    }

    public void testGivenNormalizedRate_WhenSearchByMonth_ThenReturnNormalizedList() {
        NormalizedCryptoDto normalizedCryptoDto = new NormalizedCryptoDto();
        normalizedCryptoDto.setMax(BigDecimal.valueOf(10));
        normalizedCryptoDto.setMin(BigDecimal.valueOf(5));
        normalizedCryptoDto.setNormalizedRate(BigDecimal.valueOf(1));
        normalizedCryptoDto.setSymbol(CryptoType.BTC);
        List<NormalizedCryptoDto> expectedDto = Collections.singletonList(normalizedCryptoDto);

        NormalizedCrypto normalizedCrypto = new NormalizedCrypto();
        normalizedCrypto.setMax(BigDecimal.valueOf(10));
        normalizedCrypto.setMin(BigDecimal.valueOf(5));
        normalizedCrypto.setSymbol(CryptoType.BTC);
        List<NormalizedCrypto> expected = Collections.singletonList(normalizedCrypto);

        when(repository.findNormalizedByMonth(Integer.valueOf("1"))).thenReturn(expected);
        List<NormalizedCryptoDto> actualDto = service.findNormalizedByMonth("January");

        assertEquals(expected.get(0).getMax(), actualDto.get(0).getMax());
    }

    public void testGivenNormalizedRate_WhenSearchByMonthAndDat_ThenReturnNormalizedList() {
        NormalizedCryptoDto normalizedCryptoDto = new NormalizedCryptoDto();
        normalizedCryptoDto.setMax(BigDecimal.valueOf(10));
        normalizedCryptoDto.setMin(BigDecimal.valueOf(5));
        normalizedCryptoDto.setNormalizedRate(BigDecimal.valueOf(1));
        normalizedCryptoDto.setSymbol(CryptoType.BTC);
        List<NormalizedCryptoDto> expectedDto = Collections.singletonList(normalizedCryptoDto);

        NormalizedCrypto normalizedCrypto = new NormalizedCrypto();
        normalizedCrypto.setMax(BigDecimal.valueOf(10));
        normalizedCrypto.setMin(BigDecimal.valueOf(5));
        normalizedCrypto.setSymbol(CryptoType.BTC);
        List<NormalizedCrypto> expected = Collections.singletonList(normalizedCrypto);

        when(repository.findNormalizedByMonthDay(Integer.valueOf("1"), 1)).thenReturn(expected);
        List<NormalizedCryptoDto> actualDto = service.findNormalizedByMonthDay("January", 1);

        assertEquals(expected.get(0).getMax(), actualDto.get(0).getMax());
    }
}