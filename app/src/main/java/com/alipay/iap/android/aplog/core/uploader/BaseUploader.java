package com.alipay.iap.android.aplog.core.uploader;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import java.io.File;

/* loaded from: classes3.dex */
public class BaseUploader {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static int PlaceComponentResult = 1;
    public static String TAG = "BaseUploader";
    private static int getAuthRequestContext;
    protected Context mContext;
    protected File mUploadFileDir;

    static {
        MyBillsEntityDataFactory();
        int i = getAuthRequestContext + 105;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? 'R' : (char) 22) != 22) {
            int i2 = 76 / 0;
        }
    }

    static void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory = (char) 42070;
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{42070, 42068, 37257, 37275, 42065, 37346, 37274, 42071, 37367};
    }

    public BaseUploader(File file, Context context) {
        try {
            this.mUploadFileDir = file;
            this.mContext = context;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x004d, code lost:
    
        if ((r1.length >= 3 ? '^' : '-') != '-') goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x004f, code lost:
    
        java.util.Arrays.sort(r1, com.alipay.iap.android.aplog.core.uploader.UploadManager.CLEAN_FILE_COMPARATOR);
        r2 = r1.length / 4;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0057, code lost:
    
        if (r3 >= r2) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0059, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x005b, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x005c, code lost:
    
        if (r4 == false) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x005e, code lost:
    
        r4 = r1[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0060, code lost:
    
        if (r4 == null) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0062, code lost:
    
        r5 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.PlaceComponentResult + 19;
        com.alipay.iap.android.aplog.core.uploader.BaseUploader.getAuthRequestContext = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0072, code lost:
    
        if (r4.exists() == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0074, code lost:
    
        r5 = 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0077, code lost:
    
        r5 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0079, code lost:
    
        if (r5 == 15) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x007b, code lost:
    
        r5 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.getAuthRequestContext + 49;
        com.alipay.iap.android.aplog.core.uploader.BaseUploader.PlaceComponentResult = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0087, code lost:
    
        if ((r5 % 2) != 0) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0089, code lost:
    
        r5 = kotlin.text.Typography.greater;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x008c, code lost:
    
        r5 = id.dana.cashier.view.InputCardNumberView.DIVIDER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x008e, code lost:
    
        if (r5 == '>') goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0094, code lost:
    
        if (r4.isFile() == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0097, code lost:
    
        r5 = r4.isFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x009b, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x009e, code lost:
    
        if (r5 == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00a0, code lost:
    
        r4.delete();
        r5 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger();
        r8 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.TAG;
        r9 = new java.lang.StringBuilder();
        r9.append("cleanExpiresFile: ");
        r9.append(r4.getName());
        r9.append(" is too large or too old, total: ");
        r9.append(r1.length);
        r5.error(r8, r9.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00cb, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00cc, code lost:
    
        r8 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger();
        r9 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.TAG;
        r10 = new java.lang.StringBuilder();
        r10.append(r4.getName());
        r10.append(" cleanExpiresFile");
        r8.warn(r9, r10.toString(), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x003f, code lost:
    
        if ((r1.length >= 4) != true) goto L131;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cleanExpiresFile() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.BaseUploader.cleanExpiresFile():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x0024, code lost:
    
        if ((!r8) == true) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0038, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r0) ? 30 : 5) != 5) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x003a, code lost:
    
        r8 = decodeUploadContent(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0042, code lost:
    
        if (android.text.TextUtils.isEmpty(r8) != false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0044, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0046, code lost:
    
        r0 = 'V';
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0048, code lost:
    
        if (r0 != 0) goto L246;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x004a, code lost:
    
        r9 = com.alipay.iap.android.aplog.core.LoggerFactory.getLogContext().getLogHost();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0056, code lost:
    
        if (android.text.TextUtils.isEmpty(r9) != false) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x005c, code lost:
    
        if (com.alipay.iap.android.aplog.util.LoggingUtil.isDebuggable() == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x005e, code lost:
    
        setComponentEnabled(r18.mContext, "com.alipay.mobile.logmonitor.ClientMonitorExtReceiver");
        r0 = new java.lang.StringBuilder();
        r0.append(r18.mContext.getPackageName());
        r0.append(".monitor.action.UPLOAD_MDAP_LOG");
        r10 = new android.content.Intent(r0.toString());
        r10.setPackage(r18.mContext.getPackageName());
        r10.putExtra("file", r19.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0093, code lost:
    
        r18.mContext.sendBroadcast(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0099, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x009a, code lost:
    
        com.fullstory.instrumentation.InstrumentInjector.log_e(com.alipay.iap.android.aplog.core.uploader.BaseUploader.TAG, com.alibaba.ariver.permission.PermissionConstant.UPLOAD_FILE, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x026b, code lost:
    
        if (r2 > 0) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0277, code lost:
    
        if (r2 > 0) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0323, code lost:
    
        throw new java.lang.IllegalStateException("log host is empty");
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x032b, code lost:
    
        throw new java.lang.IllegalStateException("decode file content is empty");
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x032c, code lost:
    
        r19.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0336, code lost:
    
        throw new java.lang.IllegalStateException("file content is empty");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uploadFileByHttp(java.io.File r19, java.lang.String r20, java.lang.String r21, java.lang.String r22) throws java.lang.IllegalStateException {
        /*
            Method dump skipped, instructions count: 858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.BaseUploader.uploadFileByHttp(java.io.File, java.lang.String, java.lang.String, java.lang.String):void");
    }

    protected void setComponentEnabled(Context context, String str) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, str), 1, 1);
            int i = getAuthRequestContext + 25;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
        } catch (Throwable th) {
            TraceLogger traceLogger = LoggerFactory.getTraceLogger();
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("setComponentEnabled: ");
            sb.append(th);
            traceLogger.error(str2, sb.toString());
        }
    }

    protected String getLogCategory(String str) {
        int i = getAuthRequestContext + 73;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Object[] objArr = null;
        if (!(!TextUtils.isEmpty(str))) {
            int i3 = getAuthRequestContext + 5;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 17 / 0;
            }
            return null;
        }
        try {
            String[] split = str.split("_");
            if ((split.length < 3 ? (char) 1 : 'C') == 1) {
                int i5 = getAuthRequestContext + 3;
                PlaceComponentResult = i5 % 128;
                if (i5 % 2 == 0) {
                    int length = objArr.length;
                }
                return null;
            }
            return split[2];
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0049, code lost:
    
        if (r6.startsWith(com.alipay.iap.android.aplog.core.appender.MdapFileLogAppender.ENCRYPT_SIGN) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0052, code lost:
    
        if (r6.startsWith(com.alipay.iap.android.aplog.core.appender.MdapFileLogAppender.ENCRYPT_SIGN) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0054, code lost:
    
        r7 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.getAuthRequestContext + 49;
        com.alipay.iap.android.aplog.core.uploader.BaseUploader.PlaceComponentResult = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x005d, code lost:
    
        r6 = r0.decrypt(r6.substring(2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x006b, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x006d, code lost:
    
        r7 = '+';
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0070, code lost:
    
        r7 = '/';
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0072, code lost:
    
        if (r7 == '/') goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0074, code lost:
    
        r2.append(r6);
        r2.append(com.alipay.iap.android.aplog.core.layout.mas.MasLog.Constant.GAP);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x007b, code lost:
    
        r2.append(r6);
        r2.append(com.alipay.iap.android.aplog.core.layout.mas.MasLog.Constant.GAP);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String decodeUploadContent(java.lang.String r11) {
        /*
            r10 = this;
            com.alipay.iap.android.aplog.api.LogContext r0 = com.alipay.iap.android.aplog.core.LoggerFactory.getLogContext()
            com.alipay.iap.android.aplog.api.LogEncryptClient r0 = r0.getLogEncryptClient()
            if (r0 != 0) goto Lb
            return r11
        Lb:
            java.lang.String r1 = "\\$\\$"
            java.lang.String[] r11 = r11.split(r1)
            int r1 = r11.length
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            int r3 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.getAuthRequestContext
            int r3 = r3 + 117
            int r4 = r3 % 128
            com.alipay.iap.android.aplog.core.uploader.BaseUploader.PlaceComponentResult = r4
            r4 = 2
            int r3 = r3 % r4
            r3 = 0
            r5 = 0
        L23:
            if (r5 >= r1) goto L84
            r6 = r11[r5]
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            r8 = 1
            if (r7 != 0) goto L30
            r7 = 0
            goto L31
        L30:
            r7 = 1
        L31:
            if (r7 == r8) goto L81
            int r7 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.getAuthRequestContext
            int r7 = r7 + 27
            int r8 = r7 % 128
            com.alipay.iap.android.aplog.core.uploader.BaseUploader.PlaceComponentResult = r8
            int r7 = r7 % r4
            java.lang.String r8 = "$$"
            java.lang.String r9 = "1_"
            if (r7 != 0) goto L4e
            boolean r7 = r6.startsWith(r9)
            r9 = 98
            int r9 = r9 / r3
            if (r7 == 0) goto L7b
            goto L54
        L4c:
            r11 = move-exception
            throw r11
        L4e:
            boolean r7 = r6.startsWith(r9)
            if (r7 == 0) goto L7b
        L54:
            int r7 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.getAuthRequestContext
            int r7 = r7 + 49
            int r9 = r7 % 128
            com.alipay.iap.android.aplog.core.uploader.BaseUploader.PlaceComponentResult = r9
            int r7 = r7 % r4
            java.lang.String r6 = r6.substring(r4)     // Catch: java.lang.Throwable -> L81
            java.lang.String r6 = r0.decrypt(r6)     // Catch: java.lang.Throwable -> L81
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L81
            r9 = 47
            if (r7 != 0) goto L70
            r7 = 43
            goto L72
        L70:
            r7 = 47
        L72:
            if (r7 == r9) goto L81
            r2.append(r6)     // Catch: java.lang.Throwable -> L81
            r2.append(r8)     // Catch: java.lang.Throwable -> L81
            goto L81
        L7b:
            r2.append(r6)
            r2.append(r8)
        L81:
            int r5 = r5 + 1
            goto L23
        L84:
            java.lang.String r11 = r2.toString()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.BaseUploader.decodeUploadContent(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00b8, code lost:
    
        if ((r0.MyBillsEntityDataFactory == r0.PlaceComponentResult ? 'N' : '\'') != '\'') goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00ba, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r12);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x00cd, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x00ce, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00cf, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00e9, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00eb, code lost:
    
        r6 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00ee, code lost:
    
        r6 = 'J';
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00f0, code lost:
    
        if (r6 == '!') goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00f6, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00f8, code lost:
    
        r6 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.$10 + 61;
        com.alipay.iap.android.aplog.core.uploader.BaseUploader.$11 = r6 % 128;
        r6 = r6 % 2;
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r6 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r6];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x012c, code lost:
    
        r6 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r6];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0148, code lost:
    
        r6 = com.alipay.iap.android.aplog.core.uploader.BaseUploader.$10 + 51;
        com.alipay.iap.android.aplog.core.uploader.BaseUploader.$11 = r6 % 128;
        r6 = r6 % 2;
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r6 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r6];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x009b, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L125;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r11, byte r12, int r13, java.lang.Object[] r14) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.BaseUploader.a(char[], byte, int, java.lang.Object[]):void");
    }
}
