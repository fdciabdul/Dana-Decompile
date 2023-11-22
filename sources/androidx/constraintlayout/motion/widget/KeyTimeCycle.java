package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class KeyTimeCycle extends Key {
    private String FragmentBottomSheetPaymentSettingBinding;
    private int NetworkUserEntityData$$ExternalSyntheticLambda3 = -1;
    float getErrorConfigVersion = Float.NaN;
    float moveToNextValue = Float.NaN;
    float lookAheadTest = Float.NaN;
    float initRecordTimeStamp = Float.NaN;
    float DatabaseTableConfigUtil = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda2 = Float.NaN;
    float GetContactSyncConfig = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda7 = Float.NaN;
    float newProxyInstance = Float.NaN;
    float PrepareContext = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda0 = Float.NaN;
    int NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
    private String NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
    float isLayoutRequested = Float.NaN;
    float NetworkUserEntityData$$ExternalSyntheticLambda8 = 0.0f;

    public KeyTimeCycle() {
        this.scheduleImpl = 3;
        this.MyBillsEntityDataFactory = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void getAuthRequestContext(Context context, AttributeSet attributeSet) {
        Loader.getAuthRequestContext(this, context.obtainStyledAttributes(attributeSet, R.styleable.SequencesKt___SequencesKt$filterNotNull$1));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void PlaceComponentResult(HashSet<String> hashSet) {
        if (!Float.isNaN(this.getErrorConfigVersion)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.moveToNextValue)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.lookAheadTest)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.initRecordTimeStamp)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.DatabaseTableConfigUtil)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.newProxyInstance)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.PrepareContext)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.GetContactSyncConfig)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            hashSet.add("progress");
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
    public final void MyBillsEntityDataFactory(HashMap<String, Integer> hashMap) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 == -1) {
            return;
        }
        if (!Float.isNaN(this.getErrorConfigVersion)) {
            hashMap.put("alpha", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.moveToNextValue)) {
            hashMap.put("elevation", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.lookAheadTest)) {
            hashMap.put("rotation", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.initRecordTimeStamp)) {
            hashMap.put("rotationX", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.DatabaseTableConfigUtil)) {
            hashMap.put("rotationY", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            hashMap.put("translationX", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.newProxyInstance)) {
            hashMap.put("translationY", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.PrepareContext)) {
            hashMap.put("translationZ", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.GetContactSyncConfig)) {
            hashMap.put("scaleX", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.GetContactSyncConfig)) {
            hashMap.put("scaleY", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            hashMap.put("progress", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
        }
        if (this.MyBillsEntityDataFactory.size() > 0) {
            for (String str : this.MyBillsEntityDataFactory.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("CUSTOM,");
                sb.append(str);
                hashMap.put(sb.toString(), Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda3));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void PlaceComponentResult(HashMap<String, ViewSpline> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    /* loaded from: classes6.dex */
    static class Loader {
        private static SparseIntArray MyBillsEntityDataFactory;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            MyBillsEntityDataFactory = sparseIntArray;
            sparseIntArray.append(R.styleable.LogEventDropped$Reason, 1);
            MyBillsEntityDataFactory.append(R.styleable.setAllAttributes, 2);
            MyBillsEntityDataFactory.append(R.styleable.access$getSelectOpSequenceNumber$p, 4);
            MyBillsEntityDataFactory.append(R.styleable.DaggerOauthGrantComponent$OauthGrantComponentImpl$PostExecutionThreadProvider, 5);
            MyBillsEntityDataFactory.append(R.styleable.getPresetAppInfos, 6);
            MyBillsEntityDataFactory.append(R.styleable.f14$r8$lambda$lNslH7bN2MzxI8TFxssBVYVFg, 7);
            MyBillsEntityDataFactory.append(R.styleable.AccessibilityNodeProvider, 8);
            MyBillsEntityDataFactory.append(R.styleable.shouldSendGlobalHeartBeat, 9);
            MyBillsEntityDataFactory.append(R.styleable.isJavaCrash, 10);
            MyBillsEntityDataFactory.append(R.styleable.ExpressPurchasePresenter$quickBuyInsurance$2, 12);
            MyBillsEntityDataFactory.append(R.styleable.Ref$IntRef, 13);
            MyBillsEntityDataFactory.append(R.styleable.ExpressPurchasePresenter$quickBuyInsurance$1, 14);
            MyBillsEntityDataFactory.append(R.styleable.findFocus, 15);
            MyBillsEntityDataFactory.append(R.styleable.f29xa4c0a625, 16);
            MyBillsEntityDataFactory.append(R.styleable.SQLiteOpenHelper, 17);
            MyBillsEntityDataFactory.append(R.styleable.NavViewModelStoreProvider, 18);
            MyBillsEntityDataFactory.append(R.styleable.ArrayBasedEscaperMap, 20);
            MyBillsEntityDataFactory.append(R.styleable.RawResultCallback, 21);
            MyBillsEntityDataFactory.append(R.styleable.DaggerPayMethodComponent$PayMethodComponentImpl$FeatureConfigRepositoryProvider, 19);
        }

        public static void getAuthRequestContext(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (MyBillsEntityDataFactory.get(index)) {
                    case 1:
                        keyTimeCycle.getErrorConfigVersion = typedArray.getFloat(index, keyTimeCycle.getErrorConfigVersion);
                        break;
                    case 2:
                        keyTimeCycle.moveToNextValue = typedArray.getDimension(index, keyTimeCycle.moveToNextValue);
                        break;
                    case 3:
                    case 11:
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(MyBillsEntityDataFactory.get(index));
                        InstrumentInjector.log_e("KeyTimeCycle", sb.toString());
                        break;
                    case 4:
                        keyTimeCycle.lookAheadTest = typedArray.getFloat(index, keyTimeCycle.lookAheadTest);
                        break;
                    case 5:
                        keyTimeCycle.initRecordTimeStamp = typedArray.getFloat(index, keyTimeCycle.initRecordTimeStamp);
                        break;
                    case 6:
                        keyTimeCycle.DatabaseTableConfigUtil = typedArray.getFloat(index, keyTimeCycle.DatabaseTableConfigUtil);
                        break;
                    case 7:
                        keyTimeCycle.GetContactSyncConfig = typedArray.getFloat(index, keyTimeCycle.GetContactSyncConfig);
                        break;
                    case 8:
                        keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda2 = typedArray.getFloat(index, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        break;
                    case 9:
                        keyTimeCycle.FragmentBottomSheetPaymentSettingBinding = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyTimeCycle.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyTimeCycle.KClassImpl$Data$declaredNonStaticMembers$2);
                            if (keyTimeCycle.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                                keyTimeCycle.getAuthRequestContext = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTimeCycle.getAuthRequestContext = typedArray.getString(index);
                            break;
                        } else {
                            keyTimeCycle.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyTimeCycle.KClassImpl$Data$declaredNonStaticMembers$2);
                            break;
                        }
                    case 12:
                        keyTimeCycle.BuiltInFictitiousFunctionClassFactory = typedArray.getInt(index, keyTimeCycle.BuiltInFictitiousFunctionClassFactory);
                        break;
                    case 13:
                        keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda3 = typedArray.getInteger(index, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        break;
                    case 14:
                        keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda1 = typedArray.getFloat(index, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        break;
                    case 15:
                        keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda7 = typedArray.getDimension(index, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda7);
                        break;
                    case 16:
                        keyTimeCycle.newProxyInstance = typedArray.getDimension(index, keyTimeCycle.newProxyInstance);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            keyTimeCycle.PrepareContext = typedArray.getDimension(index, keyTimeCycle.PrepareContext);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getFloat(index, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type == 3) {
                            keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda4 = typedArray.getString(index);
                            keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5 = 7;
                            break;
                        } else {
                            keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5 = typedArray.getInt(index, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5);
                            break;
                        }
                    case 20:
                        keyTimeCycle.isLayoutRequested = typedArray.getFloat(index, keyTimeCycle.isLayoutRequested);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8 = typedArray.getDimension(index, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                            break;
                        } else {
                            keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8 = typedArray.getFloat(index, keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8);
                            break;
                        }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final Key KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(key);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) key;
        this.FragmentBottomSheetPaymentSettingBinding = keyTimeCycle.FragmentBottomSheetPaymentSettingBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda5;
        this.isLayoutRequested = keyTimeCycle.isLayoutRequested;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.getErrorConfigVersion = keyTimeCycle.getErrorConfigVersion;
        this.moveToNextValue = keyTimeCycle.moveToNextValue;
        this.lookAheadTest = keyTimeCycle.lookAheadTest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.initRecordTimeStamp = keyTimeCycle.initRecordTimeStamp;
        this.DatabaseTableConfigUtil = keyTimeCycle.DatabaseTableConfigUtil;
        this.GetContactSyncConfig = keyTimeCycle.GetContactSyncConfig;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = keyTimeCycle.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.newProxyInstance = keyTimeCycle.newProxyInstance;
        this.PrepareContext = keyTimeCycle.PrepareContext;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final Key clone() {
        return new KeyTimeCycle().KClassImpl$Data$declaredNonStaticMembers$2((Key) this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new KeyTimeCycle().KClassImpl$Data$declaredNonStaticMembers$2((Key) this);
    }
}
