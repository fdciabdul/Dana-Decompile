package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.dtos.DataType;
import java.util.Map;

/* loaded from: classes6.dex */
public class LessThanOrEqualToMatcher implements Matcher {
    private final long KClassImpl$Data$declaredNonStaticMembers$2;
    private final long MyBillsEntityDataFactory;
    private final DataType getAuthRequestContext;

    public LessThanOrEqualToMatcher(long j, DataType dataType) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.getAuthRequestContext = dataType;
        if (dataType == DataType.DATETIME) {
            this.MyBillsEntityDataFactory = Transformers.BuiltInFictitiousFunctionClassFactory(Long.valueOf(j)).longValue();
        } else {
            this.MyBillsEntityDataFactory = j;
        }
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        Long MyBillsEntityDataFactory;
        if (this.getAuthRequestContext == DataType.DATETIME) {
            MyBillsEntityDataFactory = Transformers.BuiltInFictitiousFunctionClassFactory(obj);
        } else {
            MyBillsEntityDataFactory = Transformers.MyBillsEntityDataFactory(obj);
        }
        return MyBillsEntityDataFactory != null && MyBillsEntityDataFactory.longValue() <= this.MyBillsEntityDataFactory;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<= ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        return sb.toString();
    }

    public int hashCode() {
        long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return ((int) (j ^ (j >>> 32))) + 527;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof LessThanOrEqualToMatcher) && this.KClassImpl$Data$declaredNonStaticMembers$2 == ((LessThanOrEqualToMatcher) obj).KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
