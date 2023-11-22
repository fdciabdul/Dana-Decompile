package com.alibaba.griver.device.jsapi.vibrate;

import android.os.Vibrator;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes2.dex */
public class VibrateBridgeExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6525a = "com.alibaba.griver.device.jsapi.vibrate.VibrateBridgeExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    private static BridgeResponse a(int i) {
        try {
            Vibrator vibrator = (Vibrator) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(i);
            }
            return BridgeResponse.SUCCESS;
        } catch (Throwable th) {
            RVLogger.e(f6525a, th);
            return BridgeResponse.UNKNOWN_ERROR;
        }
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse vibrateLong() {
        return a(400);
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse vibrate() {
        return a(400);
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse vibrateShort() {
        return a(40);
    }
}
