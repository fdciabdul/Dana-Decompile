package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.dtos.DataType;
import java.util.Map;

/* loaded from: classes6.dex */
public class BetweenMatcher implements Matcher {
    private final long BuiltInFictitiousFunctionClassFactory;
    private final long KClassImpl$Data$declaredNonStaticMembers$2;
    private final long MyBillsEntityDataFactory;
    private final DataType PlaceComponentResult;
    private final long getAuthRequestContext;

    public BetweenMatcher(long j, long j2, DataType dataType) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
        this.getAuthRequestContext = j2;
        this.PlaceComponentResult = dataType;
        if (dataType == DataType.DATETIME) {
            this.BuiltInFictitiousFunctionClassFactory = Transformers.BuiltInFictitiousFunctionClassFactory(Long.valueOf(j)).longValue();
            this.MyBillsEntityDataFactory = Transformers.BuiltInFictitiousFunctionClassFactory(Long.valueOf(j2)).longValue();
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = j;
        this.MyBillsEntityDataFactory = j2;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        Long MyBillsEntityDataFactory;
        if (this.PlaceComponentResult == DataType.DATETIME) {
            MyBillsEntityDataFactory = Transformers.BuiltInFictitiousFunctionClassFactory(obj);
        } else {
            MyBillsEntityDataFactory = Transformers.MyBillsEntityDataFactory(obj);
        }
        return MyBillsEntityDataFactory != null && MyBillsEntityDataFactory.longValue() >= this.BuiltInFictitiousFunctionClassFactory && MyBillsEntityDataFactory.longValue() <= this.MyBillsEntityDataFactory;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("between ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(" and ");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }

    public int hashCode() {
        long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.getAuthRequestContext;
        return ((i + 527) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof BetweenMatcher) {
            BetweenMatcher betweenMatcher = (BetweenMatcher) obj;
            return this.KClassImpl$Data$declaredNonStaticMembers$2 == betweenMatcher.KClassImpl$Data$declaredNonStaticMembers$2 && this.getAuthRequestContext == betweenMatcher.getAuthRequestContext;
        }
        return false;
    }
}
