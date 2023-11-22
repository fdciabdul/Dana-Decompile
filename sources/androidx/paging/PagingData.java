package androidx.paging;

import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u000fB%\b\u0000\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003X\u0000¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\bX\u0000¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Landroidx/paging/PagingData;", "", "T", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "PlaceComponentResult", "Lkotlinx/coroutines/flow/Flow;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/UiReceiver;", "MyBillsEntityDataFactory", "Landroidx/paging/UiReceiver;", "p0", "p1", "<init>", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/UiReceiver;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingData<T> {
    public static final UiReceiver BuiltInFictitiousFunctionClassFactory;
    public static final PagingData<Object> getAuthRequestContext;
    final UiReceiver MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Flow<PageEvent<T>> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Multi-variable type inference failed */
    public PagingData(Flow<? extends PageEvent<T>> flow, UiReceiver uiReceiver) {
        Intrinsics.checkNotNullParameter(flow, "");
        Intrinsics.checkNotNullParameter(uiReceiver, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = flow;
        this.MyBillsEntityDataFactory = uiReceiver;
    }

    static {
        UiReceiver uiReceiver = new UiReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_RECEIVER$1
            @Override // androidx.paging.UiReceiver
            public final void getAuthRequestContext(ViewportHint p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }
        };
        BuiltInFictitiousFunctionClassFactory = uiReceiver;
        PageEvent.Insert.Companion companion = PageEvent.Insert.INSTANCE;
        getAuthRequestContext = new PagingData<>(FlowKt.flowOf(PageEvent.Insert.Companion.getAuthRequestContext()), uiReceiver);
    }
}
