package androidx.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.view.NavArgument;
import androidx.view.NavType;
import androidx.view.common.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0014\u0012\u0006\u0010\u0005\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u000e\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Landroidx/navigation/NavInflater;", "", "Landroid/content/res/Resources;", "p0", "Landroid/content/res/XmlResourceParser;", "p1", "Landroid/util/AttributeSet;", "p2", "", "p3", "Landroidx/navigation/NavDestination;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/res/Resources;Landroid/content/res/XmlResourceParser;Landroid/util/AttributeSet;I)Landroidx/navigation/NavDestination;", "Landroidx/navigation/NavGraph;", "BuiltInFictitiousFunctionClassFactory", "(I)Landroidx/navigation/NavGraph;", "Landroid/content/res/TypedArray;", "Landroidx/navigation/NavArgument;", "getAuthRequestContext", "(Landroid/content/res/TypedArray;Landroid/content/res/Resources;I)Landroidx/navigation/NavArgument;", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "Landroidx/navigation/NavigatorProvider;", "MyBillsEntityDataFactory", "Landroidx/navigation/NavigatorProvider;", "<init>", "(Landroid/content/Context;Landroidx/navigation/NavigatorProvider;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavInflater {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ThreadLocal<TypedValue> KClassImpl$Data$declaredNonStaticMembers$2 = new ThreadLocal<>();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final NavigatorProvider BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(navigatorProvider, "");
        this.PlaceComponentResult = context;
        this.BuiltInFictitiousFunctionClassFactory = navigatorProvider;
    }

    public final NavGraph BuiltInFictitiousFunctionClassFactory(int p0) {
        int next;
        Resources resources = this.PlaceComponentResult.getResources();
        XmlResourceParser xml = resources.getXml(p0);
        Intrinsics.checkNotNullExpressionValue(xml, "");
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Exception inflating ");
                    sb.append(resources.getResourceName(p0));
                    sb.append(" line ");
                    sb.append(xml.getLineNumber());
                    throw new RuntimeException(sb.toString(), e);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        Intrinsics.checkNotNullExpressionValue(resources, "");
        Intrinsics.checkNotNullExpressionValue(asAttributeSet, "");
        NavDestination KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(resources, xml, asAttributeSet, p0);
        if (!(KClassImpl$Data$declaredNonStaticMembers$22 instanceof NavGraph)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Root element <");
            sb2.append(name);
            sb2.append("> did not inflate into a NavGraph");
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        return (NavGraph) KClassImpl$Data$declaredNonStaticMembers$22;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0282, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append("Cannot add action ");
        r1.append(r12);
        r1.append(" to ");
        r1.append(r4);
        r1.append(" as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02a5, code lost:
    
        throw new java.lang.UnsupportedOperationException(r1.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02e9, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0259, code lost:
    
        if (r5.isEmpty() != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x025b, code lost:
    
        r15.BuiltInFictitiousFunctionClassFactory = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x025d, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0264, code lost:
    
        if (r4.MyBillsEntityDataFactory() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0266, code lost:
    
        if (r12 == 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0268, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x026a, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x026b, code lost:
    
        if (r14 == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x026d, code lost:
    
        r4.MyBillsEntityDataFactory.PlaceComponentResult(r12, r15);
        r8.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0281, code lost:
    
        throw new java.lang.IllegalArgumentException("Cannot have an action with actionId 0".toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.view.NavDestination KClassImpl$Data$declaredNonStaticMembers$2(android.content.res.Resources r23, android.content.res.XmlResourceParser r24, android.util.AttributeSet r25, int r26) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.NavInflater.KClassImpl$Data$declaredNonStaticMembers$2(android.content.res.Resources, android.content.res.XmlResourceParser, android.util.AttributeSet, int):androidx.navigation.NavDestination");
    }

    private static NavArgument getAuthRequestContext(TypedArray p0, Resources p1, int p2) throws XmlPullParserException {
        NavType<?> navType;
        NavArgument.Builder builder = new NavArgument.Builder();
        int i = 0;
        builder.getAuthRequestContext = p0.getBoolean(R.styleable.isLayoutRequested, false);
        ThreadLocal<TypedValue> threadLocal = KClassImpl$Data$declaredNonStaticMembers$2;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = p0.getString(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda7);
        Object obj = null;
        if (string != null) {
            NavType.Companion companion = NavType.INSTANCE;
            navType = NavType.Companion.PlaceComponentResult(string, p1.getResourcePackageName(p2));
        } else {
            navType = null;
        }
        if (p0.getValue(R.styleable.DatabaseTableConfigUtil, typedValue)) {
            if (navType == NavType.getErrorConfigVersion) {
                if (typedValue.resourceId != 0) {
                    i = typedValue.resourceId;
                } else if (typedValue.type != 16 || typedValue.data != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unsupported value '");
                    sb.append((Object) typedValue.string);
                    sb.append("' for ");
                    sb.append(navType.getMyBillsEntityDataFactory());
                    sb.append(". Must be a reference to a resource.");
                    throw new XmlPullParserException(sb.toString());
                }
                obj = Integer.valueOf(i);
            } else if (typedValue.resourceId != 0) {
                if (navType == null) {
                    navType = NavType.getErrorConfigVersion;
                    obj = Integer.valueOf(typedValue.resourceId);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("unsupported value '");
                    sb2.append((Object) typedValue.string);
                    sb2.append("' for ");
                    sb2.append(navType.getMyBillsEntityDataFactory());
                    sb2.append(". You must use a \"");
                    sb2.append(NavType.getErrorConfigVersion.getMyBillsEntityDataFactory());
                    sb2.append("\" type to reference other resources.");
                    throw new XmlPullParserException(sb2.toString());
                }
            } else if (navType == NavType.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                obj = p0.getString(R.styleable.DatabaseTableConfigUtil);
            } else {
                int i2 = typedValue.type;
                if (i2 == 3) {
                    String obj2 = typedValue.string.toString();
                    if (navType == null) {
                        NavType.Companion companion2 = NavType.INSTANCE;
                        navType = NavType.Companion.MyBillsEntityDataFactory(obj2);
                    }
                    obj = navType.PlaceComponentResult(obj2);
                } else if (i2 == 4) {
                    navType = Companion.MyBillsEntityDataFactory(typedValue, navType, NavType.KClassImpl$Data$declaredNonStaticMembers$2, string, "float");
                    obj = Float.valueOf(typedValue.getFloat());
                } else if (i2 == 5) {
                    navType = Companion.MyBillsEntityDataFactory(typedValue, navType, NavType.moveToNextValue, string, "dimension");
                    obj = Integer.valueOf((int) typedValue.getDimension(p1.getDisplayMetrics()));
                } else if (i2 == 18) {
                    navType = Companion.MyBillsEntityDataFactory(typedValue, navType, NavType.MyBillsEntityDataFactory, string, "boolean");
                    obj = Boolean.valueOf(typedValue.data != 0);
                } else if (typedValue.type >= 16 && typedValue.type <= 31) {
                    if (navType == NavType.KClassImpl$Data$declaredNonStaticMembers$2) {
                        navType = Companion.MyBillsEntityDataFactory(typedValue, navType, NavType.KClassImpl$Data$declaredNonStaticMembers$2, string, "float");
                        obj = Float.valueOf(typedValue.data);
                    } else {
                        navType = Companion.MyBillsEntityDataFactory(typedValue, navType, NavType.moveToNextValue, string, "integer");
                        obj = Integer.valueOf(typedValue.data);
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("unsupported argument type ");
                    sb3.append(typedValue.type);
                    throw new XmlPullParserException(sb3.toString());
                }
            }
        }
        if (obj != null) {
            builder.PlaceComponentResult = obj;
            builder.BuiltInFictitiousFunctionClassFactory = true;
        }
        if (navType != null) {
            Intrinsics.checkNotNullParameter(navType, "");
            builder.MyBillsEntityDataFactory = navType;
        }
        return builder.PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Landroidx/navigation/NavInflater$Companion;", "", "Landroid/util/TypedValue;", "p0", "Landroidx/navigation/NavType;", "p1", "p2", "", "p3", "p4", "MyBillsEntityDataFactory", "(Landroid/util/TypedValue;Landroidx/navigation/NavType;Landroidx/navigation/NavType;Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;", "Ljava/lang/ThreadLocal;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/ThreadLocal;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static NavType<?> MyBillsEntityDataFactory(TypedValue p0, NavType<?> p1, NavType<?> p2, String p3, String p4) throws XmlPullParserException {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p4, "");
            if (p1 == null || p1 == p2) {
                return p1 == null ? p2 : p1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Type is ");
            sb.append(p3);
            sb.append(" but found ");
            sb.append(p4);
            sb.append(": ");
            sb.append(p0.data);
            throw new XmlPullParserException(sb.toString());
        }
    }
}
