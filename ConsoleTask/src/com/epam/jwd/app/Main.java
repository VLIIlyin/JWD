package com.epam.jwd.app;
import com.epam.jwd.model.Figure;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.log(Level.INFO, "Application started");

        Figure figures[] = new Figure[] {new Figure(12, 14, 5, "Cube"),
                new Figure((float) 10.2, 11, (float) 4.5, "Pyramid"),
                new Figure((float) 9.7, (float) 4.6, (float) 2.4, "Parallelepiped")};

        for (Figure figure: figures) {
            LOGGER.log(Level.DEBUG, figure.toString());
        }

        LOGGER.log(Level.INFO, "Application ended");
    }
}
