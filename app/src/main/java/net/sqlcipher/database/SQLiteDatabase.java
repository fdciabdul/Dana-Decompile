package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Color;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Gravity;
import android.view.ViewConfiguration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.fullstory.instrumentation.InstrumentInjector;
import com.j256.ormlite.field.FieldType;
import id.dana.cashier.view.InputCardNumberView;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.SQLException;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class SQLiteDatabase extends SQLiteClosable implements SupportSQLiteDatabase {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 0;
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES;
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final Pattern EMAIL_IN_DB_PATTERN;
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static final String KEY_ENCODING;
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    private static int MyBillsEntityDataFactory = 1;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "4.4.3";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private static int getAuthRequestContext;
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases;
    private static int sQueryLogTimeInMillis;
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;

    /* loaded from: classes6.dex */
    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    /* loaded from: classes6.dex */
    public interface LibraryLoader {
        void loadLibraries(String... strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public enum SQLiteDatabaseTransactionType {
        Deferred,
        Immediate,
        Exclusive
    }

    static void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{36611, 26275, 23634, 13208, 10730};
        BuiltInFictitiousFunctionClassFactory = -3549373554099610897L;
    }

    private native void dbclose();

    private native void dbopen(String str, int i);

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    private native void key(byte[] bArr) throws SQLException;

    private native void key_mutf8(char[] cArr) throws SQLException;

    private native int native_getDbLookaside();

    private native void native_rawExecSQL(String str);

    private native int native_status(int i, boolean z);

    private native void rekey(byte[] bArr) throws SQLException;

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
        int i = MyBillsEntityDataFactory + 37;
        getAuthRequestContext = i % 128;
        if (!(i % 2 != 0)) {
            try {
                SupportSQLiteDatabase.CC.PlaceComponentResult();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        SupportSQLiteDatabase.CC.PlaceComponentResult();
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        int i = getAuthRequestContext + 75;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            boolean MyBillsEntityDataFactory2 = SupportSQLiteDatabase.CC.MyBillsEntityDataFactory();
            int i3 = getAuthRequestContext + 1;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return MyBillsEntityDataFactory2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int lastChangeCount();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native long lastInsertRow();

    native void native_execSQL(String str) throws SQLException;

    native void native_setLocale(String str, int i);

    static /* synthetic */ void access$000(SQLiteDatabase sQLiteDatabase, byte[] bArr) throws SQLException {
        try {
            int i = MyBillsEntityDataFactory + 5;
            getAuthRequestContext = i % 128;
            if ((i % 2 != 0 ? '-' : 'W') != '-') {
                sQLiteDatabase.key(bArr);
                return;
            }
            sQLiteDatabase.key(bArr);
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$100(SQLiteDatabase sQLiteDatabase, char[] cArr) throws SQLException {
        int i = getAuthRequestContext + 53;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 == 0 ? (char) 15 : 'Y';
        sQLiteDatabase.key_mutf8(cArr);
        if (c != 'Y') {
            int i2 = 12 / 0;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* bridge */ /* synthetic */ SupportSQLiteStatement compileStatement(String str) {
        try {
            int i = getAuthRequestContext + 47;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            SQLiteStatement compileStatement = compileStatement(str);
            int i3 = MyBillsEntityDataFactory + 23;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return compileStatement;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(Color.green(0), 5 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (31768 - Gravity.getAbsoluteGravity(0, 0)), objArr);
        KEY_ENCODING = ((String) objArr[0]).intern();
        sActiveDatabases = new WeakHashMap<>();
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
        sQueryLogTimeInMillis = 0;
        try {
            int i = getAuthRequestContext + 57;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public int status(int i, boolean z) {
        try {
            int i2 = MyBillsEntityDataFactory + 89;
            getAuthRequestContext = i2 % 128;
            char c = i2 % 2 != 0 ? (char) 4 : '3';
            int native_status = native_status(i, z);
            if (c == 4) {
                int i3 = 77 / 0;
            }
            int i4 = MyBillsEntityDataFactory + 119;
            try {
                getAuthRequestContext = i4 % 128;
                if ((i4 % 2 != 0 ? (char) 17 : (char) 27) != 27) {
                    Object obj = null;
                    obj.hashCode();
                    return native_status;
                }
                return native_status;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x0051
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void changePassword(java.lang.String r5) throws net.sqlcipher.database.SQLiteException {
        /*
            r4 = this;
            boolean r0 = r4.isOpen()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            if (r0 == 0) goto L49
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 97
            int r3 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L1a
            r1 = 0
        L1a:
            if (r1 == 0) goto L1f
            if (r5 == 0) goto L3c
            goto L2e
        L1f:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L47
            r0 = 24
            if (r5 == 0) goto L2a
            r1 = 90
            goto L2c
        L2a:
            r1 = 24
        L2c:
            if (r1 == r0) goto L3c
        L2e:
            char[] r5 = r5.toCharArray()
            byte[] r5 = getBytes(r5)
            r4.rekey(r5)
            java.util.Arrays.fill(r5, r2)
        L3c:
            int r5 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r5 = r5 + 73
            int r0 = r5 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0
            int r5 = r5 % 2
            return
        L47:
            r5 = move-exception
            throw r5
        L49:
            net.sqlcipher.database.SQLiteException r5 = new net.sqlcipher.database.SQLiteException
            java.lang.String r0 = "database not open"
            r5.<init>(r0)
            throw r5
        L51:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.changePassword(java.lang.String):void");
    }

    public void changePassword(char[] cArr) throws SQLiteException {
        if (!(isOpen())) {
            throw new SQLiteException("database not open");
        }
        int i = getAuthRequestContext + 101;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if ((cArr != null ? '\\' : 'J') == '\\') {
            byte[] bytes = getBytes(cArr);
            rekey(bytes);
            Arrays.fill(bytes, (byte) 0);
        }
        int i3 = MyBillsEntityDataFactory + 67;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:105:0x0118
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static void loadICUData(android.content.Context r9, java.io.File r10) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.loadICUData(android.content.Context, java.io.File):void");
    }

    public static void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    public static void loadLibs(Context context, File file) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, file, new LibraryLoader() { // from class: net.sqlcipher.database.SQLiteDatabase.1
                @Override // net.sqlcipher.database.SQLiteDatabase.LibraryLoader
                public final void loadLibraries(String... strArr) {
                    for (String str : strArr) {
                        System.loadLibrary(str);
                    }
                }
            });
        }
    }

    public static void loadLibs(Context context, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir(), libraryLoader);
        }
    }

    public static void loadLibs(Context context, File file, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            libraryLoader.loadLibraries("sqlcipher");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addSQLiteClosable(SQLiteClosable sQLiteClosable) {
        try {
            int i = getAuthRequestContext + 27;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            lock();
            try {
                Object[] objArr = null;
                this.mPrograms.put(sQLiteClosable, null);
                int i3 = MyBillsEntityDataFactory + 25;
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 != 0 ? Typography.dollar : ';') != ';') {
                    int length = objArr.length;
                }
            } finally {
                unlock();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSQLiteClosable(SQLiteClosable sQLiteClosable) {
        int i = getAuthRequestContext + 77;
        MyBillsEntityDataFactory = i % 128;
        try {
            if (i % 2 != 0) {
                lock();
                this.mPrograms.remove(sQLiteClosable);
                return;
            }
            try {
                lock();
                this.mPrograms.remove(sQLiteClosable);
                try {
                    int i2 = 39 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } finally {
            unlock();
        }
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    public void setLockingEnabled(boolean z) {
        int i = MyBillsEntityDataFactory + 95;
        getAuthRequestContext = i % 128;
        boolean z2 = i % 2 == 0;
        this.mLockingEnabled = z;
        if (z2) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCorruption() {
        int i = MyBillsEntityDataFactory + 61;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            this.mErrorHandler.onCorruption(this);
            int i3 = MyBillsEntityDataFactory + 19;
            try {
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 != 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lock() {
        int i = MyBillsEntityDataFactory + 55;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            if (this.mLockingEnabled) {
                this.mLock.lock();
                if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING) {
                    try {
                        if (!(this.mLock.getHoldCount() == 1)) {
                            return;
                        }
                        int i3 = getAuthRequestContext + 7;
                        MyBillsEntityDataFactory = i3 % 128;
                        int i4 = i3 % 2;
                        this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                        this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
                        int i5 = MyBillsEntityDataFactory + 51;
                        getAuthRequestContext = i5 % 128;
                        int i6 = i5 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if ((SQLiteDebug.DEBUG_LOCK_TIME_TRACKING ? (char) 14 : 'E') != 'E') {
            try {
                try {
                    if ((this.mLock.getHoldCount() == 1 ? (char) 19 : '@') != '@') {
                        int i = MyBillsEntityDataFactory + 75;
                        getAuthRequestContext = i % 128;
                        int i2 = i % 2;
                        this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                        this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
                        int i3 = getAuthRequestContext + 71;
                        MyBillsEntityDataFactory = i3 % 128;
                        int i4 = i3 % 2;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r0 == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        if (r3.mLockingEnabled == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 37;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if ((r0 % 2) != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        r0 = '\'';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r0 = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if (r0 == 28) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
    
        r0 = 97 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
    
        if (net.sqlcipher.database.SQLiteDebug.DEBUG_LOCK_TIME_TRACKING == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        if (r3.mLock.getHoldCount() != 1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004e, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
    
        if (r2 == true) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:
    
        checkLockHoldTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0057, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0058, code lost:
    
        r3.mLock.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void unlock() {
        /*
            r3 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 29
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 51
            if (r0 == 0) goto L11
            r0 = 72
            goto L13
        L11:
            r0 = 51
        L13:
            r2 = 0
            if (r0 == r1) goto L21
            boolean r0 = r3.mLockingEnabled
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto L41
            goto L25
        L1f:
            r0 = move-exception
            throw r0
        L21:
            boolean r0 = r3.mLockingEnabled
            if (r0 != 0) goto L41
        L25:
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 37
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 28
            if (r0 != 0) goto L36
            r0 = 39
            goto L38
        L36:
            r0 = 28
        L38:
            if (r0 == r1) goto L40
            r0 = 97
            int r0 = r0 / r2
            return
        L3e:
            r0 = move-exception
            throw r0
        L40:
            return
        L41:
            boolean r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_LOCK_TIME_TRACKING
            if (r0 == 0) goto L58
            java.util.concurrent.locks.ReentrantLock r0 = r3.mLock     // Catch: java.lang.Exception -> L56
            int r0 = r0.getHoldCount()     // Catch: java.lang.Exception -> L56
            r1 = 1
            if (r0 != r1) goto L4f
            r2 = 1
        L4f:
            if (r2 == r1) goto L52
            goto L58
        L52:
            r3.checkLockHoldTime()
            goto L58
        L56:
            r0 = move-exception
            throw r0
        L58:
            java.util.concurrent.locks.ReentrantLock r0 = r3.mLock
            r0.unlock()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.unlock():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if (r0 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r4.mLock.getHoldCount() != 1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r0 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r0 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (r0 == '0') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory + 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        r0 = r0 % 2;
        checkLockHoldTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        r4.mLock.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory + 17;
        net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
    
        if ((r0 % 2) == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0051, code lost:
    
        r0 = 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0054, code lost:
    
        r0 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        if (r0 == '!') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        r0 = 21 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (net.sqlcipher.database.SQLiteDebug.DEBUG_LOCK_TIME_TRACKING != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void unlockForced() {
        /*
            r4 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 41
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r2) goto L18
            boolean r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_LOCK_TIME_TRACKING
            if (r0 == 0) goto L3e
            goto L20
        L18:
            boolean r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_LOCK_TIME_TRACKING     // Catch: java.lang.Exception -> L63
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L3e
        L20:
            java.util.concurrent.locks.ReentrantLock r0 = r4.mLock
            int r0 = r0.getHoldCount()
            r3 = 48
            if (r0 != r2) goto L2d
            r0 = 12
            goto L2f
        L2d:
            r0 = 48
        L2f:
            if (r0 == r3) goto L3e
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L5f
            int r0 = r0 + 17
            int r2 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r2     // Catch: java.lang.Exception -> L63
            int r0 = r0 % 2
            r4.checkLockHoldTime()
        L3e:
            java.util.concurrent.locks.ReentrantLock r0 = r4.mLock     // Catch: java.lang.Exception -> L5f
            r0.unlock()     // Catch: java.lang.Exception -> L5f
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 17
            int r2 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r2
            int r0 = r0 % 2
            r2 = 33
            if (r0 == 0) goto L54
            r0 = 87
            goto L56
        L54:
            r0 = 33
        L56:
            if (r0 == r2) goto L5e
            r0 = 21
            int r0 = r0 / r1
            return
        L5c:
            r0 = move-exception
            throw r0
        L5e:
            return
        L5f:
            r0 = move-exception
            throw r0
        L61:
            r0 = move-exception
            throw r0
        L63:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.unlockForced():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        if (r8 < 2000) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (android.util.Log.isLoggable(net.sqlcipher.database.SQLiteDatabase.TAG, 2) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if ((r6 - r14.mLastLockMessageTime) >= 20000) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory + 13;
        net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        if ((r0 % 2) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
    
        r0 = 82 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if ((r8 >= 2000) != true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkLockHoldTime() {
        /*
            r14 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 51
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 0
            r3 = 2000(0x7d0, double:9.88E-321)
            r5 = 1
            if (r0 != 0) goto L21
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r8 = r14.mLockAcquiredWallTime
            long r8 = r8 | r6
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 >= 0) goto L1d
            r0 = 0
            goto L1e
        L1d:
            r0 = 1
        L1e:
            if (r0 == r5) goto L51
            goto L2d
        L21:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r8 = r14.mLockAcquiredWallTime
            long r8 = r6 - r8
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 >= 0) goto L51
        L2d:
            java.lang.String r0 = "Database"
            boolean r0 = android.util.Log.isLoggable(r0, r1)
            if (r0 != 0) goto L51
            long r10 = r14.mLastLockMessageTime
            long r10 = r6 - r10
            r12 = 20000(0x4e20, double:9.8813E-320)
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 >= 0) goto L51
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 13
            int r3 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r3
            int r0 = r0 % r1
            if (r0 == 0) goto L50
            r0 = 82
            int r0 = r0 / r2
            return
        L4e:
            r0 = move-exception
            throw r0
        L50:
            return
        L51:
            r10 = 300(0x12c, double:1.48E-321)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 <= 0) goto La4
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext     // Catch: java.lang.Exception -> La2
            int r0 = r0 + 55
            int r10 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r10     // Catch: java.lang.Exception -> La2
            int r0 = r0 % r1
            long r10 = android.os.Debug.threadCpuTimeNanos()
            long r12 = r14.mLockAcquiredThreadTime
            long r10 = r10 - r12
            r12 = 1000000(0xf4240, double:4.940656E-318)
            long r10 = r10 / r12
            int r0 = (int) r10
            r10 = 100
            r11 = 36
            if (r0 > r10) goto L75
            r0 = 36
            goto L77
        L75:
            r0 = 56
        L77:
            if (r0 == r11) goto L7a
            goto L9b
        L7a:
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 35
            int r10 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r10
            int r0 = r0 % r1
            if (r0 != 0) goto L87
            r0 = 1
            goto L88
        L87:
            r0 = 0
        L88:
            if (r0 == 0) goto L93
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L91
            if (r0 <= 0) goto La4
            goto L9b
        L91:
            r0 = move-exception
            throw r0
        L93:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 <= 0) goto L98
            goto L99
        L98:
            r2 = 1
        L99:
            if (r2 == r5) goto La4
        L9b:
            r14.mLastLockMessageTime = r6     // Catch: java.lang.Exception -> La0
            boolean r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE     // Catch: java.lang.Exception -> La0
            goto La4
        La0:
            r0 = move-exception
            throw r0
        La2:
            r0 = move-exception
            throw r0
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.checkLockHoldTime():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if ((((java.lang.Boolean) r0.first).booleanValue() ? 'a' : 16) != 16) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        r0 = ((java.lang.String) r0.second).equals("ok");
        r1 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 47;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        return ((java.lang.Boolean) r0.first).booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (((java.lang.Boolean) r0.first).booleanValue() != false) goto L16;
     */
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isDatabaseIntegrityOk() {
        /*
            r3 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext     // Catch: java.lang.Exception -> L5a
            int r0 = r0 + 75
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L5a
            int r0 = r0 % 2
            java.lang.String r1 = "PRAGMA integrity_check;"
            if (r0 != 0) goto L23
            android.util.Pair r0 = r3.getResultFromPragma(r1)
            java.lang.Object r1 = r0.first
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = 98
            int r2 = r2 / 0
            if (r1 == 0) goto L4f
            goto L3a
        L21:
            r0 = move-exception
            throw r0
        L23:
            android.util.Pair r0 = r3.getResultFromPragma(r1)
            java.lang.Object r1 = r0.first
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = 16
            if (r1 == 0) goto L36
            r1 = 97
            goto L38
        L36:
            r1 = 16
        L38:
            if (r1 == r2) goto L4f
        L3a:
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "ok"
            boolean r0 = r0.equals(r1)
            int r1 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r1 = r1 + 47
            int r2 = r1 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r2
            int r1 = r1 % 2
            goto L57
        L4f:
            java.lang.Object r0 = r0.first     // Catch: java.lang.Exception -> L58
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L58
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L58
        L57:
            return r0
        L58:
            r0 = move-exception
            throw r0
        L5a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.isDatabaseIntegrityOk():boolean");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        ArrayList<Pair<String, String>> attachedDbs;
        try {
            int i = getAuthRequestContext + 15;
            MyBillsEntityDataFactory = i % 128;
            Object[] objArr = null;
            if ((i % 2 == 0 ? (char) 27 : (char) 20) != 20) {
                attachedDbs = getAttachedDbs(this);
                int length = objArr.length;
            } else {
                attachedDbs = getAttachedDbs(this);
            }
            int i2 = getAuthRequestContext + 65;
            MyBillsEntityDataFactory = i2 % 128;
            if ((i2 % 2 == 0 ? '\f' : (char) 7) != 7) {
                objArr.hashCode();
                return attachedDbs;
            }
            return attachedDbs;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean enableWriteAheadLogging() {
        if (!(!inTransaction())) {
            throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
        }
        ArrayList<Pair<String, String>> attachedDbs = getAttachedDbs(this);
        if (attachedDbs != null) {
            int i = getAuthRequestContext + 29;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            if (!(attachedDbs.size() <= 1)) {
                return false;
            }
        }
        if (!isReadOnly()) {
            int i3 = getAuthRequestContext + 7;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            if (!getPath().equals(MEMORY)) {
                rawExecSQL("PRAGMA journal_mode = WAL;");
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if ((!r0 ? '_' : '4') != '4') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if ((!inTransaction() ? '8' : '[') != '[') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        rawExecSQL("PRAGMA journal_mode = DELETE;");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
    
        throw new java.lang.IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void disableWriteAheadLogging() {
        /*
            r2 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 29
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L22
            boolean r0 = r2.inTransaction()
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L20
            r1 = 52
            if (r0 != 0) goto L1b
            r0 = 95
            goto L1d
        L1b:
            r0 = 52
        L1d:
            if (r0 == r1) goto L45
            goto L31
        L20:
            r0 = move-exception
            throw r0
        L22:
            boolean r0 = r2.inTransaction()
            r1 = 91
            if (r0 != 0) goto L2d
            r0 = 56
            goto L2f
        L2d:
            r0 = 91
        L2f:
            if (r0 == r1) goto L45
        L31:
            java.lang.String r0 = "PRAGMA journal_mode = DELETE;"
            r2.rawExecSQL(r0)     // Catch: java.lang.Exception -> L41
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext     // Catch: java.lang.Exception -> L43
            int r0 = r0 + 101
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L43
            int r0 = r0 % 2
            return
        L41:
            r0 = move-exception
            throw r0
        L43:
            r0 = move-exception
            throw r0
        L45:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Write Ahead Logging cannot be disabled while in a transaction"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.disableWriteAheadLogging():void");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        try {
            int i = MyBillsEntityDataFactory + 1;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            Pair<Boolean, String> resultFromPragma = getResultFromPragma("PRAGMA journal_mode;");
            if (((Boolean) resultFromPragma.first).booleanValue()) {
                boolean equals = ((String) resultFromPragma.second).equals("wal");
                int i3 = MyBillsEntityDataFactory + 11;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return equals;
            }
            return ((Boolean) resultFromPragma.first).booleanValue();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z) {
        String str;
        try {
            if (!(!inTransaction())) {
                throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
            }
            int i = MyBillsEntityDataFactory + 23;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            Object[] objArr = new Object[1];
            if (!z) {
                int i3 = getAuthRequestContext + 119;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                str = "OFF";
            } else {
                int i5 = MyBillsEntityDataFactory + 9;
                getAuthRequestContext = i5 % 128;
                if (!(i5 % 2 == 0)) {
                    int i6 = 49 / 0;
                }
                str = "ON";
            }
            objArr[0] = str;
            execSQL(String.format("PRAGMA foreign_keys = %s;", objArr));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        int i = getAuthRequestContext + 113;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        beginTransactionWithListener((SQLiteTransactionListener) null);
        try {
            int i3 = MyBillsEntityDataFactory + 93;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        int i = MyBillsEntityDataFactory + 89;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Exclusive);
            int i3 = getAuthRequestContext + 23;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 == 0 ? 'P' : 'Z') != 'Z') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        int i = getAuthRequestContext + 61;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        beginTransactionWithListenerInternal(null, SQLiteDatabaseTransactionType.Immediate);
        int i3 = MyBillsEntityDataFactory + 117;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        int i = getAuthRequestContext + 31;
        MyBillsEntityDataFactory = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? '\\' : 'a') != 'a') {
            beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Immediate);
            obj.hashCode();
        } else {
            beginTransactionWithListenerInternal(sQLiteTransactionListener, SQLiteDatabaseTransactionType.Immediate);
        }
        try {
            int i2 = MyBillsEntityDataFactory + 73;
            getAuthRequestContext = i2 % 128;
            if (i2 % 2 != 0) {
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x008a, code lost:
    
        if ((!r6.mTransactionIsSuccessful) != true) goto L50;
     */
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void endTransaction() {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.endTransaction():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r0 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r3.mLock.isHeldByCurrentThread() == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r0 == true) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 63;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        if (r3.mInnerTransactionIsSuccessful != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 7;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        r3.mInnerTransactionIsSuccessful = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        throw new java.lang.IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        throw new java.lang.IllegalStateException("no transaction pending");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
    
        throw new java.lang.IllegalStateException("database not open");
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (isOpen() != false) goto L14;
     */
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setTransactionSuccessful() {
        /*
            r3 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 9
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 80
            if (r0 == 0) goto L11
            r0 = 80
            goto L13
        L11:
            r0 = 52
        L13:
            if (r0 == r1) goto L1c
            boolean r0 = r3.isOpen()
            if (r0 == 0) goto L62
            goto L26
        L1c:
            boolean r0 = r3.isOpen()     // Catch: java.lang.Exception -> L6c
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L62
        L26:
            java.util.concurrent.locks.ReentrantLock r0 = r3.mLock
            boolean r0 = r0.isHeldByCurrentThread()
            r1 = 1
            if (r0 == 0) goto L31
            r0 = 0
            goto L32
        L31:
            r0 = 1
        L32:
            if (r0 == r1) goto L5a
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext     // Catch: java.lang.Exception -> L6c
            int r0 = r0 + 63
            int r2 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r2     // Catch: java.lang.Exception -> L6c
            int r0 = r0 % 2
            boolean r0 = r3.mInnerTransactionIsSuccessful     // Catch: java.lang.Exception -> L58
            if (r0 != 0) goto L4f
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 7
            int r2 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r2
            int r0 = r0 % 2
            r3.mInnerTransactionIsSuccessful = r1     // Catch: java.lang.Exception -> L58
            return
        L4f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "setTransactionSuccessful may only be called once per call to beginTransaction"
            r0.<init>(r1)
            throw r0
        L58:
            r0 = move-exception
            throw r0
        L5a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "no transaction pending"
            r0.<init>(r1)
            throw r0
        L62:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "database not open"
            r0.<init>(r1)
            throw r0
        L6a:
            r0 = move-exception
            throw r0
        L6c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.setTransactionSuccessful():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if ((r4.mLock.getHoldCount() > 0 ? 14 : 23) != 14) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if ((r4.mLock.getHoldCount() <= 0) != true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory + 109;
        net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        return r1;
     */
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean inTransaction() {
        /*
            r4 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 17
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L27
            java.util.concurrent.locks.ReentrantLock r0 = r4.mLock     // Catch: java.lang.Exception -> L25
            int r0 = r0.getHoldCount()     // Catch: java.lang.Exception -> L25
            r3 = 35
            int r3 = r3 / r1
            r3 = 14
            if (r0 <= 0) goto L1e
            r0 = 14
            goto L20
        L1e:
            r0 = 23
        L20:
            if (r0 == r3) goto L34
            goto L35
        L23:
            r0 = move-exception
            throw r0
        L25:
            r0 = move-exception
            throw r0
        L27:
            java.util.concurrent.locks.ReentrantLock r0 = r4.mLock
            int r0 = r0.getHoldCount()
            if (r0 <= 0) goto L31
            r0 = 0
            goto L32
        L31:
            r0 = 1
        L32:
            if (r0 == r2) goto L35
        L34:
            r1 = 1
        L35:
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 109
            int r2 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r2
            int r0 = r0 % 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.inTransaction():boolean");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        try {
            int i = MyBillsEntityDataFactory + 41;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            boolean isHeldByCurrentThread = this.mLock.isHeldByCurrentThread();
            int i3 = MyBillsEntityDataFactory + 13;
            getAuthRequestContext = i3 % 128;
            if (i3 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                return isHeldByCurrentThread;
            }
            return isHeldByCurrentThread;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isDbLockedByOtherThreads() {
        if (!(this.mLock.isHeldByCurrentThread())) {
            int i = MyBillsEntityDataFactory + 37;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            if (!(!this.mLock.isLocked())) {
                int i3 = getAuthRequestContext + 19;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 != 0) {
                }
                return true;
            }
        }
        int i4 = MyBillsEntityDataFactory + 113;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        return false;
    }

    @Deprecated
    public boolean yieldIfContended() {
        if (!(isOpen())) {
            int i = getAuthRequestContext + 123;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return false;
        }
        boolean yieldIfContendedHelper = yieldIfContendedHelper(false, -1L);
        int i3 = MyBillsEntityDataFactory + 5;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return yieldIfContendedHelper;
        }
        Object obj = null;
        obj.hashCode();
        return yieldIfContendedHelper;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if ((!r0 ? 27 : 'O') != 'O') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if ((isOpen()) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r0 = yieldIfContendedHelper(true, -1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r4 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory + 41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        if ((r4 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        if (r2 == true) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory + 95;
        net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0059, code lost:
    
        return false;
     */
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean yieldIfContendedSafely() {
        /*
            r6 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 115
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L24
            boolean r0 = r6.isOpen()
            r1.hashCode()     // Catch: java.lang.Throwable -> L22
            r4 = 79
            if (r0 != 0) goto L1d
            r0 = 27
            goto L1f
        L1d:
            r0 = 79
        L1f:
            if (r0 == r4) goto L2f
            goto L4f
        L22:
            r0 = move-exception
            throw r0
        L24:
            boolean r0 = r6.isOpen()
            if (r0 != 0) goto L2c
            r0 = 0
            goto L2d
        L2c:
            r0 = 1
        L2d:
            if (r0 == 0) goto L4f
        L2f:
            r4 = -1
            boolean r0 = r6.yieldIfContendedHelper(r3, r4)
            int r4 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L4d
            int r4 = r4 + 41
            int r5 = r4 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r5     // Catch: java.lang.Exception -> L4b
            int r4 = r4 % 2
            if (r4 == 0) goto L42
            r2 = 1
        L42:
            if (r2 == r3) goto L45
            return r0
        L45:
            r1.hashCode()     // Catch: java.lang.Throwable -> L49
            return r0
        L49:
            r0 = move-exception
            throw r0
        L4b:
            r0 = move-exception
            throw r0
        L4d:
            r0 = move-exception
            throw r0
        L4f:
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 95
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1
            int r0 = r0 % 2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.yieldIfContendedSafely():boolean");
    }

    public boolean yieldIfContendedSafely(long j) {
        if (!(isOpen())) {
            int i = getAuthRequestContext + 95;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            int i3 = MyBillsEntityDataFactory + 17;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return false;
        }
        return yieldIfContendedHelper(true, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        if (r12 > 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0075, code lost:
    
        if (r12 <= 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0077, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
    
        if (r11 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
    
        if (r12 >= 1000) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        if (r11 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        r8 = 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
    
        r8 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        java.lang.Thread.sleep(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008d, code lost:
    
        r11 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 29;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r11 % 128;
        r11 = r11 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
    
        java.lang.Thread.interrupted();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean yieldIfContendedHelper(boolean r11, long r12) {
        /*
            r10 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 23
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1
            int r0 = r0 % 2
            java.util.concurrent.locks.ReentrantLock r0 = r10.mLock
            int r0 = r0.getQueueLength()
            r1 = 29
            r2 = 0
            if (r0 != 0) goto L44
            int r11 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r11 = r11 + 37
            int r12 = r11 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r12
            int r11 = r11 % 2
            if (r11 == 0) goto L24
            r11 = 29
            goto L26
        L24:
            r11 = 25
        L26:
            if (r11 == r1) goto L37
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L35
            r10.mLockAcquiredWallTime = r11     // Catch: java.lang.Exception -> L35
            long r11 = android.os.Debug.threadCpuTimeNanos()     // Catch: java.lang.Exception -> L35
            r10.mLockAcquiredThreadTime = r11     // Catch: java.lang.Exception -> L35
            return r2
        L35:
            r11 = move-exception
            goto L97
        L37:
            long r11 = android.os.SystemClock.elapsedRealtime()
            r10.mLockAcquiredWallTime = r11
            long r11 = android.os.Debug.threadCpuTimeNanos()
            r10.mLockAcquiredThreadTime = r11
            return r2
        L44:
            r10.setTransactionSuccessful()
            net.sqlcipher.database.SQLiteTransactionListener r0 = r10.mTransactionListener
            r10.endTransaction()
            r3 = 1
            if (r11 == 0) goto L51
            r11 = 1
            goto L52
        L51:
            r11 = 0
        L52:
            if (r11 == 0) goto L6d
            int r11 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r11 = r11 + 91
            int r4 = r11 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r4
            int r11 = r11 % 2
            boolean r11 = r10.isDbLockedByCurrentThread()
            if (r11 != 0) goto L65
            goto L6d
        L65:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Db locked more than once. yielfIfContended cannot yield"
            r11.<init>(r12)
            throw r11
        L6d:
            r4 = 0
            int r11 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r11 <= 0) goto La4
        L73:
            int r11 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r11 <= 0) goto L79
            r11 = 1
            goto L7a
        L79:
            r11 = 0
        L7a:
            if (r11 == 0) goto La4
            r6 = 1000(0x3e8, double:4.94E-321)
            int r11 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r11 >= 0) goto L84
            r11 = 0
            goto L85
        L84:
            r11 = 1
        L85:
            if (r11 == 0) goto L89
            r8 = r6
            goto L8a
        L89:
            r8 = r12
        L8a:
            java.lang.Thread.sleep(r8)     // Catch: java.lang.InterruptedException -> L98
            int r11 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext     // Catch: java.lang.Exception -> L35
            int r11 = r11 + r1
            int r8 = r11 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r8     // Catch: java.lang.Exception -> L35
            int r11 = r11 % 2
            goto L9b
        L97:
            throw r11
        L98:
            java.lang.Thread.interrupted()
        L9b:
            long r12 = r12 - r6
            java.util.concurrent.locks.ReentrantLock r11 = r10.mLock
            int r11 = r11.getQueueLength()
            if (r11 != 0) goto L73
        La4:
            r10.beginTransactionWithListener(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.yieldIfContendedHelper(boolean, long):boolean");
    }

    public Map<String, String> getSyncedTables() {
        HashMap hashMap;
        synchronized (this.mSyncUpdateInfo) {
            hashMap = new HashMap();
            for (String str : this.mSyncUpdateInfo.keySet()) {
                SyncUpdateInfo syncUpdateInfo = this.mSyncUpdateInfo.get(str);
                if (syncUpdateInfo.deletedTable != null) {
                    hashMap.put(str, syncUpdateInfo.deletedTable);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        SyncUpdateInfo(String str, String str2, String str3) {
            this.masterTable = str;
            this.deletedTable = str2;
            this.foreignKey = str3;
        }
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i) {
        try {
            int i2 = getAuthRequestContext + 23;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            SQLiteDatabase openDatabase = openDatabase(str, str2, cursorFactory, i, (SQLiteDatabaseHook) null);
            int i4 = getAuthRequestContext + 25;
            MyBillsEntityDataFactory = i4 % 128;
            int i5 = i4 % 2;
            return openDatabase;
        } catch (Exception e) {
            throw e;
        }
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        int i2 = getAuthRequestContext + 61;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        SQLiteDatabase openDatabase = openDatabase(str, cArr, cursorFactory, i, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
        int i4 = getAuthRequestContext + 67;
        MyBillsEntityDataFactory = i4 % 128;
        if ((i4 % 2 == 0 ? (char) 21 : (char) 0) != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return openDatabase;
        }
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        int i2 = getAuthRequestContext + 51;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        SQLiteDatabase openDatabase = openDatabase(str, str2, cursorFactory, i, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
        int i4 = getAuthRequestContext + 43;
        MyBillsEntityDataFactory = i4 % 128;
        if ((i4 % 2 == 0 ? (char) 1 : 'P') != 1) {
            return openDatabase;
        }
        int i5 = 28 / 0;
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        int i2 = getAuthRequestContext + 5;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        SQLiteDatabase openDatabase = openDatabase(str, cArr, cursorFactory, i, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
        int i4 = MyBillsEntityDataFactory + 49;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        char[] cArr = null;
        if ((str2 == null ? '5' : '\'') != '5') {
            cArr = str2.toCharArray();
        } else {
            int i2 = MyBillsEntityDataFactory + 75;
            getAuthRequestContext = i2 % 128;
            if ((i2 % 2 != 0 ? (char) 22 : 'b') == 22) {
                cArr.hashCode();
            }
            int i3 = getAuthRequestContext + 1;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
        }
        return openDatabase(str, cArr, cursorFactory, i, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        try {
            int i2 = MyBillsEntityDataFactory + 63;
            getAuthRequestContext = i2 % 128;
            if ((i2 % 2 != 0 ? '\r' : 'A') != 'A') {
                SQLiteDatabase openDatabase = openDatabase(str, getBytes(cArr), cursorFactory, i, sQLiteDatabaseHook, databaseErrorHandler);
                Object[] objArr = null;
                int length = objArr.length;
                return openDatabase;
            }
            try {
                return openDatabase(str, getBytes(cArr), cursorFactory, i, sQLiteDatabaseHook, databaseErrorHandler);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static net.sqlcipher.database.SQLiteDatabase openDatabase(java.lang.String r2, byte[] r3, net.sqlcipher.database.SQLiteDatabase.CursorFactory r4, int r5, net.sqlcipher.database.SQLiteDatabaseHook r6, net.sqlcipher.DatabaseErrorHandler r7) {
        /*
            if (r7 != 0) goto L7
            net.sqlcipher.DefaultDatabaseErrorHandler r7 = new net.sqlcipher.DefaultDatabaseErrorHandler
            r7.<init>()
        L7:
            r0 = 0
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L11
            r1.<init>(r2, r4, r5, r7)     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L11
            r1.openDatabaseInternal(r3, r6)     // Catch: net.sqlcipher.database.SQLiteDatabaseCorruptException -> L12
            goto L1d
        L11:
            r1 = r0
        L12:
            r7.onCorruption(r1)
            net.sqlcipher.database.SQLiteDatabase r1 = new net.sqlcipher.database.SQLiteDatabase
            r1.<init>(r2, r4, r5, r7)
            r1.openDatabaseInternal(r3, r6)
        L1d:
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_STATEMENTS
            if (r3 == 0) goto L24
            r1.enableSqlTracing(r2)
        L24:
            boolean r3 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_TIME
            if (r3 == 0) goto L2b
            r1.enableSqlProfiling(r2)
        L2b:
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r2 = net.sqlcipher.database.SQLiteDatabase.sActiveDatabases
            monitor-enter(r2)
            java.util.WeakHashMap<net.sqlcipher.database.SQLiteDatabase, java.lang.Object> r3 = net.sqlcipher.database.SQLiteDatabase.sActiveDatabases     // Catch: java.lang.Throwable -> L35
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> L35
            monitor-exit(r2)
            return r1
        L35:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabase(java.lang.String, byte[], net.sqlcipher.database.SQLiteDatabase$CursorFactory, int, net.sqlcipher.database.SQLiteDatabaseHook, net.sqlcipher.DatabaseErrorHandler):net.sqlcipher.database.SQLiteDatabase");
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        int i = MyBillsEntityDataFactory + 13;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Object obj = null;
        try {
            SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file, str, cursorFactory, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
            int i3 = MyBillsEntityDataFactory + 89;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 0 : '=') != '=') {
                obj.hashCode();
                return openOrCreateDatabase;
            }
            return openOrCreateDatabase;
        } catch (Exception e) {
            throw e;
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        String path;
        if (file == null) {
            int i = getAuthRequestContext + 123;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 == 0) {
                int i2 = 97 / 0;
            }
            path = null;
        } else {
            path = file.getPath();
            try {
                int i3 = getAuthRequestContext + 73;
                try {
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return openOrCreateDatabase(path, str, cursorFactory, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        int i = MyBillsEntityDataFactory + 117;
        getAuthRequestContext = i % 128;
        boolean z = i % 2 != 0;
        SQLiteDatabase openDatabase = openDatabase(str, str2, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook);
        if (z) {
            int i2 = 9 / 0;
        }
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        char[] cArr;
        int i = getAuthRequestContext + 89;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (!(str2 == null)) {
            cArr = str2.toCharArray();
            int i3 = MyBillsEntityDataFactory + 13;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        } else {
            cArr = null;
        }
        return openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        int i = getAuthRequestContext + 85;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        SQLiteDatabase openDatabase = openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook);
        int i3 = MyBillsEntityDataFactory + 117;
        getAuthRequestContext = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 17 / 0;
            return openDatabase;
        }
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        int i = getAuthRequestContext + 21;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        SQLiteDatabase openDatabase = openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
        int i3 = MyBillsEntityDataFactory + 73;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        SQLiteDatabase openDatabase;
        int i = getAuthRequestContext + 125;
        MyBillsEntityDataFactory = i % 128;
        Object obj = null;
        if (i % 2 != 0) {
            openDatabase = openDatabase(str, bArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
        } else {
            openDatabase = openDatabase(str, bArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, (DatabaseErrorHandler) null);
            obj.hashCode();
        }
        int i2 = getAuthRequestContext + 33;
        MyBillsEntityDataFactory = i2 % 128;
        if (i2 % 2 != 0) {
            return openDatabase;
        }
        obj.hashCode();
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        int i = MyBillsEntityDataFactory + 85;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            SQLiteDatabase openDatabase = openDatabase(str, bArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
            Object obj = null;
            obj.hashCode();
            return openDatabase;
        }
        return openDatabase(str, bArr, cursorFactory, (int) CREATE_IF_NECESSARY, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory) {
        SQLiteDatabase openOrCreateDatabase;
        int i = MyBillsEntityDataFactory + 81;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? 'H' : (char) 7) != 7) {
            try {
                openOrCreateDatabase = openOrCreateDatabase(file, str, cursorFactory, (SQLiteDatabaseHook) null);
                int i2 = 85 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            openOrCreateDatabase = openOrCreateDatabase(file, str, cursorFactory, (SQLiteDatabaseHook) null);
        }
        int i3 = MyBillsEntityDataFactory + 93;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory) {
        int i = MyBillsEntityDataFactory + 79;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Object[] objArr = null;
        SQLiteDatabase openDatabase = openDatabase(str, str2, cursorFactory, (int) CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
        int i3 = MyBillsEntityDataFactory + 83;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 != 0 ? 'K' : Typography.dollar) != '$') {
            int length = objArr.length;
            return openDatabase;
        }
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory) {
        int i = getAuthRequestContext + 41;
        MyBillsEntityDataFactory = i % 128;
        char c = i % 2 == 0 ? (char) 24 : '7';
        Object obj = null;
        SQLiteDatabase openDatabase = openDatabase(str, cArr, cursorFactory, (int) CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null);
        if (c != '7') {
            obj.hashCode();
        }
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory) {
        int i = MyBillsEntityDataFactory + 73;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        SQLiteDatabase openDatabase = openDatabase(str, bArr, cursorFactory, (int) CREATE_IF_NECESSARY, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
        int i3 = MyBillsEntityDataFactory + 31;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return openDatabase;
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, String str) {
        char[] cArr;
        int i = getAuthRequestContext + 73;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (!(str == null)) {
            cArr = str.toCharArray();
        } else {
            int i3 = MyBillsEntityDataFactory + 27;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            cArr = null;
        }
        return openDatabase(MEMORY, cArr, cursorFactory, (int) CREATE_IF_NECESSARY);
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, char[] cArr) {
        int i = MyBillsEntityDataFactory + 71;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? 'X' : (char) 11) != 'X') {
            return openDatabase(MEMORY, cArr, cursorFactory, (int) CREATE_IF_NECESSARY);
        }
        SQLiteDatabase openDatabase = openDatabase(MEMORY, cArr, cursorFactory, (int) CREATE_IF_NECESSARY);
        int i2 = 43 / 0;
        return openDatabase;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i = getAuthRequestContext + 39;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (!isOpen()) {
            int i3 = getAuthRequestContext + 85;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        try {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void closeClosable() {
        Iterator<Map.Entry<SQLiteClosable, Object>> it;
        SQLiteClosable key;
        int i = MyBillsEntityDataFactory + 91;
        getAuthRequestContext = i % 128;
        if (!(i % 2 != 0)) {
            deallocCachedSqlStatements();
            it = this.mPrograms.entrySet().iterator();
        } else {
            deallocCachedSqlStatements();
            it = this.mPrograms.entrySet().iterator();
            int i2 = 49 / 0;
        }
        while (true) {
            if ((it.hasNext() ? Typography.amp : (char) 23) == 23) {
                return;
            }
            try {
                int i3 = getAuthRequestContext + 125;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    key = it.next().getKey();
                    Object obj = null;
                    obj.hashCode();
                    if (key != null) {
                        key.onAllReferencesReleasedFromContainer();
                        int i4 = MyBillsEntityDataFactory + 5;
                        getAuthRequestContext = i4 % 128;
                        int i5 = i4 % 2;
                    }
                } else {
                    key = it.next().getKey();
                    if (key != null) {
                        key.onAllReferencesReleasedFromContainer();
                        int i42 = MyBillsEntityDataFactory + 5;
                        getAuthRequestContext = i42 % 128;
                        int i52 = i42 % 2;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        if (isOpen() != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r0 = new net.sqlcipher.database.SQLiteStatement(r5, "PRAGMA user_version;");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        r2 = (int) r0.simpleQueryForLong();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        r0.close();
        unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        throw new java.lang.IllegalStateException("database not open");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
    
        r3 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        r3 = '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        if (r3 == '^') goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        r2 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 125;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        if ((r2 % 2) == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        r2 = '*';
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        r2 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        if (r2 != 'O') goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        r1 = 86 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0072, code lost:
    
        r1 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory + 7;
        net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007f, code lost:
    
        unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r0 != false) goto L13;
     */
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getVersion() {
        /*
            r5 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 31
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L1c
            r5.lock()
            boolean r0 = r5.isOpen()     // Catch: java.lang.Throwable -> L1a
            r1.hashCode()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L3d
            goto L25
        L1a:
            r0 = move-exception
            goto L45
        L1c:
            r5.lock()     // Catch: java.lang.Exception -> L83
            boolean r0 = r5.isOpen()     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L3d
        L25:
            net.sqlcipher.database.SQLiteStatement r0 = new net.sqlcipher.database.SQLiteStatement     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "PRAGMA user_version;"
            r0.<init>(r5, r2)     // Catch: java.lang.Throwable -> L1a
            long r1 = r0.simpleQueryForLong()     // Catch: java.lang.Throwable -> L38
            int r2 = (int) r1
            r0.close()     // Catch: java.lang.Exception -> L83
            r5.unlock()     // Catch: java.lang.Exception -> L83
            return r2
        L38:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L45
        L3d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "database not open"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L1a
            throw r0     // Catch: java.lang.Throwable -> L1a
        L45:
            r2 = 94
            if (r1 == 0) goto L4c
            r3 = 94
            goto L4e
        L4c:
            r3 = 55
        L4e:
            if (r3 != r2) goto L7f
            int r2 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r2 = r2 + 125
            int r3 = r2 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r3
            int r2 = r2 % 2
            r3 = 79
            if (r2 != 0) goto L61
            r2 = 42
            goto L63
        L61:
            r2 = 79
        L63:
            if (r2 == r3) goto L6f
            r1.close()
            r1 = 86
            int r1 = r1 / 0
            goto L72
        L6d:
            r0 = move-exception
            throw r0
        L6f:
            r1.close()
        L72:
            int r1 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L7d
            int r1 = r1 + 7
            int r2 = r1 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r2     // Catch: java.lang.Exception -> L7d
            int r1 = r1 % 2
            goto L7f
        L7d:
            r0 = move-exception
            throw r0
        L7f:
            r5.unlock()
            throw r0
        L83:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getVersion():int");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("PRAGMA user_version = ");
            sb.append(i);
            execSQL(sb.toString());
            int i2 = MyBillsEntityDataFactory + 91;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        Throwable th;
        SQLiteStatement sQLiteStatement;
        int i = getAuthRequestContext + 115;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        lock();
        try {
            if (!isOpen()) {
                throw new IllegalStateException("database not open");
            }
            sQLiteStatement = new SQLiteStatement(this, "PRAGMA max_page_count;");
            try {
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                long pageSize = getPageSize();
                try {
                    sQLiteStatement.close();
                    unlock();
                    return simpleQueryForLong * pageSize;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th2) {
                th = th2;
                if ((sQLiteStatement != null ? (char) 15 : (char) 27) == 15) {
                    sQLiteStatement.close();
                    int i3 = getAuthRequestContext + 101;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                }
                unlock();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            sQLiteStatement = null;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j) {
        Throwable th;
        SQLiteStatement sQLiteStatement;
        try {
            int i = getAuthRequestContext + 57;
            try {
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                lock();
                Object obj = null;
                try {
                    if (!isOpen()) {
                        throw new IllegalStateException("database not open");
                    }
                    int i3 = MyBillsEntityDataFactory + 51;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    long pageSize = getPageSize();
                    long j2 = j / pageSize;
                    if (j % pageSize != 0) {
                        int i5 = MyBillsEntityDataFactory + 107;
                        getAuthRequestContext = i5 % 128;
                        int i6 = i5 % 2;
                        j2++;
                        int i7 = getAuthRequestContext + 23;
                        MyBillsEntityDataFactory = i7 % 128;
                        int i8 = i7 % 2;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("PRAGMA max_page_count = ");
                    sb.append(j2);
                    sQLiteStatement = new SQLiteStatement(this, sb.toString());
                    try {
                        long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                        sQLiteStatement.close();
                        unlock();
                        return simpleQueryForLong * pageSize;
                    } catch (Throwable th2) {
                        th = th2;
                        if (sQLiteStatement != null) {
                            int i9 = getAuthRequestContext + 113;
                            MyBillsEntityDataFactory = i9 % 128;
                            if (!(i9 % 2 != 0)) {
                                sQLiteStatement.close();
                                obj.hashCode();
                            } else {
                                sQLiteStatement.close();
                            }
                        }
                        unlock();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteStatement = null;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        Throwable th;
        SQLiteStatement sQLiteStatement;
        int i = MyBillsEntityDataFactory + 75;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            lock();
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                sQLiteStatement = new SQLiteStatement(this, "PRAGMA page_size;");
                try {
                    long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                    sQLiteStatement.close();
                    unlock();
                    return simpleQueryForLong;
                } catch (Throwable th2) {
                    th = th2;
                    if (!(sQLiteStatement == null)) {
                        int i3 = getAuthRequestContext + 19;
                        MyBillsEntityDataFactory = i3 % 128;
                        int i4 = i3 % 2;
                        sQLiteStatement.close();
                    }
                    unlock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("PRAGMA page_size = ");
        sb.append(j);
        execSQL(sb.toString());
        int i = getAuthRequestContext + 101;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            return;
        }
        int i2 = 21 / 0;
    }

    public void markTableSyncable(String str, String str2) {
        if ((isOpen() ? (char) 4 : 'F') != 4) {
            throw new SQLiteException("database not open");
        }
        int i = getAuthRequestContext + 7;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        markTableSyncable(str, FieldType.FOREIGN_ID_FIELD_SUFFIX, str, str2);
        int i3 = MyBillsEntityDataFactory + 107;
        getAuthRequestContext = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public void markTableSyncable(String str, String str2, String str3) {
        if ((isOpen() ? ';' : (char) 14) == ';') {
            int i = getAuthRequestContext + 125;
            MyBillsEntityDataFactory = i % 128;
            char c = i % 2 == 0 ? '\n' : (char) 14;
            markTableSyncable(str, str2, str3, null);
            if (c != 14) {
                int i2 = 83 / 0;
            }
            int i3 = getAuthRequestContext + 113;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return;
        }
        throw new SQLiteException("database not open");
    }

    private void markTableSyncable(String str, String str2, String str3, String str4) {
        lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT _sync_dirty FROM ");
            sb.append(str3);
            sb.append(" LIMIT 0");
            native_execSQL(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SELECT ");
            sb2.append(str2);
            sb2.append(" FROM ");
            sb2.append(str);
            sb2.append(" LIMIT 0");
            native_execSQL(sb2.toString());
            unlock();
            SyncUpdateInfo syncUpdateInfo = new SyncUpdateInfo(str3, str4, str2);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(str, syncUpdateInfo);
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rowUpdated(String str, long j) {
        SyncUpdateInfo syncUpdateInfo;
        synchronized (this.mSyncUpdateInfo) {
            syncUpdateInfo = this.mSyncUpdateInfo.get(str);
        }
        if (syncUpdateInfo != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append(syncUpdateInfo.masterTable);
            sb.append(" SET _sync_dirty=1 WHERE _id=(SELECT ");
            sb.append(syncUpdateInfo.foreignKey);
            sb.append(" FROM ");
            sb.append(str);
            sb.append(" WHERE _id=");
            sb.append(j);
            sb.append(")");
            execSQL(sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
    
        if ((r1 < 0) != true) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005a, code lost:
    
        if ((r0 >= 0) != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String findEditTable(java.lang.String r6) {
        /*
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L76
            int r0 = r0 + 31
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L74
            int r0 = r0 % 2
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L6c
            r0 = 32
            int r0 = r6.indexOf(r0)
            r1 = 44
            int r1 = r6.indexOf(r1)
            r2 = 1
            r3 = 0
            if (r0 <= 0) goto L48
            int r4 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L76
            int r4 = r4 + 63
            int r5 = r4 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r5     // Catch: java.lang.Exception -> L74
            int r4 = r4 % 2
            if (r0 < r1) goto L2e
            r4 = 1
            goto L2f
        L2e:
            r4 = 0
        L2f:
            if (r4 == 0) goto L43
            int r4 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r4 = r4 + 81
            int r5 = r4 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r5
            int r4 = r4 % 2
            if (r1 >= 0) goto L3f
            r4 = 1
            goto L40
        L3f:
            r4 = 0
        L40:
            if (r4 == r2) goto L43
            goto L48
        L43:
            java.lang.String r6 = r6.substring(r3, r0)
            return r6
        L48:
            if (r1 <= 0) goto L4c
            r4 = 0
            goto L4d
        L4c:
            r4 = 1
        L4d:
            if (r4 == 0) goto L50
            goto L61
        L50:
            if (r1 < r0) goto L54
            r4 = 1
            goto L55
        L54:
            r4 = 0
        L55:
            if (r4 == 0) goto L5d
            if (r0 >= 0) goto L5a
            r2 = 0
        L5a:
            if (r2 == 0) goto L5d
            goto L61
        L5d:
            java.lang.String r6 = r6.substring(r3, r1)
        L61:
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 83
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return r6
        L6c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Invalid tables"
            r6.<init>(r0)     // Catch: java.lang.Exception -> L76
            throw r6     // Catch: java.lang.Exception -> L76
        L74:
            r6 = move-exception
            throw r6
        L76:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.findEditTable(java.lang.String):java.lang.String");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SQLiteStatement compileStatement(String str) throws SQLException {
        try {
            int i = MyBillsEntityDataFactory + 43;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            lock();
            try {
                if (!isOpen()) {
                    throw new IllegalStateException("database not open");
                }
                SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str);
                unlock();
                int i3 = getAuthRequestContext + 91;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    Object obj = null;
                    obj.hashCode();
                    return sQLiteStatement;
                }
                return sQLiteStatement;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        int i = getAuthRequestContext + 23;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Cursor queryWithFactory = queryWithFactory(null, z, str, strArr, str2, strArr2, str3, str4, str5, str6);
        int i3 = getAuthRequestContext + 119;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return queryWithFactory;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return queryWithFactory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r3 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 3;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if ((r3 % 2) != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        if (r3 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        r2 = 79 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        return rawQueryWithFactory(r14, net.sqlcipher.database.SQLiteQueryBuilder.buildQueryString(r15, r16, r17, r18, r20, r21, r22, r23), r19, findEditTable(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        throw new java.lang.IllegalStateException("database not open");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return rawQueryWithFactory(r14, net.sqlcipher.database.SQLiteQueryBuilder.buildQueryString(r15, r16, r17, r18, r20, r21, r22, r23), r19, findEditTable(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (isOpen() != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public net.sqlcipher.Cursor queryWithFactory(net.sqlcipher.database.SQLiteDatabase.CursorFactory r14, boolean r15, java.lang.String r16, java.lang.String[] r17, java.lang.String r18, java.lang.String[] r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            r13 = this;
            r1 = r13
            r0 = r14
            r2 = r19
            int r3 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r3 = r3 + 43
            int r4 = r3 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r4
            int r3 = r3 % 2
            r4 = 53
            if (r3 == 0) goto L15
            r3 = 53
            goto L17
        L15:
            r3 = 56
        L17:
            if (r3 == r4) goto L23
            boolean r3 = r13.isOpen()     // Catch: java.lang.Exception -> L20
            if (r3 == 0) goto L7f
            goto L2d
        L20:
            r0 = move-exception
            r2 = r0
            throw r2
        L23:
            boolean r3 = r13.isOpen()
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L87
            if (r3 == 0) goto L7f
        L2d:
            int r3 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r3 = r3 + 3
            int r4 = r3 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r4
            int r3 = r3 % 2
            r4 = 0
            if (r3 != 0) goto L3c
            r3 = 0
            goto L3d
        L3c:
            r3 = 1
        L3d:
            if (r3 == 0) goto L5b
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            java.lang.String r3 = net.sqlcipher.database.SQLiteQueryBuilder.buildQueryString(r3, r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r4 = findEditTable(r16)
            net.sqlcipher.Cursor r0 = r13.rawQueryWithFactory(r14, r3, r2, r4)
            goto L79
        L5b:
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            java.lang.String r3 = net.sqlcipher.database.SQLiteQueryBuilder.buildQueryString(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L7d
            java.lang.String r5 = findEditTable(r16)     // Catch: java.lang.Exception -> L7d
            net.sqlcipher.Cursor r0 = r13.rawQueryWithFactory(r14, r3, r2, r5)     // Catch: java.lang.Exception -> L7d
            r2 = 79
            int r2 = r2 / r4
        L79:
            return r0
        L7a:
            r0 = move-exception
            r2 = r0
            throw r2
        L7d:
            r0 = move-exception
            throw r0
        L7f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "database not open"
            r0.<init>(r2)
            throw r0
        L87:
            r0 = move-exception
            r2 = r0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.queryWithFactory(net.sqlcipher.database.SQLiteDatabase$CursorFactory, boolean, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String):net.sqlcipher.Cursor");
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        int i = MyBillsEntityDataFactory + 91;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '!' : '/') != '!') {
            return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
        }
        try {
            return query(true, str, strArr, str2, strArr2, str3, str4, str5, null);
        } catch (Exception e) {
            throw e;
        }
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        int i = MyBillsEntityDataFactory + 71;
        getAuthRequestContext = i % 128;
        Cursor query = (i % 2 != 0 ? InputCardNumberView.DIVIDER : (char) 4) != ' ' ? query(false, str, strArr, str2, strArr2, str3, str4, str5, str6) : query(true, str, strArr, str2, strArr2, str3, str4, str5, str6);
        int i2 = MyBillsEntityDataFactory + 79;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return query;
    }

    public Cursor rawQuery(String str, String[] strArr) {
        int i = getAuthRequestContext + 117;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Cursor rawQueryWithFactory = rawQueryWithFactory(null, str, strArr, null);
            int i3 = getAuthRequestContext + 23;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return rawQueryWithFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public SQLiteQueryStats getQueryStats(String str, Object[] objArr) {
        int i = getAuthRequestContext + 99;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            execSQL(String.format("CREATE TABLE tempstat AS %s", str), objArr);
            Cursor rawQuery = rawQuery("SELECT sum(payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (rawQuery == null) {
                return new SQLiteQueryStats(0L, 0L);
            }
            rawQuery.moveToFirst();
            long j = rawQuery.getLong(0);
            rawQuery.close();
            Cursor rawQuery2 = rawQuery("SELECT max(mx_payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);
            if (rawQuery2 == null) {
                return new SQLiteQueryStats(j, 0L);
            }
            rawQuery2.moveToFirst();
            long j2 = rawQuery2.getLong(0);
            rawQuery2.close();
            execSQL("DROP TABLE tempstat;");
            SQLiteQueryStats sQLiteQueryStats = new SQLiteQueryStats(j, j2);
            int i3 = getAuthRequestContext + 13;
            MyBillsEntityDataFactory = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
                return sQLiteQueryStats;
            }
            return sQLiteQueryStats;
        } catch (SQLiteException e) {
            execSQL("DROP TABLE IF EXISTS tempstat;");
            throw e;
        }
    }

    public Cursor rawQuery(String str, Object[] objArr) {
        if (isOpen()) {
            int i = MyBillsEntityDataFactory + 13;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            long j = 0;
            int i3 = -1;
            if (!(this.mSlowQueryThreshold == -1)) {
                try {
                    j = System.currentTimeMillis();
                } catch (Exception e) {
                    throw e;
                }
            }
            Object[] objArr2 = null;
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, null);
            try {
                Cursor query = sQLiteDirectCursorDriver.query(this.mFactory, objArr);
                if (this.mSlowQueryThreshold != -1) {
                    int i4 = getAuthRequestContext + 9;
                    MyBillsEntityDataFactory = i4 % 128;
                    int i5 = i4 % 2;
                    if (query != null) {
                        int i6 = getAuthRequestContext + 61;
                        MyBillsEntityDataFactory = i6 % 128;
                        if (i6 % 2 != 0) {
                            i3 = query.getCount();
                        } else {
                            i3 = query.getCount();
                            int length = objArr2.length;
                        }
                    }
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    if (currentTimeMillis >= this.mSlowQueryThreshold) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("query (");
                        sb.append(currentTimeMillis);
                        sb.append(" ms): ");
                        sb.append(sQLiteDirectCursorDriver.toString());
                        sb.append(", args are <redacted>, count is ");
                        sb.append(i3);
                        InstrumentInjector.log_v(TAG, sb.toString());
                    }
                }
                return new CrossProcessCursorWrapper(query);
            } finally {
                if (this.mSlowQueryThreshold != -1) {
                    long currentTimeMillis2 = System.currentTimeMillis() - j;
                    if (currentTimeMillis2 >= this.mSlowQueryThreshold) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("query (");
                        sb2.append(currentTimeMillis2);
                        sb2.append(" ms): ");
                        sb2.append(sQLiteDirectCursorDriver.toString());
                        sb2.append(", args are <redacted>, count is ");
                        sb2.append(-1);
                        InstrumentInjector.log_v(TAG, sb2.toString());
                    }
                }
            }
        }
        throw new IllegalStateException("database not open");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if ((r10.mSlowQueryThreshold != -1) != true) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r10.mSlowQueryThreshold != (-1)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 79;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if ((r0 % 2) != 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        r2 = java.lang.System.currentTimeMillis();
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        r0 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        r2 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        r0 = new net.sqlcipher.database.SQLiteDirectCursorDriver(r10, r12, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r11 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        r11 = r10.mFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        r11 = r0.query(r11, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r10.mSlowQueryThreshold == (-1)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        if (r11 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0064, code lost:
    
        if (r1 == true) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:
    
        r5 = r11.getCount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        r8 = java.lang.System.currentTimeMillis() - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        if (r8 < r10.mSlowQueryThreshold) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
    
        r13 = new java.lang.StringBuilder();
        r13.append("query (");
        r13.append(r8);
        r13.append(" ms): ");
        r13.append(r0.toString());
        r13.append(", args are <redacted>, count is ");
        r13.append(r5);
        com.fullstory.instrumentation.InstrumentInjector.log_v(net.sqlcipher.database.SQLiteDatabase.TAG, r13.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009d, code lost:
    
        return new net.sqlcipher.CrossProcessCursorWrapper(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009e, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a1, code lost:
    
        if (r10.mSlowQueryThreshold != (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a3, code lost:
    
        r8 = java.lang.System.currentTimeMillis() - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
    
        if (r8 >= r10.mSlowQueryThreshold) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00af, code lost:
    
        r13 = new java.lang.StringBuilder();
        r13.append("query (");
        r13.append(r8);
        r13.append(" ms): ");
        r13.append(r0.toString());
        r13.append(", args are <redacted>, count is ");
        r13.append(-1);
        com.fullstory.instrumentation.InstrumentInjector.log_v(net.sqlcipher.database.SQLiteDatabase.TAG, r13.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d1, code lost:
    
        throw r11;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public net.sqlcipher.Cursor rawQueryWithFactory(net.sqlcipher.database.SQLiteDatabase.CursorFactory r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.rawQueryWithFactory(net.sqlcipher.database.SQLiteDatabase$CursorFactory, java.lang.String, java.lang.String[], java.lang.String):net.sqlcipher.Cursor");
    }

    public Cursor rawQuery(String str, String[] strArr, int i, int i2) {
        int i3 = getAuthRequestContext + 1;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        try {
            CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, str, strArr, null);
            ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(i, i2);
            int i5 = MyBillsEntityDataFactory + 97;
            getAuthRequestContext = i5 % 128;
            int i6 = i5 % 2;
            return cursorWrapper;
        } catch (Exception e) {
            throw e;
        }
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        int i = MyBillsEntityDataFactory + 57;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
        }
        try {
            long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 0);
            int i2 = getAuthRequestContext + 5;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return insertWithOnConflict;
        } catch (SQLException unused) {
            return -1L;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        int i = MyBillsEntityDataFactory + 125;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 0);
        int i3 = getAuthRequestContext + 125;
        MyBillsEntityDataFactory = i3 % 128;
        if (i3 % 2 != 0) {
            return insertWithOnConflict;
        }
        Object obj = null;
        obj.hashCode();
        return insertWithOnConflict;
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        int i = MyBillsEntityDataFactory + 79;
        getAuthRequestContext = i % 128;
        try {
            return i % 2 != 0 ? insertWithOnConflict(str, str2, contentValues, 3) : insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException unused) {
            return -1L;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        int i = getAuthRequestContext + 23;
        MyBillsEntityDataFactory = i % 128;
        long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, i % 2 != 0 ? 5 : 4);
        int i2 = MyBillsEntityDataFactory + 119;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return insertWithOnConflict;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd A[Catch: all -> 0x0123, SQLiteDatabaseCorruptException -> 0x0126, TRY_LEAVE, TryCatch #6 {SQLiteDatabaseCorruptException -> 0x0126, all -> 0x0123, blocks: (B:26:0x00bf, B:34:0x00de, B:27:0x00c9, B:35:0x00ee, B:40:0x00fd), top: B:78:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [net.sqlcipher.database.SQLiteProgram] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long insertWithOnConflict(java.lang.String r6, java.lang.String r7, android.content.ContentValues r8, int r9) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.insertWithOnConflict(java.lang.String, java.lang.String, android.content.ContentValues, int):long");
    }

    public int delete(String str, String str2, String[] strArr) {
        int i = getAuthRequestContext + 85;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        int delete = delete(str, str2, (Object[]) strArr);
        int i3 = MyBillsEntityDataFactory + 113;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return delete;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String str, String str2, Object[] objArr) {
        String str3;
        try {
            lock();
            AutoCloseable autoCloseable = null;
            try {
                try {
                    if (isOpen()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("DELETE FROM ");
                        sb.append(str);
                        if (TextUtils.isEmpty(str2)) {
                            str3 = "";
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" WHERE ");
                            sb2.append(str2);
                            str3 = sb2.toString();
                            int i = MyBillsEntityDataFactory + 91;
                            getAuthRequestContext = i % 128;
                            int i2 = i % 2;
                        }
                        sb.append(str3);
                        SQLiteStatement compileStatement = compileStatement(sb.toString());
                        if ((objArr != null ? ';' : '`') != '`') {
                            int length = objArr.length;
                            int i3 = 0;
                            while (i3 < length) {
                                int i4 = i3 + 1;
                                DatabaseUtils.bindObjectToProgram(compileStatement, i4, objArr[i3]);
                                int i5 = getAuthRequestContext + 1;
                                MyBillsEntityDataFactory = i5 % 128;
                                int i6 = i5 % 2;
                                i3 = i4;
                            }
                        }
                        compileStatement.execute();
                        int lastChangeCount = lastChangeCount();
                        if (compileStatement != null) {
                            compileStatement.close();
                        }
                        unlock();
                        return lastChangeCount;
                    }
                    throw new IllegalStateException("database not open");
                } catch (SQLiteDatabaseCorruptException e) {
                    onCorruption();
                    throw e;
                }
            } catch (Throwable th) {
                if (!(0 == 0)) {
                    int i7 = MyBillsEntityDataFactory + 121;
                    getAuthRequestContext = i7 % 128;
                    int i8 = i7 % 2;
                    autoCloseable.close();
                }
                unlock();
                throw th;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        try {
            int i = getAuthRequestContext + 119;
            MyBillsEntityDataFactory = i % 128;
            int updateWithOnConflict = (i % 2 == 0 ? '[' : '^') != '^' ? updateWithOnConflict(str, contentValues, str2, strArr, 1) : updateWithOnConflict(str, contentValues, str2, strArr, 0);
            try {
                int i2 = MyBillsEntityDataFactory + 117;
                getAuthRequestContext = i2 % 128;
                if ((i2 % 2 != 0 ? '8' : (char) 28) != 28) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return updateWithOnConflict;
                }
                return updateWithOnConflict;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [net.sqlcipher.database.SQLiteProgram] */
    public int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        ?? r1;
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("UPDATE ");
        sb.append(CONFLICT_VALUES[i]);
        sb.append(str);
        sb.append(" SET ");
        Set<Map.Entry<String, Object>> valueSet = contentValues.valueSet();
        Iterator<Map.Entry<String, Object>> it = valueSet.iterator();
        while (true) {
            r1 = 0;
            if (!it.hasNext()) {
                break;
            }
            sb.append(it.next().getKey());
            sb.append("=?");
            if (it.hasNext()) {
                int i2 = MyBillsEntityDataFactory + 45;
                getAuthRequestContext = i2 % 128;
                if (i2 % 2 != 0) {
                    sb.append(", ");
                    int length = r1.length;
                } else {
                    sb.append(", ");
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        try {
            lock();
            try {
                try {
                    try {
                        if ((isOpen() ? 'E' : '*') != 'E') {
                            throw new IllegalStateException("database not open");
                        }
                        SQLiteStatement compileStatement = compileStatement(sb.toString());
                        int size = valueSet.size();
                        Iterator<Map.Entry<String, Object>> it2 = valueSet.iterator();
                        int i3 = 0;
                        int i4 = 1;
                        while (i3 < size) {
                            DatabaseUtils.bindObjectToProgram(compileStatement, i4, it2.next().getValue());
                            i4++;
                            i3++;
                            try {
                                int i5 = getAuthRequestContext + 49;
                                MyBillsEntityDataFactory = i5 % 128;
                                int i6 = i5 % 2;
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        if (strArr != null) {
                            int length2 = strArr.length;
                            int i7 = 0;
                            while (true) {
                                if ((i7 < length2 ? '#' : (char) 19) != '#') {
                                    break;
                                }
                                compileStatement.bindString(i4, strArr[i7]);
                                i4++;
                                i7++;
                            }
                        }
                        compileStatement.execute();
                        int lastChangeCount = lastChangeCount();
                        if (compileStatement != null) {
                            compileStatement.close();
                        }
                        unlock();
                        return lastChangeCount;
                    } catch (SQLiteDatabaseCorruptException e2) {
                        onCorruption();
                        throw e2;
                    }
                } catch (SQLException e3) {
                    throw e3;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    r1.close();
                }
                unlock();
                throw th;
            }
        } catch (Exception e4) {
            throw e4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if ((r0) == true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        if (isOpen() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        native_execSQL(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        unlock();
        r3 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 107;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        throw new java.lang.IllegalStateException("database not open");
     */
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void execSQL(java.lang.String r3) throws net.sqlcipher.SQLException {
        /*
            r2 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L5e
            int r0 = r0 + 81
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L5e
            int r0 = r0 % 2
            r1 = 28
            if (r0 == 0) goto L11
            r0 = 17
            goto L13
        L11:
            r0 = 28
        L13:
            if (r0 == r1) goto L2e
            android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Exception -> L2c
            r2.lock()     // Catch: java.lang.Exception -> L5e
            boolean r0 = r2.isOpen()     // Catch: java.lang.Throwable -> L53 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L55
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L53 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L55
            r1 = 1
            if (r0 == 0) goto L28
            r0 = 1
            goto L29
        L28:
            r0 = 0
        L29:
            if (r0 != r1) goto L4b
            goto L3a
        L2c:
            r3 = move-exception
            throw r3
        L2e:
            android.os.SystemClock.uptimeMillis()
            r2.lock()
            boolean r0 = r2.isOpen()     // Catch: java.lang.Throwable -> L53 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L55
            if (r0 == 0) goto L4b
        L3a:
            r2.native_execSQL(r3)     // Catch: java.lang.Throwable -> L53 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L55
            r2.unlock()
            int r3 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r3 = r3 + 107
            int r0 = r3 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0
            int r3 = r3 % 2
            return
        L4b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L53 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L55
            java.lang.String r0 = "database not open"
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L53 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L55
            throw r3     // Catch: java.lang.Throwable -> L53 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L55
        L53:
            r3 = move-exception
            goto L5a
        L55:
            r3 = move-exception
            r2.onCorruption()     // Catch: java.lang.Throwable -> L53
            throw r3     // Catch: java.lang.Throwable -> L53
        L5a:
            r2.unlock()
            throw r3
        L5e:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.execSQL(java.lang.String):void");
    }

    public void rawExecSQL(String str) {
        int i = MyBillsEntityDataFactory + 53;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        SystemClock.uptimeMillis();
        lock();
        try {
            try {
                if ((isOpen() ? 'C' : (char) 24) != 'C') {
                    throw new IllegalStateException("database not open");
                }
                int i3 = getAuthRequestContext + 37;
                MyBillsEntityDataFactory = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    native_rawExecSQL(str);
                    unlock();
                    Object[] objArr = null;
                    int length = objArr.length;
                    return;
                }
                native_rawExecSQL(str);
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            }
        } finally {
            unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r10 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        if ((r10 == null) != true) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        r4 = r9;
        r9 = r10.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        if (r5 >= r9) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0043, code lost:
    
        r7 = 28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        r7 = 'M';
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        if (r7 == 28) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
    
        r6 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
    
        if ((r6 % 2) != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        r6 = r5 * 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0058, code lost:
    
        r5 = r10[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005b, code lost:
    
        r6 = r5 + 1;
        r5 = r10[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005f, code lost:
    
        net.sqlcipher.DatabaseUtils.bindObjectToProgram(r4, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0062, code lost:
    
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0064, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0065, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0066, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0067, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0068, code lost:
    
        r4 = r9;
     */
    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void execSQL(java.lang.String r9, java.lang.Object[] r10) throws net.sqlcipher.SQLException {
        /*
            r8 = this;
            r0 = 75
            r1 = 2
            if (r10 == 0) goto L8
            r2 = 75
            goto L9
        L8:
            r2 = 2
        L9:
            if (r2 != r0) goto L99
            android.os.SystemClock.uptimeMillis()
            r8.lock()
            r2 = 0
            r3 = 1
            r4 = 0
            boolean r5 = r8.isOpen()     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            if (r5 == 0) goto L7e
            int r5 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r5 = r5 + 97
            int r6 = r5 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r6
            int r5 = r5 % r1
            if (r5 == 0) goto L31
            net.sqlcipher.database.SQLiteStatement r9 = r8.compileStatement(r9)     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            r4.hashCode()     // Catch: java.lang.Throwable -> L2f
            if (r10 == 0) goto L68
            goto L3c
        L2f:
            r9 = move-exception
            throw r9
        L31:
            net.sqlcipher.database.SQLiteStatement r9 = r8.compileStatement(r9)     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            if (r10 == 0) goto L39
            r4 = 0
            goto L3a
        L39:
            r4 = 1
        L3a:
            if (r4 == r3) goto L68
        L3c:
            r4 = r9
            int r9 = r10.length     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            r5 = 0
        L3f:
            r6 = 28
            if (r5 >= r9) goto L46
            r7 = 28
            goto L48
        L46:
            r7 = 77
        L48:
            if (r7 == r6) goto L4b
            goto L69
        L4b:
            int r6 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext     // Catch: java.lang.Exception -> L66
            int r6 = r6 + r0
            int r7 = r6 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r7     // Catch: java.lang.Exception -> L64
            int r6 = r6 % 2
            if (r6 != 0) goto L5b
            int r6 = r5 * 1
            r5 = r10[r5]     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            goto L5f
        L5b:
            int r6 = r5 + 1
            r5 = r10[r5]     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
        L5f:
            net.sqlcipher.DatabaseUtils.bindObjectToProgram(r4, r6, r5)     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            r5 = r6
            goto L3f
        L64:
            r9 = move-exception
            throw r9
        L66:
            r9 = move-exception
            throw r9
        L68:
            r4 = r9
        L69:
            r4.execute()     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            if (r4 == 0) goto L7a
            int r9 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r9 = r9 + 59
            int r10 = r9 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r10
            int r9 = r9 % r1
            r4.close()
        L7a:
            r8.unlock()
            return
        L7e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            java.lang.String r10 = "database not open"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
            throw r9     // Catch: java.lang.Throwable -> L86 net.sqlcipher.database.SQLiteDatabaseCorruptException -> L88
        L86:
            r9 = move-exception
            goto L8d
        L88:
            r9 = move-exception
            r8.onCorruption()     // Catch: java.lang.Throwable -> L86
            throw r9     // Catch: java.lang.Throwable -> L86
        L8d:
            if (r4 == 0) goto L90
            r2 = 1
        L90:
            if (r2 == 0) goto L95
            r4.close()
        L95:
            r8.unlock()
            throw r9
        L99:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Empty bindArgs"
            r9.<init>(r10)
            goto La2
        La1:
            throw r9
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.execSQL(java.lang.String, java.lang.Object[]):void");
    }

    protected void finalize() {
        Object[] objArr = null;
        if ((isOpen() ? 'P' : (char) 4) != 4) {
            int i = getAuthRequestContext + 97;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 == 0) {
                closeClosable();
                onAllReferencesReleased();
                objArr.hashCode();
            } else {
                closeClosable();
                onAllReferencesReleased();
            }
        }
        int i2 = MyBillsEntityDataFactory + 79;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 != 0) {
            int length = objArr.length;
        }
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        this(str, cursorFactory, i, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, (SQLiteDatabaseHook) null);
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i, (DatabaseErrorHandler) null);
        openDatabaseInternal(cArr, sQLiteDatabaseHook);
    }

    public SQLiteDatabase(String str, byte[] bArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i, (DatabaseErrorHandler) null);
        openDatabaseInternal(bArr, sQLiteDatabaseHook);
    }

    private SQLiteDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0L;
        this.mLockAcquiredThreadTime = 0L;
        this.mLastLockMessageTime = 0L;
        Object obj = null;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0L;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = 250;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (str == null) {
            try {
                throw new IllegalArgumentException("path should not be null");
            } catch (Exception e) {
                throw e;
            }
        }
        this.mFlags = i;
        this.mPath = str;
        this.mSlowQueryThreshold = -1;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mFactory = cursorFactory;
        this.mPrograms = new WeakHashMap<>();
        this.mErrorHandler = databaseErrorHandler;
        int i2 = getAuthRequestContext + 79;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 == 0 ? '(' : '_') != '(') {
            return;
        }
        obj.hashCode();
    }

    private void openDatabaseInternal(char[] cArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        int i = MyBillsEntityDataFactory + 97;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        openDatabaseInternal(getBytes(cArr), sQLiteDatabaseHook);
        int i3 = getAuthRequestContext + 21;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void openDatabaseInternal(final byte[] r6, net.sqlcipher.database.SQLiteDatabaseHook r7) {
        /*
            r5 = this;
            java.lang.String r0 = r5.mPath
            int r1 = r5.mFlags
            r5.dbopen(r0, r1)
            r0 = 1
            r1 = 0
            net.sqlcipher.database.SQLiteDatabase$2 r2 = new net.sqlcipher.database.SQLiteDatabase$2     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L14
            r2.<init>()     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L14
            r5.keyDatabase(r7, r2)     // Catch: java.lang.Throwable -> L12 java.lang.RuntimeException -> L14
            return
        L12:
            r6 = move-exception
            goto L67
        L14:
            r2 = move-exception
            char[] r3 = getChars(r6)     // Catch: java.lang.Throwable -> L12
            boolean r4 = r5.containsNull(r3)     // Catch: java.lang.Throwable -> L12
            if (r4 == 0) goto L66
            net.sqlcipher.database.SQLiteDatabase$3 r2 = new net.sqlcipher.database.SQLiteDatabase$3     // Catch: java.lang.Throwable -> L12
            r2.<init>()     // Catch: java.lang.Throwable -> L12
            r5.keyDatabase(r7, r2)     // Catch: java.lang.Throwable -> L12
            if (r6 == 0) goto L2b
            r7 = 1
            goto L2c
        L2b:
            r7 = 0
        L2c:
            if (r7 == 0) goto L4f
            int r7 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L8b
            int r7 = r7 + 123
            int r2 = r7 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r2     // Catch: java.lang.Exception -> L8b
            int r7 = r7 % 2
            int r7 = r6.length     // Catch: java.lang.Throwable -> L12
            r2 = 3
            if (r7 <= 0) goto L3f
            r7 = 29
            goto L40
        L3f:
            r7 = 3
        L40:
            if (r7 == r2) goto L4f
            r5.rekey(r6)     // Catch: java.lang.Throwable -> L12
            int r6 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r6 = r6 + 85
            int r7 = r6 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r7
            int r6 = r6 % 2
        L4f:
            if (r3 == 0) goto L65
            int r6 = r3.length     // Catch: java.lang.Throwable -> L62
            r7 = 34
            if (r6 <= 0) goto L59
            r6 = 34
            goto L5b
        L59:
            r6 = 70
        L5b:
            if (r6 == r7) goto L5e
            goto L65
        L5e:
            java.util.Arrays.fill(r3, r1)     // Catch: java.lang.Throwable -> L62
            return
        L62:
            r6 = move-exception
            r0 = 0
            goto L67
        L65:
            return
        L66:
            throw r2     // Catch: java.lang.Throwable -> L12
        L67:
            if (r0 == 0) goto L8d
            int r7 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r7 = r7 + 59
            int r0 = r7 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0
            int r7 = r7 % 2
            r5.dbclose()
            boolean r7 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE
            if (r7 == 0) goto L8d
            int r7 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L8b
            int r7 = r7 + 101
            int r0 = r7 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r0     // Catch: java.lang.Exception -> L8b
            int r7 = r7 % 2
            java.lang.String r7 = r5.getTime()
            r5.mTimeClosed = r7
            goto L8d
        L8b:
            r6 = move-exception
            throw r6
        L8d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabaseInternal(byte[], net.sqlcipher.database.SQLiteDatabaseHook):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if (r7 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean containsNull(char[] r7) {
        /*
            r6 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 51
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 28
            if (r0 != 0) goto L11
            r0 = 29
            goto L13
        L11:
            r0 = 28
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1a
            if (r7 == 0) goto L4d
            goto L1c
        L1a:
            if (r7 == 0) goto L4c
        L1c:
            int r0 = r7.length
            if (r0 <= 0) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 == 0) goto L4c
            int r0 = r7.length
            r1 = 0
        L26:
            if (r1 >= r0) goto L4c
            int r4 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r4 = r4 + 9
            int r5 = r4 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r5
            int r4 = r4 % 2
            char r4 = r7[r1]
            r5 = 13
            if (r4 != 0) goto L3b
            r4 = 13
            goto L3c
        L3b:
            r4 = 5
        L3c:
            if (r4 == r5) goto L41
            int r1 = r1 + 1
            goto L26
        L41:
            int r7 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r7 = r7 + 117
            int r0 = r7 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0
            int r7 = r7 % 2
            goto L4d
        L4c:
            r2 = 0
        L4d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.containsNull(char[]):boolean");
    }

    private void keyDatabase(SQLiteDatabaseHook sQLiteDatabaseHook, Runnable runnable) {
        int i = getAuthRequestContext + 77;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if ((sQLiteDatabaseHook != null ? 'X' : 'c') != 'c') {
            int i3 = MyBillsEntityDataFactory + 67;
            getAuthRequestContext = i3 % 128;
            if (i3 % 2 == 0) {
                sQLiteDatabaseHook.preKey(this);
            } else {
                try {
                    sQLiteDatabaseHook.preKey(this);
                    int i4 = 95 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        if (!(sQLiteDatabaseHook == null)) {
            int i5 = getAuthRequestContext + 83;
            MyBillsEntityDataFactory = i5 % 128;
            if (i5 % 2 != 0) {
                sQLiteDatabaseHook.postKey(this);
            } else {
                sQLiteDatabaseHook.postKey(this);
                Object[] objArr = null;
                int length = objArr.length;
            }
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            int i6 = MyBillsEntityDataFactory + 79;
            getAuthRequestContext = i6 % 128;
            int i7 = i6 % 2;
            this.mTimeOpened = getTime();
        }
        try {
            Cursor rawQuery = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if ((rawQuery != null ? (char) 14 : 'I') != 'I') {
                rawQuery.moveToFirst();
                rawQuery.getInt(0);
                rawQuery.close();
            }
        } catch (RuntimeException e2) {
            throw e2;
        }
    }

    private String getTime() {
        try {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
            int i = getAuthRequestContext + 19;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 == 0 ? (char) 16 : Typography.dollar) != '$') {
                int i2 = 73 / 0;
                return format;
            }
            return format;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        boolean z;
        if ((this.mFlags & 1) != 1) {
            int i = MyBillsEntityDataFactory + 85;
            getAuthRequestContext = i % 128;
            z = i % 2 != 0;
            int i2 = MyBillsEntityDataFactory + 83;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
        } else {
            z = true;
        }
        int i4 = MyBillsEntityDataFactory + 125;
        getAuthRequestContext = i4 % 128;
        if (i4 % 2 == 0) {
            return z;
        }
        int i5 = 14 / 0;
        return z;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        int i = getAuthRequestContext + 113;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            if (!(this.mNativeHandle != 0)) {
                return false;
            }
            int i3 = MyBillsEntityDataFactory + 109;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i) {
        try {
            if (!(i <= getVersion())) {
                int i2 = getAuthRequestContext + 95;
                MyBillsEntityDataFactory = i2 % 128;
                if (i2 % 2 == 0) {
                }
                return true;
            }
            int i3 = getAuthRequestContext + 73;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        try {
            int i = MyBillsEntityDataFactory + 121;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            String str = this.mPath;
            int i3 = MyBillsEntityDataFactory + 69;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if ((r0 == null) != true) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        r1 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 15;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r0 = r4.mPath;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 53;
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
    
        if ((r0 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        r2 = 0 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        if (r0.indexOf(64) != (-1)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        r4.mPathForLogs = r4.mPath;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        r4.mPathForLogs = net.sqlcipher.database.SQLiteDatabase.EMAIL_IN_DB_PATTERN.matcher(r4.mPath).replaceAll("XX@YY");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        r0 = r4.mPathForLogs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r2 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext + 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
    
        if ((r2 % 2) != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0079, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getPathForLogs() {
        /*
            r4 = this;
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L7c
            int r0 = r0 + 21
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L7c
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L1d
            java.lang.String r0 = r4.mPathForLogs
            if (r0 == 0) goto L19
            r3 = 0
            goto L1a
        L19:
            r3 = 1
        L1a:
            if (r3 == r1) goto L2f
            goto L24
        L1d:
            java.lang.String r0 = r4.mPathForLogs
            r1 = 41
            int r1 = r1 / r2
            if (r0 == 0) goto L2f
        L24:
            int r1 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r1 = r1 + 15
            int r2 = r1 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r2
            int r1 = r1 % 2
            return r0
        L2f:
            java.lang.String r0 = r4.mPath
            r1 = 0
            if (r0 != 0) goto L45
            int r0 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r0 = r0 + 53
            int r3 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L44
            int r2 = r2 / r2
            return r1
        L42:
            r0 = move-exception
            throw r0
        L44:
            return r1
        L45:
            r2 = 64
            int r0 = r0.indexOf(r2)
            r2 = -1
            if (r0 != r2) goto L53
            java.lang.String r0 = r4.mPath
            r4.mPathForLogs = r0
            goto L63
        L53:
            java.util.regex.Pattern r0 = net.sqlcipher.database.SQLiteDatabase.EMAIL_IN_DB_PATTERN
            java.lang.String r2 = r4.mPath
            java.util.regex.Matcher r0 = r0.matcher(r2)
            java.lang.String r2 = "XX@YY"
            java.lang.String r0 = r0.replaceAll(r2)
            r4.mPathForLogs = r0
        L63:
            java.lang.String r0 = r4.mPathForLogs     // Catch: java.lang.Exception -> L78
            int r2 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext     // Catch: java.lang.Exception -> L78
            int r2 = r2 + 31
            int r3 = r2 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L78
            int r2 = r2 % 2
            if (r2 != 0) goto L77
            r1.hashCode()     // Catch: java.lang.Throwable -> L75
            return r0
        L75:
            r0 = move-exception
            throw r0
        L77:
            return r0
        L78:
            r0 = move-exception
            throw r0
        L7a:
            r0 = move-exception
            throw r0
        L7c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getPathForLogs():java.lang.String");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        int i = getAuthRequestContext + 27;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
            unlock();
            int i3 = getAuthRequestContext + 11;
            MyBillsEntityDataFactory = i3 % 128;
            if ((i3 % 2 == 0 ? '!' : ',') != ',') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addToCompiledQueries(String str, SQLiteCompiledSql sQLiteCompiledSql) {
        if (this.mMaxSqlCacheSize == 0) {
            boolean z = SQLiteDebug.DEBUG_SQL_CACHE;
            return;
        }
        synchronized (this.mCompiledQueries) {
            if (this.mCompiledQueries.get(str) != null) {
                return;
            }
            if (this.mCompiledQueries.size() == this.mMaxSqlCacheSize) {
                this.mCacheFullWarnings++;
            } else {
                this.mCompiledQueries.put(str, sQLiteCompiledSql);
                boolean z2 = SQLiteDebug.DEBUG_SQL_CACHE;
            }
        }
    }

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            Iterator<SQLiteCompiledSql> it = this.mCompiledQueries.values().iterator();
            while (it.hasNext()) {
                it.next().releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCompiledSql getCompiledStatementForSql(String str) {
        synchronized (this.mCompiledQueries) {
            if (this.mMaxSqlCacheSize == 0) {
                boolean z = SQLiteDebug.DEBUG_SQL_CACHE;
                return null;
            }
            SQLiteCompiledSql sQLiteCompiledSql = this.mCompiledQueries.get(str);
            boolean z2 = sQLiteCompiledSql != null;
            if (z2) {
                this.mNumCacheHits++;
            } else {
                this.mNumCacheMisses++;
            }
            boolean z3 = SQLiteDebug.DEBUG_SQL_CACHE;
            return sQLiteCompiledSql;
        }
    }

    public boolean isInCompiledSqlCache(String str) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(str);
        }
        return containsKey;
    }

    public void purgeFromCompiledSqlCache(String str) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(str);
        }
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    public int getMaxSqlCacheSize() {
        int i;
        synchronized (this) {
            i = this.mMaxSqlCacheSize;
        }
        return i;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i) {
        synchronized (this) {
            if (i > 250 || i < 0) {
                throw new IllegalStateException("expected value between 0 and 250");
            }
            if (i < this.mMaxSqlCacheSize) {
                throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
            }
            this.mMaxSqlCacheSize = i;
        }
    }

    public static byte[] getBytes(char[] cArr) {
        try {
            int i = MyBillsEntityDataFactory + 45;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                if (!(cArr != null)) {
                    return null;
                }
                if (cArr.length != 0) {
                    CharBuffer wrap = CharBuffer.wrap(cArr);
                    Object[] objArr = new Object[1];
                    a(ViewConfiguration.getKeyRepeatTimeout() >> 16, Color.alpha(0) + 5, (char) (31769 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), objArr);
                    ByteBuffer encode = Charset.forName(((String) objArr[0]).intern()).encode(wrap);
                    byte[] bArr = new byte[encode.limit()];
                    encode.get(bArr);
                    int i3 = MyBillsEntityDataFactory + 45;
                    getAuthRequestContext = i3 % 128;
                    if (i3 % 2 != 0) {
                        int i4 = 21 / 0;
                        return bArr;
                    }
                    return bArr;
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if ((r1 != 0 ? '@' : '4') != '@') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0029, code lost:
    
        if ((r6.length != 0) != true) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
    
        r6 = java.nio.ByteBuffer.wrap(r6);
        r3 = new java.lang.Object[1];
        a(android.view.ViewConfiguration.getPressedStateDuration() >> 16, android.widget.ExpandableListView.getPackedPositionChild(0) + 6, (char) ((android.view.ViewConfiguration.getTouchSlop() >> 8) + 31768), r3);
        r6 = java.nio.charset.Charset.forName(((java.lang.String) r3[0]).intern()).decode(r6);
        r0 = new char[r6.limit()];
        r6.get(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static char[] getChars(byte[] r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L66
            int r1 = net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext
            int r1 = r1 + 107
            int r2 = r1 % 128
            net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory = r2
            int r1 = r1 % 2
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L23
            int r1 = r6.length
            r0.hashCode()     // Catch: java.lang.Throwable -> L21
            r4 = 64
            if (r1 == 0) goto L1c
            r1 = 64
            goto L1e
        L1c:
            r1 = 52
        L1e:
            if (r1 == r4) goto L2c
            goto L66
        L21:
            r6 = move-exception
            throw r6
        L23:
            int r1 = r6.length
            if (r1 == 0) goto L28
            r1 = 1
            goto L29
        L28:
            r1 = 0
        L29:
            if (r1 == r3) goto L2c
            goto L66
        L2c:
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)     // Catch: java.lang.Exception -> L71
            int r0 = android.view.ViewConfiguration.getPressedStateDuration()     // Catch: java.lang.Exception -> L71
            int r0 = r0 >> 16
            r4 = 0
            int r1 = android.widget.ExpandableListView.getPackedPositionChild(r4)     // Catch: java.lang.Exception -> L71
            int r1 = r1 + 6
            int r4 = android.view.ViewConfiguration.getTouchSlop()     // Catch: java.lang.Exception -> L71
            int r4 = r4 >> 8
            int r4 = r4 + 31768
            char r4 = (char) r4     // Catch: java.lang.Exception -> L71
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L71
            a(r0, r1, r4, r3)     // Catch: java.lang.Exception -> L71
            r0 = r3[r2]     // Catch: java.lang.Exception -> L71
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L71
            java.lang.String r0 = r0.intern()     // Catch: java.lang.Exception -> L71
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch: java.lang.Exception -> L71
            java.nio.CharBuffer r6 = r0.decode(r6)     // Catch: java.lang.Exception -> L71
            int r0 = r6.limit()     // Catch: java.lang.Exception -> L71
            char[] r0 = new char[r0]     // Catch: java.lang.Exception -> L71
            r6.get(r0)     // Catch: java.lang.Exception -> L71
            return r0
        L66:
            int r6 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L71
            int r6 = r6 + 89
            int r1 = r6 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1     // Catch: java.lang.Exception -> L71
            int r6 = r6 % 2
            return r0
        L71:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getChars(byte[]):char[]");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(String str) {
        int i = getAuthRequestContext + 35;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        Cursor rawQuery = rawQuery(str, (String[]) null);
        int i3 = MyBillsEntityDataFactory + 39;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return rawQuery;
    }

    public android.database.Cursor query(String str, Object[] objArr) {
        int i = getAuthRequestContext + 63;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            Cursor rawQuery = rawQuery(str, objArr);
            try {
                int i3 = MyBillsEntityDataFactory + 47;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 != 0) {
                    Object[] objArr2 = null;
                    int length = objArr2.length;
                    return rawQuery;
                }
                return rawQuery;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        int i = getAuthRequestContext + 33;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            int i2 = 96 / 0;
            return query(supportSQLiteQuery, (CancellationSignal) null);
        }
        try {
            return query(supportSQLiteQuery, (CancellationSignal) null);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        try {
            String KClassImpl$Data$declaredNonStaticMembers$22 = supportSQLiteQuery.KClassImpl$Data$declaredNonStaticMembers$2();
            Object[] objArr = new Object[supportSQLiteQuery.getAuthRequestContext()];
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, KClassImpl$Data$declaredNonStaticMembers$22, null);
            SQLiteQuery sQLiteQuery = new SQLiteQuery(this, KClassImpl$Data$declaredNonStaticMembers$22, 0, objArr);
            supportSQLiteQuery.getAuthRequestContext(sQLiteQuery);
            CrossProcessCursorWrapper crossProcessCursorWrapper = new CrossProcessCursorWrapper(new SQLiteCursor(this, sQLiteDirectCursorDriver, null, sQLiteQuery));
            int i = MyBillsEntityDataFactory + 117;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            return crossProcessCursorWrapper;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String str, int i, ContentValues contentValues) throws android.database.SQLException {
        long insertWithOnConflict;
        int i2 = getAuthRequestContext + 9;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 14 : (char) 5) != 14) {
            try {
                insertWithOnConflict = insertWithOnConflict(str, null, contentValues, i);
            } catch (Exception e) {
                throw e;
            }
        } else {
            insertWithOnConflict = insertWithOnConflict(str, null, contentValues, i);
            int i3 = 89 / 0;
        }
        int i4 = getAuthRequestContext + 55;
        MyBillsEntityDataFactory = i4 % 128;
        int i5 = i4 % 2;
        return insertWithOnConflict;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        String[] strArr;
        int i2;
        int i3 = getAuthRequestContext + 23;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? Typography.amp : (char) 30) != 30) {
            strArr = new String[objArr.length];
            i2 = 1;
        } else {
            strArr = new String[objArr.length];
            i2 = 0;
        }
        while (true) {
            if (!(i2 < objArr.length)) {
                int updateWithOnConflict = updateWithOnConflict(str, contentValues, str2, strArr, i);
                int i4 = getAuthRequestContext + 39;
                MyBillsEntityDataFactory = i4 % 128;
                int i5 = i4 % 2;
                return updateWithOnConflict;
            }
            int i6 = getAuthRequestContext + 53;
            MyBillsEntityDataFactory = i6 % 128;
            if (i6 % 2 == 0) {
                try {
                    strArr[i2] = objArr[i2].toString();
                    i2 += 104;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                strArr[i2] = objArr[i2].toString();
                i2++;
            }
            throw e;
        }
    }

    public void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        beginTransactionWithListener(new SQLiteTransactionListener() { // from class: net.sqlcipher.database.SQLiteDatabase.4
            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.sqlcipher.database.SQLiteTransactionListener
            public void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        });
        int i = getAuthRequestContext + 105;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
    }

    public void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        try {
            beginTransactionWithListenerNonExclusive(new SQLiteTransactionListener() { // from class: net.sqlcipher.database.SQLiteDatabase.5
                @Override // net.sqlcipher.database.SQLiteTransactionListener
                public void onBegin() {
                    sQLiteTransactionListener.onBegin();
                }

                @Override // net.sqlcipher.database.SQLiteTransactionListener
                public void onCommit() {
                    sQLiteTransactionListener.onCommit();
                }

                @Override // net.sqlcipher.database.SQLiteTransactionListener
                public void onRollback() {
                    sQLiteTransactionListener.onRollback();
                }
            });
            int i = MyBillsEntityDataFactory + 119;
            getAuthRequestContext = i % 128;
            if ((i % 2 != 0 ? (char) 19 : 'B') != 19) {
                return;
            }
            int i2 = 16 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r4.mLock.getHoldCount() > 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void beginTransactionWithListenerInternal(net.sqlcipher.database.SQLiteTransactionListener r5, net.sqlcipher.database.SQLiteDatabase.SQLiteDatabaseTransactionType r6) {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.beginTransactionWithListenerInternal(net.sqlcipher.database.SQLiteTransactionListener, net.sqlcipher.database.SQLiteDatabase$SQLiteDatabaseTransactionType):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<net.sqlcipher.database.SQLiteDebug.DbStats> getDbStats() {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getDbStats():java.util.ArrayList");
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<>();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    private static long getPragmaVal(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            SQLiteStatement sQLiteStatement = null;
            if ((!sQLiteDatabase.isOpen() ? '+' : '%') != '+') {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("PRAGMA ");
                    sb.append(str);
                    SQLiteStatement sQLiteStatement2 = new SQLiteStatement(sQLiteDatabase, sb.toString());
                    try {
                        long simpleQueryForLong = sQLiteStatement2.simpleQueryForLong();
                        sQLiteStatement2.close();
                        return simpleQueryForLong;
                    } catch (Throwable th) {
                        th = th;
                        sQLiteStatement = sQLiteStatement2;
                        if (sQLiteStatement != null) {
                            int i = getAuthRequestContext + 19;
                            MyBillsEntityDataFactory = i % 128;
                            int i2 = i % 2;
                            sQLiteStatement.close();
                            int i3 = MyBillsEntityDataFactory + 107;
                            try {
                                getAuthRequestContext = i3 % 128;
                                int i4 = i3 % 2;
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                int i5 = MyBillsEntityDataFactory + 79;
                getAuthRequestContext = i5 % 128;
                long j = i5 % 2 != 0 ? 1L : 0L;
                int i6 = MyBillsEntityDataFactory + 5;
                getAuthRequestContext = i6 % 128;
                if (!(i6 % 2 == 0)) {
                    sQLiteStatement.hashCode();
                    return j;
                }
                return j;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if ((!r0 ? 2 : '_') != '_') goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        r6 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory + 13;
        net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        r0 = new java.util.ArrayList<>();
        r6 = r6.rawQuery("pragma database_list;", (java.lang.String[]) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (r6.moveToNext() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r0.add(new android.util.Pair<>(r6.getString(1), r6.getString(2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r6.isOpen() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> getAttachedDbs(net.sqlcipher.database.SQLiteDatabase r6) {
        /*
            int r0 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r0 = r0 + 3
            int r1 = r0 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 31
            r3 = 1
            if (r0 == 0) goto L12
            r0 = 31
            goto L13
        L12:
            r0 = 1
        L13:
            r4 = 0
            if (r0 == r2) goto L1d
            boolean r0 = r6.isOpen()
            if (r0 != 0) goto L36
            goto L2c
        L1d:
            boolean r0 = r6.isOpen()     // Catch: java.lang.Exception -> L60
            int r2 = r4.length     // Catch: java.lang.Throwable -> L5e
            r2 = 95
            if (r0 != 0) goto L28
            r0 = 2
            goto L2a
        L28:
            r0 = 95
        L2a:
            if (r0 == r2) goto L36
        L2c:
            int r6 = net.sqlcipher.database.SQLiteDatabase.MyBillsEntityDataFactory
            int r6 = r6 + 13
            int r0 = r6 % 128
            net.sqlcipher.database.SQLiteDatabase.getAuthRequestContext = r0
            int r6 = r6 % r1
            return r4
        L36:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r2 = "pragma database_list;"
            net.sqlcipher.Cursor r6 = r6.rawQuery(r2, r4)
        L41:
            boolean r2 = r6.moveToNext()     // Catch: java.lang.Exception -> L5c
            if (r2 == 0) goto L58
            android.util.Pair r2 = new android.util.Pair
            java.lang.String r4 = r6.getString(r3)     // Catch: java.lang.Exception -> L60
            java.lang.String r5 = r6.getString(r1)     // Catch: java.lang.Exception -> L5c
            r2.<init>(r4, r5)     // Catch: java.lang.Exception -> L5c
            r0.add(r2)     // Catch: java.lang.Exception -> L5c
            goto L41
        L58:
            r6.close()
            return r0
        L5c:
            r6 = move-exception
            throw r6
        L5e:
            r6 = move-exception
            throw r6
        L60:
            r6 = move-exception
            goto L63
        L62:
            throw r6
        L63:
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getAttachedDbs(net.sqlcipher.database.SQLiteDatabase):java.util.ArrayList");
    }

    private Pair<Boolean, String> getResultFromPragma(String str) {
        Cursor rawQuery;
        try {
            int i = getAuthRequestContext + 17;
            try {
                MyBillsEntityDataFactory = i % 128;
                if ((i % 2 == 0 ? '\t' : '0') == '0' ? (rawQuery = rawQuery(str, new Object[0])) == null : (rawQuery = rawQuery(str, new Object[1])) == null) {
                    return new Pair<>(Boolean.FALSE, "");
                }
                rawQuery.moveToFirst();
                String string = rawQuery.getString(0);
                rawQuery.close();
                Pair<Boolean, String> pair = new Pair<>(Boolean.TRUE, string);
                int i2 = MyBillsEntityDataFactory + 53;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                return pair;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (!(whenavailable.BuiltInFictitiousFunctionClassFactory < i2)) {
                break;
            }
            int i3 = $10 + 15;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (KClassImpl$Data$declaredNonStaticMembers$2[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BuiltInFictitiousFunctionClassFactory))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            try {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? 'V' : (char) 24) != 'V') {
                    objArr[0] = new String(cArr);
                    return;
                }
                int i5 = $11 + 91;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
