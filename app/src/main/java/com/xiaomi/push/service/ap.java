package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: classes8.dex */
public class ap {
    private static long PlaceComponentResult;

    /* loaded from: classes8.dex */
    public static class a {
        byte[] BuiltInFictitiousFunctionClassFactory;
        int getAuthRequestContext;

        public a(byte[] bArr, int i) {
            this.BuiltInFictitiousFunctionClassFactory = bArr;
            this.getAuthRequestContext = i;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public Bitmap BuiltInFictitiousFunctionClassFactory = null;
        public long PlaceComponentResult = 0;
    }

    /*  JADX ERROR: Type inference failed with exception
        java.lang.NullPointerException
        */
    /* JADX WARN: Failed to calculate best type for var: r1v0 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v1 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v3 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v6 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v7 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v0 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r3v0 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0045: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:53:0x0045 */
    public static android.graphics.Bitmap KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context r3, java.lang.String r4) {
        /*
            android.net.Uri r4 = android.net.Uri.parse(r4)
            r0 = 0
            android.content.ContentResolver r1 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L36
            java.io.InputStream r1 = r1.openInputStream(r4)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L36
            int r2 = MyBillsEntityDataFactory(r3, r1)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L44
            r4.<init>()     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L44
            r4.inSampleSize = r2     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L44
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3, r0, r4)     // Catch: java.io.IOException -> L2b java.lang.Throwable -> L44
            com.xiaomi.push.h.MyBillsEntityDataFactory(r3)
            com.xiaomi.push.h.MyBillsEntityDataFactory(r1)
            return r4
        L2b:
            r4 = move-exception
            goto L3a
        L2d:
            r3 = move-exception
            goto L49
        L2f:
            r3 = move-exception
            r4 = r3
            r3 = r0
            goto L3a
        L33:
            r3 = move-exception
            r1 = r0
            goto L49
        L36:
            r3 = move-exception
            r4 = r3
            r3 = r0
            r1 = r3
        L3a:
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(r4)     // Catch: java.lang.Throwable -> L44
            com.xiaomi.push.h.MyBillsEntityDataFactory(r3)
            com.xiaomi.push.h.MyBillsEntityDataFactory(r1)
            return r0
        L44:
            r4 = move-exception
            r0 = r1
            r1 = r0
            r0 = r3
            r3 = r4
        L49:
            com.xiaomi.push.h.MyBillsEntityDataFactory(r0)
            com.xiaomi.push.h.MyBillsEntityDataFactory(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ap.KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /*  JADX ERROR: Type inference failed with exception
        java.lang.NullPointerException
        */
    /* JADX WARN: Failed to calculate best type for var: r1v0 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v1 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v14 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v2 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v4 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v5 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v6 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v7 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r1v8 ??
    java.lang.NullPointerException
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x010a: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:142:0x010a */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x010c: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:142:0x010a */
    private static com.xiaomi.push.service.ap.a KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ap.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String, boolean):com.xiaomi.push.service.ap$a");
    }

    private static int MyBillsEntityDataFactory(Context context, InputStream inputStream) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((context.getResources().getDisplayMetrics().densityDpi / 160.0f) * 48.0f);
        if (options.outWidth <= round || options.outHeight <= round) {
            return 1;
        }
        return Math.min(options.outWidth / round, options.outHeight / round);
    }

    private static Bitmap MyBillsEntityDataFactory(Context context, String str) {
        FileInputStream fileInputStream;
        Bitmap bitmap;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getPath());
        sb.append(File.separator);
        sb.append("mipush_icon");
        File file = new File(sb.toString(), com.xiaomi.push.ad.PlaceComponentResult(str));
        FileInputStream fileInputStream2 = null;
        Bitmap bitmap2 = null;
        fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmap2 = BitmapFactory.decodeStream(fileInputStream);
                    file.setLastModified(System.currentTimeMillis());
                    com.xiaomi.push.h.MyBillsEntityDataFactory((Closeable) fileInputStream);
                    return bitmap2;
                } catch (Exception e) {
                    e = e;
                    Bitmap bitmap3 = bitmap2;
                    fileInputStream2 = fileInputStream;
                    bitmap = bitmap3;
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                    com.xiaomi.push.h.MyBillsEntityDataFactory((Closeable) fileInputStream2);
                    return bitmap;
                } catch (Throwable th) {
                    th = th;
                    com.xiaomi.push.h.MyBillsEntityDataFactory((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
            }
        } catch (Exception e2) {
            e = e2;
            bitmap = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0052 A[Catch: all -> 0x0172, Exception -> 0x0175, TryCatch #4 {Exception -> 0x0175, blocks: (B:132:0x002d, B:141:0x004e, B:143:0x0052, B:144:0x0059, B:146:0x0082, B:148:0x0088, B:149:0x008e, B:163:0x00c8, B:162:0x00c5, B:164:0x00ca, B:166:0x00f1, B:167:0x00f4, B:174:0x0116, B:191:0x0132, B:193:0x013b, B:197:0x016b, B:198:0x0171, B:190:0x012e), top: B:214:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0059 A[Catch: all -> 0x0172, Exception -> 0x0175, TryCatch #4 {Exception -> 0x0175, blocks: (B:132:0x002d, B:141:0x004e, B:143:0x0052, B:144:0x0059, B:146:0x0082, B:148:0x0088, B:149:0x008e, B:163:0x00c8, B:162:0x00c5, B:164:0x00ca, B:166:0x00f1, B:167:0x00f4, B:174:0x0116, B:191:0x0132, B:193:0x013b, B:197:0x016b, B:198:0x0171, B:190:0x012e), top: B:214:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x013b A[Catch: all -> 0x0172, Exception -> 0x0175, TryCatch #4 {Exception -> 0x0175, blocks: (B:132:0x002d, B:141:0x004e, B:143:0x0052, B:144:0x0059, B:146:0x0082, B:148:0x0088, B:149:0x008e, B:163:0x00c8, B:162:0x00c5, B:164:0x00ca, B:166:0x00f1, B:167:0x00f4, B:174:0x0116, B:191:0x0132, B:193:0x013b, B:197:0x016b, B:198:0x0171, B:190:0x012e), top: B:214:0x002d }] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.io.OutputStream, java.io.Closeable, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.xiaomi.push.service.ap.b MyBillsEntityDataFactory(android.content.Context r15, java.lang.String r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ap.MyBillsEntityDataFactory(android.content.Context, java.lang.String, boolean):com.xiaomi.push.service.ap$b");
    }
}
