package id.dana.data.globalnetwork.source;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.globalnetwork.source.network.NetworkUniPaymentEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/data/globalnetwork/source/UniPaymentDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/globalnetwork/source/UniPaymentEntityData;", "", "source", "Lid/dana/data/globalnetwork/source/network/NetworkUniPaymentEntityData;", "createData", "(Ljava/lang/String;)Lid/dana/data/globalnetwork/source/network/NetworkUniPaymentEntityData;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "getApSecurityFacade", "()Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/network/rpc/RpcConnector;", "getRpcConnector", "()Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/utils/concurrent/ThreadExecutor;", "getThreadExecutor", "()Lid/dana/utils/concurrent/ThreadExecutor;", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UniPaymentDataFactory extends AbstractEntityDataFactory<UniPaymentEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final RpcConnector rpcConnector;
    private final ThreadExecutor threadExecutor;

    @JvmName(name = "getRpcConnector")
    public final RpcConnector getRpcConnector() {
        return this.rpcConnector;
    }

    @JvmName(name = "getThreadExecutor")
    public final ThreadExecutor getThreadExecutor() {
        return this.threadExecutor;
    }

    @JvmName(name = "getApSecurityFacade")
    public final ApSecurityFacade getApSecurityFacade() {
        return this.apSecurityFacade;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @Inject
    public UniPaymentDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.rpcConnector = rpcConnector;
        this.threadExecutor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
        this.context = context;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final UniPaymentEntityData createData2(String source) {
        return new NetworkUniPaymentEntityData(this.rpcConnector, this.threadExecutor, this.apSecurityFacade, this.context);
    }
}
