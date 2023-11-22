package id.dana.domain.carrieridentification.interactor;

import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.login.source.network.model.VerifyMethod;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.carrieridentification.model.VerifySecurityProduct;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.twilio.model.VerifySecurityInfo;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/domain/carrieridentification/interactor/VerifyIpificationAuthCode;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/twilio/model/VerifySecurityInfo;", "Lid/dana/domain/carrieridentification/interactor/VerifyIpificationAuthCode$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/carrieridentification/interactor/VerifyIpificationAuthCode$Params;)Lio/reactivex/Observable;", "", "", "char", "", "index", "addCharAtIndex", "(Ljava/lang/String;CI)Ljava/lang/String;", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "carrierIdentificationRepository", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "<init>", "(Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyIpificationAuthCode extends BaseUseCase<VerifySecurityInfo, Params> {
    private final CarrierIdentificationRepository carrierIdentificationRepository;

    @Inject
    public VerifyIpificationAuthCode(CarrierIdentificationRepository carrierIdentificationRepository) {
        Intrinsics.checkNotNullParameter(carrierIdentificationRepository, "");
        this.carrierIdentificationRepository = carrierIdentificationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<VerifySecurityInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        String replace$default = StringsKt.replace$default(params.getPhoneNumber(), "+", "", false, 4, (Object) null);
        CarrierIdentificationRepository carrierIdentificationRepository = this.carrierIdentificationRepository;
        String securityId = params.getSecurityId();
        String addCharAtIndex = addCharAtIndex(replace$default, '-', 2);
        return carrierIdentificationRepository.verifyIpificationAuthCode(new VerifySecurityProduct(null, securityId, VerifyMethod.CARRIER_IDENTIFICATION, params.getAuthCode(), null, addCharAtIndex, 17, null), params.getRedirectUri());
    }

    private final String addCharAtIndex(String str, char c, int i) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(i, c);
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/carrieridentification/interactor/VerifyIpificationAuthCode$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", BioUtilityBridge.SECURITY_ID, "phoneNumber", "redirectUri", "authCode", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/carrieridentification/interactor/VerifyIpificationAuthCode$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", Constants.JS_API_GET_AUTH_CODE, "getPhoneNumber", "getRedirectUri", "getSecurityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String authCode;
        private final String phoneNumber;
        private final String redirectUri;
        private final String securityId;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.securityId;
            }
            if ((i & 2) != 0) {
                str2 = params.phoneNumber;
            }
            if ((i & 4) != 0) {
                str3 = params.redirectUri;
            }
            if ((i & 8) != 0) {
                str4 = params.authCode;
            }
            return params.copy(str, str2, str3, str4);
        }

        /* renamed from: component1  reason: from getter */
        public final String getSecurityId() {
            return this.securityId;
        }

        /* renamed from: component2  reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* renamed from: component3  reason: from getter */
        public final String getRedirectUri() {
            return this.redirectUri;
        }

        /* renamed from: component4  reason: from getter */
        public final String getAuthCode() {
            return this.authCode;
        }

        public final Params copy(String securityId, String phoneNumber, String redirectUri, String authCode) {
            Intrinsics.checkNotNullParameter(securityId, "");
            Intrinsics.checkNotNullParameter(phoneNumber, "");
            Intrinsics.checkNotNullParameter(redirectUri, "");
            Intrinsics.checkNotNullParameter(authCode, "");
            return new Params(securityId, phoneNumber, redirectUri, authCode);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.securityId, params.securityId) && Intrinsics.areEqual(this.phoneNumber, params.phoneNumber) && Intrinsics.areEqual(this.redirectUri, params.redirectUri) && Intrinsics.areEqual(this.authCode, params.authCode);
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.securityId.hashCode() * 31) + this.phoneNumber.hashCode()) * 31) + this.redirectUri.hashCode()) * 31) + this.authCode.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(securityId=");
            sb.append(this.securityId);
            sb.append(", phoneNumber=");
            sb.append(this.phoneNumber);
            sb.append(", redirectUri=");
            sb.append(this.redirectUri);
            sb.append(", authCode=");
            sb.append(this.authCode);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.securityId = str;
            this.phoneNumber = str2;
            this.redirectUri = str3;
            this.authCode = str4;
        }

        @JvmName(name = "getSecurityId")
        public final String getSecurityId() {
            return this.securityId;
        }

        @JvmName(name = "getPhoneNumber")
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        @JvmName(name = "getRedirectUri")
        public final String getRedirectUri() {
            return this.redirectUri;
        }

        @JvmName(name = Constants.JS_API_GET_AUTH_CODE)
        public final String getAuthCode() {
            return this.authCode;
        }
    }
}
