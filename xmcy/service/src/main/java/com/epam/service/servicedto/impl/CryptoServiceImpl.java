package com.epam.service.servicedto.impl;

import com.epam.repository.jparepository.CryptoEntityRepository;
import com.epam.repository.model.Crypto;
import com.epam.service.dto.mapper.CryptoMapper;
import com.epam.service.dto.modeldto.CryptoDto;
import com.epam.service.handler.FileHandler;
import com.epam.service.servicedto.ServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.service.util.CryptoTypeUtil.checkCryptoType;
import static com.epam.service.util.MonthUtil.*;


@Service
@Transactional
public class CryptoServiceImpl implements ServiceDto {

    @Autowired
    private CryptoEntityRepository repository;
    private final CryptoMapper cryptoMapper;
    private final FileHandler<CryptoDto> fileHandler;

    @Autowired
    public CryptoServiceImpl(CryptoMapper cryptoMapper, FileHandler<CryptoDto> fileHandler) {
        this.cryptoMapper = cryptoMapper;
        this.fileHandler = fileHandler;
    }

    public List<CryptoDto> addEntitiesFromFile(MultipartFile file) {
        List<CryptoDto> cryptoDtoList = fileHandler.handleCSVFile(file, CryptoDto.class);
        List<Crypto> cryptoList = cryptoDtoList.stream().map(cryptoMapper::toEntity)
                .peek(x -> x.setDate(new Date(x.getTimestamp()))).collect(Collectors.toList());
        repository.saveAll(cryptoList);
        return cryptoDtoList;
    }

    public List<CryptoDto> findMinByMonth(String month) {
        return repository.findMinByMonth(findCurrentNumberOfMonth(month)).stream().map(cryptoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CryptoDto> findMaxByMonth(String month) {
        return repository.findMaxByMonth(findCurrentNumberOfMonth(month)).stream().map(cryptoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CryptoDto> findOldestByMonth(String month) {
        return repository.findOldestByMonth(findCurrentNumberOfMonth(month)).stream().map(cryptoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CryptoDto> findNewestByMonth(String month) {
        return repository.findNewestByMonth(findCurrentNumberOfMonth(month)).stream().map(cryptoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<CryptoDto> findMinByMonthSymbol(String month, String symbol) {
        checkCryptoType(symbol);
        return repository.findMinByMonthSymbol(findCurrentNumberOfMonth(month), symbol.toUpperCase()).stream()
                .map(cryptoMapper::toDto).collect(Collectors.toList());
    }

    public List<CryptoDto> findMaxByMonthSymbol(String month, String symbol) {
        checkCryptoType(symbol);
        return repository.findMaxByMonthSymbol(findCurrentNumberOfMonth(month), symbol.toUpperCase()).stream()
                .map(cryptoMapper::toDto).collect(Collectors.toList());
    }

    public List<CryptoDto> findOldestByMonthSymbol(String month, String symbol) {
        checkCryptoType(symbol);
        return repository.findOldestByMonthSymbol(findCurrentNumberOfMonth(month), symbol.toUpperCase()).stream()
                .map(cryptoMapper::toDto).collect(Collectors.toList());
    }

    public List<CryptoDto> findNewestByMonthSymbol(String month, String symbol) {
        checkCryptoType(symbol);
        return repository.findNewestByMonthSymbol(findCurrentNumberOfMonth(month), symbol.toUpperCase()).stream()
                .map(cryptoMapper::toDto).collect(Collectors.toList());
    }
}