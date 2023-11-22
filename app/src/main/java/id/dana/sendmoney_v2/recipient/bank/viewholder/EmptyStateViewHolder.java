package id.dana.sendmoney_v2.recipient.bank.viewholder;

import android.content.Context;
import android.view.View;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemRecipientContactNoPermissionBinding;
import id.dana.richview.EmptyStateView;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney_v2.recipient.model.EmptyStateViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney_v2/recipient/bank/viewholder/EmptyStateViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecipientViewModel;", "Lid/dana/databinding/ItemRecipientContactNoPermissionBinding;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyStateViewHolder extends ViewBindingRecyclerViewHolder<RecipientViewModel, ItemRecipientContactNoPermissionBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        RecipientViewModel recipientViewModel = (RecipientViewModel) obj;
        EmptyStateViewModel emptyStateViewModel = recipientViewModel instanceof EmptyStateViewModel ? (EmptyStateViewModel) recipientViewModel : null;
        if (emptyStateViewModel != null) {
            EmptyStateView emptyStateView = getBinding().BuiltInFictitiousFunctionClassFactory;
            if (!emptyStateView.isViewBinded()) {
                emptyStateView = null;
            }
            if (emptyStateView != null) {
                Context context = emptyStateView.getContext();
                String string = context != null ? context.getString(emptyStateViewModel.MyBillsEntityDataFactory) : null;
                if (string == null) {
                    string = "";
                }
                emptyStateView.setTitle(string);
                Context context2 = emptyStateView.getContext();
                String string2 = context2 != null ? context2.getString(emptyStateViewModel.BuiltInFictitiousFunctionClassFactory) : null;
                if (string2 == null) {
                    string2 = "";
                }
                emptyStateView.setDesc(string2);
                emptyStateView.setIcon(emptyStateViewModel.PlaceComponentResult);
                Context context3 = emptyStateView.getContext();
                String string3 = context3 != null ? context3.getString(emptyStateViewModel.KClassImpl$Data$declaredNonStaticMembers$2) : null;
                emptyStateView.setAction(string3 != null ? string3 : "");
                emptyStateView.setHasAction(emptyStateViewModel.getGetAuthRequestContext());
            }
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemRecipientContactNoPermissionBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemRecipientContactNoPermissionBinding PlaceComponentResult = ItemRecipientContactNoPermissionBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EmptyStateViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559237(0x7f0d0345, float:1.8743812E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.bank.viewholder.EmptyStateViewHolder.<init>(android.view.ViewGroup):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnActionClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.bank.viewholder.EmptyStateViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmptyStateViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(BaseRecyclerViewHolder.OnItemClickListener.this, this);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, EmptyStateViewHolder emptyStateViewHolder) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        Intrinsics.checkNotNullParameter(emptyStateViewHolder, "");
        onItemClickListener.onItemClick(emptyStateViewHolder.getBindingAdapterPosition());
    }
}
