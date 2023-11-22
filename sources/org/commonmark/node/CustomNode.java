package org.commonmark.node;

/* loaded from: classes6.dex */
public abstract class CustomNode extends Node {
    @Override // org.commonmark.node.Node
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Visitor visitor) {
        visitor.getAuthRequestContext(this);
    }
}
