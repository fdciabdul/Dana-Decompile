package com.ap.zoloz.hummer.connect.h5;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.security.bio.utils.StringUtil;
import com.ap.zoloz.hummer.biz.HummerLogger;
import com.ap.zoloz.hummer.connect.api.ConnectFacade;
import com.ap.zoloz.hummer.connect.api.ConnectRequest;
import com.ap.zoloz.hummer.connect.api.ConnectResponse;
import com.ap.zoloz.hummer.connect.api.IConnectCallback;
import com.ap.zoloz.hummer.h5.IH5HandlerCallback;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class ZolozConnectH5Handler {
    public static final String TAG = "ZolozConnectH5Handler";
    public static final String ZIM_IDENTIFY_ACTION = "action";
    public static final String ZIM_IDENTIFY_BIZCONFIG = "bizParam";
    public static final String ZIM_IDENTIFY_CLIENT_CONFIG = "clientConfig";
    public static final String ZIM_IDENTIFY_CONNECT_ID = "connectId";
    public static final String ZIM_IDENTIFY_START_CONNECT = "startConnect";

    public void identify(JSONObject jSONObject, Context context, final IH5HandlerCallback iH5HandlerCallback) {
        if (jSONObject == null || context == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" jsapi");
        sb.append(jSONObject.toJSONString());
        HummerLogger.i(TAG, sb.toString());
        String string = jSONObject.getString("action");
        if (!StringUtil.isNullorEmpty(string) && ZIM_IDENTIFY_START_CONNECT.equals(string)) {
            ConnectFacade connectFacade = ConnectFacade.getInstance();
            connectFacade.setContext(context);
            String string2 = jSONObject.getString("connectId");
            ConnectRequest connectRequest = new ConnectRequest();
            connectRequest.connectId = string2;
            JSONObject jSONObject2 = jSONObject.getJSONObject("bizParam");
            Map<? extends String, ? extends Object> hashMap = new HashMap<>();
            if (jSONObject2 != null && jSONObject2.size() > 0) {
                hashMap = (Map) JSONObject.toJavaObject(jSONObject2, Map.class);
            } else {
                String string3 = jSONObject.getString("bizParam");
                if (!StringUtil.isNullorEmpty(string3)) {
                    hashMap = (Map) JSON.parseObject(string3, Map.class);
                }
            }
            connectRequest.bizConfig.putAll(hashMap);
            connectRequest.connectConfig = jSONObject.getString(ZIM_IDENTIFY_CLIENT_CONFIG);
            connectFacade.startConnect(connectRequest, new IConnectCallback() { // from class: com.ap.zoloz.hummer.connect.h5.ZolozConnectH5Handler.1
                @Override // com.ap.zoloz.hummer.connect.api.IConnectCallback
                public void onCompletion(ConnectResponse connectResponse) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("code", (Object) Integer.valueOf(connectResponse.code));
                    jSONObject3.put("subCode", (Object) connectResponse.subCode);
                    jSONObject3.put("result", (Object) connectResponse.result);
                    if (connectResponse.extInfo != null) {
                        jSONObject3.put("extInfo", (Object) connectResponse.extInfo);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(" connect response ");
                    sb2.append(jSONObject3.toString());
                    HummerLogger.i(ZolozConnectH5Handler.TAG, sb2.toString());
                    iH5HandlerCallback.onCompletion(jSONObject3);
                }
            });
        }
    }
}
