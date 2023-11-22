package id.dana.sendmoney.recipient.recent;

import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckSendMoneyPeerToCash;
import id.dana.domain.featureconfig.interactor.CheckTransferToLinkFeature;
import id.dana.domain.recentrecipient.interactor.GetIsRecentRecipientMigratedToRoom;
import id.dana.domain.recentrecipient.interactor.GetMaxRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetRecentContact;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction;
import id.dana.domain.recentrecipient.interactor.MaskingRecentRecipient;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.sendmoney.interactor.GetRecentGroup;
import id.dana.sendmoney.mapper.RecentRecipientModelMapper;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public class RecentRecipientPresenter implements RecentRecipientContract.Presenter {
    private final GetIsRecentRecipientMigratedToRoom BuiltInFictitiousFunctionClassFactory;
    final RecentRecipientContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    final RecentRecipientModelMapper MyBillsEntityDataFactory;
    private final GetRecentContact NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final CheckSendMoneyPeerToCash PlaceComponentResult;
    private final CheckTransferToLinkFeature getAuthRequestContext;
    private final GetMaxRecentRecipient getErrorConfigVersion;
    private final MaskingRecentRecipient initRecordTimeStamp;
    private final GetRecentGroup lookAheadTest;
    private final GetRecentTransaction moveToNextValue;
    private final GetRecentRecipient scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit MyBillsEntityDataFactory() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit getAuthRequestContext() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit getErrorConfigVersion() {
        return null;
    }

    @Inject
    public RecentRecipientPresenter(RecentRecipientContract.View view, GetRecentRecipient getRecentRecipient, RecentRecipientModelMapper recentRecipientModelMapper, CheckTransferToLinkFeature checkTransferToLinkFeature, CheckSendMoneyPeerToCash checkSendMoneyPeerToCash, MaskingRecentRecipient maskingRecentRecipient, GetMaxRecentRecipient getMaxRecentRecipient, GetRecentTransaction getRecentTransaction, GetRecentContact getRecentContact, GetRecentGroup getRecentGroup, GetIsRecentRecipientMigratedToRoom getIsRecentRecipientMigratedToRoom) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.scheduleImpl = getRecentRecipient;
        this.MyBillsEntityDataFactory = recentRecipientModelMapper;
        this.getAuthRequestContext = checkTransferToLinkFeature;
        this.PlaceComponentResult = checkSendMoneyPeerToCash;
        this.initRecordTimeStamp = maskingRecentRecipient;
        this.getErrorConfigVersion = getMaxRecentRecipient;
        this.moveToNextValue = getRecentTransaction;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getRecentContact;
        this.lookAheadTest = getRecentGroup;
        this.BuiltInFictitiousFunctionClassFactory = getIsRecentRecipientMigratedToRoom;
    }

    /* renamed from: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 extends DefaultObserver<List<RecentRecipient>> {
        final /* synthetic */ RecentRecipientPresenter BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ int MyBillsEntityDataFactory;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            RecentRecipientContract.View unused = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            RecentRecipientModelMapper unused2 = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            RecentRecipientModelMapper.MyBillsEntityDataFactory((List) obj, this.MyBillsEntityDataFactory);
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            RecentRecipientContract.View unused = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.Presenter
    public final void getAuthRequestContext(String str) {
        this.moveToNextValue.dispose();
        this.moveToNextValue.execute(GetRecentTransaction.Params.forSearchRecentTransaction(str), new Function1() { // from class: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                RecentRecipientPresenter recentRecipientPresenter = RecentRecipientPresenter.this;
                RecentRecipientContract.View view = recentRecipientPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
                RecentRecipientModelMapper recentRecipientModelMapper = recentRecipientPresenter.MyBillsEntityDataFactory;
                view.KClassImpl$Data$declaredNonStaticMembers$2(RecentRecipientModelMapper.MyBillsEntityDataFactory((List) obj, 0));
                return null;
            }
        }, new Function1() { // from class: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                RecentRecipientContract.View view = RecentRecipientPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return null;
            }
        });
    }

    @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.lookAheadTest.execute(GetRecentGroup.Params.createParams(str), new Function1() { // from class: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                RecentRecipientPresenter recentRecipientPresenter = RecentRecipientPresenter.this;
                RecentRecipientContract.View view = recentRecipientPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
                RecentRecipientModelMapper recentRecipientModelMapper = recentRecipientPresenter.MyBillsEntityDataFactory;
                view.MyBillsEntityDataFactory(RecentRecipientModelMapper.MyBillsEntityDataFactory((List) obj, 0));
                return null;
            }
        }, new Function1() { // from class: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return RecentRecipientPresenter.getErrorConfigVersion();
            }
        });
    }

    /* renamed from: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass2 extends DefaultObserver<Boolean> {
        final /* synthetic */ RecentRecipientPresenter BuiltInFictitiousFunctionClassFactory;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            Boolean bool = (Boolean) obj;
            RecentRecipientContract.View unused = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* renamed from: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass3 extends DefaultObserver<Boolean> {
        final /* synthetic */ RecentRecipientPresenter KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            Boolean bool = (Boolean) obj;
            RecentRecipientContract.View unused = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                RecentRecipientPresenter recentRecipientPresenter = RecentRecipientPresenter.this;
                RecentRecipientContract.View view = recentRecipientPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
                RecentRecipientModelMapper recentRecipientModelMapper = recentRecipientPresenter.MyBillsEntityDataFactory;
                view.getAuthRequestContext(RecentRecipientModelMapper.MyBillsEntityDataFactory((List) obj, 0));
                return null;
            }
        }, new Function1() { // from class: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return RecentRecipientPresenter.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                RecentRecipientPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(((Boolean) obj).booleanValue());
                return null;
            }
        }, new Function1() { // from class: id.dana.sendmoney.recipient.recent.RecentRecipientPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return RecentRecipientPresenter.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.PlaceComponentResult.dispose();
        this.initRecordTimeStamp.dispose();
        this.getErrorConfigVersion.dispose();
        this.moveToNextValue.dispose();
        this.scheduleImpl.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.lookAheadTest.dispose();
    }
}
