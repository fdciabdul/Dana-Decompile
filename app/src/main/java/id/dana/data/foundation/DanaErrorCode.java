package id.dana.data.foundation;

import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.foundation.common.error.AEErrorCode;
import id.dana.network.response.login.LoginRpcResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import o.A;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes4.dex */
public enum DanaErrorCode {
    NETWORK_TIMEOUT(getErrorCode("005"), "Network timeout, please try again later"),
    NETWORK_UNAVAILABLE(getErrorCode("012"), "Network unavailable, please try again later"),
    NETWORK_ERROR("AE15002258001005", "Network unavailable, please try again later."),
    SYSTEM_ERROR("AE15002058020002", "System is busy, please try again later."),
    USER_UN_REGISTER("AE15102058020034", "Unregister or Uninitialized."),
    HAS_USER_BUT_WITH_ERROR("AE15102058020049", "Login failed."),
    SERVICE_NOT_FOUND("DE404", "Service not found."),
    USER_NOT_EXIST("AE15112001306101", "USER_NOT_EXIST"),
    USER_STATUS_IS_ILLEGAL("AE15112001306102", "USER_STATUS_IS_ILLEGAL"),
    HOLD_LOGIN_FAILED("AE15112158044830", "HOLD_LOGIN_FAILED"),
    LOGIN_RISK_REJECT("AE15112158045003", "LOGIN_RISK_REJECT"),
    USER_NOT_EXIST_B("AE15112158047201", "USER_NOT_EXIST");

    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static int getAuthRequestContext = 1;
    public String code;
    public String msg;

