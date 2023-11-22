package id.dana.data.promocode.repository.source;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.promocode.repository.source.network.NetworkPromoCodeEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/promocode/repository/source/PromoCodeEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/promocode/repository/source/PromoCodeEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/promocode/repository/source/PromoCodeEntityData;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/utils/concurrent/ThreadExecutor;", "executor", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/network/rpc/RpcConnector;", "<init>", "(Landroid/content/Context;Lid/dana/data/foundation/facade/ApSecurityFacade;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/network/rpc/RpcConnector;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoCodeEntityDataFactory extends AbstractEntityDataFactory<PromoCodeEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final ThreadExecutor executor;
    private final RpcConnector rpcConnector;

    @Inject
    public PromoCodeEntityDataFactory(Context context, ApSecurityFacade apSecurityFacade, ThreadExecutor threadExecutor, RpcConnector rpcConnector) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        this.context = context;
        this.apSecurityFacade = apSecurityFacade;
        this.executor = threadExecutor;
        this.rpcConnector = rpcConnector;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final PromoCodeEntityData createData2(String source) {
        return new NetworkPromoCodeEntityData(this.rpcConnector, this.executor, this.apSecurityFacade, this.context);
    }
}
