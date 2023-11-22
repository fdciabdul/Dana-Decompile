package com.alibaba.griver.base.common.utils;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.MimeTypeMap;
import com.alibaba.ariver.kernel.common.io.PoolingByteArrayOutputStream;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.a.b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Date;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* loaded from: classes2.dex */
public class H5FileUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int MyBillsEntityDataFactory = 0;
    public static final String TAG = "H5FileUtil";
    private static long getAuthRequestContext = -6119534228473090880L;

    public static boolean create(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 != 0 ? 'b' : (char) 18) != 18) {
            return create(str, false);
        }
        try {
            return create(str, false);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        if ((!r0) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean create(java.lang.String r5, boolean r6) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r0 = r0 + 25
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 79
            if (r0 != 0) goto L11
            r0 = 79
            goto L12
        L11:
            r0 = 2
        L12:
            r3 = 1
            r4 = 0
            if (r0 == r2) goto L1d
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L2a
            goto L63
        L1d:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L64
            if (r0 == 0) goto L27
            r0 = 0
            goto L28
        L27:
            r0 = 1
        L28:
            if (r0 == 0) goto L63
        L2a:
            boolean r0 = exists(r5)
            if (r0 == 0) goto L32
            r0 = 1
            goto L33
        L32:
            r0 = 0
        L33:
            if (r0 == 0) goto L3f
            int r5 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 63
            int r6 = r5 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r6
            int r5 = r5 % r1
            return r3
        L3f:
            java.lang.String r0 = getParent(r5)
            mkdirs(r0, r6)
            java.io.File r6 = new java.io.File     // Catch: java.lang.Exception -> L5b
            r6.<init>(r5)     // Catch: java.lang.Exception -> L5b
            boolean r5 = r6.createNewFile()     // Catch: java.lang.Exception -> L5b
            int r6 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L59
            int r6 = r6 + 101
            int r0 = r6 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> L59
            int r6 = r6 % r1
            return r5
        L59:
            r5 = move-exception
            throw r5
        L5b:
            r5 = move-exception
            java.lang.String r6 = "H5FileUtil"
            java.lang.String r0 = "exception detail"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r6, r0, r5)
        L63:
            return r4
        L64:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.create(java.lang.String, boolean):boolean");
    }

    public static boolean mkdirs(String str) {
        int i = MyBillsEntityDataFactory + 115;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            try {
                return mkdirs(str, true);
            } catch (Exception e) {
                throw e;
            }
        }
        return mkdirs(str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r6 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        if (r6 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        r5 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 95;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        delete(r1);
        r5 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 111;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r5 % 128;
        r5 = r5 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean mkdirs(java.lang.String r5, boolean r6) {
        /*
            java.lang.String r0 = "H5FileUtil"
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = exists(r5)
            if (r2 == 0) goto L4d
            boolean r5 = isFolder(r5)     // Catch: java.lang.Exception -> L4b
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L17
            r5 = 1
            goto L18
        L17:
            r5 = 0
        L18:
            if (r5 == 0) goto L4d
            int r5 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r5 = r5 + 33
            int r4 = r5 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r5 = r5 % 2
            if (r5 != 0) goto L27
            r2 = 0
        L27:
            if (r2 == 0) goto L2c
            if (r6 != 0) goto L3b
            goto L30
        L2c:
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L49
            if (r6 != 0) goto L3b
        L30:
            int r5 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r5 + 95
            int r6 = r5 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r6
            int r5 = r5 % 2
            return r3
        L3b:
            delete(r1)     // Catch: java.lang.Exception -> L4b
            int r5 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L4b
            int r5 = r5 + 111
            int r6 = r5 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r6     // Catch: java.lang.Exception -> L4b
            int r5 = r5 % 2
            goto L4d
        L49:
            r5 = move-exception
            throw r5
        L4b:
            r5 = move-exception
            throw r5
        L4d:
            boolean r5 = r1.mkdirs()     // Catch: java.lang.Exception -> L66
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L66
            r6.<init>()     // Catch: java.lang.Exception -> L66
            java.lang.String r2 = "create dir "
            r6.append(r2)     // Catch: java.lang.Exception -> L66
            r6.append(r5)     // Catch: java.lang.Exception -> L66
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Exception -> L66
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r5)     // Catch: java.lang.Exception -> L66
            goto L6c
        L66:
            r5 = move-exception
            java.lang.String r6 = "exception detail"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r6, r5)
        L6c:
            boolean r5 = exists(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.mkdirs(java.lang.String, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        if ((!r0 ? ':' : kotlin.text.Typography.less) != ':') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        if (android.text.TextUtils.equals(r5, "/") != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory + 71;
        com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        if ((r0 % 2) != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        r0 = r5.contains("../");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        r3 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        if (r0 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
    
        r0 = 'D';
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        r0 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        if (r0 == 'D') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:
    
        if (r5.contains("../") != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0062, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        if (r0 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006e, code lost:
    
        if (r5.contains("/..") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0072, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0073, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0074, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0075, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean checkPathValid(java.lang.String r5) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 125
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 91
            if (r0 == 0) goto L11
            r0 = 8
            goto L13
        L11:
            r0 = 91
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L2c
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L2a
            int r1 = r3.length     // Catch: java.lang.Throwable -> L28
            r1 = 58
            if (r0 != 0) goto L23
            r0 = 58
            goto L25
        L23:
            r0 = 60
        L25:
            if (r0 == r1) goto L32
            goto L75
        L28:
            r5 = move-exception
            throw r5
        L2a:
            r5 = move-exception
            goto L71
        L2c:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L75
        L32:
            java.lang.String r0 = "/"
            boolean r0 = android.text.TextUtils.equals(r5, r0)
            r1 = 0
            if (r0 != 0) goto L74
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r0 = r0 + 71
            int r4 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r0 = r0 % 2
            java.lang.String r4 = "../"
            if (r0 != 0) goto L5c
            boolean r0 = r5.contains(r4)
            int r3 = r3.length     // Catch: java.lang.Throwable -> L5a
            r3 = 68
            if (r0 != 0) goto L55
            r0 = 68
            goto L57
        L55:
            r0 = 84
        L57:
            if (r0 == r3) goto L68
            goto L74
        L5a:
            r5 = move-exception
            throw r5
        L5c:
            boolean r0 = r5.contains(r4)     // Catch: java.lang.Exception -> L72
            if (r0 != 0) goto L64
            r0 = 0
            goto L65
        L64:
            r0 = 1
        L65:
            if (r0 == 0) goto L68
            goto L74
        L68:
            java.lang.String r0 = "/.."
            boolean r5 = r5.contains(r0)     // Catch: java.lang.Exception -> L2a
            if (r5 == 0) goto L75
            goto L74
        L71:
            throw r5
        L72:
            r5 = move-exception
            throw r5
        L74:
            return r1
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.checkPathValid(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if ((android.text.TextUtils.isEmpty(r4) ? false : true) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        if ((android.text.TextUtils.isEmpty(r4)) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r4.equals("/") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        r4 = delete(new java.io.File(r4));
        r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory + 21;
        com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean delete(java.lang.String r4) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 49
            if (r0 != 0) goto L11
            r0 = 49
            goto L13
        L11:
            r0 = 37
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L22
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L1e
            goto L1f
        L1e:
            r2 = 0
        L1f:
            if (r2 == 0) goto L4b
            goto L2f
        L22:
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L4e
            r1 = 38
            int r1 = r1 / r3
            if (r0 != 0) goto L2c
            r2 = 0
        L2c:
            if (r2 == 0) goto L2f
            goto L4b
        L2f:
            java.lang.String r0 = "/"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L4b
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = delete(r0)
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r0 = r0 + 21
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            return r4
        L4b:
            return r3
        L4c:
            r4 = move-exception
            throw r4
        L4e:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.delete(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean delete(java.io.File r8) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> Lb3
            int r0 = r0 + 19
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> Lb3
            int r0 = r0 % 2
            r1 = 73
            if (r0 == 0) goto L11
            r0 = 73
            goto L13
        L11:
            r0 = 8
        L13:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1f
            boolean r0 = exists(r8)
            if (r0 == 0) goto Lb2
            r0 = 1
            goto L26
        L1f:
            boolean r0 = exists(r8)
            if (r0 == 0) goto Lb2
            r0 = 0
        L26:
            java.lang.String r1 = r8.getAbsolutePath()
            java.lang.String r4 = "/"
            boolean r1 = android.text.TextUtils.equals(r4, r1)
            if (r1 != 0) goto L34
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            if (r1 == 0) goto L39
            goto Lb2
        L39:
            int r1 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r1 = r1 + 35
            int r4 = r1 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r1 = r1 % 2
            boolean r1 = r8.isFile()
            java.lang.String r4 = "H5FileUtil"
            java.lang.String r5 = "deleteFile:"
            if (r1 == 0) goto L68
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = r8.getAbsolutePath()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r4, r0)
            boolean r8 = r8.delete()
            return r8
        L68:
            java.io.File[] r1 = r8.listFiles()
            r6 = 85
            if (r1 != 0) goto L73
            r7 = 85
            goto L75
        L73:
            r7 = 43
        L75:
            if (r7 == r6) goto Lb2
            int r3 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r3 = r3 + 93
            int r6 = r3 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r3 = r3 % 2
        L81:
            int r3 = r1.length
            if (r2 >= r3) goto L8e
            r3 = r1[r2]
            boolean r3 = delete(r3)     // Catch: java.lang.Exception -> Lb3
            r0 = r0 | r3
            int r2 = r2 + 1
            goto L81
        L8e:
            boolean r1 = r8.delete()
            r0 = r0 | r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r8 = r8.getAbsolutePath()
            r1.append(r8)
            java.lang.String r8 = " result:"
            r1.append(r8)
            r1.append(r0)
            java.lang.String r8 = r1.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r4, r8)
            return r0
        Lb2:
            return r3
        Lb3:
            r8 = move-exception
            goto Lb6
        Lb5:
            throw r8
        Lb6:
            goto Lb5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.delete(java.io.File):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        if ((r0 ? 20 : '\b') != 20) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3)) != true) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        return exists(new java.io.File(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        r3 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory + 51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0043, code lost:
    
        if ((r3 % 2) != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        r3 = 39 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean exists(java.lang.String r3) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L4e
            int r0 = r0 + 97
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L4e
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L23
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L21
            r2 = 20
            if (r0 == 0) goto L1c
            r0 = 20
            goto L1e
        L1c:
            r0 = 8
        L1e:
            if (r0 == r2) goto L39
            goto L2f
        L21:
            r3 = move-exception
            throw r3
        L23:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L4c
            r2 = 1
            if (r0 == 0) goto L2c
            r0 = 1
            goto L2d
        L2c:
            r0 = 0
        L2d:
            if (r0 == r2) goto L39
        L2f:
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = exists(r0)
            return r3
        L39:
            int r3 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L4e
            int r3 = r3 + 51
            int r0 = r3 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L4c
            int r3 = r3 % 2
            if (r3 != 0) goto L4b
            r3 = 39
            int r3 = r3 / r1
            return r1
        L49:
            r3 = move-exception
            throw r3
        L4b:
            return r1
        L4c:
            r3 = move-exception
            throw r3
        L4e:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.exists(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        if (r3 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0020, code lost:
    
        if ((r3 != null) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0026, code lost:
    
        if (r3.exists() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0028, code lost:
    
        r3 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r3 % 128;
        r3 = r3 % 2;
        r3 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory + 15;
        com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean exists(java.io.File r3) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L49
            int r0 = r0 + 121
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L49
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L1b
            r0 = 18
            int r0 = r0 / r1
            if (r3 == 0) goto L3e
            goto L22
        L19:
            r3 = move-exception
            throw r3
        L1b:
            if (r3 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 == 0) goto L3e
        L22:
            boolean r3 = r3.exists()
            if (r3 == 0) goto L3e
            int r3 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 43
            int r0 = r3 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r0
            int r3 = r3 % 2
            int r3 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r3 = r3 + 15
            int r0 = r3 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r3 = r3 % 2
            r1 = 1
            goto L48
        L3e:
            int r3 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 81
            int r0 = r3 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r0
            int r3 = r3 % 2
        L48:
            return r1
        L49:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.exists(java.io.File):boolean");
    }

    public static String getParent(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            if (TextUtils.isEmpty(str)) {
                int i3 = MyBillsEntityDataFactory + 43;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return null;
            }
            return getParent(new File(cleanPath(str)));
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getParent(File file) {
        int i = MyBillsEntityDataFactory + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Object obj = null;
        if (!(file == null)) {
            try {
                String parent = file.getParent();
                int i3 = MyBillsEntityDataFactory + 65;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    obj.hashCode();
                    return parent;
                }
                return parent;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3) ? 15 : 5) != 5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0036, code lost:
    
        if ((r0 ? '\b' : 'M') != '\b') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.griver.base.common.utils.H5FileUtil.TAG, "Exception", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 119;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
        r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return new java.io.File(r3).getCanonicalPath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String cleanPath(java.lang.String r3) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 35
            if (r0 == 0) goto L11
            r0 = 35
            goto L13
        L11:
            r0 = 49
        L13:
            if (r0 == r1) goto L25
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L23
            r1 = 5
            if (r0 == 0) goto L1f
            r0 = 15
            goto L20
        L1f:
            r0 = 5
        L20:
            if (r0 == r1) goto L38
            goto L4b
        L23:
            r3 = move-exception
            throw r3
        L25:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L60
            r1 = 8
            if (r0 == 0) goto L34
            r0 = 8
            goto L36
        L34:
            r0 = 77
        L36:
            if (r0 == r1) goto L4b
        L38:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L42
            r0.<init>(r3)     // Catch: java.lang.Exception -> L42
            java.lang.String r3 = r0.getCanonicalPath()     // Catch: java.lang.Exception -> L42
            goto L4a
        L42:
            r0 = move-exception
            java.lang.String r1 = "H5FileUtil"
            java.lang.String r2 = "Exception"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r2, r0)
        L4a:
            return r3
        L4b:
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 119
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 79
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return r3
        L60:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.cleanPath(java.lang.String):java.lang.String");
    }

    public static long size(String str) {
        int i = MyBillsEntityDataFactory + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 20 / 0;
            if (!(str != null)) {
                return 0L;
            }
        } else if (str == null) {
            return 0L;
        }
        long size = size(new File(str));
        int i3 = MyBillsEntityDataFactory + 17;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return size;
        }
        return size;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        if ((r8.length == 0 ? 'W' : 3) != 'W') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
    
        if ((r8.length == 0) != true) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:
    
        r0 = r8.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005a, code lost:
    
        if (r5 >= r0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005c, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005e, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005f, code lost:
    
        if (r6 == true) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0067, code lost:
    
        r1 = r1 + size(r8[r5]);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006b, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006c, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006d, code lost:
    
        r8 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r8 % 128;
        r8 = r8 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long size(java.io.File r8) {
        /*
            boolean r0 = exists(r8)     // Catch: java.lang.Exception -> L78
            r1 = 0
            if (r0 != 0) goto L9
            return r1
        L9:
            boolean r0 = isFile(r8)
            if (r0 == 0) goto L2b
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory
            int r0 = r0 + 67
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L26
            long r0 = r8.length()
            r8 = 0
            r8.hashCode()     // Catch: java.lang.Throwable -> L24
            goto L2a
        L24:
            r8 = move-exception
            throw r8
        L26:
            long r0 = r8.length()
        L2a:
            return r0
        L2b:
            java.io.File[] r8 = r8.listFiles()
            if (r8 == 0) goto L77
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 39
            int r3 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r3
            int r0 = r0 % 2
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L50
            int r0 = r8.length
            r5 = 84
            int r5 = r5 / r3
            r5 = 87
            if (r0 != 0) goto L4a
            r0 = 87
            goto L4b
        L4a:
            r0 = 3
        L4b:
            if (r0 == r5) goto L6d
            goto L58
        L4e:
            r8 = move-exception
            throw r8
        L50:
            int r0 = r8.length
            if (r0 != 0) goto L55
            r0 = 1
            goto L56
        L55:
            r0 = 0
        L56:
            if (r0 == r4) goto L6d
        L58:
            int r0 = r8.length
            r5 = 0
        L5a:
            if (r5 >= r0) goto L5e
            r6 = 0
            goto L5f
        L5e:
            r6 = 1
        L5f:
            if (r6 == r4) goto L77
            r6 = r8[r5]
            long r6 = size(r6)     // Catch: java.lang.Exception -> L6b
            long r1 = r1 + r6
            int r5 = r5 + 1
            goto L5a
        L6b:
            r8 = move-exception
            throw r8
        L6d:
            int r8 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 + 25
            int r0 = r8 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r0
            int r8 = r8 % 2
        L77:
            return r1
        L78:
            r8 = move-exception
            goto L7b
        L7a:
            throw r8
        L7b:
            goto L7a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.size(java.io.File):long");
    }

    public static boolean copy(String str, String str2) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            try {
                return copy(str, str2, false);
            } catch (Exception e) {
                throw e;
            }
        }
        return copy(str, str2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if ((r6.equals(r7) ? '\f' : '2') != '2') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        if ((r6.equals(r7)) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        if (exists(r6) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r2 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 41;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (isFile(r6) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        if (r2 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
    
        if (exists(r7) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0078, code lost:
    
        if (r8 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
    
        r8 = 'C';
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
    
        r8 = 'G';
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
    
        if (r8 == 'C') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
    
        delete(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0085, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008a, code lost:
    
        if (create(r7) != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008c, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008d, code lost:
    
        r8 = new java.io.FileInputStream(r6);
        r6 = new java.io.FileOutputStream(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0097, code lost:
    
        r7 = com.alibaba.ariver.kernel.common.utils.IOUtils.getBuf(2048);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009d, code lost:
    
        r2 = r8.read(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a2, code lost:
    
        if (r2 == (-1)) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        r6.write(r7, 0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a8, code lost:
    
        r6.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b4, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b5, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b7, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b8, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.griver.base.common.utils.H5FileUtil.TAG, "exception detail", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c5, code lost:
    
        com.alibaba.ariver.kernel.common.utils.IOUtils.returnBuf(r7);
        com.alibaba.ariver.kernel.common.utils.IOUtils.closeQuietly(r8);
        com.alibaba.ariver.kernel.common.utils.IOUtils.closeQuietly(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ce, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cf, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d0, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.griver.base.common.utils.H5FileUtil.TAG, "exception detail", r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean copy(java.lang.String r6, java.lang.String r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.copy(java.lang.String, java.lang.String, boolean):boolean");
    }

    public static String fileName(String str) {
        int i = MyBillsEntityDataFactory + 53;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if ((TextUtils.isEmpty(str) ? 'c' : 'P') != 'P') {
            return null;
        }
        String name = new File(cleanPath(str)).getName();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return name;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if (r4 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        r5 = getExtension(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        r0 = 'U';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        r0 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        if (r0 == 20) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        if (android.webkit.MimeTypeMap.getSingleton().hasExtension(r5.toLowerCase()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        if (r1 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory + 115;
        com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        if ((r0 % 2) != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileExtensionFromUrl(java.lang.String r5) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L69
            int r0 = r0 + 41
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L67
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == r2) goto L1f
            java.lang.String r0 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r5)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L64
            goto L2c
        L1f:
            java.lang.String r0 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r5)     // Catch: java.lang.Exception -> L69
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L67
            r3.hashCode()     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L64
        L2c:
            java.lang.String r5 = getExtension(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r4 = 20
            if (r0 != 0) goto L3b
            r0 = 85
            goto L3d
        L3b:
            r0 = 20
        L3d:
            if (r0 == r4) goto L63
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r4 = r5.toLowerCase()
            boolean r0 = r0.hasExtension(r4)
            if (r0 == 0) goto L4e
            r1 = 1
        L4e:
            if (r1 == 0) goto L63
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L69
            int r0 = r0 + 115
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L62
            r3.hashCode()     // Catch: java.lang.Throwable -> L60
            return r5
        L60:
            r5 = move-exception
            throw r5
        L62:
            return r5
        L63:
            return r3
        L64:
            return r0
        L65:
            r5 = move-exception
            throw r5
        L67:
            r5 = move-exception
            throw r5
        L69:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.getFileExtensionFromUrl(java.lang.String):java.lang.String");
    }

    @Deprecated
    public static String getExtension(String str) {
        int i = MyBillsEntityDataFactory + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if ((lastIndexOf >= 0 ? (char) 28 : '[') == 28) {
            if (!(lastIndexOf >= str.length() - 1)) {
                String substring = str.substring(lastIndexOf + 1);
                int i3 = MyBillsEntityDataFactory + 29;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 13 / 0;
                    return substring;
                }
                return substring;
            }
        }
        return "";
    }

    public static String getMimeType(String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        String fileExtensionFromUrl = getFileExtensionFromUrl(str);
        if (("js".equalsIgnoreCase(fileExtensionFromUrl) ? '3' : (char) 21) != 21) {
            int i3 = MyBillsEntityDataFactory + 95;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return "application/javascript";
        } else if (fileExtensionFromUrl != null) {
            int i5 = MyBillsEntityDataFactory + 49;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            if ((i5 % 2 == 0 ? 'c' : (char) 23) != 'c') {
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
            }
            int i6 = 3 / 0;
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        } else {
            return null;
        }
    }

    public static String getExtensionFromMimeType(String str) {
        if (!(TextUtils.isEmpty(str))) {
            return MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            int i3 = MyBillsEntityDataFactory + 121;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean isFile(String str) {
        try {
            if ((!exists(str) ? (char) 17 : '[') != 17) {
                boolean isFile = isFile(new File(str));
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                return isFile;
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
            MyBillsEntityDataFactory = i5 % 128;
            if ((i5 % 2 != 0 ? '/' : Typography.dollar) != '$') {
                int i6 = 12 / 0;
                return false;
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        if (r3 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        if (r3.isFile() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        r3 = 'U';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
    
        r3 = '5';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0029, code lost:
    
        if (r3 == 'U') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
    
        r3 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 109;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if ((r3 == null) != true) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isFile(java.io.File r3) {
        /*
            int r0 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 119
            int r1 = r0 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1a
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L18
            if (r3 == 0) goto L14
            r0 = 0
            goto L15
        L14:
            r0 = 1
        L15:
            if (r0 == r2) goto L30
            goto L1c
        L18:
            r3 = move-exception
            throw r3
        L1a:
            if (r3 == 0) goto L30
        L1c:
            boolean r3 = r3.isFile()     // Catch: java.lang.Exception -> L2e
            r0 = 85
            if (r3 == 0) goto L27
            r3 = 85
            goto L29
        L27:
            r3 = 53
        L29:
            if (r3 == r0) goto L2c
            goto L30
        L2c:
            r1 = 1
            goto L3a
        L2e:
            r3 = move-exception
            throw r3
        L30:
            int r3 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L3b
            int r3 = r3 + 109
            int r0 = r3 % 128
            com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> L3b
            int r3 = r3 % 2
        L3a:
            return r1
        L3b:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.isFile(java.io.File):boolean");
    }

    public static boolean isFolder(String str) {
        int i = MyBillsEntityDataFactory + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (!exists(str)) {
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
                try {
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    return false;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return new File(str).isDirectory();
    }

    public static String getFileSHA1(String str) {
        FileInputStream fileInputStream;
        try {
            String str2 = null;
            if (TextUtils.isEmpty(str)) {
                int i = MyBillsEntityDataFactory + 71;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (i % 2 == 0) {
                    str2.hashCode();
                }
                return null;
            }
            File file = new File(str);
            if ((!file.exists()) || file.isDirectory()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                RVLogger.e(TAG, "exception detail.", e);
                fileInputStream = null;
            }
            if (fileInputStream == null) {
                try {
                    int i2 = MyBillsEntityDataFactory + 45;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                    if ((i2 % 2 == 0 ? (char) 31 : '\r') != 31) {
                        return null;
                    }
                    str2.hashCode();
                    return null;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            byte[] buf = IOUtils.getBuf(2048);
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    while (true) {
                        int read = fileInputStream.read(buf);
                        if (read <= 0) {
                            break;
                        }
                        int i5 = MyBillsEntityDataFactory + 109;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        int i6 = i5 % 2;
                        messageDigest.update(buf, 0, read);
                    }
                    str2 = b.a(messageDigest.digest());
                } catch (Exception e3) {
                    RVLogger.e(TAG, "exception detail", e3);
                }
                IOUtils.returnBuf(buf);
                IOUtils.closeQuietly(fileInputStream);
                return (!TextUtils.isEmpty(str2) ? 'b' : 'U') != 'b' ? str2 : str2.trim();
            } catch (Throwable th) {
                IOUtils.returnBuf(buf);
                IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception e4) {
            throw e4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if ((android.text.TextUtils.isEmpty(r7) ? '6' : 1) != 1) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        if (android.text.TextUtils.isEmpty(r7) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        r1 = new java.io.File(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        if (r1.exists() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        if (r7 == true) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003e, code lost:
    
        if (r1.isDirectory() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        r7 = new java.io.FileInputStream(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0045, code lost:
    
        r1 = com.alibaba.griver.base.common.utils.H5FileUtil.KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        com.alibaba.griver.base.common.utils.H5FileUtil.MyBillsEntityDataFactory = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.griver.base.common.utils.H5FileUtil.TAG, "exception detail.", r7);
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c5, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileMD5(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.base.common.utils.H5FileUtil.getFileMD5(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Type inference failed for: r7v9, types: [int] */
    public static String getText(String str) {
        Closeable closeable;
        Exception e;
        BufferedInputStream bufferedInputStream;
        PoolingByteArrayOutputStream poolingByteArrayOutputStream;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            PoolingByteArrayOutputStream poolingByteArrayOutputStream2 = null;
            if ((!exists(str) ? '\b' : '.') != '\b') {
                File file = new File(str);
                ?? length = (int) file.length();
                if ((length > 20480 ? '\n' : 'H') != 'H') {
                    return null;
                }
                byte[] buf = IOUtils.getBuf(1024);
                try {
                    try {
                        poolingByteArrayOutputStream = new PoolingByteArrayOutputStream((int) length);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = null;
                        poolingByteArrayOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        closeable = null;
                    }
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        while (true) {
                            try {
                                int read = bufferedInputStream.read(buf);
                                if (-1 != read) {
                                    poolingByteArrayOutputStream.write(buf, 0, read);
                                } else {
                                    String obj = poolingByteArrayOutputStream.toString();
                                    IOUtils.getByteArrayPool().returnBuf(buf);
                                    IOUtils.closeQuietly(poolingByteArrayOutputStream);
                                    IOUtils.closeQuietly(bufferedInputStream);
                                    return obj;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                RVLogger.e(TAG, "exception detail", e);
                                IOUtils.getByteArrayPool().returnBuf(buf);
                                IOUtils.closeQuietly(poolingByteArrayOutputStream);
                                IOUtils.closeQuietly(bufferedInputStream);
                                return null;
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        bufferedInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = null;
                        poolingByteArrayOutputStream2 = poolingByteArrayOutputStream;
                        IOUtils.getByteArrayPool().returnBuf(buf);
                        IOUtils.closeQuietly(poolingByteArrayOutputStream2);
                        IOUtils.closeQuietly(closeable);
                        throw th;
                    }
                } catch (Throwable th3) {
                    poolingByteArrayOutputStream2 = 72;
                    closeable = length;
                    th = th3;
                }
            } else {
                try {
                    int i3 = MyBillsEntityDataFactory + 47;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                    MyBillsEntityDataFactory = i5 % 128;
                    int i6 = i5 % 2;
                    return null;
                } catch (Exception e5) {
                    throw e5;
                }
            }
        } catch (Exception e6) {
            throw e6;
        }
    }

    public static final String read(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        String str2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            IOUtils.closeQuietly(fileInputStream2);
            throw th;
        }
        try {
            try {
                try {
                    str2 = read(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    IOUtils.closeQuietly(fileInputStream2);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                RVLogger.e(TAG, "Exception", e);
                try {
                    int i = MyBillsEntityDataFactory + 49;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                    int i2 = i % 2;
                    IOUtils.closeQuietly(fileInputStream);
                    int i3 = MyBillsEntityDataFactory + 35;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    return str2;
                } catch (Exception e3) {
                    throw e3;
                }
            }
            int i32 = MyBillsEntityDataFactory + 35;
            KClassImpl$Data$declaredNonStaticMembers$2 = i32 % 128;
            int i42 = i32 % 2;
            return str2;
        } catch (Exception e4) {
            throw e4;
        }
        IOUtils.closeQuietly(fileInputStream);
    }

    public static final String read(InputStream inputStream) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (inputStream != null) {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[2048];
            try {
                Object[] objArr = new Object[1];
                a(KeyEvent.normalizeMetaState(0) + 6143, new char[]{48598, 43560, 37435, 64083, 57927}, objArr);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, ((String) objArr[0]).intern());
                int i3 = MyBillsEntityDataFactory + 75;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                while (true) {
                    int read = inputStreamReader.read(cArr, 0, 2048);
                    if (read < 0) {
                        break;
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (Exception e) {
                RVLogger.e(TAG, "Exception", e);
            }
            return sb.toString();
        }
        int i5 = MyBillsEntityDataFactory + 113;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        boolean z = i5 % 2 != 0;
        Object obj = null;
        if (!z) {
            obj.hashCode();
        }
        return null;
    }

    public static long getCreateTime(String str) {
        int i = MyBillsEntityDataFactory + 59;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            if ((!exists(str) ? '\t' : '1') == '\t') {
                return 0L;
            }
        } else {
            int i2 = 0 / 0;
            if (!exists(str)) {
                return 0L;
            }
        }
        long time = new Date(new File(str).lastModified()).getTime();
        try {
            int i3 = MyBillsEntityDataFactory + 63;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 == 0 ? '9' : (char) 5) != '9') {
                return time;
            }
            Object obj = null;
            obj.hashCode();
            return time;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static boolean copyToFile(InputStream inputStream, File file) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
            try {
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                try {
                    if ((file.exists() ? '/' : '5') != '5') {
                        file.delete();
                    }
                    byte[] buf = IOUtils.getBuf(4096);
                    ?? r2 = 0;
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        int i3 = MyBillsEntityDataFactory + 75;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                        int i4 = i3 % 2;
                        while (true) {
                            try {
                                int read = inputStream.read(buf);
                                if (read < 0) {
                                    break;
                                }
                                fileOutputStream.write(buf, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                r2 = fileOutputStream;
                                IOUtils.returnBuf(buf);
                                IOUtils.closeQuietly(r2);
                                throw th;
                            }
                        }
                        IOUtils.returnBuf(buf);
                        IOUtils.closeQuietly(fileOutputStream);
                        int i5 = MyBillsEntityDataFactory + 91;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        if (!(i5 % 2 != 0)) {
                            int length = r2.length;
                            return true;
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e) {
                    RVLogger.e(TAG, e);
                    return false;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            try {
                int i2 = $11 + 13;
                try {
                    $10 = i2 % 128;
                    int i3 = i2 % 2;
                    jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getAuthRequestContext ^ 4796183387843776835L);
                    getonboardingscenario.getAuthRequestContext++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i4 = $10 + 71;
        $11 = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '\\' : (char) 14) != '\\') {
                objArr[0] = new String(cArr2);
                return;
            }
            int i6 = $10 + 121;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            } else {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            }
            getonboardingscenario.getAuthRequestContext++;
        }
    }
}
