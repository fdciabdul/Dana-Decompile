package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class KeyPosition extends KeyPositionBase {
    String isLayoutRequested = null;
    int NetworkUserEntityData$$ExternalSyntheticLambda0 = PlaceComponentResult;
    int getErrorConfigVersion = 0;
    float initRecordTimeStamp = Float.NaN;
    float DatabaseTableConfigUtil = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda2 = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.NaN;
    float moveToNextValue = Float.NaN;
    float lookAheadTest = Float.NaN;
    public int GetContactSyncConfig = 0;
    private float NetworkUserEntityData$$ExternalSyntheticLambda8 = Float.NaN;
    private float PrepareContext = Float.NaN;

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void PlaceComponentResult(HashMap<String, ViewSpline> hashMap) {
    }

    public KeyPosition() {
        this.scheduleImpl = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void getAuthRequestContext(Context context, AttributeSet attributeSet) {
        Loader.BuiltInFictitiousFunctionClassFactory(this, context.obtainStyledAttributes(attributeSet, R.styleable.isPerformanceLogEnable));
    }

    /* loaded from: classes6.dex */
    static class Loader {
        private static SparseIntArray getAuthRequestContext;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            getAuthRequestContext = sparseIntArray;
            sparseIntArray.append(R.styleable.DynamicExtension, 1);
            getAuthRequestContext.append(R.styleable.AMapUtil, 2);
            getAuthRequestContext.append(R.styleable.access$getArgumentsDepth, 3);
            getAuthRequestContext.append(R.styleable.getShadowCompatRotation, 4);
            getAuthRequestContext.append(R.styleable.GriverEmptyMonitor, 5);
            getAuthRequestContext.append(R.styleable.setmSubmitInterface, 6);
            getAuthRequestContext.append(R.styleable.getCSSRules, 7);
            getAuthRequestContext.append(R.styleable.BaseRpcFacadeInvoker$1, 9);
            getAuthRequestContext.append(R.styleable.actualDraw, 8);
            getAuthRequestContext.append(R.styleable.ConfirmUpdateBalanceEmoney, 11);
            getAuthRequestContext.append(R.styleable.getAaid, 12);
            getAuthRequestContext.append(R.styleable.CompletableCache$InnerCompletableCache, 10);
        }

        static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (getAuthRequestContext.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyPosition.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyPosition.KClassImpl$Data$declaredNonStaticMembers$2);
                            if (keyPosition.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                                keyPosition.getAuthRequestContext = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyPosition.getAuthRequestContext = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyPosition.KClassImpl$Data$declaredNonStaticMembers$2);
                            break;
                        }
                    case 2:
                        keyPosition.BuiltInFictitiousFunctionClassFactory = typedArray.getInt(index, keyPosition.BuiltInFictitiousFunctionClassFactory);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            keyPosition.isLayoutRequested = typedArray.getString(index);
                            break;
                        } else {
                            keyPosition.isLayoutRequested = Easing.PlaceComponentResult[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        keyPosition.newProxyInstance = typedArray.getInteger(index, keyPosition.newProxyInstance);
                        break;
                    case 5:
                        keyPosition.getErrorConfigVersion = typedArray.getInt(index, keyPosition.getErrorConfigVersion);
                        break;
                    case 6:
                        keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2 = typedArray.getFloat(index, keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        break;
                    case 7:
                        keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1 = typedArray.getFloat(index, keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        break;
                    case 8:
                        float f = typedArray.getFloat(index, keyPosition.DatabaseTableConfigUtil);
                        keyPosition.initRecordTimeStamp = f;
                        keyPosition.DatabaseTableConfigUtil = f;
                        break;
                    case 9:
                        keyPosition.GetContactSyncConfig = typedArray.getInt(index, keyPosition.GetContactSyncConfig);
                        break;
                    case 10:
                        keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getInt(index, keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        break;
                    case 11:
                        keyPosition.initRecordTimeStamp = typedArray.getFloat(index, keyPosition.initRecordTimeStamp);
                        break;
                    case 12:
                        keyPosition.DatabaseTableConfigUtil = typedArray.getFloat(index, keyPosition.DatabaseTableConfigUtil);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(getAuthRequestContext.get(index));
                        InstrumentInjector.log_e(TypedValues.PositionType.getAuthRequestContext, sb.toString());
                        break;
                }
            }
            if (keyPosition.BuiltInFictitiousFunctionClassFactory == -1) {
                InstrumentInjector.log_e(TypedValues.PositionType.getAuthRequestContext, "no frame position");
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void getAuthRequestContext(String str, Object obj) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                this.isLayoutRequested = obj.toString();
                return;
            case 1:
                this.initRecordTimeStamp = Float.parseFloat(obj.toString());
                return;
            case 2:
                this.DatabaseTableConfigUtil = Float.parseFloat(obj.toString());
                return;
            case 3:
                this.getErrorConfigVersion = obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
                return;
            case 4:
                float parseFloat = Float.parseFloat(obj.toString());
                this.initRecordTimeStamp = parseFloat;
                this.DatabaseTableConfigUtil = parseFloat;
                return;
            case 5:
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Float.parseFloat(obj.toString());
                return;
            case 6:
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.parseFloat(obj.toString());
                return;
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final Key KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.isLayoutRequested = keyPosition.isLayoutRequested;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.getErrorConfigVersion = keyPosition.getErrorConfigVersion;
        this.initRecordTimeStamp = keyPosition.initRecordTimeStamp;
        this.DatabaseTableConfigUtil = Float.NaN;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.moveToNextValue = keyPosition.moveToNextValue;
        this.lookAheadTest = keyPosition.lookAheadTest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = keyPosition.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.PrepareContext = keyPosition.PrepareContext;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final Key clone() {
        return new KeyPosition().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new KeyPosition().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }
}
