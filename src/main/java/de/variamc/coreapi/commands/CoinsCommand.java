package de.variamc.coreapi.commands;

import de.variamc.coreapi.CoreAPI;
import de.variamc.coreapi.coins.CoinAPI;
import de.variamc.coreapi.language.LanguageAPI;
import org.apache.commons.lang3.LocaleUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Class created by Kaseax on 2022
 */
public class CoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // /coins <arg> <player> <amount>
        Player player = (Player) sender;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("lang.core", Objects.requireNonNull(LocaleUtils.toLocale(LanguageAPI.getLanguage(player.getUniqueId().toString()))));
        if(sender.hasPermission("variamc.coins.*")) {
            if(args.length >= 3) {
                Player target = Bukkit.getPlayer(args[1]);
                if(target != null) {
                    String uuid = target.getUniqueId().toString();
                    try {
                        int amount = Integer.parseInt(args[2]);
                        switch (args[0]) {
                            case "add":
                                CoinAPI.addCoins(uuid, amount);
                                resourceBundle.getString("coins-added");
                                sender.sendMessage(CoreAPI.getPrefix() + resourceBundle.getString("coins-added").replaceAll("\\{player}", target.getName()).replaceAll("\\{amount}", String.valueOf(amount)));
                                break;
                            case "remove":
                                CoinAPI.removeCoins(uuid, amount);
                                resourceBundle.getString("coins-removed");
                                sender.sendMessage(CoreAPI.getPrefix() + resourceBundle.getString("coins-removed").replaceAll("\\{player}", target.getName()).replaceAll("\\{amount}", String.valueOf(amount)));
                                break;
                            case "set":
                                CoinAPI.setCoins(uuid, amount);
                                resourceBundle.getString("coins-set");
                                sender.sendMessage(CoreAPI.getPrefix() + resourceBundle.getString("coins-set").replaceAll("\\{player}", target.getName()).replaceAll("\\{amount}", String.valueOf(amount)));
                                break;
                            case "reset":
                                CoinAPI.resetCoins(uuid);
                                resourceBundle.getString("coins-reset");
                                sender.sendMessage(CoreAPI.getPrefix() + resourceBundle.getString("coins-reset").replaceAll("\\{player}", target.getName()));
                                break;
                            default:
                                sender.sendMessage(CoreAPI.getPrefix() + resourceBundle.getString("coins-usage"));
                                break;
                        }
                    } catch (NumberFormatException e) {
                        sender.sendMessage(CoreAPI.getPrefix() + resourceBundle.getString("coins-no-number"));
                    }
                } else {
                    sender.sendMessage(CoreAPI.getPrefix() + resourceBundle.getString("coins-offline-player"));
                }
            } else {
                int coins = CoinAPI.getCoins(player.getUniqueId().toString());
                sender.sendMessage(CoreAPI.getPrefix() + resourceBundle.getString("coins-display").replaceAll("\\{amount}", String.valueOf(coins)));
            }
        }
        return false;
    }
}
