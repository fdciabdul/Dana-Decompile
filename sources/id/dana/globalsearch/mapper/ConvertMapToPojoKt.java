package id.dana.globalsearch.mapper;

import com.google.gson.JsonElement;
import id.dana.globalsearch.dfrestaurant.model.RestaurantInfoModel;
import id.dana.globalsearch.service.model.ServiceInfoModel;
import id.dana.utils.extension.JSONExtKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001d\u0010\t\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\f\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "T", "", "", "Ljava/lang/Class;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;", "Lid/dana/globalsearch/dfrestaurant/model/RestaurantInfoModel;", "getAuthRequestContext", "(Ljava/util/Map;)Lid/dana/globalsearch/dfrestaurant/model/RestaurantInfoModel;", "Lid/dana/globalsearch/service/model/ServiceInfoModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Map;)Lid/dana/globalsearch/service/model/ServiceInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConvertMapToPojoKt {
    public static final RestaurantInfoModel getAuthRequestContext(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        JsonElement jsonTree = JSONExtKt.PlaceComponentResult().toJsonTree(map);
        Intrinsics.checkNotNullExpressionValue(jsonTree, "");
        Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(jsonTree, (Class<Object>) RestaurantInfoModel.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "");
        return (RestaurantInfoModel) fromJson;
    }

    public static final ServiceInfoModel BuiltInFictitiousFunctionClassFactory(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        JsonElement jsonTree = JSONExtKt.PlaceComponentResult().toJsonTree(map);
        Intrinsics.checkNotNullExpressionValue(jsonTree, "");
        Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(jsonTree, (Class<Object>) ServiceInfoModel.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "");
        return (ServiceInfoModel) fromJson;
    }

    public static final <T> T KClassImpl$Data$declaredNonStaticMembers$2(Map<String, ? extends Object> map, Class<T> cls) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(cls, "");
        JsonElement jsonTree = JSONExtKt.PlaceComponentResult().toJsonTree(map);
        Intrinsics.checkNotNullExpressionValue(jsonTree, "");
        T t = (T) JSONExtKt.PlaceComponentResult().fromJson(jsonTree, (Class) cls);
        Intrinsics.checkNotNullExpressionValue(t, "");
        return t;
    }
}
