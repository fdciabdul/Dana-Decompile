package id.dana.statement.model;

import id.dana.domain.statement.model.StatementDetail;
import id.dana.domain.statement.model.UserStatementDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/statement/model/UserStatementDetail;", "Lid/dana/statement/model/UserStatementDetailModel;", "getAuthRequestContext", "(Lid/dana/domain/statement/model/UserStatementDetail;)Lid/dana/statement/model/UserStatementDetailModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserStatementDetailModelKt {
    public static final UserStatementDetailModel getAuthRequestContext(UserStatementDetail userStatementDetail) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(userStatementDetail, "");
        List<StatementDetail> statementDetails = userStatementDetail.getStatementDetails();
        if (statementDetails != null) {
            Intrinsics.checkNotNullParameter(statementDetails, "");
            List<StatementDetail> list = statementDetails;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(StatementDetailModelKt.BuiltInFictitiousFunctionClassFactory((StatementDetail) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new UserStatementDetailModel(arrayList);
    }
}
