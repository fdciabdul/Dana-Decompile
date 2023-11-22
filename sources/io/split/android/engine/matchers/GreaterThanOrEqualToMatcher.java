package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.dtos.DataType;
import java.util.Map;

/* loaded from: classes6.dex */
public class GreaterThanOrEqualToMatcher implements Matcher {
    private final long KClassImpl$Data$declaredNonStaticMembers$2;
    private final DataType MyBillsEntityDataFactory;
    private final long PlaceComponentResult;

    public GreaterThanOrEqualToMatcher(long j, DataType dataType) {
        this.PlaceComponentResult = j;
        this.MyBillsEntityDataFactory = dataType;
        if (dataType == DataType.DATETIME) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Transformers.BuiltInFictitiousFunctionClassFactory(Long.valueOf(j)).longValue();
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        }
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        Long MyBillsEntityDataFactory;
        if (this.MyBillsEntityDataFactory == DataType.DATETIME) {
            MyBillsEntityDataFactory = Transformers.BuiltInFictitiousFunctionClassFactory(obj);
        } else {
            MyBillsEntityDataFactory = Transformers.MyBillsEntityDataFactory(obj);
        }
        return MyBillsEntityDataFactory != null && MyBillsEntityDataFactory.longValue() >= this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(">= ");
        sb.append(this.PlaceComponentResult);
        return sb.toString();
    }

    public int hashCode() {
        long j = this.PlaceComponentResult;
        return ((int) (j ^ (j >>> 32))) + 527;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof GreaterThanOrEqualToMatcher) && this.PlaceComponentResult == ((GreaterThanOrEqualToMatcher) obj).PlaceComponentResult;
    }
}
