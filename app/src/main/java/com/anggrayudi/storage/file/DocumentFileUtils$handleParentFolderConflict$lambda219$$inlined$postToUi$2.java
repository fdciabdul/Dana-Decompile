package com.anggrayudi.storage.file;

import com.anggrayudi.storage.callback.FolderCallback;
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
@DebugMetadata(c = "com.anggrayudi.storage.file.DocumentFileUtils$handleParentFolderConflict$lambda-219$$inlined$postToUi$2", f = "DocumentFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$handleParentFolderConflict$lambda-219$$inlined$postToUi$2  reason: invalid class name */
/* loaded from: classes3.dex */
public final class DocumentFileUtils$handleParentFolderConflict$lambda219$$inlined$postToUi$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FolderCallback $callback$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$handleParentFolderConflict$lambda219$$inlined$postToUi$2(Continuation continuation, FolderCallback folderCallback) {
        super(2, continuation);
        this.$callback$inlined = folderCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$handleParentFolderConflict$lambda219$$inlined$postToUi$2(continuation, this.$callback$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentFileUtils$handleParentFolderConflict$lambda219$$inlined$postToUi$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FolderCallback.ErrorCode errorCode = FolderCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
