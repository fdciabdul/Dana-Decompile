package id.dana.feeds.data.synccontact.source;

import android.content.Context;
import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityData;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "getAuthRequestContext", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "Lid/dana/network/rpc/RpcConnector;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/network/rpc/RpcConnector;", "p0", "p1", "p2", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsSyncProcessEntityDataFactory extends AbstractEntityDataFactory<FeedsSyncProcessEntityData> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final RpcConnector getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ApSecurityFacade BuiltInFictitiousFunctionClassFactory;

    @Inject
    public FeedsSyncProcessEntityDataFactory(RpcConnector rpcConnector, ApSecurityFacade apSecurityFacade, Context context) {
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = rpcConnector;
        this.BuiltInFictitiousFunctionClassFactory = apSecurityFacade;
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ FeedsSyncProcessEntityData createData2(String str) {
        return new NetworkSocialSyncProcessEntityData(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }
}
