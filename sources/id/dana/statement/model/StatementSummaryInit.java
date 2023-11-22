package id.dana.statement.model;

import id.dana.domain.statement.StatementType;
import id.dana.statement.TimeUnitInterval;
import id.dana.utils.DateTimeUtil;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0012\u0010\u0003\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0012\u0010\t\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/statement/model/StatementSummaryInit;", "", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "", "J", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/statement/TimeUnitInterval;", "getAuthRequestContext", "Lid/dana/statement/TimeUnitInterval;", "Lid/dana/domain/statement/StatementType;", "PlaceComponentResult", "Lid/dana/domain/statement/StatementType;", "p0", "p1", "p2", "<init>", "(JLid/dana/statement/TimeUnitInterval;Lid/dana/domain/statement/StatementType;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StatementSummaryInit {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public long KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public StatementType getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public TimeUnitInterval BuiltInFictitiousFunctionClassFactory;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[TimeUnitInterval.values().length];
            iArr[TimeUnitInterval.DAY.ordinal()] = 1;
            iArr[TimeUnitInterval.MONTH.ordinal()] = 2;
            iArr[TimeUnitInterval.WEEK.ordinal()] = 3;
            PlaceComponentResult = iArr;
        }
    }

    public StatementSummaryInit(long j, TimeUnitInterval timeUnitInterval, StatementType statementType) {
        Intrinsics.checkNotNullParameter(timeUnitInterval, "");
        Intrinsics.checkNotNullParameter(statementType, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.BuiltInFictitiousFunctionClassFactory = timeUnitInterval;
        this.getAuthRequestContext = statementType;
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        int i = WhenMappings.PlaceComponentResult[this.BuiltInFictitiousFunctionClassFactory.ordinal()];
        if (i == 1) {
            String BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("ddMMyyyy", Locale.getDefault(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            return BuiltInFictitiousFunctionClassFactory;
        } else if (i == 2) {
            String BuiltInFictitiousFunctionClassFactory2 = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("MMyyyy", Locale.getDefault(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
            return BuiltInFictitiousFunctionClassFactory2;
        } else if (i == 3) {
            String BuiltInFictitiousFunctionClassFactory3 = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("wwyyyy", Locale.getDefault(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory3, "");
            return BuiltInFictitiousFunctionClassFactory3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
