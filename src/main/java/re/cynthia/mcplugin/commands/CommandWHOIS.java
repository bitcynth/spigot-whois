package re.cynthia.mcplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import re.cynthia.mcplugin.utils.WHOIS;

import java.io.IOException;

public class CommandWHOIS implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            sender.sendMessage(WHOIS.query(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
