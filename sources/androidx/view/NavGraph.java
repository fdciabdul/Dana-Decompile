package androidx.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.view.NavDestination;
import androidx.view.common.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 +2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002:\u0001+B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000(¢\u0006\u0004\b)\u0010*J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0005\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u001d\u001a\u00020\u000f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\"X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010$R\u0018\u0010!\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b'\u0010&"}, d2 = {"Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavDestination;)V", "", "", "equals", "(Ljava/lang/Object;)Z", "", "p1", "MyBillsEntityDataFactory", "(IZ)Landroidx/navigation/NavDestination;", "", "PlaceComponentResult", "(Ljava/lang/String;Z)Landroidx/navigation/NavDestination;", "(Ljava/lang/String;)Landroidx/navigation/NavDestination;", "hashCode", "()I", "", "iterator", "()Ljava/util/Iterator;", "Landroidx/navigation/NavDeepLinkRequest;", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "Landroid/content/Context;", "Landroid/util/AttributeSet;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Landroidx/collection/SparseArrayCompat;", "Landroidx/collection/SparseArrayCompat;", "I", "DatabaseTableConfigUtil", "Ljava/lang/String;", "GetContactSyncConfig", "Landroidx/navigation/Navigator;", "<init>", "(Landroidx/navigation/Navigator;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavGraph extends NavDestination implements Iterable<NavDestination>, KMappedMarker {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    int PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    String getAuthRequestContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    String MyBillsEntityDataFactory;
    final SparseArrayCompat<NavDestination> KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraph(Navigator<? extends NavGraph> navigator) {
        super(navigator);
        Intrinsics.checkNotNullParameter(navigator, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new SparseArrayCompat<>();
    }

    @Override // androidx.view.NavDestination
    public final void BuiltInFictitiousFunctionClassFactory(Context p0, AttributeSet p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        super.BuiltInFictitiousFunctionClassFactory(p0, p1);
        TypedArray obtainAttributes = p0.getResources().obtainAttributes(p1, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda3);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "");
        int resourceId = obtainAttributes.getResourceId(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda5, 0);
        if (!(resourceId != this.getErrorConfigVersion)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Start destination ");
            sb.append(resourceId);
            sb.append(" cannot use the same id as the graph ");
            sb.append(this);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        if (this.MyBillsEntityDataFactory != null) {
            this.PlaceComponentResult = 0;
            this.MyBillsEntityDataFactory = null;
        }
        this.PlaceComponentResult = resourceId;
        this.getAuthRequestContext = null;
        this.getAuthRequestContext = NavDestination.Companion.BuiltInFictitiousFunctionClassFactory(p0, resourceId);
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    @Override // androidx.view.NavDestination
    public final NavDestination.DeepLinkMatch KClassImpl$Data$declaredNonStaticMembers$2(NavDeepLinkRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NavDestination.DeepLinkMatch KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        ArrayList arrayList = new ArrayList();
        Iterator<NavDestination> it = iterator();
        while (it.hasNext()) {
            NavDestination.DeepLinkMatch KClassImpl$Data$declaredNonStaticMembers$22 = it.next().KClassImpl$Data$declaredNonStaticMembers$2(p0);
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$22);
            }
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) CollectionsKt.listOfNotNull((Object[]) new NavDestination.DeepLinkMatch[]{KClassImpl$Data$declaredNonStaticMembers$2, (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull((Iterable) arrayList)}));
    }

    private NavDestination PlaceComponentResult(String p0) {
        String str = p0;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return PlaceComponentResult(p0, true);
    }

    public final NavDestination MyBillsEntityDataFactory(int p0, boolean p1) {
        NavDestination BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(p0);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            if (!p1 || this.moveToNextValue == null) {
                return null;
            }
            NavGraph navGraph = this.moveToNextValue;
            Intrinsics.checkNotNull(navGraph);
            return navGraph.MyBillsEntityDataFactory(p0, true);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final NavDestination PlaceComponentResult(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        NavDestination BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(NavDestination.Companion.MyBillsEntityDataFactory(p0).hashCode());
        if (BuiltInFictitiousFunctionClassFactory == null) {
            if (!p1 || this.moveToNextValue == null) {
                return null;
            }
            NavGraph navGraph = this.moveToNextValue;
            Intrinsics.checkNotNull(navGraph);
            return navGraph.PlaceComponentResult(p0);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new NavGraph$iterator$1(this);
    }

    @Override // androidx.view.NavDestination
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        NavDestination PlaceComponentResult = PlaceComponentResult(this.MyBillsEntityDataFactory);
        if (PlaceComponentResult == null) {
            PlaceComponentResult = MyBillsEntityDataFactory(this.PlaceComponentResult, true);
        }
        sb.append(" startDestination=");
        if (PlaceComponentResult == null) {
            String str = this.MyBillsEntityDataFactory;
            if (str != null) {
                sb.append(str);
            } else {
                String str2 = this.getAuthRequestContext;
                if (str2 != null) {
                    sb.append(str2);
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("0x");
                    sb2.append(Integer.toHexString(this.PlaceComponentResult));
                    sb.append(sb2.toString());
                }
            }
        } else {
            sb.append("{");
            sb.append(PlaceComponentResult.toString());
            sb.append("}");
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    @Override // androidx.view.NavDestination
    public boolean equals(Object p0) {
        if (p0 == null || !(p0 instanceof NavGraph)) {
            return false;
        }
        List mutableList = SequencesKt.toMutableList(SequencesKt.asSequence(SparseArrayKt.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)));
        NavGraph navGraph = (NavGraph) p0;
        Iterator MyBillsEntityDataFactory = SparseArrayKt.MyBillsEntityDataFactory(navGraph.KClassImpl$Data$declaredNonStaticMembers$2);
        while (MyBillsEntityDataFactory.hasNext()) {
            mutableList.remove((NavDestination) MyBillsEntityDataFactory.next());
        }
        return super.equals(p0) && this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory() == navGraph.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory() && this.PlaceComponentResult == navGraph.PlaceComponentResult && mutableList.isEmpty();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/navigation/NavGraph$Companion;", "", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/NavDestination;", "MyBillsEntityDataFactory", "(Landroidx/navigation/NavGraph;)Landroidx/navigation/NavDestination;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static NavDestination MyBillsEntityDataFactory(NavGraph navGraph) {
            Intrinsics.checkNotNullParameter(navGraph, "");
            return (NavDestination) SequencesKt.last(SequencesKt.generateSequence(navGraph.MyBillsEntityDataFactory(navGraph.PlaceComponentResult, true), new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavGraph$Companion$findStartDestination$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination navDestination) {
                    Intrinsics.checkNotNullParameter(navDestination, "");
                    if (navDestination instanceof NavGraph) {
                        NavGraph navGraph2 = (NavGraph) navDestination;
                        return navGraph2.MyBillsEntityDataFactory(navGraph2.PlaceComponentResult, true);
                    }
                    return null;
                }
            }));
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(NavDestination p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = p0.getErrorConfigVersion;
        if (!((i == 0 && p0.scheduleImpl == null) ? false : true)) {
            throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.".toString());
        }
        if (this.scheduleImpl != null && (!Intrinsics.areEqual(r1, this.scheduleImpl)) == false) {
            StringBuilder sb = new StringBuilder();
            sb.append("Destination ");
            sb.append(p0);
            sb.append(" cannot have the same route as graph ");
            sb.append(this);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        if (!(i != this.getErrorConfigVersion)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Destination ");
            sb2.append(p0);
            sb2.append(" cannot have the same id as graph ");
            sb2.append(this);
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        NavDestination BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(i);
        if (BuiltInFictitiousFunctionClassFactory == p0) {
            return;
        }
        if (!(p0.moveToNextValue == null)) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.".toString());
        }
        if (BuiltInFictitiousFunctionClassFactory != null) {
            BuiltInFictitiousFunctionClassFactory.moveToNextValue = null;
        }
        p0.moveToNextValue = this;
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0.getErrorConfigVersion, p0);
    }

    @Override // androidx.view.NavDestination
    @JvmName(name = "getAuthRequestContext")
    public final String getAuthRequestContext() {
        return this.getErrorConfigVersion != 0 ? super.getAuthRequestContext() : "the root navigation";
    }

    @Override // androidx.view.NavDestination
    public int hashCode() {
        int i = this.PlaceComponentResult;
        SparseArrayCompat<NavDestination> sparseArrayCompat = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory = sparseArrayCompat.MyBillsEntityDataFactory();
        for (int i2 = 0; i2 < MyBillsEntityDataFactory; i2++) {
            i = (((i * 31) + sparseArrayCompat.PlaceComponentResult(i2)) * 31) + sparseArrayCompat.lookAheadTest(i2).hashCode();
        }
        return i;
    }
}
