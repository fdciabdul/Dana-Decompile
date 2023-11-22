package androidx.view;

import androidx.view.MediatorLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r\u0012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000e"}, d2 = {"Landroidx/lifecycle/EmittedSource;", "Lkotlinx/coroutines/DisposableHandle;", "", "dispose", "()V", "", "PlaceComponentResult", "Z", "getAuthRequestContext", "Landroidx/lifecycle/MediatorLiveData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/MediatorLiveData;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/MediatorLiveData;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class EmittedSource implements DisposableHandle {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MediatorLiveData<?> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final LiveData<?> MyBillsEntityDataFactory;

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(liveData, "");
        Intrinsics.checkNotNullParameter(mediatorLiveData, "");
        this.MyBillsEntityDataFactory = liveData;
        this.BuiltInFictitiousFunctionClassFactory = mediatorLiveData;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new EmittedSource$dispose$1(this, null), 3, null);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(EmittedSource emittedSource) {
        if (emittedSource.getAuthRequestContext) {
            return;
        }
        MediatorLiveData<?> mediatorLiveData = emittedSource.BuiltInFictitiousFunctionClassFactory;
        MediatorLiveData.Source<?> KClassImpl$Data$declaredNonStaticMembers$2 = mediatorLiveData.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(emittedSource.MyBillsEntityDataFactory);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((Observer<? super Object>) KClassImpl$Data$declaredNonStaticMembers$2);
        }
        emittedSource.getAuthRequestContext = true;
    }
}
