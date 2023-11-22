package id.dana.animation;

import android.net.Uri;
import id.dana.base.AbstractContractKt;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/loyalty/ScanQrLoyaltyContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface ScanQrLoyaltyContract {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/loyalty/ScanQrLoyaltyContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Landroid/net/Uri;", "", "p1", "p2", "MyBillsEntityDataFactory", "(Landroid/net/Uri;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(String p0);

        void MyBillsEntityDataFactory(Uri p0, int p1, int p2);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0007J#\u0010\t\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/loyalty/ScanQrLoyaltyContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "()V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/Map;)V", "getAuthRequestContext", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> p0);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(String p0);

        void getAuthRequestContext();
    }
}
