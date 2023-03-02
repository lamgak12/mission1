package api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import wifi.ApiDBService;
import wifi.WifiDTO;

public class apitest {

    public static final int cnt = 1000;
    public static final String URL = "http://openapi.seoul.go.kr:8088/sample/json/TbPublicWifiInfo/1/1";

    public static void loadWifi() throws IOException{

        int listTotalCount = getTotalCountOfList();
        int loopCount = listTotalCount / cnt + 1;

        for (int i = 0, j = 1; i < loopCount; i++, j += cnt) {
            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
            urlBuilder.append("/" + URLEncoder.encode("794b6c5266746e74313133576f684572","UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("json","UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo","UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(String.valueOf(j), "UTF-8"));
            urlBuilder.append("/" + URLEncoder.encode(String.valueOf(j + cnt - 1),"UTF-8"));

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd;
            if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();
            conn.disconnect();

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(sb.toString());
            JsonObject tbPublicWifiInfo = element.getAsJsonObject().get("TbPublicWifiInfo").getAsJsonObject();
            JsonArray rows = tbPublicWifiInfo.get("row").getAsJsonArray();

            for (JsonElement row : rows) {
                WifiDTO dto = new WifiDTO();
                String X_SWIFI_MGR_NO = row.getAsJsonObject().get("X_SWIFI_MGR_NO").getAsString();
                dto.setX_SWIFI_MGR_NO(X_SWIFI_MGR_NO);

                String X_SWIFI_WRDOFC = row.getAsJsonObject().get("X_SWIFI_WRDOFC").getAsString();
                dto.setX_SWIFI_WRDOFC(X_SWIFI_WRDOFC);

                String MAIN_NM = row.getAsJsonObject().get("X_SWIFI_MAIN_NM").getAsString();
                dto.setX_SWIFI_MAIN_NM(MAIN_NM);

                String ADRES1 = row.getAsJsonObject().get("X_SWIFI_ADRES1").getAsString();
                dto.setX_SWIFI_ADRES1(ADRES1);

                String ADRES2 = row.getAsJsonObject().get("X_SWIFI_ADRES2").getAsString();
                dto.setX_SWIFI_ADRES2(ADRES2);

                String INSTL_FLOOR = row.getAsJsonObject().get("X_SWIFI_INSTL_FLOOR").getAsString();
                dto.setX_SWIFI_INSTL_FLOOR(INSTL_FLOOR);

                String INSTL_TY = row.getAsJsonObject().get("X_SWIFI_INSTL_TY").getAsString();
                dto.setX_SWIFI_INSTL_TY(INSTL_TY);

                String INSTL_MBY = row.getAsJsonObject().get("X_SWIFI_INSTL_MBY").getAsString();
                dto.setX_SWIFI_INSTL_MBY(INSTL_MBY);

                String SVC_SE = row.getAsJsonObject().get("X_SWIFI_SVC_SE").getAsString();
                dto.setX_SWIFI_SVC_SE(SVC_SE);

                String CMCWR = row.getAsJsonObject().get("X_SWIFI_CMCWR").getAsString();
                dto.setX_SWIFI_CMCWR(CMCWR);

                String CNSTC_YEAR = row.getAsJsonObject().get("X_SWIFI_CNSTC_YEAR").getAsString();
                dto.setX_SWIFI_CNSTC_YEAR(CNSTC_YEAR);

                String INOUT_DOOR = row.getAsJsonObject().get("X_SWIFI_INOUT_DOOR").getAsString();
                dto.setX_SWIFI_INOUT_DOOR(INOUT_DOOR);

                String REMARS3 = row.getAsJsonObject().get("X_SWIFI_REMARS3").getAsString();
                dto.setX_SWIFI_REMARS3(REMARS3);

                Double LAT = row.getAsJsonObject().get("LAT").getAsDouble();
                dto.setLAT(LAT);

                Double LNT = row.getAsJsonObject().get("LNT").getAsDouble();
                dto.setLNT(LNT);

                String WORK_DTTM = row.getAsJsonObject().get("WORK_DTTM").getAsString();
                dto.setWORK_DTTM(WORK_DTTM);

                ApiDBService.insert(dto);

            }
        }
    }

    public static int getTotalCountOfList() throws IOException {

        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(sb.toString());
        JsonObject tbPublicWifiInfo = element.getAsJsonObject().get("TbPublicWifiInfo").getAsJsonObject();
        int listTotalCount = tbPublicWifiInfo.getAsJsonObject().get("list_total_count").getAsInt();
        System.out.println(listTotalCount);
        return listTotalCount;
    }

}
