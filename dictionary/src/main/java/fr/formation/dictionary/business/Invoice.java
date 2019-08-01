package fr.formation.dictionary.business;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

public class Invoice {

    @NotEmpty
    private String reference;

    @PastOrPresent
    private LocalDate date;

    private double amount;

    private boolean paid = false;

    private Long id;

    public Invoice(String reference, LocalDate date, double amount) {
	this.reference = reference;
	this.date = date;
	this.amount = amount;
    }

    public Invoice(String reference, LocalDate date, double amount,
	    boolean paid) {
	this.reference = reference;
	this.date = date;
	this.amount = amount;
	this.paid = paid;
    }

    public Invoice() {
    }

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public LocalDate getDate() {
	return date;
    }

    public void setDate(LocalDate date) {
	this.date = date;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public boolean isPaid() {
	return paid;
    }

    public void setPaid(boolean paid) {
	this.paid = paid;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
	//
    }

    @Override
    public String toString() {
	return "{reference=" + reference + ", date=" + date + ", amount="
		+ amount + ", paid=" + paid + ", id=" + id + "}";
    }
}
