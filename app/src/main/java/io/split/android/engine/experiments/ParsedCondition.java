package io.split.android.engine.experiments;

import io.split.android.client.dtos.ConditionType;
import io.split.android.client.dtos.Partition;
import io.split.android.engine.matchers.CombiningMatcher;
import java.util.List;

/* loaded from: classes6.dex */
public final class ParsedCondition {
    public final ConditionType BuiltInFictitiousFunctionClassFactory;
    public final String MyBillsEntityDataFactory;
    public final CombiningMatcher PlaceComponentResult;
    public final List<Partition> getAuthRequestContext;

    public ParsedCondition(ConditionType conditionType, CombiningMatcher combiningMatcher, List<Partition> list, String str) {
        this.BuiltInFictitiousFunctionClassFactory = conditionType;
        this.PlaceComponentResult = combiningMatcher;
        this.getAuthRequestContext = list;
        this.MyBillsEntityDataFactory = str;
    }

    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        int i = 17;
        for (Partition partition : this.getAuthRequestContext) {
            i = (((i * 31) + partition.treatment.hashCode()) * 31) + partition.size;
        }
        return ((hashCode + 527) * 31) + i;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParsedCondition) {
            ParsedCondition parsedCondition = (ParsedCondition) obj;
            boolean equals = this.PlaceComponentResult.equals(parsedCondition.PlaceComponentResult);
            if (equals) {
                if (this.getAuthRequestContext.size() != parsedCondition.getAuthRequestContext.size()) {
                    return equals;
                }
                for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
                    Partition partition = this.getAuthRequestContext.get(i);
                    Partition partition2 = parsedCondition.getAuthRequestContext.get(i);
                    equals &= partition.size == partition2.size && partition.treatment.equals(partition2.treatment);
                }
                return equals;
            }
            return false;
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.PlaceComponentResult);
        sb.append(" then split ");
        boolean z = true;
        for (Partition partition : this.getAuthRequestContext) {
            if (!z) {
                sb.append(',');
            }
            sb.append(partition.size);
            sb.append(':');
            sb.append(partition.treatment);
            z = false;
        }
        return sb.toString();
    }
}
