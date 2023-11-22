package id.dana.challenge.otp;

import dagger.MembersInjector;
import id.dana.myprofile.UserInfoMapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class OtpLoginPresenter_MembersInjector implements MembersInjector<OtpLoginPresenter> {
    public static void MyBillsEntityDataFactory(OtpLoginPresenter otpLoginPresenter, UserInfoMapper userInfoMapper) {
        Intrinsics.checkNotNullParameter(userInfoMapper, "");
        Intrinsics.checkNotNullParameter(userInfoMapper, "");
        otpLoginPresenter.NetworkUserEntityData$$ExternalSyntheticLambda5 = userInfoMapper;
    }
}
