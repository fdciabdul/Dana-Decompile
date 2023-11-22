package id.dana.bottomsheet;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class BaseBottomSheetRadioButton$onShow$1 extends FunctionReferenceImpl implements Function1<View, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseBottomSheetRadioButton$onShow$1(Object obj) {
        super(1, obj, BaseBottomSheetRadioButton.class, "PlaceComponentResult", "PlaceComponentResult(Landroid/view/View;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ((BaseBottomSheetRadioButton) this.receiver).PlaceComponentResult(view);
    }
}
