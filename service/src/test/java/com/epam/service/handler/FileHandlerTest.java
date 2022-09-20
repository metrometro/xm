package com.epam.service.handler;

import com.epam.service.dto.modeldto.CryptoDto;
import com.epam.service.exception.ServiceException;
import junit.framework.TestCase;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FileHandlerTest extends TestCase {

    private final FileHandler<CryptoDto> fileHandler;
    private MultipartFile file;
    private MultipartFile fileWithoutHeaders;

    {
        fileHandler = new FileHandler();
        try {
            file = new MockMultipartFile("BTC_values.csv",
                    "BTC_values.csv",
                    "text/plain",
                    new FileInputStream("src/test/resources/BTC_values.csv"));
            fileWithoutHeaders = new MockMultipartFile("DOGE_values.csv",
                    "DOGE_values.csv",
                    "text/plain",
                    new FileInputStream("src/test/resources/DOGE_values.csv"));
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void testGivenHandleFile_whenCorrectFile_thenReturnListOfRates() {
        List<CryptoDto> cryptoDtoList = fileHandler.handleCSVFile(file, CryptoDto.class);
        assertEquals(Optional.ofNullable(cryptoDtoList.get(0).getSymbol()), Optional.of("BTC"));
    }

    public void testGivenHandleFile_whenIncorrectFile_thenReturnServiceException() {
        try {
            List<CryptoDto> userDtoList = fileHandler.handleCSVFile(fileWithoutHeaders, CryptoDto.class);
        } catch (ServiceException e) {
            assertEquals("Headers in SCV file are required", e.getMessage());
        }
    }
}