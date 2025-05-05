package bg.tu_varna.sit.b1.f23621684;

import bg.tu_varna.sit.b1.f23621684.data.HallList;
import bg.tu_varna.sit.b1.f23621684.data_handlers.CSVHallListConverter;
import bg.tu_varna.sit.b1.f23621684.files.TextFileHandler;
import bg.tu_varna.sit.b1.f23621684.files.contracts.FileHandler;
import bg.tu_varna.sit.b1.f23621684.loggers.ConsoleLogger;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.TicketBoothMenu;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;

import java.io.IOException;

public class Application {

    private static final Logger logger = new ConsoleLogger();
    private static final FileHandler fileHandler = new TextFileHandler();

    public static void loadHalls() {
        try {
            var data = fileHandler.readFile("halls.txt");
            var hallList = (new CSVHallListConverter()).load(data);

            var hallListInstance = HallList.getInstance();
            hallListInstance.clear();
            hallListInstance.addHalls(hallList);
            
        } catch (IOException e) {
            logger.log("Error loading file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        loadHalls();
        Menu menu = new TicketBoothMenu(logger);
        menu.startMenu();
    }
}
