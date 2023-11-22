package id.dana.data.recentrecipient.repository;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;

/* loaded from: classes4.dex */
public final /* synthetic */ class RecentRecipientEntityRepository$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ RecentRecipientEntityRepository f$0;

    public /* synthetic */ RecentRecipientEntityRepository$$ExternalSyntheticLambda0(RecentRecipientEntityRepository recentRecipientEntityRepository) {
        this.f$0 = recentRecipientEntityRepository;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        Observable saveRecentRecipient;
        saveRecentRecipient = this.f$0.saveRecentRecipient((List) obj);
        return saveRecentRecipient;
    }
}
