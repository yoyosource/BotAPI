package botapi.command;

import botapi.bot.Bot;
import botapi.command.commandParser;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class CommandHandler {

    public static HashMap<String, Command> commands = new HashMap<>();

    public static void addCommand(String commandName, Command command) {
        if (!(commands.containsKey(commandName))) {
            commands.put(commandName, command);
        }
    }

    public static void handleCommand(MessageReceivedEvent e) {

        String[] args1 = e.getMessage().getContentRaw().substring(Bot.cmdprefix.length()).split(" ");

        if (commands.containsKey(args1[0])) {

            String[] args2 = e.getMessage().getContentRaw().substring(Bot.cmdprefix.length() + args1[0].length()).split(" ");

            if (commands.get(args1[0]).needsExecution(e, args2)) {
                commands.get(args1[0]).execute(e, args2);
            }
        }

    }

}
