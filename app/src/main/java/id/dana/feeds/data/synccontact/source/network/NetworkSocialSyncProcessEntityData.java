package id.dana.feeds.data.synccontact.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.social.core.SecureBaseNetwork;
import id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityData;
import id.dana.feeds.data.synccontact.source.network.request.FeedsSyncRequest;
import id.dana.feeds.data.synccontact.source.network.response.FeedsSyncResponse;
import id.dana.feeds.data.synccontact.source.network.response.FeedsUserContact;
import id.dana.network.rpc.RpcConnector;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0012\u0012\u0006\u0010\b\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\t\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/synccontact/source/network/NetworkSocialSyncProcessEntityData;", "Lid/dana/data/social/core/SecureBaseNetwork;", "Lid/dana/feeds/data/synccontact/source/network/FeedsSyncProcessFacade;", "Lid/dana/feeds/data/synccontact/source/FeedsSyncProcessEntityData;", "", "", "p0", "Lid/dana/domain/sendmoney/model/UserContact;", "p1", "getAuthRequestContext", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsUserContact;", "Lid/dana/feeds/data/synccontact/source/network/response/FeedsSyncResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", "p2", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkSocialSyncProcessEntityData extends SecureBaseNetwork<FeedsSyncProcessFacade> implements FeedsSyncProcessEntityData {
    @Override // id.dana.data.social.core.BaseNetwork
    public final Class<FeedsSyncProcessFacade> getFacadeClass() {
        return FeedsSyncProcessFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkSocialSyncProcessEntityData(RpcConnector rpcConnector, ApSecurityFacade apSecurityFacade, Context context) {
        super(apSecurityFacade, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext(final java.util.List<java.lang.String> r5, final java.util.List<id.dana.domain.sendmoney.model.UserContact> r6, kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData$filterDanaUser$1
            if (r0 == 0) goto L14
            r0 = r7
            id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData$filterDanaUser$1 r0 = (id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData$filterDanaUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData$filterDanaUser$1 r0 = new id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData$filterDanaUser$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData$filterDanaUser$2 r7 = new id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData$filterDanaUser$2
            r7.<init>()
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r0.label = r3
            java.lang.Object r7 = r4.wrapper(r7, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult r7 = (id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult) r7
            java.util.List<java.lang.String> r5 = r7.registeredUsers
            if (r5 != 0) goto L4f
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L4f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData.getAuthRequestContext(java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsSyncProcessEntityData
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(final List<FeedsUserContact> list, Continuation<? super FeedsSyncResponse> continuation) {
        return wrapper(new Function1<FeedsSyncProcessFacade, FeedsSyncResponse>() { // from class: id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData$syncContact$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FeedsSyncResponse invoke(FeedsSyncProcessFacade feedsSyncProcessFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(feedsSyncProcessFacade, "");
                FeedsSyncRequest feedsSyncRequest = new FeedsSyncRequest(list);
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                feedsSyncRequest.envInfo = generateMobileEnvInfo;
                return feedsSyncProcessFacade.syncSocialContact(feedsSyncRequest);
            }
        }, continuation);
    }
}
