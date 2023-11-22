package id.dana.data.usersecurityquestions.mapper;

import com.alibaba.fastjson.JSON;
import id.dana.data.base.BaseMapper;
import id.dana.data.usersecurityquestions.repository.source.network.result.UserSecurityQuestionEntityResult;
import id.dana.domain.usersecurityquestions.model.SecuritySettingData;
import id.dana.domain.usersecurityquestions.model.UserSecurityQuestionInfo;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class UserSecurityQuestionResultMapper extends BaseMapper<UserSecurityQuestionEntityResult, UserSecurityQuestionInfo> {
    @Inject
    public UserSecurityQuestionResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public UserSecurityQuestionInfo map(UserSecurityQuestionEntityResult userSecurityQuestionEntityResult) {
        if (userSecurityQuestionEntityResult != null) {
            SecuritySettingData securitySettingData = (SecuritySettingData) JSON.parseObject(userSecurityQuestionEntityResult.getData(), SecuritySettingData.class);
            UserSecurityQuestionInfo userSecurityQuestionInfo = new UserSecurityQuestionInfo();
            userSecurityQuestionInfo.setData(securitySettingData);
            userSecurityQuestionInfo.setExpireTime(userSecurityQuestionEntityResult.getExpireTime());
            userSecurityQuestionInfo.setFinish(userSecurityQuestionEntityResult.isFinish());
            userSecurityQuestionInfo.setVerifySuccess(userSecurityQuestionEntityResult.isVerifySuccess());
            return userSecurityQuestionInfo;
        }
        return null;
    }
}
