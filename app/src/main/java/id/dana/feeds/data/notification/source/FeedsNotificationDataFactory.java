package id.dana.feeds.data.notification.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.notification.source.network.NetworkFeedsNotificationEntityData;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000f"}, d2 = {"Lid/dana/feeds/data/notification/source/FeedsNotificationDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/feeds/data/notification/source/FeedsNotificationData;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "MyBillsEntityDataFactory", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "PlaceComponentResult", "Landroid/content/Context;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/network/rpc/RpcConnector;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/network/rpc/RpcConnector;", "getAuthRequestContext", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsNotificationDataFactory extends AbstractEntityDataFactory<FeedsNotificationData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final RpcConnector getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ThreadExecutor BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ApSecurityFacade PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public FeedsNotificationDataFactory(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = rpcConnector;
        this.BuiltInFictitiousFunctionClassFactory = threadExecutor;
        this.PlaceComponentResult = apSecurityFacade;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ FeedsNotificationData createData2(String str) {
        return new NetworkFeedsNotificationEntityData(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
