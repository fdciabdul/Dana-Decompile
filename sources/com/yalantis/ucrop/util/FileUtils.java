package com.yalantis.ucrop.util;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.promocenter.model.PromoActionType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes8.dex */
public class FileUtils {
    private FileUtils() {
    }

    private static boolean getAuthRequestContext(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static boolean MyBillsEntityDataFactory(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r8 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r8 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String MyBillsEntityDataFactory(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L2e java.lang.IllegalArgumentException -> L30
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L2e java.lang.IllegalArgumentException -> L30
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L53
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L53
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L53
            if (r8 == 0) goto L28
            r8.close()
        L28:
            return r9
        L29:
            r9 = move-exception
            goto L33
        L2b:
            if (r8 == 0) goto L52
            goto L4f
        L2e:
            r8 = move-exception
            goto L56
        L30:
            r8 = move-exception
            r9 = r8
            r8 = r7
        L33:
            java.util.Locale r10 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L53
            r11 = 1
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch: java.lang.Throwable -> L53
            r0 = 0
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L53
            r11[r0] = r9     // Catch: java.lang.Throwable -> L53
            java.lang.String r9 = "FileUtils"
            java.lang.String r0 = "getDataColumn: _data - [%s]"
            java.lang.String r10 = java.lang.String.format(r10, r0, r11)     // Catch: java.lang.Throwable -> L53
            com.fullstory.instrumentation.InstrumentInjector.log_i(r9, r10)     // Catch: java.lang.Throwable -> L53
            if (r8 != 0) goto L4f
            goto L52
        L4f:
            r8.close()
        L52:
            return r7
        L53:
            r9 = move-exception
            r7 = r8
            r8 = r9
        L56:
            if (r7 == 0) goto L5b
            r7.close()
        L5b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.util.FileUtils.MyBillsEntityDataFactory(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static String BuiltInFictitiousFunctionClassFactory(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (getAuthRequestContext(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if (PromoActionType.PRIMARY.equalsIgnoreCase(split[0])) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Environment.getExternalStorageDirectory());
                    sb.append("/");
                    sb.append(split[1]);
                    return sb.toString();
                }
            } else if (KClassImpl$Data$declaredNonStaticMembers$2(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (!TextUtils.isEmpty(documentId)) {
                    try {
                        return MyBillsEntityDataFactory(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (NumberFormatException e) {
                        InstrumentInjector.log_i(com.alibaba.griver.image.framework.utils.FileUtils.TAG, e.getMessage());
                        return null;
                    }
                }
            } else if (BuiltInFictitiousFunctionClassFactory(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (H5ResourceHandlerUtil.AUDIO.equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return MyBillsEntityDataFactory(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            if (MyBillsEntityDataFactory(uri)) {
                return uri.getLastPathSegment();
            }
            return MyBillsEntityDataFactory(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static void PlaceComponentResult(String str, String str2) throws IOException {
        FileChannel fileChannel;
        Throwable th;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(new File(str)).getChannel();
            try {
                fileChannel = new FileOutputStream(new File(str2)).getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
            try {
                channel.transferTo(0L, channel.size(), fileChannel);
                channel.close();
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                fileChannel2 = channel;
                th = th4;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
        }
    }
}
