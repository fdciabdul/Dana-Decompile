package id.dana.mybills.ui.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.messaging.Constants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewCustomEditTextMyBillsBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001EB'\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010@\u001a\u00020!¢\u0006\u0004\bA\u0010BB+\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010@\u001a\u00020!\u0012\u0006\u0010C\u001a\u00020!¢\u0006\u0004\bA\u0010DJ\u001b\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0018J!\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\b¢\u0006\u0004\b&\u0010 J\u0015\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020!¢\u0006\u0004\b(\u0010$J\u0015\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020!¢\u0006\u0004\b*\u0010$J\u001b\u0010,\u001a\u00020\u00042\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b,\u0010\u0007J\u0015\u0010-\u001a\u00020\u00042\u0006\u0010'\u001a\u00020!¢\u0006\u0004\b-\u0010$J\u0017\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b/\u0010 J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0018R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00108R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00103R\u0016\u0010<\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010=\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?"}, d2 = {"Lid/dana/mybills/ui/customview/CustomEditTextView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewCustomEditTextMyBillsBinding;", "Lkotlin/Function0;", "", "onTextChanged", "addTextChangeListener", "(Lkotlin/jvm/functions/Function0;)V", "", "getText", "()Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/mybills/databinding/ViewCustomEditTextMyBillsBinding;", "", "isActivated", "isEditTextActivated", "(Z)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setDisabled", "()V", "setEnabled", ContainerUIProvider.KEY_SHOW, "msg", "setErrorMessage", "(ZLjava/lang/String;)Lid/dana/mybills/databinding/ViewCustomEditTextMyBillsBinding;", "hintMessage", "setHint", "(Ljava/lang/String;)V", "", "type", "setInputType", "(I)V", Constants.ScionAnalytics.PARAM_LABEL, "setLabelText", "img", "setLeftImage", "resIcon", "setLeftTextIcon", "onClick", "setOnEditTextClickListener", "setRightImage", "text", "setText", "setup", "Landroid/graphics/drawable/Drawable;", "BuiltInFictitiousFunctionClassFactory", "Landroid/graphics/drawable/Drawable;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Z", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "moveToNextValue", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "lookAheadTest", "I", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class CustomEditTextView extends BaseViewBindingRichView<ViewCustomEditTextMyBillsBinding> {
    public static final int TYPE_DISABLE = 1;
    public static final int TYPE_NORMAL = 0;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function0<Unit> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Drawable BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    public static final byte[] getAuthRequestContext = {16, -117, -56, -112, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int PlaceComponentResult = 108;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomEditTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomEditTextView(Context context, AttributeSet attributeSet) {
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

    public /* synthetic */ CustomEditTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        this.MyBillsEntityDataFactory = "";
        this.getAuthRequestContext = CustomEditTextView$onEditTextClickListener$1.INSTANCE;
        this.PlaceComponentResult = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomEditTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = "";
        this.MyBillsEntityDataFactory = "";
        this.getAuthRequestContext = CustomEditTextView$onEditTextClickListener$1.INSTANCE;
        this.PlaceComponentResult = true;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCustomEditTextMyBillsBinding inflateViewBinding() {
        ViewCustomEditTextMyBillsBinding authRequestContext = ViewCustomEditTextMyBillsBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        Resources.Theme theme;
        TypedArray obtainStyledAttributes;
        if (attrs == null || context == null || (theme = context.getTheme()) == null || (obtainStyledAttributes = theme.obtainStyledAttributes(attrs, R.styleable.R, 0, 0)) == null) {
            return;
        }
        try {
            this.getErrorConfigVersion = obtainStyledAttributes.getInt(R.styleable.T, 0);
            String string = obtainStyledAttributes.getString(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda1);
            String str = "";
            if (string == null) {
                string = "";
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = string;
            String string2 = obtainStyledAttributes.getString(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda2);
            if (string2 != null) {
                str = string2;
            }
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.S);
            this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.isAuth);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        setCustomEditText$default(this, 0, null, null, null, null, 31, null);
        final ViewCustomEditTextMyBillsBinding binding = getBinding();
        binding.lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.CustomEditTextView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomEditTextView.m2680$r8$lambda$X54r_RwRtdB4kEoSZ0so_idoYU(ViewCustomEditTextMyBillsBinding.this, this, view);
            }
        });
        binding.MyBillsEntityDataFactory.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.mybills.ui.customview.CustomEditTextView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                CustomEditTextView.m2679$r8$lambda$7QBUF6Ynb1QJNwPgNiKlxyIfc(ViewCustomEditTextMyBillsBinding.this, view, z);
            }
        });
    }

    static /* synthetic */ void setCustomEditText$default(CustomEditTextView customEditTextView, int i, String str, String str2, Drawable drawable, Drawable drawable2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = customEditTextView.getErrorConfigVersion;
        }
        if ((i2 & 2) != 0) {
            str = customEditTextView.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        if ((i2 & 4) != 0) {
            str2 = customEditTextView.MyBillsEntityDataFactory;
        }
        if ((i2 & 8) != 0) {
            drawable = customEditTextView.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if ((i2 & 16) != 0) {
            drawable2 = customEditTextView.BuiltInFictitiousFunctionClassFactory;
        }
        if (i == 0) {
            ViewCustomEditTextMyBillsBinding binding = customEditTextView.getBinding();
            binding.MyBillsEntityDataFactory.setEnabled(true);
            binding.getAuthRequestContext.setBackground(ContextCompat.PlaceComponentResult(customEditTextView.getContext(), R.drawable.bg_white_rounded_grey_border_8dp));
            binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(str);
            if (str2 != null) {
                binding.MyBillsEntityDataFactory.setText(str2);
            }
            if (drawable != null) {
                binding.BuiltInFictitiousFunctionClassFactory.setImageDrawable(drawable);
            }
            if (drawable2 != null) {
                binding.scheduleImpl.setImageDrawable(drawable2);
            }
        } else if (i == 1) {
            ViewCustomEditTextMyBillsBinding binding2 = customEditTextView.getBinding();
            binding2.MyBillsEntityDataFactory.setEnabled(false);
            binding2.getAuthRequestContext.setBackground(ContextCompat.PlaceComponentResult(customEditTextView.getContext(), R.drawable.bg_grey_rounded_grey_border_8dp));
            binding2.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(str);
            binding2.MyBillsEntityDataFactory.setText(str2);
            if (drawable != null) {
                AppCompatImageView appCompatImageView = binding2.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(0);
                binding2.BuiltInFictitiousFunctionClassFactory.setImageDrawable(drawable);
            }
            if (drawable2 != null) {
                AppCompatImageView appCompatImageView2 = binding2.scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                appCompatImageView2.setVisibility(0);
                binding2.scheduleImpl.setImageDrawable(drawable2);
            }
        }
    }

    public final void isEditTextActivated(boolean isActivated) {
        Drawable PlaceComponentResult2;
        ViewCustomEditTextMyBillsBinding binding = getBinding();
        this.PlaceComponentResult = isActivated;
        ConstraintLayout constraintLayout = binding.getAuthRequestContext;
        if (isActivated) {
            PlaceComponentResult2 = ContextCompat.PlaceComponentResult(getContext(), R.drawable.bg_white_rounded_grey_border_8dp);
        } else {
            PlaceComponentResult2 = ContextCompat.PlaceComponentResult(getContext(), R.drawable.bg_grey_rounded_grey_border_8dp);
        }
        constraintLayout.setBackground(PlaceComponentResult2);
    }

    public static /* synthetic */ ViewCustomEditTextMyBillsBinding setErrorMessage$default(CustomEditTextView customEditTextView, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return customEditTextView.setErrorMessage(z, str);
    }

    public final ViewCustomEditTextMyBillsBinding setErrorMessage(boolean show, String msg) {
        int i;
        ViewCustomEditTextMyBillsBinding binding = getBinding();
        TextView textView = binding.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(show ? 0 : 8);
        binding.getErrorConfigVersion.setText(msg);
        if (binding.MyBillsEntityDataFactory.isEnabled()) {
            ConstraintLayout constraintLayout = binding.getAuthRequestContext;
            if (show) {
                i = R.drawable.bg_white_rounded_red_border_8dp;
            } else {
                i = R.drawable.bg_white_rounded_grey_border_8dp;
            }
            constraintLayout.setBackgroundResource(i);
        }
        return binding;
    }

    public final void setDisabled() {
        getBinding().MyBillsEntityDataFactory.setEnabled(false);
    }

    public final void setEnabled() {
        getBinding().MyBillsEntityDataFactory.setEnabled(true);
    }

    public final void setHint(String hintMessage) {
        Intrinsics.checkNotNullParameter(hintMessage, "");
        getBinding().MyBillsEntityDataFactory.setHint(hintMessage);
    }

    public final void setText(String text) {
        if (text != null) {
            getBinding().MyBillsEntityDataFactory.setText(text);
        }
    }

    public final void addTextChangeListener(final Function0<Unit> onTextChanged) {
        Intrinsics.checkNotNullParameter(onTextChanged, "");
        EditText editText = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.mybills.ui.customview.CustomEditTextView$addTextChangeListener$$inlined$doOnTextChanged$1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                Function0.this.invoke();
            }
        });
    }

    public final void setRightImage(int img) {
        AppCompatImageView appCompatImageView = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, img);
    }

    public final void setLeftImage(int img) {
        AppCompatImageView appCompatImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, img);
    }

    public final void setLabelText(String label) {
        Intrinsics.checkNotNullParameter(label, "");
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(label);
    }

    public final void setLeftTextIcon(int resIcon) {
        AppCompatImageView appCompatImageView = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, resIcon);
    }

    public final void setInputType(int type) {
        getBinding().MyBillsEntityDataFactory.setInputType(type);
    }

    public final String getText() {
        return getBinding().MyBillsEntityDataFactory.getText().toString();
    }

    public final void setOnEditTextClickListener(Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "");
        this.getAuthRequestContext = onClick;
    }

    /* renamed from: $r8$lambda$7QBUF6Yn-b1QJNwPgNi-KlxyIfc  reason: not valid java name */
    public static /* synthetic */ void m2679$r8$lambda$7QBUF6Ynb1QJNwPgNiKlxyIfc(ViewCustomEditTextMyBillsBinding viewCustomEditTextMyBillsBinding, View view, boolean z) {
        Intrinsics.checkNotNullParameter(viewCustomEditTextMyBillsBinding, "");
        if (z) {
            viewCustomEditTextMyBillsBinding.getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_yellow_border_8dp);
            return;
        }
        KeyboardHelper.getAuthRequestContext(view);
        viewCustomEditTextMyBillsBinding.getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_grey_border_8dp);
    }

    /* renamed from: $r8$lambda$X54r_RwRtdB4kEoSZ0so_ido-YU  reason: not valid java name */
    public static /* synthetic */ void m2680$r8$lambda$X54r_RwRtdB4kEoSZ0so_idoYU(ViewCustomEditTextMyBillsBinding viewCustomEditTextMyBillsBinding, CustomEditTextView customEditTextView, View view) {
        Intrinsics.checkNotNullParameter(viewCustomEditTextMyBillsBinding, "");
        Intrinsics.checkNotNullParameter(customEditTextView, "");
        viewCustomEditTextMyBillsBinding.MyBillsEntityDataFactory.setFocusable(true);
        if (customEditTextView.PlaceComponentResult) {
            customEditTextView.getAuthRequestContext.invoke();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0045). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = id.dana.mybills.ui.customview.CustomEditTextView.getAuthRequestContext
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 4
            r4 = 97
            r5 = 0
            if (r0 != 0) goto L15
            r6 = r2
            r4 = 4
            r7 = 97
            r8 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L45
        L15:
            r3 = r2
            r4 = 4
            r6 = 97
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            int r8 = r7 + 1
            byte r9 = (byte) r6
            r3[r7] = r9
            if (r8 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r5)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3a
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3a:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L3f:
            r7 = r2[r4]
            r10 = r6
            r6 = r3
            r3 = r7
            r7 = r10
        L45:
            int r3 = -r3
            int r7 = r7 + r3
            int r3 = r7 + (-8)
            int r4 = r4 + 1
            r7 = r8
            r10 = r6
            r6 = r3
            r3 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.customview.CustomEditTextView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
