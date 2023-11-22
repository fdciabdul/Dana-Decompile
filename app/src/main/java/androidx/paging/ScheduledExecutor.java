package androidx.paging;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/paging/ScheduledExecutor;", "Lio/reactivex/Scheduler;", "Ljava/util/concurrent/Executor;", "Lio/reactivex/Scheduler$Worker;", "createWorker", "()Lio/reactivex/Scheduler$Worker;", "Ljava/lang/Runnable;", "p0", "", "execute", "(Ljava/lang/Runnable;)V", "MyBillsEntityDataFactory", "Ljava/util/concurrent/Executor;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/Scheduler;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Ljava/util/concurrent/Executor;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ScheduledExecutor extends Scheduler implements Executor {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Scheduler BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Executor PlaceComponentResult;

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "command", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.paging.ScheduledExecutor$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 implements Executor {
        final /* synthetic */ Scheduler.Worker KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.schedule(runnable);
        }
    }

    public ScheduledExecutor(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "");
        this.PlaceComponentResult = executor;
        Scheduler BuiltInFictitiousFunctionClassFactory = Schedulers.BuiltInFictitiousFunctionClassFactory(executor);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        Scheduler.Worker createWorker = this.BuiltInFictitiousFunctionClassFactory.createWorker();
        Intrinsics.checkNotNullExpressionValue(createWorker, "");
        return createWorker;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.execute(p0);
    }
}
