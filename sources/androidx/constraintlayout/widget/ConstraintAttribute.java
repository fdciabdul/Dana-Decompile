package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class ConstraintAttribute {
    public boolean BuiltInFictitiousFunctionClassFactory;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public AttributeType NetworkUserEntityData$$ExternalSyntheticLambda0;
    public float PlaceComponentResult;
    public int getAuthRequestContext;
    public String lookAheadTest;
    public String moveToNextValue;

    /* loaded from: classes3.dex */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintAttribute$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[AttributeType.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                PlaceComponentResult[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                PlaceComponentResult[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                PlaceComponentResult[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                PlaceComponentResult[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                PlaceComponentResult[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public final boolean MyBillsEntityDataFactory() {
        int i = AnonymousClass1.PlaceComponentResult[this.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? false : true;
    }

    public final float PlaceComponentResult() {
        switch (AnonymousClass1.PlaceComponentResult[this.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()]) {
            case 2:
                return this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.MyBillsEntityDataFactory;
            case 7:
                return this.PlaceComponentResult;
            case 8:
                return this.PlaceComponentResult;
            default:
                return Float.NaN;
        }
    }

    public final void getAuthRequestContext(float[] fArr) {
        switch (AnonymousClass1.PlaceComponentResult[this.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()]) {
            case 2:
                fArr[0] = this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i = this.getAuthRequestContext;
                float pow = (float) Math.pow(((i >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((i >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((i & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = ((i >> 24) & 255) / 255.0f;
                return;
            case 6:
                fArr[0] = this.MyBillsEntityDataFactory;
                return;
            case 7:
                fArr[0] = this.PlaceComponentResult;
                return;
            case 8:
                fArr[0] = this.PlaceComponentResult;
                return;
            default:
                return;
        }
    }

    private ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.lookAheadTest = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = attributeType;
        this.BuiltInFictitiousFunctionClassFactory = z;
        KClassImpl$Data$declaredNonStaticMembers$2(obj);
    }

    private ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.lookAheadTest = constraintAttribute.lookAheadTest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = constraintAttribute.NetworkUserEntityData$$ExternalSyntheticLambda0;
        KClassImpl$Data$declaredNonStaticMembers$2(obj);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        switch (AnonymousClass1.PlaceComponentResult[this.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()]) {
            case 1:
            case 6:
                this.MyBillsEntityDataFactory = ((Integer) obj).intValue();
                return;
            case 2:
                this.KClassImpl$Data$declaredNonStaticMembers$2 = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.moveToNextValue = (String) obj;
                return;
            case 4:
            case 5:
                this.getAuthRequestContext = ((Integer) obj).intValue();
                return;
            case 7:
                this.PlaceComponentResult = ((Float) obj).floatValue();
                return;
            case 8:
                this.PlaceComponentResult = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public static HashMap<String, ConstraintAttribute> getAuthRequestContext(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("getMap");
                    sb.append(str);
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod(sb.toString(), new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return hashMap2;
    }

    public static void getAuthRequestContext(View view, HashMap<String, ConstraintAttribute> hashMap) {
        String str;
        Class<?> cls = view.getClass();
        for (String str2 : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str2);
            if (constraintAttribute.BuiltInFictitiousFunctionClassFactory) {
                str = str2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("set");
                sb.append(str2);
                str = sb.toString();
            }
            try {
                switch (AnonymousClass1.PlaceComponentResult[constraintAttribute.NetworkUserEntityData$$ExternalSyntheticLambda0.ordinal()]) {
                    case 1:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.MyBillsEntityDataFactory));
                        break;
                    case 2:
                        cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.KClassImpl$Data$declaredNonStaticMembers$2));
                        break;
                    case 3:
                        cls.getMethod(str, CharSequence.class).invoke(view, constraintAttribute.moveToNextValue);
                        break;
                    case 4:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.getAuthRequestContext));
                        break;
                    case 5:
                        Method method = cls.getMethod(str, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.getAuthRequestContext);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.MyBillsEntityDataFactory));
                        break;
                    case 7:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.PlaceComponentResult));
                        break;
                    case 8:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.PlaceComponentResult));
                        break;
                }
            } catch (IllegalAccessException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" Custom Attribute \"");
                sb2.append(str2);
                sb2.append("\" not found on ");
                sb2.append(cls.getName());
                InstrumentInjector.log_e("TransitionLayout", sb2.toString());
            } catch (NoSuchMethodException e) {
                InstrumentInjector.log_e("TransitionLayout", e.getMessage());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" Custom Attribute \"");
                sb3.append(str2);
                sb3.append("\" not found on ");
                sb3.append(cls.getName());
                InstrumentInjector.log_e("TransitionLayout", sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(cls.getName());
                sb4.append(" must have a method ");
                sb4.append(str);
                InstrumentInjector.log_e("TransitionLayout", sb4.toString());
            } catch (InvocationTargetException unused2) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" Custom Attribute \"");
                sb5.append(str2);
                sb5.append("\" not found on ");
                sb5.append(cls.getName());
                InstrumentInjector.log_e("TransitionLayout", sb5.toString());
            }
        }
    }

    public static void MyBillsEntityDataFactory(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.isNeedUpload);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        boolean z = false;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.GetKybCompressQrConfig_Factory) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Character.toUpperCase(str.charAt(0)));
                    sb.append(str.substring(1));
                    str = sb.toString();
                }
            } else if (index == R.styleable.setNationality) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == R.styleable.validateScopes) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.hideWorkerProperty) {
                    attributeType = AttributeType.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.OtpChallengeUIState$VerifyInvalidOtp) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.getOnCreateTime) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.FlowLiveDataConversions$asLiveData$1) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CaptureStatus) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.ThreadLocalKey) {
                    attributeType = AttributeType.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.QuickBuyBillsAdapter$onQuickBuyItemClickListener$1) {
                    attributeType = AttributeType.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.LimitedDispatcher) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                attributeType2 = attributeType;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj, z));
        }
        obtainStyledAttributes.recycle();
    }
}
