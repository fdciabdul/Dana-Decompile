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
public class DanaButtonSecondaryView extends BaseDanaButton {
    public static final byte[] PlaceComponentResult = {37, 81, 122, 15, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int getAuthRequestContext = 147;
    private Drawable BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    TextView amountButton;
    ConstraintLayout containerView;
    private int getErrorConfigVersion;
    ImageView iconButton;
    ImageView iconButtonCenter;
    private int moveToNextValue;
    TextView titleButtonCenter;
    TextView titleButtonLeft;

    public DanaButtonSecondaryView(Context context) {
        super(context);
    }

    public DanaButtonSecondaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DanaButtonSecondaryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // id.dana.component.BaseRichView
    public int getLayout() {
        return R.layout.view_dana_button_secondary;
    }

    @Override // id.dana.component.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.isAuth, 0, 0);
            try {
                this.getErrorConfigVersion = obtainStyledAttributes.getInt(R.styleable.T, 0);
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getString(R.styleable.U);
                this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.X);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getString(R.styleable.W);
                this.moveToNextValue = obtainStyledAttributes.getInt(R.styleable.V, 0);
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getString(R.styleable.flip);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setDanaButtonView(int i, String str, String str2, Drawable drawable) {
        if (i == 0) {
            setDisabled(str);
        } else if (i == 1) {
            setActiveButton(str, drawable);
        } else if (i == 2) {
            setActiveButtonWithIcon(str, drawable);
        } else if (i == 3) {
            setActiveButtonLeftAlignWithAmount(str, str2);
        } else if (i == 4) {
            setActiveButtonLeftAlignWithIcon(str, drawable);
        } else if (i == 5) {
            setError(str);
        }
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButton(String str, Drawable drawable) {
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setVisibility(0);
        this.titleButtonCenter.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult));
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_secondary_active);
        this.iconButtonCenter.setVisibility(0);
        this.iconButtonCenter.setImageDrawable(drawable);
        this.iconButtonCenter.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult), PorterDuff.Mode.SRC_IN);
        this.amountButton.setVisibility(4);
        this.titleButtonLeft.setVisibility(4);
        this.iconButton.setVisibility(4);
        vallidateSize(this.moveToNextValue, this.containerView, this.titleButtonCenter);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonWithIcon(String str, Drawable drawable) {
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setVisibility(0);
        this.titleButtonCenter.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult));
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_secondary_active);
        this.iconButton.setImageDrawable(drawable);
        this.iconButton.setVisibility(0);
        this.iconButton.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult), PorterDuff.Mode.SRC_IN);
        this.iconButtonCenter.setVisibility(4);
        this.titleButtonLeft.setVisibility(4);
        this.amountButton.setVisibility(4);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonLeftAlignWithAmount(String str, String str2) {
        this.titleButtonLeft.setText(str);
        this.titleButtonLeft.setVisibility(0);
        this.titleButtonCenter.setVisibility(4);
        this.titleButtonCenter.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult));
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_secondary_active);
        this.amountButton.setText(str2);
        this.amountButton.setVisibility(0);
        this.iconButtonCenter.setVisibility(4);
        this.iconButton.setVisibility(4);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setActiveButtonLeftAlignWithIcon(String str, Drawable drawable) {
        this.titleButtonLeft.setText(str);
        this.titleButtonLeft.setVisibility(0);
        this.titleButtonCenter.setVisibility(4);
        this.titleButtonCenter.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult));
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_secondary_active);
        this.iconButton.setImageDrawable(drawable);
        this.iconButton.setVisibility(0);
        this.iconButton.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.PlaceComponentResult), PorterDuff.Mode.SRC_IN);
        this.amountButton.setVisibility(4);
        this.iconButtonCenter.setVisibility(4);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setError(String str) {
        this.titleButtonCenter.setText(str);
        this.titleButtonCenter.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.lookAheadTest));
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_secondary_error);
        this.titleButtonCenter.setVisibility(0);
        this.iconButton.setVisibility(4);
        this.amountButton.setVisibility(4);
        this.titleButtonLeft.setVisibility(4);
        this.iconButtonCenter.setVisibility(4);
        vallidateSize(this.moveToNextValue, this.containerView, this.titleButtonCenter);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setDisabled(String str) {
        this.titleButtonCenter.setText(str);
        this.containerView.setBackgroundResource(R.drawable.bg_dana_button_secondary_disabled);
        this.titleButtonCenter.setVisibility(0);
        this.titleButtonCenter.setTextColor(getResources().getColor(R.color.MyBillsEntityDataFactory));
        this.iconButtonCenter.setVisibility(0);
        this.iconButtonCenter.setImageDrawable(this.BuiltInFictitiousFunctionClassFactory);
        this.iconButtonCenter.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.MyBillsEntityDataFactory), PorterDuff.Mode.SRC_IN);
        this.iconButton.setVisibility(4);
        this.amountButton.setVisibility(4);
        this.titleButtonLeft.setVisibility(4);
        vallidateSize(this.moveToNextValue, this.containerView, this.titleButtonCenter);
    }

    @Override // id.dana.component.buttoncomponent.BaseDanaButton
    public void setButtonContentDescription(String str) {
        this.containerView.setContentDescription(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0043 -> B:15:0x004a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.component.buttoncomponent.DanaButtonSecondaryView.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 0
            r4 = 97
            r5 = 3
            if (r0 != 0) goto L17
            r5 = r1
            r6 = 22
            r7 = 3
            r8 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L4a
        L17:
            r4 = r1
            r5 = 97
            r6 = 3
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1f:
            int r6 = r6 + 1
            byte r8 = (byte) r5
            r4[r7] = r8
            int r8 = r7 + 1
            if (r7 != r2) goto L43
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3e
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3e:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L43:
            r7 = r1[r6]
            r9 = r5
            r5 = r4
            r4 = r7
            r7 = r6
            r6 = r9
        L4a:
            int r6 = r6 + r4
            int r4 = r6 + (-8)
            r6 = r7
            r7 = r8
            r9 = r5
            r5 = r4
            r4 = r9
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.component.buttoncomponent.DanaButtonSecondaryView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    @Override // id.dana.component.BaseRichView
    public void setup() {
        this.containerView = (ConstraintLayout) getRootView().findViewById(R.id.res_0x7f0a041e_networkuserentitydata_externalsyntheticlambda1);
        this.titleButtonLeft = (TextView) getRootView().findViewById(R.id.tv_title_button_left);
        this.titleButtonCenter = (TextView) getRootView().findViewById(R.id.res_0x7f0a1919_summaryvoucherview_externalsyntheticlambda1);
        this.amountButton = (TextView) getRootView().findViewById(R.id.tv_ammount_button);
        this.iconButton = (ImageView) getRootView().findViewById(R.id.iv_icon_button_right);
        this.iconButtonCenter = (ImageView) getRootView().findViewById(R.id.iv_icon_button_center);
        this.containerView.setContentDescription(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        setDanaButtonView(this.getErrorConfigVersion, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
    }
}
