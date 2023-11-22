package id.dana.statement.model;

import id.dana.data.util.NumberUtils;
import id.dana.domain.statement.model.StatementSummary;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/domain/statement/model/StatementSummary;", "", "p0", "Lid/dana/statement/model/StatementSummaryModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/statement/model/StatementSummary;Ljava/lang/String;)Lid/dana/statement/model/StatementSummaryModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementSummaryModelKt {
    public static final StatementSummaryModel MyBillsEntityDataFactory(StatementSummary statementSummary, String str) {
        Intrinsics.checkNotNullParameter(statementSummary, "");
        Intrinsics.checkNotNullParameter(str, "");
        String cleanDot = NumberUtils.getCleanDot(statementSummary.getAmount().getAmount());
        Intrinsics.checkNotNullExpressionValue(cleanDot, "");
        float parseFloat = Float.parseFloat(cleanDot);
        String cleanDot2 = NumberUtils.getCleanDot(str);
        Intrinsics.checkNotNullExpressionValue(cleanDot2, "");
        String format = new DecimalFormat().format(Float.valueOf((parseFloat / Float.parseFloat(cleanDot2)) * 100.0f));
        Intrinsics.checkNotNullExpressionValue(format, "");
        float parseFloat2 = Float.parseFloat(StringsKt.replace$default(format, ",", ".", false, 4, (Object) null));
        return new StatementSummaryModel(UserStatementModelKt.PlaceComponentResult(statementSummary.getAmount()), statementSummary.getBizType(), statementSummary.getDescription(), parseFloat2, false, 16, null);
    }
}
