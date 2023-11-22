package com.afollestad.materialdialogs.files;

import android.content.Context;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.files.util.FilesUtilExtKt;
import com.afollestad.materialdialogs.files.util.ViewExtKt;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", BridgeDSL.INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.afollestad.materialdialogs.files.FileChooserAdapter$switchDirectory$1", f = "FileChooserAdapter.kt", i = {0}, l = {141}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes3.dex */
public final class FileChooserAdapter$switchDirectory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $$directory;
    Object L$0;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ FileChooserAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileChooserAdapter$switchDirectory$1(FileChooserAdapter fileChooserAdapter, File file, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fileChooserAdapter;
        this.$$directory = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "");
        FileChooserAdapter$switchDirectory$1 fileChooserAdapter$switchDirectory$1 = new FileChooserAdapter$switchDirectory$1(this.this$0, this.$$directory, continuation);
        fileChooserAdapter$switchDirectory$1.p$ = (CoroutineScope) obj;
        return fileChooserAdapter$switchDirectory$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FileChooserAdapter$switchDirectory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        MaterialDialog materialDialog;
        MaterialDialog materialDialog2;
        MaterialDialog materialDialog3;
        TextView textView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            z = this.this$0.onlyFolders;
            if (z) {
                this.this$0.setSelectedFile(this.$$directory);
                materialDialog3 = this.this$0.dialog;
                DialogActionExtKt.setActionButtonEnabled(materialDialog3, WhichButton.POSITIVE, true);
            }
            this.this$0.currentFolder = this.$$directory;
            materialDialog = this.this$0.dialog;
            File file = this.$$directory;
            materialDialog2 = this.this$0.dialog;
            Context context = materialDialog2.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "");
            MaterialDialog.title$default(materialDialog, null, FilesUtilExtKt.friendlyName(file, context), 1, null);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            FileChooserAdapter$switchDirectory$1$result$1 fileChooserAdapter$switchDirectory$1$result$1 = new FileChooserAdapter$switchDirectory$1$result$1(this, null);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = BuildersKt.withContext(io2, fileChooserAdapter$switchDirectory$1$result$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        FileChooserAdapter fileChooserAdapter = this.this$0;
        textView = fileChooserAdapter.emptyView;
        ViewExtKt.setVisible(textView, list.isEmpty());
        fileChooserAdapter.contents = list;
        this.this$0.notifyDataSetChanged();
        return Unit.INSTANCE;
    }
}
