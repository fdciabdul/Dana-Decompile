package io.split.android.engine.matchers.collections;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import io.split.android.engine.matchers.Transformers;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class ContainsAnyOfSetMatcher implements Matcher {
    private final Set<String> MyBillsEntityDataFactory;

    public ContainsAnyOfSetMatcher(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        this.MyBillsEntityDataFactory = hashSet;
        if (collection == null) {
            throw new IllegalArgumentException("Null whitelist");
        }
        hashSet.addAll(collection);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        if (obj != null && (obj instanceof Collection)) {
            Set<String> MyBillsEntityDataFactory = Transformers.MyBillsEntityDataFactory((Collection) obj);
            Iterator<String> it = this.MyBillsEntityDataFactory.iterator();
            while (it.hasNext()) {
                if (MyBillsEntityDataFactory.contains(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("contains any of ");
        sb.append(this.MyBillsEntityDataFactory);
        return sb.toString();
    }

    public int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode() + 527;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof ContainsAnyOfSetMatcher) {
            return this.MyBillsEntityDataFactory.equals(((ContainsAnyOfSetMatcher) obj).MyBillsEntityDataFactory);
        }
        return false;
    }
}
