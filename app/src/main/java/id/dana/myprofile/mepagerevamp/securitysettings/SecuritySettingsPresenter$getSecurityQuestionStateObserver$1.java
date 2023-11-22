package id.dana.myprofile.mepagerevamp.securitysettings;

import android.content.Context;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.domain.DefaultObserver;
import id.dana.domain.usersecurityquestions.model.SecuritySettingData;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsContract;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/SecuritySettingsPresenter$getSecurityQuestionStateObserver$1;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/usersecurityquestions/model/SecuritySettingData;", "", "p0", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SecuritySettingsPresenter$getSecurityQuestionStateObserver$1 extends DefaultObserver<SecuritySettingData> {
    final /* synthetic */ SecuritySettingsPresenter KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecuritySettingsPresenter$getSecurityQuestionStateObserver$1(SecuritySettingsPresenter securitySettingsPresenter) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = securitySettingsPresenter;
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final /* synthetic */ void onNext(Object obj) {
        SecuritySettingsContract.View view;
        SecuritySettingsContract.View view2;
        SecuritySettingData securitySettingData = (SecuritySettingData) obj;
        Intrinsics.checkNotNullParameter(securitySettingData, "");
        if (Intrinsics.areEqual("Set", SecuritySettingsPresenter.getAuthRequestContext(securitySettingData))) {
            view2 = this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl;
            view2.showSecurityQuestionStateOn();
            return;
        }
        view = this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl;
        view.showSecurityQuestionStateOff();
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final void onError(Throwable p0) {
        SecuritySettingsContract.View view;
        Context context;
        Intrinsics.checkNotNullParameter(p0, "");
        view = this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl;
        context = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        view.onError(ErrorUtil.PlaceComponentResult(p0, context));
        SecuritySettingsPresenter.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, DanaLogConstants.Prefix.PROFILE_GETSECURITYQUESTIONSTATE_PREFIX, p0);
    }
}
