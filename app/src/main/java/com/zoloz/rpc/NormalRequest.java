package com.zoloz.rpc;

import android.graphics.PointF;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.zoloz.rpccommon.NetResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import o.D;

/* loaded from: classes8.dex */
public class NormalRequest {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int MyBillsEntityDataFactory = 0;
    private static long PlaceComponentResult = 0;
    private static String TAG = "NormalRequest";

    static {
        BuiltInFictitiousFunctionClassFactory();
        int i = BuiltInFictitiousFunctionClassFactory + 87;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            int i2 = 70 / 0;
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult = 4068256130671101072L;
    }

    public static NetResponse doRequest(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("AppId", RpcConfig.getInstance().getAppId());
        hashMap.put("workspaceId", RpcConfig.getInstance().getWorkspaceId());
        hashMap.put(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        Object[] objArr = new Object[1];
        a((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{44824, 61598, 7381, 44877, 31154, 3683, 3553, 37284, 35520}, objArr);
        hashMap.put("Charset", ((String) objArr[0]).intern());
        hashMap.put("Content-type", "application/json");
        NetResponse doRequest = doRequest(str, hashMap, str2.getBytes());
        int i = MyBillsEntityDataFactory + 57;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return doRequest;
    }

    public static NetResponse doRequest(String str, Map<String, String> map, byte[] bArr) throws ZolozRpcException {
        InputStream errorStream;
        NetResponse netResponse = new NetResponse();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(InstrumentInjector.urlconnection_wrapInstance(new URL(str).openConnection())));
            httpURLConnection.setReadTimeout(RpcConfig.getInstance().getReadTimeout());
            httpURLConnection.setConnectTimeout(RpcConfig.getInstance().getConnectTimeout());
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            int i = BuiltInFictitiousFunctionClassFactory + 65;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            while (true) {
                if ((it.hasNext() ? 'X' : (char) 30) != 'X') {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                httpURLConnection.setRequestProperty(next.getKey(), next.getValue());
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            httpURLConnection.connect();
            if (httpURLConnection != null) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 43;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        errorStream = httpURLConnection.getInputStream();
                    } else {
                        errorStream = httpURLConnection.getErrorStream();
                        int i5 = MyBillsEntityDataFactory + 21;
                        BuiltInFictitiousFunctionClassFactory = i5 % 128;
                        int i6 = i5 % 2;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[10240];
                    while (true) {
                        int read = errorStream.read(bArr2);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    netResponse.responseBody = byteArrayOutputStream.toByteArray();
                    netResponse.rpcCode = responseCode;
                } catch (IOException unused) {
                    netResponse.rpcCode = 4;
                }
            }
            return netResponse;
        } catch (IOException unused2) {
            throw new ZolozRpcException((Integer) 2, GriverMonitorConstants.MESSAGE_HTTP_REQUEST_NETWORK_ERROR);
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 77;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length ? 'C' : ':') != ':') {
                int i4 = $10 + 35;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (PlaceComponentResult ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } else {
                String str = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                int i6 = $11 + 109;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
