package com.alipay.multimedia.adjuster.api;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Size;
import com.alipay.multimedia.adjuster.api.data.APMInsertReq;
import com.alipay.multimedia.adjuster.api.data.APMSaveReq;
import com.alipay.multimedia.adjuster.api.data.ICache;
import com.alipay.multimedia.adjuster.utils.FileUtils;
import com.alipay.multimedia.adjuster.utils.IOUilts;
import com.alipay.multimedia.adjuster.utils.Log;
import com.alipay.multimedia.adjuster.utils.PathUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class APMSandboxProcessor {
    public static final String TEMP_DIR = "/tmp/";

    /* renamed from: a  reason: collision with root package name */
    private static Context f7326a;
    private static final Log b = Log.getLogger("APMSandboxProcessor");
    private static ICache c = null;

    public static void setApplicationContext(Context context) {
        if (f7326a == null) {
            f7326a = context;
        }
    }

    public static void registerICache(ICache iCache) {
        if (c == null) {
            c = iCache;
        }
    }

    private static ContentResolver a() {
        Context context = f7326a;
        if (context != null) {
            return context.getContentResolver();
        }
        return null;
    }

    public static boolean checkFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (isContentUriPath(str)) {
            if (a() == null) {
                return false;
            }
            try {
                InputStream openInputStream = a().openInputStream(Uri.parse(str));
                if (openInputStream != null) {
                    IOUilts.close(openInputStream);
                    return true;
                }
                IOUilts.close(openInputStream);
            } catch (FileNotFoundException unused) {
                IOUilts.close((InputStream) null);
                return false;
            } catch (Throwable th) {
                IOUilts.close((InputStream) null);
                throw th;
            }
        }
        File file = new File(PathUtils.extractPath(str));
        return file.isFile() && file.exists();
    }

    public static Bitmap decodeBitmap(String str, BitmapFactory.Options options) {
        if (TextUtils.isEmpty(str) || options == null) {
            return null;
        }
        if (isContentUriPath(str)) {
            return decodeBitmapByContentUri(a(), str, options);
        }
        try {
            return BitmapFactory.decodeFile(PathUtils.extractPath(str), options);
        } catch (Throwable th) {
            b.e(th, "decodeBitmap exp=", new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 16) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 16) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        com.alipay.multimedia.adjuster.utils.IOUilts.close(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap decodeBitmapByContentUri(android.content.ContentResolver r4, java.lang.String r5, android.graphics.BitmapFactory.Options r6) {
        /*
            r0 = 0
            if (r4 == 0) goto L4f
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L4f
            if (r6 == 0) goto L4f
            r1 = 16
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch: java.lang.Throwable -> L30
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r4 = r4.openFileDescriptor(r5, r2)     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L2b
            java.io.FileDescriptor r5 = r4.getFileDescriptor()     // Catch: java.lang.Throwable -> L29
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFileDescriptor(r5, r0, r6)     // Catch: java.lang.Throwable -> L29
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r1) goto L28
            com.alipay.multimedia.adjuster.utils.IOUilts.close(r4)
        L28:
            return r5
        L29:
            r5 = move-exception
            goto L33
        L2b:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r1) goto L45
            goto L42
        L30:
            r4 = move-exception
            r5 = r4
            r4 = r0
        L33:
            com.alipay.multimedia.adjuster.utils.Log r6 = com.alipay.multimedia.adjuster.api.APMSandboxProcessor.b     // Catch: java.lang.Throwable -> L46
            java.lang.String r2 = "decodeBitmapByContentUri exp"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L46
            r6.e(r5, r2, r3)     // Catch: java.lang.Throwable -> L46
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 >= r1) goto L42
            goto L45
        L42:
            com.alipay.multimedia.adjuster.utils.IOUilts.close(r4)
        L45:
            return r0
        L46:
            r5 = move-exception
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 < r1) goto L4e
            com.alipay.multimedia.adjuster.utils.IOUilts.close(r4)
        L4e:
            throw r5
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.multimedia.adjuster.api.APMSandboxProcessor.decodeBitmapByContentUri(android.content.ContentResolver, java.lang.String, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static boolean isContentUriPath(String str) {
        return PathUtils.isContentUriPath(str);
    }

    public static String insertMediaFile(APMInsertReq aPMInsertReq) {
        return a(aPMInsertReq.getUri(), aPMInsertReq.getContext(), aPMInsertReq.getMimeType(), aPMInsertReq.getDisplayName(), aPMInsertReq.getDescription(), aPMInsertReq.getSourceData(), aPMInsertReq.getSavePrimaryDir(), aPMInsertReq.getSaveSecondaryDir());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0108 A[Catch: all -> 0x0128, TRY_LEAVE, TryCatch #3 {all -> 0x0128, blocks: (B:48:0x00d3, B:49:0x00d5, B:51:0x00df, B:52:0x00e3, B:67:0x00fe, B:69:0x0108), top: B:95:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.net.Uri r16, android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Object r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.multimedia.adjuster.api.APMSandboxProcessor.a(android.net.Uri, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.Object, java.lang.String, java.lang.String):java.lang.String");
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 10000;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.ContentResolver r3, android.graphics.Bitmap r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            java.lang.String r2 = "title"
            r1.put(r2, r5)
            java.lang.String r5 = "description"
            r1.put(r5, r6)
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L1b
            r5 = r7
            goto L1d
        L1b:
            java.lang.String r5 = "image/jpeg"
        L1d:
            java.lang.String r6 = "mime_type"
            r1.put(r6, r5)
            r5 = 0
            android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Exception -> L64
            android.net.Uri r6 = r3.insert(r6, r1)     // Catch: java.lang.Exception -> L64
            if (r4 == 0) goto L55
            java.io.OutputStream r1 = r3.openOutputStream(r6)     // Catch: java.lang.Exception -> L62
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L50
            if (r2 != 0) goto L45
            java.lang.String r2 = "image/png"
            boolean r7 = r2.equalsIgnoreCase(r7)     // Catch: java.lang.Throwable -> L50
            if (r7 == 0) goto L45
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L50
            r2 = 100
            r4.compress(r7, r2, r1)     // Catch: java.lang.Throwable -> L50
            goto L4c
        L45:
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L50
            r2 = 80
            r4.compress(r7, r2, r1)     // Catch: java.lang.Throwable -> L50
        L4c:
            com.alipay.multimedia.adjuster.utils.IOUilts.close(r1)     // Catch: java.lang.Exception -> L62
            goto L75
        L50:
            r4 = move-exception
            com.alipay.multimedia.adjuster.utils.IOUilts.close(r1)     // Catch: java.lang.Exception -> L62
            throw r4     // Catch: java.lang.Exception -> L62
        L55:
            com.alipay.multimedia.adjuster.utils.Log r4 = com.alipay.multimedia.adjuster.api.APMSandboxProcessor.b     // Catch: java.lang.Exception -> L62
            java.lang.String r7 = "Failed to create thumbnail, removing original"
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L62
            r4.e(r7, r1)     // Catch: java.lang.Exception -> L62
            r3.delete(r6, r0, r0)     // Catch: java.lang.Exception -> L62
            goto L74
        L62:
            r4 = move-exception
            goto L66
        L64:
            r4 = move-exception
            r6 = r0
        L66:
            com.alipay.multimedia.adjuster.utils.Log r7 = com.alipay.multimedia.adjuster.api.APMSandboxProcessor.b
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r1 = "Failed to insert image"
            r7.e(r4, r1, r5)
            if (r6 == 0) goto L75
            r3.delete(r6, r0, r0)
        L74:
            r6 = r0
        L75:
            if (r6 == 0) goto L7b
            java.lang.String r0 = r6.toString()
        L7b:
            android.content.Context r3 = com.alipay.multimedia.adjuster.api.APMSandboxProcessor.f7326a
            com.alipay.multimedia.adjuster.utils.FileUtils.scanPictureAsync(r3, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.multimedia.adjuster.api.APMSandboxProcessor.a(android.content.ContentResolver, android.graphics.Bitmap, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static final String a(ContentResolver contentResolver, String str, String str2, String str3, String str4) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            String a2 = a(contentResolver, decodeFile, str2, str3, str4);
            decodeFile.recycle();
            return a2;
        } finally {
            IOUilts.close((InputStream) fileInputStream);
        }
    }

    public static int deleteMediaFile(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        if (!isContentUriPath(str)) {
            new File(PathUtils.extractPath(str)).deleteOnExit();
            return 0;
        }
        return context.getContentResolver().delete(Uri.parse(str), null, null);
    }

    private static boolean a(Uri uri, String str) {
        return (uri == MediaStore.Images.Media.EXTERNAL_CONTENT_URI) && (TextUtils.isEmpty(str) || (str.startsWith("image/") && !str.equalsIgnoreCase("image/gif")));
    }

    public static boolean isLocalFile(String str) {
        return PathUtils.isLocalFile(str) || isContentUriPath(str);
    }

    public static String copyContentUriFile(APMSaveReq aPMSaveReq) {
        InputStream inputStream;
        if (aPMSaveReq == null || TextUtils.isEmpty(aPMSaveReq.getUri())) {
            return null;
        }
        String savePth = aPMSaveReq.getSavePth();
        try {
            if (TextUtils.isEmpty(aPMSaveReq.getSavePth()) && c != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(c.getCacheRootDir());
                sb.append(TEMP_DIR);
                sb.append(System.currentTimeMillis());
                savePth = sb.toString();
            }
            if (TextUtils.isEmpty(savePth)) {
                IOUilts.close((InputStream) null);
                return null;
            }
            inputStream = a().openInputStream(Uri.parse(aPMSaveReq.getUri()));
            if (inputStream == null) {
                return null;
            }
            try {
                if (FileUtils.safeCopyToFile(inputStream, new File(savePth))) {
                    Log log = b;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("copyContentUriFile dest=");
                    sb2.append(savePth);
                    log.d(sb2.toString(), new Object[0]);
                    return savePth;
                }
                return null;
            } catch (Throwable unused) {
                try {
                    FileUtils.delete(new File(savePth));
                    return null;
                } finally {
                    IOUilts.close(inputStream);
                }
            }
        } catch (Throwable unused2) {
            inputStream = null;
        }
    }

    public static boolean isSandBoxSdk() {
        return Build.VERSION.SDK_INT > 28 || (Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }

    public static Bitmap loadThumbnail(Uri uri, int i, int i2) {
        if (isSandBoxSdk() && i > 0 && i2 > 0 && i <= 512 && i2 <= 512) {
            try {
                if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT >= 29) {
                    return a().loadThumbnail(uri, new Size(i, i2), null);
                }
            } catch (Exception e) {
                Log log = b;
                StringBuilder sb = new StringBuilder();
                sb.append("loadThumbnail exp=");
                sb.append(e.toString());
                log.d(sb.toString(), new Object[0]);
            }
        }
        return null;
    }
}
