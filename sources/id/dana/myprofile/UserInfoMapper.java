package id.dana.myprofile;

import id.dana.domain.homeinfo.KycResponse;
import id.dana.domain.user.UserInfoResponse;
import id.dana.model.KycInfo;
import id.dana.model.UserInfo;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/myprofile/UserInfoMapper;", "", "Lid/dana/domain/user/UserInfoResponse;", "p0", "Lid/dana/model/UserInfo;", "MyBillsEntityDataFactory", "(Lid/dana/domain/user/UserInfoResponse;)Lid/dana/model/UserInfo;", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "<init>", "(Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserInfoMapper {
    private final CurrencyAmountModelMapper BuiltInFictitiousFunctionClassFactory;

    @Inject
    public UserInfoMapper(CurrencyAmountModelMapper currencyAmountModelMapper) {
        Intrinsics.checkNotNullParameter(currencyAmountModelMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = currencyAmountModelMapper;
    }

    public final UserInfo MyBillsEntityDataFactory(UserInfoResponse p0) {
        if (p0 == null) {
            return new UserInfo(null, null, null, null, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, 524287, null);
        }
        UserInfo userInfo = new UserInfo(null, null, null, null, null, 0, null, null, null, null, null, false, false, false, false, null, null, null, null, 524287, null);
        userInfo.getErrorConfigVersion = p0.getKtpName();
        userInfo.lookAheadTest = p0.getKtpId();
        userInfo.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0.getNickname();
        userInfo.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.apply(p0.getBalance());
        userInfo.GetContactSyncConfig = p0.getLoginId();
        KycResponse kycResponse = p0.getKycResponse();
        KycInfo kycInfo = new KycInfo();
        kycInfo.PlaceComponentResult = kycResponse.getLevel();
        kycInfo.getAuthRequestContext = kycResponse.getOrderStatus();
        userInfo.DatabaseTableConfigUtil = kycInfo;
        userInfo.moveToNextValue = p0.isKycCertified();
        userInfo.PlaceComponentResult = p0.isFaceLoginEnabled();
        userInfo.getAuthRequestContext = p0.getHasFaceLoginEnrolled();
        userInfo.scheduleImpl = p0.isFaceLoginReady();
        userInfo.NetworkUserEntityData$$ExternalSyntheticLambda7 = p0.getUsername();
        userInfo.KClassImpl$Data$declaredNonStaticMembers$2 = p0.getAccountStatus();
        userInfo.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0.getLoginStatus();
        userInfo.isLayoutRequested = p0.getUserStatus();
        int i = 0;
        try {
            String pendingTransaction = p0.getPendingTransaction();
            if (pendingTransaction == null) {
                pendingTransaction = "0";
            }
            Integer valueOf = Integer.valueOf(pendingTransaction);
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
            i = valueOf.intValue();
        } catch (NumberFormatException unused) {
        }
        userInfo.PrepareContext = i;
        return userInfo;
    }
}
