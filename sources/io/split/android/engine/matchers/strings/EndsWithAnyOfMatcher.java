package io.split.android.engine.matchers.strings;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class EndsWithAnyOfMatcher implements Matcher {
    private final Set<String> getAuthRequestContext;

    public EndsWithAnyOfMatcher(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        this.getAuthRequestContext = hashSet;
        if (collection == null) {
            throw new IllegalArgumentException("Null whitelist");
        }
        hashSet.addAll(collection);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        if (obj == null || !(obj instanceof String) || this.getAuthRequestContext.isEmpty()) {
            return false;
        }
        String str2 = (String) obj;
        for (String str3 : this.getAuthRequestContext) {
            if (!str3.isEmpty() && str2.endsWith(str3)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ends with ");
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
        if (obj instanceof EndsWithAnyOfMatcher) {
            return this.getAuthRequestContext.equals(((EndsWithAnyOfMatcher) obj).getAuthRequestContext);
        }
        return false;
    }
}
