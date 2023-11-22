package com.alibaba.ariver.ariverexthub.api;

import com.alibaba.ariver.ariverexthub.api.constant.RVEConstant;
import com.alibaba.ariver.ariverexthub.api.provider.RVEApiResponseCallback;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class RVEApiHandler {

    /* loaded from: classes3.dex */
    public enum Error {
        NONE,
        NOT_FOUND,
        INVALID_PARAM,
        UNKNOWN_ERROR,
        FORBIDDEN,
        INIT_FAILE,
        API_NOT_HANDLED
    }

    public void onDestory() {
    }

    public void onInitialized() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.ariver.ariverexthub.api.RVEApiHandler$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$ariverexthub$api$RVEApiHandler$Error;

        static {
            int[] iArr = new int[Error.values().length];
            $SwitchMap$com$alibaba$ariver$ariverexthub$api$RVEApiHandler$Error = iArr;
            try {
                iArr[Error.NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$ariverexthub$api$RVEApiHandler$Error[Error.INVALID_PARAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$ariverexthub$api$RVEApiHandler$Error[Error.UNKNOWN_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$ariverexthub$api$RVEApiHandler$Error[Error.FORBIDDEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$ariverexthub$api$RVEApiHandler$Error[Error.INIT_FAILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$ariverexthub$api$RVEApiHandler$Error[Error.API_NOT_HANDLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static String getErrorMsg(Error error) {
        switch (AnonymousClass1.$SwitchMap$com$alibaba$ariver$ariverexthub$api$RVEApiHandler$Error[error.ordinal()]) {
            case 1:
                return RVEConstant.RVEResponse.API_HANDLER_NOT_IMPLEMENTED_ERROR_MSG;
            case 2:
                return RVEConstant.RVEResponse.API_HANDLER_INVALID_ERROR_MSG;
            case 3:
                return "unknown error!";
            case 4:
                return RVEConstant.RVEResponse.API_HANDLER_FORBIDDEN_ERROR_MSG;
            case 5:
                return RVEConstant.RVEResponse.API_HANDLER_INSTANCE_ERROR_MSG;
            case 6:
                return RVEConstant.RVEResponse.API_HANDLER_NOT_HANDLED_ERROR_MSG;
            default:
                return RVEConstant.RVEResponse.API_HANDLER_NONE_ERROR_MSG;
        }
    }

    public static void sendError(RVEApiResponseCallback rVEApiResponseCallback, Error error) {
        if (rVEApiResponseCallback == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) Integer.valueOf(error.ordinal()));
        jSONObject.put("errorMessage", (Object) getErrorMsg(error));
        rVEApiResponseCallback.onResult(jSONObject);
    }

    public void sendError(int i, String str, RVEApiResponseCallback rVEApiResponseCallback) {
        if (rVEApiResponseCallback == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) Integer.valueOf(i));
        jSONObject.put("errorMessage", (Object) str);
        rVEApiResponseCallback.onResult(jSONObject);
    }

    public static void sendSuccess(RVEApiResponseCallback rVEApiResponseCallback) {
        if (rVEApiResponseCallback == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        rVEApiResponseCallback.onResult(jSONObject);
    }
}
