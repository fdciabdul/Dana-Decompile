package id.dana.base;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a,\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0019\u0010\u0004\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "p0", "PlaceComponentResult", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ThrottledOnClickListenerKt {
    public static final void PlaceComponentResult(View view, final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(function1, "");
        view.setOnClickListener(new ThrottledOnClickListener(0L, new Function1<View, Unit>() { // from class: id.dana.base.ThrottledOnClickListenerKt$setThrottledOnClickListener$1
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
