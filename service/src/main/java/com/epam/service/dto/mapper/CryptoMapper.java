/**
 * CryptoMapper class
 * @author Ryhor Pishchyk
 * */

package com.epam.service.dto.mapper;

import com.epam.repository.model.Crypto;
import com.epam.service.dto.modeldto.CryptoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CryptoMapper {

    /**Field model mapper that needed for CryptoMapper*/
    private ModelMapper modelMapper;

    /**
     * Constructor for creating object
     * */
    public CryptoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Method of converting CryptoDto to Crypto
     * @param cryptoDto - entity for converting
     * @return object
     * */
    public Crypto toEntity(CryptoDto cryptoDto) {
        return modelMapper.map(cryptoDto, Crypto.class);
    }

    /**
     * Method of converting Crypto CryptoDto
     * @param crypto - entity for converting
     * @return object
     * */
    public CryptoDto toDto(Crypto crypto) {
        return modelMapper.map(crypto, CryptoDto.class);
    }
}