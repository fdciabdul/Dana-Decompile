package id.dana.riskChallenges.domain.danaprotection;

import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.riskChallenges.domain.danaprotection.model.RiskChallengeStatusModel;
import io.reactivex.Observable;
import kotlin.Metadata;

@RiskChallengesScope
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/domain/danaprotection/DanaProtectionRepository;", "", "", "p0", "p1", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/domain/danaprotection/model/RiskChallengeStatusModel;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DanaProtectionRepository {
    Observable<RiskChallengeStatusModel> PlaceComponentResult(String p0, String p1, String p2, String p3);
}
