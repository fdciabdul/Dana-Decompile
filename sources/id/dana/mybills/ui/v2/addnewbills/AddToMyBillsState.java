package id.dana.mybills.ui.v2.addnewbills;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0017\u0010\r\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0012\u0010\u0015"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddToMyBillsState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Calendar;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Calendar;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "Z", "()Z", "p1", "p2", "p3", "<init>", "(ZLjava/lang/String;Ljava/util/Calendar;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AddToMyBillsState {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Calendar BuiltInFictitiousFunctionClassFactory;
    public final String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    public AddToMyBillsState() {
        this(false, null, null, null, 15, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof AddToMyBillsState) {
            AddToMyBillsState addToMyBillsState = (AddToMyBillsState) p0;
            return this.KClassImpl$Data$declaredNonStaticMembers$2 == addToMyBillsState.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.MyBillsEntityDataFactory, addToMyBillsState.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, addToMyBillsState.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, addToMyBillsState.PlaceComponentResult);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AddToMyBillsState(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    private AddToMyBillsState(boolean z, String str, Calendar calendar, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(calendar, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = calendar;
        this.PlaceComponentResult = str2;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AddToMyBillsState(boolean r2, java.lang.String r3, java.util.Calendar r4, java.lang.String r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r1 = this;
            r7 = r6 & 1
            if (r7 == 0) goto L5
            r2 = 0
        L5:
            r7 = r6 & 2
            java.lang.String r0 = ""
            if (r7 == 0) goto Lc
            r3 = r0
        Lc:
            r7 = r6 & 4
            if (r7 == 0) goto L17
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
        L17:
            r6 = r6 & 8
            if (r6 == 0) goto L1d
            java.lang.String r5 = "REMINDER"
        L1d:
            r1.<init>(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.addnewbills.AddToMyBillsState.<init>(boolean, java.lang.String, java.util.Calendar, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ AddToMyBillsState getAuthRequestContext(AddToMyBillsState addToMyBillsState, boolean z) {
        String str = addToMyBillsState.MyBillsEntityDataFactory;
        Calendar calendar = addToMyBillsState.BuiltInFictitiousFunctionClassFactory;
        String str2 = addToMyBillsState.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(calendar, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return new AddToMyBillsState(z, str, calendar, str2);
    }
}
