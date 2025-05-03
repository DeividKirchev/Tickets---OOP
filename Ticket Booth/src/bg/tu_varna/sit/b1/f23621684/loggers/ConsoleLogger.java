package bg.tu_varna.sit.b1.f23621684.loggers;

import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.print(message);
    }
}
