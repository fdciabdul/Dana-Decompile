package id.dana.social.view.activity.detail;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.state.ViewHolderState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003B\u0019\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/social/view/activity/detail/EmptyViewHolder;", "", "T", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/state/ViewHolderState;", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "p0", "", "p1", "<init>", "(Landroid/view/ViewGroup;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyViewHolder<T> extends BaseRecyclerViewHolder<ViewHolderState<? extends T>> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ViewGroup BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ EmptyViewHolder(ViewGroup viewGroup, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i2 & 2) != 0 ? R.layout.viewholder_empty_state : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private EmptyViewHolder(ViewGroup viewGroup, int i) {
        super(viewGroup.getContext(), i, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.BuiltInFictitiousFunctionClassFactory = viewGroup;
    }
}
