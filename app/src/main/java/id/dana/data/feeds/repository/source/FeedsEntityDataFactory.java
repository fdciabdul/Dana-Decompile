package id.dana.data.feeds.repository.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.feeds.repository.source.network.NetworkFeedsEntityData;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class FeedsEntityDataFactory extends AbstractEntityDataFactory<FeedsEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final RpcConnector rpcConnector;
    private final ThreadExecutor threadExecutor;

    @Inject
    public FeedsEntityDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        this.rpcConnector = rpcConnector;
        this.threadExecutor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
        this.context = context;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public FeedsEntityData createData2(String str) {
        return new NetworkFeedsEntityData(this.rpcConnector, this.threadExecutor, this.apSecurityFacade, this.context);
    }
}
