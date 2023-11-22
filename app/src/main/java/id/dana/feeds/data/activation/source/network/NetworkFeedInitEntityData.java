package id.dana.feeds.data.activation.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.social.core.SecureBaseNetwork;
import id.dana.feeds.data.activation.source.FeedInitEntityData;
import id.dana.feeds.data.activation.source.network.request.InitFeedRequest;
import id.dana.feeds.data.activation.source.network.response.InitFeedResponse;
import id.dana.network.rpc.RpcConnector;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0019\u0012\u0006\u0010\b\u001a\u00020\u001a\u0012\u0006\u0010\u0015\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\t\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/activation/source/network/NetworkFeedInitEntityData;", "Lid/dana/data/social/core/SecureBaseNetwork;", "Lid/dana/feeds/data/activation/source/network/FeedInitFacade;", "Lid/dana/feeds/data/activation/source/FeedInitEntityData;", "", "", "p0", "Lid/dana/domain/sendmoney/model/UserContact;", "p1", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "Lid/dana/feeds/data/activation/source/network/response/InitFeedResponse;", "PlaceComponentResult", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Z", "p2", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "Landroid/content/Context;", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkFeedInitEntityData extends SecureBaseNetwork<FeedInitFacade> implements FeedInitEntityData {
    @Override // id.dana.data.social.core.BaseNetwork
    public final Class<FeedInitFacade> getFacadeClass() {
        return FeedInitFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkFeedInitEntityData(RpcConnector rpcConnector, ApSecurityFacade apSecurityFacade, Context context) {
        super(apSecurityFacade, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object BuiltInFictitiousFunctionClassFactory(kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData$filterDanaUser$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData$filterDanaUser$1 r0 = (id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData$filterDanaUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData$filterDanaUser$1 r0 = new id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData$filterDanaUser$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L46
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData$filterDanaUser$2 r5 = new id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData$filterDanaUser$2
            r2 = 0
            r5.<init>()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r0.label = r3
            java.lang.Object r5 = r4.wrapper(r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult r5 = (id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult) r5
            java.util.List<java.lang.String> r5 = r5.registeredUsers
            if (r5 != 0) goto L50
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L50:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData.BuiltInFictitiousFunctionClassFactory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // id.dana.feeds.data.activation.source.FeedInitEntityData
    public final Object PlaceComponentResult(final int i, Continuation<? super InitFeedResponse> continuation) {
        return wrapper(new Function1<FeedInitFacade, InitFeedResponse>() { // from class: id.dana.feeds.data.activation.source.network.NetworkFeedInitEntityData$initFeed$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final InitFeedResponse invoke(FeedInitFacade feedInitFacade) {
                Intrinsics.checkNotNullParameter(feedInitFacade, "");
                return feedInitFacade.initFeed(new InitFeedRequest(i, 0L, 2, null));
            }
        }, continuation);
    }

    @Override // id.dana.feeds.data.activation.source.FeedInitEntityData
    public final boolean getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.feeds.data.activation.source.FeedInitEntityData
    public final void MyBillsEntityDataFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        throw new UnsupportedOperationException();
    }
}
