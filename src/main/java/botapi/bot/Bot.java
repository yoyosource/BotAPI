package botapi.bot;

import botapi.command.Command;
import botapi.command.commandHandler;
import botapi.command.commandListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Bot {

    private boolean isStarted;

    private JDA BotJDA;
    private JDABuilder jda;

    public Bot(String token) {
        isStarted = false;
        jda = new JDABuilder(AccountType.BOT);
        jda.setToken(token);
    }

    public void setGame(String game) {
        if (!isStarted) {
            jda.setGame(Game.playing(game));
        } else {
            BotJDA.getPresence().setGame(Game.playing(game));
        }
    }

    public void setListening(String game) {
         if (!isStarted) {
             jda.setGame(Game.listening(game));
         } else {
             BotJDA.getPresence().setGame(Game.listening(game));
         }
    }

    public void setStreaming(String game, String url) {
        if (!isStarted) {
            jda.setGame(Game.streaming(game, url));
        } else {
            BotJDA.getPresence().setGame(Game.streaming(game, url));
        }
    }

    public void setWatching(String game) {
        if (!isStarted) {
            jda.setGame(Game.watching(game));
        } else {
            BotJDA.getPresence().setGame(Game.watching(game));
        }
    }

    public void setStatus(OnlineStatus status) {
        if (!isStarted) {
            jda.setStatus(status);
        } else {
            BotJDA.getPresence().setStatus(status);
        }
    }

    public void start() {
        if (!isStarted) {
            try {
                BotJDA = jda.buildAsync();
                jda.addEventListener(new commandListener());
                isStarted = true;
            } catch (LoginException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public void addListener(Object... clas){
        try {
            jda.addEventListener(clas);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addCommand(String name, Command clas){
        commandHandler.commands.put(name, clas);
    }

    public JDA getBot() {
        return BotJDA;
    }

}
