package androidx.view;

import androidx.view.Navigator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\u00028\u0000\"\f\b\u0000\u0010\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Landroidx/navigation/NavigatorProvider;", "", "", "p0", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "p1", "getAuthRequestContext", "(Ljava/lang/String;Landroidx/navigation/Navigator;)Landroidx/navigation/Navigator;", "T", "PlaceComponentResult", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "", "MyBillsEntityDataFactory", "Ljava/util/Map;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavigatorProvider {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Class<?>, String> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Map<String, Navigator<? extends NavDestination>> BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();

    public <T extends Navigator<?>> T PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!Companion.PlaceComponentResult(p0)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
        Navigator<? extends NavDestination> navigator = this.BuiltInFictitiousFunctionClassFactory.get(p0);
        if (navigator != null) {
            return navigator;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find Navigator with name \"");
        sb.append(p0);
        sb.append("\". You must call NavController.addNavigator() for each navigation type.");
        throw new IllegalStateException(sb.toString());
    }

    public final Navigator<? extends NavDestination> getAuthRequestContext(String p0, Navigator<? extends NavDestination> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!Companion.PlaceComponentResult(p0)) {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
        Navigator<? extends NavDestination> navigator = this.BuiltInFictitiousFunctionClassFactory.get(p0);
        if (Intrinsics.areEqual(navigator, p1)) {
            return p1;
        }
        boolean z = false;
        if (navigator != null && navigator.getPlaceComponentResult()) {
            z = true;
        }
        if ((!z) == false) {
            StringBuilder sb = new StringBuilder();
            sb.append("Navigator ");
            sb.append(p1);
            sb.append(" is replacing an already attached ");
            sb.append(navigator);
            throw new IllegalStateException(sb.toString().toString());
        } else if ((!p1.getPlaceComponentResult()) == false) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Navigator ");
            sb2.append(p1);
            sb2.append(" is already attached to another NavController");
            throw new IllegalStateException(sb2.toString().toString());
        } else {
            return this.BuiltInFictitiousFunctionClassFactory.put(p0, p1);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0006\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\tR&\u0010\f\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b"}, d2 = {"Landroidx/navigation/NavigatorProvider$Companion;", "", "Ljava/lang/Class;", "Landroidx/navigation/Navigator;", "p0", "", "PlaceComponentResult", "(Ljava/lang/Class;)Ljava/lang/String;", "", "(Ljava/lang/String;)Z", "", "Ljava/util/Map;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static boolean PlaceComponentResult(String p0) {
            if (p0 != null) {
                return p0.length() > 0;
            }
            return false;
        }

        @JvmStatic
        public static String PlaceComponentResult(Class<? extends Navigator<?>> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            String str = (String) NavigatorProvider.PlaceComponentResult.get(p0);
            if (str == null) {
                Navigator.Name name = (Navigator.Name) p0.getAnnotation(Navigator.Name.class);
                str = name != null ? name.value() : null;
                if (PlaceComponentResult(str)) {
                    NavigatorProvider.PlaceComponentResult.put(p0, str);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("No @Navigator.Name annotation found for ");
                    sb.append(p0.getSimpleName());
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
            Intrinsics.checkNotNull(str);
            return str;
        }
    }
}
