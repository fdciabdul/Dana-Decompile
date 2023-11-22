package id.dana.data.globalnetwork.source;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.globalnetwork.GlobalNetworkEntityData;
import id.dana.data.globalnetwork.source.local.GlobalNetworkPreference;
import id.dana.data.globalnetwork.source.local.PreferenceGlobalNetworkEntityData;
import id.dana.data.globalnetwork.source.network.NetworkGlobalNetworkEntityData;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/data/globalnetwork/source/GlobalNetworkDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/globalnetwork/GlobalNetworkEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/globalnetwork/GlobalNetworkEntityData;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/data/globalnetwork/source/local/GlobalNetworkPreference;", "globalNetworkPreference", "Lid/dana/data/globalnetwork/source/local/GlobalNetworkPreference;", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/utils/concurrent/ThreadExecutor;", "<init>", "(Landroid/content/Context;Lid/dana/data/globalnetwork/source/local/GlobalNetworkPreference;Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalNetworkDataFactory extends AbstractEntityDataFactory<GlobalNetworkEntityData> {
    private final ApSecurityFacade apSecurityFacade;
    private final Context context;
    private final FeatureConfigRepository featureConfigRepository;
    private final GlobalNetworkPreference globalNetworkPreference;
    private final RpcConnector rpcConnector;
    private final ThreadExecutor threadExecutor;

    @Inject
    public GlobalNetworkDataFactory(Context context, GlobalNetworkPreference globalNetworkPreference, FeatureConfigRepository featureConfigRepository, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(globalNetworkPreference, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        this.context = context;
        this.globalNetworkPreference = globalNetworkPreference;
        this.featureConfigRepository = featureConfigRepository;
        this.rpcConnector = rpcConnector;
        this.threadExecutor = threadExecutor;
        this.apSecurityFacade = apSecurityFacade;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final GlobalNetworkEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        if (Intrinsics.areEqual("local", source)) {
            return new PreferenceGlobalNetworkEntityData(this.globalNetworkPreference);
        }
        return new NetworkGlobalNetworkEntityData(this.context, this.featureConfigRepository, this.rpcConnector, this.threadExecutor, this.apSecurityFacade);
    }
}
