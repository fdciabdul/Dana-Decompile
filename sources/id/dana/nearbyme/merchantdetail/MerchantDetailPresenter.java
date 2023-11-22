package id.dana.nearbyme.merchantdetail;

import id.dana.domain.merchant.model.MerchantSubcategory;
import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.model.ContactAddress;
import id.dana.domain.nearbyme.model.PromoInfo;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.nearbyme.model.ShopOpenHour;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDetailMapper;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0014\u0012\u0006\u0010\u0007\u001a\u00020\f\u0012\u0006\u0010\t\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0003\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\r\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015"}, d2 = {"Lid/dana/nearbyme/merchantdetail/MerchantDetailPresenter;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "", "p0", "p1", "", "p2", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;", "getAuthRequestContext", "Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantDetailMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantDetailMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$View;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$View;", "<init>", "(Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$View;Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;Lid/dana/nearbyme/merchantdetail/mapper/MerchantDetailMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailPresenter implements MerchantDetailContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MerchantDetailMapper KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MerchantDetailContract.View getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetMerchantInfo PlaceComponentResult;

    @Inject
    public MerchantDetailPresenter(MerchantDetailContract.View view, GetMerchantInfo getMerchantInfo, MerchantDetailMapper merchantDetailMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMerchantInfo, "");
        Intrinsics.checkNotNullParameter(merchantDetailMapper, "");
        this.getAuthRequestContext = view;
        this.PlaceComponentResult = getMerchantInfo;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantDetailMapper;
    }

    @Override // id.dana.nearbyme.merchantdetail.MerchantDetailContract.Presenter
    public final void MyBillsEntityDataFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.PlaceComponentResult.execute(new GetMerchantInfo.Params(str2, str, false), new Function1<Shop, Unit>() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailPresenter$getMerchantInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Shop shop) {
                invoke2(shop);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Shop shop) {
                MerchantDetailContract.View view;
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                MerchantDetailMapper unused;
                Intrinsics.checkNotNullParameter(shop, "");
                view = MerchantDetailPresenter.this.getAuthRequestContext;
                unused = MerchantDetailPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullParameter(shop, "");
                ShopModel shopModel = new ShopModel();
                shopModel.MyBillsEntityDataFactory = shop.getBranchName();
                shopModel.getAuthRequestContext = shop.getBrandName();
                shopModel.BuiltInFictitiousFunctionClassFactory = shop.getCertStatus();
                List<ContactAddress> contactAddresses = shop.getContactAddresses();
                ArrayList arrayList4 = null;
                if (contactAddresses != null) {
                    arrayList = new ArrayList();
                    Iterator<ContactAddress> it = contactAddresses.iterator();
                    while (it.hasNext()) {
                        arrayList.add(MerchantDetailMapper.getAuthRequestContext(it.next()));
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                shopModel.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
                shopModel.getErrorConfigVersion = shop.getDistance();
                shopModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = shop.getExtInfo();
                shopModel.lookAheadTest = shop.getExternalShopId();
                shopModel.GetContactSyncConfig = shop.getInstId();
                shopModel.moveToNextValue = shop.getFullDay();
                shopModel.DatabaseTableConfigUtil = shop.getLatitude();
                shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = shop.getLogoUrl();
                shopModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = shop.getLogoUrlMap();
                shopModel.PrepareContext = shop.getLongtitude();
                shopModel.newProxyInstance = shop.getMainName();
                shopModel.isLayoutRequested = shop.getMccCodes();
                shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = shop.getMerchantId();
                shopModel.FragmentBottomSheetPaymentSettingBinding = shop.getMerchantSizeType();
                shopModel.NetworkUserEntityData$$ExternalSyntheticLambda5 = shop.getOfficeNumbers();
                List<PromoInfo> promoInfos = shop.getPromoInfos();
                if (promoInfos != null) {
                    arrayList2 = new ArrayList();
                    Iterator<PromoInfo> it2 = promoInfos.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(MerchantDetailMapper.BuiltInFictitiousFunctionClassFactory(it2.next()));
                    }
                } else {
                    arrayList2 = null;
                }
                if (arrayList2 == null) {
                    arrayList2 = CollectionsKt.emptyList();
                }
                shopModel.MyBillsEntityDataFactory(arrayList2);
                shopModel.readMicros = shop.getRating();
                shopModel.getSupportButtonTintMode = shop.getRegisterSource();
                shopModel.SubSequence = shop.getReviewNumbers();
                shopModel.B = shop.getShopDesc();
                shopModel.BottomSheetCardBindingView$watcherCardNumberView$1 = shop.getShopId();
                List<ShopOpenHour> shopOpenHours = shop.getShopOpenHours();
                if (shopOpenHours != null) {
                    arrayList4 = new ArrayList();
                    Iterator<ShopOpenHour> it3 = shopOpenHours.iterator();
                    while (it3.hasNext()) {
                        arrayList4.add(MerchantDetailMapper.BuiltInFictitiousFunctionClassFactory(it3.next()));
                    }
                }
                if (arrayList4 == null) {
                    arrayList4 = CollectionsKt.emptyList();
                }
                shopModel.BuiltInFictitiousFunctionClassFactory(arrayList4);
                shopModel.VerifyPinStateManager$executeRiskChallenge$2$1 = shop.getShopStatus();
                shopModel.D = shop.getShopType();
                List<MerchantSubcategory> subcategories = shop.getSubcategories();
                if (subcategories == null) {
                    arrayList3 = new ArrayList();
                } else {
                    arrayList3 = new ArrayList();
                    Iterator<MerchantSubcategory> it4 = subcategories.iterator();
                    while (it4.hasNext()) {
                        arrayList3.add(MerchantDetailMapper.PlaceComponentResult(it4.next()));
                    }
                }
                shopModel.getOnBoardingScenario = arrayList3;
                shopModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = shop.getHasMoreShop();
                shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = shop.getMerchantName();
                shopModel.VerifyPinStateManager$executeRiskChallenge$2$2 = shop.getTransactionDate();
                shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8();
                view.BuiltInFictitiousFunctionClassFactory(shopModel);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.MerchantDetailPresenter$getMerchantInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                MerchantDetailContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                view = MerchantDetailPresenter.this.getAuthRequestContext;
                Exception exc2 = exc;
                view.MyBillsEntityDataFactory(exc2, GetMerchantInfo.OPERATION_TYPE);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.NEARBY_ME_MERCHANT_DETAIL, exc.getMessage(), exc2);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }

    @Override // id.dana.nearbyme.merchantdetail.MerchantDetailContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.dispose();
    }
}
