package io.split.android.engine.matchers;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import io.split.android.client.Evaluator;
import io.split.android.client.dtos.MatcherCombiner;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class CombiningMatcher {
    private final ImmutableList<AttributeMatcher> BuiltInFictitiousFunctionClassFactory;
    private final MatcherCombiner KClassImpl$Data$declaredNonStaticMembers$2;

    public CombiningMatcher(MatcherCombiner matcherCombiner, List<AttributeMatcher> list) {
        ImmutableList<AttributeMatcher> copyOf = ImmutableList.copyOf((Collection) list);
        this.BuiltInFictitiousFunctionClassFactory = copyOf;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = matcherCombiner;
        Preconditions.checkArgument(copyOf.size() > 0);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String str, String str2, Map<String, Object> map, Evaluator evaluator) {
        if (this.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
            return false;
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == MatcherCombiner.AND) {
            return MyBillsEntityDataFactory(str, str2, map, evaluator);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown combiner: ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        throw new IllegalArgumentException(sb.toString());
    }

    private boolean MyBillsEntityDataFactory(String str, String str2, Map<String, Object> map, Evaluator evaluator) {
        UnmodifiableIterator<AttributeMatcher> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        boolean z = true;
        while (it.hasNext()) {
            z &= it.next().getAuthRequestContext(str, str2, map, evaluator);
        }
        return z;
    }

    public int hashCode() {
        return (this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("if");
        UnmodifiableIterator<AttributeMatcher> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        boolean z = true;
        while (it.hasNext()) {
            AttributeMatcher next = it.next();
            if (!z) {
                sb.append(" ");
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            sb.append(" ");
            sb.append(next);
            z = false;
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof CombiningMatcher) {
            CombiningMatcher combiningMatcher = (CombiningMatcher) obj;
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(combiningMatcher.KClassImpl$Data$declaredNonStaticMembers$2) && this.BuiltInFictitiousFunctionClassFactory.equals(combiningMatcher.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }
}
