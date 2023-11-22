package com.iap.ac.android.biz.b;

import com.alibaba.griver.api.common.GriverExtensionManifest;
import com.alibaba.griver.api.common.account.GriverAccountExtension;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.GriverInitializeCallback;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.InitCallback;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.InitErrorCode;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes3.dex */
public final class b extends GriverInitializeCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InitCallback f7539a;

    /* loaded from: classes3.dex */
    public class a implements GriverAccountExtension {
        public a(b bVar) {
        }

        @Override // com.alibaba.griver.api.common.account.GriverAccountExtension
        public String getUserId() {
            return SPIManager.getInstance().getOpenId();
        }
    }

    public b(InitCallback initCallback) {
        this.f7539a = initCallback;
    }

    @Override // com.alibaba.griver.core.GriverInitializeCallback
    public final void onInitializeFailed(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("initGriver callback, initGriver fail: ");
        sb.append(i);
        sb.append(", errorMessage: ");
        sb.append(str);
        ACLog.i(Constants.TAG, sb.toString());
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_AC_COMMON_INIT_GRIVER).addParams("sdkVersion", ACManager.getInstance().getIapConnectVersion()).addParams("result", LogConstants.RESULT_FALSE).addParams("resultMessage", str).event();
        if (this.f7539a != null) {
            InitErrorCode initErrorCode = InitErrorCode.INITIALIZE_UNKNOWN_EXCEPTION;
            if (i == 90001) {
                initErrorCode = InitErrorCode.INITIALIZE_AUTHENTICATION_FAILED;
            } else if (i == 90002) {
                initErrorCode = InitErrorCode.INITIALIZE_PARAM_ILLEGAL;
            }
            this.f7539a.onFailure(initErrorCode, str);
        }
    }

    @Override // com.alibaba.griver.core.GriverInitializeCallback
    public final void onInitializedSuccess() {
        ACLog.i(Constants.TAG, "initGriver callback, initGriver success");
        ACLogEvent.newLogger("iapconnect_center", LogConstants.EVENT_ID_AC_COMMON_INIT_GRIVER).addParams("sdkVersion", ACManager.getInstance().getIapConnectVersion()).addParams("result", "T").event();
        Griver.registerExtension(new GriverExtensionManifest(GriverAccountExtension.class, new a(this)));
        InitCallback initCallback = this.f7539a;
        if (initCallback != null) {
            initCallback.onSuccess();
        }
    }
}
