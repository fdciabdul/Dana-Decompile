package id.dana.feeds.data.username.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.social.core.SecureBaseNetwork;
import id.dana.feeds.data.username.source.UserProfileEntityData;
import id.dana.feeds.data.username.source.network.response.CheckUsernameResult;
import id.dana.feeds.data.username.source.network.response.UpdateUserInfoResult;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/feeds/data/username/source/network/NetworkUserProfileEntityData;", "Lid/dana/data/social/core/SecureBaseNetwork;", "Lid/dana/feeds/data/username/source/network/UserProfileService;", "Lid/dana/feeds/data/username/source/UserProfileEntityData;", "", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/feeds/data/username/source/network/response/UpdateUserInfoResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/feeds/data/username/source/network/response/CheckUsernameResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p1", "Landroid/content/Context;", "p2", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkUserProfileEntityData extends SecureBaseNetwork<UserProfileService> implements UserProfileEntityData {
    @Override // id.dana.data.social.core.BaseNetwork
    public final Class<UserProfileService> getFacadeClass() {
        return UserProfileService.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkUserProfileEntityData(RpcConnector rpcConnector, ApSecurityFacade apSecurityFacade, Context context) {
        super(apSecurityFacade, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.feeds.data.username.source.UserProfileEntityData
    public final Flow<UpdateUserInfoResult> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flow(new NetworkUserProfileEntityData$changeUsername$1(p0, this, null));
    }

    @Override // id.dana.feeds.data.username.source.UserProfileEntityData
    public final Flow<CheckUsernameResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flow(new NetworkUserProfileEntityData$checkUsername$1(p0, this, null));
    }
}
