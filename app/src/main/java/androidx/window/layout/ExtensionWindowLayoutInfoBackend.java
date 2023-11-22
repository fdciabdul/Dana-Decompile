package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0016\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/ExtensionWindowLayoutInfoBackend;", "Landroidx/window/layout/WindowBackend;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "(Landroidx/window/extensions/layout/WindowLayoutComponent;)V", "activityToListeners", "", "Landroid/app/Activity;", "Landroidx/window/layout/ExtensionWindowLayoutInfoBackend$MulticastConsumer;", "extensionWindowBackendLock", "Ljava/util/concurrent/locks/ReentrantLock;", "listenerToActivity", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "registerLayoutChangeCallback", "", AkuEventParamsKey.KEY_ACTIVITY, "executor", "Ljava/util/concurrent/Executor;", "callback", "unregisterLayoutChangeCallback", "MulticastConsumer", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ExtensionWindowLayoutInfoBackend implements WindowBackend {
    private final Map<Activity, MulticastConsumer> BuiltInFictitiousFunctionClassFactory;
    private final ReentrantLock KClassImpl$Data$declaredNonStaticMembers$2;
    private final WindowLayoutComponent PlaceComponentResult;
    private final Map<Consumer<WindowLayoutInfo>, Activity> getAuthRequestContext;

    public ExtensionWindowLayoutInfoBackend(WindowLayoutComponent windowLayoutComponent) {
        Intrinsics.checkNotNullParameter(windowLayoutComponent, "");
        this.PlaceComponentResult = windowLayoutComponent;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ReentrantLock();
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();
        this.getAuthRequestContext = new LinkedHashMap();
    }

    @Override // androidx.window.layout.WindowBackend
    public final void BuiltInFictitiousFunctionClassFactory(Activity activity, Executor executor, Consumer<WindowLayoutInfo> consumer) {
        Unit unit;
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(consumer, "");
        ReentrantLock reentrantLock = this.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = this.BuiltInFictitiousFunctionClassFactory.get(activity);
            if (multicastConsumer == null) {
                unit = null;
            } else {
                multicastConsumer.getAuthRequestContext(consumer);
                this.getAuthRequestContext.put(consumer, activity);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                ExtensionWindowLayoutInfoBackend extensionWindowLayoutInfoBackend = this;
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(activity);
                this.BuiltInFictitiousFunctionClassFactory.put(activity, multicastConsumer2);
                this.getAuthRequestContext.put(consumer, activity);
                multicastConsumer2.getAuthRequestContext(consumer);
                this.PlaceComponentResult.addWindowLayoutInfoListener(activity, multicastConsumer2);
            }
            Unit unit2 = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.window.layout.WindowBackend
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Consumer<WindowLayoutInfo> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "");
        ReentrantLock reentrantLock = this.KClassImpl$Data$declaredNonStaticMembers$2;
        reentrantLock.lock();
        try {
            Activity activity = this.getAuthRequestContext.get(consumer);
            if (activity == null) {
                return;
            }
            MulticastConsumer multicastConsumer = this.BuiltInFictitiousFunctionClassFactory.get(activity);
            if (multicastConsumer == null) {
                return;
            }
            Intrinsics.checkNotNullParameter(consumer, "");
            reentrantLock = multicastConsumer.PlaceComponentResult;
            reentrantLock.lock();
            multicastConsumer.MyBillsEntityDataFactory.remove(consumer);
            reentrantLock.unlock();
            if (multicastConsumer.getAuthRequestContext()) {
                this.PlaceComponentResult.removeWindowLayoutInfoListener(multicastConsumer);
            }
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            throw th;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/ExtensionWindowLayoutInfoBackend$MulticastConsumer;", "j$/util/function/Consumer", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "value", "", "accept", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addListener", "removeListener", "", "isEmpty", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Ljava/util/concurrent/locks/ReentrantLock;", "multicastConsumerLock", "Ljava/util/concurrent/locks/ReentrantLock;", "lastKnownValue", "Landroidx/window/layout/WindowLayoutInfo;", "", "registeredListeners", "Ljava/util/Set;", "<init>", "(Landroid/app/Activity;)V", "window_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes6.dex */
    static final class MulticastConsumer implements j$.util.function.Consumer<androidx.window.extensions.layout.WindowLayoutInfo> {
        private final Activity BuiltInFictitiousFunctionClassFactory;
        final Set<Consumer<WindowLayoutInfo>> MyBillsEntityDataFactory;
        final ReentrantLock PlaceComponentResult;
        private WindowLayoutInfo getAuthRequestContext;

        @Override // j$.util.function.Consumer
        public final /* synthetic */ j$.util.function.Consumer<androidx.window.extensions.layout.WindowLayoutInfo> andThen(j$.util.function.Consumer<? super androidx.window.extensions.layout.WindowLayoutInfo> consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        public MulticastConsumer(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "");
            this.BuiltInFictitiousFunctionClassFactory = activity;
            this.PlaceComponentResult = new ReentrantLock();
            this.MyBillsEntityDataFactory = new LinkedHashSet();
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo) {
            androidx.window.extensions.layout.WindowLayoutInfo windowLayoutInfo2 = windowLayoutInfo;
            Intrinsics.checkNotNullParameter(windowLayoutInfo2, "");
            ReentrantLock reentrantLock = this.PlaceComponentResult;
            reentrantLock.lock();
            try {
                ExtensionsWindowLayoutInfoAdapter extensionsWindowLayoutInfoAdapter = ExtensionsWindowLayoutInfoAdapter.MyBillsEntityDataFactory;
                this.getAuthRequestContext = ExtensionsWindowLayoutInfoAdapter.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, windowLayoutInfo2);
                Iterator<T> it = this.MyBillsEntityDataFactory.iterator();
                while (it.hasNext()) {
                    ((androidx.core.util.Consumer) it.next()).accept(this.getAuthRequestContext);
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void getAuthRequestContext(androidx.core.util.Consumer<WindowLayoutInfo> consumer) {
            Intrinsics.checkNotNullParameter(consumer, "");
            ReentrantLock reentrantLock = this.PlaceComponentResult;
            reentrantLock.lock();
            try {
                WindowLayoutInfo windowLayoutInfo = this.getAuthRequestContext;
                if (windowLayoutInfo != null) {
                    consumer.accept(windowLayoutInfo);
                }
                this.MyBillsEntityDataFactory.add(consumer);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean getAuthRequestContext() {
            return this.MyBillsEntityDataFactory.isEmpty();
        }
    }
}
