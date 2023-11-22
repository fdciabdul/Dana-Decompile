package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import java.util.Map;

/* loaded from: classes6.dex */
public final class AttributeMatcher {
    private final String BuiltInFictitiousFunctionClassFactory;
    private final Matcher getAuthRequestContext;

    public AttributeMatcher(String str, Matcher matcher, boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = new NegatableMatcher(matcher, z);
    }

    public final boolean getAuthRequestContext(String str, String str2, Map<String, Object> map, Evaluator evaluator) {
        Object obj;
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        if (str3 == null) {
            return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, map, evaluator);
        }
        if (map == null || (obj = map.get(str3)) == null) {
            return false;
        }
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(obj, str2, null, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AttributeMatcher attributeMatcher = (AttributeMatcher) obj;
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str == null ? attributeMatcher.BuiltInFictitiousFunctionClassFactory == null : str.equals(attributeMatcher.BuiltInFictitiousFunctionClassFactory)) {
            return this.getAuthRequestContext.equals(attributeMatcher.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        return ((str != null ? str.hashCode() : 0) * 31) + this.getAuthRequestContext.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("key");
        if (this.BuiltInFictitiousFunctionClassFactory != null) {
            sb.append(".");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
        }
        sb.append(" is");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    public static final class NegatableMatcher implements Matcher {
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final Matcher PlaceComponentResult;

        public NegatableMatcher(Matcher matcher, boolean z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.PlaceComponentResult = matcher;
        }

        @Override // io.split.android.engine.matchers.Matcher
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 != this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(obj, str, map, evaluator);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                sb.append(" not");
            }
            sb.append(" ");
            sb.append(this.PlaceComponentResult);
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            NegatableMatcher negatableMatcher = (NegatableMatcher) obj;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != negatableMatcher.KClassImpl$Data$declaredNonStaticMembers$2) {
                return false;
            }
            return this.PlaceComponentResult.equals(negatableMatcher.PlaceComponentResult);
        }

        public final int hashCode() {
            return ((this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0) * 31) + this.PlaceComponentResult.hashCode();
        }
    }
}
