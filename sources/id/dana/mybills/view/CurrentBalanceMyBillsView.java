package id.dana.mybills.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ViewMyBillsCurrentBalanceBinding;
import id.dana.mybills.utils.MyBillsMoneyUtils;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018B+\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/mybills/view/CurrentBalanceMyBillsView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewMyBillsCurrentBalanceBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewMyBillsCurrentBalanceBinding;", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "balance", "", "setBalance", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CurrentBalanceMyBillsView extends ViewBindingRichView<ViewMyBillsCurrentBalanceBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CurrentBalanceMyBillsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CurrentBalanceMyBillsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_my_bills_current_balance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewMyBillsCurrentBalanceBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewMyBillsCurrentBalanceBinding BuiltInFictitiousFunctionClassFactory = ViewMyBillsCurrentBalanceBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrentBalanceMyBillsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MoneyViewModel("0", null, null, 6, null);
    }

    public /* synthetic */ CurrentBalanceMyBillsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrentBalanceMyBillsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MoneyViewModel("0", null, null, 6, null);
    }

    public final void setBalance(MoneyViewModel balance) {
        String format;
        Intrinsics.checkNotNullParameter(balance, "");
        MyBillsMoneyUtils myBillsMoneyUtils = MyBillsMoneyUtils.INSTANCE;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsMoneyUtils.MyBillsEntityDataFactory(balance);
        TextView textView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        MoneyViewModel moneyViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
        sb.append(format != null ? format : "");
        textView.setText(sb.toString());
    }
}
