package id.dana.paymentsetting.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.paymentsetting.model.PaymentSettingOnboardingModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/paymentsetting/viewholder/PaymentSettingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/paymentsetting/model/PaymentSettingOnboardingModel;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentSettingViewHolder extends BaseRecyclerViewHolder<PaymentSettingOnboardingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PaymentSettingOnboardingModel paymentSettingOnboardingModel) {
        PaymentSettingOnboardingModel paymentSettingOnboardingModel2 = paymentSettingOnboardingModel;
        if (paymentSettingOnboardingModel2 != null) {
            View view = this.itemView;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.BottomSheetType);
            if (appCompatImageView != null) {
                int i = paymentSettingOnboardingModel2.getAuthRequestContext;
                if (appCompatImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                } else {
                    appCompatImageView.setImageResource(i);
                }
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.setDrawValueAboveBar);
            if (appCompatTextView != null) {
                appCompatTextView.setText(paymentSettingOnboardingModel2.PlaceComponentResult);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.SendRiskEventEntityRepository$$ExternalSyntheticLambda1);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(paymentSettingOnboardingModel2.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentSettingViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1) {
        super(viewGroup.getContext(), R.layout.item_payment_setting_onboarding, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.BottomSheetType);
        if (appCompatImageView != null) {
            appCompatImageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.paymentsetting.viewholder.PaymentSettingViewHolder$special$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    p0.removeOnLayoutChangeListener(this);
                    Function1.this.invoke(Integer.valueOf(this.getAbsoluteAdapterPosition()));
                }
            });
        }
    }
}
