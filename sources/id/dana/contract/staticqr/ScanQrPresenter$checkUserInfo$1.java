package id.dana.contract.staticqr;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.model.ScanModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScanQrPresenter$checkUserInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScanModel $$scanModel;
    final /* synthetic */ ScanQrPresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanQrPresenter$checkUserInfo$1(ScanQrPresenter scanQrPresenter, ScanModel scanModel) {
        super(0);
        this.this$0 = scanQrPresenter;
        this.$$scanModel = scanModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.BuiltInFictitiousFunctionClassFactory(this.$$scanModel);
    }
}
