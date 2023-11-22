package org.yaml.snakeyaml.nodes;

import java.util.List;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes6.dex */
public abstract class Node {
    public boolean DatabaseTableConfigUtil;
    protected Boolean GetContactSyncConfig;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Class<? extends Object> NetworkUserEntityData$$ExternalSyntheticLambda1;
    public Tag NetworkUserEntityData$$ExternalSyntheticLambda2;
    public String getAuthRequestContext;
    public List<CommentLine> getErrorConfigVersion;
    public final Mark initRecordTimeStamp;
    protected Mark lookAheadTest;
    public List<CommentLine> moveToNextValue;
    public List<CommentLine> scheduleImpl;

    public abstract NodeId KClassImpl$Data$declaredNonStaticMembers$2();

    public Node(Tag tag, Mark mark, Mark mark2) {
        if (tag == null) {
            throw new NullPointerException("tag in a Node is required.");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = tag;
        this.initRecordTimeStamp = mark;
        this.lookAheadTest = mark2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Object.class;
        this.DatabaseTableConfigUtil = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.GetContactSyncConfig = null;
        this.moveToNextValue = null;
        this.scheduleImpl = null;
        this.getErrorConfigVersion = null;
    }

    public final Mark BuiltInFictitiousFunctionClassFactory() {
        return this.lookAheadTest;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.DatabaseTableConfigUtil;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean moveToNextValue() {
        Boolean bool = this.GetContactSyncConfig;
        if (bool == null) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult() || !this.NetworkUserEntityData$$ExternalSyntheticLambda0 || Object.class.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda1) || this.NetworkUserEntityData$$ExternalSyntheticLambda2.equals(Tag.moveToNextValue)) {
                return this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
            return true;
        }
        return bool.booleanValue();
    }

    public final void MyBillsEntityDataFactory(Boolean bool) {
        this.GetContactSyncConfig = bool;
    }
}
