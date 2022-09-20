package com.epam.controller;

import com.epam.service.dto.modeldto.CryptoDto;
import com.epam.service.servicedto.impl.CryptoServiceImpl;
import junit.framework.TestCase;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class CryptoControllerTest extends TestCase {

    private CryptoServiceImpl service = mock(CryptoServiceImpl.class);
    private CryptoController controller;

    {
        controller = new CryptoController(service);
    }

    public void testGivenController_whenFindOldestByMonth_thenReturnResponseOk() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> expected = Collections.singletonList(cryptoDto);
        when(service.findOldestByMonth("January")).thenReturn(expected);
        ResponseEntity<List<CryptoDto>> actual = controller.findOldestByMonth("January");
        assertEquals(actual.getBody(), expected);
    }

    public void testGivenController_whenFindNewestByMonth_thenReturnResponseOk() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> expected = Collections.singletonList(cryptoDto);
        when(service.findNewestByMonth("January")).thenReturn(expected);
        ResponseEntity<List<CryptoDto>> actual = controller.findNewestByMonth("January");
        assertEquals(actual.getBody(), expected);
    }

    public void testGivenController_whenFindMinByMonth_thenReturnResponseOk() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> expected = Collections.singletonList(cryptoDto);
        when(service.findMinByMonth("January")).thenReturn(expected);
        ResponseEntity<List<CryptoDto>> actual = controller.findMinByMonth("January");
        assertEquals(actual.getBody(), expected);
    }

    public void testGivenController_whenFindMaxByMonth_thenReturnResponseOk() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> expected = Collections.singletonList(cryptoDto);
        when(service.findMaxByMonth("January")).thenReturn(expected);
        ResponseEntity<List<CryptoDto>> actual = controller.findMaxByMonth("January");
        assertEquals(actual.getBody(), expected);
    }

    public void testGivenController_whenFindOldestByMonthAndSymbol_thenReturnResponseOk() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> expected = Collections.singletonList(cryptoDto);
        when(service.findOldestByMonthSymbol("January", "BTC")).thenReturn(expected);
        ResponseEntity<List<CryptoDto>> actual = controller.findOldestByMonthAndSymbol("January", "BTC");
        assertEquals(actual.getBody(), expected);
    }

    public void testGivenController_whenFindNewestByMonthAndSymbol_thenReturnResponseOk() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> expected = Collections.singletonList(cryptoDto);
        when(service.findNewestByMonthSymbol("January", "BTC")).thenReturn(expected);
        ResponseEntity<List<CryptoDto>> actual = controller.findNewestByMonthAndSymbol("January", "BTC");
        assertEquals(actual.getBody(), expected);
    }

    public void testGivenController_whenFindOlMinByMonthAndSymbol_thenReturnResponseOk() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> expected = Collections.singletonList(cryptoDto);
        when(service.findMinByMonthSymbol("January", "BTC")).thenReturn(expected);
        ResponseEntity<List<CryptoDto>> actual = controller.findMinByMonthAndSymbol("January", "BTC");
        assertEquals(actual.getBody(), expected);
    }

    public void testGivenController_whenFindMaxByMonthAndSymbol_thenReturnResponseOk() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> expected = Collections.singletonList(cryptoDto);
        when(service.findMaxByMonthSymbol("January", "BTC")).thenReturn(expected);
        ResponseEntity<List<CryptoDto>> actual = controller.findMaxByMonthAndSymbol("January", "BTC");
        assertEquals(actual.getBody(), expected);
    }
}