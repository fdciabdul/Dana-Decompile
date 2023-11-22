package id.dana.data.kycamledd.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.kycamledd.repository.source.KycAmlEntityData;
import id.dana.data.kycamledd.repository.source.network.request.EddInfoRequest;
import id.dana.data.kycamledd.repository.source.network.response.EddConsultResponse;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/kycamledd/repository/source/network/NetworkKycAmlEddEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/kycamledd/repository/source/network/KycAmlEddFacade;", "Lid/dana/data/kycamledd/repository/source/KycAmlEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/kycamledd/repository/source/network/response/EddConsultResponse;", "getAmlEddConsult", "()Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/kycamledd/repository/source/network/request/EddInfoRequest;", "eddInfoRequest", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "submitAmlEdd", "(Lid/dana/data/kycamledd/repository/source/network/request/EddInfoRequest;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "securityFacade", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkKycAmlEddEntityData extends SecureBaseNetwork<KycAmlEddFacade> implements KycAmlEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<KycAmlEddFacade> getFacadeClass() {
        return KycAmlEddFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkKycAmlEddEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.kycamledd.repository.source.KycAmlEntityData
    public final Observable<EddConsultResponse> getAmlEddConsult() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.kycamledd.repository.source.network.NetworkKycAmlEddEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                EddConsultResponse m1385getAmlEddConsult$lambda1;
                m1385getAmlEddConsult$lambda1 = NetworkKycAmlEddEntityData.m1385getAmlEddConsult$lambda1(NetworkKycAmlEddEntityData.this, (KycAmlEddFacade) obj);
                return m1385getAmlEddConsult$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAmlEddConsult$lambda-1  reason: not valid java name */
    public static final EddConsultResponse m1385getAmlEddConsult$lambda1(NetworkKycAmlEddEntityData networkKycAmlEddEntityData, KycAmlEddFacade kycAmlEddFacade) {
        Intrinsics.checkNotNullParameter(networkKycAmlEddEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkKycAmlEddEntityData.generateMobileEnvInfo();
        return kycAmlEddFacade.consultEdd(baseRpcRequest);
    }

    @Override // id.dana.data.kycamledd.repository.source.KycAmlEntityData
    public final Observable<BaseRpcResult> submitAmlEdd(final EddInfoRequest eddInfoRequest) {
        Intrinsics.checkNotNullParameter(eddInfoRequest, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.kycamledd.repository.source.network.NetworkKycAmlEddEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BaseRpcResult m1386submitAmlEdd$lambda3;
                m1386submitAmlEdd$lambda3 = NetworkKycAmlEddEntityData.m1386submitAmlEdd$lambda3(EddInfoRequest.this, this, (KycAmlEddFacade) obj);
                return m1386submitAmlEdd$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: submitAmlEdd$lambda-3  reason: not valid java name */
    public static final BaseRpcResult m1386submitAmlEdd$lambda3(EddInfoRequest eddInfoRequest, NetworkKycAmlEddEntityData networkKycAmlEddEntityData, KycAmlEddFacade kycAmlEddFacade) {
        Intrinsics.checkNotNullParameter(eddInfoRequest, "");
        Intrinsics.checkNotNullParameter(networkKycAmlEddEntityData, "");
        eddInfoRequest.envInfo = networkKycAmlEddEntityData.generateMobileEnvInfo();
        return kycAmlEddFacade.submitEdd(eddInfoRequest);
    }
}
