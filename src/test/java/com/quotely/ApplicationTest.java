package com.quotely;

import com.quotely.exceptions.MissingLanguageException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationTest {

    @Test
    public void testApplicationWithEnArgument() throws Exception {
        new Application(new String[]{"language=en"});
    }

    @Test void testApplicationWithRUArgument() throws Exception {
        new Application(new String[]{"language=ru"});
    }

    @Test
    public void testApplicationWithHelpArgument() throws Exception {
        new Application(new String[]{"help"});
    }

    @Test
    public void testApplicationWithInvalidLanguage() {
        assertThrows(IllegalArgumentException.class, () ->new Application(new String[]{"language=de"}));
    }

    @Test
    public void testApplicationWithEmptyArguments() {
        assertThrows(MissingLanguageException.class, () -> new Application(new String[0]));
    }

}
