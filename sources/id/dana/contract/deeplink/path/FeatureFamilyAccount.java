package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.familyaccount.view.dashboard.MemberDashboardActivity;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.familyaccount.view.joininvitation.JoinInvitationActivity;
import id.dana.familyaccount.view.statusinformation.FamilyStatusInformationActivity;
import id.dana.familyaccount.view.summary.OrganizerSummaryActivity;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000e"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureFamilyAccount;", "", "Landroid/app/Activity;", "p0", "", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Ljava/util/Map;)V", "Lid/dana/domain/familyaccount/interactor/CheckConsultFamilyAccount;", "getAuthRequestContext", "Lid/dana/domain/familyaccount/interactor/CheckConsultFamilyAccount;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/domain/familyaccount/interactor/CheckConsultFamilyAccount;Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureFamilyAccount {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DynamicUrlWrapper MyBillsEntityDataFactory;
    final CheckConsultFamilyAccount getAuthRequestContext;

    @Inject
    public FeatureFamilyAccount(CheckConsultFamilyAccount checkConsultFamilyAccount, DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(checkConsultFamilyAccount, "");
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.getAuthRequestContext = checkConsultFamilyAccount;
        this.MyBillsEntityDataFactory = dynamicUrlWrapper;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1.get(BranchLinkConstant.FamilyAccountParam.DESTINATION);
        if (str != null) {
            switch (str.hashCode()) {
                case -1859601793:
                    if (str.equals(BranchLinkConstant.FamilyAccountDestinations.INVITATION_CANCELLED)) {
                        Intent intent = new Intent(p0, FamilyStatusInformationActivity.class);
                        intent.setFlags(67108864);
                        intent.putExtra(FamilyStatusInformationActivity.FAMILY_STATUS, "INVITATION_CANCELED");
                        p0.startActivity(intent);
                        return;
                    }
                    return;
                case -910346466:
                    if (!str.equals(BranchLinkConstant.FamilyAccountDestinations.MEMBER_ACCESS_CHANGED)) {
                        return;
                    }
                    Intent intent2 = new Intent(p0, MemberDashboardActivity.class);
                    intent2.setFlags(67108864);
                    p0.startActivity(intent2);
                    return;
                case -608360588:
                    if (!str.equals(BranchLinkConstant.FamilyAccountDestinations.MEMBER_DELETED)) {
                        return;
                    }
                    Intent intent3 = new Intent(p0, FamilyStatusInformationActivity.class);
                    intent3.setFlags(67108864);
                    intent3.putExtra(FamilyStatusInformationActivity.FAMILY_STATUS, "MEMBER_DELETED");
                    p0.startActivity(intent3);
                    return;
                case -530088187:
                    if (str.equals(BranchLinkConstant.FamilyAccountDestinations.SENDMONEY_REQUEST_DECLINED)) {
                        DanaH5.startContainerFullUrl("https://m.dana.id/i/transaction/list/completed");
                        return;
                    }
                    return;
                case -314779568:
                    if (!str.equals(BranchLinkConstant.FamilyAccountDestinations.INVITATION_DECLINE)) {
                        return;
                    }
                    Intent intent4 = new Intent(p0, OrganizerDashboardActivity.class);
                    intent4.setFlags(67108864);
                    p0.startActivity(intent4);
                    return;
                case -236442514:
                    if (!str.equals(BranchLinkConstant.FamilyAccountDestinations.INVITATION_ACCEPT)) {
                        return;
                    }
                    Intent intent42 = new Intent(p0, OrganizerDashboardActivity.class);
                    intent42.setFlags(67108864);
                    p0.startActivity(intent42);
                    return;
                case 86960410:
                    if (str.equals(BranchLinkConstant.FamilyAccountDestinations.SENDMONEY_REQUEST_APPROVAL)) {
                        OrganizerSummaryActivity.Companion companion = OrganizerSummaryActivity.INSTANCE;
                        Activity activity = p0;
                        String str2 = p1.get("orderId");
                        Intent MyBillsEntityDataFactory = OrganizerSummaryActivity.Companion.MyBillsEntityDataFactory(activity, str2 != null ? str2 : "");
                        MyBillsEntityDataFactory.setFlags(67108864);
                        p0.startActivity(MyBillsEntityDataFactory);
                        return;
                    }
                    return;
                case 816401708:
                    if (!str.equals(BranchLinkConstant.FamilyAccountDestinations.FAMILY_ACCOUNT_DELETED)) {
                        return;
                    }
                    Intent intent32 = new Intent(p0, FamilyStatusInformationActivity.class);
                    intent32.setFlags(67108864);
                    intent32.putExtra(FamilyStatusInformationActivity.FAMILY_STATUS, "MEMBER_DELETED");
                    p0.startActivity(intent32);
                    return;
                case 1195341721:
                    if (str.equals(BranchLinkConstant.FamilyAccountDestinations.INVITATION)) {
                        JoinInvitationActivity.Companion companion2 = JoinInvitationActivity.INSTANCE;
                        Activity activity2 = p0;
                        String str3 = p1.get("organizer_name");
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = p1.get("invitation_id");
                        Intent MyBillsEntityDataFactory2 = JoinInvitationActivity.Companion.MyBillsEntityDataFactory(activity2, str3, str4 != null ? str4 : "");
                        MyBillsEntityDataFactory2.setFlags(67108864);
                        p0.startActivity(MyBillsEntityDataFactory2);
                        return;
                    }
                    return;
                case 1897214283:
                    if (!str.equals(BranchLinkConstant.FamilyAccountDestinations.MEMBER_LIMIT_CHANGED)) {
                        return;
                    }
                    Intent intent22 = new Intent(p0, MemberDashboardActivity.class);
                    intent22.setFlags(67108864);
                    p0.startActivity(intent22);
                    return;
                default:
                    return;
            }
        }
    }
}
