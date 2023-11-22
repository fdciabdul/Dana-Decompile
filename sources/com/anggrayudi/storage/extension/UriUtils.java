package com.anggrayudi.storage.extension;

import android.content.Context;
import android.net.Uri;
import com.anggrayudi.storage.file.FileUtils;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.promocenter.model.PromoActionType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0007\u001a \u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0003¨\u0006\u0017"}, d2 = {"isDocumentsDocument", "", "Landroid/net/Uri;", "(Landroid/net/Uri;)Z", "isDownloadsDocument", "isExternalStorageDocument", "isMediaDocument", "isMediaFile", "isRawFile", "isTreeDocumentFile", "getStorageId", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "openInputStream", "Ljava/io/InputStream;", "openOutputStream", "Ljava/io/OutputStream;", "append", "toDocumentFile", "Landroidx/documentfile/provider/DocumentFile;", "toMediaFile", "Lcom/anggrayudi/storage/media/MediaFile;", "storage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class UriUtils {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "");
        Intrinsics.checkNotNullParameter(context, "");
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        if (PlaceComponentResult(uri)) {
            return FileUtils.getAuthRequestContext(new File(path), context);
        }
        return (getAuthRequestContext(uri) || KClassImpl$Data$declaredNonStaticMembers$2(uri)) ? PromoActionType.PRIMARY : BuiltInFictitiousFunctionClassFactory(uri) ? StringsKt.substringAfterLast$default(StringsKt.substringBefore(path, ':', ""), '/', (String) null, 2, (Object) null) : "";
    }

    @JvmName(name = "isTreeDocumentFile")
    public static final boolean MyBillsEntityDataFactory(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "");
        String path = uri.getPath();
        return path != null && StringsKt.startsWith$default(path, "/tree/", false, 2, (Object) null);
    }

    @JvmName(name = "isExternalStorageDocument")
    public static final boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "");
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.externalstorage.documents");
    }

    @JvmName(name = "isDownloadsDocument")
    public static final boolean getAuthRequestContext(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "");
        return Intrinsics.areEqual(uri.getAuthority(), "com.android.providers.downloads.documents");
    }

    @JvmName(name = "isDocumentsDocument")
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "");
        if (BuiltInFictitiousFunctionClassFactory(uri)) {
            String path = uri.getPath();
            return path != null && StringsKt.startsWith$default(path, "/tree/home:", false, 2, (Object) null);
        }
        return false;
    }

    @JvmName(name = "isRawFile")
    public static final boolean PlaceComponentResult(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "");
        return Intrinsics.areEqual(uri.getScheme(), "file");
    }

    public static final OutputStream getAuthRequestContext(Uri uri, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(uri, "");
        Intrinsics.checkNotNullParameter(context, "");
        try {
            if (!PlaceComponentResult(uri)) {
                return context.getContentResolver().openOutputStream(uri, (z && MyBillsEntityDataFactory(uri)) ? "wa" : "w");
            }
            String path = uri.getPath();
            if (path == null) {
                return null;
            }
            return new FileOutputStream(new File(path), z);
        } catch (IOException unused) {
            return null;
        }
    }

    public static final InputStream BuiltInFictitiousFunctionClassFactory(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "");
        Intrinsics.checkNotNullParameter(context, "");
        InputStream inputStream = null;
        try {
            if (PlaceComponentResult(uri)) {
                String path = uri.getPath();
                if (path == null) {
                    return null;
                }
                inputStream = new FileInputStream(new File(path));
            } else {
                inputStream = context.getContentResolver().openInputStream(uri);
            }
        } catch (IOException unused) {
        }
        return inputStream;
    }
}
