package id.dana.myprofile.mepagerevamp.smartpay.viewholder;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.smartpay.view.NewPaymentAuthenticationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/myprofile/mepagerevamp/smartpay/viewholder/NewProfileMenuPaymentAuthViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/myprofile/mepagerevamp/smartpay/view/NewPaymentAuthenticationView;", "MyBillsEntityDataFactory", "Lid/dana/myprofile/mepagerevamp/smartpay/view/NewPaymentAuthenticationView;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileMenuPaymentAuthViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final NewPaymentAuthenticationView KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setTitle(settingModel2 != null ? settingModel2.getTitle() : null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileMenuPaymentAuthViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.new_item_authentication_payment, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        NewPaymentAuthenticationView newPaymentAuthenticationView = (NewPaymentAuthenticationView) this.itemView.findViewById(R.id.TopUpAndPayModule_ProvideTopUpAndPayViewFactory);
        Intrinsics.checkNotNullExpressionValue(newPaymentAuthenticationView, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = newPaymentAuthenticationView;
    }
}
