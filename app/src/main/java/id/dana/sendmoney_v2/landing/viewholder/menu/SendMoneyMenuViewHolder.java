package id.dana.sendmoney_v2.landing.viewholder.menu;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ItemHomeMenuSendmoneyBinding;
import id.dana.model.SendMoneyScenarioModel;
import id.dana.sendmoney.recipienthome.SendMoneyScenarioActionType;
import id.dana.sendmoney_v2.landing.view.RecipientRibbonView;
import id.dana.utils.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney_v2/landing/viewholder/menu/SendMoneyMenuViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/model/SendMoneyScenarioModel;", "Lid/dana/databinding/ItemHomeMenuSendmoneyBinding;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SendMoneyMenuViewHolder extends ViewBindingRecyclerViewHolder<SendMoneyScenarioModel, ItemHomeMenuSendmoneyBinding> {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(Object obj) {
        int i;
        SendMoneyScenarioModel sendMoneyScenarioModel = (SendMoneyScenarioModel) obj;
        if (sendMoneyScenarioModel != null) {
            String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyScenarioModel.FragmentBottomSheetPaymentSettingBinding);
            AppCompatTextView appCompatTextView = getBinding().lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            String str = KClassImpl$Data$declaredNonStaticMembers$2;
            appCompatTextView.setVisibility(StringsKt.isBlank(str) ^ true ? 0 : 8);
            appCompatTextView.setText(str);
            String KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda6);
            AppCompatTextView appCompatTextView2 = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
            String str2 = KClassImpl$Data$declaredNonStaticMembers$22;
            appCompatTextView2.setVisibility(StringsKt.isBlank(str2) ^ true ? 0 : 8);
            appCompatTextView2.setText(str2);
            String str3 = sendMoneyScenarioModel.MyBillsEntityDataFactory;
            String str4 = sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2;
            switch (str4.hashCode()) {
                case -1820761141:
                    if (str4.equals("external")) {
                        i = R.drawable.ic_x2c_48dp;
                        break;
                    }
                    i = R.drawable.white_seven_circle;
                    break;
                case -1442835217:
                    if (str4.equals(SendMoneyScenarioActionType.SALDO_DIGITAL)) {
                        i = R.drawable.ic_saldo_digital;
                        break;
                    }
                    i = R.drawable.white_seven_circle;
                    break;
                case -1192969641:
                    if (str4.equals("phoneNumber")) {
                        i = R.drawable.ic_x2p_48dp;
                        break;
                    }
                    i = R.drawable.white_seven_circle;
                    break;
                case -1005516787:
                    if (str4.equals("outlet")) {
                        i = R.drawable.ic_send_to_outlet;
                        break;
                    }
                    i = R.drawable.white_seven_circle;
                    break;
                case 3016252:
                    if (str4.equals("bank")) {
                        i = R.drawable.ic_x2b_gold;
                        break;
                    }
                    i = R.drawable.white_seven_circle;
                    break;
                case 3052376:
                    if (str4.equals("chat")) {
                        i = R.drawable.ic_x2l_48dp;
                        break;
                    }
                    i = R.drawable.white_seven_circle;
                    break;
                case 98629247:
                    if (str4.equals("group")) {
                        i = R.drawable.ic_send_to_group;
                        break;
                    }
                    i = R.drawable.white_seven_circle;
                    break;
                default:
                    i = R.drawable.white_seven_circle;
                    break;
            }
            Intrinsics.checkNotNullParameter(str3, "");
            AppCompatImageView appCompatImageView = getBinding().PlaceComponentResult;
            GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(str3).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion(i).PlaceComponentResult(i).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            RecipientRibbonView recipientRibbonView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            if (sendMoneyScenarioModel.getNetworkUserEntityData$$ExternalSyntheticLambda7()) {
                recipientRibbonView.setTitle(KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyScenarioModel.isLayoutRequested));
                recipientRibbonView.setContent(KClassImpl$Data$declaredNonStaticMembers$2(sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda8));
            }
            Intrinsics.checkNotNullExpressionValue(recipientRibbonView, "");
            recipientRibbonView.setVisibility(sendMoneyScenarioModel.getNetworkUserEntityData$$ExternalSyntheticLambda7() ? 0 : 8);
            Intrinsics.checkNotNullExpressionValue(recipientRibbonView, "");
            String str5 = sendMoneyScenarioModel.KClassImpl$Data$declaredNonStaticMembers$2;
            switch (str5.hashCode()) {
                case -1820761141:
                    if (str5.equals("external")) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btnWithdrawCash));
                        break;
                    }
                    break;
                case -1442835217:
                    if (str5.equals(SendMoneyScenarioActionType.SALDO_DIGITAL)) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btnSaldoDigital));
                        break;
                    }
                    break;
                case -1192969641:
                    if (str5.equals("phoneNumber")) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btnSendToPhone));
                        break;
                    }
                    break;
                case -1005516787:
                    if (str5.equals("outlet")) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btnSendViaOutlet));
                        break;
                    }
                    break;
                case 3016252:
                    if (str5.equals("bank")) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btnSendToBank));
                        break;
                    }
                    break;
                case 3052376:
                    if (str5.equals("chat")) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btnSendToChat));
                        break;
                    }
                    break;
                case 98629247:
                    if (str5.equals("group")) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btn_send_money_group));
                        break;
                    }
                    break;
                case 106069776:
                    if (str5.equals("other")) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btnScanQrCode));
                        break;
                    }
                    break;
                case 1107020974:
                    if (str5.equals("globalTransfer")) {
                        this.itemView.setContentDescription(getContext().getString(R.string.btnGlobalTransfer));
                        break;
                    }
                    break;
            }
            AppCompatImageView appCompatImageView2 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
            appCompatImageView2.setVisibility(sendMoneyScenarioModel.getBuiltInFictitiousFunctionClassFactory() ? 0 : 8);
            TextView textView = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(sendMoneyScenarioModel.getNetworkUserEntityData$$ExternalSyntheticLambda1() ? 0 : 8);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public /* synthetic */ ItemHomeMenuSendmoneyBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemHomeMenuSendmoneyBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemHomeMenuSendmoneyBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SendMoneyMenuViewHolder(android.view.ViewGroup r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559126(0x7f0d02d6, float:1.8743587E38)
            r2.<init>(r1, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.landing.viewholder.menu.SendMoneyMenuViewHolder.<init>(android.view.ViewGroup):void");
    }

    private final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("_v2");
        return ResourceUtils.PlaceComponentResult(context, sb.toString(), p0);
    }
}
