package androidx.constraintlayout.core.motion.utils;

import java.util.HashMap;

/* loaded from: classes3.dex */
public class KeyCache {
    public HashMap<Object, HashMap<String, float[]>> MyBillsEntityDataFactory = new HashMap<>();

    public final float BuiltInFictitiousFunctionClassFactory(Object obj, String str) {
        HashMap<String, float[]> hashMap;
        float[] fArr;
        if (this.MyBillsEntityDataFactory.containsKey(obj) && (hashMap = this.MyBillsEntityDataFactory.get(obj)) != null && hashMap.containsKey(str) && (fArr = hashMap.get(str)) != null && fArr.length > 0) {
            return fArr[0];
        }
        return Float.NaN;
    }
}
