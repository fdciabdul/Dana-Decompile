package org.commonmark.node;

/* loaded from: classes6.dex */
public class Image extends Node {
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;

    public Image() {
    }

    public Image(String str, String str2) {
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = str2;
    }

    @Override // org.commonmark.node.Node
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Visitor visitor) {
        visitor.getAuthRequestContext(this);
    }

    @Override // org.commonmark.node.Node
    protected final String BuiltInFictitiousFunctionClassFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append("destination=");
        sb.append(this.PlaceComponentResult);
        sb.append(", title=");
        sb.append(this.MyBillsEntityDataFactory);
        return sb.toString();
    }
}
