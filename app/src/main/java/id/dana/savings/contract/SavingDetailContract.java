package id.dana.savings.contract;

import id.dana.base.AbstractContractKt;
import id.dana.core.ui.model.UiTextModel;
import id.dana.savings.model.SavingDetailModel;
import id.dana.savings.model.TopUpModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/SavingDetailContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SavingDetailContract {

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/SavingDetailContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\u0004J\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&¢\u0006\u0004\b\u0003\u0010\u000fJ1\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0011H&¢\u0006\u0004\b\u0007\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/contract/SavingDetailContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "PlaceComponentResult", "()V", "Lid/dana/core/ui/model/UiTextModel;", "p0", "getAuthRequestContext", "(Lid/dana/core/ui/model/UiTextModel;)V", "Lid/dana/savings/model/SavingDetailModel;", "(Lid/dana/savings/model/SavingDetailModel;)V", "", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/savings/model/TopUpModel;", "(Ljava/util/List;)V", "", "", "p1", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Lid/dana/core/ui/model/UiTextModel;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(List<TopUpModel> p0);

        void getAuthRequestContext(UiTextModel p0);

        void getAuthRequestContext(SavingDetailModel p0);

        void getAuthRequestContext(Throwable p0, String p1, UiTextModel p2, String p3);
    }
}
