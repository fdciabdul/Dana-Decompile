package androidx.work;

import androidx.work.Data;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class OverwritingInputMerger extends InputMerger {
    @Override // androidx.work.InputMerger
    public final Data PlaceComponentResult(List<Data> list) {
        Data.Builder builder = new Data.Builder();
        HashMap hashMap = new HashMap();
        Iterator<Data> it = list.iterator();
        while (it.hasNext()) {
            hashMap.putAll(Collections.unmodifiableMap(it.next().MyBillsEntityDataFactory));
        }
        builder.BuiltInFictitiousFunctionClassFactory(hashMap);
        Data data = new Data(builder.MyBillsEntityDataFactory);
        Data.getAuthRequestContext(data);
        return data;
    }
}
