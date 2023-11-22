package androidx.paging.rxjava2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.paging.rxjava2.RxPagingSource", f = "RxPagingSource.kt", i = {}, l = {37}, m = "load", n = {}, s = {})
/* loaded from: classes6.dex */
final class RxPagingSource$load$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RxPagingSource<Key, Value> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RxPagingSource$load$1(RxPagingSource<Key, Value> rxPagingSource, Continuation<? super RxPagingSource$load$1> continuation) {
        super(continuation);
        this.this$0 = rxPagingSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.BuiltInFictitiousFunctionClassFactory(null, this);
    }
}
