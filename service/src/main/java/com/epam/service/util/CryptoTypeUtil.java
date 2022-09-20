/**
 * Cryptocurrency util class
 * @author Ryhor Pishchyk
 * */

package com.epam.service.util;

import com.epam.repository.type.CryptoType;
import com.epam.service.exception.ServiceException;

public class CryptoTypeUtil {

    /**Private constructor*/
    private CryptoTypeUtil() {}

    /**
     * Method for chechin existing cryptocurrency type
     * @param symbol - cryptocurrency type
     * @return boolean
     * @throws ServiceException - not existing cryptocurrency type will throw exception with message
     * */
    public static boolean checkCryptoType(String symbol) {
        try {
            CryptoType.valueOf(symbol.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ServiceException("Crypto doesn't exist or no have information about this");
        }
        return true;
    }
}
