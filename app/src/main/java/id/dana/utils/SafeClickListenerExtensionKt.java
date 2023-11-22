package id.dana.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "", "p0", "MyBillsEntityDataFactory", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SafeClickListenerExtensionKt {
    public static final void MyBillsEntityDataFactory(View view, final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(function1, "");
        view.setOnClickListener(new id.dana.utils.safeonclicklistener.SafeClickListener(0, new Function1<View, Unit>() { // from class: id.dana.utils.SafeClickListenerExtensionKt$setSafeOnClickListener$safeClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                Intrinsics.checkNotNullParameter(view2, "");
                function1.invoke(view2);
            }
        }, 1, null));
    }
}
