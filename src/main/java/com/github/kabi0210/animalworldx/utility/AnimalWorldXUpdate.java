package com.github.kabi0210.animalworldx.utility;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraftforge.fml.common.versioning.ComparableVersion;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author KSGFK create in 2019/10/21
 */
public class AnimalWorldXUpdate implements Runnable {
    private final Logger logger;
    private boolean canUpdate;
    private String latest;
    private String latestPre;

    public AnimalWorldXUpdate() {
        logger = AnimalWorldX.getLogger();
    }

    private void getUpdateJson() {
        StringBuilder result = new StringBuilder();
        try {
            URL apiUrl = new URL(AnimalWorldX.UPDATE);
            HttpsURLConnection connection = (HttpsURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.getResponseCode();
            InputStreamReader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
        JsonArray elements = new JsonParser().parse(result.toString()).getAsJsonArray();
        for (JsonElement e : elements) {
            JsonObject jsonObject = e.getAsJsonObject();
            String versionString = jsonObject.get("tag_name").getAsString();
            boolean prerelease = jsonObject.get("prerelease").getAsBoolean();
            ComparableVersion latest = new ComparableVersion(versionString);
            ComparableVersion now = new ComparableVersion(AnimalWorldX.VERSION);
            if (latest.compareTo(now) > 0) {
                if (prerelease) {
                    latestPre = versionString;
                } else {
                    this.latest = versionString;
                    canUpdate = true;
                }
            }
        }
        String r = "最新:" + latest + "\tPre:" + latestPre;
        if (canUpdate) {
            logger.warn("发现更新!" + r);
        } else {
            logger.info(r);
        }
    }

    public boolean isCanUpdate() {
        return canUpdate;
    }

    public String getLatest() {
        return latest;
    }

    public String getLatestPre() {
        return latestPre;
    }

    @Override
    public void run() {
        getUpdateJson();
    }
}
