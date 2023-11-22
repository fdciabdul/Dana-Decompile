package com.iap.ac.android.biz.common.proxy.common;

import android.content.Context;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.http.HttpTransportFactory;
import com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class HttpTransportCreatorUtils {

    /* loaded from: classes3.dex */
    public static class CommonNetworkProxyHttpTransport implements AbstractHttpTransport {
        public final NetworkProxy proxy;
        public final ProxyScene proxyScene;

        private String assembleHeader2Str(Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (this.proxyScene == ProxyScene.PROXY_SCENE_MINI_PROGRAM) {
                map.put("AppId", "GMP_ECO_REGION");
            }
            return JsonUtils.toJson(map);
        }

        private void eventTrack(HttpProxyRequestInfo httpProxyRequestInfo, HttpProxyResponseInfo httpProxyResponseInfo) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            str = "";
            if (httpProxyRequestInfo != null) {
                str3 = httpProxyRequestInfo.getRequestHeader() == null ? "" : httpProxyRequestInfo.getRequestHeader();
                str2 = httpProxyRequestInfo.getProxyRequestData() == null ? "" : httpProxyRequestInfo.getProxyRequestData();
            } else {
                str2 = "";
                str3 = str2;
            }
            if (httpProxyResponseInfo != null) {
                String proxyResponseHeader = httpProxyResponseInfo.getProxyResponseHeader() == null ? "" : httpProxyResponseInfo.getProxyResponseHeader();
                str5 = httpProxyResponseInfo.getProxyResponseData() == null ? "" : httpProxyResponseInfo.getProxyResponseData();
                str4 = httpProxyResponseInfo.getErrorCode() != null ? httpProxyResponseInfo.getErrorCode() : "";
                str = proxyResponseHeader;
            } else {
                str4 = "";
                str5 = str4;
            }
            ACLogEvent.newLogger("iapconnect_center", "ac_region_rpc_spi_call_record").addParams("proxyRequestHeader", str3).addParams("proxyRequestData", str2).addParams("proxyResponseHeader", str).addParams("proxyResponseData", str5).addParams("errorCode", str4).event();
        }

        private Map<String, List<String>> headerStr2Map(String str) {
            Map map;
            HashMap hashMap = new HashMap();
            try {
                map = (Map) JsonUtils.fromJson(str, Map.class);
            } catch (Exception e) {
                ACLog.e(Constants.TAG, e.getMessage());
            }
            if (map == null) {
                return hashMap;
            }
            for (Object obj : map.keySet()) {
                if (obj != null || (obj instanceof String)) {
                    List list = (List) hashMap.get(obj);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(obj.toString(), list);
                    }
                    Object obj2 = map.get(obj);
                    if (obj2 instanceof String) {
                        list.add(obj2 == null ? "" : obj2.toString());
                    } else if (obj2 instanceof List) {
                        list.addAll((List) obj2);
                    }
                }
            }
            return hashMap;
        }

        @Override // com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport
        public HttpResponse performRequest(HttpRequest httpRequest) throws Exception {
            HttpResponse httpResponse;
            ACLog.d(Constants.TAG, "performRequest");
            HttpProxyRequestInfo httpProxyRequestInfo = new HttpProxyRequestInfo();
            httpProxyRequestInfo.setRequestHeader(assembleHeader2Str(httpRequest.headers));
            httpProxyRequestInfo.setProxyRequestData(httpRequest.data);
            httpProxyRequestInfo.setScene(this.proxyScene);
            HttpProxyResponseInfo sendHttpRequest = this.proxy.sendHttpRequest(httpProxyRequestInfo);
            if (sendHttpRequest == null) {
                httpResponse = new HttpResponse(500, "proxy request fail:common network proxy SPI return null", null, null);
            } else {
                httpResponse = new HttpResponse(200, "request success", (sendHttpRequest.getProxyResponseData() == null ? "{}" : sendHttpRequest.getProxyResponseData()).toString().getBytes(), headerStr2Map(sendHttpRequest.getProxyResponseHeader()));
            }
            eventTrack(httpProxyRequestInfo, sendHttpRequest);
            return httpResponse;
        }

        public CommonNetworkProxyHttpTransport(NetworkProxy networkProxy, ProxyScene proxyScene) {
            this.proxy = networkProxy;
            this.proxyScene = proxyScene;
        }
    }

    public static HttpTransportFactory.Creater createHttpTransporter(final NetworkProxy networkProxy, final ProxyScene proxyScene) {
        return new HttpTransportFactory.Creater() { // from class: com.iap.ac.android.biz.common.proxy.common.HttpTransportCreatorUtils.1
            @Override // com.iap.ac.android.common.rpc.http.HttpTransportFactory.Creater
            public final AbstractHttpTransport createHttpTransport(Context context) throws Exception {
                return new CommonNetworkProxyHttpTransport(NetworkProxy.this, proxyScene);
            }
        };
    }
}
