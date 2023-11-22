package id.dana.social.contract;

import id.dana.base.AbstractContractKt;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/ActivityReactionsContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ActivityReactionsContract {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¢\u0006\u0004\b\u0006\u0010\u000bJ\u000f\u0010\f\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/ActivityReactionsContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "Lid/dana/utils/DisplayedErrorMessage;", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "p0", "", "(Ljava/util/List;)V", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        String BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(List<ActivityReactionsUserModel> p0);

        String MyBillsEntityDataFactory();

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Lid/dana/social/contract/ActivityReactionsContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "getActivityReactions", "", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "", "kind", "forPagination", "", "getActivityReactionsPagination", "getCurrentUserSize", "", "getMyActivityReactionInfo", "setSelectedKind", "selectedKind", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        int MyBillsEntityDataFactory();

        void PlaceComponentResult(String str, String str2);

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext(String str, String str2, boolean z);

        /* renamed from: id.dana.social.contract.ActivityReactionsContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }
    }
}
