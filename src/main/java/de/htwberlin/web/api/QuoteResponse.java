package de.htwberlin.web.api;

import de.htwberlin.service.UpdatableQuote;

public class QuoteResponse extends UpdatableQuote {

    private int index;

    public QuoteResponse(String quote, int index) {
        super(quote);
        this.index = index;
    }

    public QuoteResponse() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
