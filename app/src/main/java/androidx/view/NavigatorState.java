package androidx.view;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000bR \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0014X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0014\u0010\n\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\f8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u0007\u0010\u001bR\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u0014X\u0007¢\u0006\u0006\n\u0004\b\r\u0010\u0015"}, d2 = {"Landroidx/navigation/NavigatorState;", "", "Landroidx/navigation/NavDestination;", "p0", "Landroid/os/Bundle;", "p1", "Landroidx/navigation/NavBackStackEntry;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/navigation/NavBackStackEntry;)V", "", "PlaceComponentResult", "(Landroidx/navigation/NavBackStackEntry;Z)V", "getAuthRequestContext", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "MyBillsEntityDataFactory", "Ljava/util/concurrent/locks/ReentrantLock;", "lookAheadTest", "Ljava/util/concurrent/locks/ReentrantLock;", "Z", "()Z", "getErrorConfigVersion", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class NavigatorState {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MutableStateFlow<Set<NavBackStackEntry>> PlaceComponentResult;
    private final MutableStateFlow<List<NavBackStackEntry>> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    boolean getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final StateFlow<Set<NavBackStackEntry>> getErrorConfigVersion;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final StateFlow<List<NavBackStackEntry>> MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final ReentrantLock BuiltInFictitiousFunctionClassFactory = new ReentrantLock(true);

    public abstract NavBackStackEntry KClassImpl$Data$declaredNonStaticMembers$2(NavDestination p0, Bundle p1);

    public NavigatorState() {
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MutableStateFlow;
        MutableStateFlow<Set<NavBackStackEntry>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this.PlaceComponentResult = MutableStateFlow2;
        this.MyBillsEntityDataFactory = FlowKt.asStateFlow(MutableStateFlow);
        this.getErrorConfigVersion = FlowKt.asStateFlow(MutableStateFlow2);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public void getAuthRequestContext(NavBackStackEntry p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReentrantLock reentrantLock = this.BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            MutableStateFlow<List<NavBackStackEntry>> mutableStateFlow = this.KClassImpl$Data$declaredNonStaticMembers$2;
            mutableStateFlow.setValue(CollectionsKt.plus((Collection<? extends NavBackStackEntry>) mutableStateFlow.getValue(), p0));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void PlaceComponentResult(NavBackStackEntry p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReentrantLock reentrantLock = this.BuiltInFictitiousFunctionClassFactory;
        reentrantLock.lock();
        try {
            MutableStateFlow<List<NavBackStackEntry>> mutableStateFlow = this.KClassImpl$Data$declaredNonStaticMembers$2;
            List<NavBackStackEntry> value = mutableStateFlow.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if ((!Intrinsics.areEqual((NavBackStackEntry) obj, p0)) != true) {
                    break;
                }
                arrayList.add(obj);
            }
            mutableStateFlow.setValue(arrayList);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(NavBackStackEntry p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<List<NavBackStackEntry>> mutableStateFlow = this.KClassImpl$Data$declaredNonStaticMembers$2;
        mutableStateFlow.setValue(CollectionsKt.plus((Collection<? extends NavBackStackEntry>) CollectionsKt.minus(mutableStateFlow.getValue(), CollectionsKt.last((List) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue())), p0));
    }

    public void BuiltInFictitiousFunctionClassFactory(NavBackStackEntry p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MutableStateFlow<Set<NavBackStackEntry>> mutableStateFlow = this.PlaceComponentResult;
        mutableStateFlow.setValue(SetsKt.minus(mutableStateFlow.getValue(), p0));
    }
}
