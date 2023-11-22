package id.dana.data.f2fpay.remote;

import com.alipay.iap.android.f2fpay.client.F2FPayDefaultClient;
import com.alipay.iap.android.f2fpay.client.callback.IF2FPaySwitchOnVerifier;
import com.alipay.iap.android.f2fpay.components.IF2FPayInitializeComponent;
import com.alipay.iap.android.f2fpay.components.IF2FPayOpenComponent;
import com.alipay.iap.android.f2fpay.extension.impl.AesCipherOtpInitializeInterceptor;
import com.alipayplus.mobile.component.f2fpay.service.result.F2fpayCheckOpenResult;
import id.dana.data.f2fpay.remote.F2FPayFlow;

/* loaded from: classes4.dex */
public class F2FPayClientImpl extends F2FPayDefaultClient implements IF2FPaySwitchOnVerifier {
    private String publicKey;

    @Override // com.alipay.iap.android.f2fpay.client.F2FPayDefaultClient
    public IF2FPayOpenComponent createOpenComponent() {
        return null;
    }

    public F2FPayClientImpl(String str) {
        this.publicKey = str;
    }

    @Override // com.alipay.iap.android.f2fpay.client.F2FPayDefaultClient
    public void initializeComponents() {
        synchronized (this) {
            super.initializeComponents();
            IF2FPayOpenComponent iF2FPayOpenComponent = (IF2FPayOpenComponent) getComponent(IF2FPayOpenComponent.class);
            ((IF2FPayInitializeComponent) getComponent(IF2FPayInitializeComponent.class)).setInitializeInterceptor(new AesCipherOtpInitializeInterceptor(this.publicKey, CipherConstant.IV_STRING));
        }
    }

    @Override // com.alipay.iap.android.f2fpay.client.callback.IF2FPaySwitchOnVerifier
    public void verifySwitchOnF2FPay(F2fpayCheckOpenResult f2fpayCheckOpenResult, IF2FPaySwitchOnVerifier.Callback callback) {
        F2FPayFlow.setWaitOpenEnv(new F2FPayFlow.OpenEnv(f2fpayCheckOpenResult, callback));
    }
}
