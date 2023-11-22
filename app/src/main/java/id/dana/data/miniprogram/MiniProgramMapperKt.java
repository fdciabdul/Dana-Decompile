package id.dana.data.miniprogram;

import com.alibaba.griver.core.model.applist.FetchAppInfo;
import com.alipay.iap.android.wallet.acl.member.MemberInfo;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import id.dana.data.miniprogram.model.MiniProgramEntity;
import id.dana.data.miniprogram.model.MiniProgramVersionRequirementsEntity;
import id.dana.domain.miniprogram.model.MiniProgram;
import id.dana.domain.miniprogram.model.MiniProgramVersionRequirements;
import id.dana.domain.user.MiniProgramUserInfoResponse;
import id.dana.domain.version.SemanticVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/user/MiniProgramUserInfoResponse;", "Lcom/alipay/iap/android/wallet/acl/member/MemberInfo;", "PlaceComponentResult", "(Lid/dana/domain/user/MiniProgramUserInfoResponse;)Lcom/alipay/iap/android/wallet/acl/member/MemberInfo;", "Lcom/alibaba/griver/core/model/applist/FetchAppInfo;", "Lid/dana/data/miniprogram/model/MiniProgramEntity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/alibaba/griver/core/model/applist/FetchAppInfo;)Lid/dana/data/miniprogram/model/MiniProgramEntity;", "Lid/dana/data/miniprogram/model/MiniProgramVersionRequirementsEntity;", "Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;", "MyBillsEntityDataFactory", "(Lid/dana/data/miniprogram/model/MiniProgramVersionRequirementsEntity;)Lid/dana/domain/miniprogram/model/MiniProgramVersionRequirements;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MiniProgramMapperKt {
    public static final MiniProgramEntity KClassImpl$Data$declaredNonStaticMembers$2(FetchAppInfo fetchAppInfo) {
        Intrinsics.checkNotNullParameter(fetchAppInfo, "");
        String appId = fetchAppInfo.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "");
        String appName = fetchAppInfo.getAppName();
        Intrinsics.checkNotNullExpressionValue(appName, "");
        String appSlogan = fetchAppInfo.getAppSlogan();
        Intrinsics.checkNotNullExpressionValue(appSlogan, "");
        String iconUrl = fetchAppInfo.getIconUrl();
        Intrinsics.checkNotNullExpressionValue(iconUrl, "");
        return new MiniProgramEntity(appId, appName, appSlogan, iconUrl);
    }

    public static final MemberInfo PlaceComponentResult(MiniProgramUserInfoResponse miniProgramUserInfoResponse) {
        Intrinsics.checkNotNullParameter(miniProgramUserInfoResponse, "");
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.userId = miniProgramUserInfoResponse.getUserInfo().get("USER_ID");
        memberInfo.loginId = miniProgramUserInfoResponse.getUserInfo().get(OAuthService.SCOPE_USER_LOGIN_ID);
        memberInfo.avatar = miniProgramUserInfoResponse.getUserInfo().get(OAuthService.SCOPE_USER_AVATAR);
        memberInfo.gender = miniProgramUserInfoResponse.getUserInfo().get(OAuthService.SCOPE_USER_GENDER);
        memberInfo.birthday = miniProgramUserInfoResponse.getUserInfo().get(OAuthService.SCOPE_USER_BIRTHDAY);
        memberInfo.extendedInfo = miniProgramUserInfoResponse.getUserInfo();
        return memberInfo;
    }

    public static final MiniProgramVersionRequirements MyBillsEntityDataFactory(MiniProgramVersionRequirementsEntity miniProgramVersionRequirementsEntity) {
        Intrinsics.checkNotNullParameter(miniProgramVersionRequirementsEntity, "");
        return new MiniProgramVersionRequirements(SemanticVersion.INSTANCE.fromVersion(miniProgramVersionRequirementsEntity.getAuthRequestContext), SemanticVersion.INSTANCE.fromVersion(miniProgramVersionRequirementsEntity.BuiltInFictitiousFunctionClassFactory));
    }

    public static /* synthetic */ MiniProgram getAuthRequestContext(MiniProgramEntity miniProgramEntity) {
        Intrinsics.checkNotNullParameter(miniProgramEntity, "");
        return new MiniProgram(miniProgramEntity.getAuthRequestContext, miniProgramEntity.KClassImpl$Data$declaredNonStaticMembers$2, miniProgramEntity.PlaceComponentResult, miniProgramEntity.MyBillsEntityDataFactory, false, false, 0L, 96, null);
    }
}
