package id.dana.data.authcode.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.authcode.AuthCodeEntity;
import id.dana.data.authcode.AuthRequest;
import id.dana.data.authcode.QueryAuthInfoRequest;
import id.dana.data.authcode.QueryAuthInfoResult;
import id.dana.data.authcode.repository.source.AuthEntityData;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+JM\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010JM\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0085\u0001\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\r2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!"}, d2 = {"Lid/dana/data/authcode/repository/source/network/NetworkAuthEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/authcode/repository/source/network/AuthFacade;", "Lid/dana/data/authcode/repository/source/AuthEntityData;", "", "redirectUrl", "clientId", "scopes", "", "agreed", "codeChallenge", "needMobileToken", "requestSourceType", "Lio/reactivex/Observable;", "Lid/dana/data/authcode/AuthCodeEntity;", Constants.JS_API_GET_AUTH_CODE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;)Lio/reactivex/Observable;", "subMerchantId", "fromMiniProgram", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "state", BranchLinkConstant.OauthParams.NET_AUTH_ID, BioUtilityBridge.SECURITY_ID, "signatureCode", "originalAuthUrl", "getGnAuthCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "authCode", "Lid/dana/data/authcode/QueryAuthInfoResult;", "queryAuthInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkAuthEntityData extends SecureBaseNetwork<AuthFacade> implements AuthEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<AuthFacade> getFacadeClass() {
        return AuthFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkAuthEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.authcode.repository.source.AuthEntityData
    public final Observable<AuthCodeEntity> getAuthCode(String str, String str2, String str3, boolean z, String str4, String str5, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        String str6 = null;
        final AuthRequest authRequest = new AuthRequest(null, null, null, null, false, null, null, null, str6, str6, null, null, null, false, false, 32767, null);
        authRequest.envInfo = generateMobileEnvInfo();
        authRequest.setRedirectUrl(str);
        authRequest.setClientId(str2);
        authRequest.setScopes(str3);
        authRequest.setAgreed(z);
        authRequest.setRequestSourceType(str4);
        authRequest.setMiniProgram(z2);
        authRequest.setSubMerchantId(str5);
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                AuthCodeEntity m797getAuthCode$lambda0;
                m797getAuthCode$lambda0 = NetworkAuthEntityData.m797getAuthCode$lambda0(AuthRequest.this, (AuthFacade) obj);
                return m797getAuthCode$lambda0;
            }
        }, AuthCodeEntity.class).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$getAuthCode$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$getAuthCode$4
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, 3, 2000L);
    }

    /* renamed from: getAuthCode$lambda-0 */
    public static final AuthCodeEntity m797getAuthCode$lambda0(AuthRequest authRequest, AuthFacade authFacade) {
        Intrinsics.checkNotNullParameter(authRequest, "");
        Intrinsics.checkNotNullParameter(authFacade, "");
        return authFacade.oauthAuthCodeApply(authRequest);
    }

    @Override // id.dana.data.authcode.repository.source.AuthEntityData
    public final Observable<AuthCodeEntity> getAuthCode(String str, String str2, String str3, boolean z, String str4, boolean z2, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        String str6 = null;
        final AuthRequest authRequest = new AuthRequest(null, null, null, null, false, null, null, null, str6, str6, null, null, null, false, false, 32767, null);
        authRequest.envInfo = generateMobileEnvInfo();
        authRequest.setRedirectUrl(str);
        authRequest.setClientId(str2);
        authRequest.setScopes(str3);
        authRequest.setAgreed(z);
        authRequest.setCodeChallenge(str4);
        authRequest.setNeedMobileToken(z2);
        authRequest.setRequestSourceType(str5);
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                AuthCodeEntity m798getAuthCode$lambda1;
                m798getAuthCode$lambda1 = NetworkAuthEntityData.m798getAuthCode$lambda1(AuthRequest.this, (AuthFacade) obj);
                return m798getAuthCode$lambda1;
            }
        }, AuthCodeEntity.class).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$getAuthCode$7
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$getAuthCode$8
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, 3, 2000L);
    }

    /* renamed from: getAuthCode$lambda-1 */
    public static final AuthCodeEntity m798getAuthCode$lambda1(AuthRequest authRequest, AuthFacade authFacade) {
        Intrinsics.checkNotNullParameter(authRequest, "");
        Intrinsics.checkNotNullParameter(authFacade, "");
        return authFacade.oauthAuthCodeApply(authRequest);
    }

    @Override // id.dana.data.authcode.repository.source.AuthEntityData
    public final Observable<AuthCodeEntity> getGnAuthCode(String state, String redirectUrl, String clientId, String scopes, Boolean agreed, String r25, String subMerchantId, String r27, String signatureCode, String originalAuthUrl, String requestSourceType) {
        final AuthRequest authRequest = new AuthRequest(redirectUrl == null ? "" : redirectUrl, clientId == null ? "" : clientId, scopes == null ? "" : scopes, state == null ? "" : state, agreed != null ? agreed.booleanValue() : false, null, r27, null, requestSourceType, r25, subMerchantId, signatureCode, originalAuthUrl, false, false, 24736, null);
        authRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                AuthCodeEntity m799getGnAuthCode$lambda3;
                m799getGnAuthCode$lambda3 = NetworkAuthEntityData.m799getGnAuthCode$lambda3(AuthRequest.this, (AuthFacade) obj);
                return m799getGnAuthCode$lambda3;
            }
        });
    }

    /* renamed from: getGnAuthCode$lambda-3 */
    public static final AuthCodeEntity m799getGnAuthCode$lambda3(AuthRequest authRequest, AuthFacade authFacade) {
        Intrinsics.checkNotNullParameter(authRequest, "");
        return authFacade.oauthAuthCodeApply(authRequest);
    }

    @Override // id.dana.data.authcode.repository.source.AuthEntityData
    public final Observable<QueryAuthInfoResult> queryAuthInfo(String authCode, String clientId) {
        Intrinsics.checkNotNullParameter(authCode, "");
        Intrinsics.checkNotNullParameter(clientId, "");
        final QueryAuthInfoRequest queryAuthInfoRequest = new QueryAuthInfoRequest(authCode, clientId);
        queryAuthInfoRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                QueryAuthInfoResult m800queryAuthInfo$lambda4;
                m800queryAuthInfo$lambda4 = NetworkAuthEntityData.m800queryAuthInfo$lambda4(QueryAuthInfoRequest.this, (AuthFacade) obj);
                return m800queryAuthInfo$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* renamed from: queryAuthInfo$lambda-4 */
    public static final QueryAuthInfoResult m800queryAuthInfo$lambda4(QueryAuthInfoRequest queryAuthInfoRequest, AuthFacade authFacade) {
        Intrinsics.checkNotNullParameter(queryAuthInfoRequest, "");
        Intrinsics.checkNotNullParameter(authFacade, "");
        return authFacade.queryAuthInfo(queryAuthInfoRequest);
    }
}
