package id.dana.data.toggle.traffictype;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.gson.Gson;
import id.dana.utils.extension.JSONExtKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "", "key", BridgeDSL.INVOKE, "(Ljava/lang/String;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes2.dex */
public final class BaseTrafficType$getDefaultValue$1<T> extends Lambda implements Function1<String, T> {
    final /* synthetic */ Map<String, T> $$defaultMapValue;
    final /* synthetic */ T $$defaultValue;
    final /* synthetic */ BaseTrafficType this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseTrafficType$getDefaultValue$1(Map<String, ? extends T> map, BaseTrafficType baseTrafficType, T t) {
        super(1);
        this.$$defaultMapValue = map;
        this.this$0 = baseTrafficType;
        this.$$defaultValue = t;
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Map<String, T> map = this.$$defaultMapValue;
        if (!((map.isEmpty() ^ true) && map.containsKey(str))) {
            map = null;
        }
        if (map != null) {
            String json = JSONExtKt.PlaceComponentResult().toJson(map.get(str));
            if (json == null) {
                json = JSONExtKt.PlaceComponentResult().toJson(map);
            }
            Gson PlaceComponentResult = JSONExtKt.PlaceComponentResult();
            Intrinsics.reifiedOperationMarker(4, "T");
            T t = (T) PlaceComponentResult.fromJson(json, (Class) Object.class);
            if (t != null) {
                return t;
            }
        }
        BaseTrafficType baseTrafficType = this.this$0;
        return this.$$defaultValue;
    }
}
