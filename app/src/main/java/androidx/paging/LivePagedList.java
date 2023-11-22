package androidx.paging;

import androidx.paging.PagedList;
import androidx.view.LiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0018\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0011\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R&\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0012R\u0014\u0010\u0014\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Landroidx/paging/LivePagedList;", "", "Key", "Value", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "", "p0", "", "MyBillsEntityDataFactory", "(Z)V", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroidx/paging/PagedList$BoundaryCallback;", "PlaceComponentResult", "Landroidx/paging/PagedList$BoundaryCallback;", "Lkotlin/Function0;", "scheduleImpl", "Lkotlin/jvm/functions/Function0;", "Landroidx/paging/PagedList$Config;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/paging/PagedList$Config;", "getAuthRequestContext", "Lkotlinx/coroutines/CoroutineScope;", "lookAheadTest", "Lkotlinx/coroutines/CoroutineScope;", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Landroidx/paging/PagedList;", "Lkotlinx/coroutines/Job;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlinx/coroutines/Job;", "moveToNextValue", "Lkotlinx/coroutines/CoroutineDispatcher;", "initRecordTimeStamp", "Lkotlinx/coroutines/CoroutineDispatcher;", "GetContactSyncConfig", "Landroidx/paging/PagingSource;", "DatabaseTableConfigUtil", "getErrorConfigVersion", "Ljava/lang/Runnable;", "PrepareContext", "Ljava/lang/Runnable;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class LivePagedList<Key, Value> extends LiveData<PagedList<Value>> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Function0<PagingSource<Key, Value>> getErrorConfigVersion;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final CoroutineDispatcher scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final PagedList.Config getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private PagedList<Value> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private Job moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PagedList.BoundaryCallback<Value> MyBillsEntityDataFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Runnable NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final CoroutineDispatcher lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CoroutineScope KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.view.LiveData
    public final void BuiltInFictitiousFunctionClassFactory() {
        super.BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(boolean p0) {
        Job launch$default;
        Job job = this.moveToNextValue;
        if (job == null || p0) {
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, null, 1, null);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, null, new LivePagedList$invalidate$1(this, null), 2, null);
            this.moveToNextValue = launch$default;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(LivePagedList livePagedList, PagedList pagedList, PagedList pagedList2) {
        pagedList.scheduleImpl = null;
        pagedList2.scheduleImpl = livePagedList.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
