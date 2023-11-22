package id.dana.domain.carrieridentification.interactor;

import android.app.Activity;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.carrieridentification.model.GetAuthCodeResponse;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/carrieridentification/interactor/CheckIpificationAuthCode;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/carrieridentification/model/GetAuthCodeResponse;", "Lid/dana/domain/carrieridentification/interactor/CheckIpificationAuthCode$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/carrieridentification/interactor/CheckIpificationAuthCode$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "carrierIdentificationRepository", "Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;", "<init>", "(Lid/dana/domain/carrieridentification/CarrierIdentificationRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckIpificationAuthCode extends BaseUseCase<GetAuthCodeResponse, Params> {
    private final CarrierIdentificationRepository carrierIdentificationRepository;

    @Inject
    public CheckIpificationAuthCode(CarrierIdentificationRepository carrierIdentificationRepository) {
        Intrinsics.checkNotNullParameter(carrierIdentificationRepository, "");
        this.carrierIdentificationRepository = carrierIdentificationRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<GetAuthCodeResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.carrierIdentificationRepository.getIPificationAuthCode(params.getActivity(), params.getSecurityId(), params.getPhoneNumber(), params.getRedirectUri());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001c\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001d\u0010\u0007"}, d2 = {"Lid/dana/domain/carrieridentification/interactor/CheckIpificationAuthCode$Params;", "", "Landroid/app/Activity;", "component1", "()Landroid/app/Activity;", "", "component2", "()Ljava/lang/String;", "component3", "component4", AkuEventParamsKey.KEY_ACTIVITY, BioUtilityBridge.SECURITY_ID, "phoneNumber", "redirectUri", "copy", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/carrieridentification/interactor/CheckIpificationAuthCode$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Landroid/app/Activity;", "getActivity", "Ljava/lang/String;", "getPhoneNumber", "getRedirectUri", "getSecurityId", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final Activity activity;
        private final String phoneNumber;
        private final String redirectUri;
        private final String securityId;

        public static /* synthetic */ Params copy$default(Params params, Activity activity, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                activity = params.activity;
            }
            if ((i & 2) != 0) {
                str = params.securityId;
            }
            if ((i & 4) != 0) {
                str2 = params.phoneNumber;
            }
            if ((i & 8) != 0) {
                str3 = params.redirectUri;
            }
            return params.copy(activity, str, str2, str3);
        }

        /* renamed from: component1  reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        /* renamed from: component2  reason: from getter */
        public final String getSecurityId() {
            return this.securityId;
        }

        /* renamed from: component3  reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* renamed from: component4  reason: from getter */
        public final String getRedirectUri() {
            return this.redirectUri;
        }

        public final Params copy(Activity activity, String securityId, String phoneNumber, String redirectUri) {
            Intrinsics.checkNotNullParameter(activity, "");
            Intrinsics.checkNotNullParameter(securityId, "");
            Intrinsics.checkNotNullParameter(phoneNumber, "");
            Intrinsics.checkNotNullParameter(redirectUri, "");
            return new Params(activity, securityId, phoneNumber, redirectUri);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.activity, params.activity) && Intrinsics.areEqual(this.securityId, params.securityId) && Intrinsics.areEqual(this.phoneNumber, params.phoneNumber) && Intrinsics.areEqual(this.redirectUri, params.redirectUri);
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.activity.hashCode() * 31) + this.securityId.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + this.redirectUri.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(activity=");
            sb.append(this.activity);
            sb.append(", securityId=");
            sb.append(this.securityId);
            sb.append(", phoneNumber=");
            sb.append(this.phoneNumber);
            sb.append(", redirectUri=");
            sb.append(this.redirectUri);
            sb.append(')');
            return sb.toString();
        }

        public Params(Activity activity, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(activity, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.activity = activity;
            this.securityId = str;
            this.phoneNumber = str2;
            this.redirectUri = str3;
        }

        @JvmName(name = "getActivity")
        public final Activity getActivity() {
            return this.activity;
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
    }
}
