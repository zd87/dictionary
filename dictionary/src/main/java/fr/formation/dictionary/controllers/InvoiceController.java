package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices") // after http://localhost:8080
public class InvoiceController {

    @GetMapping("/{id}")
    public Invoice getOne(@PathVariable("id") Long id) { // Long beacuse it can
							 // has value null
	LocalDate date = LocalDate.of(2018, 12, 26);
	Invoice invoice = new Invoice("A01", date, 1005.36);
	invoice.setPaid(true);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping()
    public ArrayList<Invoice> getAll(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size = " + size + ", page = " + page);
	// http://localhost:8080/invoices?size=1&page=1
	ArrayList<Invoice> invoices = new ArrayList<>();
	LocalDate date1 = LocalDate.of(2019, 11, 15);
	Invoice invoice1 = new Invoice("A01", date1, 1005.36, true);
	LocalDate date2 = LocalDate.of(2018, 12, 26);
	Invoice invoice2 = new Invoice("B05", date2, 103.00);
	invoices.add(invoice1);
	invoices.add(invoice2);
	return invoices;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleting invoice with id: " + id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id) {
	System.out.println("Update of invoice with id: " + id);
    }

    @PatchMapping("/{id}/paid")
    public void paid(@PathVariable("id") Long id) {
	// normally would add this line of code: getAll.setPaid(true);
	System.out.println("Patched invoice with id: " + id);
    }

    @PatchMapping("/{id}/unpaid")
    public void unpaid(@PathVariable("id") Long id) {
	System.out.println("Patched invoice with id: " + id);
    }
}
