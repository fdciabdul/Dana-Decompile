package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class KeyCycle extends Key {
    private String readMicros = null;
    private int FragmentBottomSheetPaymentSettingBinding = 0;
    int NetworkUserEntityData$$ExternalSyntheticLambda4 = -1;
    String NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    float NetworkUserEntityData$$ExternalSyntheticLambda6 = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda7 = 0.0f;
    float NetworkUserEntityData$$ExternalSyntheticLambda3 = 0.0f;
    float getErrorConfigVersion = Float.NaN;
    int NetworkUserEntityData$$ExternalSyntheticLambda5 = -1;
    float moveToNextValue = Float.NaN;
    float lookAheadTest = Float.NaN;
    float initRecordTimeStamp = Float.NaN;
    float newProxyInstance = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.NaN;
    float DatabaseTableConfigUtil = Float.NaN;
    float GetContactSyncConfig = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda2 = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda8 = Float.NaN;
    float isLayoutRequested = Float.NaN;
    float PrepareContext = Float.NaN;

    public KeyCycle() {
        this.scheduleImpl = 4;
        this.MyBillsEntityDataFactory = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void getAuthRequestContext(Context context, AttributeSet attributeSet) {
        Loader.getAuthRequestContext(this, context.obtainStyledAttributes(attributeSet, R.styleable.GetUserStatusInfo$Param));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void PlaceComponentResult(HashSet<String> hashSet) {
        if (!Float.isNaN(this.moveToNextValue)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.lookAheadTest)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.initRecordTimeStamp)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.DatabaseTableConfigUtil)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.GetContactSyncConfig)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.newProxyInstance)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.isLayoutRequested)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.PrepareContext)) {
            hashSet.add("translationZ");
        }
        if (this.MyBillsEntityDataFactory.size() > 0) {
            for (String str : this.MyBillsEntityDataFactory.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("CUSTOM,");
                sb.append(str);
                hashSet.add(sb.toString());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void PlaceComponentResult(HashMap<String, ViewSpline> hashMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("add ");
        sb.append(hashMap.size());
        sb.append(" values");
        Debug.PlaceComponentResult(TypedValues.CycleType.KClassImpl$Data$declaredNonStaticMembers$2, sb.toString());
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(str);
            if (viewSpline != null) {
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            c = 7;
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            c = '\r';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        continue;
                    case 1:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.DatabaseTableConfigUtil);
                        continue;
                    case 2:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                        continue;
                    case 3:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.isLayoutRequested);
                        continue;
                    case 4:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.PrepareContext);
                        continue;
                    case 5:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.getErrorConfigVersion);
                        continue;
                    case 6:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.GetContactSyncConfig);
                        continue;
                    case 7:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        continue;
                    case '\b':
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.initRecordTimeStamp);
                        continue;
                    case '\t':
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.lookAheadTest);
                        continue;
                    case '\n':
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.newProxyInstance);
                        continue;
                    case 11:
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.moveToNextValue);
                        continue;
                    case '\f':
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                        continue;
                    case '\r':
                        viewSpline.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        continue;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("  UNKNOWN  ");
                            sb2.append(str);
                            InstrumentInjector.log_v("WARNING KeyCycle", sb2.toString());
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    static class Loader {
        private static SparseIntArray KClassImpl$Data$declaredNonStaticMembers$2;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            KClassImpl$Data$declaredNonStaticMembers$2 = sparseIntArray;
            sparseIntArray.append(R.styleable.CrashUtils, 1);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.setSnapshotHtml, 2);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.MediaCodec$OutputFrame, 3);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.AmountFormFragment$onBackPressedCallback$1, 4);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.AUTextView$OnTextViewTextChangeListener, 5);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.FlowableSequenceEqual$EqualCoordinator, 6);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.f27isInNanosimpl, 7);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.MePageRevampPresenter_Factory, 8);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.impressionsCount, 9);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.getSubStringLengthPer9Digit, 10);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.DaggerSavingTopUpHistoryComponent$SavingTopUpHistoryComponentImpl$ContextProvider, 11);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.getAppStack, 12);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.DaggerMoreForYouComponent$MoreForYouComponentImpl$ProvideMoreForYouRepositoryProvider, 13);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.z$10, 14);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.selectedFolder, 15);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.MutedFragmentContract$View, 16);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.setMapper, 17);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.FragmentState$1, 18);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.BarcodeEncoder, 19);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.AlarmManagerCompat, 20);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.parseAtRule, 21);
        }

        static /* synthetic */ void getAuthRequestContext(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (KClassImpl$Data$declaredNonStaticMembers$2.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyCycle.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyCycle.KClassImpl$Data$declaredNonStaticMembers$2);
                            if (keyCycle.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                                keyCycle.getAuthRequestContext = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyCycle.getAuthRequestContext = typedArray.getString(index);
                            break;
                        } else {
                            keyCycle.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyCycle.KClassImpl$Data$declaredNonStaticMembers$2);
                            break;
                        }
                    case 2:
                        keyCycle.BuiltInFictitiousFunctionClassFactory = typedArray.getInt(index, keyCycle.BuiltInFictitiousFunctionClassFactory);
                        break;
                    case 3:
                        keyCycle.readMicros = typedArray.getString(index);
                        break;
                    case 4:
                        keyCycle.FragmentBottomSheetPaymentSettingBinding = typedArray.getInteger(index, keyCycle.FragmentBottomSheetPaymentSettingBinding);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getString(index);
                            keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda4 = 7;
                            break;
                        } else {
                            keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda4 = typedArray.getInt(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda4);
                            break;
                        }
                    case 6:
                        keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda6 = typedArray.getFloat(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda6);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda7 = typedArray.getDimension(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda7);
                            break;
                        } else {
                            keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda7 = typedArray.getFloat(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda7);
                            break;
                        }
                    case 8:
                        keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda5 = typedArray.getInt(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda5);
                        break;
                    case 9:
                        keyCycle.moveToNextValue = typedArray.getFloat(index, keyCycle.moveToNextValue);
                        break;
                    case 10:
                        keyCycle.lookAheadTest = typedArray.getDimension(index, keyCycle.lookAheadTest);
                        break;
                    case 11:
                        keyCycle.initRecordTimeStamp = typedArray.getFloat(index, keyCycle.initRecordTimeStamp);
                        break;
                    case 12:
                        keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda1 = typedArray.getFloat(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        break;
                    case 13:
                        keyCycle.DatabaseTableConfigUtil = typedArray.getFloat(index, keyCycle.DatabaseTableConfigUtil);
                        break;
                    case 14:
                        keyCycle.newProxyInstance = typedArray.getFloat(index, keyCycle.newProxyInstance);
                        break;
                    case 15:
                        keyCycle.GetContactSyncConfig = typedArray.getFloat(index, keyCycle.GetContactSyncConfig);
                        break;
                    case 16:
                        keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda2 = typedArray.getFloat(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        break;
                    case 17:
                        keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda8 = typedArray.getDimension(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                        break;
                    case 18:
                        keyCycle.isLayoutRequested = typedArray.getDimension(index, keyCycle.isLayoutRequested);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT >= 21) {
                            keyCycle.PrepareContext = typedArray.getDimension(index, keyCycle.PrepareContext);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        keyCycle.getErrorConfigVersion = typedArray.getFloat(index, keyCycle.getErrorConfigVersion);
                        break;
                    case 21:
                        keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda3 = typedArray.getFloat(index, keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda3) / 360.0f;
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(KClassImpl$Data$declaredNonStaticMembers$2.get(index));
                        InstrumentInjector.log_e(TypedValues.CycleType.KClassImpl$Data$declaredNonStaticMembers$2, sb.toString());
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final Key KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.readMicros = keyCycle.readMicros;
        this.FragmentBottomSheetPaymentSettingBinding = keyCycle.FragmentBottomSheetPaymentSettingBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda3;
        this.getErrorConfigVersion = keyCycle.getErrorConfigVersion;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda5;
        this.moveToNextValue = keyCycle.moveToNextValue;
        this.lookAheadTest = keyCycle.lookAheadTest;
        this.initRecordTimeStamp = keyCycle.initRecordTimeStamp;
        this.newProxyInstance = keyCycle.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.DatabaseTableConfigUtil = keyCycle.DatabaseTableConfigUtil;
        this.GetContactSyncConfig = keyCycle.GetContactSyncConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = keyCycle.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.isLayoutRequested = keyCycle.isLayoutRequested;
        this.PrepareContext = keyCycle.PrepareContext;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final Key clone() {
        return new KeyCycle().KClassImpl$Data$declaredNonStaticMembers$2((Key) this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new KeyCycle().KClassImpl$Data$declaredNonStaticMembers$2((Key) this);
    }
}
