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
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.component.R;

/* loaded from: classes2.dex */
public class DanaButtonPrimaryView extends BaseDanaButton {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {59, -103, 22, 57, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int getAuthRequestContext = 149;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private Drawable MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String PlaceComponentResult;
    TextView amountButton;
    TextView amountValueButtonCenter;
    ConstraintLayout containerButtonAmountCenter;
    ConstraintLayout containerView;
    ImageView iconButton;
    private int lookAheadTest;
    private String scheduleImpl;
    TextView titleButtonAmountCenter;
    TextView titleButtonCenter;
    TextView titleButtonLeft;

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setError(String str) {
    }

    public DanaButtonPrimaryView(Context context) {
        super(context);
    }

    public DanaButtonPrimaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanaButtonPrimaryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.component.BaseRichView
    public int getLayout() {
        return R.layout.res_0x7f0d04e5_networkuserentitydata_externalsyntheticlambda0;
    }

    @Override // id.dana.component.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.P, 0, 0);
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getInt(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda2, 0);
                this.PlaceComponentResult = obtainStyledAttributes.getString(R.styleable.S);
                this.MyBillsEntityDataFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.N);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getString(R.styleable.O);
                this.lookAheadTest = obtainStyledAttributes.getInt(R.styleable.R, 0);
                this.scheduleImpl = obtainStyledAttributes.getString(R.styleable.SummaryVoucherView$$ExternalSyntheticLambda1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setDanaButtonView(int i, String str, String str2, Drawable drawable) {
        switch (i) {
            case 0:
                setDisabled(str);
                return;
            case 1:
                setActiveButton(str, drawable);
                return;
            case 2:
                setActiveButtonWithIcon(str, drawable);
                return;
            case 3:
                setActiveButtonLeftAlignWithAmount(str, str2);
                return;
            case 4:
                setActiveButtonLeftAlignWithIcon(str, drawable);
                return;
            case 5:
                setDisabledWithAmount(str, str2);
                return;
            case 6:
                setActiveButtonWithCenterAmount(str, str2);
                return;
            case 7:
                setDisableButtonWithCenterAmount(str, str2);
                return;
            default:
                return;
        }
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButton(String str, Drawable drawable) {
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setVisibility(0);
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_primary_active);
        this.amountButton.setVisibility(4);
        this.titleButtonLeft.setVisibility(4);
        this.iconButton.setVisibility(4);
        this.containerButtonAmountCenter.setVisibility(4);
        vallidateSize(this.lookAheadTest, this.containerView, this.titleButtonCenter);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonWithIcon(String str, Drawable drawable) {
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setVisibility(0);
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_primary_active);
        this.iconButton.setImageDrawable(drawable);
        this.iconButton.setVisibility(0);
        this.iconButton.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.scheduleImpl), PorterDuff.Mode.SRC_IN);
        this.titleButtonLeft.setVisibility(4);
        this.amountButton.setVisibility(4);
        this.containerButtonAmountCenter.setVisibility(4);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonLeftAlignWithAmount(String str, String str2) {
        this.titleButtonLeft.setText(str);
        this.titleButtonLeft.setVisibility(0);
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_primary_active);
        this.amountButton.setText(str2);
        this.amountButton.setVisibility(0);
        this.titleButtonCenter.setVisibility(4);
        this.iconButton.setVisibility(4);
        this.containerButtonAmountCenter.setVisibility(4);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonLeftAlignWithIcon(String str, Drawable drawable) {
        this.titleButtonLeft.setText(str);
        this.titleButtonLeft.setVisibility(0);
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_primary_active);
        this.iconButton.setImageDrawable(drawable);
        this.iconButton.setVisibility(0);
        this.amountButton.setVisibility(4);
        this.titleButtonCenter.setVisibility(4);
        this.containerButtonAmountCenter.setVisibility(4);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setDisabled(String str) {
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setVisibility(0);
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_primary_disabled);
        this.iconButton.setVisibility(4);
        this.amountButton.setVisibility(4);
        this.titleButtonLeft.setVisibility(4);
        this.containerButtonAmountCenter.setVisibility(4);
        vallidateSize(this.lookAheadTest, this.containerView, this.titleButtonCenter);
    }

    public void setDisabledWithAmount(String str, String str2) {
        this.titleButtonLeft.setText(str);
        this.titleButtonLeft.setVisibility(0);
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_primary_disabled);
        this.amountButton.setText(str2);
        this.amountButton.setVisibility(0);
        this.titleButtonCenter.setVisibility(4);
        this.iconButton.setVisibility(4);
        this.containerButtonAmountCenter.setVisibility(4);
    }

    public void setActiveButtonWithCenterAmount(String str, String str2) {
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_primary_active);
        this.titleButtonAmountCenter.setText(str);
        this.amountValueButtonCenter.setText(str2);
        this.containerButtonAmountCenter.setVisibility(0);
        this.titleButtonCenter.setVisibility(4);
        this.titleButtonLeft.setVisibility(4);
        this.iconButton.setVisibility(4);
        this.amountButton.setVisibility(4);
    }

    public void setDisableButtonWithCenterAmount(String str, String str2) {
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_primary_disabled);
        this.titleButtonAmountCenter.setText(str);
        this.amountValueButtonCenter.setText(str2);
        this.containerButtonAmountCenter.setVisibility(0);
        this.titleButtonCenter.setVisibility(4);
        this.titleButtonLeft.setVisibility(4);
        this.iconButton.setVisibility(4);
        this.amountButton.setVisibility(4);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setButtonContentDescription(String str) {
        this.containerView.setContentDescription(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0047). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = id.dana.component.buttoncomponent.DanaButtonPrimaryView.BuiltInFictitiousFunctionClassFactory
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 3
            r4 = 0
            r5 = 97
            if (r0 != 0) goto L15
            r5 = r2
            r6 = 97
            r7 = 3
            r8 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L47
        L15:
            r3 = r2
            r5 = 3
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
            int r5 = r5 + 1
            r7 = r2[r5]
            r10 = r5
            r5 = r3
            r3 = r7
            r7 = r10
        L47:
            int r6 = r6 + r3
            int r6 = r6 + (-8)
            r3 = r5
            r5 = r7
            r7 = r8
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.component.buttoncomponent.DanaButtonPrimaryView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    @Override // id.dana.component.BaseRichView
    public void setup() {
        this.containerView = (ConstraintLayout) getRootView().findViewById(R.id.cl_container_dana_button_primary_view);
        this.titleButtonLeft = (TextView) getRootView().findViewById(R.id.tv_title_button_left);
        this.titleButtonCenter = (TextView) getRootView().findViewById(R.id.res_0x7f0a1919_summaryvoucherview_externalsyntheticlambda1);
        this.titleButtonAmountCenter = (TextView) getRootView().findViewById(R.id.res_0x7f0a1918_summaryvoucherview_externalsyntheticlambda0);
        this.amountValueButtonCenter = (TextView) getRootView().findViewById(R.id.tv_amount_button_center);
        this.amountButton = (TextView) getRootView().findViewById(R.id.tv_ammount_button);
        this.iconButton = (ImageView) getRootView().findViewById(R.id.iv_icon_button_right);
        this.containerButtonAmountCenter = (ConstraintLayout) getRootView().findViewById(R.id.cl_button_amount_center);
        this.containerView.setContentDescription(this.scheduleImpl);
        setDanaButtonView(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
    }
}
