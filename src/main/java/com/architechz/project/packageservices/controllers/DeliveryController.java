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
import org.springframework.web.bind.annotation.PutMapping;
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
            @RequestParam("departureDate") String departureDate,
            @RequestParam("comments") String comments,
            @RequestParam("nit") String nit,
            @RequestBody List<Product> products) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = formatter.parse(arriveDate);
        Date finishDate = formatter.parse(departureDate);
        return this.deliveryService.programDelivery(originId, destinationId, type, parsedDate, finishDate, comments, nit, products);
    }

    @GetMapping("/allDeliveriesProgramed")
    public List<Delivery> getAllDelivery() {
        return this.deliveryService.listAllDeliveries();
    }

    @DeleteMapping("/cancelDelivery/{id}")
    public ResponseEntity<?> deleteDelivery(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryService.deleteDelivery(id));
    }

    @PutMapping("/updateDelivery")
    public ResponseEntity<?> editWarehouse(@Valid @RequestBody Delivery delivery) {
        return ResponseEntity.ok(new MessageResponse(deliveryService.editDelivery(delivery)));
    }

    @GetMapping("/deliveriesByDriverId/{id}")
    public List<Delivery> getDeliveriesById(@PathVariable Long id){
        return this.deliveryService.listAllDeliveriesByIdDriver(id);
    }

    @GetMapping("/deliveriesByDriverIdInWarehouse/{id}")
    public List<Delivery> getDeliveriesByIdInWarehouse(@PathVariable Long id){
        return this.deliveryService.listAllDeliveriesByIdDriverInWarehouse(id);
    }

    @GetMapping("/deliveriesByDriverIdOnTheWay/{id}")
    public List<Delivery> getDeliveriesByIdOnTheWay(@PathVariable Long id){
        return this.deliveryService.listAllDeliveriesByIdDriverInWarehouse(id);
    }

    @GetMapping("/deliveriesByDriverIdDelivered/{id}")
    public List<Delivery> getDeliveriesByIdDelivered(@PathVariable Long id){
        return this.deliveryService.listAllDeliveriesByIdDriverDelivered(id);
    }

    @GetMapping("/deliveriesByNit/{nit}")
    public List<Delivery> getDeliveriesByNit(@PathVariable String nit){
        return this.deliveryService.getAllDeliveriesByNit(nit);
    }

    @GetMapping("/deliveriesInWarehouse/{nit}")
    public List<Delivery> getDeliveriesInWarehouse(@Valid @PathVariable String nit){
        return this.deliveryService.listAllDeliveriesInWarehouse(nit);
    }

    @GetMapping("/deliveriesOnTheWay/{nit}")
    public List<Delivery> getDeliveriesOnTheWay(@Valid @PathVariable String nit){
        return this.deliveryService.listAllDeliveriesOnTheWay(nit);
    }

    @GetMapping("/deliveriesDelivered/{nit}")
    public List<Delivery> getDeliveriesDelivered(@Valid @PathVariable String nit){
        return this.deliveryService.listAllDeliveriesDelivered(nit);
    }

}
