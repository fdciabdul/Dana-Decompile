package id.dana.data.util;

import com.google.gson.Gson;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007JS\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\b\b\u0000\u0010\u0002*\u00020\u0001\"\u0004\b\u0001\u0010\b2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u00002\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000eJ[\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\b*\u00028\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\u00028\u00002\u001a\b\b\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000fJQ\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Lid/dana/data/util/ConfigUtil;", "", "T", "Lkotlin/Function1;", "", "local", "fallbackAmcsOrLocal", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "P", "", "configEntityDatas", "Lio/reactivex/Observable;", "entityData", "getConfigFallback", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "(Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "", "iterator", "getConfigFromOtherEntityData", "(Lio/reactivex/Observable;Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConfigUtil {
    public static final ConfigUtil INSTANCE = new ConfigUtil();

    private ConfigUtil() {
    }

    public final /* synthetic */ <T, P> Observable<P> getConfigFallback(T t, T[] tArr, Function1<? super T, ? extends Observable<P>> function1) {
        Intrinsics.checkNotNullParameter(tArr, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return getConfigFromOtherEntityData(function1.invoke(t), ArrayIteratorKt.iterator(tArr), function1);
    }

    @JvmStatic
    public static final <T, P> Observable<P> getConfigFallback(T[] configEntityDatas, Function1<? super T, ? extends Observable<P>> entityData) {
        Intrinsics.checkNotNullParameter(configEntityDatas, "");
        Intrinsics.checkNotNullParameter(entityData, "");
        Iterator<? extends T> it = ArrayIteratorKt.iterator(configEntityDatas);
        return INSTANCE.getConfigFromOtherEntityData(entityData.invoke((T) it.next()), it, entityData);
    }

    public final <T, P> Observable<P> getConfigFromOtherEntityData(Observable<P> observable, Iterator<? extends T> it, Function1<? super T, ? extends Observable<P>> function1) {
        Intrinsics.checkNotNullParameter(observable, "");
        Intrinsics.checkNotNullParameter(it, "");
        Intrinsics.checkNotNullParameter(function1, "");
        if (it.hasNext()) {
            Observable<P> onErrorResumeNext = observable.onErrorResumeNext(getConfigFromOtherEntityData(function1.invoke((T) it.next()), it, function1));
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
            return onErrorResumeNext;
        }
        return observable;
    }

    public final /* synthetic */ <T> Function1<String, T> fallbackAmcsOrLocal(final Function1<? super String, ? extends T> local) {
        Intrinsics.checkNotNullParameter(local, "");
        Intrinsics.needClassReification();
        return new Function1<String, T>() { // from class: id.dana.data.util.ConfigUtil$fallbackAmcsOrLocal$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(String str) {
                String jSONObject;
                Intrinsics.checkNotNullParameter(str, "");
                JSONObject jSONConfig = ConfigCenter.getInstance().getJSONConfig(str);
                if (jSONConfig != null && (jSONObject = jSONConfig.toString()) != null) {
                    T t = null;
                    try {
                        Gson PlaceComponentResult = JSONExtKt.PlaceComponentResult();
                        String KClassImpl$Data$declaredNonStaticMembers$2 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject, null);
                        Intrinsics.reifiedOperationMarker(4, "T");
                        t = (T) PlaceComponentResult.fromJson(KClassImpl$Data$declaredNonStaticMembers$2, (Class) Object.class);
                    } catch (Exception unused) {
                    }
                    if (t != null) {
                        return t;
                    }
                }
                ConfigUtil configUtil = ConfigUtil.INSTANCE;
                return local.invoke(str);
            }
        };
    }
}
