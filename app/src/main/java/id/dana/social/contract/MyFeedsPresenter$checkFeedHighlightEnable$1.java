package id.dana.social.contract;

import id.dana.social.contract.MyFeedsContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class MyFeedsPresenter$checkFeedHighlightEnable$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MyFeedsPresenter$checkFeedHighlightEnable$1(Object obj) {
        super(1, obj, MyFeedsContract.View.class, "MyBillsEntityDataFactory", "MyBillsEntityDataFactory(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ((MyFeedsContract.View) this.receiver).MyBillsEntityDataFactory(z);
    }
}
