package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FileCallback;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u008a@¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "com/anggrayudi/storage/extension/CoroutineExtKt$postToUi$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$lambda-187$$inlined$postToUi$1", f = "DocumentFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$lambda-187$$inlined$postToUi$1  reason: invalid class name */
/* loaded from: classes3.dex */
public final class DocumentFileUtils$moveFileTo$lambda187$$inlined$postToUi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileCallback $callback$inlined;
    final /* synthetic */ File $it$inlined;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$moveFileTo$lambda187$$inlined$postToUi$1(Continuation continuation, FileCallback fileCallback, File file) {
        super(2, continuation);
        this.$callback$inlined = fileCallback;
        this.$it$inlined = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$moveFileTo$lambda187$$inlined$postToUi$1(continuation, this.$callback$inlined, this.$it$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentFileUtils$moveFileTo$lambda187$$inlined$postToUi$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DocumentFile KClassImpl$Data$declaredNonStaticMembers$2 = DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(this.$it$inlined);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
