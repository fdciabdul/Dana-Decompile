package id.dana.cashier.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.model.PaylaterOnboardingBenefitModel;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemPaylaterCicilOnboardingBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/viewholder/PaylaterCicilOnboardingBenefitViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/model/PaylaterOnboardingBenefitModel;", "Lid/dana/databinding/ItemPaylaterCicilOnboardingBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class PaylaterCicilOnboardingBenefitViewHolder extends ViewBindingRecyclerViewHolder<PaylaterOnboardingBenefitModel, ItemPaylaterCicilOnboardingBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        PaylaterOnboardingBenefitModel paylaterOnboardingBenefitModel = (PaylaterOnboardingBenefitModel) obj;
        if (paylaterOnboardingBenefitModel != null) {
            ItemPaylaterCicilOnboardingBinding binding = getBinding();
            AppCompatImageView appCompatImageView = binding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(paylaterOnboardingBenefitModel.PlaceComponentResult).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            binding.getAuthRequestContext.setText(paylaterOnboardingBenefitModel.KClassImpl$Data$declaredNonStaticMembers$2);
            AppCompatImageView appCompatImageView2 = binding.BuiltInFictitiousFunctionClassFactory;
            Context context = getContext();
            appCompatImageView2.setContentDescription(context != null ? context.getString(R.string.paylater_cicil_pop_up_registration_img_benefit_info, String.valueOf(getAbsoluteAdapterPosition())) : null);
            AppCompatTextView appCompatTextView = binding.getAuthRequestContext;
            Context context2 = getContext();
            appCompatTextView.setContentDescription(context2 != null ? context2.getString(R.string.paylater_cicil_pop_up_registration_desc_benefit_info, String.valueOf(getAbsoluteAdapterPosition())) : null);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemPaylaterCicilOnboardingBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemPaylaterCicilOnboardingBinding MyBillsEntityDataFactory = ItemPaylaterCicilOnboardingBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PaylaterCicilOnboardingBenefitViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559200(0x7f0d0320, float:1.8743737E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.PaylaterCicilOnboardingBenefitViewHolder.<init>(android.view.ViewGroup):void");
    }
}
