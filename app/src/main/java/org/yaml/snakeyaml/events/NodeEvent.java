package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
public abstract class NodeEvent extends Event {
    public final String BuiltInFictitiousFunctionClassFactory;

    public NodeEvent(String str, Mark mark, Mark mark2) {
        super(mark, mark2);
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.yaml.snakeyaml.events.Event
    public String KClassImpl$Data$declaredNonStaticMembers$2() {
        StringBuilder sb = new StringBuilder();
        sb.append("anchor=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        return sb.toString();
    }
}
