package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ThumbnailStreamOpener {
    private static final FileService getAuthRequestContext = new FileService();
    private final ArrayPool BuiltInFictitiousFunctionClassFactory;
    private final List<ImageHeaderParser> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ThumbnailQuery MyBillsEntityDataFactory;
    private final ContentResolver PlaceComponentResult;
    private final FileService getErrorConfigVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, getAuthRequestContext, thumbnailQuery, arrayPool, contentResolver);
    }

    private ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.getErrorConfigVersion = fileService;
        this.MyBillsEntityDataFactory = thumbnailQuery;
        this.BuiltInFictitiousFunctionClassFactory = arrayPool;
        this.PlaceComponentResult = contentResolver;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getAuthRequestContext(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.PlaceComponentResult.openInputStream(uri);
                int KClassImpl$Data$declaredNonStaticMembers$2 = ImageHeaderParserUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, inputStream, this.BuiltInFictitiousFunctionClassFactory);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return KClassImpl$Data$declaredNonStaticMembers$2;
            } catch (IOException | NullPointerException e) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to open uri: ");
                    sb.append(uri);
                    InstrumentInjector.log_d("ThumbStreamOpener", sb.toString(), e);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused2) {
                        return -1;
                    }
                }
                return -1;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public final InputStream KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) throws FileNotFoundException {
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(uri);
        if (TextUtils.isEmpty(MyBillsEntityDataFactory)) {
            return null;
        }
        File authRequestContext = FileService.getAuthRequestContext(MyBillsEntityDataFactory);
        if (MyBillsEntityDataFactory(authRequestContext)) {
            Uri fromFile = Uri.fromFile(authRequestContext);
            try {
                return this.PlaceComponentResult.openInputStream(fromFile);
            } catch (NullPointerException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("NPE opening uri: ");
                sb.append(uri);
                sb.append(" -> ");
                sb.append(fromFile);
                throw ((FileNotFoundException) new FileNotFoundException(sb.toString()).initCause(e));
            }
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x001d: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:12:0x001d */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String MyBillsEntityDataFactory(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r2 = r6.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L27 java.lang.SecurityException -> L29
            android.database.Cursor r2 = r2.BuiltInFictitiousFunctionClassFactory(r7)     // Catch: java.lang.Throwable -> L27 java.lang.SecurityException -> L29
            if (r2 == 0) goto L21
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L1c java.lang.SecurityException -> L1f
            if (r3 == 0) goto L21
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch: java.lang.Throwable -> L1c java.lang.SecurityException -> L1f
            if (r2 == 0) goto L1b
            r2.close()
        L1b:
            return r7
        L1c:
            r7 = move-exception
            r1 = r2
            goto L4d
        L1f:
            r3 = move-exception
            goto L2c
        L21:
            if (r2 == 0) goto L26
            r2.close()
        L26:
            return r1
        L27:
            r7 = move-exception
            goto L4d
        L29:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L2c:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L47
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            r4.<init>()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L1c
            r4.append(r7)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L1c
            com.fullstory.instrumentation.InstrumentInjector.log_d(r0, r7, r3)     // Catch: java.lang.Throwable -> L1c
        L47:
            if (r2 == 0) goto L4c
            r2.close()
        L4c:
            return r1
        L4d:
            if (r1 == 0) goto L52
            r1.close()
        L52:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.MyBillsEntityDataFactory(android.net.Uri):java.lang.String");
    }

    private boolean MyBillsEntityDataFactory(File file) {
        long length;
        if (FileService.PlaceComponentResult(file)) {
            length = file.length();
            if (0 < length) {
                return true;
            }
        }
        return false;
    }
}
