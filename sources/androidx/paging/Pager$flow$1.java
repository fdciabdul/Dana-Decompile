package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
final /* synthetic */ class Pager$flow$1<Key, Value> extends FunctionReferenceImpl implements Function1<PagingSource<Key, Value>>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Pager$flow$1(Object obj) {
        super(1, obj, SuspendingPagingSourceFactory.class, "KClassImpl$Data$declaredNonStaticMembers$2", "KClassImpl$Data$declaredNonStaticMembers$2(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((Continuation) ((Continuation) obj));
    }

    public final Object invoke(Continuation<? super PagingSource<Key, Value>> continuation) {
        return ((SuspendingPagingSourceFactory) this.receiver).KClassImpl$Data$declaredNonStaticMembers$2(continuation);
    }
}
