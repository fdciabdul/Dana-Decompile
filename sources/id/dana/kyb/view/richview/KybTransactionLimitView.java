package id.dana.kyb.view.richview;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.util.BalanceUtil;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ViewKybTransactionLimitBinding;
import id.dana.extension.view.ProgressBarExtKt;
import id.dana.kyb.constant.KybUpgradeTierUrgencyLevel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B/\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/kyb/view/richview/KybTransactionLimitView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewKybTransactionLimitBinding;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/databinding/ViewKybTransactionLimitBinding;", "usedAmount", "limitAmount", "urgencyLevel", "", ContainerUIProvider.KEY_SHOW, "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybTransactionLimitView extends BaseViewBindingRichView<ViewKybTransactionLimitBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybTransactionLimitView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybTransactionLimitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybTransactionLimitView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybTransactionLimitView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ KybTransactionLimitView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewKybTransactionLimitBinding inflateViewBinding() {
        ViewKybTransactionLimitBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewKybTransactionLimitBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void show(MoneyViewModel usedAmount, MoneyViewModel limitAmount, String urgencyLevel) {
        int i;
        Intrinsics.checkNotNullParameter(usedAmount, "");
        Intrinsics.checkNotNullParameter(limitAmount, "");
        Intrinsics.checkNotNullParameter(urgencyLevel, "");
        ViewKybTransactionLimitBinding binding = getBinding();
        if (usedAmount.PlaceComponentResult.length() > 0) {
            if (limitAmount.PlaceComponentResult.length() > 0) {
                ConstraintLayout constraintLayout = binding.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setVisibility(0);
                AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(Intrinsics.areEqual(urgencyLevel, KybUpgradeTierUrgencyLevel.HIGH) ? 0 : 8);
                TextView textView = getBinding().BuiltInFictitiousFunctionClassFactory;
                String authRequestContext = getAuthRequestContext(usedAmount);
                String authRequestContext2 = getAuthRequestContext(limitAmount);
                StringBuilder sb = new StringBuilder();
                sb.append(authRequestContext);
                sb.append(" / ");
                sb.append(authRequestContext2);
                String obj = sb.toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                String str = obj;
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new TextAppearanceSpan(getContext(), R.style.f49672132017413), 0, StringsKt.getLastIndex(authRequestContext) + 1, 33);
                spannableString.setSpan(new TextAppearanceSpan(getContext(), R.style.f49792132017433), StringsKt.indexOf$default((CharSequence) str, " / ", 0, false, 6, (Object) null), StringsKt.getLastIndex(str) + 1, 33);
                textView.setText(spannableString);
                ProgressBar progressBar = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                String cleanAll = NumberUtils.getCleanAll(usedAmount.PlaceComponentResult);
                if (cleanAll == null) {
                    cleanAll = "0";
                }
                Long longOrNull = StringsKt.toLongOrNull(cleanAll);
                double longValue = longOrNull != null ? longOrNull.longValue() : 0L;
                String cleanAll2 = NumberUtils.getCleanAll(limitAmount.PlaceComponentResult);
                Long longOrNull2 = StringsKt.toLongOrNull(cleanAll2 != null ? cleanAll2 : "0");
                double longValue2 = longOrNull2 != null ? longOrNull2.longValue() : 0L;
                Double.isNaN(longValue);
                Double.isNaN(longValue2);
                progressBar.setProgress(RangesKt.coerceIn((int) ((longValue / longValue2) * 100.0d), 0, 100));
                Pair pair = new Pair(Integer.valueOf(Intrinsics.areEqual(urgencyLevel, KybUpgradeTierUrgencyLevel.HIGH) ? R.color.f26712131100373 : R.color.f22912131099753), Integer.valueOf((int) R.color.f23952131099990));
                int intValue = ((Number) pair.component1()).intValue();
                int intValue2 = ((Number) pair.component2()).intValue();
                Intrinsics.checkNotNullExpressionValue(progressBar, "");
                ProgressBarExtKt.MyBillsEntityDataFactory(progressBar, intValue, intValue2);
                ProgressBar progressBar2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(progressBar2, "");
                if (ProgressBarExtKt.MyBillsEntityDataFactory(progressBar2)) {
                    i = R.string.progress_bar_empty;
                } else {
                    i = Intrinsics.areEqual(urgencyLevel, KybUpgradeTierUrgencyLevel.HIGH) ? R.string.progress_bar_red : R.string.progress_bar_blue;
                }
                String string = getContext().getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "");
                progressBar.setContentDescription(string);
                return;
            }
        }
        ConstraintLayout constraintLayout2 = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(8);
    }

    private static String getAuthRequestContext(MoneyViewModel p0) {
        BalanceUtil balanceUtil = BalanceUtil.INSTANCE;
        String authRequestContext = BalanceUtil.getAuthRequestContext(new CurrencyAmountModel(p0.PlaceComponentResult, p0.KClassImpl$Data$declaredNonStaticMembers$2, false, 4, null));
        return authRequestContext == null ? "" : authRequestContext;
    }
}
