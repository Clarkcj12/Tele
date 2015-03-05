package me.Clarkcj.tele;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class tele
  extends JavaPlugin
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static tele plugin;
  
  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Has Been Disabled!");
  }
  
  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
    if (commandLabel.equalsIgnoreCase("clarkport")) {
      if (args.length == 0)
      {
        player.sendMessage(ChatColor.DARK_RED + "TOO LITTLE ARGUMENTS!");
      }
      else if (args.length == 1)
      {
        Player targetPlayer = player.getServer().getPlayer(args[0]);
        Location targetPlayerLocation = targetPlayer.getLocation();
        player.teleport(targetPlayerLocation);
      }
      else if (args.length == 2)
      {
        Player targetPlayer = player.getServer().getPlayer(args[0]);
        Player targetPlayer1 = player.getServer().getPlayer(args[1]);
        Location targetPlayer1Location = targetPlayer1.getLocation();
        targetPlayer.teleport(targetPlayer1Location);
      }
    }
    return false;
  }
}
