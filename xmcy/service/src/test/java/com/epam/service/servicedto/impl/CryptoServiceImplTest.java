package com.epam.service.servicedto.impl;

import com.epam.repository.jparepository.CryptoEntityRepository;
import com.epam.repository.model.Crypto;
import com.epam.repository.type.CryptoType;
import com.epam.service.dto.mapper.CryptoMapper;
import com.epam.service.dto.modeldto.CryptoDto;
import com.epam.service.exception.ServiceException;
import com.epam.service.handler.FileHandler;
import junit.framework.TestCase;
import org.modelmapper.ModelMapper;
import org.powermock.reflect.Whitebox;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class CryptoServiceImplTest extends TestCase {

    private final CryptoServiceImpl service;
    private final CryptoEntityRepository repository = mock(CryptoEntityRepository.class);
    private final CryptoMapper cryptoMapper;
    private final FileHandler<CryptoDto> fileHandler;

    {
        cryptoMapper = new CryptoMapper(new ModelMapper());
        fileHandler = new FileHandler<>();
        service = new CryptoServiceImpl(cryptoMapper, fileHandler);

        Whitebox.setInternalState(service, "repository", repository);
    }

    public void testGIvenCryptoMethod_whenFindByMinPriceMonth_thenReturnResultList() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findMinByMonth(1)).thenReturn(cryptoList);
        List<CryptoDto> actual = service.findMinByMonth("January");
        assertEquals(actual.get(0).getSymbol(), cryptoDtoList.get(0).getSymbol());
    }

    public void testGIvenCryptoMethod_whenFindByMaxPriceMonth_thenReturnResultList() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findMaxByMonth(1)).thenReturn(cryptoList);
        List<CryptoDto> actual = service.findMaxByMonth("January");
        assertEquals(actual.get(0).getSymbol(), cryptoDtoList.get(0).getSymbol());
    }

    public void testGIvenCryptoMethod_whenFindByOldestPriceMonth_thenReturnResultList() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findOldestByMonth(1)).thenReturn(cryptoList);
        List<CryptoDto> actual = service.findOldestByMonth("January");
        assertEquals(actual.get(0).getSymbol(), cryptoDtoList.get(0).getSymbol());
    }

    public void testGIvenCryptoMethod_whenFindByNewestPriceMonth_thenReturnResultList() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findNewestByMonth(1)).thenReturn(cryptoList);
        List<CryptoDto> actual = service.findNewestByMonth("January");
        assertEquals(actual.get(0).getSymbol(), cryptoDtoList.get(0).getSymbol());
    }

    public void testGIvenCryptoMethod_whenFindByMinPriceMonthAndSymbol_thenReturnResultList() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findMinByMonthSymbol(1, "BTC")).thenReturn(cryptoList);
        List<CryptoDto> actual = service.findMinByMonthSymbol("January", "BTC");
        assertEquals(actual.get(0).getSymbol(), cryptoDtoList.get(0).getSymbol());
    }

    public void testGIvenCryptoMethod_whenFindByMaxPriceMonthAndSymbol_thenReturnResultList() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findMaxByMonthSymbol(1, "BTC")).thenReturn(cryptoList);
        List<CryptoDto> actual = service.findMaxByMonthSymbol("January", "BTC");
        assertEquals(actual.get(0).getSymbol(), cryptoDtoList.get(0).getSymbol());
    }

    public void testGIvenCryptoMethod_whenFindByOldestPriceMonthAndSymbol_thenReturnResultList() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findOldestByMonthSymbol(1, "BTC")).thenReturn(cryptoList);
        List<CryptoDto> actual = service.findOldestByMonthSymbol("January", "BTC");
        assertEquals(actual.get(0).getSymbol(), cryptoDtoList.get(0).getSymbol());
    }

    public void testGIvenCryptoMethod_whenFindByNewestPriceMonthAndSymbol_thenReturnResultList() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findNewestByMonthSymbol(1, "BTC")).thenReturn(cryptoList);
        List<CryptoDto> actual = service.findNewestByMonthSymbol("January", "BTC");
        assertEquals(actual.get(0).getSymbol(), cryptoDtoList.get(0).getSymbol());
    }

    public void testGIvenCryptoMethod_whenFindByMinPriceMonthAndSymbolAndWrongMonth_thenReturnException() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findMinByMonthSymbol(1, "BTC")).thenReturn(cryptoList);

        try {
            List<CryptoDto> actual = service.findMinByMonthSymbol("Januaryy", "BTC");
        } catch (ServiceException e) {
            assertNotNull(e.getMessage());
        }
    }

    public void testGIvenCryptoMethod_whenFindByMaxPriceMonthAndSymbolAndWrongMonth_thenReturnException() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findMaxByMonthSymbol(1, "BTC")).thenReturn(cryptoList);
        try {
            List<CryptoDto> actual = service.findMaxByMonthSymbol("Januaryy", "BTC");
        } catch (ServiceException e) {
            assertNotNull(e.getMessage());
        }
    }

    public void testGIvenCryptoMethod_whenFindByOldestPriceMonthAndSymbolAndWrongMonth_thenReturnException() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findOldestByMonthSymbol(1, "BTC")).thenReturn(cryptoList);
        try {
            List<CryptoDto> actual = service.findOldestByMonthSymbol("Januaryy", "BTC");
        } catch (ServiceException e) {
            assertNotNull(e.getMessage());
        }
    }

    public void testGIvenCryptoMethod_whenFindByNewestPriceMonthAndSymbolAndWrongMonth_thenReturnException() {
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setSymbol("BTC");
        List<CryptoDto> cryptoDtoList = Collections.singletonList(cryptoDto);
        Crypto crypto = new Crypto();
        crypto.setSymbol(CryptoType.BTC);
        List<Crypto> cryptoList = Collections.singletonList(crypto);
        when(repository.findNewestByMonthSymbol(1, "BTC")).thenReturn(cryptoList);
        try {
            List<CryptoDto> actual = service.findNewestByMonthSymbol("Januaryy", "BTC");
        } catch (ServiceException e) {
            assertNotNull(e.getMessage());
        }
    }
}