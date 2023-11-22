package net.sqlcipher.database;

import android.util.Log;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public final class SQLiteDebug {
    public static final boolean DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
    public static final boolean DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);
    public static final boolean DEBUG_SQL_CACHE = Log.isLoggable("SQLiteCompiledSql", 2);
    public static final boolean DEBUG_ACTIVE_CURSOR_FINALIZATION = Log.isLoggable("SQLiteCursorClosing", 2);
    public static final boolean DEBUG_LOCK_TIME_TRACKING = Log.isLoggable("SQLiteLockTime", 2);
    public static final boolean DEBUG_LOCK_TIME_TRACKING_STACK_TRACE = Log.isLoggable("SQLiteLockStackTrace", 2);
    private static int sNumActiveCursorsFinalized = 0;

    /* loaded from: classes9.dex */
    public static class PagerStats {
        @Deprecated
        public long databaseBytes;
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        @Deprecated
        public int numPagers;
        public int pageCacheOverflo;
        @Deprecated
        public long referencedBytes;
        @Deprecated
        public long totalBytes;
    }

    public static native long getHeapAllocatedSize();

    public static native void getHeapDirtyPages(int[] iArr);

    public static native long getHeapFreeSize();

    public static native long getHeapSize();

    public static native void getPagerStats(PagerStats pagerStats);

    /* loaded from: classes9.dex */
    public static class DbStats {
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String str, long j, long j2, int i) {
            this.dbName = str;
            this.pageSize = j2;
            this.dbSize = (j * j2) / ConvertUtils.KB;
            this.lookaside = i;
        }
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats pagerStats = new PagerStats();
        getPagerStats(pagerStats);
        pagerStats.dbStats = SQLiteDatabase.getDbStats();
        return pagerStats;
    }

    public static int getNumActiveCursorsFinalized() {
        return sNumActiveCursorsFinalized;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void notifyActiveCursorFinalized() {
        synchronized (SQLiteDebug.class) {
            sNumActiveCursorsFinalized++;
        }
    }
}
