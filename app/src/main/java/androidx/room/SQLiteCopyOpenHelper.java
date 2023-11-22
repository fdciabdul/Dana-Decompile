package androidx.room;

import android.content.Context;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private static int GetContactSyncConfig = 1;
    private static int initRecordTimeStamp;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private final File NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final String PlaceComponentResult;
    DatabaseConfiguration getAuthRequestContext;
    private final SupportSQLiteOpenHelper getErrorConfigVersion;
    private boolean lookAheadTest;
    private final Callable<InputStream> moveToNextValue;
    private final int scheduleImpl;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {38, -105, 32, Ascii.RS, -5, -8, -6, 56, -62, -20, -9, -17, 68, -67, -5, -15, -12, 3, -21};
    public static final int MyBillsEntityDataFactory = 226;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCopyOpenHelper(Context context, String str, File file, Callable<InputStream> callable, int i, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = file;
        this.moveToNextValue = callable;
        this.scheduleImpl = i;
        this.getErrorConfigVersion = supportSQLiteOpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.getErrorConfigVersion.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.getErrorConfigVersion.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        SupportSQLiteDatabase writableDatabase;
        synchronized (this) {
            if (!this.lookAheadTest) {
                getAuthRequestContext(true);
                this.lookAheadTest = true;
            }
            writableDatabase = this.getErrorConfigVersion.getWritableDatabase();
        }
        return writableDatabase;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        SupportSQLiteDatabase readableDatabase;
        synchronized (this) {
            if (!this.lookAheadTest) {
                getAuthRequestContext(false);
                this.lookAheadTest = true;
            }
            readableDatabase = this.getErrorConfigVersion.getReadableDatabase();
        }
        return readableDatabase;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            this.getErrorConfigVersion.close();
            this.lookAheadTest = false;
        }
    }

    @Override // androidx.room.DelegatingOpenHelper
    public final SupportSQLiteOpenHelper PlaceComponentResult() {
        return this.getErrorConfigVersion;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getAuthRequestContext(boolean r9) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.SQLiteCopyOpenHelper.getAuthRequestContext(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x013f, code lost:
    
        if (r8 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0149, code lost:
    
        if (r7.exists() == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014f, code lost:
    
        if (r7.mkdirs() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0152, code lost:
    
        r2 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0157, code lost:
    
        r2.append("Failed to create directories for ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x015c, code lost:
    
        r2.append(r0.getAbsolutePath());
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016c, code lost:
    
        throw new java.io.IOException(r2.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0187, code lost:
    
        if (r3 != null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x018f, code lost:
    
        if (r7.initRecordTimeStamp != null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0191, code lost:
    
        r3 = r15.PlaceComponentResult(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0195, code lost:
    
        if (r2 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0197, code lost:
    
        r3.getWritableDatabase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x019b, code lost:
    
        r3.getReadableDatabase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x019e, code lost:
    
        r2 = r15.getAuthRequestContext.initRecordTimeStamp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01a7, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01aa, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x01de -> B:102:0x01e6). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void PlaceComponentResult(java.io.File r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.SQLiteCopyOpenHelper.PlaceComponentResult(java.io.File, boolean):void");
    }

    private SupportSQLiteOpenHelper PlaceComponentResult(File file) {
        try {
            int MyBillsEntityDataFactory2 = DBUtil.MyBillsEntityDataFactory(file);
            FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            SupportSQLiteOpenHelper.Configuration.Builder BuiltInFictitiousFunctionClassFactory2 = SupportSQLiteOpenHelper.Configuration.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = file.getAbsolutePath();
            BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult = new SupportSQLiteOpenHelper.Callback(Math.max(MyBillsEntityDataFactory2, 1)) { // from class: androidx.room.SQLiteCopyOpenHelper.1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public final void BuiltInFictitiousFunctionClassFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public final void getAuthRequestContext(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public final void getAuthRequestContext(SupportSQLiteDatabase supportSQLiteDatabase) {
                    if (this.KClassImpl$Data$declaredNonStaticMembers$2 <= 0) {
                        supportSQLiteDatabase.setVersion(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                }
            };
            return frameworkSQLiteOpenHelperFactory.create(BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory());
        } catch (IOException e) {
            throw new RuntimeException("Malformed database file, unable to read version.", e);
        }
    }
}
