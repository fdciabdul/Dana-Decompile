package com.anggrayudi.storage.media;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.callback.ZipDecompressionCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class MediaFileUtils$decompressZip$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.LongRef $$bytesDecompressed;
    final /* synthetic */ ZipDecompressionCallback<MediaFile> $$callback;
    final /* synthetic */ Ref.IntRef $$fileDecompressedCount;
    final /* synthetic */ Ref.IntRef $$writeSpeed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaFileUtils$decompressZip$5(Ref.LongRef longRef, Ref.IntRef intRef, Ref.IntRef intRef2, ZipDecompressionCallback<MediaFile> zipDecompressionCallback) {
        super(0);
        this.$$bytesDecompressed = longRef;
        this.$$writeSpeed = intRef;
        this.$$fileDecompressedCount = intRef2;
        this.$$callback = zipDecompressionCallback;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ZipDecompressionCallback.Report report = new ZipDecompressionCallback.Report(this.$$bytesDecompressed.element, this.$$writeSpeed.element, this.$$fileDecompressedCount.element);
        BuildersKt__Builders_commonKt.launch$default(this.$$callback.KClassImpl$Data$declaredNonStaticMembers$2, Dispatchers.getMain(), null, new MediaFileUtils$decompressZip$5$invoke$$inlined$postToUi$1(null, this.$$callback, report), 2, null);
        this.$$writeSpeed.element = 0;
    }
}
