package me.dio.decola_tech_2025.domain.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@Table(name = "cards")
public class Card extends BaseEntity {

    @Column(unique = true)
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Card{" +
                super.toString() +
                ", number='" + number + '\'' +
                ", limit=" + limit +
                '}';
    }
}
