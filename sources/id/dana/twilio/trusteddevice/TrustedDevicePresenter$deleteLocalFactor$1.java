package id.dana.twilio.trusteddevice;

import com.alibaba.ariver.kernel.RVEvents;
import id.dana.domain.DefaultObserver;
import id.dana.twilio.trusteddevice.TrustedDeviceContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/twilio/trusteddevice/TrustedDevicePresenter$deleteLocalFactor$1;", "Lid/dana/domain/DefaultObserver;", "", "", "p0", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/Throwable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrustedDevicePresenter$deleteLocalFactor$1 extends DefaultObserver<Boolean> {
    final /* synthetic */ TrustedDevicePresenter KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TrustedDevicePresenter$deleteLocalFactor$1(TrustedDevicePresenter trustedDevicePresenter) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = trustedDevicePresenter;
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final /* synthetic */ void onNext(Object obj) {
        TrustedDeviceContract.View view;
        Boolean bool = (Boolean) obj;
        view = this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue;
        view.PlaceComponentResult();
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final void onError(Throwable p0) {
        TrustedDeviceContract.View view;
        Intrinsics.checkNotNullParameter(p0, "");
        view = this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue;
        view.MyBillsEntityDataFactory();
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.TWILIO_DELETE_LOCAL_FACTOR, p0.getMessage(), p0);
    }
}
