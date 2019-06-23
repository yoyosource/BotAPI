package botapi.command;

import botapi.bot.Bot;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().startsWith(Bot.cmdprefix) && !(event.getAuthor().isBot())) {
            CommandHandler.handleCommand(event);
        }

    }

}
