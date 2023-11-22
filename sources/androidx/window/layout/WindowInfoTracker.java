package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/window/layout/WindowInfoTracker;", "", "Landroid/app/Activity;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)Lkotlinx/coroutines/flow/Flow;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface WindowInfoTracker {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;

    Flow<WindowLayoutInfo> BuiltInFictitiousFunctionClassFactory(Activity p0);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000e"}, d2 = {"Landroidx/window/layout/WindowInfoTracker$Companion;", "", "Landroid/content/Context;", "p0", "Landroidx/window/layout/WindowBackend;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Landroidx/window/layout/WindowBackend;", "", "MyBillsEntityDataFactory", "Z", "getAuthRequestContext", "", "Ljava/lang/String;", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private static final boolean getAuthRequestContext = false;
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();
        private static final String KClassImpl$Data$declaredNonStaticMembers$2 = Reflection.getOrCreateKotlinClass(WindowInfoTracker.class).getSimpleName();

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        static WindowInfoTrackerDecorator MyBillsEntityDataFactory = EmptyDecorator.INSTANCE;

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static androidx.window.layout.WindowBackend KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context r2) {
            /*
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L13
                androidx.window.extensions.layout.WindowLayoutComponent r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.BuiltInFictitiousFunctionClassFactory()     // Catch: java.lang.Throwable -> L13
                if (r0 == 0) goto L1f
                androidx.window.layout.ExtensionWindowLayoutInfoBackend r1 = new androidx.window.layout.ExtensionWindowLayoutInfoBackend     // Catch: java.lang.Throwable -> L13
                r1.<init>(r0)     // Catch: java.lang.Throwable -> L13
                goto L20
            L13:
                boolean r0 = androidx.window.layout.WindowInfoTracker.Companion.getAuthRequestContext
                if (r0 == 0) goto L1f
                java.lang.String r0 = androidx.window.layout.WindowInfoTracker.Companion.KClassImpl$Data$declaredNonStaticMembers$2
                java.lang.String r1 = "Failed to load WindowExtensions"
                com.fullstory.instrumentation.InstrumentInjector.log_d(r0, r1)
            L1f:
                r1 = 0
            L20:
                if (r1 != 0) goto L2b
                androidx.window.layout.SidecarWindowBackend$Companion r0 = androidx.window.layout.SidecarWindowBackend.INSTANCE
                androidx.window.layout.SidecarWindowBackend r2 = androidx.window.layout.SidecarWindowBackend.Companion.BuiltInFictitiousFunctionClassFactory(r2)
                androidx.window.layout.WindowBackend r2 = (androidx.window.layout.WindowBackend) r2
                goto L2e
            L2b:
                r2 = r1
                androidx.window.layout.WindowBackend r2 = (androidx.window.layout.WindowBackend) r2
            L2e:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTracker.Companion.KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context):androidx.window.layout.WindowBackend");
        }
    }

    /* renamed from: androidx.window.layout.WindowInfoTracker$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = WindowInfoTracker.INSTANCE;
        }

        @JvmStatic
        public static WindowInfoTracker PlaceComponentResult(Context context) {
            Companion companion = WindowInfoTracker.INSTANCE;
            Intrinsics.checkNotNullParameter(context, "");
            return Companion.MyBillsEntityDataFactory.MyBillsEntityDataFactory(new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.INSTANCE, Companion.KClassImpl$Data$declaredNonStaticMembers$2(context)));
        }
    }
}
