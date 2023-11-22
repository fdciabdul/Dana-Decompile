package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class DocumentFileUtils$copyFolderTo$finalize$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ FolderCallback $callback;
    final /* synthetic */ ArrayList<FolderCallback.FileConflict> $conflictedFiles;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $deleteSourceWhenComplete;
    final /* synthetic */ Ref.BooleanRef $success;
    final /* synthetic */ DocumentFile $targetFolder;
    final /* synthetic */ DocumentFile $this_copyFolderTo;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $totalFilesToCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyFolderTo$finalize$1(Ref.ObjectRef<Job> objectRef, Ref.BooleanRef booleanRef, ArrayList<FolderCallback.FileConflict> arrayList, boolean z, DocumentFile documentFile, Context context, FolderCallback folderCallback, DocumentFile documentFile2, Ref.IntRef intRef, Ref.IntRef intRef2) {
        super(0);
        this.$timer = objectRef;
        this.$success = booleanRef;
        this.$conflictedFiles = arrayList;
        this.$deleteSourceWhenComplete = z;
        this.$this_copyFolderTo = documentFile;
        this.$context = context;
        this.$callback = folderCallback;
        this.$targetFolder = documentFile2;
        this.$totalFilesToCopy = intRef;
        this.$totalCopiedFiles = intRef2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        Job job = this.$timer.element;
        boolean z = true;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        if (!this.$success.element || this.$conflictedFiles.isEmpty()) {
            if (this.$deleteSourceWhenComplete && this.$success.element) {
                DocumentFileUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.$this_copyFolderTo, this.$context, false);
            }
            BuildersKt__Builders_commonKt.launch$default(this.$callback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyFolderTo$finalize$1$invoke$$inlined$postToUi$1(null, this.$callback, this.$targetFolder, this.$totalFilesToCopy, this.$totalCopiedFiles, this.$success), 2, null);
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
