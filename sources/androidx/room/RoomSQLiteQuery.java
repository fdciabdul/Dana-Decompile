package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes6.dex */
public class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    static final TreeMap<Integer, RoomSQLiteQuery> BuiltInFictitiousFunctionClassFactory = new TreeMap<>();
    final double[] KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    final long[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    final int PlaceComponentResult;
    final byte[][] getAuthRequestContext;
    private final int[] getErrorConfigVersion;
    final String[] lookAheadTest;
    private volatile String moveToNextValue;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: androidx.room.RoomSQLiteQuery$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements SupportSQLiteProgram {
        final /* synthetic */ RoomSQLiteQuery getAuthRequestContext;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int i) {
            this.getAuthRequestContext.bindNull(i);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int i, long j) {
            this.getAuthRequestContext.bindLong(i, j);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int i, double d) {
            this.getAuthRequestContext.bindDouble(i, d);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int i, String str) {
            this.getAuthRequestContext.bindString(i, str);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int i, byte[] bArr) {
            this.getAuthRequestContext.bindBlob(i, bArr);
        }
    }

    public static RoomSQLiteQuery getAuthRequestContext(String str, int i) {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = BuiltInFictitiousFunctionClassFactory;
        synchronized (treeMap) {
            Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                treeMap.remove(ceilingEntry.getKey());
                RoomSQLiteQuery value = ceilingEntry.getValue();
                value.moveToNextValue = str;
                value.MyBillsEntityDataFactory = i;
                return value;
            }
            RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i);
            roomSQLiteQuery.moveToNextValue = str;
            roomSQLiteQuery.MyBillsEntityDataFactory = i;
            return roomSQLiteQuery;
        }
    }

    private RoomSQLiteQuery(int i) {
        this.PlaceComponentResult = i;
        int i2 = i + 1;
        this.getErrorConfigVersion = new int[i2];
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new long[i2];
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new double[i2];
        this.lookAheadTest = new String[i2];
        this.getAuthRequestContext = new byte[i2];
    }

    public final void MyBillsEntityDataFactory() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = BuiltInFictitiousFunctionClassFactory;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.PlaceComponentResult), this);
            TreeMap<Integer, RoomSQLiteQuery> treeMap2 = BuiltInFictitiousFunctionClassFactory;
            if (treeMap2.size() > 15) {
                Iterator<Integer> it = treeMap2.descendingKeySet().iterator();
                for (int size = treeMap2.size() - 10; size > 0; size--) {
                    it.next();
                    it.remove();
                }
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final int getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void getAuthRequestContext(SupportSQLiteProgram supportSQLiteProgram) {
        for (int i = 1; i <= this.MyBillsEntityDataFactory; i++) {
            int i2 = this.getErrorConfigVersion[i];
            if (i2 == 1) {
                supportSQLiteProgram.bindNull(i);
            } else if (i2 == 2) {
                supportSQLiteProgram.bindLong(i, this.NetworkUserEntityData$$ExternalSyntheticLambda0[i]);
            } else if (i2 == 3) {
                supportSQLiteProgram.bindDouble(i, this.KClassImpl$Data$declaredNonStaticMembers$2[i]);
            } else if (i2 == 4) {
                supportSQLiteProgram.bindString(i, this.lookAheadTest[i]);
            } else if (i2 == 5) {
                supportSQLiteProgram.bindBlob(i, this.getAuthRequestContext[i]);
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int i) {
        this.getErrorConfigVersion[i] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int i, long j) {
        this.getErrorConfigVersion[i] = 2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0[i] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int i, double d) {
        this.getErrorConfigVersion[i] = 3;
        this.KClassImpl$Data$declaredNonStaticMembers$2[i] = d;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int i, String str) {
        this.getErrorConfigVersion[i] = 4;
        this.lookAheadTest[i] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int i, byte[] bArr) {
        this.getErrorConfigVersion[i] = 5;
        this.getAuthRequestContext[i] = bArr;
    }
}
