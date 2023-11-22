package androidx.window.core;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0012\u001a\u00020\u000fX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0011\u0010\u0018\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016"}, d2 = {"Landroidx/window/core/Version;", "", "p0", "", "PlaceComponentResult", "(Landroidx/window/core/Version;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/math/BigInteger;", "moveToNextValue", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "lookAheadTest", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "p1", "p2", "p3", "<init>", "(IIILjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Version implements Comparable<Version> {
    public static final Version BuiltInFictitiousFunctionClassFactory;
    public static final Version MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final int PlaceComponentResult;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Version KClassImpl$Data$declaredNonStaticMembers$2 = new Version(0, 0, 0, "");
    private static final Version getErrorConfigVersion = new Version(0, 1, 0, "");

    public /* synthetic */ Version(int i, int i2, int i3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, str);
    }

    private Version(int i, int i2, int i3, String str) {
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.PlaceComponentResult = i3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<BigInteger>() { // from class: androidx.window.core.Version$bigInteger$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BigInteger invoke() {
                return BigInteger.valueOf(Version.this.getAuthRequestContext).shiftLeft(32).or(BigInteger.valueOf(Version.this.BuiltInFictitiousFunctionClassFactory)).shiftLeft(32).or(BigInteger.valueOf(Version.this.PlaceComponentResult));
            }
        });
    }

    public final String toString() {
        String stringPlus = StringsKt.isBlank(this.KClassImpl$Data$declaredNonStaticMembers$2) ^ true ? Intrinsics.stringPlus("-", this.KClassImpl$Data$declaredNonStaticMembers$2) : "";
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAuthRequestContext);
        sb.append('.');
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('.');
        sb.append(this.PlaceComponentResult);
        sb.append(stringPlus);
        return sb.toString();
    }

    public final boolean equals(Object p0) {
        if (p0 instanceof Version) {
            Version version = (Version) p0;
            return this.getAuthRequestContext == version.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory == version.BuiltInFictitiousFunctionClassFactory && this.PlaceComponentResult == version.PlaceComponentResult;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.getAuthRequestContext + 527) * 31) + this.BuiltInFictitiousFunctionClassFactory) * 31) + this.PlaceComponentResult;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\b\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0017\u0010\r\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\t\u0010\fR\u0011\u0010\t\u001a\u00020\u0004X\u0007¢\u0006\u0006\n\u0004\b\b\u0010\u0007"}, d2 = {"Landroidx/window/core/Version$Companion;", "", "", "p0", "Landroidx/window/core/Version;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Landroidx/window/core/Version;", "Landroidx/window/core/Version;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "getErrorConfigVersion", "()Landroidx/window/core/Version;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        public static Version KClassImpl$Data$declaredNonStaticMembers$2() {
            return Version.getErrorConfigVersion;
        }

        @JvmStatic
        public static Version MyBillsEntityDataFactory(String p0) {
            if (p0 != null) {
                String str = p0;
                if (!StringsKt.isBlank(str)) {
                    Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        Integer valueOf = group == null ? null : Integer.valueOf(Integer.parseInt(group));
                        if (valueOf == null) {
                            return null;
                        }
                        int intValue = valueOf.intValue();
                        String group2 = matcher.group(2);
                        Integer valueOf2 = group2 == null ? null : Integer.valueOf(Integer.parseInt(group2));
                        if (valueOf2 == null) {
                            return null;
                        }
                        int intValue2 = valueOf2.intValue();
                        String group3 = matcher.group(3);
                        Integer valueOf3 = group3 == null ? null : Integer.valueOf(Integer.parseInt(group3));
                        if (valueOf3 == null) {
                            return null;
                        }
                        int intValue3 = valueOf3.intValue();
                        String group4 = matcher.group(4) != null ? matcher.group(4) : "";
                        Intrinsics.checkNotNullExpressionValue(group4, "");
                        return new Version(intValue, intValue2, intValue3, group4, null);
                    }
                    return null;
                }
            }
            return null;
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        BuiltInFictitiousFunctionClassFactory = version;
        MyBillsEntityDataFactory = version;
    }

    @Override // java.lang.Comparable
    /* renamed from: PlaceComponentResult */
    public final int compareTo(Version p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Object value = this.MyBillsEntityDataFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        Object value2 = p0.MyBillsEntityDataFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(value2, "");
        return ((BigInteger) value).compareTo((BigInteger) value2);
    }
}
