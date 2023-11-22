package id.dana.analytics.firebase;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/analytics/firebase/Crashlytics;", "", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "MyBillsEntityDataFactory", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "getAuthRequestContext", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Crashlytics {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final FirebaseCrashlytics getAuthRequestContext;

    public /* synthetic */ Crashlytics(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final Crashlytics BuiltInFictitiousFunctionClassFactory() {
        return Companion.getAuthRequestContext();
    }

    @JvmStatic
    public static final boolean getAuthRequestContext() {
        return Companion.MyBillsEntityDataFactory();
    }

    private Crashlytics() {
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseCrashlytics, "");
        this.getAuthRequestContext = firebaseCrashlytics;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000b\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000b\u0010\u000e"}, d2 = {"Lid/dana/analytics/firebase/Crashlytics$Companion;", "", "", "MyBillsEntityDataFactory", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)V", "Lid/dana/analytics/firebase/Crashlytics;", "()Lid/dana/analytics/firebase/Crashlytics;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Crashlytics getAuthRequestContext() {
            return new Crashlytics(null);
        }

        @JvmStatic
        public static void getAuthRequestContext(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            FirebaseCrashlytics.getInstance().setUserId(p0);
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory() {
            FirebaseCrashlytics.getInstance().setUserId("");
        }

        @JvmStatic
        public static boolean MyBillsEntityDataFactory() {
            return CommonUtils.isEmulator();
        }

        @JvmStatic
        public static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return CommonUtils.isRooted();
        }
    }
}
