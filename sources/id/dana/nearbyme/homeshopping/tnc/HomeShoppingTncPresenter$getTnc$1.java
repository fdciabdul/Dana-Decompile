package id.dana.nearbyme.homeshopping.tnc;

import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class HomeShoppingTncPresenter$getTnc$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeShoppingTncPresenter$getTnc$1(Object obj) {
        super(1, obj, HomeShoppingTncContract.View.class, "KClassImpl$Data$declaredNonStaticMembers$2", "KClassImpl$Data$declaredNonStaticMembers$2(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        ((HomeShoppingTncContract.View) this.receiver).KClassImpl$Data$declaredNonStaticMembers$2(str);
    }
}
