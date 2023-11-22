package id.dana.base.viewbinding;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import id.dana.base.viewbinding.FragmentViewBindingDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003B#\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/base/viewbinding/FragmentViewBindingDelegate;", "Landroidx/viewbinding/ViewBinding;", "T", "Lkotlin/properties/ReadOnlyProperty;", "Landroidx/fragment/app/Fragment;", "p0", "Lkotlin/reflect/KProperty;", "p1", "getAuthRequestContext", "(Landroidx/fragment/app/Fragment;Lkotlin/reflect/KProperty;)Landroidx/viewbinding/ViewBinding;", "Landroidx/viewbinding/ViewBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Landroidx/fragment/app/Fragment;", "PlaceComponentResult", "Lkotlin/Function1;", "Landroid/view/View;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "<init>", "(Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FragmentViewBindingDelegate<T extends ViewBinding> implements ReadOnlyProperty<Fragment, T> {
    private final Function1<View, T> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Fragment PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private T KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewBindingDelegate(Fragment fragment, Function1<? super View, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(fragment, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = fragment;
        this.BuiltInFictitiousFunctionClassFactory = function1;
        fragment.getLifecycle().BuiltInFictitiousFunctionClassFactory(new AnonymousClass1(this));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/base/viewbinding/FragmentViewBindingDelegate$1;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "p0", "", "onCreate", "(Landroidx/lifecycle/LifecycleOwner;)V", "onDestroy", "Landroidx/lifecycle/Observer;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/lifecycle/Observer;", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.base.viewbinding.FragmentViewBindingDelegate$1 */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 implements DefaultLifecycleObserver {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final Observer<LifecycleOwner> MyBillsEntityDataFactory;
        final /* synthetic */ FragmentViewBindingDelegate<T> MyBillsEntityDataFactory;

        @Override // androidx.view.FullLifecycleObserver
        public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.CC.MyBillsEntityDataFactory();
        }

        @Override // androidx.view.FullLifecycleObserver
        public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.CC.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // androidx.view.FullLifecycleObserver
        public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.CC.PlaceComponentResult();
        }

        @Override // androidx.view.FullLifecycleObserver
        public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver.CC.scheduleImpl();
        }

        AnonymousClass1(final FragmentViewBindingDelegate<T> fragmentViewBindingDelegate) {
            this.MyBillsEntityDataFactory = fragmentViewBindingDelegate;
            this.MyBillsEntityDataFactory = new Observer() { // from class: id.dana.base.viewbinding.FragmentViewBindingDelegate$1$$ExternalSyntheticLambda0
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    FragmentViewBindingDelegate.AnonymousClass1.getAuthRequestContext(FragmentViewBindingDelegate.this, (LifecycleOwner) obj);
                }
            };
        }

        @Override // androidx.view.FullLifecycleObserver
        public final void onCreate(LifecycleOwner p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ((FragmentViewBindingDelegate) this.MyBillsEntityDataFactory).PlaceComponentResult.getViewLifecycleOwnerLiveData().getAuthRequestContext(this.MyBillsEntityDataFactory);
        }

        @Override // androidx.view.FullLifecycleObserver
        public final void onDestroy(LifecycleOwner p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ((FragmentViewBindingDelegate) this.MyBillsEntityDataFactory).PlaceComponentResult.getViewLifecycleOwnerLiveData().BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
        }

        public static /* synthetic */ void getAuthRequestContext(final FragmentViewBindingDelegate fragmentViewBindingDelegate, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(fragmentViewBindingDelegate, "");
            if (lifecycleOwner != null) {
                lifecycleOwner.getLifecycle().BuiltInFictitiousFunctionClassFactory(new DefaultLifecycleObserver() { // from class: id.dana.base.viewbinding.FragmentViewBindingDelegate$1$observer$1$1
                    @Override // androidx.view.FullLifecycleObserver
                    public final /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner2) {
                        DefaultLifecycleObserver.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                    }

                    @Override // androidx.view.FullLifecycleObserver
                    public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner2) {
                        DefaultLifecycleObserver.CC.MyBillsEntityDataFactory();
                    }

                    @Override // androidx.view.FullLifecycleObserver
                    public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner2) {
                        DefaultLifecycleObserver.CC.BuiltInFictitiousFunctionClassFactory();
                    }

                    @Override // androidx.view.FullLifecycleObserver
                    public final /* synthetic */ void onStart(LifecycleOwner lifecycleOwner2) {
                        DefaultLifecycleObserver.CC.PlaceComponentResult();
                    }

                    @Override // androidx.view.FullLifecycleObserver
                    public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner2) {
                        DefaultLifecycleObserver.CC.scheduleImpl();
                    }

                    @Override // androidx.view.FullLifecycleObserver
                    public final void onDestroy(LifecycleOwner p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        ((FragmentViewBindingDelegate) fragmentViewBindingDelegate).KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    }
                });
            }
        }
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* renamed from: getAuthRequestContext */
    public final T getValue(Fragment p0, KProperty<?> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        T t = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (t != null) {
            return t;
        }
        try {
            LifecycleOwner viewLifecycleOwner = p0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
            if (viewLifecycleOwner.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.INITIALIZED)) {
                Function1<View, T> function1 = this.BuiltInFictitiousFunctionClassFactory;
                View requireView = p0.requireView();
                Intrinsics.checkNotNullExpressionValue(requireView, "");
                T invoke = function1.invoke(requireView);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = invoke;
                return invoke;
            }
            return t;
        } catch (IllegalStateException unused) {
            return t;
        }
    }
}
