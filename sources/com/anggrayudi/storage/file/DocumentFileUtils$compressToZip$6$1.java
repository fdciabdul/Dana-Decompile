package com.anggrayudi.storage.file;

import com.anggrayudi.storage.extension.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"com/anggrayudi/storage/file/DocumentFileUtils$compressToZip$EntryFile", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class DocumentFileUtils$compressToZip$6$1 extends Lambda implements Function1<DocumentFileUtils$compressToZip$EntryFile, Boolean> {
    final /* synthetic */ String $parent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$compressToZip$6$1(String str) {
        super(1);
        this.$parent = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(DocumentFileUtils$compressToZip$EntryFile documentFileUtils$compressToZip$EntryFile) {
        Intrinsics.checkNotNullParameter(documentFileUtils$compressToZip$EntryFile, "");
        return Boolean.valueOf(TextUtils.KClassImpl$Data$declaredNonStaticMembers$2(documentFileUtils$compressToZip$EntryFile.BuiltInFictitiousFunctionClassFactory, this.$parent));
    }
}
