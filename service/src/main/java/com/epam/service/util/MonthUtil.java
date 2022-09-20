package com.epam.service.util;

import com.epam.service.exception.ServiceException;

import java.time.Month;

public class MonthUtil {

    private MonthUtil() {}

    public static Integer findCurrentNumberOfMonth(String month) throws ServiceException {
        try {
            return Month.valueOf(month.toUpperCase()).getValue();
        } catch (Exception e) {
            throw new ServiceException("Incorrect month name");
        }
    }
}