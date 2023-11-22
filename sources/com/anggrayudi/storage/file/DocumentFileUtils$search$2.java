package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Landroidx/documentfile/provider/DocumentFile;", "kotlin.jvm.PlatformType", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class DocumentFileUtils$search$2 extends Lambda implements Function1<DocumentFile, Boolean> {
    final /* synthetic */ Regex $regex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$search$2(Regex regex) {
        super(1);
        this.$regex = regex;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(DocumentFile documentFile) {
        Regex regex = this.$regex;
        String KClassImpl$Data$declaredNonStaticMembers$2 = documentFile.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            KClassImpl$Data$declaredNonStaticMembers$2 = "";
        }
        return Boolean.valueOf(regex.matches(KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
