package id.dana.sendmoney.util;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/util/HybridCoroutinePresenter;", "Lkotlinx/coroutines/CoroutineScope;", "", "PlaceComponentResult", "()V", "Lkotlin/coroutines/CoroutineContext;", "getAuthRequestContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CoroutineDispatcher;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CompletableJob;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class HybridCoroutinePresenter implements CoroutineScope {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CoroutineDispatcher getAuthRequestContext;
    private final CompletableJob PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final CoroutineContext BuiltInFictitiousFunctionClassFactory;

    public HybridCoroutinePresenter() {
        CompletableJob Job$default;
        MainCoroutineDispatcher main = Dispatchers.getMain();
        this.getAuthRequestContext = main;
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.PlaceComponentResult = Job$default;
        this.BuiltInFictitiousFunctionClassFactory = Job$default.plus(main);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @JvmName(name = "getCoroutineContext")
    public CoroutineContext getCoroutineContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final void PlaceComponentResult() {
        Job.DefaultImpls.cancel$default(this.PlaceComponentResult, null, 1, null);
    }
}
