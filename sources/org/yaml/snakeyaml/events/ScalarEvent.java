package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event;

/* loaded from: classes6.dex */
public final class ScalarEvent extends NodeEvent {
    public final DumperOptions.ScalarStyle KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImplicitTuple MyBillsEntityDataFactory;
    public final String getAuthRequestContext;
    public final String getErrorConfigVersion;

    public ScalarEvent(String str, String str2, ImplicitTuple implicitTuple, String str3, Mark mark, Mark mark2, DumperOptions.ScalarStyle scalarStyle) {
        super(str, mark, mark2);
        this.getAuthRequestContext = str2;
        this.MyBillsEntityDataFactory = implicitTuple;
        if (str3 == null) {
            throw new NullPointerException("Value must be provided.");
        }
        this.getErrorConfigVersion = str3;
        if (scalarStyle == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = scalarStyle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.yaml.snakeyaml.events.NodeEvent, org.yaml.snakeyaml.events.Event
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.KClassImpl$Data$declaredNonStaticMembers$2());
        sb.append(", tag=");
        sb.append(this.getAuthRequestContext);
        sb.append(", ");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", value=");
        sb.append(this.getErrorConfigVersion);
        return sb.toString();
    }

    @Override // org.yaml.snakeyaml.events.Event
    public final Event.ID BuiltInFictitiousFunctionClassFactory() {
        return Event.ID.Scalar;
    }
}
