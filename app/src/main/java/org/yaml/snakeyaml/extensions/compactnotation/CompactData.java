package org.yaml.snakeyaml.extensions.compactnotation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes9.dex */
public class CompactData {
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    final List<String> PlaceComponentResult = new ArrayList();
    final Map<String, String> getAuthRequestContext = new HashMap();

    public CompactData(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompactData: ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(" ");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }
}
