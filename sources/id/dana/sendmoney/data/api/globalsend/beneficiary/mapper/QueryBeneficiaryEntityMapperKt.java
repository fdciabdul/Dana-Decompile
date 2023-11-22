package id.dana.sendmoney.data.api.globalsend.beneficiary.mapper;

import id.dana.sendmoney.data.api.globalsend.beneficiary.request.QueryBeneficiaryRequestEntity;
import id.dana.sendmoney.data.api.globalsend.beneficiary.response.QueryBeneficiaryResultEntity;
import id.dana.sendmoney.data.api.globalsend.validate.mapper.BeneficiaryInfoEntityMapperKt;
import id.dana.sendmoney.data.api.globalsend.validate.model.BeneficiaryInfoEntity;
import id.dana.sendmoney.domain.globalsend.model.beneficiary.request.QueryBeneficiaryRequest;
import id.dana.sendmoney.domain.globalsend.model.beneficiary.response.QueryBeneficiaryResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;", "Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;", "toQueryBeneficiaryRequestEntity", "(Lid/dana/sendmoney/domain/globalsend/model/beneficiary/request/QueryBeneficiaryRequest;)Lid/dana/sendmoney/data/api/globalsend/beneficiary/request/QueryBeneficiaryRequestEntity;", "Lid/dana/sendmoney/data/api/globalsend/beneficiary/response/QueryBeneficiaryResultEntity;", "Lid/dana/sendmoney/domain/globalsend/model/beneficiary/response/QueryBeneficiaryResult;", "toQueryBeneficiaryResult", "(Lid/dana/sendmoney/data/api/globalsend/beneficiary/response/QueryBeneficiaryResultEntity;)Lid/dana/sendmoney/domain/globalsend/model/beneficiary/response/QueryBeneficiaryResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryBeneficiaryEntityMapperKt {
    public static final QueryBeneficiaryResult toQueryBeneficiaryResult(QueryBeneficiaryResultEntity queryBeneficiaryResultEntity) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(queryBeneficiaryResultEntity, "");
        List<BeneficiaryInfoEntity> beneficiaryList = queryBeneficiaryResultEntity.getBeneficiaryList();
        if (beneficiaryList == null) {
            arrayList = new ArrayList();
        } else {
            List<BeneficiaryInfoEntity> list = beneficiaryList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(BeneficiaryInfoEntityMapperKt.toBeneficiaryInfo((BeneficiaryInfoEntity) it.next()));
            }
            arrayList = arrayList2;
        }
        List asMutableList = TypeIntrinsics.asMutableList(arrayList);
        Integer totalCount = queryBeneficiaryResultEntity.getTotalCount();
        int intValue = totalCount != null ? totalCount.intValue() : 0;
        String location = queryBeneficiaryResultEntity.getLocation();
        return new QueryBeneficiaryResult(asMutableList, intValue, location != null ? location : "");
    }

    public static final QueryBeneficiaryRequestEntity toQueryBeneficiaryRequestEntity(QueryBeneficiaryRequest queryBeneficiaryRequest) {
        Intrinsics.checkNotNullParameter(queryBeneficiaryRequest, "");
        return new QueryBeneficiaryRequestEntity(queryBeneficiaryRequest.PlaceComponentResult, queryBeneficiaryRequest.getAuthRequestContext, queryBeneficiaryRequest.BuiltInFictitiousFunctionClassFactory);
    }
}
