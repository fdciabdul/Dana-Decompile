package id.dana.contract.contact;

import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sync_engine.domain.model.UserContact;
import java.util.List;

/* loaded from: classes4.dex */
public interface DanaContactContract {

    /* loaded from: classes2.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();

        void getErrorConfigVersion();
    }

    /* loaded from: classes2.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.contract.contact.DanaContactContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void PlaceComponentResult() {
            }

            public static void getAuthRequestContext() {
            }
        }

        void onEnableContactSyncFeature();

        void onGetContactSyncState(boolean z);

        void onGetDanaUserContactSuccess(List<String> list);

        void onGetRecipientSyncContacts(List<RecipientViewModel> list);

        void onGetSyncContacts(List<UserContact> list);
    }
}
