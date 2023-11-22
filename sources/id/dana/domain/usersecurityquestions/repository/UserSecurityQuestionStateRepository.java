package id.dana.domain.usersecurityquestions.repository;

import id.dana.domain.usersecurityquestions.model.UserSecurityQuestionInfo;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface UserSecurityQuestionStateRepository {
    Observable<UserSecurityQuestionInfo> getSecurityQuestionState(String str);
}
