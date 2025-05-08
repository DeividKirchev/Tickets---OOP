package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.commands.contracts.ParametizedCommand;
import bg.tu_varna.sit.b1.f23621684.exceptions.ExitException;
import bg.tu_varna.sit.b1.f23621684.exceptions.NoOpenFileException;
import bg.tu_varna.sit.b1.f23621684.loggers.contracts.Logger;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;

import java.util.*;

public class BaseMenu implements Menu {
    private final Map<String, ParametizedCommand> commands = new LinkedHashMap<>();

    private final Logger logger;

    public BaseMenu(Logger logger) {
        this.logger = logger;

        var commandList = getCommands();
        for (var cmd : commandList)
            commands.put(cmd.getCommandName(), cmd);
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public List<ParametizedCommand> getCommands() {
        return new ArrayList<>();
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

                ParametizedCommand match = commands.get(cmdName);

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


    private String filePath;

    @Override
    public String getFilePath() {
        if (filePath == null)
            throw new NoOpenFileException("There is no currently open file.");
        return filePath;
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
