package id.dana.contract.sendmoney.v2;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.base.AbstractContractKt;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.sendmoney.model.BaseRecipientModel;
import id.dana.sendmoney_v2.model.BillerX2BModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/sendmoney/v2/BillerX2BContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BillerX2BContract {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0003\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "PlaceComponentResult", "()V", "Lid/dana/sendmoney/model/BaseRecipientModel;", "p0", "(Lid/dana/sendmoney/model/BaseRecipientModel;)V", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney_v2/model/BillerX2BModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(BillerX2BModel p0);

        void PlaceComponentResult();

        void PlaceComponentResult(BaseRecipientModel p0);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0016\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lid/dana/contract/sendmoney/v2/BillerX2BContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "loadingState", "", GriverMonitorConstants.KEY_IS_LOADING, "", "onBillerUrlConstructed", "url", "", "onErrorCheckPrefix", "recipientModel", "Lid/dana/sendmoney/model/BaseRecipientModel;", "onErrorOpenBillerPage", "message", "onErrorQueryPrefix", "onPrefixExist", "billerX2BModel", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "onSuccessGetAllBillerX2B", "allBillerX2B", "", "Lid/dana/domain/sendmoney/model/BillerX2B;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {

        /* renamed from: id.dana.contract.sendmoney.v2.BillerX2BContract$View$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void PlaceComponentResult(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }
        }

        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(List<BillerX2B> list);

        void KClassImpl$Data$declaredNonStaticMembers$2(BillerX2BModel billerX2BModel);

        void PlaceComponentResult(BaseRecipientModel baseRecipientModel);

        void PlaceComponentResult(boolean z);

        void getAuthRequestContext(BaseRecipientModel baseRecipientModel);

        void getAuthRequestContext(String str);
    }
}
