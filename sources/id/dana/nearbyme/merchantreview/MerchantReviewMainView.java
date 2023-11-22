package id.dana.nearbyme.merchantreview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.nearbyme.merchantreview.MerchantReviewMainView;
import id.dana.utils.KeyboardHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB!\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewMainView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "removeFocus", "()V", "Landroid/view/View$OnClickListener;", "onClickListener", "setOnEditTextClickListener", "(Landroid/view/View$OnClickListener;)V", "Lid/dana/nearbyme/merchantreview/MerchantReviewMainView$TextListener;", "textListener", "setTextListener", "(Lid/dana/nearbyme/merchantreview/MerchantReviewMainView$TextListener;)V", "setup", "PlaceComponentResult", "Lid/dana/nearbyme/merchantreview/MerchantReviewMainView$TextListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "TextListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewMainView extends BaseRichView {
    public static final int MAX_LENGTH = 150;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private TextListener BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewMainView$TextListener;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface TextListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantReviewMainView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
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
        return R.layout.view_merchant_review_main;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantReviewMainView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantReviewMainView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setOnEditTextClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        AppCompatEditText appCompatEditText = (AppCompatEditText) _$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
        if (appCompatEditText != null) {
            appCompatEditText.setOnClickListener(onClickListener);
        }
    }

    public final void setTextListener(TextListener textListener) {
        Intrinsics.checkNotNullParameter(textListener, "");
        this.BuiltInFictitiousFunctionClassFactory = textListener;
        final AppCompatEditText appCompatEditText = (AppCompatEditText) _$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewMainView$setupListeners$lambda-2$$inlined$onTextAfterChanged$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                    MerchantReviewMainView.TextListener textListener2;
                    MerchantReviewMainView.TextListener textListener3 = null;
                    String obj = p0 != null ? p0.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    textListener2 = MerchantReviewMainView.this.BuiltInFictitiousFunctionClassFactory;
                    if (textListener2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        textListener3 = textListener2;
                    }
                    textListener3.KClassImpl$Data$declaredNonStaticMembers$2(obj);
                    MerchantReviewMainView.access$updateFocusedState(MerchantReviewMainView.this, obj.length());
                }
            });
            appCompatEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewMainView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    MerchantReviewMainView.$r8$lambda$ac3bPBQumU3bnFxV5EW_TZJ4N2U(MerchantReviewMainView.this, appCompatEditText, view, z);
                }
            });
        }
    }

    public final void removeFocus() {
        AppCompatEditText appCompatEditText = (AppCompatEditText) _$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
        if (appCompatEditText != null) {
            appCompatEditText.clearFocus();
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(appCompatEditText);
        }
    }

    public static /* synthetic */ void $r8$lambda$ac3bPBQumU3bnFxV5EW_TZJ4N2U(MerchantReviewMainView merchantReviewMainView, AppCompatEditText appCompatEditText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(merchantReviewMainView, "");
        Intrinsics.checkNotNullParameter(appCompatEditText, "");
        if (z) {
            if (appCompatEditText.length() < 150) {
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) merchantReviewMainView._$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
                if (appCompatEditText2 != null) {
                    appCompatEditText2.setBackgroundResource(R.drawable.bg_review_focused);
                    return;
                }
                return;
            }
            AppCompatEditText appCompatEditText3 = (AppCompatEditText) merchantReviewMainView._$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
            if (appCompatEditText3 != null) {
                appCompatEditText3.setBackgroundResource(R.drawable.bg_review_full);
                return;
            }
            return;
        }
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(appCompatEditText);
        if (appCompatEditText.length() < 150) {
            AppCompatEditText appCompatEditText4 = (AppCompatEditText) merchantReviewMainView._$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
            if (appCompatEditText4 != null) {
                appCompatEditText4.setBackgroundResource(R.drawable.bg_review_normal);
                return;
            }
            return;
        }
        AppCompatEditText appCompatEditText5 = (AppCompatEditText) merchantReviewMainView._$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
        if (appCompatEditText5 != null) {
            appCompatEditText5.setBackgroundResource(R.drawable.bg_review_full);
        }
    }

    public static final /* synthetic */ void access$updateFocusedState(MerchantReviewMainView merchantReviewMainView, int i) {
        if (i < 150) {
            AppCompatEditText appCompatEditText = (AppCompatEditText) merchantReviewMainView._$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
            if (appCompatEditText != null) {
                appCompatEditText.setBackgroundResource(R.drawable.bg_review_focused);
                return;
            }
            return;
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) merchantReviewMainView._$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3);
        if (appCompatEditText2 != null) {
            appCompatEditText2.setBackgroundResource(R.drawable.bg_review_full);
        }
    }
}
