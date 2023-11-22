package com.anggrayudi.storage.media;

import android.app.RecoverableSecurityException;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.extension.IOUtils;
import com.anggrayudi.storage.extension.PrimitivesExtKt;
import com.anggrayudi.storage.extension.TextUtils;
import com.anggrayudi.storage.extension.UriUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020\u0011¢\u0006\u0004\b$\u0010%B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u0006\u0010#\u001a\u00020!¢\u0006\u0004\b$\u0010&J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0018\u0010\u0003\u001a\u0006*\u00020\u00190\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u001c\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002@GX\u0086\n¢\u0006\u0006\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0004R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010 \u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b \u0010\u0004R\u0011\u0010\u0012\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u001e\u001a\u00020!X\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010\""}, d2 = {"Lcom/anggrayudi/storage/media/MediaFile;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "p0", "equals", "(Ljava/lang/Object;)Z", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/lang/String;", "", "hashCode", "()I", "Ljava/io/OutputStream;", "getAuthRequestContext", "(Z)Ljava/io/OutputStream;", "Ljava/io/File;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Ljava/io/File;", "toString", "()Ljava/lang/String;", "Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", "Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", "PlaceComponentResult", "Landroid/content/Context;", "Landroid/content/Context;", "scheduleImpl", "()V", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "getErrorConfigVersion", "lookAheadTest", "Landroid/net/Uri;", "Landroid/net/Uri;", "p1", "<init>", "(Landroid/content/Context;Ljava/io/File;)V", "(Landroid/content/Context;Landroid/net/Uri;)V", "AccessCallback"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class MediaFile {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Uri moveToNextValue;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public AccessCallback PlaceComponentResult;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", ""}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public interface AccessCallback {
    }

    public MediaFile(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(uri, "");
        this.moveToNextValue = uri;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MediaFile(android.content.Context r2, java.io.File r3) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.net.Uri r3 = android.net.Uri.fromFile(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.<init>(android.content.Context, java.io.File):void");
    }

    @JvmName(name = "PlaceComponentResult")
    public final String PlaceComponentResult() {
        File NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
        String name = NetworkUserEntityData$$ExternalSyntheticLambda0 == null ? null : NetworkUserEntityData$$ExternalSyntheticLambda0.getName();
        return name == null ? MyBillsEntityDataFactory("_display_name") : name;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final boolean MyBillsEntityDataFactory() {
        return lookAheadTest() && getAuthRequestContext();
    }

    @JvmName(name = "lookAheadTest")
    private boolean lookAheadTest() {
        Cursor query = this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver().query(this.moveToNextValue, null, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                r1 = cursor.getCount() > 0;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        return r1;
    }

    @JvmName(name = "getAuthRequestContext")
    public final boolean getAuthRequestContext() {
        Uri uri = this.moveToNextValue;
        Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(context, "");
        InputStream BuiltInFictitiousFunctionClassFactory = UriUtils.BuiltInFictitiousFunctionClassFactory(uri, context);
        boolean z = false;
        if (BuiltInFictitiousFunctionClassFactory != null) {
            InputStream inputStream = BuiltInFictitiousFunctionClassFactory;
            try {
                boolean z2 = inputStream.available() == 0;
                CloseableKt.closeFinally(inputStream, null);
                if (!z2) {
                    z = true;
                }
            } finally {
            }
        }
        return !z;
    }

    @JvmName(name = "moveToNextValue")
    private boolean moveToNextValue() {
        return UriUtils.PlaceComponentResult(this.moveToNextValue);
    }

    @Deprecated(message = "Accessing files with java.io.File only works on app private directory since Android 10.")
    private File NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String path;
        if (!moveToNextValue() || (path = this.moveToNextValue.getPath()) == null) {
            return null;
        }
        return new File(path);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final String BuiltInFictitiousFunctionClassFactory() {
        Cursor cursor;
        String str;
        File NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
        String str2 = null;
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            String path = NetworkUserEntityData$$ExternalSyntheticLambda0.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "");
            String substringBeforeLast$default = StringsKt.substringBeforeLast$default(path, '/', (String) null, 2, (Object) null);
            SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
            return Intrinsics.stringPlus(TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.replaceFirst$default(substringBeforeLast$default, SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2(), "", false, 4, (Object) null)), "/");
        }
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Cursor query = this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver().query(this.moveToNextValue, new String[]{"_data"}, null, null, null);
                if (query != null) {
                    cursor = query;
                    try {
                        Cursor cursor2 = cursor;
                        if (cursor2.moveToFirst()) {
                            String BuiltInFictitiousFunctionClassFactory = IOUtils.BuiltInFictitiousFunctionClassFactory(cursor2, "_data");
                            if (BuiltInFictitiousFunctionClassFactory == null) {
                                BuiltInFictitiousFunctionClassFactory = "";
                            }
                            String substringBeforeLast$default2 = StringsKt.substringBeforeLast$default(BuiltInFictitiousFunctionClassFactory, '/', (String) null, 2, (Object) null);
                            SimpleStorage.Companion companion2 = SimpleStorage.INSTANCE;
                            str = Intrinsics.stringPlus(TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.replaceFirst$default(substringBeforeLast$default2, SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2(), "", false, 4, (Object) null)), "/");
                        } else {
                            str = "";
                        }
                        CloseableKt.closeFinally(cursor, null);
                        str2 = str;
                    } finally {
                    }
                }
                if (str2 == null) {
                    return "";
                }
            } catch (Exception unused) {
                return "";
            }
        } else {
            Cursor query2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver().query(this.moveToNextValue, new String[]{"relative_path"}, null, null, null);
            if (query2 != null) {
                cursor = query2;
                try {
                    Cursor cursor3 = cursor;
                    String BuiltInFictitiousFunctionClassFactory2 = cursor3.moveToFirst() ? IOUtils.BuiltInFictitiousFunctionClassFactory(cursor3, "relative_path") : "";
                    CloseableKt.closeFinally(cursor, null);
                    str2 = BuiltInFictitiousFunctionClassFactory2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            if (str2 == null) {
                return "";
            }
        }
        return str2;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        File NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda0.delete() || !NetworkUserEntityData$$ExternalSyntheticLambda0.exists()) {
                return true;
            }
        } else {
            try {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver().delete(this.moveToNextValue, null, null) > 0) {
                    return true;
                }
            } catch (SecurityException e) {
                KClassImpl$Data$declaredNonStaticMembers$2(this, e);
            }
        }
        return false;
    }

    @JvmName(name = "scheduleImpl")
    public final void scheduleImpl() {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("is_pending", Integer.valueOf(PrimitivesExtKt.BuiltInFictitiousFunctionClassFactory(Boolean.FALSE)));
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver().update(this.moveToNextValue, contentValues, null, null);
        } catch (SecurityException e) {
            KClassImpl$Data$declaredNonStaticMembers$2(this, e);
        }
    }

    public final OutputStream getAuthRequestContext(boolean p0) {
        FileOutputStream openOutputStream;
        try {
            File NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                openOutputStream = new FileOutputStream(NetworkUserEntityData$$ExternalSyntheticLambda0, true);
            } else {
                openOutputStream = this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver().openOutputStream(this.moveToNextValue, "wa");
            }
            return openOutputStream;
        } catch (IOException unused) {
            return null;
        }
    }

    private final String MyBillsEntityDataFactory(String p0) {
        int columnIndex;
        Cursor query = this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver().query(this.moveToNextValue, new String[]{p0}, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst() && (columnIndex = cursor2.getColumnIndex(p0)) != -1) {
                    String string = cursor2.getString(columnIndex);
                    CloseableKt.closeFinally(cursor, null);
                    return string;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        return null;
    }

    public final boolean equals(Object p0) {
        return p0 == this || ((p0 instanceof MediaFile) && Intrinsics.areEqual(((MediaFile) p0).moveToNextValue, this.moveToNextValue));
    }

    public final int hashCode() {
        return this.moveToNextValue.hashCode();
    }

    public final String toString() {
        String obj = this.moveToNextValue.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    private static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MediaFile mediaFile, SecurityException securityException) {
        if (Build.VERSION.SDK_INT < 29 || !(securityException instanceof RecoverableSecurityException) || mediaFile.PlaceComponentResult == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(((RecoverableSecurityException) securityException).getUserAction().getActionIntent().getIntentSender(), "");
    }
}
