package id.dana.familyaccount.contract;

import id.dana.base.AbstractContractKt;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.familyaccount.model.DashboardModel;
import id.dana.familyaccount.model.TopUpUserConsultModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyDashboardContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FamilyDashboardContract {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH&¢\u0006\u0004\b\u000e\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyDashboardContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Lid/dana/domain/nearbyme/model/MoneyView;", "PlaceComponentResult", "(Lid/dana/domain/nearbyme/model/MoneyView;)V", "getAuthRequestContext", "()Ljava/lang/String;", "()V", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "(Ljava/util/List;)V", "scheduleImpl"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(List<String> p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String p0);

        void PlaceComponentResult();

        void PlaceComponentResult(MoneyView p0);

        String getAuthRequestContext();

        void getAuthRequestContext(String p0);

        void scheduleImpl();
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyDashboardContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "dismissDanaLoading", "", "onErrorCancelInvitation", "errorMessage", "", "onErrorCreateOrderTopUpFamilyBalance", "onErrorGetDashboardFamilyAccount", "onErrorGetFamilyAccountMaxMember", "onErrorGetFamilyAvailableServices", "onErrorGetMaxMemberLimit", "onErrorResendInvitation", "onGetFamilyAccountMaxMember", "maxMember", "", "onGetFamilyAvailableServices", "availableServicesConfig", "", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "onGetFamilyDashboard", "dashboardModel", "Lid/dana/familyaccount/model/DashboardModel;", "onGetMaxMemberLimit", "maxMemberLimitConfig", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "onGetMemberAvailableServices", "onGetTopUpUserConsult", "topUpUserConsultModel", "Lid/dana/familyaccount/model/TopUpUserConsultModel;", "onSuccessCancelInvitation", "onSuccessCreateOrderTopUpFamilyBalance", "checkoutUrl", "onSuccessResendlInvitation", "showDanaLoading", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.familyaccount.contract.FamilyDashboardContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void BuiltInFictitiousFunctionClassFactory(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            public static void BuiltInFictitiousFunctionClassFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void MyBillsEntityDataFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            public static void NetworkUserEntityData$$ExternalSyntheticLambda0() {
            }

            public static void NetworkUserEntityData$$ExternalSyntheticLambda1() {
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }

            public static void getAuthRequestContext(MaxMemberLimitConfig maxMemberLimitConfig) {
                Intrinsics.checkNotNullParameter(maxMemberLimitConfig, "");
            }

            public static void getErrorConfigVersion() {
            }

            public static void lookAheadTest() {
            }

            public static void moveToNextValue() {
            }

            public static void scheduleImpl() {
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(MaxMemberLimitConfig maxMemberLimitConfig);

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(List<AvailableServicesConfig> list);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(DashboardModel dashboardModel);

        void MyBillsEntityDataFactory(TopUpUserConsultModel topUpUserConsultModel);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(List<AvailableServicesConfig> list);

        void PlaceComponentResult();

        void PlaceComponentResult(String str);

        void getAuthRequestContext();

        void getAuthRequestContext(String str);

        void getErrorConfigVersion();

        void moveToNextValue();

        void scheduleImpl();
    }
}
