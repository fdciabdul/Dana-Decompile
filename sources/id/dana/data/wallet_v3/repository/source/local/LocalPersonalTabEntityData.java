package id.dana.data.wallet_v3.repository.source.local;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.PocketQueryListResult;
import id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData;
import id.dana.data.wallet_v3.repository.source.network.result.InsuranceResult;
import id.dana.data.wallet_v3.repository.source.network.result.KycStatusResult;
import id.dana.data.wallet_v3.repository.source.network.result.VerifyPinKtpResult;
import id.dana.domain.pocket.model.AssetStatus;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0007J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/local/LocalPersonalTabEntityData;", "Lid/dana/data/wallet_v3/repository/source/network/PersonalTabEntityData;", "", "phoneNumber", "Lio/reactivex/Observable;", "", "checkKtpPopUp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "", "Lid/dana/domain/pocket/model/AssetStatus;", "statuses", "Lid/dana/data/pocket/model/PocketQueryListResult;", "Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;", "getInsuranceAssets", "(IILjava/util/List;)Lio/reactivex/Observable;", "Lid/dana/data/pocket/model/KtpAssetResult;", "getKtpInfo", "(II)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/network/result/KycStatusResult;", "getUserKYCStatus", "isFirstTimeCheck", "saveFirstTimeCheck", "ktpIsSaved", "saveKtpPopUpCheck", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "inputPin", RecordError.KEY_PUB_KEY, "Lid/dana/data/wallet_v3/repository/source/network/result/VerifyPinKtpResult;", "verifyPinKtp", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/local/PersonalTabPreference;", "personalTabPreference", "Lid/dana/data/wallet_v3/repository/source/local/PersonalTabPreference;", "<init>", "(Lid/dana/data/wallet_v3/repository/source/local/PersonalTabPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalPersonalTabEntityData implements PersonalTabEntityData {
    private final PersonalTabPreference personalTabPreference;

    @Inject
    public LocalPersonalTabEntityData(PersonalTabPreference personalTabPreference) {
        Intrinsics.checkNotNullParameter(personalTabPreference, "");
        this.personalTabPreference = personalTabPreference;
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<Boolean> isFirstTimeCheck(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.personalTabPreference.isFirstTimeCheck(phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<Boolean> saveFirstTimeCheck(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.personalTabPreference.saveFirstTimeCheck(phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<Boolean> checkKtpPopUp(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.personalTabPreference.getKtpPopUpCheck(phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<Boolean> saveKtpPopUpCheck(String phoneNumber, boolean ktpIsSaved) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.personalTabPreference.saveKtpPopUpCheck(phoneNumber, ktpIsSaved)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<KycStatusResult> getUserKYCStatus(int pageNum, int pageSize) {
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<KtpAssetResult> getKtpInfo(int pageNum, int pageSize) {
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<PocketQueryListResult<InsuranceResult>> getInsuranceAssets(int pageNum, int pageSize, List<? extends AssetStatus> statuses) {
        Intrinsics.checkNotNullParameter(statuses, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData
    public final Observable<VerifyPinKtpResult> verifyPinKtp(String inputPin, String pubKey) {
        Intrinsics.checkNotNullParameter(inputPin, "");
        Intrinsics.checkNotNullParameter(pubKey, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }
}
