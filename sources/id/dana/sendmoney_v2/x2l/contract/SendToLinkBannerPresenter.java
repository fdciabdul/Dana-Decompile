package id.dana.sendmoney_v2.x2l.contract;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.x2l.interactor.GetSendToLinkBannerConfig;
import id.dana.domain.sendmoney.x2l.model.BannerConfig;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerContract;
import id.dana.sendmoney_v2.x2l.model.BannerConfigModelKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerPresenter;", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerContract$Presenter;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "onDestroy", "Lid/dana/domain/sendmoney/x2l/interactor/GetSendToLinkBannerConfig;", "MyBillsEntityDataFactory", "Lid/dana/domain/sendmoney/x2l/interactor/GetSendToLinkBannerConfig;", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerContract$View;", "getAuthRequestContext", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerContract$View;", "p0", "p1", "<init>", "(Lid/dana/sendmoney_v2/x2l/contract/SendToLinkBannerContract$View;Lid/dana/domain/sendmoney/x2l/interactor/GetSendToLinkBannerConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendToLinkBannerPresenter implements SendToLinkBannerContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetSendToLinkBannerConfig BuiltInFictitiousFunctionClassFactory;
    private final SendToLinkBannerContract.View getAuthRequestContext;

    @Inject
    public SendToLinkBannerPresenter(SendToLinkBannerContract.View view, GetSendToLinkBannerConfig getSendToLinkBannerConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getSendToLinkBannerConfig, "");
        this.getAuthRequestContext = view;
        this.BuiltInFictitiousFunctionClassFactory = getSendToLinkBannerConfig;
    }

    @Override // id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<BannerConfig, Unit>() { // from class: id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerPresenter$getBannerConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BannerConfig bannerConfig) {
                invoke2(bannerConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BannerConfig bannerConfig) {
                SendToLinkBannerContract.View view;
                Intrinsics.checkNotNullParameter(bannerConfig, "");
                view = SendToLinkBannerPresenter.this.getAuthRequestContext;
                view.KClassImpl$Data$declaredNonStaticMembers$2(BannerConfigModelKt.PlaceComponentResult(bannerConfig));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.x2l.contract.SendToLinkBannerPresenter$getBannerConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                SendToLinkBannerContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = SendToLinkBannerPresenter.this.getAuthRequestContext;
                String message = th.getMessage();
                if (message == null) {
                    message = "";
                }
                view.onError(message);
                String message2 = th.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SENDMONEY_TO_LINK_BANNER_TAG, message2 != null ? message2 : "", th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
