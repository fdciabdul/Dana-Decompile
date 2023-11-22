package androidx.room;

/* loaded from: classes6.dex */
public class RoomMasterTable {
    public static String MyBillsEntityDataFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '");
        sb.append(str);
        sb.append("')");
        return sb.toString();
    }

    private RoomMasterTable() {
    }
}
