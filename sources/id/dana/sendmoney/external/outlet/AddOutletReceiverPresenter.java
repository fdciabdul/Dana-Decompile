package id.dana.sendmoney.external.outlet;

import id.dana.domain.DefaultObserver;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.sendmoney.interactor.GetSendMoneyVendorLogo;
import id.dana.sendmoney.external.outlet.AddOutletReceiverContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/external/outlet/AddOutletReceiverPresenter;", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "onDestroy", "Lid/dana/domain/sendmoney/interactor/GetSendMoneyVendorLogo;", "Lid/dana/domain/sendmoney/interactor/GetSendMoneyVendorLogo;", "PlaceComponentResult", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$View;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/domain/sendmoney/interactor/GetSendMoneyVendorLogo;Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddOutletReceiverPresenter implements AddOutletReceiverContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetSendMoneyVendorLogo PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AddOutletReceiverContract.View MyBillsEntityDataFactory;

    @Inject
    public AddOutletReceiverPresenter(GetSendMoneyVendorLogo getSendMoneyVendorLogo, AddOutletReceiverContract.View view) {
        Intrinsics.checkNotNullParameter(getSendMoneyVendorLogo, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = getSendMoneyVendorLogo;
        this.MyBillsEntityDataFactory = view;
    }

    @Override // id.dana.sendmoney.external.outlet.AddOutletReceiverContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory.showProgress();
        this.PlaceComponentResult.execute(new DefaultObserver<List<? extends CdpContent>>() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverPresenter$getOutletLogos$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                AddOutletReceiverContract.View view;
                AddOutletReceiverContract.View view2;
                List<? extends CdpContent> list = (List) obj;
                Intrinsics.checkNotNullParameter(list, "");
                view = AddOutletReceiverPresenter.this.MyBillsEntityDataFactory;
                view.BuiltInFictitiousFunctionClassFactory(list);
                view2 = AddOutletReceiverPresenter.this.MyBillsEntityDataFactory;
                view2.dismissProgress();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                AddOutletReceiverContract.View view;
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, p0.getMessage(), p0);
                view = AddOutletReceiverPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }
}
