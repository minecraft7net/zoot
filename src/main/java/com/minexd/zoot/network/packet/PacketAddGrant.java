package com.minexd.zoot.network.packet;

import com.google.gson.JsonObject;
import com.minexd.zoot.pidgin.packet.Packet;
import com.minexd.zoot.profile.grant.Grant;
import com.minexd.zoot.util.json.JsonChain;
import java.util.UUID;
import lombok.Getter;

public class PacketAddGrant implements Packet {

	@Getter private UUID playerUuid;
	@Getter private Grant grant;

	public PacketAddGrant() {

	}

	public PacketAddGrant(UUID playerUuid, Grant grant) {
		this.playerUuid = playerUuid;
		this.grant = grant;
	}

	@Override
	public int id() {
		return 1;
	}

	@Override
	public JsonObject serialize() {
		return new JsonChain()
				.addProperty("playerUuid", playerUuid.toString())
				.add("grant", Grant.SERIALIZER.serialize(grant))
				.get();
	}

	@Override
	public void deserialize(JsonObject jsonObject) {
		playerUuid = UUID.fromString(jsonObject.get("playerUuid").getAsString());
		grant = Grant.DESERIALIZER.deserialize(jsonObject.get("grant").getAsJsonObject());
	}

}
