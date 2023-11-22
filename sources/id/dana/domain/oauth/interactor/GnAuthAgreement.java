package id.dana.domain.oauth.interactor;

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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/oauth/interactor/GnAuthAgreement;", "Lid/dana/domain/UseCase;", "Lid/dana/domain/authcode/AuthCodeResult;", "Lid/dana/domain/oauth/interactor/GnAuthAgreement$Params;", "params", "Lio/reactivex/Observable;", "buildUseCaseObservable", "(Lid/dana/domain/oauth/interactor/GnAuthAgreement$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/oauth/repository/OauthRepository;", "oauthRepository", "Lid/dana/domain/oauth/repository/OauthRepository;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/domain/PostExecutionThread;", "postExecutionThread", "<init>", "(Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/domain/PostExecutionThread;Lid/dana/domain/oauth/repository/OauthRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GnAuthAgreement extends UseCase<AuthCodeResult, Params> {
    private final OauthRepository oauthRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GnAuthAgreement(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, OauthRepository oauthRepository) {
        super(threadExecutor, postExecutionThread);
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(postExecutionThread, "");
        Intrinsics.checkNotNullParameter(oauthRepository, "");
        this.oauthRepository = oauthRepository;
    }

    @Override // id.dana.domain.UseCase
    public final Observable<AuthCodeResult> buildUseCaseObservable(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<AuthCodeResult> gnAuthAgreement = this.oauthRepository.getGnAuthAgreement(params.getClientId(), params.getScopes(), params.getRedirectUrl(), params.getNetAuthId(), params.getSubMerchantId(), params.getSignature(), params.getRefferingLink());
        Intrinsics.checkNotNullExpressionValue(gnAuthAgreement, "");
        return gnAuthAgreement;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b0\u00101J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004Jj\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004\"\u0004\b \u0010!R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010!R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010!R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b&\u0010\u0004\"\u0004\b'\u0010!R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010+R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010!R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010!"}, d2 = {"Lid/dana/domain/oauth/interactor/GnAuthAgreement$Params;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", "component4", "component5", "component6", "component7", "clientId", "scopes", "redirectUrl", BranchLinkConstant.OauthParams.NET_AUTH_ID, "subMerchantId", BranchLinkConstant.OauthParams.SIGNATURE, "refferingLink", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/oauth/interactor/GnAuthAgreement$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "getNetAuthId", "setNetAuthId", "getRedirectUrl", "setRedirectUrl", "getRefferingLink", "setRefferingLink", "Ljava/util/List;", "getScopes", "setScopes", "(Ljava/util/List;)V", "getSignature", "setSignature", "getSubMerchantId", "setSubMerchantId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private String clientId;
        private String netAuthId;
        private String redirectUrl;
        private String refferingLink;
        private List<String> scopes;
        private String signature;
        private String subMerchantId;

        public static /* synthetic */ Params copy$default(Params params, String str, List list, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.clientId;
            }
            List<String> list2 = list;
            if ((i & 2) != 0) {
                list2 = params.scopes;
            }
            List list3 = list2;
            if ((i & 4) != 0) {
                str2 = params.redirectUrl;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = params.netAuthId;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = params.subMerchantId;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = params.signature;
            }
            String str10 = str5;
            if ((i & 64) != 0) {
                str6 = params.refferingLink;
            }
            return params.copy(str, list3, str7, str8, str9, str10, str6);
        }

        /* renamed from: component1  reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        public final List<String> component2() {
            return this.scopes;
        }

        /* renamed from: component3  reason: from getter */
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        /* renamed from: component4  reason: from getter */
        public final String getNetAuthId() {
            return this.netAuthId;
        }

        /* renamed from: component5  reason: from getter */
        public final String getSubMerchantId() {
            return this.subMerchantId;
        }

        /* renamed from: component6  reason: from getter */
        public final String getSignature() {
            return this.signature;
        }

        /* renamed from: component7  reason: from getter */
        public final String getRefferingLink() {
            return this.refferingLink;
        }

        public final Params copy(String clientId, List<String> scopes, String redirectUrl, String netAuthId, String subMerchantId, String signature, String refferingLink) {
            return new Params(clientId, scopes, redirectUrl, netAuthId, subMerchantId, signature, refferingLink);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.clientId, params.clientId) && Intrinsics.areEqual(this.scopes, params.scopes) && Intrinsics.areEqual(this.redirectUrl, params.redirectUrl) && Intrinsics.areEqual(this.netAuthId, params.netAuthId) && Intrinsics.areEqual(this.subMerchantId, params.subMerchantId) && Intrinsics.areEqual(this.signature, params.signature) && Intrinsics.areEqual(this.refferingLink, params.refferingLink);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.clientId;
            int hashCode = str == null ? 0 : str.hashCode();
            List<String> list = this.scopes;
            int hashCode2 = list == null ? 0 : list.hashCode();
            String str2 = this.redirectUrl;
            int hashCode3 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.netAuthId;
            int hashCode4 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.subMerchantId;
            int hashCode5 = str4 == null ? 0 : str4.hashCode();
            String str5 = this.signature;
            int hashCode6 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.refferingLink;
            return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str6 != null ? str6.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(clientId=");
            sb.append(this.clientId);
            sb.append(", scopes=");
            sb.append(this.scopes);
            sb.append(", redirectUrl=");
            sb.append(this.redirectUrl);
            sb.append(", netAuthId=");
            sb.append(this.netAuthId);
            sb.append(", subMerchantId=");
            sb.append(this.subMerchantId);
            sb.append(", signature=");
            sb.append(this.signature);
            sb.append(", refferingLink=");
            sb.append(this.refferingLink);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, List<String> list, String str2, String str3, String str4, String str5, String str6) {
            this.clientId = str;
            this.scopes = list;
            this.redirectUrl = str2;
            this.netAuthId = str3;
            this.subMerchantId = str4;
            this.signature = str5;
            this.refferingLink = str6;
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

        @JvmName(name = "getSignature")
        public final String getSignature() {
            return this.signature;
        }

        @JvmName(name = "setSignature")
        public final void setSignature(String str) {
            this.signature = str;
        }

        @JvmName(name = "getRefferingLink")
        public final String getRefferingLink() {
            return this.refferingLink;
        }

        @JvmName(name = "setRefferingLink")
        public final void setRefferingLink(String str) {
            this.refferingLink = str;
        }
    }
}
