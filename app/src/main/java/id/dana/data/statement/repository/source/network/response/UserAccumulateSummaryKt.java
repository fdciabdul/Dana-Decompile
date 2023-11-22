package id.dana.data.statement.repository.source.network.response;

import com.alipay.ap.mobileprod.service.facade.uniresultpage.model.MoneyView;
import id.dana.data.util.NumberUtils;
import id.dana.domain.statement.model.StatementSummary;
import id.dana.domain.user.CurrencyAmount;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004*\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;", "Lid/dana/domain/user/CurrencyAmount;", "PlaceComponentResult", "(Lcom/alipay/ap/mobileprod/service/facade/uniresultpage/model/MoneyView;)Lid/dana/domain/user/CurrencyAmount;", "", "Lid/dana/data/statement/repository/source/network/response/UserAccumulateSummary;", "Lid/dana/domain/statement/model/StatementSummary;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAccumulateSummaryKt {
    public static final CurrencyAmount PlaceComponentResult(MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        return new CurrencyAmount(NumberUtils.getCleanSpaceAndDash(moneyView.amount), moneyView.currency);
    }

    public static final List<StatementSummary> MyBillsEntityDataFactory(List<UserAccumulateSummary> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<UserAccumulateSummary> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (UserAccumulateSummary userAccumulateSummary : list2) {
            Intrinsics.checkNotNullParameter(userAccumulateSummary, "");
            MoneyView amount = userAccumulateSummary.getAmount();
            Intrinsics.checkNotNullParameter(amount, "");
            arrayList.add(new StatementSummary(new CurrencyAmount(NumberUtils.getCleanSpaceAndDash(amount.amount), amount.currency), userAccumulateSummary.getBizType(), userAccumulateSummary.getDescription()));
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.data.statement.repository.source.network.response.UserAccumulateSummaryKt$toListOfStatementSummary$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String cleanDot = NumberUtils.getCleanDot(((StatementSummary) t2).getAmount().getAmount());
                Intrinsics.checkNotNullExpressionValue(cleanDot, "");
                Long longOrNull = StringsKt.toLongOrNull(cleanDot);
                String cleanDot2 = NumberUtils.getCleanDot(((StatementSummary) t).getAmount().getAmount());
                Intrinsics.checkNotNullExpressionValue(cleanDot2, "");
                return ComparisonsKt.compareValues(longOrNull, StringsKt.toLongOrNull(cleanDot2));
            }
        });
    }
}
