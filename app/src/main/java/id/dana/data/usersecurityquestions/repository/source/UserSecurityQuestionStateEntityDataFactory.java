package id.dana.data.usersecurityquestions.repository.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.usersecurityquestions.UserSecurityQuestionStateEntityData;
import id.dana.data.usersecurityquestions.repository.source.network.NetworkUserSecurityQuestionStateEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class UserSecurityQuestionStateEntityDataFactory extends AbstractEntityDataFactory<UserSecurityQuestionStateEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final RpcConnector rpcConnector;
    private final SecurityGuardFacade securityGuardFacade;
    private final ThreadExecutor threadExecutor;

    @Inject
    public UserSecurityQuestionStateEntityDataFactory(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, SecurityGuardFacade securityGuardFacade) {
        this.context = context;
        this.rpcConnector = rpcConnector;
        this.threadExecutor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
        this.securityGuardFacade = securityGuardFacade;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public UserSecurityQuestionStateEntityData createData2(String str) {
        return new NetworkUserSecurityQuestionStateEntityData(this.rpcConnector, this.threadExecutor, this.apSecurityFacade, this.securityGuardFacade, this.context);
    }
}
