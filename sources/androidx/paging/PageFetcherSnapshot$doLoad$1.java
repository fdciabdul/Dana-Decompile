package androidx.paging;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.wireless.security.SecExceptionCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {SecExceptionCode.SEC_ERROR_SIGNATURE_INCORRECT_DATA_FILE, 620, 398, SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_ENCRYPTED_DATA, 631, 642, 448, 653, 470, 496, 664}, m = "doLoad", n = {"this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "this_$iv", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "loadKey", "this_$iv", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "loadKey", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "result", "this_$iv", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "result", "this_$iv", "$this$withLock_u24default$iv$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "$this$withLock_u24default$iv$iv", "state", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "result", "dropType", "this_$iv", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "result", "$this$withLock_u24default$iv$iv", "state", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "params", "result", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "generationalHint", "itemsLoaded", "loadKey", "endOfPaginationReached", "this_$iv", "$this$withLock_u24default$iv$iv", "endsPrepend", "endsAppend"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1"})
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$doLoad$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$doLoad$1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super PageFetcherSnapshot$doLoad$1> continuation) {
        super(continuation);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object BuiltInFictitiousFunctionClassFactory;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        BuiltInFictitiousFunctionClassFactory = this.this$0.BuiltInFictitiousFunctionClassFactory((LoadType) null, (GenerationalViewportHint) null, this);
        return BuiltInFictitiousFunctionClassFactory;
    }
}
