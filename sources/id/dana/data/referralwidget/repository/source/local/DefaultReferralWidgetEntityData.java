package id.dana.data.referralwidget.repository.source.local;

import android.content.Context;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.referralwidget.model.ReferralWidgetResult;
import id.dana.data.referralwidget.repository.source.ReferralWidgetEntityData;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class DefaultReferralWidgetEntityData implements ReferralWidgetEntityData {
    private static final String BUTTONS_JSON = "json/amcs-referral-widget-button-default.json";
    private final Context context;
    private final Serializer serializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$getReferralWidgets$2(Map map, List list) throws Exception {
        return map;
    }

    @Inject
    public DefaultReferralWidgetEntityData(Context context, Serializer serializer) {
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.referralwidget.repository.source.ReferralWidgetEntityData
    public Observable<Map<String, ReferralWidgetResult>> getReferralWidgets() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.referralwidget.repository.source.local.DefaultReferralWidgetEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultReferralWidgetEntityData.this.m1792x3f0671cb();
            }
        }).flatMap(new Function() { // from class: id.dana.data.referralwidget.repository.source.local.DefaultReferralWidgetEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultReferralWidgetEntityData.this.m1794x66cbba4e((Set) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getReferralWidgets$0$id-dana-data-referralwidget-repository-source-local-DefaultReferralWidgetEntityData  reason: not valid java name */
    public /* synthetic */ Set m1792x3f0671cb() throws Exception {
        return this.serializer.deserializeMap(JsonUtil.PlaceComponentResult(this.context, BUTTONS_JSON)).entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getReferralWidgets$3$id-dana-data-referralwidget-repository-source-local-DefaultReferralWidgetEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1794x66cbba4e(Set set) throws Exception {
        Observable BuiltInFictitiousFunctionClassFactory;
        final HashMap hashMap = new HashMap();
        Single list = Observable.fromIterable(set).map(new Function() { // from class: id.dana.data.referralwidget.repository.source.local.DefaultReferralWidgetEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultReferralWidgetEntityData.this.m1793xf6f2df4c(hashMap, (Map.Entry) obj);
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        return BuiltInFictitiousFunctionClassFactory.map(new Function() { // from class: id.dana.data.referralwidget.repository.source.local.DefaultReferralWidgetEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultReferralWidgetEntityData.lambda$getReferralWidgets$2(hashMap, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getReferralWidgets$1$id-dana-data-referralwidget-repository-source-local-DefaultReferralWidgetEntityData  reason: not valid java name */
    public /* synthetic */ ReferralWidgetResult m1793xf6f2df4c(Map map, Map.Entry entry) throws Exception {
        String str = (String) entry.getKey();
        ReferralWidgetResult referralWidgetResult = (ReferralWidgetResult) this.serializer.deserialize((String) entry.getValue(), ReferralWidgetResult.class);
        referralWidgetResult.key = str;
        map.put(str, referralWidgetResult);
        return referralWidgetResult;
    }
}
