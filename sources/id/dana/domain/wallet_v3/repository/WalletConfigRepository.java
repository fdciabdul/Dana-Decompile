package id.dana.domain.wallet_v3.repository;

import id.dana.animation.HomeTabActivity;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.wallet_v3.model.SearchCategory;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.model.WalletV3RestrictedErrorCodes;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H&¢\u0006\u0004\b\f\u0010\u000bJ#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H&¢\u0006\u0004\b\u0013\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/wallet_v3/repository/WalletConfigRepository;", "", "", HomeTabActivity.WALLET_SECTION, "Lio/reactivex/Observable;", "", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "getBottomSheetServices", "(I)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/model/WalletConfig;", "getWalletConfig", "()Lio/reactivex/Observable;", "getWalletConfigFromLocal", "", "category", "Lid/dana/domain/wallet_v3/model/SearchCategory;", "getWalletSearchCategory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/model/WalletV3RestrictedErrorCodes;", "getWalletV3RestrictedErrorCodes"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface WalletConfigRepository {
    Observable<List<ThirdPartyServiceResponse>> getBottomSheetServices(int section);

    Observable<WalletConfig> getWalletConfig();

    Observable<WalletConfig> getWalletConfigFromLocal();

    Observable<List<SearchCategory>> getWalletSearchCategory(String category);

    Observable<WalletV3RestrictedErrorCodes> getWalletV3RestrictedErrorCodes();
}
