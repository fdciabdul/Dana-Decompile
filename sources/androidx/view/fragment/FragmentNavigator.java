package androidx.view.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransition;
import androidx.view.NavBackStackEntry;
import androidx.view.NavDestination;
import androidx.view.NavOptions;
import androidx.view.Navigator;
import androidx.view.NavigatorState;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Navigator.Name("fragment")
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0017\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003$%&B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u001a\u0012\u0006\u0010\u0006\u001a\u00020\u001c\u0012\u0006\u0010\f\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000e\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\b\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\b\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0010\u0010\u0017R\u0014\u0010\u000e\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0014\u0010\u0010\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\b\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010!"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroidx/navigation/NavBackStackEntry;", "p0", "Landroidx/navigation/NavOptions;", "p1", "Landroidx/fragment/app/FragmentTransaction;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/NavOptions;)Landroidx/fragment/app/FragmentTransaction;", "", "Landroidx/navigation/Navigator$Extras;", "p2", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "getAuthRequestContext", "(Landroidx/navigation/NavBackStackEntry;)V", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "BuiltInFictitiousFunctionClassFactory", "()Landroid/os/Bundle;", "", "(Landroidx/navigation/NavBackStackEntry;Z)V", "", "I", "Landroid/content/Context;", "Landroid/content/Context;", "Landroidx/fragment/app/FragmentManager;", "PlaceComponentResult", "Landroidx/fragment/app/FragmentManager;", "", "", "Ljava/util/Set;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "Companion", "Destination", "Extras"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class FragmentNavigator extends Navigator<Destination> {
    private static final Companion Companion = new Companion(null);
    private final Set<String> BuiltInFictitiousFunctionClassFactory;
    private final int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FragmentManager KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tR0\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras;", "Landroidx/navigation/Navigator$Extras;", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "", "Lkotlin/collections/LinkedHashMap;", "MyBillsEntityDataFactory", "Ljava/util/LinkedHashMap;", "getAuthRequestContext", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Extras implements Navigator.Extras {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final LinkedHashMap<View, String> getAuthRequestContext;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR0\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Extras$Builder;", "", "Ljava/util/LinkedHashMap;", "Landroid/view/View;", "", "Lkotlin/collections/LinkedHashMap;", "getAuthRequestContext", "Ljava/util/LinkedHashMap;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Builder {

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            private final LinkedHashMap<View, String> BuiltInFictitiousFunctionClassFactory = new LinkedHashMap<>();
        }
    }

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int i) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        this.getAuthRequestContext = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentManager;
        this.MyBillsEntityDataFactory = i;
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashSet();
    }

    @Override // androidx.view.Navigator
    public final void getAuthRequestContext(NavBackStackEntry p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isStateSaved()) {
            InstrumentInjector.log_i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        if (!p1) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.popBackStack(p0.getErrorConfigVersion, 1);
        } else {
            NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
            if (navigatorState != null) {
                List<NavBackStackEntry> value = navigatorState.MyBillsEntityDataFactory.getValue();
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) CollectionsKt.first((List) value);
                for (NavBackStackEntry navBackStackEntry2 : CollectionsKt.reversed(value.subList(value.indexOf(p0), value.size()))) {
                    if (Intrinsics.areEqual(navBackStackEntry2, navBackStackEntry)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("FragmentManager cannot save the state of the initial destination ");
                        sb.append(navBackStackEntry2);
                        InstrumentInjector.log_i("FragmentNavigator", sb.toString());
                    } else {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.saveBackStack(navBackStackEntry2.getErrorConfigVersion);
                        this.BuiltInFictitiousFunctionClassFactory.add(navBackStackEntry2.getErrorConfigVersion);
                    }
                }
            } else {
                throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
            }
        }
        NavigatorState navigatorState2 = this.BuiltInFictitiousFunctionClassFactory;
        if (navigatorState2 != null) {
            navigatorState2.PlaceComponentResult(p0, p1);
            return;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    @Override // androidx.view.Navigator
    public final void MyBillsEntityDataFactory(List<NavBackStackEntry> p0, NavOptions p1, Navigator.Extras p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isStateSaved()) {
            InstrumentInjector.log_i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        for (NavBackStackEntry navBackStackEntry : p0) {
            NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
            if (navigatorState != null) {
                boolean isEmpty = navigatorState.MyBillsEntityDataFactory.getValue().isEmpty();
                if (p1 != null && !isEmpty && p1.getLookAheadTest() && this.BuiltInFictitiousFunctionClassFactory.remove(navBackStackEntry.getErrorConfigVersion)) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.restoreBackStack(navBackStackEntry.getErrorConfigVersion);
                    NavigatorState navigatorState2 = this.BuiltInFictitiousFunctionClassFactory;
                    if (navigatorState2 != null) {
                        navigatorState2.getAuthRequestContext(navBackStackEntry);
                    } else {
                        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
                    }
                } else {
                    FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(navBackStackEntry, p1);
                    if (!isEmpty) {
                        String str = navBackStackEntry.getErrorConfigVersion;
                        if (!KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                        }
                        KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = true;
                        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8 = str;
                    }
                    if (p2 instanceof Extras) {
                        for (Map.Entry entry : MapsKt.toMap(((Extras) p2).getAuthRequestContext).entrySet()) {
                            View view = (View) entry.getKey();
                            String str2 = (String) entry.getValue();
                            if (FragmentTransition.MyBillsEntityDataFactory()) {
                                String callingPid = ViewCompat.getCallingPid(view);
                                if (callingPid == null) {
                                    throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
                                }
                                if (KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                                    KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4 = new ArrayList<>();
                                    KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ArrayList<>();
                                } else if (KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5.contains(str2)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("A shared element with the target name '");
                                    sb.append(str2);
                                    sb.append("' has already been added to the transaction.");
                                    throw new IllegalArgumentException(sb.toString());
                                } else if (KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4.contains(callingPid)) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("A shared element with the source name '");
                                    sb2.append(callingPid);
                                    sb2.append("' has already been added to the transaction.");
                                    throw new IllegalArgumentException(sb2.toString());
                                }
                                KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4.add(callingPid);
                                KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda5.add(str2);
                            }
                        }
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                    NavigatorState navigatorState3 = this.BuiltInFictitiousFunctionClassFactory;
                    if (navigatorState3 != null) {
                        navigatorState3.getAuthRequestContext(navBackStackEntry);
                    } else {
                        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
                    }
                }
            } else {
                throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
            }
        }
    }

    @Override // androidx.view.Navigator
    public final void getAuthRequestContext(NavBackStackEntry p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isStateSaved()) {
            InstrumentInjector.log_i("FragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0, null);
        NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
        if (navigatorState != null) {
            if (navigatorState.MyBillsEntityDataFactory.getValue().size() > 1) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.popBackStack(p0.getErrorConfigVersion, 1);
                String str = p0.getErrorConfigVersion;
                if (!KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
                KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = true;
                KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8 = str;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            NavigatorState navigatorState2 = this.BuiltInFictitiousFunctionClassFactory;
            if (navigatorState2 != null) {
                navigatorState2.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                return;
            }
            throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    @Override // androidx.view.Navigator
    public final Bundle BuiltInFictitiousFunctionClassFactory() {
        if (this.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            return null;
        }
        return BundleKt.PlaceComponentResult(TuplesKt.to("androidx-nav-fragment:navigator:savedIds", new ArrayList(this.BuiltInFictitiousFunctionClassFactory)));
    }

    @Override // androidx.view.Navigator
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList<String> stringArrayList = p0.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            this.BuiltInFictitiousFunctionClassFactory.clear();
            CollectionsKt.addAll(this.BuiltInFictitiousFunctionClassFactory, stringArrayList);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Destination;", "Landroidx/navigation/NavDestination;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Landroidx/navigation/Navigator;", "<init>", "(Landroidx/navigation/Navigator;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class Destination extends NavDestination {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        String MyBillsEntityDataFactory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(Navigator<? extends Destination> navigator) {
            super(navigator);
            Intrinsics.checkNotNullParameter(navigator, "");
        }

        @Override // androidx.view.NavDestination
        public final void BuiltInFictitiousFunctionClassFactory(Context p0, AttributeSet p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            super.BuiltInFictitiousFunctionClassFactory(p0, p1);
            TypedArray obtainAttributes = p0.getResources().obtainAttributes(p1, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "");
            String string = obtainAttributes.getString(R.styleable.MyBillsEntityDataFactory);
            if (string != null) {
                Intrinsics.checkNotNullParameter(string, "");
                this.MyBillsEntityDataFactory = string;
            }
            Unit unit = Unit.INSTANCE;
            obtainAttributes.recycle();
        }

        @Override // androidx.view.NavDestination
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.MyBillsEntityDataFactory;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            String obj = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return obj;
        }

        @Override // androidx.view.NavDestination
        public boolean equals(Object p0) {
            return p0 != null && (p0 instanceof Destination) && super.equals(p0) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((Destination) p0).MyBillsEntityDataFactory);
        }

        @Override // androidx.view.NavDestination
        public int hashCode() {
            int hashCode = super.hashCode();
            String str = this.MyBillsEntityDataFactory;
            return (hashCode * 31) + (str != null ? str.hashCode() : 0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/fragment/FragmentNavigator$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2(NavBackStackEntry p0, NavOptions p1) {
        Destination destination = (Destination) p0.KClassImpl$Data$declaredNonStaticMembers$2;
        Bundle bundle = p0.getAuthRequestContext;
        String str = destination.MyBillsEntityDataFactory;
        if (str != null) {
            if (str != null) {
                if (str.charAt(0) == '.') {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.getAuthRequestContext.getPackageName());
                    sb.append(str);
                    str = sb.toString();
                }
                Fragment authRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2.getFragmentFactory().getAuthRequestContext(this.getAuthRequestContext.getClassLoader(), str);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                authRequestContext.setArguments(bundle);
                FragmentTransaction beginTransaction = this.KClassImpl$Data$declaredNonStaticMembers$2.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
                int i = p1 != null ? p1.KClassImpl$Data$declaredNonStaticMembers$2 : -1;
                int i2 = p1 != null ? p1.getAuthRequestContext : -1;
                int i3 = p1 != null ? p1.MyBillsEntityDataFactory : -1;
                int i4 = p1 != null ? p1.PlaceComponentResult : -1;
                if (i != -1 || i2 != -1 || i3 != -1 || i4 != -1) {
                    if (i == -1) {
                        i = 0;
                    }
                    if (i2 == -1) {
                        i2 = 0;
                    }
                    if (i3 == -1) {
                        i3 = 0;
                    }
                    int i5 = i4 != -1 ? i4 : 0;
                    beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = i;
                    beginTransaction.GetContactSyncConfig = i2;
                    beginTransaction.newProxyInstance = i3;
                    beginTransaction.PrepareContext = i5;
                }
                int i6 = this.MyBillsEntityDataFactory;
                if (i6 == 0) {
                    throw new IllegalArgumentException("Must use non-zero containerViewId");
                }
                beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(i6, authRequestContext, null, 2);
                beginTransaction.MyBillsEntityDataFactory(authRequestContext);
                beginTransaction.isLayoutRequested = true;
                return beginTransaction;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        throw new IllegalStateException("Fragment class was not set".toString());
    }

    @Override // androidx.view.Navigator
    public final /* synthetic */ Destination KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Destination(this);
    }
}
