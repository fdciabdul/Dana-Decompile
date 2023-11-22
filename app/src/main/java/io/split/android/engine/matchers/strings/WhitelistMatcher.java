package io.split.android.engine.matchers.strings;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;

/* loaded from: classes6.dex */
public class WhitelistMatcher implements Matcher {
    private final Set<String> BuiltInFictitiousFunctionClassFactory;

    public WhitelistMatcher(Collection<String> collection) {
        HashSet hashSet = new HashSet();
        this.BuiltInFictitiousFunctionClassFactory = hashSet;
        if (collection == null) {
            throw new IllegalArgumentException("Null whitelist parameter");
        }
        hashSet.addAll(collection);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        return this.BuiltInFictitiousFunctionClassFactory.contains(obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("in segment [");
        boolean z = true;
        for (String str : this.BuiltInFictitiousFunctionClassFactory) {
            if (!z) {
                sb.append(',');
            }
            sb.append(Typography.quote);
            sb.append(str);
            sb.append(Typography.quote);
            z = false;
        }
        sb.append("]");
        return sb.toString();
    }

    public int hashCode() {
        return this.BuiltInFictitiousFunctionClassFactory.hashCode() + 527;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof WhitelistMatcher) {
            return this.BuiltInFictitiousFunctionClassFactory.equals(((WhitelistMatcher) obj).BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }
}
