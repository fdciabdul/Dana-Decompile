package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import java.util.Map;

/* loaded from: classes6.dex */
public final class AllKeysMatcher implements Matcher {
    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        return obj != null;
    }

    public final int hashCode() {
        return 17;
    }

    public final String toString() {
        return "in segment all";
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj instanceof AllKeysMatcher;
    }
}
