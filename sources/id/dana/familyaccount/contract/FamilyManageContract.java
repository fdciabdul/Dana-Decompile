package id.dana.familyaccount.contract;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.familyaccount.model.SetLimitAndServicesRequestModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyManageContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FamilyManageContract {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyManageContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "removeFamilyAccount", "", "removeFamilyMember", "invitationId", "", "setLimitAndServices", "requestModel", "Lid/dana/familyaccount/model/SetLimitAndServicesRequestModel;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void MyBillsEntityDataFactory(SetLimitAndServicesRequestModel setLimitAndServicesRequestModel);

        void PlaceComponentResult(String str);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/contract/FamilyManageContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onFailedDeleteFamilyAccount", "", "onFailedRemoveMemberFamilyAccount", "onFailedSetLimitAndServices", "onProcessRisk", BioUtilityBridge.SECURITY_ID, "", RecordError.KEY_PUB_KEY, "invitationId", "onSuccessRemoveFamilyAccount", "onSuccessRemoveMemberFamilyAccount", "onSuccessSetLimitAndServices", TrackerKey.Property.IS_SUCCESS, "", "requestModel", "Lid/dana/familyaccount/model/SetLimitAndServicesRequestModel;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.familyaccount.contract.FamilyManageContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void BuiltInFictitiousFunctionClassFactory(SetLimitAndServicesRequestModel setLimitAndServicesRequestModel) {
                Intrinsics.checkNotNullParameter(setLimitAndServicesRequestModel, "");
            }

            public static void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }

            public static void getAuthRequestContext(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean z, SetLimitAndServicesRequestModel setLimitAndServicesRequestModel);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();

        void getAuthRequestContext(String str, String str2);
    }
}
