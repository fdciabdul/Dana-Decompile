package id.dana.domain.carrieridentification;

import android.app.Activity;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeLogger;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.carrieridentification.model.CheckCoverageResponse;
import id.dana.domain.carrieridentification.model.GetAuthCodeResponse;
import id.dana.domain.carrieridentification.model.VerifySecurityProduct;
import id.dana.domain.otp.model.VerifyOtpRiskResponse;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J.\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H&J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0006H&JL\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0018H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "", "checkIPificationCoverage", "Lio/reactivex/Single;", "Lid/dana/domain/carrieridentification/model/CheckCoverageResponse;", "phoneNumber", "", "getIPificationAuthCode", "Lio/reactivex/Observable;", "Lid/dana/domain/carrieridentification/model/GetAuthCodeResponse;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", BioUtilityBridge.SECURITY_ID, "redirectUri", "verifyIpificationAuthCode", "Lid/dana/domain/twilio/model/VerifySecurityInfo;", "verifySecurityProduct", "Lid/dana/domain/carrieridentification/model/VerifySecurityProduct;", "verifyOtpToRisk", "Lid/dana/domain/otp/model/VerifyOtpRiskResponse;", "otpValue", CashierKeyParams.VERIFICATION_METHOD, "sendOtpStrategy", ApiDowngradeLogger.EXT_KEY_EXT_PARAMS, "", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CarrierIdentificationRepository {
    Single<CheckCoverageResponse> checkIPificationCoverage(String phoneNumber);

    Observable<GetAuthCodeResponse> getIPificationAuthCode(Activity activity, String securityId, String phoneNumber, String redirectUri);

    Observable<VerifySecurityInfo> verifyIpificationAuthCode(VerifySecurityProduct verifySecurityProduct, String redirectUri);

    Observable<VerifyOtpRiskResponse> verifyOtpToRisk(String otpValue, String securityId, String phoneNumber, String verificationMethod, String sendOtpStrategy, Map<String, String> extParams);

    /* renamed from: id.dana.domain.carrieridentification.CarrierIdentificationRepository$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable verifyOtpToRisk$default(CarrierIdentificationRepository carrierIdentificationRepository, String str, String str2, String str3, String str4, String str5, Map map, int i, Object obj) {
            if (obj == null) {
                Map map2 = map;
                if ((i & 32) != 0) {
                    map2 = MapsKt.emptyMap();
                }
                return carrierIdentificationRepository.verifyOtpToRisk(str, str2, str3, str4, str5, map2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: verifyOtpToRisk");
        }
    }
}
