package id.dana.data.splitbill.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.splitbill.repository.source.SplitBillEntityData;
import id.dana.data.splitbill.repository.source.network.request.GetSplitBillCloseRequest;
import id.dana.data.splitbill.repository.source.network.request.GetSplitBillDetailRequest;
import id.dana.data.splitbill.repository.source.network.request.GetSplitBillHistoriesRequest;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillDetailResult;
import id.dana.data.splitbill.repository.source.network.response.GetSplitBillHistoriesResult;
import id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class NetworkSplitBillEntityData extends SecureBaseNetwork<SplitBillFacade> implements SplitBillEntityData {
    @Inject
    public NetworkSplitBillEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<SplitBillFacade> getFacadeClass() {
        return SplitBillFacade.class;
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<Long> saveSplitBillHistory(SplitBillHistoryEntity splitBillHistoryEntity) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<GetSplitBillHistoriesResult> getSplitBillHistories(int i) {
        final GetSplitBillHistoriesRequest getSplitBillHistoriesRequest = new GetSplitBillHistoriesRequest();
        getSplitBillHistoriesRequest.pageNum = i;
        getSplitBillHistoriesRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.splitbill.repository.source.network.NetworkSplitBillEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GetSplitBillHistoriesResult splitBillHistories;
                splitBillHistories = ((SplitBillFacade) obj).getSplitBillHistories(GetSplitBillHistoriesRequest.this);
                return splitBillHistories;
            }
        });
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<Boolean> updateSplitBillHistories(List<SplitBillHistoryEntity> list) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public void clearAll() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<GetSplitBillDetailResult> getSplitBillDetail(String str) {
        final GetSplitBillDetailRequest getSplitBillDetailRequest = new GetSplitBillDetailRequest();
        getSplitBillDetailRequest.splitBillId = str;
        getSplitBillDetailRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.splitbill.repository.source.network.NetworkSplitBillEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GetSplitBillDetailResult splitBillDetail;
                splitBillDetail = ((SplitBillFacade) obj).getSplitBillDetail(GetSplitBillDetailRequest.this);
                return splitBillDetail;
            }
        });
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<Boolean> updateSplitBillDetail(SplitBillHistoryEntity splitBillHistoryEntity) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.splitbill.repository.source.SplitBillEntityData
    public Observable<BaseRpcResult> closePayers(List<String> list, String str) {
        final GetSplitBillCloseRequest getSplitBillCloseRequest = new GetSplitBillCloseRequest();
        getSplitBillCloseRequest.closePayers = new ArrayList();
        getSplitBillCloseRequest.closePayers.addAll(list);
        getSplitBillCloseRequest.splitBillId = str;
        getSplitBillCloseRequest.envInfo = generateMobileEnvInfo();
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.splitbill.repository.source.network.NetworkSplitBillEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                BaseRpcResult closePayers;
                closePayers = ((SplitBillFacade) obj).closePayers(GetSplitBillCloseRequest.this);
                return closePayers;
            }
        });
    }
}
