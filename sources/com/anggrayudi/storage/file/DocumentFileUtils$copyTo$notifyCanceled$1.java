package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "errorCode", "", BridgeDSL.INVOKE, "(Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class DocumentFileUtils$copyTo$notifyCanceled$1 extends Lambda implements Function1<MultipleFileCallback.ErrorCode, Unit> {
    final /* synthetic */ MultipleFileCallback $$callback;
    final /* synthetic */ Ref.BooleanRef $$canceled;
    final /* synthetic */ Map<DocumentFile, DocumentFile> $$results;
    final /* synthetic */ Ref.ObjectRef<DocumentFile> $$targetFile;
    final /* synthetic */ Ref.ObjectRef<Job> $$timer;
    final /* synthetic */ Ref.IntRef $$totalCopiedFiles;
    final /* synthetic */ int $$totalFilesToCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyTo$notifyCanceled$1(Ref.BooleanRef booleanRef, Ref.ObjectRef<Job> objectRef, Ref.ObjectRef<DocumentFile> objectRef2, Map<DocumentFile, DocumentFile> map, int i, Ref.IntRef intRef, MultipleFileCallback multipleFileCallback) {
        super(1);
        this.$$canceled = booleanRef;
        this.$$timer = objectRef;
        this.$$targetFile = objectRef2;
        this.$$results = map;
        this.$$totalFilesToCopy = i;
        this.$$totalCopiedFiles = intRef;
        this.$$callback = multipleFileCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(MultipleFileCallback.ErrorCode errorCode) {
        invoke2(errorCode);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MultipleFileCallback.ErrorCode errorCode) {
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
        Map<DocumentFile, DocumentFile> map = this.$$results;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<DocumentFile, DocumentFile>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        MultipleFileCallback.Result result = new MultipleFileCallback.Result(arrayList, this.$$totalFilesToCopy, this.$$totalCopiedFiles.element, false);
        BuildersKt__Builders_commonKt.launch$default(this.$$callback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyTo$notifyCanceled$1$invoke$$inlined$postToUi$1(null, this.$$callback, errorCode, result), 2, null);
    }
}
