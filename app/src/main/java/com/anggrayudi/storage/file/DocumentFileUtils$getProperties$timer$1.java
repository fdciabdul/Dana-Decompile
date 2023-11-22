package com.anggrayudi.storage.file;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.file.FileProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class DocumentFileUtils$getProperties$timer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FileProperties.CalculationCallback $$callback;
    final /* synthetic */ FileProperties $$properties;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$getProperties$timer$1(FileProperties.CalculationCallback calculationCallback, FileProperties fileProperties) {
        super(0);
        this.$$callback = calculationCallback;
        this.$$properties = fileProperties;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BuildersKt__Builders_commonKt.launch$default(this.$$callback.KClassImpl$Data$declaredNonStaticMembers$2, Dispatchers.getMain(), null, new DocumentFileUtils$getProperties$timer$1$invoke$$inlined$postToUi$1(null, this.$$callback, this.$$properties), 2, null);
    }
}
