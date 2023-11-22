package id.dana.data.sendmoney.repository.source.split;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.gson.reflect.TypeToken;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.config.source.split.DefaultJsonPath;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.sendmoney.model.DigitalMoneyResult;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.util.ConfigUtil;
import id.dana.domain.extension.MapExtKt;
import id.dana.lib.toggle.RawResultsCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.lib.toggle.result.RawResult;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "suffixKeys", "Lio/reactivex/Observable;", "", "Lid/dana/data/sendmoney/model/DigitalMoneyResult;", BridgeDSL.INVOKE, "(Ljava/util/List;)Lio/reactivex/Observable;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SplitDigitalMoneyEntityData$getEwalletList$1 extends Lambda implements Function1<List<? extends String>, Observable<Map<String, ? extends DigitalMoneyResult>>> {
    final /* synthetic */ SplitDigitalMoneyEntityData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitDigitalMoneyEntityData$getEwalletList$1(SplitDigitalMoneyEntityData splitDigitalMoneyEntityData) {
        super(1);
        this.this$0 = splitDigitalMoneyEntityData;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Observable<Map<String, ? extends DigitalMoneyResult>> invoke(List<? extends String> list) {
        return invoke2((List<String>) list);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Observable<Map<String, DigitalMoneyResult>> invoke2(final List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        if (list.isEmpty()) {
            Observable<Map<String, DigitalMoneyResult>> just = Observable.just(new LinkedHashMap());
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable flatMap = SplitDigitalMoneyEntityData.access$getSplitFacade$p(this.this$0).KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1935invoke$lambda0;
                m1935invoke$lambda0 = SplitDigitalMoneyEntityData$getEwalletList$1.m1935invoke$lambda0(list, (BaseTrafficType) obj);
                return m1935invoke$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final ObservableSource m1935invoke$lambda0(final List list, final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final String str = DefaultJsonPath.DEFAULT_EWALLET_CATEGORY_LIST;
        final boolean z = false;
        final boolean z2 = true;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$invoke$lambda-0$$inlined$getConfigsOnceReady$default$1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<Map<String, T>> observableEmitter) {
                Map emptyMap;
                final Object obj;
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                try {
                    Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(JsonUtil.PlaceComponentResult(BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2, str), null), new TypeToken<Map<String, ? extends T>>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$invoke$lambda-0$$inlined$getConfigsOnceReady$default$1.1
                    }.getType());
                    Intrinsics.checkNotNullExpressionValue(fromJson, "");
                    emptyMap = (Map) fromJson;
                } catch (Exception unused) {
                    emptyMap = MapsKt.emptyMap();
                }
                final Map map = emptyMap;
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(JsonUtil.PlaceComponentResult(BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2, str), null), (Class<Object>) DigitalMoneyResult.class);
                } catch (Exception unused2) {
                    obj = null;
                }
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(TuplesKt.to((String) it.next(), null));
                }
                final Map mutableMap = MapsKt.toMutableMap(MapsKt.toMap(arrayList));
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                List<String> list3 = list;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final boolean z3 = z;
                final boolean z4 = z2;
                final List list4 = list;
                MyBillsEntityDataFactory.PlaceComponentResult(list3, BuiltInFictitiousFunctionClassFactory, new RawResultsCallback() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$invoke$lambda-0$$inlined$getConfigsOnceReady$default$1.2
                    @Override // id.dana.lib.toggle.RawResultsCallback
                    public final void onComplete(Map<String, ? extends RawResult> it2) {
                        Object obj2;
                        Unit unit = null;
                        if (it2 != null) {
                            ObservableEmitter observableEmitter2 = ObservableEmitter.this;
                            Map map2 = mutableMap;
                            final BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            boolean z5 = z3;
                            final Map map3 = map;
                            final Object obj3 = obj;
                            boolean z6 = z4;
                            for (Map.Entry<String, ? extends RawResult> entry : it2.entrySet()) {
                                final String key = entry.getKey();
                                RawResult value = entry.getValue();
                                if (Intrinsics.areEqual(value.getAuthRequestContext, "control")) {
                                    if (!z5) {
                                        T invoke = new Function1<String, T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$invoke$lambda-0$.inlined.getConfigsOnceReady.default.1.2.1
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
                                                    T t = (T) JSONExtKt.PlaceComponentResult().fromJson(json, (Class) DigitalMoneyResult.class);
                                                    if (t != null) {
                                                        return t;
                                                    }
                                                }
                                                return (T) obj3;
                                            }
                                        }.invoke(key);
                                        if (invoke != null) {
                                            map2.put(key, invoke);
                                        }
                                    } else {
                                        ConfigUtil configUtil = ConfigUtil.INSTANCE;
                                        T invoke2 = new Function1<String, T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$invoke$lambda-0$.inlined.getConfigsOnceReady.default.1.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final T invoke(String str2) {
                                                String jSONObject;
                                                Intrinsics.checkNotNullParameter(str2, "");
                                                JSONObject jSONConfig = ConfigCenter.getInstance().getJSONConfig(str2);
                                                if (jSONConfig != null && (jSONObject = jSONConfig.toString()) != null) {
                                                    T t = null;
                                                    try {
                                                        t = (T) JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject, null), (Class) DigitalMoneyResult.class);
                                                    } catch (Exception unused3) {
                                                    }
                                                    if (t != null) {
                                                        return t;
                                                    }
                                                }
                                                ConfigUtil configUtil2 = ConfigUtil.INSTANCE;
                                                final BaseTrafficType baseTrafficType4 = BaseTrafficType.this;
                                                final Map map4 = map3;
                                                final Object obj4 = obj3;
                                                return new Function1<String, T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$invoke$lambda-0$.inlined.getConfigsOnceReady.default.1.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final T invoke(String str3) {
                                                        Intrinsics.checkNotNullParameter(str3, "");
                                                        Map map5 = map4;
                                                        if (!((map5.isEmpty() ^ true) && map5.containsKey(str3))) {
                                                            map5 = null;
                                                        }
                                                        if (map5 != null) {
                                                            String json = JSONExtKt.PlaceComponentResult().toJson(map5.get(str3));
                                                            if (json == null) {
                                                                json = JSONExtKt.PlaceComponentResult().toJson(map5);
                                                            }
                                                            T t2 = (T) JSONExtKt.PlaceComponentResult().fromJson(json, (Class) DigitalMoneyResult.class);
                                                            if (t2 != null) {
                                                                return t2;
                                                            }
                                                        }
                                                        return (T) obj4;
                                                    }
                                                }.invoke(key);
                                            }
                                        }.invoke(key);
                                        if (invoke2 != null) {
                                            map2.put(key, invoke2);
                                        }
                                    }
                                } else if (z6) {
                                    String str2 = value.KClassImpl$Data$declaredNonStaticMembers$2;
                                    if (str2 != null) {
                                        try {
                                            obj2 = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(str2, null), (Class<Object>) DigitalMoneyResult.class);
                                        } catch (Exception unused3) {
                                            obj2 = null;
                                        }
                                        if (obj2 != null) {
                                            map2.put(key, obj2);
                                            if (obj2 == null) {
                                            }
                                        }
                                    }
                                    T invoke3 = new Function1<String, T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$invoke$lambda-0$.inlined.getConfigsOnceReady.default.1.2.3
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
                                                T t = (T) JSONExtKt.PlaceComponentResult().fromJson(json, (Class) DigitalMoneyResult.class);
                                                if (t != null) {
                                                    return t;
                                                }
                                            }
                                            return (T) obj3;
                                        }
                                    }.invoke(key);
                                    if (invoke3 != null) {
                                        map2.put(key, invoke3);
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                } else {
                                    String str3 = value.KClassImpl$Data$declaredNonStaticMembers$2;
                                    if (str3 != null) {
                                        if (str3 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type id.dana.data.sendmoney.model.DigitalMoneyResult");
                                        }
                                        map2.put(key, (DigitalMoneyResult) str3);
                                        if (str3 == null) {
                                        }
                                    }
                                    T invoke4 = new Function1<String, T>() { // from class: id.dana.data.sendmoney.repository.source.split.SplitDigitalMoneyEntityData$getEwalletList$1$invoke$lambda-0$.inlined.getConfigsOnceReady.default.1.2.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final T invoke(String str4) {
                                            Intrinsics.checkNotNullParameter(str4, "");
                                            Map map4 = map3;
                                            if (!((map4.isEmpty() ^ true) && map4.containsKey(str4))) {
                                                map4 = null;
                                            }
                                            if (map4 != null) {
                                                String json = JSONExtKt.PlaceComponentResult().toJson(map4.get(str4));
                                                if (json == null) {
                                                    json = JSONExtKt.PlaceComponentResult().toJson(map4);
                                                }
                                                T t = (T) JSONExtKt.PlaceComponentResult().fromJson(json, (Class) DigitalMoneyResult.class);
                                                if (t != null) {
                                                    return t;
                                                }
                                            }
                                            return (T) obj3;
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
                            ObservableEmitter.this.onError(new SplitNull(list4.toString()));
                        }
                    }

                    @Override // id.dana.lib.toggle.RawResultsCallback
                    public final void onError() {
                        ObservableEmitter.this.onError(new SplitException("Error when get configs once ready"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }
}
