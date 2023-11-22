package id.dana.data.useremailaddress.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.useremailaddress.repository.source.network.result.UserEmailAddressEntityResult;
import id.dana.domain.useremailaddress.model.UserEmailAddress;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class UserEmailAddressEntityResultMapper extends BaseMapper<UserEmailAddressEntityResult, UserEmailAddress> {
    @Inject
    public UserEmailAddressEntityResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public UserEmailAddress map(UserEmailAddressEntityResult userEmailAddressEntityResult) {
        if (userEmailAddressEntityResult != null) {
            return new UserEmailAddress(userEmailAddressEntityResult.getUserEmail(), userEmailAddressEntityResult.getVerifyStatus());
        }
        return null;
    }
}
