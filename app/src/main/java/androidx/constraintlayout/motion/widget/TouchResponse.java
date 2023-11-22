package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class TouchResponse {
    private static final float[][] getCallingPid = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] whenAvailable = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private int A;
    private boolean B;
    float BuiltInFictitiousFunctionClassFactory;
    private int C;
    public int DatabaseTableConfigUtil;
    int FragmentBottomSheetPaymentSettingBinding;
    final MotionLayout GetContactSyncConfig;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    float NetworkUserEntityData$$ExternalSyntheticLambda2;
    float NetworkUserEntityData$$ExternalSyntheticLambda3;
    float NetworkUserEntityData$$ExternalSyntheticLambda4;
    float NetworkUserEntityData$$ExternalSyntheticLambda5;
    float NetworkUserEntityData$$ExternalSyntheticLambda7;
    float NetworkUserEntityData$$ExternalSyntheticLambda8;
    int PlaceComponentResult;
    int PrepareContext;
    int SubSequence;
    private int VerifyPinStateManager$executeRiskChallenge$2$1;
    float getAuthRequestContext;
    float getErrorConfigVersion;
    float getSupportButtonTintMode;
    float isLayoutRequested;
    float lookAheadTest;
    float moveToNextValue;
    int newProxyInstance;
    float readMicros;
    boolean scheduleImpl;
    float initRecordTimeStamp = 0.5f;
    float NetworkUserEntityData$$ExternalSyntheticLambda1 = 0.5f;
    boolean KClassImpl$Data$declaredNonStaticMembers$2 = false;
    float[] MyBillsEntityDataFactory = new float[2];
    int[] NetworkUserEntityData$$ExternalSyntheticLambda6 = new int[2];

    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.A = 0;
        this.C = 0;
        this.DatabaseTableConfigUtil = 0;
        this.FragmentBottomSheetPaymentSettingBinding = -1;
        this.SubSequence = -1;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0.5f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 0.5f;
        this.PrepareContext = -1;
        this.scheduleImpl = false;
        this.readMicros = 0.0f;
        this.getSupportButtonTintMode = 1.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 4.0f;
        this.getErrorConfigVersion = 1.2f;
        this.B = true;
        this.BuiltInFictitiousFunctionClassFactory = 1.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
        this.getAuthRequestContext = 10.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 10.0f;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = 1.0f;
        this.isLayoutRequested = Float.NaN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = Float.NaN;
        this.newProxyInstance = 0;
        this.PlaceComponentResult = 0;
        this.GetContactSyncConfig = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.openH5Container);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.average) {
                this.FragmentBottomSheetPaymentSettingBinding = obtainStyledAttributes.getResourceId(index, this.FragmentBottomSheetPaymentSettingBinding);
            } else if (index == R.styleable.getCheckBoxText) {
                int i2 = obtainStyledAttributes.getInt(index, this.A);
                this.A = i2;
                float[] fArr = getCallingPid[i2];
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = fArr[0];
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = fArr[1];
            } else if (index == R.styleable.MediaCodecInfo$VideoCapabilities) {
                int i3 = obtainStyledAttributes.getInt(index, this.C);
                this.C = i3;
                float[][] fArr2 = whenAvailable;
                if (i3 < fArr2.length) {
                    float[] fArr3 = fArr2[i3];
                    this.readMicros = fArr3[0];
                    this.getSupportButtonTintMode = fArr3[1];
                } else {
                    this.getSupportButtonTintMode = Float.NaN;
                    this.readMicros = Float.NaN;
                    this.scheduleImpl = true;
                }
            } else if (index == R.styleable.createInverse) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obtainStyledAttributes.getFloat(index, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            } else if (index == R.styleable.getNearbyMeByRadius) {
                this.getErrorConfigVersion = obtainStyledAttributes.getFloat(index, this.getErrorConfigVersion);
            } else if (index == R.styleable.f23getEmergencyNotifConfig$lambda179) {
                this.B = obtainStyledAttributes.getBoolean(index, this.B);
            } else if (index == R.styleable.HereAuthenticationPreference$saveBackoffData$1) {
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getFloat(index, this.BuiltInFictitiousFunctionClassFactory);
            } else if (index == R.styleable.getSystemResourceAsStream) {
                this.getAuthRequestContext = obtainStyledAttributes.getFloat(index, this.getAuthRequestContext);
            } else if (index == R.styleable.Typography) {
                this.SubSequence = obtainStyledAttributes.getResourceId(index, this.SubSequence);
            } else if (index == R.styleable.SaveNewsWidgetActivitiesIntoPersistence) {
                this.DatabaseTableConfigUtil = obtainStyledAttributes.getInt(index, this.DatabaseTableConfigUtil);
            } else if (index == R.styleable.CallCsOrDianaViewModel$getHelpButtonChatBotFeature$1) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.DrawInvoice) {
                this.VerifyPinStateManager$executeRiskChallenge$2$1 = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == R.styleable.ChangePayMethodPresenter_Factory) {
                this.PrepareContext = obtainStyledAttributes.getResourceId(index, this.PrepareContext);
            } else if (index == R.styleable.RiskResult) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obtainStyledAttributes.getFloat(index, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            } else if (index == R.styleable.getFlavorType) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = obtainStyledAttributes.getFloat(index, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            } else if (index == R.styleable.f28x612c6568) {
                this.isLayoutRequested = obtainStyledAttributes.getFloat(index, this.isLayoutRequested);
            } else if (index == R.styleable.BottomSheetType) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = obtainStyledAttributes.getFloat(index, this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            } else if (index == R.styleable.RenderBridge) {
                this.newProxyInstance = obtainStyledAttributes.getInt(index, this.newProxyInstance);
            } else if (index == R.styleable.getSearchKeyword) {
                this.PlaceComponentResult = obtainStyledAttributes.getInt(index, this.PlaceComponentResult);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final void getAuthRequestContext(boolean z) {
        if (z) {
            float[][] fArr = whenAvailable;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = getCallingPid;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = whenAvailable;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = getCallingPid;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = getCallingPid[this.A];
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = fArr5[0];
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = fArr5[1];
        int i = this.C;
        float[][] fArr6 = whenAvailable;
        if (i >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i];
        this.readMicros = fArr7[0];
        this.getSupportButtonTintMode = fArr7[1];
    }

    public final boolean PlaceComponentResult() {
        return this.B;
    }

    public final RectF BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.SubSequence;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public final RectF KClassImpl$Data$declaredNonStaticMembers$2(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public String toString() {
        if (Float.isNaN(this.readMicros)) {
            return "rotation";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.readMicros);
        sb.append(" , ");
        sb.append(this.getSupportButtonTintMode);
        return sb.toString();
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
