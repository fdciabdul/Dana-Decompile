package androidx.view;

import android.os.Bundle;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.view.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n"}, d2 = {"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "p0", "Landroidx/lifecycle/Lifecycle$Event;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "PlaceComponentResult", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "Companion", "SavedStateProvider"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Recreator implements LifecycleEventObserver {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SavedStateRegistryOwner PlaceComponentResult;

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "");
        this.PlaceComponentResult = savedStateRegistryOwner;
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner p0, Lifecycle.Event p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p1 != Lifecycle.Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        p0.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this);
        Bundle PlaceComponentResult = this.PlaceComponentResult.getSavedStateRegistry().PlaceComponentResult("androidx.savedstate.Restarter");
        if (PlaceComponentResult == null) {
            return;
        }
        ArrayList<String> stringArrayList = PlaceComponentResult.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
                Intrinsics.checkNotNullExpressionValue(asSubclass, "");
                try {
                    Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object newInstance = declaredConstructor.newInstance(new Object[0]);
                        Intrinsics.checkNotNullExpressionValue(newInstance, "");
                        ((SavedStateRegistry.AutoRecreated) newInstance).MyBillsEntityDataFactory(this.PlaceComponentResult);
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to instantiate ");
                        sb.append(str);
                        throw new RuntimeException(sb.toString(), e);
                    }
                } catch (NoSuchMethodException e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Class ");
                    sb2.append(asSubclass.getSimpleName());
                    sb2.append(" must have default constructor in order to be automatically recreated");
                    throw new IllegalStateException(sb2.toString(), e2);
                }
            } catch (ClassNotFoundException e3) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Class ");
                sb3.append(str);
                sb3.append(" wasn't found");
                throw new RuntimeException(sb3.toString(), e3);
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/savedstate/Recreator$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/os/Bundle;", "", "", "MyBillsEntityDataFactory", "Ljava/util/Set;", "getAuthRequestContext", "Landroidx/savedstate/SavedStateRegistry;", "p0", "<init>", "(Landroidx/savedstate/SavedStateRegistry;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final Set<String> getAuthRequestContext;

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            Intrinsics.checkNotNullParameter(savedStateRegistry, "");
            this.getAuthRequestContext = new LinkedHashSet();
            savedStateRegistry.KClassImpl$Data$declaredNonStaticMembers$2("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.getAuthRequestContext));
            return bundle;
        }
    }
}
