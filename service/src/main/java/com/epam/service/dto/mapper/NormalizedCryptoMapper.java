package com.epam.service.dto.mapper;

import com.epam.repository.model.NormalizedCrypto;
import com.epam.service.dto.modeldto.NormalizedCryptoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NormalizedCryptoMapper {

    private ModelMapper modelMapper;

    public NormalizedCryptoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NormalizedCrypto toEntity(NormalizedCryptoDto cryptoDto) {
        return modelMapper.map(cryptoDto, NormalizedCrypto.class);
    }

    public NormalizedCryptoDto toDto(NormalizedCrypto crypto) {
        return modelMapper.map(crypto, NormalizedCryptoDto.class);
    }
}