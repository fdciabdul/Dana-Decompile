package com.alipay.imobile.network.quake.transport.http.constant;

import android.os.Process;
import android.view.View;
import o.getCallingPid;

/* loaded from: classes6.dex */
public class HeaderConstant {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    public static final String DEFAULT_CHARSET;
    public static final String HEADER_KEY_APPID = "AppId";
    public static final String HEADER_KEY_APPKEY = "AppKey";
    public static final String HEADER_KEY_APP_KEY = "App-Key";
    public static final Object HEADER_KEY_CHARSET;
    public static final String HEADER_KEY_CLIENT_ID = "clientId";
    public static final String HEADER_KEY_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_KEY_CONTROL = "Control";
    public static final String HEADER_KEY_COOKIE = "Cookie";
    public static final String HEADER_KEY_DID = "did";
    public static final String HEADER_KEY_ETAG = "ETag";
    public static final String HEADER_KEY_ID = "id";
    public static final String HEADER_KEY_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HEADER_KEY_IF_NONE_MATCH = "If-None-Match";
    public static final String HEADER_KEY_MEMO = "Memo";
    public static final String HEADER_KEY_MGW_TRACE_ID = "Mgw-TraceId";
    public static final String HEADER_KEY_OPERATION_TYPE = "operationType";
    public static final String HEADER_KEY_REQ_DATA = "requestData";
    public static final String HEADER_KEY_RESULT_STATUS = "Result-Status";
    public static final String HEADER_KEY_RPCID = "RpcId";
    public static final String HEADER_KEY_SENCE = "scene";
    public static final String HEADER_KEY_SERVER_TIME = "Server-Time";
    public static final String HEADER_KEY_SET_COOKIE = "Set-Cookie";
    public static final String HEADER_KEY_SIGN = "sign";
    public static final String HEADER_KEY_TENANT_ID = "tenantId";
    public static final String HEADER_KEY_TIPS = "Tips";
    public static final String HEADER_KEY_TRACKERID = "TrackerId";
    public static final String HEADER_KEY_TS = "ts";
    public static final String HEADER_KEY_UUID = "uuid";
    public static final String HEADER_KEY_VERSION = "version";
    public static final String HEADER_KEY_WORKSPACE_ID = "workspaceId";
    public static final String HEADER_VALUE_CONTENT_ENCODING_GZIP = "gzip";
    public static final String HEADER_VALUE_JSON_TYPE = "application/json";
    public static final String HEADER_VALUE_OLD_TYPE = "application/x-www-form-urlencoded";
    public static final String HEADER_VALUE_PB_TYPE = "application/protobuf";
    public static final String HEADER_VALUE_RPC_VERSION_1_0 = "1";
    public static final String HEADER_VALUE_RPC_VERSION_2 = "2";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char[] MyBillsEntityDataFactory = null;
    private static int getAuthRequestContext = 1;

    static {
        BuiltInFictitiousFunctionClassFactory();
        Object[] objArr = new Object[1];
        a(new char[]{4, 7, '\b', 5, 13768}, (byte) ((Process.myTid() >> 22) + 38), View.MeasureSpec.makeMeasureSpec(0, 0) + 5, objArr);
        DEFAULT_CHARSET = ((String) objArr[0]).intern();
        HEADER_KEY_CHARSET = "Charset";
        int i = getAuthRequestContext + 95;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = (char) 42070;
        MyBillsEntityDataFactory = new char[]{42065, 37274, 37346, 37367, 37275, 37257, 42071, 42070, 42068};
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ BuiltInFictitiousFunctionClassFactory);
        char[] cArr4 = new char[i];
        if (!(i % 2 == 0)) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i4 = $11 + 27;
            $10 = i4 % 128;
            if ((i4 % 2 != 0 ? '#' : (char) 21) != '#') {
                getcallingpid.getAuthRequestContext = 0;
            } else {
                try {
                    getcallingpid.getAuthRequestContext = 1;
                } catch (Exception e) {
                    throw e;
                }
            }
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (!(getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult)) {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i5 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i6 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i5];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i6];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory != getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        int i7 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i8 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i7];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i8];
                        int i9 = $10 + 3;
                        $11 = i9 % 128;
                        int i10 = i9 % 2;
                    } else {
                        int i11 = $10 + 1;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                        try {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                } else {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i15 = 0; i15 < i; i15++) {
            cArr4[i15] = (char) (cArr4[i15] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
