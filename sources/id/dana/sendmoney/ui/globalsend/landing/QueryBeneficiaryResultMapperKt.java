package id.dana.sendmoney.ui.globalsend.landing;

import id.dana.sendmoney.domain.globalsend.model.beneficiary.response.QueryBeneficiaryResult;
import id.dana.sendmoney.domain.globalsend.model.validate.BeneficiaryInfo;
import id.dana.sendmoney.ui.globalsend.form.mapper.BeneficiaryModelMapperKt;
import id.dana.sendmoney.ui.globalsend.landing.model.QueryBeneficiaryResultModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/beneficiary/response/QueryBeneficiaryResult;", "Lid/dana/sendmoney/ui/globalsend/landing/model/QueryBeneficiaryResultModel;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/domain/globalsend/model/beneficiary/response/QueryBeneficiaryResult;)Lid/dana/sendmoney/ui/globalsend/landing/model/QueryBeneficiaryResultModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryBeneficiaryResultMapperKt {
    public static final QueryBeneficiaryResultModel MyBillsEntityDataFactory(QueryBeneficiaryResult queryBeneficiaryResult) {
        Intrinsics.checkNotNullParameter(queryBeneficiaryResult, "");
        List<BeneficiaryInfo> list = queryBeneficiaryResult.KClassImpl$Data$declaredNonStaticMembers$2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(BeneficiaryModelMapperKt.BuiltInFictitiousFunctionClassFactory((BeneficiaryInfo) it.next()));
        }
        return new QueryBeneficiaryResultModel(TypeIntrinsics.asMutableList(arrayList), queryBeneficiaryResult.PlaceComponentResult, queryBeneficiaryResult.BuiltInFictitiousFunctionClassFactory);
    }
}
