package id.dana.myprofile.viewholder;

import android.view.View;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemProfileMenuReferralBinding;
import id.dana.domain.profilemenu.model.SettingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/myprofile/viewholder/NewProfileMenuReferralViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/databinding/ItemProfileMenuReferralBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileMenuReferralViewHolder extends ViewBindingRecyclerViewHolder<SettingModel, ItemProfileMenuReferralBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        SettingModel settingModel = (SettingModel) obj;
        getBinding().moveToNextValue.setText(settingModel != null ? settingModel.getTitle() : null);
        Integer valueOf = settingModel != null ? Integer.valueOf(settingModel.getReferralUserCount()) : null;
        if (valueOf != null && valueOf.intValue() > 0) {
            getBinding().PlaceComponentResult.setVisibility(0);
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(0);
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(getContext().getString(R.string.referral_banner_subtitle, valueOf));
        } else {
            getBinding().PlaceComponentResult.setVisibility(0);
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(8);
        }
        if (settingModel != null ? settingModel.isStartReferralLottie() : true) {
            getBinding().getAuthRequestContext.resumeAnimation();
        } else {
            getBinding().getAuthRequestContext.pauseAnimation();
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemProfileMenuReferralBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemProfileMenuReferralBinding MyBillsEntityDataFactory = ItemProfileMenuReferralBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NewProfileMenuReferralViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559223(0x7f0d0337, float:1.8743784E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.viewholder.NewProfileMenuReferralViewHolder.<init>(android.view.ViewGroup):void");
    }
}
