package net.sqlcipher.database;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes9.dex */
public abstract class SQLiteOpenHelper {
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mDeferSetWriteAheadLoggingEnabled;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(context, str, cursorFactory, i, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (i <= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Version must be >= 1, was ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (databaseErrorHandler == null) {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        } else {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i;
            this.mHook = sQLiteDatabaseHook;
            this.mErrorHandler = databaseErrorHandler;
        }
    }

    public SQLiteDatabase getWritableDatabase(String str) {
        SQLiteDatabase writableDatabase;
        synchronized (this) {
            writableDatabase = getWritableDatabase(str == null ? null : str.toCharArray());
        }
        return writableDatabase;
    }

    public SQLiteDatabase getWritableDatabase(char[] cArr) {
        SQLiteDatabase writableDatabase;
        synchronized (this) {
            writableDatabase = getWritableDatabase(cArr == null ? null : SQLiteDatabase.getBytes(cArr));
        }
        return writableDatabase;
    }

    public SQLiteDatabase getWritableDatabase(byte[] bArr) {
        SQLiteDatabase openOrCreateDatabase;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                return this.mDatabase;
            } else if (this.mIsInitializing) {
                throw new IllegalStateException("getWritableDatabase called recursively");
            } else {
                SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.lock();
                }
                SQLiteDatabase sQLiteDatabase3 = null;
                try {
                    this.mIsInitializing = true;
                    String str = this.mName;
                    if (str == null) {
                        openOrCreateDatabase = SQLiteDatabase.create((SQLiteDatabase.CursorFactory) null, "");
                    } else {
                        String path = this.mContext.getDatabasePath(str).getPath();
                        File file = new File(path);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                        }
                        openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(path, bArr, this.mFactory, this.mHook, this.mErrorHandler);
                    }
                    sQLiteDatabase3 = openOrCreateDatabase;
                    if (this.mDeferSetWriteAheadLoggingEnabled) {
                        this.mEnableWriteAheadLogging = sQLiteDatabase3.enableWriteAheadLogging();
                    }
                    onConfigure(sQLiteDatabase3);
                    int version = sQLiteDatabase3.getVersion();
                    if (version != this.mNewVersion) {
                        sQLiteDatabase3.beginTransaction();
                        try {
                            if (version == 0) {
                                onCreate(sQLiteDatabase3);
                            } else {
                                int i = this.mNewVersion;
                                if (version > i) {
                                    onDowngrade(sQLiteDatabase3, version, i);
                                } else {
                                    onUpgrade(sQLiteDatabase3, version, i);
                                }
                            }
                            sQLiteDatabase3.setVersion(this.mNewVersion);
                            sQLiteDatabase3.setTransactionSuccessful();
                            sQLiteDatabase3.endTransaction();
                        } catch (Throwable th) {
                            sQLiteDatabase3.endTransaction();
                            throw th;
                        }
                    }
                    onOpen(sQLiteDatabase3);
                    this.mIsInitializing = false;
                    SQLiteDatabase sQLiteDatabase4 = this.mDatabase;
                    if (sQLiteDatabase4 != null) {
                        try {
                            sQLiteDatabase4.close();
                        } catch (Exception unused) {
                        }
                        this.mDatabase.unlock();
                    }
                    this.mDatabase = sQLiteDatabase3;
                    return sQLiteDatabase3;
                } catch (Throwable th2) {
                    this.mIsInitializing = false;
                    SQLiteDatabase sQLiteDatabase5 = this.mDatabase;
                    if (sQLiteDatabase5 != null) {
                        sQLiteDatabase5.unlock();
                    }
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.close();
                    }
                    throw th2;
                }
            }
        }
    }

    public SQLiteDatabase getReadableDatabase(String str) {
        SQLiteDatabase readableDatabase;
        synchronized (this) {
            readableDatabase = getReadableDatabase(str == null ? null : str.toCharArray());
        }
        return readableDatabase;
    }

    public SQLiteDatabase getReadableDatabase(char[] cArr) {
        SQLiteDatabase readableDatabase;
        synchronized (this) {
            readableDatabase = getReadableDatabase(cArr == null ? null : SQLiteDatabase.getBytes(cArr));
        }
        return readableDatabase;
    }

    public SQLiteDatabase getReadableDatabase(byte[] bArr) {
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                return this.mDatabase;
            } else if (this.mIsInitializing) {
                throw new IllegalStateException("getReadableDatabase called recursively");
            } else {
                try {
                    return getWritableDatabase(bArr);
                } catch (SQLiteException e) {
                    if (this.mName == null) {
                        throw e;
                    }
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Couldn't open ");
                    sb.append(this.mName);
                    sb.append(" for writing (will try read-only):");
                    InstrumentInjector.log_e(str, sb.toString(), e);
                    AutoCloseable autoCloseable = null;
                    try {
                        this.mIsInitializing = true;
                        String path = this.mContext.getDatabasePath(this.mName).getPath();
                        File file = new File(path);
                        File file2 = new File(this.mContext.getDatabasePath(this.mName).getParent());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        if (!file.exists()) {
                            this.mIsInitializing = false;
                            SQLiteDatabase writableDatabase = getWritableDatabase(bArr);
                            this.mIsInitializing = true;
                            writableDatabase.close();
                        }
                        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(path, bArr, this.mFactory, 1, this.mHook, this.mErrorHandler);
                        if (openDatabase.getVersion() != this.mNewVersion) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Can't upgrade read-only database from version ");
                            sb2.append(openDatabase.getVersion());
                            sb2.append(" to ");
                            sb2.append(this.mNewVersion);
                            sb2.append(": ");
                            sb2.append(path);
                            throw new SQLiteException(sb2.toString());
                        }
                        onOpen(openDatabase);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Opened ");
                        sb3.append(this.mName);
                        sb3.append(" in read-only mode");
                        InstrumentInjector.log_w(str, sb3.toString());
                        this.mDatabase = openDatabase;
                        this.mIsInitializing = false;
                        return openDatabase;
                    } catch (Throwable th) {
                        this.mIsInitializing = false;
                        if (0 != 0 && null != this.mDatabase) {
                            autoCloseable.close();
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public void close() {
        synchronized (this) {
            if (this.mIsInitializing) {
                throw new IllegalStateException("Closed during initialization");
            }
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.close();
                this.mDatabase = null;
            }
        }
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != z) {
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                    if (z) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                    this.mEnableWriteAheadLogging = z;
                } else {
                    this.mDeferSetWriteAheadLoggingEnabled = z;
                }
            }
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Can't downgrade database from version ");
        sb.append(i);
        sb.append(" to ");
        sb.append(i2);
        throw new SQLiteException(sb.toString());
    }
}
