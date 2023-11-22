package id.dana.kyb.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class MyBusinessFragment$bindRegisteredContent$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MyBusinessFragment$bindRegisteredContent$1$1(Object obj) {
        super(0, obj, MyBusinessFragment.class, "onBalanceWithdrawClicked", "onBalanceWithdrawClicked()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        MyBusinessFragment.getValueOfTouchPositionAbsolute((MyBusinessFragment) this.receiver);
    }
}
