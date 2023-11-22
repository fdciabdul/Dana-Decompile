package id.dana.animation.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseRichView;

@Deprecated
/* loaded from: classes5.dex */
public class NavigationTabView extends BaseRichView {
    public static final byte[] MyBillsEntityDataFactory = {71, Ascii.US, 113, 39, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int PlaceComponentResult = 213;
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;
    @BindView(R.id.cl_view_nav)
    RelativeLayout clViewNav;
    private String getAuthRequestContext;
    ImageView iconIv;
    @BindView(R.id.nav_tab_notif)
    TextView tabNotif;
    @BindView(R.id.nav_tab_title)
    TextView titleTv;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_nav_tab;
    }

    public NavigationTabView(Context context, int i, String str) {
        super(context);
        setIcon(i);
        setTitle(str);
    }

    public NavigationTabView(Context context, int i, String str, int i2, boolean z) {
        super(context);
        setIcon(i);
        setTitle(str);
        this.titleTv.setTextColor(i2);
        RelativeLayout relativeLayout = this.clViewNav;
        if (relativeLayout != null) {
            boolean z2 = !z;
            relativeLayout.setClickable(z2);
            this.clViewNav.setActivated(z2);
        }
    }

    public NavigationTabView(Context context) {
        super(context);
    }

    public NavigationTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NavigationTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NavigationTabView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setUnreadNotif(int i, boolean z) {
        Object obj;
        TextView textView = this.tabNotif;
        if (textView != null) {
            textView.setVisibility(8);
            if (i > 0) {
                TextView textView2 = this.tabNotif;
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    sb.append("+");
                    obj = sb.toString();
                } else {
                    obj = Integer.valueOf(i);
                }
                textView2.setText(String.valueOf(obj));
                this.tabNotif.setVisibility(0);
            }
        }
    }

    public boolean hasUnreadNotif() {
        TextView textView = this.tabNotif;
        return textView != null && textView.getVisibility() == 0;
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RepaymentPlan);
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 0);
                this.getAuthRequestContext = obtainStyledAttributes.getString(1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.iconIv = (ImageView) findViewById(R.id.nav_tab_icon);
        Drawable drawable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (drawable != null) {
            setIcon(drawable);
        }
        if (!TextUtils.isEmpty(this.getAuthRequestContext)) {
            setTitle(this.getAuthRequestContext);
        }
        setSelected(false);
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public void setIcon(int i) {
        InstrumentInjector.Resources_setImageResource(this.iconIv, i);
    }

    public void setIcon(Drawable drawable) {
        this.iconIv.setImageDrawable(drawable);
    }

    public TextView getTabTextView() {
        return this.titleTv;
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        ImageView imageView = this.iconIv;
        if (imageView != null) {
            imageView.setSelected(z);
        }
        if (getTabTextView() == null) {
            return;
        }
        getTabTextView().setSelected(z);
        if (Build.VERSION.SDK_INT >= 23) {
            getTabTextView().setTextAppearance(z ? R.style.f54062132017900 : R.style.f54072132017901);
        } else {
            getTabTextView().setTypeface(getTabTextView().getTypeface(), z ? 1 : 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:15:0x0044). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.animation.view.NavigationTabView.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 0
            r4 = 4
            if (r0 != 0) goto L15
            r5 = r1
            r6 = 4
            r7 = 0
            r8 = 22
            r1 = r0
            r0 = r11
            r11 = r10
            goto L44
        L15:
            r5 = 97
            r4 = r1
            r6 = 4
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1d:
            byte r8 = (byte) r5
            r4[r7] = r8
            if (r7 != r2) goto L3d
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L38
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L38:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L3d:
            r8 = r1[r6]
            int r7 = r7 + 1
            r9 = r5
            r5 = r4
            r4 = r9
        L44:
            int r8 = -r8
            int r4 = r4 + r8
            int r4 = r4 + (-8)
            int r6 = r6 + 1
            r9 = r5
            r5 = r4
            r4 = r9
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.view.NavigationTabView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
