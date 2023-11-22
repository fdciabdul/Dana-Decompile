package id.dana.wallet_v3.presenter;

import dagger.Lazy;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.wallet_v3.interactor.GetKtpInfo;
import id.dana.domain.wallet_v3.interactor.SaveKtpConsultPopUp;
import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.pocket.mapper.PocketMapperKt;
import id.dana.pocket.model.PocketQueryListModel;
import id.dana.wallet_v3.model.KtpInfoModel;
import id.dana.wallet_v3.presenter.KtpDetailContract;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B3\b\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\n"}, d2 = {"Lid/dana/wallet_v3/presenter/KtpDetailPresenter;", "Lid/dana/wallet_v3/presenter/KtpDetailContract$Presenter;", "", "deleteKtp", "()V", "getKtpDetailAsset", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetKtpInfo;", "getKtpInfo", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/SaveKtpConsultPopUp;", "saveKtpConsultPopUp", "Lid/dana/wallet_v3/presenter/KtpDetailContract$View;", "view", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class KtpDetailPresenter implements KtpDetailContract.Presenter {
    public static final int KTP_PAGE_NUM = 1;
    public static final int KTP_PAGE_SIZE = 1;
    private final Lazy<GetKtpInfo> getKtpInfo;
    private final Lazy<SaveKtpConsultPopUp> saveKtpConsultPopUp;
    private final Lazy<KtpDetailContract.View> view;

    @Inject
    public KtpDetailPresenter(Lazy<KtpDetailContract.View> lazy, Lazy<SaveKtpConsultPopUp> lazy2, Lazy<GetKtpInfo> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.view = lazy;
        this.saveKtpConsultPopUp = lazy2;
        this.getKtpInfo = lazy3;
    }

    @Override // id.dana.wallet_v3.presenter.KtpDetailContract.Presenter
    public final void deleteKtp() {
        this.saveKtpConsultPopUp.get().execute(Boolean.FALSE, new Function1<Boolean, Unit>() { // from class: id.dana.wallet_v3.presenter.KtpDetailPresenter$deleteKtp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                Lazy lazy2;
                if (z) {
                    lazy2 = KtpDetailPresenter.this.view;
                    ((KtpDetailContract.View) lazy2.get()).onDeleteKtpSuccess();
                    return;
                }
                lazy = KtpDetailPresenter.this.view;
                ((KtpDetailContract.View) lazy.get()).onDeleteKtpError();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.KtpDetailPresenter$deleteKtp$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = KtpDetailPresenter.this.view;
                ((KtpDetailContract.View) lazy.get()).onDeleteKtpError();
            }
        });
    }

    @Override // id.dana.wallet_v3.presenter.KtpDetailContract.Presenter
    public final void getKtpDetailAsset() {
        this.view.get().showProgress();
        this.getKtpInfo.get().execute(new GetKtpInfo.Param(1, 1), new Function1<PocketQueryList<KtpInfo>, Unit>() { // from class: id.dana.wallet_v3.presenter.KtpDetailPresenter$getKtpDetailAsset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PocketQueryList<KtpInfo> pocketQueryList) {
                invoke2(pocketQueryList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PocketQueryList<KtpInfo> pocketQueryList) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Lazy lazy4;
                Intrinsics.checkNotNullParameter(pocketQueryList, "");
                PocketQueryListModel PlaceComponentResult = PocketMapperKt.PlaceComponentResult(pocketQueryList, KtpDetailPresenter$getKtpDetailAsset$1$pocketQueryListKtpInfoModel$1.INSTANCE);
                if (PlaceComponentResult.PlaceComponentResult.isEmpty()) {
                    lazy3 = KtpDetailPresenter.this.view;
                    ((KtpDetailContract.View) lazy3.get()).onGetKtpDetailFailed();
                    lazy4 = KtpDetailPresenter.this.view;
                    ((KtpDetailContract.View) lazy4.get()).dismissProgress();
                    return;
                }
                lazy = KtpDetailPresenter.this.view;
                ((KtpDetailContract.View) lazy.get()).onGetKtpDetailSuccess((KtpInfoModel) PlaceComponentResult.PlaceComponentResult.get(0));
                lazy2 = KtpDetailPresenter.this.view;
                ((KtpDetailContract.View) lazy2.get()).dismissProgress();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.presenter.KtpDetailPresenter$getKtpDetailAsset$2
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
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = KtpDetailPresenter.this.view;
                ((KtpDetailContract.View) lazy.get()).onGetKtpDetailFailed();
                lazy2 = KtpDetailPresenter.this.view;
                ((KtpDetailContract.View) lazy2.get()).dismissProgress();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.saveKtpConsultPopUp.get().dispose();
        this.getKtpInfo.get().dispose();
    }
}
