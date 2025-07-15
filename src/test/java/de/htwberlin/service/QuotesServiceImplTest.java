package de.htwberlin.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuotesServiceImplTest {

    @Test
    @DisplayName("should throw Exception when index is out of range")
    void throwQuote() {
        var sut = new QuotesServiceImpl();
        assertThrows(IllegalArgumentException.class, () -> sut.getQuote(-42));
    }

    @Test
    @DisplayName("should return first quote")
    void getQuote() {
        var sut = new QuotesServiceImpl();
        String expected = "Chuck Norris dreht nicht die Dusche auf. Er starrt sie an, bis sie zu weinen anfängt.";
        assertEquals(expected, sut.getQuote(0).getQuote());
    }

    @Test
    @DisplayName("should update a quote")
    void updateQuote() {
        final var sut = new QuotesServiceImpl();
        final String newText = "Chuck Norris kennt die letzte Ziffer von Pi persönlich.";
        sut.updateQuote(42, newText);
        assertEquals(newText, sut.getQuote(42).getQuote());
    }

    //TODO hier zwei Testfälle für die Methode addQuote(index, quote) hinzufügen


}
