package androidx.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/lifecycle/LiveDataScopeImpl;", "T", "Landroidx/lifecycle/LiveDataScope;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "PlaceComponentResult", "Lkotlin/coroutines/CoroutineContext;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/CoroutineLiveData;", "MyBillsEntityDataFactory", "Landroidx/lifecycle/CoroutineLiveData;", "getAuthRequestContext", "p1", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/coroutines/CoroutineContext;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class LiveDataScopeImpl<T> implements LiveDataScope<T> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    CoroutineLiveData<T> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CoroutineContext BuiltInFictitiousFunctionClassFactory;

    public LiveDataScopeImpl(CoroutineLiveData<T> coroutineLiveData, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineLiveData, "");
        Intrinsics.checkNotNullParameter(coroutineContext, "");
        this.getAuthRequestContext = coroutineLiveData;
        this.BuiltInFictitiousFunctionClassFactory = coroutineContext.plus(Dispatchers.getMain().getImmediate());
    }

    @Override // androidx.view.LiveDataScope
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(T t, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.BuiltInFictitiousFunctionClassFactory, new LiveDataScopeImpl$emit$2(this, t, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
