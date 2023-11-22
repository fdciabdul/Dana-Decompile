package id.dana.data.featureswitch.repository.source.local;

import android.content.Context;
import id.dana.data.featureswitch.repository.source.FeatureNonAMCSEntityData;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.storage.Serializer;
import id.dana.domain.featureswitch.KeyFeatureNonAMCS;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class DefaultFeatureNonAMCSData implements FeatureNonAMCSEntityData {
    private static final String FEATURE_NON_AMCS = "json/feature-non-amcs.json";
    private final Context context;
    private final Serializer serializer;

    @Inject
    public DefaultFeatureNonAMCSData(Context context, Serializer serializer) {
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.featureswitch.repository.source.FeatureNonAMCSEntityData
    public Observable<Boolean> isFeatureNonAMCS(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.featureswitch.repository.source.local.DefaultFeatureNonAMCSData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultFeatureNonAMCSData.this.m1283xbf6e6270(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$isFeatureNonAMCS$0$id-dana-data-featureswitch-repository-source-local-DefaultFeatureNonAMCSData  reason: not valid java name */
    public /* synthetic */ Boolean m1283xbf6e6270(String str) throws Exception {
        Iterator<String> it = this.serializer.deserializeList(this.serializer.deserializeMap(JsonUtil.PlaceComponentResult(this.context, FEATURE_NON_AMCS)).get(KeyFeatureNonAMCS.ALL)).iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
