package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class TypedArrayUtils {
    public static boolean BuiltInFictitiousFunctionClassFactory(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static float KClassImpl$Data$declaredNonStaticMembers$2(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !BuiltInFictitiousFunctionClassFactory(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static boolean getAuthRequestContext(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !BuiltInFictitiousFunctionClassFactory(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static int getAuthRequestContext(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !BuiltInFictitiousFunctionClassFactory(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static int getAuthRequestContext(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (BuiltInFictitiousFunctionClassFactory(xmlPullParser, str)) {
            return typedArray.getColor(i, 0);
        }
        return 0;
    }

    public static ComplexColorCompat getAuthRequestContext(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        if (BuiltInFictitiousFunctionClassFactory(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return ComplexColorCompat.BuiltInFictitiousFunctionClassFactory(typedValue.data);
            }
            ComplexColorCompat PlaceComponentResult = ComplexColorCompat.PlaceComponentResult(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (PlaceComponentResult != null) {
                return PlaceComponentResult;
            }
        }
        return ComplexColorCompat.BuiltInFictitiousFunctionClassFactory(0);
    }

    public static ColorStateList getAuthRequestContext(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str) {
        if (BuiltInFictitiousFunctionClassFactory(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(1, typedValue);
            if (typedValue.type == 2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to resolve attribute at index ");
                sb.append(1);
                sb.append(": ");
                sb.append(typedValue);
                throw new UnsupportedOperationException(sb.toString());
            } else if (typedValue.type < 28 || typedValue.type > 31) {
                return ColorStateListInflaterCompat.BuiltInFictitiousFunctionClassFactory(typedArray.getResources(), typedArray.getResourceId(1, 0), theme);
            } else {
                return ColorStateList.valueOf(typedValue.data);
            }
        }
        return null;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (BuiltInFictitiousFunctionClassFactory(xmlPullParser, str)) {
            return typedArray.getResourceId(i, 0);
        }
        return 0;
    }

    public static String BuiltInFictitiousFunctionClassFactory(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (BuiltInFictitiousFunctionClassFactory(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    public static TypedValue KClassImpl$Data$declaredNonStaticMembers$2(TypedArray typedArray, XmlPullParser xmlPullParser, String str) {
        if (BuiltInFictitiousFunctionClassFactory(xmlPullParser, str)) {
            return typedArray.peekValue(0);
        }
        return null;
    }

    public static TypedArray getAuthRequestContext(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private TypedArrayUtils() {
    }
}
