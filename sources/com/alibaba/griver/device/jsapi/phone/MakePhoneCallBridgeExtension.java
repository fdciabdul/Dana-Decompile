package com.alibaba.griver.device.jsapi.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.CommonUtils;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes2.dex */
public class MakePhoneCallBridgeExtension implements BridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6512a = "com.alibaba.griver.device.jsapi.phone.MakePhoneCallBridgeExtension";

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

    private static void a(Activity activity, Intent intent) {
        if (intent == null || activity == null) {
            return;
        }
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            RVLogger.e(f6512a, "startActivity exception", e);
        }
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse makePhoneCall(@BindingParam({"number"}) String str) {
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.INVALID_PARAM;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("tel:");
        sb.append(Uri.encode(str));
        Uri parseUrl = CommonUtils.parseUrl(sb.toString());
        if (parseUrl == null) {
            return BridgeResponse.INVALID_PARAM;
        }
        Intent intent = new Intent("android.intent.action.VIEW", parseUrl);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getTopActivity().get(), intent);
            return BridgeResponse.SUCCESS;
        } catch (Throwable unused) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
    }
}
