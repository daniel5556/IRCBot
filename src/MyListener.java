import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.lang.Object;

import org.pircbotx.Colors;

public class MyListener extends ListenerAdapter {
        @Override
        public void onGenericMessage(GenericMessageEvent event) {
                if (event.getMessage().startsWith("!site"))
                	event.getUser().send().notice(Colors.BOLD + Colors.GREEN + "Our forums are located at:" + Colors.BOLD + Colors.CYAN +" http://rs-descent.com");
                if (event.getMessage().startsWith("!reqs"))
                	event.getUser().send().notice(Colors.BOLD + Colors.GREEN + "Descent's current requirements are:" + Colors.BOLD + Colors.CYAN +" 110+ Cmb, 90+ Rng or 70+ Mage, 60+ Pray");
                if (event.getMessage().startsWith("!apply"))
                	event.getUser().send().notice(Colors.BOLD + Colors.GREEN + "You can apply to join Descent at:" + Colors.BOLD + Colors.CYAN +" http://rs-descent.com/index.php?/forum/27-applications/");
                if (event.getMessage().startsWith("@site"))
                	event.respond(Colors.BOLD + Colors.GREEN + "Our forums are located at:" + Colors.BOLD + Colors.CYAN +" http://rs-descent.com");
                if (event.getMessage().startsWith("@reqs"))
                	event.respond(Colors.BOLD + Colors.GREEN + "Descent's current requirements are:" + Colors.BOLD + Colors.CYAN +" 110+ Cmb, 90+ Rng or 70+ Mage, 60+ Pray");
                if (event.getMessage().startsWith("@apply"))
                	event.respond(Colors.BOLD + Colors.GREEN + "You can apply to join Descent at:" + Colors.BOLD + Colors.CYAN +" http://rs-descent.com/index.php?/forum/27-applications/");
                if (event.getMessage().startsWith("!shutdowngreenbot")){
                	event.getUser().send().notice("Shutting down GreenBot");
                	System.exit(0);
                }
                
        }
        
        @Override
        public void onJoin(JoinEvent event) {
        	event.getUser().send().notice("Welcome to Descent's IRC. Commands: !site - Website, !reqs - Current Requirements, !apply - Link to Applications");
        }

        public static void main(String[] args) throws Exception {
                Configuration configuration = new Configuration.Builder()
                                .setName("GreenBot")
                                .setLogin("GreenBot")
                                .setNickservPassword("greenbot123")
                                .setServerHostname("irc.swiftirc.net")
                                .addAutoJoinChannel("#descent")
                                .addListener(new MyListener())
                                .buildConfiguration();

                PircBotX bot = new PircBotX(configuration);
                
                bot.startBot();
                
        }
}