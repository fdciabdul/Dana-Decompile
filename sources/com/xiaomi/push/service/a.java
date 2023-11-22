package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes8.dex */
public class a {
    private static volatile a BuiltInFictitiousFunctionClassFactory;
    private Context MyBillsEntityDataFactory;
    private volatile String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private volatile String scheduleImpl;
    private final Object getAuthRequestContext = new Object();
    private final Object PlaceComponentResult = new Object();
    private final String KClassImpl$Data$declaredNonStaticMembers$2 = "mipush_region";
    private final String moveToNextValue = "mipush_country_code";
    private final String lookAheadTest = "mipush_region.lock";
    private final String getErrorConfigVersion = "mipush_country_code.lock";

    private a(Context context) {
        this.MyBillsEntityDataFactory = context;
    }

    public static a BuiltInFictitiousFunctionClassFactory(Context context) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (a.class) {
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = new a(context);
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private static void BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                File file = new File(context.getFilesDir(), str3);
                com.xiaomi.push.h.BuiltInFictitiousFunctionClassFactory(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Exception e) {
                e = e;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = null;
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e2) {
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e2);
                    }
                }
                com.xiaomi.push.h.MyBillsEntityDataFactory(randomAccessFile);
                throw th;
            }
            try {
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                    com.xiaomi.push.h.KClassImpl$Data$declaredNonStaticMembers$2(new File(context.getFilesDir(), str2), str);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                            com.xiaomi.push.h.MyBillsEntityDataFactory(randomAccessFile);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    com.xiaomi.push.h.MyBillsEntityDataFactory(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e5) {
                        e = e5;
                        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                        com.xiaomi.push.h.MyBillsEntityDataFactory(randomAccessFile);
                    }
                }
                com.xiaomi.push.h.MyBillsEntityDataFactory(randomAccessFile);
            }
            com.xiaomi.push.h.MyBillsEntityDataFactory(randomAccessFile);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.RandomAccessFile, java.io.Closeable] */
    private static String PlaceComponentResult(Context context, String str, String str2, Object obj) {
        Throwable th;
        Exception e;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        ?? r2 = 0;
        r2 = 0;
        if (!file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append("No ready file to get data from ");
            sb.append(str);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            return null;
        }
        synchronized (obj) {
            try {
                try {
                    File file2 = new File(context.getFilesDir(), str2);
                    com.xiaomi.push.h.BuiltInFictitiousFunctionClassFactory(file2);
                    context = new RandomAccessFile(file2, "rw");
                } catch (Exception e2) {
                    e = e2;
                    context = 0;
                    fileLock = null;
                } catch (Throwable th2) {
                    th = th2;
                    context = 0;
                }
                try {
                    fileLock = context.getChannel().lock();
                } catch (Exception e3) {
                    e = e3;
                    fileLock = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (r2 != 0 && r2.isValid()) {
                        try {
                            r2.release();
                        } catch (IOException e4) {
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e4);
                        }
                    }
                    com.xiaomi.push.h.MyBillsEntityDataFactory((Closeable) context);
                    throw th;
                }
                try {
                    String authRequestContext = com.xiaomi.push.h.getAuthRequestContext(file);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e5);
                        }
                    }
                    com.xiaomi.push.h.MyBillsEntityDataFactory((Closeable) context);
                    return authRequestContext;
                } catch (Exception e6) {
                    e = e6;
                    com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e7) {
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e7);
                        }
                    }
                    com.xiaomi.push.h.MyBillsEntityDataFactory((Closeable) context);
                    return null;
                }
            } catch (Throwable th4) {
                r2 = str;
                th = th4;
            }
        }
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        if (TextUtils.isEmpty(this.scheduleImpl)) {
            this.scheduleImpl = PlaceComponentResult(this.MyBillsEntityDataFactory, "mipush_region", "mipush_region.lock", this.getAuthRequestContext);
        }
        return this.scheduleImpl;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (TextUtils.equals(str, this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0, "mipush_country_code", "mipush_country_code.lock", this.PlaceComponentResult);
    }

    public final String PlaceComponentResult() {
        if (TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = PlaceComponentResult(this.MyBillsEntityDataFactory, "mipush_country_code", "mipush_country_code.lock", this.PlaceComponentResult);
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public final void PlaceComponentResult(String str) {
        if (TextUtils.equals(str, this.scheduleImpl)) {
            return;
        }
        this.scheduleImpl = str;
        BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, this.scheduleImpl, "mipush_region", "mipush_region.lock", this.getAuthRequestContext);
    }
}
