package id.dana.pushverify.view.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewPushVerifyChallengeInfoBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/pushverify/view/richview/PushVerifyChallengeInfoView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewPushVerifyChallengeInfoBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewPushVerifyChallengeInfoBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "value", "setValue", "(Ljava/lang/String;)V", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushVerifyChallengeInfoView extends BaseViewBindingRichView<ViewPushVerifyChallengeInfoBinding> {
    public Map<Integer, View> _$_findViewCache;
    public static final byte[] MyBillsEntityDataFactory = {TarHeader.LF_LINK, 16, -25, 45, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 82;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushVerifyChallengeInfoView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushVerifyChallengeInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PushVerifyChallengeInfoView(Context context, AttributeSet attributeSet, int i) {
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
    public PushVerifyChallengeInfoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ PushVerifyChallengeInfoView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewPushVerifyChallengeInfoBinding inflateViewBinding() {
        ViewPushVerifyChallengeInfoBinding authRequestContext = ViewPushVerifyChallengeInfoBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (context == null || attrs == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.onLayoutDirectionChanged);
        try {
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 2);
            String string = obtainStyledAttributes.getString(3);
            if (string == null) {
                string = "";
            }
            String string2 = obtainStyledAttributes.getString(0);
            String str = string2 != null ? string2 : "";
            int color = obtainStyledAttributes.getColor(1, getBinding().PlaceComponentResult.getCurrentTextColor());
            ViewPushVerifyChallengeInfoBinding binding = getBinding();
            binding.KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d);
            binding.getAuthRequestContext.setText(string);
            binding.PlaceComponentResult.setText(str);
            binding.PlaceComponentResult.setTextColor(color);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void setValue(String value) {
        Intrinsics.checkNotNullParameter(value, "");
        getBinding().PlaceComponentResult.setText(value);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.pushverify.view.richview.PushVerifyChallengeInfoView.MyBillsEntityDataFactory
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 0
            r4 = 97
            r5 = 4
            if (r0 != 0) goto L15
            r5 = r2
            r6 = 23
            r7 = 4
            r8 = 0
            r2 = r0
            r0 = r11
            r11 = r10
            goto L47
        L15:
            r4 = r2
            r5 = 97
            r6 = 4
            r7 = 0
            r2 = r0
            r0 = r11
            r11 = r10
        L1d:
            byte r8 = (byte) r5
            r4[r7] = r8
            int r7 = r7 + 1
            if (r7 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3a
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3a:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L3f:
            r8 = r2[r6]
            r9 = r5
            r5 = r4
            r4 = r8
            r8 = r7
            r7 = r6
            r6 = r9
        L47:
            int r4 = -r4
            int r6 = r6 + r4
            int r4 = r7 + 1
            int r6 = r6 + (-8)
            r7 = r8
            r9 = r6
            r6 = r4
            r4 = r5
            r5 = r9
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.richview.PushVerifyChallengeInfoView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
