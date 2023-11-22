package id.dana.domain.kycrenewal;

import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.domain.kycrenewal.model.QueryKYCRenewalStatus;
import id.dana.domain.kycrenewal.model.QueryKYCUserData;
import id.dana.domain.kycrenewal.model.ShowDialogPreference;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0002H&¢\u0006\u0004\b\u000b\u0010\u0005J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H&¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005J\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\fH&¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/kycrenewal/KycRenewalRepository;", "", "Lio/reactivex/Observable;", "", "getKYCRenewalButtonClick", "()Lio/reactivex/Observable;", "", "getKYCRenewalDismissCount", "Lid/dana/domain/kycrenewal/model/QueryKYCRenewalStatus;", "getKYCRenewalStatus", "Lid/dana/domain/kycrenewal/model/QueryKYCUserData;", "getKYCUserData", "", "isNeedToQueryKYCRenewalDialog", "Lid/dana/domain/kycrenewal/model/ShowDialogPreference;", "isNeedToShowKYCRenewalDialog", DynamicLayerModel.TYPE_CLICK, "saveClickKYCRenewalButton", "(Z)Lio/reactivex/Observable;", LogConstants.KEY_TIME_STAPM, "saveQueryKYCRenewalDialog", "(J)Lio/reactivex/Observable;", ContainerUIProvider.KEY_SHOW, "saveShowKYCRenewalDialog", "(ZJ)Lio/reactivex/Observable;", "count", "setKYCRenewalDismissCount", "(I)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface KycRenewalRepository {
    Observable<Boolean> getKYCRenewalButtonClick();

    Observable<Integer> getKYCRenewalDismissCount();

    Observable<QueryKYCRenewalStatus> getKYCRenewalStatus();

    Observable<QueryKYCUserData> getKYCUserData();

    Observable<Long> isNeedToQueryKYCRenewalDialog();

    Observable<ShowDialogPreference> isNeedToShowKYCRenewalDialog();

    Observable<Boolean> saveClickKYCRenewalButton(boolean click);

    Observable<Boolean> saveQueryKYCRenewalDialog(long timeStamp);

    Observable<Boolean> saveShowKYCRenewalDialog(boolean show, long timeStamp);

    Observable<Boolean> setKYCRenewalDismissCount(int count);
}
