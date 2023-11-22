package id.dana.familyaccount.contract;

import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.familyaccount.interactor.CreateOrderTopUpFamilyBalance;
import id.dana.domain.familyaccount.interactor.DashboardFamilyAccount;
import id.dana.domain.familyaccount.interactor.GetFamilyAccountMaxMember;
import id.dana.domain.familyaccount.interactor.GetFamilyAvailableServices;
import id.dana.domain.familyaccount.interactor.GetMaxMemberLimit;
import id.dana.domain.familyaccount.interactor.GetTopUpUserConsult;
import id.dana.domain.familyaccount.interactor.InviteFamilyAccount;
import id.dana.domain.familyaccount.interactor.RemoveFamilyMember;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.domain.familyaccount.model.CreateOrderTopupRequest;
import id.dana.domain.familyaccount.model.CreateOrderTopupResult;
import id.dana.domain.familyaccount.model.DashboardFamilyAccountResult;
import id.dana.domain.familyaccount.model.FamilyTopUpConsult;
import id.dana.domain.familyaccount.model.InviteMemberRequest;
import id.dana.domain.familyaccount.model.InviteMemberResult;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.domain.familyaccount.model.RemoveFamilyMemberResult;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import id.dana.familyaccount.mapper.DashboardFamilyAccountResultMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001Ba\b\u0007\u0012\u0006\u0010\u0003\u001a\u000202\u0012\u0006\u00104\u001a\u00020\u0015\u0012\u0006\u00105\u001a\u00020\u001c\u0012\u0006\u00106\u001a\u00020%\u0012\u0006\u00107\u001a\u00020\"\u0012\u0006\u00108\u001a\u00020'\u0012\u0006\u00109\u001a\u00020\u001f\u0012\u0006\u0010:\u001a\u00020\u0019\u0012\u0006\u0010;\u001a\u00020*\u0012\u0006\u0010<\u001a\u00020\u0013\u0012\u0006\u0010=\u001a\u00020\u0017¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016¢\u0006\u0004\b\u000e\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0014\u0010\r\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001a\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010#R\u0014\u0010\u0011\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010&R\u0014\u0010 \u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\u001d\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\u000fX\u0086\"¢\u0006\u0006\n\u0004\b\u0005\u0010.R\u0012\u00101\u001a\u00020\u0002X\u0086\"¢\u0006\u0006\n\u0004\b\r\u00100R\u0014\u0010(\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00103"}, d2 = {"Lid/dana/familyaccount/contract/FamilyDashboardPresenter;", "Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Lid/dana/domain/nearbyme/model/MoneyView;", "PlaceComponentResult", "(Lid/dana/domain/nearbyme/model/MoneyView;)V", "getAuthRequestContext", "()Ljava/lang/String;", "()V", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "(Ljava/util/List;)V", "scheduleImpl", "onDestroy", "Lid/dana/domain/familyaccount/interactor/CreateOrderTopUpFamilyBalance;", "Lid/dana/domain/familyaccount/interactor/CreateOrderTopUpFamilyBalance;", "Lid/dana/domain/familyaccount/interactor/DashboardFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/DashboardFamilyAccount;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/domain/familyaccount/interactor/GetFamilyAccountMaxMember;", "lookAheadTest", "Lid/dana/domain/familyaccount/interactor/GetFamilyAccountMaxMember;", "Lid/dana/domain/familyaccount/interactor/GetFamilyAvailableServices;", "getErrorConfigVersion", "Lid/dana/domain/familyaccount/interactor/GetFamilyAvailableServices;", "Lid/dana/domain/familyaccount/interactor/GetMaxMemberLimit;", "moveToNextValue", "Lid/dana/domain/familyaccount/interactor/GetMaxMemberLimit;", "Lid/dana/domain/familyaccount/interactor/GetTopUpUserConsult;", "Lid/dana/domain/familyaccount/interactor/GetTopUpUserConsult;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/account/interactor/GetUserId;", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;", "GetContactSyncConfig", "Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;", "Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;", "DatabaseTableConfigUtil", "Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/String;", "initRecordTimeStamp", "Lid/dana/familyaccount/contract/FamilyDashboardContract$View;", "Lid/dana/familyaccount/contract/FamilyDashboardContract$View;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Lid/dana/familyaccount/contract/FamilyDashboardContract$View;Lid/dana/domain/familyaccount/interactor/DashboardFamilyAccount;Lid/dana/domain/familyaccount/interactor/GetFamilyAvailableServices;Lid/dana/domain/account/interactor/GetUserId;Lid/dana/domain/familyaccount/interactor/GetTopUpUserConsult;Lid/dana/domain/familyaccount/interactor/RemoveFamilyMember;Lid/dana/domain/familyaccount/interactor/GetMaxMemberLimit;Lid/dana/domain/familyaccount/interactor/GetFamilyAccountMaxMember;Lid/dana/domain/familyaccount/interactor/InviteFamilyAccount;Lid/dana/domain/familyaccount/interactor/CreateOrderTopUpFamilyBalance;Lid/dana/data/config/DeviceInformationProvider;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyDashboardPresenter implements FamilyDashboardContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String initRecordTimeStamp;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final InviteFamilyAccount getErrorConfigVersion;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final RemoveFamilyMember moveToNextValue;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CreateOrderTopUpFamilyBalance getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<AvailableServicesConfig> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetUserId scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final DashboardFamilyAccount BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DeviceInformationProvider MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final GetFamilyAvailableServices PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final FamilyDashboardContract.View GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetFamilyAccountMaxMember KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetMaxMemberLimit lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final GetTopUpUserConsult NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Inject
    public FamilyDashboardPresenter(FamilyDashboardContract.View view, DashboardFamilyAccount dashboardFamilyAccount, GetFamilyAvailableServices getFamilyAvailableServices, GetUserId getUserId, GetTopUpUserConsult getTopUpUserConsult, RemoveFamilyMember removeFamilyMember, GetMaxMemberLimit getMaxMemberLimit, GetFamilyAccountMaxMember getFamilyAccountMaxMember, InviteFamilyAccount inviteFamilyAccount, CreateOrderTopUpFamilyBalance createOrderTopUpFamilyBalance, DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(dashboardFamilyAccount, "");
        Intrinsics.checkNotNullParameter(getFamilyAvailableServices, "");
        Intrinsics.checkNotNullParameter(getUserId, "");
        Intrinsics.checkNotNullParameter(getTopUpUserConsult, "");
        Intrinsics.checkNotNullParameter(removeFamilyMember, "");
        Intrinsics.checkNotNullParameter(getMaxMemberLimit, "");
        Intrinsics.checkNotNullParameter(getFamilyAccountMaxMember, "");
        Intrinsics.checkNotNullParameter(inviteFamilyAccount, "");
        Intrinsics.checkNotNullParameter(createOrderTopUpFamilyBalance, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.GetContactSyncConfig = view;
        this.BuiltInFictitiousFunctionClassFactory = dashboardFamilyAccount;
        this.PlaceComponentResult = getFamilyAvailableServices;
        this.scheduleImpl = getUserId;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getTopUpUserConsult;
        this.moveToNextValue = removeFamilyMember;
        this.lookAheadTest = getMaxMemberLimit;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getFamilyAccountMaxMember;
        this.getErrorConfigVersion = inviteFamilyAccount;
        this.getAuthRequestContext = createOrderTopUpFamilyBalance;
        this.MyBillsEntityDataFactory = deviceInformationProvider;
        getUserId.execute(new DefaultObserver<String>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getCurrentlyLoggedInUserId$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                super.onNext(str);
                FamilyDashboardPresenter familyDashboardPresenter = FamilyDashboardPresenter.this;
                Intrinsics.checkNotNullParameter(str, "");
                familyDashboardPresenter.initRecordTimeStamp = str;
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.GetContactSyncConfig.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<DashboardFamilyAccountResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getFamilyDashboard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DashboardFamilyAccountResult dashboardFamilyAccountResult) {
                invoke2(dashboardFamilyAccountResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DashboardFamilyAccountResult dashboardFamilyAccountResult) {
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(dashboardFamilyAccountResult, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.MyBillsEntityDataFactory(DashboardFamilyAccountResultMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(dashboardFamilyAccountResult));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getFamilyDashboard$2
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
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.GetContactSyncConfig.showProgress();
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<List<? extends AvailableServicesConfig>, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getFamilyAvailableServices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends AvailableServicesConfig> list) {
                invoke2((List<AvailableServicesConfig>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<AvailableServicesConfig> list) {
                FamilyDashboardContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                FamilyDashboardPresenter familyDashboardPresenter = FamilyDashboardPresenter.this;
                Intrinsics.checkNotNullParameter(list, "");
                familyDashboardPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 = list;
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.MyBillsEntityDataFactory(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getFamilyAvailableServices$2
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
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void scheduleImpl() {
        this.GetContactSyncConfig.moveToNextValue();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(NoParams.INSTANCE, new Function1<FamilyTopUpConsult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getTopUpUserConsult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FamilyTopUpConsult familyTopUpConsult) {
                invoke2(familyTopUpConsult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FamilyTopUpConsult familyTopUpConsult) {
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(familyTopUpConsult, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.PlaceComponentResult();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.MyBillsEntityDataFactory(DashboardFamilyAccountResultMapperKt.PlaceComponentResult(familyTopUpConsult));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getTopUpUserConsult$2
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
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.PlaceComponentResult();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<AvailableServicesConfig> list = null;
        if (p0.isEmpty()) {
            List<AvailableServicesConfig> list2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                list2 = null;
            }
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                ((AvailableServicesConfig) it.next()).setEnable(false);
            }
            FamilyDashboardContract.View view = this.GetContactSyncConfig;
            List<AvailableServicesConfig> list3 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (list3 != null) {
                list = list3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            view.BuiltInFictitiousFunctionClassFactory(list);
            return;
        }
        List<AvailableServicesConfig> list4 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list4 = null;
        }
        for (AvailableServicesConfig availableServicesConfig : list4) {
            if (!p0.contains(availableServicesConfig.getUseCase())) {
                availableServicesConfig.setEnable(false);
            }
        }
        FamilyDashboardContract.View view2 = this.GetContactSyncConfig;
        List<AvailableServicesConfig> list5 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (list5 != null) {
            list = list5;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        view2.BuiltInFictitiousFunctionClassFactory(list);
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void PlaceComponentResult() {
        this.GetContactSyncConfig.showProgress();
        this.lookAheadTest.execute(NoParams.INSTANCE, new Function1<MaxMemberLimitConfig, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getMaxMemberLimit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MaxMemberLimitConfig maxMemberLimitConfig) {
                invoke2(maxMemberLimitConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MaxMemberLimitConfig maxMemberLimitConfig) {
                FamilyDashboardContract.View view;
                Intrinsics.checkNotNullParameter(maxMemberLimitConfig, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.BuiltInFictitiousFunctionClassFactory(maxMemberLimitConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getMaxMemberLimit$2
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
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.dismissProgress();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(th.getMessage());
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.moveToNextValue();
        this.moveToNextValue.execute(new RemoveFamilyMember.Params("", p0), new Function1<RemoveFamilyMemberResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$cancelInvitation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RemoveFamilyMemberResult removeFamilyMemberResult) {
                invoke2(removeFamilyMemberResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RemoveFamilyMemberResult removeFamilyMemberResult) {
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(removeFamilyMemberResult, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.PlaceComponentResult();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.scheduleImpl();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$cancelInvitation$2
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
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.PlaceComponentResult();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.getAuthRequestContext(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.moveToNextValue();
        this.getErrorConfigVersion.execute(InviteFamilyAccount.Params.INSTANCE.create(new InviteMemberRequest(false, true, p0, null, null, null, null, 120, null)), new Function1<InviteMemberResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$resendInvitation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(InviteMemberResult inviteMemberResult) {
                invoke2(inviteMemberResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InviteMemberResult inviteMemberResult) {
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(inviteMemberResult, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.PlaceComponentResult();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.getErrorConfigVersion();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$resendInvitation$2
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
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.PlaceComponentResult();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.MyBillsEntityDataFactory(th.getMessage());
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.FAMILY_ACCOUNT_RESEND_INVITE);
                sb.append(FamilyDashboardPresenter.this.getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FAMILY_ACCOUNT, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void PlaceComponentResult(MoneyView p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig.moveToNextValue();
        CreateOrderTopUpFamilyBalance createOrderTopUpFamilyBalance = this.getAuthRequestContext;
        CreateOrderTopUpFamilyBalance.Params.Companion companion = CreateOrderTopUpFamilyBalance.Params.INSTANCE;
        String deviceUUID = this.MyBillsEntityDataFactory.getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        createOrderTopUpFamilyBalance.execute(companion.create(new CreateOrderTopupRequest(deviceUUID, p0)), new Function1<CreateOrderTopupResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$createOrderTopUpFamilybalance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CreateOrderTopupResult createOrderTopupResult) {
                invoke2(createOrderTopupResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CreateOrderTopupResult createOrderTopupResult) {
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(createOrderTopupResult, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.PlaceComponentResult();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.BuiltInFictitiousFunctionClassFactory(createOrderTopupResult.getCheckoutUrl());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$createOrderTopUpFamilybalance$2
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
                FamilyDashboardContract.View view;
                FamilyDashboardContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.PlaceComponentResult();
                view2 = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view2.PlaceComponentResult(th.getMessage());
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getFamilyAccountMaxMember$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                FamilyDashboardContract.View view;
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyDashboardPresenter$getFamilyAccountMaxMember$2
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
                FamilyDashboardContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyDashboardPresenter.this.GetContactSyncConfig;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.scheduleImpl.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.lookAheadTest.dispose();
        this.moveToNextValue.dispose();
        this.getErrorConfigVersion.dispose();
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    @Override // id.dana.familyaccount.contract.FamilyDashboardContract.Presenter
    public final String getAuthRequestContext() {
        String str = this.initRecordTimeStamp;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }
}
