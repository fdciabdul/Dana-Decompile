package org.commonmark.node;

/* loaded from: classes6.dex */
public class Emphasis extends Node implements Delimited {
    private String getAuthRequestContext;

    public Emphasis() {
    }

    public Emphasis(String str) {
        this.getAuthRequestContext = str;
    }

    @Override // org.commonmark.node.Node
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Visitor visitor) {
        visitor.PlaceComponentResult(this);
    }
}
