package io.reactivex.internal.util;

import androidx.view.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes6.dex */
public final class EndConsumerHelper {
    private EndConsumerHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean getAuthRequestContext(Disposable disposable, Disposable disposable2, Class<?> cls) {
        ObjectHelper.PlaceComponentResult(disposable2, "next is null");
        if (disposable != null) {
            disposable2.dispose();
            if (disposable != DisposableHelper.DISPOSED) {
                PlaceComponentResult(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean getAuthRequestContext(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        ObjectHelper.PlaceComponentResult(disposable, "next is null");
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(atomicReference, null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() != DisposableHelper.DISPOSED) {
            PlaceComponentResult(cls);
            return false;
        }
        return false;
    }

    public static boolean getAuthRequestContext(Subscription subscription, Subscription subscription2, Class<?> cls) {
        ObjectHelper.PlaceComponentResult(subscription2, "next is null");
        if (subscription != null) {
            subscription2.cancel();
            if (subscription != SubscriptionHelper.CANCELLED) {
                PlaceComponentResult(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> cls) {
        ObjectHelper.PlaceComponentResult(subscription, "next is null");
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.KClassImpl$Data$declaredNonStaticMembers$2(atomicReference, null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() != SubscriptionHelper.CANCELLED) {
            PlaceComponentResult(cls);
            return false;
        }
        return false;
    }

    private static void PlaceComponentResult(Class<?> cls) {
        String name = cls.getName();
        StringBuilder sb = new StringBuilder();
        sb.append("It is not allowed to subscribe with a(n) ");
        sb.append(name);
        sb.append(" multiple times. Please create a fresh instance of ");
        sb.append(name);
        sb.append(" and subscribe that to the target source instead.");
        RxJavaPlugins.PlaceComponentResult(new ProtocolViolationException(sb.toString()));
    }
}
