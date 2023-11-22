package id.dana.data.recentrecipient.repository;

import id.dana.data.recentrecipient.mapper.RecentRecipientEntityMapper;
import io.reactivex.functions.Function;
import java.util.List;

/* loaded from: classes4.dex */
public final /* synthetic */ class RecentRecipientEntityRepository$$ExternalSyntheticLambda5 implements Function {
    public final /* synthetic */ RecentRecipientEntityMapper f$0;

    public /* synthetic */ RecentRecipientEntityRepository$$ExternalSyntheticLambda5(RecentRecipientEntityMapper recentRecipientEntityMapper) {
        this.f$0 = recentRecipientEntityMapper;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.apply((List) obj);
    }
}
