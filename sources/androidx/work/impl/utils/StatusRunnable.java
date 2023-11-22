package androidx.work.impl.utils;

import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class StatusRunnable<T> implements Runnable {
    public final SettableFuture<T> MyBillsEntityDataFactory = SettableFuture.PlaceComponentResult();

    abstract T KClassImpl$Data$declaredNonStaticMembers$2();

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.MyBillsEntityDataFactory.getAuthRequestContext((SettableFuture<T>) KClassImpl$Data$declaredNonStaticMembers$2());
        } catch (Throwable th) {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(th);
        }
    }

    public static StatusRunnable<List<WorkInfo>> PlaceComponentResult(final WorkManagerImpl workManagerImpl, final String str) {
        return new StatusRunnable<List<WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable.4
            @Override // androidx.work.impl.utils.StatusRunnable
            final /* synthetic */ List<WorkInfo> KClassImpl$Data$declaredNonStaticMembers$2() {
                return WorkSpec.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(workManagerImpl.lookAheadTest.getErrorConfigVersion().NetworkUserEntityData$$ExternalSyntheticLambda0(str));
            }
        };
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$1 */
    /* loaded from: classes3.dex */
    class AnonymousClass1 extends StatusRunnable<List<WorkInfo>> {
        final /* synthetic */ WorkManagerImpl BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ List PlaceComponentResult;

        @Override // androidx.work.impl.utils.StatusRunnable
        public final /* synthetic */ List<WorkInfo> KClassImpl$Data$declaredNonStaticMembers$2() {
            return WorkSpec.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.lookAheadTest.getErrorConfigVersion().MyBillsEntityDataFactory(this.PlaceComponentResult));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$2 */
    /* loaded from: classes3.dex */
    class AnonymousClass2 extends StatusRunnable<WorkInfo> {
        final /* synthetic */ UUID KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ WorkManagerImpl PlaceComponentResult;

        @Override // androidx.work.impl.utils.StatusRunnable
        final /* synthetic */ WorkInfo KClassImpl$Data$declaredNonStaticMembers$2() {
            WorkSpec.WorkInfoPojo scheduleImpl = this.PlaceComponentResult.lookAheadTest.getErrorConfigVersion().scheduleImpl(this.KClassImpl$Data$declaredNonStaticMembers$2.toString());
            if (scheduleImpl != null) {
                return scheduleImpl.MyBillsEntityDataFactory();
            }
            return null;
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$3 */
    /* loaded from: classes3.dex */
    class AnonymousClass3 extends StatusRunnable<List<WorkInfo>> {
        final /* synthetic */ WorkManagerImpl KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ String getAuthRequestContext;

        @Override // androidx.work.impl.utils.StatusRunnable
        final /* synthetic */ List<WorkInfo> KClassImpl$Data$declaredNonStaticMembers$2() {
            return WorkSpec.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest.getErrorConfigVersion().lookAheadTest(this.getAuthRequestContext));
        }
    }

    /* renamed from: androidx.work.impl.utils.StatusRunnable$5 */
    /* loaded from: classes3.dex */
    class AnonymousClass5 extends StatusRunnable<List<WorkInfo>> {
        final /* synthetic */ WorkQuery BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ WorkManagerImpl PlaceComponentResult;

        @Override // androidx.work.impl.utils.StatusRunnable
        final /* synthetic */ List<WorkInfo> KClassImpl$Data$declaredNonStaticMembers$2() {
            return WorkSpec.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this.PlaceComponentResult.lookAheadTest.PlaceComponentResult().getAuthRequestContext(RawQueries.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory)));
        }
    }
}
