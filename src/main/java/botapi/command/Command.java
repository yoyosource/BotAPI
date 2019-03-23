package botapi.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {
    boolean called(String[] args, MessageReceivedEvent e);
    void action(String[] args, MessageReceivedEvent e);
    void executed(boolean succes, MessageReceivedEvent e);
    String help();
}
