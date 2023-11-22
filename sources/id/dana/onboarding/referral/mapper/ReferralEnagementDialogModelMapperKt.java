package id.dana.onboarding.referral.mapper;

import id.dana.domain.referral.model.ReferralEngagementDialog;
import id.dana.onboarding.referral.model.ReferralEngagementDialogModel;
import id.dana.utils.LocaleUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/referral/model/ReferralEngagementDialog;", "Lid/dana/onboarding/referral/model/ReferralEngagementDialogModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/referral/model/ReferralEngagementDialog;)Lid/dana/onboarding/referral/model/ReferralEngagementDialogModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralEnagementDialogModelMapperKt {
    public static final ReferralEngagementDialogModel BuiltInFictitiousFunctionClassFactory(ReferralEngagementDialog referralEngagementDialog) {
        Intrinsics.checkNotNullParameter(referralEngagementDialog, "");
        return new ReferralEngagementDialogModel(referralEngagementDialog.getShowDialog(), LocaleUtil.BuiltInFictitiousFunctionClassFactory() ? referralEngagementDialog.getDialogTitleId() : referralEngagementDialog.getDialogTitleEn(), LocaleUtil.BuiltInFictitiousFunctionClassFactory() ? referralEngagementDialog.getDialogDescriptionId() : referralEngagementDialog.getDialogDescriptionEn(), referralEngagementDialog.getTimerDuration(), referralEngagementDialog.getScenario());
    }
}
