package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/documentfile/provider/DocumentFile;", BridgeDSL.INVOKE, "()Landroidx/documentfile/provider/DocumentFile;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class DocumentFileCompat$mkdirs$tryCreateWithRawFile$1 extends Lambda implements Function0<DocumentFile> {
    final /* synthetic */ Context $$context;
    final /* synthetic */ String $$fullPath;
    final /* synthetic */ boolean $$requiresWriteAccess;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileCompat$mkdirs$tryCreateWithRawFile$1(String str, boolean z, Context context) {
        super(0);
        this.$$fullPath = str;
        this.$$requiresWriteAccess = z;
        this.$$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DocumentFile invoke() {
        DocumentFileCompat documentFileCompat = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
        File file = new File(DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.$$fullPath));
        file.mkdirs();
        if (file.isDirectory() && file.canRead() && ((this.$$requiresWriteAccess && FileUtils.BuiltInFictitiousFunctionClassFactory(file, this.$$context)) || !this.$$requiresWriteAccess)) {
            return DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(file);
        }
        return null;
    }
}
