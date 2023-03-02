package wifi;

import java.sql.*;

public class ApiDBService {

public static void insert(WifiDTO wifiDto) {

    Connection conn=null;
    try {

        Class.forName("org.sqlite.JDBC");
        String file="C:\\Program Files\\SQLiteStudio\\test";
        conn=DriverManager.getConnection("jdbc:sqlite:" + file);

        String sql = "INSERT INTO wifi ('X_SWIFI_MGR_NO','X_SWIFI_MAIN_NM','X_SWIFI_WRDOFC',"
                   + "'X_SWIFI_ADRES1','X_SWIFI_ADRES2','X_SWIFI_INSTL_FLOOR','X_SWIFI_INSTL_MBY','X_SWIFI_INSTL_TY',"
                   + "'X_SWIFI_SVC_SE','X_SWIFI_CMCWR','X_SWIFI_CNSTC_YEAR','X_SWIFI_INOUT_DOOR','X_SWIFI_REMARS3','LNT','LAT','WORK_DTTM')"
                   + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement pst  = conn.prepareStatement(sql);
            pst.setString(1, wifiDto.getX_SWIFI_MGR_NO());
            pst.setString(2, wifiDto.getX_SWIFI_MAIN_NM());
            pst.setString(3, wifiDto.getX_SWIFI_WRDOFC());
            pst.setString(4, wifiDto.getX_SWIFI_ADRES1());
            pst.setString(5, wifiDto.getX_SWIFI_ADRES2());
            pst.setString(6, wifiDto.getX_SWIFI_INSTL_FLOOR());
            pst.setString(7, wifiDto.getX_SWIFI_INSTL_MBY());
            pst.setString(8, wifiDto.getX_SWIFI_INSTL_TY());
            pst.setString(9, wifiDto.getX_SWIFI_SVC_SE());
            pst.setString(10, wifiDto.getX_SWIFI_CMCWR());
            pst.setString(11, wifiDto.getX_SWIFI_CNSTC_YEAR());
            pst.setString(12, wifiDto.getX_SWIFI_INOUT_DOOR());
            pst.setString(13, wifiDto.getX_SWIFI_REMARS3());
            pst.setDouble(14, wifiDto.getLNT());
            pst.setDouble(15, wifiDto.getLAT());
            pst.setString(16, wifiDto.getWORK_DTTM());
            pst.executeUpdate();

    }catch(Exception e) {
        System.out.println(e);
        e.printStackTrace();
        }
    }
}
