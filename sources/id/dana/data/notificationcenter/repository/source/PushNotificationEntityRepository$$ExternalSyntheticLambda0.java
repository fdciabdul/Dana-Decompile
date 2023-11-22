package id.dana.data.notificationcenter.repository.source;

import id.dana.data.notificationcenter.mapper.PushNotificationMapper;
import id.dana.data.notificationcenter.repository.source.network.result.BindAppResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class PushNotificationEntityRepository$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ PushNotificationMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((BindAppResult) obj);
    }
}
