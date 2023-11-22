package id.dana.data.resetpin.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.resetpin.ResetPinEntityData;
import id.dana.data.resetpin.model.ConsultForceDanaVizEnrollResult;
import id.dana.data.resetpin.model.CountPinChangeRequest;
import id.dana.data.resetpin.model.CountPinChangeResult;
import id.dana.data.resetpin.model.SelfUnfreezeRequest;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0015\u0012\u0006\u0010\u0011\u001a\u00020\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/resetpin/source/network/NetworkResetPinEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/resetpin/source/network/CredentialFacade;", "Lid/dana/data/resetpin/ResetPinEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/resetpin/model/ConsultForceDanaVizEnrollResult;", "PlaceComponentResult", "()Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/resetpin/model/CountPinChangeResult;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p0", "p1", "p2", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkResetPinEntityData extends SecureBaseNetwork<CredentialFacade> implements ResetPinEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<CredentialFacade> getFacadeClass() {
        return CredentialFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkResetPinEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    public final Observable<CountPinChangeResult> BuiltInFictitiousFunctionClassFactory() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.resetpin.source.network.NetworkResetPinEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkResetPinEntityData.PlaceComponentResult(NetworkResetPinEntityData.this, (CredentialFacade) obj);
            }
        }, CountPinChangeResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public final Observable<ConsultForceDanaVizEnrollResult> PlaceComponentResult() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.resetpin.source.network.NetworkResetPinEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkResetPinEntityData.BuiltInFictitiousFunctionClassFactory(NetworkResetPinEntityData.this, (CredentialFacade) obj);
            }
        }, ConsultForceDanaVizEnrollResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public final Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.resetpin.source.network.NetworkResetPinEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkResetPinEntityData.KClassImpl$Data$declaredNonStaticMembers$2(NetworkResetPinEntityData.this, (CredentialFacade) obj);
            }
        }, BaseRpcResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public final Observable<BaseRpcResult> getAuthRequestContext(final String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.resetpin.source.network.NetworkResetPinEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkResetPinEntityData.MyBillsEntityDataFactory(p0, p1, p2, this, (CredentialFacade) obj);
            }
        }, BaseRpcResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ CountPinChangeResult PlaceComponentResult(NetworkResetPinEntityData networkResetPinEntityData, CredentialFacade credentialFacade) {
        Intrinsics.checkNotNullParameter(networkResetPinEntityData, "");
        CountPinChangeRequest countPinChangeRequest = new CountPinChangeRequest();
        countPinChangeRequest.envInfo = networkResetPinEntityData.generateMobileEnvInfo();
        return credentialFacade.countPinChange(countPinChangeRequest);
    }

    public static /* synthetic */ ConsultForceDanaVizEnrollResult BuiltInFictitiousFunctionClassFactory(NetworkResetPinEntityData networkResetPinEntityData, CredentialFacade credentialFacade) {
        Intrinsics.checkNotNullParameter(networkResetPinEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkResetPinEntityData.generateMobileEnvInfo();
        return credentialFacade.consultForceDanaVizEnroll(baseRpcRequest);
    }

    public static /* synthetic */ BaseRpcResult KClassImpl$Data$declaredNonStaticMembers$2(NetworkResetPinEntityData networkResetPinEntityData, CredentialFacade credentialFacade) {
        Intrinsics.checkNotNullParameter(networkResetPinEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkResetPinEntityData.generateMobileEnvInfo();
        return credentialFacade.finishForceDanaVizEnroll(baseRpcRequest);
    }

    public static /* synthetic */ BaseRpcResult MyBillsEntityDataFactory(String str, String str2, String str3, NetworkResetPinEntityData networkResetPinEntityData, CredentialFacade credentialFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(networkResetPinEntityData, "");
        SelfUnfreezeRequest selfUnfreezeRequest = new SelfUnfreezeRequest(str, str2, str3);
        selfUnfreezeRequest.envInfo = networkResetPinEntityData.generateMobileEnvInfo();
        return credentialFacade.selfUnfreeze(selfUnfreezeRequest);
    }
}
