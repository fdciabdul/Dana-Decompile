package id.dana.data.promoquest.repository.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.promoquest.repository.source.network.NetworkPromoQuestEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PromoQuestEntityDataFactory extends AbstractEntityDataFactory<PromoQuestEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final ThreadExecutor executor;
    private final RpcConnector rpcConnector;

    @Inject
    public PromoQuestEntityDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        this.rpcConnector = rpcConnector;
        this.executor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
        this.context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public PromoQuestEntityData createData2(String str) {
        str.hashCode();
        if (str.equals("network")) {
            return new NetworkPromoQuestEntityData(this.rpcConnector, this.executor, this.apSecurityFacade, this.context);
        }
        return null;
    }
}
