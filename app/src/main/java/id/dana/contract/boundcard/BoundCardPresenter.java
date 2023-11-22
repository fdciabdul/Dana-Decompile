package id.dana.contract.boundcard;

import android.content.Context;
import id.dana.cardbinding.domain.interactor.GetIsCardBindingV2Enabled;
import id.dana.contract.boundcard.BoundCardContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.card.interactor.GetDefaultCard;
import id.dana.domain.card.interactor.SaveLastCardUsed;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckEnableExpressPayFeature;
import id.dana.domain.featureconfig.model.ExpressPayInfo;
import id.dana.domain.payasset.model.PayCardOptionView;
import id.dana.domain.payasset.model.PayChannelOptionView;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.domain.sendmoney.interactor.GetSendMoneyOption;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.richview.boundcard.mapper.BoundCardMapper;
import id.dana.richview.boundcard.model.BoundCard;
import id.dana.utils.ErrorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes8.dex */
public class BoundCardPresenter implements BoundCardContract.Presenter {
    private Context BuiltInFictitiousFunctionClassFactory;
    private final GetDefaultCard KClassImpl$Data$declaredNonStaticMembers$2;
    private final CheckEnableExpressPayFeature MyBillsEntityDataFactory;
    private final GetSendMoneyOption NetworkUserEntityData$$ExternalSyntheticLambda0;
    final BoundCardContract.View PlaceComponentResult;
    private final BoundCardMapper getAuthRequestContext;
    private final SaveLastCardUsed getErrorConfigVersion;
    private final GetIsCardBindingV2Enabled lookAheadTest;
    private final GetPhoneNumber moveToNextValue;

    @Inject
    public BoundCardPresenter(Context context, BoundCardContract.View view, BoundCardMapper boundCardMapper, GetDefaultCard getDefaultCard, GetPhoneNumber getPhoneNumber, GetSendMoneyOption getSendMoneyOption, SaveLastCardUsed saveLastCardUsed, CheckEnableExpressPayFeature checkEnableExpressPayFeature, GetIsCardBindingV2Enabled getIsCardBindingV2Enabled) {
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = boundCardMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getDefaultCard;
        this.moveToNextValue = getPhoneNumber;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getSendMoneyOption;
        this.getErrorConfigVersion = saveLastCardUsed;
        this.MyBillsEntityDataFactory = checkEnableExpressPayFeature;
        this.lookAheadTest = getIsCardBindingV2Enabled;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.moveToNextValue.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.getErrorConfigVersion.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.lookAheadTest.dispose();
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DefaultObserver<SendMoneyInit>() { // from class: id.dana.contract.boundcard.BoundCardPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SendMoneyInit sendMoneyInit = (SendMoneyInit) obj;
                BoundCardContract.View view = BoundCardPresenter.this.PlaceComponentResult;
                BoundCardMapper unused = BoundCardPresenter.this.getAuthRequestContext;
                ArrayList arrayList = new ArrayList();
                arrayList.add(BoundCardMapper.BuiltInFictitiousFunctionClassFactory(sendMoneyInit));
                for (int i = 1; i < sendMoneyInit.getPayOptions().size(); i++) {
                    if (sendMoneyInit.getPayOptions().get(i).getPayMethodView().getPayCardOptionViews() != null) {
                        PayOptionDTOResponse payOptionDTOResponse = sendMoneyInit.getPayOptions().get(i);
                        PayMethodView payMethodView = payOptionDTOResponse.getPayMethodView();
                        List<PayCardOptionView> payCardOptionViews = payMethodView.getPayCardOptionViews();
                        List<PayChannelOptionView> payChannelOptionViews = payMethodView.getPayChannelOptionViews();
                        for (int i2 = 0; i2 < payCardOptionViews.size(); i2++) {
                            PayCardOptionView payCardOptionView = payCardOptionViews.get(i2);
                            BoundCard boundCard = new BoundCard();
                            boundCard.GetContactSyncConfig = payCardOptionView.getMaskedCardNo();
                            ArrayList arrayList2 = new ArrayList();
                            Iterator<PayChannelOptionView> it = payChannelOptionViews.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(BoundCardMapper.BuiltInFictitiousFunctionClassFactory(it.next()));
                            }
                            boundCard.NetworkUserEntityData$$ExternalSyntheticLambda2 = arrayList2;
                            boundCard.BuiltInFictitiousFunctionClassFactory = payCardOptionView.getCardScheme();
                            boundCard.getErrorConfigVersion = payCardOptionView.getExpiryMonth();
                            boundCard.NetworkUserEntityData$$ExternalSyntheticLambda0 = payCardOptionView.getExpiryYear();
                            boundCard.moveToNextValue = Boolean.valueOf(payCardOptionView.isEnableStatus());
                            boundCard.lookAheadTest = payCardOptionView.getInstId();
                            boundCard.KClassImpl$Data$declaredNonStaticMembers$2 = payCardOptionView.getCardIndexNo();
                            boundCard.DatabaseTableConfigUtil = payCardOptionView.getInstName();
                            boundCard.NetworkUserEntityData$$ExternalSyntheticLambda7 = payOptionDTOResponse.getPayMethod();
                            boundCard.NetworkUserEntityData$$ExternalSyntheticLambda1 = payCardOptionView.isPayWithoutCVV();
                            boundCard.PlaceComponentResult = payCardOptionView.getAssetType();
                            arrayList.add(boundCard);
                        }
                    }
                }
                view.onGetBoundCardsSuccess(arrayList);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                BoundCardPresenter.this.PlaceComponentResult.onErrorGetCard(ErrorUtil.BuiltInFictitiousFunctionClassFactory(BoundCardPresenter.this.BuiltInFictitiousFunctionClassFactory));
            }
        });
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.boundcard.BoundCardPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                BoundCardPresenter.this.PlaceComponentResult.onGetDefaultCardSuccess((String) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.boundcard.BoundCardPresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.Presenter
    public final void PlaceComponentResult() {
        this.moveToNextValue.execute(new DefaultObserver<String>() { // from class: id.dana.contract.boundcard.BoundCardPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                BoundCardPresenter.this.PlaceComponentResult.onGetPhoneNumberSuccess((String) obj);
            }
        });
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.Presenter
    public final void PlaceComponentResult(String str) {
        this.getErrorConfigVersion.execute(SaveLastCardUsed.Params.forDefaultCard(str), new Function1() { // from class: id.dana.contract.boundcard.BoundCardPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Boolean bool = (Boolean) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: id.dana.contract.boundcard.BoundCardPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<ExpressPayInfo>() { // from class: id.dana.contract.boundcard.BoundCardPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                BoundCardPresenter.this.PlaceComponentResult.onCheckEnableExpressPayFeature(Boolean.valueOf(((ExpressPayInfo) obj).isEnableInP2P()));
            }
        });
    }

    @Override // id.dana.contract.boundcard.BoundCardContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.lookAheadTest.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.boundcard.BoundCardPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                BoundCardPresenter.this.PlaceComponentResult.onGetIsCardBindingV2Enabled((Boolean) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.boundcard.BoundCardPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                BoundCardPresenter.this.PlaceComponentResult.onGetIsCardBindingV2Enabled(Boolean.FALSE);
                return Unit.INSTANCE;
            }
        });
    }
}
