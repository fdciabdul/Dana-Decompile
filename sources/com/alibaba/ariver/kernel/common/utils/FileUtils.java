package com.alibaba.ariver.kernel.common.utils;

import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.cashier.view.InputCardNumberView;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.text.Typography;
import o.C;

/* loaded from: classes2.dex */
public class FileUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 47188;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 57333;
    private static char MyBillsEntityDataFactory = 32471;
    private static int PlaceComponentResult = 0;
    public static final String TAG = "AriverKernel:FileUtils";
    private static char getAuthRequestContext = 4860;
    private static int scheduleImpl = 1;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if ((r3 == null) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
    
        r3 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult + 25;
        com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        return calculateSize(new java.io.File(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0013, code lost:
    
        if ((r3 == null) != true) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long calculateSize(java.lang.String r3) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl     // Catch: java.lang.Exception -> L34
            int r0 = r0 + 17
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L34
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L16
            if (r3 != 0) goto L13
            r1 = 1
        L13:
            if (r1 == r2) goto L1d
            goto L2a
        L16:
            r3 = move-exception
            throw r3
        L18:
            if (r3 != 0) goto L1b
            r1 = 1
        L1b:
            if (r1 == 0) goto L2a
        L1d:
            int r3 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r3 = r3 + 25
            int r0 = r3 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r0
            int r3 = r3 % 2
            r0 = 0
            return r0
        L2a:
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            long r0 = calculateSize(r0)
            return r0
        L34:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.calculateSize(java.lang.String):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        if (exists(r8) == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long calculateSize(java.io.File r8) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r0 = r0 + 93
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 59
            if (r0 == 0) goto L11
            r0 = 59
            goto L13
        L11:
            r0 = 36
        L13:
            r2 = 0
            if (r0 == r1) goto L20
            boolean r0 = exists(r8)
            if (r0 != 0) goto L1e
            goto L28
        L1e:
            r4 = r2
            goto L29
        L20:
            boolean r0 = exists(r8)
            r4 = 1
            if (r0 != 0) goto L29
        L28:
            return r2
        L29:
            boolean r0 = r8.isFile()
            if (r0 == 0) goto L34
            long r0 = r8.length()
            return r0
        L34:
            java.io.File[] r8 = r8.listFiles()
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L3e
            r6 = 1
            goto L3f
        L3e:
            r6 = 0
        L3f:
            if (r6 == r1) goto L42
            goto L6d
        L42:
            int r6 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r6 = r6 + 103
            int r7 = r6 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r7
            int r6 = r6 % 2
            int r6 = r8.length
            if (r6 != 0) goto L63
            int r8 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r8 = r8 + 39
            int r0 = r8 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r0
            int r8 = r8 % 2
            r0 = 13
            if (r8 != 0) goto L60
            r8 = 13
            goto L6d
        L60:
            r8 = 25
            goto L6d
        L63:
            int r2 = r8.length
            r3 = 0
        L65:
            if (r3 >= r2) goto L69
            r6 = 1
            goto L6a
        L69:
            r6 = 0
        L6a:
            if (r6 == r1) goto L78
            r2 = r4
        L6d:
            int r8 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r8 = r8 + 7
            int r0 = r8 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r0
            int r8 = r8 % 2
            return r2
        L78:
            int r6 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r6 = r6 + 35
            int r7 = r6 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r7
            int r6 = r6 % 2
            if (r6 == 0) goto L8e
            r6 = r8[r3]
            long r6 = calculateSize(r6)
            long r4 = r4 & r6
            int r3 = r3 + 99
            goto L65
        L8e:
            r6 = r8[r3]
            long r6 = calculateSize(r6)
            long r4 = r4 + r6
            int r3 = r3 + 1
            goto L65
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.calculateSize(java.io.File):long");
    }

    public static String combinePath(String str, String str2) {
        if ((str != null ? 'J' : '=') == 'J') {
            try {
                int i = PlaceComponentResult + 59;
                scheduleImpl = i % 128;
                int i2 = i % 2;
                if (!(str.length() == 0)) {
                    int length = str.length();
                    if ((str2 == null) || str2.length() == 0) {
                        if (str.charAt(length - 1) == '/') {
                            return str;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append("/");
                        return sb.toString();
                    }
                    int i3 = PlaceComponentResult + 119;
                    scheduleImpl = i3 % 128;
                    int i4 = i3 % 2;
                    if ((str2.startsWith("./") ? (char) 7 : 'C') == 7) {
                        int i5 = scheduleImpl + 75;
                        PlaceComponentResult = i5 % 128;
                        str2 = i5 % 2 != 0 ? str2.substring(0) : str2.substring(1);
                    }
                    try {
                        if (str.charAt(length - 1) == '/') {
                            int i6 = PlaceComponentResult + 57;
                            scheduleImpl = i6 % 128;
                            int i7 = i6 % 2;
                            if (str2.charAt(0) == '/') {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str.substring(0, str.length() - 1));
                                sb2.append(str2);
                                return sb2.toString();
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str);
                            sb3.append(str2);
                            return sb3.toString();
                        } else if (str2.charAt(0) == '/') {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str);
                            sb4.append(str2);
                            return sb4.toString();
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(str);
                            sb5.append("/");
                            sb5.append(str2);
                            return sb5.toString();
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return str2;
    }

    public static boolean create(String str) {
        try {
            int i = PlaceComponentResult + 71;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
                boolean create = create(str, false);
                int i3 = scheduleImpl + 125;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return create;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3) ? 31 : '\f') != 31) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (exists(r3) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        if (r0 == true) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        r3 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl + 121;
        com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0046, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        mkdirs(getParent(r3), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        return new java.io.File(r3).createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e(com.alibaba.ariver.kernel.common.utils.FileUtils.TAG, "exception detail", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean create(java.lang.String r3, boolean r4) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl     // Catch: java.lang.Exception -> L64
            int r0 = r0 + 97
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L64
            int r0 = r0 % 2
            r1 = 47
            if (r0 == 0) goto L11
            r0 = 47
            goto L12
        L11:
            r0 = 6
        L12:
            r2 = 0
            if (r0 == r1) goto L25
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L64
            r1 = 31
            if (r0 == 0) goto L20
            r0 = 31
            goto L22
        L20:
            r0 = 12
        L22:
            if (r0 == r1) goto L2e
            goto L2f
        L25:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 18
            int r1 = r1 / r2
            if (r0 == 0) goto L2f
        L2e:
            return r2
        L2f:
            boolean r0 = exists(r3)
            r1 = 1
            if (r0 == 0) goto L38
            r0 = 0
            goto L39
        L38:
            r0 = 1
        L39:
            if (r0 == r1) goto L48
            int r3 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl     // Catch: java.lang.Exception -> L46
            int r3 = r3 + 121
            int r4 = r3 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r4     // Catch: java.lang.Exception -> L46
            int r3 = r3 % 2
            return r1
        L46:
            r3 = move-exception
            throw r3
        L48:
            java.lang.String r0 = getParent(r3)
            mkdirs(r0, r4)
            java.io.File r4 = new java.io.File     // Catch: java.lang.Exception -> L59
            r4.<init>(r3)     // Catch: java.lang.Exception -> L59
            boolean r3 = r4.createNewFile()     // Catch: java.lang.Exception -> L59
            return r3
        L59:
            r3 = move-exception
            java.lang.String r4 = "AriverKernel:FileUtils"
            java.lang.String r0 = "exception detail"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r4, r0, r3)
            return r2
        L62:
            r3 = move-exception
            throw r3
        L64:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.create(java.lang.String, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        if ((r5) != true) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if (r5 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        delete(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0043, code lost:
    
        r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl + 99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
    
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
    
        throw r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean mkdirs(java.lang.String r4, boolean r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = exists(r4)
            r1 = 0
            r2 = 1
            if (r4 == 0) goto Lf
            r4 = 0
            goto L10
        Lf:
            r4 = 1
        L10:
            if (r4 == r2) goto L4e
            boolean r4 = r0.isDirectory()
            if (r4 != 0) goto L4e
            int r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r4 = r4 + 101
            int r3 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r3
            int r4 = r4 % 2
            r3 = 31
            if (r4 == 0) goto L29
            r4 = 93
            goto L2b
        L29:
            r4 = 31
        L2b:
            if (r4 == r3) goto L3b
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L39
            if (r5 != 0) goto L35
            r4 = 0
            goto L36
        L35:
            r4 = 1
        L36:
            if (r4 == r2) goto L3e
            goto L3d
        L39:
            r4 = move-exception
            throw r4
        L3b:
            if (r5 != 0) goto L3e
        L3d:
            return r1
        L3e:
            delete(r0)     // Catch: java.lang.Exception -> L4c
            int r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl     // Catch: java.lang.Exception -> L4c
            int r4 = r4 + 99
            int r5 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r5     // Catch: java.lang.Exception -> L4c
            int r4 = r4 % 2
            goto L4e
        L4c:
            r4 = move-exception
            throw r4
        L4e:
            r0.mkdirs()     // Catch: java.lang.Exception -> L52
            goto L5a
        L52:
            r4 = move-exception
            java.lang.String r5 = "AriverKernel:FileUtils"
            java.lang.String r1 = "exception detail"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r5, r1, r4)
        L5a:
            boolean r4 = exists(r0)     // Catch: java.lang.Exception -> L5f
            return r4
        L5f:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.mkdirs(java.lang.String, boolean):boolean");
    }

    public static boolean move(String str, String str2) {
        int i = scheduleImpl + 15;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            boolean move = move(str, str2, false);
            int i3 = scheduleImpl + 41;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                return move;
            }
            int i4 = 72 / 0;
            return move;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        if (r0 == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean move(java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult     // Catch: java.lang.Exception -> L97
            int r0 = r0 + 83
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r1     // Catch: java.lang.Exception -> L97
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L1a
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1.hashCode()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L96
            goto L20
        L18:
            r4 = move-exception
            throw r4
        L1a:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L96
        L20:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r3 = 1
            if (r0 != 0) goto L29
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto L96
            boolean r0 = exists(r4)
            if (r0 != 0) goto L45
            int r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r4 = r4 + 51
            int r5 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L40
            r4 = 1
            goto L41
        L40:
            r4 = 0
        L41:
            if (r4 == r3) goto L44
            return r2
        L44:
            return r3
        L45:
            boolean r0 = exists(r5)
            r3 = 21
            if (r0 == 0) goto L50
            r0 = 21
            goto L52
        L50:
            r0 = 13
        L52:
            if (r0 == r3) goto L55
            goto L75
        L55:
            if (r6 != 0) goto L68
            int r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult     // Catch: java.lang.Exception -> L97
            int r4 = r4 + 37
            int r5 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r5     // Catch: java.lang.Exception -> L97
            int r4 = r4 % 2
            if (r4 != 0) goto L67
            int r4 = r1.length     // Catch: java.lang.Throwable -> L65
            return r2
        L65:
            r4 = move-exception
            throw r4
        L67:
            return r2
        L68:
            delete(r5)
            int r6 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r6 = r6 + 47
            int r0 = r6 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r0
            int r6 = r6 % 2
        L75:
            java.io.File r6 = new java.io.File     // Catch: java.lang.Exception -> L8e
            r6.<init>(r4)     // Catch: java.lang.Exception -> L8e
            java.io.File r4 = new java.io.File     // Catch: java.lang.Exception -> L8e
            r4.<init>(r5)     // Catch: java.lang.Exception -> L8e
            boolean r4 = r6.renameTo(r4)     // Catch: java.lang.Exception -> L8e
            int r5 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r5 = r5 + 11
            int r6 = r5 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r6
            int r5 = r5 % 2
            return r4
        L8e:
            r4 = move-exception
            java.lang.String r5 = "AriverKernel:FileUtils"
            java.lang.String r6 = "exception detail"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r5, r6, r4)
        L96:
            return r2
        L97:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.move(java.lang.String, java.lang.String, boolean):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:34:0x004f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static boolean checkPathValid(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            if (r0 == 0) goto L51
            java.lang.String r0 = "/"
            boolean r0 = android.text.TextUtils.equals(r4, r0)     // Catch: java.lang.Exception -> L4d
            r3 = 63
            if (r0 != 0) goto L1a
            r0 = 63
            goto L1b
        L1a:
            r0 = 1
        L1b:
            if (r0 == r3) goto L1e
            goto L4c
        L1e:
            java.lang.String r0 = "../"
            boolean r0 = r4.contains(r0)
            if (r0 != 0) goto L4c
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r0 = r0 + 69
            int r3 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r3
            int r0 = r0 % 2
            java.lang.String r3 = "/.."
            if (r0 != 0) goto L41
            boolean r4 = r4.contains(r3)     // Catch: java.lang.Exception -> L4d
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L3f
            if (r4 == 0) goto L51
            goto L4c
        L3f:
            r4 = move-exception
            throw r4
        L41:
            boolean r4 = r4.contains(r3)
            if (r4 == 0) goto L49
            r4 = 1
            goto L4a
        L49:
            r4 = 0
        L4a:
            if (r4 == 0) goto L51
        L4c:
            return r1
        L4d:
            r4 = move-exception
            throw r4
        L4f:
            r4 = move-exception
            throw r4
        L51:
            int r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r4 = r4 + 123
            int r0 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r0
            int r4 = r4 % 2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.checkPathValid(java.lang.String):boolean");
    }

    public static boolean noPermissionDelete(String str) {
        int i = scheduleImpl + 59;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        boolean isEmpty = TextUtils.isEmpty(str);
        try {
            int i3 = scheduleImpl + 63;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return isEmpty;
            }
            Object obj = null;
            obj.hashCode();
            return isEmpty;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r0 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        r0.append("path: ");
        r0.append(r2);
        r0.append(" not valid to download by resource");
        com.alibaba.ariver.kernel.common.utils.RVLogger.w(com.alibaba.ariver.kernel.common.utils.FileUtils.TAG, r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult + 73;
        com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
    
        return delete(new java.io.File(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (noPermissionDelete(r2) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean delete(java.lang.String r2) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r0 = r0 + 9
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 12
            if (r0 == 0) goto L11
            r0 = 12
            goto L13
        L11:
            r0 = 81
        L13:
            if (r0 == r1) goto L1c
            boolean r0 = noPermissionDelete(r2)
            if (r0 == 0) goto L4d
            goto L24
        L1c:
            boolean r0 = noPermissionDelete(r2)
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L57
            if (r0 == 0) goto L4d
        L24:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "path: "
            r0.append(r1)     // Catch: java.lang.Exception -> L4b
            r0.append(r2)     // Catch: java.lang.Exception -> L4b
            java.lang.String r2 = " not valid to download by resource"
            r0.append(r2)     // Catch: java.lang.Exception -> L4b
            java.lang.String r2 = "AriverKernel:FileUtils"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L4b
            com.alibaba.ariver.kernel.common.utils.RVLogger.w(r2, r0)     // Catch: java.lang.Exception -> L4b
            r2 = 0
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r0 = r0 + 73
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r1
            int r0 = r0 % 2
            return r2
        L4b:
            r2 = move-exception
            throw r2
        L4d:
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r2 = delete(r0)
            return r2
        L57:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.delete(java.lang.String):boolean");
    }

    public static boolean delete(File file) {
        int i = scheduleImpl + 25;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        boolean z = true;
        if (!exists(file)) {
            return true;
        }
        int i3 = 0;
        if (noPermissionDelete(file.getAbsolutePath())) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("path: ");
                sb.append(file.getAbsolutePath());
                sb.append(" not valid to download by resource");
                RVLogger.w(TAG, sb.toString());
                return false;
            } catch (Exception e) {
                throw e;
            }
        } else if (file.isFile()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deleteFile:");
            sb2.append(file.getAbsolutePath());
            RVLogger.d(TAG, sb2.toString());
            return file.delete();
        } else {
            File[] listFiles = file.listFiles();
            if ((listFiles == null ? (char) 14 : Typography.amp) != '&') {
                return true;
            }
            while (true) {
                if ((i3 < listFiles.length ? '1' : 'P') == '1') {
                    z |= delete(listFiles[i3]);
                    i3++;
                } else {
                    boolean delete = file.delete() | z;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("deleteFile:");
                    sb3.append(file.getAbsolutePath());
                    sb3.append(" result:");
                    sb3.append(delete);
                    RVLogger.d(TAG, sb3.toString());
                    int i4 = scheduleImpl + 23;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                    return delete;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if (r0 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3) ? 23 : 'A') != 'A') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0030, code lost:
    
        r3 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult + 3;
        com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        return exists(new java.io.File(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean exists(java.lang.String r3) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r0 = r0 + 61
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r1
            r1 = 2
            int r0 = r0 % r1
            if (r0 != 0) goto Lf
            r0 = 77
            goto L10
        Lf:
            r0 = 2
        L10:
            if (r0 == r1) goto L21
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L1f
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L3b
            goto L30
        L1d:
            r3 = move-exception
            throw r3
        L1f:
            r3 = move-exception
            throw r3
        L21:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r2 = 65
            if (r0 == 0) goto L2c
            r0 = 23
            goto L2e
        L2c:
            r0 = 65
        L2e:
            if (r0 == r2) goto L3b
        L30:
            int r3 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r3 = r3 + 3
            int r0 = r3 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r0
            int r3 = r3 % r1
            r3 = 0
            return r3
        L3b:
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = exists(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.exists(java.lang.String):boolean");
    }

    public static boolean exists(File file) {
        try {
            int i = PlaceComponentResult + 79;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
                if (file != null) {
                    int i3 = PlaceComponentResult + 65;
                    scheduleImpl = i3 % 128;
                    int i4 = i3 % 2;
                    if ((file.exists() ? (char) 16 : '\'') == 16) {
                        return true;
                    }
                }
                int i5 = scheduleImpl + 63;
                PlaceComponentResult = i5 % 128;
                int i6 = i5 % 2;
                return false;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static String getParent(String str) {
        int i = PlaceComponentResult + 79;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            if (!TextUtils.isEmpty(str)) {
                String parent = getParent(new File(cleanPath(str)));
                int i3 = scheduleImpl + 61;
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 != 0 ? '@' : (char) 15) != 15) {
                    int i4 = 25 / 0;
                    return parent;
                }
                return parent;
            }
            int i5 = PlaceComponentResult + 61;
            scheduleImpl = i5 % 128;
            boolean z = i5 % 2 == 0;
            Object obj = null;
            if (!z) {
                return null;
            }
            obj.hashCode();
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getParent(File file) {
        int i = scheduleImpl + 69;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (file != null) {
            try {
                String parent = file.getParent();
                int i3 = scheduleImpl + 99;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return parent;
            } catch (Exception e) {
                throw e;
            }
        }
        int i5 = PlaceComponentResult + 23;
        scheduleImpl = i5 % 128;
        Object[] objArr = null;
        if (i5 % 2 == 0) {
            int length = objArr.length;
        }
        int i6 = PlaceComponentResult + 83;
        scheduleImpl = i6 % 128;
        if ((i6 % 2 == 0 ? (char) 2 : 'c') != 2) {
            return null;
        }
        int i7 = 20 / 0;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3) ? '1' : '8') != '1') goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0035, code lost:
    
        if ((android.text.TextUtils.isEmpty(r3)) != true) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String cleanPath(java.lang.String r3) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r0 = r0 + 89
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 46
            if (r0 != 0) goto L11
            r0 = 21
            goto L13
        L11:
            r0 = 46
        L13:
            r2 = 0
            if (r0 == r1) goto L2d
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L2b
            r1 = 37
            int r1 = r1 / r2
            r1 = 49
            if (r0 == 0) goto L24
            r0 = 49
            goto L26
        L24:
            r0 = 56
        L26:
            if (r0 == r1) goto L53
            goto L37
        L29:
            r3 = move-exception
            throw r3
        L2b:
            r3 = move-exception
            throw r3
        L2d:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L54
            r1 = 1
            if (r0 == 0) goto L35
            r2 = 1
        L35:
            if (r2 == r1) goto L53
        L37:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L4b
            r0.<init>(r3)     // Catch: java.lang.Exception -> L4b
            java.lang.String r3 = r0.getCanonicalPath()     // Catch: java.lang.Exception -> L4b
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r0 = r0 + 19
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1
            int r0 = r0 % 2
            goto L53
        L4b:
            r0 = move-exception
            java.lang.String r1 = "AriverKernel:FileUtils"
            java.lang.String r2 = "Exception"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r2, r0)
        L53:
            return r3
        L54:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.cleanPath(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        r5 = getExtension(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        if (r1 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (android.webkit.MimeTypeMap.getSingleton().hasExtension(r5.toLowerCase()) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        r1 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl + 21;
        com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if ((r1 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r1 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        r1 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r1 == 'X') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileExtensionFromUrl(java.lang.String r5) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r0 = r0 + 61
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L23
            java.lang.String r0 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r5)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r4 = 62
            int r4 = r4 / r2
            if (r3 == 0) goto L66
            goto L2d
        L21:
            r5 = move-exception
            throw r5
        L23:
            java.lang.String r0 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r5)     // Catch: java.lang.Exception -> L67
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L67
            if (r3 == 0) goto L66
        L2d:
            java.lang.String r5 = getExtension(r5)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L38
            goto L39
        L38:
            r1 = 0
        L39:
            r0 = 0
            if (r1 == 0) goto L66
            android.webkit.MimeTypeMap r1 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r2 = r5.toLowerCase()
            boolean r1 = r1.hasExtension(r2)
            if (r1 == 0) goto L66
            int r1 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r1 = r1 + 21
            int r2 = r1 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r2
            int r1 = r1 % 2
            r2 = 88
            if (r1 == 0) goto L5b
            r1 = 88
            goto L5d
        L5b:
            r1 = 13
        L5d:
            if (r1 == r2) goto L60
            return r5
        L60:
            r0.hashCode()     // Catch: java.lang.Throwable -> L64
            return r5
        L64:
            r5 = move-exception
            throw r5
        L66:
            return r0
        L67:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.getFileExtensionFromUrl(java.lang.String):java.lang.String");
    }

    public static String getExtension(String str) {
        int i = scheduleImpl + 97;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                if (!(lastIndexOf >= str.length() - 1)) {
                    int i3 = PlaceComponentResult + 49;
                    scheduleImpl = i3 % 128;
                    int i4 = i3 % 2;
                    return str.substring(lastIndexOf + 1);
                }
            }
            return "";
        }
        int i5 = PlaceComponentResult + 31;
        scheduleImpl = i5 % 128;
        if ((i5 % 2 == 0 ? '+' : (char) 23) != 23) {
            int i6 = 66 / 0;
            return "";
        }
        return "";
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:32:0x0065
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String getMimeType(java.lang.String r4) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r0 = r0 + 39
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 77
            if (r0 == 0) goto L11
            r0 = 77
            goto L13
        L11:
            r0 = 44
        L13:
            r2 = 0
            java.lang.String r3 = "js"
            if (r0 == r1) goto L23
            java.lang.String r4 = getFileExtensionFromUrl(r4)
            boolean r0 = r3.equalsIgnoreCase(r4)
            if (r0 == 0) goto L37
            goto L62
        L23:
            java.lang.String r4 = getFileExtensionFromUrl(r4)
            boolean r0 = r3.equalsIgnoreCase(r4)
            int r1 = r2.length     // Catch: java.lang.Throwable -> L67
            r1 = 26
            if (r0 == 0) goto L33
            r0 = 26
            goto L35
        L33:
            r0 = 20
        L35:
            if (r0 == r1) goto L62
        L37:
            r0 = 92
            if (r4 == 0) goto L3e
            r1 = 92
            goto L40
        L3e:
            r1 = 14
        L40:
            if (r1 == r0) goto L43
            goto L55
        L43:
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult     // Catch: java.lang.Exception -> L60
            int r0 = r0 + 43
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r1     // Catch: java.lang.Exception -> L60
            int r0 = r0 % 2
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r2 = r0.getMimeTypeFromExtension(r4)
        L55:
            int r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r4 = r4 + 53
            int r0 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r0
            int r4 = r4 % 2
            return r2
        L60:
            r4 = move-exception
            throw r4
        L62:
            java.lang.String r4 = "application/javascript"
            return r4
        L65:
            r4 = move-exception
            throw r4
        L67:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.getMimeType(java.lang.String):java.lang.String");
    }

    public static String getMimeTypeFromContentType(String str) {
        try {
            int i = scheduleImpl + 29;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            try {
                String str2 = str.split(";")[0];
                if (!(str2 != null)) {
                    return null;
                }
                try {
                    int i3 = PlaceComponentResult + 107;
                    scheduleImpl = i3 % 128;
                    if (!(i3 % 2 == 0)) {
                        return str2.trim();
                    }
                    int i4 = 96 / 0;
                    return str2.trim();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                RVLogger.e(TAG, "getMimeTypeFromContentType", th);
                return null;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x0078
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String getMD5(java.lang.String r6) {
        /*
            int r0 = com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult = r1
            int r0 = r0 % 2
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L12
            return r1
        L12:
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch: java.lang.Exception -> L89
            char[] r6 = r6.toCharArray()
            int r1 = r6.length
            byte[] r1 = new byte[r1]
            r2 = 0
            r3 = 0
        L21:
            int r4 = r6.length
            r5 = 63
            if (r3 >= r4) goto L29
            r4 = 21
            goto L2b
        L29:
            r4 = 63
        L2b:
            if (r4 == r5) goto L49
            int r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r4 = r4 + 83
            int r5 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L41
            char r4 = r6[r3]
            byte r4 = (byte) r4
            r1[r3] = r4
            int r3 = r3 + 115
            goto L21
        L41:
            char r4 = r6[r3]
            byte r4 = (byte) r4
            r1[r3] = r4
            int r3 = r3 + 1
            goto L21
        L49:
            byte[] r6 = r0.digest(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L52:
            int r1 = r6.length
            if (r2 >= r1) goto L84
            r1 = r6[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r3 = 16
            r4 = 60
            if (r1 >= r3) goto L62
            r3 = 9
            goto L64
        L62:
            r3 = 60
        L64:
            if (r3 == r4) goto L7a
            java.lang.String r3 = "0"
            r0.append(r3)     // Catch: java.lang.Exception -> L76
            int r3 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r3 = r3 + 69
            int r4 = r3 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r4
            int r3 = r3 % 2
            goto L7a
        L76:
            r6 = move-exception
            throw r6
        L78:
            r6 = move-exception
            throw r6
        L7a:
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            int r2 = r2 + 1
            goto L52
        L84:
            java.lang.String r6 = r0.toString()
            return r6
        L89:
            r6 = move-exception
            java.lang.String r0 = "AriverKernel:FileUtils"
            java.lang.String r2 = "exception detail"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r2, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.getMD5(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String read(java.lang.String r4) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L10 java.lang.Exception -> L12
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L10 java.lang.Exception -> L12
            java.lang.String r0 = read(r1)     // Catch: java.lang.Throwable -> Lb java.lang.Exception -> Le
            goto L1b
        Lb:
            r4 = move-exception
            r0 = r1
            goto L3d
        Le:
            r4 = move-exception
            goto L14
        L10:
            r4 = move-exception
            goto L3d
        L12:
            r4 = move-exception
            r1 = r0
        L14:
            java.lang.String r2 = "AriverKernel:FileUtils"
            java.lang.String r3 = "Exception"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r2, r3, r4)     // Catch: java.lang.Throwable -> Lb
        L1b:
            com.alibaba.ariver.kernel.common.utils.IOUtils.closeQuietly(r1)     // Catch: java.lang.Exception -> L3b
            int r4 = com.alibaba.ariver.kernel.common.utils.FileUtils.PlaceComponentResult
            int r4 = r4 + 65
            int r1 = r4 % 128
            com.alibaba.ariver.kernel.common.utils.FileUtils.scheduleImpl = r1
            int r4 = r4 % 2
            r1 = 40
            if (r4 != 0) goto L2f
            r4 = 40
            goto L31
        L2f:
            r4 = 23
        L31:
            if (r4 == r1) goto L34
            goto L38
        L34:
            r4 = 41
            int r4 = r4 / 0
        L38:
            return r0
        L39:
            r4 = move-exception
            throw r4
        L3b:
            r4 = move-exception
            throw r4
        L3d:
            com.alibaba.ariver.kernel.common.utils.IOUtils.closeQuietly(r0)     // Catch: java.lang.Exception -> L41
            throw r4     // Catch: java.lang.Exception -> L41
        L41:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.read(java.lang.String):java.lang.String");
    }

    public static String read(InputStream inputStream) {
        if ((inputStream == null ? (char) 27 : '#') != 27) {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[2048];
            try {
                Object[] objArr = new Object[1];
                a(5 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{24066, 30238, 35154, 45142, 7723, 63528}, objArr);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, ((String) objArr[0]).intern());
                while (true) {
                    int read = inputStreamReader.read(cArr, 0, 2048);
                    if ((read >= 0 ? (char) 3 : InputCardNumberView.DIVIDER) == ' ') {
                        break;
                    }
                    int i = scheduleImpl + 41;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    sb.append(cArr, 0, read);
                }
            } catch (Exception e) {
                RVLogger.e(TAG, "Exception", e);
            }
            String obj = sb.toString();
            int i3 = PlaceComponentResult + 67;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return obj;
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:17:0x004a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.lang.String formatFileSize(long r6) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.FileUtils.formatFileSize(long):java.lang.String");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            int i3 = 0;
            while (true) {
                if (!(i3 < 16)) {
                    break;
                }
                int i4 = $10 + 117;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                i2 -= 40503;
                i3++;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
            int i6 = $11 + 103;
            $10 = i6 % 128;
            int i7 = i6 % 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
