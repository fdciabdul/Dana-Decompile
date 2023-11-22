package id.dana.sendmoney.external;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.data.constant.DanaUrl;
import id.dana.sendmoney.model.ExternalWithdrawChannelModel;
import id.dana.utils.ImageUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyExternalOutletViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "", "getAuthRequestContext", "()V", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyExternalOutletViewHolder extends BaseRecyclerViewHolder<ExternalWithdrawChannelModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ExternalWithdrawChannelModel externalWithdrawChannelModel) {
        Boolean bool;
        String str;
        ExternalWithdrawChannelModel externalWithdrawChannelModel2 = externalWithdrawChannelModel;
        if (externalWithdrawChannelModel2 == null || externalWithdrawChannelModel2.BuiltInFictitiousFunctionClassFactory == null || externalWithdrawChannelModel2.MyBillsEntityDataFactory == null || (bool = externalWithdrawChannelModel2.MyBillsEntityDataFactory) == null) {
            return;
        }
        boolean booleanValue = bool.booleanValue();
        boolean booleanValue2 = externalWithdrawChannelModel2.BuiltInFictitiousFunctionClassFactory.booleanValue();
        String str2 = externalWithdrawChannelModel2.lookAheadTest;
        if (!Intrinsics.areEqual(str2, "WITHDRAW_ATM")) {
            if (Intrinsics.areEqual(str2, "WITHDRAW_OTC")) {
                if (booleanValue2 && !externalWithdrawChannelModel2.PlaceComponentResult() && !booleanValue) {
                    getAuthRequestContext();
                } else {
                    String str3 = externalWithdrawChannelModel2.getAuthRequestContext;
                    if (str3 == null || str3.length() == 0) {
                        BuiltInFictitiousFunctionClassFactory(externalWithdrawChannelModel2);
                    } else {
                        getAuthRequestContext();
                    }
                }
                String valueOf = String.valueOf(externalWithdrawChannelModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                View view = this.itemView;
                String string = view.getContext().getString(R.string.lblWithdrawOtc);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String format = String.format(string, Arrays.copyOf(new Object[]{valueOf}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                view.setContentDescription(format);
            }
        } else {
            if (!externalWithdrawChannelModel2.PlaceComponentResult() && !booleanValue) {
                getAuthRequestContext();
            } else {
                BuiltInFictitiousFunctionClassFactory(externalWithdrawChannelModel2);
            }
            String valueOf2 = String.valueOf(externalWithdrawChannelModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
            View view2 = this.itemView;
            String string2 = view2.getContext().getString(R.string.lblWithdrawAtm);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{valueOf2}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "");
            view2.setContentDescription(format2);
        }
        TextView textView = (TextView) this.itemView.findViewById(R.id.onChipDrawableSizeChange);
        if (textView != null) {
            textView.setText(externalWithdrawChannelModel2.moveToNextValue);
        }
        GlideRequests authRequestContext = GlideApp.getAuthRequestContext(getContext());
        String str4 = externalWithdrawChannelModel2.lookAheadTest;
        if (!Intrinsics.areEqual(str4, "WITHDRAW_ATM")) {
            if (Intrinsics.areEqual(str4, "WITHDRAW_OTC")) {
                String lowerCase = String.valueOf(externalWithdrawChannelModel2.NetworkUserEntityData$$ExternalSyntheticLambda0).toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                str = String.format(DanaUrl.CHANNEL_OUTLET_URL, Arrays.copyOf(new Object[]{lowerCase}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "");
            } else {
                str = null;
            }
        } else {
            String lowerCase2 = String.valueOf(externalWithdrawChannelModel2.NetworkUserEntityData$$ExternalSyntheticLambda0).toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
            str = String.format(DanaUrl.BANK_ICON_URL, Arrays.copyOf(new Object[]{lowerCase2}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        authRequestContext.PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.ic_bank_placeholder).PlaceComponentResult((int) R.drawable.ic_bank_placeholder).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.civ_channel_logo)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendMoneyExternalOutletViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_item_atm_outlet, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    private final void getAuthRequestContext() {
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.res_0x7f0a041b_fontscontractcompat_fontrequestcallback);
        if (constraintLayout != null) {
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setClickable(false);
            constraintLayout.setFocusable(false);
            if (Build.VERSION.SDK_INT >= 23) {
                constraintLayout.setForeground(null);
            }
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_maintenance_flag);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.civ_channel_logo);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        ImageUtil.BuiltInFictitiousFunctionClassFactory(appCompatImageView);
    }

    private final void BuiltInFictitiousFunctionClassFactory(ExternalWithdrawChannelModel p0) {
        TextView textView = (TextView) this.itemView.findViewById(R.id.onChipDrawableSizeChange);
        if (textView != null) {
            textView.setText(p0.moveToNextValue);
        }
        View view = this.itemView;
        String str = p0.getErrorConfigVersion;
        if (!(str == null || str.length() == 0)) {
            TextView textView2 = (TextView) view.findViewById(R.id.res_0x7f0a1401_nearbypromoadapter_viewholder_externalsyntheticlambda0);
            if (textView2 != null) {
                textView2.setText(p0.getErrorConfigVersion);
            }
            TextView textView3 = (TextView) view.findViewById(R.id.res_0x7f0a1401_nearbypromoadapter_viewholder_externalsyntheticlambda0);
            if (textView3 != null) {
                Intrinsics.checkNotNullExpressionValue(textView3, "");
                textView3.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView4 = (TextView) view.findViewById(R.id.res_0x7f0a1401_nearbypromoadapter_viewholder_externalsyntheticlambda0);
        if (textView4 != null) {
            Intrinsics.checkNotNullExpressionValue(textView4, "");
            textView4.setVisibility(8);
        }
    }
}
