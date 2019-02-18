package com.minexd.zoot.profile.option.command;

import com.minexd.zoot.Locale;
import com.minexd.zoot.profile.Profile;
import com.qrakn.honcho.command.CommandMeta;
import org.bukkit.entity.Player;

@CommandMeta(label = { "togglesounds", "sounds" })
public class ToggleSoundsCommand {

    public void execute(Player player) {
        Profile profile = Profile.getByUuid(player.getUniqueId());
        profile.getOptions().playingMessageSounds(!profile.getOptions().playingMessageSounds());

        if (profile.getOptions().playingMessageSounds()) {
            player.sendMessage(Locale.OPTIONS_PRIVATE_MESSAGE_SOUND_ENABLED.format());
        } else {
            player.sendMessage(Locale.OPTIONS_PRIVATE_MESSAGE_SOUND_DISABLED.format());
        }
    }

}
