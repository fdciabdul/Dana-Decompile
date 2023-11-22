package androidx.view;

import android.os.Bundle;
import androidx.view.NavDestination;
import id.dana.sendmoney.summary.SummaryActivity;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0002\"#B\u0007¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00028\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\r\u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u0012J\u0017\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0004\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0004\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\r\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\r\u0010\u001bJ\u001f\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u0015\u0010\u001cR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001dR$\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u001a8\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b"}, d2 = {"Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", SummaryActivity.DAYS, "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroidx/navigation/NavDestination;", "p0", "Landroid/os/Bundle;", "p1", "Landroidx/navigation/NavOptions;", "p2", "Landroidx/navigation/Navigator$Extras;", "p3", "MyBillsEntityDataFactory", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)Landroidx/navigation/NavDestination;", "", "Landroidx/navigation/NavBackStackEntry;", "", "(Ljava/util/List;Landroidx/navigation/NavOptions;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/NavigatorState;", "(Landroidx/navigation/NavigatorState;)V", "getAuthRequestContext", "(Landroidx/navigation/NavBackStackEntry;)V", "(Landroid/os/Bundle;)V", "BuiltInFictitiousFunctionClassFactory", "()Landroid/os/Bundle;", "", "()Z", "(Landroidx/navigation/NavBackStackEntry;Z)V", "Landroidx/navigation/NavigatorState;", "Z", "PlaceComponentResult", "<init>", "()V", "Extras", "Name"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Navigator<D extends NavDestination> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public NavigatorState BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001"}, d2 = {"Landroidx/navigation/Navigator$Extras;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Extras {
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/Navigator$Name;", "", "", "value", "()Ljava/lang/String;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface Name {
        @JvmName(name = "value")
        String value();
    }

    public Bundle BuiltInFictitiousFunctionClassFactory() {
        return null;
    }

    public abstract D KClassImpl$Data$declaredNonStaticMembers$2();

    public void KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    public NavDestination MyBillsEntityDataFactory(D p0, Bundle p1, NavOptions p2, Extras p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    public boolean MyBillsEntityDataFactory() {
        return true;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(NavigatorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory = p0;
        this.PlaceComponentResult = true;
    }

    public void MyBillsEntityDataFactory(List<NavBackStackEntry> p0, final NavOptions p1, final Extras p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        for (NavBackStackEntry navBackStackEntry : SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(p0), new Function1<NavBackStackEntry, NavBackStackEntry>(this) { // from class: androidx.navigation.Navigator$navigate$1
            final /* synthetic */ Navigator<D> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavBackStackEntry invoke(NavBackStackEntry navBackStackEntry2) {
                NavDestination MyBillsEntityDataFactory;
                Intrinsics.checkNotNullParameter(navBackStackEntry2, "");
                NavDestination navDestination = navBackStackEntry2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (!(navDestination instanceof NavDestination)) {
                    navDestination = null;
                }
                if (navDestination != null && (MyBillsEntityDataFactory = this.this$0.MyBillsEntityDataFactory(navDestination, navBackStackEntry2.getAuthRequestContext, p1, p2)) != null) {
                    if (Intrinsics.areEqual(MyBillsEntityDataFactory, navDestination)) {
                        return navBackStackEntry2;
                    }
                    NavigatorState navigatorState = this.this$0.BuiltInFictitiousFunctionClassFactory;
                    if (navigatorState != null) {
                        return navigatorState.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory, MyBillsEntityDataFactory.MyBillsEntityDataFactory(navBackStackEntry2.getAuthRequestContext));
                    }
                    throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
                }
                return null;
            }
        }))) {
            NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
            if (navigatorState != null) {
                navigatorState.getAuthRequestContext(navBackStackEntry);
            } else {
                throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getAuthRequestContext(NavBackStackEntry p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NavDestination navDestination = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!(navDestination instanceof NavDestination)) {
            navDestination = null;
        }
        if (navDestination == null) {
            return;
        }
        MyBillsEntityDataFactory(navDestination, null, NavOptionsBuilderKt.getAuthRequestContext(new Function1<NavOptionsBuilder, Unit>() { // from class: androidx.navigation.Navigator$onLaunchSingleTop$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                invoke2(navOptionsBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(NavOptionsBuilder navOptionsBuilder) {
                Intrinsics.checkNotNullParameter(navOptionsBuilder, "");
                navOptionsBuilder.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
        }), null);
        NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
        if (navigatorState != null) {
            navigatorState.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            return;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    public void getAuthRequestContext(NavBackStackEntry p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        NavigatorState navigatorState = this.BuiltInFictitiousFunctionClassFactory;
        if (navigatorState != null) {
            List<NavBackStackEntry> value = navigatorState.MyBillsEntityDataFactory.getValue();
            if (!value.contains(p0)) {
                StringBuilder sb = new StringBuilder();
                sb.append("popBackStack was called with ");
                sb.append(p0);
                sb.append(" which does not exist in back stack ");
                sb.append(value);
                throw new IllegalStateException(sb.toString().toString());
            }
            ListIterator<NavBackStackEntry> listIterator = value.listIterator(value.size());
            NavBackStackEntry navBackStackEntry = null;
            while (MyBillsEntityDataFactory()) {
                navBackStackEntry = listIterator.previous();
                if (Intrinsics.areEqual(navBackStackEntry, p0)) {
                    break;
                }
            }
            if (navBackStackEntry != null) {
                NavigatorState navigatorState2 = this.BuiltInFictitiousFunctionClassFactory;
                if (navigatorState2 != null) {
                    navigatorState2.PlaceComponentResult(navBackStackEntry, p1);
                    return;
                }
                throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
            }
            return;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }
}
