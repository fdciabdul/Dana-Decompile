package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.os.RemoteException;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.util.Function;
import androidx.room.InvalidationTracker;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import j$.util.DesugarCollections;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private AutoCloser mAutoCloser;
    @Deprecated
    public List<Callback> mCallbacks;
    @Deprecated
    public volatile SupportSQLiteDatabase mDatabase;
    private SupportSQLiteOpenHelper mOpenHelper;
    private Executor mQueryExecutor;
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;
    public static final byte[] PlaceComponentResult = {Ascii.EM, -104, -116, 103, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 91;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private final Map<String, Object> mBackingFieldMap = DesugarCollections.MyBillsEntityDataFactory(new HashMap());
    private final InvalidationTracker mInvalidationTracker = createInvalidationTracker();
    private final Map<Class<?>, Object> mTypeConverters = new HashMap();
    protected Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> mAutoMigrationSpecs = new HashMap();

    /* loaded from: classes3.dex */
    public static abstract class Callback {
        public void KClassImpl$Data$declaredNonStaticMembers$2(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class PrepackagedDatabaseCallback {
    }

    /* loaded from: classes3.dex */
    public interface QueryCallback {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 12
            int r7 = r7 + 4
            byte[] r0 = androidx.room.RoomDatabase.PlaceComponentResult
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r8 = r8 * 7
            int r8 = r8 + 99
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r9 = r9 + r6
            int r6 = r9 + 2
            int r8 = r8 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.g(short, short, byte, java.lang.Object[]):void");
    }

    public abstract void clearAllTables();

    protected abstract InvalidationTracker createInvalidationTracker();

    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public <T> T getTypeConverter(Class<T> cls) {
        return (T) this.mTypeConverters.get(cls);
    }

    public void init(DatabaseConfiguration databaseConfiguration) {
        boolean z;
        this.mOpenHelper = createOpenHelper(databaseConfiguration);
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> it = requiredAutoMigrationSpecs.iterator();
        while (true) {
            int i = -1;
            if (it.hasNext()) {
                Class<? extends AutoMigrationSpec> next = it.next();
                int size = databaseConfiguration.MyBillsEntityDataFactory.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    } else if (next.isAssignableFrom(databaseConfiguration.MyBillsEntityDataFactory.get(size).getClass())) {
                        bitSet.set(size);
                        i = size;
                        break;
                    } else {
                        size--;
                    }
                }
                if (i < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("A required auto migration spec (");
                    sb.append(next.getCanonicalName());
                    sb.append(") is missing in the database configuration.");
                    throw new IllegalArgumentException(sb.toString());
                }
                this.mAutoMigrationSpecs.put(next, databaseConfiguration.MyBillsEntityDataFactory.get(i));
            } else {
                for (int size2 = databaseConfiguration.MyBillsEntityDataFactory.size() - 1; size2 >= 0; size2--) {
                    if (!bitSet.get(size2)) {
                        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                Iterator<Migration> it2 = getAutoMigrations(this.mAutoMigrationSpecs).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Migration next2 = it2.next();
                    if (!Collections.unmodifiableMap(databaseConfiguration.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory).containsKey(Integer.valueOf(next2.BuiltInFictitiousFunctionClassFactory))) {
                        MigrationContainer migrationContainer = databaseConfiguration.getErrorConfigVersion;
                        Migration[] migrationArr = {next2};
                        for (int i2 = 0; i2 <= 0; i2++) {
                            migrationContainer.getAuthRequestContext(migrationArr[0]);
                        }
                    }
                }
                SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, this.mOpenHelper);
                if (sQLiteCopyOpenHelper != null) {
                    sQLiteCopyOpenHelper.getAuthRequestContext = databaseConfiguration;
                }
                AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, this.mOpenHelper);
                if (autoClosingRoomOpenHelper != null) {
                    AutoCloser autoCloser = autoClosingRoomOpenHelper.KClassImpl$Data$declaredNonStaticMembers$2;
                    this.mAutoCloser = autoCloser;
                    final InvalidationTracker invalidationTracker = this.mInvalidationTracker;
                    invalidationTracker.KClassImpl$Data$declaredNonStaticMembers$2 = autoCloser;
                    autoCloser.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Runnable() { // from class: androidx.room.InvalidationTracker$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            InvalidationTracker invalidationTracker2 = InvalidationTracker.this;
                            synchronized (invalidationTracker2) {
                                invalidationTracker2.PlaceComponentResult = false;
                                InvalidationTracker.ObservedTableTracker observedTableTracker = invalidationTracker2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                synchronized (observedTableTracker) {
                                    Arrays.fill(observedTableTracker.BuiltInFictitiousFunctionClassFactory, false);
                                    observedTableTracker.PlaceComponentResult = true;
                                }
                            }
                        }
                    };
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    z = databaseConfiguration.lookAheadTest == JournalMode.WRITE_AHEAD_LOGGING;
                    this.mOpenHelper.setWriteAheadLoggingEnabled(z);
                }
                this.mCallbacks = databaseConfiguration.PlaceComponentResult;
                this.mQueryExecutor = databaseConfiguration.DatabaseTableConfigUtil;
                this.mTransactionExecutor = new TransactionExecutor(databaseConfiguration.newProxyInstance);
                this.mAllowMainThreadQueries = databaseConfiguration.getAuthRequestContext;
                this.mWriteAheadLoggingEnabled = z;
                if (databaseConfiguration.GetContactSyncConfig != null) {
                    InvalidationTracker invalidationTracker2 = this.mInvalidationTracker;
                    invalidationTracker2.scheduleImpl = new MultiInstanceInvalidationClient(databaseConfiguration.BuiltInFictitiousFunctionClassFactory, databaseConfiguration.NetworkUserEntityData$$ExternalSyntheticLambda2, databaseConfiguration.GetContactSyncConfig, invalidationTracker2, invalidationTracker2.getAuthRequestContext.getQueryExecutor());
                }
                Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry<Class<?>, List<Class<?>>> entry : requiredTypeConverters.entrySet()) {
                    Class<?> key = entry.getKey();
                    for (Class<?> cls : entry.getValue()) {
                        int size3 = databaseConfiguration.isLayoutRequested.size() - 1;
                        while (true) {
                            if (size3 < 0) {
                                size3 = -1;
                                break;
                            } else if (cls.isAssignableFrom(databaseConfiguration.isLayoutRequested.get(size3).getClass())) {
                                bitSet2.set(size3);
                                break;
                            } else {
                                size3--;
                            }
                        }
                        if (size3 < 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("A required type converter (");
                            sb2.append(cls);
                            sb2.append(") for ");
                            sb2.append(key.getCanonicalName());
                            sb2.append(" is missing in the database configuration.");
                            throw new IllegalArgumentException(sb2.toString());
                        }
                        this.mTypeConverters.put(cls, databaseConfiguration.isLayoutRequested.get(size3));
                    }
                }
                for (int size4 = databaseConfiguration.isLayoutRequested.size() - 1; size4 >= 0; size4--) {
                    if (!bitSet2.get(size4)) {
                        Object obj = databaseConfiguration.isLayoutRequested.get(size4);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Unexpected type converter ");
                        sb3.append(obj);
                        sb3.append(". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                        throw new IllegalArgumentException(sb3.toString());
                    }
                }
                return;
            }
        }
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Collections.emptyList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r3 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> T unwrapOpenHelper(java.lang.Class<T> r2, androidx.sqlite.db.SupportSQLiteOpenHelper r3) {
        /*
            r1 = this;
        L0:
            boolean r0 = r2.isInstance(r3)
            if (r0 == 0) goto L7
            return r3
        L7:
            boolean r0 = r3 instanceof androidx.room.DelegatingOpenHelper
            if (r0 == 0) goto L12
            androidx.room.DelegatingOpenHelper r3 = (androidx.room.DelegatingOpenHelper) r3
            androidx.sqlite.db.SupportSQLiteOpenHelper r3 = r3.PlaceComponentResult()
            goto L0
        L12:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.unwrapOpenHelper(java.lang.Class, androidx.sqlite.db.SupportSQLiteOpenHelper):java.lang.Object");
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return Collections.emptyMap();
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return Collections.emptySet();
    }

    public boolean isOpen() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            return autoCloser.getAuthRequestContext();
        }
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        return supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen();
    }

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            writeLock.lock();
            try {
                InvalidationTracker invalidationTracker = this.mInvalidationTracker;
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = invalidationTracker.scheduleImpl;
                if (multiInstanceInvalidationClient != null) {
                    if (multiInstanceInvalidationClient.DatabaseTableConfigUtil.compareAndSet(false, true)) {
                        multiInstanceInvalidationClient.PlaceComponentResult.getAuthRequestContext(multiInstanceInvalidationClient.getErrorConfigVersion);
                        try {
                            IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.lookAheadTest;
                            if (iMultiInstanceInvalidationService != null) {
                                iMultiInstanceInvalidationService.unregisterCallback(multiInstanceInvalidationClient.BuiltInFictitiousFunctionClassFactory, multiInstanceInvalidationClient.getAuthRequestContext);
                            }
                        } catch (RemoteException e) {
                            InstrumentInjector.log_w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
                        }
                        multiInstanceInvalidationClient.KClassImpl$Data$declaredNonStaticMembers$2.unbindService(multiInstanceInvalidationClient.moveToNextValue);
                    }
                    invalidationTracker.scheduleImpl = null;
                }
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public Cursor query(String str, Object[] objArr) {
        return this.mOpenHelper.getWritableDatabase().query(new SimpleSQLiteQuery(str, objArr));
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null && Build.VERSION.SDK_INT >= 16) {
            return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    public SupportSQLiteStatement compileStatement(String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(str);
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalBeginTransaction();
        } else {
            autoCloser.PlaceComponentResult(new Function() { // from class: androidx.room.RoomDatabase$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return RoomDatabase.this.m43lambda$beginTransaction$0$androidxroomRoomDatabase((SupportSQLiteDatabase) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$beginTransaction$0$androidx-room-RoomDatabase  reason: not valid java name */
    public /* synthetic */ Object m43lambda$beginTransaction$0$androidxroomRoomDatabase(SupportSQLiteDatabase supportSQLiteDatabase) {
        internalBeginTransaction();
        return null;
    }

    private void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.BuiltInFictitiousFunctionClassFactory(writableDatabase);
        if (Build.VERSION.SDK_INT >= 16 && writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    @Deprecated
    public void endTransaction() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalEndTransaction();
        } else {
            autoCloser.PlaceComponentResult(new Function() { // from class: androidx.room.RoomDatabase$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return RoomDatabase.this.m44lambda$endTransaction$1$androidxroomRoomDatabase((SupportSQLiteDatabase) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$endTransaction$1$androidx-room-RoomDatabase  reason: not valid java name */
    public /* synthetic */ Object m44lambda$endTransaction$1$androidxroomRoomDatabase(SupportSQLiteDatabase supportSQLiteDatabase) {
        internalEndTransaction();
        return null;
    }

    private void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        InvalidationTracker invalidationTracker = this.mInvalidationTracker;
        if (invalidationTracker.getErrorConfigVersion.compareAndSet(false, true)) {
            AutoCloser autoCloser = invalidationTracker.KClassImpl$Data$declaredNonStaticMembers$2;
            if (autoCloser != null) {
                autoCloser.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            invalidationTracker.getAuthRequestContext.getQueryExecutor().execute(invalidationTracker.moveToNextValue);
        }
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }

    public void runInTransaction(Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    public <V> V runInTransaction(Callable<V> callable) {
        beginTransaction();
        try {
            try {
                V call = callable.call();
                setTransactionSuccessful();
                return call;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                SneakyThrow.BuiltInFictitiousFunctionClassFactory(e2);
                endTransaction();
                return null;
            }
        } finally {
            endTransaction();
        }
    }

    public void internalInitInvalidationTracker(SupportSQLiteDatabase supportSQLiteDatabase) {
        InvalidationTracker invalidationTracker = this.mInvalidationTracker;
        synchronized (invalidationTracker) {
            if (invalidationTracker.PlaceComponentResult) {
                InstrumentInjector.log_e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            invalidationTracker.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase);
            invalidationTracker.MyBillsEntityDataFactory = supportSQLiteDatabase.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            invalidationTracker.PlaceComponentResult = true;
        }
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    /* loaded from: classes3.dex */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        final JournalMode resolve(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY)) != null && !isLowRamDevice(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return SupportSQLiteCompat.Api19Impl.PlaceComponentResult(activityManager);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder<T extends RoomDatabase> {
        public boolean BuiltInFictitiousFunctionClassFactory;
        private File DatabaseTableConfigUtil;
        private QueryCallback FragmentBottomSheetPaymentSettingBinding;
        private String GetContactSyncConfig;
        public SupportSQLiteOpenHelper.Factory KClassImpl$Data$declaredNonStaticMembers$2;
        private TimeUnit NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final Class<T> NetworkUserEntityData$$ExternalSyntheticLambda1;
        private Callable<InputStream> NetworkUserEntityData$$ExternalSyntheticLambda2;
        private PrepackagedDatabaseCallback NetworkUserEntityData$$ExternalSyntheticLambda3;
        private Executor NetworkUserEntityData$$ExternalSyntheticLambda4;
        private Executor NetworkUserEntityData$$ExternalSyntheticLambda5;
        private List<Object> NetworkUserEntityData$$ExternalSyntheticLambda6;
        private Set<Integer> NetworkUserEntityData$$ExternalSyntheticLambda8;
        public ArrayList<Callback> PlaceComponentResult;
        private Set<Integer> PrepareContext;
        public boolean getAuthRequestContext;
        private final Context initRecordTimeStamp;
        private final String isLayoutRequested;
        public Executor lookAheadTest;
        private Intent newProxyInstance;
        private List<AutoMigrationSpec> scheduleImpl;
        private long getErrorConfigVersion = -1;
        public JournalMode MyBillsEntityDataFactory = JournalMode.AUTOMATIC;
        public boolean moveToNextValue = true;
        private final MigrationContainer NetworkUserEntityData$$ExternalSyntheticLambda7 = new MigrationContainer();

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(Context context, Class<T> cls, String str) {
            this.initRecordTimeStamp = context;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = cls;
            this.isLayoutRequested = str;
        }

        public final Builder<T> KClassImpl$Data$declaredNonStaticMembers$2(Migration... migrationArr) {
            if (this.PrepareContext == null) {
                this.PrepareContext = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.PrepareContext.add(Integer.valueOf(migration.BuiltInFictitiousFunctionClassFactory));
                this.PrepareContext.add(Integer.valueOf(migration.MyBillsEntityDataFactory));
            }
            MigrationContainer migrationContainer = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            for (Migration migration2 : migrationArr) {
                migrationContainer.getAuthRequestContext(migration2);
            }
            return this;
        }

        public final T BuiltInFictitiousFunctionClassFactory() {
            Executor executor;
            if (this.initRecordTimeStamp == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            Executor executor2 = this.lookAheadTest;
            if (executor2 == null && this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                Executor authRequestContext = ArchTaskExecutor.getAuthRequestContext();
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = authRequestContext;
                this.lookAheadTest = authRequestContext;
            } else if (executor2 != null && this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = executor2;
            } else if (executor2 == null && (executor = this.NetworkUserEntityData$$ExternalSyntheticLambda4) != null) {
                this.lookAheadTest = executor;
            }
            Set<Integer> set = this.PrepareContext;
            if (set != null && this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
                for (Integer num : set) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda8.contains(num)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ");
                        sb.append(num);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
            AutoClosingRoomOpenHelperFactory autoClosingRoomOpenHelperFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (autoClosingRoomOpenHelperFactory == null) {
                autoClosingRoomOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            }
            long j = this.getErrorConfigVersion;
            if (j > 0) {
                if (this.isLayoutRequested == null) {
                    throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                }
                autoClosingRoomOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(autoClosingRoomOpenHelperFactory, new AutoCloser(j, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.NetworkUserEntityData$$ExternalSyntheticLambda4));
            }
            String str = this.GetContactSyncConfig;
            if (str != null || this.DatabaseTableConfigUtil != null || this.NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
                if (this.isLayoutRequested == null) {
                    throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                }
                int i = str == null ? 0 : 1;
                File file = this.DatabaseTableConfigUtil;
                int i2 = file == null ? 0 : 1;
                Callable<InputStream> callable = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (i + i2 + (callable != null ? 1 : 0) != 1) {
                    throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                }
                autoClosingRoomOpenHelperFactory = new SQLiteCopyOpenHelperFactory(str, file, callable, autoClosingRoomOpenHelperFactory);
            }
            QueryCallback queryCallback = this.FragmentBottomSheetPaymentSettingBinding;
            QueryInterceptorOpenHelperFactory queryInterceptorOpenHelperFactory = queryCallback != null ? new QueryInterceptorOpenHelperFactory(autoClosingRoomOpenHelperFactory, queryCallback, this.NetworkUserEntityData$$ExternalSyntheticLambda5) : autoClosingRoomOpenHelperFactory;
            Context context = this.initRecordTimeStamp;
            DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.isLayoutRequested, queryInterceptorOpenHelperFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory.resolve(context), this.lookAheadTest, this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.newProxyInstance, this.moveToNextValue, this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda8, this.GetContactSyncConfig, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.NetworkUserEntityData$$ExternalSyntheticLambda6, this.scheduleImpl);
            T t = (T) Room.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1, RoomDatabase.DB_IMPL_SUFFIX);
            t.init(databaseConfiguration);
            return t;
        }
    }

    /* loaded from: classes3.dex */
    public static class MigrationContainer {
        HashMap<Integer, TreeMap<Integer, Migration>> BuiltInFictitiousFunctionClassFactory = new HashMap<>();

        final void getAuthRequestContext(Migration migration) {
            int i = migration.BuiltInFictitiousFunctionClassFactory;
            int i2 = migration.MyBillsEntityDataFactory;
            TreeMap<Integer, Migration> treeMap = this.BuiltInFictitiousFunctionClassFactory.get(Integer.valueOf(i));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.BuiltInFictitiousFunctionClassFactory.put(Integer.valueOf(i), treeMap);
            }
            Migration migration2 = treeMap.get(Integer.valueOf(i2));
            if (migration2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Overriding migration ");
                sb.append(migration2);
                sb.append(" with ");
                sb.append(migration);
                InstrumentInjector.log_w("ROOM", sb.toString());
            }
            treeMap.put(Integer.valueOf(i2), migration);
        }
    }

    private static boolean isMainThread() {
        Thread thread = Looper.getMainLooper().getThread();
        try {
            byte b = PlaceComponentResult[15];
            byte b2 = b;
            Object[] objArr = new Object[1];
            g(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[15] - 1);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            g(b3, b4, b4, objArr2);
            return thread == cls.getMethod((String) objArr2[0], null).invoke(null, null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
