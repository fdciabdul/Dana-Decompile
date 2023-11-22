package id.dana.explore.model;

import id.dana.domain.globalsearch.model.ProductBizId;
import id.dana.domain.homeinfo.SkuAttribute;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0016\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.BÁ\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b,\u0010-J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\rR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\r"}, d2 = {"Lid/dana/explore/model/ExploreProductModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "Lid/dana/domain/globalsearch/model/ProductBizId;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/globalsearch/model/ProductBizId;", "getErrorConfigVersion", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "", "moveToNextValue", "Ljava/util/List;", "GetContactSyncConfig", "initRecordTimeStamp", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/ProductBizId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ExploreProductModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public String GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final List<String> initRecordTimeStamp;
    public ProductBizId KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String getErrorConfigVersion;
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;
    public String getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final List<String> DatabaseTableConfigUtil;
    public String lookAheadTest;
    public final List<String> moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public ExploreProductModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ExploreProductModel) {
            ExploreProductModel exploreProductModel = (ExploreProductModel) p0;
            return Intrinsics.areEqual(this.DatabaseTableConfigUtil, exploreProductModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.initRecordTimeStamp, exploreProductModel.initRecordTimeStamp) && Intrinsics.areEqual(this.moveToNextValue, exploreProductModel.moveToNextValue) && Intrinsics.areEqual(this.getAuthRequestContext, exploreProductModel.getAuthRequestContext) && Intrinsics.areEqual(this.GetContactSyncConfig, exploreProductModel.GetContactSyncConfig) && Intrinsics.areEqual(this.getErrorConfigVersion, exploreProductModel.getErrorConfigVersion) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, exploreProductModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, exploreProductModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, exploreProductModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, exploreProductModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, exploreProductModel.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, exploreProductModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.lookAheadTest, exploreProductModel.lookAheadTest) && Intrinsics.areEqual(this.PlaceComponentResult, exploreProductModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        List<String> list = this.DatabaseTableConfigUtil;
        int hashCode = list == null ? 0 : list.hashCode();
        List<String> list2 = this.initRecordTimeStamp;
        int hashCode2 = list2 == null ? 0 : list2.hashCode();
        List<String> list3 = this.moveToNextValue;
        int hashCode3 = list3 == null ? 0 : list3.hashCode();
        String str = this.getAuthRequestContext;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.GetContactSyncConfig;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.getErrorConfigVersion;
        int hashCode6 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        ProductBizId productBizId = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode9 = productBizId == null ? 0 : productBizId.hashCode();
        String str6 = this.MyBillsEntityDataFactory;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.scheduleImpl;
        int hashCode11 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode12 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.lookAheadTest;
        int hashCode13 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.PlaceComponentResult;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExploreProductModel(DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    private ExploreProductModel(List<String> list, List<String> list2, List<String> list3, String str, String str2, String str3, String str4, String str5, ProductBizId productBizId, String str6, String str7, String str8, String str9, String str10) {
        this.DatabaseTableConfigUtil = list;
        this.initRecordTimeStamp = list2;
        this.moveToNextValue = list3;
        this.getAuthRequestContext = str;
        this.GetContactSyncConfig = str2;
        this.getErrorConfigVersion = str3;
        this.BuiltInFictitiousFunctionClassFactory = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = productBizId;
        this.MyBillsEntityDataFactory = str6;
        this.scheduleImpl = str7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str8;
        this.lookAheadTest = str9;
        this.PlaceComponentResult = str10;
    }

    public /* synthetic */ ExploreProductModel(List list, List list2, List list3, String str, String str2, String str3, String str4, String str5, ProductBizId productBizId, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : productBizId, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) == 0 ? str10 : null);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/model/ExploreProductModel$Companion;", "", "Lid/dana/domain/homeinfo/SkuAttribute;", "p0", "Lid/dana/explore/model/ExploreProductModel;", "PlaceComponentResult", "(Lid/dana/domain/homeinfo/SkuAttribute;)Lid/dana/explore/model/ExploreProductModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ExploreProductModel PlaceComponentResult(SkuAttribute p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new ExploreProductModel(p0.getServiceKey(), p0.getPrepaidKey(), p0.getPostpaidKey(), p0.getBackgroundColor(), p0.getTitle(), p0.getIcon(), p0.getButtonDescription(), p0.getServiceName(), p0.getProductBizId(), null, null, p0.getKey(), p0.getLink(), p0.getAppId(), 1536, null);
        }
    }
}
