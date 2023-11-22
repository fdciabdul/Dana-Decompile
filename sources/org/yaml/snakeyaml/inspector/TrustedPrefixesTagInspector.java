package org.yaml.snakeyaml.inspector;

import java.util.Iterator;
import java.util.List;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes9.dex */
public final class TrustedPrefixesTagInspector implements TagInspector {
    private final List<String> BuiltInFictitiousFunctionClassFactory;

    @Override // org.yaml.snakeyaml.inspector.TagInspector
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Tag tag) {
        Iterator<String> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            if (tag.MyBillsEntityDataFactory().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }
}
