package id.dana.data.merchantmanagement.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.merchantmanagement.MerchantManagementEntityData;
import id.dana.data.merchantmanagement.repository.source.network.request.BoundMerchantRequest;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindConsultRequest;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindEligibilityCheckRequest;
import id.dana.data.merchantmanagement.repository.source.network.request.UnbindMerchantRequest;
import id.dana.data.merchantmanagement.repository.source.network.result.BoundMerchantResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindConsultResult;
import id.dana.data.merchantmanagement.repository.source.network.result.UnbindEligibilityCheckResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/data/merchantmanagement/repository/source/network/NetworkMerchantManagementEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/merchantmanagement/repository/source/network/MerchantManagementFacade;", "Lid/dana/data/merchantmanagement/MerchantManagementEntityData;", "", "clientId", "merchantId", "divisionId", "Lio/reactivex/Observable;", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindEligibilityCheckResult;", "checkUnbindEligibility", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", ZdocRecordService.PAGE_NUMBER, "Lid/dana/data/merchantmanagement/repository/source/network/result/BoundMerchantResult;", "getLinkedMerchants", "(I)Lio/reactivex/Observable;", "Lid/dana/data/merchantmanagement/repository/source/network/result/UnbindConsultResult;", "unbindConsult", "Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;", "unbindMerchantRequest", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "unbindMerchant", "(Lid/dana/data/merchantmanagement/repository/source/network/request/UnbindMerchantRequest;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkMerchantManagementEntityData extends SecureBaseNetwork<MerchantManagementFacade> implements MerchantManagementEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<MerchantManagementFacade> getFacadeClass() {
        return MerchantManagementFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkMerchantManagementEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.data.merchantmanagement.MerchantManagementEntityData
    public final Observable<BoundMerchantResult> getLinkedMerchants(int pageNumber) {
        final BoundMerchantRequest boundMerchantRequest = new BoundMerchantRequest(pageNumber, 0, 2, null);
        boundMerchantRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.merchantmanagement.repository.source.network.NetworkMerchantManagementEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BoundMerchantResult m1507getLinkedMerchants$lambda0;
                m1507getLinkedMerchants$lambda0 = NetworkMerchantManagementEntityData.m1507getLinkedMerchants$lambda0(BoundMerchantRequest.this, (MerchantManagementFacade) obj);
                return m1507getLinkedMerchants$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLinkedMerchants$lambda-0  reason: not valid java name */
    public static final BoundMerchantResult m1507getLinkedMerchants$lambda0(BoundMerchantRequest boundMerchantRequest, MerchantManagementFacade merchantManagementFacade) {
        Intrinsics.checkNotNullParameter(boundMerchantRequest, "");
        return merchantManagementFacade.getLinkedMerchants(boundMerchantRequest);
    }

    @Override // id.dana.data.merchantmanagement.MerchantManagementEntityData
    public final Observable<UnbindConsultResult> unbindConsult(String clientId, String merchantId, String divisionId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        final UnbindConsultRequest unbindConsultRequest = new UnbindConsultRequest(null, null, null, 7, null);
        unbindConsultRequest.setClientId(clientId);
        unbindConsultRequest.setMerchantId(merchantId);
        unbindConsultRequest.setDivisionId(divisionId);
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.merchantmanagement.repository.source.network.NetworkMerchantManagementEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UnbindConsultResult m1508unbindConsult$lambda2;
                m1508unbindConsult$lambda2 = NetworkMerchantManagementEntityData.m1508unbindConsult$lambda2(UnbindConsultRequest.this, (MerchantManagementFacade) obj);
                return m1508unbindConsult$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: unbindConsult$lambda-2  reason: not valid java name */
    public static final UnbindConsultResult m1508unbindConsult$lambda2(UnbindConsultRequest unbindConsultRequest, MerchantManagementFacade merchantManagementFacade) {
        Intrinsics.checkNotNullParameter(unbindConsultRequest, "");
        return merchantManagementFacade.unbindConsult(unbindConsultRequest);
    }

    @Override // id.dana.data.merchantmanagement.MerchantManagementEntityData
    public final Observable<BaseRpcResult> unbindMerchant(final UnbindMerchantRequest unbindMerchantRequest) {
        Intrinsics.checkNotNullParameter(unbindMerchantRequest, "");
        unbindMerchantRequest.envInfo = generateMobileEnvInfo();
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.merchantmanagement.repository.source.network.NetworkMerchantManagementEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BaseRpcResult m1509unbindMerchant$lambda3;
                m1509unbindMerchant$lambda3 = NetworkMerchantManagementEntityData.m1509unbindMerchant$lambda3(UnbindMerchantRequest.this, (MerchantManagementFacade) obj);
                return m1509unbindMerchant$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: unbindMerchant$lambda-3  reason: not valid java name */
    public static final BaseRpcResult m1509unbindMerchant$lambda3(UnbindMerchantRequest unbindMerchantRequest, MerchantManagementFacade merchantManagementFacade) {
        Intrinsics.checkNotNullParameter(unbindMerchantRequest, "");
        return merchantManagementFacade.unbindMerchant(unbindMerchantRequest);
    }

    @Override // id.dana.data.merchantmanagement.MerchantManagementEntityData
    public final Observable<UnbindEligibilityCheckResult> checkUnbindEligibility(String clientId, String merchantId, String divisionId) {
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(merchantId, "");
        final UnbindEligibilityCheckRequest unbindEligibilityCheckRequest = new UnbindEligibilityCheckRequest(clientId, merchantId, divisionId);
        unbindEligibilityCheckRequest.envInfo = generateMobileEnvInfo();
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.merchantmanagement.repository.source.network.NetworkMerchantManagementEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UnbindEligibilityCheckResult m1506checkUnbindEligibility$lambda5;
                m1506checkUnbindEligibility$lambda5 = NetworkMerchantManagementEntityData.m1506checkUnbindEligibility$lambda5(UnbindEligibilityCheckRequest.this, (MerchantManagementFacade) obj);
                return m1506checkUnbindEligibility$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkUnbindEligibility$lambda-5  reason: not valid java name */
    public static final UnbindEligibilityCheckResult m1506checkUnbindEligibility$lambda5(UnbindEligibilityCheckRequest unbindEligibilityCheckRequest, MerchantManagementFacade merchantManagementFacade) {
        Intrinsics.checkNotNullParameter(unbindEligibilityCheckRequest, "");
        return merchantManagementFacade.checkUnbindEligibility(unbindEligibilityCheckRequest);
    }
}
