package com.epam.controller;

import com.epam.service.dto.modeldto.NormalizedCryptoDto;
import com.epam.service.servicedto.impl.NormalizedCryptoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(tags = "Module to find normalized information by request")
@Controller
@RequestMapping("normalized")
public class NormalizedCryptoController {

    private final NormalizedCryptoServiceImpl normalizedCryptoService;

    @Autowired
    public NormalizedCryptoController(NormalizedCryptoServiceImpl normalizedCryptoService) {
        this.normalizedCryptoService = normalizedCryptoService;
    }

    @ApiOperation(value = "Find a descending sorted list of all the cryptos, comparing the normalized range", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true)
    })
    @GetMapping(value = "/byMonth")
    public ResponseEntity<List<NormalizedCryptoDto>> findNormalizedByMonth(@RequestParam(name = "month") String month) {
        return ResponseEntity.ok(normalizedCryptoService.findNormalizedByMonth(month));
    }

    @ApiOperation(value = "Find crypto with the highest normalized range for a specific day", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "month", value = "month", required = true),
            @ApiImplicitParam(name = "day", value = "day", required = true)
    })
    @GetMapping(value = "/byMonthAndDay")
    public ResponseEntity<Object> findNormalizedByMonthAndDay(@RequestParam(name = "month") String month,
                                       @RequestParam(name = "day") Integer day) {
        return ResponseEntity.ok(normalizedCryptoService.findNormalizedByMonthDay(month, day));
    }
}