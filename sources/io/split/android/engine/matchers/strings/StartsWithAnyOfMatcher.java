package io.split.android.engine.matchers.strings;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class StartsWithAnyOfMatcher implements Matcher {
    private final Set<String> MyBillsEntityDataFactory;

    public StartsWithAnyOfMatcher(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        this.MyBillsEntityDataFactory = hashSet;
        if (collection == null) {
            throw new IllegalArgumentException("Null whitelist");
        }
        hashSet.addAll(collection);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        if (obj == null || !(obj instanceof String) || this.MyBillsEntityDataFactory.isEmpty()) {
            return false;
        }
        String str2 = (String) obj;
        for (String str3 : this.MyBillsEntityDataFactory) {
            if (!str3.isEmpty() && str2.startsWith(str3)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("starts with ");
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
        if (obj instanceof StartsWithAnyOfMatcher) {
            return this.MyBillsEntityDataFactory.equals(((StartsWithAnyOfMatcher) obj).MyBillsEntityDataFactory);
        }
        return false;
    }
}
