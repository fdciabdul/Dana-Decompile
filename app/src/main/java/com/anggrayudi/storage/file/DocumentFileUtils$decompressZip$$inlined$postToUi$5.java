package com.anggrayudi.storage.file;

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
@DebugMetadata(c = "com.anggrayudi.storage.file.DocumentFileUtils$decompressZip$$inlined$postToUi$5", f = "DocumentFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class DocumentFileUtils$decompressZip$$inlined$postToUi$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ZipDecompressionCallback $callback$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$decompressZip$$inlined$postToUi$5(Continuation continuation, ZipDecompressionCallback zipDecompressionCallback) {
        super(2, continuation);
        this.$callback$inlined = zipDecompressionCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$decompressZip$$inlined$postToUi$5(continuation, this.$callback$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentFileUtils$decompressZip$$inlined$postToUi$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
