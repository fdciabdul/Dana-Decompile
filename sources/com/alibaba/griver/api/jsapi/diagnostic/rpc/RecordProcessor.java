package com.alibaba.griver.api.jsapi.diagnostic.rpc;

import android.graphics.Color;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.api.common.network.UploadRequest;
import com.alibaba.griver.api.jsapi.diagnostic.UploadCallback;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.base.common.rpc.GriverRpcExtension;
import com.alibaba.griver.ui.ant.api.AUAttrsConstant;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.common.net.HttpHeaders;
import id.dana.cashier.view.InputCardNumberView;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import o.A;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class RecordProcessor {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final String DEFAULT_CHARSET;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 269894782;
    private static int getAuthRequestContext;

    static {
        Object[] objArr = new Object[1];
        b(new char[]{16, 2, 65513, 65524, 17}, 159 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), Process.getGidForName("") + 6, false, (ViewConfiguration.getTouchSlop() >> 8) + 4, objArr);
        DEFAULT_CHARSET = ((String) objArr[0]).intern();
        int i = getAuthRequestContext + 75;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? ';' : '9') != '9') {
            Object obj = null;
            obj.hashCode();
        }
    }

    static /* synthetic */ void access$000(RecordProcessor recordProcessor, String str, String str2, String str3, UploadFileResult uploadFileResult, UploadCallback uploadCallback) {
        int i = BuiltInFictitiousFunctionClassFactory + 27;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        recordProcessor.a(str, str2, str3, uploadFileResult, uploadCallback);
        int i3 = BuiltInFictitiousFunctionClassFactory + 125;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 61 / 0;
        }
    }

    public void uploadFile(final String str, final String str2, final String str3, final String str4, final UploadCallback uploadCallback) {
        GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.api.jsapi.diagnostic.rpc.RecordProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("fileName", str2);
                    jSONObject.put("currentWorkspaceId", str4);
                    HashMap hashMap = new HashMap();
                    hashMap.put("AppId", GriverEnv.getAppId());
                    hashMap.put("operationType", "gmp.openplatform.portal.fileupload.params.fetch");
                    hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                    hashMap.put("WorkspaceId", "default");
                    com.alibaba.fastjson.JSONObject invokeRpc = ((GriverRpcExtension) RVProxy.get(GriverRpcExtension.class)).invokeRpc("gmp.openplatform.portal.fileupload.params.fetch", jSONObject.toString(), GriverEnv.getGateway(), hashMap);
                    String string = JSONUtils.getString(invokeRpc, "success", "");
                    if (!TextUtils.isEmpty(string)) {
                        UploadFileResult uploadFileResult = (UploadFileResult) JSON.parseObject(string, UploadFileResult.class);
                        StringBuilder sb = new StringBuilder();
                        sb.append("result");
                        sb.append(invokeRpc);
                        GriverLogger.d("RecordProcessor", sb.toString());
                        RecordProcessor.access$000(RecordProcessor.this, str, str2, str3, uploadFileResult, uploadCallback);
                        return;
                    }
                    uploadCallback.onFailed("-1", "fileupload error");
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("result");
                    sb2.append(th);
                    GriverLogger.e("RecordProcessor", sb2.toString());
                    uploadCallback.onFailed("-1", "fileupload error");
                }
            }
        });
        int i = BuiltInFictitiousFunctionClassFactory + 87;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    private void a(String str, String str2, String str3, UploadFileResult uploadFileResult, UploadCallback uploadCallback) {
        try {
            StringBuilder sb = new StringBuilder();
            int i = getAuthRequestContext + 13;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            for (Map.Entry<String, String> entry : uploadFileResult.uploadParams.entrySet()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("--");
                sb2.append(str);
                sb2.append("\r\n");
                sb.append(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Content-Disposition: form-data; name=\"");
                sb3.append(entry.getKey());
                sb3.append("\"\r\n");
                sb.append(sb3.toString());
                sb.append("\r\n");
                StringBuilder sb4 = new StringBuilder();
                sb4.append(entry.getValue());
                sb4.append("\r\n");
                sb.append(sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("--");
            sb5.append(str);
            sb5.append("\r\n");
            sb.append(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Content-Disposition: form-data; name=\"file\"; filename=\"");
            sb6.append(str2);
            sb6.append("\"\r\n");
            sb.append(sb6.toString());
            sb.append("Content-Type: application/json\r\n");
            sb.append("\r\n");
            String obj = sb.toString();
            Object[] objArr = new Object[1];
            b(new char[]{16, 2, 65513, 65524, 17}, Color.green(0) + 159, 5 - TextUtils.getTrimmedLength(""), false, '4' - AndroidCharacter.getMirror('0'), objArr);
            byte[] bytes = obj.getBytes(Charset.forName(((String) objArr[0]).intern()));
            StringBuilder sb7 = new StringBuilder();
            sb7.append("\r\n--");
            sb7.append(str);
            sb7.append("--\r\n");
            String obj2 = sb7.toString();
            Object[] objArr2 = new Object[1];
            b(new char[]{16, 2, 65513, 65524, 17}, TextUtils.indexOf((CharSequence) "", '0') + BlobStatic.MONITOR_IMAGE_WIDTH, 4 - MotionEvent.axisFromString(""), false, 4 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr2);
            byte[] bytes2 = obj2.getBytes(Charset.forName(((String) objArr2[0]).intern()));
            HttpRequest httpRequest = new HttpRequest();
            httpRequest.setMethod("POST");
            httpRequest.setUrl(uploadFileResult.uploadOrigin);
            HashMap hashMap = new HashMap();
            StringBuilder sb8 = new StringBuilder();
            sb8.append("multipart/form-data; boundary=");
            sb8.append(str);
            hashMap.put("Content-Type", sb8.toString());
            hashMap.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(bytes.length + str3.length() + bytes2.length));
            httpRequest.setHeaders(hashMap);
            UploadRequest uploadRequest = new UploadRequest();
            uploadRequest.setHeaders(bytes);
            uploadRequest.setEnds(bytes2);
            Object[] objArr3 = new Object[1];
            b(new char[]{16, 2, 65513, 65524, 17}, 159 - View.resolveSize(0, 0), 5 - (ViewConfiguration.getWindowTouchSlop() >> 8), false, 4 - ((Process.getThreadPriority(0) + 20) >> 6), objArr3);
            uploadRequest.setInputStream(new ByteArrayInputStream(str3.getBytes(Charset.forName(((String) objArr3[0]).intern()))));
            httpRequest.setUploadRequest(uploadRequest);
            HttpResponse request = GriverTransport.request(httpRequest);
            if ((request != null ? '!' : 'U') == '!') {
                int i3 = getAuthRequestContext + 53;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                if (!(request.getStatusCode() != 204)) {
                    uploadCallback.onSuccess(uploadFileResult.objectUrl);
                    return;
                }
            }
            uploadCallback.onFailed(AUAttrsConstant.WRAP_CONTENT, "upload to oss failed");
            int i5 = BuiltInFictitiousFunctionClassFactory + 63;
            getAuthRequestContext = i5 % 128;
            int i6 = i5 % 2;
        } catch (Throwable unused) {
            uploadCallback.onFailed(AUAttrsConstant.WRAP_CONTENT, "upload to oss failed");
        }
    }

    public void uploadRunningReport(final String str, String str2, final String str3, final UploadCallback uploadCallback) {
        try {
            try {
                GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.api.jsapi.diagnostic.rpc.RecordProcessor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("AppId", GriverEnv.getAppId());
                            hashMap.put("operationType", str);
                            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                            hashMap.put("WorkspaceId", "default");
                            if (!TextUtils.isEmpty(JSONUtils.getString(((GriverRpcExtension) RVProxy.get(GriverRpcExtension.class)).invokeRpc(str, str3, GriverEnv.getGateway(), hashMap), "success", ""))) {
                                uploadCallback.onSuccess("");
                            } else {
                                uploadCallback.onFailed("-1", "uploading running report error");
                            }
                        } catch (Throwable th) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("result");
                            sb.append(th);
                            GriverLogger.e("RecordProcessor", sb.toString());
                            uploadCallback.onFailed("-1", "uploading running report error");
                        }
                    }
                });
                int i = BuiltInFictitiousFunctionClassFactory + 73;
                getAuthRequestContext = i % 128;
                if ((i % 2 != 0 ? '^' : InputCardNumberView.DIVIDER) != ' ') {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void b(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        try {
            a2.MyBillsEntityDataFactory = 0;
            int i4 = $10 + 103;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? '`' : ';') != '`') {
                    break;
                }
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i6 = a2.MyBillsEntityDataFactory;
                cArr2[i6] = (char) (cArr2[i6] - ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            }
            if (!(i3 <= 0)) {
                int i7 = $11 + 1;
                try {
                    $10 = i7 % 128;
                    int i8 = i7 % 2;
                    a2.BuiltInFictitiousFunctionClassFactory = i3;
                    char[] cArr3 = new char[i2];
                    System.arraycopy(cArr2, 0, cArr3, 0, i2);
                    System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                    System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                } catch (Exception e) {
                    throw e;
                }
            }
            if (z) {
                char[] cArr4 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i2) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            }
            objArr[0] = new String(cArr2);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
