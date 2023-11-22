package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
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
@DebugMetadata(c = "com.anggrayudi.storage.file.DocumentFileUtils$copyFolderTo$finalize$1$invoke$$inlined$postToUi$1", f = "DocumentFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class DocumentFileUtils$copyFolderTo$finalize$1$invoke$$inlined$postToUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FolderCallback $callback$inlined;
    final /* synthetic */ Ref.BooleanRef $success$inlined;
    final /* synthetic */ DocumentFile $targetFolder$inlined;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles$inlined;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyFolderTo$finalize$1$invoke$$inlined$postToUi$1(Continuation continuation, FolderCallback folderCallback, DocumentFile documentFile, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.BooleanRef booleanRef) {
        super(2, continuation);
        this.$callback$inlined = folderCallback;
        this.$targetFolder$inlined = documentFile;
        this.$totalFilesToCopy$inlined = intRef;
        this.$totalCopiedFiles$inlined = intRef2;
        this.$success$inlined = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$copyFolderTo$finalize$1$invoke$$inlined$postToUi$1(continuation, this.$callback$inlined, this.$targetFolder$inlined, this.$totalFilesToCopy$inlined, this.$totalCopiedFiles$inlined, this.$success$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentFileUtils$copyFolderTo$finalize$1$invoke$$inlined$postToUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            new FolderCallback.Result(this.$targetFolder$inlined, this.$totalFilesToCopy$inlined.element, this.$totalCopiedFiles$inlined.element, this.$success$inlined.element);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
