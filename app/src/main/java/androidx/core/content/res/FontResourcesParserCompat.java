package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FontResourcesParserCompat {

    /* loaded from: classes.dex */
    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FetchStrategy {
    }

    /* loaded from: classes.dex */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final FontRequest PlaceComponentResult;
        private final String getAuthRequestContext;

        public ProviderResourceEntry(FontRequest fontRequest, int i, int i2, String str) {
            this.PlaceComponentResult = fontRequest;
            this.MyBillsEntityDataFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            this.getAuthRequestContext = str;
        }

        public final FontRequest BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult;
        }

        public final int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.MyBillsEntityDataFactory;
        }

        public final int MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public final String getAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }

    /* loaded from: classes.dex */
    public static final class FontFileResourceEntry {
        private final boolean BuiltInFictitiousFunctionClassFactory;
        private final int KClassImpl$Data$declaredNonStaticMembers$2;
        private final String MyBillsEntityDataFactory;
        private final String PlaceComponentResult;
        private final int getAuthRequestContext;
        private final int getErrorConfigVersion;

        public FontFileResourceEntry(String str, int i, boolean z, String str2, int i2, int i3) {
            this.MyBillsEntityDataFactory = str;
            this.getErrorConfigVersion = i;
            this.BuiltInFictitiousFunctionClassFactory = z;
            this.PlaceComponentResult = str2;
            this.getAuthRequestContext = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
        }

        public final String BuiltInFictitiousFunctionClassFactory() {
            return this.MyBillsEntityDataFactory;
        }

        public final int MyBillsEntityDataFactory() {
            return this.getErrorConfigVersion;
        }

        public final boolean moveToNextValue() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public final String PlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        public final int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext;
        }

        public final int getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes.dex */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        private final FontFileResourceEntry[] getAuthRequestContext;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.getAuthRequestContext = fontFileResourceEntryArr;
        }

        public final FontFileResourceEntry[] KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext;
        }
    }

    public static FamilyResourceEntry KClassImpl$Data$declaredNonStaticMembers$2(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return PlaceComponentResult(xmlPullParser, resources);
    }

    private static FamilyResourceEntry PlaceComponentResult(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return MyBillsEntityDataFactory(xmlPullParser, resources);
        }
        getAuthRequestContext(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry MyBillsEntityDataFactory(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.getErrorConfigVersion);
        String string = obtainAttributes.getString(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda8);
        String string2 = obtainAttributes.getString(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda5);
        String string3 = obtainAttributes.getString(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda6);
        int resourceId = obtainAttributes.getResourceId(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda3, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FragmentBottomSheetPaymentSettingBinding, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda4, 500);
        String string4 = obtainAttributes.getString(R.styleable.SubSequence);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                getAuthRequestContext(xmlPullParser);
            }
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, KClassImpl$Data$declaredNonStaticMembers$2(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(BuiltInFictitiousFunctionClassFactory(xmlPullParser, resources));
                } else {
                    getAuthRequestContext(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[0]));
    }

    private static int MyBillsEntityDataFactory(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            return typedValue.type;
        }
        return typedArray.getType(i);
    }

    public static List<List<byte[]>> KClassImpl$Data$declaredNonStaticMembers$2(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (MyBillsEntityDataFactory(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(getAuthRequestContext(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(getAuthRequestContext(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> getAuthRequestContext(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static FontFileResourceEntry BuiltInFictitiousFunctionClassFactory(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.scheduleImpl);
        if (obtainAttributes.hasValue(R.styleable.PrepareContext)) {
            i = R.styleable.PrepareContext;
        } else {
            i = R.styleable.initRecordTimeStamp;
        }
        int i6 = obtainAttributes.getInt(i, 400);
        if (obtainAttributes.hasValue(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7)) {
            i2 = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7;
        } else {
            i2 = R.styleable.DatabaseTableConfigUtil;
        }
        boolean z = 1 == obtainAttributes.getInt(i2, 0);
        if (obtainAttributes.hasValue(R.styleable.isLayoutRequested)) {
            i3 = R.styleable.isLayoutRequested;
        } else {
            i3 = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }
        if (obtainAttributes.hasValue(R.styleable.newProxyInstance)) {
            i4 = R.styleable.newProxyInstance;
        } else {
            i4 = R.styleable.GetContactSyncConfig;
        }
        String string = obtainAttributes.getString(i4);
        int i7 = obtainAttributes.getInt(i3, 0);
        if (obtainAttributes.hasValue(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
            i5 = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1;
        } else {
            i5 = R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        int resourceId = obtainAttributes.getResourceId(i5, 0);
        String string2 = obtainAttributes.getString(i5);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            getAuthRequestContext(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i6, z, string, i7, resourceId);
    }

    private static void getAuthRequestContext(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private FontResourcesParserCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }
    }
}
