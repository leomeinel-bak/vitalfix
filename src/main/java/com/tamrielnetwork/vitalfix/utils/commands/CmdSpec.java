/*
 * VitalFix is a Spigot Plugin that gives players the ability to fix their tools & armor.
 * Copyright © 2022 Leopold Meinel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/TamrielNetwork/VitalFix/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalfix.utils.commands;

import com.tamrielnetwork.vitalfix.utils.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class CmdSpec {

	public static void doFix(@NotNull Player senderPlayer) {

		Inventory senderInventory = senderPlayer.getInventory();
		ItemStack[] inventoryItemStacks = senderInventory.getContents();

		for (ItemStack itemStack : inventoryItemStacks) {

			if (itemStack == null) {
				continue;
			}

			ItemMeta itemMeta = itemStack.getItemMeta();

			if (!(itemMeta instanceof Damageable itemDamageable)) {
				continue;
			}

			if (!(itemDamageable.hasDamage())) {
				continue;
			}

			Chat.sendMessage(senderPlayer, "repaired");

			itemDamageable.setDamage(0);
			itemStack.setItemMeta(itemDamageable);
		}
	}

	public static boolean isInvalidCmd(@NotNull CommandSender sender, @NotNull String perm) {

		if (Cmd.isInvalidSender(sender)) {
			return true;
		}
		return Cmd.isNotPermitted(sender, perm);
	}

}
