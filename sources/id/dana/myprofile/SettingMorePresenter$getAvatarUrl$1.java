package id.dana.myprofile;

import android.content.Context;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.domain.DefaultObserver;
import id.dana.myprofile.SettingMoreContract;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/myprofile/SettingMorePresenter$getAvatarUrl$1;", "Lid/dana/domain/DefaultObserver;", "", "", "p0", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingMorePresenter$getAvatarUrl$1 extends DefaultObserver<String> {
    final /* synthetic */ SettingMorePresenter PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SettingMorePresenter$getAvatarUrl$1(SettingMorePresenter settingMorePresenter) {
        this.PlaceComponentResult = settingMorePresenter;
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final /* synthetic */ void onNext(Object obj) {
        SettingMoreContract.View view;
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, "");
        view = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6;
        view.showAvatar(str);
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final void onError(Throwable p0) {
        SettingMoreContract.View view;
        Context context;
        Intrinsics.checkNotNullParameter(p0, "");
        view = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6;
        context = this.PlaceComponentResult.PlaceComponentResult;
        view.onError(ErrorUtil.PlaceComponentResult(p0, context));
        SettingMorePresenter.MyBillsEntityDataFactory(this.PlaceComponentResult, DanaLogConstants.Prefix.PROFILE_GETAVATARURL_PREFIX, p0);
    }
}
