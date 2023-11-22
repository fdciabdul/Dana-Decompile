package id.dana.data.usercredential.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.usercredential.model.QueryCredentialInfoResult;
import id.dana.data.usercredential.repository.CredentialEntityData;
import id.dana.domain.usercredential.model.PinRegularChangesConfig;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/usercredential/repository/source/network/NetworkCredentialEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/usercredential/repository/source/network/CredentialFacade;", "Lid/dana/data/usercredential/repository/CredentialEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lio/reactivex/Observable;", "Lid/dana/data/usercredential/model/QueryCredentialInfoResult;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Landroid/content/Context;", "p0", "Lid/dana/network/rpc/RpcConnector;", "p1", "Lid/dana/utils/concurrent/ThreadExecutor;", "p2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkCredentialEntityData extends SecureBaseNetwork<CredentialFacade> implements CredentialEntityData {
    @Override // id.dana.data.usercredential.repository.CredentialEntityData
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(QueryCredentialInfoResult queryCredentialInfoResult) {
        CredentialEntityData.CC.MyBillsEntityDataFactory(queryCredentialInfoResult);
    }

    @Override // id.dana.data.usercredential.repository.CredentialEntityData
    public final /* synthetic */ PinRegularChangesConfig KClassImpl$Data$declaredNonStaticMembers$2() {
        return CredentialEntityData.CC.PlaceComponentResult();
    }

    @Override // id.dana.data.usercredential.repository.CredentialEntityData
    public final /* synthetic */ void getAuthRequestContext(PinRegularChangesConfig pinRegularChangesConfig) {
        CredentialEntityData.CC.PlaceComponentResult(pinRegularChangesConfig);
    }

    @Override // id.dana.network.base.BaseNetwork
    public final Class<CredentialFacade> getFacadeClass() {
        return CredentialFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkCredentialEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.usercredential.repository.CredentialEntityData
    public final Observable<QueryCredentialInfoResult> getAuthRequestContext() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.usercredential.repository.source.network.NetworkCredentialEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkCredentialEntityData.KClassImpl$Data$declaredNonStaticMembers$2(NetworkCredentialEntityData.this, (CredentialFacade) obj);
            }
        }, QueryCredentialInfoResult.class);
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ QueryCredentialInfoResult KClassImpl$Data$declaredNonStaticMembers$2(NetworkCredentialEntityData networkCredentialEntityData, CredentialFacade credentialFacade) {
        Intrinsics.checkNotNullParameter(networkCredentialEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkCredentialEntityData.generateMobileEnvInfo();
        return credentialFacade.getPasswordLastModified(baseRpcRequest);
    }
}
