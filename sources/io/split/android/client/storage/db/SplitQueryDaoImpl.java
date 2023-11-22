package io.split.android.client.storage.db;

import android.database.Cursor;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class SplitQueryDaoImpl implements SplitQueryDao {
    private final SplitRoomDatabase mDatabase;

    public SplitQueryDaoImpl(SplitRoomDatabase splitRoomDatabase) {
        this.mDatabase = splitRoomDatabase;
    }

    @Override // io.split.android.client.storage.db.SplitQueryDao
    public List<SplitEntity> get(long j, int i) {
        Cursor query = this.mDatabase.query("SELECT rowid, name, body, updated_at FROM splits WHERE rowId > ? ORDER BY rowId LIMIT ?", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        try {
            try {
                int columnIndexOrThrow = getColumnIndexOrThrow(query, "rowid");
                int columnIndexOrThrow2 = getColumnIndexOrThrow(query, "name");
                int columnIndexOrThrow3 = getColumnIndexOrThrow(query, "body");
                int columnIndexOrThrow4 = getColumnIndexOrThrow(query, "updated_at");
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    SplitEntity splitEntity = new SplitEntity();
                    splitEntity.setRowId(query.getLong(columnIndexOrThrow));
                    splitEntity.setName(query.getString(columnIndexOrThrow2));
                    splitEntity.setBody(query.getString(columnIndexOrThrow3));
                    splitEntity.setUpdatedAt(query.getLong(columnIndexOrThrow4));
                    arrayList.add(splitEntity);
                }
                return arrayList;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error executing splits query: ");
                sb.append(e.getLocalizedMessage());
                Logger.e(sb.toString());
                query.close();
                return new ArrayList();
            }
        } finally {
            query.close();
        }
    }

    int getColumnIndexOrThrow(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("`");
        sb.append(str);
        sb.append("`");
        return cursor.getColumnIndexOrThrow(sb.toString());
    }
}
