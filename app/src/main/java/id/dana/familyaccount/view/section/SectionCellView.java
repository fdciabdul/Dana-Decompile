package id.dana.familyaccount.view.section;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ViewFamilySectionCellBinding;
import id.dana.familyaccount.model.LimitInfoModel;
import id.dana.familyaccount.model.LimitInfoModelKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\tJ\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\t"}, d2 = {"Lid/dana/familyaccount/view/section/SectionCellView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewFamilySectionCellBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewFamilySectionCellBinding;", "", "available", "", "initHistorySection", "(Z)V", "Lid/dana/familyaccount/model/LimitInfoModel;", "limitInfoModel", "initMemberDashboardLimitSection", "(Lid/dana/familyaccount/model/LimitInfoModel;)V", "initMemberDetailLimitSection", "initOrganizerDashboardLimitSection", "", "contentDescription", "setContentDescription", "(Ljava/lang/String;)V", "p0", "MyBillsEntityDataFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionCellView extends BaseViewBindingRichView<ViewFamilySectionCellBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectionCellView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectionCellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectionCellView(Context context, AttributeSet attributeSet, int i) {
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
    public SectionCellView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SectionCellView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewFamilySectionCellBinding inflateViewBinding() {
        ViewFamilySectionCellBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewFamilySectionCellBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void initOrganizerDashboardLimitSection(boolean available) {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(getResources().getText(R.string.family_account_text_month_transaction_limit_title));
        getBinding().scheduleImpl.setText(getResources().getText(R.string.family_account_text_not_set));
        MyBillsEntityDataFactory(available);
        if (available) {
            getBinding().moveToNextValue.setText(getResources().getText(R.string.family_account_text_month_transaction_limit_desc));
        } else {
            getBinding().moveToNextValue.setText(getResources().getText(R.string.family_account_text_month_transaction_limit_desc_all_member_pending));
        }
    }

    public final void initMemberDashboardLimitSection(LimitInfoModel limitInfoModel) {
        String format;
        Intrinsics.checkNotNullParameter(limitInfoModel, "");
        AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
        TextView textView = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(8);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(getResources().getText(R.string.family_account_text_month_transaction_limit_title));
        getBinding().scheduleImpl.setText(getResources().getText(R.string.family_account_text_not_set));
        if (LimitInfoModelKt.BuiltInFictitiousFunctionClassFactory(limitInfoModel)) {
            getBinding().scheduleImpl.setText(getResources().getText(R.string.family_account_text_not_set));
            getBinding().scheduleImpl.setContentDescription(getContext().getString(R.string.txt_member_limit));
            return;
        }
        TextView textView2 = getBinding().scheduleImpl;
        MoneyViewModel moneyViewModel = limitInfoModel.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
        sb.append(format != null ? format : "");
        textView2.setText(sb.toString());
        getBinding().scheduleImpl.setContentDescription(getContext().getString(R.string.txt_member_limit));
    }

    public final void initHistorySection(boolean available) {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(getResources().getText(R.string.family_text_member_transaction_history));
        getBinding().scheduleImpl.setText(getResources().getText(R.string.family_account_text_not_set));
        TextView textView = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(8);
        MyBillsEntityDataFactory(available);
    }

    public final void initMemberDetailLimitSection(LimitInfoModel limitInfoModel) {
        String format;
        Intrinsics.checkNotNullParameter(limitInfoModel, "");
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(getResources().getText(R.string.family_member_transaction_limit_title));
        getBinding().moveToNextValue.setText(getResources().getText(R.string.family_account_text_month_transaction_limit_desc));
        getBinding().scheduleImpl.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22912131099753));
        if (LimitInfoModelKt.BuiltInFictitiousFunctionClassFactory(limitInfoModel)) {
            TextView textView = getBinding().moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            getBinding().scheduleImpl.setText(getResources().getText(R.string.family_account_text_set_limit));
            return;
        }
        TextView textView2 = getBinding().scheduleImpl;
        MoneyViewModel moneyViewModel = limitInfoModel.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
        if (format == null) {
            format = "";
        }
        sb.append(format);
        textView2.setText(sb.toString());
        TextView textView3 = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView3, "");
        textView3.setVisibility(8);
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        if (p0) {
            AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(0);
            TextView textView = getBinding().scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(8);
            return;
        }
        AppCompatImageView appCompatImageView2 = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        appCompatImageView2.setVisibility(8);
        TextView textView2 = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(0);
    }

    public final void setContentDescription(String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "");
        getBinding().MyBillsEntityDataFactory.setContentDescription(contentDescription);
    }
}
