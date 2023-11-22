package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    final AutoCloser KClassImpl$Data$declaredNonStaticMembers$2;
    private final AutoClosingSupportSQLiteDatabase PlaceComponentResult;
    private final SupportSQLiteOpenHelper getAuthRequestContext;

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper, AutoCloser autoCloser) {
        this.getAuthRequestContext = supportSQLiteOpenHelper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = autoCloser;
        if (autoCloser.MyBillsEntityDataFactory != null) {
            InstrumentInjector.log_e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        } else {
            autoCloser.MyBillsEntityDataFactory = supportSQLiteOpenHelper;
        }
        this.PlaceComponentResult = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final String getDatabaseName() {
        return this.getAuthRequestContext.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        this.getAuthRequestContext.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getWritableDatabase() {
        this.PlaceComponentResult.PlaceComponentResult.PlaceComponentResult(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda1());
        return this.PlaceComponentResult;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getReadableDatabase() {
        this.PlaceComponentResult.PlaceComponentResult.PlaceComponentResult(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda1());
        return this.PlaceComponentResult;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.PlaceComponentResult.close();
        } catch (IOException e) {
            SneakyThrow.BuiltInFictitiousFunctionClassFactory(e);
        }
    }

    @Override // androidx.room.DelegatingOpenHelper
    public final SupportSQLiteOpenHelper PlaceComponentResult() {
        return this.getAuthRequestContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        final AutoCloser PlaceComponentResult;

        public static /* synthetic */ Object getAuthRequestContext() {
            return null;
        }

        AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
            this.PlaceComponentResult = autoCloser;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final SupportSQLiteStatement compileStatement(String str) {
            return new AutoClosingSupportSqliteStatement(str, this.PlaceComponentResult);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void beginTransaction() {
            try {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().beginTransaction();
            } catch (Throwable th) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void beginTransactionNonExclusive() {
            try {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void endTransaction() {
            if (this.PlaceComponentResult.MyBillsEntityDataFactory() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
            try {
                this.PlaceComponentResult.MyBillsEntityDataFactory().endTransaction();
            } finally {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void setTransactionSuccessful() {
            SupportSQLiteDatabase MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            }
            MyBillsEntityDataFactory.setTransactionSuccessful();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean inTransaction() {
            if (this.PlaceComponentResult.MyBillsEntityDataFactory() == null) {
                return false;
            }
            return ((Boolean) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda22
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).inTransaction());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean isDbLockedByCurrentThread() {
            if (this.PlaceComponentResult.MyBillsEntityDataFactory() == null) {
                return false;
            }
            return ((Boolean) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda17
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDbLockedByCurrentThread());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean yieldIfContendedSafely() {
            return ((Boolean) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda14
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).yieldIfContendedSafely());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final int getVersion() {
            return ((Integer) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda16
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void setVersion(final int i) {
            this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda5
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.MyBillsEntityDataFactory(i, (SupportSQLiteDatabase) obj);
                }
            });
        }

        public static /* synthetic */ Object MyBillsEntityDataFactory(int i, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setVersion(i);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final long getMaximumSize() {
            return ((Long) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda3
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final long setMaximumSize(final long j) {
            return ((Long) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda7
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    Long valueOf;
                    valueOf = Long.valueOf(((SupportSQLiteDatabase) obj).setMaximumSize(j));
                    return valueOf;
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final long getPageSize() {
            return ((Long) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda10
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void setPageSize(final long j) {
            this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda9
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.MyBillsEntityDataFactory(j, (SupportSQLiteDatabase) obj);
                }
            });
        }

        public static /* synthetic */ Object MyBillsEntityDataFactory(long j, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setPageSize(j);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final Cursor query(String str) {
            try {
                return new KeepAliveCursor(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().query(str), this.PlaceComponentResult);
            } catch (Throwable th) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
            try {
                return new KeepAliveCursor(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().query(supportSQLiteQuery), this.PlaceComponentResult);
            } catch (Throwable th) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
            try {
                return new KeepAliveCursor(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().query(supportSQLiteQuery, cancellationSignal), this.PlaceComponentResult);
            } catch (Throwable th) {
                this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
                throw th;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final long insert(final String str, final int i, final ContentValues contentValues) throws SQLException {
            return ((Long) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda15
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    Long valueOf;
                    valueOf = Long.valueOf(((SupportSQLiteDatabase) obj).insert(str, i, contentValues));
                    return valueOf;
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final int delete(final String str, final String str2, final Object[] objArr) {
            return ((Integer) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda6
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    Integer valueOf;
                    valueOf = Integer.valueOf(((SupportSQLiteDatabase) obj).delete(str, str2, objArr));
                    return valueOf;
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final int update(final String str, final int i, final ContentValues contentValues, final String str2, final Object[] objArr) {
            return ((Integer) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda20
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    Integer valueOf;
                    valueOf = Integer.valueOf(((SupportSQLiteDatabase) obj).update(str, i, contentValues, str2, objArr));
                    return valueOf;
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void execSQL(final String str) throws SQLException {
            this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda2
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.KClassImpl$Data$declaredNonStaticMembers$2(str, (SupportSQLiteDatabase) obj);
                }
            });
        }

        public static /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2(String str, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void execSQL(final String str, final Object[] objArr) throws SQLException {
            this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda12
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.MyBillsEntityDataFactory(str, objArr, (SupportSQLiteDatabase) obj);
                }
            });
        }

        public static /* synthetic */ Object MyBillsEntityDataFactory(String str, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str, objArr);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean isReadOnly() {
            return ((Boolean) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda18
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isReadOnly());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean isOpen() {
            SupportSQLiteDatabase MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == null) {
                return false;
            }
            return MyBillsEntityDataFactory.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean needUpgrade(final int i) {
            return ((Boolean) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda8
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    Boolean valueOf;
                    valueOf = Boolean.valueOf(((SupportSQLiteDatabase) obj).needUpgrade(i));
                    return valueOf;
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final String getPath() {
            return (String) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda13
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getPath();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void setLocale(final Locale locale) {
            this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda21
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.MyBillsEntityDataFactory(locale, (SupportSQLiteDatabase) obj);
                }
            });
        }

        public static /* synthetic */ Object MyBillsEntityDataFactory(Locale locale, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setLocale(locale);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void setMaxSqlCacheSize(final int i) {
            this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda19
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.PlaceComponentResult(i, (SupportSQLiteDatabase) obj);
                }
            });
        }

        public static /* synthetic */ Object PlaceComponentResult(int i, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setMaxSqlCacheSize(i);
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final void setForeignKeyConstraintsEnabled(final boolean z) {
            this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda11
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.BuiltInFictitiousFunctionClassFactory(z, (SupportSQLiteDatabase) obj);
                }
            });
        }

        public static /* synthetic */ Object BuiltInFictitiousFunctionClassFactory(boolean z, SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 16) {
                supportSQLiteDatabase.setForeignKeyConstraintsEnabled(z);
                return null;
            }
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.getAuthRequestContext((SupportSQLiteDatabase) obj);
                }
            })).booleanValue();
        }

        public static /* synthetic */ Boolean getAuthRequestContext(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 16) {
                return Boolean.valueOf(supportSQLiteDatabase.isWriteAheadLoggingEnabled());
            }
            return Boolean.FALSE;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final List<Pair<String, String>> getAttachedDbs() {
            return (List) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda23
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getAttachedDbs();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public final boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.PlaceComponentResult.PlaceComponentResult(new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$$ExternalSyntheticLambda4
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDatabaseIntegrityOk());
                }
            })).booleanValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            AutoCloser autoCloser = this.PlaceComponentResult;
            synchronized (autoCloser.lookAheadTest) {
                autoCloser.moveToNextValue = true;
                SupportSQLiteDatabase supportSQLiteDatabase = autoCloser.PlaceComponentResult;
                if (supportSQLiteDatabase != null) {
                    supportSQLiteDatabase.close();
                }
                autoCloser.PlaceComponentResult = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class KeepAliveCursor implements Cursor {
        private final Cursor PlaceComponentResult;
        private final AutoCloser getAuthRequestContext;

        KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
            this.PlaceComponentResult = cursor;
            this.getAuthRequestContext = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.PlaceComponentResult.close();
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // android.database.Cursor
        public final boolean isClosed() {
            return this.PlaceComponentResult.isClosed();
        }

        @Override // android.database.Cursor
        public final int getCount() {
            return this.PlaceComponentResult.getCount();
        }

        @Override // android.database.Cursor
        public final int getPosition() {
            return this.PlaceComponentResult.getPosition();
        }

        @Override // android.database.Cursor
        public final boolean move(int i) {
            return this.PlaceComponentResult.move(i);
        }

        @Override // android.database.Cursor
        public final boolean moveToPosition(int i) {
            return this.PlaceComponentResult.moveToPosition(i);
        }

        @Override // android.database.Cursor
        public final boolean moveToFirst() {
            return this.PlaceComponentResult.moveToFirst();
        }

        @Override // android.database.Cursor
        public final boolean moveToLast() {
            return this.PlaceComponentResult.moveToLast();
        }

        @Override // android.database.Cursor
        public final boolean moveToNext() {
            return this.PlaceComponentResult.moveToNext();
        }

        @Override // android.database.Cursor
        public final boolean moveToPrevious() {
            return this.PlaceComponentResult.moveToPrevious();
        }

        @Override // android.database.Cursor
        public final boolean isFirst() {
            return this.PlaceComponentResult.isFirst();
        }

        @Override // android.database.Cursor
        public final boolean isLast() {
            return this.PlaceComponentResult.isLast();
        }

        @Override // android.database.Cursor
        public final boolean isBeforeFirst() {
            return this.PlaceComponentResult.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public final boolean isAfterLast() {
            return this.PlaceComponentResult.isAfterLast();
        }

        @Override // android.database.Cursor
        public final int getColumnIndex(String str) {
            return this.PlaceComponentResult.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public final int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            return this.PlaceComponentResult.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public final String getColumnName(int i) {
            return this.PlaceComponentResult.getColumnName(i);
        }

        @Override // android.database.Cursor
        public final String[] getColumnNames() {
            return this.PlaceComponentResult.getColumnNames();
        }

        @Override // android.database.Cursor
        public final int getColumnCount() {
            return this.PlaceComponentResult.getColumnCount();
        }

        @Override // android.database.Cursor
        public final byte[] getBlob(int i) {
            return this.PlaceComponentResult.getBlob(i);
        }

        @Override // android.database.Cursor
        public final String getString(int i) {
            return this.PlaceComponentResult.getString(i);
        }

        @Override // android.database.Cursor
        public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
            this.PlaceComponentResult.copyStringToBuffer(i, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public final short getShort(int i) {
            return this.PlaceComponentResult.getShort(i);
        }

        @Override // android.database.Cursor
        public final int getInt(int i) {
            return this.PlaceComponentResult.getInt(i);
        }

        @Override // android.database.Cursor
        public final long getLong(int i) {
            return this.PlaceComponentResult.getLong(i);
        }

        @Override // android.database.Cursor
        public final float getFloat(int i) {
            return this.PlaceComponentResult.getFloat(i);
        }

        @Override // android.database.Cursor
        public final double getDouble(int i) {
            return this.PlaceComponentResult.getDouble(i);
        }

        @Override // android.database.Cursor
        public final int getType(int i) {
            return this.PlaceComponentResult.getType(i);
        }

        @Override // android.database.Cursor
        public final boolean isNull(int i) {
            return this.PlaceComponentResult.isNull(i);
        }

        @Override // android.database.Cursor
        @Deprecated
        public final void deactivate() {
            this.PlaceComponentResult.deactivate();
        }

        @Override // android.database.Cursor
        @Deprecated
        public final boolean requery() {
            return this.PlaceComponentResult.requery();
        }

        @Override // android.database.Cursor
        public final void registerContentObserver(ContentObserver contentObserver) {
            this.PlaceComponentResult.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public final void unregisterContentObserver(ContentObserver contentObserver) {
            this.PlaceComponentResult.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.PlaceComponentResult.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.PlaceComponentResult.unregisterDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public final void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.PlaceComponentResult.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public final void setNotificationUris(ContentResolver contentResolver, List<Uri> list) {
            SupportSQLiteCompat.Api29Impl.PlaceComponentResult(this.PlaceComponentResult, contentResolver, list);
        }

        @Override // android.database.Cursor
        public final Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.PlaceComponentResult(this.PlaceComponentResult);
        }

        @Override // android.database.Cursor
        public final List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
        }

        @Override // android.database.Cursor
        public final boolean getWantsAllOnMoveCalls() {
            return this.PlaceComponentResult.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public final void setExtras(Bundle bundle) {
            this.PlaceComponentResult.setExtras(bundle);
        }

        @Override // android.database.Cursor
        public final Bundle getExtras() {
            return this.PlaceComponentResult.getExtras();
        }

        @Override // android.database.Cursor
        public final Bundle respond(Bundle bundle) {
            return this.PlaceComponentResult.respond(bundle);
        }
    }

    /* loaded from: classes6.dex */
    public static class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser MyBillsEntityDataFactory;
        final String PlaceComponentResult;
        final ArrayList<Object> getAuthRequestContext = new ArrayList<>();

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        AutoClosingSupportSqliteStatement(String str, AutoCloser autoCloser) {
            this.PlaceComponentResult = str;
            this.MyBillsEntityDataFactory = autoCloser;
        }

        private void MyBillsEntityDataFactory(int i, Object obj) {
            int i2 = i - 1;
            if (i2 >= this.getAuthRequestContext.size()) {
                for (int size = this.getAuthRequestContext.size(); size <= i2; size++) {
                    this.getAuthRequestContext.add(null);
                }
            }
            this.getAuthRequestContext.set(i2, obj);
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            this.MyBillsEntityDataFactory.PlaceComponentResult(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda2(this, new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda5
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.KClassImpl$Data$declaredNonStaticMembers$2((SupportSQLiteStatement) obj);
                }
            }));
        }

        public static /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2(SupportSQLiteStatement supportSQLiteStatement) {
            supportSQLiteStatement.execute();
            return null;
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Integer) this.MyBillsEntityDataFactory.PlaceComponentResult(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda2(this, new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Integer.valueOf(((SupportSQLiteStatement) obj).executeUpdateDelete());
                }
            }))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Long) this.MyBillsEntityDataFactory.PlaceComponentResult(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda2(this, new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda3
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).executeInsert());
                }
            }))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Long) this.MyBillsEntityDataFactory.PlaceComponentResult(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda2(this, new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda4
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).simpleQueryForLong());
                }
            }))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) this.MyBillsEntityDataFactory.PlaceComponentResult(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda2(this, new Function() { // from class: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$$ExternalSyntheticLambda1
                @Override // androidx.arch.core.util.Function
                public final Object getAuthRequestContext(Object obj) {
                    return ((SupportSQLiteStatement) obj).simpleQueryForString();
                }
            }));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int i) {
            MyBillsEntityDataFactory(i, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int i, long j) {
            MyBillsEntityDataFactory(i, Long.valueOf(j));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int i, double d) {
            MyBillsEntityDataFactory(i, Double.valueOf(d));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int i, String str) {
            MyBillsEntityDataFactory(i, str);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int i, byte[] bArr) {
            MyBillsEntityDataFactory(i, bArr);
        }
    }
}
