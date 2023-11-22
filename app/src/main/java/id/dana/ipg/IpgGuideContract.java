package id.dana.ipg;

import id.dana.base.AbstractContract;
import id.dana.contract.deeplink.path.IpgRegistrationPayload;
import id.dana.domain.ipg.IpgRegistrationUrl;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ipg/IpgGuideContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IpgGuideContract {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ipg/IpgGuideContract$Presenter;", "Lid/dana/base/AbstractContract$AbstractPresenter;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "getAuthRequestContext", "()Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "PlaceComponentResult", "(Lid/dana/contract/deeplink/path/IpgRegistrationPayload;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(String p0);

        void MyBillsEntityDataFactory(String p0, String p1);

        void PlaceComponentResult(IpgRegistrationPayload p0);

        IpgRegistrationPayload getAuthRequestContext();

        void getAuthRequestContext(String p0, String p1);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ipg/IpgGuideContract$View;", "Lid/dana/base/AbstractContract$AbstractView;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "PlaceComponentResult", "()V", "Lid/dana/domain/ipg/IpgRegistrationUrl;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/ipg/IpgRegistrationUrl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void BuiltInFictitiousFunctionClassFactory(boolean p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(IpgRegistrationUrl p0);

        void PlaceComponentResult();
    }
}
