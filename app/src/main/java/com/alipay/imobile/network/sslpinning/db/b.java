package com.alipay.imobile.network.sslpinning.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class b implements com.alipay.imobile.network.sslpinning.db.a {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f7090a;
    private final EntityInsertionAdapter b;

    /* loaded from: classes6.dex */
    class a extends EntityInsertionAdapter<c> {
        a(b bVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a  reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, c cVar) {
            String str = cVar.f7091a;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            byte[] a2 = d.a(cVar.b);
            if (a2 == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindBlob(2, a2);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `certificate`(`certificateUrl`,`certificateData`) VALUES (?,?)";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.f7090a = roomDatabase;
        this.b = new a(this, roomDatabase);
    }

    @Override // com.alipay.imobile.network.sslpinning.db.a
    public void a(List<c> list) {
        this.f7090a.beginTransaction();
        try {
            this.b.insert((Iterable) list);
            this.f7090a.setTransactionSuccessful();
        } finally {
            this.f7090a.endTransaction();
        }
    }

    @Override // com.alipay.imobile.network.sslpinning.db.a
    public List<c> a() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM certificate", 0);
        Cursor query = this.f7090a.query(authRequestContext);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("certificateUrl");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("certificateData");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new c(query.getString(columnIndexOrThrow), d.a(query.getBlob(columnIndexOrThrow2))));
            }
            return arrayList;
        } finally {
            query.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }
}
