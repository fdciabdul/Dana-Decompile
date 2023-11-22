package id.dana.wallet_v3.view.search.presenter;

import id.dana.base.AbstractContractKt;
import id.dana.contract.payasset.SceneType;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.domain.wallet_v3.constant.WalletSearchCategoryConstant;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.view.search.model.SearchCategoryModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/search/presenter/WalletSearchContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface WalletSearchContract {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u000e\u0010\fJ!\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/search/presenter/WalletSearchContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "", "assetTypes", "cardTitle", "searchCategory", "", "getAllCardAssets", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "categoryKey", "getChipSearchCategory", "(Ljava/lang/String;)V", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "getDefaultRecommendation", "getDynamicRecommendation", "(Ljava/lang/String;Ljava/lang/String;)V", "getPaymentOrPocketAssetsBasedOnAssetType", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void getAllCardAssets(List<String> assetTypes, String cardTitle, String searchCategory);

        void getChipSearchCategory(String categoryKey);

        void getDefaultRecommendation(@WalletSearchCategoryConstant String pageSource);

        void getDynamicRecommendation(String cardTitle, @WalletSearchCategoryConstant String pageSource);

        void getPaymentOrPocketAssetsBasedOnAssetType(List<String> assetTypes);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u001d\u0010\u000e\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H&¢\u0006\u0004\b\u000f\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/search/presenter/WalletSearchContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "onErrorGetChipSearchCategory", "()V", "", "Lid/dana/wallet_v3/view/search/model/SearchCategoryModel;", "searchGeneralModel", "onGetChipSearchCategory", "(Ljava/util/List;)V", "onInitialState", "onInitialStateWithRecommendation", "Lid/dana/wallet_v3/model/WalletV3CardModel;", SceneType.ASSETS, "onSuccessGetAllAssets", "onSuccessGetPaymentOrPocketAssetsBasedOnAssetType"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onErrorGetChipSearchCategory();

        void onGetChipSearchCategory(List<SearchCategoryModel> searchGeneralModel);

        void onInitialState();

        void onInitialStateWithRecommendation();

        void onSuccessGetAllAssets(List<? extends WalletV3CardModel> assets);

        void onSuccessGetPaymentOrPocketAssetsBasedOnAssetType(List<? extends WalletV3CardModel> assets);
    }
}
