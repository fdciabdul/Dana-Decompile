package org.yaml.snakeyaml.resolver;

import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes6.dex */
final class ResolverTuple {
    final Tag MyBillsEntityDataFactory;
    final Pattern PlaceComponentResult;
    final int getAuthRequestContext;

    public ResolverTuple(Tag tag, Pattern pattern, int i) {
        this.MyBillsEntityDataFactory = tag;
        this.PlaceComponentResult = pattern;
        this.getAuthRequestContext = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tuple tag=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(" regexp=");
        sb.append(this.PlaceComponentResult);
        sb.append(" limit=");
        sb.append(this.getAuthRequestContext);
        return sb.toString();
    }
}
