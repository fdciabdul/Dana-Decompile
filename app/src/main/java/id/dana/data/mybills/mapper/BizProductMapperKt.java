package id.dana.data.mybills.mapper;

import id.dana.data.mybills.model.result.BizProductResult;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.mybills.model.BizProduct;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lid/dana/data/mybills/model/result/BizProductResult;", "Lid/dana/domain/mybills/model/BizProduct;", "getAuthRequestContext", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BizProductMapperKt {
    public static final List<BizProduct> getAuthRequestContext(List<BizProductResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<BizProductResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (BizProductResult bizProductResult : list2) {
            Intrinsics.checkNotNullParameter(bizProductResult, "");
            String str = bizProductResult.PlaceComponentResult;
            String str2 = str == null ? "" : str;
            MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(bizProductResult.BuiltInFictitiousFunctionClassFactory);
            String str3 = bizProductResult.getAuthRequestContext;
            String str4 = str3 == null ? "" : str3;
            String str5 = bizProductResult.KClassImpl$Data$declaredNonStaticMembers$2;
            String str6 = str5 == null ? "" : str5;
            String str7 = bizProductResult.moveToNextValue;
            String str8 = str7 == null ? "" : str7;
            Boolean bool = bizProductResult.lookAheadTest;
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            String str9 = bizProductResult.NetworkUserEntityData$$ExternalSyntheticLambda0;
            String str10 = str9 == null ? "" : str9;
            String str11 = bizProductResult.scheduleImpl;
            String str12 = str11 == null ? "" : str11;
            Long l = bizProductResult.getErrorConfigVersion;
            long longValue = l != null ? l.longValue() : 0L;
            Map<String, Object> map = bizProductResult.MyBillsEntityDataFactory;
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            arrayList.add(new BizProduct(str2, moneyView, str4, str6, str8, booleanValue, str10, str12, longValue, map));
        }
        return arrayList;
    }
}
