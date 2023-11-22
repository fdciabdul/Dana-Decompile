package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class CLContainer extends CLElement {
    ArrayList<CLElement> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<CLElement> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            CLElement next = it.next();
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(next);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" = <");
        sb2.append((Object) sb);
        sb2.append(" >");
        return sb2.toString();
    }
}
