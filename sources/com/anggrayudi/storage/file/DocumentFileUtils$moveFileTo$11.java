package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.callback.FileCallback;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ljava/io/InputStream;", "inputStream", "Ljava/io/OutputStream;", "outputStream", "", BridgeDSL.INVOKE, "(Ljava/io/InputStream;Ljava/io/OutputStream;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
final class DocumentFileUtils$moveFileTo$11 extends Lambda implements Function2<InputStream, OutputStream, Unit> {
    final /* synthetic */ FileCallback $$callback;
    final /* synthetic */ long $$reportInterval;
    final /* synthetic */ DocumentFile $$targetFile;
    final /* synthetic */ DocumentFile $$this_moveFileTo;
    final /* synthetic */ boolean $$watchProgress;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$moveFileTo$11(DocumentFile documentFile, DocumentFile documentFile2, boolean z, long j, FileCallback fileCallback) {
        super(2);
        this.$$this_moveFileTo = documentFile;
        this.$$targetFile = documentFile2;
        this.$$watchProgress = z;
        this.$$reportInterval = j;
        this.$$callback = fileCallback;
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
        DocumentFileUtils.PlaceComponentResult(this.$$this_moveFileTo, inputStream, outputStream, this.$$targetFile, this.$$watchProgress, this.$$reportInterval, true, this.$$callback);
    }
}
