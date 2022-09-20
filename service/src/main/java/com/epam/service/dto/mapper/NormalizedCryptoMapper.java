/**
 * NormalizedCryptoMapper class
 * @author Ryhor Pishchyk
 * */

package com.epam.service.dto.mapper;

import com.epam.repository.model.NormalizedCrypto;
import com.epam.service.dto.modeldto.NormalizedCryptoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NormalizedCryptoMapper {

    /**Field model mapper that needed for NormalizedCryptoMapper*/
    private ModelMapper modelMapper;

    /**
     * Constructor for creating object
     * */
    public NormalizedCryptoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Method of converting NormalizedCryptoDto to NormalizedCrypto
     * @param normalizedCryptoDto - entity for converting
     * @return object
     * */
    public NormalizedCrypto toEntity(NormalizedCryptoDto normalizedCryptoDto) {
        return modelMapper.map(normalizedCryptoDto, NormalizedCrypto.class);
    }

    /**
     * Method of converting NormalizedCrypto to NormalizedCryptoDto
     * @param normalizedCrypto - entity for converting
     * @return object
     * */
    public NormalizedCryptoDto toDto(NormalizedCrypto normalizedCrypto) {
        return modelMapper.map(normalizedCrypto, NormalizedCryptoDto.class);
    }
}