package id.dana.nearbyme.merchantdetail.viewcomponent;

import id.dana.nearbyme.merchantdetail.enums.MerchantMenu;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class MerchantDetailMenuView$setupAdapter$2 extends FunctionReferenceImpl implements Function1<MerchantMenu, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MerchantDetailMenuView$setupAdapter$2(Object obj) {
        super(1, obj, MerchantDetailMenuView.class, "onMenuClick", "onMenuClick(Lid/dana/nearbyme/merchantdetail/enums/MerchantMenu;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(MerchantMenu merchantMenu) {
        invoke2(merchantMenu);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MerchantMenu merchantMenu) {
        Intrinsics.checkNotNullParameter(merchantMenu, "");
        MerchantDetailMenuView.access$onMenuClick((MerchantDetailMenuView) this.receiver, merchantMenu);
    }
}
