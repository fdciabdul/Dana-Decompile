package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import androidx.sqlite.db.SupportSQLiteCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.Closeable;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes3.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    /* loaded from: classes3.dex */
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);

    /* loaded from: classes3.dex */
    public static abstract class Callback {
        public final int KClassImpl$Data$declaredNonStaticMembers$2;

        public abstract void BuiltInFictitiousFunctionClassFactory(SupportSQLiteDatabase supportSQLiteDatabase);

        public void getAuthRequestContext(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void getAuthRequestContext(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);

        public Callback(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't downgrade database from version ");
            sb.append(i);
            sb.append(" to ");
            sb.append(i2);
            throw new SQLiteException(sb.toString());
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            if (str.equalsIgnoreCase(SQLiteDatabase.MEMORY) || str.trim().length() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("deleting the database file: ");
            sb.append(str);
            InstrumentInjector.log_w("SupportSQLite", sb.toString());
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SupportSQLiteCompat.Api16Impl.PlaceComponentResult(new File(str));
                    return;
                }
                try {
                    if (new File(str).delete()) {
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not delete the database file ");
                    sb2.append(str);
                    InstrumentInjector.log_e("SupportSQLite", sb2.toString());
                } catch (Exception e) {
                    InstrumentInjector.log_e("SupportSQLite", "error while deleting corrupted database file", e);
                }
            } catch (Exception e2) {
                InstrumentInjector.log_w("SupportSQLite", "delete failed: ", e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class Configuration {
        public final Context BuiltInFictitiousFunctionClassFactory;
        public final Callback KClassImpl$Data$declaredNonStaticMembers$2;
        public final boolean MyBillsEntityDataFactory;
        public final String PlaceComponentResult;

        Configuration(Context context, String str, Callback callback, boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.PlaceComponentResult = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = callback;
            this.MyBillsEntityDataFactory = z;
        }

        public static Builder BuiltInFictitiousFunctionClassFactory(Context context) {
            return new Builder(context);
        }

        /* loaded from: classes3.dex */
        public static class Builder {
            public String BuiltInFictitiousFunctionClassFactory;
            Context KClassImpl$Data$declaredNonStaticMembers$2;
            public boolean MyBillsEntityDataFactory;
            public Callback PlaceComponentResult;

            public final Configuration MyBillsEntityDataFactory() {
                if (this.PlaceComponentResult == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
                if (this.MyBillsEntityDataFactory && TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new Configuration(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.MyBillsEntityDataFactory);
            }

            Builder(Context context) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
            }
        }
    }
}
