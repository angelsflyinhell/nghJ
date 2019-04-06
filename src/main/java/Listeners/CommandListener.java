package Listeners;

import Utility.CommandHandler;
import Utility.Config;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.Objects;

public class CommandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().startsWith(Config.PREFIX)
                && !Objects.equals(event.getMessage().getAuthor().getId(), event.getJDA().getSelfUser().getId())
                && !event.getMessage().getAuthor().isBot()
                && event.getMessage().getTextChannel().isNSFW())
        {

            CommandHandler.handleCommand(CommandHandler.parse.parser(event.getMessage().getContentRaw(), event, Config.PREFIX));

        } else {
            return;
        }

    }
}
