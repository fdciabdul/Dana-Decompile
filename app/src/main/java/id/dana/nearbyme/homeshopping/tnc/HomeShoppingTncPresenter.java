package id.dana.nearbyme.homeshopping.tnc;

import id.dana.domain.nearbyme.interactor.GetHomeShoppingTnc;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/nearbyme/homeshopping/tnc/HomeShoppingTncPresenter;", "Lid/dana/nearbyme/homeshopping/tnc/HomeShoppingTncContract$Presenter;", "", "onDestroy", "()V", "Lid/dana/domain/nearbyme/interactor/GetHomeShoppingTnc;", "MyBillsEntityDataFactory", "Lid/dana/domain/nearbyme/interactor/GetHomeShoppingTnc;", "PlaceComponentResult", "Lid/dana/nearbyme/homeshopping/tnc/HomeShoppingTncContract$View;", "getAuthRequestContext", "Lid/dana/nearbyme/homeshopping/tnc/HomeShoppingTncContract$View;", "p0", "p1", "<init>", "(Lid/dana/domain/nearbyme/interactor/GetHomeShoppingTnc;Lid/dana/nearbyme/homeshopping/tnc/HomeShoppingTncContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeShoppingTncPresenter implements HomeShoppingTncContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final GetHomeShoppingTnc PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final HomeShoppingTncContract.View MyBillsEntityDataFactory;

    @Inject
    public HomeShoppingTncPresenter(GetHomeShoppingTnc getHomeShoppingTnc, HomeShoppingTncContract.View view) {
        Intrinsics.checkNotNullParameter(getHomeShoppingTnc, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = getHomeShoppingTnc;
        this.MyBillsEntityDataFactory = view;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HomeShoppingTncPresenter homeShoppingTncPresenter, Throwable th) {
        homeShoppingTncPresenter.MyBillsEntityDataFactory.PlaceComponentResult();
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.NEARBY_HOME_SHOPPING, message, th);
    }
}
