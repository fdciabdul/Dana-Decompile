package org.commonmark.node;

/* loaded from: classes6.dex */
public abstract class Block extends Node {
    public final Block MyBillsEntityDataFactory() {
        return (Block) super.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.commonmark.node.Node
    public final void getAuthRequestContext(Node node) {
        if (!(node instanceof Block)) {
            throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
        }
        super.getAuthRequestContext(node);
    }

    @Override // org.commonmark.node.Node
    public final /* bridge */ /* synthetic */ Node getAuthRequestContext() {
        return (Block) super.getAuthRequestContext();
    }
}
