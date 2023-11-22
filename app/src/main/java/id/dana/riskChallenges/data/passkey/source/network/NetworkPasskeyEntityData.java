package id.dana.riskChallenges.data.passkey.source.network;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Quake;
import com.alipay.imobile.network.quake.Request;
import com.alipay.imobile.network.quake.request.RequestInterceptor;
import com.alipay.imobile.network.quake.transport.strategy.RetryPolicy;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ExceptionParserAphome;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.riskChallenges.data.passkey.source.PasskeyEntityData;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.foundation.facede.ApSecurity;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@RiskChallengesScope
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B1\b\u0007\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u0018\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00170\u0017*\f\u0012\b\u0012\u0006*\u00020\u00170\u00170\b0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ;\u0010\u001b\u001a\u001a\u0012\b\u0012\u0006*\u00020\u001a0\u001a*\f\u0012\b\u0012\u0006*\u00020\u001a0\u001a0\b0\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0015"}, d2 = {"Lid/dana/riskChallenges/data/passkey/source/network/NetworkPasskeyEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/riskChallenges/data/passkey/source/network/PasskeyFacade;", "Lid/dana/riskChallenges/data/passkey/source/PasskeyEntityData;", "Lcom/alibaba/fastjson/JSONObject;", "credential", "", "userId", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationFinishResponse;", "authenticationFinish", "(Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/passkey/source/network/AuthenticationStartResponse;", "authenticationStart", "()Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "credentialId", "Lid/dana/riskChallenges/data/passkey/source/network/QueryUserCredentialsResponse;", "queryUserCredentials", "(Ljava/lang/String;)Lio/reactivex/Observable;", BioUtilityBridge.SECURITY_ID, "Lid/dana/riskChallenges/data/passkey/source/network/RegistrationFinishResponse;", "registrationFinish", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Lid/dana/riskChallenges/data/passkey/source/network/RegistrationStartResponse;", "registrationStart", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/passkey/source/network/RemoveCredentialResponse;", "removeCredential", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/utils/foundation/facede/ApSecurity;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkPasskeyEntityData extends SecureBaseNetwork<PasskeyFacade> implements PasskeyEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<PasskeyFacade> getFacadeClass() {
        return PasskeyFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkPasskeyEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurity apSecurity, Context context) {
        super(rpcConnector, threadExecutor, apSecurity, context);
        Quake.instance().addRequestInterceptor(new RequestInterceptor() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$1$1
            @Override // com.alipay.imobile.network.quake.request.RequestInterceptor
            public final void afterReceiveResponse(Request request, NetworkResponse response) {
                Intrinsics.checkNotNullParameter(request, "");
                Intrinsics.checkNotNullParameter(response, "");
            }

            @Override // com.alipay.imobile.network.quake.request.RequestInterceptor
            public final void beforeSendRequest(Request request) {
                Intrinsics.checkNotNullParameter(request, "");
                String obj = request.toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                Object[] array = StringsKt.split$default((CharSequence) obj, new String[]{"#"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    if (CollectionsKt.listOf((Object[]) new String[]{"id.dana.userprod.user.passKey.startRegistration", "id.dana.userprod.user.passKey.startAuthentication"}).contains(((String[]) array)[1])) {
                        request.setRetryPolicy(new RetryPolicy() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$1$1$beforeSendRequest$1
                            @Override // com.alipay.imobile.network.quake.transport.strategy.RetryPolicy
                            public final int getCurrentRetryCount() {
                                return 0;
                            }

                            @Override // com.alipay.imobile.network.quake.transport.strategy.RetryPolicy
                            public final int getCurrentTimeout() {
                                return 3000;
                            }

                            @Override // com.alipay.imobile.network.quake.transport.strategy.RetryPolicy
                            public final void retry(RpcException e) {
                                if (e != null) {
                                    throw e;
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        });
    }

    @Override // id.dana.riskChallenges.data.passkey.source.PasskeyEntityData
    public final Observable<RegistrationStartResponse> registrationStart(final String pageSource, final String securityId) {
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RegistrationStartResponse m2872registrationStart$lambda4;
                m2872registrationStart$lambda4 = NetworkPasskeyEntityData.m2872registrationStart$lambda4(securityId, this, pageSource, (PasskeyFacade) obj);
                return m2872registrationStart$lambda4;
            }
        }, RegistrationStartResponse.class).flatMap(new ExceptionParserAphome());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registrationStart$lambda-4  reason: not valid java name */
    public static final RegistrationStartResponse m2872registrationStart$lambda4(String str, NetworkPasskeyEntityData networkPasskeyEntityData, String str2, PasskeyFacade passkeyFacade) {
        Intrinsics.checkNotNullParameter(networkPasskeyEntityData, "");
        RegistrationStartRequest registrationStartRequest = new RegistrationStartRequest(str);
        MobileEnvInfo generateMobileEnvInfo = networkPasskeyEntityData.generateMobileEnvInfo();
        if (str2 != null) {
            Map<String, String> map = generateMobileEnvInfo.extendInfo;
            Intrinsics.checkNotNullExpressionValue(map, "");
            map.put(NetworkFaceAuthenticationEntityData.PAGE_SOURCE, str2);
        }
        registrationStartRequest.envInfo = generateMobileEnvInfo;
        return passkeyFacade.registrationStart(registrationStartRequest);
    }

    @Override // id.dana.riskChallenges.data.passkey.source.PasskeyEntityData
    public final Observable<RegistrationFinishResponse> registrationFinish(final JSONObject credential, final String securityId) {
        Intrinsics.checkNotNullParameter(credential, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RegistrationFinishResponse m2871registrationFinish$lambda6;
                m2871registrationFinish$lambda6 = NetworkPasskeyEntityData.m2871registrationFinish$lambda6(securityId, credential, this, (PasskeyFacade) obj);
                return m2871registrationFinish$lambda6;
            }
        }, RegistrationFinishResponse.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registrationFinish$lambda-6  reason: not valid java name */
    public static final RegistrationFinishResponse m2871registrationFinish$lambda6(String str, JSONObject jSONObject, NetworkPasskeyEntityData networkPasskeyEntityData, PasskeyFacade passkeyFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Intrinsics.checkNotNullParameter(networkPasskeyEntityData, "");
        RegistrationFinishRequest registrationFinishRequest = new RegistrationFinishRequest(str, jSONObject);
        registrationFinishRequest.envInfo = networkPasskeyEntityData.generateMobileEnvInfo();
        return passkeyFacade.registrationFinish(registrationFinishRequest);
    }

    @Override // id.dana.riskChallenges.data.passkey.source.PasskeyEntityData
    public final Observable<AuthenticationStartResponse> authenticationStart() {
        Observable<AuthenticationStartResponse> flatMap = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                AuthenticationStartResponse m2869authenticationStart$lambda8;
                m2869authenticationStart$lambda8 = NetworkPasskeyEntityData.m2869authenticationStart$lambda8(NetworkPasskeyEntityData.this, (PasskeyFacade) obj);
                return m2869authenticationStart$lambda8;
            }
        }, AuthenticationStartResponse.class).flatMap(new ExceptionParserAphome());
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: authenticationStart$lambda-8  reason: not valid java name */
    public static final AuthenticationStartResponse m2869authenticationStart$lambda8(NetworkPasskeyEntityData networkPasskeyEntityData, PasskeyFacade passkeyFacade) {
        Intrinsics.checkNotNullParameter(networkPasskeyEntityData, "");
        AuthenticationStartRequest authenticationStartRequest = new AuthenticationStartRequest();
        authenticationStartRequest.envInfo = networkPasskeyEntityData.generateMobileEnvInfo();
        return passkeyFacade.authenticationStart(authenticationStartRequest);
    }

    @Override // id.dana.riskChallenges.data.passkey.source.PasskeyEntityData
    @Deprecated(message = "not used, we will use from alipayplus.mobilewallet.product.security.verify")
    public final Observable<AuthenticationFinishResponse> authenticationFinish(final JSONObject credential, final String userId) {
        Intrinsics.checkNotNullParameter(credential, "");
        Intrinsics.checkNotNullParameter(userId, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                AuthenticationFinishResponse m2868authenticationFinish$lambda10;
                m2868authenticationFinish$lambda10 = NetworkPasskeyEntityData.m2868authenticationFinish$lambda10(userId, credential, this, (PasskeyFacade) obj);
                return m2868authenticationFinish$lambda10;
            }
        }, AuthenticationFinishResponse.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: authenticationFinish$lambda-10  reason: not valid java name */
    public static final AuthenticationFinishResponse m2868authenticationFinish$lambda10(String str, JSONObject jSONObject, NetworkPasskeyEntityData networkPasskeyEntityData, PasskeyFacade passkeyFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Intrinsics.checkNotNullParameter(networkPasskeyEntityData, "");
        AuthenticationFinishRequest authenticationFinishRequest = new AuthenticationFinishRequest(str, jSONObject);
        authenticationFinishRequest.envInfo = networkPasskeyEntityData.generateMobileEnvInfo();
        return passkeyFacade.authenticationFinish(authenticationFinishRequest);
    }

    @Override // id.dana.riskChallenges.data.passkey.source.PasskeyEntityData
    public final Observable<QueryUserCredentialsResponse> queryUserCredentials(final String credentialId) {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                QueryUserCredentialsResponse m2870queryUserCredentials$lambda12;
                m2870queryUserCredentials$lambda12 = NetworkPasskeyEntityData.m2870queryUserCredentials$lambda12(credentialId, this, (PasskeyFacade) obj);
                return m2870queryUserCredentials$lambda12;
            }
        }, QueryUserCredentialsResponse.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: queryUserCredentials$lambda-12  reason: not valid java name */
    public static final QueryUserCredentialsResponse m2870queryUserCredentials$lambda12(String str, NetworkPasskeyEntityData networkPasskeyEntityData, PasskeyFacade passkeyFacade) {
        Intrinsics.checkNotNullParameter(networkPasskeyEntityData, "");
        QueryUserCredentialsRequest queryUserCredentialsRequest = new QueryUserCredentialsRequest(str);
        queryUserCredentialsRequest.envInfo = networkPasskeyEntityData.generateMobileEnvInfo();
        return passkeyFacade.queryUserCredentials(queryUserCredentialsRequest);
    }

    @Override // id.dana.riskChallenges.data.passkey.source.PasskeyEntityData
    public final Observable<RemoveCredentialResponse> removeCredential(final String securityId) {
        Observable<RemoveCredentialResponse> map = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                RemoveCredentialResponse m2873removeCredential$lambda15;
                m2873removeCredential$lambda15 = NetworkPasskeyEntityData.m2873removeCredential$lambda15(securityId, this, (PasskeyFacade) obj);
                return m2873removeCredential$lambda15;
            }
        }, RemoveCredentialResponse.class).map(new Function() { // from class: id.dana.riskChallenges.data.passkey.source.network.NetworkPasskeyEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RemoveCredentialResponse m2874removeCredential$lambda17;
                m2874removeCredential$lambda17 = NetworkPasskeyEntityData.m2874removeCredential$lambda17((RemoveCredentialResponse) obj);
                return m2874removeCredential$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* renamed from: removeCredential$lambda-15  reason: not valid java name */
    public static final RemoveCredentialResponse m2873removeCredential$lambda15(String str, NetworkPasskeyEntityData networkPasskeyEntityData, PasskeyFacade passkeyFacade) {
        Intrinsics.checkNotNullParameter(networkPasskeyEntityData, "");
        ?? r2 = 0;
        RemoveCredentialRequest removeCredentialRequest = new RemoveCredentialRequest(str, r2, 2, r2);
        MobileEnvInfo generateMobileEnvInfo = networkPasskeyEntityData.generateMobileEnvInfo();
        Map<String, String> map = generateMobileEnvInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("isPasskeysSupported", SummaryActivity.CHECKED);
        Map<String, String> map2 = generateMobileEnvInfo.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map2, "");
        map2.put(NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "PROFILE");
        removeCredentialRequest.envInfo = generateMobileEnvInfo;
        return passkeyFacade.removeCredential(removeCredentialRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeCredential$lambda-17  reason: not valid java name */
    public static final RemoveCredentialResponse m2874removeCredential$lambda17(RemoveCredentialResponse removeCredentialResponse) {
        Intrinsics.checkNotNullParameter(removeCredentialResponse, "");
        if (removeCredentialResponse.getVerificationMethods() == null) {
            removeCredentialResponse.setVerificationMethods(CollectionsKt.emptyList());
        }
        return removeCredentialResponse;
    }
}
