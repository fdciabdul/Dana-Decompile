package id.dana.domain.qriscrossborder;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/qriscrossborder/QrisCrossBorderRepository;", "", "Lio/reactivex/Observable;", "", "getCurrentCountry", "()Lio/reactivex/Observable;", "getOriginCountry", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "", "saveCurrentCountry", "(Ljava/lang/String;)Lio/reactivex/Observable;", "saveOriginCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface QrisCrossBorderRepository {
    Observable<String> getCurrentCountry();

    Observable<String> getOriginCountry();

    Observable<Boolean> saveCurrentCountry(String countryCode);

    Observable<Boolean> saveOriginCountry(String countryCode);
}
