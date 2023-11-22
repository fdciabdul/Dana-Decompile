package id.dana.data.security.source.network;

import android.content.Context;
import id.dana.data.authcode.repository.source.network.NetworkAuthEntityData$$ExternalSyntheticLambda2;
import id.dana.data.security.PublicKeyScene;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.network.request.GetPublicKeyRpcRequest;
import id.dana.data.security.source.network.result.GetPublicKeyRpcResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.ConnectionExceptionParser;
import id.dana.network.exception.NoInternetConnectionException;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import id.dana.utils.extension.RxExtensionKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/security/source/network/NetworkSecurityEntityData;", "Lid/dana/network/base/BaseNetwork;", "Lid/dana/data/security/source/network/GetPublicKeyRpcFacade;", "Lid/dana/data/security/source/SecurityEntityData;", "Lio/reactivex/Observable;", "", "cardCredentialKey", "()Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "loginKey", "offlinePayKey", "Landroid/content/Context;", "passContext", "()Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkSecurityEntityData extends BaseNetwork<GetPublicKeyRpcFacade> implements SecurityEntityData {
    private final RpcConnector rpcConnector;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<GetPublicKeyRpcFacade> getFacadeClass() {
        return GetPublicKeyRpcFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkSecurityEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor) {
        super(rpcConnector, threadExecutor);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        this.rpcConnector = rpcConnector;
    }

    @Override // id.dana.network.base.BaseNetwork
    public final Context passContext() {
        Context context = this.rpcConnector.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return context;
    }

    @Override // id.dana.data.security.source.SecurityEntityData
    public final Observable<String> loginKey() {
        Observable onErrorResumeNext = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.security.source.network.NetworkSecurityEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GetPublicKeyRpcResult m1903loginKey$lambda0;
                m1903loginKey$lambda0 = NetworkSecurityEntityData.m1903loginKey$lambda0((GetPublicKeyRpcFacade) obj);
                return m1903loginKey$lambda0;
            }
        }).map(new Function() { // from class: id.dana.data.security.source.network.NetworkSecurityEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1904loginKey$lambda1;
                m1904loginKey$lambda1 = NetworkSecurityEntityData.m1904loginKey$lambda1((GetPublicKeyRpcResult) obj);
                return m1904loginKey$lambda1;
            }
        }).onErrorResumeNext(new NetworkAuthEntityData$$ExternalSyntheticLambda2(new ConnectionExceptionParser()));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return RxExtensionKt.PlaceComponentResult(onErrorResumeNext, new Function1<Throwable, Boolean>() { // from class: id.dana.data.security.source.network.NetworkSecurityEntityData$loginKey$4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return Boolean.valueOf(th instanceof NoInternetConnectionException);
            }
        }, new Function1<Integer, Unit>() { // from class: id.dana.data.security.source.network.NetworkSecurityEntityData$loginKey$5
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        }, 2, TimeUnit.SECONDS.toMillis(2L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loginKey$lambda-0  reason: not valid java name */
    public static final GetPublicKeyRpcResult m1903loginKey$lambda0(GetPublicKeyRpcFacade getPublicKeyRpcFacade) {
        Intrinsics.checkNotNullParameter(getPublicKeyRpcFacade, "");
        return getPublicKeyRpcFacade.fetchPublicKey(new GetPublicKeyRpcRequest("LOGIN"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loginKey$lambda-1  reason: not valid java name */
    public static final String m1904loginKey$lambda1(GetPublicKeyRpcResult getPublicKeyRpcResult) {
        Intrinsics.checkNotNullParameter(getPublicKeyRpcResult, "");
        return getPublicKeyRpcResult.publicKey;
    }

    @Override // id.dana.data.security.source.SecurityEntityData
    public final Observable<String> offlinePayKey() {
        Observable<String> map = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.security.source.network.NetworkSecurityEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GetPublicKeyRpcResult m1905offlinePayKey$lambda2;
                m1905offlinePayKey$lambda2 = NetworkSecurityEntityData.m1905offlinePayKey$lambda2((GetPublicKeyRpcFacade) obj);
                return m1905offlinePayKey$lambda2;
            }
        }).map(new Function() { // from class: id.dana.data.security.source.network.NetworkSecurityEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1906offlinePayKey$lambda3;
                m1906offlinePayKey$lambda3 = NetworkSecurityEntityData.m1906offlinePayKey$lambda3((GetPublicKeyRpcResult) obj);
                return m1906offlinePayKey$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: offlinePayKey$lambda-2  reason: not valid java name */
    public static final GetPublicKeyRpcResult m1905offlinePayKey$lambda2(GetPublicKeyRpcFacade getPublicKeyRpcFacade) {
        Intrinsics.checkNotNullParameter(getPublicKeyRpcFacade, "");
        return getPublicKeyRpcFacade.fetchPublicKey(new GetPublicKeyRpcRequest(PublicKeyScene.F2FPAY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: offlinePayKey$lambda-3  reason: not valid java name */
    public static final String m1906offlinePayKey$lambda3(GetPublicKeyRpcResult getPublicKeyRpcResult) {
        Intrinsics.checkNotNullParameter(getPublicKeyRpcResult, "");
        return getPublicKeyRpcResult.publicKey;
    }

    @Override // id.dana.data.security.source.SecurityEntityData
    public final Observable<String> cardCredentialKey() {
        Observable<String> map = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.security.source.network.NetworkSecurityEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GetPublicKeyRpcResult m1901cardCredentialKey$lambda4;
                m1901cardCredentialKey$lambda4 = NetworkSecurityEntityData.m1901cardCredentialKey$lambda4((GetPublicKeyRpcFacade) obj);
                return m1901cardCredentialKey$lambda4;
            }
        }).map(new Function() { // from class: id.dana.data.security.source.network.NetworkSecurityEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1902cardCredentialKey$lambda5;
                m1902cardCredentialKey$lambda5 = NetworkSecurityEntityData.m1902cardCredentialKey$lambda5((GetPublicKeyRpcResult) obj);
                return m1902cardCredentialKey$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cardCredentialKey$lambda-4  reason: not valid java name */
    public static final GetPublicKeyRpcResult m1901cardCredentialKey$lambda4(GetPublicKeyRpcFacade getPublicKeyRpcFacade) {
        Intrinsics.checkNotNullParameter(getPublicKeyRpcFacade, "");
        return getPublicKeyRpcFacade.fetchPublicKey(new GetPublicKeyRpcRequest(PublicKeyScene.CARD_CREDENTIAL));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cardCredentialKey$lambda-5  reason: not valid java name */
    public static final String m1902cardCredentialKey$lambda5(GetPublicKeyRpcResult getPublicKeyRpcResult) {
        Intrinsics.checkNotNullParameter(getPublicKeyRpcResult, "");
        return getPublicKeyRpcResult.publicKey;
    }
}
