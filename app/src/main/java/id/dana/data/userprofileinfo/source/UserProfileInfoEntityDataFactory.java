package id.dana.data.userprofileinfo.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.userprofileinfo.source.network.NetworkUserProfileInfoEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class UserProfileInfoEntityDataFactory extends AbstractEntityDataFactory<UserProfileInfoEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final RpcConnector rpcConnector;
    private final ThreadExecutor threadExecutor;

    @Inject
    public UserProfileInfoEntityDataFactory(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        this.context = context;
        this.rpcConnector = rpcConnector;
        this.threadExecutor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public UserProfileInfoEntityData createData2(String str) {
        return new NetworkUserProfileInfoEntityData(this.rpcConnector, this.threadExecutor, this.apSecurityFacade, this.context);
    }
}
