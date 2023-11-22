package id.dana.social.state;

import id.dana.social.state.ViewHolderState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewHolderStateKt {
    public static /* synthetic */ int BuiltInFictitiousFunctionClassFactory(ViewHolderState viewHolderState) {
        ViewHolderStateKt$getViewHolderStateViewType$1 viewHolderStateKt$getViewHolderStateViewType$1 = new Function0<Integer>() { // from class: id.dana.social.state.ViewHolderStateKt$getViewHolderStateViewType$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return 1;
            }
        };
        Intrinsics.checkNotNullParameter(viewHolderState, "");
        Intrinsics.checkNotNullParameter(viewHolderStateKt$getViewHolderStateViewType$1, "");
        if (viewHolderState instanceof ViewHolderState.Item) {
            return viewHolderStateKt$getViewHolderStateViewType$1.invoke().intValue();
        }
        if (viewHolderState instanceof ViewHolderState.LoadingMore) {
            return 2;
        }
        if (viewHolderState instanceof ViewHolderState.Shimmer) {
            return 3;
        }
        if (viewHolderState instanceof ViewHolderState.Empty) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }
}
