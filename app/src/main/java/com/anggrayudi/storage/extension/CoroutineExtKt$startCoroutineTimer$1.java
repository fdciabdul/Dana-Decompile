package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1", f = "CoroutineExt.kt", i = {}, l = {18, 26}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class CoroutineExtKt$startCoroutineTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $repeatMillis;
    final /* synthetic */ boolean $runActionOnUiThread;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineExtKt$startCoroutineTimer$1(long j, long j2, boolean z, Function0<Unit> function0, Continuation<? super CoroutineExtKt$startCoroutineTimer$1> continuation) {
        super(2, continuation);
        this.$delayMillis = j;
        this.$repeatMillis = j2;
        this.$runActionOnUiThread = z;
        this.$action = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineExtKt$startCoroutineTimer$1(this.$delayMillis, this.$repeatMillis, this.$runActionOnUiThread, this.$action, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineExtKt$startCoroutineTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1f
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r9)
            goto L38
        L13:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1b:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L30
        L1f:
            kotlin.ResultKt.throwOnFailure(r9)
            long r5 = r8.$delayMillis
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r9)
            if (r9 != r0) goto L30
            return r0
        L30:
            long r4 = r8.$repeatMillis
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 <= 0) goto L5c
        L38:
            boolean r9 = r8.$runActionOnUiThread
            if (r9 == 0) goto L49
            com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1 r9 = new com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r8.$action
            r9.<init>(r1, r2)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            com.anggrayudi.storage.extension.CoroutineExtKt.BuiltInFictitiousFunctionClassFactory(r9)
            goto L4e
        L49:
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r8.$action
            r9.invoke()
        L4e:
            long r4 = r8.$repeatMillis
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r4, r9)
            if (r9 != r0) goto L38
            return r0
        L5c:
            boolean r9 = r8.$runActionOnUiThread
            if (r9 == 0) goto L6d
            com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2 r9 = new com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r8.$action
            r9.<init>(r0, r2)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            com.anggrayudi.storage.extension.CoroutineExtKt.BuiltInFictitiousFunctionClassFactory(r9)
            goto L72
        L6d:
            kotlin.jvm.functions.Function0<kotlin.Unit> r9 = r8.$action
            r9.invoke()
        L72:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1", f = "CoroutineExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$action.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2", f = "CoroutineExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.anggrayudi.storage.extension.CoroutineExtKt$startCoroutineTimer$1$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$action = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$action.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
