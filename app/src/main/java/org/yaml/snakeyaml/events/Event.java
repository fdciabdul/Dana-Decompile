package org.yaml.snakeyaml.events;

import com.j256.ormlite.stmt.query.SimpleComparison;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
public abstract class Event {
    public final Mark PlaceComponentResult;
    public final Mark scheduleImpl;

    /* loaded from: classes6.dex */
    public enum ID {
        Alias,
        Comment,
        DocumentEnd,
        DocumentStart,
        MappingEnd,
        MappingStart,
        Scalar,
        SequenceEnd,
        SequenceStart,
        StreamEnd,
        StreamStart
    }

    public abstract ID BuiltInFictitiousFunctionClassFactory();

    /* JADX INFO: Access modifiers changed from: protected */
    public String KClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    public Event(Mark mark, Mark mark2) {
        this.scheduleImpl = mark;
        this.PlaceComponentResult = mark2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(getClass().getName());
        sb.append("(");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2());
        sb.append(")>");
        return sb.toString();
    }

    public final boolean getAuthRequestContext(ID id2) {
        return BuiltInFictitiousFunctionClassFactory() == id2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
