package com.example.financedataanalyzermobilelitepro.model;

import java.io.Serializable;

public class Stock implements Serializable {
    private String symbol;
    private String name;
    private String kategorie;

    public Stock(String symbol, String name, String kategorie) {
        this.symbol = symbol;
        this.name = name;
        this.kategorie = kategorie;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }
}
