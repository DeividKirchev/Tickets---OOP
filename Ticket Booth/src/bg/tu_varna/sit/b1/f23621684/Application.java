package bg.tu_varna.sit.b1.f23621684;

import bg.tu_varna.sit.b1.f23621684.loggers.ConsoleLogger;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.TicketBoothMenu;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;

public class Application {
    public static void main(String[] args) {
        Logger consoleLogger = new ConsoleLogger();
        Menu menu = new TicketBoothMenu(consoleLogger);
        menu.startMenu();
    }
}
