package id.dana.utils.extension;

import android.os.Bundle;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\u001aP\u0010\u0004\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\u000726\u0010\b\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\tH\u0086\bø\u0001\u0000\u001a\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u001a\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u001a\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u00010\u0010H\u0086\b¢\u0006\u0002\u0010\u0017\u001a\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u0007\u001a\n\u0010\u001b\u001a\u00020\u0014*\u00020\u0012\u001a\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019*\u00020\u0007\u001a\u0010\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0019*\u00020\u0007\u001a\u0010\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0019*\u00020\u0007\u001a/\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H#0\"\"\u0006\b\u0000\u0010#\u0018\u0001*\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0086\b\u001a/\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H#0\"\"\u0006\b\u0000\u0010#\u0018\u0001*\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0086\b\u001a*\u0010$\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u00010%2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0086\b¢\u0006\u0002\u0010&\u001a*\u0010$\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0086\b¢\u0006\u0002\u0010'\u001a*\u0010$\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0086\b¢\u0006\u0002\u0010(\u001a\u001f\u0010)\u001a\n\u0012\u0004\u0012\u0002H\u0016\u0018\u00010\u0019\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u0004\u0018\u00010\u0010H\u0086\b\u001a\u0010\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019*\u00020\u0010\u001a\u0010\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100+*\u00020\u0007\u001a$\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\"*\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u001a$\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\"*\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, d2 = {"gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "forEach", "", "E", "Lorg/json/JSONArray;", "action", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", LottieParams.KEY_ELEMENT_ID, "getStringJson", "", "key", "Lorg/json/JSONObject;", "removeString", "Landroid/os/Bundle;", "stringJsonToDataClass", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "toBooleanList", "", "", "toBundle", "toDoubleList", "", "toIntList", "toLongList", "", "toMap", "", "V", "toSerializedJson", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Object;", "toSerializedListJson", "toStringList", "", "toStringMap", "core-utils_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JSONExtKt {
    private static final Gson getAuthRequestContext = new Gson();

    @JvmName(name = "getGson")
    public static final Gson PlaceComponentResult() {
        return getAuthRequestContext;
    }

    public static final List<String> KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2(new JSONArray(str));
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    public static final List<String> KClassImpl$Data$declaredNonStaticMembers$2(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "");
            arrayList.add(string);
        }
        CollectionsKt.removeAll((List) arrayList, (Function1) new Function1<String, Boolean>() { // from class: id.dana.utils.extension.JSONExtKt$toStringList$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return Boolean.valueOf(Intrinsics.areEqual(str, "null"));
            }
        });
        return arrayList;
    }

    public static final String getAuthRequestContext(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        try {
            Intrinsics.checkNotNull(str);
            return new JSONObject(str).toString();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            Object parseObject = JSON.parseObject(KClassImpl$Data$declaredNonStaticMembers$2(str, null), new TypeReference<Map<String, ? extends String>>() { // from class: id.dana.utils.extension.JSONExtKt$toStringMap$2
            }, new Feature[0]);
            Intrinsics.checkNotNullExpressionValue(parseObject, "");
            return (Map) parseObject;
        } catch (Exception unused) {
            return MapsKt.emptyMap();
        }
    }

    public static final Bundle KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Bundle bundle = new Bundle(jSONObject.length());
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "");
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null && !Intrinsics.areEqual(opt.toString(), "null")) {
                if (opt instanceof Integer) {
                    bundle.putInt(next, ((Number) opt).intValue());
                } else if (opt instanceof Long) {
                    bundle.putLong(next, ((Number) opt).longValue());
                } else if (opt instanceof Double) {
                    bundle.putDouble(next, ((Number) opt).doubleValue());
                } else if (opt instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) opt).booleanValue());
                } else if (!(opt instanceof JSONArray)) {
                    bundle.putString(next, opt.toString());
                } else if (((JSONArray) opt).length() > 0) {
                    try {
                        int i = 0;
                        Object opt2 = ((JSONArray) opt).opt(0);
                        if (!(opt2 instanceof Integer)) {
                            if (!(opt2 instanceof Long)) {
                                if (!(opt2 instanceof Double)) {
                                    if (!(opt2 instanceof Boolean)) {
                                        Object[] array = KClassImpl$Data$declaredNonStaticMembers$2((JSONArray) opt).toArray(new String[0]);
                                        if (array != null) {
                                            bundle.putStringArray(next, (String[]) array);
                                        } else {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                            break;
                                        }
                                    } else {
                                        JSONArray jSONArray = (JSONArray) opt;
                                        Intrinsics.checkNotNullParameter(jSONArray, "");
                                        ArrayList arrayList = new ArrayList();
                                        int length = jSONArray.length();
                                        while (i < length) {
                                            arrayList.add(Boolean.valueOf(jSONArray.getBoolean(i)));
                                            i++;
                                        }
                                        bundle.putBooleanArray(next, CollectionsKt.toBooleanArray(arrayList));
                                    }
                                } else {
                                    JSONArray jSONArray2 = (JSONArray) opt;
                                    Intrinsics.checkNotNullParameter(jSONArray2, "");
                                    ArrayList arrayList2 = new ArrayList();
                                    int length2 = jSONArray2.length();
                                    while (i < length2) {
                                        arrayList2.add(Double.valueOf(jSONArray2.getDouble(i)));
                                        i++;
                                    }
                                    bundle.putDoubleArray(next, CollectionsKt.toDoubleArray(arrayList2));
                                }
                            } else {
                                JSONArray jSONArray3 = (JSONArray) opt;
                                Intrinsics.checkNotNullParameter(jSONArray3, "");
                                ArrayList arrayList3 = new ArrayList();
                                int length3 = jSONArray3.length();
                                while (i < length3) {
                                    arrayList3.add(Long.valueOf(jSONArray3.getLong(i)));
                                    i++;
                                }
                                bundle.putLongArray(next, CollectionsKt.toLongArray(arrayList3));
                            }
                        } else {
                            JSONArray jSONArray4 = (JSONArray) opt;
                            Intrinsics.checkNotNullParameter(jSONArray4, "");
                            ArrayList arrayList4 = new ArrayList();
                            int length4 = jSONArray4.length();
                            while (i < length4) {
                                arrayList4.add(Integer.valueOf(jSONArray4.getInt(i)));
                                i++;
                            }
                            bundle.putIntArray(next, CollectionsKt.toIntArray(arrayList4));
                        }
                    } catch (JSONException unused) {
                    }
                } else {
                    continue;
                }
            }
        }
        return bundle;
    }

    public static final String BuiltInFictitiousFunctionClassFactory(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(str, "");
        try {
            return bundle.getString(str);
        } finally {
            bundle.remove(str);
        }
    }
}
