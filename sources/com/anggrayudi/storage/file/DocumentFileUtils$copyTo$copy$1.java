package com.anggrayudi.storage.file;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import com.anggrayudi.storage.extension.IOUtils;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/documentfile/provider/DocumentFile;", "sourceFile", "destFile", "", BridgeDSL.INVOKE, "(Landroidx/documentfile/provider/DocumentFile;Landroidx/documentfile/provider/DocumentFile;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class DocumentFileUtils$copyTo$copy$1 extends Lambda implements Function2<DocumentFile, DocumentFile, Unit> {
    final /* synthetic */ byte[] $$buffer;
    final /* synthetic */ Ref.LongRef $$bytesMoved;
    final /* synthetic */ MultipleFileCallback $$callback;
    final /* synthetic */ Context $$context;
    final /* synthetic */ boolean $$deleteSourceWhenComplete;
    final /* synthetic */ Ref.IntRef $$totalCopiedFiles;
    final /* synthetic */ Ref.IntRef $$writeSpeed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$copyTo$copy$1(Context context, MultipleFileCallback multipleFileCallback, Ref.IntRef intRef, boolean z, byte[] bArr, Ref.LongRef longRef, Ref.IntRef intRef2) {
        super(2);
        this.$$context = context;
        this.$$callback = multipleFileCallback;
        this.$$totalCopiedFiles = intRef;
        this.$$deleteSourceWhenComplete = z;
        this.$$buffer = bArr;
        this.$$bytesMoved = longRef;
        this.$$writeSpeed = intRef2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Unit invoke(DocumentFile documentFile, DocumentFile documentFile2) {
        invoke2(documentFile, documentFile2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DocumentFile documentFile, DocumentFile documentFile2) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(documentFile2, "");
        Context context = this.$$context;
        MultipleFileCallback multipleFileCallback = this.$$callback;
        final byte[] bArr = this.$$buffer;
        final Ref.LongRef longRef = this.$$bytesMoved;
        final Ref.IntRef intRef = this.$$writeSpeed;
        DocumentFileUtils.MyBillsEntityDataFactory(context, documentFile, documentFile2, multipleFileCallback, new Function2<InputStream, OutputStream, Unit>() { // from class: com.anggrayudi.storage.file.DocumentFileUtils$copyTo$copy$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(InputStream inputStream, OutputStream outputStream) {
                invoke2(inputStream, outputStream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InputStream inputStream, OutputStream outputStream) {
                Intrinsics.checkNotNullParameter(inputStream, "");
                Intrinsics.checkNotNullParameter(outputStream, "");
                try {
                    int read = inputStream.read(bArr);
                    while (read != -1) {
                        outputStream.write(bArr, 0, read);
                        longRef.element += read;
                        intRef.element += read;
                        read = inputStream.read(bArr);
                    }
                } finally {
                    IOUtils.KClassImpl$Data$declaredNonStaticMembers$2(inputStream);
                    IOUtils.KClassImpl$Data$declaredNonStaticMembers$2(outputStream);
                }
            }
        });
        this.$$totalCopiedFiles.element++;
        if (this.$$deleteSourceWhenComplete) {
            documentFile.MyBillsEntityDataFactory();
        }
    }
}
