package androidx.view;

import android.app.Application;
import androidx.view.viewmodel.CreationExtras;
import androidx.view.viewmodel.MutableCreationExtras;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0014\u0012\u0006\u0010\t\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016B!\u0012\u0006\u0010\u0005\u001a\u00020\u0011\u0012\u0006\u0010\t\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0018J(\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/lifecycle/ViewModelProvider;", "", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "p1", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModelStore;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/ViewModelStore;", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "p2", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "AndroidViewModelFactory", "Factory", "NewInstanceFactory", "OnRequeryFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class ViewModelProvider {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CreationExtras getAuthRequestContext;
    private final ViewModelStore KClassImpl$Data$declaredNonStaticMembers$2;
    private final Factory MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "", "Landroidx/lifecycle/ViewModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/lifecycle/ViewModel;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class OnRequeryFactory {
        public void BuiltInFictitiousFunctionClassFactory(ViewModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this(viewModelStore, factory, null, 4, null);
        Intrinsics.checkNotNullParameter(viewModelStore, "");
        Intrinsics.checkNotNullParameter(factory, "");
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(viewModelStore, "");
        Intrinsics.checkNotNullParameter(factory, "");
        Intrinsics.checkNotNullParameter(creationExtras, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewModelStore;
        this.MyBillsEntityDataFactory = factory;
        this.getAuthRequestContext = creationExtras;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras.Empty empty, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory, (i & 4) != 0 ? CreationExtras.Empty.INSTANCE : empty);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J-\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory;", "", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Factory {
        public static final Companion MyBillsEntityDataFactory = Companion.KClassImpl$Data$declaredNonStaticMembers$2;

        <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> cls);

        <T extends ViewModel> T MyBillsEntityDataFactory(Class<T> cls, CreationExtras creationExtras);

        /* renamed from: androidx.lifecycle.ViewModelProvider$Factory$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public final /* synthetic */ class CC {
            static {
                Companion companion = Factory.MyBillsEntityDataFactory;
            }

            public static ViewModel getAuthRequestContext(Class cls) {
                Intrinsics.checkNotNullParameter(cls, "");
                throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
            }

            public static ViewModel BuiltInFictitiousFunctionClassFactory(Factory factory, Class cls, CreationExtras creationExtras) {
                Intrinsics.checkNotNullParameter(cls, "");
                Intrinsics.checkNotNullParameter(creationExtras, "");
                return factory.BuiltInFictitiousFunctionClassFactory(cls);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

            private Companion() {
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ViewModelProvider(androidx.view.ViewModelStoreOwner r3, androidx.lifecycle.ViewModelProvider.Factory r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.lifecycle.ViewModelStore r1 = r3.getViewModelStore()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            androidx.lifecycle.viewmodel.CreationExtras r3 = androidx.view.ViewModelProviderGetKt.PlaceComponentResult(r3)
            r2.<init>(r1, r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner, androidx.lifecycle.ViewModelProvider$Factory):void");
    }

    public final <T extends ViewModel> T MyBillsEntityDataFactory(Class<T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String canonicalName = p0.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
        sb.append(canonicalName);
        return (T) getAuthRequestContext(sb.toString(), p0);
    }

    public final <T extends ViewModel> T getAuthRequestContext(String p0, Class<T> p1) {
        T t;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        T t2 = (T) this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.get(p0);
        if (p1.isInstance(t2)) {
            Factory factory = this.MyBillsEntityDataFactory;
            OnRequeryFactory onRequeryFactory = factory instanceof OnRequeryFactory ? (OnRequeryFactory) factory : null;
            if (onRequeryFactory != null) {
                Intrinsics.checkNotNullExpressionValue(t2, "");
                onRequeryFactory.BuiltInFictitiousFunctionClassFactory(t2);
            }
            if (t2 != null) {
                return t2;
            }
            throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.getAuthRequestContext);
        CreationExtras.Key<String> key = NewInstanceFactory.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(key, "");
        mutableCreationExtras.MyBillsEntityDataFactory.put(key, p0);
        try {
            t = (T) this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(p1, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            t = (T) this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(p1);
        }
        ViewModel put = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.put(p0, t);
        if (put != null) {
            put.onCleared();
        }
        return t;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {
        private static NewInstanceFactory KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final CreationExtras.Key<String> BuiltInFictitiousFunctionClassFactory = Companion.ViewModelKeyImpl.INSTANCE;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel MyBillsEntityDataFactory(Class cls, CreationExtras creationExtras) {
            return Factory.CC.BuiltInFictitiousFunctionClassFactory(this, cls, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                T newInstance = p0.newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance, "");
                return newInstance;
            } catch (IllegalAccessException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot create an instance of ");
                sb.append(p0);
                throw new RuntimeException(sb.toString(), e);
            } catch (InstantiationException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot create an instance of ");
                sb2.append(p0);
                throw new RuntimeException(sb2.toString(), e2);
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0004\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\n"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion;", "", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "()Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "MyBillsEntityDataFactory", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "<init>", "()V", "ViewModelKeyImpl"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
            public static NewInstanceFactory BuiltInFictitiousFunctionClassFactory() {
                if (NewInstanceFactory.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    NewInstanceFactory.KClassImpl$Data$declaredNonStaticMembers$2 = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNull(newInstanceFactory);
                return newInstanceFactory;
            }

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion$ViewModelKeyImpl;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes.dex */
            static final class ViewModelKeyImpl implements CreationExtras.Key<String> {
                public static final ViewModelKeyImpl INSTANCE = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0016¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0012B\u001b\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0013¢\u0006\u0004\b\u0010\u0010\u0014J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroid/app/Application;", "p1", "getAuthRequestContext", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "MyBillsEntityDataFactory", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Landroid/app/Application;", "<init>", "()V", "(Landroid/app/Application;)V", "", "(Landroid/app/Application;B)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final CreationExtras.Key<Application> KClassImpl$Data$declaredNonStaticMembers$2 = Companion.ApplicationKeyImpl.INSTANCE;
        private static AndroidViewModelFactory PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final Application BuiltInFictitiousFunctionClassFactory;

        private AndroidViewModelFactory(Application application, byte b) {
            this.BuiltInFictitiousFunctionClassFactory = application;
        }

        public AndroidViewModelFactory() {
            this(null, (byte) 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application) {
            this(application, (byte) 0);
            Intrinsics.checkNotNullParameter(application, "");
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T MyBillsEntityDataFactory(Class<T> p0, CreationExtras p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            if (this.BuiltInFictitiousFunctionClassFactory != null) {
                return (T) BuiltInFictitiousFunctionClassFactory(p0);
            }
            Application application = (Application) p1.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
            if (application != null) {
                return (T) getAuthRequestContext(p0, application);
            }
            if (AndroidViewModel.class.isAssignableFrom(p0)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.BuiltInFictitiousFunctionClassFactory(p0);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T BuiltInFictitiousFunctionClassFactory(Class<T> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Application application = this.BuiltInFictitiousFunctionClassFactory;
            if (application == null) {
                throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
            }
            return (T) getAuthRequestContext(p0, application);
        }

        private final <T extends ViewModel> T getAuthRequestContext(Class<T> p0, Application p1) {
            if (AndroidViewModel.class.isAssignableFrom(p0)) {
                try {
                    T newInstance = p0.getConstructor(Application.class).newInstance(p1);
                    Intrinsics.checkNotNullExpressionValue(newInstance, "");
                    return newInstance;
                } catch (IllegalAccessException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot create an instance of ");
                    sb.append(p0);
                    throw new RuntimeException(sb.toString(), e);
                } catch (InstantiationException e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cannot create an instance of ");
                    sb2.append(p0);
                    throw new RuntimeException(sb2.toString(), e2);
                } catch (NoSuchMethodException e3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Cannot create an instance of ");
                    sb3.append(p0);
                    throw new RuntimeException(sb3.toString(), e3);
                } catch (InvocationTargetException e4) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Cannot create an instance of ");
                    sb4.append(p0);
                    throw new RuntimeException(sb4.toString(), e4);
                }
            }
            return (T) super.BuiltInFictitiousFunctionClassFactory(p0);
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion;", "", "Landroid/app/Application;", "p0", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "getAuthRequestContext", "(Landroid/app/Application;)Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "MyBillsEntityDataFactory", "PlaceComponentResult", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "<init>", "()V", "ApplicationKeyImpl"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public static AndroidViewModelFactory getAuthRequestContext(Application p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (AndroidViewModelFactory.PlaceComponentResult == null) {
                    AndroidViewModelFactory.PlaceComponentResult = new AndroidViewModelFactory(p0);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.PlaceComponentResult;
                Intrinsics.checkNotNull(androidViewModelFactory);
                return androidViewModelFactory;
            }

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion$ApplicationKeyImpl;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroid/app/Application;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes.dex */
            static final class ApplicationKeyImpl implements CreationExtras.Key<Application> {
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }
        }
    }
}
