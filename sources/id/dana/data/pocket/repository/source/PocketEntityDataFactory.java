package id.dana.data.pocket.repository.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.pocket.repository.PocketEntityData;
import id.dana.data.pocket.repository.source.network.NetworkPocketEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PocketEntityDataFactory extends AbstractEntityDataFactory<PocketEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final ThreadExecutor executor;
    private final RpcConnector rpcConnector;

    @Inject
    public PocketEntityDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        this.rpcConnector = rpcConnector;
        this.executor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
        this.context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public PocketEntityData createData2(String str) {
        return new NetworkPocketEntityData(this.rpcConnector, this.executor, this.apSecurityFacade, this.context);
    }
}
