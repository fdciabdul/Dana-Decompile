package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0010\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0011X\u0016¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014X\u0000¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0017X\u0000¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "Landroidx/work/ListenableWorker$Result;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/common/util/concurrent/ListenableFuture;", "Landroidx/work/ForegroundInfo;", "getForegroundInfoAsync", "()Lcom/google/common/util/concurrent/ListenableFuture;", "", "onStopped", "()V", "Landroidx/work/Data;", "p0", "MyBillsEntityDataFactory", "(Landroidx/work/Data;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWork", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "getAuthRequestContext", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/impl/utils/futures/SettableFuture;", "PlaceComponentResult", "Lkotlinx/coroutines/CompletableJob;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CompletableJob;", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final CompletableJob MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CoroutineDispatcher getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final SettableFuture<ListenableWorker.Result> PlaceComponentResult;

    public abstract Object KClassImpl$Data$declaredNonStaticMembers$2(Continuation<? super ListenableWorker.Result> continuation);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(workerParameters, "");
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.MyBillsEntityDataFactory = Job$default;
        SettableFuture<ListenableWorker.Result> PlaceComponentResult = SettableFuture.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.PlaceComponentResult = PlaceComponentResult;
        PlaceComponentResult.addListener(new Runnable() { // from class: androidx.work.CoroutineWorker.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CoroutineWorker.this.PlaceComponentResult.isCancelled()) {
                    Job.DefaultImpls.cancel$default(CoroutineWorker.this.MyBillsEntityDataFactory, null, 1, null);
                }
            }
        }, getTaskExecutor().MyBillsEntityDataFactory());
        this.getAuthRequestContext = Dispatchers.getDefault();
    }

    public final Object MyBillsEntityDataFactory(Data data, Continuation<? super Unit> continuation) {
        Object obj;
        final ListenableFuture<Void> progressAsync = setProgressAsync(data);
        Intrinsics.checkNotNullExpressionValue(progressAsync, "");
        if (progressAsync.isDone()) {
            try {
                obj = progressAsync.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        } else {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            progressAsync.addListener(new Runnable() { // from class: androidx.work.ListenableFutureKt$await$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        Continuation continuation2 = cancellableContinuationImpl2;
                        Object obj2 = progressAsync.get();
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m3179constructorimpl(obj2));
                    } catch (Throwable th) {
                        Throwable cause2 = th.getCause();
                        if (cause2 == null) {
                            cause2 = th;
                        }
                        if (th instanceof CancellationException) {
                            cancellableContinuationImpl2.cancel(cause2);
                            return;
                        }
                        Continuation continuation3 = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation3.resumeWith(Result.m3179constructorimpl(ResultKt.createFailure(cause2)));
                    }
                }
            }, DirectExecutor.INSTANCE);
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.work.ListenableFutureKt$await$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    progressAsync.cancel(false);
                }
            });
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
        }
        return obj == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, androidx.work.impl.utils.futures.SettableFuture] */
    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        CompletableJob Job$default;
        ?? r0 = 0;
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(this.getAuthRequestContext.plus(Job$default));
        JobListenableFuture jobListenableFuture = new JobListenableFuture(Job$default, r0, 2, r0);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new CoroutineWorker$getForegroundInfoAsync$1(jobListenableFuture, this, null), 3, null);
        return jobListenableFuture;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.PlaceComponentResult.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.getAuthRequestContext.plus(this.MyBillsEntityDataFactory)), null, null, new CoroutineWorker$startWork$1(this, null), 3, null);
        return this.PlaceComponentResult;
    }
}
