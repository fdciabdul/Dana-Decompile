package id.dana.component.cellcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.component.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.utils.SizeUtil;

/* loaded from: classes4.dex */
public class DanaCellRightView extends BaseDanaCell {
    public static final byte[] PlaceComponentResult = {116, 15, TarHeader.LF_BLK, -20, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 165;
    private Drawable BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    ConstraintLayout containerView;
    boolean isSmallCell;
    private String moveToNextValue;
    ImageView redDot;
    TextView rightAmount;
    TextView rightBlueColorValue;
    DanaButtonSecondaryView rightButton;
    ImageView rightDanaLogo;
    ImageView rightIcon;
    LinearLayout rightIconChip;
    DanaStepperView rightStepper;
    TextView rightSubValue;
    SwitchCompat rightSwitch;
    TextView rightValue;
    LinearLayout rightValueDouble;
    private String scheduleImpl;

    public DanaCellRightView(Context context) {
        super(context);
    }

    public DanaCellRightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanaCellRightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.component.BaseRichView
    public int getLayout() {
        return R.layout.res_0x7f0d04ed_networkuserentitydata_externalsyntheticlambda1;
    }

    @Override // id.dana.component.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.f8038a, 0, 0);
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(R.styleable.TypeProjectionImpl, 0);
                this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.e);
                this.scheduleImpl = obtainStyledAttributes.getString(R.styleable.f);
                this.moveToNextValue = obtainStyledAttributes.getString(R.styleable.g);
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getString(R.styleable.c);
                this.isSmallCell = obtainStyledAttributes.getBoolean(R.styleable.FillAnimation, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setCellRightIcon(Drawable drawable) {
        this.rightIcon.setVisibility(0);
        this.rightIcon.setImageDrawable(drawable);
    }

    public void setCellRightArrowValue(String str) {
        this.rightBlueColorValue.setVisibility(0);
        this.rightBlueColorValue.setText(str);
        setRightArrow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setCellRightSwitch$0$id-dana-component-cellcomponent-DanaCellRightView  reason: not valid java name */
    public /* synthetic */ void m607xbfe046d3(CompoundButton compoundButton, boolean z) {
        this.rightSwitch.setThumbTintList(getResources().getColorStateList(R.color.scheduleImpl));
        if (z) {
            this.rightSwitch.setTrackTintList(getResources().getColorStateList(R.color.PlaceComponentResult));
        } else {
            this.rightSwitch.setTrackTintList(getResources().getColorStateList(R.color.MyBillsEntityDataFactory));
        }
    }

    public void setRightSwitchChecked(boolean z) {
        this.rightSwitch.setChecked(z);
    }

    public void setCellRightValueDouble(String str, String str2) {
        this.rightValueDouble.setVisibility(0);
        this.rightValue.setText(str);
        this.rightSubValue.setText(str2);
    }

    public void setCellRightStepper() {
        this.rightStepper.setVisibility(0);
    }

    public void setCellRightValue(String str) {
        this.rightValue.setText(str);
        this.rightValueDouble.setVisibility(0);
        this.rightSubValue.setVisibility(8);
    }

    public void setCellRightArrowDana() {
        setRightArrow();
        this.containerView.setPadding(SizeUtil.PlaceComponentResult(16), 0, SizeUtil.PlaceComponentResult(10), 0);
        this.rightDanaLogo.setVisibility(0);
    }

    public void setCellRightArrowChip() {
        setCellRightChip();
        setRightArrow();
        this.containerView.setPadding(SizeUtil.PlaceComponentResult(16), 0, SizeUtil.PlaceComponentResult(10), 0);
    }

    public void setCellRightChip() {
        this.rightIconChip.setVisibility(0);
    }

    public void setRightArrowNotif() {
        this.redDot.setVisibility(0);
        setRightArrow();
        this.containerView.setPadding(SizeUtil.PlaceComponentResult(16), 0, SizeUtil.PlaceComponentResult(10), 0);
    }

    public void setCellRightButton(String str) {
        this.rightButton.setVisibility(0);
        this.rightButton.setActiveButton(str, null);
    }

    public void setRightArrow() {
        this.rightIcon.setVisibility(0);
        this.rightIcon.setImageDrawable(InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.res_0x7f080796_networkuserentitydata_externalsyntheticlambda1));
        this.containerView.setPadding(SizeUtil.PlaceComponentResult(16), 0, SizeUtil.PlaceComponentResult(10), 0);
    }

    public void setCellRightAmount(String str) {
        this.rightAmount.setVisibility(0);
        this.rightAmount.setText(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0040 -> B:15:0x0045). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = id.dana.component.cellcomponent.DanaCellRightView.PlaceComponentResult
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 97
            r4 = 0
            r5 = 3
            if (r0 != 0) goto L14
            r5 = r2
            r6 = 3
            r7 = 3
            r9 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L45
        L14:
            r3 = r2
            r5 = 97
            r6 = 3
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1c:
            byte r8 = (byte) r5
            int r9 = r7 + 1
            r3[r7] = r8
            int r6 = r6 + 1
            if (r9 != r1) goto L40
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3b
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3b:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L40:
            r7 = r2[r6]
            r10 = r5
            r5 = r3
            r3 = r10
        L45:
            int r7 = -r7
            int r3 = r3 + r7
            int r3 = r3 + (-8)
            r7 = r9
            r10 = r5
            r5 = r3
            r3 = r10
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.component.cellcomponent.DanaCellRightView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    @Override // id.dana.component.BaseRichView
    public void setup() {
        this.containerView = (ConstraintLayout) getRootView().findViewById(R.id.res_0x7f0a0421_networkuserentitydata_externalsyntheticlambda8);
        this.rightAmount = (TextView) getRootView().findViewById(R.id.tv_right_amount);
        this.rightValue = (TextView) getRootView().findViewById(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
        this.rightSubValue = (TextView) getRootView().findViewById(R.id.tv_sub_value);
        this.rightBlueColorValue = (TextView) getRootView().findViewById(R.id.tv_blue_color_value);
        this.rightIcon = (ImageView) getRootView().findViewById(R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a0aad);
        this.redDot = (ImageView) getRootView().findViewById(R.id.res_0x7f0a0c00_bottomsheetcardbindingview_watchercardnumberview_1);
        this.rightDanaLogo = (ImageView) getRootView().findViewById(R.id.readMicros);
        this.rightButton = (DanaButtonSecondaryView) getRootView().findViewById(R.id.btn_dana_secondary);
        this.rightValueDouble = (LinearLayout) getRootView().findViewById(R.id.ll_cell_right_value_double);
        this.rightIconChip = (LinearLayout) getRootView().findViewById(R.id.ll_all_chip);
        this.rightSwitch = (SwitchCompat) getRootView().findViewById(R.id.VerifyPinStateManager$executeRiskChallenge$2$2);
        this.rightStepper = (DanaStepperView) getRootView().findViewById(R.id.view_stepper);
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Drawable drawable = this.BuiltInFictitiousFunctionClassFactory;
        String str = this.scheduleImpl;
        String str2 = this.moveToNextValue;
        String str3 = this.MyBillsEntityDataFactory;
        switch (i) {
            case 0:
                setCellRightAmount(str3);
                break;
            case 1:
                setRightArrow();
                break;
            case 2:
                setCellRightButton(str);
                break;
            case 3:
                setRightArrowNotif();
                break;
            case 4:
                setCellRightChip();
                break;
            case 5:
                setCellRightArrowChip();
                break;
            case 6:
                setCellRightArrowDana();
                break;
            case 7:
                setCellRightValue(str);
                break;
            case 8:
                setCellRightStepper();
                break;
            case 9:
                setCellRightValueDouble(str, str2);
                break;
            case 10:
                this.containerView.setPadding(SizeUtil.PlaceComponentResult(16), 0, SizeUtil.PlaceComponentResult(10), 0);
                this.rightSwitch.setVisibility(0);
                this.rightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.component.cellcomponent.DanaCellRightView$$ExternalSyntheticLambda0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        DanaCellRightView.this.m607xbfe046d3(compoundButton, z);
                    }
                });
                break;
            case 11:
                setCellRightArrowValue(str);
                break;
            case 12:
                setCellRightIcon(drawable);
                break;
        }
        vallidateSmallCell(this.containerView, this.isSmallCell);
    }
}
