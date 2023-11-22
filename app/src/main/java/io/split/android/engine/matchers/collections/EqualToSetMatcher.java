package io.split.android.engine.matchers.collections;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import io.split.android.engine.matchers.Transformers;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class EqualToSetMatcher implements Matcher {
    private final Set<String> getAuthRequestContext;

    public EqualToSetMatcher(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        this.getAuthRequestContext = hashSet;
        if (collection == null) {
            throw new IllegalArgumentException("Null whitelist");
        }
        hashSet.addAll(collection);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        if (obj != null && (obj instanceof Collection)) {
            return Transformers.MyBillsEntityDataFactory((Collection) obj).equals(this.getAuthRequestContext);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("is equal to  ");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }

    public int hashCode() {
        return this.getAuthRequestContext.hashCode() + 527;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof EqualToSetMatcher) {
            return this.getAuthRequestContext.equals(((EqualToSetMatcher) obj).getAuthRequestContext);
        }
        return false;
    }
}
