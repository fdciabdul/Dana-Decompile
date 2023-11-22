package id.dana.riskChallenges.domain.forgetpassword;

import id.dana.riskChallenges.domain.forgetpassword.model.ResetPasswordResponseModel;
import id.dana.riskChallenges.domain.forgetpassword.model.RiskChallenges;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/domain/forgetpassword/ResetPasswordRepository;", "", "", "p0", "p1", "", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/domain/forgetpassword/model/RiskChallenges;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/domain/forgetpassword/model/ResetPasswordResponseModel;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ResetPasswordRepository {
    Observable<RiskChallenges> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, boolean p2, boolean p3);

    Observable<ResetPasswordResponseModel> getAuthRequestContext(String p0, String p1, String p2, String p3);
}
