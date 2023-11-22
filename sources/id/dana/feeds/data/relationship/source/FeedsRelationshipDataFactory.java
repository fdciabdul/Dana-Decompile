package id.dana.feeds.data.relationship.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.relationship.source.network.NetworkRelationshipEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Lid/dana/feeds/data/relationship/source/FeedsRelationshipDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/feeds/data/relationship/source/RemoteRelationshipEntityData;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "getAuthRequestContext", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Lid/dana/network/rpc/RpcConnector;", "PlaceComponentResult", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsRelationshipDataFactory extends AbstractEntityDataFactory<RemoteRelationshipEntityData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ApSecurityFacade getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ThreadExecutor PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final RpcConnector BuiltInFictitiousFunctionClassFactory;

    @Inject
    public FeedsRelationshipDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = rpcConnector;
        this.PlaceComponentResult = threadExecutor;
        this.getAuthRequestContext = apSecurityFacade;
        this.MyBillsEntityDataFactory = context;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ RemoteRelationshipEntityData createData2(String str) {
        return new NetworkRelationshipEntityData(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }
}
