package de.htwberlin.web.api;

import de.htwberlin.service.UpdatableQuote;
import de.htwberlin.service.QuotesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = QuoteController.class)
public class QuoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuotesService service;

    @Test
    public void testGetByIndexRoute() throws Exception {
        //Test Daten und Service Mock
        UpdatableQuote q42 = new UpdatableQuote("Chuck Norris ...");
        when(service.getQuote(42)).thenReturn(q42);

        //Erwartetes Ergebnis
        String expected = "{\"quote\":\"Chuck Norris ...\",\"index\":42}";

        //Aufruf und Vergleich
        this.mockMvc.perform(get("/api/v1/quote?index=42"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    public void testPostRoute() throws Exception {
        //Test Daten und Service Mock
        UpdatableQuote q42 = new UpdatableQuote("Chuck Norris ...");
        when(service.getQuote(42)).thenReturn(q42);

        //Erwartetes Ergebnis
        String newQuote = "{\"quote\":\"Chuck Norris ...\",\"index\":42}";

        //Aufruf und Vergleich
        this.mockMvc.perform(post("/api/v1/quote/42")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newQuote)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk());

        verify(service, times(1)).addQuote(42, "Chuck Norris ...");
    }

    @Test
    public void testUpdateRoute() throws Exception {
        //Test Daten und Service Mock
        UpdatableQuote q42 = new UpdatableQuote("Chuck Norris ...");
        when(service.getQuote(42)).thenReturn(q42);

        //Erwartetes Ergebnis
        String newQuote = "{\"quote\":\"Chuck Norris ...\"}";

        //Aufruf und Vergleich
        this.mockMvc.perform(put("/api/v1/quote?index=42")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newQuote)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk());

        verify(service, times(1)).updateQuote(42, "Chuck Norris ...");
    }
}
