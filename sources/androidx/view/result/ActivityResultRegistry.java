package androidx.view.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.view.result.contract.ActivityResultContract;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    public Random getErrorConfigVersion = new Random();
    public final Map<Integer, String> scheduleImpl = new HashMap();
    public final Map<String, Integer> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    private final Map<String, LifecycleContainer> PlaceComponentResult = new HashMap();
    public ArrayList<String> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
    final transient Map<String, CallbackAndContract<?>> MyBillsEntityDataFactory = new HashMap();
    final Map<String, Object> getAuthRequestContext = new HashMap();
    public final Bundle moveToNextValue = new Bundle();

    public abstract <I, O> void MyBillsEntityDataFactory(int i, ActivityResultContract<I, O> activityResultContract, I i2, ActivityOptionsCompat activityOptionsCompat);

    public final <I, O> ActivityResultLauncher<I> KClassImpl$Data$declaredNonStaticMembers$2(final String str, LifecycleOwner lifecycleOwner, final ActivityResultContract<I, O> activityResultContract, final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.PlaceComponentResult().isAtLeast(Lifecycle.State.STARTED)) {
            StringBuilder sb = new StringBuilder();
            sb.append("LifecycleOwner ");
            sb.append(lifecycleOwner);
            sb.append(" is attempting to register while current state is ");
            sb.append(lifecycle.PlaceComponentResult());
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(str);
        LifecycleContainer lifecycleContainer = this.PlaceComponentResult.get(str);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry.1
            @Override // androidx.view.LifecycleEventObserver
            public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                if (Lifecycle.Event.ON_START.equals(event)) {
                    ActivityResultRegistry.this.MyBillsEntityDataFactory.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
                    if (ActivityResultRegistry.this.getAuthRequestContext.containsKey(str)) {
                        Object obj = ActivityResultRegistry.this.getAuthRequestContext.get(str);
                        ActivityResultRegistry.this.getAuthRequestContext.remove(str);
                        activityResultCallback.onActivityResult(obj);
                    }
                    ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.moveToNextValue.getParcelable(str);
                    if (activityResult != null) {
                        ActivityResultRegistry.this.moveToNextValue.remove(str);
                        activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory));
                    }
                } else if (Lifecycle.Event.ON_STOP.equals(event)) {
                    ActivityResultRegistry.this.MyBillsEntityDataFactory.remove(str);
                } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                    ActivityResultRegistry.this.PlaceComponentResult(str);
                }
            }
        };
        lifecycleContainer.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(lifecycleEventObserver);
        lifecycleContainer.MyBillsEntityDataFactory.add(lifecycleEventObserver);
        this.PlaceComponentResult.put(str, lifecycleContainer);
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.2
            @Override // androidx.view.result.ActivityResultLauncher
            public final void MyBillsEntityDataFactory(I i, ActivityOptionsCompat activityOptionsCompat) {
                Integer num = ActivityResultRegistry.this.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
                if (num == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Attempting to launch an unregistered ActivityResultLauncher with contract ");
                    sb2.append(activityResultContract);
                    sb2.append(" and input ");
                    sb2.append(i);
                    sb2.append(". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    throw new IllegalStateException(sb2.toString());
                }
                ActivityResultRegistry.this.BuiltInFictitiousFunctionClassFactory.add(str);
                try {
                    ActivityResultRegistry.this.MyBillsEntityDataFactory(num.intValue(), activityResultContract, i, activityOptionsCompat);
                } catch (Exception e) {
                    ActivityResultRegistry.this.BuiltInFictitiousFunctionClassFactory.remove(str);
                    throw e;
                }
            }

            @Override // androidx.view.result.ActivityResultLauncher
            public final void getAuthRequestContext() {
                ActivityResultRegistry.this.PlaceComponentResult(str);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> ActivityResultLauncher<I> getAuthRequestContext(final String str, final ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        KClassImpl$Data$declaredNonStaticMembers$2(str);
        this.MyBillsEntityDataFactory.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
        if (this.getAuthRequestContext.containsKey(str)) {
            Object obj = this.getAuthRequestContext.get(str);
            this.getAuthRequestContext.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.moveToNextValue.getParcelable(str);
        if (activityResult != null) {
            this.moveToNextValue.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.BuiltInFictitiousFunctionClassFactory, activityResult.MyBillsEntityDataFactory));
        }
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.3
            @Override // androidx.view.result.ActivityResultLauncher
            public final void MyBillsEntityDataFactory(I i, ActivityOptionsCompat activityOptionsCompat) {
                Integer num = ActivityResultRegistry.this.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
                if (num == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempting to launch an unregistered ActivityResultLauncher with contract ");
                    sb.append(activityResultContract);
                    sb.append(" and input ");
                    sb.append(i);
                    sb.append(". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    throw new IllegalStateException(sb.toString());
                }
                ActivityResultRegistry.this.BuiltInFictitiousFunctionClassFactory.add(str);
                try {
                    ActivityResultRegistry.this.MyBillsEntityDataFactory(num.intValue(), activityResultContract, i, activityOptionsCompat);
                } catch (Exception e) {
                    ActivityResultRegistry.this.BuiltInFictitiousFunctionClassFactory.remove(str);
                    throw e;
                }
            }

            @Override // androidx.view.result.ActivityResultLauncher
            public final void getAuthRequestContext() {
                ActivityResultRegistry.this.PlaceComponentResult(str);
            }
        };
    }

    final void PlaceComponentResult(String str) {
        Integer remove;
        if (!this.BuiltInFictitiousFunctionClassFactory.contains(str) && (remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove(str)) != null) {
            this.scheduleImpl.remove(remove);
        }
        this.MyBillsEntityDataFactory.remove(str);
        if (this.getAuthRequestContext.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Dropping pending result for request ");
            sb.append(str);
            sb.append(": ");
            sb.append(this.getAuthRequestContext.get(str));
            InstrumentInjector.log_w("ActivityResultRegistry", sb.toString());
            this.getAuthRequestContext.remove(str);
        }
        if (this.moveToNextValue.containsKey(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Dropping pending result for request ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(this.moveToNextValue.getParcelable(str));
            InstrumentInjector.log_w("ActivityResultRegistry", sb2.toString());
            this.moveToNextValue.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.PlaceComponentResult.get(str);
        if (lifecycleContainer != null) {
            Iterator<LifecycleEventObserver> it = lifecycleContainer.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                lifecycleContainer.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(it.next());
            }
            lifecycleContainer.MyBillsEntityDataFactory.clear();
            this.PlaceComponentResult.remove(str);
        }
    }

    public final boolean MyBillsEntityDataFactory(int i, int i2, Intent intent) {
        String str = this.scheduleImpl.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        CallbackAndContract<?> callbackAndContract = this.MyBillsEntityDataFactory.get(str);
        if (callbackAndContract != null && callbackAndContract.BuiltInFictitiousFunctionClassFactory != null && this.BuiltInFictitiousFunctionClassFactory.contains(str)) {
            callbackAndContract.BuiltInFictitiousFunctionClassFactory.onActivityResult(callbackAndContract.MyBillsEntityDataFactory.parseResult(i2, intent));
            this.BuiltInFictitiousFunctionClassFactory.remove(str);
            return true;
        }
        this.getAuthRequestContext.remove(str);
        this.moveToNextValue.putParcelable(str, new ActivityResult(i2, intent));
        return true;
    }

    public final <O> boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, O o2) {
        String str = this.scheduleImpl.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        CallbackAndContract<?> callbackAndContract = this.MyBillsEntityDataFactory.get(str);
        if (callbackAndContract == null || callbackAndContract.BuiltInFictitiousFunctionClassFactory == null) {
            this.moveToNextValue.remove(str);
            this.getAuthRequestContext.put(str, o2);
            return true;
        }
        ActivityResultCallback<?> activityResultCallback = callbackAndContract.BuiltInFictitiousFunctionClassFactory;
        if (this.BuiltInFictitiousFunctionClassFactory.remove(str)) {
            activityResultCallback.onActivityResult(o2);
            return true;
        }
        return true;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.get(str) != null) {
            return;
        }
        int nextInt = this.getErrorConfigVersion.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (this.scheduleImpl.containsKey(Integer.valueOf(i))) {
                nextInt = this.getErrorConfigVersion.nextInt(2147418112);
            } else {
                this.scheduleImpl.put(Integer.valueOf(i), str);
                this.KClassImpl$Data$declaredNonStaticMembers$2.put(str, Integer.valueOf(i));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CallbackAndContract<O> {
        final ActivityResultCallback<O> BuiltInFictitiousFunctionClassFactory;
        final ActivityResultContract<?, O> MyBillsEntityDataFactory;

        CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.BuiltInFictitiousFunctionClassFactory = activityResultCallback;
            this.MyBillsEntityDataFactory = activityResultContract;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LifecycleContainer {
        final ArrayList<LifecycleEventObserver> MyBillsEntityDataFactory = new ArrayList<>();
        final Lifecycle getAuthRequestContext;

        LifecycleContainer(Lifecycle lifecycle) {
            this.getAuthRequestContext = lifecycle;
        }
    }
}
