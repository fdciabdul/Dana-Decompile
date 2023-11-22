package id.dana.cashier.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.FlowViewUtil;
import id.dana.databinding.ViewInputCardNumberBinding;
import id.dana.utils.KeyboardHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB'\b\u0016\u0012\u0006\u0010H\u001a\u00020G\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010I\u0012\b\b\u0002\u0010K\u001a\u00020\u0014¢\u0006\u0004\bL\u0010MB+\b\u0016\u0012\u0006\u0010H\u001a\u00020G\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0006\u0010N\u001a\u00020\u0014\u0012\u0006\u0010O\u001a\u00020\u0014¢\u0006\u0004\bL\u0010PJ+\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00032\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\fR*\u0010$\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00068\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010(\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00068\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u0011\u0010*\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b)\u0010!R.\u0010.\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R.\u00106\u001a\u0004\u0018\u00010/2\b\u0010\u001e\u001a\u0004\u0018\u00010/8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R.\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010+\u001a\u00020\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010>R*\u0010B\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00068\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010\u001f\u001a\u0004\b@\u0010!\"\u0004\bA\u0010#R.\u0010F\u001a\u0004\u0018\u00010/2\b\u0010\u001e\u001a\u0004\u0018\u00010/8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bC\u00101\u001a\u0004\bD\u00103\"\u0004\bE\u00105"}, d2 = {"Lid/dana/cashier/view/InputCardNumberView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewInputCardNumberBinding;", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "Lkotlin/Function1;", "", "", "inputCardChangedListener", "addInputCardListener", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "clearCardIcon", "()V", "clearText", "inflateViewBinding", "()Lid/dana/databinding/ViewInputCardNumberBinding;", "number", "", "isLuhnCheckSumValid", "(Ljava/lang/String;)Z", "", "cardSchemeIcon", "cardTypeIcon", "setCardIcon", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "p0", "p1", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "setup", "value", "Ljava/lang/String;", "getCardHint", "()Ljava/lang/String;", "setCardHint", "(Ljava/lang/String;)V", "cardHint", "PlaceComponentResult", "getCardNumberOCR", "setCardNumberOCR", "cardNumberOCR", "getCleanCardNumber", "cleanCardNumber", "getAuthRequestContext", "getErrorMessage", "setErrorMessage", "errorMessage", "Landroid/text/SpannableString;", "MyBillsEntityDataFactory", "Landroid/text/SpannableString;", "getErrorMessageSpan", "()Landroid/text/SpannableString;", "setErrorMessageSpan", "(Landroid/text/SpannableString;)V", "errorMessageSpan", "Lkotlin/jvm/functions/Function1;", "getIconCardErrorHandlingListener", "()Lkotlin/jvm/functions/Function1;", "setIconCardErrorHandlingListener", "(Lkotlin/jvm/functions/Function1;)V", "iconCardErrorHandlingListener", "moveToNextValue", "Z", "lookAheadTest", "getTitle", GriverEvents.EVENT_SET_TITLE, "title", "scheduleImpl", "getWarningMessageSpan", "setWarningMessageSpan", "warningMessageSpan", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InputCardNumberView extends BaseViewBindingRichView<ViewInputCardNumberBinding> {
    public static final int AMEX_BANK_CARD_DIGIT = 15;
    public static final char DIVIDER = ' ';
    public static final int MAX_LENGTH_CARD_NUMBER = 19;
    public static final int MODULO = 5;
    public static final int PREFIX_BANK_CARD_DIGIT = 6;
    public static final int TOTAL_CHAR_BETWEEN_DIVIDER = 4;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String cardHint;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super String, Unit> iconCardErrorHandlingListener;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private SpannableString errorMessageSpan;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String cardNumberOCR;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String errorMessage;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String title;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private SpannableString warningMessageSpan;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputCardNumberView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputCardNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
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
    public InputCardNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.title = "";
        this.errorMessage = "";
        this.cardNumberOCR = "";
        this.cardHint = "";
        this.iconCardErrorHandlingListener = InputCardNumberView$iconCardErrorHandlingListener$1.INSTANCE;
    }

    public /* synthetic */ InputCardNumberView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputCardNumberView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.title = "";
        this.errorMessage = "";
        this.cardNumberOCR = "";
        this.cardHint = "";
        this.iconCardErrorHandlingListener = InputCardNumberView$iconCardErrorHandlingListener$1.INSTANCE;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.title = str;
        AppCompatTextView appCompatTextView = getBinding().moveToNextValue;
        appCompatTextView.setText(this.title);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(this.title.length() > 0 ? 0 : 8);
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0027, code lost:
    
        if ((r0.length() > 0) != true) goto L24;
     */
    @kotlin.jvm.JvmName(name = "setErrorMessage")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setErrorMessage(java.lang.String r4) {
        /*
            r3 = this;
            r3.errorMessage = r4
            androidx.viewbinding.ViewBinding r4 = r3.getBinding()
            id.dana.databinding.ViewInputCardNumberBinding r4 = (id.dana.databinding.ViewInputCardNumberBinding) r4
            androidx.appcompat.widget.AppCompatTextView r4 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0
            java.lang.String r0 = r3.errorMessage
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r4.setText(r0)
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.String r0 = r3.errorMessage
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L29
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = 0
        L27:
            if (r0 == r2) goto L2a
        L29:
            r2 = 0
        L2a:
            if (r2 == 0) goto L2d
            goto L2e
        L2d:
            r1 = 4
        L2e:
            r4.setVisibility(r1)
            r3.KClassImpl$Data$declaredNonStaticMembers$2()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.InputCardNumberView.setErrorMessage(java.lang.String):void");
    }

    @JvmName(name = "getErrorMessageSpan")
    public final SpannableString getErrorMessageSpan() {
        return this.errorMessageSpan;
    }

    @JvmName(name = "setErrorMessageSpan")
    public final void setErrorMessageSpan(SpannableString spannableString) {
        this.errorMessageSpan = spannableString;
        AppCompatTextView appCompatTextView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        appCompatTextView.setText(this.errorMessageSpan);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(this.errorMessageSpan != null ? 0 : 4);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @JvmName(name = "getWarningMessageSpan")
    public final SpannableString getWarningMessageSpan() {
        return this.warningMessageSpan;
    }

    @JvmName(name = "setWarningMessageSpan")
    public final void setWarningMessageSpan(SpannableString spannableString) {
        this.warningMessageSpan = spannableString;
        AppCompatTextView appCompatTextView = getBinding().getErrorConfigVersion;
        appCompatTextView.setText(this.warningMessageSpan);
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(this.warningMessageSpan != null ? 0 : 4);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @JvmName(name = "getCardNumberOCR")
    public final String getCardNumberOCR() {
        return this.cardNumberOCR;
    }

    @JvmName(name = "setCardNumberOCR")
    public final void setCardNumberOCR(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cardNumberOCR = str;
        AppCompatEditText appCompatEditText = getBinding().BuiltInFictitiousFunctionClassFactory;
        appCompatEditText.setText(this.cardNumberOCR);
        appCompatEditText.setSelection(appCompatEditText.length());
    }

    @JvmName(name = "getCardHint")
    public final String getCardHint() {
        return this.cardHint;
    }

    @JvmName(name = "setCardHint")
    public final void setCardHint(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cardHint = str;
        getBinding().BuiltInFictitiousFunctionClassFactory.setHint(this.cardHint);
    }

    @JvmName(name = "getIconCardErrorHandlingListener")
    public final Function1<String, Unit> getIconCardErrorHandlingListener() {
        return this.iconCardErrorHandlingListener;
    }

    @JvmName(name = "setIconCardErrorHandlingListener")
    public final void setIconCardErrorHandlingListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.iconCardErrorHandlingListener = function1;
    }

    @JvmName(name = "getCleanCardNumber")
    public final String getCleanCardNumber() {
        return StringsKt.replace$default(String.valueOf(getBinding().BuiltInFictitiousFunctionClassFactory.getText()), " ", "", false, 4, (Object) null);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewInputCardNumberBinding inflateViewBinding() {
        ViewInputCardNumberBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewInputCardNumberBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        final AppCompatEditText appCompatEditText = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.view.InputCardNumberView$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                Ref.IntRef.this.element = appCompatEditText.getSelectionStart();
                intRef2.element = String.valueOf(appCompatEditText.getText()).length() - Ref.IntRef.this.element;
                objectRef.element = String.valueOf(p0);
            }

            /* JADX WARN: Code restructure failed: missing block: B:40:0x00b5, code lost:
            
                if (r5[r4] == ' ') goto L43;
             */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void afterTextChanged(android.text.Editable r8) {
                /*
                    Method dump skipped, instructions count: 317
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.InputCardNumberView$addTextChangedListener$1.afterTextChanged(android.text.Editable):void");
            }
        });
        appCompatEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.cashier.view.InputCardNumberView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                InputCardNumberView.m596$r8$lambda$x6g83Q9UdFqVAxnHhbRpBGa_E(InputCardNumberView.this, appCompatEditText, view, z);
            }
        });
        appCompatEditText.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.cashier.view.InputCardNumberView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean PlaceComponentResult;
                PlaceComponentResult = InputCardNumberView.PlaceComponentResult(AppCompatEditText.this, motionEvent);
                return PlaceComponentResult;
            }
        });
        appCompatEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.cashier.view.InputCardNumberView$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean authRequestContext;
                authRequestContext = InputCardNumberView.getAuthRequestContext(AppCompatEditText.this, i);
                return authRequestContext;
            }
        });
        appCompatEditText.requestFocus();
        Context context = appCompatEditText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addInputCardListener$default(InputCardNumberView inputCardNumberView, CoroutineScope coroutineScope, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<String, Unit>() { // from class: id.dana.cashier.view.InputCardNumberView$addInputCardListener$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }
            };
        }
        inputCardNumberView.addInputCardListener(coroutineScope, function1);
    }

    public final void addInputCardListener(CoroutineScope lifecycleScope, Function1<? super String, Unit> inputCardChangedListener) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "");
        Intrinsics.checkNotNullParameter(inputCardChangedListener, "");
        BuiltInFictitiousFunctionClassFactory(lifecycleScope, inputCardChangedListener);
    }

    public final void setCardIcon(Integer cardSchemeIcon, Integer cardTypeIcon) {
        if (cardSchemeIcon != null) {
            int intValue = cardSchemeIcon.intValue();
            AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(Integer.valueOf(intValue)).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            appCompatImageView.setVisibility(0);
        }
        if (cardTypeIcon != null) {
            int intValue2 = cardTypeIcon.intValue();
            AppCompatImageView appCompatImageView2 = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
            GlideApp.getAuthRequestContext(appCompatImageView2.getContext()).PlaceComponentResult(Integer.valueOf(intValue2)).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
            appCompatImageView2.setVisibility(0);
        }
    }

    public final void clearCardIcon() {
        ViewInputCardNumberBinding binding = getBinding();
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding.MyBillsEntityDataFactory, 0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding.getAuthRequestContext, 0);
        AppCompatImageView appCompatImageView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
        AppCompatImageView appCompatImageView2 = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        appCompatImageView2.setVisibility(8);
    }

    public final boolean isLuhnCheckSumValid(String number) {
        Intrinsics.checkNotNullParameter(number, "");
        int i = 0;
        boolean z = false;
        for (int length = number.length() - 1; length >= 0; length--) {
            int charAt = number.charAt(length) - '0';
            if (charAt >= 0 && charAt <= 9) {
                if (z && (charAt = charAt * 2) > 9) {
                    charAt -= 9;
                }
                i += charAt;
                z = !z;
            }
        }
        return i % 10 == 0;
    }

    public final void clearText() {
        Editable text = getBinding().BuiltInFictitiousFunctionClassFactory.getText();
        if (text != null) {
            text.clear();
        }
    }

    public static final boolean getAuthRequestContext(AppCompatEditText appCompatEditText, int i) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "");
        if (i == 6) {
            appCompatEditText.clearFocus();
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(appCompatEditText);
            return true;
        }
        return false;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Integer valueOf;
        Integer valueOf2;
        String str = this.errorMessage;
        if (!(str == null || str.length() == 0) || this.errorMessageSpan != null) {
            valueOf = Integer.valueOf((int) R.style.f54022132017896);
            valueOf2 = Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f26712131100373));
        } else if (this.getAuthRequestContext) {
            valueOf = Integer.valueOf((int) R.style.f54032132017897);
            valueOf2 = Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27152131100507));
        } else {
            valueOf = Integer.valueOf((int) R.style.f54072132017901);
            valueOf2 = Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23962131099992));
        }
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().moveToNextValue, valueOf.intValue());
        ColorStateList valueOf3 = ColorStateList.valueOf(valueOf2.intValue());
        Intrinsics.checkNotNullExpressionValue(valueOf3, "");
        ViewCompat.BuiltInFictitiousFunctionClassFactory(getBinding().BuiltInFictitiousFunctionClassFactory, valueOf3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory$default(InputCardNumberView inputCardNumberView, CoroutineScope coroutineScope, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<String, Unit>() { // from class: id.dana.cashier.view.InputCardNumberView$setInputCardListener$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }
            };
        }
        inputCardNumberView.BuiltInFictitiousFunctionClassFactory(coroutineScope, function1);
    }

    private final void BuiltInFictitiousFunctionClassFactory(CoroutineScope p0, Function1<? super String, Unit> p1) {
        FlowViewUtil flowViewUtil = FlowViewUtil.INSTANCE;
        AppCompatEditText appCompatEditText = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
        final Flow filterNotNull = FlowKt.filterNotNull(FlowViewUtil.PlaceComponentResult(appCompatEditText));
        final Flow<CharSequence> flow = new Flow<CharSequence>() { // from class: id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super CharSequence> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1$2", f = "InputCardNumberView.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$BuiltInFictitiousFunctionClassFactory = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1$2$1 r0 = (id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 + r2
                        r0.label = r7
                        goto L19
                    L14:
                        id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1$2$1 r0 = new id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L52
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$BuiltInFictitiousFunctionClassFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        r2 = r6
                        java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                        int r2 = r2.length()
                        r4 = 4
                        if (r2 < r4) goto L46
                        r2 = 1
                        goto L47
                    L46:
                        r2 = 0
                    L47:
                        if (r2 == 0) goto L52
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L52
                        return r1
                    L52:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        FlowKt.launchIn(FlowKt.onEach(FlowKt.debounce(new Flow<CharSequence>() { // from class: id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super CharSequence> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1$2", f = "InputCardNumberView.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$PlaceComponentResult = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r9
                        id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1$2$1 r0 = (id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r9 = r0.label
                        int r9 = r9 + r2
                        r0.label = r9
                        goto L19
                    L14:
                        id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1$2$1 r0 = new id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L19:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L65
                    L2a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L32:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.flow.FlowCollector r9 = r7.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        java.lang.Appendable r2 = (java.lang.Appendable) r2
                        r4 = 0
                    L44:
                        int r5 = r8.length()
                        if (r4 >= r5) goto L5a
                        char r5 = r8.charAt(r4)
                        boolean r6 = kotlin.text.CharsKt.isWhitespace(r5)
                        if (r6 != 0) goto L57
                        r2.append(r5)
                    L57:
                        int r4 = r4 + 1
                        goto L44
                    L5a:
                        java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r2, r0)
                        if (r8 != r1) goto L65
                        return r1
                    L65:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.view.InputCardNumberView$setInputCardListener$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, 1500L), new InputCardNumberView$setInputCardListener$4(p1, null)), p0);
    }

    public static final boolean PlaceComponentResult(AppCompatEditText appCompatEditText, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        if (appCompatEditText.getCompoundDrawables()[2] == null || motionEvent.getAction() != 1 || motionEvent.getRawX() < appCompatEditText.getRight() - appCompatEditText.getCompoundDrawables()[2].getBounds().width() || appCompatEditText.getText() == null) {
            return false;
        }
        Editable text = appCompatEditText.getText();
        if (text != null) {
            text.clear();
        }
        return true;
    }

    /* renamed from: $r8$lambda$x6g83Q9UdFqV--AxnHhbRpBGa_E */
    public static /* synthetic */ void m596$r8$lambda$x6g83Q9UdFqVAxnHhbRpBGa_E(InputCardNumberView inputCardNumberView, AppCompatEditText appCompatEditText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(inputCardNumberView, "");
        Intrinsics.checkNotNullParameter(appCompatEditText, "");
        inputCardNumberView.getAuthRequestContext = z;
        inputCardNumberView.KClassImpl$Data$declaredNonStaticMembers$2();
        appCompatEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, z ? R.drawable.ic_close_filled_grey : 0, 0);
    }
}
