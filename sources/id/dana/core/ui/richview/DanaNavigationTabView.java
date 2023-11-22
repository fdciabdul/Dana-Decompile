package id.dana.core.ui.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.R;
import id.dana.core.ui.databinding.ViewNavigationTabBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b.\u0010/B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b.\u00100B\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b.\u0010\u0011B#\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u00101\u001a\u00020\u0016¢\u0006\u0004\b.\u00102B+\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u00101\u001a\u00020\u0016\u0012\u0006\u00103\u001a\u00020\u0016¢\u0006\u0004\b.\u00104J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010&\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/core/ui/richview/DanaNavigationTabView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/core/ui/databinding/ViewNavigationTabBinding;", "Landroid/widget/TextView;", "getTabTextView", "()Landroid/widget/TextView;", "", "hasUnreadNotif", "()Z", "inflateViewBinding", "()Lid/dana/core/ui/databinding/ViewNavigationTabBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "drawableRes", "(I)V", "selected", "setSelected", "(Z)V", "", "title", GriverEvents.EVENT_SET_TITLE, "(Ljava/lang/String;)V", "counter", "hasMore", "setUnreadNotif", "(IZ)V", "setup", "()V", "PlaceComponentResult", "Landroid/graphics/drawable/Drawable;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/res/TypedArray;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/res/TypedArray;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;ILjava/lang/String;)V", "(Landroid/content/Context;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class DanaNavigationTabView extends BaseViewBindingRichView<ViewNavigationTabBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private TypedArray PlaceComponentResult;
    private String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Drawable BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    public static final byte[] getAuthRequestContext = {Ascii.RS, 119, -63, 113, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 61;

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public View _$_findCachedViewById(int i) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaNavigationTabView(Context context, int i, String str) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        setIcon(i);
        setTitle(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaNavigationTabView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaNavigationTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaNavigationTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaNavigationTabView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public ViewNavigationTabBinding inflateViewBinding() {
        ViewNavigationTabBinding BuiltInFictitiousFunctionClassFactory2 = ViewNavigationTabBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        return BuiltInFictitiousFunctionClassFactory2;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] iArr = R.styleable.S;
            Intrinsics.checkNotNullExpressionValue(iArr, "");
            if (context != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, 0, 0);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
                this.PlaceComponentResult = obtainStyledAttributes;
            }
            TypedArray typedArray = null;
            try {
                TypedArray typedArray2 = this.PlaceComponentResult;
                if (typedArray2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray2 = null;
                }
                this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(typedArray2, R.styleable.U);
                TypedArray typedArray3 = this.PlaceComponentResult;
                if (typedArray3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray3 = null;
                }
                String string = typedArray3.getString(R.styleable.V);
                if (string == null) {
                    string = "";
                }
                this.MyBillsEntityDataFactory = string;
            } finally {
                TypedArray typedArray4 = this.PlaceComponentResult;
                if (typedArray4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    typedArray = typedArray4;
                }
                typedArray.recycle();
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public void setup() {
        Drawable drawable = this.BuiltInFictitiousFunctionClassFactory;
        if (drawable != null) {
            setIcon(drawable);
        }
        String str = this.MyBillsEntityDataFactory;
        if (str == null) {
            str = "";
        }
        setTitle(str);
    }

    public final void setUnreadNotif(int counter, boolean hasMore) {
        String obj;
        TextView textView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(counter > 0 ? 0 : 8);
        TextView textView2 = getBinding().MyBillsEntityDataFactory;
        if (hasMore) {
            StringBuilder sb = new StringBuilder();
            sb.append(counter);
            sb.append('+');
            obj = sb.toString();
        } else {
            obj = String.valueOf(counter);
        }
        textView2.setText(obj);
    }

    public final boolean hasUnreadNotif() {
        TextView textView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        return textView.getVisibility() == 0;
    }

    public final void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "");
        getBinding().getAuthRequestContext.setText(title);
    }

    public final void setIcon(int drawableRes) {
        InstrumentInjector.Resources_setImageResource(getBinding().KClassImpl$Data$declaredNonStaticMembers$2, drawableRes);
    }

    public final void setIcon(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(drawable);
    }

    public final TextView getTabTextView() {
        TextView textView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        return textView;
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setSelected(selected);
        getTabTextView().setSelected(selected);
        if (Build.VERSION.SDK_INT >= 23) {
            getTabTextView().setTextAppearance(selected ? R.style.BuiltInFictitiousFunctionClassFactory : R.style.PlaceComponentResult);
        } else {
            getTabTextView().setTypeface(getTabTextView().getTypeface(), selected ? 1 : 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0044). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = id.dana.core.ui.richview.DanaNavigationTabView.getAuthRequestContext
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 0
            r4 = 97
            r5 = 4
            if (r0 != 0) goto L15
            r5 = r2
            r6 = 4
            r7 = 23
            r9 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L44
        L15:
            r4 = r2
            r5 = 97
            r6 = 4
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            byte r8 = (byte) r5
            int r9 = r7 + 1
            r4[r7] = r8
            if (r9 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
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
            r7 = r2[r6]
            r10 = r5
            r5 = r4
            r4 = r10
        L44:
            int r4 = r4 + r7
            int r4 = r4 + (-8)
            int r6 = r6 + 1
            r7 = r9
            r10 = r5
            r5 = r4
            r4 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.richview.DanaNavigationTabView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
