package id.dana.appwidget.mapper;

import com.github.mikephil.charting.data.Entry;
import id.dana.appwidget.model.IncomeAndExpenseEntryChartModel;
import id.dana.data.base.BaseMapper;
import id.dana.domain.statement.model.IncomeAndExpenseStatementSummary;
import id.dana.domain.statement.model.UserStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u000f"}, d2 = {"Lid/dana/appwidget/mapper/IncomeAndExpenseEntryChartModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/statement/model/IncomeAndExpenseStatementSummary;", "Lid/dana/appwidget/model/IncomeAndExpenseEntryChartModel;", "", "", "p0", "Ljava/util/ArrayList;", "Lcom/github/mikephil/charting/data/Entry;", "Lkotlin/collections/ArrayList;", "PlaceComponentResult", "(Ljava/util/List;)Ljava/util/ArrayList;", "Lid/dana/domain/statement/model/UserStatement;", "", "MyBillsEntityDataFactory", "(Ljava/util/List;)Ljava/util/List;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class IncomeAndExpenseEntryChartModelMapper extends BaseMapper<IncomeAndExpenseStatementSummary, IncomeAndExpenseEntryChartModel> {
    @Inject
    public IncomeAndExpenseEntryChartModelMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ IncomeAndExpenseEntryChartModel map(IncomeAndExpenseStatementSummary incomeAndExpenseStatementSummary) {
        IncomeAndExpenseStatementSummary incomeAndExpenseStatementSummary2 = incomeAndExpenseStatementSummary;
        if (incomeAndExpenseStatementSummary2 == null) {
            return new IncomeAndExpenseEntryChartModel(new ArrayList(), new ArrayList());
        }
        return new IncomeAndExpenseEntryChartModel(PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory(incomeAndExpenseStatementSummary2.getIncomes()))), PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory(incomeAndExpenseStatementSummary2.getExpenses()))));
    }

    private static List<String> MyBillsEntityDataFactory(List<UserStatement> p0) {
        ArrayList arrayList = new ArrayList();
        Iterator<UserStatement> it = p0.iterator();
        while (it.hasNext()) {
            String amount = it.next().getAccumulateAmount().getAmount();
            Intrinsics.checkNotNullExpressionValue(amount, "");
            arrayList.add(amount);
        }
        return arrayList;
    }

    private static List<Float> KClassImpl$Data$declaredNonStaticMembers$2(List<String> p0) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = p0.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(Float.parseFloat(StringsKt.replace$default(it.next(), ".", "", false, 4, (Object) null))));
        }
        return arrayList;
    }

    private static ArrayList<Entry> PlaceComponentResult(List<Float> p0) {
        ArrayList<Entry> arrayList = new ArrayList<>();
        int size = p0.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new Entry(i, p0.get(i).floatValue(), "expense"));
        }
        return arrayList;
    }
}
