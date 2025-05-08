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
                List<String> parts = new ArrayList<>();
                logger.log("\n> ");
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) return;

                StringBuilder current = new StringBuilder();
                boolean inQuotes = false;

                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if (c == '"') {
                        inQuotes = !inQuotes;
                    } else if (Character.isWhitespace(c) && !inQuotes) {
                        if (!current.isEmpty()) {
                            parts.add(current.toString());
                            current.setLength(0);
                        }
                    } else {
                        current.append(c);
                    }
                }

                if (!current.isEmpty()) {
                    parts.add(current.toString());
                }

                if (parts.isEmpty()) return;

                String cmdName = parts.getFirst();
                List<String> params = parts.size() > 1 ? parts.subList(1, parts.size()) : Collections.emptyList();

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
