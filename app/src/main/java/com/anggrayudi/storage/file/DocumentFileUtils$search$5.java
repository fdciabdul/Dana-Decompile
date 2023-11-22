package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Landroidx/documentfile/provider/DocumentFile;", "kotlin.jvm.PlatformType", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class DocumentFileUtils$search$5 extends Lambda implements Function1<DocumentFile, Boolean> {
    final /* synthetic */ String[] $mimeTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$search$5(String[] strArr) {
        super(1);
        this.$mimeTypes = strArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(DocumentFile documentFile) {
        boolean MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(documentFile, "");
        String[] strArr = this.$mimeTypes;
        Intrinsics.checkNotNull(strArr);
        MyBillsEntityDataFactory = DocumentFileUtils.MyBillsEntityDataFactory(documentFile, strArr);
        return Boolean.valueOf(MyBillsEntityDataFactory);
    }
}
