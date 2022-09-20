package com.epam.controller;

import com.epam.repository.type.CryptoType;
import com.epam.service.dto.modeldto.NormalizedCryptoDto;
import com.epam.service.servicedto.impl.NormalizedCryptoServiceImpl;
import junit.framework.TestCase;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class NormalizedCryptoControllerTest extends TestCase {

    private final NormalizedCryptoServiceImpl service = mock(NormalizedCryptoServiceImpl.class);
    private final NormalizedCryptoController controller;

    {
        controller = new NormalizedCryptoController(service);
    }

    public void testGivenController_whenFindByMonth_thenReturnResponceEntiteOk() {
        NormalizedCryptoDto normalizedCryptoDto = new NormalizedCryptoDto();
        normalizedCryptoDto.setMax(BigDecimal.valueOf(10));
        normalizedCryptoDto.setMin(BigDecimal.valueOf(5));
        normalizedCryptoDto.setNormalizedRate(BigDecimal.valueOf(1));
        normalizedCryptoDto.setSymbol(CryptoType.BTC);
        List<NormalizedCryptoDto> expectedDto = Collections.singletonList(normalizedCryptoDto);
        when(service.findNormalizedByMonth("January")).thenReturn(expectedDto);
        ResponseEntity<List<NormalizedCryptoDto>> actual = controller.findNormalizedByMonth("January");
        assertEquals(actual.getBody(), expectedDto);

    }

    public void testGivenController_whenFindByMonthDay_thenReturnResponceEntiteOk() {
        NormalizedCryptoDto normalizedCryptoDto = new NormalizedCryptoDto();
        normalizedCryptoDto.setMax(BigDecimal.valueOf(10));
        normalizedCryptoDto.setMin(BigDecimal.valueOf(5));
        normalizedCryptoDto.setNormalizedRate(BigDecimal.valueOf(1));
        normalizedCryptoDto.setSymbol(CryptoType.BTC);
        List<NormalizedCryptoDto> expectedDto = Collections.singletonList(normalizedCryptoDto);
        when(service.findNormalizedByMonthDay("January", 1)).thenReturn(expectedDto);
        ResponseEntity<Object> actual = controller.findNormalizedByMonthAndDay("January", 1);
        assertEquals(actual.getBody(), expectedDto);
    }
}