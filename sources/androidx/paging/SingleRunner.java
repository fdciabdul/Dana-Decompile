package androidx.paging;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0003\u000f\u0010\u0011B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J9\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/paging/SingleRunner;", "", "cancelPreviousInEqualPriority", "", "(Z)V", "holder", "Landroidx/paging/SingleRunner$Holder;", "runInIsolation", "", "priority", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CancelIsolatedRunnerException", "Companion", "Holder", "paging-common"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SingleRunner {
    public static final Companion BuiltInFictitiousFunctionClassFactory = new Companion(null);
    private final Holder MyBillsEntityDataFactory;

    public SingleRunner() {
        this(false, 1, null);
    }

    public SingleRunner(boolean z) {
        this.MyBillsEntityDataFactory = new Holder(this, z);
    }

    public /* synthetic */ SingleRunner(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext(int r5, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.paging.SingleRunner$runInIsolation$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.paging.SingleRunner$runInIsolation$1 r0 = (androidx.paging.SingleRunner$runInIsolation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 + r2
            r0.label = r7
            goto L19
        L14:
            androidx.paging.SingleRunner$runInIsolation$1 r0 = new androidx.paging.SingleRunner$runInIsolation$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            androidx.paging.SingleRunner r5 = (androidx.paging.SingleRunner) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L2e
            goto L57
        L2e:
            r6 = move-exception
            goto L51
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.paging.SingleRunner$runInIsolation$2 r7 = new androidx.paging.SingleRunner$runInIsolation$2     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4e
            r2 = 0
            r7.<init>(r4, r5, r6, r2)     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4e
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4e
            r0.L$0 = r4     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4e
            r0.label = r3     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4e
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r7, r0)     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4e
            if (r5 != r1) goto L57
            return r1
        L4e:
            r5 = move-exception
            r6 = r5
            r5 = r4
        L51:
            androidx.paging.SingleRunner r7 = r6.getRunner()
            if (r7 != r5) goto L5a
        L57:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L5a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.getAuthRequestContext(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/paging/SingleRunner$CancelIsolatedRunnerException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Landroidx/paging/SingleRunner;", "runner", "Landroidx/paging/SingleRunner;", "getRunner", "()Landroidx/paging/SingleRunner;", "<init>", "(Landroidx/paging/SingleRunner;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CancelIsolatedRunnerException extends CancellationException {
        private final SingleRunner runner;

        public CancelIsolatedRunnerException(SingleRunner singleRunner) {
            Intrinsics.checkNotNullParameter(singleRunner, "");
            this.runner = singleRunner;
        }

        @JvmName(name = "getRunner")
        public final SingleRunner getRunner() {
            return this.runner;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0014\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/SingleRunner$Holder;", "", "Lkotlinx/coroutines/Job;", "p0", "", "MyBillsEntityDataFactory", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p1", "", "getAuthRequestContext", "(ILkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlaceComponentResult", "Z", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/Job;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "Landroidx/paging/SingleRunner;", "Landroidx/paging/SingleRunner;", "<init>", "(Landroidx/paging/SingleRunner;Z)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Holder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final SingleRunner getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private int MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private Job KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final Mutex PlaceComponentResult;

        public Holder(SingleRunner singleRunner, boolean z) {
            Intrinsics.checkNotNullParameter(singleRunner, "");
            this.getAuthRequestContext = singleRunner;
            this.BuiltInFictitiousFunctionClassFactory = z;
            this.PlaceComponentResult = MutexKt.Mutex$default(false, 1, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
        
            r12.cancel(new androidx.paging.SingleRunner.CancelIsolatedRunnerException(r6.getAuthRequestContext));
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0097 A[Catch: all -> 0x00b8, TryCatch #0 {all -> 0x00b8, blocks: (B:13:0x0038, B:41:0x00ac, B:42:0x00b0, B:22:0x0070, B:24:0x0074, B:26:0x007a, B:29:0x0080, B:34:0x0089, B:36:0x0097), top: B:48:0x0024 }] */
        /* JADX WARN: Type inference failed for: r11v0, types: [kotlinx.coroutines.Job, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v4, types: [kotlinx.coroutines.sync.Mutex] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getAuthRequestContext(int r10, kotlinx.coroutines.Job r11, kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
            /*
                r9 = this;
                boolean r0 = r12 instanceof androidx.paging.SingleRunner$Holder$tryEnqueue$1
                if (r0 == 0) goto L14
                r0 = r12
                androidx.paging.SingleRunner$Holder$tryEnqueue$1 r0 = (androidx.paging.SingleRunner$Holder$tryEnqueue$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r12 = r0.label
                int r12 = r12 + r2
                r0.label = r12
                goto L19
            L14:
                androidx.paging.SingleRunner$Holder$tryEnqueue$1 r0 = new androidx.paging.SingleRunner$Holder$tryEnqueue$1
                r0.<init>(r9, r12)
            L19:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L57
                if (r2 == r5) goto L45
                if (r2 != r3) goto L3d
                int r10 = r0.I$0
                java.lang.Object r11 = r0.L$2
                kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
                java.lang.Object r1 = r0.L$1
                kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
                java.lang.Object r0 = r0.L$0
                androidx.paging.SingleRunner$Holder r0 = (androidx.paging.SingleRunner.Holder) r0
                kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Throwable -> Lb8
                goto Laa
            L3d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L45:
                int r10 = r0.I$0
                java.lang.Object r11 = r0.L$2
                kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
                java.lang.Object r2 = r0.L$1
                kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
                java.lang.Object r6 = r0.L$0
                androidx.paging.SingleRunner$Holder r6 = (androidx.paging.SingleRunner.Holder) r6
                kotlin.ResultKt.throwOnFailure(r12)
                goto L70
            L57:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.sync.Mutex r12 = r9.PlaceComponentResult
                r0.L$0 = r9
                r0.L$1 = r11
                r0.L$2 = r12
                r0.I$0 = r10
                r0.label = r5
                java.lang.Object r2 = r12.lock(r4, r0)
                if (r2 != r1) goto L6d
                return r1
            L6d:
                r6 = r9
                r2 = r11
                r11 = r12
            L70:
                kotlinx.coroutines.Job r12 = r6.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> Lb8
                if (r12 == 0) goto L87
                boolean r7 = r12.isActive()     // Catch: java.lang.Throwable -> Lb8
                if (r7 == 0) goto L87
                int r7 = r6.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> Lb8
                if (r7 < r10) goto L87
                if (r7 != r10) goto L85
                boolean r7 = r6.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> Lb8
                if (r7 == 0) goto L85
                goto L87
            L85:
                r5 = 0
                goto Lb0
            L87:
                if (r12 == 0) goto L95
                androidx.paging.SingleRunner$CancelIsolatedRunnerException r7 = new androidx.paging.SingleRunner$CancelIsolatedRunnerException     // Catch: java.lang.Throwable -> Lb8
                androidx.paging.SingleRunner r8 = r6.getAuthRequestContext     // Catch: java.lang.Throwable -> Lb8
                r7.<init>(r8)     // Catch: java.lang.Throwable -> Lb8
                java.util.concurrent.CancellationException r7 = (java.util.concurrent.CancellationException) r7     // Catch: java.lang.Throwable -> Lb8
                r12.cancel(r7)     // Catch: java.lang.Throwable -> Lb8
            L95:
                if (r12 == 0) goto Lac
                r0.L$0 = r6     // Catch: java.lang.Throwable -> Lb8
                r0.L$1 = r2     // Catch: java.lang.Throwable -> Lb8
                r0.L$2 = r11     // Catch: java.lang.Throwable -> Lb8
                r0.I$0 = r10     // Catch: java.lang.Throwable -> Lb8
                r0.label = r3     // Catch: java.lang.Throwable -> Lb8
                java.lang.Object r12 = r12.join(r0)     // Catch: java.lang.Throwable -> Lb8
                if (r12 != r1) goto La8
                return r1
            La8:
                r1 = r2
                r0 = r6
            Laa:
                r6 = r0
                r2 = r1
            Lac:
                r6.KClassImpl$Data$declaredNonStaticMembers$2 = r2     // Catch: java.lang.Throwable -> Lb8
                r6.MyBillsEntityDataFactory = r10     // Catch: java.lang.Throwable -> Lb8
            Lb0:
                java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)     // Catch: java.lang.Throwable -> Lb8
                r11.unlock(r4)
                return r10
            Lb8:
                r10 = move-exception
                r11.unlock(r4)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.Holder.getAuthRequestContext(int, kotlinx.coroutines.Job, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: all -> 0x0064, TryCatch #0 {all -> 0x0064, blocks: (B:18:0x0056, B:20:0x005a, B:21:0x005c), top: B:27:0x0056 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object MyBillsEntityDataFactory(kotlinx.coroutines.Job r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.SingleRunner$Holder$onFinish$1
                if (r0 == 0) goto L14
                r0 = r7
                androidx.paging.SingleRunner$Holder$onFinish$1 r0 = (androidx.paging.SingleRunner$Holder$onFinish$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r7 = r0.label
                int r7 = r7 + r2
                r0.label = r7
                goto L19
            L14:
                androidx.paging.SingleRunner$Holder$onFinish$1 r0 = new androidx.paging.SingleRunner$Holder$onFinish$1
                r0.<init>(r5, r7)
            L19:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                if (r2 != r3) goto L39
                java.lang.Object r6 = r0.L$2
                kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
                java.lang.Object r1 = r0.L$1
                kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
                java.lang.Object r0 = r0.L$0
                androidx.paging.SingleRunner$Holder r0 = (androidx.paging.SingleRunner.Holder) r0
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r6
                r6 = r1
                goto L56
            L39:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L41:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.sync.Mutex r7 = r5.PlaceComponentResult
                r0.L$0 = r5
                r0.L$1 = r6
                r0.L$2 = r7
                r0.label = r3
                java.lang.Object r0 = r7.lock(r4, r0)
                if (r0 != r1) goto L55
                return r1
            L55:
                r0 = r5
            L56:
                kotlinx.coroutines.Job r1 = r0.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L64
                if (r6 != r1) goto L5c
                r0.KClassImpl$Data$declaredNonStaticMembers$2 = r4     // Catch: java.lang.Throwable -> L64
            L5c:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L64
                r7.unlock(r4)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L64:
                r6 = move-exception
                r7.unlock(r4)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.Holder.MyBillsEntityDataFactory(kotlinx.coroutines.Job, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/paging/SingleRunner$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
