package io.split.android.engine.matchers.strings;

import io.split.android.client.Evaluator;
import io.split.android.engine.matchers.Matcher;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class RegularExpressionMatcher implements Matcher {
    private String BuiltInFictitiousFunctionClassFactory;
    private Pattern PlaceComponentResult;

    public RegularExpressionMatcher(String str) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = Pattern.compile(str);
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        if (obj != null && (obj instanceof String)) {
            return this.PlaceComponentResult.matcher((String) obj).find();
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("matches ");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.BuiltInFictitiousFunctionClassFactory;
        String str2 = ((RegularExpressionMatcher) obj).BuiltInFictitiousFunctionClassFactory;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
