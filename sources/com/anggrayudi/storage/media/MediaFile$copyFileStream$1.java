package com.anggrayudi.storage.media;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.callback.FileCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class MediaFile$copyFileStream$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.LongRef $$bytesMoved;
    final /* synthetic */ FileCallback $$callback;
    final /* synthetic */ long $$srcSize;
    final /* synthetic */ Ref.IntRef $$writeSpeed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaFile$copyFileStream$1(Ref.LongRef longRef, long j, Ref.IntRef intRef, FileCallback fileCallback) {
        super(0);
        this.$$bytesMoved = longRef;
        this.$$srcSize = j;
        this.$$writeSpeed = intRef;
        this.$$callback = fileCallback;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FileCallback.Report report = new FileCallback.Report((((float) this.$$bytesMoved.element) * 100.0f) / ((float) this.$$srcSize), this.$$bytesMoved.element, this.$$writeSpeed.element);
        BuildersKt__Builders_commonKt.launch$default(this.$$callback.PlaceComponentResult, Dispatchers.getMain(), null, new MediaFile$copyFileStream$1$invoke$$inlined$postToUi$1(null, this.$$callback, report), 2, null);
        this.$$writeSpeed.element = 0;
    }
}
