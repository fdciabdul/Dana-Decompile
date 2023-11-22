package id.dana.domain.extension;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0004"}, d2 = {"Lcom/alibaba/fastjson/JSONArray;", "", "Lcom/alibaba/fastjson/JSONObject;", "toMutableListOfJSONObject", "(Lcom/alibaba/fastjson/JSONArray;)Ljava/util/List;", "", "toMutableListOfString"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JSONArrayExtKt {
    public static final List<String> toMutableListOfString(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "");
        int size = jSONArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static final List<JSONObject> toMutableListOfJSONObject(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "");
        int size = jSONArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(jSONArray.getJSONObject(i));
        }
        return arrayList;
    }
}
