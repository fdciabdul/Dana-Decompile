package id.dana.domain.login.interactor;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.foundation.logger.LoginScenarioConstant;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.model.rpc.response.LoginResponse;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/login/interactor/TrustRiskLogin;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/model/rpc/response/LoginResponse;", "Lid/dana/domain/login/interactor/TrustRiskLogin$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/login/interactor/TrustRiskLogin$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/login/LoginRepository;", "loginRepository", "Lid/dana/domain/login/LoginRepository;", "<init>", "(Lid/dana/domain/login/LoginRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TrustRiskLogin extends BaseUseCase<LoginResponse, Params> {
    private final LoginRepository loginRepository;

    @Inject
    public TrustRiskLogin(LoginRepository loginRepository) {
        Intrinsics.checkNotNullParameter(loginRepository, "");
        this.loginRepository = loginRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<LoginResponse> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<LoginResponse> login = this.loginRepository.login(LoginScenarioConstant.TRUSTRISKLOGIN, params.getPin(), params.getSecurityId(), params.isWhatsAppInstalled());
        Intrinsics.checkNotNullExpressionValue(login, "");
        return login;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/domain/login/interactor/TrustRiskLogin$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Z", "pin", BioUtilityBridge.SECURITY_ID, "isWhatsAppInstalled", "copy", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/login/interactor/TrustRiskLogin$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "Ljava/lang/String;", "getPin", "getSecurityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final boolean isWhatsAppInstalled;
        private final String pin;
        private final String securityId;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.pin;
            }
            if ((i & 2) != 0) {
                str2 = params.securityId;
            }
            if ((i & 4) != 0) {
                z = params.isWhatsAppInstalled;
            }
            return params.copy(str, str2, z);
        }

        /* renamed from: component1  reason: from getter */
        public final String getPin() {
            return this.pin;
        }

        /* renamed from: component2  reason: from getter */
        public final String getSecurityId() {
            return this.securityId;
        }

        /* renamed from: component3  reason: from getter */
        public final boolean getIsWhatsAppInstalled() {
            return this.isWhatsAppInstalled;
        }

        public final Params copy(String pin, String securityId, boolean isWhatsAppInstalled) {
            Intrinsics.checkNotNullParameter(pin, "");
            Intrinsics.checkNotNullParameter(securityId, "");
            return new Params(pin, securityId, isWhatsAppInstalled);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.pin, params.pin) && Intrinsics.areEqual(this.securityId, params.securityId) && this.isWhatsAppInstalled == params.isWhatsAppInstalled;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.pin.hashCode();
            int hashCode2 = this.securityId.hashCode();
            boolean z = this.isWhatsAppInstalled;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((hashCode * 31) + hashCode2) * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(pin=");
            sb.append(this.pin);
            sb.append(", securityId=");
            sb.append(this.securityId);
            sb.append(", isWhatsAppInstalled=");
            sb.append(this.isWhatsAppInstalled);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.pin = str;
            this.securityId = str2;
            this.isWhatsAppInstalled = z;
        }

        public /* synthetic */ Params(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? false : z);
        }

        @JvmName(name = "getPin")
        public final String getPin() {
            return this.pin;
        }

        @JvmName(name = "getSecurityId")
        public final String getSecurityId() {
            return this.securityId;
        }

        @JvmName(name = "isWhatsAppInstalled")
        public final boolean isWhatsAppInstalled() {
            return this.isWhatsAppInstalled;
        }
    }
}
