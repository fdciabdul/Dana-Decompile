package androidx.view;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.view.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0003\"!#B\t\b\u0000¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\b\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\b\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0011J\u001d\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012¢\u0006\u0004\b\f\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u0015X\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u001c\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015@BX\u0086\n¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Landroidx/savedstate/SavedStateRegistry;", "", "", "p0", "Landroid/os/Bundle;", "PlaceComponentResult", "(Ljava/lang/String;)Landroid/os/Bundle;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "getAuthRequestContext", "(Ljava/lang/String;)Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "Landroidx/lifecycle/Lifecycle;", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/lifecycle/Lifecycle;)V", "(Landroid/os/Bundle;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "Ljava/lang/Class;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "(Ljava/lang/Class;)V", "", "Z", "Landroidx/arch/core/internal/SafeIterableMap;", "Landroidx/arch/core/internal/SafeIterableMap;", "MyBillsEntityDataFactory", "Landroidx/savedstate/Recreator$SavedStateProvider;", "Landroidx/savedstate/Recreator$SavedStateProvider;", "getErrorConfigVersion", "Landroid/os/Bundle;", "moveToNextValue", "<init>", "()V", "Companion", "AutoRecreated", "SavedStateProvider"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    private static final Companion Companion = new Companion(null);
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Recreator.SavedStateProvider getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private Bundle moveToNextValue;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SafeIterableMap<String, SavedStateProvider> PlaceComponentResult = new SafeIterableMap<>();

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory = true;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "", "Landroidx/savedstate/SavedStateRegistryOwner;", "p0", "", "MyBillsEntityDataFactory", "(Landroidx/savedstate/SavedStateRegistryOwner;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface AutoRecreated {
        void MyBillsEntityDataFactory(SavedStateRegistryOwner p0);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/os/Bundle;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        Bundle KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final Bundle PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.moveToNextValue;
        if (bundle != null) {
            Bundle bundle2 = bundle != null ? bundle.getBundle(p0) : null;
            Bundle bundle3 = this.moveToNextValue;
            if (bundle3 != null) {
                bundle3.remove(p0);
            }
            Bundle bundle4 = this.moveToNextValue;
            boolean z = false;
            if (bundle4 != null && !bundle4.isEmpty()) {
                z = true;
            }
            if (!z) {
                this.moveToNextValue = null;
            }
            return bundle2;
        }
        return null;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, SavedStateProvider p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(p0, p1) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final SavedStateProvider getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Iterator<Map.Entry<String, SavedStateProvider>> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            Map.Entry<String, SavedStateProvider> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "");
            String key = next.getKey();
            SavedStateProvider value = next.getValue();
            if (Intrinsics.areEqual(key, p0)) {
                return value;
            }
        }
        return null;
    }

    public final void BuiltInFictitiousFunctionClassFactory(Class<? extends AutoRecreated> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!this.MyBillsEntityDataFactory) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.SavedStateProvider savedStateProvider = this.getAuthRequestContext;
        if (savedStateProvider == null) {
            savedStateProvider = new Recreator.SavedStateProvider(this);
        }
        this.getAuthRequestContext = savedStateProvider;
        try {
            p0.getDeclaredConstructor(new Class[0]);
            Recreator.SavedStateProvider savedStateProvider2 = this.getAuthRequestContext;
            if (savedStateProvider2 != null) {
                String name = p0.getName();
                Intrinsics.checkNotNullExpressionValue(name, "");
                Intrinsics.checkNotNullParameter(name, "");
                savedStateProvider2.getAuthRequestContext.add(name);
            }
        } catch (NoSuchMethodException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(p0.getSimpleName());
            sb.append(" must have default constructor in order to be automatically recreated");
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(Lifecycle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if ((!this.BuiltInFictitiousFunctionClassFactory) == false) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        p0.BuiltInFictitiousFunctionClassFactory(new LifecycleEventObserver() { // from class: androidx.savedstate.SavedStateRegistry$$ExternalSyntheticLambda0
            @Override // androidx.view.LifecycleEventObserver
            public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                SavedStateRegistry.getAuthRequestContext(SavedStateRegistry.this, lifecycleOwner, event);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    public final void getAuthRequestContext(Bundle p0) {
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if ((!this.KClassImpl$Data$declaredNonStaticMembers$2) == false) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.moveToNextValue = p0 != null ? p0.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.moveToNextValue;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        SafeIterableMap<String, SavedStateProvider> safeIterableMap = this.PlaceComponentResult;
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
        safeIterableMap.BuiltInFictitiousFunctionClassFactory.put(iteratorWithAdditions, Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "");
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions2 = iteratorWithAdditions;
        while (iteratorWithAdditions2.hasNext()) {
            Map.Entry next = iteratorWithAdditions2.next();
            bundle.putBundle((String) next.getKey(), ((SavedStateProvider) next.getValue()).KClassImpl$Data$declaredNonStaticMembers$2());
        }
        if (bundle.isEmpty()) {
            return;
        }
        p0.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getAuthRequestContext(SavedStateRegistry savedStateRegistry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "");
        Intrinsics.checkNotNullParameter(event, "");
        if (event == Lifecycle.Event.ON_START) {
            savedStateRegistry.MyBillsEntityDataFactory = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            savedStateRegistry.MyBillsEntityDataFactory = false;
        }
    }
}
