package com.iap.ac.android.common.container.interceptor;

import com.alibaba.ariver.ariverexthub.api.constant.RVEConstant;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BridgeResponse {
    public static final int ERROR_CODE_FORBIDDEN_ERROR = 4;
    public static final int ERROR_CODE_INVALID_PARAM = 2;
    public static final int ERROR_CODE_JAVA_EXCEPTION = 6;
    public static final int ERROR_CODE_NATIVE_NODE_NULL = 30;
    public static final int ERROR_CODE_NOT_FOUND = 1;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_SYSTEM_ERROR = 5;
    public static final int ERROR_CODE_UNAUTHORIZED_USERINFO = 10;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 3;
    public static final int ERROR_CODE_USER_NOT_GRANT = 2001;
    public static final String KEY_SUCCESS = "success";
    public static final String TAG = "BridgeResponse";
    public JSONObject response;
    public static BridgeResponse SUCCESS = new BridgeResponse(null) { // from class: com.iap.ac.android.common.container.interceptor.BridgeResponse.1
        @Override // com.iap.ac.android.common.container.interceptor.BridgeResponse
        public final JSONObject get() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", true);
            } catch (JSONException e) {
                ACLog.e(BridgeResponse.TAG, "put json failed", e);
            }
            return jSONObject;
        }
    };
    public static BridgeResponse NOT_FOUND = new Error(1, RVEConstant.RVEResponse.API_HANDLER_NOT_IMPLEMENTED_ERROR_MSG);
    public static BridgeResponse INVALID_PARAM = new Error(2, RVEConstant.RVEResponse.API_HANDLER_INVALID_ERROR_MSG);
    public static BridgeResponse UNKNOWN_ERROR = new Error(3, "unknown error!");
    public static BridgeResponse FORBIDDEN_ERROR = new Error(4, "forbidden error!");
    public static BridgeResponse UNAUTHORIZED_USERINFO_ERROR = new Error(10, "unauthorized error!");
    public static BridgeResponse NATIVE_NODE_NULL = new Error(10, "native node is null");

    /* loaded from: classes8.dex */
    public static class Error extends BridgeResponse {
        public int errorCode;
        public String errorMessage;

        public Error(int i, String str) {
            super(null);
            this.errorCode = i;
            this.errorMessage = str;
        }

        @Override // com.iap.ac.android.common.container.interceptor.BridgeResponse
        public JSONObject get() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error", this.errorCode);
                jSONObject.put("message", this.errorMessage);
                jSONObject.put("errorMessage", this.errorMessage);
            } catch (JSONException e) {
                ACLog.e(BridgeResponse.TAG, "put json failed", e);
            }
            return jSONObject;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }
    }

    /* loaded from: classes8.dex */
    public static class NamedValue extends BridgeResponse {
        public JSONObject response;

        public NamedValue(String str, Object obj) {
            super(null);
            JSONObject jSONObject = new JSONObject();
            this.response = jSONObject;
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e) {
                ACLog.e(BridgeResponse.TAG, "put json failed", e);
            }
        }

        @Override // com.iap.ac.android.common.container.interceptor.BridgeResponse
        public JSONObject get() {
            return this.response;
        }
    }

    public BridgeResponse() {
    }

    public static Error newError(int i, String str) {
        return new Error(i, str);
    }

    public static NamedValue newValue(String str, Object obj) {
        return new NamedValue(str, obj);
    }

    public JSONObject get() {
        return this.response;
    }

    public BridgeResponse(JSONObject jSONObject) {
        this.response = jSONObject;
    }
}
