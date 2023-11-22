package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import java.util.Map;

/* loaded from: classes6.dex */
public class BooleanMatcher implements Matcher {
    private boolean getAuthRequestContext;

    public BooleanMatcher(boolean z) {
        this.getAuthRequestContext = z;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        Boolean PlaceComponentResult;
        return (obj == null || (PlaceComponentResult = Transformers.PlaceComponentResult(obj)) == null || PlaceComponentResult.booleanValue() != this.getAuthRequestContext) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("is ");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.getAuthRequestContext == ((BooleanMatcher) obj).getAuthRequestContext;
    }

    public int hashCode() {
        return this.getAuthRequestContext ? 1 : 0;
    }
}
