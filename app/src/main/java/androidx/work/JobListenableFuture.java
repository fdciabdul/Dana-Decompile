package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0015\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ(\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006*\u00020\u00030\u00032\n\u0010\u0006\u001a\u0006*\u00020\u00050\u0005H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\r\u001a\u0006*\u00028\u00008\u0000H\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\r\u001a\u0006*\u00028\u00008\u00002\u0006\u0010\u0004\u001a\u00020\u000f2\n\u0010\u0006\u001a\u0006*\u00020\u00100\u0010H\u0096\u0003¢\u0006\u0004\b\r\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Landroidx/work/JobListenableFuture;", "R", "Lcom/google/common/util/concurrent/ListenableFuture;", "Ljava/lang/Runnable;", "p0", "Ljava/util/concurrent/Executor;", "p1", "", "addListener", "(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V", "", "cancel", "(Z)Z", "get", "()Ljava/lang/Object;", "", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "isCancelled", "()Z", "isDone", "Lkotlinx/coroutines/Job;", "getAuthRequestContext", "Lkotlinx/coroutines/Job;", "Landroidx/work/impl/utils/futures/SettableFuture;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/work/impl/utils/futures/SettableFuture;", "PlaceComponentResult", "<init>", "(Lkotlinx/coroutines/Job;Landroidx/work/impl/utils/futures/SettableFuture;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class JobListenableFuture<R> implements ListenableFuture<R> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final SettableFuture<R> PlaceComponentResult;
    private final Job getAuthRequestContext;

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable p0, Executor p1) {
        this.PlaceComponentResult.addListener(p0, p1);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean p0) {
        return this.PlaceComponentResult.cancel(p0);
    }

    @Override // java.util.concurrent.Future
    public final R get() {
        return this.PlaceComponentResult.get();
    }

    @Override // java.util.concurrent.Future
    public final R get(long p0, TimeUnit p1) {
        return this.PlaceComponentResult.get(p0, p1);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.PlaceComponentResult.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.PlaceComponentResult.isDone();
    }

    private JobListenableFuture(Job job, SettableFuture<R> settableFuture) {
        Intrinsics.checkNotNullParameter(job, "");
        Intrinsics.checkNotNullParameter(settableFuture, "");
        this.getAuthRequestContext = job;
        this.PlaceComponentResult = settableFuture;
        job.invokeOnCompletion(new Function1<Throwable, Unit>(this) { // from class: androidx.work.JobListenableFuture.1
            final /* synthetic */ JobListenableFuture<R> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th == null) {
                    if (!this.this$0.PlaceComponentResult.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                } else if (th instanceof CancellationException) {
                    this.this$0.PlaceComponentResult.cancel(true);
                } else {
                    SettableFuture settableFuture2 = this.this$0.PlaceComponentResult;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    settableFuture2.BuiltInFictitiousFunctionClassFactory(th);
                }
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ JobListenableFuture(kotlinx.coroutines.Job r1, androidx.work.impl.utils.futures.SettableFuture r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto Ld
            androidx.work.impl.utils.futures.SettableFuture r2 = androidx.work.impl.utils.futures.SettableFuture.PlaceComponentResult()
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        Ld:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.JobListenableFuture.<init>(kotlinx.coroutines.Job, androidx.work.impl.utils.futures.SettableFuture, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
