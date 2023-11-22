package com.anggrayudi.storage.media;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.ZipDecompressionCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u008a@¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "com/anggrayudi/storage/extension/CoroutineExtKt$postToUi$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.anggrayudi.storage.media.MediaFileUtils$decompressZip$$inlined$postToUi$11", f = "MediaFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class MediaFileUtils$decompressZip$$inlined$postToUi$11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $bytesDecompressed$inlined;
    final /* synthetic */ ZipDecompressionCallback $callback$inlined;
    final /* synthetic */ Ref.ObjectRef $destFolder$inlined;
    final /* synthetic */ Ref.IntRef $fileDecompressedCount$inlined;
    final /* synthetic */ MediaFile $this_decompressZip$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFileUtils$decompressZip$$inlined$postToUi$11(Continuation continuation, ZipDecompressionCallback zipDecompressionCallback, MediaFile mediaFile, Ref.ObjectRef objectRef, Ref.LongRef longRef, Ref.IntRef intRef) {
        super(2, continuation);
        this.$callback$inlined = zipDecompressionCallback;
        this.$this_decompressZip$inlined = mediaFile;
        this.$destFolder$inlined = objectRef;
        this.$bytesDecompressed$inlined = longRef;
        this.$fileDecompressedCount$inlined = intRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MediaFileUtils$decompressZip$$inlined$postToUi$11(continuation, this.$callback$inlined, this.$this_decompressZip$inlined, this.$destFolder$inlined, this.$bytesDecompressed$inlined, this.$fileDecompressedCount$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MediaFileUtils$decompressZip$$inlined$postToUi$11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DocumentFile documentFile = (DocumentFile) this.$destFolder$inlined.element;
            long j = this.$bytesDecompressed$inlined.element;
            int i = this.$fileDecompressedCount$inlined.element;
            ZipDecompressionCallback.BuiltInFictitiousFunctionClassFactory(documentFile);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
