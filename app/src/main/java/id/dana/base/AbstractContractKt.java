package id.dana.base;

import com.alibaba.ariver.kernel.RVEvents;
import id.dana.base.AbstractContract;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/base/AbstractContractKt;", "Lid/dana/base/AbstractContract;", "AbstractPresenter", "AbstractView"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface AbstractContractKt extends AbstractContract {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "onDestroy", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface AbstractPresenter extends AbstractContract.AbstractPresenter {

        /* renamed from: id.dana.base.AbstractContractKt$AbstractPresenter$-CC  reason: invalid class name */
        /* loaded from: classes4.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }
        }

        @Override // id.dana.base.AbstractContract.AbstractPresenter
        void onDestroy();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lid/dana/base/AbstractContractKt$AbstractView;", "Lid/dana/base/AbstractContract$AbstractView;", "dismissProgress", "", "getErrorSource", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "errorMessage", "showProgress", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface AbstractView extends AbstractContract.AbstractView {

        /* renamed from: id.dana.base.AbstractContractKt$AbstractView$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void MyBillsEntityDataFactory() {
            }

            public static void PlaceComponentResult() {
            }

            public static String getAuthRequestContext() {
                return "";
            }
        }

        @Override // id.dana.base.AbstractContract.AbstractView
        void dismissProgress();

        String getErrorSource();

        @Override // id.dana.base.AbstractContract.AbstractView
        void onError(String errorMessage);

        @Override // id.dana.base.AbstractContract.AbstractView
        void showProgress();
    }
}
