package androidx.paging;

import androidx.paging.ViewportHint;
import id.dana.analytics.tracker.TrackerKey;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u00060\bR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Landroidx/paging/HintHandler;", "", "Landroidx/paging/LoadType;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/ViewportHint;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/LoadType;)Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/HintHandler$State;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/HintHandler$State;", "getAuthRequestContext", "<init>", "()V", "HintFlow", TrackerKey.Property.STATE}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class HintHandler {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final State getAuthRequestContext = new State(this);

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.PREPEND.ordinal()] = 1;
            iArr[LoadType.APPEND.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public final Flow<ViewportHint> KClassImpl$Data$declaredNonStaticMembers$2(LoadType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new IllegalArgumentException("invalid load type for hints");
            }
            return this.getAuthRequestContext.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return this.getAuthRequestContext.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015JG\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022.\u0010\t\u001a*\u0012\u000f\u0012\r\u0018\u00010\u0005R\u00020\u0006¢\u0006\u0002\b\u0007\u0012\u000f\u0012\r\u0018\u00010\u0005R\u00020\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\n\u001a\u00060\u0005R\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002@BX\u0086\n¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\f\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00060\u0005R\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r"}, d2 = {"Landroidx/paging/HintHandler$State;", "", "Landroidx/paging/ViewportHint$Access;", "p0", "Lkotlin/Function2;", "Landroidx/paging/HintHandler$HintFlow;", "Landroidx/paging/HintHandler;", "Lkotlin/ParameterName;", "", "p1", "PlaceComponentResult", "(Landroidx/paging/ViewportHint$Access;Lkotlin/jvm/functions/Function2;)V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/HintHandler$HintFlow;", "getAuthRequestContext", "Landroidx/paging/ViewportHint$Access;", "Ljava/util/concurrent/locks/ReentrantLock;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/concurrent/locks/ReentrantLock;", "MyBillsEntityDataFactory", "<init>", "(Landroidx/paging/HintHandler;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class State {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final HintFlow PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final ReentrantLock BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ HintHandler MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final HintFlow MyBillsEntityDataFactory;
        ViewportHint.Access getAuthRequestContext;

        public State(HintHandler hintHandler) {
            Intrinsics.checkNotNullParameter(hintHandler, "");
            this.MyBillsEntityDataFactory = hintHandler;
            this.MyBillsEntityDataFactory = new HintFlow(hintHandler);
            this.PlaceComponentResult = new HintFlow(hintHandler);
            this.BuiltInFictitiousFunctionClassFactory = new ReentrantLock();
        }

        public final void PlaceComponentResult(ViewportHint.Access p0, Function2<? super HintFlow, ? super HintFlow, Unit> p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            ReentrantLock reentrantLock = this.BuiltInFictitiousFunctionClassFactory;
            reentrantLock.lock();
            if (p0 != null) {
                try {
                    this.getAuthRequestContext = p0;
                } finally {
                    reentrantLock.unlock();
                }
            }
            p1.invoke(this.MyBillsEntityDataFactory, this.PlaceComponentResult);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/paging/HintHandler$HintFlow;", "", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/paging/ViewportHint;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "MyBillsEntityDataFactory", "Landroidx/paging/ViewportHint;", "PlaceComponentResult", "<init>", "(Landroidx/paging/HintHandler;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    final class HintFlow {
        final /* synthetic */ HintHandler BuiltInFictitiousFunctionClassFactory;
        final MutableSharedFlow<ViewportHint> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        ViewportHint PlaceComponentResult;

        public HintFlow(HintHandler hintHandler) {
            Intrinsics.checkNotNullParameter(hintHandler, "");
            this.BuiltInFictitiousFunctionClassFactory = hintHandler;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        }
    }
}
