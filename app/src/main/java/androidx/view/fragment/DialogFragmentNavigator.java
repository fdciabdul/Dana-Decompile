package androidx.view.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.view.FloatingWindow;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleOwner;
import androidx.view.NavBackStackEntry;
import androidx.view.NavDestination;
import androidx.view.NavOptions;
import androidx.view.Navigator;
import androidx.view.NavigatorState;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Navigator.Name("dialog")
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0013\u0012\u0006\u0010\u0007\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0014\u0010\u0011\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001d"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "", "Landroidx/navigation/NavBackStackEntry;", "p0", "Landroidx/navigation/NavOptions;", "p1", "Landroidx/navigation/Navigator$Extras;", "p2", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavigatorState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavigatorState;)V", "", "getAuthRequestContext", "(Landroidx/navigation/NavBackStackEntry;Z)V", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "Landroidx/lifecycle/LifecycleEventObserver;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/LifecycleEventObserver;", "", "", "Ljava/util/Set;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "Companion", "Destination"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DialogFragmentNavigator extends Navigator<Destination> {
    private static final Companion Companion = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final LifecycleEventObserver getAuthRequestContext;
    private final FragmentManager MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Set<String> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        this.PlaceComponentResult = context;
        this.MyBillsEntityDataFactory = fragmentManager;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashSet();
        this.getAuthRequestContext = new LifecycleEventObserver() { // from class: androidx.navigation.fragment.DialogFragmentNavigator$$ExternalSyntheticLambda1
            @Override // androidx.view.LifecycleEventObserver
            public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                DialogFragmentNavigator.MyBillsEntityDataFactory(DialogFragmentNavigator.this, lifecycleOwner, event);
            }
        };
    }

    @Override // androidx.view.Navigator
    public final void getAuthRequestContext(NavBackStackEntry p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.MyBillsEntityDataFactory.isStateSaved()) {
            InstrumentInjector.log_i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
        if (navigatorState != null) {
            List<NavBackStackEntry> value = navigatorState.MyBillsEntityDataFactory.getValue();
            Iterator it = CollectionsKt.reversed(value.subList(value.indexOf(p0), value.size())).iterator();
            while (it.hasNext()) {
                Fragment findFragmentByTag = this.MyBillsEntityDataFactory.findFragmentByTag(((NavBackStackEntry) it.next()).getErrorConfigVersion);
                if (findFragmentByTag != null) {
                    findFragmentByTag.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
                    ((DialogFragment) findFragmentByTag).dismiss();
                }
            }
            NavigatorState navigatorState2 = this.BuiltInFictitiousFunctionClassFactory;
            if (navigatorState2 != null) {
                navigatorState2.PlaceComponentResult(p0, p1);
                return;
            }
            throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    @Override // androidx.view.Navigator
    public final void MyBillsEntityDataFactory(List<NavBackStackEntry> p0, NavOptions p1, Navigator.Extras p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.MyBillsEntityDataFactory.isStateSaved()) {
            InstrumentInjector.log_i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        for (NavBackStackEntry navBackStackEntry : p0) {
            Destination destination = (Destination) navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2;
            String BuiltInFictitiousFunctionClassFactory = destination.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory.charAt(0) == '.') {
                StringBuilder sb = new StringBuilder();
                sb.append(this.PlaceComponentResult.getPackageName());
                sb.append(BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory = sb.toString();
            }
            Fragment authRequestContext = this.MyBillsEntityDataFactory.getFragmentFactory().getAuthRequestContext(this.PlaceComponentResult.getClassLoader(), BuiltInFictitiousFunctionClassFactory);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            if (!DialogFragment.class.isAssignableFrom(authRequestContext.getClass())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Dialog destination ");
                sb2.append(destination.BuiltInFictitiousFunctionClassFactory());
                sb2.append(" is not an instance of DialogFragment");
                throw new IllegalArgumentException(sb2.toString().toString());
            }
            DialogFragment dialogFragment = (DialogFragment) authRequestContext;
            dialogFragment.setArguments(navBackStackEntry.getAuthRequestContext);
            dialogFragment.getLifecycle().BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            dialogFragment.show(this.MyBillsEntityDataFactory, navBackStackEntry.getErrorConfigVersion);
            NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
            if (navigatorState != null) {
                navigatorState.getAuthRequestContext(navBackStackEntry);
            } else {
                throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
            }
        }
    }

    @Override // androidx.view.Navigator
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NavigatorState p0) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(p0, "");
        super.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        for (NavBackStackEntry navBackStackEntry : p0.MyBillsEntityDataFactory.getValue()) {
            DialogFragment dialogFragment = (DialogFragment) this.MyBillsEntityDataFactory.findFragmentByTag(navBackStackEntry.getErrorConfigVersion);
            if (dialogFragment == null || (lifecycle = dialogFragment.getLifecycle()) == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(navBackStackEntry.getErrorConfigVersion);
            } else {
                lifecycle.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            }
        }
        this.MyBillsEntityDataFactory.addFragmentOnAttachListener(new FragmentOnAttachListener() { // from class: androidx.navigation.fragment.DialogFragmentNavigator$$ExternalSyntheticLambda0
            @Override // androidx.fragment.app.FragmentOnAttachListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FragmentManager fragmentManager, Fragment fragment) {
                DialogFragmentNavigator.PlaceComponentResult(DialogFragmentNavigator.this, fragmentManager, fragment);
            }
        });
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0012\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0015"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "Landroidx/navigation/FloatingWindow;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "()Ljava/lang/String;", "Landroidx/navigation/Navigator;", "<init>", "(Landroidx/navigation/Navigator;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class Destination extends NavDestination implements FloatingWindow {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private String PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> navigator) {
            super(navigator);
            Intrinsics.checkNotNullParameter(navigator, "");
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public final String BuiltInFictitiousFunctionClassFactory() {
            String str = this.PlaceComponentResult;
            if (str != null) {
                if (str != null) {
                    return str;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new IllegalStateException("DialogFragment class was not set".toString());
        }

        @Override // androidx.view.NavDestination
        public final void BuiltInFictitiousFunctionClassFactory(Context p0, AttributeSet p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            super.BuiltInFictitiousFunctionClassFactory(p0, p1);
            TypedArray obtainAttributes = p0.getResources().obtainAttributes(p1, R.styleable.PlaceComponentResult);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "");
            String string = obtainAttributes.getString(R.styleable.BuiltInFictitiousFunctionClassFactory);
            if (string != null) {
                Intrinsics.checkNotNullParameter(string, "");
                this.PlaceComponentResult = string;
            }
            obtainAttributes.recycle();
        }

        @Override // androidx.view.NavDestination
        public boolean equals(Object p0) {
            return p0 != null && (p0 instanceof Destination) && super.equals(p0) && Intrinsics.areEqual(this.PlaceComponentResult, ((Destination) p0).PlaceComponentResult);
        }

        @Override // androidx.view.NavDestination
        public int hashCode() {
            int hashCode = super.hashCode();
            String str = this.PlaceComponentResult;
            return (hashCode * 31) + (str != null ? str.hashCode() : 0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigator$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void PlaceComponentResult(DialogFragmentNavigator dialogFragmentNavigator, FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(dialogFragmentNavigator, "");
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(fragment, "");
        Set<String> set = dialogFragmentNavigator.KClassImpl$Data$declaredNonStaticMembers$2;
        if (TypeIntrinsics.asMutableCollection(set).remove(fragment.getTag())) {
            fragment.getLifecycle().BuiltInFictitiousFunctionClassFactory(dialogFragmentNavigator.getAuthRequestContext);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(DialogFragmentNavigator dialogFragmentNavigator, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(dialogFragmentNavigator, "");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "");
        Intrinsics.checkNotNullParameter(event, "");
        boolean z = false;
        if (event == Lifecycle.Event.ON_CREATE) {
            DialogFragment dialogFragment = (DialogFragment) lifecycleOwner;
            NavigatorState navigatorState = dialogFragmentNavigator.BuiltInFictitiousFunctionClassFactory;
            if (navigatorState != null) {
                List<NavBackStackEntry> value = navigatorState.MyBillsEntityDataFactory.getValue();
                if (!(value instanceof Collection) || !value.isEmpty()) {
                    Iterator<T> it = value.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual(((NavBackStackEntry) it.next()).getErrorConfigVersion, dialogFragment.getTag())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    return;
                }
                dialogFragment.dismiss();
                return;
            }
            throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
        } else if (event == Lifecycle.Event.ON_STOP) {
            DialogFragment dialogFragment2 = (DialogFragment) lifecycleOwner;
            if (dialogFragment2.requireDialog().isShowing()) {
                return;
            }
            NavigatorState navigatorState2 = dialogFragmentNavigator.BuiltInFictitiousFunctionClassFactory;
            if (navigatorState2 != null) {
                List<NavBackStackEntry> value2 = navigatorState2.MyBillsEntityDataFactory.getValue();
                ListIterator<NavBackStackEntry> listIterator = value2.listIterator(value2.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        navBackStackEntry = null;
                        break;
                    }
                    navBackStackEntry = listIterator.previous();
                    if (Intrinsics.areEqual(navBackStackEntry.getErrorConfigVersion, dialogFragment2.getTag())) {
                        break;
                    }
                }
                if (navBackStackEntry != null) {
                    NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
                    if (!Intrinsics.areEqual(CollectionsKt.lastOrNull((List) value2), navBackStackEntry2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Dialog ");
                        sb.append(dialogFragment2);
                        sb.append(" was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
                        InstrumentInjector.log_i("DialogFragmentNavigator", sb.toString());
                    }
                    dialogFragmentNavigator.getAuthRequestContext(navBackStackEntry2, false);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Dialog ");
                sb2.append(dialogFragment2);
                sb2.append(" has already been popped off of the Navigation back stack");
                throw new IllegalStateException(sb2.toString().toString());
            }
            throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
        }
    }

    @Override // androidx.view.Navigator
    public final /* synthetic */ Destination KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Destination(this);
    }
}
