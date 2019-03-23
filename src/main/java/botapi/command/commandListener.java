package botapi.command;

import botapi.bot.Bot;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class commandListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().startsWith(Bot.cmdprefix) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
            commandHandler.handleCommand(commandHandler.parse.parse(event.getMessage().getContentRaw(), event));
        }

    }
}
