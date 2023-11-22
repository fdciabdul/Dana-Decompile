package org.yaml.snakeyaml.events;

import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes6.dex */
public final class DocumentStartEvent extends Event {
    private final DumperOptions.Version BuiltInFictitiousFunctionClassFactory;
    private final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2;
    private final boolean getAuthRequestContext;

    public DocumentStartEvent(Mark mark, Mark mark2, boolean z, DumperOptions.Version version, Map<String, String> map) {
        super(mark, mark2);
        this.getAuthRequestContext = z;
        this.BuiltInFictitiousFunctionClassFactory = version;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
    }

    @Override // org.yaml.snakeyaml.events.Event
    public final Event.ID BuiltInFictitiousFunctionClassFactory() {
        return Event.ID.DocumentStart;
    }
}
