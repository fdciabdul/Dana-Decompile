package id.dana.data.referralconfig.repository.source.local;

import android.content.Context;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.referralconfig.model.ReferralConfigEntity;
import id.dana.data.referralconfig.repository.source.ReferralConfigEntityData;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class DefaultReferralConfigEntityData implements ReferralConfigEntityData {
    private static final String REFERRAL_CONFIG_JSON = "json/amcs-referral-config-default.json";
    private final Context context;
    private final Serializer serializer;

    @Inject
    public DefaultReferralConfigEntityData(Context context, Serializer serializer) {
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.referralconfig.repository.source.ReferralConfigEntityData
    public Observable<ReferralConfigEntity> getReferralConfig(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.referralconfig.repository.source.local.DefaultReferralConfigEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultReferralConfigEntityData.this.m1787x9589386(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getReferralConfig$0$id-dana-data-referralconfig-repository-source-local-DefaultReferralConfigEntityData  reason: not valid java name */
    public /* synthetic */ ReferralConfigEntity m1787x9589386(String str) throws Exception {
        return (ReferralConfigEntity) this.serializer.deserialize(this.serializer.deserializeMap(JsonUtil.PlaceComponentResult(this.context, REFERRAL_CONFIG_JSON)).get(str), ReferralConfigEntity.class);
    }
}
