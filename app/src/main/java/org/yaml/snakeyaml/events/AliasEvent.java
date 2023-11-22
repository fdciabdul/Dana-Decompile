package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes6.dex */
public final class AliasEvent extends NodeEvent {
    public AliasEvent(String str, Mark mark, Mark mark2) {
        super(str, mark, mark2);
        if (str == null) {
            throw new NullPointerException("anchor is not specified for alias");
        }
    }

    @Override // org.yaml.snakeyaml.events.Event
    public final Event.ID BuiltInFictitiousFunctionClassFactory() {
        return Event.ID.Alias;
    }
}
