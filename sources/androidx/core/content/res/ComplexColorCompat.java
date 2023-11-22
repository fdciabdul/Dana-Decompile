package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Xml;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.biz.common.internal.foundation.FoundationProxy;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ComplexColorCompat {
    private final Shader BuiltInFictitiousFunctionClassFactory;
    private int PlaceComponentResult;
    private final ColorStateList getAuthRequestContext;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i) {
        this.BuiltInFictitiousFunctionClassFactory = shader;
        this.getAuthRequestContext = colorStateList;
        this.PlaceComponentResult = i;
    }

    static ComplexColorCompat KClassImpl$Data$declaredNonStaticMembers$2(Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    static ComplexColorCompat getAuthRequestContext(ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComplexColorCompat BuiltInFictitiousFunctionClassFactory(int i) {
        return new ComplexColorCompat(null, null, i);
    }

    public final Shader getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.PlaceComponentResult = i;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory != null;
    }

    public final boolean PlaceComponentResult() {
        ColorStateList colorStateList;
        return this.BuiltInFictitiousFunctionClassFactory == null && (colorStateList = this.getAuthRequestContext) != null && colorStateList.isStateful();
    }

    public final boolean MyBillsEntityDataFactory(int[] iArr) {
        if (PlaceComponentResult()) {
            ColorStateList colorStateList = this.getAuthRequestContext;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.PlaceComponentResult) {
                this.PlaceComponentResult = colorForState;
                return true;
            }
        }
        return false;
    }

    public final boolean MyBillsEntityDataFactory() {
        return BuiltInFictitiousFunctionClassFactory() || this.PlaceComponentResult != 0;
    }

    public static ComplexColorCompat PlaceComponentResult(Resources resources, int i, Resources.Theme theme) {
        try {
            return BuiltInFictitiousFunctionClassFactory(resources, i, theme);
        } catch (Exception e) {
            InstrumentInjector.log_e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    private static ComplexColorCompat BuiltInFictitiousFunctionClassFactory(Resources resources, int i, Resources.Theme theme) throws IOException, XmlPullParserException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals(FoundationProxy.COMPONENT_GRADIENT)) {
            return KClassImpl$Data$declaredNonStaticMembers$2(GradientColorInflaterCompat.BuiltInFictitiousFunctionClassFactory(resources, xml, asAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return getAuthRequestContext(ColorStateListInflaterCompat.KClassImpl$Data$declaredNonStaticMembers$2(resources, xml, asAttributeSet, theme));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(xml.getPositionDescription());
        sb.append(": unsupported complex color tag ");
        sb.append(name);
        throw new XmlPullParserException(sb.toString());
    }
}
