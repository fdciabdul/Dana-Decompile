package id.dana.mybills.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014B+\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/mybills/view/TotalEstimatedBillsView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "total", "paid", GetInquirySubscriptionPaylaterWithDestination.TYPE_PAYLATER_UNPAID, "", "setBillsInformation", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V", "setExpanded", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TotalEstimatedBillsView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TotalEstimatedBillsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TotalEstimatedBillsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_estimated_bills;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TotalEstimatedBillsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        ((ConstraintLayout) _$_findCachedViewById(R.id.cl_total_bills)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.view.TotalEstimatedBillsView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TotalEstimatedBillsView.m2686$r8$lambda$l7_Fwush3_wELkYmDnTtD46HkQ(TotalEstimatedBillsView.this, view);
            }
        });
    }

    public /* synthetic */ TotalEstimatedBillsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TotalEstimatedBillsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        ((ConstraintLayout) _$_findCachedViewById(R.id.cl_total_bills)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.view.TotalEstimatedBillsView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TotalEstimatedBillsView.m2686$r8$lambda$l7_Fwush3_wELkYmDnTtD46HkQ(TotalEstimatedBillsView.this, view);
            }
        });
    }

    public final void setBillsInformation(MoneyViewModel total, MoneyViewModel paid, MoneyViewModel r9) {
        String format;
        String format2;
        String format3;
        Intrinsics.checkNotNullParameter(total, "");
        Intrinsics.checkNotNullParameter(paid, "");
        Intrinsics.checkNotNullParameter(r9, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_paid_bills);
        StringBuilder sb = new StringBuilder();
        sb.append(paid.KClassImpl$Data$declaredNonStaticMembers$2);
        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(paid.MyBillsEntityDataFactory());
        if (format == null) {
            format = "";
        }
        sb.append(format);
        textView.setText(sb.toString());
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_unpaid_bills);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(r9.KClassImpl$Data$declaredNonStaticMembers$2);
        format2 = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(r9.MyBillsEntityDataFactory());
        if (format2 == null) {
            format2 = "";
        }
        sb2.append(format2);
        textView2.setText(sb2.toString());
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_total_bills);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(total.KClassImpl$Data$declaredNonStaticMembers$2);
        format3 = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(total.MyBillsEntityDataFactory());
        sb3.append(format3 != null ? format3 : "");
        textView3.setText(sb3.toString());
    }

    public final void setExpanded() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.setMatchingBeaconTypeCode_res_0x7f0a0432);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        if (constraintLayout.getVisibility() == 0) {
            ((ConstraintLayout) _$_findCachedViewById(R.id.setMatchingBeaconTypeCode_res_0x7f0a0432)).setVisibility(8);
            InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.CustomPopMenuExtension), R.drawable.ic_arrow_down_v2_grey);
            return;
        }
        ((ConstraintLayout) _$_findCachedViewById(R.id.setMatchingBeaconTypeCode_res_0x7f0a0432)).setVisibility(0);
        InstrumentInjector.Resources_setImageResource((ImageView) _$_findCachedViewById(R.id.CustomPopMenuExtension), R.drawable.ic_arrow_up_v2_grey);
    }

    /* renamed from: $r8$lambda$l7_Fwush3_wELkYmDnTtD-46HkQ */
    public static /* synthetic */ void m2686$r8$lambda$l7_Fwush3_wELkYmDnTtD46HkQ(TotalEstimatedBillsView totalEstimatedBillsView, View view) {
        Intrinsics.checkNotNullParameter(totalEstimatedBillsView, "");
        totalEstimatedBillsView.setExpanded();
    }
}
