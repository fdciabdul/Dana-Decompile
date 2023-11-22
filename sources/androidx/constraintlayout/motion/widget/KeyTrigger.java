package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes3.dex */
public class KeyTrigger extends Key {
    private float NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int NetworkUserEntityData$$ExternalSyntheticLambda1 = -1;
    private String GetContactSyncConfig = null;
    private int getSupportButtonTintMode = PlaceComponentResult;
    private String NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
    private String NetworkUserEntityData$$ExternalSyntheticLambda5 = null;
    private int getCallingPid = PlaceComponentResult;
    private int FragmentBottomSheetPaymentSettingBinding = PlaceComponentResult;
    private View NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
    float NetworkUserEntityData$$ExternalSyntheticLambda0 = 0.1f;
    private boolean PrepareContext = true;
    private boolean isLayoutRequested = true;
    private boolean newProxyInstance = true;
    private float NetworkUserEntityData$$ExternalSyntheticLambda8 = Float.NaN;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
    int DatabaseTableConfigUtil = PlaceComponentResult;
    int NetworkUserEntityData$$ExternalSyntheticLambda2 = PlaceComponentResult;
    int initRecordTimeStamp = PlaceComponentResult;
    RectF lookAheadTest = new RectF();
    RectF getErrorConfigVersion = new RectF();
    HashMap<String, Method> moveToNextValue = new HashMap<>();

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void PlaceComponentResult(HashMap<String, ViewSpline> hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void PlaceComponentResult(HashSet<String> hashSet) {
    }

    public KeyTrigger() {
        this.scheduleImpl = 5;
        this.MyBillsEntityDataFactory = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void getAuthRequestContext(Context context, AttributeSet attributeSet) {
        Loader.KClassImpl$Data$declaredNonStaticMembers$2(this, context.obtainStyledAttributes(attributeSet, R.styleable.Camera$FaceDetectionListener));
    }

    private static void PlaceComponentResult(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(float r9, android.view.View r10) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.BuiltInFictitiousFunctionClassFactory(float, android.view.View):void");
    }

    private void BuiltInFictitiousFunctionClassFactory(String str, View view) {
        Method method;
        String str2;
        if (str == null) {
            return;
        }
        if (!str.startsWith(".")) {
            if (this.moveToNextValue.containsKey(str)) {
                method = this.moveToNextValue.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, new Class[0]);
                    this.moveToNextValue.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.moveToNextValue.put(str, null);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not find method \"");
                    sb.append(str);
                    sb.append("\"on class ");
                    sb.append(view.getClass().getSimpleName());
                    sb.append(" ");
                    sb.append(Debug.MyBillsEntityDataFactory(view));
                    InstrumentInjector.log_e(TypedValues.TriggerType.MyBillsEntityDataFactory, sb.toString());
                    return;
                }
            }
            try {
                method.invoke(view, new Object[0]);
                return;
            } catch (Exception unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Exception in call \"");
                sb2.append(this.GetContactSyncConfig);
                sb2.append("\"on class ");
                sb2.append(view.getClass().getSimpleName());
                sb2.append(" ");
                sb2.append(Debug.MyBillsEntityDataFactory(view));
                InstrumentInjector.log_e(TypedValues.TriggerType.MyBillsEntityDataFactory, sb2.toString());
                return;
            }
        }
        boolean z = str.length() == 1;
        if (!z) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str3 : this.MyBillsEntityDataFactory.keySet()) {
            String lowerCase = str3.toLowerCase(Locale.ROOT);
            if (z || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = this.MyBillsEntityDataFactory.get(str3);
                if (constraintAttribute != null) {
                    Class<?> cls = view.getClass();
                    String str4 = constraintAttribute.lookAheadTest;
                    if (constraintAttribute.BuiltInFictitiousFunctionClassFactory) {
                        str2 = str4;
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("set");
                        sb3.append(str4);
                        str2 = sb3.toString();
                    }
                    try {
                        switch (ConstraintAttribute.AnonymousClass1.PlaceComponentResult[constraintAttribute.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()]) {
                            case 1:
                            case 6:
                                cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.MyBillsEntityDataFactory));
                                break;
                            case 2:
                                cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.KClassImpl$Data$declaredNonStaticMembers$2));
                                break;
                            case 3:
                                cls.getMethod(str2, CharSequence.class).invoke(view, constraintAttribute.moveToNextValue);
                                break;
                            case 4:
                                cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.getAuthRequestContext));
                                break;
                            case 5:
                                Method method2 = cls.getMethod(str2, Drawable.class);
                                ColorDrawable colorDrawable = new ColorDrawable();
                                colorDrawable.setColor(constraintAttribute.getAuthRequestContext);
                                method2.invoke(view, colorDrawable);
                                break;
                            case 7:
                                cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.PlaceComponentResult));
                                break;
                            case 8:
                                cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.PlaceComponentResult));
                                break;
                        }
                    } catch (IllegalAccessException unused3) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(" Custom Attribute \"");
                        sb4.append(str4);
                        sb4.append("\" not found on ");
                        sb4.append(cls.getName());
                        InstrumentInjector.log_e("TransitionLayout", sb4.toString());
                    } catch (NoSuchMethodException e) {
                        InstrumentInjector.log_e("TransitionLayout", e.getMessage());
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(" Custom Attribute \"");
                        sb5.append(str4);
                        sb5.append("\" not found on ");
                        sb5.append(cls.getName());
                        InstrumentInjector.log_e("TransitionLayout", sb5.toString());
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(cls.getName());
                        sb6.append(" must have a method ");
                        sb6.append(str2);
                        InstrumentInjector.log_e("TransitionLayout", sb6.toString());
                    } catch (InvocationTargetException unused4) {
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(" Custom Attribute \"");
                        sb7.append(str4);
                        sb7.append("\" not found on ");
                        sb7.append(cls.getName());
                        InstrumentInjector.log_e("TransitionLayout", sb7.toString());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    static class Loader {
        private static SparseIntArray MyBillsEntityDataFactory;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            MyBillsEntityDataFactory = sparseIntArray;
            sparseIntArray.append(R.styleable.getCaseField, 8);
            MyBillsEntityDataFactory.append(R.styleable.InputCardNumberView$iconCardErrorHandlingListener$1, 4);
            MyBillsEntityDataFactory.append(R.styleable.ParetoDistribution, 1);
            MyBillsEntityDataFactory.append(R.styleable.onPageEnter, 2);
            MyBillsEntityDataFactory.append(R.styleable.setDocumentationRootUrl, 7);
            MyBillsEntityDataFactory.append(R.styleable.encodingECI, 6);
            MyBillsEntityDataFactory.append(R.styleable.addOnItemTouchListener, 5);
            MyBillsEntityDataFactory.append(R.styleable.UiTextModel, 9);
            MyBillsEntityDataFactory.append(R.styleable.setText, 10);
            MyBillsEntityDataFactory.append(R.styleable.ProfileMenuHeaderViewHolder_ViewBinding, 11);
            MyBillsEntityDataFactory.append(R.styleable.SendMoneyActivity$bottomSheetOnBoardingModule$1, 12);
            MyBillsEntityDataFactory.append(R.styleable.CallCsOrDianaFragment$initLifecycleFragment$1$1$1, 13);
            MyBillsEntityDataFactory.append(R.styleable.newLogger, 14);
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(KeyTrigger keyTrigger, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (MyBillsEntityDataFactory.get(index)) {
                    case 1:
                        keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda4 = typedArray.getString(index);
                        break;
                    case 2:
                        keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda5 = typedArray.getString(index);
                        break;
                    case 3:
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("unused attribute 0x");
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(MyBillsEntityDataFactory.get(index));
                        InstrumentInjector.log_e(TypedValues.TriggerType.MyBillsEntityDataFactory, sb.toString());
                        break;
                    case 4:
                        keyTrigger.GetContactSyncConfig = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda0 = typedArray.getFloat(index, keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        break;
                    case 6:
                        keyTrigger.getCallingPid = typedArray.getResourceId(index, keyTrigger.getCallingPid);
                        break;
                    case 7:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyTrigger.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyTrigger.KClassImpl$Data$declaredNonStaticMembers$2);
                            if (keyTrigger.KClassImpl$Data$declaredNonStaticMembers$2 == -1) {
                                keyTrigger.getAuthRequestContext = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyTrigger.getAuthRequestContext = typedArray.getString(index);
                            break;
                        } else {
                            keyTrigger.KClassImpl$Data$declaredNonStaticMembers$2 = typedArray.getResourceId(index, keyTrigger.KClassImpl$Data$declaredNonStaticMembers$2);
                            break;
                        }
                    case 8:
                        keyTrigger.BuiltInFictitiousFunctionClassFactory = typedArray.getInteger(index, keyTrigger.BuiltInFictitiousFunctionClassFactory);
                        keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda8 = (keyTrigger.BuiltInFictitiousFunctionClassFactory + 0.5f) / 100.0f;
                        break;
                    case 9:
                        keyTrigger.FragmentBottomSheetPaymentSettingBinding = typedArray.getResourceId(index, keyTrigger.FragmentBottomSheetPaymentSettingBinding);
                        break;
                    case 10:
                        keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda6 = typedArray.getBoolean(index, keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda6);
                        break;
                    case 11:
                        keyTrigger.getSupportButtonTintMode = typedArray.getResourceId(index, keyTrigger.getSupportButtonTintMode);
                        break;
                    case 12:
                        keyTrigger.initRecordTimeStamp = typedArray.getResourceId(index, keyTrigger.initRecordTimeStamp);
                        break;
                    case 13:
                        keyTrigger.DatabaseTableConfigUtil = typedArray.getResourceId(index, keyTrigger.DatabaseTableConfigUtil);
                        break;
                    case 14:
                        keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda2 = typedArray.getResourceId(index, keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda2);
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final Key KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.GetContactSyncConfig = keyTrigger.GetContactSyncConfig;
        this.getSupportButtonTintMode = keyTrigger.getSupportButtonTintMode;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda5;
        this.getCallingPid = keyTrigger.getCallingPid;
        this.FragmentBottomSheetPaymentSettingBinding = keyTrigger.FragmentBottomSheetPaymentSettingBinding;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.PrepareContext = keyTrigger.PrepareContext;
        this.isLayoutRequested = keyTrigger.isLayoutRequested;
        this.newProxyInstance = keyTrigger.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = keyTrigger.NetworkUserEntityData$$ExternalSyntheticLambda6;
        this.lookAheadTest = keyTrigger.lookAheadTest;
        this.getErrorConfigVersion = keyTrigger.getErrorConfigVersion;
        this.moveToNextValue = keyTrigger.moveToNextValue;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final Key clone() {
        return new KeyTrigger().KClassImpl$Data$declaredNonStaticMembers$2((Key) this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new KeyTrigger().KClassImpl$Data$declaredNonStaticMembers$2((Key) this);
    }
}
