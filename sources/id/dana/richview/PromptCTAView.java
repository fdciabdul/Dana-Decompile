package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.component.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.extension.view.InputExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010?\u001a\u00020\u0002¢\u0006\u0004\b@\u0010AB+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010B\u001a\u00020\u0002\u0012\u0006\u0010C\u001a\u00020\u0002¢\u0006\u0004\b@\u0010DJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0012J9\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001e\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR*\u0010&\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00028\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010%R*\u0010,\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u00100\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+RB\u00109\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t018\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108RB\u0010=\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t018\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b:\u00104\u001a\u0004\b;\u00106\"\u0004\b<\u00108"}, d2 = {"Lid/dana/richview/PromptCTAView;", "Lid/dana/component/BaseRichView;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "text", "", "enable", "contentDesc", "setButtonNegative", "(Ljava/lang/String;ZLjava/lang/String;)V", "setButtonPositive", "color", "isUnderlineText", "Lkotlin/Function0;", "onClick", "setHeaderColoredSpan", "(ILjava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "setup", "()V", "p0", "p1", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "value", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getCtaStyle", "setCtaStyle", "(I)V", "ctaStyle", "Ljava/lang/String;", "getHeaderText", "()Ljava/lang/String;", "setHeaderText", "(Ljava/lang/String;)V", "headerText", "PlaceComponentResult", "getHeaderTextContentDesc", "setHeaderTextContentDesc", "headerTextContentDesc", "Lkotlin/Function1;", "Landroid/view/View;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "getOnBtnNegativeClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnBtnNegativeClickListener", "(Lkotlin/jvm/functions/Function1;)V", "onBtnNegativeClickListener", "MyBillsEntityDataFactory", "getOnBtnPositiveClickListener", "setOnBtnPositiveClickListener", "onBtnPositiveClickListener", "attributeSet", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PromptCTAView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Function1<? super View, Unit> onBtnNegativeClickListener;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int ctaStyle;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function1<? super View, Unit> onBtnPositiveClickListener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String headerTextContentDesc;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String headerText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromptCTAView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromptCTAView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.view_prompt_cta;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptCTAView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onBtnNegativeClickListener = PromptCTAView$onBtnNegativeClickListener$1.INSTANCE;
        this.onBtnPositiveClickListener = PromptCTAView$onBtnPositiveClickListener$1.INSTANCE;
        this.headerText = "";
        this.headerTextContentDesc = "";
    }

    public /* synthetic */ PromptCTAView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptCTAView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onBtnNegativeClickListener = PromptCTAView$onBtnNegativeClickListener$1.INSTANCE;
        this.onBtnPositiveClickListener = PromptCTAView$onBtnPositiveClickListener$1.INSTANCE;
        this.headerText = "";
        this.headerTextContentDesc = "";
    }

    @JvmName(name = "getOnBtnNegativeClickListener")
    public final Function1<View, Unit> getOnBtnNegativeClickListener() {
        return this.onBtnNegativeClickListener;
    }

    @JvmName(name = "setOnBtnNegativeClickListener")
    public final void setOnBtnNegativeClickListener(Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        getAuthRequestContext(new PromptCTAView$onBtnNegativeClickListener$2(this, function1), new PromptCTAView$onBtnNegativeClickListener$3(this, function1));
        this.onBtnNegativeClickListener = function1;
    }

    @JvmName(name = "getOnBtnPositiveClickListener")
    public final Function1<View, Unit> getOnBtnPositiveClickListener() {
        return this.onBtnPositiveClickListener;
    }

    @JvmName(name = "setOnBtnPositiveClickListener")
    public final void setOnBtnPositiveClickListener(Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        getAuthRequestContext(new PromptCTAView$onBtnPositiveClickListener$2(this, function1), new PromptCTAView$onBtnPositiveClickListener$3(this, function1));
        this.onBtnPositiveClickListener = function1;
    }

    @JvmName(name = "getHeaderText")
    public final String getHeaderText() {
        return this.headerText;
    }

    @JvmName(name = "setHeaderText")
    public final void setHeaderText(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a0876_sendmoneyactivity_bottomsheetonboardingmodule_1);
        if (textView != null) {
            String str2 = str;
            ((TextView) textView.findViewById(R.id.res_0x7f0a0876_sendmoneyactivity_bottomsheetonboardingmodule_1)).setText(str2);
            ((TextView) textView.findViewById(R.id.res_0x7f0a0876_sendmoneyactivity_bottomsheetonboardingmodule_1)).setVisibility(StringsKt.isBlank(str2) ^ true ? 0 : 8);
        }
        this.headerText = str;
    }

    @JvmName(name = "getHeaderTextContentDesc")
    public final String getHeaderTextContentDesc() {
        return this.headerTextContentDesc;
    }

    @JvmName(name = "setHeaderTextContentDesc")
    public final void setHeaderTextContentDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a0876_sendmoneyactivity_bottomsheetonboardingmodule_1);
        if (textView != null) {
            textView.setContentDescription(str);
        }
        this.headerTextContentDesc = str;
    }

    @JvmName(name = "getCtaStyle")
    public final int getCtaStyle() {
        return this.ctaStyle;
    }

    @JvmName(name = "setCtaStyle")
    public final void setCtaStyle(int i) {
        this.ctaStyle = i;
        getAuthRequestContext(new Function0<Unit>() { // from class: id.dana.richview.PromptCTAView$renderCtaStyle$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConstraintLayout constraintLayout = (ConstraintLayout) PromptCTAView.this._$_findCachedViewById(R.id.storeUserConfig_res_0x7f0a035e);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) PromptCTAView.this._$_findCachedViewById(R.id.murmurHash64WithSeed_res_0x7f0a035f);
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.richview.PromptCTAView$renderCtaStyle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ConstraintLayout constraintLayout = (ConstraintLayout) PromptCTAView.this._$_findCachedViewById(R.id.storeUserConfig_res_0x7f0a035e);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(8);
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) PromptCTAView.this._$_findCachedViewById(R.id.murmurHash64WithSeed_res_0x7f0a035f);
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(0);
                }
                TextView textView = (TextView) PromptCTAView.this._$_findCachedViewById(R.id.res_0x7f0a0876_sendmoneyactivity_bottomsheetonboardingmodule_1);
                if (textView != null) {
                    textView.setTextAlignment(4);
                }
                TextView textView2 = (TextView) PromptCTAView.this._$_findCachedViewById(R.id.res_0x7f0a0876_sendmoneyactivity_bottomsheetonboardingmodule_1);
                if (textView2 != null) {
                    textView2.setTextColor(ResourcesCompat.PlaceComponentResult(PromptCTAView.this.getResources(), R.color.f23982131099995, null));
                }
            }
        });
    }

    @Override // id.dana.component.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        String string;
        String string2;
        String string3;
        Intrinsics.checkNotNullParameter(context, "");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.setAkuEntranceOpen);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        try {
            if (obtainStyledAttributes.hasValue(1) && (string3 = obtainStyledAttributes.getString(1)) != null) {
                setHeaderText(string3);
            }
            if (obtainStyledAttributes.hasValue(3) && (string2 = obtainStyledAttributes.getString(3)) != null) {
                String str = StringsKt.isBlank(string2) ^ true ? string2 : null;
                if (str != null) {
                    setButtonPositive$default(this, str, true, null, 4, null);
                }
            }
            if (obtainStyledAttributes.hasValue(2) && (string = obtainStyledAttributes.getString(2)) != null) {
                String str2 = true ^ StringsKt.isBlank(string) ? string : null;
                if (str2 != null) {
                    setButtonNegative$default(this, str2, true, null, 4, null);
                }
            }
            if (obtainStyledAttributes.hasValue(0)) {
                setCtaStyle(obtainStyledAttributes.getInt(0, 0));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ void setButtonPositive$default(PromptCTAView promptCTAView, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        promptCTAView.setButtonPositive(str, z, str2);
    }

    public final void setButtonPositive(final String text, final boolean enable, final String contentDesc) {
        Intrinsics.checkNotNullParameter(text, "");
        Intrinsics.checkNotNullParameter(contentDesc, "");
        getAuthRequestContext(new Function0<Unit>() { // from class: id.dana.richview.PromptCTAView$setButtonPositive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) PromptCTAView.this._$_findCachedViewById(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
                if (danaButtonPrimaryView != null) {
                    PromptCTAView.access$set(PromptCTAView.this, danaButtonPrimaryView, text, enable, contentDesc);
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.richview.PromptCTAView$setButtonPositive$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) PromptCTAView.this._$_findCachedViewById(R.id.btnPositiveTop);
                if (danaButtonPrimaryView != null) {
                    PromptCTAView.access$set(PromptCTAView.this, danaButtonPrimaryView, text, enable, contentDesc);
                }
            }
        });
    }

    public static /* synthetic */ void setButtonNegative$default(PromptCTAView promptCTAView, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        promptCTAView.setButtonNegative(str, z, str2);
    }

    public final void setButtonNegative(final String text, final boolean enable, final String contentDesc) {
        Intrinsics.checkNotNullParameter(text, "");
        Intrinsics.checkNotNullParameter(contentDesc, "");
        getAuthRequestContext(new Function0<Unit>() { // from class: id.dana.richview.PromptCTAView$setButtonNegative$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) PromptCTAView.this._$_findCachedViewById(R.id.M);
                if (danaButtonSecondaryView != null) {
                    PromptCTAView.access$set(PromptCTAView.this, danaButtonSecondaryView, text, enable, contentDesc);
                }
            }
        }, new Function0<Unit>() { // from class: id.dana.richview.PromptCTAView$setButtonNegative$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) PromptCTAView.this._$_findCachedViewById(R.id.btnNegativeDown);
                if (danaButtonGhostView != null) {
                    PromptCTAView.access$set(PromptCTAView.this, danaButtonGhostView, text, enable, contentDesc);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setHeaderColoredSpan$default(PromptCTAView promptCTAView, int i, String str, boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = R.color.f22912131099753;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.richview.PromptCTAView$setHeaderColoredSpan$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        promptCTAView.setHeaderColoredSpan(i, str, z, function0);
    }

    public final void setHeaderColoredSpan(int color, String text, boolean isUnderlineText, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(text, "");
        Intrinsics.checkNotNullParameter(onClick, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a0876_sendmoneyactivity_bottomsheetonboardingmodule_1);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        InputExtKt.getAuthRequestContext(textView, color, text, isUnderlineText, onClick);
    }

    private final void getAuthRequestContext(Function0<Unit> p0, Function0<Unit> p1) {
        int i = this.ctaStyle;
        if (i == 0) {
            p0.invoke();
        } else if (i == 1) {
            p1.invoke();
        } else {
            p0.invoke();
        }
    }

    public static final /* synthetic */ void access$set(PromptCTAView promptCTAView, DanaButtonGhostView danaButtonGhostView, String str, boolean z, String str2) {
        danaButtonGhostView.setVisibility(StringsKt.isBlank(str) ? 8 : 0);
        danaButtonGhostView.setClickable(z);
        danaButtonGhostView.setEnabled(z);
        danaButtonGhostView.setContentDescription(str2);
        danaButtonGhostView.setDanaButtonView(z ? 1 : 0, str, null);
    }

    public static final /* synthetic */ void access$set(PromptCTAView promptCTAView, DanaButtonPrimaryView danaButtonPrimaryView, String str, boolean z, String str2) {
        danaButtonPrimaryView.setVisibility(StringsKt.isBlank(str) ? 8 : 0);
        danaButtonPrimaryView.setClickable(z);
        danaButtonPrimaryView.setEnabled(z);
        danaButtonPrimaryView.setContentDescription(str2);
        danaButtonPrimaryView.setDanaButtonView(z ? 1 : 0, str, null, null);
    }

    public static final /* synthetic */ void access$set(PromptCTAView promptCTAView, DanaButtonSecondaryView danaButtonSecondaryView, String str, boolean z, String str2) {
        danaButtonSecondaryView.setVisibility(StringsKt.isBlank(str) ? 8 : 0);
        danaButtonSecondaryView.setClickable(z);
        danaButtonSecondaryView.setEnabled(z);
        danaButtonSecondaryView.setContentDescription(str2);
        danaButtonSecondaryView.setDanaButtonView(z ? 1 : 0, str, null, null);
    }
}
