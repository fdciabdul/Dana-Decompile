package id.dana.core.ui.richview;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.R;
import id.dana.core.ui.databinding.ViewInputPhoneBinding;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.utils.DanaPhoneNumberUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00019B/\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u00105\u001a\u00020(\u0012\b\b\u0002\u00106\u001a\u00020(¢\u0006\u0004\b7\u00108J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J#\u0010\u0014\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\r\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0005J\u0015\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u0005J\u0017\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0003¢\u0006\u0004\b \u0010\u0005J\u0017\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b&\u0010\u001fJ\u001f\u0010*\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0003¢\u0006\u0004\b,\u0010\u0005J\u000f\u0010-\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010\u0005R\u0016\u00100\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u00101R\u0018\u0010\u000f\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010.\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00101"}, d2 = {"Lid/dana/core/ui/richview/InputPhoneView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/core/ui/databinding/ViewInputPhoneBinding;", "", "clearText", "()V", "", "getCompletePhoneNumber", "()Ljava/lang/String;", "Landroid/widget/EditText;", "getInput", "()Landroid/widget/EditText;", "getPrefix", "inflateViewBinding", "()Lid/dana/core/ui/databinding/ViewInputPhoneBinding;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setBackgroundIntoGrey", "setBackgroundIntoWhite", "", "editable", "setEditable", "(Z)V", "setErrorViewV2", "setPhoneNumber", "setInput", "(Ljava/lang/String;)V", "setNormalViewV2", "Lid/dana/textbehavior/OnValidatedListener;", "onValidatedListener", "setOnValidatedListener", "(Lid/dana/textbehavior/OnValidatedListener;)V", "prefixString", "setPrefix", "prefixNumber", "", "version", "setPrefixMissedCallOtp", "(Ljava/lang/String;I)V", "setSuccessViewV2", "setup", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Lid/dana/textbehavior/OnValidatedListener;", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InputPhoneView extends BaseViewBindingRichView<ViewInputPhoneBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private OnValidatedListener BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputPhoneView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputPhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputPhoneView(Context context, AttributeSet attributeSet, int i) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPhoneView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = 1;
    }

    public /* synthetic */ InputPhoneView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewInputPhoneBinding inflateViewBinding() {
        ViewInputPhoneBinding authRequestContext = ViewInputPhoneBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (r6 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r6 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r6.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        if (r4.PlaceComponentResult != 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        BuiltInFictitiousFunctionClassFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        getBinding().BuiltInFictitiousFunctionClassFactory.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, id.dana.core.ui.extension.ViewExtKt.getAuthRequestContext(44.0f)));
        getBinding().PlaceComponentResult.setBackground(null);
        getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(androidx.core.content.ContextCompat.PlaceComponentResult(getContext(), id.dana.core.ui.R.drawable.btn_common_white));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
    
        if (r4.MyBillsEntityDataFactory == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
    
        r6 = id.dana.core.ui.R.drawable.res_0x7f080ae3_networkuserentitydata_externalsyntheticlambda4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
    
        r6 = id.dana.core.ui.R.drawable.res_0x7f08091e_networkuserentitydata_externalsyntheticlambda8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0092, code lost:
    
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(androidx.core.content.ContextCompat.PlaceComponentResult(getContext(), r6));
        r6 = id.dana.textbehavior.TextBehavior.Builder.PlaceComponentResult(getBinding().getAuthRequestContext);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
    
        if (r4.MyBillsEntityDataFactory != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
    
        r6.getAuthRequestContext = new id.dana.textbehavior.manipulate.NoZeroFirstManipulator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
    
        r0 = new id.dana.core.ui.richview.InputPhoneView$parseAttrs$1(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c7, code lost:
    
        if (r6.BuiltInFictitiousFunctionClassFactory != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c9, code lost:
    
        r6.BuiltInFictitiousFunctionClassFactory = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d0, code lost:
    
        r6.BuiltInFictitiousFunctionClassFactory.add(r0);
        r6.MyBillsEntityDataFactory = new id.dana.core.ui.richview.InputPhoneView$parseAttrs$2(r5, r4);
        r6.KClassImpl$Data$declaredNonStaticMembers$2();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e1, code lost:
    
        return;
     */
    @Override // id.dana.core.ui.BaseViewBindingRichView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void parseAttrs(final android.content.Context r5, android.util.AttributeSet r6) {
        /*
            r4 = this;
            super.parseAttrs(r5, r6)
            r0 = 0
            r1 = 0
            if (r5 == 0) goto Le
            int[] r2 = id.dana.core.ui.R.styleable.connectForeground
            android.content.res.TypedArray r6 = r5.obtainStyledAttributes(r6, r2, r1, r1)
            goto Lf
        Le:
            r6 = r0
        Lf:
            java.lang.String r2 = "InputPhoneView"
            if (r6 == 0) goto L19
            int r3 = id.dana.core.ui.R.styleable.access$throwIllegalArgumentType     // Catch: java.lang.Exception -> L1c
            boolean r1 = r6.getBoolean(r3, r1)     // Catch: java.lang.Exception -> L1c
        L19:
            r4.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L1c
            goto L26
        L1c:
            r1 = move-exception
            java.lang.String r3 = r1.getMessage()
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            id.dana.utils.foundation.logger.log.DanaLog.BuiltInFictitiousFunctionClassFactory(r2, r3, r1)
        L26:
            r1 = 1
            if (r6 == 0) goto L2f
            int r3 = id.dana.core.ui.R.styleable.m     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            int r1 = r6.getInt(r3, r1)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
        L2f:
            r4.PlaceComponentResult = r1     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            if (r6 == 0) goto L47
            goto L44
        L34:
            r5 = move-exception
            goto Le2
        L37:
            r1 = move-exception
            java.lang.String r3 = r1.getMessage()     // Catch: java.lang.Throwable -> L34
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch: java.lang.Throwable -> L34
            id.dana.utils.foundation.logger.log.DanaLog.BuiltInFictitiousFunctionClassFactory(r2, r3, r1)     // Catch: java.lang.Throwable -> L34
            if (r6 != 0) goto L44
            goto L47
        L44:
            r6.recycle()
        L47:
            int r6 = r4.PlaceComponentResult
            r1 = 2
            if (r6 != r1) goto L50
            r4.BuiltInFictitiousFunctionClassFactory()
            goto L89
        L50:
            androidx.viewbinding.ViewBinding r6 = r4.getBinding()
            id.dana.core.ui.databinding.ViewInputPhoneBinding r6 = (id.dana.core.ui.databinding.ViewInputPhoneBinding) r6
            android.widget.FrameLayout r6 = r6.BuiltInFictitiousFunctionClassFactory
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = -1
            r3 = 1110441984(0x42300000, float:44.0)
            int r3 = id.dana.core.ui.extension.ViewExtKt.getAuthRequestContext(r3)
            r1.<init>(r2, r3)
            android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
            r6.setLayoutParams(r1)
            androidx.viewbinding.ViewBinding r6 = r4.getBinding()
            id.dana.core.ui.databinding.ViewInputPhoneBinding r6 = (id.dana.core.ui.databinding.ViewInputPhoneBinding) r6
            android.widget.LinearLayout r6 = r6.PlaceComponentResult
            r6.setBackground(r0)
            androidx.viewbinding.ViewBinding r6 = r4.getBinding()
            id.dana.core.ui.databinding.ViewInputPhoneBinding r6 = (id.dana.core.ui.databinding.ViewInputPhoneBinding) r6
            android.widget.FrameLayout r6 = r6.BuiltInFictitiousFunctionClassFactory
            android.content.Context r0 = r4.getContext()
            int r1 = id.dana.core.ui.R.drawable.btn_common_white
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.PlaceComponentResult(r0, r1)
            r6.setBackground(r0)
        L89:
            boolean r6 = r4.MyBillsEntityDataFactory
            if (r6 == 0) goto L90
            int r6 = id.dana.core.ui.R.drawable.res_0x7f080ae3_networkuserentitydata_externalsyntheticlambda4
            goto L92
        L90:
            int r6 = id.dana.core.ui.R.drawable.res_0x7f08091e_networkuserentitydata_externalsyntheticlambda8
        L92:
            androidx.viewbinding.ViewBinding r0 = r4.getBinding()
            id.dana.core.ui.databinding.ViewInputPhoneBinding r0 = (id.dana.core.ui.databinding.ViewInputPhoneBinding) r0
            androidx.appcompat.widget.AppCompatImageView r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
            android.content.Context r1 = r4.getContext()
            android.graphics.drawable.Drawable r6 = androidx.core.content.ContextCompat.PlaceComponentResult(r1, r6)
            r0.setImageDrawable(r6)
            androidx.viewbinding.ViewBinding r6 = r4.getBinding()
            id.dana.core.ui.databinding.ViewInputPhoneBinding r6 = (id.dana.core.ui.databinding.ViewInputPhoneBinding) r6
            android.widget.EditText r6 = r6.getAuthRequestContext
            id.dana.textbehavior.TextBehavior$EditTextBehaviorBuilder r6 = id.dana.textbehavior.TextBehavior.Builder.PlaceComponentResult(r6)
            boolean r0 = r4.MyBillsEntityDataFactory
            if (r0 != 0) goto Lbe
            id.dana.textbehavior.manipulate.NoZeroFirstManipulator r0 = new id.dana.textbehavior.manipulate.NoZeroFirstManipulator
            r0.<init>()
            id.dana.textbehavior.manipulate.Manipulator r0 = (id.dana.textbehavior.manipulate.Manipulator) r0
            r6.getAuthRequestContext = r0
        Lbe:
            id.dana.core.ui.richview.InputPhoneView$parseAttrs$1 r0 = new id.dana.core.ui.richview.InputPhoneView$parseAttrs$1
            r0.<init>()
            id.dana.textbehavior.validate.Validator r0 = (id.dana.textbehavior.validate.Validator) r0
            java.util.List<id.dana.textbehavior.validate.Validator> r1 = r6.BuiltInFictitiousFunctionClassFactory
            if (r1 != 0) goto Ld0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r6.BuiltInFictitiousFunctionClassFactory = r1
        Ld0:
            java.util.List<id.dana.textbehavior.validate.Validator> r1 = r6.BuiltInFictitiousFunctionClassFactory
            r1.add(r0)
            id.dana.core.ui.richview.InputPhoneView$parseAttrs$2 r0 = new id.dana.core.ui.richview.InputPhoneView$parseAttrs$2
            r0.<init>()
            id.dana.textbehavior.OnValidatedListener r0 = (id.dana.textbehavior.OnValidatedListener) r0
            r6.MyBillsEntityDataFactory = r0
            r6.KClassImpl$Data$declaredNonStaticMembers$2()
            return
        Le2:
            if (r6 == 0) goto Le7
            r6.recycle()
        Le7:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.richview.InputPhoneView.parseAttrs(android.content.Context, android.util.AttributeSet):void");
    }

    public final void setErrorViewV2() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.btn_common_white_border_red50));
    }

    public final void setSuccessViewV2() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.btn_common_white_border_green50));
        getBinding().MyBillsEntityDataFactory.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), R.drawable.SubSequence));
    }

    public final void setNormalViewV2() {
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setLayoutParams(new FrameLayout.LayoutParams(-1, ViewExtKt.getAuthRequestContext(52.0f)));
        getBinding().PlaceComponentResult.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f080534));
        getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.btn_common_white_border_grey20));
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        super.setup();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getResources().getInteger(R.integer.getAuthRequestContext);
        getBinding().getAuthRequestContext.setTransformationMethod(null);
    }

    public final String getPrefix() {
        return getBinding().lookAheadTest.getText().toString();
    }

    public final void setPrefix(String prefixString) {
        getBinding().lookAheadTest.setText(prefixString);
    }

    public final EditText getInput() {
        EditText editText = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        return editText;
    }

    public final void setInput(String setPhoneNumber) {
        getBinding().getAuthRequestContext.setText(setPhoneNumber);
    }

    public final void setEditable(boolean editable) {
        getBinding().getAuthRequestContext.setFocusable(editable);
        getBinding().getAuthRequestContext.setFocusableInTouchMode(editable);
        getBinding().getAuthRequestContext.setClickable(editable);
    }

    public final void setOnValidatedListener(OnValidatedListener onValidatedListener) {
        this.BuiltInFictitiousFunctionClassFactory = onValidatedListener;
    }

    public final String getCompletePhoneNumber() {
        String replace$default = StringsKt.replace$default(getBinding().getAuthRequestContext.getText().toString(), "-", "", false, 4, (Object) null);
        StringBuilder sb = new StringBuilder();
        sb.append(getPrefix());
        sb.append(replace$default);
        return sb.toString();
    }

    public final void setBackgroundIntoGrey() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.bg_grey_40_border_grey_20));
    }

    public final void setBackgroundIntoWhite() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.drawable.btn_common_white_border_grey20));
    }

    public final void clearText() {
        getBinding().getAuthRequestContext.getText().clear();
    }

    public static /* synthetic */ void setPrefixMissedCallOtp$default(InputPhoneView inputPhoneView, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        inputPhoneView.setPrefixMissedCallOtp(str, i);
    }

    public final void setPrefixMissedCallOtp(String prefixNumber, int version) {
        Intrinsics.checkNotNullParameter(prefixNumber, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), R.drawable.res_0x7f080ae3_networkuserentitydata_externalsyntheticlambda4));
        if (version == 2) {
            getBinding().lookAheadTest.setTextSize(2, 16.0f);
            Pair<String, String> BuiltInFictitiousFunctionClassFactory = DanaPhoneNumberUtil.BuiltInFictitiousFunctionClassFactory(prefixNumber);
            String component1 = BuiltInFictitiousFunctionClassFactory.component1();
            String component2 = BuiltInFictitiousFunctionClassFactory.component2();
            getBinding().lookAheadTest.setText(component1);
            AppCompatTextView appCompatTextView = getBinding().scheduleImpl;
            appCompatTextView.setTextSize(2, 24.0f);
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            ViewExtKt.MyBillsEntityDataFactory(appCompatTextView, Integer.valueOf(ViewExtKt.getAuthRequestContext(12.0f)), Integer.valueOf(ViewExtKt.getAuthRequestContext(10.0f)), Integer.valueOf(ViewExtKt.getAuthRequestContext(10.0f)), 4);
            appCompatTextView.setText(component2);
            getBinding().getAuthRequestContext.setHint("");
        } else {
            getBinding().lookAheadTest.setTextSize(2, 24.0f);
            getBinding().lookAheadTest.setText(DanaPhoneNumberUtil.MyBillsEntityDataFactory(prefixNumber));
            getBinding().getAuthRequestContext.setHint("XXXX");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 4;
        InputFilter[] filters = getBinding().getAuthRequestContext.getFilters();
        InputFilter[] inputFilterArr = new InputFilter[filters.length + 1];
        System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
        inputFilterArr[filters.length] = new InputFilter.LengthFilter(4);
        getBinding().getAuthRequestContext.setFilters(inputFilterArr);
    }
}
