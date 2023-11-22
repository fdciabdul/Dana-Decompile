package id.dana.cardbinding.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.utils.NoUnderlineClickableSpan;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0002'(B'\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#B+\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00188\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/cardbinding/view/DisclaimerView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/cardbinding/view/DisclaimerView$OnCheckboxListener;", "onCheckboxListener", "", "setCheckboxListener", "(Lid/dana/cardbinding/view/DisclaimerView$OnCheckboxListener;)V", "", "cardType", "", "isGpn", "setDataBankCard", "(Ljava/lang/String;Z)V", "getAuthRequestContext", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "Lid/dana/cardbinding/view/DisclaimerView$OnCheckboxListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getOnCheckedChangeListener", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCheckedChangeListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnCheckboxListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DisclaimerView extends BaseRichView {
    public static final String BCA_ONE_KLIK = "BCA_ONE_KLIK";
    public static final String DIRECT_DEBIT = "DIRECT_DEBIT";

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnCheckboxListener KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/view/DisclaimerView$OnCheckboxListener;", "", "", "p0", "", "PlaceComponentResult", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface OnCheckboxListener {
        void PlaceComponentResult(boolean p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisclaimerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisclaimerView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_disclaimer_binding_card;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisclaimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.cardbinding.view.DisclaimerView$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DisclaimerView.$r8$lambda$TKKzhjEZS6Zlwgop8a2dyUDoHtM(DisclaimerView.this, compoundButton, z);
            }
        };
        this.onCheckedChangeListener = onCheckedChangeListener;
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.cbAgreementDC)).setOnCheckedChangeListener(onCheckedChangeListener);
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.WrappedDrawableState_res_0x7f0a02ad)).setOnCheckedChangeListener(onCheckedChangeListener);
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.cbAgreementOneKlik)).setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public /* synthetic */ DisclaimerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisclaimerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.cardbinding.view.DisclaimerView$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DisclaimerView.$r8$lambda$TKKzhjEZS6Zlwgop8a2dyUDoHtM(DisclaimerView.this, compoundButton, z);
            }
        };
        this.onCheckedChangeListener = onCheckedChangeListener;
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.cbAgreementDC)).setOnCheckedChangeListener(onCheckedChangeListener);
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.WrappedDrawableState_res_0x7f0a02ad)).setOnCheckedChangeListener(onCheckedChangeListener);
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.cbAgreementOneKlik)).setOnCheckedChangeListener(onCheckedChangeListener);
    }

    @JvmName(name = "getOnCheckedChangeListener")
    public final CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    public static /* synthetic */ void setDataBankCard$default(DisclaimerView disclaimerView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        disclaimerView.setDataBankCard(str, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r13.equals("CREDIT_CARD") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r13.equals("DEBIT_CARD") != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r13 = (androidx.constraintlayout.widget.ConstraintLayout) _$_findCachedViewById(id.dana.R.id.getGnBenefitEntityDanaProtection_res_0x7f0a036e);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "");
        r13.setVisibility(8);
        r13 = (androidx.constraintlayout.widget.ConstraintLayout) _$_findCachedViewById(id.dana.R.id.res_0x7f0a036d_submitreceiptresultmodel_creator);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "");
        r13.setVisibility(0);
        r13 = (androidx.constraintlayout.widget.ConstraintLayout) _$_findCachedViewById(id.dana.R.id.res_0x7f0a036f_standardrowsortedtable_1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "");
        r13.setVisibility(8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setDataBankCard(java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.view.DisclaimerView.setDataBankCard(java.lang.String, boolean):void");
    }

    public final void setCheckboxListener(OnCheckboxListener onCheckboxListener) {
        Intrinsics.checkNotNullParameter(onCheckboxListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onCheckboxListener;
    }

    private final void getAuthRequestContext() {
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.cbAgreementDC)).setChecked(false);
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.WrappedDrawableState_res_0x7f0a02ad)).setChecked(false);
        ((AppCompatCheckBox) _$_findCachedViewById(R.id.cbAgreementOneKlik)).setChecked(false);
    }

    public static /* synthetic */ void $r8$lambda$TKKzhjEZS6Zlwgop8a2dyUDoHtM(DisclaimerView disclaimerView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(disclaimerView, "");
        OnCheckboxListener onCheckboxListener = disclaimerView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onCheckboxListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onCheckboxListener = null;
        }
        onCheckboxListener.PlaceComponentResult(z);
    }

    static /* synthetic */ SpannableString getTnCSpannableString$default(DisclaimerView disclaimerView, String str, String str2, int i, NoUnderlineClickableSpan noUnderlineClickableSpan, int i2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            i2 = R.color.f22912131099753;
        }
        SpannableString spannableString = new SpannableString(str);
        if (noUnderlineClickableSpan != null) {
            spannableString.setSpan(noUnderlineClickableSpan, i, str2.length() + i, 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(disclaimerView.getContext(), i2)), i, str2.length() + i, 33);
        spannableString.setSpan(new StyleSpan(0), i, str2.length() + i, 33);
        return spannableString;
    }
}
