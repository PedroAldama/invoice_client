package com.pedro.springboot.di.factura.springbootdifactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.springboot.di.factura.springbootdifactura.models.Client;
import com.pedro.springboot.di.factura.springbootdifactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;
    
    @GetMapping("/show")
    public Invoice show(){
        Invoice newInvoice = new Invoice();
        Client client = new Client();

        client.setName(invoice.getClient().getName());
        client.setLastname(invoice.getClient().getLastname());

        newInvoice.setClient(client);
        newInvoice.setDescription(invoice.getDescription());
        newInvoice.setItems(invoice.getItems());
        return newInvoice;
    }
}