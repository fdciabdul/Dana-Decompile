package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004B)\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/SuspendingPagingSourceFactory;", "", "Key", "Value", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "p0", "p1", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SuspendingPagingSourceFactory<Key, Value> implements Function0<PagingSource<Key, Value>> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function0<PagingSource<Key, Value>> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final CoroutineDispatcher KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Multi-variable type inference failed */
    public SuspendingPagingSourceFactory(CoroutineDispatcher coroutineDispatcher, Function0<? extends PagingSource<Key, Value>> function0) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = coroutineDispatcher;
        this.getAuthRequestContext = function0;
    }

    public final Object KClassImpl$Data$declaredNonStaticMembers$2(Continuation<? super PagingSource<Key, Value>> continuation) {
        return BuildersKt.withContext(this.KClassImpl$Data$declaredNonStaticMembers$2, new SuspendingPagingSourceFactory$create$2(this, null), continuation);
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        return this.getAuthRequestContext.invoke();
    }
}
