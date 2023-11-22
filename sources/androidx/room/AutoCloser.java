package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.arch.core.util.Function;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AutoCloser {
    final Executor KClassImpl$Data$declaredNonStaticMembers$2;
    SupportSQLiteDatabase PlaceComponentResult;
    final long getAuthRequestContext;
    SupportSQLiteOpenHelper MyBillsEntityDataFactory = null;
    private final Handler NetworkUserEntityData$$ExternalSyntheticLambda1 = new Handler(Looper.getMainLooper());
    Runnable NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    final Object lookAheadTest = new Object();
    int scheduleImpl = 0;
    long getErrorConfigVersion = SystemClock.uptimeMillis();
    boolean moveToNextValue = false;
    private final Runnable DatabaseTableConfigUtil = new Runnable() { // from class: androidx.room.AutoCloser.1
        @Override // java.lang.Runnable
        public void run() {
            AutoCloser.this.KClassImpl$Data$declaredNonStaticMembers$2.execute(AutoCloser.this.BuiltInFictitiousFunctionClassFactory);
        }
    };
    final Runnable BuiltInFictitiousFunctionClassFactory = new Runnable() { // from class: androidx.room.AutoCloser.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (AutoCloser.this.lookAheadTest) {
                if (SystemClock.uptimeMillis() - AutoCloser.this.getErrorConfigVersion < AutoCloser.this.getAuthRequestContext) {
                    return;
                }
                if (AutoCloser.this.scheduleImpl != 0) {
                    return;
                }
                if (AutoCloser.this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                    AutoCloser.this.NetworkUserEntityData$$ExternalSyntheticLambda0.run();
                    if (AutoCloser.this.PlaceComponentResult != null && AutoCloser.this.PlaceComponentResult.isOpen()) {
                        try {
                            AutoCloser.this.PlaceComponentResult.close();
                        } catch (IOException e) {
                            SneakyThrow.BuiltInFictitiousFunctionClassFactory(e);
                        }
                        AutoCloser.this.PlaceComponentResult = null;
                    }
                    return;
                }
                throw new IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoCloser(long j, TimeUnit timeUnit, Executor executor) {
        this.getAuthRequestContext = timeUnit.toMillis(j);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = executor;
    }

    public final <V> V PlaceComponentResult(Function<SupportSQLiteDatabase, V> function) {
        try {
            return function.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2());
        } finally {
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    public final SupportSQLiteDatabase KClassImpl$Data$declaredNonStaticMembers$2() {
        synchronized (this.lookAheadTest) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.removeCallbacks(this.DatabaseTableConfigUtil);
            this.scheduleImpl++;
            if (this.moveToNextValue) {
                throw new IllegalStateException("Attempting to open already closed database.");
            }
            SupportSQLiteDatabase supportSQLiteDatabase = this.PlaceComponentResult;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                return this.PlaceComponentResult;
            }
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.MyBillsEntityDataFactory;
            if (supportSQLiteOpenHelper != null) {
                SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
                this.PlaceComponentResult = writableDatabase;
                return writableDatabase;
            }
            throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this.lookAheadTest) {
            int i = this.scheduleImpl;
            if (i <= 0) {
                throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
            }
            int i2 = i - 1;
            this.scheduleImpl = i2;
            if (i2 == 0) {
                if (this.PlaceComponentResult == null) {
                    return;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.postDelayed(this.DatabaseTableConfigUtil, this.getAuthRequestContext);
            }
        }
    }

    public final SupportSQLiteDatabase MyBillsEntityDataFactory() {
        SupportSQLiteDatabase supportSQLiteDatabase;
        synchronized (this.lookAheadTest) {
            supportSQLiteDatabase = this.PlaceComponentResult;
        }
        return supportSQLiteDatabase;
    }

    public final boolean getAuthRequestContext() {
        return !this.moveToNextValue;
    }
}
