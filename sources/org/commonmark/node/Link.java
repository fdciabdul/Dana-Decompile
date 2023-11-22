package org.commonmark.node;

/* loaded from: classes6.dex */
public class Link extends Node {
    public String BuiltInFictitiousFunctionClassFactory;
    public String PlaceComponentResult;

    public Link() {
    }

    public Link(String str, String str2) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = str2;
    }

    @Override // org.commonmark.node.Node
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Visitor visitor) {
        visitor.KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Override // org.commonmark.node.Node
    protected final String BuiltInFictitiousFunctionClassFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append("destination=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", title=");
        sb.append(this.PlaceComponentResult);
        return sb.toString();
    }
}
