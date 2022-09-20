package com.epam.service.util;

import com.epam.repository.type.CryptoType;
import com.epam.service.exception.ServiceException;

public class CryptoTypeUtil {

    private CryptoTypeUtil() {}

    public static boolean checkCryptoType(String symbol) {
        try {
            CryptoType.valueOf(symbol.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ServiceException("Crypto doesn't exist or no have information about this");
        }
        return true;
    }
}
