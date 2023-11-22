package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class ConstraintReference implements Reference {
    final State H;
    String F = null;
    Facade scheduleImpl = null;
    int GetContactSyncConfig = 0;
    int O = 0;
    float NetworkUserEntityData$$ExternalSyntheticLambda1 = -1.0f;
    float Q = -1.0f;
    float initRecordTimeStamp = 0.5f;
    float K = 0.5f;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda4 = 0;
    protected int getSupportButtonTintMode = 0;
    protected int SubSequence = 0;
    protected int FragmentBottomSheetPaymentSettingBinding = 0;
    protected int whenAvailable = 0;
    protected int newProxyInstance = 0;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda3 = 0;
    protected int readMicros = 0;
    protected int getCallingPid = 0;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
    protected int B = 0;
    protected int NetworkUserEntityData$$ExternalSyntheticLambda6 = 0;
    int PrepareContext = 0;
    int NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    float BottomSheetCardBindingView$watcherCardNumberView$1 = Float.NaN;
    float C = Float.NaN;
    float getOnBoardingScenario = Float.NaN;
    float VerifyPinStateManager$executeRiskChallenge$2$2 = Float.NaN;
    float getValueOfTouchPositionAbsolute = Float.NaN;
    float getNameOrBuilderList = Float.NaN;
    float J = Float.NaN;
    float L = Float.NaN;
    float KClassImpl$Data$declaredNonStaticMembers$2 = Float.NaN;
    float E = Float.NaN;
    float D = Float.NaN;
    int P = 0;
    protected Object isLayoutRequested = null;
    protected Object NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
    protected Object VerifyPinStateManager$executeRiskChallenge$2$1 = null;
    protected Object A = null;
    protected Object AppCompatEmojiTextHelper = null;
    protected Object G = null;
    protected Object getErrorConfigVersion = null;
    protected Object NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    protected Object M = null;
    protected Object I = null;
    protected Object lookAheadTest = null;
    protected Object MyBillsEntityDataFactory = null;
    Object BuiltInFictitiousFunctionClassFactory = null;
    Object getAuthRequestContext = null;
    Object PlaceComponentResult = null;
    Object moveToNextValue = null;
    State.Constraint NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
    Dimension DatabaseTableConfigUtil = Dimension.PlaceComponentResult(Dimension.NetworkUserEntityData$$ExternalSyntheticLambda0);
    Dimension SummaryVoucherView$$ExternalSyntheticLambda0 = Dimension.PlaceComponentResult(Dimension.NetworkUserEntityData$$ExternalSyntheticLambda0);
    private HashMap<String, Integer> N = new HashMap<>();
    private HashMap<String, Float> S = new HashMap<>();

    /* loaded from: classes6.dex */
    public interface ConstraintReferenceFactory {
    }

    /* loaded from: classes6.dex */
    static class IncorrectConstraintException extends Exception {
        private final ArrayList<String> mErrors;

        public IncorrectConstraintException(ArrayList<String> arrayList) {
            this.mErrors = arrayList;
        }

        public ArrayList<String> getErrors() {
            return this.mErrors;
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("IncorrectConstraintException: ");
            sb.append(this.mErrors.toString());
            return sb.toString();
        }
    }

    public ConstraintReference(State state) {
        this.H = state;
    }

    /* renamed from: androidx.constraintlayout.core.state.ConstraintReference$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[State.Constraint.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[State.Constraint.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[State.Constraint.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[State.Constraint.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[State.Constraint.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[State.Constraint.START_TO_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[State.Constraint.START_TO_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                getAuthRequestContext[State.Constraint.END_TO_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                getAuthRequestContext[State.Constraint.END_TO_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                getAuthRequestContext[State.Constraint.TOP_TO_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                getAuthRequestContext[State.Constraint.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                getAuthRequestContext[State.Constraint.BOTTOM_TO_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                getAuthRequestContext[State.Constraint.BOTTOM_TO_BOTTOM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                getAuthRequestContext[State.Constraint.BASELINE_TO_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                getAuthRequestContext[State.Constraint.BASELINE_TO_TOP.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                getAuthRequestContext[State.Constraint.BASELINE_TO_BASELINE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                getAuthRequestContext[State.Constraint.CIRCULAR_CONSTRAINT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                getAuthRequestContext[State.Constraint.CENTER_HORIZONTALLY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                getAuthRequestContext[State.Constraint.CENTER_VERTICALLY.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }
}
