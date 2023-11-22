package id.dana.data.statement.repository.source.network.response;

import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.model.UserStatementDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/statement/repository/source/network/response/StatementDetailResult;", "Lid/dana/domain/statement/StatementType;", "p0", "Lid/dana/domain/statement/model/UserStatementDetail;", "MyBillsEntityDataFactory", "(Lid/dana/data/statement/repository/source/network/response/StatementDetailResult;Lid/dana/domain/statement/StatementType;)Lid/dana/domain/statement/model/UserStatementDetail;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StatementDetailResultKt {
    public static final UserStatementDetail MyBillsEntityDataFactory(StatementDetailResult statementDetailResult, StatementType statementType) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(statementDetailResult, "");
        Intrinsics.checkNotNullParameter(statementType, "");
        List<UserAccumulateDetail> userAccumulateDetails = statementDetailResult.getUserAccumulateDetails();
        if (userAccumulateDetails != null) {
            Intrinsics.checkNotNullParameter(userAccumulateDetails, "");
            List<UserAccumulateDetail> list = userAccumulateDetails;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(UserAccumulateDetailKt.BuiltInFictitiousFunctionClassFactory((UserAccumulateDetail) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new UserStatementDetail(arrayList, statementType);
    }
}
