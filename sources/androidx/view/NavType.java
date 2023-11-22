package androidx.view;

import android.os.Bundle;
import android.os.Parcelable;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b&\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u001a\u001b\u001c\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0007\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00108\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u00058\u0017X\u0097D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u000f"}, d2 = {"Landroidx/navigation/NavType;", "T", "", "Landroid/os/Bundle;", "p0", "", "p1", "MyBillsEntityDataFactory", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/Object;", "p2", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "toString", "()Ljava/lang/String;", "", "DatabaseTableConfigUtil", "Z", "PlaceComponentResult", "()Z", "getAuthRequestContext", "initRecordTimeStamp", "Ljava/lang/String;", "<init>", "(Z)V", "Companion", "EnumType", "ParcelableArrayType", "ParcelableType", "SerializableArrayType", "SerializableType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class NavType<T> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory = "nav_type";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final NavType<Integer> moveToNextValue = new NavType<Integer>() { // from class: androidx.navigation.NavType$Companion$IntType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "integer";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ Integer PlaceComponentResult(String str) {
            int parseInt;
            Intrinsics.checkNotNullParameter(str, "");
            if (StringsKt.startsWith$default(str, "0x", false, 2, (Object) null)) {
                String substring = str.substring(2);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                parseInt = Integer.parseInt(substring, CharsKt.checkRadix(16));
            } else {
                parseInt = Integer.parseInt(str);
            }
            return Integer.valueOf(parseInt);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ Integer MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            Object obj = bundle.get(str);
            if (obj != null) {
                return Integer.valueOf(((Integer) obj).intValue());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, Integer num) {
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putInt(str, intValue);
        }
    };
    public static final NavType<Integer> getErrorConfigVersion = new NavType<Integer>() { // from class: androidx.navigation.NavType$Companion$ReferenceType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "reference";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ Integer PlaceComponentResult(String str) {
            int parseInt;
            Intrinsics.checkNotNullParameter(str, "");
            if (StringsKt.startsWith$default(str, "0x", false, 2, (Object) null)) {
                String substring = str.substring(2);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                parseInt = Integer.parseInt(substring, CharsKt.checkRadix(16));
            } else {
                parseInt = Integer.parseInt(str);
            }
            return Integer.valueOf(parseInt);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ Integer MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            Object obj = bundle.get(str);
            if (obj != null) {
                return Integer.valueOf(((Integer) obj).intValue());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, Integer num) {
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putInt(str, intValue);
        }
    };
    public static final NavType<int[]> PlaceComponentResult = new NavType<int[]>() { // from class: androidx.navigation.NavType$Companion$IntArrayType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "integer[]";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ int[] PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ int[] MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (int[]) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, int[] iArr) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putIntArray(str, iArr);
        }
    };
    public static final NavType<Long> lookAheadTest = new NavType<Long>() { // from class: androidx.navigation.NavType$Companion$LongType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "long";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ Long PlaceComponentResult(String str) {
            String str2;
            long parseLong;
            Intrinsics.checkNotNullParameter(str, "");
            if (StringsKt.endsWith$default(str, "L", false, 2, (Object) null)) {
                str2 = str.substring(0, str.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str2, "");
            } else {
                str2 = str;
            }
            if (StringsKt.startsWith$default(str, "0x", false, 2, (Object) null)) {
                String substring = str2.substring(2);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                parseLong = Long.parseLong(substring, CharsKt.checkRadix(16));
            } else {
                parseLong = Long.parseLong(str2);
            }
            return Long.valueOf(parseLong);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ Long MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            Object obj = bundle.get(str);
            if (obj != null) {
                return Long.valueOf(((Long) obj).longValue());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, Long l) {
            long longValue = l.longValue();
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putLong(str, longValue);
        }
    };
    public static final NavType<long[]> NetworkUserEntityData$$ExternalSyntheticLambda0 = new NavType<long[]>() { // from class: androidx.navigation.NavType$Companion$LongArrayType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "long[]";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ long[] PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ long[] MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (long[]) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, long[] jArr) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putLongArray(str, jArr);
        }
    };
    public static final NavType<Float> KClassImpl$Data$declaredNonStaticMembers$2 = new NavType<Float>() { // from class: androidx.navigation.NavType$Companion$FloatType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "float";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ Float PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            return Float.valueOf(Float.parseFloat(str));
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ Float MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            Object obj = bundle.get(str);
            if (obj != null) {
                return Float.valueOf(((Float) obj).floatValue());
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, Float f) {
            float floatValue = f.floatValue();
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putFloat(str, floatValue);
        }
    };
    public static final NavType<float[]> getAuthRequestContext = new NavType<float[]>() { // from class: androidx.navigation.NavType$Companion$FloatArrayType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "float[]";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ float[] PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ float[] MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (float[]) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, float[] fArr) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putFloatArray(str, fArr);
        }
    };
    public static final NavType<Boolean> MyBillsEntityDataFactory = new NavType<Boolean>() { // from class: androidx.navigation.NavType$Companion$BoolType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "boolean";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ Boolean PlaceComponentResult(String str) {
            boolean z;
            Intrinsics.checkNotNullParameter(str, "");
            if (Intrinsics.areEqual(str, SummaryActivity.CHECKED)) {
                z = true;
            } else if (!Intrinsics.areEqual(str, "false")) {
                throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ Boolean MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (Boolean) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putBoolean(str, booleanValue);
        }
    };
    public static final NavType<boolean[]> BuiltInFictitiousFunctionClassFactory = new NavType<boolean[]>() { // from class: androidx.navigation.NavType$Companion$BoolArrayType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "boolean[]";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ boolean[] PlaceComponentResult(String str) {
            return PlaceComponentResult(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ boolean[] MyBillsEntityDataFactory(Bundle bundle, String str) {
            return BuiltInFictitiousFunctionClassFactory(bundle, str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, boolean[] zArr) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putBooleanArray(str, zArr);
        }

        private static boolean[] BuiltInFictitiousFunctionClassFactory(Bundle p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return (boolean[]) p0.get(p1);
        }

        private static boolean[] PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }
    };
    public static final NavType<String> NetworkUserEntityData$$ExternalSyntheticLambda2 = new NavType<String>() { // from class: androidx.navigation.NavType$Companion$StringType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "string";
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ String MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (String) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, String str2) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putString(str, str2);
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ String PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            return str;
        }
    };
    public static final NavType<String[]> scheduleImpl = new NavType<String[]>() { // from class: androidx.navigation.NavType$Companion$StringArrayType$1
        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            return "string[]";
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ String[] PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ String[] MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (String[]) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, String[] strArr) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            bundle.putStringArray(str, strArr);
        }
    };

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
    public abstract T PlaceComponentResult(String p0);

    public abstract T MyBillsEntityDataFactory(Bundle p0, String p1);

    public abstract void MyBillsEntityDataFactory(Bundle p0, String p1, T p2);

    public NavType(boolean z) {
        this.getAuthRequestContext = z;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public String getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    public String toString() {
        return getMyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J'\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00058\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00058\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00058\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00058\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00058\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00190\u00058\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c0\u00058\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00058\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u000e"}, d2 = {"Landroidx/navigation/NavType$Companion;", "", "", "p0", "p1", "Landroidx/navigation/NavType;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/navigation/NavType;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Landroidx/navigation/NavType;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;)Landroidx/navigation/NavType;", "", "BuiltInFictitiousFunctionClassFactory", "Landroidx/navigation/NavType;", "", "", "getAuthRequestContext", "", "", "", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "scheduleImpl", "", "lookAheadTest", "getErrorConfigVersion", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static NavType<?> PlaceComponentResult(String p0, String p1) {
            String str;
            if (Intrinsics.areEqual(NavType.moveToNextValue.getMyBillsEntityDataFactory(), p0)) {
                return NavType.moveToNextValue;
            }
            if (Intrinsics.areEqual(NavType.PlaceComponentResult.getMyBillsEntityDataFactory(), p0)) {
                return NavType.PlaceComponentResult;
            }
            if (Intrinsics.areEqual(NavType.lookAheadTest.getMyBillsEntityDataFactory(), p0)) {
                return NavType.lookAheadTest;
            }
            if (Intrinsics.areEqual(NavType.NetworkUserEntityData$$ExternalSyntheticLambda0.getMyBillsEntityDataFactory(), p0)) {
                return NavType.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            if (Intrinsics.areEqual(NavType.MyBillsEntityDataFactory.getMyBillsEntityDataFactory(), p0)) {
                return NavType.MyBillsEntityDataFactory;
            }
            if (Intrinsics.areEqual(NavType.BuiltInFictitiousFunctionClassFactory.getMyBillsEntityDataFactory(), p0)) {
                return NavType.BuiltInFictitiousFunctionClassFactory;
            }
            if (Intrinsics.areEqual(NavType.NetworkUserEntityData$$ExternalSyntheticLambda2.getMyBillsEntityDataFactory(), p0)) {
                return NavType.NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
            if (Intrinsics.areEqual(NavType.scheduleImpl.getMyBillsEntityDataFactory(), p0)) {
                return NavType.scheduleImpl;
            }
            if (Intrinsics.areEqual(NavType.KClassImpl$Data$declaredNonStaticMembers$2.getMyBillsEntityDataFactory(), p0)) {
                return NavType.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (Intrinsics.areEqual(NavType.getAuthRequestContext.getMyBillsEntityDataFactory(), p0)) {
                return NavType.getAuthRequestContext;
            }
            if (Intrinsics.areEqual(NavType.getErrorConfigVersion.getMyBillsEntityDataFactory(), p0)) {
                return NavType.getErrorConfigVersion;
            }
            String str2 = p0;
            if (!(str2 == null || str2.length() == 0)) {
                try {
                    if (!StringsKt.startsWith$default(p0, ".", false, 2, (Object) null) || p1 == null) {
                        str = p0;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append(p1);
                        sb.append(p0);
                        str = sb.toString();
                    }
                    if (StringsKt.endsWith$default(p0, "[]", false, 2, (Object) null)) {
                        str = str.substring(0, str.length() - 2);
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        Class<?> cls = Class.forName(str);
                        if (Parcelable.class.isAssignableFrom(cls)) {
                            if (cls != null) {
                                return new ParcelableArrayType(cls);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                        } else if (Serializable.class.isAssignableFrom(cls)) {
                            if (cls != null) {
                                return new SerializableArrayType(cls);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                        }
                    } else {
                        Class<?> cls2 = Class.forName(str);
                        if (Parcelable.class.isAssignableFrom(cls2)) {
                            if (cls2 != null) {
                                return new ParcelableType(cls2);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Any?>");
                        } else if (Enum.class.isAssignableFrom(cls2)) {
                            if (cls2 != null) {
                                return new EnumType(cls2);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>>");
                        } else if (Serializable.class.isAssignableFrom(cls2)) {
                            if (cls2 != null) {
                                return new SerializableType(cls2);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(" is not Serializable or Parcelable.");
                    throw new IllegalArgumentException(sb2.toString());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            return NavType.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }

        @JvmStatic
        public static NavType<Object> MyBillsEntityDataFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                try {
                    try {
                        try {
                            NavType.moveToNextValue.PlaceComponentResult(p0);
                            return NavType.moveToNextValue;
                        } catch (IllegalArgumentException unused) {
                            NavType.lookAheadTest.PlaceComponentResult(p0);
                            return NavType.lookAheadTest;
                        }
                    } catch (IllegalArgumentException unused2) {
                        NavType.MyBillsEntityDataFactory.PlaceComponentResult(p0);
                        return NavType.MyBillsEntityDataFactory;
                    }
                } catch (IllegalArgumentException unused3) {
                    NavType.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0);
                    return NavType.KClassImpl$Data$declaredNonStaticMembers$2;
                }
            } catch (IllegalArgumentException unused4) {
                return NavType.NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
        }

        @JvmStatic
        public static NavType<Object> KClassImpl$Data$declaredNonStaticMembers$2(Object p0) {
            if (p0 instanceof Integer) {
                return NavType.moveToNextValue;
            }
            if (p0 instanceof int[]) {
                return NavType.PlaceComponentResult;
            }
            if (p0 instanceof Long) {
                return NavType.lookAheadTest;
            }
            if (p0 instanceof long[]) {
                return NavType.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
            if (p0 instanceof Float) {
                return NavType.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (p0 instanceof float[]) {
                return NavType.getAuthRequestContext;
            }
            if (p0 instanceof Boolean) {
                return NavType.MyBillsEntityDataFactory;
            }
            if (p0 instanceof boolean[]) {
                return NavType.BuiltInFictitiousFunctionClassFactory;
            }
            if ((p0 instanceof String) || p0 == null) {
                return NavType.NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
            if ((p0 instanceof Object[]) && (((Object[]) p0) instanceof String[])) {
                return NavType.scheduleImpl;
            }
            if (p0.getClass().isArray()) {
                Class<?> componentType = p0.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Class<?> componentType2 = p0.getClass().getComponentType();
                    if (componentType2 != null) {
                        return new ParcelableArrayType(componentType2);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                }
            }
            if (p0.getClass().isArray()) {
                Class<?> componentType3 = p0.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType3);
                if (Serializable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = p0.getClass().getComponentType();
                    if (componentType4 != null) {
                        return new SerializableArrayType(componentType4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                }
            }
            if (p0 instanceof Parcelable) {
                return new ParcelableType(p0.getClass());
            }
            if (p0 instanceof Enum) {
                return new EnumType(p0.getClass());
            }
            if (p0 instanceof Serializable) {
                return new SerializableType(p0.getClass());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Object of type ");
            sb.append(p0.getClass().getName());
            sb.append(" is not supported for navigation arguments.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\t8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Landroidx/navigation/NavType$ParcelableType;", SummaryActivity.DAYS, "Landroidx/navigation/NavType;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Bundle;", "", "p1", "MyBillsEntityDataFactory", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "", "hashCode", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/Object;", "p2", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "getAuthRequestContext", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Class;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ParcelableType<D> extends NavType<D> {

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        private final Class<D> getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParcelableType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "");
            boolean z = true;
            if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
                z = false;
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(cls);
                sb.append(" does not implement Parcelable or Serializable.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            this.getAuthRequestContext = cls;
        }

        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            String name = this.getAuthRequestContext.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            return name;
        }

        @Override // androidx.view.NavType
        public final void MyBillsEntityDataFactory(Bundle p0, String p1, D p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            this.getAuthRequestContext.cast(p2);
            if (p2 == null || (p2 instanceof Parcelable)) {
                p0.putParcelable(p1, (Parcelable) p2);
            } else if (p2 instanceof Serializable) {
                p0.putSerializable(p1, (Serializable) p2);
            }
        }

        @Override // androidx.view.NavType
        public final D MyBillsEntityDataFactory(Bundle p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return (D) p0.get(p1);
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final D PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 == null || !Intrinsics.areEqual(getClass(), p0.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.getAuthRequestContext, ((ParcelableType) p0).getAuthRequestContext);
        }

        public final int hashCode() {
            return this.getAuthRequestContext.hashCode();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/navigation/NavType$ParcelableArrayType;", "Landroid/os/Parcelable;", SummaryActivity.DAYS, "Landroidx/navigation/NavType;", "", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/Class;", "DatabaseTableConfigUtil", "Ljava/lang/Class;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/Class;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        private final Class<D[]> BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "");
            if (!Parcelable.class.isAssignableFrom(cls)) {
                StringBuilder sb = new StringBuilder();
                sb.append(cls);
                sb.append(" does not implement Parcelable.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[L");
                sb2.append(cls.getName());
                sb2.append(';');
                Class<D[]> cls2 = (Class<D[]>) Class.forName(sb2.toString());
                if (cls2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");
                }
                this.BuiltInFictitiousFunctionClassFactory = cls2;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ Object PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ Object MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (Parcelable[]) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, Object obj) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory.cast(parcelableArr);
            bundle.putParcelableArray(str, parcelableArr);
        }

        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            String name = this.BuiltInFictitiousFunctionClassFactory.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            return name;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 == null || !Intrinsics.areEqual(getClass(), p0.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((ParcelableArrayType) p0).BuiltInFictitiousFunctionClassFactory);
        }

        public final int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0017\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016B\u001f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0018J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Landroidx/navigation/NavType$SerializableType;", "Ljava/io/Serializable;", SummaryActivity.DAYS, "Landroidx/navigation/NavType;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/io/Serializable;", "getAuthRequestContext", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Class;", "DatabaseTableConfigUtil", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "p1", "(Ljava/lang/Class;B)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class SerializableType<D extends Serializable> extends NavType<D> {

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        private final Class<D> PlaceComponentResult;

        @Override // androidx.view.NavType
        public final /* synthetic */ Object MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (Serializable) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, Object obj) {
            Serializable serializable = (Serializable) obj;
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(serializable, "");
            this.PlaceComponentResult.cast(serializable);
            bundle.putSerializable(str, serializable);
        }

        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public String getMyBillsEntityDataFactory() {
            String name = this.PlaceComponentResult.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            return name;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "");
            if (!Serializable.class.isAssignableFrom(cls)) {
                StringBuilder sb = new StringBuilder();
                sb.append(cls);
                sb.append(" does not implement Serializable.");
                throw new IllegalArgumentException(sb.toString().toString());
            } else if (!(true ^ cls.isEnum())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cls);
                sb2.append(" is an Enum. You should use EnumType instead.");
                throw new IllegalArgumentException(sb2.toString().toString());
            } else {
                this.PlaceComponentResult = cls;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableType(Class<D> cls, byte b) {
            super(false);
            Intrinsics.checkNotNullParameter(cls, "");
            if (!Serializable.class.isAssignableFrom(cls)) {
                StringBuilder sb = new StringBuilder();
                sb.append(cls);
                sb.append(" does not implement Serializable.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            this.PlaceComponentResult = cls;
        }

        @Override // androidx.view.NavType
        public D PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof SerializableType) {
                return Intrinsics.areEqual(this.PlaceComponentResult, ((SerializableType) p0).PlaceComponentResult);
            }
            return false;
        }

        public int hashCode() {
            return this.PlaceComponentResult.hashCode();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\f\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/navigation/NavType$EnumType;", "", SummaryActivity.DAYS, "Landroidx/navigation/NavType$SerializableType;", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/lang/Enum;", "getAuthRequestContext", "()Ljava/lang/String;", "Ljava/lang/Class;", "DatabaseTableConfigUtil", "Ljava/lang/Class;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/Class;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        private final Class<D> KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumType(Class<D> cls) {
            super(cls, (byte) 0);
            Intrinsics.checkNotNullParameter(cls, "");
            if (!cls.isEnum()) {
                StringBuilder sb = new StringBuilder();
                sb.append(cls);
                sb.append(" is not an Enum type.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = cls;
        }

        @Override // androidx.navigation.NavType.SerializableType, androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            String name = this.KClassImpl$Data$declaredNonStaticMembers$2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            return name;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // androidx.navigation.NavType.SerializableType
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public D PlaceComponentResult(String p0) {
            D d;
            Intrinsics.checkNotNullParameter(p0, "");
            D[] enumConstants = this.KClassImpl$Data$declaredNonStaticMembers$2.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(enumConstants, "");
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    d = null;
                    break;
                }
                d = enumConstants[i];
                if (StringsKt.equals(d.name(), p0, true)) {
                    break;
                }
                i++;
            }
            D d2 = d;
            if (d2 != null) {
                return d2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Enum value ");
            sb.append(p0);
            sb.append(" not found for type ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getName());
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/navigation/NavType$SerializableArrayType;", "Ljava/io/Serializable;", SummaryActivity.DAYS, "Landroidx/navigation/NavType;", "", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/Class;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/Class;", "MyBillsEntityDataFactory", "", "getAuthRequestContext", "()Ljava/lang/String;", "PlaceComponentResult", "<init>", "(Ljava/lang/Class;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        private final Class<D[]> MyBillsEntityDataFactory;

        @Override // androidx.view.NavType
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final /* synthetic */ Object PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ Object MyBillsEntityDataFactory(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            return (Serializable[]) bundle.get(str);
        }

        @Override // androidx.view.NavType
        public final /* synthetic */ void MyBillsEntityDataFactory(Bundle bundle, String str, Object obj) {
            Serializable[] serializableArr = (Serializable[]) obj;
            Intrinsics.checkNotNullParameter(bundle, "");
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory.cast(serializableArr);
            bundle.putSerializable(str, (Serializable) serializableArr);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "");
            if (!Serializable.class.isAssignableFrom(cls)) {
                StringBuilder sb = new StringBuilder();
                sb.append(cls);
                sb.append(" does not implement Serializable.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[L");
                sb2.append(cls.getName());
                sb2.append(';');
                Class<D[]> cls2 = (Class<D[]>) Class.forName(sb2.toString());
                if (cls2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");
                }
                this.MyBillsEntityDataFactory = cls2;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.view.NavType
        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext */
        public final String getMyBillsEntityDataFactory() {
            String name = this.MyBillsEntityDataFactory.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            return name;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 == null || !Intrinsics.areEqual(getClass(), p0.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((SerializableArrayType) p0).MyBillsEntityDataFactory);
        }

        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode();
        }
    }
}
