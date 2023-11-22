package id.dana.cashier.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.BenefitModel;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemDialogCashierAddOnBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/viewholder/BenefitViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/BenefitModel;", "Lid/dana/databinding/ItemDialogCashierAddOnBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BenefitViewHolder extends ViewBindingRecyclerViewHolder<BenefitModel, ItemDialogCashierAddOnBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        BenefitModel benefitModel = (BenefitModel) obj;
        ItemDialogCashierAddOnBinding binding = getBinding();
        if (benefitModel != null) {
            binding.PlaceComponentResult.setText(benefitModel.BuiltInFictitiousFunctionClassFactory);
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setText(benefitModel.PlaceComponentResult);
            CircleImageView circleImageView = binding.getAuthRequestContext;
            Context context = getContext();
            String string = context != null ? context.getString(R.string.sdet_img_benefit_info_addon, String.valueOf(getAbsoluteAdapterPosition())) : null;
            if (string == null) {
                string = "";
            }
            circleImageView.setContentDescription(string);
            AppCompatTextView appCompatTextView = binding.PlaceComponentResult;
            Context context2 = getContext();
            String string2 = context2 != null ? context2.getString(R.string.sdet_title_benefit_info_addon, String.valueOf(getAbsoluteAdapterPosition())) : null;
            if (string2 == null) {
                string2 = "";
            }
            appCompatTextView.setContentDescription(string2);
            AppCompatTextView appCompatTextView2 = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            Context context3 = getContext();
            String string3 = context3 != null ? context3.getString(R.string.sdet_desc_benefit_info_addon, String.valueOf(getAbsoluteAdapterPosition())) : null;
            appCompatTextView2.setContentDescription(string3 != null ? string3 : "");
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(benefitModel.getAuthRequestContext).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_no_image_state).PlaceComponentResult((int) R.drawable.ic_no_image_state).MyBillsEntityDataFactory((ImageView) binding.getAuthRequestContext);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemDialogCashierAddOnBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemDialogCashierAddOnBinding authRequestContext = ItemDialogCashierAddOnBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BenefitViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559087(0x7f0d02af, float:1.8743508E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.BenefitViewHolder.<init>(android.view.ViewGroup):void");
    }
}
