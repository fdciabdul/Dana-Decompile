package id.dana.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.anggrayudi.storage.FileWrapper;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.media.FileDescription;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.tracker.TrackerKey;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J2\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0004H\u0007JX\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0003J<\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lid/dana/util/MediaStoreUtil;", "", "()V", "DANA_DIRECTORY", "", "calculateCompressedQuality", "", "compressRate", "saveBitmapToMediaStore", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "fileName", "format", "bitmap", "Landroid/graphics/Bitmap;", "folderName", "saveFileToMediaStore", "Lkotlin/Pair;", "Ljava/io/File;", "Landroid/net/Uri;", "enableCompress", "saveImageApi29", "", "resolver", "Landroid/content/ContentResolver;", "uri", "saveImageLegacy", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaStoreUtil {
    public static final MediaStoreUtil MyBillsEntityDataFactory = new MediaStoreUtil();

    private MediaStoreUtil() {
    }

    @JvmStatic
    public static final boolean getAuthRequestContext(Context context, String str, String str2, Bitmap bitmap, String str3) {
        OutputStream PlaceComponentResult;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        Intrinsics.checkNotNullParameter(str3, "");
        boolean z = str3.length() == 0;
        String str4 = TrackerKey.DanaBalanceRecipientTypeProperty.DANA;
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append(TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
            sb.append('/');
            sb.append(str3);
            str4 = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append('.');
        sb2.append(str2);
        String obj = sb2.toString();
        String trimEnd = StringsKt.trimEnd(str4, '/');
        StringBuilder sb3 = new StringBuilder();
        sb3.append("image/");
        sb3.append(str2);
        FileWrapper BuiltInFictitiousFunctionClassFactory = DocumentFileCompat.BuiltInFictitiousFunctionClassFactory(context, new FileDescription(obj, trimEnd, sb3.toString()));
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return false;
        }
        try {
            PlaceComponentResult = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(context);
        } catch (Exception unused) {
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        }
        if (PlaceComponentResult != null) {
            OutputStream outputStream = PlaceComponentResult;
            try {
                boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                if (BuiltInFictitiousFunctionClassFactory instanceof FileWrapper.Media) {
                    ((FileWrapper.Media) BuiltInFictitiousFunctionClassFactory).KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl();
                }
                CloseableKt.closeFinally(outputStream, null);
                return compress;
            } finally {
            }
        } else {
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static Pair<File, Uri> getAuthRequestContext(Context context, String str, String str2, Bitmap bitmap, String str3, boolean z, int i) {
        Uri uri;
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        Intrinsics.checkNotNullParameter(str3, "");
        ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
        Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        boolean z2 = str3.length() == 0;
        String str4 = TrackerKey.DanaBalanceRecipientTypeProperty.DANA;
        if (!z2) {
            StringBuilder sb = new StringBuilder();
            sb.append(TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
            sb.append('/');
            sb.append(str3);
            str4 = sb.toString();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        if (Build.VERSION.SDK_INT >= 29) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Environment.DIRECTORY_PICTURES);
            sb2.append('/');
            sb2.append(str4);
            contentValues.put("relative_path", sb2.toString());
            contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
        } else {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str4);
            sb3.append('/');
            sb3.append(str);
            sb3.append('.');
            sb3.append(str2);
            contentValues.put("_data", new File(externalStoragePublicDirectory, sb3.toString()).getAbsolutePath());
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str);
        sb4.append('.');
        sb4.append(str2);
        contentValues.put("_display_name", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("image/");
        sb5.append(str2);
        contentValues.put("mime_type", sb5.toString());
        long j = currentTimeMillis / 1000;
        contentValues.put("date_added", Long.valueOf(j));
        contentValues.put("date_modified", Long.valueOf(j));
        try {
            uri = contentResolver.insert(uri2, contentValues);
            try {
                if (Build.VERSION.SDK_INT >= 29) {
                    Intrinsics.checkNotNullExpressionValue(contentResolver, "");
                    Intrinsics.checkNotNull(uri);
                    OutputStream openOutputStream = contentResolver.openOutputStream(uri);
                    Intrinsics.checkNotNull(openOutputStream);
                    fileOutputStream = openOutputStream;
                    try {
                        OutputStream outputStream = fileOutputStream;
                        if (z) {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 - RangesKt.coerceIn(i, 0, 100), outputStream);
                        } else {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                        }
                        CloseableKt.closeFinally(fileOutputStream, null);
                    } finally {
                    }
                } else {
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), str4);
                    file.mkdirs();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append('.');
                    sb6.append(str2);
                    fileOutputStream = new FileOutputStream(new File(file, sb6.toString()));
                    try {
                        FileOutputStream fileOutputStream2 = fileOutputStream;
                        if (z) {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 - RangesKt.coerceIn(i, 0, 100), fileOutputStream2);
                        } else {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                        }
                        CloseableKt.closeFinally(fileOutputStream, null);
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                Intrinsics.checkNotNull(uri);
                String path = uri.getPath();
                Intrinsics.checkNotNull(path);
                return TuplesKt.to(new File(path), uri);
            } catch (Exception unused) {
                if (uri != null) {
                    contentResolver.delete(uri, null, null);
                }
                return TuplesKt.to(null, null);
            }
        } catch (Exception unused2) {
            uri = null;
        }
    }
}
