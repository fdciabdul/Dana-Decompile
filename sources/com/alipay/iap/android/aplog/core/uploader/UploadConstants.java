package com.alipay.iap.android.aplog.core.uploader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.uploader.UserDiagnostician;
import com.alipay.iap.android.aplog.rpc.LinkRpcResult;
import com.alipay.iap.android.aplog.rpc.TaskInstanceRpcFacade;
import com.alipay.iap.android.aplog.rpc.TaskInstanceRpcRequest;
import com.alipay.iap.android.common.rpcintegration.RPCProxyHost;
import com.fullstory.instrumentation.InstrumentInjector;
import java.net.URLDecoder;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes3.dex */
public class UploadConstants {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static final String LOG_UPLOAD_ORIGINI = "/loggw/extLog.do";
    private static int MyBillsEntityDataFactory = 0;
    private static final String TAG = "UploadConstants";
    private static String logGW = null;
    private static boolean shouldGetLogGwFromManifest = true;

    static {
        try {
            getAuthRequestContext();
            int i = BuiltInFictitiousFunctionClassFactory + 65;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{35508, 35530, 35539, 35495, 35500};
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0019, code lost:
    
        if (r0 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0029, code lost:
    
        if ((com.alipay.iap.android.aplog.core.uploader.UploadConstants.shouldGetLogGwFromManifest ? 'W' : '4') != 'W') goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x002c, code lost:
    
        com.alipay.iap.android.aplog.core.uploader.UploadConstants.shouldGetLogGwFromManifest = false;
        com.alipay.iap.android.aplog.core.uploader.UploadConstants.logGW = com.alipay.iap.android.aplog.util.ManifestUtil.getLoggingGWFromManifest();
        r0 = com.alipay.iap.android.aplog.core.uploader.UploadConstants.BuiltInFictitiousFunctionClassFactory + 37;
        com.alipay.iap.android.aplog.core.uploader.UploadConstants.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getLogGWFromManifest() {
        /*
            int r0 = com.alipay.iap.android.aplog.core.uploader.UploadConstants.MyBillsEntityDataFactory
            int r0 = r0 + 9
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.core.uploader.UploadConstants.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 8
            if (r0 != 0) goto L11
            r0 = 46
            goto L13
        L11:
            r0 = 8
        L13:
            if (r0 == r1) goto L1e
            boolean r0 = com.alipay.iap.android.aplog.core.uploader.UploadConstants.shouldGetLogGwFromManifest
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L3f
            goto L2c
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            boolean r0 = com.alipay.iap.android.aplog.core.uploader.UploadConstants.shouldGetLogGwFromManifest
            r1 = 87
            if (r0 == 0) goto L27
            r0 = 87
            goto L29
        L27:
            r0 = 52
        L29:
            if (r0 == r1) goto L2c
            goto L3f
        L2c:
            r0 = 0
            com.alipay.iap.android.aplog.core.uploader.UploadConstants.shouldGetLogGwFromManifest = r0
            java.lang.String r0 = com.alipay.iap.android.aplog.util.ManifestUtil.getLoggingGWFromManifest()
            com.alipay.iap.android.aplog.core.uploader.UploadConstants.logGW = r0
            int r0 = com.alipay.iap.android.aplog.core.uploader.UploadConstants.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 37
            int r1 = r0 % 128
            com.alipay.iap.android.aplog.core.uploader.UploadConstants.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
        L3f:
            java.lang.String r0 = com.alipay.iap.android.aplog.core.uploader.UploadConstants.logGW
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.uploader.UploadConstants.getLogGWFromManifest():java.lang.String");
    }

    static String getUploadFileUrl() {
        int i = BuiltInFictitiousFunctionClassFactory + 29;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        try {
            if (TextUtils.isEmpty(getLogGWFromManifest())) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 27;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(logGW);
            sb.append(LOG_UPLOAD_ORIGINI);
            return sb.toString();
        } catch (Exception e) {
            throw e;
        }
    }

    public static String requestUploadFileUrl(UserDiagnostician.DiagnoseTask diagnoseTask) {
        int i = MyBillsEntityDataFactory + 79;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            TaskInstanceRpcFacade taskInstanceRpcFacade = (TaskInstanceRpcFacade) RPCProxyHost.getInterfaceProxy(TaskInstanceRpcFacade.class);
            if (taskInstanceRpcFacade != null) {
                TaskInstanceRpcRequest taskInstanceRpcRequest = new TaskInstanceRpcRequest();
                taskInstanceRpcRequest.taskId = diagnoseTask.taskID;
                taskInstanceRpcRequest.submitId = diagnoseTask.submitId;
                taskInstanceRpcRequest.appId = UserDiagnostician.getInstance().getAppId();
                LinkRpcResult fetchuploadlink = taskInstanceRpcFacade.fetchuploadlink(taskInstanceRpcRequest);
                if ((fetchuploadlink.success ? '7' : (char) 20) != '7') {
                    return null;
                }
                int i3 = BuiltInFictitiousFunctionClassFactory + 111;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                String str = fetchuploadlink.url;
                Object[] objArr = new Object[1];
                a(new int[]{0, 5, 0, 0}, false, new byte[]{1, 1, 0, 1, 1}, objArr);
                return URLDecoder.decode(str, ((String) objArr[0]).intern());
            }
            return null;
        } catch (Exception e) {
            LoggerFactory.getTraceLogger().error(TAG, e);
            return null;
        }
    }

    public static String getAppId() {
        ApplicationInfo applicationInfo;
        int i = MyBillsEntityDataFactory + 7;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Context applicationContext = LoggerFactory.getLogContext().getApplicationContext();
            applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
        } catch (Throwable th) {
            InstrumentInjector.log_e(TAG, "obtainPublicKey", th);
            applicationInfo = null;
        }
        if (!(applicationInfo == null)) {
            if (applicationInfo.metaData == null) {
                int i3 = MyBillsEntityDataFactory + 71;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 17 / 0;
                    return null;
                }
                return null;
            }
            try {
                return applicationInfo.metaData.getString(MonitorItemConstants.KEY_APP_ID);
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        int length;
        char[] cArr;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if ((cArr2 != null ? (char) 27 : 'P') == 27) {
            int i5 = $11 + 45;
            $10 = i5 % 128;
            if (i5 % 2 == 0) {
                length = cArr2.length;
                cArr = new char[length];
            } else {
                length = cArr2.length;
                cArr = new char[length];
            }
            int i6 = 0;
            while (true) {
                if ((i6 < length ? Typography.dollar : 'Z') != '$') {
                    break;
                }
                int i7 = $11 + 37;
                $10 = i7 % 128;
                if ((i7 % 2 != 0 ? (char) 17 : (char) 15) == 17) {
                    cArr[i6] = (char) (cArr2[i6] / 5097613533456403102L);
                    i6 >>= 0;
                } else {
                    cArr[i6] = (char) (cArr2[i6] ^ 5097613533456403102L);
                    i6++;
                }
            }
            cArr2 = cArr;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr2, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (true) {
                if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2 ? (char) 28 : 'S') != 28) {
                    break;
                }
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    int i8 = $10 + 29;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                try {
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i10 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i10, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i10);
        }
        if ((z ? '?' : '8') == '?') {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                int i11 = $10 + 93;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                int i13 = $11 + 45;
                $10 = i13 % 128;
                int i14 = i13 % 2;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
