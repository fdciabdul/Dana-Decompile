package id.dana.data.carrieridentification.source;

import id.dana.data.carrieridentification.model.VerifySecurityProductRequest;
import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.network.response.login.VerifyOtpResult;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JY\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/carrieridentification/source/CarrierIdentificationEntityData;", "", "", "p0", "p1", "p2", "p3", "p4", "p5", "", "p6", "Lio/reactivex/Observable;", "Lid/dana/network/response/login/VerifyOtpResult;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CarrierIdentificationEntityData {
    Observable<VerifySecurityProductResult> KClassImpl$Data$declaredNonStaticMembers$2(VerifySecurityProductRequest p0, String p1);

    Observable<VerifyOtpResult> PlaceComponentResult(String p0, String p1, String p2, String p3, String p4, String p5, Map<String, String> p6);
}
