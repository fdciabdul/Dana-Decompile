package androidx.paging;

import androidx.paging.LoadStates;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J3\u0010\b\u001a\u00028\u0002\"\u0004\b\u0002\u0010\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012"}, d2 = {"Landroidx/paging/AccessorStateHolder;", "", "Key", "Value", "R", "Lkotlin/Function1;", "Landroidx/paging/AccessorState;", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/paging/LoadStates;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "MyBillsEntityDataFactory", "Landroidx/paging/AccessorState;", "getAuthRequestContext", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AccessorStateHolder<Key, Value> {
    final MutableStateFlow<LoadStates> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final AccessorState<Key, Value> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ReentrantLock KClassImpl$Data$declaredNonStaticMembers$2 = new ReentrantLock();

    public AccessorStateHolder() {
        LoadStates.Companion companion = LoadStates.INSTANCE;
        this.BuiltInFictitiousFunctionClassFactory = StateFlowKt.MutableStateFlow(LoadStates.Companion.BuiltInFictitiousFunctionClassFactory());
        this.getAuthRequestContext = new AccessorState<>();
    }

    public final <R> R PlaceComponentResult(Function1<? super AccessorState<Key, Value>, ? extends R> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReentrantLock reentrantLock = this.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            R invoke = p0.invoke(this.getAuthRequestContext);
            this.BuiltInFictitiousFunctionClassFactory.setValue(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory());
            return invoke;
        } finally {
            reentrantLock.unlock();
        }
    }
}
