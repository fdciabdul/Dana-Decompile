package id.dana.splitbill;

import id.dana.domain.DefaultObserver;
import id.dana.domain.homeinfo.HomeInfoResponse;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.mapper.HomeInfoMapper;
import id.dana.splitbill.SplitBillShareQRContract;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SplitBillShareQRPresenter implements SplitBillShareQRContract.Presenter {
    private final SplitBillShareQRContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetHomeInfo MyBillsEntityDataFactory;
    private final HomeInfoMapper PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public SplitBillShareQRPresenter(SplitBillShareQRContract.View view, GetHomeInfo getHomeInfo, HomeInfoMapper homeInfoMapper) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.MyBillsEntityDataFactory = getHomeInfo;
        this.PlaceComponentResult = homeInfoMapper;
    }

    @Override // id.dana.splitbill.SplitBillShareQRContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<HomeInfoResponse>() { // from class: id.dana.splitbill.SplitBillShareQRPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillShareQRPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onFinishGetHomeInfo(SplitBillShareQRPresenter.this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2((HomeInfoResponse) obj));
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
