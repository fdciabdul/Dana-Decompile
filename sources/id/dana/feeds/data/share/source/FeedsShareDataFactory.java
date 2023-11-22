package id.dana.feeds.data.share.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.share.source.network.NetworkFeedsShareEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Lid/dana/feeds/data/share/source/FeedsShareDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/feeds/data/share/source/FeedsShareData;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/network/rpc/RpcConnector;", "PlaceComponentResult", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsShareDataFactory extends AbstractEntityDataFactory<FeedsShareData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ThreadExecutor KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ApSecurityFacade MyBillsEntityDataFactory;
    public final RpcConnector PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;

    @Inject
    public FeedsShareDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = rpcConnector;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = threadExecutor;
        this.MyBillsEntityDataFactory = apSecurityFacade;
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ FeedsShareData createData2(String str) {
        return new NetworkFeedsShareEntityData(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
    }
}
