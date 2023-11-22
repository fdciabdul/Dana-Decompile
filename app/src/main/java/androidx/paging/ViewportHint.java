package androidx.paging;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b0\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B)\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\n\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\r\u0082\u0001\u0002\u0017\u0018"}, d2 = {"Landroidx/paging/ViewportHint;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroidx/paging/LoadType;", "getAuthRequestContext", "(Landroidx/paging/LoadType;)I", "BuiltInFictitiousFunctionClassFactory", "I", "MyBillsEntityDataFactory", "PlaceComponentResult", "p1", "p2", "p3", "<init>", "(IIII)V", "Access", "Initial", "Landroidx/paging/ViewportHint$Initial;", "Landroidx/paging/ViewportHint$Access;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ViewportHint {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final int MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final int PlaceComponentResult;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.APPEND.ordinal()] = 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    public /* synthetic */ ViewportHint(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4);
    }

    private ViewportHint(int i, int i2, int i3, int i4) {
        this.PlaceComponentResult = i;
        this.getAuthRequestContext = i2;
        this.MyBillsEntityDataFactory = i3;
        this.BuiltInFictitiousFunctionClassFactory = i4;
    }

    public boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ViewportHint) {
            ViewportHint viewportHint = (ViewportHint) p0;
            return this.PlaceComponentResult == viewportHint.PlaceComponentResult && this.getAuthRequestContext == viewportHint.getAuthRequestContext && this.MyBillsEntityDataFactory == viewportHint.MyBillsEntityDataFactory && this.BuiltInFictitiousFunctionClassFactory == viewportHint.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    public final int getAuthRequestContext(LoadType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return this.getAuthRequestContext;
                }
                throw new NoWhenBranchMatchedException();
            }
            return this.PlaceComponentResult;
        }
        throw new IllegalArgumentException("Cannot get presentedItems for loadType: REFRESH");
    }

    public int hashCode() {
        return this.PlaceComponentResult + this.getAuthRequestContext + this.MyBillsEntityDataFactory + this.BuiltInFictitiousFunctionClassFactory;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/paging/ViewportHint$Initial;", "Landroidx/paging/ViewportHint;", "", "toString", "()Ljava/lang/String;", "", "p0", "p1", "p2", "p3", "<init>", "(IIII)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Initial extends ViewportHint {
        public Initial(int i, int i2, int i3, int i4) {
            super(i, i2, i3, i4, null);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewportHint.Initial(\n            |    presentedItemsBefore=");
            sb.append(this.PlaceComponentResult);
            sb.append(",\n            |    presentedItemsAfter=");
            sb.append(this.getAuthRequestContext);
            sb.append(",\n            |    originalPageOffsetFirst=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(",\n            |    originalPageOffsetLast=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(",\n            |)");
            return StringsKt.trimMargin$default(sb.toString(), null, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e"}, d2 = {"Landroidx/paging/ViewportHint$Access;", "Landroidx/paging/ViewportHint;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "lookAheadTest", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "p3", "p4", "p5", "<init>", "(IIIIII)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Access extends ViewportHint {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final int getAuthRequestContext;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        final int BuiltInFictitiousFunctionClassFactory;

        public Access(int i, int i2, int i3, int i4, int i5, int i6) {
            super(i3, i4, i5, i6, null);
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.getAuthRequestContext = i2;
        }

        @Override // androidx.paging.ViewportHint
        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Access) {
                Access access = (Access) p0;
                return this.BuiltInFictitiousFunctionClassFactory == access.BuiltInFictitiousFunctionClassFactory && this.getAuthRequestContext == access.getAuthRequestContext && this.PlaceComponentResult == access.PlaceComponentResult && this.getAuthRequestContext == access.getAuthRequestContext && this.MyBillsEntityDataFactory == access.MyBillsEntityDataFactory && this.BuiltInFictitiousFunctionClassFactory == access.BuiltInFictitiousFunctionClassFactory;
            }
            return false;
        }

        @Override // androidx.paging.ViewportHint
        public final int hashCode() {
            return super.hashCode() + this.BuiltInFictitiousFunctionClassFactory + this.getAuthRequestContext;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewportHint.Access(\n            |    pageOffset=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(",\n            |    indexInPage=");
            sb.append(this.getAuthRequestContext);
            sb.append(",\n            |    presentedItemsBefore=");
            sb.append(this.PlaceComponentResult);
            sb.append(",\n            |    presentedItemsAfter=");
            sb.append(this.getAuthRequestContext);
            sb.append(",\n            |    originalPageOffsetFirst=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(",\n            |    originalPageOffsetLast=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(",\n            |)");
            return StringsKt.trimMargin$default(sb.toString(), null, 1, null);
        }
    }
}
