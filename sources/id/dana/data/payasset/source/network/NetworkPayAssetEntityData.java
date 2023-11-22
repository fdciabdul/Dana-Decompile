package id.dana.data.payasset.source.network;

import android.content.Context;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.base.UnInitializedSecuredPreferencesException;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.payasset.source.PayAssetEntityData;
import id.dana.data.payasset.source.network.request.ChangePayMethodRequest;
import id.dana.data.payasset.source.network.request.QueryPayMethodRequest;
import id.dana.data.payasset.source.network.result.ChangePayMethodResult;
import id.dana.data.payasset.source.network.result.QueryPayMethodResult;
import id.dana.data.util.DateTimeUtil;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkPayAssetEntityData extends SecureBaseNetwork<PayMethodFacade> implements PayAssetEntityData {
    private final SecuredAccountPreferences accountPreferences;

    @Inject
    public NetworkPayAssetEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, SecuredAccountPreferences securedAccountPreferences) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        this.accountPreferences = securedAccountPreferences;
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<PayMethodFacade> getFacadeClass() {
        return PayMethodFacade.class;
    }

    @Override // id.dana.data.payasset.source.PayAssetEntityData
    public Observable<ChangePayMethodResult> changePayMethod(String str, String str2, String str3) {
        final ChangePayMethodRequest changePayMethodRequest = new ChangePayMethodRequest();
        changePayMethodRequest.envInfo = generateMobileEnvInfo();
        changePayMethodRequest.payMethod = str;
        changePayMethodRequest.payOption = str2;
        changePayMethodRequest.cardIndexNo = str3;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.payasset.source.network.NetworkPayAssetEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                ChangePayMethodResult changePayMethod;
                changePayMethod = ((PayMethodFacade) obj).changePayMethod(ChangePayMethodRequest.this);
                return changePayMethod;
            }
        });
    }

    @Override // id.dana.data.payasset.source.PayAssetEntityData
    public Observable<QueryPayMethodResult> queryPayMethod(String str, final String str2) {
        final QueryPayMethodRequest queryPayMethodRequest = new QueryPayMethodRequest();
        queryPayMethodRequest.envInfo = generateMobileEnvInfo();
        queryPayMethodRequest.tid = str;
        queryPayMethodRequest.scene = str2;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.payasset.source.network.NetworkPayAssetEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                QueryPayMethodResult queryPayMethod;
                queryPayMethod = ((PayMethodFacade) obj).queryPayMethod(QueryPayMethodRequest.this);
                return queryPayMethod;
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.payasset.source.network.NetworkPayAssetEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NetworkPayAssetEntityData.this.m1558xa7f595b7(str2, (QueryPayMethodResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveQueryPayResult  reason: merged with bridge method [inline-methods] */
    public void m1558xa7f595b7(String str, QueryPayMethodResult queryPayMethodResult) throws UnInitializedSecuredPreferencesException {
        queryPayMethodResult.lastUpdate = Long.valueOf(DateTimeUtil.getCurrentTimeMillis());
        if (str == null) {
            this.accountPreferences.savePayMethodResult(queryPayMethodResult);
        } else {
            this.accountPreferences.saveAssetCardResult(queryPayMethodResult);
        }
    }
}
