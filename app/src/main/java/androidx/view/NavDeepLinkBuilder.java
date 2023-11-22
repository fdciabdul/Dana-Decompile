package androidx.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.TaskStackBuilder;
import androidx.view.NavDestination;
import androidx.view.Navigator;
import androidx.view.NavigatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cB\u000f\u0012\u0006\u0010\t\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0003\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder;", "", "Landroidx/core/app/TaskStackBuilder;", "MyBillsEntityDataFactory", "()Landroidx/core/app/TaskStackBuilder;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "Landroidx/navigation/NavDestination;", "(I)Landroidx/navigation/NavDestination;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Landroid/content/Context;", "", "Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "getAuthRequestContext", "Ljava/util/List;", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavGraph;", "PlaceComponentResult", "Landroid/content/Intent;", "Landroid/content/Intent;", "Landroidx/navigation/NavController;", "<init>", "(Landroidx/navigation/NavController;)V", "(Landroid/content/Context;)V", "DeepLinkDestination", "PermissiveNavigatorProvider"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NavDeepLinkBuilder {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    NavGraph PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    Bundle BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Intent KClassImpl$Data$declaredNonStaticMembers$2;
    final List<DeepLinkDestination> getAuthRequestContext;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$DeepLinkDestination;", "", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "I", "PlaceComponentResult", "p0", "p1", "<init>", "(ILandroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DeepLinkDestination {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final Bundle KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final int PlaceComponentResult;

        public DeepLinkDestination(int i, Bundle bundle) {
            this.PlaceComponentResult = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
        }
    }

    private NavDeepLinkBuilder(Context context) {
        Intent launchIntentForPackage;
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        if (context instanceof Activity) {
            launchIntentForPackage = new Intent(context, context.getClass());
        } else {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                launchIntentForPackage = new Intent();
            }
        }
        launchIntentForPackage.addFlags(268468224);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = launchIntentForPackage;
        this.getAuthRequestContext = new ArrayList();
    }

    private final NavDestination MyBillsEntityDataFactory(int p0) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this.PlaceComponentResult;
        Intrinsics.checkNotNull(navGraph);
        arrayDeque.add(navGraph);
        while (!arrayDeque.isEmpty()) {
            NavDestination navDestination = (NavDestination) arrayDeque.removeFirst();
            if (navDestination.getErrorConfigVersion == p0) {
                return navDestination;
            }
            if (navDestination instanceof NavGraph) {
                Iterator<NavDestination> it = ((NavGraph) navDestination).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        return null;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        Iterator<DeepLinkDestination> it = this.getAuthRequestContext.iterator();
        while (it.hasNext()) {
            int i = it.next().PlaceComponentResult;
            if (MyBillsEntityDataFactory(i) == null) {
                NavDestination.Companion companion = NavDestination.getAuthRequestContext;
                String BuiltInFictitiousFunctionClassFactory = NavDestination.Companion.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, i);
                StringBuilder sb = new StringBuilder();
                sb.append("Navigation destination ");
                sb.append(BuiltInFictitiousFunctionClassFactory);
                sb.append(" cannot be found in the navigation graph ");
                sb.append(this.PlaceComponentResult);
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        NavDestination navDestination = null;
        for (DeepLinkDestination deepLinkDestination : this.getAuthRequestContext) {
            int i = deepLinkDestination.PlaceComponentResult;
            Bundle bundle = deepLinkDestination.KClassImpl$Data$declaredNonStaticMembers$2;
            NavDestination MyBillsEntityDataFactory = MyBillsEntityDataFactory(i);
            if (MyBillsEntityDataFactory == null) {
                NavDestination.Companion companion = NavDestination.getAuthRequestContext;
                String BuiltInFictitiousFunctionClassFactory = NavDestination.Companion.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, i);
                StringBuilder sb = new StringBuilder();
                sb.append("Navigation destination ");
                sb.append(BuiltInFictitiousFunctionClassFactory);
                sb.append(" cannot be found in the navigation graph ");
                sb.append(this.PlaceComponentResult);
                throw new IllegalArgumentException(sb.toString());
            }
            for (int i2 : MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(navDestination)) {
                arrayList.add(Integer.valueOf(i2));
                arrayList2.add(bundle);
            }
            navDestination = MyBillsEntityDataFactory;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.putExtra("android-support-nav:controller:deepLinkIds", CollectionsKt.toIntArray(arrayList));
        this.KClassImpl$Data$declaredNonStaticMembers$2.putParcelableArrayListExtra("android-support-nav:controller:deepLinkArgs", arrayList2);
    }

    public final TaskStackBuilder MyBillsEntityDataFactory() {
        if (this.PlaceComponentResult == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link".toString());
        }
        if ((!this.getAuthRequestContext.isEmpty()) == false) {
            throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link".toString());
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
        TaskStackBuilder BuiltInFictitiousFunctionClassFactory = TaskStackBuilder.PlaceComponentResult(this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(new Intent(this.KClassImpl$Data$declaredNonStaticMembers$2));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        int size = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.size();
        for (int i = 0; i < size; i++) {
            Intent intent = BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get(i);
            if (intent != null) {
                intent.putExtra("android-support-nav:controller:deepLinkIntent", this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0007\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0004*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Landroidx/navigation/NavDeepLinkBuilder$PermissiveNavigatorProvider;", "Landroidx/navigation/NavigatorProvider;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "T", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Landroidx/navigation/Navigator;", "getAuthRequestContext", "Landroidx/navigation/Navigator;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    static final class PermissiveNavigatorProvider extends NavigatorProvider {

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final Navigator<NavDestination> PlaceComponentResult = new Navigator<NavDestination>() { // from class: androidx.navigation.NavDeepLinkBuilder$PermissiveNavigatorProvider$mDestNavigator$1
            @Override // androidx.view.Navigator
            public final NavDestination KClassImpl$Data$declaredNonStaticMembers$2() {
                return new NavDestination("permissive");
            }

            @Override // androidx.view.Navigator
            public final NavDestination MyBillsEntityDataFactory(NavDestination p0, Bundle p1, NavOptions p2, Navigator.Extras p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                throw new IllegalStateException("navigate is not supported");
            }

            @Override // androidx.view.Navigator
            public final boolean MyBillsEntityDataFactory() {
                throw new IllegalStateException("popBackStack is not supported");
            }
        };

        public PermissiveNavigatorProvider() {
            NavGraphNavigator navGraphNavigator = new NavGraphNavigator(this);
            Intrinsics.checkNotNullParameter(navGraphNavigator, "");
            getAuthRequestContext(NavigatorProvider.Companion.PlaceComponentResult((Class<? extends Navigator<?>>) navGraphNavigator.getClass()), navGraphNavigator);
        }

        @Override // androidx.view.NavigatorProvider
        public final <T extends Navigator<? extends NavDestination>> T PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                return (T) super.PlaceComponentResult(p0);
            } catch (IllegalStateException unused) {
                return this.PlaceComponentResult;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDeepLinkBuilder(NavController navController) {
        this(navController.getErrorConfigVersion);
        Intrinsics.checkNotNullParameter(navController, "");
        this.PlaceComponentResult = navController.getAuthRequestContext();
    }

    public static /* synthetic */ NavDeepLinkBuilder BuiltInFictitiousFunctionClassFactory(NavDeepLinkBuilder navDeepLinkBuilder, int i) {
        navDeepLinkBuilder.getAuthRequestContext.clear();
        navDeepLinkBuilder.getAuthRequestContext.add(new DeepLinkDestination(i, null));
        if (navDeepLinkBuilder.PlaceComponentResult != null) {
            navDeepLinkBuilder.BuiltInFictitiousFunctionClassFactory();
        }
        return navDeepLinkBuilder;
    }
}
