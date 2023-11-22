package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.dtos.DataType;
import java.util.Map;

/* loaded from: classes6.dex */
public class EqualToMatcher implements Matcher {
    private final DataType BuiltInFictitiousFunctionClassFactory;
    private final long MyBillsEntityDataFactory;
    private final long PlaceComponentResult;

    public EqualToMatcher(long j, DataType dataType) {
        this.PlaceComponentResult = j;
        this.BuiltInFictitiousFunctionClassFactory = dataType;
        if (dataType == DataType.DATETIME) {
            this.MyBillsEntityDataFactory = Transformers.KClassImpl$Data$declaredNonStaticMembers$2(Long.valueOf(j)).longValue();
        } else {
            this.MyBillsEntityDataFactory = j;
        }
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        Long MyBillsEntityDataFactory;
        if (this.BuiltInFictitiousFunctionClassFactory == DataType.DATETIME) {
            MyBillsEntityDataFactory = Transformers.KClassImpl$Data$declaredNonStaticMembers$2(obj);
        } else {
            MyBillsEntityDataFactory = Transformers.MyBillsEntityDataFactory(obj);
        }
        return MyBillsEntityDataFactory != null && MyBillsEntityDataFactory.longValue() == this.MyBillsEntityDataFactory;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("== ");
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
        return (obj instanceof EqualToMatcher) && this.PlaceComponentResult == ((EqualToMatcher) obj).PlaceComponentResult;
    }
}
