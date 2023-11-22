package id.dana.data.f2fpay.mock;

import android.text.TextUtils;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.alipay.iap.android.f2fpay.extension.impl.DefaultSecureStorageImpl;
import com.alipay.iap.android.f2fpay.otp.F2FPayOtpInfo;

/* loaded from: classes8.dex */
public class MockSecurityStorage extends DefaultSecureStorageImpl {
    private static final String DEVICE_ID = "993006E12D4C6E5FDEEF27EB59DACBDDFC8F4AFDCC64D26E05C61B31927B195F";

    @Override // com.alipay.iap.android.f2fpay.extension.impl.DefaultSecureStorageImpl, com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage
    public void saveOtpInfo(F2FPayOtpInfo f2FPayOtpInfo, String str) {
        String userId = UserInfoManager.instance().getUserId();
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(DEVICE_ID)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append(DEVICE_ID);
        super.saveOtpInfo(new F2FPayOtpInfo("773071", "12345678123456781234567812345678", 3), sb.toString());
    }

    @Override // com.alipay.iap.android.f2fpay.extension.impl.DefaultSecureStorageImpl, com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage
    public F2FPayOtpInfo getOtpInfoByIdentity(String str) {
        String userId = UserInfoManager.instance().getUserId();
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(DEVICE_ID)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append(DEVICE_ID);
        return super.getOtpInfoByIdentity(sb.toString());
    }

    @Override // com.alipay.iap.android.f2fpay.extension.impl.DefaultSecureStorageImpl, com.alipay.iap.android.f2fpay.extension.IF2FPaySecureStorage
    public boolean checkOtpInfoExist(String str) {
        String userId = UserInfoManager.instance().getUserId();
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(DEVICE_ID)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append(DEVICE_ID);
        return super.checkOtpInfoExist(sb.toString());
    }
}
