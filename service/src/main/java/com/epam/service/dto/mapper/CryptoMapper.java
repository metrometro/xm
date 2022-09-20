package com.epam.service.dto.mapper;

import com.epam.repository.model.Crypto;
import com.epam.service.dto.modeldto.CryptoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CryptoMapper {

    private ModelMapper modelMapper;

    public CryptoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Crypto toEntity(CryptoDto cryptoDto) {
        return modelMapper.map(cryptoDto, Crypto.class);
    }

    public CryptoDto toDto(Crypto crypto) {
        return modelMapper.map(crypto, CryptoDto.class);
    }
}