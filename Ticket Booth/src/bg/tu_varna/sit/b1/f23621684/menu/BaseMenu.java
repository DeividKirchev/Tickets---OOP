package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.contracts.CommandWithParameters;
import bg.tu_varna.sit.b1.f23621684.exceptions.ExitException;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;

import java.util.*;

public class BaseMenu implements Menu {
    private final Map<String, CommandWithParameters> commands = new LinkedHashMap<>();
    private final Logger logger;

    public BaseMenu(Logger logger) {
        this.logger = logger;
    }

    void addCommands(List<CommandWithParameters> commandList) {
        for (var cmd : commandList)
            commands.put(cmd.getCommandName(), cmd);
    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                logger.log("\n> ");
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                String cmdName = parts[0];

                List<String> params = parts.length > 1
                        ? Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length))
                        : Collections.emptyList();

                CommandWithParameters match = commands.get(cmdName);

                if (match != null) {
                    try {
                        match.execute(params);
                    } catch (ExitException e) {
                        throw e;
                    } catch (Exception ex) {
                        logger.log("Error executing command: " + ex.getMessage() + "\n");
                    }
                } else {
                    logger.log("Unknown command: " + cmdName + "\n");
                }
            }
        } catch (ExitException e) {
            logger.log(e.getMessage());
        }
    }
}
