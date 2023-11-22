package id.dana.riskChallenges.domain.verifypassword;

import id.dana.riskChallenges.domain.verifypassword.model.VerifyPassword;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ=\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/domain/verifypassword/VerifyPasswordRepository;", "", "", "p0", "p1", "p2", "", "p3", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/domain/verifypassword/model/VerifyPassword;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lio/reactivex/Observable;", "p4", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface VerifyPasswordRepository {
    Observable<VerifyPassword> BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, boolean p3);

    Observable<VerifyPassword> getAuthRequestContext(String p0, String p1, String p2, String p3, String p4);
}
