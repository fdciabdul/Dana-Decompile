package androidx.paging.rxjava2;

import androidx.paging.RemoteMediator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.paging.rxjava2.RxRemoteMediator", f = "RxRemoteMediator.kt", i = {}, l = {97}, m = "initialize", n = {}, s = {})
/* loaded from: classes6.dex */
final class RxRemoteMediator$initialize$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RxRemoteMediator<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RxRemoteMediator$initialize$1(RxRemoteMediator<Key, Value> rxRemoteMediator, Continuation<? super RxRemoteMediator$initialize$1> continuation) {
        super(continuation);
        this.this$0 = rxRemoteMediator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RemoteMediator.getAuthRequestContext();
    }
}
