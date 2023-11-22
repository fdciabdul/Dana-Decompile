package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.j256.ormlite.field.FieldType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;

/* loaded from: classes6.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private String[] mColumns;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    protected MainThreadNotificationHandler mNotificationHandler;
    private SQLiteQuery mQuery;
    private int mCount = -1;
    private int mCursorWindowCapacity = 0;
    private boolean fillWindowForwardOnly = false;
    private int mMaxRead = Integer.MAX_VALUE;
    private int mInitialRead = Integer.MAX_VALUE;
    private int mCursorState = 0;
    private ReentrantLock mLock = null;
    private boolean mPendingData = false;
    private Throwable mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    private Map<String, Integer> mColumnNameMap = null;

    public void setFillWindowForwardOnly(boolean z) {
        this.fillWindowForwardOnly = z;
    }

    public void setLoadStyle(int i, int i2) {
        this.mMaxRead = i2;
        this.mInitialRead = i;
        this.mLock = new ReentrantLock(true);
    }

    private void queryThreadLock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.lock();
        }
    }

    private void queryThreadUnlock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class QueryThread implements Runnable {
        private final int mThreadState;

        QueryThread(int i) {
            this.mThreadState = i;
        }

        private void sendMessage() {
            if (SQLiteCursor.this.mNotificationHandler == null) {
                SQLiteCursor.this.mPendingData = true;
                return;
            }
            SQLiteCursor.this.mNotificationHandler.sendEmptyMessage(1);
            SQLiteCursor.this.mPendingData = false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0077, code lost:
        
            r4.this$0.mCount = r1;
            sendMessage();
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r4 = this;
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                net.sqlcipher.CursorWindow r0 = net.sqlcipher.database.SQLiteCursor.access$100(r0)
                int r1 = android.os.Process.myTid()
                r2 = 10
                android.os.Process.setThreadPriority(r1, r2)
            Lf:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                if (r1 != 0) goto L22
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r2 = new java.util.concurrent.locks.ReentrantLock
                r3 = 1
                r2.<init>(r3)
                net.sqlcipher.database.SQLiteCursor.access$202(r1, r2)
            L22:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.lock()
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                int r1 = net.sqlcipher.database.SQLiteCursor.access$300(r1)
                int r2 = r4.mThreadState
                if (r1 == r2) goto L3f
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r0 = net.sqlcipher.database.SQLiteCursor.access$200(r0)
                r0.unlock()
                return
            L3f:
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteQuery r1 = net.sqlcipher.database.SQLiteCursor.access$600(r1)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor r2 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r2 = net.sqlcipher.database.SQLiteCursor.access$400(r2)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor r3 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r3 = net.sqlcipher.database.SQLiteCursor.access$500(r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r1 = r1.fillWindow(r0, r2, r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                if (r1 == 0) goto L8b
                r2 = -1
                if (r1 != r2) goto L77
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r2 = net.sqlcipher.database.SQLiteCursor.access$500(r1)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor r3 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r3 = net.sqlcipher.database.SQLiteCursor.access$400(r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                int r2 = r2 + r3
                net.sqlcipher.database.SQLiteCursor.access$502(r1, r2)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                r4.sendMessage()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.unlock()
                goto Lf
            L77:
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                net.sqlcipher.database.SQLiteCursor.access$502(r0, r1)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                r4.sendMessage()     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L8b
                goto L8b
            L80:
                r0 = move-exception
                net.sqlcipher.database.SQLiteCursor r1 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r1 = net.sqlcipher.database.SQLiteCursor.access$200(r1)
                r1.unlock()
                throw r0
            L8b:
                net.sqlcipher.database.SQLiteCursor r0 = net.sqlcipher.database.SQLiteCursor.this
                java.util.concurrent.locks.ReentrantLock r0 = net.sqlcipher.database.SQLiteCursor.access$200(r0)
                r0.unlock()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteCursor.QueryThread.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static class MainThreadNotificationHandler extends Handler {
        private final WeakReference<SQLiteCursor> wrappedCursor;

        MainThreadNotificationHandler(SQLiteCursor sQLiteCursor) {
            this.wrappedCursor = new WeakReference<>(sQLiteCursor);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SQLiteCursor sQLiteCursor = this.wrappedCursor.get();
            if (sQLiteCursor != null) {
                sQLiteCursor.notifyDataSetChange();
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        if (!(Integer.MAX_VALUE == this.mMaxRead && Integer.MAX_VALUE == this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler(this);
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
            } finally {
                queryThreadUnlock();
            }
        }
    }

    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.mDatabase = sQLiteDatabase;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mQuery = sQLiteQuery;
        try {
            sQLiteDatabase.lock();
            int columnCountLocked = this.mQuery.columnCountLocked();
            this.mColumns = new String[columnCountLocked];
            for (int i = 0; i < columnCountLocked; i++) {
                String columnNameLocked = this.mQuery.columnNameLocked(i);
                this.mColumns[i] = columnNameLocked;
                if (FieldType.FOREIGN_ID_FIELD_SUFFIX.equals(columnNameLocked)) {
                    this.mRowIdColumnIndex = i;
                }
            }
        } finally {
            sQLiteDatabase.unlock();
        }
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        if (this.mWindow == null || i2 < this.mWindow.getStartPosition() || i2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(i2);
            return true;
        }
        return true;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    private void fillWindow(int i) {
        int cursorPickFillWindowStartPosition;
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        if (this.fillWindowForwardOnly) {
            cursorPickFillWindowStartPosition = i;
        } else if (this.mCount == -1) {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i, 0);
        } else {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i, this.mCursorWindowCapacity);
        }
        this.mWindow.setStartPosition(cursorPickFillWindowStartPosition);
        this.mWindow.setRequiredPosition(i);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity == 0) {
            this.mCursorWindowCapacity = this.mWindow.getNumRows();
        }
        if (this.mCount == -1) {
            this.mCount = cursorPickFillWindowStartPosition + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getColumnIndex(String str) {
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        Integer num = this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        boolean z;
        checkPosition();
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            return false;
        }
        this.mDatabase.lock();
        try {
            try {
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                String str = this.mEditTable;
                StringBuilder sb = new StringBuilder();
                sb.append(this.mColumns[this.mRowIdColumnIndex]);
                sb.append("=?");
                sQLiteDatabase.delete(str, sb.toString(), new String[]{this.mCurrentRowID.toString()});
                z = true;
            } finally {
                this.mDatabase.unlock();
            }
        } catch (SQLException unused) {
            z = false;
        }
        int i = this.mPos;
        requery();
        moveToPosition(i);
        if (z) {
            onChange(true);
            return true;
        }
        return false;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        if (supportsUpdates()) {
            synchronized (this.mUpdatedRows) {
                if (map != null) {
                    this.mUpdatedRows.putAll(map);
                }
                if (this.mUpdatedRows.size() == 0) {
                    return true;
                }
                this.mDatabase.beginTransaction();
                try {
                    StringBuilder sb = new StringBuilder(128);
                    for (Map.Entry<Long, Map<String, Object>> entry : this.mUpdatedRows.entrySet()) {
                        Map<String, Object> value = entry.getValue();
                        Long key = entry.getKey();
                        if (key == null || value == null) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("null rowId or values found! rowId = ");
                            sb2.append(key);
                            sb2.append(", values = ");
                            sb2.append(value);
                            throw new IllegalStateException(sb2.toString());
                        } else if (value.size() != 0) {
                            long longValue = key.longValue();
                            Iterator<Map.Entry<String, Object>> it = value.entrySet().iterator();
                            sb.setLength(0);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("UPDATE ");
                            sb3.append(this.mEditTable);
                            sb3.append(" SET ");
                            sb.append(sb3.toString());
                            Object[] objArr = new Object[value.size()];
                            int i = 0;
                            while (it.hasNext()) {
                                Map.Entry<String, Object> next = it.next();
                                sb.append(next.getKey());
                                sb.append("=?");
                                objArr[i] = next.getValue();
                                if (it.hasNext()) {
                                    sb.append(", ");
                                }
                                i++;
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(" WHERE ");
                            sb4.append(this.mColumns[this.mRowIdColumnIndex]);
                            sb4.append('=');
                            sb4.append(longValue);
                            sb.append(sb4.toString());
                            sb.append(';');
                            this.mDatabase.execSQL(sb.toString(), objArr);
                            this.mDatabase.rowUpdated(this.mEditTable, longValue);
                        }
                    }
                    this.mDatabase.setTransactionSuccessful();
                    this.mDatabase.endTransaction();
                    this.mUpdatedRows.clear();
                    onChange(true);
                    return true;
                } catch (Throwable th) {
                    this.mDatabase.endTransaction();
                    throw th;
                }
            }
        }
        return false;
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            if (this.mWindow != null) {
                this.mWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mQuery.requery();
                this.mDatabase.unlock();
                return super.requery();
            } finally {
                queryThreadUnlock();
            }
        } catch (Throwable th) {
            this.mDatabase.unlock();
            throw th;
        }
    }

    @Override // net.sqlcipher.AbstractWindowedCursor
    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                queryThreadUnlock();
                this.mCount = -1;
            } catch (Throwable th) {
                queryThreadUnlock();
                throw th;
            }
        }
        this.mWindow = cursorWindow;
    }

    public void setSelectionArguments(String[] strArr) {
        this.mDriver.setBindArguments(strArr);
    }

    @Override // net.sqlcipher.AbstractCursor
    public void finalize() {
        try {
            if (this.mWindow != null) {
                String str = this.mQuery.mSql;
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public void fillWindow(int i, android.database.CursorWindow cursorWindow) {
        int cursorPickFillWindowStartPosition;
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        if (this.fillWindowForwardOnly) {
            cursorPickFillWindowStartPosition = i;
        } else if (this.mCount == -1) {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i, 0);
        } else {
            cursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i, this.mCursorWindowCapacity);
        }
        this.mWindow.setStartPosition(cursorPickFillWindowStartPosition);
        this.mWindow.setRequiredPosition(i);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity == 0) {
            this.mCursorWindowCapacity = this.mWindow.getNumRows();
        }
        if (this.mCount == -1) {
            this.mCount = cursorPickFillWindowStartPosition + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    public int cursorPickFillWindowStartPosition(int i, int i2) {
        return Math.max(i - (i2 / 3), 0);
    }
}
