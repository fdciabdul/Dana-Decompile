package androidx.view;

import androidx.view.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements LifecycleEventObserver {
    private final FullLifecycleObserver BuiltInFictitiousFunctionClassFactory;
    private final LifecycleEventObserver MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver, LifecycleEventObserver lifecycleEventObserver) {
        this.BuiltInFictitiousFunctionClassFactory = fullLifecycleObserver;
        this.MyBillsEntityDataFactory = lifecycleEventObserver;
    }

    /* renamed from: androidx.lifecycle.FullLifecycleObserverAdapter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                MyBillsEntityDataFactory[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                MyBillsEntityDataFactory[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                MyBillsEntityDataFactory[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.view.LifecycleEventObserver
    public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (AnonymousClass1.MyBillsEntityDataFactory[event.ordinal()]) {
            case 1:
                this.BuiltInFictitiousFunctionClassFactory.onCreate(lifecycleOwner);
                break;
            case 2:
                this.BuiltInFictitiousFunctionClassFactory.onStart(lifecycleOwner);
                break;
            case 3:
                this.BuiltInFictitiousFunctionClassFactory.onResume(lifecycleOwner);
                break;
            case 4:
                this.BuiltInFictitiousFunctionClassFactory.onPause(lifecycleOwner);
                break;
            case 5:
                this.BuiltInFictitiousFunctionClassFactory.onStop(lifecycleOwner);
                break;
            case 6:
                this.BuiltInFictitiousFunctionClassFactory.onDestroy(lifecycleOwner);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        LifecycleEventObserver lifecycleEventObserver = this.MyBillsEntityDataFactory;
        if (lifecycleEventObserver != null) {
            lifecycleEventObserver.BuiltInFictitiousFunctionClassFactory(lifecycleOwner, event);
        }
    }
}
