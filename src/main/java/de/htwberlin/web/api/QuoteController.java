package de.htwberlin.web.api;

import de.htwberlin.service.UpdatableQuote;
import de.htwberlin.service.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuoteController {

    @Autowired
    QuotesService quotesService;

    public QuoteController() {
    }

    @GetMapping("/api/v1/quote")
    public QuoteResponse getQuote(@RequestParam int index) {
        UpdatableQuote quote = quotesService.getQuote(index);
        return new QuoteResponse(quote.getQuote(), index);
    }

    @GetMapping("/api/v1/quotes")
    public List<QuoteResponse> getQuotes() {
        List<QuoteResponse> result = new ArrayList<>();
        List<UpdatableQuote> quotes = quotesService.getAllQuotes();
        for (int i = 0; i < quotes.size(); i++) {
            UpdatableQuote quote = quotes.get(i);
            result.add(new QuoteResponse(quote.getQuote(), i));
        }
        return result;
    }

    // TODO hier eine Route zum Speichern von neuen Sprüchen hinzufügen

    // TODO hier eine Route zum Bearbeiten von neuen Sprüchen hinzufügen

}
