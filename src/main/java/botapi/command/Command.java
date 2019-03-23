package botapi.command;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command {

    default boolean needsExecution(MessageReceivedEvent e, String args[]) {
        //TODO Check if should not be executed

        return false;
    }

    default void execute(MessageReceivedEvent e, String args[]) {
        //TODO Your Execution code here
    }

}
