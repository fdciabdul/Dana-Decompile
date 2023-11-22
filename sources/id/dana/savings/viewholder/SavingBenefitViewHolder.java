package id.dana.savings.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.savings.model.SavingBenefitModel;
import id.dana.utils.ResourceUtils;
import id.dana.utils.SizeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0012\u0010\u0006\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/savings/viewholder/SavingBenefitViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/savings/model/SavingBenefitModel;", "", "MyBillsEntityDataFactory", "I", "PlaceComponentResult", "Landroid/content/Context;", "p0", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavingBenefitViewHolder extends BaseRecyclerViewHolder<SavingBenefitModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SavingBenefitModel savingBenefitModel) {
        SavingBenefitModel savingBenefitModel2 = savingBenefitModel;
        if (savingBenefitModel2 != null) {
            LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.res_0x7f0a0d7d_configurationconstants_logsourcename_1);
            ViewGroup.LayoutParams layoutParams = linearLayout != null ? linearLayout.getLayoutParams() : null;
            if (layoutParams != null) {
                layoutParams.height = this.PlaceComponentResult + SizeUtil.getAuthRequestContext(50);
            }
            TextView textView = (TextView) this.itemView.findViewById(R.id.tv_benefit_title);
            if (textView != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                textView.setText(ResourceUtils.PlaceComponentResult(context, savingBenefitModel2.BuiltInFictitiousFunctionClassFactory, savingBenefitModel2.BuiltInFictitiousFunctionClassFactory));
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.tv_benefit_desc);
            if (textView2 != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                textView2.setText(ResourceUtils.PlaceComponentResult(context2, savingBenefitModel2.getAuthRequestContext, savingBenefitModel2.getAuthRequestContext));
            }
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "");
            int KClassImpl$Data$declaredNonStaticMembers$2 = ResourceUtils.KClassImpl$Data$declaredNonStaticMembers$2(context3, savingBenefitModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            if (KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_benefit_icon);
                if (appCompatImageView != null) {
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2)).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) appCompatImageView);
                    return;
                }
                return;
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.itemView.findViewById(R.id.iv_benefit_icon);
            if (appCompatImageView2 != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                GlideApp.getAuthRequestContext(appCompatImageView2.getContext()).PlaceComponentResult(savingBenefitModel2.KClassImpl$Data$declaredNonStaticMembers$2).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavingBenefitViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.item_benefit, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
