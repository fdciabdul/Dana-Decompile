package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.CancellationSignal;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
public final class SupportSQLiteCompat {
    private SupportSQLiteCompat() {
    }

    /* loaded from: classes3.dex */
    public static final class Api16Impl {
        public static boolean PlaceComponentResult(File file) {
            return SQLiteDatabase.deleteDatabase(file);
        }

        public static Cursor MyBillsEntityDataFactory(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, CancellationSignal cancellationSignal, SQLiteDatabase.CursorFactory cursorFactory) {
            return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        }

        public static void MyBillsEntityDataFactory(SQLiteDatabase sQLiteDatabase, boolean z) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z);
        }

        public static void getAuthRequestContext(SQLiteOpenHelper sQLiteOpenHelper, boolean z) {
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
        }

        private Api16Impl() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class Api19Impl {
        public static Uri PlaceComponentResult(Cursor cursor) {
            return cursor.getNotificationUri();
        }

        public static boolean PlaceComponentResult(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }

        private Api19Impl() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class Api21Impl {
        public static File BuiltInFictitiousFunctionClassFactory(Context context) {
            return context.getNoBackupFilesDir();
        }

        private Api21Impl() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class Api23Impl {
        private Api23Impl() {
        }
    }

    /* loaded from: classes6.dex */
    public static final class Api29Impl {
        public static void PlaceComponentResult(Cursor cursor, ContentResolver contentResolver, List<Uri> list) {
            cursor.setNotificationUris(contentResolver, list);
        }

        public static List<Uri> BuiltInFictitiousFunctionClassFactory(Cursor cursor) {
            return cursor.getNotificationUris();
        }

        private Api29Impl() {
        }
    }
}
