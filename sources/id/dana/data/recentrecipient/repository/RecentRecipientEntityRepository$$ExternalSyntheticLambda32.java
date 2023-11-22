package id.dana.data.recentrecipient.repository;

import id.dana.data.recentrecipient.mapper.RecentRecipientMapperKt;
import io.reactivex.functions.Function;
import java.util.List;

/* loaded from: classes4.dex */
public final /* synthetic */ class RecentRecipientEntityRepository$$ExternalSyntheticLambda32 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return RecentRecipientMapperKt.toRecentRecipientList((List) obj);
    }
}
