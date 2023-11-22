package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroidx/documentfile/provider/DocumentFile;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class DocumentFileUtils$compressToZip$9 extends Lambda implements Function1<DocumentFile, Boolean> {
    final /* synthetic */ DocumentFile $targetZipFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$compressToZip$9(DocumentFile documentFile) {
        super(1);
        this.$targetZipFile = documentFile;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        return Boolean.valueOf(Intrinsics.areEqual(documentFile.getErrorConfigVersion(), this.$targetZipFile.getErrorConfigVersion()));
    }
}
