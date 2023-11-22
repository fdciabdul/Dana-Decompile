package id.dana.data.f2fpay.remote;

import com.alipay.iap.android.f2fpay.client.callback.IF2FPaySwitchOnVerifier;
import com.alipayplus.mobile.component.f2fpay.service.result.F2fpayCheckOpenResult;

/* loaded from: classes4.dex */
public class F2FPayFlow {
    private static OpenEnv waitOpenEnv;

    public static OpenEnv getWaitOpenEnv() {
        return waitOpenEnv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setWaitOpenEnv(OpenEnv openEnv) {
        waitOpenEnv = openEnv;
    }

    /* loaded from: classes4.dex */
    static class OpenEnv {
        IF2FPaySwitchOnVerifier.Callback MyBillsEntityDataFactory;
        F2fpayCheckOpenResult getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OpenEnv(F2fpayCheckOpenResult f2fpayCheckOpenResult, IF2FPaySwitchOnVerifier.Callback callback) {
            this.getAuthRequestContext = f2fpayCheckOpenResult;
            this.MyBillsEntityDataFactory = callback;
        }
    }
}
