package id.dana.data.f2fpay.extensions;

import android.content.Context;
import com.alipay.iap.android.f2fpay.extension.impl.DefaultPaymentCodeGeneratorImpl;
import com.alipay.iap.android.f2fpay.otp.F2FPayOtpInfo;
import id.dana.data.config.repository.FeatureConfigEntityRepository;

/* loaded from: classes4.dex */
public class PaymentCodeGeneratorImpl extends DefaultPaymentCodeGeneratorImpl {
    FeatureConfigEntityRepository featureConfigEntityRepository;

    public PaymentCodeGeneratorImpl(FeatureConfigEntityRepository featureConfigEntityRepository) {
        this.featureConfigEntityRepository = featureConfigEntityRepository;
    }

    @Override // com.alipay.iap.android.f2fpay.extension.impl.DefaultPaymentCodeGeneratorImpl, com.alipay.iap.android.f2fpay.extension.IF2FPayPaymentCodeGenerator
    public String generateCode(Context context, F2FPayOtpInfo f2FPayOtpInfo, long j, Object obj) {
        String generateCode = super.generateCode(context, f2FPayOtpInfo, j, obj);
        if (this.featureConfigEntityRepository.getPaymentCodeDigit().blockingFirst().intValue() == 20) {
            StringBuilder sb = new StringBuilder();
            sb.append(generateCode.substring(0, 2));
            sb.append(generateCode.substring(6));
            return sb.toString();
        }
        return generateCode;
    }
}
