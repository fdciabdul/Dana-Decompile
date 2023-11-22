package id.dana.myprofile;

import android.content.Context;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.profilecompletion.model.ProfileCompletionData;
import id.dana.feeds.data.username.source.network.request.UpdateUserInfoRequest;
import id.dana.myprofile.model.ProfileCompletionTasksModel;
import id.dana.myprofile.model.ProfileCompletionTrustedDeviceTaskModel;
import id.dana.tracker.spm.SpmTagConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0014\u0010\u0003\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/myprofile/ProfileCompletionTaskManager;", "", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/profilecompletion/model/ProfileCompletionData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/profilecompletion/model/ProfileCompletionData;", "getAuthRequestContext", "", "Lid/dana/myprofile/model/ProfileCompletionTasksModel;", "Ljava/util/List;", "", "MyBillsEntityDataFactory", "Z", "p0", "p1", "p2", "<init>", "(Landroid/content/Context;Lid/dana/domain/profilecompletion/model/ProfileCompletionData;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileCompletionTaskManager {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ProfileCompletionData getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    List<? extends ProfileCompletionTasksModel> KClassImpl$Data$declaredNonStaticMembers$2;

    public ProfileCompletionTaskManager(Context context, ProfileCompletionData profileCompletionData, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(profileCompletionData, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = profileCompletionData;
        this.PlaceComponentResult = z;
        ArrayList arrayList = new ArrayList();
        String string = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_phone_number);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Context context2 = this.BuiltInFictitiousFunctionClassFactory;
        String string2 = context2.getString(R.string.lbl_profile_completion_desc_default, context2.getString(R.string.profile_completion_task_phone_number));
        Intrinsics.checkNotNullExpressionValue(string2, "");
        arrayList.add(new ProfileCompletionTasksModel(string, string2, this.getAuthRequestContext.getPhoneNumber().length() > 0, SpmTagConstant.REGISTRATION.TAG_PHONE_NUMBER));
        String string3 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_dana_viz);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_description_dana_viz);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        arrayList.add(new ProfileCompletionTasksModel(string3, string4, !this.getAuthRequestContext.getShouldShowFaceAuth(), TrackerKey.LoginType.DANA_VIZ));
        if (this.getAuthRequestContext.getShouldShowTrustedDevice()) {
            ProfileCompletionTrustedDeviceTaskModel profileCompletionTrustedDeviceTaskModel = new ProfileCompletionTrustedDeviceTaskModel(this.getAuthRequestContext.getSecurityIdForTrustedDevice());
            String string5 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_trusted_device);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            Intrinsics.checkNotNullParameter(string5, "");
            profileCompletionTrustedDeviceTaskModel.getAuthRequestContext = string5;
            String string6 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_description_trusted_device);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            Intrinsics.checkNotNullParameter(string6, "");
            profileCompletionTrustedDeviceTaskModel.KClassImpl$Data$declaredNonStaticMembers$2 = string6;
            profileCompletionTrustedDeviceTaskModel.MyBillsEntityDataFactory = this.getAuthRequestContext.isTrustedDeviceRegistered();
            Intrinsics.checkNotNullParameter("TRUSTED_DEVICE", "");
            profileCompletionTrustedDeviceTaskModel.BuiltInFictitiousFunctionClassFactory = "TRUSTED_DEVICE";
            arrayList.add(profileCompletionTrustedDeviceTaskModel);
        }
        String string7 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_email);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        String string8 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_description_email);
        Intrinsics.checkNotNullExpressionValue(string8, "");
        arrayList.add(new ProfileCompletionTasksModel(string7, string8, this.getAuthRequestContext.getEmail().length() > 0, SubtitleType.EMAIL));
        String string9 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.lbl_profile_completion_title_default);
        Intrinsics.checkNotNullExpressionValue(string9, "");
        Context context3 = this.BuiltInFictitiousFunctionClassFactory;
        String string10 = context3.getString(R.string.lbl_profile_completion_desc_default, context3.getString(R.string.profile_completion_task_nickname));
        Intrinsics.checkNotNullExpressionValue(string10, "");
        String nickName = this.getAuthRequestContext.getNickName();
        if (this.PlaceComponentResult) {
            string9 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_username);
            Intrinsics.checkNotNullExpressionValue(string9, "");
            string10 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_description_username);
            Intrinsics.checkNotNullExpressionValue(string10, "");
            nickName = this.getAuthRequestContext.getUsername();
            str = UpdateUserInfoRequest.USERNAME;
        } else {
            str = "NICKNAME";
        }
        arrayList.add(new ProfileCompletionTasksModel(string9, string10, nickName.length() > 0, str));
        String string11 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_security_question);
        Intrinsics.checkNotNullExpressionValue(string11, "");
        String string12 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.profile_completion_task_description_security_question);
        Intrinsics.checkNotNullExpressionValue(string12, "");
        arrayList.add(new ProfileCompletionTasksModel(string11, string12, this.getAuthRequestContext.getSecurityQuestionAvailable(), SubtitleType.SECURITY_QUESTIONS));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = arrayList;
    }
}
