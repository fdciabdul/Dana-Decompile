package id.dana.data.ott.repository.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.ott.repository.source.network.NetworkOttEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/ott/repository/source/OttEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/ott/repository/source/OttEntityData;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "getAuthRequestContext", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "Lid/dana/utils/concurrent/ThreadExecutor;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/network/rpc/RpcConnector;", "MyBillsEntityDataFactory", "Lid/dana/network/rpc/RpcConnector;", "p0", "p1", "p2", "p3", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OttEntityDataFactory extends AbstractEntityDataFactory<OttEntityData> {
    public final ThreadExecutor BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ApSecurityFacade getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final RpcConnector PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public OttEntityDataFactory(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = rpcConnector;
        this.BuiltInFictitiousFunctionClassFactory = threadExecutor;
        this.getAuthRequestContext = apSecurityFacade;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ OttEntityData createData2(String str) {
        return new NetworkOttEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
    }
}
