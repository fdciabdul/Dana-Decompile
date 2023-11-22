package id.dana.data.base;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseHook;
import net.sqlcipher.database.SQLiteStatement;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0013"}, d2 = {"Lid/dana/data/base/SqlCipherUtils;", "", "Landroid/content/Context;", "ctx", "Ljava/io/File;", "originalFile", "", "passphrase", "", "encrypt", "(Landroid/content/Context;Ljava/io/File;[B)V", "", "dbName", "(Landroid/content/Context;Ljava/lang/String;[B)V", "name", "Lid/dana/data/base/SqlCipherUtils$State;", "getDatabaseState", "(Landroid/content/Context;Ljava/lang/String;)Lid/dana/data/base/SqlCipherUtils$State;", "path", "(Ljava/io/File;)Lid/dana/data/base/SqlCipherUtils$State;", "<init>", "()V", TrackerKey.Property.STATE}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SqlCipherUtils {
    public static final SqlCipherUtils INSTANCE = new SqlCipherUtils();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/data/base/SqlCipherUtils$State;", "", "<init>", "(Ljava/lang/String;I)V", "DOES_NOT_EXISTS", "UNENCRYPTED", "ENCRYPTED"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum State {
        DOES_NOT_EXISTS,
        UNENCRYPTED,
        ENCRYPTED
    }

    private SqlCipherUtils() {
    }

    @JvmStatic
    public static final State getDatabaseState(Context ctx, String name) {
        Intrinsics.checkNotNullParameter(ctx, "");
        Intrinsics.checkNotNullParameter(name, "");
        SQLiteDatabase.loadLibs(ctx);
        File databasePath = ctx.getDatabasePath(name);
        Intrinsics.checkNotNullExpressionValue(databasePath, "");
        return getDatabaseState(databasePath);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if (r1 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (r1 != null) goto L14;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.data.base.SqlCipherUtils.State getDatabaseState(java.io.File r3) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r1 = r3.exists()
            if (r1 != 0) goto Le
            id.dana.data.base.SqlCipherUtils$State r3 = id.dana.data.base.SqlCipherUtils.State.DOES_NOT_EXISTS
            return r3
        Le:
            r1 = 0
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            r2 = 1
            net.sqlcipher.database.SQLiteDatabase r1 = net.sqlcipher.database.SQLiteDatabase.openDatabase(r3, r0, r1, r2)     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            r1.getVersion()     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            id.dana.data.base.SqlCipherUtils$State r3 = id.dana.data.base.SqlCipherUtils.State.UNENCRYPTED     // Catch: java.lang.Throwable -> L20 java.lang.Exception -> L22
            if (r1 == 0) goto L29
            goto L26
        L20:
            r3 = move-exception
            goto L2a
        L22:
            id.dana.data.base.SqlCipherUtils$State r3 = id.dana.data.base.SqlCipherUtils.State.ENCRYPTED     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L29
        L26:
            r1.close()
        L29:
            return r3
        L2a:
            if (r1 == 0) goto L2f
            r1.close()
        L2f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.base.SqlCipherUtils.getDatabaseState(java.io.File):id.dana.data.base.SqlCipherUtils$State");
    }

    @JvmStatic
    public static final void encrypt(Context ctx, String dbName, byte[] passphrase) {
        Intrinsics.checkNotNullParameter(ctx, "");
        Intrinsics.checkNotNullParameter(dbName, "");
        Intrinsics.checkNotNullParameter(passphrase, "");
        File databasePath = ctx.getDatabasePath(dbName);
        Intrinsics.checkNotNullExpressionValue(databasePath, "");
        encrypt(ctx, databasePath, passphrase);
    }

    @JvmStatic
    public static final void encrypt(Context ctx, File originalFile, byte[] passphrase) {
        Intrinsics.checkNotNullParameter(ctx, "");
        Intrinsics.checkNotNullParameter(originalFile, "");
        Intrinsics.checkNotNullParameter(passphrase, "");
        SQLiteDatabase.loadLibs(ctx);
        if (originalFile.exists()) {
            SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(originalFile.getAbsolutePath(), "", (SQLiteDatabase.CursorFactory) null, 0);
            int version = openDatabase.getVersion();
            openDatabase.close();
            File createTempFile = File.createTempFile("sqlcipherutils", "tmp", ctx.getCacheDir());
            SQLiteDatabase openDatabase2 = SQLiteDatabase.openDatabase(createTempFile.getAbsolutePath(), passphrase, (SQLiteDatabase.CursorFactory) null, 0, (SQLiteDatabaseHook) null, (DatabaseErrorHandler) null);
            SQLiteStatement compileStatement = openDatabase2.compileStatement("ATTACH DATABASE ? AS plaintext KEY ''");
            compileStatement.bindString(1, originalFile.getAbsolutePath());
            compileStatement.execute();
            openDatabase2.rawExecSQL("SELECT sqlcipher_export('main', 'plaintext')");
            openDatabase2.rawExecSQL("DETACH DATABASE plaintext");
            openDatabase2.setVersion(version);
            compileStatement.close();
            openDatabase2.close();
            originalFile.delete();
            createTempFile.renameTo(originalFile);
        }
    }
}
