package io.split.android.engine.matchers.collections;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import io.split.android.engine.matchers.Transformers;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class PartOfSetMatcher implements Matcher {
    private final Set<String> KClassImpl$Data$declaredNonStaticMembers$2;

    public PartOfSetMatcher(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = hashSet;
        if (collection == null) {
            throw new IllegalArgumentException("Null whitelist");
        }
        hashSet.addAll(collection);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        if (obj != null && (obj instanceof Collection)) {
            Set<String> MyBillsEntityDataFactory = Transformers.MyBillsEntityDataFactory((Collection) obj);
            if (MyBillsEntityDataFactory.isEmpty()) {
                return false;
            }
            return this.KClassImpl$Data$declaredNonStaticMembers$2.containsAll(MyBillsEntityDataFactory);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("is part of ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        return sb.toString();
    }

    public int hashCode() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() + 527;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof PartOfSetMatcher) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.equals(((PartOfSetMatcher) obj).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }
}
