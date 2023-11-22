package id.dana.oauth.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemAgreementScopeBinding;
import id.dana.oauth.model.ScopeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/oauth/adapter/AgreementScopeAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/oauth/model/ScopeModel;", "<init>", "()V", "ScopeViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgreementScopeAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ScopeModel>, ScopeModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ScopeViewHolder(viewGroup);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/oauth/adapter/AgreementScopeAdapter$ScopeViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/oauth/model/ScopeModel;", "Lid/dana/databinding/ItemAgreementScopeBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class ScopeViewHolder extends ViewBindingRecyclerViewHolder<ScopeModel, ItemAgreementScopeBinding> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(Object obj) {
            ScopeModel scopeModel = (ScopeModel) obj;
            super.bindData(scopeModel);
            getBinding().getAuthRequestContext.setText(scopeModel != null ? scopeModel.PlaceComponentResult : null);
        }

        @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
        public final /* synthetic */ ItemAgreementScopeBinding initViewBinding(View view) {
            Intrinsics.checkNotNullParameter(view, "");
            ItemAgreementScopeBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemAgreementScopeBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ScopeViewHolder(android.view.ViewGroup r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                android.content.Context r1 = r3.getContext()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                r0 = 2131559036(0x7f0d027c, float:1.8743405E38)
                r2.<init>(r1, r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.adapter.AgreementScopeAdapter.ScopeViewHolder.<init>(android.view.ViewGroup):void");
        }
    }
}
