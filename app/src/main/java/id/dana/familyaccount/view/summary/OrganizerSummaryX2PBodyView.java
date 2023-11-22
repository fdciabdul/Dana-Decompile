package id.dana.familyaccount.view.summary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ViewOrganizerSummaryX2pBodyBinding;
import id.dana.familyaccount.model.PayeeUserInfoModel;
import id.dana.familyaccount.model.PayerUserInfoModel;
import id.dana.familyaccount.model.SummaryModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.MaskedTextUtil;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/familyaccount/view/summary/OrganizerSummaryX2PBodyView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewOrganizerSummaryX2pBodyBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewOrganizerSummaryX2pBodyBinding;", "Lid/dana/familyaccount/model/SummaryModel;", "summaryModel", "", "setSummaryView", "(Lid/dana/familyaccount/model/SummaryModel;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OrganizerSummaryX2PBodyView extends BaseViewBindingRichView<ViewOrganizerSummaryX2pBodyBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2PBodyView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2PBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2PBodyView(Context context, AttributeSet attributeSet, int i) {
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
    public OrganizerSummaryX2PBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ OrganizerSummaryX2PBodyView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewOrganizerSummaryX2pBodyBinding inflateViewBinding() {
        ViewOrganizerSummaryX2pBodyBinding authRequestContext = ViewOrganizerSummaryX2pBodyBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void setSummaryView(SummaryModel summaryModel) {
        String str;
        String format;
        Intrinsics.checkNotNullParameter(summaryModel, "");
        ViewOrganizerSummaryX2pBodyBinding binding = getBinding();
        TextView textView = binding.MyBillsEntityDataFactory;
        MoneyViewModel moneyViewModel = summaryModel.scheduleImpl;
        if (moneyViewModel != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
            format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
            sb.append(format != null ? format : "");
            str = sb.toString();
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = binding.getErrorConfigVersion;
        PayeeUserInfoModel payeeUserInfoModel = summaryModel.moveToNextValue;
        textView2.setText(MaskedTextUtil.PlaceComponentResult(payeeUserInfoModel != null ? payeeUserInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0 : null));
        TextView textView3 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        PayerUserInfoModel payerUserInfoModel = summaryModel.GetContactSyncConfig;
        textView3.setText(payerUserInfoModel != null ? payerUserInfoModel.BuiltInFictitiousFunctionClassFactory : null);
        binding.KClassImpl$Data$declaredNonStaticMembers$2.setText(summaryModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
    }
}
