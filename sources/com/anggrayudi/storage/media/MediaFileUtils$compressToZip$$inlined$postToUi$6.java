package com.anggrayudi.storage.media;

import com.anggrayudi.storage.callback.ZipCompressionCallback;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u008a@¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "com/anggrayudi/storage/extension/CoroutineExtKt$postToUi$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.anggrayudi.storage.media.MediaFileUtils$compressToZip$$inlined$postToUi$6", f = "MediaFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class MediaFileUtils$compressToZip$$inlined$postToUi$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZipCompressionCallback $callback$inlined;
    final /* synthetic */ FileNotFoundException $e$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFileUtils$compressToZip$$inlined$postToUi$6(Continuation continuation, ZipCompressionCallback zipCompressionCallback, FileNotFoundException fileNotFoundException) {
        super(2, continuation);
        this.$callback$inlined = zipCompressionCallback;
        this.$e$inlined = fileNotFoundException;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaFileUtils$compressToZip$$inlined$postToUi$6(continuation, this.$callback$inlined, this.$e$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaFileUtils$compressToZip$$inlined$postToUi$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ZipCompressionCallback.ErrorCode errorCode = ZipCompressionCallback.ErrorCode.MISSING_ENTRY_FILE;
            this.$e$inlined.getMessage();
            ZipCompressionCallback.MyBillsEntityDataFactory(errorCode);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
