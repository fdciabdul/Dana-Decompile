package id.dana.core.ui.richview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.R;
import id.dana.core.ui.databinding.ViewInputOtpBinding;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.richview.OtpInputView;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000234B/\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0018\u0012\b\b\u0002\u00100\u001a\u00020\u0018¢\u0006\u0004\b1\u00102J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\r\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\r\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u0015\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0005R\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010&\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010*"}, d2 = {"Lid/dana/core/ui/richview/OtpInputView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/core/ui/databinding/ViewInputOtpBinding;", "", "clearFocusAndHideKeyboard", "()V", "clearFocusInput", "", "enable", "enableCodeEditTexts", "(Z)V", "inflateViewBinding", "()Lid/dana/core/ui/databinding/ViewInputOtpBinding;", "Lid/dana/core/ui/richview/OtpInputView$FocusIndex;", "focusIndex", "requestFocusAndShowKeyboard", "(Lid/dana/core/ui/richview/OtpInputView$FocusIndex;)V", "setDisableView", "setError", "setNormalBorder", "Lid/dana/core/ui/richview/OtpInputView$OtpListener;", "onOtpComplete", "setOtpListener", "(Lid/dana/core/ui/richview/OtpInputView$OtpListener;)V", "", SecurityConstants.KEY_MAXLENGTH, "setOtpView", "(I)V", "setSuccessBorder", "setup", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "", "Landroid/widget/EditText;", "MyBillsEntityDataFactory", "Ljava/util/List;", "getAuthRequestContext", "Lid/dana/core/ui/richview/OtpInputView$OtpListener;", "BuiltInFictitiousFunctionClassFactory", "I", "PlaceComponentResult", "", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "FocusIndex", "OtpListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OtpInputView extends BaseViewBindingRichView<ViewInputOtpBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int PlaceComponentResult;
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private List<EditText> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    private OtpListener getAuthRequestContext;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/core/ui/richview/OtpInputView$FocusIndex;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "LAST"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum FocusIndex {
        FIRST,
        LAST
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/core/ui/richview/OtpInputView$OtpListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OtpListener {
        void BuiltInFictitiousFunctionClassFactory(String p0);

        void getAuthRequestContext(String p0);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[FocusIndex.values().length];
            iArr[FocusIndex.FIRST.ordinal()] = 1;
            iArr[FocusIndex.LAST.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OtpInputView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OtpInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OtpInputView(Context context, AttributeSet attributeSet, int i) {
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

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtpInputView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.PlaceComponentResult = -1;
    }

    public /* synthetic */ OtpInputView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewInputOtpBinding inflateViewBinding() {
        ViewInputOtpBinding BuiltInFictitiousFunctionClassFactory = ViewInputOtpBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static final boolean getAuthRequestContext(int i, OtpInputView otpInputView, int i2, KeyEvent keyEvent) {
        List<EditText> list;
        Intrinsics.checkNotNullParameter(otpInputView, "");
        if (i2 == 67 && keyEvent.getAction() == 0 && i != 0 && (list = otpInputView.MyBillsEntityDataFactory) != null) {
            int i3 = i - 1;
            list.get(i3).requestFocus();
            list.get(i3).setSelection(list.get(i3).length());
            Editable text = list.get(i).getText();
            Intrinsics.checkNotNullExpressionValue(text, "");
            if (text.length() == 0) {
                list.get(i3).setText("");
            }
        }
        return false;
    }

    public final void setOtpView(int r13) {
        if (r13 > 0) {
            getBinding().BuiltInFictitiousFunctionClassFactory.removeAllViews();
            this.MyBillsEntityDataFactory = new ArrayList();
            this.PlaceComponentResult = r13;
            for (final int i = 0; i < r13; i++) {
                EditText editText = new EditText(getContext());
                editText.setLayoutParams(new LinearLayout.LayoutParams(ViewExtKt.getAuthRequestContext(52.0f), ViewExtKt.getAuthRequestContext(52.0f)));
                editText.setBackground(ContextCompat.PlaceComponentResult(editText.getContext(), R.drawable.bg_otp_rounded_grey_20));
                editText.setId(i);
                editText.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(2)});
                ViewExtKt.PlaceComponentResult(editText, Integer.valueOf(ViewExtKt.getAuthRequestContext(3.0f)), null, Integer.valueOf(ViewExtKt.getAuthRequestContext(3.0f)), 10);
                editText.setGravity(17);
                editText.setInputType(2);
                if (Build.VERSION.SDK_INT >= 23) {
                    editText.setTextAppearance(R.style.getAuthRequestContext);
                } else {
                    editText.setTextAppearance(editText.getContext(), R.style.getAuthRequestContext);
                }
                editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.core.ui.richview.OtpInputView$setListener$1
                    @Override // android.text.TextWatcher
                    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                        OtpInputView.this.BuiltInFictitiousFunctionClassFactory = String.valueOf(p0);
                    }

                    @Override // android.text.TextWatcher
                    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                        OtpInputView.OtpListener otpListener;
                        otpListener = OtpInputView.this.getAuthRequestContext;
                        if (otpListener != null) {
                            otpListener.getAuthRequestContext(String.valueOf(p0));
                        }
                    }

                    @Override // android.text.TextWatcher
                    public final void afterTextChanged(Editable p0) {
                        boolean z;
                        OtpInputView.access$afterTextChanged(OtpInputView.this, p0);
                        z = OtpInputView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (z) {
                            OtpInputView.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                        }
                    }
                });
                editText.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.core.ui.richview.OtpInputView$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnKeyListener
                    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                        boolean authRequestContext;
                        authRequestContext = OtpInputView.getAuthRequestContext(i, this, i2, keyEvent);
                        return authRequestContext;
                    }
                });
                EditText editText2 = editText;
                int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.KClassImpl$Data$declaredNonStaticMembers$2);
                if (Build.VERSION.SDK_INT >= 29) {
                    Drawable textCursorDrawable = editText2.getTextCursorDrawable();
                    if (textCursorDrawable != null) {
                        textCursorDrawable.setTint(BuiltInFictitiousFunctionClassFactory);
                    }
                    editText2.setTextCursorDrawable(textCursorDrawable);
                } else {
                    try {
                        Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                        Intrinsics.checkNotNullExpressionValue(declaredField, "");
                        declaredField.setAccessible(true);
                        int i2 = declaredField.getInt(editText2);
                        Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                        Intrinsics.checkNotNullExpressionValue(declaredField2, "");
                        declaredField2.setAccessible(true);
                        Object obj = declaredField2.get(editText2);
                        Intrinsics.checkNotNullExpressionValue(obj, "");
                        Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
                        Intrinsics.checkNotNullExpressionValue(declaredField3, "");
                        declaredField3.setAccessible(true);
                        Drawable[] drawableArr = {ContextCompat.PlaceComponentResult(getContext(), i2), ContextCompat.PlaceComponentResult(getContext(), i2)};
                        Drawable drawable = drawableArr[0];
                        if (drawable != null) {
                            drawable.setColorFilter(BlendModeColorFilterCompat.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, BlendModeCompat.SRC_IN));
                        }
                        Drawable drawable2 = drawableArr[1];
                        if (drawable2 != null) {
                            drawable2.setColorFilter(BlendModeColorFilterCompat.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, BlendModeCompat.SRC_IN));
                        }
                        declaredField3.set(obj, drawableArr);
                    } catch (Throwable th) {
                        DanaLog.MyBillsEntityDataFactory(Reflection.getOrCreateKotlinClass(OtpInputView.class).getSimpleName(), th.getMessage());
                        DanaLog.MyBillsEntityDataFactory(Reflection.getOrCreateKotlinClass(OtpInputView.class).getSimpleName(), ExceptionsKt.stackTraceToString(th));
                        DanaLog.MyBillsEntityDataFactory(Reflection.getOrCreateKotlinClass(OtpInputView.class).getSimpleName(), "can't set text cursor color");
                    }
                }
                List<EditText> list = this.MyBillsEntityDataFactory;
                if (list != null) {
                    list.add(i, editText);
                }
                List<EditText> list2 = this.MyBillsEntityDataFactory;
                if (list2 != null) {
                    getBinding().BuiltInFictitiousFunctionClassFactory.addView(list2.get(i));
                }
            }
        }
    }

    public final void enableCodeEditTexts(boolean enable) {
        List<EditText> list = this.MyBillsEntityDataFactory;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).setEnabled(enable);
            }
        }
    }

    public static /* synthetic */ void requestFocusAndShowKeyboard$default(OtpInputView otpInputView, FocusIndex focusIndex, int i, Object obj) {
        if ((i & 1) != 0) {
            focusIndex = FocusIndex.FIRST;
        }
        otpInputView.requestFocusAndShowKeyboard(focusIndex);
    }

    public final void requestFocusAndShowKeyboard(final FocusIndex focusIndex) {
        Intrinsics.checkNotNullParameter(focusIndex, "");
        getBinding().BuiltInFictitiousFunctionClassFactory.post(new Runnable() { // from class: id.dana.core.ui.richview.OtpInputView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                OtpInputView.m613$r8$lambda$HZxuDeB0zw39QZULewCBEXDVLk(OtpInputView.FocusIndex.this, this);
            }
        });
    }

    public final void clearFocusAndHideKeyboard() {
        getBinding().BuiltInFictitiousFunctionClassFactory.post(new Runnable() { // from class: id.dana.core.ui.richview.OtpInputView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OtpInputView.$r8$lambda$VCFwLIuVBWYBfyLY8pWYCTixfzs(OtpInputView.this);
            }
        });
    }

    public final void clearFocusInput() {
        Object obj;
        List<EditText> list = this.MyBillsEntityDataFactory;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((EditText) obj).hasFocus()) {
                    break;
                }
            }
            EditText editText = (EditText) obj;
            if (editText != null) {
                editText.clearFocus();
            }
        }
    }

    public final void setSuccessBorder() {
        List<EditText> list = this.MyBillsEntityDataFactory;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((EditText) it.next()).setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.res_0x7f080520_kclassimpl_data_declarednonstaticmembers_2));
            }
        }
    }

    public final void setNormalBorder() {
        List<EditText> list = this.MyBillsEntityDataFactory;
        if (list != null) {
            for (EditText editText : list) {
                editText.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.bg_otp_rounded_grey_20));
                editText.setEnabled(true);
            }
        }
    }

    public final void setDisableView() {
        List<EditText> list = this.MyBillsEntityDataFactory;
        if (list != null) {
            for (EditText editText : list) {
                editText.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.bg_grey_40_border_grey_20));
                editText.setEnabled(false);
                editText.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.getAuthRequestContext_res_0x7f0600d0));
            }
        }
    }

    public final void setOtpListener(OtpListener onOtpComplete) {
        Intrinsics.checkNotNullParameter(onOtpComplete, "");
        this.getAuthRequestContext = onOtpComplete;
    }

    /* renamed from: $r8$lambda$HZxuDeB0zw39QZULewCBEXD-VLk */
    public static /* synthetic */ void m613$r8$lambda$HZxuDeB0zw39QZULewCBEXDVLk(FocusIndex focusIndex, OtpInputView otpInputView) {
        EditText editText;
        Intrinsics.checkNotNullParameter(focusIndex, "");
        Intrinsics.checkNotNullParameter(otpInputView, "");
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[focusIndex.ordinal()];
        if (i == 1) {
            List<EditText> list = otpInputView.MyBillsEntityDataFactory;
            if (list != null) {
                editText = (EditText) CollectionsKt.first((List) list);
            }
            editText = null;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            List<EditText> list2 = otpInputView.MyBillsEntityDataFactory;
            if (list2 != null) {
                editText = (EditText) CollectionsKt.last((List) list2);
            }
            editText = null;
        }
        if (editText != null) {
            editText.requestFocus();
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(editText);
        }
    }

    public static /* synthetic */ void $r8$lambda$VCFwLIuVBWYBfyLY8pWYCTixfzs(OtpInputView otpInputView) {
        Object obj;
        Intrinsics.checkNotNullParameter(otpInputView, "");
        List<EditText> list = otpInputView.MyBillsEntityDataFactory;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((EditText) obj).hasFocus()) {
                    break;
                }
            }
            EditText editText = (EditText) obj;
            if (editText != null) {
                editText.clearFocus();
                KeyboardHelper.getAuthRequestContext(editText);
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$dUDTVohsWGNMhghVORzHvJqmW8g(EditText editText, OtpInputView otpInputView) {
        Intrinsics.checkNotNullParameter(editText, "");
        Intrinsics.checkNotNullParameter(otpInputView, "");
        editText.setBackground(ContextCompat.PlaceComponentResult(otpInputView.getContext(), R.drawable.bg_otp_rounded_grey_20));
    }

    public static final /* synthetic */ void access$afterTextChanged(final OtpInputView otpInputView, Editable editable) {
        OtpListener otpListener;
        List<EditText> list = otpInputView.MyBillsEntityDataFactory;
        Editable editable2 = editable;
        int i = 0;
        if (editable2 == null || editable2.length() == 0) {
            return;
        }
        List<EditText> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final EditText editText = (EditText) obj;
            if (otpInputView.KClassImpl$Data$declaredNonStaticMembers$2) {
                otpInputView.post(new Runnable() { // from class: id.dana.core.ui.richview.OtpInputView$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        OtpInputView.$r8$lambda$dUDTVohsWGNMhghVORzHvJqmW8g(editText, otpInputView);
                    }
                });
            }
            if ((!StringsKt.isBlank(editable2)) != false && editable.hashCode() == editText.getEditableText().hashCode()) {
                String str = "";
                if (editable.length() >= 2) {
                    String substring = editable.toString().substring(editable.length() - 1, editable.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    if (!Intrinsics.areEqual(substring, otpInputView.BuiltInFictitiousFunctionClassFactory)) {
                        editText.setText(substring);
                    } else {
                        String substring2 = editable.toString().substring(i, editable.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "");
                        editText.setText(substring2);
                    }
                } else if (i2 != list.size() - 1) {
                    list.get(i3).requestFocus();
                    list.get(i3).setSelection(list.get(i3).length());
                    return;
                } else {
                    List<EditText> list3 = otpInputView.MyBillsEntityDataFactory;
                    if (list3 != null) {
                        int size = list3.size();
                        String str2 = "";
                        for (int i4 = 0; i4 < size; i4++) {
                            String obj2 = list3.get(i4).getText().toString();
                            int length = obj2.length() - 1;
                            int i5 = 0;
                            boolean z = false;
                            while (i5 <= length) {
                                boolean z2 = Intrinsics.compare((int) obj2.charAt(!z ? i5 : length), 32) <= 0;
                                if (z) {
                                    if (z2) {
                                        length--;
                                    }
                                } else if (z2) {
                                    i5++;
                                } else {
                                    z = true;
                                }
                            }
                            String obj3 = obj2.subSequence(i5, length + 1).toString();
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append(obj3);
                            str2 = sb.toString();
                        }
                        String str3 = str2;
                        int length2 = str3.length() - 1;
                        int i6 = 0;
                        boolean z3 = false;
                        while (i6 <= length2) {
                            boolean z4 = Intrinsics.compare((int) str3.charAt(!z3 ? i6 : length2), 32) <= 0;
                            if (z3) {
                                if (!z4) {
                                    break;
                                }
                                length2--;
                            } else if (z4) {
                                i6++;
                            } else {
                                z3 = true;
                            }
                        }
                        if (str3.subSequence(i6, length2 + 1).toString().length() == otpInputView.PlaceComponentResult) {
                            str = str2;
                        }
                    }
                    if ((str.length() > 0) && str.length() == otpInputView.PlaceComponentResult && (otpListener = otpInputView.getAuthRequestContext) != null) {
                        otpListener.BuiltInFictitiousFunctionClassFactory(str);
                    }
                }
            }
            i2 = i3;
            i = 0;
        }
    }

    public final void setError() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        List<EditText> list = this.MyBillsEntityDataFactory;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((EditText) it.next()).setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.bg_otp_rounded_red_50));
            }
        }
        getBinding().getAuthRequestContext.startAnimation(AnimationUtils.loadAnimation(getBinding().getAuthRequestContext.getContext(), R.anim.BuiltInFictitiousFunctionClassFactory_res_0x7f010052));
    }
}
