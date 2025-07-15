package de.htwberlin.service;

public class UpdatableQuote {

    private String quote;

    public UpdatableQuote(String quote) {
        this.quote = quote;
    }

    public UpdatableQuote() { }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