    static void MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 269894796;
    }

    public static DanaErrorCode valueOf(String str) {
        int i = MyBillsEntityDataFactory + 79;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            DanaErrorCode danaErrorCode = (DanaErrorCode) Enum.valueOf(DanaErrorCode.class, str);
            int i3 = MyBillsEntityDataFactory + 123;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return danaErrorCode;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static DanaErrorCode[] valuesCustom() {
        try {
            int i = getAuthRequestContext + 27;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 != 0) {
                DanaErrorCode[] danaErrorCodeArr = (DanaErrorCode[]) values().clone();
                Object[] objArr = null;
                int length = objArr.length;
                return danaErrorCodeArr;
            }
            return (DanaErrorCode[]) values().clone();
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        MyBillsEntityDataFactory();
        try {
            int i = getAuthRequestContext + 115;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 != 0 ? 'a' : 'Y') != 'a') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    DanaErrorCode(String str, String str2) {
        this.code = str;
        this.msg = str2;
    }

    public static boolean isUserUnregister(String str) {
        int i = getAuthRequestContext + 125;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        boolean equalsIgnoreCase = USER_UN_REGISTER.code.equalsIgnoreCase(str);
        try {
            int i3 = getAuthRequestContext + 79;
            MyBillsEntityDataFactory = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return equalsIgnoreCase;
            }
            return equalsIgnoreCase;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String getErrorCode(RpcException rpcException) {
        try {
            int i = getAuthRequestContext + 3;
            try {
                MyBillsEntityDataFactory = i % 128;
                char c = i % 2 != 0 ? (char) 28 : (char) 22;
                String str = getDanaErrorCodeByRpcException(rpcException).code;
                if (c == 28) {
                    int i2 = 7 / 0;
                }
                int i3 = MyBillsEntityDataFactory + 21;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static DanaErrorCode getDanaErrorCodeByRpcException(RpcException rpcException) {
        int i = MyBillsEntityDataFactory + 49;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (rpcException == null) {
            try {
                return SYSTEM_ERROR;
            } catch (Exception e) {
                throw e;
            }
        }
        if (!("012".equalsIgnoreCase(rpcException.code) ? false : true)) {
            int i3 = MyBillsEntityDataFactory + 93;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            DanaErrorCode danaErrorCode = NETWORK_UNAVAILABLE;
            int i5 = getAuthRequestContext + 49;
            MyBillsEntityDataFactory = i5 % 128;
            int i6 = i5 % 2;
            return danaErrorCode;
        }
        if (("005".equalsIgnoreCase(rpcException.code) ? 'T' : Typography.less) != '<') {
            return NETWORK_TIMEOUT;
        }
        return SYSTEM_ERROR;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        if (r3 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r3 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(getDanaErrorCodeByRpcException(r3).msg);
        r0.append(" (");
        r0.append(r3.code);
        r0.append(")");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        return r0.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getErrorMsg(id.dana.data.foundation.RpcException r3) {
        /*
            id.dana.data.foundation.DanaErrorCode r0 = getDanaErrorCodeByRpcException(r3)     // Catch: java.lang.Exception -> L61
            id.dana.data.foundation.DanaErrorCode r1 = id.dana.data.foundation.DanaErrorCode.SYSTEM_ERROR     // Catch: java.lang.Exception -> L61
            r2 = 87
            if (r0 != r1) goto Ld
            r1 = 87
            goto Lf
        Ld:
            r1 = 33
        Lf:
            if (r1 == r2) goto L12
            goto L54
        L12:
            int r1 = id.dana.data.foundation.DanaErrorCode.MyBillsEntityDataFactory
            int r1 = r1 + 63
            int r2 = r1 % 128
            id.dana.data.foundation.DanaErrorCode.getAuthRequestContext = r2
            int r1 = r1 % 2
            r2 = 44
            if (r1 != 0) goto L23
            r1 = 83
            goto L25
        L23:
            r1 = 44
        L25:
            if (r1 == r2) goto L30
            r1 = 16
            int r1 = r1 / 0
            if (r3 == 0) goto L54
            goto L32
        L2e:
            r3 = move-exception
            throw r3
        L30:
            if (r3 == 0) goto L54
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            id.dana.data.foundation.DanaErrorCode r1 = getDanaErrorCodeByRpcException(r3)
            java.lang.String r1 = r1.msg
            r0.append(r1)
            java.lang.String r1 = " ("
            r0.append(r1)
            java.lang.String r3 = r3.code
            r0.append(r3)
            java.lang.String r3 = ")"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        L54:
            java.lang.String r3 = r0.msg
            int r0 = id.dana.data.foundation.DanaErrorCode.getAuthRequestContext
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.data.foundation.DanaErrorCode.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return r3
        L61:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.DanaErrorCode.getErrorMsg(id.dana.data.foundation.RpcException):java.lang.String");
    }

    private static String getErrorCode(String str) {
        String obj = new AEErrorCode("1", "5", "0", "02258001", str, AEErrorCode.getAuthRequestContext()).toString();
        try {
            int i = getAuthRequestContext + 1;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 == 0) {
                return obj;
            }
            int i2 = 47 / 0;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    public static boolean isNetworkError(RpcException rpcException) {
        int i = MyBillsEntityDataFactory + 79;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? (char) 27 : (char) 24) != 24) {
            boolean equalsIgnoreCase = "012".equalsIgnoreCase(rpcException.code);
            Object[] objArr = null;
            int length = objArr.length;
            if ((!equalsIgnoreCase ? 'S' : (char) 23) != 'S') {
                return true;
            }
        } else if ("012".equalsIgnoreCase(rpcException.code)) {
            return true;
        }
        if (("005".equalsIgnoreCase(rpcException.code)) || "002".equalsIgnoreCase(rpcException.code) || "006".equalsIgnoreCase(rpcException.code)) {
            return true;
        }
        int i2 = MyBillsEntityDataFactory + 43;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 == 0) {
        }
        return false;
    }

    public static boolean isHoldLoginError(LoginRpcResult loginRpcResult) {
        int i = MyBillsEntityDataFactory + 7;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (loginRpcResult == null) {
            int i3 = getAuthRequestContext + 59;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return false;
        }
        try {
            String str = loginRpcResult.errorCode;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!(isHoldLoginFailError(str))) {
                for (String str2 : getHoldLoginErrorCode()) {
                    if (!TextUtils.isEmpty(str2)) {
                        if ((str.equals(str2) ? (char) 24 : 'a') == 24) {
                            return true;
                        }
                    }
                }
                int i5 = MyBillsEntityDataFactory + 41;
                getAuthRequestContext = i5 % 128;
                if (i5 % 2 == 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return false;
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        if ((r0) != true) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        if ((!id.dana.data.foundation.DanaErrorCode.LOGIN_RISK_REJECT.code.equals(r4)) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        if (id.dana.data.foundation.DanaErrorCode.USER_NOT_EXIST_B.code.equals(r4) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isHoldLoginFailError(java.lang.String r4) {
        /*
            id.dana.data.foundation.DanaErrorCode r0 = id.dana.data.foundation.DanaErrorCode.USER_NOT_EXIST
            java.lang.String r0 = r0.code
            boolean r0 = r0.equals(r4)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L68
            int r0 = id.dana.data.foundation.DanaErrorCode.MyBillsEntityDataFactory
            int r0 = r0 + 5
            int r3 = r0 % 128
            id.dana.data.foundation.DanaErrorCode.getAuthRequestContext = r3
            int r0 = r0 % 2
            id.dana.data.foundation.DanaErrorCode r0 = id.dana.data.foundation.DanaErrorCode.USER_STATUS_IS_ILLEGAL     // Catch: java.lang.Exception -> L66
            java.lang.String r0 = r0.code     // Catch: java.lang.Exception -> L66
            boolean r0 = r0.equals(r4)     // Catch: java.lang.Exception -> L66
            if (r0 != 0) goto L68
            id.dana.data.foundation.DanaErrorCode r0 = id.dana.data.foundation.DanaErrorCode.HOLD_LOGIN_FAILED     // Catch: java.lang.Exception -> L66
            java.lang.String r0 = r0.code     // Catch: java.lang.Exception -> L66
            boolean r0 = r0.equals(r4)     // Catch: java.lang.Exception -> L66
            if (r0 != 0) goto L68
            int r0 = id.dana.data.foundation.DanaErrorCode.MyBillsEntityDataFactory
            int r0 = r0 + 55
            int r3 = r0 % 128
            id.dana.data.foundation.DanaErrorCode.getAuthRequestContext = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L4c
            id.dana.data.foundation.DanaErrorCode r0 = id.dana.data.foundation.DanaErrorCode.LOGIN_RISK_REJECT
            java.lang.String r0 = r0.code
            boolean r0 = r0.equals(r4)
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L46
            r0 = 0
            goto L47
        L46:
            r0 = 1
        L47:
            if (r0 == r2) goto L68
            goto L5b
        L4a:
            r4 = move-exception
            throw r4
        L4c:
            id.dana.data.foundation.DanaErrorCode r0 = id.dana.data.foundation.DanaErrorCode.LOGIN_RISK_REJECT
            java.lang.String r0 = r0.code
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L58
            r0 = 1
            goto L59
        L58:
            r0 = 0
        L59:
            if (r0 == 0) goto L68
        L5b:
            id.dana.data.foundation.DanaErrorCode r0 = id.dana.data.foundation.DanaErrorCode.USER_NOT_EXIST_B
            java.lang.String r0 = r0.code
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L68
            goto L69
        L66:
            r4 = move-exception
            throw r4
        L68:
            r1 = 1
        L69:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.DanaErrorCode.isHoldLoginFailError(java.lang.String):boolean");
    }

    private static List<String> getHoldLoginErrorCode() {
        int i = MyBillsEntityDataFactory + 87;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ConfigCenter configCenter = ConfigCenter.getInstance();
        Object[] objArr = new Object[1];
        a(new char[]{65531, 65530, 5, 65529, '\b', 5, '\b', '\b', 65531, 65525, 4, 65535, 65533, 5, 2, 65530, 2, 5, 65534}, View.MeasureSpec.getMode(0) + 275, ((Process.getThreadPriority(0) + 20) >> 6) + 19, true, 19 - (Process.myPid() >> 22), objArr);
        JSONArray jSONArrayConfig = configCenter.getJSONArrayConfig(((String) objArr[0]).intern());
        if (jSONArrayConfig == null) {
            int i3 = MyBillsEntityDataFactory + 49;
            getAuthRequestContext = i3 % 128;
            boolean z = i3 % 2 != 0;
            List<String> emptyList = Collections.emptyList();
            if (!z) {
                Object[] objArr2 = null;
                int length = objArr2.length;
            }
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            try {
                if (!(i4 < jSONArrayConfig.length())) {
                    return arrayList;
                }
                arrayList.add(jSONArrayConfig.getString(i4));
                i4++;
            } catch (JSONException unused) {
                return new ArrayList();
            }
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        int i4;
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i2) {
            int i5 = $11 + 21;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i7 = a2.MyBillsEntityDataFactory;
            cArr2[i7] = (char) (cArr2[i7] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (!(i3 <= 0)) {
            try {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            } catch (Exception e) {
                throw e;
            }
        }
        if ((z ? 'P' : 'B') == 'P') {
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i2) {
                int i8 = $11 + 85;
                $10 = i8 % 128;
                if (i8 % 2 != 0) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(a2.MyBillsEntityDataFactory * i2) % 0];
                    i4 = a2.MyBillsEntityDataFactory >>> 0;
                } else {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    i4 = a2.MyBillsEntityDataFactory + 1;
                }
                a2.MyBillsEntityDataFactory = i4;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
