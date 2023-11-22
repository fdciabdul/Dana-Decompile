package id.dana.sendmoney.domain.groupsend;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/GroupSendOperationType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes3.dex */
public @interface GroupSendOperationType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String GROUP_DETAIL = "alipayplus.mobilewallet.bizgroup.detail";
    public static final String GROUP_DISPLAY_BOTTOM_SHEET_ONBOARDING = "saveDisplayBottomSheetOnBoarding";
    public static final String GROUP_GET_BOTTOM_SHEET_ONBOARDING = "getBottomSheetOnBoarding";
    public static final String GROUP_GET_CONTACT_USE_CASE = "getContactsUseCase";
    public static final String GROUP_GET_DEFAULT_AVATAR_GROUP = "getDefaultAvatarGroup";
    public static final String GROUP_GET_EDIT_MEMBER_SWITCH = "getEditMemberSwitch";
    public static final String GROUP_GET_GROUP_SEND_MAX_GROUP = "getGroupSendMaxGroup";
    public static final String GROUP_GET_GROUP_SEND_SCENARIO = "getGroupSendScenarios";
    public static final String GROUP_GET_PHONE_NUMBER = "getPhoneNumber";
    public static final String GROUP_GET_USER_INFO = "getUserInfo";
    public static final String GROUP_INIT = "alipayplus.mobilewallet.bizgrouptransfer.init";
    public static final String GROUP_MODIFY = "alipayplus.mobilewallet.bizgroup.modify";
    public static final String GROUP_QUERY = "alipayplus.mobilewallet.bizgroup.query";
    public static final String GROUP_SAVE_DEFAULT_AVATAR_GROUP = "saveDefaultAvatarGroup";
    public static final String GROUP_SAVE_RECENT = "saveRecentGroup";
    public static final String GROUP_SEND_MAX_PARTICIPANT = "getGroupSendMaxParticipant";
    public static final String GROUP_TRANSFER_SUBMIT = "alipayplus.mobilewallet.bizgrouptransfer.submit";
    public static final String GROUP_UPLOAD_GROUP_AVATAR = "uploadGroupAvatar";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/GroupSendOperationType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }
    }
}
