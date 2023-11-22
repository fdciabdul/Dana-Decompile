package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class CursorUtil {
    public static Cursor MyBillsEntityDataFactory(Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    int type = cursor.getType(i);
                    if (type == 0) {
                        objArr[i] = null;
                    } else if (type == 1) {
                        objArr[i] = Long.valueOf(cursor.getLong(i));
                    } else if (type == 2) {
                        objArr[i] = Double.valueOf(cursor.getDouble(i));
                    } else if (type == 3) {
                        objArr[i] = cursor.getString(i);
                    } else if (type == 4) {
                        objArr[i] = cursor.getBlob(i);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("`");
        sb.append(str);
        sb.append("`");
        int columnIndex2 = cursor.getColumnIndex(sb.toString());
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(".");
        sb2.append(str);
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(".");
        sb3.append(str);
        sb3.append("`");
        String obj2 = sb3.toString();
        for (int i = 0; i < columnNames.length; i++) {
            String str2 = columnNames[i];
            if (str2.length() >= str.length() + 2) {
                if (str2.endsWith(obj)) {
                    return i;
                }
                if (str2.charAt(0) == '`' && str2.endsWith(obj2)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getAuthRequestContext(Cursor cursor, String str) {
        String str2;
        int KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(cursor, str);
        if (KClassImpl$Data$declaredNonStaticMembers$2 >= 0) {
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
        try {
            str2 = Arrays.toString(cursor.getColumnNames());
        } catch (Exception e) {
            InstrumentInjector.log_d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            str2 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("column '");
        sb.append(str);
        sb.append("' does not exist. Available columns: ");
        sb.append(str2);
        throw new IllegalArgumentException(sb.toString());
    }

    private CursorUtil() {
    }
}
