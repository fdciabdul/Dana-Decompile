package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class LayoutState {
    int KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean PlaceComponentResult;
    int getAuthRequestContext;
    boolean lookAheadTest;
    boolean getErrorConfigVersion = true;
    int scheduleImpl = 0;
    int BuiltInFictitiousFunctionClassFactory = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(RecyclerView.State state) {
        int i;
        int i2 = this.MyBillsEntityDataFactory;
        if (i2 >= 0) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (i2 < i) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LayoutState{mAvailable=");
        sb.append(this.getAuthRequestContext);
        sb.append(", mCurrentPosition=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", mItemDirection=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", mLayoutDirection=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", mStartLine=");
        sb.append(this.scheduleImpl);
        sb.append(", mEndLine=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('}');
        return sb.toString();
    }
}
