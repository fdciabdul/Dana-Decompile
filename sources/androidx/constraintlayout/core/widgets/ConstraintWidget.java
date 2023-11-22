package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ConstraintWidget {
    public static float KClassImpl$Data$declaredNonStaticMembers$2 = 0.5f;
    boolean A;
    public boolean AppCompatEmojiTextHelper;
    int B;
    public float BottomSheetCardBindingView$watcherCardNumberView$1;
    private int BuiltInFictitiousFunctionClassFactory;
    public int C;
    public boolean DatabaseTableConfigUtil;
    public int E;
    public boolean F;
    boolean FlowViewUtil$textChanges$1;
    public int FlowViewUtil$textChanges$2;
    public ConstraintAnchor[] J;
    boolean L;
    protected ConstraintWidget[] M;
    protected ArrayList<ConstraintAnchor> NetworkUserEntityData$$ExternalSyntheticLambda1;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    public String NetworkUserEntityData$$ExternalSyntheticLambda4;
    public Object NetworkUserEntityData$$ExternalSyntheticLambda6;
    public int NetworkUserEntityData$$ExternalSyntheticLambda7;
    public int OtpRegistrationPresenter$input$2;
    boolean PrepareContext;
    boolean QrExpiredActivity;
    public float SubSequence;
    protected int SummaryVoucherView$$ExternalSyntheticLambda1;
    protected int T;
    ConstraintWidget TypeProjectionImpl;
    protected int U;
    protected int V;
    boolean VerifyPinStateManager$executeRiskChallenge$2$1;
    ConstraintWidget VerifyPinStateManager$executeRiskChallenge$2$2;
    public ConstraintWidget W;
    protected ConstraintWidget[] X;
    int Y;
    boolean d;
    public float e;
    public int f;
    boolean g;
    int getCallingPid;
    public DimensionBehaviour[] getNameOrBuilderList;
    boolean getOnBoardingScenario;
    int getSupportButtonTintMode;
    public int h;
    public float[] i;
    int isAuto;
    protected int k;
    public String l;
    public int lookAheadTest;
    protected int m;
    public ChainRun moveToNextValue;
    public ConstraintAnchor newProxyInstance;

    /* renamed from: o  reason: collision with root package name */
    private boolean[] f5940o;
    public ChainRun p;
    int readMicros;
    private String s;
    protected int whenAvailable;
    public boolean access$throwIllegalArgumentType = false;
    public WidgetRun[] j = new WidgetRun[2];
    public HorizontalWidgetRun NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    public VerticalWidgetRun n = null;
    public boolean[] initRecordTimeStamp = {true, true};
    boolean shouldRecycleViewType = false;
    public boolean isAuth = true;
    private boolean MyBillsEntityDataFactory = false;
    private boolean PlaceComponentResult = true;
    private int q = -1;
    private int getAuthRequestContext = -1;
    public WidgetFrame getErrorConfigVersion = new WidgetFrame(this);
    private boolean SizeSelectors$OrSelector = false;
    private boolean t = false;
    public boolean GetContactSyncConfig = false;
    public boolean DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = false;
    public int getValueOfTouchPositionAbsolute = -1;
    public int FillAnimation = -1;
    public int connectForeground = 0;
    public int N = 0;
    public int K = 0;
    public int[] b = new int[2];
    public int P = 0;
    public int O = 0;
    public float S = 1.0f;
    public int SummaryVoucherView$$ExternalSyntheticLambda0 = 0;
    public int Q = 0;
    public float R = 1.0f;
    int Z = -1;
    float flip = 1.0f;
    public int[] SummaryVoucherView$$ExternalSyntheticLambda2 = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float NetworkUserEntityData$$ExternalSyntheticLambda3 = 0.0f;
    public boolean scheduleImpl = false;
    public boolean D = false;
    public int H = 0;
    public int G = 0;
    public ConstraintAnchor I = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);

    /* renamed from: a  reason: collision with root package name */
    public ConstraintAnchor f5939a = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    public ConstraintAnchor c = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor isLayoutRequested = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor NetworkUserEntityData$$ExternalSyntheticLambda8 = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor NetworkUserEntityData$$ExternalSyntheticLambda5 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor FragmentBottomSheetPaymentSettingBinding = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    /* loaded from: classes3.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public final void SubSequence() {
        ConstraintAnchor constraintAnchor = this.I;
        constraintAnchor.PlaceComponentResult = 0;
        constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.m = 0;
    }

    public final void VerifyPinStateManager$executeRiskChallenge$2$1() {
        ConstraintAnchor constraintAnchor = this.f5939a;
        constraintAnchor.PlaceComponentResult = 0;
        constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.k = 0;
    }

    public final boolean isLayoutRequested() {
        return this.GetContactSyncConfig;
    }

    public final boolean FragmentBottomSheetPaymentSettingBinding() {
        return this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider;
    }

    public final void PlaceComponentResult(int i, int i2) {
        if (this.SizeSelectors$OrSelector) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.I;
        constraintAnchor.PlaceComponentResult = i;
        constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        ConstraintAnchor constraintAnchor2 = this.c;
        constraintAnchor2.PlaceComponentResult = i2;
        constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.m = i;
        this.FlowViewUtil$textChanges$2 = i2 - i;
        this.SizeSelectors$OrSelector = true;
    }

    public final void getAuthRequestContext(int i, int i2) {
        if (this.t) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.f5939a;
        constraintAnchor.PlaceComponentResult = i;
        constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        ConstraintAnchor constraintAnchor2 = this.isLayoutRequested;
        constraintAnchor2.PlaceComponentResult = i2;
        constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        this.k = i;
        this.C = i2 - i;
        if (this.scheduleImpl) {
            ConstraintAnchor constraintAnchor3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            constraintAnchor3.PlaceComponentResult = i + this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            constraintAnchor3.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        this.t = true;
    }

    public final void BuiltInFictitiousFunctionClassFactory(int i) {
        if (this.scheduleImpl) {
            int i2 = i - this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            int i3 = this.C;
            this.k = i2;
            ConstraintAnchor constraintAnchor = this.f5939a;
            constraintAnchor.PlaceComponentResult = i2;
            constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            ConstraintAnchor constraintAnchor2 = this.isLayoutRequested;
            constraintAnchor2.PlaceComponentResult = i3 + i2;
            constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            ConstraintAnchor constraintAnchor3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            constraintAnchor3.PlaceComponentResult = i;
            constraintAnchor3.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            this.t = true;
        }
    }

    public boolean PlaceComponentResult() {
        return this.SizeSelectors$OrSelector || (this.I.getAuthRequestContext() && this.c.getAuthRequestContext());
    }

    public boolean getAuthRequestContext() {
        return this.t || (this.f5939a.getAuthRequestContext() && this.isLayoutRequested.getAuthRequestContext());
    }

    public final void readMicros() {
        this.SizeSelectors$OrSelector = false;
        this.t = false;
        this.GetContactSyncConfig = false;
        this.DaggerUserBankCardComponent$UserBankCardComponentImpl$PostExecutionThreadProvider = false;
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda1.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(i);
            constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            constraintAnchor.PlaceComponentResult = 0;
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda1.size();
        for (int i = 0; i < size; i++) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(i).BuiltInFictitiousFunctionClassFactory()) {
                return true;
            }
        }
        return false;
    }

    public final boolean getAuthRequestContext(int i) {
        if (i == 0) {
            return (this.I.moveToNextValue != null ? 1 : 0) + (this.c.moveToNextValue != null ? 1 : 0) < 2;
        }
        return ((this.f5939a.moveToNextValue != null ? 1 : 0) + (this.isLayoutRequested.moveToNextValue != null ? 1 : 0)) + (this.NetworkUserEntityData$$ExternalSyntheticLambda8.moveToNextValue != null ? 1 : 0) < 2;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        if (i == 0) {
            if (this.I.moveToNextValue != null && this.I.moveToNextValue.getAuthRequestContext() && this.c.moveToNextValue != null && this.c.moveToNextValue.getAuthRequestContext()) {
                ConstraintAnchor constraintAnchor = this.c.moveToNextValue;
                int i3 = !constraintAnchor.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor.PlaceComponentResult;
                int MyBillsEntityDataFactory = this.c.MyBillsEntityDataFactory();
                ConstraintAnchor constraintAnchor2 = this.I.moveToNextValue;
                return (i3 - MyBillsEntityDataFactory) - ((!constraintAnchor2.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor2.PlaceComponentResult) + this.I.MyBillsEntityDataFactory()) >= i2;
            }
        } else if (this.f5939a.moveToNextValue != null && this.f5939a.moveToNextValue.getAuthRequestContext() && this.isLayoutRequested.moveToNextValue != null && this.isLayoutRequested.moveToNextValue.getAuthRequestContext()) {
            ConstraintAnchor constraintAnchor3 = this.isLayoutRequested.moveToNextValue;
            int i4 = !constraintAnchor3.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor3.PlaceComponentResult;
            int MyBillsEntityDataFactory2 = this.isLayoutRequested.MyBillsEntityDataFactory();
            ConstraintAnchor constraintAnchor4 = this.f5939a.moveToNextValue;
            return (i4 - MyBillsEntityDataFactory2) - ((!constraintAnchor4.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : constraintAnchor4.PlaceComponentResult) + this.f5939a.MyBillsEntityDataFactory()) >= i2;
        }
        return false;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda6() {
        return this.D;
    }

    public final boolean PrepareContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, boolean z) {
        this.f5940o[i] = z;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return this.f5940o[i];
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return this.isAuth && this.h != 8;
    }

    public void whenAvailable() {
        this.I.lookAheadTest();
        this.f5939a.lookAheadTest();
        this.c.lookAheadTest();
        this.isLayoutRequested.lookAheadTest();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.lookAheadTest();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.lookAheadTest();
        this.FragmentBottomSheetPaymentSettingBinding.lookAheadTest();
        this.newProxyInstance.lookAheadTest();
        this.W = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = 0.0f;
        this.FlowViewUtil$textChanges$2 = 0;
        this.C = 0;
        this.SubSequence = 0.0f;
        this.whenAvailable = -1;
        this.m = 0;
        this.k = 0;
        this.V = 0;
        this.T = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        this.U = 0;
        this.SummaryVoucherView$$ExternalSyntheticLambda1 = 0;
        float f = KClassImpl$Data$declaredNonStaticMembers$2;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = f;
        this.e = f;
        this.getNameOrBuilderList[0] = DimensionBehaviour.FIXED;
        this.getNameOrBuilderList[1] = DimensionBehaviour.FIXED;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.h = 0;
        this.s = null;
        this.getOnBoardingScenario = false;
        this.FlowViewUtil$textChanges$1 = false;
        this.E = 0;
        this.f = 0;
        this.A = false;
        this.g = false;
        float[] fArr = this.i;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.getValueOfTouchPositionAbsolute = -1;
        this.FillAnimation = -1;
        int[] iArr = this.SummaryVoucherView$$ExternalSyntheticLambda2;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.N = 0;
        this.K = 0;
        this.S = 1.0f;
        this.R = 1.0f;
        this.O = Integer.MAX_VALUE;
        this.Q = Integer.MAX_VALUE;
        this.P = 0;
        this.SummaryVoucherView$$ExternalSyntheticLambda0 = 0;
        this.shouldRecycleViewType = false;
        this.Z = -1;
        this.flip = 1.0f;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
        boolean[] zArr = this.initRecordTimeStamp;
        zArr[0] = true;
        zArr[1] = true;
        this.D = false;
        boolean[] zArr2 = this.f5940o;
        zArr2[0] = false;
        zArr2[1] = false;
        this.isAuth = true;
        int[] iArr2 = this.b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.q = -1;
        this.getAuthRequestContext = -1;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(StringBuilder sb, String str, float f, float f2) {
        if (f == f2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f);
        sb.append(",\n");
    }

    private static void getAuthRequestContext(StringBuilder sb, String str, int i, int i2) {
        if (i == i2) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i);
        sb.append(",\n");
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda4() {
        return this.getNameOrBuilderList[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.getNameOrBuilderList[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return (this.q == -1 && this.getAuthRequestContext == -1) ? false : true;
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.newProxyInstance = constraintAnchor;
        this.J = new ConstraintAnchor[]{this.I, this.c, this.f5939a, this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda8, constraintAnchor};
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new ArrayList<>();
        this.f5940o = new boolean[2];
        this.getNameOrBuilderList = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.W = null;
        this.FlowViewUtil$textChanges$2 = 0;
        this.C = 0;
        this.SubSequence = 0.0f;
        this.whenAvailable = -1;
        this.m = 0;
        this.k = 0;
        this.Y = 0;
        this.isAuto = 0;
        this.V = 0;
        this.T = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        float f = KClassImpl$Data$declaredNonStaticMembers$2;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = f;
        this.e = f;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.h = 0;
        this.DatabaseTableConfigUtil = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
        this.s = null;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
        this.E = 0;
        this.f = 0;
        this.i = new float[]{-1.0f, -1.0f};
        this.M = new ConstraintWidget[]{null, null};
        this.X = new ConstraintWidget[]{null, null};
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = null;
        this.TypeProjectionImpl = null;
        this.lookAheadTest = -1;
        this.OtpRegistrationPresenter$input$2 = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.I);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.f5939a);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.c);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.isLayoutRequested);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.FragmentBottomSheetPaymentSettingBinding);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.newProxyInstance);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
    }

    public final void b_() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new HorizontalWidgetRun(this);
        }
        if (this.n == null) {
            this.n = new VerticalWidgetRun(this);
        }
    }

    public void PlaceComponentResult(Cache cache) {
        ConstraintAnchor constraintAnchor = this.I;
        SolverVariable solverVariable = constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable == null) {
            constraintAnchor.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable.MyBillsEntityDataFactory();
        }
        ConstraintAnchor constraintAnchor2 = this.f5939a;
        SolverVariable solverVariable2 = constraintAnchor2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable2 == null) {
            constraintAnchor2.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable2.MyBillsEntityDataFactory();
        }
        ConstraintAnchor constraintAnchor3 = this.c;
        SolverVariable solverVariable3 = constraintAnchor3.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable3 == null) {
            constraintAnchor3.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable3.MyBillsEntityDataFactory();
        }
        ConstraintAnchor constraintAnchor4 = this.isLayoutRequested;
        SolverVariable solverVariable4 = constraintAnchor4.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable4 == null) {
            constraintAnchor4.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable4.MyBillsEntityDataFactory();
        }
        ConstraintAnchor constraintAnchor5 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        SolverVariable solverVariable5 = constraintAnchor5.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable5 == null) {
            constraintAnchor5.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable5.MyBillsEntityDataFactory();
        }
        ConstraintAnchor constraintAnchor6 = this.newProxyInstance;
        SolverVariable solverVariable6 = constraintAnchor6.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable6 == null) {
            constraintAnchor6.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable6.MyBillsEntityDataFactory();
        }
        ConstraintAnchor constraintAnchor7 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        SolverVariable solverVariable7 = constraintAnchor7.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable7 == null) {
            constraintAnchor7.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable7.MyBillsEntityDataFactory();
        }
        ConstraintAnchor constraintAnchor8 = this.FragmentBottomSheetPaymentSettingBinding;
        SolverVariable solverVariable8 = constraintAnchor8.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (solverVariable8 == null) {
            constraintAnchor8.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SolverVariable(SolverVariable.Type.UNRESTRICTED);
        } else {
            solverVariable8.MyBillsEntityDataFactory();
        }
    }

    public final void MyBillsEntityDataFactory(LinearSystem linearSystem) {
        linearSystem.PlaceComponentResult(this.I);
        linearSystem.PlaceComponentResult(this.f5939a);
        linearSystem.PlaceComponentResult(this.c);
        linearSystem.PlaceComponentResult(this.isLayoutRequested);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 > 0) {
            linearSystem.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.s != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("type: ");
            sb2.append(this.s);
            sb2.append(" ");
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("id: ");
            sb3.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
            sb3.append(" ");
            str2 = sb3.toString();
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.m);
        sb.append(", ");
        sb.append(this.k);
        sb.append(") - (");
        sb.append(this.FlowViewUtil$textChanges$2);
        sb.append(" x ");
        sb.append(this.C);
        sb.append(")");
        return sb.toString();
    }

    public final int NetworkUserEntityData$$ExternalSyntheticLambda1() {
        ConstraintWidget constraintWidget = this.W;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).TypefaceCompatApi26Impl + this.m;
        }
        return this.m;
    }

    public final int DatabaseTableConfigUtil() {
        ConstraintWidget constraintWidget = this.W;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            return ((ConstraintWidgetContainer) constraintWidget).RequestMoneyQrContract$View + this.k;
        }
        return this.k;
    }

    public final int GetContactSyncConfig() {
        return this.U;
    }

    public final int initRecordTimeStamp() {
        return this.SummaryVoucherView$$ExternalSyntheticLambda1;
    }

    public final int NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return NetworkUserEntityData$$ExternalSyntheticLambda1() + this.FlowViewUtil$textChanges$2;
    }

    public final int getErrorConfigVersion() {
        return DatabaseTableConfigUtil() + this.C;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.scheduleImpl;
    }

    public final void moveToNextValue(int i) {
        this.m = i;
    }

    public final void GetContactSyncConfig(int i) {
        this.k = i;
    }

    public final void MyBillsEntityDataFactory(int i, int i2) {
        this.m = i;
        this.k = i2;
    }

    public final void getErrorConfigVersion(int i) {
        this.FlowViewUtil$textChanges$2 = i;
        int i2 = this.U;
        if (i < i2) {
            this.FlowViewUtil$textChanges$2 = i2;
        }
    }

    public final void lookAheadTest(int i) {
        this.C = i;
        int i2 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        if (i < i2) {
            this.C = i2;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0082 -> B:38:0x0083). Please submit an issue!!! */
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        float f;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.SubSequence = 0.0f;
            return;
        }
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i2 = -1;
        int i3 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase(SummaryActivity.HOURS)) {
                i2 = 1;
            }
            i3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0 && indexOf2 < length - 1) {
            String substring2 = str.substring(i3, indexOf2);
            String substring3 = str.substring(indexOf2 + 1);
            if (substring2.length() > 0 && substring3.length() > 0) {
                float parseFloat = Float.parseFloat(substring2);
                float parseFloat2 = Float.parseFloat(substring3);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    if (i2 == 1) {
                        f = Math.abs(parseFloat2 / parseFloat);
                    } else {
                        f = Math.abs(parseFloat / parseFloat2);
                    }
                }
            }
            f = 0.0f;
        } else {
            String substring4 = str.substring(i3);
            if (substring4.length() > 0) {
                f = Float.parseFloat(substring4);
            }
            f = 0.0f;
        }
        i = (f > i ? 1 : (f == i ? 0 : -1));
        if (i > 0) {
            this.SubSequence = f;
            this.whenAvailable = i2;
        }
    }

    public final int c_() {
        return this.whenAvailable;
    }

    public final void scheduleImpl(int i) {
        if (i < 0) {
            this.U = 0;
        } else {
            this.U = i;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(int i) {
        if (i < 0) {
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = 0;
        } else {
            this.SummaryVoucherView$$ExternalSyntheticLambda1 = i;
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        this.m = i;
        int i3 = i2 - i;
        this.FlowViewUtil$textChanges$2 = i3;
        int i4 = this.U;
        if (i3 < i4) {
            this.FlowViewUtil$textChanges$2 = i4;
        }
    }

    public final void moveToNextValue(int i, int i2) {
        this.k = i;
        int i3 = i2 - i;
        this.C = i3;
        int i4 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        if (i3 < i4) {
            this.C = i4;
        }
    }

    public boolean MyBillsEntityDataFactory() {
        return this.h != 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        boolean z;
        if (type == ConstraintAnchor.Type.CENTER) {
            if (type2 == ConstraintAnchor.Type.CENTER) {
                ConstraintAnchor BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP);
                ConstraintAnchor BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((BuiltInFictitiousFunctionClassFactory == null || !BuiltInFictitiousFunctionClassFactory.scheduleImpl()) && (BuiltInFictitiousFunctionClassFactory2 == null || !BuiltInFictitiousFunctionClassFactory2.scheduleImpl())) {
                    PlaceComponentResult(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0);
                    PlaceComponentResult(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((BuiltInFictitiousFunctionClassFactory3 == null || !BuiltInFictitiousFunctionClassFactory3.scheduleImpl()) && (BuiltInFictitiousFunctionClassFactory4 == null || !BuiltInFictitiousFunctionClassFactory4.scheduleImpl())) {
                    PlaceComponentResult(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0);
                    PlaceComponentResult(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER), 0);
                } else if (z) {
                    BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_X).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_X), 0);
                } else if (z2) {
                    BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_Y).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_Y), 0);
                }
            } else if (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT) {
                PlaceComponentResult(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                PlaceComponentResult(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(type2), 0);
            } else if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                PlaceComponentResult(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                PlaceComponentResult(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(type2), 0);
            }
        } else if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor BuiltInFictitiousFunctionClassFactory5 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor BuiltInFictitiousFunctionClassFactory6 = constraintWidget.BuiltInFictitiousFunctionClassFactory(type2);
            ConstraintAnchor BuiltInFictitiousFunctionClassFactory7 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT);
            BuiltInFictitiousFunctionClassFactory5.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory6, 0);
            BuiltInFictitiousFunctionClassFactory7.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory6, 0);
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_X).BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory6, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor BuiltInFictitiousFunctionClassFactory8 = constraintWidget.BuiltInFictitiousFunctionClassFactory(type2);
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP).BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory8, 0);
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM).BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory8, 0);
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_Y).BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory8, 0);
        } else if (type == ConstraintAnchor.Type.CENTER_X && type2 == ConstraintAnchor.Type.CENTER_X) {
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.LEFT), 0);
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.RIGHT), 0);
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_X).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(type2), 0);
        } else if (type == ConstraintAnchor.Type.CENTER_Y && type2 == ConstraintAnchor.Type.CENTER_Y) {
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP), 0);
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM), 0);
            BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_Y).BuiltInFictitiousFunctionClassFactory(constraintWidget.BuiltInFictitiousFunctionClassFactory(type2), 0);
        } else {
            ConstraintAnchor BuiltInFictitiousFunctionClassFactory9 = BuiltInFictitiousFunctionClassFactory(type);
            ConstraintAnchor BuiltInFictitiousFunctionClassFactory10 = constraintWidget.BuiltInFictitiousFunctionClassFactory(type2);
            if (BuiltInFictitiousFunctionClassFactory9.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory10)) {
                if (type == ConstraintAnchor.Type.BASELINE) {
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory11 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.TOP);
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory12 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BOTTOM);
                    if (BuiltInFictitiousFunctionClassFactory11 != null) {
                        BuiltInFictitiousFunctionClassFactory11.lookAheadTest();
                    }
                    if (BuiltInFictitiousFunctionClassFactory12 != null) {
                        BuiltInFictitiousFunctionClassFactory12.lookAheadTest();
                    }
                } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory13 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.BASELINE);
                    if (BuiltInFictitiousFunctionClassFactory13 != null) {
                        BuiltInFictitiousFunctionClassFactory13.lookAheadTest();
                    }
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory14 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER);
                    if (BuiltInFictitiousFunctionClassFactory14.moveToNextValue != BuiltInFictitiousFunctionClassFactory10) {
                        BuiltInFictitiousFunctionClassFactory14.lookAheadTest();
                    }
                    ConstraintAnchor PlaceComponentResult = BuiltInFictitiousFunctionClassFactory(type).PlaceComponentResult();
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory15 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_Y);
                    if (BuiltInFictitiousFunctionClassFactory15.scheduleImpl()) {
                        PlaceComponentResult.lookAheadTest();
                        BuiltInFictitiousFunctionClassFactory15.lookAheadTest();
                    }
                } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory16 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER);
                    if (BuiltInFictitiousFunctionClassFactory16.moveToNextValue != BuiltInFictitiousFunctionClassFactory10) {
                        BuiltInFictitiousFunctionClassFactory16.lookAheadTest();
                    }
                    ConstraintAnchor PlaceComponentResult2 = BuiltInFictitiousFunctionClassFactory(type).PlaceComponentResult();
                    ConstraintAnchor BuiltInFictitiousFunctionClassFactory17 = BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type.CENTER_X);
                    if (BuiltInFictitiousFunctionClassFactory17.scheduleImpl()) {
                        PlaceComponentResult2.lookAheadTest();
                        BuiltInFictitiousFunctionClassFactory17.lookAheadTest();
                    }
                }
                BuiltInFictitiousFunctionClassFactory9.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory10, i);
            }
        }
    }

    public final void getCallingPid() {
        getSupportButtonTintMode();
        float f = KClassImpl$Data$declaredNonStaticMembers$2;
        this.e = f;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = f;
    }

    public ConstraintAnchor BuiltInFictitiousFunctionClassFactory(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.getAuthRequestContext[type.ordinal()]) {
            case 1:
                return this.I;
            case 2:
                return this.f5939a;
            case 3:
                return this.c;
            case 4:
                return this.isLayoutRequested;
            case 5:
                return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            case 6:
                return this.newProxyInstance;
            case 7:
                return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
            case 8:
                return this.FragmentBottomSheetPaymentSettingBinding;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final boolean newProxyInstance() {
        if (this.I.moveToNextValue == null || this.I.moveToNextValue.moveToNextValue != this.I) {
            return this.c.moveToNextValue != null && this.c.moveToNextValue.moveToNextValue == this.c;
        }
        return true;
    }

    public final ConstraintWidget MyBillsEntityDataFactory(int i) {
        if (i == 0) {
            if (this.I.moveToNextValue != null) {
                ConstraintAnchor constraintAnchor = this.I.moveToNextValue.moveToNextValue;
                ConstraintAnchor constraintAnchor2 = this.I;
                if (constraintAnchor == constraintAnchor2) {
                    return constraintAnchor2.moveToNextValue.lookAheadTest;
                }
                return null;
            }
            return null;
        } else if (i != 1 || this.f5939a.moveToNextValue == null) {
            return null;
        } else {
            ConstraintAnchor constraintAnchor3 = this.f5939a.moveToNextValue.moveToNextValue;
            ConstraintAnchor constraintAnchor4 = this.f5939a;
            if (constraintAnchor3 == constraintAnchor4) {
                return constraintAnchor4.moveToNextValue.lookAheadTest;
            }
            return null;
        }
    }

    public final ConstraintWidget PlaceComponentResult(int i) {
        if (i == 0) {
            if (this.c.moveToNextValue != null) {
                ConstraintAnchor constraintAnchor = this.c.moveToNextValue.moveToNextValue;
                ConstraintAnchor constraintAnchor2 = this.c;
                if (constraintAnchor == constraintAnchor2) {
                    return constraintAnchor2.moveToNextValue.lookAheadTest;
                }
                return null;
            }
            return null;
        } else if (i != 1 || this.isLayoutRequested.moveToNextValue == null) {
            return null;
        } else {
            ConstraintAnchor constraintAnchor3 = this.isLayoutRequested.moveToNextValue.moveToNextValue;
            ConstraintAnchor constraintAnchor4 = this.isLayoutRequested;
            if (constraintAnchor3 == constraintAnchor4) {
                return constraintAnchor4.moveToNextValue.lookAheadTest;
            }
            return null;
        }
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda5() {
        if (this.f5939a.moveToNextValue == null || this.f5939a.moveToNextValue.moveToNextValue != this.f5939a) {
            return this.isLayoutRequested.moveToNextValue != null && this.isLayoutRequested.moveToNextValue.moveToNextValue == this.isLayoutRequested;
        }
        return true;
    }

    private boolean DatabaseTableConfigUtil(int i) {
        int i2 = i * 2;
        if (this.J[i2].moveToNextValue != null) {
            ConstraintAnchor constraintAnchor = this.J[i2].moveToNextValue.moveToNextValue;
            ConstraintAnchor[] constraintAnchorArr = this.J;
            if (constraintAnchor != constraintAnchorArr[i2]) {
                int i3 = i2 + 1;
                if (constraintAnchorArr[i3].moveToNextValue != null && this.J[i3].moveToNextValue.moveToNextValue == this.J[i3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void KClassImpl$Data$declaredNonStaticMembers$2(androidx.constraintlayout.core.LinearSystem r51, boolean r52) {
        /*
            Method dump skipped, instructions count: 1947
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.KClassImpl$Data$declaredNonStaticMembers$2(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean moveToNextValue() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0499 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x04ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:377:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void BuiltInFictitiousFunctionClassFactory(androidx.constraintlayout.core.LinearSystem r33, boolean r34, boolean r35, boolean r36, boolean r37, androidx.constraintlayout.core.SolverVariable r38, androidx.constraintlayout.core.SolverVariable r39, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r40, boolean r41, androidx.constraintlayout.core.widgets.ConstraintAnchor r42, androidx.constraintlayout.core.widgets.ConstraintAnchor r43, int r44, int r45, int r46, int r47, float r48, boolean r49, boolean r50, boolean r51, boolean r52, boolean r53, int r54, int r55, int r56, int r57, float r58, boolean r59) {
        /*
            Method dump skipped, instructions count: 1337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.BuiltInFictitiousFunctionClassFactory(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            getAuthRequestContext = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                getAuthRequestContext[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                getAuthRequestContext[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                getAuthRequestContext[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                getAuthRequestContext[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                getAuthRequestContext[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                getAuthRequestContext[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                getAuthRequestContext[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public void MyBillsEntityDataFactory(boolean z) {
        int i;
        int i2;
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int KClassImpl$Data$declaredNonStaticMembers$22 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.I);
        int KClassImpl$Data$declaredNonStaticMembers$23 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.f5939a);
        int KClassImpl$Data$declaredNonStaticMembers$24 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.c);
        int KClassImpl$Data$declaredNonStaticMembers$25 = LinearSystem.KClassImpl$Data$declaredNonStaticMembers$2(this.isLayoutRequested);
        if (z && (horizontalWidgetRun = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null && horizontalWidgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            KClassImpl$Data$declaredNonStaticMembers$22 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil;
            KClassImpl$Data$declaredNonStaticMembers$24 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.DatabaseTableConfigUtil;
        }
        if (z && (verticalWidgetRun = this.n) != null && verticalWidgetRun.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.n.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            KClassImpl$Data$declaredNonStaticMembers$23 = this.n.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil;
            KClassImpl$Data$declaredNonStaticMembers$25 = this.n.MyBillsEntityDataFactory.DatabaseTableConfigUtil;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$24 - KClassImpl$Data$declaredNonStaticMembers$22 < 0 || KClassImpl$Data$declaredNonStaticMembers$25 - KClassImpl$Data$declaredNonStaticMembers$23 < 0 || KClassImpl$Data$declaredNonStaticMembers$22 == Integer.MIN_VALUE || KClassImpl$Data$declaredNonStaticMembers$22 == Integer.MAX_VALUE || KClassImpl$Data$declaredNonStaticMembers$23 == Integer.MIN_VALUE || KClassImpl$Data$declaredNonStaticMembers$23 == Integer.MAX_VALUE || KClassImpl$Data$declaredNonStaticMembers$24 == Integer.MIN_VALUE || KClassImpl$Data$declaredNonStaticMembers$24 == Integer.MAX_VALUE || KClassImpl$Data$declaredNonStaticMembers$25 == Integer.MIN_VALUE || KClassImpl$Data$declaredNonStaticMembers$25 == Integer.MAX_VALUE) {
            KClassImpl$Data$declaredNonStaticMembers$22 = 0;
            KClassImpl$Data$declaredNonStaticMembers$23 = 0;
            KClassImpl$Data$declaredNonStaticMembers$24 = 0;
            KClassImpl$Data$declaredNonStaticMembers$25 = 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$24 - KClassImpl$Data$declaredNonStaticMembers$22;
        int i4 = KClassImpl$Data$declaredNonStaticMembers$25 - KClassImpl$Data$declaredNonStaticMembers$23;
        this.m = KClassImpl$Data$declaredNonStaticMembers$22;
        this.k = KClassImpl$Data$declaredNonStaticMembers$23;
        if (this.h == 8) {
            this.FlowViewUtil$textChanges$2 = 0;
            this.C = 0;
            return;
        }
        if (this.getNameOrBuilderList[0] == DimensionBehaviour.FIXED && i3 < (i2 = this.FlowViewUtil$textChanges$2)) {
            i3 = i2;
        }
        if (this.getNameOrBuilderList[1] == DimensionBehaviour.FIXED && i4 < (i = this.C)) {
            i4 = i;
        }
        this.FlowViewUtil$textChanges$2 = i3;
        this.C = i4;
        int i5 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        if (i4 < i5) {
            this.C = i5;
        }
        int i6 = this.U;
        if (i3 < i6) {
            this.FlowViewUtil$textChanges$2 = i6;
        }
        if (this.O > 0 && this.getNameOrBuilderList[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.FlowViewUtil$textChanges$2 = Math.min(this.FlowViewUtil$textChanges$2, this.O);
        }
        if (this.Q > 0 && this.getNameOrBuilderList[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.C = Math.min(this.C, this.Q);
        }
        int i7 = this.FlowViewUtil$textChanges$2;
        if (i3 != i7) {
            this.q = i7;
        }
        int i8 = this.C;
        if (i4 != i8) {
            this.getAuthRequestContext = i8;
        }
    }

    public void getAuthRequestContext(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.getValueOfTouchPositionAbsolute = constraintWidget.getValueOfTouchPositionAbsolute;
        this.FillAnimation = constraintWidget.FillAnimation;
        this.N = constraintWidget.N;
        this.K = constraintWidget.K;
        int[] iArr = this.b;
        int[] iArr2 = constraintWidget.b;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.P = constraintWidget.P;
        this.O = constraintWidget.O;
        this.SummaryVoucherView$$ExternalSyntheticLambda0 = constraintWidget.SummaryVoucherView$$ExternalSyntheticLambda0;
        this.Q = constraintWidget.Q;
        this.R = constraintWidget.R;
        this.F = constraintWidget.F;
        this.AppCompatEmojiTextHelper = constraintWidget.AppCompatEmojiTextHelper;
        this.Z = constraintWidget.Z;
        this.flip = constraintWidget.flip;
        int[] iArr3 = constraintWidget.SummaryVoucherView$$ExternalSyntheticLambda2;
        this.SummaryVoucherView$$ExternalSyntheticLambda2 = Arrays.copyOf(iArr3, iArr3.length);
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda3;
        this.scheduleImpl = constraintWidget.scheduleImpl;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.I.lookAheadTest();
        this.f5939a.lookAheadTest();
        this.c.lookAheadTest();
        this.isLayoutRequested.lookAheadTest();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.lookAheadTest();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.lookAheadTest();
        this.FragmentBottomSheetPaymentSettingBinding.lookAheadTest();
        this.newProxyInstance.lookAheadTest();
        this.getNameOrBuilderList = (DimensionBehaviour[]) Arrays.copyOf(this.getNameOrBuilderList, 2);
        this.W = this.W == null ? null : hashMap.get(constraintWidget.W);
        this.FlowViewUtil$textChanges$2 = constraintWidget.FlowViewUtil$textChanges$2;
        this.C = constraintWidget.C;
        this.SubSequence = constraintWidget.SubSequence;
        this.whenAvailable = constraintWidget.whenAvailable;
        this.m = constraintWidget.m;
        this.k = constraintWidget.k;
        this.Y = constraintWidget.Y;
        this.isAuto = constraintWidget.isAuto;
        this.V = constraintWidget.V;
        this.T = constraintWidget.T;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.U = constraintWidget.U;
        this.SummaryVoucherView$$ExternalSyntheticLambda1 = constraintWidget.SummaryVoucherView$$ExternalSyntheticLambda1;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = constraintWidget.BottomSheetCardBindingView$watcherCardNumberView$1;
        this.e = constraintWidget.e;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda6;
        this.BuiltInFictitiousFunctionClassFactory = constraintWidget.BuiltInFictitiousFunctionClassFactory;
        this.h = constraintWidget.h;
        this.DatabaseTableConfigUtil = constraintWidget.DatabaseTableConfigUtil;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = constraintWidget.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.s = constraintWidget.s;
        this.B = constraintWidget.B;
        this.readMicros = constraintWidget.readMicros;
        this.getSupportButtonTintMode = constraintWidget.getSupportButtonTintMode;
        this.getCallingPid = constraintWidget.getCallingPid;
        this.L = constraintWidget.L;
        this.d = constraintWidget.d;
        this.QrExpiredActivity = constraintWidget.QrExpiredActivity;
        this.PrepareContext = constraintWidget.PrepareContext;
        this.getOnBoardingScenario = constraintWidget.getOnBoardingScenario;
        this.FlowViewUtil$textChanges$1 = constraintWidget.FlowViewUtil$textChanges$1;
        this.E = constraintWidget.E;
        this.f = constraintWidget.f;
        this.A = constraintWidget.A;
        this.g = constraintWidget.g;
        float[] fArr = this.i;
        float[] fArr2 = constraintWidget.i;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.M;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.M;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.X;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.X;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.VerifyPinStateManager$executeRiskChallenge$2$2;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = constraintWidget2 == null ? null : hashMap.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.TypeProjectionImpl;
        this.TypeProjectionImpl = constraintWidget3 != null ? hashMap.get(constraintWidget3) : null;
    }

    public void getAuthRequestContext(boolean z, boolean z2) {
        int i;
        int i2;
        boolean errorConfigVersion = z & this.NetworkUserEntityData$$ExternalSyntheticLambda0.getErrorConfigVersion();
        boolean errorConfigVersion2 = z2 & this.n.getErrorConfigVersion();
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil;
        int i4 = this.n.NetworkUserEntityData$$ExternalSyntheticLambda1.DatabaseTableConfigUtil;
        int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.DatabaseTableConfigUtil;
        int i6 = this.n.MyBillsEntityDataFactory.DatabaseTableConfigUtil;
        if (i5 - i3 < 0 || i6 - i4 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        if (errorConfigVersion) {
            this.m = i3;
        }
        if (errorConfigVersion2) {
            this.k = i4;
        }
        if (this.h == 8) {
            this.FlowViewUtil$textChanges$2 = 0;
            this.C = 0;
            return;
        }
        if (errorConfigVersion) {
            if (this.getNameOrBuilderList[0] == DimensionBehaviour.FIXED && i7 < (i2 = this.FlowViewUtil$textChanges$2)) {
                i7 = i2;
            }
            this.FlowViewUtil$textChanges$2 = i7;
            int i9 = this.U;
            if (i7 < i9) {
                this.FlowViewUtil$textChanges$2 = i9;
            }
        }
        if (errorConfigVersion2) {
            if (this.getNameOrBuilderList[1] == DimensionBehaviour.FIXED && i8 < (i = this.C)) {
                i8 = i;
            }
            this.C = i8;
            int i10 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
            if (i8 < i10) {
                this.C = i10;
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            KClassImpl$Data$declaredNonStaticMembers$2(linearSystem, constraintWidgetContainer.initRecordTimeStamp(64));
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> hashSet2 = this.I.MyBillsEntityDataFactory;
            if (hashSet2 != null) {
                Iterator<ConstraintAnchor> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().lookAheadTest.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> hashSet3 = this.c.MyBillsEntityDataFactory;
            if (hashSet3 != null) {
                Iterator<ConstraintAnchor> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().lookAheadTest.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer, linearSystem, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> hashSet4 = this.f5939a.MyBillsEntityDataFactory;
        if (hashSet4 != null) {
            Iterator<ConstraintAnchor> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().lookAheadTest.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> hashSet5 = this.isLayoutRequested.MyBillsEntityDataFactory;
        if (hashSet5 != null) {
            Iterator<ConstraintAnchor> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().lookAheadTest.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> hashSet6 = this.NetworkUserEntityData$$ExternalSyntheticLambda8.MyBillsEntityDataFactory;
        if (hashSet6 != null) {
            Iterator<ConstraintAnchor> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().lookAheadTest.BuiltInFictitiousFunctionClassFactory(constraintWidgetContainer, linearSystem, hashSet, i, true);
            }
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("  ");
        sb2.append(this.l);
        sb2.append(":{\n");
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("    actualWidth:");
        sb3.append(this.FlowViewUtil$textChanges$2);
        sb.append(sb3.toString());
        sb.append("\n");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("    actualHeight:");
        sb4.append(this.C);
        sb.append(sb4.toString());
        sb.append("\n");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("    actualLeft:");
        sb5.append(this.m);
        sb.append(sb5.toString());
        sb.append("\n");
        StringBuilder sb6 = new StringBuilder();
        sb6.append("    actualTop:");
        sb6.append(this.k);
        sb.append(sb6.toString());
        sb.append("\n");
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "left", this.I);
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "top", this.f5939a);
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "right", this.c);
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "bottom", this.isLayoutRequested);
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "baseline", this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "centerX", this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "centerY", this.FragmentBottomSheetPaymentSettingBinding);
        int i = this.FlowViewUtil$textChanges$2;
        int i2 = this.U;
        int i3 = this.SummaryVoucherView$$ExternalSyntheticLambda2[0];
        int i4 = this.P;
        int i5 = this.N;
        float f = this.S;
        float f2 = this.i[0];
        PlaceComponentResult(sb, "    width", i, i2, i3, i4, i5, f);
        int i6 = this.C;
        int i7 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        int i8 = this.SummaryVoucherView$$ExternalSyntheticLambda2[1];
        int i9 = this.SummaryVoucherView$$ExternalSyntheticLambda0;
        int i10 = this.K;
        float f3 = this.R;
        float f4 = this.i[1];
        PlaceComponentResult(sb, "    height", i6, i7, i8, i9, i10, f3);
        float f5 = this.SubSequence;
        int i11 = this.whenAvailable;
        if (f5 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f5);
            sb.append(",");
            sb.append(i11);
            sb.append("],\n");
        }
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "    horizontalBias", this.BottomSheetCardBindingView$watcherCardNumberView$1, KClassImpl$Data$declaredNonStaticMembers$2);
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "    verticalBias", this.e, KClassImpl$Data$declaredNonStaticMembers$2);
        getAuthRequestContext(sb, "    horizontalChainStyle", this.E, 0);
        getAuthRequestContext(sb, "    verticalChainStyle", this.f, 0);
        sb.append("  }");
    }

    private static void PlaceComponentResult(StringBuilder sb, String str, int i, int i2, int i3, int i4, int i5, float f) {
        sb.append(str);
        sb.append(" :  {\n");
        getAuthRequestContext(sb, "      size", i, 0);
        getAuthRequestContext(sb, "      min", i2, 0);
        getAuthRequestContext(sb, "      max", i3, Integer.MAX_VALUE);
        getAuthRequestContext(sb, "      matchMin", i4, 0);
        getAuthRequestContext(sb, "      matchDef", i5, 0);
        KClassImpl$Data$declaredNonStaticMembers$2(sb, "      matchPercent", f, 1.0f);
        sb.append("    },\n");
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.moveToNextValue == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(constraintAnchor.moveToNextValue);
        sb.append("'");
        if (constraintAnchor.BuiltInFictitiousFunctionClassFactory != Integer.MIN_VALUE || constraintAnchor.getAuthRequestContext != 0) {
            sb.append(",");
            sb.append(constraintAnchor.getAuthRequestContext);
            if (constraintAnchor.BuiltInFictitiousFunctionClassFactory != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.BuiltInFictitiousFunctionClassFactory);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public final void getSupportButtonTintMode() {
        ConstraintWidget constraintWidget = this.W;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget;
        }
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda1.size();
        for (int i = 0; i < size; i++) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(i).lookAheadTest();
        }
    }
}
