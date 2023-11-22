package androidx.paging;

import com.alibaba.wireless.security.SecExceptionCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8}, l = {SecExceptionCode.SEC_ERROR_SIGNATURE_NO_DATA_FILE, 280, 283, 619, 630, 317, 641, 652, 341}, m = "doInitialLoad", n = {"this", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "$this$withLock_u24default$iv$iv", "this", "this", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "result", "$this$withLock_u24default$iv$iv", "this", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$doInitialLoad$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$doInitialLoad$1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super PageFetcherSnapshot$doInitialLoad$1> continuation) {
        super(continuation);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object BuiltInFictitiousFunctionClassFactory;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        BuiltInFictitiousFunctionClassFactory = this.this$0.BuiltInFictitiousFunctionClassFactory(this);
        return BuiltInFictitiousFunctionClassFactory;
    }
}
