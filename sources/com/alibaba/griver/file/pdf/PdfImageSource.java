package com.alibaba.griver.file.pdf;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class PdfImageSource {
    private int b = 0;

    /* renamed from: a  reason: collision with root package name */
    private List<Bitmap> f6536a = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e A[Catch: IOException -> 0x0091, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x0091, blocks: (B:50:0x008e, B:30:0x0064), top: B:54:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void open(java.lang.String r7, int r8, int r9) {
        /*
            r6 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L80
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L80
            r7 = 268435456(0x10000000, float:2.5243549E-29)
            android.os.ParcelFileDescriptor r7 = android.os.ParcelFileDescriptor.open(r1, r7)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L80
            if (r7 == 0) goto L1b
            android.graphics.pdf.PdfRenderer r1 = new android.graphics.pdf.PdfRenderer     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L18
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L18
            goto L1c
        L14:
            r8 = move-exception
            r1 = r0
            goto L70
        L18:
            r1 = r0
            goto L82
        L1b:
            r1 = r0
        L1c:
            int r2 = r1.getPageCount()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r6.b = r2     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            int r2 = r1.getPageCount()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r2 <= 0) goto L58
            int r2 = r1.getPageCount()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r6.b = r2     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2 = 0
            r3 = r0
        L30:
            int r4 = r1.getPageCount()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            if (r2 >= r4) goto L51
            if (r3 == 0) goto L3b
            r3.close()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
        L3b:
            android.graphics.pdf.PdfRenderer$Page r3 = r1.openPage(r2)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_4444     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r8, r9, r4)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            r5 = 1
            r3.render(r4, r0, r0, r5)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            java.util.List<android.graphics.Bitmap> r5 = r6.f6536a     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            r5.add(r4)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
            int r2 = r2 + 1
            goto L30
        L51:
            r0 = r3
            goto L58
        L53:
            r8 = move-exception
            r0 = r3
            goto L70
        L56:
            r0 = r3
            goto L82
        L58:
            if (r0 == 0) goto L5d
            r0.close()
        L5d:
            if (r1 == 0) goto L62
            r1.close()
        L62:
            if (r7 == 0) goto L91
            r7.close()     // Catch: java.io.IOException -> L91
            return
        L68:
            r8 = move-exception
            goto L70
        L6a:
            goto L82
        L6c:
            r7 = move-exception
            r8 = r7
            r7 = r0
            r1 = r7
        L70:
            if (r0 == 0) goto L75
            r0.close()
        L75:
            if (r1 == 0) goto L7a
            r1.close()
        L7a:
            if (r7 == 0) goto L7f
            r7.close()     // Catch: java.io.IOException -> L7f
        L7f:
            throw r8
        L80:
            r7 = r0
            r1 = r7
        L82:
            if (r0 == 0) goto L87
            r0.close()
        L87:
            if (r1 == 0) goto L8c
            r1.close()
        L8c:
            if (r7 == 0) goto L91
            r7.close()     // Catch: java.io.IOException -> L91
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.file.pdf.PdfImageSource.open(java.lang.String, int, int):void");
    }

    public int getTotalCount() {
        return this.b;
    }

    public Bitmap getItem(int i) {
        if (i >= 0 && i < this.b && !this.f6536a.isEmpty()) {
            return this.f6536a.get(i);
        }
        return null;
    }

    public void close() {
        synchronized (this) {
            for (Bitmap bitmap : this.f6536a) {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.f6536a.clear();
        }
    }
}
