package com.quotely.app;

import org.junit.jupiter.api.Test;
import com.quotely.enums.Language;
import com.quotely.exceptions.MissingLanguageException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuoteApplicationTest {

    QuoteApplication quoteApplication = new QuoteApplication();

    @Test
    public void testFetchEnglish() throws Exception {
        quoteApplication.setLanguage(Language.EN);
        quoteApplication.fetch();
    }

    @Test
    public void testFetchRussian() throws Exception {
        quoteApplication.setLanguage(Language.RU);
        quoteApplication.fetch();
    }

    @Test
    public void testThrowsMissingLanguageException() {
        assertThrows(MissingLanguageException.class, () -> quoteApplication.fetch());
    }

}
