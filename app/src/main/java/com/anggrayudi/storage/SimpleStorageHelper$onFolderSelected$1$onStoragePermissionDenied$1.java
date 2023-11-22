package com.anggrayudi.storage;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(Z)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes7.dex */
final class SimpleStorageHelper$onFolderSelected$1$onStoragePermissionDenied$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ SimpleStorageHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleStorageHelper$onFolderSelected$1$onStoragePermissionDenied$1(SimpleStorageHelper simpleStorageHelper) {
        super(1);
        this.this$0 = simpleStorageHelper;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            SimpleStorage.PlaceComponentResult(this.this$0.lookAheadTest);
        } else {
            SimpleStorageHelper.moveToNextValue(this.this$0);
        }
    }
}
