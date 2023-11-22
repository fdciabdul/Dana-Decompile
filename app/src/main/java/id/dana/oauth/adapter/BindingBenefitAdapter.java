package id.dana.oauth.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.oauth.model.BindingBenefitModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/oauth/adapter/BindingBenefitAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/oauth/model/BindingBenefitModel;", "<init>", "()V", "BindingBenefitItemViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BindingBenefitAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<BindingBenefitModel>, BindingBenefitModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new BindingBenefitItemViewHolder(viewGroup);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/oauth/adapter/BindingBenefitAdapter$BindingBenefitItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/oauth/model/BindingBenefitModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final class BindingBenefitItemViewHolder extends BaseRecyclerViewHolder<BindingBenefitModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(BindingBenefitModel bindingBenefitModel) {
            String str;
            BindingBenefitModel bindingBenefitModel2 = bindingBenefitModel;
            if (bindingBenefitModel2 != null) {
                View view = this.itemView;
                TextView textView = (TextView) view.findViewById(R.id.res_0x7f0a13ca_r8_lambda_x5imhbcldeinkvcvzuebzsyaono);
                if (textView != null) {
                    if (StringsKt.equals(Locale.getDefault().getCountry(), "id", true)) {
                        str = bindingBenefitModel2.getAuthRequestContext;
                    } else {
                        str = bindingBenefitModel2.MyBillsEntityDataFactory;
                    }
                    textView.setText(str);
                }
                String str2 = bindingBenefitModel2.BuiltInFictitiousFunctionClassFactory;
                AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.clearJavaObjects);
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str2).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BindingBenefitItemViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_binding_benefit, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}
