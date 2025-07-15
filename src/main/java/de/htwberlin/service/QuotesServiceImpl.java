package de.htwberlin.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuotesServiceImpl implements QuotesService {

    List<UpdatableQuote> quotes = QUOTES.stream().map(UpdatableQuote::new).collect(Collectors.toList());

    @Override
    public UpdatableQuote getQuote(int index) {
        if(index >= quotes.size() || index < 0) throw new IllegalArgumentException("invalid index");
        return quotes.get(index);
    }

    @Override
    public List<UpdatableQuote> getAllQuotes() {
            return quotes;
    }

    @Override
    public void addQuote(int index, String quote) {
        if(index >= quotes.size() || index < 0) throw new IllegalArgumentException("invalid index");
        quotes.add(index, new UpdatableQuote(quote));
    }

    @Override
    public void updateQuote(int index, String quote) {
        // TODO hier implementieren
    }
}
