package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000b\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class DocumentFileUtils$copyTo$finalize$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ MultipleFileCallback $callback;
    final /* synthetic */ List<FolderCallback.FileConflict> $conflictedFiles;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $deleteSourceWhenComplete;
    final /* synthetic */ Map<DocumentFile, DocumentFile> $results;
    final /* synthetic */ Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> $sourceInfos;
    final /* synthetic */ Ref.BooleanRef $success;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ int $totalFilesToCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyTo$finalize$1(Ref.ObjectRef<Job> objectRef, Ref.BooleanRef booleanRef, List<FolderCallback.FileConflict> list, boolean z, Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> map, Map<DocumentFile, DocumentFile> map2, int i, Ref.IntRef intRef, MultipleFileCallback multipleFileCallback, Context context) {
        super(0);
        this.$timer = objectRef;
        this.$success = booleanRef;
        this.$conflictedFiles = list;
        this.$deleteSourceWhenComplete = z;
        this.$sourceInfos = map;
        this.$results = map2;
        this.$totalFilesToCopy = i;
        this.$totalCopiedFiles = intRef;
        this.$callback = multipleFileCallback;
        this.$context = context;
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
                Map<DocumentFile, DocumentFileUtils$copyTo$SourceInfo> map = this.$sourceInfos;
                Context context = this.$context;
                Iterator<Map.Entry<DocumentFile, DocumentFileUtils$copyTo$SourceInfo>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    DocumentFileUtils.getAuthRequestContext(it.next().getKey(), context, false);
                }
            }
            Map<DocumentFile, DocumentFile> map2 = this.$results;
            ArrayList arrayList = new ArrayList(map2.size());
            Iterator<Map.Entry<DocumentFile, DocumentFile>> it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getValue());
            }
            MultipleFileCallback.Result result = new MultipleFileCallback.Result(arrayList, this.$totalFilesToCopy, this.$totalCopiedFiles.element, this.$success.element);
            BuildersKt__Builders_commonKt.launch$default(this.$callback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyTo$finalize$1$invoke$$inlined$postToUi$1(null, this.$callback, result), 2, null);
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
