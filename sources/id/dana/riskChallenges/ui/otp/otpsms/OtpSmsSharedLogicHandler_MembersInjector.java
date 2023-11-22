package id.dana.riskChallenges.ui.otp.otpsms;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.utils.danah5.DanaH5Facade;

/* loaded from: classes5.dex */
public final class OtpSmsSharedLogicHandler_MembersInjector implements MembersInjector<OtpSmsSharedLogicHandler> {
    public static void MyBillsEntityDataFactory(OtpSmsSharedLogicHandler otpSmsSharedLogicHandler, ViewModelFactory viewModelFactory) {
        otpSmsSharedLogicHandler.viewModelFactory = viewModelFactory;
    }

    public static void MyBillsEntityDataFactory(OtpSmsSharedLogicHandler otpSmsSharedLogicHandler, Lazy<DanaH5Facade> lazy) {
        otpSmsSharedLogicHandler.danaH5Facade = lazy;
    }
}
