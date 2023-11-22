package id.dana.promocode;

import id.dana.domain.promocode.interactor.ApplyPromoCode;
import id.dana.domain.promocode.model.PrizeAwardVO;
import id.dana.domain.promocode.model.PrizeInfoVO;
import id.dana.domain.promocode.model.PromoCode;
import id.dana.domain.promoquest.model.PrizeInfoEntity;
import id.dana.network.exception.NetworkException;
import id.dana.promocode.RedeemPromoCodeContract;
import id.dana.promocode.mapper.PrizeInfoEntityMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/promocode/RedeemPromoCodePresenter;", "Lid/dana/promocode/RedeemPromoCodeContract$Presenter;", "", "onDestroy", "()V", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Lid/dana/domain/promocode/interactor/ApplyPromoCode;", "MyBillsEntityDataFactory", "Lid/dana/domain/promocode/interactor/ApplyPromoCode;", "Lid/dana/promocode/RedeemPromoCodeContract$View;", "getAuthRequestContext", "Lid/dana/promocode/RedeemPromoCodeContract$View;", "p1", "<init>", "(Lid/dana/promocode/RedeemPromoCodeContract$View;Lid/dana/domain/promocode/interactor/ApplyPromoCode;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RedeemPromoCodePresenter implements RedeemPromoCodeContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ApplyPromoCode BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final RedeemPromoCodeContract.View MyBillsEntityDataFactory;

    @Inject
    public RedeemPromoCodePresenter(RedeemPromoCodeContract.View view, ApplyPromoCode applyPromoCode) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(applyPromoCode, "");
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = applyPromoCode;
    }

    @Override // id.dana.promocode.RedeemPromoCodeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(new ApplyPromoCode.ApplyPromoCodeParams(p0), new Function1<PromoCode, Unit>() { // from class: id.dana.promocode.RedeemPromoCodePresenter$redeemCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PromoCode promoCode) {
                invoke2(promoCode);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PromoCode promoCode) {
                RedeemPromoCodeContract.View view;
                Intrinsics.checkNotNullParameter(promoCode, "");
                view = RedeemPromoCodePresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                RedeemPromoCodePresenter.MyBillsEntityDataFactory(RedeemPromoCodePresenter.this, p0, promoCode);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.promocode.RedeemPromoCodePresenter$redeemCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                RedeemPromoCodeContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.APPLY_PROMO_CODE);
                sb.append(RedeemPromoCodePresenter.this.getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.PROMO_CENTER, sb.toString(), th);
                view = RedeemPromoCodePresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                RedeemPromoCodePresenter.BuiltInFictitiousFunctionClassFactory(RedeemPromoCodePresenter.this, th, p0);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(RedeemPromoCodePresenter redeemPromoCodePresenter, Throwable th, String str) {
        if (th instanceof NetworkException) {
            redeemPromoCodePresenter.MyBillsEntityDataFactory.onErrorResult(((NetworkException) th).getErrorCode(), th.getMessage(), str);
        } else {
            redeemPromoCodePresenter.MyBillsEntityDataFactory.onErrorResult("", th.getMessage(), str);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(RedeemPromoCodePresenter redeemPromoCodePresenter, String str, PromoCode promoCode) {
        List<PrizeAwardVO> prizeAwards = promoCode.getPrizeAwards();
        if ((!prizeAwards.isEmpty()) != false) {
            PrizeAwardVO prizeAwardVO = prizeAwards.get(0);
            RedeemPromoCodeContract.View view = redeemPromoCodePresenter.MyBillsEntityDataFactory;
            PrizeInfoVO prizeInfoVO = prizeAwardVO.getPrizeInfoVO();
            PrizeInfoEntity prizeInfoEntity = null;
            if (prizeInfoVO != null) {
                String prizeAwardOrderId = prizeAwardVO.getPrizeAwardOrderId();
                String bizNo = prizeAwardVO.getBizNo();
                Map<String, String> extendInfo = prizeAwardVO.getExtendInfo();
                prizeInfoEntity = PrizeInfoEntityMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(prizeInfoVO, prizeAwardOrderId, bizNo, extendInfo != null ? extendInfo.get("voucherId") : null);
            }
            view.onRedeemResult(str, prizeInfoEntity, prizeAwardVO.getActivityId());
            return;
        }
        redeemPromoCodePresenter.MyBillsEntityDataFactory.onErrorResult("", "Empty Prize", str);
    }
}
