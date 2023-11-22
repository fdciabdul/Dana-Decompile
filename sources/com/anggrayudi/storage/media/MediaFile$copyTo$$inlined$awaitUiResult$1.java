package com.anggrayudi.storage.media;

import com.anggrayudi.storage.callback.FileCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¨\u0006\u0002"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$awaitUiResult$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.anggrayudi.storage.media.MediaFile$copyTo$$inlined$awaitUiResult$1", f = "MediaFile.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class MediaFile$copyTo$$inlined$awaitUiResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ FileCallback $callback$inlined;
    final /* synthetic */ Thread $thread$inlined;
    final /* synthetic */ CoroutineScope $uiScope;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MediaFile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFile$copyTo$$inlined$awaitUiResult$1(CoroutineScope coroutineScope, Continuation continuation, FileCallback fileCallback, MediaFile mediaFile, Thread thread) {
        super(2, continuation);
        this.$uiScope = coroutineScope;
        this.$callback$inlined = fileCallback;
        this.this$0 = mediaFile;
        this.$thread$inlined = thread;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaFile$copyTo$$inlined$awaitUiResult$1(this.$uiScope, continuation, this.$callback$inlined, this.this$0, this.$thread$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((MediaFile$copyTo$$inlined$awaitUiResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¨\u0006\u0003"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "", "com/anggrayudi/storage/extension/CoroutineExtKt$awaitUiResult$1$1$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.anggrayudi.storage.media.MediaFile$copyTo$$inlined$awaitUiResult$1$1", f = "MediaFile.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.anggrayudi.storage.media.MediaFile$copyTo$$inlined$awaitUiResult$1$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileCallback $callback$inlined;
        final /* synthetic */ CancellableContinuation $it;
        final /* synthetic */ Thread $thread$inlined;
        int label;
        final /* synthetic */ MediaFile this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CancellableContinuation cancellableContinuation, Continuation continuation, FileCallback fileCallback, MediaFile mediaFile, Thread thread) {
            super(2, continuation);
            this.$it = cancellableContinuation;
            this.$callback$inlined = fileCallback;
            this.this$0 = mediaFile;
            this.$thread$inlined = thread;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$it, continuation, this.$callback$inlined, this.this$0, this.$thread$inlined);
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
                CancellableContinuation cancellableContinuation = this.$it;
                Result.Companion companion = Result.INSTANCE;
                MediaFile mediaFile = this.this$0;
                Intrinsics.checkNotNullExpressionValue(this.$thread$inlined, "");
                cancellableContinuation.resumeWith(Result.m3179constructorimpl(Boxing.boxLong(FileCallback.MyBillsEntityDataFactory(mediaFile, this.$thread$inlined))));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope2 = this.$uiScope;
        this.L$0 = coroutineScope2;
        this.label = 1;
        MediaFile$copyTo$$inlined$awaitUiResult$1 mediaFile$copyTo$$inlined$awaitUiResult$1 = this;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(mediaFile$copyTo$$inlined$awaitUiResult$1), 1);
        cancellableContinuationImpl.initCancellability();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new AnonymousClass1(cancellableContinuationImpl, null, this.$callback$inlined, this.this$0, this.$thread$inlined), 2, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(mediaFile$copyTo$$inlined$awaitUiResult$1);
        }
        return result == coroutine_suspended ? coroutine_suspended : result;
    }
}
