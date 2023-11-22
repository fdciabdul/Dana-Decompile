package id.dana.familyaccount.view.summary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ViewOrganizerSummaryX2bBodyBinding;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/familyaccount/view/summary/OrganizerSummaryX2BBodyView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewOrganizerSummaryX2bBodyBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewOrganizerSummaryX2bBodyBinding;", "", "p0", "", "getAuthRequestContext", "(I)Z", "Lid/dana/familyaccount/model/SummaryModel;", "summaryModel", "totalBankFreeTransfer", "", "setSummaryView", "(Lid/dana/familyaccount/model/SummaryModel;I)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OrganizerSummaryX2BBodyView extends BaseViewBindingRichView<ViewOrganizerSummaryX2bBodyBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2BBodyView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2BBodyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrganizerSummaryX2BBodyView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    private static boolean getAuthRequestContext(int p0) {
        return p0 > 0;
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
    public OrganizerSummaryX2BBodyView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ OrganizerSummaryX2BBodyView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewOrganizerSummaryX2bBodyBinding inflateViewBinding() {
        ViewOrganizerSummaryX2bBodyBinding PlaceComponentResult = ViewOrganizerSummaryX2bBodyBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void setSummaryView(SummaryModel summaryModel, int totalBankFreeTransfer) {
        String str;
        String str2;
        String str3;
        String format;
        String format2;
        String format3;
        Intrinsics.checkNotNullParameter(summaryModel, "");
        ViewOrganizerSummaryX2bBodyBinding binding = getBinding();
        TextView textView = binding.getAuthRequestContext;
        MoneyViewModel moneyViewModel = summaryModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str4 = null;
        if (moneyViewModel != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
            format3 = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
            if (format3 == null) {
                format3 = "";
            }
            sb.append(format3);
            str = sb.toString();
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = binding.lookAheadTest;
        PayeeUserInfoModel payeeUserInfoModel = summaryModel.moveToNextValue;
        if (payeeUserInfoModel != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(payeeUserInfoModel.getErrorConfigVersion);
            sb2.append(" \n ");
            sb2.append(payeeUserInfoModel.getAuthRequestContext);
            sb2.append(" | ");
            sb2.append(payeeUserInfoModel.moveToNextValue);
            str2 = sb2.toString();
        } else {
            str2 = null;
        }
        textView2.setText(MaskedTextUtil.PlaceComponentResult(str2));
        TextView textView3 = binding.getErrorConfigVersion;
        PayerUserInfoModel payerUserInfoModel = summaryModel.GetContactSyncConfig;
        textView3.setText(payerUserInfoModel != null ? payerUserInfoModel.BuiltInFictitiousFunctionClassFactory : null);
        binding.scheduleImpl.setText(summaryModel.NetworkUserEntityData$$ExternalSyntheticLambda2);
        TextView textView4 = binding.initRecordTimeStamp;
        if (getAuthRequestContext(totalBankFreeTransfer)) {
            str3 = getResources().getString(R.string.family_account_text_organizer_summary_free_transfer, Integer.valueOf(totalBankFreeTransfer));
            Intrinsics.checkNotNullExpressionValue(str3, "");
        } else {
            MoneyViewModel moneyViewModel2 = summaryModel.BuiltInFictitiousFunctionClassFactory;
            if (moneyViewModel2 != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(moneyViewModel2.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel2.MyBillsEntityDataFactory());
                if (format == null) {
                    format = "";
                }
                sb3.append(format);
                str3 = sb3.toString();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
        }
        textView4.setText(str3);
        TextView textView5 = binding.DatabaseTableConfigUtil;
        MoneyViewModel moneyViewModel3 = summaryModel.scheduleImpl;
        if (moneyViewModel3 != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(moneyViewModel3.KClassImpl$Data$declaredNonStaticMembers$2);
            format2 = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel3.MyBillsEntityDataFactory());
            if (format2 == null) {
                format2 = "";
            }
            sb4.append(format2);
            str4 = sb4.toString();
        }
        textView5.setText(str4);
        TextView textView6 = binding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(textView6, "");
        textView6.setVisibility(getAuthRequestContext(totalBankFreeTransfer) ? 0 : 8);
    }
}
