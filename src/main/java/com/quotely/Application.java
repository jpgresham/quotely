package com.quotely;

import com.quotely.app.QuoteApplication;
import com.quotely.enums.Language;
import com.quotely.exceptions.MissingLanguageException;
import com.quotely.help.Help;

public class Application {

    public Application(String[] args) throws Exception {
        String language = "";
        boolean help = false;

        for (String s : args) {
            String[] parts = s.split("=");
            if (parts[0].equalsIgnoreCase("language")) {
                language = parts[1];
            } else if (parts[0].equalsIgnoreCase("help")) {
                help = true;
            }
        }
        if (help) {
            System.out.println(Help.Text);
        } else {
            if (language.isEmpty()) {
                throw new MissingLanguageException();
            }
            var quoteApp = new QuoteApplication();
            quoteApp.setLanguage(Language.valueOf(language.toUpperCase()));
            var quote = quoteApp.fetch();
            System.out.println(quote.getQuoteAuthor());
            System.out.println(quote.getQuoteText());
        }
    }

    public static void main(String[] args) throws Exception {
        new Application(args);
    }

}
