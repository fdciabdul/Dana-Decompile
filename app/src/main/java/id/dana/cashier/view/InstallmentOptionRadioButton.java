package id.dana.cashier.view;

import android.content.res.TypedArray;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.databinding.ItemInstallmentOptionBinding;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B\u001b\b\u0016\u0012\u0006\u0010!\u001a\u00020 \u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b\"\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0007R*\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R*\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0012"}, d2 = {"Lid/dana/cashier/view/InstallmentOptionRadioButton;", "Lid/dana/cashier/view/BaseCustomRadioButton;", "Lid/dana/databinding/ItemInstallmentOptionBinding;", "inflateViewBinding", "()Lid/dana/databinding/ItemInstallmentOptionBinding;", "", "initAttributes", "()V", "populateViews", "selectedRadioButton", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(I)Z", "unselectedRadioButton", "", "value", "Ljava/lang/String;", "getAmountText", "()Ljava/lang/String;", "setAmountText", "(Ljava/lang/String;)V", "amountText", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "getPeriodText", "setPeriodText", "periodText", "scheduleImpl", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InstallmentOptionRadioButton extends BaseCustomRadioButton<ItemInstallmentOptionBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String amountText;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String periodText;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String getAuthRequestContext;

    @Override // id.dana.cashier.view.BaseCustomRadioButton
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.cashier.view.BaseCustomRadioButton
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public InstallmentOptionRadioButton(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            r2._$_findViewCache = r1
            int[] r1 = id.dana.R.styleable.TypeProjectionImpl
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2.<init>(r3, r1)
            r2.periodText = r0
            r2.amountText = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.InstallmentOptionRadioButton.<init>(android.content.Context):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public InstallmentOptionRadioButton(android.content.Context r3, android.util.AttributeSet r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            r2._$_findViewCache = r1
            int[] r1 = id.dana.R.styleable.TypeProjectionImpl
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2.<init>(r3, r4, r1)
            r2.periodText = r0
            r2.amountText = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.InstallmentOptionRadioButton.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // id.dana.cashier.view.BaseCustomRadioButton
    public final ItemInstallmentOptionBinding inflateViewBinding() {
        ItemInstallmentOptionBinding authRequestContext = ItemInstallmentOptionBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @JvmName(name = "getPeriodText")
    public final String getPeriodText() {
        return this.periodText;
    }

    @JvmName(name = "setPeriodText")
    public final void setPeriodText(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.periodText = str;
        getBinding().MyBillsEntityDataFactory.setText(this.periodText);
    }

    @JvmName(name = "getAmountText")
    public final String getAmountText() {
        return this.amountText;
    }

    @JvmName(name = "setAmountText")
    public final void setAmountText(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.amountText = str;
        getBinding().BuiltInFictitiousFunctionClassFactory.setText(this.amountText);
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(int p0) {
        TypedArray a2 = getA();
        Intrinsics.checkNotNull(a2);
        return a2.hasValue(p0);
    }

    public final void selectedRadioButton() {
        AppCompatTextView appCompatTextView = getBinding().MyBillsEntityDataFactory;
        if (appCompatTextView != null) {
            if (Build.VERSION.SDK_INT < 23) {
                appCompatTextView.setTextAppearance(appCompatTextView.getContext(), R.style.f49602132017405);
            } else {
                appCompatTextView.setTextAppearance(R.style.f49602132017405);
            }
        }
        AppCompatTextView appCompatTextView2 = getBinding().BuiltInFictitiousFunctionClassFactory;
        if (appCompatTextView2 != null) {
            if (Build.VERSION.SDK_INT < 23) {
                appCompatTextView2.setTextAppearance(appCompatTextView2.getContext(), R.style.f49602132017405);
            } else {
                appCompatTextView2.setTextAppearance(R.style.f49602132017405);
            }
        }
    }

    public final void unselectedRadioButton() {
        AppCompatTextView appCompatTextView = getBinding().MyBillsEntityDataFactory;
        if (appCompatTextView != null) {
            if (Build.VERSION.SDK_INT < 23) {
                appCompatTextView.setTextAppearance(appCompatTextView.getContext(), R.style.f49612132017406);
            } else {
                appCompatTextView.setTextAppearance(R.style.f49612132017406);
            }
        }
        AppCompatTextView appCompatTextView2 = getBinding().BuiltInFictitiousFunctionClassFactory;
        if (appCompatTextView2 != null) {
            if (Build.VERSION.SDK_INT < 23) {
                appCompatTextView2.setTextAppearance(appCompatTextView2.getContext(), R.style.f49612132017406);
            } else {
                appCompatTextView2.setTextAppearance(R.style.f49612132017406);
            }
        }
    }

    @Override // id.dana.cashier.view.BaseCustomRadioButton
    protected final void populateViews() {
        getBinding().MyBillsEntityDataFactory.setText(this.getAuthRequestContext);
        getBinding().BuiltInFictitiousFunctionClassFactory.setText(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.cashier.view.BaseCustomRadioButton
    protected final void initAttributes() {
        if (BuiltInFictitiousFunctionClassFactory(1)) {
            TypedArray a2 = getA();
            this.getAuthRequestContext = a2 != null ? a2.getString(1) : null;
        }
        if (BuiltInFictitiousFunctionClassFactory(0)) {
            TypedArray a3 = getA();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = a3 != null ? a3.getString(0) : null;
        }
    }
}
