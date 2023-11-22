package id.dana.richview.statement.mapper;

import com.github.mikephil.charting.data.Entry;
import id.dana.R;
import id.dana.richview.statement.model.PointModel;
import id.dana.utils.LocaleUtil;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/richview/statement/mapper/StatementChartMapper;", "", "Lcom/github/mikephil/charting/data/Entry;", "p0", "Lid/dana/richview/statement/model/PointModel;", "MyBillsEntityDataFactory", "(Lcom/github/mikephil/charting/data/Entry;)Lid/dana/richview/statement/model/PointModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementChartMapper {
    public static final StatementChartMapper INSTANCE = new StatementChartMapper();

    private StatementChartMapper() {
    }

    public static PointModel MyBillsEntityDataFactory(Entry p0) {
        int i;
        String format;
        String valueOf = String.valueOf(p0 != null ? p0.KClassImpl$Data$declaredNonStaticMembers$2 : null);
        Float valueOf2 = p0 != null ? Float.valueOf(p0.getAuthRequestContext()) : null;
        if (valueOf2 == null) {
            valueOf2 = Float.valueOf(0.0f);
        }
        int i2 = 0;
        if (Intrinsics.areEqual("income", valueOf)) {
            i2 = R.drawable.ic_arrow_down_white;
            i = R.drawable.bg_income_statement;
        } else if (Intrinsics.areEqual("expense", valueOf)) {
            i2 = R.drawable.ic_arrow_up_white;
            i = R.drawable.bg_expense_statement;
        } else {
            i = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Rp");
        format = NumberFormat.getNumberInstance(LocaleUtil.getAuthRequestContext()).format(valueOf2.floatValue());
        sb.append(format);
        return new PointModel(i2, i, sb.toString());
    }
}
