package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.callback.FolderCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "errorCode", "", BridgeDSL.INVOKE, "(Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class DocumentFileUtils$copyFolderTo$notifyCanceled$1 extends Lambda implements Function1<FolderCallback.ErrorCode, Unit> {
    final /* synthetic */ FolderCallback $$callback;
    final /* synthetic */ Ref.BooleanRef $$canceled;
    final /* synthetic */ Ref.ObjectRef<DocumentFile> $$targetFile;
    final /* synthetic */ DocumentFile $$targetFolder;
    final /* synthetic */ Ref.ObjectRef<Job> $$timer;
    final /* synthetic */ Ref.IntRef $$totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $$totalFilesToCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyFolderTo$notifyCanceled$1(Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<DocumentFile> objectRef2, FolderCallback folderCallback, DocumentFile documentFile, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(1);
        this.$$canceled = booleanRef;
        this.$$timer = objectRef;
        this.$$targetFile = objectRef2;
        this.$$callback = folderCallback;
        this.$$targetFolder = documentFile;
        this.$$totalFilesToCopy = intRef;
        this.$$totalCopiedFiles = intRef2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(FolderCallback.ErrorCode errorCode) {
        invoke2(errorCode);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(FolderCallback.ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "");
        if (this.$$canceled.element) {
            return;
        }
        this.$$canceled.element = true;
        Job job = this.$$timer.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        DocumentFile documentFile = this.$$targetFile.element;
        if (documentFile != null) {
            documentFile.MyBillsEntityDataFactory();
        }
        BuildersKt__Builders_commonKt.launch$default(this.$$callback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyFolderTo$notifyCanceled$1$invoke$$inlined$postToUi$1(null, this.$$callback, errorCode, this.$$targetFolder, this.$$totalFilesToCopy, this.$$totalCopiedFiles), 2, null);
    }
}
