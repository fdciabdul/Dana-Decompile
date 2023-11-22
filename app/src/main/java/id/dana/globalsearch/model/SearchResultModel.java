package id.dana.globalsearch.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0011\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0017\u0010\u0010"}, d2 = {"Lid/dana/globalsearch/model/SearchResultModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "Z", "()Z", "PlaceComponentResult", "I", "MyBillsEntityDataFactory", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;ZLjava/util/List;ZIZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SearchResultModel {
    public final String BuiltInFictitiousFunctionClassFactory;
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<PaySearchInfoModel> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    public SearchResultModel() {
        this(null, false, null, false, 0, false, 63, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SearchResultModel) {
            SearchResultModel searchResultModel = (SearchResultModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, searchResultModel.BuiltInFictitiousFunctionClassFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2 == searchResultModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.getAuthRequestContext, searchResultModel.getAuthRequestContext) && this.PlaceComponentResult == searchResultModel.PlaceComponentResult && this.MyBillsEntityDataFactory == searchResultModel.MyBillsEntityDataFactory && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == searchResultModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = this.getAuthRequestContext.hashCode();
        boolean z2 = this.PlaceComponentResult;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = this.MyBillsEntityDataFactory;
        boolean z3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return (((((((((hashCode * 31) + i) * 31) + hashCode2) * 31) + i2) * 31) + i3) * 31) + (z3 ? 1 : z3 ? 1 : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SearchResultModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(')');
        return sb.toString();
    }

    public SearchResultModel(String str, boolean z, List<PaySearchInfoModel> list, boolean z2, int i, boolean z3) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.getAuthRequestContext = list;
        this.PlaceComponentResult = z2;
        this.MyBillsEntityDataFactory = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z3;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public /* synthetic */ SearchResultModel(String str, boolean z, List list, boolean z2, int i, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? 0 : i, (i2 & 32) == 0 ? z3 : false);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }
}
