package com.webstaurantstore.utils;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class JsonReader {
    public static Object[][] getdata(String JSON_path, String typeData)
            throws JsonIOException, JsonSyntaxException, FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObj = jsonParser.parse(new FileReader(JSON_path)).getAsJsonObject();
        JsonArray array = (JsonArray) jsonObj.get(typeData);
        return searchJsonElement(array);
    }

    private static Object[][] searchJsonElement(JsonArray jsonArray) throws NullPointerException {
        int jsonRowCount = jsonArray.size();
        int jsonElementCount = 0;
        for (JsonElement jsonElement : jsonArray) {
            jsonElementCount = jsonElement.getAsJsonObject().entrySet().size();
        }
        Object[][] dataSet = new Object[jsonRowCount][jsonElementCount];
        int i = 0;
        int j = 0;
        for (JsonElement jsonElement : jsonArray) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                dataSet[i][j] = entry.getValue().getAsString();
                j++;
            }
            i++;
            j = 0;
        }
        return dataSet;
    }
}
