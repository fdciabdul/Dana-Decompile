package id.dana.lib.gcontainer.extension;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\"\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\bH\u0086\b¢\u0006\u0004\b\n\u0010\u000b\u001a*\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\bH\u0086\b¢\u0006\u0004\b\u0010\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Lkotlin/Function1;", "Lcom/alibaba/fastjson/JSONObject;", "", "mapResult", "withFailedJSONResult", "(Lkotlin/jvm/functions/Function1;)Lcom/alibaba/fastjson/JSONObject;", "withSuccessJSONResult", "T", "Lcom/alibaba/fastjson/JSONArray;", "", "toList", "(Lcom/alibaba/fastjson/JSONArray;)Ljava/util/List;", "", "key", "toObject", "(Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;)Ljava/lang/Object;", "toObjectList"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class JSONExtKt {
    public static final JSONObject withSuccessJSONResult(Function1<? super JSONObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
        function1.invoke(jSONObject);
        return jSONObject;
    }

    public static final JSONObject withFailedJSONResult(Function1<? super JSONObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.FALSE);
        function1.invoke(jSONObject);
        return jSONObject;
    }

    public static final /* synthetic */ <T> List<T> toList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "");
        ArrayList arrayList = new ArrayList();
        int size = jSONArray.size();
        if (size > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object obj = jSONArray.get(i);
                Intrinsics.reifiedOperationMarker(1, "T");
                arrayList.add(obj);
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    public static /* synthetic */ Object toObject$default(JSONObject jSONObject, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(jSONObject, "");
        if (str != null) {
            try {
                jSONObject = jSONObject.getJSONObject(str);
            } catch (JSONException | NullPointerException unused) {
                return null;
            }
        }
        String jSONString = jSONObject.toJSONString();
        Intrinsics.needClassReification();
        return JSONObject.parseObject(jSONString, new JSONExtKt$toObject$1(), new Feature[0]);
    }

    public static final /* synthetic */ <T> T toObject(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        if (str != null) {
            try {
                jSONObject = jSONObject.getJSONObject(str);
            } catch (JSONException | NullPointerException unused) {
                return null;
            }
        }
        String jSONString = jSONObject.toJSONString();
        Intrinsics.needClassReification();
        return (T) JSONObject.parseObject(jSONString, new JSONExtKt$toObject$1(), new Feature[0]);
    }

    public static final /* synthetic */ <T> List<T> toObjectList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "");
        try {
            ArrayList arrayList = new ArrayList();
            int size = jSONArray.size();
            if (size <= 0) {
                return arrayList;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Object obj = null;
                if (jSONObject != null) {
                    try {
                        String jSONString = jSONObject.toJSONString();
                        Intrinsics.needClassReification();
                        obj = JSONObject.parseObject(jSONString, new TypeReference<T>() { // from class: id.dana.lib.gcontainer.extension.JSONExtKt$toObjectList$$inlined$toObject$default$1
                        }, new Feature[0]);
                    } catch (JSONException | NullPointerException unused) {
                    }
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
                if (i2 >= size) {
                    return arrayList;
                }
                i = i2;
            }
        } catch (JSONException unused2) {
            return CollectionsKt.emptyList();
        }
    }
}
