package id.dana.data.content.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.content.source.mock.MockContentDeliveryEntityData;
import id.dana.data.content.source.network.NetworkContentDeliveryEntityData;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.storage.Serializer;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class ContentDeliveryEntityDataFactory extends AbstractEntityDataFactory<ContentDeliveryEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final ThreadExecutor executor;
    private final RpcConnector rpcConnector;
    private final Serializer serializer;

    @Inject
    public ContentDeliveryEntityDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context, Serializer serializer) {
        this.rpcConnector = rpcConnector;
        this.executor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
        this.context = context;
        this.serializer = serializer;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ContentDeliveryEntityData createData2(String str) {
        if ("mock".equals(str)) {
            return new MockContentDeliveryEntityData(this.context, this.serializer);
        }
        return new NetworkContentDeliveryEntityData(this.rpcConnector, this.executor, this.apSecurityFacade, this.context);
    }
}
