package kotlinx.coroutines.rx2;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001aX\u0010\u0010\u001a\u00020\u000f*\u00020\u00042\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2,\u0010\u000e\u001a(\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n\u0012\b\u0012\u00060\u0005j\u0002`\u00060\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011*8\b\u0002\u0010\u0012\"\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n2\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lio/reactivex/Scheduler;", "Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "asCoroutineDispatcher", "(Lio/reactivex/Scheduler;)Lkotlinx/coroutines/rx2/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "delayMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "adaptForScheduling", "Lio/reactivex/disposables/Disposable;", "scheduleTask", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/Runnable;JLkotlin/jvm/functions/Function1;)Lio/reactivex/disposables/Disposable;", "Task"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RxSchedulerKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.4.2, binary compatibility with earlier versions")
    public static final /* synthetic */ SchedulerCoroutineDispatcher asCoroutineDispatcher(Scheduler scheduler) {
        return new SchedulerCoroutineDispatcher(scheduler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [kotlinx.coroutines.DisposableHandle, T] */
    public static final Disposable scheduleTask(CoroutineScope coroutineScope, Runnable runnable, long j, Function1<? super Function1<? super Continuation<? super Unit>, ? extends Object>, ? extends Runnable> function1) {
        CoroutineContext builtInFictitiousFunctionClassFactory = coroutineScope.getBuiltInFictitiousFunctionClassFactory();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Disposable authRequestContext = Disposables.getAuthRequestContext(new Runnable() { // from class: kotlinx.coroutines.rx2.RxSchedulerKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RxSchedulerKt.m4677scheduleTask$lambda0(Ref.ObjectRef.this);
            }
        });
        Runnable invoke = function1.invoke(new RxSchedulerKt$scheduleTask$toSchedule$1(authRequestContext, builtInFictitiousFunctionClassFactory, RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(runnable)));
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            if (j <= 0) {
                invoke.run();
            } else {
                objectRef.element = DelayKt.getDelay(builtInFictitiousFunctionClassFactory).invokeOnTimeout(j, invoke, builtInFictitiousFunctionClassFactory);
            }
            return authRequestContext;
        }
        return Disposables.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scheduleTask$lambda-0  reason: not valid java name */
    public static final void m4677scheduleTask$lambda0(Ref.ObjectRef objectRef) {
        DisposableHandle disposableHandle = (DisposableHandle) objectRef.element;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(2:19|(2:21|22)(2:23|(1:25)))|12|13|14))|28|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        kotlinx.coroutines.rx2.RxCancellableKt.handleUndeliverableException(r4, r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object scheduleTask$task(io.reactivex.disposables.Disposable r4, kotlin.coroutines.CoroutineContext r5, final java.lang.Runnable r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1
            if (r0 == 0) goto L14
            r0 = r7
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1 r0 = (kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1 r0 = new kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L56
            goto L5a
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r4 = r4.isDisposed()
            if (r4 == 0) goto L43
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L43:
            kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$2 r4 = new kotlinx.coroutines.rx2.RxSchedulerKt$scheduleTask$task$2     // Catch: java.lang.Throwable -> L56
            r4.<init>()     // Catch: java.lang.Throwable -> L56
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4     // Catch: java.lang.Throwable -> L56
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L56
            r0.label = r3     // Catch: java.lang.Throwable -> L56
            r6 = 0
            java.lang.Object r4 = kotlinx.coroutines.InterruptibleKt.runInterruptible$default(r6, r4, r0, r3, r6)     // Catch: java.lang.Throwable -> L56
            if (r4 != r1) goto L5a
            return r1
        L56:
            r4 = move-exception
            kotlinx.coroutines.rx2.RxCancellableKt.handleUndeliverableException(r4, r5)
        L5a:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.RxSchedulerKt.scheduleTask$task(io.reactivex.disposables.Disposable, kotlin.coroutines.CoroutineContext, java.lang.Runnable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
