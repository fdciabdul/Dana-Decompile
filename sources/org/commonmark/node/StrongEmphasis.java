package org.commonmark.node;

/* loaded from: classes6.dex */
public class StrongEmphasis extends Node implements Delimited {
    private String PlaceComponentResult;

    public StrongEmphasis() {
    }

    public StrongEmphasis(String str) {
        this.PlaceComponentResult = str;
    }

    @Override // org.commonmark.node.Node
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Visitor visitor) {
        visitor.MyBillsEntityDataFactory(this);
    }
}
