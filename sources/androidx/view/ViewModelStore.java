package androidx.view;

import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ViewModelStore {
    final HashMap<String, ViewModel> BuiltInFictitiousFunctionClassFactory = new HashMap<>();

    public final void PlaceComponentResult() {
        Iterator<ViewModel> it = this.BuiltInFictitiousFunctionClassFactory.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.BuiltInFictitiousFunctionClassFactory.clear();
    }
}
