package id.dana.nearbyme.merchantdetail.viewcomponent;

import id.dana.domain.nearbyme.interactor.CreateDanaDealsVoucherOrder;
import id.dana.domain.nearbyme.interactor.GetMerchantDanaDeals;
import id.dana.domain.nearbyme.interactor.GetShopPromoAndDeals;
import id.dana.domain.nearbyme.model.DanaDealsOrderRequest;
import id.dana.domain.nearbyme.model.MerchantProductInfo;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.nearbyme.model.ProductOrder;
import id.dana.domain.nearbyme.model.PromoDealsInfo;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.DanaDealsOrderRequestMapper;
import id.dana.nearbyme.merchantdetail.mapper.CreateProductVoucherOrderMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantDanaDealsMapper;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract;
import id.dana.nearbyme.model.DanaDealsOrderRequestModel;
import id.dana.nearbyme.model.PromoInfoModel;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/BI\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u001c\u0012\u0006\u0010\f\u001a\u00020\u001a\u0012\u0006\u0010\u000f\u001a\u00020#\u0012\u0006\u0010)\u001a\u00020\u0015\u0012\u0006\u0010*\u001a\u00020\u001f\u0012\u0006\u0010+\u001a\u00020'\u0012\u0006\u0010,\u001a\u00020\u0017¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\rJ/\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0014\u0010\u0010\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010$\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010("}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsPresenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;)V", "getAuthRequestContext", "()V", "", "p1", "", "p2", "(Ljava/lang/String;Ljava/lang/String;)V", "", "p3", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;IZ)V", "onDestroy", "Lid/dana/domain/nearbyme/interactor/CreateDanaDealsVoucherOrder;", "Lid/dana/domain/nearbyme/interactor/CreateDanaDealsVoucherOrder;", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantDanaDealsMapper;", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantDanaDealsMapper;", "Lid/dana/nearbyme/mapper/DanaDealsOrderRequestMapper;", "PlaceComponentResult", "Lid/dana/nearbyme/mapper/DanaDealsOrderRequestMapper;", "Lid/dana/domain/nearbyme/interactor/GetMerchantDanaDeals;", "Lid/dana/domain/nearbyme/interactor/GetMerchantDanaDeals;", "Lid/dana/domain/nearbyme/interactor/GetShopPromoAndDeals;", "MyBillsEntityDataFactory", "Lid/dana/domain/nearbyme/interactor/GetShopPromoAndDeals;", "Lid/dana/nearbyme/NearbyPromoModelMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/nearbyme/NearbyPromoModelMapper;", "moveToNextValue", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$View;", "scheduleImpl", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$View;", "lookAheadTest", "Lid/dana/nearbyme/merchantdetail/mapper/CreateProductVoucherOrderMapper;", "Lid/dana/nearbyme/merchantdetail/mapper/CreateProductVoucherOrderMapper;", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/domain/nearbyme/interactor/CreateDanaDealsVoucherOrder;Lid/dana/domain/nearbyme/interactor/GetShopPromoAndDeals;Lid/dana/domain/nearbyme/interactor/GetMerchantDanaDeals;Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$View;Lid/dana/nearbyme/merchantdetail/mapper/MerchantDanaDealsMapper;Lid/dana/nearbyme/NearbyPromoModelMapper;Lid/dana/nearbyme/merchantdetail/mapper/CreateProductVoucherOrderMapper;Lid/dana/nearbyme/mapper/DanaDealsOrderRequestMapper;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDanaDealsPresenter implements MerchantDanaDealsContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetMerchantDanaDeals getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MerchantDanaDealsMapper BuiltInFictitiousFunctionClassFactory;
    private final GetShopPromoAndDeals MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final NearbyPromoModelMapper moveToNextValue;
    private final DanaDealsOrderRequestMapper PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final CreateDanaDealsVoucherOrder KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CreateProductVoucherOrderMapper scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final MerchantDanaDealsContract.View lookAheadTest;

    @Inject
    public MerchantDanaDealsPresenter(CreateDanaDealsVoucherOrder createDanaDealsVoucherOrder, GetShopPromoAndDeals getShopPromoAndDeals, GetMerchantDanaDeals getMerchantDanaDeals, MerchantDanaDealsContract.View view, MerchantDanaDealsMapper merchantDanaDealsMapper, NearbyPromoModelMapper nearbyPromoModelMapper, CreateProductVoucherOrderMapper createProductVoucherOrderMapper, DanaDealsOrderRequestMapper danaDealsOrderRequestMapper) {
        Intrinsics.checkNotNullParameter(createDanaDealsVoucherOrder, "");
        Intrinsics.checkNotNullParameter(getShopPromoAndDeals, "");
        Intrinsics.checkNotNullParameter(getMerchantDanaDeals, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(merchantDanaDealsMapper, "");
        Intrinsics.checkNotNullParameter(nearbyPromoModelMapper, "");
        Intrinsics.checkNotNullParameter(createProductVoucherOrderMapper, "");
        Intrinsics.checkNotNullParameter(danaDealsOrderRequestMapper, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = createDanaDealsVoucherOrder;
        this.MyBillsEntityDataFactory = getShopPromoAndDeals;
        this.getAuthRequestContext = getMerchantDanaDeals;
        this.lookAheadTest = view;
        this.BuiltInFictitiousFunctionClassFactory = merchantDanaDealsMapper;
        this.moveToNextValue = nearbyPromoModelMapper;
        this.scheduleImpl = createProductVoucherOrderMapper;
        this.PlaceComponentResult = danaDealsOrderRequestMapper;
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.Presenter
    public final void getAuthRequestContext(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getAuthRequestContext.execute(new GetMerchantDanaDeals.Params(str, str2, 10), new Function1<List<? extends MerchantProductInfo>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter$getMerchantDanaDealsVoucher$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends MerchantProductInfo> list) {
                invoke2((List<MerchantProductInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<MerchantProductInfo> list) {
                MerchantDanaDealsContract.View view;
                MerchantDanaDealsMapper merchantDanaDealsMapper;
                Intrinsics.checkNotNullParameter(list, "");
                view = MerchantDanaDealsPresenter.this.lookAheadTest;
                merchantDanaDealsMapper = MerchantDanaDealsPresenter.this.BuiltInFictitiousFunctionClassFactory;
                Collection apply = merchantDanaDealsMapper.apply(list);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.KClassImpl$Data$declaredNonStaticMembers$2((List) apply);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter$getMerchantDanaDealsVoucher$2
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
                MerchantDanaDealsContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                view = MerchantDanaDealsPresenter.this.lookAheadTest;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantProductInfoModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CreateDanaDealsVoucherOrder createDanaDealsVoucherOrder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DanaDealsOrderRequest apply = this.PlaceComponentResult.apply(new DanaDealsOrderRequestModel(p0.scheduleImpl, p0.KClassImpl$Data$declaredNonStaticMembers$2, "", p0.lookAheadTest, "", new MoneyView(p0.getErrorConfigVersion.PlaceComponentResult, p0.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2, p0.getErrorConfigVersion.getAuthRequestContext), "DANA_VOUCHER"));
        Intrinsics.checkNotNullExpressionValue(apply, "");
        createDanaDealsVoucherOrder.execute(new CreateDanaDealsVoucherOrder.Param(apply), new Function1<ProductOrder, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter$createDanaDealsVoucherOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ProductOrder productOrder) {
                invoke2(productOrder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ProductOrder productOrder) {
                MerchantDanaDealsContract.View view;
                CreateProductVoucherOrderMapper unused;
                Intrinsics.checkNotNullParameter(productOrder, "");
                view = MerchantDanaDealsPresenter.this.lookAheadTest;
                unused = MerchantDanaDealsPresenter.this.scheduleImpl;
                view.PlaceComponentResult(CreateProductVoucherOrderMapper.getAuthRequestContext(productOrder));
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter$createDanaDealsVoucherOrder$2
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
                MerchantDanaDealsContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                view = MerchantDanaDealsPresenter.this.lookAheadTest;
                view.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, int p2, final boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.invoke(new GetShopPromoAndDeals.Params(p0, p1, p3, p2), new Function1<PromoDealsInfo, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter$getMerchantPromoAndDanaDeals$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PromoDealsInfo promoDealsInfo) {
                invoke2(promoDealsInfo);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PromoDealsInfo promoDealsInfo) {
                NearbyPromoModelMapper nearbyPromoModelMapper;
                MerchantDanaDealsMapper merchantDanaDealsMapper;
                MerchantDanaDealsContract.View view;
                Intrinsics.checkNotNullParameter(promoDealsInfo, "");
                nearbyPromoModelMapper = MerchantDanaDealsPresenter.this.moveToNextValue;
                List<PromoInfoModel> authRequestContext = nearbyPromoModelMapper.getAuthRequestContext(promoDealsInfo.getPromoInfo());
                merchantDanaDealsMapper = MerchantDanaDealsPresenter.this.BuiltInFictitiousFunctionClassFactory;
                List<? extends MerchantProductInfoModel> apply = merchantDanaDealsMapper.apply(promoDealsInfo.getDealsInfo());
                view = MerchantDanaDealsPresenter.this.lookAheadTest;
                boolean z = p3;
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.PlaceComponentResult(z, authRequestContext, apply);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter$getMerchantPromoAndDanaDeals$2
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
                MerchantDanaDealsContract.View view;
                Intrinsics.checkNotNullParameter(exc, "");
                view = MerchantDanaDealsPresenter.this.lookAheadTest;
                view.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.Presenter
    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.cancelChildren();
        this.getAuthRequestContext.dispose();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}
