package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class KeyAttributes extends Key {
    private String newProxyInstance;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
    private float getErrorConfigVersion = Float.NaN;
    private float lookAheadTest = Float.NaN;
    private float DatabaseTableConfigUtil = Float.NaN;
    private float GetContactSyncConfig = Float.NaN;
    private float initRecordTimeStamp = Float.NaN;
    private float moveToNextValue = Float.NaN;
    private float NetworkUserEntityData$$ExternalSyntheticLambda1 = Float.NaN;
    private float isLayoutRequested = Float.NaN;
    private float PrepareContext = Float.NaN;
    private float NetworkUserEntityData$$ExternalSyntheticLambda8 = Float.NaN;
    private float NetworkUserEntityData$$ExternalSyntheticLambda7 = Float.NaN;
    private float NetworkUserEntityData$$ExternalSyntheticLambda5 = Float.NaN;
    private float NetworkUserEntityData$$ExternalSyntheticLambda4 = Float.NaN;
    private float NetworkUserEntityData$$ExternalSyntheticLambda2 = Float.NaN;

    public KeyAttributes() {
        this.scheduleImpl = 1;
        this.MyBillsEntityDataFactory = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void getAuthRequestContext(Context context, AttributeSet attributeSet) {
        Loader.KClassImpl$Data$declaredNonStaticMembers$2(this, context.obtainStyledAttributes(attributeSet, R.styleable.RoundedCornerTreatment));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void PlaceComponentResult(HashSet<String> hashSet) {
        if (!Float.isNaN(this.getErrorConfigVersion)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.lookAheadTest)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.DatabaseTableConfigUtil)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.GetContactSyncConfig)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.initRecordTimeStamp)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.moveToNextValue)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda5)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda4)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.isLayoutRequested)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.PrepareContext)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
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
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == -1) {
            return;
        }
        if (!Float.isNaN(this.getErrorConfigVersion)) {
            hashMap.put("alpha", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.lookAheadTest)) {
            hashMap.put("elevation", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.DatabaseTableConfigUtil)) {
            hashMap.put("rotation", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.GetContactSyncConfig)) {
            hashMap.put("rotationX", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.initRecordTimeStamp)) {
            hashMap.put("rotationY", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.moveToNextValue)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            hashMap.put("translationX", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda5)) {
            hashMap.put("translationY", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda4)) {
            hashMap.put("translationZ", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.isLayoutRequested)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.PrepareContext)) {
            hashMap.put("scaleX", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            hashMap.put("scaleY", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (!Float.isNaN(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            hashMap.put("progress", Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        }
        if (this.MyBillsEntityDataFactory.size() > 0) {
            for (String str : this.MyBillsEntityDataFactory.keySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append("CUSTOM,");
                sb.append(str);
                hashMap.put(sb.toString(), Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
    
        if (r1.equals("scaleY") == false) goto L57;
     */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r6) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.PlaceComponentResult(java.util.HashMap):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void MyBillsEntityDataFactory(String str, Object obj) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 16;
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
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 1:
                this.newProxyInstance = obj.toString();
                return;
            case 2:
                this.GetContactSyncConfig = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 3:
                this.initRecordTimeStamp = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 4:
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 5:
                this.NetworkUserEntityData$$ExternalSyntheticLambda5 = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 6:
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 7:
                this.PrepareContext = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case '\b':
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case '\t':
                this.moveToNextValue = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case '\n':
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 11:
                this.DatabaseTableConfigUtil = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case '\f':
                this.lookAheadTest = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case '\r':
                this.isLayoutRequested = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 14:
                this.getErrorConfigVersion = obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
                return;
            case 15:
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
                return;
            case 16:
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = MyBillsEntityDataFactory(obj);
                return;
            default:
                return;
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
            sparseIntArray.append(R.styleable.createOauthGrantLoadingIntent, 1);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.AbstractMapBasedMultimap$AsMap, 2);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.getNewPassword, 4);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.NetworkMerchantInfoEntityData_Factory, 5);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.SpanSuppressionStrategy$2, 6);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.throwNpe, 19);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.DefaultBehaviorComponent, 20);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.SpanSuppressionStrategy$1, 7);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.alwaysFalse, 8);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.thenComparingDouble, 9);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.newEnumMap, 10);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.NetworkExpressPurchaseEntityData$orderQueryByCondition$1, 12);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.SpanSuppressionStrategy$3, 13);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.MatrixEvaluator, 14);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.readBoolean, 15);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.sipHash24, 16);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.CreateFamilyAccountEntity, 17);
            KClassImpl$Data$declaredNonStaticMembers$2.append(R.styleable.f20Temporal$CC, 18);
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (KClassImpl$Data$declaredNonStaticMembers$2.get(index)) {
                    case 1:
                        keyAttributes.getErrorConfigVersion = typedArray.getFloat(index, keyAttributes.getErrorConfigVersion);
                        break;
                    case 2:
                        keyAttributes.lookAheadTest = typedArray.getDimension(index, keyAttributes.lookAheadTest);
                        break;
                    case 3:
                    case 11:
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(KClassImpl$Data$declaredNonStaticMembers$2.get(index));
                        InstrumentInjector.log_e("KeyAttribute", sb.toString());
                        break;
                    case 4:
                        keyAttributes.DatabaseTableConfigUtil = typedArray.getFloat(index, keyAttributes.DatabaseTableConfigUtil);
                        break;
                    case 5:
                        keyAttributes.GetContactSyncConfig = typedArray.getFloat(index, keyAttributes.GetContactSyncConfig);
                        break;
                    case 6:
                        keyAttributes.initRecordTimeStamp = typedArray.getFloat(index, keyAttributes.initRecordTimeStamp);
                        break;
                    case 7:
                        keyAttributes.PrepareContext = typedArray.getFloat(index, keyAttributes.PrepareContext);
                        break;
                    case 8:
                        keyAttributes.isLayoutRequested = typedArray.getFloat(index, keyAttributes.isLayoutRequested);
                        break;
                    case 9:
                        keyAttributes.newProxyInstance = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyAttributes.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyAttributes.KClassImpl$Data$declaredNonStaticMembers$2);
                            if (keyAttributes.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                                keyAttributes.getAuthRequestContext = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyAttributes.getAuthRequestContext = typedArray.getString(index);
                            break;
                        } else {
                            keyAttributes.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyAttributes.KClassImpl$Data$declaredNonStaticMembers$2);
                            break;
                        }
                    case 12:
                        keyAttributes.BuiltInFictitiousFunctionClassFactory = typedArray.getInt(index, keyAttributes.BuiltInFictitiousFunctionClassFactory);
                        break;
                    case 13:
                        keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getInteger(index, keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        break;
                    case 14:
                        keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda8 = typedArray.getFloat(index, keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda8);
                        break;
                    case 15:
                        keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda7 = typedArray.getDimension(index, keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda7);
                        break;
                    case 16:
                        keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda5 = typedArray.getDimension(index, keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda5);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT >= 21) {
                            keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda4 = typedArray.getDimension(index, keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda4);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda2 = typedArray.getFloat(index, keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        break;
                    case 19:
                        keyAttributes.moveToNextValue = typedArray.getDimension(index, keyAttributes.moveToNextValue);
                        break;
                    case 20:
                        keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda1 = typedArray.getDimension(index, keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final Key KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda3;
        this.getErrorConfigVersion = keyAttributes.getErrorConfigVersion;
        this.lookAheadTest = keyAttributes.lookAheadTest;
        this.DatabaseTableConfigUtil = keyAttributes.DatabaseTableConfigUtil;
        this.GetContactSyncConfig = keyAttributes.GetContactSyncConfig;
        this.initRecordTimeStamp = keyAttributes.initRecordTimeStamp;
        this.moveToNextValue = keyAttributes.moveToNextValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.isLayoutRequested = keyAttributes.isLayoutRequested;
        this.PrepareContext = keyAttributes.PrepareContext;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = keyAttributes.NetworkUserEntityData$$ExternalSyntheticLambda2;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final Key clone() {
        return new KeyAttributes().KClassImpl$Data$declaredNonStaticMembers$2((Key) this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new KeyAttributes().KClassImpl$Data$declaredNonStaticMembers$2((Key) this);
    }
}
