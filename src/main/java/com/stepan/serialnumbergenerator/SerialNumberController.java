package com.stepan.serialnumbergenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerialNumberController {

    @Autowired
    private SerialNumberService serialNumberService;

    @GetMapping
    public String getNextSerialNumber(@RequestParam int year, @RequestParam String sellPlace) {
        return serialNumberService.generateNextItem(year, sellPlace);
    }
}
