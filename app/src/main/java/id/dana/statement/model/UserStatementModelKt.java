package id.dana.statement.model;

import id.dana.domain.statement.model.StatementSummary;
import id.dana.domain.statement.model.UserStatement;
import id.dana.domain.user.CurrencyAmount;
import id.dana.model.CurrencyAmountModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b*\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\b*\b\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\r\u001a\u00020\u0000*\u00020\u000f¢\u0006\u0004\b\r\u0010\u0012"}, d2 = {"Lid/dana/statement/model/UserStatementModel;", "Lid/dana/statement/model/StatementViewModel;", "getAuthRequestContext", "(Lid/dana/statement/model/UserStatementModel;)Lid/dana/statement/model/StatementViewModel;", "Lid/dana/domain/user/CurrencyAmount;", "Lid/dana/model/CurrencyAmountModel;", "PlaceComponentResult", "(Lid/dana/domain/user/CurrencyAmount;)Lid/dana/model/CurrencyAmountModel;", "", "Lid/dana/domain/statement/model/StatementSummary;", "", "p0", "Lid/dana/statement/model/StatementSummaryModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Lid/dana/domain/statement/model/UserStatement;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;", "(Lid/dana/domain/statement/model/UserStatement;)Lid/dana/statement/model/UserStatementModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserStatementModelKt {
    public static final CurrencyAmountModel PlaceComponentResult(CurrencyAmount currencyAmount) {
        Intrinsics.checkNotNullParameter(currencyAmount, "");
        return new CurrencyAmountModel(currencyAmount.getAmount(), currencyAmount.getCurrency());
    }

    private static List<StatementSummaryModel> BuiltInFictitiousFunctionClassFactory(List<StatementSummary> list, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        List<StatementSummary> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(StatementSummaryModelKt.MyBillsEntityDataFactory((StatementSummary) it.next(), str));
        }
        return arrayList;
    }

    public static final UserStatementModel BuiltInFictitiousFunctionClassFactory(UserStatement userStatement) {
        Intrinsics.checkNotNullParameter(userStatement, "");
        CurrencyAmount accumulateAmount = userStatement.getAccumulateAmount();
        Intrinsics.checkNotNullParameter(accumulateAmount, "");
        CurrencyAmountModel currencyAmountModel = new CurrencyAmountModel(accumulateAmount.getAmount(), accumulateAmount.getCurrency());
        List<StatementSummary> userStatement2 = userStatement.getUserStatement();
        String amount = userStatement.getAccumulateAmount().getAmount();
        Intrinsics.checkNotNullExpressionValue(amount, "");
        return new UserStatementModel(currencyAmountModel, BuiltInFictitiousFunctionClassFactory(userStatement2, amount), userStatement.getViewType(), userStatement.getStatementType(), null, null, null, null, 240, null);
    }

    public static final List<UserStatementModel> MyBillsEntityDataFactory(List<UserStatement> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<UserStatement> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(BuiltInFictitiousFunctionClassFactory((UserStatement) it.next()));
        }
        return arrayList;
    }

    public static final StatementViewModel getAuthRequestContext(UserStatementModel userStatementModel) {
        Intrinsics.checkNotNullParameter(userStatementModel, "");
        return new StatementViewModel(userStatementModel.NetworkUserEntityData$$ExternalSyntheticLambda0, new UserStatementModel(userStatementModel.getAuthRequestContext, userStatementModel.MyBillsEntityDataFactory, userStatementModel.NetworkUserEntityData$$ExternalSyntheticLambda0, userStatementModel.PlaceComponentResult, null, null, null, null, 240, null));
    }
}
