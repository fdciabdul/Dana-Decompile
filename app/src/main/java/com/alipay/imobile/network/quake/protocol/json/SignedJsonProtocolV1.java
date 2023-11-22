package com.alipay.imobile.network.quake.protocol.json;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.Response;
import com.alipay.imobile.network.quake.exception.ClientException;
import com.alipay.imobile.network.quake.exception.ServerException;
import com.alipay.imobile.network.quake.f;
import com.alipay.imobile.network.quake.protocol.AbstractHttpProtocol;
import com.alipay.imobile.network.quake.rpc.RpcRequest;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.alipay.imobile.network.quake.util.SignUtil;
import com.alipay.mobile.common.rpc.RpcException;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.text.Typography;
import o.whenAvailable;

/* loaded from: classes3.dex */
public class SignedJsonProtocolV1 extends AbstractHttpProtocol<Object> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static char[] MyBillsEntityDataFactory = {4815, 50818, 47684, 28243, 17298};
    private static long getAuthRequestContext = -3514914925583980798L;

    /* renamed from: a  reason: collision with root package name */
    private com.alipay.imobile.network.quake.ext.proxy.a f7054a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Comparator<com.alipay.imobile.network.quake.i.a> {
        a(SignedJsonProtocolV1 signedJsonProtocolV1) {
        }

        @Override // java.util.Comparator
        /* renamed from: a  reason: merged with bridge method [inline-methods] */
        public int compare(com.alipay.imobile.network.quake.i.a aVar, com.alipay.imobile.network.quake.i.a aVar2) {
            try {
                return aVar.a().compareTo(aVar2.a());
            } catch (Exception e) {
                LoggerWrapper.e(Quake.TAG, "", e);
                return 0;
            }
        }
    }

    public SignedJsonProtocolV1(Context context) {
        this.f7054a = com.alipay.imobile.network.quake.ext.proxy.a.a(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        r6.add(new com.alipay.imobile.network.quake.i.a("operationType", r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.List<com.alipay.imobile.network.quake.i.a> r6, com.alipay.imobile.network.quake.Request r7) {
        /*
            r5 = this;
            java.lang.String r0 = "ts"
            int r1 = com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 19
            int r2 = r1 % 128
            com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 == 0) goto L12
            r1 = 1
            goto L13
        L12:
            r1 = 0
        L13:
            if (r1 == 0) goto L25
            java.lang.String r1 = r7.getActionType()
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            r4 = 76
            int r4 = r4 / r2
            if (r3 != 0) goto L39
            goto L2f
        L23:
            r6 = move-exception
            throw r6
        L25:
            java.lang.String r1 = r7.getActionType()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L39
        L2f:
            com.alipay.imobile.network.quake.i.a r2 = new com.alipay.imobile.network.quake.i.a
            java.lang.String r3 = "operationType"
            r2.<init>(r3, r1)
            r6.add(r2)
        L39:
            com.alipay.imobile.network.quake.i.a r1 = new com.alipay.imobile.network.quake.i.a
            java.lang.String r2 = "id"
            int r3 = r7.getSequence()     // Catch: java.lang.Exception -> L81
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L81
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L81
            r6.add(r1)     // Catch: java.lang.Exception -> L81
            com.alipay.imobile.network.quake.i.a r1 = new com.alipay.imobile.network.quake.i.a     // Catch: java.lang.Exception -> L81
            java.lang.String r2 = "requestData"
            java.lang.String r3 = r5.getRequestDataJson(r7)     // Catch: java.lang.Exception -> L81
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L81
            r6.add(r1)     // Catch: java.lang.Exception -> L81
            java.util.Map r7 = r7.getExternalInfo()     // Catch: java.lang.Exception -> L81
            java.lang.Object r7 = r7.get(r0)     // Catch: java.lang.Exception -> L81
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L81
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L81
            if (r1 != 0) goto L80
            com.alipay.imobile.network.quake.i.a r1 = new com.alipay.imobile.network.quake.i.a
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r1.<init>(r0, r7)
            r6.add(r1)
            int r6 = com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 117
            int r7 = r6 % 128
            com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.BuiltInFictitiousFunctionClassFactory = r7
            int r6 = r6 % 2
        L80:
            return
        L81:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.a(java.util.List, com.alipay.imobile.network.quake.Request):void");
    }

    @Override // com.alipay.imobile.network.quake.protocol.Protocol
    public Response<Object> deserialize(Request request, NetworkResponse networkResponse) throws RpcException {
        String str = "";
        try {
            try {
                Map<String, String> map = networkResponse.extData;
                boolean z = false;
                Object[] objArr = new Object[1];
                d(TextUtils.lastIndexOf("", '0') + 6, ViewConfiguration.getMaximumDrawingCacheSize() >> 24, (char) (57811 - TextUtils.indexOf((CharSequence) "", '0', 0)), objArr);
                String str2 = new String(networkResponse.data, parseCharset(map, ((String) objArr[0]).intern()));
                try {
                    String str3 = Quake.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("the response to be deserialized is ");
                    sb.append(str2);
                    LoggerWrapper.d(str3, sb.toString());
                    JSONObject parseObject = JSON.parseObject(str2);
                    int intValue = parseObject.getIntValue("resultStatus");
                    Object obj = null;
                    if (intValue == 1000) {
                        Type responseType = request.getResponseType();
                        if ((responseType != null ? '2' : Typography.greater) != '>') {
                            if (Void.TYPE != responseType) {
                                String string = parseObject.getString("result");
                                if (String.class != responseType) {
                                    return Response.success(JSON.parseObject(string, responseType, new Feature[0]), parseCacheHeaders(networkResponse));
                                }
                                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                                BuiltInFictitiousFunctionClassFactory = i % 128;
                                int i2 = i % 2;
                                return Response.success(string, parseCacheHeaders(networkResponse));
                            }
                            int i3 = BuiltInFictitiousFunctionClassFactory + 3;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                            int i4 = i3 % 2;
                        }
                        return null;
                    }
                    String string2 = parseObject.getString(HeaderConstant.HEADER_KEY_MEMO);
                    String string3 = parseObject.getString(HeaderConstant.HEADER_KEY_TIPS);
                    if (!TextUtils.isEmpty(string3)) {
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                        BuiltInFictitiousFunctionClassFactory = i5 % 128;
                        int i6 = i5 % 2;
                        string2 = string3;
                    }
                    ServerException serverException = new ServerException(Integer.valueOf(intValue), string2);
                    if (intValue != 1002) {
                        z = true;
                    }
                    if (!z) {
                        JSONObject jSONObject = parseObject.getJSONObject(HeaderConstant.HEADER_KEY_CONTROL);
                        if (jSONObject != null) {
                            int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
                            BuiltInFictitiousFunctionClassFactory = i7 % 128;
                            if (i7 % 2 == 0) {
                                serverException.setControl(jSONObject.toJSONString());
                                obj.hashCode();
                                throw serverException;
                            }
                            serverException.setControl(jSONObject.toJSONString());
                            throw serverException;
                        }
                        throw serverException;
                    }
                    throw serverException;
                } catch (JSONException e) {
                    e = e;
                    str = str2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("response  =");
                    sb2.append(str);
                    sb2.append(":");
                    sb2.append(e.getMessage());
                    ClientException clientException = new ClientException((Integer) 10, sb2.toString());
                    clientException.initCause(e);
                    return Response.error(clientException);
                }
            } catch (RpcException e2) {
                return Response.error(e2);
            } catch (UnsupportedEncodingException e3) {
                return Response.error(new ClientException((Integer) 10, (Throwable) e3));
            } catch (Exception e4) {
                return Response.error(new ClientException((Integer) 10, (Throwable) e4));
            }
        } catch (JSONException e5) {
            e = e5;
        }
    }

    @Override // com.alipay.imobile.network.quake.protocol.Protocol
    public String getBodyContentType() {
        StringBuilder sb = new StringBuilder();
        sb.append("application/x-www-form-urlencoded; charset=");
        sb.append(getParamsEncoding());
        String obj = sb.toString();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return obj;
    }

    @Override // com.alipay.imobile.network.quake.protocol.Protocol
    public Map<String, String> getExternalInfo(Request request) {
        f o2 = f.o();
        HashMap hashMap = new HashMap();
        String b = this.f7054a.b();
        if (!TextUtils.isEmpty(b)) {
            hashMap.put(HeaderConstant.HEADER_KEY_DID, b);
            int i = BuiltInFictitiousFunctionClassFactory + 73;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        }
        String a2 = this.f7054a.a();
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put("clientId", a2);
        }
        hashMap.put("uuid", UUID.randomUUID().toString());
        String a3 = o2.a();
        if (!TextUtils.isEmpty(a3)) {
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (i3 % 2 != 0) {
                    hashMap.put("AppId", a3);
                } else {
                    hashMap.put("AppId", a3);
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        }
        String j = o2.j();
        if (!TextUtils.isEmpty(j)) {
            try {
                hashMap.put("version", j);
            } catch (Exception e2) {
                throw e2;
            }
        }
        String k = o2.k();
        if (!TextUtils.isEmpty(k)) {
            hashMap.put("workspaceId", k);
        }
        String i4 = o2.i();
        if (!TextUtils.isEmpty(i4)) {
            hashMap.put(HeaderConstant.HEADER_KEY_TENANT_ID, i4);
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        BuiltInFictitiousFunctionClassFactory = i5 % 128;
        int i6 = i5 % 2;
        return hashMap;
    }

    protected String getParamsEncoding() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        d(5 - (ViewConfiguration.getFadingEdgeLength() >> 16), View.MeasureSpec.getMode(0), (char) (57812 - ((Process.getThreadPriority(0) + 20) >> 6)), objArr);
        String intern = ((String) objArr[0]).intern();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return intern;
    }

    public String getRequestDataJson(Request request) {
        Object params = request.getParams();
        if (params != null) {
            try {
                String jSONString = JSON.toJSONString(params, SerializerFeature.DisableCircularReferenceDetect);
                if (!jSONString.startsWith("[")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    sb.append(jSONString);
                    jSONString = sb.toString();
                }
                if (jSONString.endsWith("]")) {
                    return jSONString;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(jSONString);
                sb2.append("]");
                return sb2.toString();
            } catch (Exception e) {
                throw e;
            }
        }
        int i = BuiltInFictitiousFunctionClassFactory + 9;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 != 0) {
            int i2 = 43 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return "[]";
    }

    private byte[] b(List<com.alipay.imobile.network.quake.i.a> list) {
        byte[] bytes;
        int i = BuiltInFictitiousFunctionClassFactory + 17;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 1 : Typography.amp) != '&') {
            bytes = a(list, getParamsEncoding()).getBytes();
            int i2 = 84 / 0;
        } else {
            try {
                try {
                    bytes = a(list, getParamsEncoding()).getBytes();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 7;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return bytes;
    }

    @Override // com.alipay.imobile.network.quake.protocol.Protocol
    public byte[] serialize(Request request) throws RpcException {
        int i = BuiltInFictitiousFunctionClassFactory + 105;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if ((request == null ? '3' : (char) 7) != '3') {
            SignUtil.SignInfo signInfo = request instanceof RpcRequest ? false : true ? null : request.getSignInfo();
            if (signInfo == null) {
                f o2 = f.o();
                signInfo = new SignUtil.SignInfo(o2.b(), o2.c());
            }
            ArrayList arrayList = new ArrayList();
            a(arrayList, request);
            String a2 = a(arrayList, request.getUrl(), signInfo);
            if (!TextUtils.isEmpty(a2)) {
                arrayList.add(new com.alipay.imobile.network.quake.i.a("sign", a2));
            }
            return b(arrayList);
        }
        byte[] bArr = new byte[0];
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return bArr;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if ((!r1 ? 31 : 'E') != 31) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if ((android.text.TextUtils.isEmpty(r0) ? false : true) != true) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        r0 = r5.getOriginUrl();
        r1 = new java.lang.StringBuilder();
        r1.append(r0);
        r1.append("#");
        r1.append(r5.getActionType());
        r1 = r1.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r5.getParams() == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append(r1);
        r2.append("#");
        r2.append(getRequestDataJson(r5));
        r1 = r2.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
    
        r5.setCacheKey(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0075, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        r5 = com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.BuiltInFictitiousFunctionClassFactory + 25;
        com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0080, code lost:
    
        return r0;
     */
    @Override // com.alipay.imobile.network.quake.protocol.Protocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String generateCacheKey(com.alipay.imobile.network.quake.Request r5) {
        /*
            r4 = this;
            int r0 = com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 57
            int r1 = r0 % 128
            com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r2) goto L2d
            java.lang.String r0 = r5.getCacheKey()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L2b
            r2 = 31
            if (r1 != 0) goto L26
            r1 = 31
            goto L28
        L26:
            r1 = 69
        L28:
            if (r1 == r2) goto L76
            goto L3a
        L2b:
            r5 = move-exception
            throw r5
        L2d:
            java.lang.String r0 = r5.getCacheKey()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L38
            r1 = 1
        L38:
            if (r1 == r2) goto L76
        L3a:
            java.lang.String r0 = r5.getOriginUrl()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "#"
            r1.append(r0)
            java.lang.String r2 = r5.getActionType()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.Object r2 = r5.getParams()
            if (r2 == 0) goto L72
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            r2.append(r0)
            java.lang.String r0 = r4.getRequestDataJson(r5)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
        L72:
            r5.setCacheKey(r1)
            return r1
        L76:
            int r5 = com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.BuiltInFictitiousFunctionClassFactory
            int r5 = r5 + 25
            int r1 = r5 % 128
            com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r5 = r5 % 2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.generateCacheKey(com.alipay.imobile.network.quake.Request):java.lang.String");
    }

    private String a(List<com.alipay.imobile.network.quake.i.a> list, String str, SignUtil.SignInfo signInfo) {
        a(list);
        StringBuilder sb = new StringBuilder();
        Iterator<com.alipay.imobile.network.quake.i.a> it = list.iterator();
        while (true) {
            if ((it.hasNext() ? 'C' : 'X') == 'C') {
                int i = BuiltInFictitiousFunctionClassFactory + 81;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 != 0 ? (char) 20 : 'Z') != 20) {
                    com.alipay.imobile.network.quake.i.a next = it.next();
                    sb.append(next.a());
                    sb.append("=");
                    sb.append(next.b());
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                } else {
                    com.alipay.imobile.network.quake.i.a next2 = it.next();
                    sb.append(next2.a());
                    sb.append("=");
                    sb.append(next2.b());
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = BuiltInFictitiousFunctionClassFactory + 43;
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                int i3 = i2 % 2;
            } else {
                LoggerWrapper.v(Quake.TAG, "before sign in SignedJsonProtocolV1");
                return SignUtil.a(f.o().e(), signInfo, str, sb.deleteCharAt(sb.length() - 1).toString());
            }
        }
    }

    private void a(List<com.alipay.imobile.network.quake.i.a> list) {
        Collections.sort(list, new a(this));
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static String a(List<? extends com.alipay.imobile.network.quake.i.a> list, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends com.alipay.imobile.network.quake.i.a> it = list.iterator();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        while (true) {
            if ((it.hasNext() ? (char) 1 : 'W') != 'W') {
                com.alipay.imobile.network.quake.i.a next = it.next();
                String a2 = a(next.a(), str);
                String b = next.b();
                String a3 = (b != null ? JSONLexer.EOI : (char) 0) != 26 ? "" : a(b, str);
                if (sb.length() > 0) {
                    int i3 = BuiltInFictitiousFunctionClassFactory + 65;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    sb.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb.append(a2);
                sb.append("=");
                sb.append(a3);
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        if ((r6 == null ? 'O' : 'G') != 'G') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0022, code lost:
    
        if (r6 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        r1 = new java.lang.Object[1];
        d('5' - android.text.AndroidCharacter.getMirror('0'), android.graphics.Color.alpha(0), (char) (57812 - android.view.KeyEvent.keyCodeFromString("")), r1);
        r6 = ((java.lang.String) r1[0]).intern();
        r0 = com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.BuiltInFictitiousFunctionClassFactory + 7;
        com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
    
        return java.net.URLEncoder.encode(r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        throw new java.lang.IllegalArgumentException(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r5, java.lang.String r6) {
        /*
            int r0 = com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 55
            int r1 = r0 % 128
            com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r1) goto L1f
            r0 = 71
            if (r6 != 0) goto L1a
            r3 = 79
            goto L1c
        L1a:
            r3 = 71
        L1c:
            if (r3 == r0) goto L52
            goto L24
        L1f:
            r0 = 98
            int r0 = r0 / r2
            if (r6 != 0) goto L52
        L24:
            r6 = 48
            char r6 = android.text.AndroidCharacter.getMirror(r6)
            int r6 = 53 - r6
            int r0 = android.graphics.Color.alpha(r2)
            r3 = 57812(0xe1d4, float:8.1012E-41)
            java.lang.String r4 = ""
            int r4 = android.view.KeyEvent.keyCodeFromString(r4)
            int r3 = r3 - r4
            char r3 = (char) r3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            d(r6, r0, r3, r1)
            r6 = r1[r2]
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r6 = r6.intern()
            int r0 = com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 7
            int r1 = r0 % 128
            com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
        L52:
            java.lang.String r5 = java.net.URLEncoder.encode(r5, r6)     // Catch: java.io.UnsupportedEncodingException -> L57
            return r5
        L57:
            r5 = move-exception
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>(r5)
            throw r6
        L5e:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.protocol.json.SignedJsonProtocolV1.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static void d(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i ? 'R' : '3') != 'R') {
                break;
            }
            int i3 = $10 + 121;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            try {
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (MyBillsEntityDataFactory[i2 + whenavailable.BuiltInFictitiousFunctionClassFactory] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getAuthRequestContext))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
                int i5 = $11 + 105;
                $10 = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i) {
                objArr[0] = new String(cArr);
                return;
            }
            int i7 = $11 + 7;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
            int i9 = $11 + 71;
            $10 = i9 % 128;
            int i10 = i9 % 2;
        }
    }
}
