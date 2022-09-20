/**
 * FileHandler class
 * @author Ryhor Pishchyk
 * */

package com.epam.service.handler;

import com.epam.service.exception.ServiceException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Component
public class FileHandler<T> {

    /**
     * Method for converting SCV file to collection of objects
     * @param file - SCV file
     * @param clazz - type of object to convert
     * @return list of objects
     * @throws ServiceException - invalid file will throw exception with message
     * */
    public List<T> handleCSVFile(MultipartFile file, Class<T> clazz) {
        List<T> list;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<T> csvBean = new CsvToBeanBuilder(reader)
                    .withType(clazz)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            list = csvBean.parse();
        } catch (IOException e) {
            throw new ServiceException("File doesn't found");
        } catch (Exception ex) {
            throw new ServiceException("Headers in SCV file are required");
        }
        return list;
    }
}