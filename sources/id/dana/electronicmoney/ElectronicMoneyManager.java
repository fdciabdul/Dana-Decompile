package id.dana.electronicmoney;

import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.OnLifecycleEvent;
import id.dana.di.PerActivity;
import id.dana.electronicmoney.bank.bri.BriBrizziManager;
import id.dana.electronicmoney.bank.mandiri.MandiriEmoneyManager;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0013\u0010\u000f\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014"}, d2 = {"Lid/dana/electronicmoney/ElectronicMoneyManager;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroy", "()V", "", "", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/electronicmoney/bank/bri/BriBrizziManager;", "Lid/dana/electronicmoney/bank/bri/BriBrizziManager;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Lazy;", "getAuthRequestContext", "Lkotlinx/coroutines/CompletableJob;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/CompletableJob;", "Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;", "p0", "p1", "<init>", "(Lid/dana/electronicmoney/bank/mandiri/MandiriEmoneyManager;Lid/dana/electronicmoney/bank/bri/BriBrizziManager;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes2.dex */
public final class ElectronicMoneyManager implements LifecycleObserver {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final BriBrizziManager MyBillsEntityDataFactory;
    private final CompletableJob KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Lazy getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final List<String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final MandiriEmoneyManager PlaceComponentResult;

    @Inject
    public ElectronicMoneyManager(MandiriEmoneyManager mandiriEmoneyManager, BriBrizziManager briBrizziManager) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(mandiriEmoneyManager, "");
        Intrinsics.checkNotNullParameter(briBrizziManager, "");
        this.PlaceComponentResult = mandiriEmoneyManager;
        this.MyBillsEntityDataFactory = briBrizziManager;
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Job$default;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<CoroutineScope>() { // from class: id.dana.electronicmoney.ElectronicMoneyManager$ioScope$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                CompletableJob completableJob;
                CoroutineDispatcher io2 = Dispatchers.getIO();
                completableJob = ElectronicMoneyManager.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return CoroutineScopeKt.CoroutineScope(io2.plus(completableJob));
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        MandiriEmoneyManager mandiriEmoneyManager = this.PlaceComponentResult;
        mandiriEmoneyManager.lookAheadTest.dispose();
        mandiriEmoneyManager.moveToNextValue.dispose();
        mandiriEmoneyManager.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        mandiriEmoneyManager.GetContactSyncConfig.dispose();
        mandiriEmoneyManager.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        Job.DefaultImpls.cancel$default(this.KClassImpl$Data$declaredNonStaticMembers$2, null, 1, null);
    }
}
