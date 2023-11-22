package id.dana.data.toggle.traffictype;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.util.ConfigUtil;
import id.dana.domain.extension.MapExtKt;
import id.dana.lib.toggle.RawResultsCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.lib.toggle.result.RawResult;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u00012(\u0010\u0004\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"T", "Lio/reactivex/ObservableEmitter;", "", "", "p0", "", "subscribe", "(Lio/reactivex/ObservableEmitter;)V"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes4.dex */
public final class BaseTrafficType$getConfigsOnceReady$1<T> implements ObservableOnSubscribe {
    final /* synthetic */ List<String> $BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ String $MyBillsEntityDataFactory;
    final /* synthetic */ boolean $PlaceComponentResult;
    final /* synthetic */ boolean $getAuthRequestContext;
    final /* synthetic */ BaseTrafficType KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(final ObservableEmitter<Map<String, T>> observableEmitter) {
        Map emptyMap;
        final Object obj;
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        String PlaceComponentResult = JsonUtil.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, this.$MyBillsEntityDataFactory);
        try {
            Gson PlaceComponentResult2 = JSONExtKt.PlaceComponentResult();
            String KClassImpl$Data$declaredNonStaticMembers$2 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, null);
            Intrinsics.needClassReification();
            Object fromJson = PlaceComponentResult2.fromJson(KClassImpl$Data$declaredNonStaticMembers$2, new TypeToken<Map<String, ? extends T>>() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$getConfigsOnceReady$1$subscribe$$inlined$toMap$default$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "");
            emptyMap = (Map) fromJson;
        } catch (Exception unused) {
            emptyMap = MapsKt.emptyMap();
        }
        final Map map = emptyMap;
        String PlaceComponentResult3 = JsonUtil.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, this.$MyBillsEntityDataFactory);
        try {
            Gson PlaceComponentResult4 = JSONExtKt.PlaceComponentResult();
            String KClassImpl$Data$declaredNonStaticMembers$22 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3, null);
            Intrinsics.reifiedOperationMarker(4, "T");
            obj = PlaceComponentResult4.fromJson(KClassImpl$Data$declaredNonStaticMembers$22, (Class<Object>) Object.class);
        } catch (Exception unused2) {
            obj = null;
        }
        List<String> list = this.$BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(TuplesKt.to((String) it.next(), null));
        }
        final Map mutableMap = MapsKt.toMutableMap(MapsKt.toMap(arrayList));
        ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
        List<String> list2 = this.$BuiltInFictitiousFunctionClassFactory;
        String BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.needClassReification();
        final BaseTrafficType baseTrafficType = this.KClassImpl$Data$declaredNonStaticMembers$2;
        final boolean z = this.$PlaceComponentResult;
        final boolean z2 = this.$getAuthRequestContext;
        final List<String> list3 = this.$BuiltInFictitiousFunctionClassFactory;
        MyBillsEntityDataFactory.PlaceComponentResult(list2, BuiltInFictitiousFunctionClassFactory, new RawResultsCallback() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$getConfigsOnceReady$1.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // id.dana.lib.toggle.RawResultsCallback
            public final void onComplete(Map<String, ? extends RawResult> p0) {
                Object obj2;
                Unit unit = null;
                if (p0 != null) {
                    ObservableEmitter<Map<String, T>> observableEmitter2 = observableEmitter;
                    Map<String, T> map2 = mutableMap;
                    final BaseTrafficType baseTrafficType2 = baseTrafficType;
                    boolean z3 = z;
                    final Map<String, T> map3 = map;
                    final T t = obj;
                    boolean z4 = z2;
                    for (Map.Entry<String, ? extends RawResult> entry : p0.entrySet()) {
                        final String key = entry.getKey();
                        RawResult value = entry.getValue();
                        if (Intrinsics.areEqual(value.getAuthRequestContext, "control")) {
                            if (!z3) {
                                Intrinsics.needClassReification();
                                T invoke = new Function1<String, T>() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$getConfigsOnceReady$1$1$onComplete$lambda-1$lambda-0$$inlined$mapResultConfigs$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final T invoke(String str) {
                                        Intrinsics.checkNotNullParameter(str, "");
                                        Map map4 = map3;
                                        if (!((map4.isEmpty() ^ true) && map4.containsKey(str))) {
                                            map4 = null;
                                        }
                                        if (map4 != null) {
                                            String json = JSONExtKt.PlaceComponentResult().toJson(map4.get(str));
                                            if (json == null) {
                                                json = JSONExtKt.PlaceComponentResult().toJson(map4);
                                            }
                                            Gson PlaceComponentResult5 = JSONExtKt.PlaceComponentResult();
                                            Intrinsics.reifiedOperationMarker(4, "T");
                                            T t2 = (T) PlaceComponentResult5.fromJson(json, (Class) Object.class);
                                            if (t2 != null) {
                                                return t2;
                                            }
                                        }
                                        BaseTrafficType baseTrafficType3 = baseTrafficType2;
                                        return (T) t;
                                    }
                                }.invoke(key);
                                if (invoke != null) {
                                    map2.put(key, invoke);
                                }
                            } else {
                                ConfigUtil configUtil = ConfigUtil.INSTANCE;
                                Intrinsics.needClassReification();
                                T invoke2 = new Function1<String, T>() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$getConfigsOnceReady$1$1$onComplete$lambda-1$lambda-0$$inlined$mapResultConfigs$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final T invoke(String str) {
                                        String jSONObject;
                                        Intrinsics.checkNotNullParameter(str, "");
                                        JSONObject jSONConfig = ConfigCenter.getInstance().getJSONConfig(str);
                                        if (jSONConfig != null && (jSONObject = jSONConfig.toString()) != null) {
                                            T t2 = null;
                                            try {
                                                Gson PlaceComponentResult5 = JSONExtKt.PlaceComponentResult();
                                                String KClassImpl$Data$declaredNonStaticMembers$23 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject, null);
                                                Intrinsics.reifiedOperationMarker(4, "T?");
                                                t2 = (T) PlaceComponentResult5.fromJson(KClassImpl$Data$declaredNonStaticMembers$23, (Class) Object.class);
                                            } catch (Exception unused3) {
                                            }
                                            if (t2 != null) {
                                                return t2;
                                            }
                                        }
                                        ConfigUtil configUtil2 = ConfigUtil.INSTANCE;
                                        final BaseTrafficType baseTrafficType3 = BaseTrafficType.this;
                                        Intrinsics.needClassReification();
                                        final Map map4 = map3;
                                        final Object obj3 = t;
                                        return new Function1<String, T>() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$getConfigsOnceReady$1$1$onComplete$lambda-1$lambda-0$$inlined$mapResultConfigs$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final T invoke(String str2) {
                                                Intrinsics.checkNotNullParameter(str2, "");
                                                Map map5 = map4;
                                                if (!((map5.isEmpty() ^ true) && map5.containsKey(str2))) {
                                                    map5 = null;
                                                }
                                                if (map5 != null) {
                                                    String json = JSONExtKt.PlaceComponentResult().toJson(map5.get(str2));
                                                    if (json == null) {
                                                        json = JSONExtKt.PlaceComponentResult().toJson(map5);
                                                    }
                                                    Gson PlaceComponentResult6 = JSONExtKt.PlaceComponentResult();
                                                    Intrinsics.reifiedOperationMarker(4, "T");
                                                    T t3 = (T) PlaceComponentResult6.fromJson(json, (Class) Object.class);
                                                    if (t3 != null) {
                                                        return t3;
                                                    }
                                                }
                                                BaseTrafficType baseTrafficType4 = baseTrafficType3;
                                                return (T) obj3;
                                            }
                                        }.invoke(key);
                                    }
                                }.invoke(key);
                                if (invoke2 != null) {
                                    map2.put(key, invoke2);
                                }
                            }
                        } else if (z4) {
                            String str = value.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (str != null) {
                                try {
                                    Gson PlaceComponentResult5 = JSONExtKt.PlaceComponentResult();
                                    String KClassImpl$Data$declaredNonStaticMembers$23 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(str, null);
                                    Intrinsics.reifiedOperationMarker(4, "T");
                                    obj2 = PlaceComponentResult5.fromJson(KClassImpl$Data$declaredNonStaticMembers$23, (Class<Object>) Object.class);
                                } catch (Exception unused3) {
                                    obj2 = null;
                                }
                                if (obj2 != null) {
                                    map2.put(key, obj2);
                                    if (obj2 == null) {
                                    }
                                }
                            }
                            Intrinsics.needClassReification();
                            T invoke3 = new Function1<String, T>() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$getConfigsOnceReady$1$1$onComplete$lambda-1$lambda-0$$inlined$mapResultConfigs$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final T invoke(String str2) {
                                    Intrinsics.checkNotNullParameter(str2, "");
                                    Map map4 = map3;
                                    if (!((map4.isEmpty() ^ true) && map4.containsKey(str2))) {
                                        map4 = null;
                                    }
                                    if (map4 != null) {
                                        String json = JSONExtKt.PlaceComponentResult().toJson(map4.get(str2));
                                        if (json == null) {
                                            json = JSONExtKt.PlaceComponentResult().toJson(map4);
                                        }
                                        Gson PlaceComponentResult6 = JSONExtKt.PlaceComponentResult();
                                        Intrinsics.reifiedOperationMarker(4, "T");
                                        T t2 = (T) PlaceComponentResult6.fromJson(json, (Class) Object.class);
                                        if (t2 != null) {
                                            return t2;
                                        }
                                    }
                                    BaseTrafficType baseTrafficType3 = baseTrafficType2;
                                    return (T) t;
                                }
                            }.invoke(key);
                            if (invoke3 != null) {
                                map2.put(key, invoke3);
                                Unit unit2 = Unit.INSTANCE;
                            }
                        } else {
                            String str2 = value.KClassImpl$Data$declaredNonStaticMembers$2;
                            if (str2 != null) {
                                Intrinsics.reifiedOperationMarker(1, "T");
                                map2.put(key, str2);
                                if (str2 == null) {
                                }
                            }
                            Intrinsics.needClassReification();
                            T invoke4 = new Function1<String, T>() { // from class: id.dana.data.toggle.traffictype.BaseTrafficType$getConfigsOnceReady$1$1$onComplete$lambda-1$lambda-0$$inlined$mapResultConfigs$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final T invoke(String str3) {
                                    Intrinsics.checkNotNullParameter(str3, "");
                                    Map map4 = map3;
                                    if (!((map4.isEmpty() ^ true) && map4.containsKey(str3))) {
                                        map4 = null;
                                    }
                                    if (map4 != null) {
                                        String json = JSONExtKt.PlaceComponentResult().toJson(map4.get(str3));
                                        if (json == null) {
                                            json = JSONExtKt.PlaceComponentResult().toJson(map4);
                                        }
                                        Gson PlaceComponentResult6 = JSONExtKt.PlaceComponentResult();
                                        Intrinsics.reifiedOperationMarker(4, "T");
                                        T t2 = (T) PlaceComponentResult6.fromJson(json, (Class) Object.class);
                                        if (t2 != null) {
                                            return t2;
                                        }
                                    }
                                    BaseTrafficType baseTrafficType3 = baseTrafficType2;
                                    return (T) t;
                                }
                            }.invoke(key);
                            if (invoke4 != null) {
                                map2.put(key, invoke4);
                                Unit unit3 = Unit.INSTANCE;
                            }
                        }
                    }
                    observableEmitter2.onNext(MapExtKt.filterNotNullValues(map2));
                    observableEmitter2.onComplete();
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    observableEmitter.onError(new SplitNull(list3.toString()));
                }
            }

            @Override // id.dana.lib.toggle.RawResultsCallback
            public final void onError() {
                observableEmitter.onError(new SplitException("Error when get configs once ready"));
            }
        }, this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
    }
}
