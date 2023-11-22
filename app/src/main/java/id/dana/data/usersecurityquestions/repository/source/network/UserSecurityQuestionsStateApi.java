package id.dana.data.usersecurityquestions.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.usersecurityquestions.repository.source.network.request.UserSecurityQuestionRequest;
import id.dana.data.usersecurityquestions.repository.source.network.result.UserSecurityQuestionEntityResult;

/* loaded from: classes4.dex */
public interface UserSecurityQuestionsStateApi {
    @OperationType("com.alipay.fc.riskcloud.dispatch")
    @SignCheck
    UserSecurityQuestionEntityResult getSecurityQuestionState(UserSecurityQuestionRequest userSecurityQuestionRequest);
}
