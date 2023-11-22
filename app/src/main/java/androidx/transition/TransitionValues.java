package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TransitionValues {
    public View MyBillsEntityDataFactory;
    public final Map<String, Object> getAuthRequestContext = new HashMap();
    final ArrayList<Transition> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public TransitionValues(View view) {
        this.MyBillsEntityDataFactory = view;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            return this.MyBillsEntityDataFactory == transitionValues.MyBillsEntityDataFactory && this.getAuthRequestContext.equals(transitionValues.getAuthRequestContext);
        }
        return false;
    }

    public int hashCode() {
        return (this.MyBillsEntityDataFactory.hashCode() * 31) + this.getAuthRequestContext.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransitionValues@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(":\n");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append("    view = ");
        sb2.append(this.MyBillsEntityDataFactory);
        sb2.append("\n");
        String obj2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj2);
        sb3.append("    values:");
        String obj3 = sb3.toString();
        for (String str : this.getAuthRequestContext.keySet()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj3);
            sb4.append("    ");
            sb4.append(str);
            sb4.append(": ");
            sb4.append(this.getAuthRequestContext.get(str));
            sb4.append("\n");
            obj3 = sb4.toString();
        }
        return obj3;
    }
}
