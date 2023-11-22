package id.dana.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRichView;

/* loaded from: classes9.dex */
public class CustomNormalMenuView extends BaseRichView {
    private int BuiltInFictitiousFunctionClassFactory;
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;
    private String PlaceComponentResult;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.rl_icon)
    RelativeLayout rlIcon;
    @BindView(R.id.tv_menu_name)
    TextView tvMenuName;
    @BindView(R.id.tv_notif)
    TextView tvNotif;
    public static final byte[] getAuthRequestContext = {82, -89, -124, -60, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 120;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_custom_normal_menu;
    }

    public CustomNormalMenuView(Context context) {
        super(context);
    }

    public CustomNormalMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomNormalMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomNormalMenuView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        setIcon(this.KClassImpl$Data$declaredNonStaticMembers$2);
        setIconName(this.PlaceComponentResult);
        setTotalUnreadNotif(this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.b);
            try {
                this.PlaceComponentResult = obtainStyledAttributes.getString(1);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 0);
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getInt(2, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = drawable;
        this.ivIcon.setImageDrawable(drawable);
    }

    public void setIconName(String str) {
        this.PlaceComponentResult = str;
        this.tvMenuName.setText(str);
    }

    public void setTotalUnreadNotif(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.tvNotif.setVisibility(8);
        if (i > 0) {
            this.tvNotif.setText(String.valueOf(i));
            this.tvNotif.setVisibility(0);
        }
    }

    public void setNotifBackground(Drawable drawable) {
        if (drawable != null) {
            this.tvNotif.setBackground(drawable);
            this.tvNotif.setVisibility(0);
        }
    }

    public String getMenuName() {
        return this.PlaceComponentResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0042 -> B:15:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r9, int r10) {
        /*
            byte[] r0 = id.dana.richview.CustomNormalMenuView.getAuthRequestContext
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 4
            r4 = -1
            if (r0 != 0) goto L15
            r4 = r1
            r5 = -1
            r6 = 22
            r7 = 4
            r1 = r0
            r0 = r10
            r10 = r9
            goto L47
        L15:
            r5 = 97
            r3 = r1
            r4 = 4
            r5 = -1
            r6 = 97
            r1 = r0
            r0 = r10
            r10 = r9
        L1f:
            int r5 = r5 + 1
            byte r7 = (byte) r6
            r3[r5] = r7
            if (r5 != r2) goto L42
            java.lang.String r1 = new java.lang.String
            r2 = 0
            r1.<init>(r3, r2)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r9 = r1.isInstance(r9)
            if (r9 == 0) goto L3d
            android.content.Context r10 = (android.content.Context) r10
            android.graphics.drawable.Drawable r9 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r10, r0)
            return r9
        L3d:
            android.graphics.drawable.Drawable r9 = r10.getDrawable(r0)
            return r9
        L42:
            r7 = r1[r4]
            r8 = r4
            r4 = r3
            r3 = r8
        L47:
            int r3 = r3 + 1
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-8)
            r8 = r4
            r4 = r3
            r3 = r8
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.CustomNormalMenuView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
