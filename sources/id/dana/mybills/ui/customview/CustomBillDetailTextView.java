package id.dana.mybills.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.messaging.Constants;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.mybills.databinding.ViewCustomBillDetailBinding;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.util.RaspUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010)\u001a\u00020\u0015¢\u0006\u0004\b*\u0010+B+\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010)\u001a\u00020\u0015\u0012\u0006\u0010,\u001a\u00020\u0015¢\u0006\u0004\b*\u0010-J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u0014J\u001b\u0010\u001c\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0011\u0010(\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\b&\u0010'"}, d2 = {"Lid/dana/mybills/ui/customview/CustomBillDetailTextView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewCustomBillDetailBinding;", "", "getContent", "()Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/mybills/databinding/ViewCustomBillDetailBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", Constants.ScionAnalytics.PARAM_LABEL, "description", "setCustomBillDetail", "(Ljava/lang/String;Ljava/lang/String;)V", "setDesc", "(Ljava/lang/String;)V", "", "icon", "setDescIcon", "(Ljava/lang/Integer;)V", "setLabel", "Lkotlin/Function0;", "onClickIcon", "setOnClickDescIcon", "(Lkotlin/jvm/functions/Function0;)V", "setup", "()V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getAuthRequestContext", "Landroid/widget/TextView;", "getTvLabel", "()Landroid/widget/TextView;", "tvLabel", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomBillDetailTextView extends BaseViewBindingRichView<ViewCustomBillDetailBinding> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {35359, 35739, 35738, 35738, 35440, 35417};
    private static int MyBillsEntityDataFactory = 1;
    private static int getAuthRequestContext;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String getAuthRequestContext;

    public static /* synthetic */ void $r8$lambda$CluQrTVNzWGRpEPleBmFLDu9CTA(Function0 function0, View view) {
        int i = getAuthRequestContext + 31;
        MyBillsEntityDataFactory = i % 128;
        try {
            if ((i % 2 == 0 ? ';' : ')') != ';') {
                KClassImpl$Data$declaredNonStaticMembers$2(function0);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2(function0);
                int i2 = 97 / 0;
            }
            int i3 = MyBillsEntityDataFactory + 105;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomBillDetailTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomBillDetailTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        try {
            Intrinsics.checkNotNullParameter(context, "");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        int i2 = MyBillsEntityDataFactory + 41;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        if (!(appCompatImageView instanceof ImageView)) {
            appCompatImageView.setImageResource(i);
            return;
        }
        int i4 = getAuthRequestContext + 67;
        MyBillsEntityDataFactory = i4 % 128;
        try {
            try {
                if (!(i4 % 2 == 0)) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                    return;
                }
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getTvLabel")
    public final TextView getTvLabel() {
        while (true) {
            int i = getAuthRequestContext + 51;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final /* synthetic */ ViewCustomBillDetailBinding inflateViewBinding() {
        ViewCustomBillDetailBinding inflateViewBinding;
        int i = getAuthRequestContext + 93;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? 'T' : '7') != '7') {
            inflateViewBinding = inflateViewBinding();
            Object obj = null;
            obj.hashCode();
        } else {
            inflateViewBinding = inflateViewBinding();
        }
        int i2 = MyBillsEntityDataFactory + 5;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return inflateViewBinding;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ CustomBillDetailTextView(android.content.Context r2, android.util.AttributeSet r3, int r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r1 = this;
            r6 = r5 & 2
            r0 = 0
            if (r6 == 0) goto L18
            int r3 = id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory
            int r3 = r3 + 63
            int r6 = r3 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext = r6
            int r3 = r3 % 2
            if (r3 == 0) goto L17
            r0.hashCode()     // Catch: java.lang.Throwable -> L15
            goto L17
        L15:
            r2 = move-exception
            throw r2
        L17:
            r3 = r0
        L18:
            r5 = r5 & 4
            r6 = 82
            if (r5 == 0) goto L21
            r5 = 8
            goto L23
        L21:
            r5 = 82
        L23:
            if (r5 == r6) goto L3d
            int r4 = id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext
            int r4 = r4 + 97
            int r5 = r4 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory = r5
            int r4 = r4 % 2
            r5 = 31
            if (r4 != 0) goto L36
            r4 = 31
            goto L38
        L36:
            r4 = 10
        L38:
            if (r4 == r5) goto L3c
            r4 = 0
            goto L3d
        L3c:
            r4 = 1
        L3d:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.customview.CustomBillDetailTextView.<init>(android.content.Context, android.util.AttributeSet, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomBillDetailTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomBillDetailTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCustomBillDetailBinding inflateViewBinding() {
        ViewCustomBillDetailBinding BuiltInFictitiousFunctionClassFactory;
        int i = getAuthRequestContext + 23;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            BuiltInFictitiousFunctionClassFactory = ViewCustomBillDetailBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        } else {
            try {
                try {
                    BuiltInFictitiousFunctionClassFactory = ViewCustomBillDetailBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
                    Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                    int i2 = 90 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = MyBillsEntityDataFactory + 3;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:
    
        if ((r5 == null) != true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x001e, code lost:
    
        if (r4 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0020, code lost:
    
        r2 = 18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        r2 = '#';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:
    
        if (r2 == '#') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0027, code lost:
    
        r0 = id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory + 49;
        id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0031, code lost:
    
        r4 = r4.getTheme();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        if (r4 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        r2 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        r2 = '\n';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        if (r2 == ';') goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        r4 = r4.obtainStyledAttributes(r5, id.dana.mybills.R.styleable.J, 0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0049, code lost:
    
        r3.getAuthRequestContext = r4.getString(id.dana.mybills.R.styleable.P);
        r3.KClassImpl$Data$declaredNonStaticMembers$2 = r4.getString(id.dana.mybills.R.styleable.Q);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        r4.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0063, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r5 != null) goto L16;
     */
    @Override // id.dana.core.ui.BaseViewBindingRichView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void parseAttrs(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            int r0 = id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext     // Catch: java.lang.Exception -> L6f
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L6f
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L14
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L12
            if (r5 == 0) goto L64
            goto L1c
        L12:
            r4 = move-exception
            throw r4
        L14:
            r0 = 1
            if (r5 == 0) goto L19
            r2 = 0
            goto L1a
        L19:
            r2 = 1
        L1a:
            if (r2 == r0) goto L64
        L1c:
            r0 = 35
            if (r4 == 0) goto L23
            r2 = 18
            goto L25
        L23:
            r2 = 35
        L25:
            if (r2 == r0) goto L64
            int r0 = id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory
            int r0 = r0 + 49
            int r2 = r0 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext = r2
            int r0 = r0 % 2
            android.content.res.Resources$Theme r4 = r4.getTheme()     // Catch: java.lang.Exception -> L62
            r0 = 59
            if (r4 == 0) goto L3c
            r2 = 59
            goto L3e
        L3c:
            r2 = 10
        L3e:
            if (r2 == r0) goto L41
            goto L64
        L41:
            int[] r0 = id.dana.mybills.R.styleable.J     // Catch: java.lang.Exception -> L62
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r0, r1, r1)     // Catch: java.lang.Exception -> L62
            if (r4 == 0) goto L64
            int r5 = id.dana.mybills.R.styleable.P     // Catch: java.lang.Throwable -> L5d
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L5d
            r3.getAuthRequestContext = r5     // Catch: java.lang.Throwable -> L5d
            int r5 = id.dana.mybills.R.styleable.Q     // Catch: java.lang.Throwable -> L5d
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L5d
            r3.KClassImpl$Data$declaredNonStaticMembers$2 = r5     // Catch: java.lang.Throwable -> L5d
            r4.recycle()
            return
        L5d:
            r5 = move-exception
            r4.recycle()
            throw r5
        L62:
            r4 = move-exception
            throw r4
        L64:
            int r4 = id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext
            int r4 = r4 + 19
            int r5 = r4 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory = r5
            int r4 = r4 % 2
            return
        L6f:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.customview.CustomBillDetailTextView.parseAttrs(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        try {
            int i = MyBillsEntityDataFactory + 105;
            getAuthRequestContext = i % 128;
            Object[] objArr = null;
            if ((i % 2 != 0 ? ';' : 'O') != 'O') {
                setCustomBillDetail(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
                int length = objArr.length;
            } else {
                setCustomBillDetail(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            int i2 = getAuthRequestContext + 33;
            MyBillsEntityDataFactory = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 4 : '@') != '@') {
                objArr.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final void setCustomBillDetail(String label, String description) {
        int i = MyBillsEntityDataFactory + 17;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? (char) 25 : Typography.quote) != '\"') {
            setLabel(label);
            setDesc(description);
            int i2 = 25 / 0;
            return;
        }
        setLabel(label);
        setDesc(description);
    }

    public final String getContent() {
        int i = MyBillsEntityDataFactory + 123;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            String obj = getBinding().BuiltInFictitiousFunctionClassFactory.getText().toString();
            Object[] objArr = null;
            int length = objArr.length;
            return obj;
        }
        return getBinding().BuiltInFictitiousFunctionClassFactory.getText().toString();
    }

    public final void setLabel(String label) {
        int i = MyBillsEntityDataFactory + 111;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (label != null) {
            getBinding().getAuthRequestContext.setText(label);
            int i3 = MyBillsEntityDataFactory + 55;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setDesc(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory
            int r0 = r0 + 27
            int r1 = r0 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext = r1
            int r0 = r0 % 2
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.mybills.databinding.ViewCustomBillDetailBinding r0 = (id.dana.mybills.databinding.ViewCustomBillDetailBinding) r0
            androidx.appcompat.widget.LinearLayoutCompat r0 = r0.PlaceComponentResult
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r1 = 1
            r2 = 0
            if (r6 == 0) goto L21
            r3 = 0
            goto L22
        L21:
            r3 = 1
        L22:
            if (r3 == 0) goto L25
            goto L30
        L25:
            int r3 = r6.length()
            if (r3 == 0) goto L2d
            r3 = 0
            goto L2e
        L2d:
            r3 = 1
        L2e:
            if (r3 == 0) goto L32
        L30:
            r3 = 1
            goto L47
        L32:
            int r3 = id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext
            int r3 = r3 + 103
            int r4 = r3 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory = r4
            int r3 = r3 % 2
            int r3 = id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext
            int r3 = r3 + 117
            int r4 = r3 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory = r4
            int r3 = r3 % 2
            r3 = 0
        L47:
            r1 = r1 ^ r3
            r3 = 99
            if (r1 == 0) goto L4f
            r1 = 99
            goto L51
        L4f:
            r1 = 87
        L51:
            if (r1 == r3) goto L56
            r2 = 8
            goto L60
        L56:
            int r1 = id.dana.mybills.ui.customview.CustomBillDetailTextView.getAuthRequestContext     // Catch: java.lang.Exception -> L6f
            int r1 = r1 + 53
            int r3 = r1 % 128
            id.dana.mybills.ui.customview.CustomBillDetailTextView.MyBillsEntityDataFactory = r3     // Catch: java.lang.Exception -> L6f
            int r1 = r1 % 2
        L60:
            r0.setVisibility(r2)
            androidx.viewbinding.ViewBinding r0 = r5.getBinding()
            id.dana.mybills.databinding.ViewCustomBillDetailBinding r0 = (id.dana.mybills.databinding.ViewCustomBillDetailBinding) r0
            android.widget.TextView r0 = r0.BuiltInFictitiousFunctionClassFactory
            r0.setText(r6)
            return
        L6f:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.customview.CustomBillDetailTextView.setDesc(java.lang.String):void");
    }

    public final void setDescIcon(Integer icon) {
        AppCompatImageView appCompatImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(icon == null)) {
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(0);
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, icon.intValue());
            int i = getAuthRequestContext + 25;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            return;
        }
        int i3 = getAuthRequestContext + 81;
        MyBillsEntityDataFactory = i3 % 128;
        if (!(i3 % 2 == 0)) {
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(8);
        } else {
            try {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(120);
            } catch (Exception e) {
                throw e;
            }
        }
        int i4 = getAuthRequestContext + 47;
        MyBillsEntityDataFactory = i4 % 128;
        int i5 = i4 % 2;
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(Function0 function0) {
        try {
            int i = MyBillsEntityDataFactory + 91;
            getAuthRequestContext = i % 128;
            if ((i % 2 != 0 ? ';' : '*') != ';') {
                Intrinsics.checkNotNullParameter(function0, "");
                function0.invoke();
                return;
            }
            Intrinsics.checkNotNullParameter(function0, "");
            function0.invoke();
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public final void setOnClickDescIcon(final Function0<Unit> onClickIcon) {
        Intrinsics.checkNotNullParameter(onClickIcon, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.CustomBillDetailTextView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomBillDetailTextView.$r8$lambda$CluQrTVNzWGRpEPleBmFLDu9CTA(Function0.this, view);
            }
        });
        int i = MyBillsEntityDataFactory + 95;
        getAuthRequestContext = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static void $$a(long j, long j2) {
        long j3 = j ^ (j2 << 32);
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        a(new int[]{0, 6, 154, 0}, false, new byte[]{1, 1, 0, 1, 1, 0}, objArr);
        sb.append((String) objArr[0]);
        sb.append(j3);
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
        RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
        Intrinsics.checkNotNullParameter(dexguardException, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(dexguardException);
        RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.HOOKED);
        UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.HOOKED);
        int i = getAuthRequestContext + 43;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 != 0) {
            return;
        }
        int i2 = 88 / 0;
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        int i;
        int i2;
        int length;
        char[] cArr;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        try {
            char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (cArr2 != null) {
                int i7 = $10 + 105;
                $11 = i7 % 128;
                if (i7 % 2 == 0) {
                    length = cArr2.length;
                    cArr = new char[length];
                } else {
                    length = cArr2.length;
                    cArr = new char[length];
                }
                for (int i8 = 0; i8 < length; i8++) {
                    cArr[i8] = (char) (cArr2[i8] ^ 5097613533456403102L);
                }
                cArr2 = cArr;
            }
            char[] cArr3 = new char[i4];
            System.arraycopy(cArr2, i3, cArr3, 0, i4);
            if (bArr != null) {
                char[] cArr4 = new char[i4];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                char c = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                    int i9 = $11 + 67;
                    $10 = i9 % 128;
                    int i10 = i9 % 2;
                    if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? '=' : (char) 27) != 27) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    try {
                        c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                cArr3 = cArr4;
            }
            if (i6 > 0) {
                char[] cArr5 = new char[i4];
                System.arraycopy(cArr3, 0, cArr5, 0, i4);
                int i11 = i4 - i6;
                System.arraycopy(cArr5, 0, cArr3, i11, i6);
                System.arraycopy(cArr5, i6, cArr3, 0, i11);
            }
            if (z) {
                int i12 = $10 + 77;
                $11 = i12 % 128;
                int i13 = i12 % 2;
                char[] cArr6 = new char[i4];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                    int i14 = $10 + 115;
                    $11 = i14 % 128;
                    if (i14 % 2 == 0) {
                        cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory * i4) << 1];
                        i2 = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory % 1;
                    } else {
                        cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i4 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                        i2 = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + 1;
                    }
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = i2;
                }
                int i15 = $10 + 11;
                $11 = i15 % 128;
                int i16 = i15 % 2;
                cArr3 = cArr6;
            }
            if (i5 > 0) {
                int i17 = $11 + 63;
                $10 = i17 % 128;
                if ((i17 % 2 != 0 ? '%' : (char) 11) != 11) {
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 1;
                } else {
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                }
                while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                    int i18 = $11 + 63;
                    $10 = i18 % 128;
                    if ((i18 % 2 != 0 ? '@' : 'a') != 'a') {
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] >> iArr[3]);
                        i = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory * 1;
                    } else {
                        cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                        i = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + 1;
                    }
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = i;
                }
            }
            objArr[0] = new String(cArr3);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
