package bg.tu_varna.sit.b1.f23621684.menu;

import bg.tu_varna.sit.b1.f23621684.exceptions.ExitException;
import bg.tu_varna.sit.b1.f23621684.menu.commands.AddEventCommand;
import bg.tu_varna.sit.b1.f23621684.menu.commands.ExitCommand;
import bg.tu_varna.sit.b1.f23621684.menu.commands.HelpCommand;
import bg.tu_varna.sit.b1.f23621684.menu.contracts.Menu;

import java.util.*;


public class TicketBoothMenu implements Menu {
    Map<String, MenuCommand> commands = new LinkedHashMap<>();

    public TicketBoothMenu() {
        List<MenuCommand> commandList = new ArrayList<>();

        commandList.add(new HelpCommand(this.commands));
        commandList.add(new AddEventCommand());
        commandList.add(new ExitCommand());

        for (var cmd : commandList)
            commands.put(cmd.getCommandName(), cmd);
    }

    @Override
    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("> ");
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                String cmdName = parts[0];

                List<String> params = parts.length > 1
                        ? Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length))
                        : Collections.emptyList();

                MenuCommand match = commands.get(cmdName);

                if (match != null) {
                    try {
                        match.execute(params);
                    } catch (ExitException e) {
                        throw e;
                    } catch (Exception ex) {
                        System.out.println("Error executing command: " + ex.getMessage());
                    }
                } else {
                    System.out.println("Unknown command: " + cmdName);
                }
            }
        } catch (ExitException e) {
            System.out.println(e.getMessage());
        }
    }
}
