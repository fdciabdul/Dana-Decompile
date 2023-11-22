package id.dana.feeds.data.synccontact.source.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "id.dana.feeds.data.synccontact.source.network.NetworkSocialSyncProcessEntityData", f = "NetworkSocialSyncProcessEntityData.kt", i = {}, l = {35}, m = "filterDanaUser", n = {}, s = {})
/* loaded from: classes5.dex */
public final class NetworkSocialSyncProcessEntityData$filterDanaUser$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkSocialSyncProcessEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkSocialSyncProcessEntityData$filterDanaUser$1(NetworkSocialSyncProcessEntityData networkSocialSyncProcessEntityData, Continuation<? super NetworkSocialSyncProcessEntityData$filterDanaUser$1> continuation) {
        super(continuation);
        this.this$0 = networkSocialSyncProcessEntityData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAuthRequestContext(null, null, this);
    }
}
