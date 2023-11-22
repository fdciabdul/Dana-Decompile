package androidx.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.view.C0212R;
import androidx.view.NavBackStackEntry;
import androidx.view.NavBackStackEntryState;
import androidx.view.NavController;
import androidx.view.NavHost;
import androidx.view.NavHostController;
import androidx.view.Navigation;
import androidx.view.Navigator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\nJ!\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010!R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavHost;", "Landroid/content/Context;", "p0", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroyView", "()V", "Landroid/util/AttributeSet;", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroid/os/Bundle;)V", "", "onPrimaryNavigationFragmentChanged", "(Z)V", "onSaveInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "", "I", "MyBillsEntityDataFactory", "Ljava/lang/Boolean;", "Landroidx/navigation/NavHostController;", "getErrorConfigVersion", "Landroidx/navigation/NavHostController;", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "Landroid/view/View;", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavHostFragment extends Fragment implements NavHost {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private NavHostController BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private View getAuthRequestContext;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        if (this.PlaceComponentResult) {
            getParentFragmentManager().beginTransaction().MyBillsEntityDataFactory(this).getAuthRequestContext();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01db  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r17) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.fragment.NavHostFragment.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrimaryNavigationFragmentChanged(boolean p0) {
        NavHostController navHostController = this.BuiltInFictitiousFunctionClassFactory;
        if (navHostController == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Boolean.valueOf(p0);
        } else if (navHostController != null) {
            navHostController.BuiltInFictitiousFunctionClassFactory(p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Context context = p0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        int id2 = getId();
        if (id2 == 0 || id2 == -1) {
            id2 = R.id.nav_host_fragment_container;
        }
        fragmentContainerView.setId(id2);
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        if (!(p0 instanceof ViewGroup)) {
            StringBuilder sb = new StringBuilder();
            sb.append("created host view ");
            sb.append(p0);
            sb.append(" is not a ViewGroup");
            throw new IllegalStateException(sb.toString().toString());
        }
        Navigation.KClassImpl$Data$declaredNonStaticMembers$2(p0, this.BuiltInFictitiousFunctionClassFactory);
        if (p0.getParent() != null) {
            ViewParent parent = p0.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
            }
            View view = (View) parent;
            this.getAuthRequestContext = view;
            Intrinsics.checkNotNull(view);
            if (view.getId() == getId()) {
                View view2 = this.getAuthRequestContext;
                Intrinsics.checkNotNull(view2);
                Navigation.KClassImpl$Data$declaredNonStaticMembers$2(view2, this.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context p0, AttributeSet p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        super.onInflate(p0, p1, p2);
        TypedArray obtainStyledAttributes = p0.obtainStyledAttributes(p1, C0212R.styleable.lookAheadTest);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        int resourceId = obtainStyledAttributes.getResourceId(C0212R.styleable.scheduleImpl, 0);
        if (resourceId != 0) {
            this.MyBillsEntityDataFactory = resourceId;
        }
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = p0.obtainStyledAttributes(p1, R.styleable.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes2, "");
        if (obtainStyledAttributes2.getBoolean(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda0, false)) {
            this.PlaceComponentResult = true;
        }
        Unit unit2 = Unit.INSTANCE;
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle p0) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onSaveInstanceState(p0);
        NavHostController navHostController = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNull(navHostController);
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : MapsKt.toMap(navHostController.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory).entrySet()) {
            String str = (String) entry.getKey();
            Bundle BuiltInFictitiousFunctionClassFactory = ((Navigator) entry.getValue()).BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory != null) {
                arrayList.add(str);
                bundle2.putBundle(str, BuiltInFictitiousFunctionClassFactory);
            }
        }
        if ((!arrayList.isEmpty()) == true) {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        } else {
            bundle = null;
        }
        if ((!navHostController.PlaceComponentResult.isEmpty()) != false) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[navHostController.PlaceComponentResult.size()];
            Iterator<NavBackStackEntry> it = navHostController.PlaceComponentResult.iterator();
            int i = 0;
            while (it.hasNext()) {
                parcelableArr[i] = new NavBackStackEntryState(it.next());
                i++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if ((!navHostController.MyBillsEntityDataFactory.isEmpty()) != false) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            int[] iArr = new int[navHostController.MyBillsEntityDataFactory.size()];
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i2 = 0;
            for (Map.Entry<Integer, String> entry2 : navHostController.MyBillsEntityDataFactory.entrySet()) {
                int intValue = entry2.getKey().intValue();
                String value = entry2.getValue();
                iArr[i2] = intValue;
                arrayList2.add(value);
                i2++;
            }
            bundle.putIntArray("android-support-nav:controller:backStackDestIds", iArr);
            bundle.putStringArrayList("android-support-nav:controller:backStackIds", arrayList2);
        }
        if ((!navHostController.getAuthRequestContext.isEmpty()) != false) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (Map.Entry<String, ArrayDeque<NavBackStackEntryState>> entry3 : navHostController.getAuthRequestContext.entrySet()) {
                String key = entry3.getKey();
                ArrayDeque<NavBackStackEntryState> value2 = entry3.getValue();
                arrayList3.add(key);
                Parcelable[] parcelableArr2 = new Parcelable[value2.size()];
                int i3 = 0;
                for (NavBackStackEntryState navBackStackEntryState : value2) {
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    parcelableArr2[i3] = navBackStackEntryState;
                    i3++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("android-support-nav:controller:backStackStates:");
                sb.append(key);
                bundle.putParcelableArray(sb.toString(), parcelableArr2);
            }
            bundle.putStringArrayList("android-support-nav:controller:backStackStates", arrayList3);
        }
        if (navHostController.lookAheadTest) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", navHostController.lookAheadTest);
        }
        if (bundle != null) {
            p0.putBundle("android-support-nav:fragment:navControllerState", bundle);
        }
        if (this.PlaceComponentResult) {
            p0.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        int i4 = this.MyBillsEntityDataFactory;
        if (i4 != 0) {
            p0.putInt("android-support-nav:fragment:graphId", i4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.getAuthRequestContext;
        if (view != null && Navigation.MyBillsEntityDataFactory(view) == this.BuiltInFictitiousFunctionClassFactory) {
            Navigation.KClassImpl$Data$declaredNonStaticMembers$2(view, null);
        }
        this.getAuthRequestContext = null;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/navigation/fragment/NavHostFragment$Companion;", "", "Landroidx/fragment/app/Fragment;", "p0", "Landroidx/navigation/NavController;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/fragment/app/Fragment;)Landroidx/navigation/NavController;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static NavController KClassImpl$Data$declaredNonStaticMembers$2(Fragment p0) {
            Dialog dialog;
            Window window;
            Intrinsics.checkNotNullParameter(p0, "");
            for (Fragment fragment = p0; fragment != null; fragment = fragment.getParentFragment()) {
                if (fragment instanceof NavHostFragment) {
                    NavHostController navHostController = ((NavHostFragment) fragment).BuiltInFictitiousFunctionClassFactory;
                    if (navHostController != null) {
                        return navHostController;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
                Fragment primaryNavigationFragment = fragment.getParentFragmentManager().getPrimaryNavigationFragment();
                if (primaryNavigationFragment instanceof NavHostFragment) {
                    NavHostController navHostController2 = ((NavHostFragment) primaryNavigationFragment).BuiltInFictitiousFunctionClassFactory;
                    if (navHostController2 != null) {
                        return navHostController2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
                }
            }
            View getAuthRequestContext = p0.getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                return Navigation.MyBillsEntityDataFactory(getAuthRequestContext);
            }
            View view = null;
            DialogFragment dialogFragment = p0 instanceof DialogFragment ? (DialogFragment) p0 : null;
            if (dialogFragment != null && (dialog = dialogFragment.getDialog()) != null && (window = dialog.getWindow()) != null) {
                view = window.getDecorView();
            }
            if (view != null) {
                return Navigation.MyBillsEntityDataFactory(view);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(p0);
            sb.append(" does not have a NavController set");
            throw new IllegalStateException(sb.toString());
        }

        public static /* synthetic */ NavHostFragment PlaceComponentResult(int i) {
            Bundle bundle;
            if (i != 0) {
                bundle = new Bundle();
                bundle.putInt("android-support-nav:fragment:graphId", i);
            } else {
                bundle = null;
            }
            NavHostFragment navHostFragment = new NavHostFragment();
            if (bundle != null) {
                navHostFragment.setArguments(bundle);
            }
            return navHostFragment;
        }
    }
}
