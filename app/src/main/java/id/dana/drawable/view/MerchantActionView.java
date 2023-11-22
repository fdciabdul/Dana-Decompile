package id.dana.drawable.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRichView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 .2\u00020\u0001:\u0001.B'\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\b*\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0012\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u001d\b\u0002\u0010\u0011\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u000f¢\u0006\u0002\b\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001fR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010("}, d2 = {"Lid/dana/nearbyrevamp/view/MerchantActionView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lkotlin/Function0;", "onEnabled", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "onDisabled", "setOnActionClickListener", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "", "enabled", "setState", "(Z)V", "p0", "PlaceComponentResult", "(I)V", "setup", "()V", "getAuthRequestContext", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getErrorConfigVersion", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "scheduleImpl", "Z", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantActionView extends BaseRichView {
    public static final int ACTIVE = 1;
    public static final int ACTIVE_AZURE = 2;
    public static final int ACTIVE_STYLE_AZURE = 1;
    public static final int ACTIVE_STYLE_DEFAULT = 0;
    public static final int PASSIVE = 0;
    private String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Drawable BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Drawable PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int getAuthRequestContext;
    private boolean scheduleImpl;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_DIR, 93, -14, -126, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 77;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantActionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(CircleImageView circleImageView, int i) {
        if (circleImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(circleImageView, i);
        } else {
            circleImageView.setImageResource(i);
        }
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
        return R.layout.view_merchant_action;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantActionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantActionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context r2, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.onTooManyRedirects);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            try {
                this.getAuthRequestContext = obtainStyledAttributes.getInt(1, 0);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(0, 0);
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getString(4);
                this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 2);
                this.PlaceComponentResult = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 3);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        TextView textView;
        String str = this.MyBillsEntityDataFactory;
        if (str != null && (textView = (TextView) _$_findCachedViewById(R.id.addFixed32)) != null) {
            textView.setText(str);
        }
        getAuthRequestContext();
    }

    private final void getAuthRequestContext() {
        int i = this.getAuthRequestContext;
        this.scheduleImpl = i != 0;
        if (i == 0) {
            PlaceComponentResult(0);
            super.setEnabled(false);
        } else if (i == 1) {
            super.setEnabled(true);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                PlaceComponentResult(1);
            } else {
                PlaceComponentResult(2);
            }
        }
    }

    public final void setState(boolean enabled) {
        this.getAuthRequestContext = enabled ? 1 : 0;
        getAuthRequestContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnActionClickListener$default(MerchantActionView merchantActionView, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        merchantActionView.setOnActionClickListener(function0, function1);
    }

    public final void setOnActionClickListener(final Function0<Unit> onEnabled, final Function1<? super String, Unit> onDisabled) {
        Intrinsics.checkNotNullParameter(onEnabled, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.MultiLanguageHttpClient_res_0x7f0a032b);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.view.MerchantActionView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantActionView.$r8$lambda$xnE6lX_T2BBdKsZHz1vZUPdTCuY(MerchantActionView.this, onEnabled, onDisabled, view);
                }
            });
        }
    }

    private final void PlaceComponentResult(int p0) {
        if (p0 == 0) {
            CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.getRssi);
            if (circleImageView != null) {
                __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(circleImageView, R.color.f23942131099989);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.FSComposeAnnotatedString);
            if (appCompatImageView != null) {
                appCompatImageView.setImageDrawable(this.PlaceComponentResult);
            }
            TextView textView = (TextView) _$_findCachedViewById(R.id.addFixed32);
            if (textView != null) {
                textView.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23962131099992));
            }
        } else if (p0 == 1) {
            CircleImageView circleImageView2 = (CircleImageView) _$_findCachedViewById(R.id.getRssi);
            if (circleImageView2 != null) {
                __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(circleImageView2, R.color.f22892131099749);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.FSComposeAnnotatedString);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageDrawable(this.BuiltInFictitiousFunctionClassFactory);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.addFixed32);
            if (textView2 != null) {
                textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.azure));
            }
        } else if (p0 == 2) {
            CircleImageView circleImageView3 = (CircleImageView) _$_findCachedViewById(R.id.getRssi);
            if (circleImageView3 != null) {
                __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(circleImageView3, R.color.f22912131099753);
            }
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) _$_findCachedViewById(R.id.FSComposeAnnotatedString);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setImageDrawable(this.BuiltInFictitiousFunctionClassFactory);
            }
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.addFixed32);
            if (textView3 != null) {
                textView3.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.azure));
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$xnE6lX_T2BBdKsZHz1vZUPdTCuY(MerchantActionView merchantActionView, Function0 function0, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(merchantActionView, "");
        Intrinsics.checkNotNullParameter(function0, "");
        if (merchantActionView.scheduleImpl) {
            function0.invoke();
        } else if (function1 != null) {
            function1.invoke(String.valueOf(merchantActionView.MyBillsEntityDataFactory));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0044  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0044 -> B:31:0x0049). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r9, int r10) {
        /*
            byte[] r0 = id.dana.drawable.view.MerchantActionView.BuiltInFictitiousFunctionClassFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 97
            r4 = 3
            r5 = -1
            if (r0 != 0) goto L17
            r4 = r1
            r5 = 3
            r6 = -1
            r7 = 22
            r1 = r0
            r0 = r10
            r10 = r9
            goto L49
        L17:
            r3 = r1
            r4 = 97
            r5 = 3
            r6 = -1
            r1 = r0
            r0 = r10
            r10 = r9
        L1f:
            int r6 = r6 + 1
            int r5 = r5 + 1
            byte r7 = (byte) r4
            r3[r6] = r7
            if (r6 != r2) goto L44
            java.lang.String r1 = new java.lang.String
            r2 = 0
            r1.<init>(r3, r2)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r9 = r1.isInstance(r9)
            if (r9 == 0) goto L3f
            android.content.Context r10 = (android.content.Context) r10
            android.graphics.drawable.Drawable r9 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r10, r0)
            return r9
        L3f:
            android.graphics.drawable.Drawable r9 = r10.getDrawable(r0)
            return r9
        L44:
            r7 = r1[r5]
            r8 = r4
            r4 = r3
            r3 = r8
        L49:
            int r3 = r3 + r7
            int r3 = r3 + (-8)
            r8 = r4
            r4 = r3
            r3 = r8
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.view.MerchantActionView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
