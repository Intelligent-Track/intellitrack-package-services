package com.architechz.project.packageservices.controllers;

import com.architechz.project.packageservices.models.Delivery;
import com.architechz.project.packageservices.models.Product;
import com.architechz.project.packageservices.payload.response.MessageResponse;
import com.architechz.project.packageservices.service.Delivery.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/del")
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("/program")
    public BigDecimal programDelivery(@RequestParam("originId") Long originId,
                                      @RequestParam("destinationId") Long destinationId,
                                      @RequestParam("type") String type,
                                      @RequestParam("arriveDate") String arriveDate,
                                      @RequestBody List<Product> products) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = formatter.parse(arriveDate);
        return this.deliveryService.programDelivery(originId, destinationId, type, parsedDate, products);
    }

    @GetMapping("/allDeliveriesProgramed")
    public List<Delivery> getAllDelivery() {
        return this.deliveryService.listAllDeliverys();
    }

    @DeleteMapping("/cancelDelivery")
    public ResponseEntity<?> deleteDelivery(@Valid @RequestBody Delivery delivery) {
        return ResponseEntity.ok(new MessageResponse(deliveryService.deleteDelivery(delivery)));
      }


}
