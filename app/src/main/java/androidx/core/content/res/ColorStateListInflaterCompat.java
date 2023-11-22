package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.math.MathUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.flexbox.FlexItem;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> KClassImpl$Data$declaredNonStaticMembers$2 = new ThreadLocal<>();

    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList BuiltInFictitiousFunctionClassFactory(Resources resources, int i, Resources.Theme theme) {
        try {
            return MyBillsEntityDataFactory(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            InstrumentInjector.log_e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    public static ColorStateList MyBillsEntityDataFactory(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(resources, xmlPullParser, asAttributeSet, theme);
    }

    public static ColorStateList KClassImpl$Data$declaredNonStaticMembers$2(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("selector")) {
            StringBuilder sb = new StringBuilder();
            sb.append(xmlPullParser.getPositionDescription());
            sb.append(": invalid color state list tag ");
            sb.append(name);
            throw new XmlPullParserException(sb.toString());
        }
        return getAuthRequestContext(resources, xmlPullParser, attributeSet, theme);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.res.ColorStateList getAuthRequestContext(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.getAuthRequestContext(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Resources resources, int i) {
        TypedValue authRequestContext = getAuthRequestContext();
        resources.getValue(i, authRequestContext, true);
        return authRequestContext.type >= 28 && authRequestContext.type <= 31;
    }

    private static TypedValue getAuthRequestContext() {
        ThreadLocal<TypedValue> threadLocal = KClassImpl$Data$declaredNonStaticMembers$2;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static TypedArray BuiltInFictitiousFunctionClassFactory(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int PlaceComponentResult(int i, float f, float f2) {
        boolean z = f2 >= 0.0f && f2 <= 100.0f;
        if (f != 1.0f || z) {
            int BuiltInFictitiousFunctionClassFactory = MathUtils.BuiltInFictitiousFunctionClassFactory((int) ((Color.alpha(i) * f) + 0.5f), 0, 255);
            if (z) {
                CamColor authRequestContext = CamColor.getAuthRequestContext(i);
                i = CamColor.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.PlaceComponentResult, authRequestContext.MyBillsEntityDataFactory, f2);
            }
            return (i & FlexItem.MAX_SIZE) | (BuiltInFictitiousFunctionClassFactory << 24);
        }
        return i;
    }
}
