package id.dana.sendmoney.recipient.recent;

import id.dana.base.AbstractContract;
import id.dana.sendmoney.model.RecentRecipientModel;
import java.util.List;

/* loaded from: classes5.dex */
public interface RecentRecipientContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void PlaceComponentResult();

        void getAuthRequestContext(String str);
    }

    /* loaded from: classes5.dex */
    public interface View {
        void KClassImpl$Data$declaredNonStaticMembers$2(List<RecentRecipientModel> list);

        void MyBillsEntityDataFactory(List<RecentRecipientModel> list);

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext(List<RecentRecipientModel> list);
    }
}
