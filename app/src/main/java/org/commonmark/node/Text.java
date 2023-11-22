package org.commonmark.node;

/* loaded from: classes6.dex */
public class Text extends Node {
    public String PlaceComponentResult;

    public Text() {
    }

    public Text(String str) {
        this.PlaceComponentResult = str;
    }

    @Override // org.commonmark.node.Node
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Visitor visitor) {
        visitor.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // org.commonmark.node.Node
    protected final String BuiltInFictitiousFunctionClassFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append("literal=");
        sb.append(this.PlaceComponentResult);
        return sb.toString();
    }
}
