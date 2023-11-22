package androidx.paging;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.paging.PagedList$dispatchStateChangeAsync$1", f = "PagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class PagedList$dispatchStateChangeAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadState $state;
    final /* synthetic */ LoadType $type;
    int label;
    final /* synthetic */ PagedList<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagedList$dispatchStateChangeAsync$1(PagedList<T> pagedList, LoadType loadType, LoadState loadState, Continuation<? super PagedList$dispatchStateChangeAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = pagedList;
        this.$type = loadType;
        this.$state = loadState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PagedList$dispatchStateChangeAsync$1(this.this$0, this.$type, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PagedList$dispatchStateChangeAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        List list2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            list = this.this$0.moveToNextValue;
            CollectionsKt.removeAll(list, (Function1) new Function1<WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>>, Boolean>() { // from class: androidx.paging.PagedList$dispatchStateChangeAsync$1.1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final Boolean invoke2(WeakReference<Function2<LoadType, LoadState, Unit>> weakReference) {
                    Intrinsics.checkNotNullParameter(weakReference, "");
                    return Boolean.valueOf(weakReference.get() == null);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>> weakReference) {
                    return invoke2((WeakReference<Function2<LoadType, LoadState, Unit>>) weakReference);
                }
            });
            list2 = this.this$0.moveToNextValue;
            LoadType loadType = this.$type;
            LoadState loadState = this.$state;
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                Function2 function2 = (Function2) ((WeakReference) it.next()).get();
                if (function2 != null) {
                    function2.invoke(loadType, loadState);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
