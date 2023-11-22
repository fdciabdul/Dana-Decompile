package id.dana.component.buttoncomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import id.dana.component.R;

/* loaded from: classes4.dex */
public class DanaButtonGhostView extends BaseDanaButton {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {116, 58, -28, -63, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 161;
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;
    private int PlaceComponentResult;
    ConstraintLayout containerView;
    private String getAuthRequestContext;
    private String getErrorConfigVersion;
    ImageView iconButtonCenter;
    private int lookAheadTest;
    TextView titleButtonCenter;

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonLeftAlignWithAmount(String str, String str2) {
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonLeftAlignWithIcon(String str, Drawable drawable) {
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonWithIcon(String str, Drawable drawable) {
    }

    public DanaButtonGhostView(Context context) {
        super(context);
    }

    public DanaButtonGhostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanaButtonGhostView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.component.BaseRichView
    public int getLayout() {
        return R.layout.view_dana_button_ghost;
    }

    @Override // id.dana.component.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.M, 0, 0);
            try {
                this.PlaceComponentResult = obtainStyledAttributes.getInt(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda0, 0);
                this.getAuthRequestContext = obtainStyledAttributes.getString(R.styleable.L);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.K);
                this.lookAheadTest = obtainStyledAttributes.getInt(R.styleable.J, 0);
                this.getErrorConfigVersion = obtainStyledAttributes.getString(R.styleable.Q);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setDanaButtonView(int i, String str, Drawable drawable) {
        if (i == 0) {
            setDisabled(str);
        } else if (i == 1) {
            setActiveButton(str, drawable);
        } else if (i == 5) {
            setError(str);
        }
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButton(String str, Drawable drawable) {
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setVisibility(0);
        this.titleButtonCenter.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult));
        this.iconButtonCenter.setVisibility(0);
        this.iconButtonCenter.setImageDrawable(drawable);
        this.iconButtonCenter.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult), PorterDuff.Mode.SRC_IN);
        vallidateSize(this.lookAheadTest, this.containerView, this.titleButtonCenter);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setError(String str) {
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.lookAheadTest));
        this.titleButtonCenter.setVisibility(0);
        vallidateSize(this.lookAheadTest, this.containerView, this.titleButtonCenter);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setDisabled(String str) {
        this.containerView.setBackground(null);
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.MyBillsEntityDataFactory));
        this.titleButtonCenter.setVisibility(0);
        vallidateSize(this.lookAheadTest, this.containerView, this.titleButtonCenter);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setButtonContentDescription(String str) {
        this.containerView.setContentDescription(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0046). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = id.dana.component.buttoncomponent.DanaButtonGhostView.BuiltInFictitiousFunctionClassFactory
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 97
            r4 = 0
            r5 = 3
            if (r0 != 0) goto L15
            r5 = r2
            r6 = 3
            r7 = 23
            r8 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L46
        L15:
            r3 = r2
            r5 = 97
            r6 = 3
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            int r8 = r7 + 1
            byte r9 = (byte) r5
            r3[r7] = r9
            if (r8 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
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
            int r6 = r6 + 1
            r7 = r2[r6]
            r10 = r5
            r5 = r3
            r3 = r10
        L46:
            int r7 = -r7
            int r3 = r3 + r7
            int r3 = r3 + (-8)
            r7 = r8
            r10 = r5
            r5 = r3
            r3 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.component.buttoncomponent.DanaButtonGhostView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    @Override // id.dana.component.BaseRichView
    public void setup() {
        this.containerView = (ConstraintLayout) getRootView().findViewById(R.id.cl_container_dana_button_ghost_view);
        this.titleButtonCenter = (TextView) getRootView().findViewById(R.id.res_0x7f0a1919_summaryvoucherview_externalsyntheticlambda1);
        this.iconButtonCenter = (ImageView) getRootView().findViewById(R.id.iv_icon_center);
        this.containerView.setContentDescription(this.getErrorConfigVersion);
        setDanaButtonView(this.PlaceComponentResult, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
