package androidx.view;

import androidx.view.OnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OnBackPressedDispatcherKt {
    public static /* synthetic */ OnBackPressedCallback PlaceComponentResult(OnBackPressedDispatcher onBackPressedDispatcher, final Function1 function1) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher, "");
        Intrinsics.checkNotNullParameter(function1, "");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                function1.invoke(this);
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
        return onBackPressedCallback;
    }
}
