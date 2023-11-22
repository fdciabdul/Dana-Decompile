package id.dana.data.usersecurityquestions;

import id.dana.data.usersecurityquestions.repository.source.network.result.UserSecurityQuestionEntityResult;
import io.reactivex.Observable;

/* loaded from: classes4.dex */
public interface UserSecurityQuestionStateEntityData {
    Observable<UserSecurityQuestionEntityResult> getSecurityQuestionState(String str, String str2);
}
