package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class DependencyMatcher implements Matcher {
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    private List<String> PlaceComponentResult;

    public DependencyMatcher(String str, List<String> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = list;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        if (obj != null && (obj instanceof String)) {
            return this.PlaceComponentResult.contains(evaluator.getTreatment((String) obj, str, this.KClassImpl$Data$declaredNonStaticMembers$2, map).getTreatment());
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("in split \"");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("\" treatment ");
        sb.append(this.PlaceComponentResult);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DependencyMatcher dependencyMatcher = (DependencyMatcher) obj;
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str == null ? dependencyMatcher.KClassImpl$Data$declaredNonStaticMembers$2 == null : str.equals(dependencyMatcher.KClassImpl$Data$declaredNonStaticMembers$2)) {
            List<String> list = this.PlaceComponentResult;
            List<String> list2 = dependencyMatcher.PlaceComponentResult;
            return list != null ? list.equals(list2) : list2 == null;
        }
        return false;
    }

    public int hashCode() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = str != null ? str.hashCode() : 0;
        List<String> list = this.PlaceComponentResult;
        return (hashCode * 31) + (list != null ? list.hashCode() : 0);
    }
}
