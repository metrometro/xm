/**
 * Month util class
 * @author Ryhor Pishchyk
 * */

package com.epam.service.util;

import com.epam.service.exception.ServiceException;

import java.time.Month;

public class MonthUtil {

    /**
     * Private constructor
     * */
    private MonthUtil() {}

    /**
     * Method to validate month
     * @param month - month
     * @return number of month
     * @throws ServiceException - not existing month will throw exception with message
     * */
    public static Integer findCurrentNumberOfMonth(String month) throws ServiceException {
        try {
            return Month.valueOf(month.toUpperCase()).getValue();
        } catch (Exception e) {
            throw new ServiceException("Incorrect month name");
        }
    }
}