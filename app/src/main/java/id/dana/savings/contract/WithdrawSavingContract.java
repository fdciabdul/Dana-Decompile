package id.dana.savings.contract;

import id.dana.base.AbstractContractKt;
import id.dana.core.ui.model.UiTextModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/WithdrawSavingContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface WithdrawSavingContract {

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/WithdrawSavingContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0004\b\u0005\u0010\u0012J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\u000b\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/WithdrawSavingContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "", "", "getAuthRequestContext", "(Ljava/util/List;)V", "MyBillsEntityDataFactory", "()V", "", "p1", "Lid/dana/core/ui/model/UiTextModel;", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Lid/dana/core/ui/model/UiTextModel;Ljava/lang/String;)V", "(Lid/dana/core/ui/model/UiTextModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, UiTextModel p2, String p3);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(UiTextModel p0);

        void getAuthRequestContext(List<String> p0);
    }
}
