package id.dana.core.ui.richview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.core.ui.R;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.util.FlowViewUtil;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.core.ui.util.OSUtil;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 S2\u00020\u0001:\u0002STB\u0011\b\u0016\u0012\u0006\u0010K\u001a\u00020J¢\u0006\u0004\bL\u0010MB\u001b\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010O\u001a\u0004\u0018\u00010N¢\u0006\u0004\bL\u0010PB#\b\u0016\u0012\u0006\u0010K\u001a\u00020J\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\u0006\u0010Q\u001a\u00020\r¢\u0006\u0004\bL\u0010RJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0015\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u000b¢\u0006\u0004\b%\u0010\u001fJ\u0015\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020*¢\u0006\u0004\b(\u0010+J\u0015\u0010,\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\b¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b/\u0010-J\u0015\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\r¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000b¢\u0006\u0004\b4\u0010\u001fR\u0011\u0010'\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b5\u00106R\u0011\u0010:\u001a\u0002078G¢\u0006\u0006\u001a\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\"\u0010@\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010\u001fR\u0016\u0010D\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0011\u0010G\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\bF\u00106R\u0018\u0010<\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010HR\u0016\u0010\u0006\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u0010?"}, d2 = {"Lid/dana/core/ui/richview/CurrencyEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "", "clearAmount", "()V", "disableSoftKeyboard", "PlaceComponentResult", "Lkotlinx/coroutines/flow/Flow;", "", "listenOriginalValue", "()Lkotlinx/coroutines/flow/Flow;", "", "focused", "", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "onFocusChanged", "(ZILandroid/graphics/Rect;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyPreIme", "(ILandroid/view/KeyEvent;)Z", "selStart", "selEnd", "onSelectionChanged", "(II)V", "removeUnderline", "enabled", "setDecimalPointEnabled", "(Z)V", "Lid/dana/core/ui/richview/CurrencyEditText$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/core/ui/richview/CurrencyEditText$Listener;)V", "locked", "setLocked", "", "amount", "setPrefixedAmount", "(D)V", "", "(J)V", "setPrefixedAmountDecimalPointEnabled", "(Ljava/lang/String;)V", "textHint", "setTextHint", "textHintColor", "setTextHintColor", "(I)V", "usePrefix", "setUsePrefix", "getAmount", "()Ljava/lang/String;", "Lid/dana/core/ui/model/CurrencyAmountModel;", "getAmountModel", "()Lid/dana/core/ui/model/CurrencyAmountModel;", "amountModel", "Landroid/text/TextWatcher;", "BuiltInFictitiousFunctionClassFactory", "Landroid/text/TextWatcher;", "getAuthRequestContext", "Z", "isAllowEmpty", "()Z", "setAllowEmpty", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Lid/dana/core/ui/richview/CurrencyEditText$Listener;", "getPrefix", "prefix", "Ljava/lang/String;", "lookAheadTest", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CurrencyEditText extends AppCompatEditText {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private TextWatcher getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Listener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean isAllowEmpty;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/core/ui/richview/CurrencyEditText$Listener;", "", "", "PlaceComponentResult", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Listener {
        void PlaceComponentResult();
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

    @JvmName(name = "isAllowEmpty")
    /* renamed from: isAllowEmpty  reason: from getter */
    public final boolean getIsAllowEmpty() {
        return this.isAllowEmpty;
    }

    @JvmName(name = "setAllowEmpty")
    public final void setAllowEmpty(boolean z) {
        this.isAllowEmpty = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrencyEditText(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = true;
        PlaceComponentResult();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrencyEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = true;
        PlaceComponentResult();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrencyEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = true;
        PlaceComponentResult();
    }

    private final void PlaceComponentResult() {
        setInputType(2);
        setTransformationMethod(null);
        setHint(getPrefix());
        setHintTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.BuiltInFictitiousFunctionClassFactory_res_0x7f06005d));
        getBackground().setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.GetContactSyncConfig_res_0x7f060337), PorterDuff.Mode.SRC_IN);
        this.getAuthRequestContext = new TextWatcher() { // from class: id.dana.core.ui.richview.CurrencyEditText$init$1

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
            private int getAuthRequestContext;

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            private int BuiltInFictitiousFunctionClassFactory;

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                this.BuiltInFictitiousFunctionClassFactory = CurrencyEditText.this.getSelectionStart();
                this.getAuthRequestContext = String.valueOf(CurrencyEditText.this.getText()).length() - this.BuiltInFictitiousFunctionClassFactory;
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                boolean z;
                boolean z2;
                String str;
                boolean z3;
                boolean z4;
                boolean z5;
                Intrinsics.checkNotNullParameter(p0, "");
                String obj = p0.toString();
                z = CurrencyEditText.this.PlaceComponentResult;
                if ((z && !StringsKt.contains$default((CharSequence) obj, (CharSequence) CurrencyEditText.this.getPrefix(), false, 2, (Object) null)) || !StringsKt.startsWith$default(obj, CurrencyEditText.this.getPrefix(), false, 2, (Object) null)) {
                    CurrencyEditText$init$1 currencyEditText$init$1 = this;
                    CurrencyEditText.this.removeTextChangedListener(currencyEditText$init$1);
                    StringBuilder sb = new StringBuilder();
                    sb.append(CurrencyEditText.this.getPrefix());
                    sb.append(obj);
                    CurrencyEditText.this.setText(sb.toString());
                    try {
                        CurrencyEditText.this.setSelection(this.BuiltInFictitiousFunctionClassFactory);
                    } catch (Exception unused) {
                    }
                    CurrencyEditText.this.addTextChangedListener(currencyEditText$init$1);
                } else if (!Intrinsics.areEqual(obj, CurrencyEditText.this.getPrefix())) {
                    z2 = CurrencyEditText.this.MyBillsEntityDataFactory;
                    String replace = new Regex(z2 ? "[^0-9,]" : "[^0-9]").replace(obj, "");
                    str = CurrencyEditText.this.BuiltInFictitiousFunctionClassFactory;
                    if (Intrinsics.areEqual(replace, str)) {
                        return;
                    }
                    if (replace.length() == 0) {
                        return;
                    }
                    if (StringsKt.startsWith$default(replace, "0", false, 2, (Object) null)) {
                        z4 = CurrencyEditText.this.MyBillsEntityDataFactory;
                        if (!z4) {
                            replace = replace.substring(1);
                            Intrinsics.checkNotNullExpressionValue(replace, "");
                        }
                    }
                    CurrencyEditText.this.BuiltInFictitiousFunctionClassFactory = replace;
                    CurrencyEditText$init$1 currencyEditText$init$12 = this;
                    CurrencyEditText.this.removeTextChangedListener(currencyEditText$init$12);
                    CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(replace, "", false);
                    if (!(currencyAmountModel.getAmount().length() == 0)) {
                        z3 = CurrencyEditText.this.MyBillsEntityDataFactory;
                        if (z3) {
                            CurrencyEditText.this.setPrefixedAmountDecimalPointEnabled(currencyAmountModel.getAmount());
                        } else {
                            CurrencyEditText.this.setPrefixedAmount(Long.parseLong(StringsKt.replace$default(currencyAmountModel.getAmount(), ',', '.', false, 4, (Object) null)));
                        }
                    } else {
                        CurrencyEditText.this.setPrefixedAmount(0L);
                    }
                    try {
                        Editable text = CurrencyEditText.this.getText();
                        if (text != null) {
                            CurrencyEditText.this.setSelection(Math.max(text.length() - this.getAuthRequestContext, 0));
                        }
                    } catch (Exception unused2) {
                    }
                    CurrencyEditText.this.addTextChangedListener(currencyEditText$init$12);
                } else {
                    CurrencyEditText$init$1 currencyEditText$init$13 = this;
                    CurrencyEditText.this.removeTextChangedListener(currencyEditText$init$13);
                    if (!CurrencyEditText.this.getIsAllowEmpty()) {
                        z5 = CurrencyEditText.this.PlaceComponentResult;
                        if (z5) {
                            CurrencyEditText.this.setPrefixedAmount(0L);
                        } else {
                            CurrencyEditText.this.setText("0");
                        }
                    } else {
                        CurrencyEditText.this.setText("");
                    }
                    try {
                        Editable text2 = CurrencyEditText.this.getText();
                        if (text2 != null) {
                            CurrencyEditText.this.setSelection(text2.length());
                        }
                    } catch (Exception unused3) {
                    }
                    CurrencyEditText.this.addTextChangedListener(currencyEditText$init$13);
                }
            }
        };
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public final void setPrefixedAmount(long amount) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefix());
        sb.append(NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), amount));
        setText(sb.toString());
    }

    public final void setPrefixedAmount(double amount) {
        String format;
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefix());
        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(amount);
        sb.append(format);
        setText(sb.toString());
    }

    public final void setPrefixedAmountDecimalPointEnabled(String amount) {
        String format;
        Intrinsics.checkNotNullParameter(amount, "");
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefix());
        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(Double.parseDouble(StringsKt.replace$default(amount, ",", ".", false, 4, (Object) null)));
        sb.append(format);
        String obj = sb.toString();
        boolean z = StringsKt.endsWith$default(amount, ",0", false, 2, (Object) null) || StringsKt.endsWith$default(amount, ",00", false, 2, (Object) null);
        if (StringsKt.last(amount) == ',') {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(',');
            obj = sb2.toString();
        } else if (z) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(obj);
            sb3.append(',');
            sb3.append(StringsKt.substringAfter$default(amount, ",", (String) null, 2, (Object) null));
            obj = sb3.toString();
        }
        setText(obj);
    }

    @JvmName(name = "getPrefix")
    public final String getPrefix() {
        return this.PlaceComponentResult ? "Rp" : "";
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        if (this.MyBillsEntityDataFactory) {
            return new Regex("[^0-9,]").replace(String.valueOf(getText()), "");
        }
        return new Regex("[^0-9]").replace(String.valueOf(getText()), "");
    }

    public final void setLocked(boolean locked) {
        getBackground().setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), locked ? R.color.getErrorConfigVersion_res_0x7f060305 : R.color.GetContactSyncConfig_res_0x7f060337), PorterDuff.Mode.SRC_IN);
    }

    public final void removeUnderline() {
        setBackgroundResource(17170445);
    }

    public final void setListener(Listener listener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = listener;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Listener listener;
        Intrinsics.checkNotNullParameter(event, "");
        if (4 == event.getKeyCode() && (listener = this.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            listener.PlaceComponentResult();
        }
        return super.onKeyPreIme(keyCode, event);
    }

    public final void setUsePrefix(boolean usePrefix) {
        this.PlaceComponentResult = usePrefix;
    }

    public final void setDecimalPointEnabled(boolean enabled) {
        this.MyBillsEntityDataFactory = enabled;
    }

    @Override // android.widget.TextView
    protected final void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        if (TextUtils.isEmpty(getText()) || getText() == null) {
            return;
        }
        try {
            Editable text = getText();
            if (text != null) {
                setSelection(text.length());
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            addTextChangedListener(this.getAuthRequestContext);
        } else {
            removeTextChangedListener(this.getAuthRequestContext);
        }
    }

    public final void setTextHintColor(int textHintColor) {
        setHintTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), textHintColor));
    }

    public final void setTextHint(String textHint) {
        setHint(textHint);
    }

    public final void clearAmount() {
        if (this.PlaceComponentResult) {
            setText(getPrefix());
        } else {
            setText("");
        }
    }

    public final void disableSoftKeyboard() {
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (OSUtil.MyBillsEntityDataFactory()) {
            setShowSoftInputOnFocus(false);
        } else {
            setTextIsSelectable(false);
        }
    }

    public final Flow<String> listenOriginalValue() {
        FlowViewUtil flowViewUtil = FlowViewUtil.INSTANCE;
        final Flow debounce = FlowKt.debounce(FlowViewUtil.PlaceComponentResult(this), 100L);
        return new Flow<String>() { // from class: id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1$2", f = "CurrencyEditText.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1$2$1  reason: invalid class name */
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
                    this.$BuiltInFictitiousFunctionClassFactory = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1$2$1 r0 = (id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1$2$1 r0 = new id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$BuiltInFictitiousFunctionClassFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                        java.lang.String r5 = java.lang.String.valueOf(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.richview.CurrencyEditText$listenOriginalValue$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @JvmName(name = "getAmountModel")
    public final CurrencyAmountModel getAmountModel() {
        return new CurrencyAmountModel(getAmount(), getPrefix(), false, 4, null);
    }
}
