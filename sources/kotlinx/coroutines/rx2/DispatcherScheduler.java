package kotlinx.coroutines.rx2;

import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import id.dana.data.config.source.amcs.result.OTCAcceptExpiryTimeConfigResult;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.rx2.DispatcherScheduler;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\r\u001a\u00020\f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lkotlinx/coroutines/rx2/DispatcherScheduler;", "Lio/reactivex/Scheduler;", "Lio/reactivex/Scheduler$Worker;", "createWorker", "()Lio/reactivex/Scheduler$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "delay", "Ljava/util/concurrent/TimeUnit;", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "Lio/reactivex/disposables/Disposable;", "scheduleDirect", "(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;", "", "shutdown", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CompletableJob;", "schedulerJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME, "Lkotlinx/coroutines/CoroutineScope;", "DispatcherWorker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
final class DispatcherScheduler extends Scheduler {
    private static final /* synthetic */ AtomicLongFieldUpdater workerCounter$FU = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter");
    public final CoroutineDispatcher dispatcher;
    private final CompletableJob schedulerJob;
    private final CoroutineScope scope;
    private volatile /* synthetic */ long workerCounter;

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable block, long delay, TimeUnit unit) {
        Disposable scheduleTask;
        scheduleTask = RxSchedulerKt.scheduleTask(this.scope, block, unit.toMillis(delay), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$scheduleDirect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Runnable invoke(final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                final DispatcherScheduler dispatcherScheduler = DispatcherScheduler.this;
                return new Runnable() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CoroutineScope coroutineScope;
                        coroutineScope = DispatcherScheduler.this.scope;
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DispatcherScheduler$scheduleDirect$1$1$1(function1, null), 3, null);
                    }
                };
            }
        });
        return scheduleTask;
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new DispatcherWorker(workerCounter$FU.getAndIncrement(this), this.dispatcher, this.schedulerJob);
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
        Job.DefaultImpls.cancel$default(this.schedulerJob, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0010\u001a\u00020\u000f2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R3\u0010\u0019\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00160\u00158\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lkotlinx/coroutines/rx2/DispatcherScheduler$DispatcherWorker;", "Lio/reactivex/Scheduler$Worker;", "", "dispose", "()V", "", "isDisposed", "()Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "delay", "Ljava/util/concurrent/TimeUnit;", OTCAcceptExpiryTimeConfigResult.JsonKey.UNIT, "Lio/reactivex/disposables/Disposable;", "schedule", "(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "blockChannel", "Lkotlinx/coroutines/channels/Channel;", "counter", "J", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CompletableJob;", "workerJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "workerScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "parentJob", "<init>", "(JLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/Job;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class DispatcherWorker extends Scheduler.Worker {
        private final Channel<Function1<Continuation<? super Unit>, Object>> blockChannel;
        private final long counter;
        private final CoroutineDispatcher dispatcher;
        private final CompletableJob workerJob;
        private final CoroutineScope workerScope;

        public DispatcherWorker(long j, CoroutineDispatcher coroutineDispatcher, Job job) {
            this.counter = j;
            this.dispatcher = coroutineDispatcher;
            CompletableJob SupervisorJob = SupervisorKt.SupervisorJob(job);
            this.workerJob = SupervisorJob;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorJob.plus(coroutineDispatcher));
            this.workerScope = CoroutineScope;
            this.blockChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
            BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        }

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$1", f = "RxScheduler.kt", i = {0, 1}, l = {WSContextConstant.HANDSHAKE_SEND_SIZE, 82}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$0", "L$0"})
        /* renamed from: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$1  reason: invalid class name */
        /* loaded from: classes9.dex */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            Object L$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x004f A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #1 {all -> 0x007d, blocks: (B:21:0x0056, B:23:0x005e), top: B:40:0x0056 }] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0071 -> B:17:0x0043). Please submit an issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L32
                    if (r1 == r3) goto L22
                    if (r1 != r2) goto L1a
                    java.lang.Object r1 = r7.L$1
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    java.lang.Object r4 = r7.L$0
                    kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L7f
                    goto L42
                L1a:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L22:
                    java.lang.Object r1 = r7.L$1
                    kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                    java.lang.Object r4 = r7.L$0
                    kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L7f
                    r5 = r4
                    r4 = r1
                    r1 = r0
                    r0 = r7
                    goto L56
                L32:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker r8 = kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.this
                    kotlinx.coroutines.channels.Channel r8 = kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.access$getBlockChannel$p(r8)
                    r4 = r8
                    kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
                    kotlinx.coroutines.channels.ChannelIterator r1 = r4.iterator()     // Catch: java.lang.Throwable -> L7f
                L42:
                    r8 = r7
                L43:
                    r8.L$0 = r4     // Catch: java.lang.Throwable -> L7f
                    r8.L$1 = r1     // Catch: java.lang.Throwable -> L7f
                    r8.label = r3     // Catch: java.lang.Throwable -> L7f
                    java.lang.Object r5 = r1.hasNext(r8)     // Catch: java.lang.Throwable -> L7f
                    if (r5 != r0) goto L50
                    return r0
                L50:
                    r6 = r0
                    r0 = r8
                    r8 = r5
                    r5 = r4
                    r4 = r1
                    r1 = r6
                L56:
                    java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L7d
                    boolean r8 = r8.booleanValue()     // Catch: java.lang.Throwable -> L7d
                    if (r8 == 0) goto L76
                    java.lang.Object r8 = r4.next()     // Catch: java.lang.Throwable -> L7d
                    kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8     // Catch: java.lang.Throwable -> L7d
                    r0.L$0 = r5     // Catch: java.lang.Throwable -> L7d
                    r0.L$1 = r4     // Catch: java.lang.Throwable -> L7d
                    r0.label = r2     // Catch: java.lang.Throwable -> L7d
                    java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L7d
                    if (r8 != r1) goto L71
                    return r1
                L71:
                    r8 = r0
                    r0 = r1
                    r1 = r4
                    r4 = r5
                    goto L43
                L76:
                    r8 = 0
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r8)
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                L7d:
                    r8 = move-exception
                    goto L81
                L7f:
                    r8 = move-exception
                    r5 = r4
                L81:
                    throw r8     // Catch: java.lang.Throwable -> L82
                L82:
                    r0 = move-exception
                    kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r5, r8)
                    goto L88
                L87:
                    throw r0
                L88:
                    goto L87
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.rx2.DispatcherScheduler.DispatcherWorker.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable block, long delay, TimeUnit unit) {
            Disposable scheduleTask;
            scheduleTask = RxSchedulerKt.scheduleTask(this.workerScope, block, unit.toMillis(delay), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$schedule$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Runnable invoke(final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                    final DispatcherScheduler.DispatcherWorker dispatcherWorker = DispatcherScheduler.DispatcherWorker.this;
                    return new Runnable() { // from class: kotlinx.coroutines.rx2.DispatcherScheduler$DispatcherWorker$schedule$1$invoke$$inlined$Runnable$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DispatcherScheduler.DispatcherWorker.this.blockChannel.mo42trySendJP2dKIU(function1);
                        }
                    };
                }
            });
            return scheduleTask;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return !CoroutineScopeKt.isActive(this.workerScope);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            SendChannel.DefaultImpls.close$default(this.blockChannel, null, 1, null);
            Job.DefaultImpls.cancel$default(this.workerJob, null, 1, null);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.dispatcher);
            sb.append(" (worker ");
            sb.append(this.counter);
            sb.append(", ");
            sb.append(isDisposed() ? "disposed" : "active");
            sb.append(')');
            return sb.toString();
        }
    }

    public final String toString() {
        return this.dispatcher.toString();
    }
}
