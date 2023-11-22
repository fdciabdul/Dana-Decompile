package id.dana.domain.oauth.interactor;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B%\b\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/oauth/interactor/GnAuthApply;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/authcode/AuthCodeResult;", "Lid/dana/domain/oauth/interactor/GnAuthApply$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/oauth/interactor/GnAuthApply$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/oauth/repository/OauthRepository;", "oauthRepository", "Lid/dana/domain/oauth/repository/OauthRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/oauth/repository/OauthRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GnAuthApply extends UseCase<AuthCodeResult, Params> {
    private final OauthRepository oauthRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GnAuthApply(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OauthRepository oauthRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(oauthRepository, "");
        this.oauthRepository = oauthRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<AuthCodeResult> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<AuthCodeResult> submitGnAuthApply = this.oauthRepository.submitGnAuthApply(params.getState(), params.getClientId(), params.getScopes(), params.getRedirectUrl(), params.getNetAuthId(), params.getSubMerchantId(), params.getSecurityId(), params.getRequestSourceType());
        Intrinsics.checkNotNullExpressionValue(submitGnAuthApply, "");
        return submitGnAuthApply;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b;\u0010<J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0080\u0001\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010&R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010#\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010&R\"\u0010\u0019\u001a\u00020\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010\u0010\"\u0004\b+\u0010,R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010#\u001a\u0004\b-\u0010\u0004\"\u0004\b.\u0010&R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010#\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010&R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u00101\u001a\u0004\b2\u0010\b\"\u0004\b3\u00104R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010#\u001a\u0004\b5\u0010\u0004\"\u0004\b6\u0010&R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b7\u0010\u0004\"\u0004\b8\u0010&R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010#\u001a\u0004\b9\u0010\u0004\"\u0004\b:\u0010&"}, d2 = {"Lid/dana/domain/oauth/interactor/GnAuthApply$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "component4", "component5", "component6", "component7", "component8", "", "component9", "()Z", "state", "clientId", "scopes", "redirectUrl", BranchLinkConstant.OauthParams.NET_AUTH_ID, "subMerchantId", BioUtilityBridge.SECURITY_ID, "requestSourceType", "qrBinding", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/oauth/interactor/GnAuthApply$Params;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "getNetAuthId", "setNetAuthId", "Z", "getQrBinding", "setQrBinding", "(Z)V", "getRedirectUrl", "setRedirectUrl", "getRequestSourceType", "setRequestSourceType", "Ljava/util/List;", "getScopes", "setScopes", "(Ljava/util/List;)V", "getSecurityId", "setSecurityId", "getState", "setState", "getSubMerchantId", "setSubMerchantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private String clientId;
        private String netAuthId;
        private boolean qrBinding;
        private String redirectUrl;
        private String requestSourceType;
        private List<String> scopes;
        private String securityId;
        private String state;
        private String subMerchantId;

        /* renamed from: component1  reason: from getter */
        public final String getState() {
            return this.state;
        }

        /* renamed from: component2  reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        public final List<String> component3() {
            return this.scopes;
        }

        /* renamed from: component4  reason: from getter */
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        /* renamed from: component5  reason: from getter */
        public final String getNetAuthId() {
            return this.netAuthId;
        }

        /* renamed from: component6  reason: from getter */
        public final String getSubMerchantId() {
            return this.subMerchantId;
        }

        /* renamed from: component7  reason: from getter */
        public final String getSecurityId() {
            return this.securityId;
        }

        /* renamed from: component8  reason: from getter */
        public final String getRequestSourceType() {
            return this.requestSourceType;
        }

        /* renamed from: component9  reason: from getter */
        public final boolean getQrBinding() {
            return this.qrBinding;
        }

        public final Params copy(String state, String clientId, List<String> scopes, String redirectUrl, String netAuthId, String subMerchantId, String securityId, String requestSourceType, boolean qrBinding) {
            return new Params(state, clientId, scopes, redirectUrl, netAuthId, subMerchantId, securityId, requestSourceType, qrBinding);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.state, params.state) && Intrinsics.areEqual(this.clientId, params.clientId) && Intrinsics.areEqual(this.scopes, params.scopes) && Intrinsics.areEqual(this.redirectUrl, params.redirectUrl) && Intrinsics.areEqual(this.netAuthId, params.netAuthId) && Intrinsics.areEqual(this.subMerchantId, params.subMerchantId) && Intrinsics.areEqual(this.securityId, params.securityId) && Intrinsics.areEqual(this.requestSourceType, params.requestSourceType) && this.qrBinding == params.qrBinding;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            String str = this.state;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.clientId;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            List<String> list = this.scopes;
            int hashCode3 = list == null ? 0 : list.hashCode();
            String str3 = this.redirectUrl;
            int hashCode4 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.netAuthId;
            int hashCode5 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.subMerchantId;
            int hashCode6 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.securityId;
            int hashCode7 = str6 == null ? 0 : str6.hashCode();
            String str7 = this.requestSourceType;
            int hashCode8 = str7 != null ? str7.hashCode() : 0;
            boolean z = this.qrBinding;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(state=");
            sb.append(this.state);
            sb.append(", clientId=");
            sb.append(this.clientId);
            sb.append(", scopes=");
            sb.append(this.scopes);
            sb.append(", redirectUrl=");
            sb.append(this.redirectUrl);
            sb.append(", netAuthId=");
            sb.append(this.netAuthId);
            sb.append(", subMerchantId=");
            sb.append(this.subMerchantId);
            sb.append(", securityId=");
            sb.append(this.securityId);
            sb.append(", requestSourceType=");
            sb.append(this.requestSourceType);
            sb.append(", qrBinding=");
            sb.append(this.qrBinding);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, List<String> list, String str3, String str4, String str5, String str6, String str7, boolean z) {
            this.state = str;
            this.clientId = str2;
            this.scopes = list;
            this.redirectUrl = str3;
            this.netAuthId = str4;
            this.subMerchantId = str5;
            this.securityId = str6;
            this.requestSourceType = str7;
            this.qrBinding = z;
        }

        public /* synthetic */ Params(String str, String str2, List list, String str3, String str4, String str5, String str6, String str7, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, list, str3, str4, str5, str6, str7, (i & 256) != 0 ? false : z);
        }

        @JvmName(name = "getState")
        public final String getState() {
            return this.state;
        }

        @JvmName(name = "setState")
        public final void setState(String str) {
            this.state = str;
        }

        @JvmName(name = "getClientId")
        public final String getClientId() {
            return this.clientId;
        }

        @JvmName(name = "setClientId")
        public final void setClientId(String str) {
            this.clientId = str;
        }

        @JvmName(name = "getScopes")
        public final List<String> getScopes() {
            return this.scopes;
        }

        @JvmName(name = "setScopes")
        public final void setScopes(List<String> list) {
            this.scopes = list;
        }

        @JvmName(name = "getRedirectUrl")
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        @JvmName(name = "setRedirectUrl")
        public final void setRedirectUrl(String str) {
            this.redirectUrl = str;
        }

        @JvmName(name = "getNetAuthId")
        public final String getNetAuthId() {
            return this.netAuthId;
        }

        @JvmName(name = "setNetAuthId")
        public final void setNetAuthId(String str) {
            this.netAuthId = str;
        }

        @JvmName(name = "getSubMerchantId")
        public final String getSubMerchantId() {
            return this.subMerchantId;
        }

        @JvmName(name = "setSubMerchantId")
        public final void setSubMerchantId(String str) {
            this.subMerchantId = str;
        }

        @JvmName(name = "getSecurityId")
        public final String getSecurityId() {
            return this.securityId;
        }

        @JvmName(name = "setSecurityId")
        public final void setSecurityId(String str) {
            this.securityId = str;
        }

        @JvmName(name = "getRequestSourceType")
        public final String getRequestSourceType() {
            return this.requestSourceType;
        }

        @JvmName(name = "setRequestSourceType")
        public final void setRequestSourceType(String str) {
            this.requestSourceType = str;
        }

        @JvmName(name = "getQrBinding")
        public final boolean getQrBinding() {
            return this.qrBinding;
        }

        @JvmName(name = "setQrBinding")
        public final void setQrBinding(boolean z) {
            this.qrBinding = z;
        }
    }
}
