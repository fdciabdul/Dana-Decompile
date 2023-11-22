package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public final class WorkInfo {
    private UUID BuiltInFictitiousFunctionClassFactory;
    public State KClassImpl$Data$declaredNonStaticMembers$2;
    public Data MyBillsEntityDataFactory;
    public Set<String> PlaceComponentResult;
    private Data getAuthRequestContext;
    private int moveToNextValue;

    public WorkInfo(UUID uuid, State state, Data data, List<String> list, Data data2, int i) {
        this.BuiltInFictitiousFunctionClassFactory = uuid;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = state;
        this.getAuthRequestContext = data;
        this.PlaceComponentResult = new HashSet(list);
        this.MyBillsEntityDataFactory = data2;
        this.moveToNextValue = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.moveToNextValue == workInfo.moveToNextValue && this.BuiltInFictitiousFunctionClassFactory.equals(workInfo.BuiltInFictitiousFunctionClassFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2 == workInfo.KClassImpl$Data$declaredNonStaticMembers$2 && this.getAuthRequestContext.equals(workInfo.getAuthRequestContext) && this.PlaceComponentResult.equals(workInfo.PlaceComponentResult)) {
            return this.MyBillsEntityDataFactory.equals(workInfo.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode2 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode3 = this.getAuthRequestContext.hashCode();
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.moveToNextValue;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WorkInfo{mId='");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('\'');
        sb.append(", mState=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", mOutputData=");
        sb.append(this.getAuthRequestContext);
        sb.append(", mTags=");
        sb.append(this.PlaceComponentResult);
        sb.append(", mProgress=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('}');
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public final boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }
}
