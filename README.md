## BotAPI
```Java
public static void main(String[] args) {
  Bot bot = new Bot("<TOKEN>");
  bot.setGame("<GAME>");
  bot.setStatus(OnlineStatus.ONLINE);
  bot.setPrefix("<PREFIX>");
  
  bot.addCommand("<COMMAND>", new Command() {
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
```

