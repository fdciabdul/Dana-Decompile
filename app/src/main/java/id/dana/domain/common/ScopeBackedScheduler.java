package id.dana.domain.common;

import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import id.dana.domain.extension.CoroutinesExtKt;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/common/ScopeBackedScheduler;", "Lio/reactivex/Scheduler;", "Lio/reactivex/Scheduler$Worker;", "createWorker", "()Lio/reactivex/Scheduler$Worker;", "Lkotlinx/coroutines/CoroutineScope;", ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME, "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "ScopeBackedWorker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScopeBackedScheduler extends Scheduler {
    private final CoroutineScope scope;

    public ScopeBackedScheduler(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "");
        this.scope = coroutineScope;
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new ScopeBackedWorker(this.scope);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016"}, d2 = {"Lid/dana/domain/common/ScopeBackedScheduler$ScopeBackedWorker;", "Lio/reactivex/Scheduler$Worker;", "", "dispose", "()V", "", "isDisposed", "()Z", "Ljava/lang/Runnable;", "p0", "", "p1", "Ljava/util/concurrent/TimeUnit;", "p2", "Lio/reactivex/disposables/Disposable;", "schedule", "(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;", "Lkotlinx/coroutines/CompletableJob;", "MyBillsEntityDataFactory", "Lkotlinx/coroutines/CompletableJob;", "getAuthRequestContext", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    static final class ScopeBackedWorker extends Scheduler.Worker {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final CompletableJob getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final CoroutineScope BuiltInFictitiousFunctionClassFactory;

        public ScopeBackedWorker(CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "");
            this.BuiltInFictitiousFunctionClassFactory = coroutineScope;
            this.getAuthRequestContext = SupervisorKt.SupervisorJob((Job) coroutineScope.getPlaceComponentResult().get(Job.INSTANCE));
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return !this.getAuthRequestContext.isActive();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Job.DefaultImpls.cancel$default(this.getAuthRequestContext, null, 1, null);
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable p0, long p1, TimeUnit p2) {
            Job launch$default;
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            if (!isDisposed()) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, null, new ScopeBackedScheduler$ScopeBackedWorker$schedule$1(p1, p2, p0, null), 2, null);
                return CoroutinesExtKt.asDisposable(launch$default);
            }
            Disposable BuiltInFictitiousFunctionClassFactory = Disposables.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            return BuiltInFictitiousFunctionClassFactory;
        }
    }
}
