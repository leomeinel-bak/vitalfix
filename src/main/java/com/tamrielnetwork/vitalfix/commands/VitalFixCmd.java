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

package com.tamrielnetwork.vitalfix.commands;

import com.tamrielnetwork.vitalfix.utils.commands.Cmd;
import com.tamrielnetwork.vitalfix.utils.commands.CmdSpec;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class VitalFixCmd implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

		if (Cmd.isArgsLengthNotEqualTo(sender, args, 0)) {
			return true;
		}
		doFix(sender);
		return true;

	}

	private void doFix(@NotNull CommandSender sender) {

		if (CmdSpec.isInvalidCmd(sender, "vitalfix.fix")) {
			return;
		}

		Player senderPlayer = (Player) sender;

		CmdSpec.doFix(senderPlayer);

	}

}