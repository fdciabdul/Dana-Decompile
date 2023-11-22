package com.alibaba.griver.base.common.utils;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes2.dex */
public class BridgeUtils {
    public static boolean contextIsValid(BridgeCallback bridgeCallback) {
        if (GriverEnv.getApplicationContext() == null) {
            GriverLogger.w("BridgeUtils", "context is null, callback error");
            if (bridgeCallback != null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                return false;
            }
            return false;
        }
        return true;
    }
}
