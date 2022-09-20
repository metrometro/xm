/**
 * Class controller for uploading cryptos rate and finding information by request
 * @author Ryhor Pishchyk
 * */

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

    /**Field of implementation service layer*/
    private final CryptoServiceImpl service;

    /**
     * Constructor for creating controller
     * */
    @Autowired
    public CryptoController(CryptoServiceImpl service) {
        this.service = service;
    }


    @ApiOperation(value = "Upload SCV file with cryptos rate", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "file", required = true)
    })
    /**
     * Endpoint to upload SCV file POST: crypto/upload
     * @param file - SCV file with data
     * */
    @PostMapping("/upload")
    public ResponseEntity<List<CryptoDto>> uploadSalaryScvFile(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(service.addEntitiesFromFile(file));
    }

    @ApiOperation(value = "Find most oldest rates by month", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    /**
     * Endpoint to get the oldest rates by month GET:crypto/oldestByMonth (paramkey = month)
     * @param month - needed month
     * @see CryptoServiceImpl#findOldestByMonth(String) 
     * */
    @GetMapping(value = "/oldestByMonth")
    public ResponseEntity<List<CryptoDto>> findOldestByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(service.findOldestByMonth(month));
    }

    @ApiOperation(value = "Find most newest rates by month", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    /**
     * Endpoint to get the newest rates by month GET:crypto/newestByMonth (paramkey = month)
     * @param month - needed month
     * @see CryptoServiceImpl#findNewestByMonth(String) 
     * */
    @GetMapping(value = "/newestByMonth")
    public ResponseEntity<List<CryptoDto>> findNewestByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(service.findNewestByMonth(month));
    }

    @ApiOperation(value = "Find min rates by month", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    /**
     * Endpoint to get the minimal rates by month GET:crypto/mintByMonth (paramkey = month)
     * @param month - needed month
     * @see CryptoServiceImpl#findMinByMonth(String) 
     * */
    @GetMapping(value = "/mintByMonth")
    public ResponseEntity<List<CryptoDto>> findMinByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(service.findMinByMonth(month));
    }

    @ApiOperation(value = "Find max rates by month", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    /**
     * Endpoint to get the maximal rates by month GET:crypto/maxByMonth (paramkey = month)
     * @param month - needed month
     * @see CryptoServiceImpl#findMaxByMonth(String) 
     * */
    @GetMapping(value = "/maxByMonth")
    public ResponseEntity<List<CryptoDto>> findMaxByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(service.findMaxByMonth(month));
    }

    @ApiOperation(value = "Find most oldest rates by month and name of the cryptocurrency", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true),
            @ApiImplicitParam(name = "symbol", value = "symbol", required = true)
    })
    /**
     * Endpoint to get the oldest rates by month and cryptocurrency type GET:crypto/oldestByMonthAndSymbol (paramkey = month, paramkey = symbol)
     * @param month - needed month
     * @param day - needed day
     * @see CryptoServiceImpl#findMinByMonthSymbol(String, String) 
     * */
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
    /**
     * Endpoint to get the newest rates by month and cryptocurrency type GET:crypto/newestByMonthAndSymbol (paramkey = month, paramkey = symbol)
     * @param month - needed month
     * @param day - needed day
     * @see CryptoServiceImpl#findNewestByMonthSymbol(String, String) 
     * */
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
    /**
     * Endpoint to get the minimal rates by month and cryptocurrency type GET:crypto/mintByMonthAndSymbol (paramkey = month, paramkey = symbol)
     * @param month - needed month
     * @param day - needed day
     * @see CryptoServiceImpl#findMaxByMonthSymbol(String, String) 
     * */
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
    /**
     * Endpoint to get the maximal rates by month and cryptocurrency type GET:crypto/maxByMonthAndSymbol (paramkey = month, paramkey = symbol)
     * @param month - needed month
     * @param day - needed day
     * @see CryptoServiceImpl#findMaxByMonthSymbol(String, String) 
     * */
    @GetMapping(value = "/maxByMonthAndSymbol")
    public ResponseEntity<List<CryptoDto>> findMaxByMonthAndSymbol(@RequestParam(name = "month") String month,
                                                                   @RequestParam(name = "symbol") String symbol) {
        return ResponseEntity.ok(service.findMaxByMonthSymbol(month, symbol));
    }
}