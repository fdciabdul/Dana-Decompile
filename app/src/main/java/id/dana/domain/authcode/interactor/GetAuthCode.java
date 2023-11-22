package id.dana.domain.authcode.interactor;

import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\b\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/domain/authcode/interactor/GetAuthCode;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/authcode/AuthCodeResult;", "Lid/dana/domain/authcode/interactor/GetAuthCode$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/authcode/interactor/GetAuthCode$Params;)Lio/reactivex/Observable;", "fetchAuthCode", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;", "checkUserInfo", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;", "Lid/dana/domain/oauth/repository/OauthRepository;", "repository", "Lid/dana/domain/oauth/repository/OauthRepository;", "<init>", "(Lid/dana/domain/oauth/repository/OauthRepository;Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo;)V", "MissingRequiredUserInfoException", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetAuthCode extends BaseUseCase<AuthCodeResult, Params> {
    private final GetEmptyUserInfo checkUserInfo;
    private final OauthRepository repository;

    @Inject
    public GetAuthCode(OauthRepository oauthRepository, GetEmptyUserInfo getEmptyUserInfo) {
        Intrinsics.checkNotNullParameter(oauthRepository, "");
        Intrinsics.checkNotNullParameter(getEmptyUserInfo, "");
        this.repository = oauthRepository;
        this.checkUserInfo = getEmptyUserInfo;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<AuthCodeResult> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (params.getAgreed() && params.getCheckUserInfo() && params.getFromMiniProgram()) {
            GetEmptyUserInfo getEmptyUserInfo = this.checkUserInfo;
            String serviceKeyOrAppId = params.getServiceKeyOrAppId();
            String scopes = params.getScopes();
            String clientId = params.getClientId();
            if (!params.getFromMiniProgram()) {
                clientId = null;
            }
            Observable<AuthCodeResult> flatMap = getEmptyUserInfo.buildUseCase(new GetEmptyUserInfo.Params(serviceKeyOrAppId, scopes, clientId, params.getFromMiniProgram())).map(new Function() { // from class: id.dana.domain.authcode.interactor.GetAuthCode$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    GetEmptyUserInfo.UserInfo m2246buildUseCase$lambda1;
                    m2246buildUseCase$lambda1 = GetAuthCode.m2246buildUseCase$lambda1((GetEmptyUserInfo.UserInfo) obj);
                    return m2246buildUseCase$lambda1;
                }
            }).flatMap(new Function() { // from class: id.dana.domain.authcode.interactor.GetAuthCode$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2247buildUseCase$lambda2;
                    m2247buildUseCase$lambda2 = GetAuthCode.m2247buildUseCase$lambda2(GetAuthCode.this, params, (GetEmptyUserInfo.UserInfo) obj);
                    return m2247buildUseCase$lambda2;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        }
        Observable<AuthCodeResult> fetchAuthCode = fetchAuthCode(params);
        Intrinsics.checkNotNullExpressionValue(fetchAuthCode, "");
        return fetchAuthCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final GetEmptyUserInfo.UserInfo m2246buildUseCase$lambda1(GetEmptyUserInfo.UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "");
        if (userInfo.getStatus() == GetEmptyUserInfo.Status.COMPLETE) {
            return userInfo;
        }
        throw new MissingRequiredUserInfoException(userInfo.getStatus());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final ObservableSource m2247buildUseCase$lambda2(GetAuthCode getAuthCode, Params params, GetEmptyUserInfo.UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(getAuthCode, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(userInfo, "");
        return getAuthCode.fetchAuthCode(params);
    }

    private final Observable<AuthCodeResult> fetchAuthCode(Params params) {
        return this.repository.getAuthCode(params.getRedirectUrl(), params.getClientId(), params.getScopes(), params.getAgreed(), params.getRequestSourceType(), params.getSubMerchantId(), params.getFromMiniProgram());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBY\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\t8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\t8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\t8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r"}, d2 = {"Lid/dana/domain/authcode/interactor/GetAuthCode$Params;", "", "", "agreed", "Z", "getAgreed$domain_productionRelease", "()Z", "checkUserInfo", "getCheckUserInfo$domain_productionRelease", "", "clientId", "Ljava/lang/String;", "getClientId$domain_productionRelease", "()Ljava/lang/String;", "fromMiniProgram", "getFromMiniProgram$domain_productionRelease", "redirectUrl", "getRedirectUrl$domain_productionRelease", "requestSourceType", "getRequestSourceType$domain_productionRelease", "scopes", "getScopes$domain_productionRelease", "serviceKeyOrAppId", "getServiceKeyOrAppId$domain_productionRelease", "subMerchantId", "getSubMerchantId$domain_productionRelease", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean agreed;
        private final boolean checkUserInfo;
        private final String clientId;
        private final boolean fromMiniProgram;
        private final String redirectUrl;
        private final String requestSourceType;
        private final String scopes;
        private final String serviceKeyOrAppId;
        private final String subMerchantId;

        @JvmStatic
        public static final Params forGetAuthCode(String str, String str2, String str3, boolean z) {
            return INSTANCE.forGetAuthCode(str, str2, str3, z);
        }

        @JvmStatic
        public static final Params forGetAuthCodeMpAgreements(String str, String str2, String str3, boolean z, String str4) {
            return INSTANCE.forGetAuthCodeMpAgreements(str, str2, str3, z, str4);
        }

        @JvmStatic
        public static final Params forGetAuthCodeMpAgreements(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5) {
            return INSTANCE.forGetAuthCodeMpAgreements(str, str2, str3, z, str4, z2, str5);
        }

        @JvmStatic
        public static final Params forGetGnAuthCode(String str, String str2, String str3, boolean z, String str4) {
            return INSTANCE.forGetGnAuthCode(str, str2, str3, z, str4);
        }

        public Params(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2, String str6, boolean z3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str6, "");
            this.redirectUrl = str;
            this.clientId = str2;
            this.scopes = str3;
            this.agreed = z;
            this.requestSourceType = str4;
            this.subMerchantId = str5;
            this.fromMiniProgram = z2;
            this.serviceKeyOrAppId = str6;
            this.checkUserInfo = z3;
        }

        public /* synthetic */ Params(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2, String str6, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, str4, str5, z2, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? false : z3);
        }

        @JvmName(name = "getRedirectUrl$domain_productionRelease")
        /* renamed from: getRedirectUrl$domain_productionRelease  reason: from getter */
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        @JvmName(name = "getClientId$domain_productionRelease")
        /* renamed from: getClientId$domain_productionRelease  reason: from getter */
        public final String getClientId() {
            return this.clientId;
        }

        @JvmName(name = "getScopes$domain_productionRelease")
        /* renamed from: getScopes$domain_productionRelease  reason: from getter */
        public final String getScopes() {
            return this.scopes;
        }

        @JvmName(name = "getAgreed$domain_productionRelease")
        /* renamed from: getAgreed$domain_productionRelease  reason: from getter */
        public final boolean getAgreed() {
            return this.agreed;
        }

        @JvmName(name = "getRequestSourceType$domain_productionRelease")
        /* renamed from: getRequestSourceType$domain_productionRelease  reason: from getter */
        public final String getRequestSourceType() {
            return this.requestSourceType;
        }

        @JvmName(name = "getSubMerchantId$domain_productionRelease")
        /* renamed from: getSubMerchantId$domain_productionRelease  reason: from getter */
        public final String getSubMerchantId() {
            return this.subMerchantId;
        }

        @JvmName(name = "getFromMiniProgram$domain_productionRelease")
        /* renamed from: getFromMiniProgram$domain_productionRelease  reason: from getter */
        public final boolean getFromMiniProgram() {
            return this.fromMiniProgram;
        }

        @JvmName(name = "getServiceKeyOrAppId$domain_productionRelease")
        /* renamed from: getServiceKeyOrAppId$domain_productionRelease  reason: from getter */
        public final String getServiceKeyOrAppId() {
            return this.serviceKeyOrAppId;
        }

        @JvmName(name = "getCheckUserInfo$domain_productionRelease")
        /* renamed from: getCheckUserInfo$domain_productionRelease  reason: from getter */
        public final boolean getCheckUserInfo() {
            return this.checkUserInfo;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ9\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJI\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\u0010J9\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\r"}, d2 = {"Lid/dana/domain/authcode/interactor/GetAuthCode$Params$Companion;", "", "", "redirectUrl", "clientId", "scopes", "", "agreed", "Lid/dana/domain/authcode/interactor/GetAuthCode$Params;", "forGetAuthCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/authcode/interactor/GetAuthCode$Params;", "subMerchantId", "forGetAuthCodeMpAgreements", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lid/dana/domain/authcode/interactor/GetAuthCode$Params;", "checkUserInfo", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;)Lid/dana/domain/authcode/interactor/GetAuthCode$Params;", "requestSourceType", "forGetGnAuthCode", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params forGetAuthCode(String redirectUrl, String clientId, String scopes, boolean agreed) {
                Intrinsics.checkNotNullParameter(redirectUrl, "");
                Intrinsics.checkNotNullParameter(clientId, "");
                Intrinsics.checkNotNullParameter(scopes, "");
                return new Params(redirectUrl, clientId, scopes, agreed, "", "", false, null, false, 384, null);
            }

            @JvmStatic
            public final Params forGetAuthCodeMpAgreements(String redirectUrl, String clientId, String scopes, boolean agreed, String subMerchantId) {
                Intrinsics.checkNotNullParameter(redirectUrl, "");
                Intrinsics.checkNotNullParameter(clientId, "");
                Intrinsics.checkNotNullParameter(scopes, "");
                return forGetAuthCodeMpAgreements(redirectUrl, clientId, scopes, agreed, subMerchantId, false, "");
            }

            @JvmStatic
            public final Params forGetAuthCodeMpAgreements(String redirectUrl, String clientId, String scopes, boolean agreed, String subMerchantId, boolean checkUserInfo, String appId) {
                Intrinsics.checkNotNullParameter(redirectUrl, "");
                Intrinsics.checkNotNullParameter(clientId, "");
                Intrinsics.checkNotNullParameter(scopes, "");
                Intrinsics.checkNotNullParameter(appId, "");
                return new Params(redirectUrl, clientId, scopes, agreed, "", subMerchantId, true, appId, checkUserInfo);
            }

            @JvmStatic
            public final Params forGetGnAuthCode(String redirectUrl, String clientId, String scopes, boolean agreed, String requestSourceType) {
                Intrinsics.checkNotNullParameter(redirectUrl, "");
                Intrinsics.checkNotNullParameter(clientId, "");
                Intrinsics.checkNotNullParameter(scopes, "");
                return new Params(redirectUrl, clientId, scopes, agreed, requestSourceType, "", false, null, false, 384, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/authcode/interactor/GetAuthCode$MissingRequiredUserInfoException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;", "userDataStatus", "Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;", "getUserDataStatus", "()Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;", "<init>", "(Lid/dana/domain/useragreement/interactor/GetEmptyUserInfo$Status;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class MissingRequiredUserInfoException extends Exception {
        private final GetEmptyUserInfo.Status userDataStatus;

        public MissingRequiredUserInfoException(GetEmptyUserInfo.Status status) {
            Intrinsics.checkNotNullParameter(status, "");
            this.userDataStatus = status;
        }

        @JvmName(name = "getUserDataStatus")
        public final GetEmptyUserInfo.Status getUserDataStatus() {
            return this.userDataStatus;
        }
    }
}
