package id.dana.expresspurchase.presenter;

import android.content.Context;
import id.dana.base.BasePresenter;
import id.dana.data.toggle.SplitFacade;
import id.dana.di.PerActivity;
import id.dana.domain.expresspurchase.interaction.DealsExpressOrderQueryByCondition;
import id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase;
import id.dana.domain.expresspurchase.interaction.GetDealsShopLocation;
import id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyDeals;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyGold;
import id.dana.domain.expresspurchase.interaction.GetQuickBuyInsurance;
import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference;
import id.dana.domain.expresspurchase.interaction.ValidateGoldProduct;
import id.dana.domain.expresspurchase.interaction.model.AddonInfo;
import id.dana.domain.expresspurchase.interaction.model.AddonOffer;
import id.dana.domain.expresspurchase.interaction.model.DealsPaymentResult;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import id.dana.domain.expresspurchase.interaction.model.GoldValidationInfo;
import id.dana.domain.expresspurchase.interaction.model.OrderQueryResult;
import id.dana.domain.expresspurchase.interaction.model.PaylaterOffer;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyDeals;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyGold;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyInsurance;
import id.dana.expresspurchase.constant.ExpressPurchaseResult;
import id.dana.expresspurchase.mapper.ExpressPurchasePresenterMapperKt;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.model.OfferExpressPurchaseModel;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.network.exception.NetworkException;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NBi\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020B\u0012\u0006\u0010\u0005\u001a\u00020\u001f\u0012\u0006\u0010\u0006\u001a\u00020#\u0012\u0006\u0010\u0017\u001a\u000209\u0012\u0006\u0010D\u001a\u000202\u0012\u0006\u0010E\u001a\u00020,\u0012\u0006\u0010F\u001a\u00020@\u0012\u0006\u0010G\u001a\u00020/\u0012\u0006\u0010H\u001a\u00020=\u0012\u0006\u0010I\u001a\u00020)\u0012\u0006\u0010J\u001a\u00020!\u0012\u0006\u0010K\u001a\u00020&¢\u0006\u0004\bL\u0010MJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012JA\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00132\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0018J3\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001bJ\u0015\u0010\b\u001a\u00020\u001c*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\b\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001c*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010\b\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010 R\u0014\u0010\u0019\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0014\u0010\u001e\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0011\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\u000f\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u0010*\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0012\u0010$\u001a\u000205X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u00106R\u0012\u0010'\u001a\u000205X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u00106R\u0014\u00108\u001a\u0004\u0018\u00010\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010>R\u0014\u00103\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010AR\u0014\u0010:\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010C"}, d2 = {"Lid/dana/expresspurchase/presenter/ExpressPurchasePresenter;", "Lid/dana/base/BasePresenter;", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "", "p0", "p1", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/expresspurchase/model/OfferExpressPurchaseModel;", "(Lid/dana/expresspurchase/model/OfferExpressPurchaseModel;)V", "onDestroy", "()V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;)V", "PlaceComponentResult", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Deals;)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;", "", "", "", "p3", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Gold;)V", "", "(Ljava/lang/String;)Z", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/expresspurchase/interaction/DealsExpressOrderQueryByCondition;", "Lid/dana/domain/expresspurchase/interaction/DealsExpressOrderQueryByCondition;", "Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase;", "Lid/dana/domain/expresspurchase/interaction/GetDealsShopLocation;", "getErrorConfigVersion", "Lid/dana/domain/expresspurchase/interaction/GetDealsShopLocation;", "Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase;", "scheduleImpl", "Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase;", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyDeals;", "lookAheadTest", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyDeals;", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold;", "moveToNextValue", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold;", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyInsurance;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyInsurance;", "", "I", "Ljava/lang/String;", "DatabaseTableConfigUtil", "Lid/dana/domain/expresspurchase/interaction/SaveLastActionToPreference;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/expresspurchase/interaction/SaveLastActionToPreference;", "initRecordTimeStamp", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "GetContactSyncConfig", "Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct;", "Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct;", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "<init>", "(Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;Landroid/content/Context;Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase;Lid/dana/domain/expresspurchase/interaction/SaveLastActionToPreference;Lid/dana/domain/expresspurchase/interaction/GetQuickBuyInsurance;Lid/dana/domain/expresspurchase/interaction/GetQuickBuyDeals;Lid/dana/domain/expresspurchase/interaction/ValidateGoldProduct;Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold;Lid/dana/data/toggle/SplitFacade;Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase;Lid/dana/domain/expresspurchase/interaction/DealsExpressOrderQueryByCondition;Lid/dana/domain/expresspurchase/interaction/GetDealsShopLocation;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class ExpressPurchasePresenter extends BasePresenter implements ExpressPurchaseContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final SplitFacade GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final ValidateGoldProduct NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    int getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final DealsExpressOrderQueryByCondition getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetAddOnOfferExpressPurchase BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final SaveLastActionToPreference initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final GetQuickBuyInsurance scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final GetDealsShopLocation PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final ExpressPurchaseContract.View NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final GetQuickBuyDeals lookAheadTest;
    private final GetQuickBuyGold moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetPaylaterOfferExpressPurchase MyBillsEntityDataFactory;

    @Inject
    public ExpressPurchasePresenter(ExpressPurchaseContract.View view, Context context, GetAddOnOfferExpressPurchase getAddOnOfferExpressPurchase, SaveLastActionToPreference saveLastActionToPreference, GetQuickBuyInsurance getQuickBuyInsurance, GetQuickBuyDeals getQuickBuyDeals, ValidateGoldProduct validateGoldProduct, GetQuickBuyGold getQuickBuyGold, SplitFacade splitFacade, GetPaylaterOfferExpressPurchase getPaylaterOfferExpressPurchase, DealsExpressOrderQueryByCondition dealsExpressOrderQueryByCondition, GetDealsShopLocation getDealsShopLocation) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(getAddOnOfferExpressPurchase, "");
        Intrinsics.checkNotNullParameter(saveLastActionToPreference, "");
        Intrinsics.checkNotNullParameter(getQuickBuyInsurance, "");
        Intrinsics.checkNotNullParameter(getQuickBuyDeals, "");
        Intrinsics.checkNotNullParameter(validateGoldProduct, "");
        Intrinsics.checkNotNullParameter(getQuickBuyGold, "");
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(getPaylaterOfferExpressPurchase, "");
        Intrinsics.checkNotNullParameter(dealsExpressOrderQueryByCondition, "");
        Intrinsics.checkNotNullParameter(getDealsShopLocation, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = getAddOnOfferExpressPurchase;
        this.initRecordTimeStamp = saveLastActionToPreference;
        this.scheduleImpl = getQuickBuyInsurance;
        this.lookAheadTest = getQuickBuyDeals;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = validateGoldProduct;
        this.moveToNextValue = getQuickBuyGold;
        this.GetContactSyncConfig = splitFacade;
        this.MyBillsEntityDataFactory = getPaylaterOfferExpressPurchase;
        this.getAuthRequestContext = dealsExpressOrderQueryByCondition;
        this.PlaceComponentResult = getDealsShopLocation;
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.initRecordTimeStamp.execute(new SaveLastActionToPreference.Param(p0, p1, p2), new Function1<Boolean, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$saveLastActionToPref$1
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.EXPRESS_PURCHASE_PRESENTER, "Success save last express purchase action");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$saveLastActionToPref$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                String message = th.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.EXPRESS_PURCHASE_PRESENTER, message != null ? message : "", th);
            }
        });
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.Presenter
    public final void PlaceComponentResult(final ExpressPurchaseModel.Deals p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.DatabaseTableConfigUtil == null) {
            this.DatabaseTableConfigUtil = UUID.randomUUID().toString();
        }
        GetQuickBuyDeals getQuickBuyDeals = this.lookAheadTest;
        String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda5;
        String str2 = p0.getErrorConfigVersion;
        String str3 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        String str4 = this.DatabaseTableConfigUtil;
        Intrinsics.checkNotNull(str4);
        getQuickBuyDeals.execute(new GetQuickBuyDeals.Param(str, str2, str3, str4), new Function1<QuickBuyDeals, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$quickBuyDeals$1

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes8.dex */
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] MyBillsEntityDataFactory;

                static {
                    int[] iArr = new int[DealsPaymentResult.values().length];
                    iArr[DealsPaymentResult.PAYMENT_INPROGRESS.ordinal()] = 1;
                    iArr[DealsPaymentResult.PAYMENT_SUCCESS.ordinal()] = 2;
                    iArr[DealsPaymentResult.PAYMENT_ERROR.ordinal()] = 3;
                    iArr[DealsPaymentResult.PAYMENT_FAILED.ordinal()] = 4;
                    MyBillsEntityDataFactory = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QuickBuyDeals quickBuyDeals) {
                invoke2(quickBuyDeals);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QuickBuyDeals quickBuyDeals) {
                ExpressPurchaseContract.View view;
                ExpressPurchaseContract.View view2;
                ExpressPurchaseContract.View view3;
                Intrinsics.checkNotNullParameter(quickBuyDeals, "");
                DealsPaymentResult quickBuyStatus = quickBuyDeals.getQuickBuyStatus();
                int i = quickBuyStatus == null ? -1 : WhenMappings.MyBillsEntityDataFactory[quickBuyStatus.ordinal()];
                if (i == 1 || i == 2) {
                    if (quickBuyDeals.getAcquirementId() != null) {
                        ExpressPurchasePresenter expressPurchasePresenter = ExpressPurchasePresenter.this;
                        String acquirementId = quickBuyDeals.getAcquirementId();
                        Intrinsics.checkNotNull(acquirementId);
                        expressPurchasePresenter.MyBillsEntityDataFactory(acquirementId, p0);
                    }
                } else if (i != 3) {
                    if (i == 4) {
                        ExpressPurchasePresenter.this.DatabaseTableConfigUtil = null;
                        view3 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        view3.PlaceComponentResult("", p0);
                    }
                } else if (ExpressPurchasePresenter.this.getErrorConfigVersion < 3) {
                    ExpressPurchasePresenter.this.getErrorConfigVersion++;
                    view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view, null, null, p0, 3);
                } else {
                    ExpressPurchasePresenter.this.DatabaseTableConfigUtil = null;
                    view2 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    view2.PlaceComponentResult("", p0);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$quickBuyDeals$2
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
                ExpressPurchaseContract.View view;
                ExpressPurchaseContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                if (ExpressPurchasePresenter.this.getErrorConfigVersion >= 3) {
                    view2 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    view2.PlaceComponentResult("", p0);
                    return;
                }
                ExpressPurchasePresenter.this.getErrorConfigVersion++;
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String localizedMessage = th.getLocalizedMessage();
                Intrinsics.checkNotNullExpressionValue(localizedMessage, "");
                ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view, localizedMessage, null, p0, 2);
            }
        });
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (p0.length() == 0) {
            return;
        }
        this.PlaceComponentResult.execute(new GetDealsShopLocation.Param(p0, p1, p2), new Function1<DealsShopInfo, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$getDealsShopLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DealsShopInfo dealsShopInfo) {
                invoke2(dealsShopInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DealsShopInfo dealsShopInfo) {
                ExpressPurchaseContract.View view;
                Intrinsics.checkNotNullParameter(dealsShopInfo, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.MyBillsEntityDataFactory(dealsShopInfo);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$getDealsShopLocation$2
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
                ExpressPurchaseContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    public final void MyBillsEntityDataFactory(final String p0, final ExpressPurchaseModel.Deals p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.execute(new DealsExpressOrderQueryByCondition.Param(p0), new Function1<OrderQueryResult, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$queryOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OrderQueryResult orderQueryResult) {
                invoke2(orderQueryResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OrderQueryResult orderQueryResult) {
                ExpressPurchaseContract.View view;
                ExpressPurchaseContract.View view2;
                DealsExpressOrderQueryByCondition dealsExpressOrderQueryByCondition;
                ExpressPurchaseContract.View view3;
                Intrinsics.checkNotNullParameter(orderQueryResult, "");
                Boolean bizFinished = orderQueryResult.getBizFinished();
                if (bizFinished != null) {
                    if (!Intrinsics.areEqual(bizFinished, Boolean.TRUE)) {
                        if (Intrinsics.areEqual(bizFinished, Boolean.FALSE)) {
                            ExpressPurchasePresenter.this.DatabaseTableConfigUtil = null;
                            view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            view.PlaceComponentResult(orderQueryResult.getProductCode(), p1);
                            return;
                        }
                        return;
                    }
                    ExpressPurchasePresenter.this.DatabaseTableConfigUtil = null;
                    view2 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    view2.BuiltInFictitiousFunctionClassFactory(orderQueryResult.getProductCode(), p1);
                } else if (ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0 < 3) {
                    dealsExpressOrderQueryByCondition = ExpressPurchasePresenter.this.getAuthRequestContext;
                    dealsExpressOrderQueryByCondition.dispose();
                    ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0++;
                    ExpressPurchasePresenter.this.MyBillsEntityDataFactory(p0, p1);
                } else {
                    ExpressPurchasePresenter.this.DatabaseTableConfigUtil = null;
                    view3 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    view3.MyBillsEntityDataFactory(orderQueryResult.getProductCode(), p1);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$queryOrder$2
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
                ExpressPurchaseContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String localizedMessage = th.getLocalizedMessage();
                ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view, localizedMessage != null ? localizedMessage : "", null, p1, 2);
            }
        });
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.Presenter
    public final void getAuthRequestContext(String p0, String p1, Map<String, String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult();
        this.scheduleImpl.execute(new GetQuickBuyInsurance.Param(p0, p1, p2), new Function1<QuickBuyInsurance, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$quickBuyInsurance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QuickBuyInsurance quickBuyInsurance) {
                invoke2(quickBuyInsurance);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QuickBuyInsurance quickBuyInsurance) {
                ExpressPurchaseContract.View view;
                ExpressPurchaseContract.View view2;
                ExpressPurchaseContract.View view3;
                Intrinsics.checkNotNullParameter(quickBuyInsurance, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.getAuthRequestContext();
                String errorCode = quickBuyInsurance.getErrorCode();
                boolean z = false;
                if (errorCode != null) {
                    if (errorCode.length() > 0) {
                        z = true;
                    }
                }
                if (z) {
                    view3 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view3, ExpressPurchaseResult.PREV_SCREEN_LOADING, "pending", quickBuyInsurance.getAcquirementId(), null, 8);
                    return;
                }
                view2 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view2, ExpressPurchaseResult.PREV_SCREEN_LOADING, "success", null, null, 12);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$quickBuyInsurance$2
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
                ExpressPurchaseContract.View view;
                ExpressPurchaseContract.View view2;
                ExpressPurchaseContract.View view3;
                Intrinsics.checkNotNullParameter(th, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.getAuthRequestContext();
                if (th instanceof NetworkException) {
                    view3 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view3, ExpressPurchaseResult.PREV_SCREEN_LOADING, "failed", null, null, 12);
                } else {
                    view2 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view2, ExpressPurchaseResult.PREV_SCREEN_LOADING, ExpressPurchaseResult.GENERAL_ERROR, null, null, 12);
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.EXPRESS_PURCHASE_PRESENTER, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.Presenter
    public final void getAuthRequestContext(final ExpressPurchaseModel.Gold p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(ValidateGoldProduct.Params.INSTANCE.create(p0.MyBillsEntityDataFactory, p0.NetworkUserEntityData$$ExternalSyntheticLambda1, p0.DatabaseTableConfigUtil), new Function1<GoldValidationInfo, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$validateGoldProduct$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(GoldValidationInfo goldValidationInfo) {
                invoke2(goldValidationInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GoldValidationInfo goldValidationInfo) {
                ExpressPurchaseContract.View view;
                ExpressPurchaseContract.View view2;
                Intrinsics.checkNotNullParameter(goldValidationInfo, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.BuiltInFictitiousFunctionClassFactory();
                ExpressPurchaseModel.Gold MyBillsEntityDataFactory = ExpressPurchaseModel.Gold.MyBillsEntityDataFactory(p0, goldValidationInfo.getValidationTypes(), goldValidationInfo.getValidationInfo(), goldValidationInfo.getProductValidateStatusInfo().getThirdRefId());
                view2 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view2.getAuthRequestContext(false, "", MyBillsEntityDataFactory);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$validateGoldProduct$2
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
                ExpressPurchaseContract.View view;
                ExpressPurchaseContract.View view2;
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                boolean BuiltInFictitiousFunctionClassFactory;
                ExpressPurchaseContract.View view3;
                ExpressPurchaseContract.View view4;
                ExpressPurchaseContract.View view5;
                Intrinsics.checkNotNullParameter(th, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.BuiltInFictitiousFunctionClassFactory();
                if (!(th instanceof NetworkException)) {
                    view2 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    view2.onError(th.getLocalizedMessage());
                } else {
                    NetworkException networkException = (NetworkException) th;
                    KClassImpl$Data$declaredNonStaticMembers$2 = ExpressPurchasePresenter.KClassImpl$Data$declaredNonStaticMembers$2(networkException.getErrorCode());
                    if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                        BuiltInFictitiousFunctionClassFactory = ExpressPurchasePresenter.BuiltInFictitiousFunctionClassFactory(networkException.getErrorCode());
                        if (BuiltInFictitiousFunctionClassFactory) {
                            view4 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view4, ExpressPurchaseResult.PREV_SCREEN_CONFIRMATION, ExpressPurchaseResult.FAILED_NOT_ENOUGH_BALANCE_RESULT, null, p0, 4);
                        } else {
                            view3 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            view3.onError(networkException.getLocalizedMessage());
                        }
                    } else {
                        Map<String, Object> epValidationInfo = networkException.getEpValidationInfo();
                        List<String> epValidationTypes = networkException.getEpValidationTypes();
                        String str = networkException.getErrorActions().get("thirdRefId");
                        ExpressPurchaseModel.Gold gold = p0;
                        Intrinsics.checkNotNullExpressionValue(epValidationTypes, "");
                        Intrinsics.checkNotNullExpressionValue(epValidationInfo, "");
                        ExpressPurchaseModel.Gold MyBillsEntityDataFactory = ExpressPurchaseModel.Gold.MyBillsEntityDataFactory(gold, epValidationTypes, epValidationInfo, str);
                        String str2 = networkException.getErrorActions().get("newPrice");
                        if (str2 != null) {
                            view5 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            view5.getAuthRequestContext(true, str2, MyBillsEntityDataFactory);
                        }
                    }
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.EXPRESS_PURCHASE_PRESENTER, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.Presenter
    public final void PlaceComponentResult(final ExpressPurchaseModel.Gold p0, List<String> p1, Map<String, ? extends Object> p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult();
        this.moveToNextValue.execute(new GetQuickBuyGold.Params(p0.MyBillsEntityDataFactory, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.PlaceComponentResult, p0.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, p0.GetContactSyncConfig, p3, p1, p2), new Function1<QuickBuyGold, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$quickBuyGold$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QuickBuyGold quickBuyGold) {
                invoke2(quickBuyGold);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QuickBuyGold quickBuyGold) {
                ExpressPurchaseContract.View view;
                Intrinsics.checkNotNullParameter(quickBuyGold, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.getAuthRequestContext();
                ExpressPurchasePresenter.KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchasePresenter.this, quickBuyGold, p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$quickBuyGold$2
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
                ExpressPurchaseContract.View view;
                ExpressPurchaseContract.View view2;
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                boolean BuiltInFictitiousFunctionClassFactory;
                ExpressPurchaseContract.View view3;
                ExpressPurchaseContract.View view4;
                Intrinsics.checkNotNullParameter(th, "");
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.getAuthRequestContext();
                if (!(th instanceof NetworkException)) {
                    view2 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view2, ExpressPurchaseResult.PREV_SCREEN_LOADING, ExpressPurchaseResult.GENERAL_ERROR, null, p0, 4);
                } else {
                    NetworkException networkException = (NetworkException) th;
                    KClassImpl$Data$declaredNonStaticMembers$2 = ExpressPurchasePresenter.KClassImpl$Data$declaredNonStaticMembers$2(networkException.getErrorCode());
                    if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                        BuiltInFictitiousFunctionClassFactory = ExpressPurchasePresenter.BuiltInFictitiousFunctionClassFactory(networkException.getErrorCode());
                        if (BuiltInFictitiousFunctionClassFactory) {
                            view4 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view4, ExpressPurchaseResult.PREV_SCREEN_LOADING, ExpressPurchaseResult.FAILED_NOT_ENOUGH_BALANCE_RESULT, null, p0, 4);
                        } else {
                            view3 = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(view3, ExpressPurchaseResult.PREV_SCREEN_LOADING, "failed", null, p0, 4);
                        }
                    } else {
                        Map<String, Object> epValidationInfo = networkException.getEpValidationInfo();
                        List<String> epValidationTypes = networkException.getEpValidationTypes();
                        ExpressPurchaseModel.Gold gold = p0;
                        Intrinsics.checkNotNullExpressionValue(epValidationTypes, "");
                        Intrinsics.checkNotNullExpressionValue(epValidationInfo, "");
                        ExpressPurchaseModel.Gold MyBillsEntityDataFactory = ExpressPurchaseModel.Gold.MyBillsEntityDataFactory(gold, epValidationTypes, epValidationInfo, p3);
                        String str = networkException.getErrorActions().get("newPrice");
                        if (str != null) {
                            ExpressPurchasePresenter.KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchasePresenter.this, str, MyBillsEntityDataFactory);
                        }
                    }
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.EXPRESS_PURCHASE_PRESENTER, th.getMessage(), th);
            }
        });
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        String str2 = str;
        return !(str2 == null || StringsKt.isBlank(str2)) && Intrinsics.areEqual(str, "AE15101858018058");
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        String str2 = str;
        return !(str2 == null || StringsKt.isBlank(str2)) && Intrinsics.areEqual(str, "AE15101858018060");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.initRecordTimeStamp.dispose();
        this.scheduleImpl.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
        this.moveToNextValue.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.lookAheadTest.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchasePresenter expressPurchasePresenter, String str, ExpressPurchaseModel.Gold gold) {
        String str2 = gold.initRecordTimeStamp;
        if (str2 != null) {
            expressPurchasePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(str, gold, gold.NetworkUserEntityData$$ExternalSyntheticLambda1, gold.DatabaseTableConfigUtil, str2);
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(ExpressPurchasePresenter expressPurchasePresenter, final Function0 function0) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Scheduler KClassImpl$Data$declaredNonStaticMembers$22;
        Completable MyBillsEntityDataFactory = Completable.MyBillsEntityDataFactory();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$23 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableDelay(MyBillsEntityDataFactory, 1200L, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
        KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$24 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$23, KClassImpl$Data$declaredNonStaticMembers$22));
        Scheduler PlaceComponentResult = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$25 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$24, PlaceComponentResult));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$25, "");
        expressPurchasePresenter.addDisposable(SubscribersKt.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$25, null, new Function0<Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$delayToShow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        }, 1));
    }

    public static final /* synthetic */ void getAuthRequestContext(final ExpressPurchasePresenter expressPurchasePresenter, final OfferExpressPurchaseModel offerExpressPurchaseModel) {
        if (offerExpressPurchaseModel.getGetAuthRequestContext()) {
            return;
        }
        expressPurchasePresenter.MyBillsEntityDataFactory.execute(GetPaylaterOfferExpressPurchase.Params.INSTANCE.create(offerExpressPurchaseModel.MyBillsEntityDataFactory), new Function1<PaylaterOffer, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$onSuccessGetPaylaterOfferExpressPurchase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PaylaterOffer paylaterOffer) {
                invoke2(paylaterOffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final PaylaterOffer paylaterOffer) {
                Intrinsics.checkNotNullParameter(paylaterOffer, "");
                final OfferExpressPurchaseModel offerExpressPurchaseModel2 = OfferExpressPurchaseModel.this;
                final ExpressPurchasePresenter expressPurchasePresenter2 = expressPurchasePresenter;
                if (paylaterOffer.getHasOffer()) {
                    ExpressPurchasePresenter.getAuthRequestContext(expressPurchasePresenter2, new Function0<Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$onSuccessGetPaylaterOfferExpressPurchase$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchasePresenterMapperKt.MyBillsEntityDataFactory(paylaterOffer, offerExpressPurchaseModel2.MyBillsEntityDataFactory, offerExpressPurchaseModel2.KClassImpl$Data$declaredNonStaticMembers$2, offerExpressPurchaseModel2.scheduleImpl, offerExpressPurchaseModel2.getErrorConfigVersion, offerExpressPurchaseModel2.BuiltInFictitiousFunctionClassFactory));
                        }
                    });
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$onErrorPayLaterOfferExpressPurchase$1
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
                ExpressPurchaseContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.EXPRESS_PURCHASE_PRESENTER, th.getMessage(), th);
                view = ExpressPurchasePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                view.onError(th.getLocalizedMessage());
            }
        });
    }

    public static final /* synthetic */ void PlaceComponentResult(ExpressPurchasePresenter expressPurchasePresenter, AddonOffer addonOffer, OfferExpressPurchaseModel offerExpressPurchaseModel) {
        String str = offerExpressPurchaseModel.MyBillsEntityDataFactory;
        String str2 = offerExpressPurchaseModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str3 = offerExpressPurchaseModel.scheduleImpl;
        String str4 = offerExpressPurchaseModel.getErrorConfigVersion;
        String str5 = offerExpressPurchaseModel.BuiltInFictitiousFunctionClassFactory;
        AddonInfo addonInfo = addonOffer.getAddonInfo();
        ExpressPurchaseModel authRequestContext = addonInfo != null ? ExpressPurchasePresenterMapperKt.getAuthRequestContext(addonInfo, expressPurchasePresenter.KClassImpl$Data$declaredNonStaticMembers$2, str, str2, str3, str4, str5) : null;
        if (authRequestContext != null) {
            expressPurchasePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchasePresenter expressPurchasePresenter, QuickBuyGold quickBuyGold, ExpressPurchaseModel.Gold gold) {
        String errorCode = quickBuyGold.getErrorCode();
        Unit unit = null;
        if (errorCode != null) {
            if ((!StringsKt.isBlank(errorCode)) == false) {
                errorCode = null;
            }
            if (errorCode != null) {
                if (Intrinsics.areEqual(errorCode, "AE15101858018060")) {
                    ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(expressPurchasePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1, ExpressPurchaseResult.PREV_SCREEN_LOADING, ExpressPurchaseResult.FAILED_NOT_ENOUGH_BALANCE_RESULT, null, gold, 4);
                } else {
                    expressPurchasePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory(ExpressPurchaseResult.PREV_SCREEN_LOADING, "pending", quickBuyGold.getAcquirementId(), gold);
                }
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            ExpressPurchaseContract.View.CC.BuiltInFictitiousFunctionClassFactory(expressPurchasePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1, ExpressPurchaseResult.PREV_SCREEN_LOADING, "success", null, gold, 4);
        }
    }

    @Override // id.dana.expresspurchase.presenter.ExpressPurchaseContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final OfferExpressPurchaseModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SplitFacade.PlaceComponentResult("addonid", p0.MyBillsEntityDataFactory);
        this.BuiltInFictitiousFunctionClassFactory.execute(GetAddOnOfferExpressPurchase.Params.INSTANCE.create(p0.MyBillsEntityDataFactory, p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.PlaceComponentResult, p0.moveToNextValue), new Function1<AddonOffer, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$onSuccessGetAddOnOfferExpressPurchase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(AddonOffer addonOffer) {
                invoke2(addonOffer);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final AddonOffer addonOffer) {
                Intrinsics.checkNotNullParameter(addonOffer, "");
                if (addonOffer.getHasOffer()) {
                    ExpressPurchasePresenter expressPurchasePresenter = ExpressPurchasePresenter.this;
                    final ExpressPurchasePresenter expressPurchasePresenter2 = ExpressPurchasePresenter.this;
                    final OfferExpressPurchaseModel offerExpressPurchaseModel = p0;
                    ExpressPurchasePresenter.getAuthRequestContext(expressPurchasePresenter, new Function0<Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$onSuccessGetAddOnOfferExpressPurchase$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ExpressPurchasePresenter.PlaceComponentResult(ExpressPurchasePresenter.this, addonOffer, offerExpressPurchaseModel);
                        }
                    });
                    return;
                }
                ExpressPurchasePresenter.getAuthRequestContext(ExpressPurchasePresenter.this, p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.expresspurchase.presenter.ExpressPurchasePresenter$getOfferExpressPurchase$1$1
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
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.EXPRESS_PURCHASE_PRESENTER, th.getMessage(), th);
                ExpressPurchasePresenter.getAuthRequestContext(ExpressPurchasePresenter.this, p0);
            }
        });
    }
}
