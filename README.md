# Quotely

## Building

Run `gradle jar`  from the root project directory to build the jar file. This will create a jar in the `build/libs` directory

## Running

To run, navigate to the `build/libs` directory and run `java -jar quotely-1.0-SNAPSHOT.jar language=en|ru` to get a quote. Supported languages are `en` (English) and `ru` (Russian)

Alternatively, run `./quotely.sh language=en` from the root project directory

## Help

Usage documentation can also be found via the `help` command: `java -jar quotely-1.0-SNAPSHOT.jar help`