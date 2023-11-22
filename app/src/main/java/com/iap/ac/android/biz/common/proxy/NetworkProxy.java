package com.iap.ac.android.biz.common.proxy;

import android.content.Context;
import com.iap.ac.android.common.account.ACUserInfo;
import com.iap.ac.android.common.account.ACUserInfoManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.http.HttpTransportFactory;
import com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport;
import com.iap.ac.android.common.rpc.model.HttpRequest;
import com.iap.ac.android.common.rpc.model.HttpResponse;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class NetworkProxy {
    public static final String HTTP_HEADER_KEY_AC_USER_ID = "Ac-UserId";
    public static final String TAG = "NetworkProxy";
    public static NetworkProxy mInstance;

    private HttpTransportFactory.Creater createHttpTransporter(final HttpTransporter httpTransporter) {
        return new HttpTransportFactory.Creater() { // from class: com.iap.ac.android.biz.common.proxy.NetworkProxy.1
            @Override // com.iap.ac.android.common.rpc.http.HttpTransportFactory.Creater
            public AbstractHttpTransport createHttpTransport(Context context) throws Exception {
                return new AbstractHttpTransport() { // from class: com.iap.ac.android.biz.common.proxy.NetworkProxy.1.1
                    private void handleRequest(HttpRequest httpRequest) {
                    }

                    private void handleResponse(HttpResponse httpResponse) {
                        Map<String, List<String>> map = httpResponse.headers;
                        if (map != null && map.containsKey(NetworkProxy.HTTP_HEADER_KEY_AC_USER_ID)) {
                            List<String> list = map.get(NetworkProxy.HTTP_HEADER_KEY_AC_USER_ID);
                            if (list != null && !list.isEmpty()) {
                                ACUserInfo aCUserInfo = new ACUserInfo();
                                aCUserInfo.openId = list.get(0);
                                ACUserInfoManager.getInstance("ac_biz").setUserInfo(aCUserInfo);
                                StringBuilder sb = new StringBuilder();
                                sb.append("resolve user id: ");
                                sb.append(aCUserInfo.openId);
                                ACLog.d(NetworkProxy.TAG, sb.toString());
                                return;
                            }
                            ACLog.d(NetworkProxy.TAG, "can not resolve user id from header");
                            return;
                        }
                        ACLog.d(NetworkProxy.TAG, "can not resolve user id key");
                    }

                    @Override // com.iap.ac.android.common.rpc.interfaces.AbstractHttpTransport
                    public HttpResponse performRequest(HttpRequest httpRequest) throws Exception {
                        ACLog.d(NetworkProxy.TAG, "performRequest");
                        handleRequest(httpRequest);
                        HttpResponse sendHttpRequest = httpTransporter.sendHttpRequest(httpRequest);
                        handleResponse(sendHttpRequest);
                        return sendHttpRequest;
                    }
                };
            }
        };
    }

    public static NetworkProxy getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkProxy();
        }
        return mInstance;
    }

    public void setHttpTransporter(HttpTransporter httpTransporter) throws IllegalArgumentException {
        if (httpTransporter != null) {
            ACLog.i(TAG, "set network proxy");
            HttpTransportFactory.setCreater(createHttpTransporter(httpTransporter), "ac_biz");
            return;
        }
        ACLog.e(TAG, "HttpTransporter proxy can not be null");
        throw new IllegalArgumentException("HttpTransporter proxy can not be null");
    }
}
