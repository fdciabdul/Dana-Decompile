package id.dana.nearbyme.merchantdetail.viewcomponent;

import id.dana.domain.nearbyme.interactor.GetMerchantInfo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.model.MerchantInfo;
import id.dana.domain.nearbyme.model.NearbyShopsPromo;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantInfoMapper;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract;
import id.dana.nearbyme.model.PromoInfoModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u000e\u0012\u0006\u0010\u0005\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\u0012\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0014\u0010\n\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001a"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoPresenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoContract$Presenter;", "", "p0", "p1", "p2", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/nearbyme/model/ShopModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/model/ShopModel;)V", "onDestroy", "()V", "Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;", "MyBillsEntityDataFactory", "Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;", "PlaceComponentResult", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantInfoMapper;", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantInfoMapper;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoContract$View;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoContract$View;", "Lid/dana/nearbyme/NearbyPromoModelMapper;", "Lid/dana/nearbyme/NearbyPromoModelMapper;", "p3", "p4", "<init>", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantInfoContract$View;Lid/dana/domain/nearbyme/interactor/GetMerchantInfo;Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;Lid/dana/nearbyme/NearbyPromoModelMapper;Lid/dana/nearbyme/merchantdetail/mapper/MerchantInfoMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantInfoPresenter implements MerchantInfoContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final MerchantInfoMapper getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MerchantInfoContract.View PlaceComponentResult;
    private final GetMerchantInfo MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetNearbyShopsPromo KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final NearbyPromoModelMapper BuiltInFictitiousFunctionClassFactory;

    @Inject
    public MerchantInfoPresenter(MerchantInfoContract.View view, GetMerchantInfo getMerchantInfo, GetNearbyShopsPromo getNearbyShopsPromo, NearbyPromoModelMapper nearbyPromoModelMapper, MerchantInfoMapper merchantInfoMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMerchantInfo, "");
        Intrinsics.checkNotNullParameter(getNearbyShopsPromo, "");
        Intrinsics.checkNotNullParameter(nearbyPromoModelMapper, "");
        Intrinsics.checkNotNullParameter(merchantInfoMapper, "");
        this.PlaceComponentResult = view;
        this.MyBillsEntityDataFactory = getMerchantInfo;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getNearbyShopsPromo;
        this.BuiltInFictitiousFunctionClassFactory = nearbyPromoModelMapper;
        this.getAuthRequestContext = merchantInfoMapper;
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.MyBillsEntityDataFactory.execute(new GetMerchantInfo.Params(p0, p1, false, 4, null), new Function1<Shop, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoPresenter$getMerchantInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                MerchantInfoContract.View view;
                MerchantInfoMapper unused;
                Intrinsics.checkNotNullParameter(shop, "");
                view = MerchantInfoPresenter.this.PlaceComponentResult;
                unused = MerchantInfoPresenter.this.getAuthRequestContext;
                view.BuiltInFictitiousFunctionClassFactory(MerchantInfoMapper.MyBillsEntityDataFactory(shop, p2));
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoPresenter$getMerchantInfo$2
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
                MerchantInfoContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                StringBuilder sb = new StringBuilder();
                sb.append("Error Get Merchant Info: ");
                sb.append(exc);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.NEARBY_ME_MERCHANT_DETAIL, sb.toString());
                view = MerchantInfoPresenter.this.PlaceComponentResult;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final ShopModel p0) {
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        GetNearbyShopsPromo getNearbyShopsPromo = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String str2 = p0.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (str2 == null || (str = p0.BottomSheetCardBindingView$watcherCardNumberView$1) == null) {
            return;
        }
        getNearbyShopsPromo.execute(new GetNearbyShopsPromo.Params(CollectionsKt.listOf(new MerchantInfo(str2, str))), new Function1<List<NearbyShopsPromo>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoPresenter$getMerchantPromo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<NearbyShopsPromo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<NearbyShopsPromo> list) {
                MerchantInfoContract.View view;
                NearbyPromoModelMapper nearbyPromoModelMapper;
                Intrinsics.checkNotNullParameter(list, "");
                view = MerchantInfoPresenter.this.PlaceComponentResult;
                nearbyPromoModelMapper = MerchantInfoPresenter.this.BuiltInFictitiousFunctionClassFactory;
                List<ShopModel> BuiltInFictitiousFunctionClassFactory = nearbyPromoModelMapper.BuiltInFictitiousFunctionClassFactory(CollectionsKt.listOf(p0), list);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                ShopModel shopModel = (ShopModel) CollectionsKt.firstOrNull((List) BuiltInFictitiousFunctionClassFactory);
                List<PromoInfoModel> list2 = shopModel != null ? shopModel.getCallingPid : null;
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                view.BuiltInFictitiousFunctionClassFactory(list2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantInfoPresenter$getMerchantPromo$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, DanaLogConstants.Prefix.GET_NEARBY_PROMO, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}
