package com.anggrayudi.storage.media;

import com.anggrayudi.storage.callback.ZipDecompressionCallback;
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
@DebugMetadata(c = "com.anggrayudi.storage.media.MediaFileUtils$decompressZip$$inlined$postToUi$7", f = "MediaFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class MediaFileUtils$decompressZip$$inlined$postToUi$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZipDecompressionCallback $callback$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFileUtils$decompressZip$$inlined$postToUi$7(Continuation continuation, ZipDecompressionCallback zipDecompressionCallback) {
        super(2, continuation);
        this.$callback$inlined = zipDecompressionCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaFileUtils$decompressZip$$inlined$postToUi$7(continuation, this.$callback$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaFileUtils$decompressZip$$inlined$postToUi$7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ZipDecompressionCallback.PlaceComponentResult(ZipDecompressionCallback.ErrorCode.MISSING_ZIP_FILE);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
