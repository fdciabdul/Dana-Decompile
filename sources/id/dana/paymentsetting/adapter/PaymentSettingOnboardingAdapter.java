package id.dana.paymentsetting.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.paymentsetting.model.PaymentSettingOnboardingModel;
import id.dana.paymentsetting.viewholder.PaymentSettingViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\r\u0010\u000eR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/paymentsetting/adapter/PaymentSettingOnboardingAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/paymentsetting/viewholder/PaymentSettingViewHolder;", "Lid/dana/paymentsetting/model/PaymentSettingOnboardingModel;", "Lkotlin/Function1;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Landroid/content/Context;", "p0", "p1", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaymentSettingOnboardingAdapter extends BaseRecyclerViewAdapter<PaymentSettingViewHolder, PaymentSettingOnboardingModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<Integer, Unit> getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new PaymentSettingViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.paymentsetting.adapter.PaymentSettingOnboardingAdapter$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                Function1 function1;
                function1 = PaymentSettingOnboardingAdapter.this.getAuthRequestContext;
                function1.invoke(Integer.valueOf(PaymentSettingOnboardingAdapter.getAuthRequestContext(PaymentSettingOnboardingAdapter.this, i2)));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaymentSettingOnboardingAdapter(Context context, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = function1;
        String string = context.getString(R.string.payment_setting_bottomsheet_content_title_1);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = context.getString(R.string.payment_setting_bottomsheet_content_desc_1);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = context.getString(R.string.payment_setting_bottomsheet_content_title_2);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = context.getString(R.string.payment_setting_bottomsheet_content_desc_2);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = context.getString(R.string.payment_setting_bottomsheet_content_title_3);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = context.getString(R.string.payment_setting_bottomsheet_content_desc_3);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        setItems(CollectionsKt.listOf((Object[]) new PaymentSettingOnboardingModel[]{new PaymentSettingOnboardingModel(R.drawable.on_boarding_dana_protection, string, string2), new PaymentSettingOnboardingModel(R.drawable.on_boarding_world_class_security, string3, string4), new PaymentSettingOnboardingModel(R.drawable.on_boarding_hashtag, string5, string6)}));
    }

    public static final /* synthetic */ int getAuthRequestContext(PaymentSettingOnboardingAdapter paymentSettingOnboardingAdapter, int i) {
        return (i + 1) % paymentSettingOnboardingAdapter.getItems().size();
    }
}
