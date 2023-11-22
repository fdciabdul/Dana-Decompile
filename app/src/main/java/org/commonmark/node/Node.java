package org.commonmark.node;

/* loaded from: classes6.dex */
public abstract class Node {
    private Node KClassImpl$Data$declaredNonStaticMembers$2 = null;
    public Node getErrorConfigVersion = null;
    public Node scheduleImpl = null;
    public Node moveToNextValue = null;
    public Node NetworkUserEntityData$$ExternalSyntheticLambda0 = null;

    protected String BuiltInFictitiousFunctionClassFactory() {
        return "";
    }

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(Visitor visitor);

    public Node getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getAuthRequestContext(Node node) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = node;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Node node) {
        node.NetworkUserEntityData$$ExternalSyntheticLambda0();
        node.getAuthRequestContext(this);
        Node node2 = this.scheduleImpl;
        if (node2 != null) {
            node2.NetworkUserEntityData$$ExternalSyntheticLambda0 = node;
            node.moveToNextValue = node2;
            this.scheduleImpl = node;
            return;
        }
        this.getErrorConfigVersion = node;
        this.scheduleImpl = node;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        Node node = this.moveToNextValue;
        if (node != null) {
            node.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        } else {
            Node node2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (node2 != null) {
                node2.getErrorConfigVersion = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            }
        }
        Node node3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (node3 != null) {
            node3.moveToNextValue = node;
        } else {
            Node node4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (node4 != null) {
                node4.scheduleImpl = node;
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.moveToNextValue = null;
    }

    public final void PlaceComponentResult(Node node) {
        node.NetworkUserEntityData$$ExternalSyntheticLambda0();
        Node node2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        node.NetworkUserEntityData$$ExternalSyntheticLambda0 = node2;
        if (node2 != null) {
            node2.moveToNextValue = node;
        }
        node.moveToNextValue = this;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = node;
        Node node3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        node.KClassImpl$Data$declaredNonStaticMembers$2 = node3;
        if (node.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            node3.scheduleImpl = node;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(BuiltInFictitiousFunctionClassFactory());
        sb.append("}");
        return sb.toString();
    }
}
