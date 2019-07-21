package re.cynthia.mcplugin;

import org.bukkit.plugin.java.JavaPlugin;
import re.cynthia.mcplugin.commands.CommandCMR;
import re.cynthia.mcplugin.commands.CommandWHOIS;

public class CMRPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Meow!");
        this.getCommand("cmr").setExecutor(new CommandCMR());
        this.getCommand("whois").setExecutor(new CommandWHOIS());
    }

    @Override
    public void onDisable() {
        getLogger().info("Nyaa!");
    }

}
