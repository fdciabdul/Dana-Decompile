package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl", f = "RemoteMediatorAccessor.kt", i = {0}, l = {397}, m = "initialize", n = {"this"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class RemoteMediatorAccessImpl$initialize$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteMediatorAccessImpl<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$initialize$1(RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl, Continuation<? super RemoteMediatorAccessImpl$initialize$1> continuation) {
        super(continuation);
        this.this$0 = remoteMediatorAccessImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.MyBillsEntityDataFactory(this);
    }
}
