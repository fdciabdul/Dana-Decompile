package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* loaded from: classes3.dex */
public class InvalidationTracker {
    private static final String[] DatabaseTableConfigUtil = {"UPDATE", "DELETE", "INSERT"};
    public final InvalidationLiveDataContainer BuiltInFictitiousFunctionClassFactory;
    AutoCloser KClassImpl$Data$declaredNonStaticMembers$2;
    volatile SupportSQLiteStatement MyBillsEntityDataFactory;
    ObservedTableTracker NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Map<String, Set<String>> NetworkUserEntityData$$ExternalSyntheticLambda1;
    final String[] NetworkUserEntityData$$ExternalSyntheticLambda2;
    volatile boolean PlaceComponentResult;
    final RoomDatabase getAuthRequestContext;
    AtomicBoolean getErrorConfigVersion;
    public final HashMap<String, Integer> initRecordTimeStamp;
    final SafeIterableMap<Observer, ObserverWrapper> lookAheadTest;
    Runnable moveToNextValue;
    MultiInstanceInvalidationClient scheduleImpl;

    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, new HashMap(), Collections.emptyMap(), strArr);
    }

    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getErrorConfigVersion = new AtomicBoolean(false);
        this.PlaceComponentResult = false;
        this.lookAheadTest = new SafeIterableMap<>();
        this.moveToNextValue = new Runnable() { // from class: androidx.room.InvalidationTracker.1
            /* JADX WARN: Code restructure failed: missing block: B:102:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
            
                if (r11.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 != null) goto L47;
             */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
            
                if (r11.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 != null) goto L47;
             */
            /* JADX WARN: Code restructure failed: missing block: B:47:0x00a4, code lost:
            
                r11.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
             */
            /* JADX WARN: Code restructure failed: missing block: B:48:0x00ab, code lost:
            
                if (r5 == null) goto L74;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:0x00b1, code lost:
            
                if (r5.isEmpty() != false) goto L102;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x00b3, code lost:
            
                r0 = r11.MyBillsEntityDataFactory.lookAheadTest;
             */
            /* JADX WARN: Code restructure failed: missing block: B:52:0x00b7, code lost:
            
                monitor-enter(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:53:0x00b8, code lost:
            
                r4 = r11.MyBillsEntityDataFactory.lookAheadTest.iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
            
                if (r4.hasNext() == false) goto L90;
             */
            /* JADX WARN: Code restructure failed: missing block: B:56:0x00c6, code lost:
            
                r6 = r4.next().getValue();
                r7 = r6.MyBillsEntityDataFactory.length;
                r9 = null;
                r8 = 0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:57:0x00d7, code lost:
            
                if (r8 >= r7) goto L95;
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x00e5, code lost:
            
                if (r5.contains(java.lang.Integer.valueOf(r6.MyBillsEntityDataFactory[r8])) == false) goto L97;
             */
            /* JADX WARN: Code restructure failed: missing block: B:60:0x00e7, code lost:
            
                if (r7 != 1) goto L62;
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x00e9, code lost:
            
                r9 = r6.PlaceComponentResult;
             */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x00ec, code lost:
            
                if (r9 != null) goto L64;
             */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x00ee, code lost:
            
                r9 = new java.util.HashSet<>(r7);
             */
            /* JADX WARN: Code restructure failed: missing block: B:64:0x00f3, code lost:
            
                r9.add(r6.BuiltInFictitiousFunctionClassFactory[r8]);
             */
            /* JADX WARN: Code restructure failed: missing block: B:65:0x00fa, code lost:
            
                r8 = r8 + 1;
             */
            /* JADX WARN: Code restructure failed: missing block: B:66:0x00fd, code lost:
            
                if (r9 == null) goto L93;
             */
            /* JADX WARN: Code restructure failed: missing block: B:67:0x00ff, code lost:
            
                r6.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(r9);
             */
            /* JADX WARN: Code restructure failed: missing block: B:69:0x0105, code lost:
            
                monitor-exit(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:70:0x0106, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x010a, code lost:
            
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 286
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.AnonymousClass1.run():void");
            }

            private Set<Integer> getAuthRequestContext() {
                HashSet hashSet = new HashSet();
                Cursor query = InvalidationTracker.this.getAuthRequestContext.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
                while (query.moveToNext()) {
                    try {
                        hashSet.add(Integer.valueOf(query.getInt(0)));
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                query.close();
                if (!hashSet.isEmpty()) {
                    InvalidationTracker.this.MyBillsEntityDataFactory.executeUpdateDelete();
                }
                return hashSet;
            }
        };
        this.getAuthRequestContext = roomDatabase;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ObservedTableTracker(strArr.length);
        this.initRecordTimeStamp = new HashMap<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = map2;
        this.BuiltInFictitiousFunctionClassFactory = new InvalidationLiveDataContainer(roomDatabase);
        int length = strArr.length;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = strArr[i].toLowerCase(Locale.US);
            this.initRecordTimeStamp.put(lowerCase, Integer.valueOf(i));
            String str = map.get(strArr[i]);
            if (str != null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2[i] = str.toLowerCase(Locale.US);
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2[i] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.US);
            if (this.initRecordTimeStamp.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(Locale.US);
                HashMap<String, Integer> hashMap = this.initRecordTimeStamp;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2[i];
        StringBuilder sb = new StringBuilder();
        for (String str2 : DatabaseTableConfigUtil) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            BuiltInFictitiousFunctionClassFactory(sb, str, str2);
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    private void PlaceComponentResult(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT OR IGNORE INTO room_table_modification_log VALUES(");
        sb.append(i);
        sb.append(", 0)");
        supportSQLiteDatabase.execSQL(sb.toString());
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2[i];
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : DatabaseTableConfigUtil) {
            sb2.setLength(0);
            sb2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            BuiltInFictitiousFunctionClassFactory(sb2, str, str2);
            sb2.append(" AFTER ");
            sb2.append(str2);
            sb2.append(" ON `");
            sb2.append(str);
            sb2.append("` BEGIN UPDATE ");
            sb2.append("room_table_modification_log");
            sb2.append(" SET ");
            sb2.append("invalidated");
            sb2.append(" = 1");
            sb2.append(" WHERE ");
            sb2.append("table_id");
            sb2.append(" = ");
            sb2.append(i);
            sb2.append(" AND ");
            sb2.append("invalidated");
            sb2.append(" = 0");
            sb2.append("; END");
            supportSQLiteDatabase.execSQL(sb2.toString());
        }
    }

    public final void MyBillsEntityDataFactory(Observer observer) {
        ObserverWrapper BuiltInFictitiousFunctionClassFactory;
        String[] BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(observer.MyBillsEntityDataFactory);
        int[] iArr = new int[BuiltInFictitiousFunctionClassFactory2.length];
        int length = BuiltInFictitiousFunctionClassFactory2.length;
        for (int i = 0; i < length; i++) {
            Integer num = this.initRecordTimeStamp.get(BuiltInFictitiousFunctionClassFactory2[i].toLowerCase(Locale.US));
            if (num == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("There is no table with name ");
                sb.append(BuiltInFictitiousFunctionClassFactory2[i]);
                throw new IllegalArgumentException(sb.toString());
            }
            iArr[i] = num.intValue();
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, BuiltInFictitiousFunctionClassFactory2);
        synchronized (this.lookAheadTest) {
            BuiltInFictitiousFunctionClassFactory = this.lookAheadTest.BuiltInFictitiousFunctionClassFactory(observer, observerWrapper);
        }
        if (BuiltInFictitiousFunctionClassFactory == null && this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory(iArr) && this.getAuthRequestContext.isOpen()) {
            BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getOpenHelper().getWritableDatabase());
        }
    }

    public final String[] BuiltInFictitiousFunctionClassFactory(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.containsKey(lowerCase)) {
                hashSet.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void getAuthRequestContext(Observer observer) {
        ObserverWrapper KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (this.lookAheadTest) {
            KClassImpl$Data$declaredNonStaticMembers$2 = this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(observer);
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null && this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory) && this.getAuthRequestContext.isOpen()) {
            BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getOpenHelper().getWritableDatabase());
        }
    }

    final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.getAuthRequestContext.isOpen()) {
            if (!this.PlaceComponentResult) {
                this.getAuthRequestContext.getOpenHelper().getWritableDatabase();
            }
            if (this.PlaceComponentResult) {
                return true;
            }
            InstrumentInjector.log_e("ROOM", "database is not initialized even though it is open");
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.inTransaction()) {
            return;
        }
        while (true) {
            try {
                Lock closeLock = this.getAuthRequestContext.getCloseLock();
                closeLock.lock();
                try {
                    int[] BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory();
                    if (BuiltInFictitiousFunctionClassFactory == null) {
                        return;
                    }
                    int length = BuiltInFictitiousFunctionClassFactory.length;
                    if (Build.VERSION.SDK_INT >= 16 && supportSQLiteDatabase.isWriteAheadLoggingEnabled()) {
                        supportSQLiteDatabase.beginTransactionNonExclusive();
                    } else {
                        supportSQLiteDatabase.beginTransaction();
                    }
                    for (int i = 0; i < length; i++) {
                        try {
                            int i2 = BuiltInFictitiousFunctionClassFactory[i];
                            if (i2 == 1) {
                                PlaceComponentResult(supportSQLiteDatabase, i);
                            } else if (i2 == 2) {
                                MyBillsEntityDataFactory(supportSQLiteDatabase, i);
                            }
                        } catch (Throwable th) {
                            supportSQLiteDatabase.endTransaction();
                            throw th;
                        }
                    }
                    supportSQLiteDatabase.setTransactionSuccessful();
                    supportSQLiteDatabase.endTransaction();
                    ObservedTableTracker observedTableTracker = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    synchronized (observedTableTracker) {
                        observedTableTracker.MyBillsEntityDataFactory = false;
                    }
                } finally {
                    closeLock.unlock();
                }
            } catch (SQLiteException | IllegalStateException e) {
                InstrumentInjector.log_e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ObserverWrapper {
        final String[] BuiltInFictitiousFunctionClassFactory;
        final Observer KClassImpl$Data$declaredNonStaticMembers$2;
        final int[] MyBillsEntityDataFactory;
        final Set<String> PlaceComponentResult;

        ObserverWrapper(Observer observer, int[] iArr, String[] strArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observer;
            this.MyBillsEntityDataFactory = iArr;
            this.BuiltInFictitiousFunctionClassFactory = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.PlaceComponentResult = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.PlaceComponentResult = null;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Observer {
        final String[] MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean MyBillsEntityDataFactory() {
            return false;
        }

        public abstract void PlaceComponentResult(Set<String> set);

        public Observer(String[] strArr) {
            this.MyBillsEntityDataFactory = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ObservedTableTracker {
        final boolean[] BuiltInFictitiousFunctionClassFactory;
        final long[] KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        boolean PlaceComponentResult;
        final int[] getAuthRequestContext;

        ObservedTableTracker(int i) {
            long[] jArr = new long[i];
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jArr;
            boolean[] zArr = new boolean[i];
            this.BuiltInFictitiousFunctionClassFactory = zArr;
            this.getAuthRequestContext = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        final boolean MyBillsEntityDataFactory(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long[] jArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    long j = jArr[i];
                    jArr[i] = 1 + j;
                    if (j == 0) {
                        this.PlaceComponentResult = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        final boolean KClassImpl$Data$declaredNonStaticMembers$2(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long[] jArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    long j = jArr[i];
                    jArr[i] = j - 1;
                    if (j == 1) {
                        this.PlaceComponentResult = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        final int[] BuiltInFictitiousFunctionClassFactory() {
            synchronized (this) {
                if (this.PlaceComponentResult && !this.MyBillsEntityDataFactory) {
                    int length = this.KClassImpl$Data$declaredNonStaticMembers$2.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2[i] > 0;
                            boolean[] zArr = this.BuiltInFictitiousFunctionClassFactory;
                            if (z != zArr[i]) {
                                this.getAuthRequestContext[i] = z ? 1 : 2;
                            } else {
                                this.getAuthRequestContext[i] = 0;
                            }
                            zArr[i] = z;
                            i++;
                        } else {
                            this.MyBillsEntityDataFactory = true;
                            this.PlaceComponentResult = false;
                            return this.getAuthRequestContext;
                        }
                    }
                }
                return null;
            }
        }
    }

    /* loaded from: classes6.dex */
    static class WeakObserver extends Observer {
        final InvalidationTracker KClassImpl$Data$declaredNonStaticMembers$2;
        final WeakReference<Observer> getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.MyBillsEntityDataFactory);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = invalidationTracker;
            this.getAuthRequestContext = new WeakReference<>(observer);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public final void PlaceComponentResult(Set<String> set) {
            Observer observer = this.getAuthRequestContext.get();
            if (observer == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this);
            } else {
                observer.PlaceComponentResult(set);
            }
        }
    }
}
