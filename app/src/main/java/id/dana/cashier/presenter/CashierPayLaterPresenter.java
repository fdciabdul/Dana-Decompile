package id.dana.cashier.presenter;

import android.content.Context;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.domain.interactor.GetLoanRegistrationInfo;
import id.dana.cashier.domain.interactor.GetPaylaterCicilOnboardingContent;
import id.dana.cashier.domain.interactor.GetPaylaterCicilRegistrationCooldownCache;
import id.dana.cashier.domain.interactor.GetQueryInstallment;
import id.dana.cashier.domain.interactor.SavePaylaterCicilRegistrationCacheCooldownCount;
import id.dana.cashier.domain.interactor.SavePaylaterCicilRegistrationCacheCooldownDelay;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.domain.model.MixPayMethod;
import id.dana.cashier.domain.model.paylater.LoanRegisterResultInfo;
import id.dana.cashier.domain.model.paylater.PaylaterRegistrationCooldownCache;
import id.dana.cashier.domain.model.paylater.QueryInstallment;
import id.dana.cashier.domain.model.paylater.QueryInstallmentRequest;
import id.dana.cashier.mapper.CashierPayMethodModelMapper;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.ConsultAgreementModelKt;
import id.dana.cashier.model.PaylaterOnboardingContentModel;
import id.dana.cashier.model.QueryInstallmentModel;
import id.dana.cashier.model.QueryInstallmentModelKt;
import id.dana.cashier.model.QueryInstallmentRequestModel;
import id.dana.cashier.utils.QueryInstallmentCacheManager;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.domain.paylater.interactor.ClearCachePayLaterLoanWhitelist;
import id.dana.domain.paylater.interactor.UpdatePayLaterLoanCache;
import id.dana.domain.paylater.model.PayLaterLoanWhitelist;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.model.AgreementInfo;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.utils.ErrorUtil;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 S2\u00020\u0001:\u0001SBq\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020)\u0012\u0006\u0010\u0006\u001a\u00020G\u0012\u0006\u0010\b\u001a\u000208\u0012\u0006\u0010\r\u001a\u000202\u0012\u0006\u0010\u001f\u001a\u00020.\u0012\u0006\u0010I\u001a\u00020#\u0012\u0006\u0010J\u001a\u00020+\u0012\u0006\u0010K\u001a\u00020'\u0012\u0006\u0010L\u001a\u00020%\u0012\u0006\u0010M\u001a\u000205\u0012\u0006\u0010N\u001a\u00020<\u0012\u0006\u0010O\u001a\u00020@\u0012\u0006\u0010P\u001a\u00020C¢\u0006\u0004\bQ\u0010RJ-\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000fJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J5\u0010\u0014\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0016J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u000fJO\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001e2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010 J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010!J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\"J\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u000fR\u0014\u0010\u0019\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010$R\u0014\u0010\u0012\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010&R\u0014\u0010\u001b\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010(R\u0014\u0010\n\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010*R\u0014\u0010\u0014\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u0010/\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00106\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00109R\u0013\u0010,\u001a\u00020:X\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010;R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010=\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010A\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010H"}, d2 = {"Lid/dana/cashier/presenter/CashierPayLaterPresenter;", "Lid/dana/cashier/CashierPayLaterContract$Presenter;", "", "Lid/dana/cashier/model/CashierPayMethodModel;", "p0", "", "p1", "", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;Ljava/lang/String;)V", "", "p3", "(IILjava/util/List;Ljava/lang/String;)V", "()V", "Lid/dana/cashier/model/QueryInstallmentRequestModel;", "Lid/dana/cashier/domain/interactor/GetQueryInstallment$Params;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/QueryInstallmentRequestModel;ZLid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/domain/interactor/GetQueryInstallment$Params;", "getAuthRequestContext", "(Ljava/util/List;Ljava/lang/String;IZ)V", "(Ljava/lang/String;)V", "(Lid/dana/cashier/model/QueryInstallmentRequestModel;Lid/dana/cashier/model/CashierPayMethodModel;)V", "", "MyBillsEntityDataFactory", "(JI)Z", "PlaceComponentResult", "(ZLjava/lang/String;)V", "onDestroy", "", "p4", "(Lid/dana/cashier/model/QueryInstallmentRequestModel;Lid/dana/cashier/model/CashierPayMethodModel;Ljava/util/Map;Ljava/util/List;Z)V", "(I)V", "(J)V", "Lid/dana/cashier/mapper/CashierPayMethodModelMapper;", "Lid/dana/cashier/mapper/CashierPayMethodModelMapper;", "Lid/dana/domain/paylater/interactor/ClearCachePayLaterLoanWhitelist;", "Lid/dana/domain/paylater/interactor/ClearCachePayLaterLoanWhitelist;", "Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;", "Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/config/DeviceInformationProvider;", "scheduleImpl", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/cashier/domain/interactor/GetLoanRegistrationInfo;", "moveToNextValue", "Lid/dana/cashier/domain/interactor/GetLoanRegistrationInfo;", "getErrorConfigVersion", "Lid/dana/cashier/domain/interactor/GetPaylaterCicilOnboardingContent;", "lookAheadTest", "Lid/dana/cashier/domain/interactor/GetPaylaterCicilOnboardingContent;", "Lid/dana/cashier/domain/interactor/GetPaylaterCicilRegistrationCooldownCache;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/cashier/domain/interactor/GetPaylaterCicilRegistrationCooldownCache;", "Lid/dana/cashier/domain/interactor/GetQueryInstallment;", "Lid/dana/cashier/domain/interactor/GetQueryInstallment;", "Lid/dana/cashier/utils/QueryInstallmentCacheManager;", "Lkotlin/Lazy;", "Lid/dana/cashier/domain/interactor/SavePaylaterCicilRegistrationCacheCooldownCount;", "GetContactSyncConfig", "Lid/dana/cashier/domain/interactor/SavePaylaterCicilRegistrationCacheCooldownCount;", "initRecordTimeStamp", "Lid/dana/cashier/domain/interactor/SavePaylaterCicilRegistrationCacheCooldownDelay;", "DatabaseTableConfigUtil", "Lid/dana/cashier/domain/interactor/SavePaylaterCicilRegistrationCacheCooldownDelay;", "Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/cashier/CashierPayLaterContract$View;", "Lid/dana/cashier/CashierPayLaterContract$View;", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(Landroid/content/Context;Lid/dana/cashier/CashierPayLaterContract$View;Lid/dana/cashier/domain/interactor/GetQueryInstallment;Lid/dana/cashier/domain/interactor/GetPaylaterCicilOnboardingContent;Lid/dana/cashier/domain/interactor/GetLoanRegistrationInfo;Lid/dana/cashier/mapper/CashierPayMethodModelMapper;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;Lid/dana/domain/paylater/interactor/ClearCachePayLaterLoanWhitelist;Lid/dana/cashier/domain/interactor/GetPaylaterCicilRegistrationCooldownCache;Lid/dana/cashier/domain/interactor/SavePaylaterCicilRegistrationCacheCooldownCount;Lid/dana/cashier/domain/interactor/SavePaylaterCicilRegistrationCacheCooldownDelay;Lid/dana/domain/paylater/interactor/UpdatePayLaterLoanCache;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class CashierPayLaterPresenter implements CashierPayLaterContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ClearCachePayLaterLoanWhitelist KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final SavePaylaterCicilRegistrationCacheCooldownDelay GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final SavePaylaterCicilRegistrationCacheCooldownCount initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CashierPayMethodModelMapper MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final GetPaylaterCicilRegistrationCooldownCache moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final UpdatePayLaterLoanCache NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final CashierPayLaterContract.View DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Lazy scheduleImpl;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ConsultAgreementOnlyParamSpaceCodes PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final GetQueryInstallment NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final GetPaylaterCicilOnboardingContent lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final GetLoanRegistrationInfo getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final DeviceInformationProvider getAuthRequestContext;

    public static final /* synthetic */ String PlaceComponentResult(String str, String str2) {
        return str2 != null ? str2 : str;
    }

    @Inject
    public CashierPayLaterPresenter(Context context, CashierPayLaterContract.View view, GetQueryInstallment getQueryInstallment, GetPaylaterCicilOnboardingContent getPaylaterCicilOnboardingContent, GetLoanRegistrationInfo getLoanRegistrationInfo, CashierPayMethodModelMapper cashierPayMethodModelMapper, DeviceInformationProvider deviceInformationProvider, ConsultAgreementOnlyParamSpaceCodes consultAgreementOnlyParamSpaceCodes, ClearCachePayLaterLoanWhitelist clearCachePayLaterLoanWhitelist, GetPaylaterCicilRegistrationCooldownCache getPaylaterCicilRegistrationCooldownCache, SavePaylaterCicilRegistrationCacheCooldownCount savePaylaterCicilRegistrationCacheCooldownCount, SavePaylaterCicilRegistrationCacheCooldownDelay savePaylaterCicilRegistrationCacheCooldownDelay, UpdatePayLaterLoanCache updatePayLaterLoanCache) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getQueryInstallment, "");
        Intrinsics.checkNotNullParameter(getPaylaterCicilOnboardingContent, "");
        Intrinsics.checkNotNullParameter(getLoanRegistrationInfo, "");
        Intrinsics.checkNotNullParameter(cashierPayMethodModelMapper, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(consultAgreementOnlyParamSpaceCodes, "");
        Intrinsics.checkNotNullParameter(clearCachePayLaterLoanWhitelist, "");
        Intrinsics.checkNotNullParameter(getPaylaterCicilRegistrationCooldownCache, "");
        Intrinsics.checkNotNullParameter(savePaylaterCicilRegistrationCacheCooldownCount, "");
        Intrinsics.checkNotNullParameter(savePaylaterCicilRegistrationCacheCooldownDelay, "");
        Intrinsics.checkNotNullParameter(updatePayLaterLoanCache, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.DatabaseTableConfigUtil = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getQueryInstallment;
        this.lookAheadTest = getPaylaterCicilOnboardingContent;
        this.getErrorConfigVersion = getLoanRegistrationInfo;
        this.MyBillsEntityDataFactory = cashierPayMethodModelMapper;
        this.getAuthRequestContext = deviceInformationProvider;
        this.PlaceComponentResult = consultAgreementOnlyParamSpaceCodes;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = clearCachePayLaterLoanWhitelist;
        this.moveToNextValue = getPaylaterCicilRegistrationCooldownCache;
        this.initRecordTimeStamp = savePaylaterCicilRegistrationCacheCooldownCount;
        this.GetContactSyncConfig = savePaylaterCicilRegistrationCacheCooldownDelay;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = updatePayLaterLoanCache;
        Lazy lazy = LazyKt.lazy(new Function0<QueryInstallmentCacheManager>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$queryInstallmentCacheManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QueryInstallmentCacheManager invoke() {
                return new QueryInstallmentCacheManager();
            }
        });
        this.scheduleImpl = lazy;
        QueryInstallmentCacheManager queryInstallmentCacheManager = (QueryInstallmentCacheManager) lazy.getValue();
        queryInstallmentCacheManager.PlaceComponentResult.clear();
        queryInstallmentCacheManager.BuiltInFictitiousFunctionClassFactory.clear();
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final QueryInstallmentRequestModel p0, final CashierPayMethodModel p1, final Map<String, Boolean> p2, final List<String> p3, boolean p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p4) {
            BuiltInFictitiousFunctionClassFactory(p0, p1);
            return;
        }
        QueryInstallmentCacheManager queryInstallmentCacheManager = (QueryInstallmentCacheManager) this.scheduleImpl.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(JSONExtKt.PlaceComponentResult().toJson(p2));
        sb.append('_');
        sb.append(QueryInstallmentCacheManager.KClassImpl$Data$declaredNonStaticMembers$2(p3));
        QueryInstallmentModel queryInstallmentModel = queryInstallmentCacheManager.PlaceComponentResult.get(sb.toString());
        if (queryInstallmentModel != null) {
            this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(queryInstallmentModel, null);
            return;
        }
        String str = p0.MyBillsEntityDataFactory;
        String initRecordTimeStamp = p1 != null ? p1.initRecordTimeStamp() : null;
        if (initRecordTimeStamp != null) {
            str = initRecordTimeStamp;
        }
        PlaceComponentResult(true, str);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(KClassImpl$Data$declaredNonStaticMembers$2(p0, p1 != null ? p1.getKClassImpl$Data$declaredNonStaticMembers$2() : false, p1), new Function1<QueryInstallment, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$doRefreshQueryInstallment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryInstallment queryInstallment) {
                invoke2(queryInstallment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryInstallment queryInstallment) {
                CashierPayLaterContract.View view;
                Intrinsics.checkNotNullParameter(queryInstallment, "");
                QueryInstallmentModel MyBillsEntityDataFactory = QueryInstallmentModelKt.MyBillsEntityDataFactory(queryInstallment);
                CashierPayLaterPresenter cashierPayLaterPresenter = CashierPayLaterPresenter.this;
                Map<String, Boolean> map = p2;
                List<String> list = p3;
                QueryInstallmentCacheManager queryInstallmentCacheManager2 = (QueryInstallmentCacheManager) cashierPayLaterPresenter.scheduleImpl.getValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(JSONExtKt.PlaceComponentResult().toJson(map));
                sb2.append('_');
                sb2.append(QueryInstallmentCacheManager.KClassImpl$Data$declaredNonStaticMembers$2(list));
                queryInstallmentCacheManager2.PlaceComponentResult.put(sb2.toString(), MyBillsEntityDataFactory);
                view = cashierPayLaterPresenter.DatabaseTableConfigUtil;
                view.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, null);
                CashierPayLaterPresenter cashierPayLaterPresenter2 = CashierPayLaterPresenter.this;
                String str2 = p0.MyBillsEntityDataFactory;
                CashierPayMethodModel cashierPayMethodModel = p1;
                cashierPayLaterPresenter2.PlaceComponentResult(false, CashierPayLaterPresenter.PlaceComponentResult(str2, cashierPayMethodModel != null ? cashierPayMethodModel.initRecordTimeStamp() : null));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$doRefreshQueryInstallment$2
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
                CashierPayLaterContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                CashierPayLaterPresenter cashierPayLaterPresenter = CashierPayLaterPresenter.this;
                String str2 = p0.MyBillsEntityDataFactory;
                CashierPayMethodModel cashierPayMethodModel = p1;
                cashierPayLaterPresenter.PlaceComponentResult(false, CashierPayLaterPresenter.PlaceComponentResult(str2, cashierPayMethodModel != null ? cashierPayMethodModel.initRecordTimeStamp() : null));
                view = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final int p0, final int p1, final List<String> p2, final String p3) {
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.moveToNextValue.execute(NoParams.INSTANCE, new Function1<PaylaterRegistrationCooldownCache, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$checkPaylaterCicilRegistrationCacheCooldown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PaylaterRegistrationCooldownCache paylaterRegistrationCooldownCache) {
                invoke2(paylaterRegistrationCooldownCache);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PaylaterRegistrationCooldownCache paylaterRegistrationCooldownCache) {
                boolean MyBillsEntityDataFactory;
                CashierPayLaterContract.View view;
                Intrinsics.checkNotNullParameter(paylaterRegistrationCooldownCache, "");
                MyBillsEntityDataFactory = CashierPayLaterPresenter.MyBillsEntityDataFactory(paylaterRegistrationCooldownCache.getCacheCooldownDelayStartTime(), p1);
                if (MyBillsEntityDataFactory && paylaterRegistrationCooldownCache.getCacheCooldownDelayStartTime() != 0) {
                    CashierPayLaterPresenter.BuiltInFictitiousFunctionClassFactory(CashierPayLaterPresenter.this);
                    CashierPayLaterContract.Presenter.CC.PlaceComponentResult(CashierPayLaterPresenter.this, p2, p3, 0, false, 8);
                } else if (paylaterRegistrationCooldownCache.getCacheCooldownCount() >= p0) {
                    view = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                    view.MyBillsEntityDataFactory();
                } else {
                    CashierPayLaterContract.Presenter.CC.PlaceComponentResult(CashierPayLaterPresenter.this, p2, p3, paylaterRegistrationCooldownCache.getCacheCooldownCount(), false, 8);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$checkPaylaterCicilRegistrationCacheCooldown$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("[CashierGetShowPaylaterCicilOnboarding]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void getAuthRequestContext(List<String> p0, final String p1, final int p2, final boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.DatabaseTableConfigUtil.showProgress();
        this.PlaceComponentResult.execute(new ConsultAgreementOnlyParamSpaceCodes.Params(p0, Boolean.TRUE), new Function1<ConsultAgreementResponse, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$consultAgreement$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConsultAgreementResponse consultAgreementResponse) {
                invoke2(consultAgreementResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultAgreementResponse consultAgreementResponse) {
                CashierPayLaterContract.View view;
                CashierPayLaterContract.View view2;
                CashierPayLaterContract.View view3;
                CashierPayLaterContract.View view4;
                AgreementInfo agreementInfo;
                Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
                view = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view.dismissProgress();
                List<AgreementInfo> agreementInfos = consultAgreementResponse.getAgreementInfos();
                String agreementKey = (agreementInfos == null || (agreementInfo = (AgreementInfo) CollectionsKt.firstOrNull((List) agreementInfos)) == null) ? null : agreementInfo.getAgreementKey();
                if (agreementKey == null || agreementKey.length() == 0) {
                    view4 = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                    view4.PlaceComponentResult(p2, p3, null);
                    return;
                }
                view2 = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(p2, p3);
                view3 = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view3.getAuthRequestContext(new PaylaterOnboardingContentModel(p1, ConsultAgreementModelKt.BuiltInFictitiousFunctionClassFactory(consultAgreementResponse)), p2, p3);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$consultAgreement$2
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
                CashierPayLaterContract.View view;
                CashierPayLaterContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view.dismissProgress();
                view2 = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view2.PlaceComponentResult(p2, p3, th);
                StringBuilder sb = new StringBuilder();
                sb.append("[CashierGetPaylaterCicilAgreement]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getErrorConfigVersion.execute(p0, new Function1<LoanRegisterResultInfo, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$getLoanRegistrationInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(LoanRegisterResultInfo loanRegisterResultInfo) {
                invoke2(loanRegisterResultInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LoanRegisterResultInfo loanRegisterResultInfo) {
                CashierPayLaterContract.View view;
                Intrinsics.checkNotNullParameter(loanRegisterResultInfo, "");
                view = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view.KClassImpl$Data$declaredNonStaticMembers$2(loanRegisterResultInfo.getAssetStatus());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$getLoanRegistrationInfo$2
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
                CashierPayLaterContract.View view;
                Context context;
                Intrinsics.checkNotNullParameter(th, "");
                view = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                context = CashierPayLaterPresenter.this.BuiltInFictitiousFunctionClassFactory;
                String authRequestContext = ErrorUtil.getAuthRequestContext(th, context);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                view.MyBillsEntityDataFactory(authRequestContext, th, "id.dana.mobilebizpaylaterprod.loan.register", "DANA CICIL Submit Registration");
                StringBuilder sb = new StringBuilder();
                sb.append("[CashierGetLoanRegistrationInfo]: cashier_native_fail");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(List<? extends CashierPayMethodModel> list, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.DatabaseTableConfigUtil.getAuthRequestContext(this.MyBillsEntityDataFactory.getAuthRequestContext(list, str));
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function0<Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$clearCachePayLaterLoanWhitelist$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.LOAN_WHITELIST);
                sb.append(CashierPayLaterPresenter.this.getClass().getName());
                DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.PAYLATER_CASHIER_NATIVE, sb.toString());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$clearCachePayLaterLoanWhitelist$2
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
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.LOAN_WHITELIST);
                sb.append(CashierPayLaterPresenter.this.getClass().getName());
                sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYLATER_CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void PlaceComponentResult(int p0) {
        this.initRecordTimeStamp.execute(Integer.valueOf(p0), CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownCount$1.INSTANCE, CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownCount$2.INSTANCE);
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void MyBillsEntityDataFactory(long p0) {
        this.GetContactSyncConfig.execute(Long.valueOf(p0), CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownDelay$1.INSTANCE, CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownDelay$2.INSTANCE);
    }

    public final void PlaceComponentResult(boolean p0, String p1) {
        if (Intrinsics.areEqual(p1, PayMethod.LOAN_CREDIT)) {
            if (p0) {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(CollectionsKt.listOf(p1));
            } else {
                this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(CollectionsKt.listOf(p1));
            }
        } else if (p0) {
            this.DatabaseTableConfigUtil.showProgress();
        } else {
            this.DatabaseTableConfigUtil.dismissProgress();
        }
    }

    public static boolean MyBillsEntityDataFactory(long p0, int p1) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(p0);
        calendar.add(5, p1);
        return timeInMillis > calendar.getTimeInMillis();
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(UpdatePayLaterLoanCache.Params.INSTANCE.withBill(), new Function1<PayLaterLoanWhitelist, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$updatePayLaterLoanCache$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PayLaterLoanWhitelist payLaterLoanWhitelist) {
                Intrinsics.checkNotNullParameter(payLaterLoanWhitelist, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PayLaterLoanWhitelist payLaterLoanWhitelist) {
                invoke2(payLaterLoanWhitelist);
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$updatePayLaterLoanCache$2
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
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.LOAN_WHITELIST);
                sb.append(CashierPayLaterPresenter.this.getClass().getSimpleName());
                sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PAYLATER_CASHIER_NATIVE, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.lookAheadTest.dispose();
        this.getErrorConfigVersion.dispose();
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.moveToNextValue.dispose();
        this.initRecordTimeStamp.dispose();
        this.GetContactSyncConfig.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CashierPayLaterPresenter cashierPayLaterPresenter) {
        cashierPayLaterPresenter.initRecordTimeStamp.execute(0, CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownCount$1.INSTANCE, CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownCount$2.INSTANCE);
        cashierPayLaterPresenter.GetContactSyncConfig.execute(0L, CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownDelay$1.INSTANCE, CashierPayLaterPresenter$savePaylaterCicilRegistrationCacheCooldownDelay$2.INSTANCE);
    }

    private GetQueryInstallment.Params KClassImpl$Data$declaredNonStaticMembers$2(QueryInstallmentRequestModel p0, boolean p1, CashierPayMethodModel p2) {
        MixPayMethod mixPayMethod;
        Intrinsics.checkNotNullParameter(p0, "");
        CashierPayMethodModel cashierPayMethodModel = p0.moveToNextValue;
        GetQueryInstallment.Params.Companion companion = GetQueryInstallment.Params.INSTANCE;
        CheckoutExternalInfo checkoutExternalInfo = p0.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = p0.getAuthRequestContext;
        String moveToNextValue = cashierPayMethodModel != null ? cashierPayMethodModel.moveToNextValue() : null;
        Boolean bool = p0.scheduleImpl;
        String str2 = p0.lookAheadTest;
        List<String> list = p0.PlaceComponentResult;
        List<String> list2 = p0.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String initRecordTimeStamp = cashierPayMethodModel != null ? cashierPayMethodModel.initRecordTimeStamp() : null;
        Boolean bool2 = p0.BuiltInFictitiousFunctionClassFactory;
        if ((p2 != null && p1) && (p2 instanceof CashierPayMethodModel.PaylaterCicilPayMethod)) {
            CashierPayMethodModel.PaylaterCicilPayMethod paylaterCicilPayMethod = (CashierPayMethodModel.PaylaterCicilPayMethod) p2;
            String str3 = paylaterCicilPayMethod.getErrorConfigVersion.B;
            String str4 = str3 == null ? "" : str3;
            String str5 = paylaterCicilPayMethod.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda7;
            String str6 = str5 == null ? "" : str5;
            String androidId = this.getAuthRequestContext.getAndroidId(this.BuiltInFictitiousFunctionClassFactory);
            String str7 = androidId == null ? "" : androidId;
            String str8 = paylaterCicilPayMethod.getErrorConfigVersion.PrepareContext;
            mixPayMethod = new MixPayMethod(str4, str6, null, null, null, null, null, null, null, str7, null, null, null, str8 == null ? "" : str8, null);
        } else {
            mixPayMethod = null;
        }
        return companion.createQueryInstallmentRequest(new QueryInstallmentRequest("payQuery", checkoutExternalInfo, str, moveToNextValue, bool, str2, list, list2, initRecordTimeStamp, bool2, mixPayMethod));
    }

    @Override // id.dana.cashier.CashierPayLaterContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final QueryInstallmentRequestModel p0, final CashierPayMethodModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.MyBillsEntityDataFactory;
        String initRecordTimeStamp = p1 != null ? p1.initRecordTimeStamp() : null;
        if (initRecordTimeStamp != null) {
            str = initRecordTimeStamp;
        }
        PlaceComponentResult(true, str);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(KClassImpl$Data$declaredNonStaticMembers$2(p0, p1 != null ? p1.getKClassImpl$Data$declaredNonStaticMembers$2() : false, p1), new Function1<QueryInstallment, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$getQueryInstallment$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(QueryInstallment queryInstallment) {
                invoke2(queryInstallment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(QueryInstallment queryInstallment) {
                CashierPayLaterContract.View view;
                Intrinsics.checkNotNullParameter(queryInstallment, "");
                CashierPayLaterPresenter cashierPayLaterPresenter = CashierPayLaterPresenter.this;
                String str2 = p0.MyBillsEntityDataFactory;
                CashierPayMethodModel cashierPayMethodModel = p1;
                cashierPayLaterPresenter.PlaceComponentResult(false, CashierPayLaterPresenter.PlaceComponentResult(str2, cashierPayMethodModel != null ? cashierPayMethodModel.initRecordTimeStamp() : null));
                view = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view.BuiltInFictitiousFunctionClassFactory(QueryInstallmentModelKt.MyBillsEntityDataFactory(queryInstallment), queryInstallment.getConsultAgreementError());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cashier.presenter.CashierPayLaterPresenter$getQueryInstallment$2
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
                CashierPayLaterContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                CashierPayLaterPresenter cashierPayLaterPresenter = CashierPayLaterPresenter.this;
                String str2 = p0.MyBillsEntityDataFactory;
                CashierPayMethodModel cashierPayMethodModel = p1;
                cashierPayLaterPresenter.PlaceComponentResult(false, CashierPayLaterPresenter.PlaceComponentResult(str2, cashierPayMethodModel != null ? cashierPayMethodModel.initRecordTimeStamp() : null));
                view = CashierPayLaterPresenter.this.DatabaseTableConfigUtil;
                view.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }
}
