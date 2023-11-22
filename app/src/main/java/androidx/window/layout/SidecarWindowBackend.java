package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u0005\u0010\rJ\u001d\u0010\u000e\u001a\u00020\f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend;", "Landroidx/window/layout/WindowBackend;", "Landroid/app/Activity;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)Z", "Ljava/util/concurrent/Executor;", "p1", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "p2", "", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/core/util/Consumer;)V", "Landroidx/window/layout/ExtensionInterfaceCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "PlaceComponentResult", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "MyBillsEntityDataFactory", "Ljava/util/concurrent/CopyOnWriteArrayList;", "<init>", "(Landroidx/window/layout/ExtensionInterfaceCompat;)V", "Companion", "ExtensionListenerImpl", "WindowLayoutChangeCallbackWrapper"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SidecarWindowBackend implements WindowBackend {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock PlaceComponentResult = new ReentrantLock();
    private static volatile SidecarWindowBackend getAuthRequestContext;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public ExtensionInterfaceCompat PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> KClassImpl$Data$declaredNonStaticMembers$2 = new CopyOnWriteArrayList<>();

    public SidecarWindowBackend(ExtensionInterfaceCompat extensionInterfaceCompat) {
        this.PlaceComponentResult = extensionInterfaceCompat;
        ExtensionInterfaceCompat extensionInterfaceCompat2 = this.PlaceComponentResult;
        if (extensionInterfaceCompat2 != null) {
            extensionInterfaceCompat2.getAuthRequestContext(new ExtensionListenerImpl(this));
        }
    }

    @Override // androidx.window.layout.WindowBackend
    public final void BuiltInFictitiousFunctionClassFactory(Activity p0, Executor p1, Consumer<WindowLayoutInfo> p2) {
        WindowLayoutInfo windowLayoutInfo;
        Object obj;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        ReentrantLock reentrantLock = PlaceComponentResult;
        reentrantLock.lock();
        try {
            ExtensionInterfaceCompat extensionInterfaceCompat = this.PlaceComponentResult;
            if (extensionInterfaceCompat == null) {
                p2.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
                return;
            }
            boolean BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0);
            WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper = new WindowLayoutChangeCallbackWrapper(p0, p1, p2);
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(windowLayoutChangeCallbackWrapper);
            if (!BuiltInFictitiousFunctionClassFactory) {
                extensionInterfaceCompat.PlaceComponentResult(p0);
            } else {
                Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                while (true) {
                    windowLayoutInfo = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(p0, ((WindowLayoutChangeCallbackWrapper) obj).getAuthRequestContext)) {
                        break;
                    }
                }
                WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper2 = (WindowLayoutChangeCallbackWrapper) obj;
                if (windowLayoutChangeCallbackWrapper2 != null) {
                    windowLayoutInfo = windowLayoutChangeCallbackWrapper2.MyBillsEntityDataFactory;
                }
                if (windowLayoutInfo != null) {
                    Intrinsics.checkNotNullParameter(windowLayoutInfo, "");
                    windowLayoutChangeCallbackWrapper.MyBillsEntityDataFactory = windowLayoutInfo;
                    windowLayoutChangeCallbackWrapper.PlaceComponentResult.execute(new SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0(windowLayoutChangeCallbackWrapper, windowLayoutInfo));
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(Activity p0) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper) it.next()).getAuthRequestContext, p0)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.window.layout.WindowBackend
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Consumer<WindowLayoutInfo> p0) {
        ExtensionInterfaceCompat extensionInterfaceCompat;
        Intrinsics.checkNotNullParameter(p0, "");
        synchronized (PlaceComponentResult) {
            if (this.PlaceComponentResult == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<WindowLayoutChangeCallbackWrapper> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                WindowLayoutChangeCallbackWrapper next = it.next();
                if (next.BuiltInFictitiousFunctionClassFactory == p0) {
                    Intrinsics.checkNotNullExpressionValue(next, "");
                    arrayList.add(next);
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.removeAll(arrayList);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Activity activity = ((WindowLayoutChangeCallbackWrapper) it2.next()).getAuthRequestContext;
                CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> copyOnWriteArrayList = this.KClassImpl$Data$declaredNonStaticMembers$2;
                boolean z = false;
                if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
                    Iterator<T> it3 = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper) it3.next()).getAuthRequestContext, activity)) {
                            z = true;
                            break;
                        }
                    }
                }
                if (!z && (extensionInterfaceCompat = this.PlaceComponentResult) != null) {
                    extensionInterfaceCompat.BuiltInFictitiousFunctionClassFactory(activity);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$ExtensionListenerImpl;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Landroid/app/Activity;", "p0", "Landroidx/window/layout/WindowLayoutInfo;", "p1", "", "PlaceComponentResult", "(Landroid/app/Activity;Landroidx/window/layout/WindowLayoutInfo;)V", "<init>", "(Landroidx/window/layout/SidecarWindowBackend;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        final /* synthetic */ SidecarWindowBackend getAuthRequestContext;

        public ExtensionListenerImpl(SidecarWindowBackend sidecarWindowBackend) {
            Intrinsics.checkNotNullParameter(sidecarWindowBackend, "");
            this.getAuthRequestContext = sidecarWindowBackend;
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public final void PlaceComponentResult(Activity p0, WindowLayoutInfo p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Iterator<WindowLayoutChangeCallbackWrapper> it = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                WindowLayoutChangeCallbackWrapper next = it.next();
                if (Intrinsics.areEqual(next.getAuthRequestContext, p0)) {
                    Intrinsics.checkNotNullParameter(p1, "");
                    next.MyBillsEntityDataFactory = p1;
                    next.PlaceComponentResult.execute(new SidecarWindowBackend$WindowLayoutChangeCallbackWrapper$$ExternalSyntheticLambda0(next, p1));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "", "Landroid/app/Activity;", "BuiltInFictitiousFunctionClassFactory", "Landroid/app/Activity;", "getAuthRequestContext", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "PlaceComponentResult", "Landroidx/core/util/Consumer;", "Ljava/util/concurrent/Executor;", "Ljava/util/concurrent/Executor;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/window/layout/WindowLayoutInfo;", "MyBillsEntityDataFactory", "p0", "p1", "p2", "<init>", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class WindowLayoutChangeCallbackWrapper {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final Activity getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        WindowLayoutInfo MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final Consumer<WindowLayoutInfo> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final Executor PlaceComponentResult;

        public WindowLayoutChangeCallbackWrapper(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer) {
            Intrinsics.checkNotNullParameter(activity, "");
            Intrinsics.checkNotNullParameter(executor, "");
            Intrinsics.checkNotNullParameter(consumer, "");
            this.getAuthRequestContext = activity;
            this.PlaceComponentResult = executor;
            this.BuiltInFictitiousFunctionClassFactory = consumer;
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
            Intrinsics.checkNotNullParameter(windowLayoutChangeCallbackWrapper, "");
            Intrinsics.checkNotNullParameter(windowLayoutInfo, "");
            windowLayoutChangeCallbackWrapper.BuiltInFictitiousFunctionClassFactory.accept(windowLayoutInfo);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\r\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$Companion;", "", "Landroid/content/Context;", "p0", "Landroidx/window/layout/SidecarWindowBackend;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Landroidx/window/layout/SidecarWindowBackend;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "PlaceComponentResult", "(Landroid/content/Context;)Landroidx/window/layout/ExtensionInterfaceCompat;", "Landroidx/window/core/Version;", "", "(Landroidx/window/core/Version;)Z", "getAuthRequestContext", "Landroidx/window/layout/SidecarWindowBackend;", "MyBillsEntityDataFactory", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static SidecarWindowBackend BuiltInFictitiousFunctionClassFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (SidecarWindowBackend.getAuthRequestContext == null) {
                ReentrantLock reentrantLock = SidecarWindowBackend.PlaceComponentResult;
                reentrantLock.lock();
                try {
                    if (SidecarWindowBackend.getAuthRequestContext == null) {
                        Companion companion = SidecarWindowBackend.INSTANCE;
                        ExtensionInterfaceCompat PlaceComponentResult = PlaceComponentResult(p0);
                        Companion companion2 = SidecarWindowBackend.INSTANCE;
                        SidecarWindowBackend.getAuthRequestContext = new SidecarWindowBackend(PlaceComponentResult);
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
            SidecarWindowBackend sidecarWindowBackend = SidecarWindowBackend.getAuthRequestContext;
            Intrinsics.checkNotNull(sidecarWindowBackend);
            return sidecarWindowBackend;
        }

        private static ExtensionInterfaceCompat PlaceComponentResult(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                if (BuiltInFictitiousFunctionClassFactory(SidecarCompat.MyBillsEntityDataFactory.getAuthRequestContext())) {
                    SidecarCompat sidecarCompat = new SidecarCompat(p0);
                    if (sidecarCompat.MyBillsEntityDataFactory()) {
                        return sidecarCompat;
                    }
                    return null;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        private static boolean BuiltInFictitiousFunctionClassFactory(Version p0) {
            Version version;
            if (p0 == null) {
                return false;
            }
            Version.Companion companion = Version.INSTANCE;
            version = Version.getErrorConfigVersion;
            return p0.compareTo(version) >= 0;
        }
    }
}
