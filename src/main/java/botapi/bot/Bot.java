package botapi.bot;

public class Bot {

    JDABuilder jda;

    public Bot(String token) {
        jda = new JDABuilder(AccountType.BOT);
        jda.setToken(token);
    }

    public void setGame() {

    }

}
