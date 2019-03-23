package botapi.main;

import botapi.bot.Bot;
import botapi.command.Command;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Main {

    public static void main(String[] args) {
        Bot bot = new Bot(token.getToken());
        bot.setGame("HELP");
        bot.setStatus(OnlineStatus.ONLINE);
        bot.setPrefix("-");

        bot.addCommand("help", new Command() {
            @Override
            public boolean needsExecution(MessageReceivedEvent e, String[] args) {
                return false;
            }

            @Override
            public void execute(MessageReceivedEvent e, String[] args) {

            }
        });

        bot.start();
    }

}
