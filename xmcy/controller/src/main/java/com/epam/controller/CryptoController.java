package com.epam.controller;

import com.epam.service.dto.modeldto.CryptoDto;
import com.epam.service.servicedto.impl.CryptoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(tags = "Module for uploading cryptos rate find information by request")
@Controller
@RequestMapping("crypto")
public class CryptoController {

    private final CryptoServiceImpl service;

    @Autowired
    public CryptoController(CryptoServiceImpl service) {
        this.service = service;
    }


    @ApiOperation(value = "Upload SCV file with cryptos rate", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "file", required = true)
    })
    @PostMapping("/upload")
    public ResponseEntity<List<CryptoDto>> uploadSalaryScvFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(service.addEntitiesFromFile(file));
    }

    @ApiOperation(value = "Find most oldest rates by month", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    @GetMapping(value = "/oldestByMonth")
    public ResponseEntity<List<CryptoDto>> findOldestByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(service.findOldestByMonth(month));
    }

    @ApiOperation(value = "Find most newest rates by month", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    @GetMapping(value = "/newestByMonth")
    public ResponseEntity<List<CryptoDto>> findNewestByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(service.findNewestByMonth(month));
    }

    @ApiOperation(value = "Find min rates by month", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    @GetMapping(value = "/mintByMonth")
    public ResponseEntity<List<CryptoDto>> findMinByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(service.findMinByMonth(month));
    }

    @ApiOperation(value = "Find max rates by month", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    @GetMapping(value = "/maxByMonth")
    public ResponseEntity<List<CryptoDto>> findMaxByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(service.findMaxByMonth(month));
    }

    @ApiOperation(value = "Find most oldest rates by month and name of the cryptocurrency", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true),
            @ApiImplicitParam(name = "symbol", value = "symbol", required = true)
    })
    @GetMapping(value = "/oldestByMonthAndSymbol")
    public ResponseEntity<List<CryptoDto>> findOldestByMonthAndSymbol(@RequestParam(name = "month") String month,
                                                                      @RequestParam(name = "symbol") String symbol) {
        return ResponseEntity.ok(service.findOldestByMonthSymbol(month, symbol));
    }

    @ApiOperation(value = "Find most newest rates by month and name of the cryptocurrency", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true),
            @ApiImplicitParam(name = "symbol", value = "symbol", required = true)
    })
    @GetMapping(value = "/newestByMonthAndSymbol")
    public ResponseEntity<List<CryptoDto>> findNewestByMonthAndSymbol(@RequestParam(name = "month") String month,
                                                                      @RequestParam(name = "symbol") String symbol) {
        return ResponseEntity.ok(service.findNewestByMonthSymbol(month, symbol));
    }

    @ApiOperation(value = "Find min rates by month and name of the cryptocurrency", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true),
            @ApiImplicitParam(name = "symbol", value = "symbol", required = true)
    })
    @GetMapping(value = "/mintByMonthAndSymbol")
    public ResponseEntity<List<CryptoDto>> findMinByMonthAndSymbol(@RequestParam(name = "month") String month,
                                                                   @RequestParam(name = "symbol") String symbol) {
        return ResponseEntity.ok(service.findMinByMonthSymbol(month, symbol));
    }

    @ApiOperation(value = "Find max rates by month and name of the cryptocurrency", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true),
            @ApiImplicitParam(name = "symbol", value = "symbol", required = true)
    })
    @GetMapping(value = "/maxByMonthAndSymbol")
    public ResponseEntity<List<CryptoDto>> findMaxByMonthAndSymbol(@RequestParam(name = "month") String month,
                                                                   @RequestParam(name = "symbol") String symbol) {
        return ResponseEntity.ok(service.findMaxByMonthSymbol(month, symbol));
    }
}