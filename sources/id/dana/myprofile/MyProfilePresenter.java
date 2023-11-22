package id.dana.myprofile;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.Lazy;
import id.dana.R;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.data.userconfig.BiztypeNotFoundException;
import id.dana.data.usereducation.repository.source.local.UserEducationPreference;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.account.interactor.UploadAvatar;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.domain.familyaccount.interactor.CheckConsultFamilyAccount;
import id.dana.domain.familyaccount.model.ConsultFamilyAccountResult;
import id.dana.domain.featureconfig.interactor.CheckShowReferralCodeFeature;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.profilecompletion.interactor.CheckUsernameConfig;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionData;
import id.dana.domain.profilecompletion.interactor.GetProfileCompletionVisibility;
import id.dana.domain.profilecompletion.model.ProfileCompletionData;
import id.dana.domain.profilecompletion.model.ProfileCompletionVisibility;
import id.dana.domain.profilemenu.interactor.GetLastHideRedDotTimestamp;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.domain.profilemenu.interactor.GetUserConfigProfileNewFlag;
import id.dana.domain.profilemenu.interactor.SaveLastHideRedDotTimestamp;
import id.dana.domain.profilemenu.interactor.SaveProfileNewFlagUserConfig;
import id.dana.domain.profilemenu.model.ProfileCompletion;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.model.UserConfigProfileNewFlag;
import id.dana.domain.recurring.subscription.interactor.GetCountRecurringSubscription;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.domain.referraltracker.interactor.GetReferralTracker;
import id.dana.domain.referraltracker.model.ReferralTracker;
import id.dana.domain.registration.interactor.GetChatBotTimestamp;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.uploadfiles.ClearFiles;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.wallet_v3.interactor.GetWalletConfigFromLocal;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.mapper.ReferralTrackerModelMapper;
import id.dana.model.KycInfo;
import id.dana.model.UserInfo;
import id.dana.myprofile.MyProfileContract;
import id.dana.myprofile.model.ProfileCompletionTasksModel;
import id.dana.myprofile.model.ProfileCompletionTrustedDeviceTaskModel;
import id.dana.myprofile.settingconfig.DanaPlusSettingConfigRunner;
import id.dana.myprofile.settingconfig.DanaPlusStarAmSettingConfigRunner;
import id.dana.myprofile.settingconfig.DefaultSettingMapper;
import id.dana.myprofile.settingconfig.FamilyAccountSettingConfigRunner;
import id.dana.myprofile.settingconfig.GoldSettingConfigRunner;
import id.dana.myprofile.settingconfig.KybSettingConfigRunner;
import id.dana.myprofile.settingconfig.ReferralSettingConfigRunner;
import id.dana.onboarding.referral.constants.ReferralEngagementScenarios;
import id.dana.referral.model.MyReferralConsult;
import id.dana.referral.model.MyReferralConsultMapper;
import id.dana.referral.referraltracker.model.ReferralTrackerModel;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.ErrorUtil;
import id.dana.utils.StringWrapper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.session.SessionManager;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 \u0096\u00012\u00020\u0001:\u0002\u0096\u0001B\u0097\u0004\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020:04\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020r04\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020q04\u0012\f\u0010s\u001a\b\u0012\u0004\u0012\u00020m04\u0012\f\u0010t\u001a\b\u0012\u0004\u0012\u00020k04\u0012\f\u0010u\u001a\b\u0012\u0004\u0012\u00020^04\u0012\f\u0010v\u001a\b\u0012\u0004\u0012\u00020j04\u0012\f\u0010w\u001a\b\u0012\u0004\u0012\u00020D04\u0012\f\u0010x\u001a\b\u0012\u0004\u0012\u00020E04\u0012\f\u0010y\u001a\b\u0012\u0004\u0012\u00020804\u0012\f\u0010z\u001a\b\u0012\u0004\u0012\u00020P04\u0012\f\u0010{\u001a\b\u0012\u0004\u0012\u00020>04\u0012\f\u0010|\u001a\b\u0012\u0004\u0012\u00020J04\u0012\f\u0010}\u001a\b\u0012\u0004\u0012\u00020704\u0012\f\u0010~\u001a\b\u0012\u0004\u0012\u00020\\04\u0012\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020V04\u0012\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020_04\u0012\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020;04\u0012\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020<04\u0012\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020T04\u0012\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020i04\u0012\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020=04\u0012\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020504\u0012\r\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020904\u0012\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020R04\u0012\r\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020F04\u0012\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020a04\u0012\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020L04\u0012\r\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020f04\u0012\r\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020c04\u0012\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020A04\u0012\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020N04\u0012\r\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020?04\u0012\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020B04\u0012\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020d04\u0012\r\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020H04¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\t\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\n\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\n\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\b\u0010\u000fJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0006J\u000f\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0006J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0007\u0010\u000fJ\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010'J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010)J'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020*2\u0006\u0010&\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010-J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020*2\u0006\u0010&\u001a\u00020.H\u0016¢\u0006\u0004\b\b\u0010/J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u000201H\u0016¢\u0006\u0004\b\t\u00102R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\fX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u00103R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u000205048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00106R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u000207048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00106R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u000208048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u00106R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u000209048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u00106R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020:048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00106R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020;048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00106R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020<048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u00106R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020=048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u00106R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020>048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00106R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020?048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00106R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020A048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00106R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020B048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00106R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020D048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020E048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u00106R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020F048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u00106R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020H048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u00106R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020J048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00106R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020L048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u00106R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020N048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u00106R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020P048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u00106R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020R048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u00106R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020T048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u00106R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020V048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u00106R\u0012\u0010C\u001a\u00020\fX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u00103R\u0012\u0010O\u001a\u00020\u001bX\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010XR\u0012\u0010M\u001a\u00020\fX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u00103R\u001a\u0010K\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010YX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010[R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\\048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u00106R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020^048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00106R\u0016\u0010Q\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010XR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020_048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u00106R\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020a048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u00106R\u001a\u0010]\u001a\b\u0012\u0004\u0012\u00020c048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u00106R\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020d048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u00106R\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020f048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u00106R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020i048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u00106R\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020j048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u00106R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020k048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u00106R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020m048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u00106R\u0014\u0010p\u001a\u0004\u0018\u00010.X\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010oR\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020q048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u00106R\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020r048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u00106"}, d2 = {"Lid/dana/myprofile/MyProfilePresenter;", "Lid/dana/myprofile/MyProfileContract$Presenter;", "", "p0", "", "PlaceComponentResult", "()V", "MyBillsEntityDataFactory", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "getErrorConfigVersion", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "lookAheadTest", "scheduleImpl", "moveToNextValue", "", "(Ljava/lang/String;)J", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/referral/model/MyReferralConsult;", "GetContactSyncConfig", "()Lid/dana/referral/model/MyReferralConsult;", "initRecordTimeStamp", "", "DatabaseTableConfigUtil", "()I", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda5", "onDestroy", "Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;", "p1", "(Lid/dana/domain/profilemenu/model/UserConfigProfileNewFlag;Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "(Z)V", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;", "p2", "(Lid/dana/domain/profilemenu/model/SettingModel;Lid/dana/domain/familyaccount/model/ConsultFamilyAccountResult;Z)V", "Lid/dana/model/UserInfo;", "(Lid/dana/domain/profilemenu/model/SettingModel;Lid/dana/model/UserInfo;)V", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Ljava/io/File;", "(Ljava/io/File;)V", "Ljava/lang/String;", "Ldagger/Lazy;", "Lid/dana/domain/familyaccount/interactor/CheckConsultFamilyAccount;", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/CheckShowReferralCodeFeature;", "Lid/dana/domain/profilecompletion/interactor/CheckUsernameConfig;", "Lid/dana/domain/uploadfiles/ClearFiles;", "Landroid/content/Context;", "Lid/dana/myprofile/settingconfig/DanaPlusSettingConfigRunner;", "Lid/dana/myprofile/settingconfig/DanaPlusStarAmSettingConfigRunner;", "Lid/dana/myprofile/settingconfig/FamilyAccountSettingConfigRunner;", "Lid/dana/domain/account/interactor/GetAvatarUrl;", "Lid/dana/domain/registration/interactor/GetChatBotTimestamp;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/domain/recurring/subscription/interactor/GetCountRecurringSubscription;", "Lid/dana/domain/profilemenu/interactor/GetLastHideRedDotTimestamp;", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/domain/profilecompletion/interactor/GetProfileCompletionData;", "Lid/dana/domain/profilecompletion/interactor/GetProfileCompletionVisibility;", "Lid/dana/domain/referraltracker/interactor/GetReferralTracker;", "SubSequence", "Lid/dana/domain/services/interactor/GetService;", "getSupportButtonTintMode", "Lid/dana/domain/profilemenu/interactor/GetSettingCollection;", "whenAvailable", "Lid/dana/domain/profilemenu/interactor/GetUserConfigProfileNewFlag;", "getCallingPid", "Lid/dana/domain/account/interactor/GetUserId;", "readMicros", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "C", "Lid/dana/domain/wallet_v3/interactor/GetWalletConfigFromLocal;", DiskFormatter.B, "Lid/dana/myprofile/settingconfig/GoldSettingConfigRunner;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/myprofile/settingconfig/KybSettingConfigRunner;", "A", "I", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/referral/model/MyReferralConsultMapper;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/domain/usereducation/interactor/IsNeedToShowToolTip;", "Lid/dana/myprofile/settingconfig/ReferralSettingConfigRunner;", SummaryActivity.DAYS, "Lid/dana/mapper/ReferralTrackerModelMapper;", "E", "Lid/dana/domain/deeplink/interactor/RemoveDeepLinkPayload;", "Lid/dana/domain/profilemenu/interactor/SaveLastHideRedDotTimestamp;", "getValueOfTouchPositionAbsolute", "Lid/dana/domain/profilemenu/interactor/SaveProfileNewFlagUserConfig;", "VerifyPinStateManager$executeRiskChallenge$2$2", "getOnBoardingScenario", "Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;", "Lid/dana/domain/usereducation/interactor/SaveShowToolTip;", "Lid/dana/utils/session/SessionManager;", SummaryActivity.HOURS, "Lid/dana/domain/account/interactor/UploadAvatar;", LogConstants.RESULT_FALSE, "Lid/dana/model/UserInfo;", "AppCompatEmojiTextHelper", "Lid/dana/myprofile/UserInfoMapper;", "Lid/dana/myprofile/MyProfileContract$View;", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "p27", "p28", "p29", "p30", "p31", "p32", "p33", "p34", "p35", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyProfilePresenter implements MyProfileContract.Presenter {

    /* renamed from: A  reason: from kotlin metadata */
    private final Lazy<KybSettingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    private final Lazy<UserInfoMapper> id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String;

    /* renamed from: B */
    private final Lazy<GetWalletConfigFromLocal> NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private final Lazy<GoldSettingConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Lazy<GetAvatarUrl> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: C  reason: from kotlin metadata */
    private final Lazy<GetUserInfoWithKyc> NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: D */
    private final Lazy<ReferralSettingConfigRunner> BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    final Lazy<SaveReferralEngagementDialogCache> E;

    /* renamed from: E  reason: from kotlin metadata */
    private final Lazy<ReferralTrackerModelMapper> com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;

    /* renamed from: F */
    private final Lazy<UploadAvatar> D;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final Lazy<GetLastHideRedDotTimestamp> DatabaseTableConfigUtil;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    int C;

    /* renamed from: H */
    private final Lazy<SessionManager> getValueOfTouchPositionAbsolute;
    final Lazy<CheckUsernameConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    int readMicros;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    final Lazy<RemoveDeepLinkPayload> VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    final Lazy<MyProfileContract.View> I;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy<GetChatBotTimestamp> GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final Lazy<GetCountRecurringSubscription> initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final Lazy<GetProfileCompletionVisibility> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy<FamilyAccountSettingConfigRunner> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy<DanaPlusSettingConfigRunner> moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy<ClearFiles> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Lazy<GetProfileCompletionData> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy<CheckConsultFamilyAccount> getAuthRequestContext;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private final Lazy<GetReferralTracker> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private final Lazy<MyReferralConsultMapper> SubSequence;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private final Lazy<SaveProfileNewFlagUserConfig> getOnBoardingScenario;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Lazy<Context> getErrorConfigVersion;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final Lazy<GetUserConfigProfileNewFlag> newProxyInstance;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final Lazy<IsNeedToShowToolTip> getSupportButtonTintMode;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private final Lazy<SaveShowToolTip> VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private final Lazy<GetService> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private final Lazy<SaveLastHideRedDotTimestamp> A;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    UserInfo AppCompatEmojiTextHelper;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy<CheckShowReferralCodeFeature> PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public DefaultObserver<UserInfoResponse> whenAvailable;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy<DanaPlusStarAmSettingConfigRunner> scheduleImpl;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final Lazy<GetUserId> PrepareContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    String getCallingPid;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy<GetSettingCollection> isLayoutRequested;

    @Inject
    public MyProfilePresenter(Lazy<Context> lazy, Lazy<MyProfileContract.View> lazy2, Lazy<UserInfoMapper> lazy3, Lazy<UploadAvatar> lazy4, Lazy<SessionManager> lazy5, Lazy<IsNeedToShowToolTip> lazy6, Lazy<SaveShowToolTip> lazy7, Lazy<GetProfileCompletionData> lazy8, Lazy<GetProfileCompletionVisibility> lazy9, Lazy<CheckUsernameConfig> lazy10, Lazy<GetUserInfoWithKyc> lazy11, Lazy<GetAvatarUrl> lazy12, Lazy<GetSettingCollection> lazy13, Lazy<CheckShowReferralCodeFeature> lazy14, Lazy<MyReferralConsultMapper> lazy15, Lazy<KybSettingConfigRunner> lazy16, Lazy<ReferralSettingConfigRunner> lazy17, Lazy<DanaPlusSettingConfigRunner> lazy18, Lazy<DanaPlusStarAmSettingConfigRunner> lazy19, Lazy<GoldSettingConfigRunner> lazy20, Lazy<SaveReferralEngagementDialogCache> lazy21, Lazy<FamilyAccountSettingConfigRunner> lazy22, Lazy<CheckConsultFamilyAccount> lazy23, Lazy<ClearFiles> lazy24, Lazy<GetWalletConfigFromLocal> lazy25, Lazy<GetReferralTracker> lazy26, Lazy<ReferralTrackerModelMapper> lazy27, Lazy<GetUserConfigProfileNewFlag> lazy28, Lazy<SaveProfileNewFlagUserConfig> lazy29, Lazy<RemoveDeepLinkPayload> lazy30, Lazy<GetCountRecurringSubscription> lazy31, Lazy<GetUserId> lazy32, Lazy<GetChatBotTimestamp> lazy33, Lazy<GetLastHideRedDotTimestamp> lazy34, Lazy<SaveLastHideRedDotTimestamp> lazy35, Lazy<GetService> lazy36) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        Intrinsics.checkNotNullParameter(lazy11, "");
        Intrinsics.checkNotNullParameter(lazy12, "");
        Intrinsics.checkNotNullParameter(lazy13, "");
        Intrinsics.checkNotNullParameter(lazy14, "");
        Intrinsics.checkNotNullParameter(lazy15, "");
        Intrinsics.checkNotNullParameter(lazy16, "");
        Intrinsics.checkNotNullParameter(lazy17, "");
        Intrinsics.checkNotNullParameter(lazy18, "");
        Intrinsics.checkNotNullParameter(lazy19, "");
        Intrinsics.checkNotNullParameter(lazy20, "");
        Intrinsics.checkNotNullParameter(lazy21, "");
        Intrinsics.checkNotNullParameter(lazy22, "");
        Intrinsics.checkNotNullParameter(lazy23, "");
        Intrinsics.checkNotNullParameter(lazy24, "");
        Intrinsics.checkNotNullParameter(lazy25, "");
        Intrinsics.checkNotNullParameter(lazy26, "");
        Intrinsics.checkNotNullParameter(lazy27, "");
        Intrinsics.checkNotNullParameter(lazy28, "");
        Intrinsics.checkNotNullParameter(lazy29, "");
        Intrinsics.checkNotNullParameter(lazy30, "");
        Intrinsics.checkNotNullParameter(lazy31, "");
        Intrinsics.checkNotNullParameter(lazy32, "");
        Intrinsics.checkNotNullParameter(lazy33, "");
        Intrinsics.checkNotNullParameter(lazy34, "");
        Intrinsics.checkNotNullParameter(lazy35, "");
        Intrinsics.checkNotNullParameter(lazy36, "");
        this.getErrorConfigVersion = lazy;
        this.I = lazy2;
        this.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String = lazy3;
        this.D = lazy4;
        this.getValueOfTouchPositionAbsolute = lazy5;
        this.getSupportButtonTintMode = lazy6;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = lazy7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy9;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = lazy11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy12;
        this.isLayoutRequested = lazy13;
        this.PlaceComponentResult = lazy14;
        this.SubSequence = lazy15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = lazy16;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = lazy17;
        this.moveToNextValue = lazy18;
        this.scheduleImpl = lazy19;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = lazy20;
        this.E = lazy21;
        this.lookAheadTest = lazy22;
        this.getAuthRequestContext = lazy23;
        this.BuiltInFictitiousFunctionClassFactory = lazy24;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = lazy25;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy26;
        this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = lazy27;
        this.newProxyInstance = lazy28;
        this.getOnBoardingScenario = lazy29;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = lazy30;
        this.initRecordTimeStamp = lazy31;
        this.PrepareContext = lazy32;
        this.GetContactSyncConfig = lazy33;
        this.DatabaseTableConfigUtil = lazy34;
        this.A = lazy35;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy36;
        this.readMicros = 6;
        this.FragmentBottomSheetPaymentSettingBinding = "";
        this.getCallingPid = "";
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().execute(NoParams.INSTANCE, new Function1<WalletConfig, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$getWalletFeatureNewConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(WalletConfig walletConfig) {
                invoke2(walletConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(WalletConfig walletConfig) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(walletConfig, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(walletConfig.getFeatureWalletNew());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$getWalletFeatureNewConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(false);
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final MyReferralConsult GetContactSyncConfig() {
        MyReferralConsult BuiltInFictitiousFunctionClassFactory = this.SubSequence.get().BuiltInFictitiousFunctionClassFactory(this.BottomSheetCardBindingView$watcherCardNumberView$1.get().MyBillsEntityDataFactory);
        return BuiltInFictitiousFunctionClassFactory == null ? new MyReferralConsult() : BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void newProxyInstance() {
        this.PrepareContext.get().execute(new DefaultObserver<String>() { // from class: id.dana.myprofile.MyProfilePresenter$loadUserId$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                MyProfilePresenter myProfilePresenter = MyProfilePresenter.this;
                Intrinsics.checkNotNullParameter(str, "");
                myProfilePresenter.getCallingPid = str;
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    /* renamed from: PrepareContext  reason: from getter */
    public final String getGetCallingPid() {
        return this.getCallingPid;
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        GetChatBotTimestamp getChatBotTimestamp = this.GetContactSyncConfig.get();
        Intrinsics.checkNotNullExpressionValue(getChatBotTimestamp, "");
        BaseUseCase.execute$default(getChatBotTimestamp, new GetChatBotTimestamp.Params(p0), new Function1<Long, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$getChatbotTimestamp$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                Lazy lazy;
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2(j);
            }
        }, null, 4, null);
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final String scheduleImpl() {
        String str = this.BottomSheetCardBindingView$watcherCardNumberView$1.get().getAuthRequestContext;
        return str == null ? "" : str;
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new MyProfilePresenter$getAvatarUrl$1(this));
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        DefaultObserver<UserInfoResponse> defaultObserver = this.whenAvailable;
        if (defaultObserver != null) {
            if (defaultObserver != null) {
                defaultObserver.dispose();
            }
            this.whenAvailable = null;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.I.get().showProgress();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.NetworkUserEntityData$$ExternalSyntheticLambda4.get());
        arrayList.add(this.BottomSheetCardBindingView$watcherCardNumberView$1.get());
        arrayList.add(this.moveToNextValue.get());
        arrayList.add(this.scheduleImpl.get());
        arrayList.add(this.NetworkUserEntityData$$ExternalSyntheticLambda6.get());
        arrayList.add(this.lookAheadTest.get());
        this.isLayoutRequested.get().execute(new DefaultObserver<List<? extends SettingModel>>() { // from class: id.dana.myprofile.MyProfilePresenter$getSettingsCollection$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Lazy lazy;
                Lazy lazy2;
                List<? extends SettingModel> list = (List) obj;
                Intrinsics.checkNotNullParameter(list, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).dismissProgress();
                lazy2 = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy2.get()).getAuthRequestContext(list);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(p02, "");
                super.onError(p02);
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).dismissProgress();
                lazy2 = MyProfilePresenter.this.I;
                MyProfileContract.View view = (MyProfileContract.View) lazy2.get();
                lazy3 = MyProfilePresenter.this.getErrorConfigVersion;
                String BuiltInFictitiousFunctionClassFactory = ErrorUtil.BuiltInFictitiousFunctionClassFactory((Context) lazy3.get());
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                view.onError(BuiltInFictitiousFunctionClassFactory);
            }
        }, GetSettingCollection.Params.forGetSettingCollection(p0, arrayList, new DefaultSettingMapper(this.getErrorConfigVersion.get())));
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.getSupportButtonTintMode.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.myprofile.MyProfilePresenter$checkProfileCompletionVisibility$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Lazy lazy;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).getAuthRequestContext(booleanValue);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, "[IsNeedToShowTooltip]MyProfilePresenter:onError", p0);
            }
        }, IsNeedToShowToolTip.Params.forShowTooltip("profile_completion_widget"));
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void isLayoutRequested() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().execute(NoParams.INSTANCE, new Function1<ProfileCompletionVisibility, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$loadProfileCompletionData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ProfileCompletionVisibility profileCompletionVisibility) {
                invoke2(profileCompletionVisibility);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ProfileCompletionVisibility profileCompletionVisibility) {
                Intrinsics.checkNotNullParameter(profileCompletionVisibility, "");
                if (profileCompletionVisibility.isVisible()) {
                    final MyProfilePresenter myProfilePresenter = MyProfilePresenter.this;
                    myProfilePresenter.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(new GetProfileCompletionData.Params("1.0.0"), new Function1<ProfileCompletionData, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$beginLoadProfileCompletionData$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(ProfileCompletionData profileCompletionData) {
                            invoke2(profileCompletionData);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(final ProfileCompletionData profileCompletionData) {
                            Intrinsics.checkNotNullParameter(profileCompletionData, "");
                            final MyProfilePresenter myProfilePresenter2 = MyProfilePresenter.this;
                            Intrinsics.checkNotNullParameter(profileCompletionData, "");
                            myProfilePresenter2.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.myprofile.MyProfilePresenter$checkUsernameConfig$1
                                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                public final /* synthetic */ void onNext(Object obj) {
                                    ProfileCompletionTasksModel profileCompletionTasksModel;
                                    Long valueOf;
                                    boolean booleanValue = ((Boolean) obj).booleanValue();
                                    final MyProfilePresenter myProfilePresenter3 = MyProfilePresenter.this;
                                    ProfileCompletionData profileCompletionData2 = profileCompletionData;
                                    Intrinsics.checkNotNullParameter(profileCompletionData2, "");
                                    myProfilePresenter3.readMicros = profileCompletionData2.getShouldShowTrustedDevice() ? 6 : 5;
                                    Context context = myProfilePresenter3.getErrorConfigVersion.get();
                                    Intrinsics.checkNotNullExpressionValue(context, "");
                                    ProfileCompletionTaskManager profileCompletionTaskManager = new ProfileCompletionTaskManager(context, profileCompletionData2, booleanValue);
                                    Iterator<? extends ProfileCompletionTasksModel> it = profileCompletionTaskManager.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            profileCompletionTasksModel = it.next();
                                            if (!profileCompletionTasksModel.getMyBillsEntityDataFactory()) {
                                                break;
                                            }
                                        } else {
                                            profileCompletionTasksModel = new ProfileCompletionTasksModel(null, null, false, null, 15, null);
                                            break;
                                        }
                                    }
                                    Iterator<? extends ProfileCompletionTasksModel> it2 = profileCompletionTaskManager.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                                    int i = 0;
                                    while (it2.hasNext()) {
                                        if (it2.next().getMyBillsEntityDataFactory()) {
                                            i++;
                                        }
                                    }
                                    int i2 = myProfilePresenter3.C;
                                    int i3 = myProfilePresenter3.readMicros;
                                    if (i2 == i3 - 1 && i == i3) {
                                        SaveReferralEngagementDialogCache saveReferralEngagementDialogCache = myProfilePresenter3.E.get();
                                        Intrinsics.checkNotNullExpressionValue(saveReferralEngagementDialogCache, "");
                                        SaveReferralEngagementDialogCache saveReferralEngagementDialogCache2 = saveReferralEngagementDialogCache;
                                        ReferralEngagementScenarios referralEngagementScenarios = ReferralEngagementScenarios.INSTANCE;
                                        String PlaceComponentResult = ReferralEngagementScenarios.PlaceComponentResult();
                                        valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
                                        Intrinsics.checkNotNullExpressionValue(valueOf, "");
                                        BaseUseCase.execute$default(saveReferralEngagementDialogCache2, new SaveReferralEngagementDialogCache.Param(PlaceComponentResult, true, valueOf.longValue()), new Function1<Boolean, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$setReferralEngagementDialog$1
                                            public final void invoke(boolean z) {
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* synthetic */ Unit invoke(Boolean bool) {
                                                invoke(bool.booleanValue());
                                                return Unit.INSTANCE;
                                            }
                                        }, null, 4, null);
                                    }
                                    myProfilePresenter3.C = i;
                                    final ProfileCompletion profileCompletion = new ProfileCompletion(null, null, 0, 0, null, null, 63, null);
                                    profileCompletion.setName(profileCompletionTasksModel.getAuthRequestContext);
                                    profileCompletion.setViewType(13);
                                    profileCompletion.setAction(i != myProfilePresenter3.readMicros ? "profile_completion_widget" : MyProfileMenuAction.CLOSE_PROFILE_COMPLETION_WIDGET);
                                    profileCompletion.setCompletedTaskCount(i);
                                    profileCompletion.setTaskCount(myProfilePresenter3.readMicros);
                                    profileCompletion.setCurrentTaskTitle(profileCompletionTasksModel.getAuthRequestContext);
                                    profileCompletion.setCurrentTaskDesc(profileCompletionTasksModel.KClassImpl$Data$declaredNonStaticMembers$2);
                                    profileCompletion.setTaskType(profileCompletionTasksModel.BuiltInFictitiousFunctionClassFactory);
                                    if (profileCompletionTasksModel instanceof ProfileCompletionTrustedDeviceTaskModel) {
                                        profileCompletion.setSecurityIdForTrustedDevice(((ProfileCompletionTrustedDeviceTaskModel) profileCompletionTasksModel).MyBillsEntityDataFactory);
                                    }
                                    myProfilePresenter3.getSupportButtonTintMode.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.myprofile.MyProfilePresenter$proceedProfileCompletionWidgetData$1
                                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                        public final /* synthetic */ void onNext(Object obj2) {
                                            Lazy lazy;
                                            boolean booleanValue2 = ((Boolean) obj2).booleanValue();
                                            boolean z = ProfileCompletion.this.getCompletedTaskCount() != myProfilePresenter3.readMicros;
                                            if (booleanValue2 || z) {
                                                lazy = myProfilePresenter3.I;
                                                ((MyProfileContract.View) lazy.get()).MyBillsEntityDataFactory(ProfileCompletion.this);
                                            }
                                            if (z) {
                                                myProfilePresenter3.MyBillsEntityDataFactory(false);
                                            }
                                        }
                                    }, IsNeedToShowToolTip.Params.forShowTooltip(UserEducationPreference.PROFILE_COMPLETION_WIDGET_CLOSED));
                                }

                                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                                public final void onError(Throwable p0) {
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    super.onError(p0);
                                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, "[GetProfileCompletionData]MyProfilePresenter:onError", p0);
                                }
                            });
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$beginLoadProfileCompletionData$2
                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, "[GetProfileCompletionData]MyProfilePresenter:onError", th);
                        }
                    });
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$loadProfileCompletionData$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, "[GetProfileCompletionVisibility]MyProfilePresenter:onError", th);
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void MyBillsEntityDataFactory(boolean p0) {
        this.VerifyPinStateManager$executeRiskChallenge$2$2.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.myprofile.MyProfilePresenter$setProfileCompletionWidgetClosed$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, "[DismissProfileCompletionWidget]MyProfilePresenter:onError", p02);
            }
        }, SaveShowToolTip.Params.forSaveShowToolTip(p0, UserEducationPreference.PROFILE_COMPLETION_WIDGET_CLOSED));
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(File p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.D.get().execute(new DefaultObserver<String>() { // from class: id.dana.myprofile.MyProfilePresenter$uploadAvatar$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Lazy lazy;
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).MyBillsEntityDataFactory(str);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(p02, "");
                lazy = MyProfilePresenter.this.I;
                MyProfileContract.View view = (MyProfileContract.View) lazy.get();
                lazy2 = MyProfilePresenter.this.getErrorConfigVersion;
                String PlaceComponentResult = ErrorUtil.PlaceComponentResult(p02, (Context) lazy2.get());
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                view.onError(PlaceComponentResult);
                MyProfilePresenter.MyBillsEntityDataFactory(DanaLogConstants.Prefix.PROFILE_UPLOADAVATARURL_PREFIX, p02);
            }
        }, UploadAvatar.Params.forUploadAvatar(p0));
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    /* renamed from: DatabaseTableConfigUtil  reason: from getter */
    public final int getReadMicros() {
        return this.readMicros;
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        this.I.get().lookAheadTest();
        this.getValueOfTouchPositionAbsolute.get().BuiltInFictitiousFunctionClassFactory(new Function0<Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$logout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Lazy lazy;
                Lazy lazy2;
                try {
                    DanaLog.getAuthRequestContext("MyProfilePresenter", Intrinsics.areEqual(Boolean.TRUE, MyProfilePresenter.this.VerifyPinStateManager$executeRiskChallenge$2$1.get().execute()) ? "Deeplink Payload removed" : "Deeplink Payload already removed");
                } catch (Exception e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory("MyProfilePresenter", "Deeplink Payload already removed", e);
                }
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2();
                lazy2 = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy2.get()).getAuthRequestContext();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$logout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2();
                lazy2 = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy2.get()).onError("");
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.I.get().showProgress();
        this.PlaceComponentResult.get().execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$checkShowReferralCodeFeature$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                Lazy lazy2;
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).dismissProgress();
                lazy2 = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy2.get()).KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$checkShowReferralCodeFeature$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).dismissProgress();
                lazy2 = MyProfilePresenter.this.I;
                MyProfileContract.View view = (MyProfileContract.View) lazy2.get();
                lazy3 = MyProfilePresenter.this.getErrorConfigVersion;
                String BuiltInFictitiousFunctionClassFactory = ErrorUtil.BuiltInFictitiousFunctionClassFactory((Context) lazy3.get());
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                view.onError(BuiltInFictitiousFunctionClassFactory);
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2() {
        String str;
        UserInfo userInfo = this.AppCompatEmojiTextHelper;
        return (userInfo == null || (str = userInfo.GetContactSyncConfig) == null) ? "" : str;
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    /* renamed from: moveToNextValue  reason: from getter */
    public final String getFragmentBottomSheetPaymentSettingBinding() {
        return this.FragmentBottomSheetPaymentSettingBinding;
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final String getErrorConfigVersion() {
        String str = this.MyBillsEntityDataFactory;
        return str == null ? "" : str;
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void getAuthRequestContext(SettingModel p0, UserInfo p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.get().getAuthRequestContext(p0, p1);
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        this.VerifyPinStateManager$executeRiskChallenge$2$2.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.myprofile.MyProfilePresenter$setProfileCompletionTooltipShown$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SAVE_SHOW_TOOLTIP_PREFIX);
                sb.append(getClass().getName());
                sb.append(":onError");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), p0);
            }
        }, SaveShowToolTip.Params.forSaveShowToolTip(true, "profile_completion_widget"));
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$clearUploadFilesData$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$clearUploadFilesData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th != null) {
                    MyProfilePresenter.MyBillsEntityDataFactory("[ClearFiles]", th);
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00f3, code lost:
    
        if (r14.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CANNOT_CREATE) != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00f5, code lost:
    
        r0 = r15.PlaceComponentResult;
        r20.setSubtitleColor("#ff108ee9");
        r20.setSubtitle(r15.PlaceComponentResult.getString(id.dana.R.string.family_account_lets_activate));
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x017a, code lost:
    
        if (r15.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.ACCOUNT_HAS_FROZEN) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0182, code lost:
    
        if (r15.equals("ORGANIZER_HAS_FROZEN") != false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0184, code lost:
    
        r20.setTitle(r12.PlaceComponentResult.getString(id.dana.R.string.family_account_setting_frozen_title));
        r20.setSubtitle(r12.PlaceComponentResult.getString(id.dana.R.string.family_account_setting_frozen_subtitle));
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01a2, code lost:
    
        if (r15.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CAN_CREATE) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0230, code lost:
    
        if (r15.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CANNOT_CREATE) != false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0232, code lost:
    
        r20.setTitle(r12.PlaceComponentResult.getString(id.dana.R.string.family_account_setting_title));
        r20.setSubtitle(r12.PlaceComponentResult.getString(id.dana.R.string.family_account_setting_subtitle));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0068, code lost:
    
        if (r14.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.ACCOUNT_HAS_FROZEN) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0070, code lost:
    
        if (r14.equals("ORGANIZER_HAS_FROZEN") != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0077, code lost:
    
        if (r14.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CAN_CREATE) == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x007f, code lost:
    
        if (r14.equals(id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_FAMILY_ACCOUNT) != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0081, code lost:
    
        r0 = r15.PlaceComponentResult;
        r20.setSubtitleColor("#ff108ee9");
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x008e, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r21.getRole(), id.dana.familyaccount.constants.FamilyAccountRoleType.ORGANIZER) == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0090, code lost:
    
        r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
        r0 = java.lang.String.format("%s %s", java.util.Arrays.copyOf(new java.lang.Object[]{r21.getBalance().getCurrency(), r21.getBalance().getAmount()}, 2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r20.setSubtitle(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00c4, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r21.getRole(), "MEMBER") == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00c6, code lost:
    
        r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE;
        r0 = java.lang.String.format("%s %s", java.util.Arrays.copyOf(new java.lang.Object[]{r21.getRemainingAmount().getCurrency(), r21.getRemainingAmount().getAmount()}, 2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r20.setSubtitle(r0);
     */
    @Override // id.dana.myprofile.MyProfileContract.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(id.dana.domain.profilemenu.model.SettingModel r20, id.dana.domain.familyaccount.model.ConsultFamilyAccountResult r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfilePresenter.PlaceComponentResult(id.dana.domain.profilemenu.model.SettingModel, id.dana.domain.familyaccount.model.ConsultFamilyAccountResult, boolean):void");
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void PlaceComponentResult() {
        this.I.get().showProgress();
        this.getAuthRequestContext.get().execute(new CheckConsultFamilyAccount.Params(true), new Function1<ConsultFamilyAccountResult, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$checkConsultFamilyAccount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ConsultFamilyAccountResult consultFamilyAccountResult) {
                invoke2(consultFamilyAccountResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ConsultFamilyAccountResult consultFamilyAccountResult) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(consultFamilyAccountResult, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).dismissProgress();
                lazy2 = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy2.get()).BuiltInFictitiousFunctionClassFactory(consultFamilyAccountResult);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$checkConsultFamilyAccount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, "[GetConsultFamilyAccount]MyProfilePresenter:onError", th);
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).dismissProgress();
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void initRecordTimeStamp() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().execute(new DefaultObserver<ReferralTracker>() { // from class: id.dana.myprofile.MyProfilePresenter$getReferralTracker$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Lazy lazy;
                Lazy lazy2;
                ReferralTracker referralTracker = (ReferralTracker) obj;
                Intrinsics.checkNotNullParameter(referralTracker, "");
                lazy = MyProfilePresenter.this.I;
                MyProfileContract.View view = (MyProfileContract.View) lazy.get();
                lazy2 = MyProfilePresenter.this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;
                ReferralTrackerModel apply = ((ReferralTrackerModelMapper) lazy2.get()).apply(referralTracker);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.getAuthRequestContext(apply);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(p0, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).PlaceComponentResult();
            }
        }, GetReferralTracker.Params.forReferralTracker(1, 5));
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        this.newProxyInstance.get().execute(NoParams.INSTANCE, new Function1<UserConfigProfileNewFlag, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$getUserConfigNewBadge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserConfigProfileNewFlag userConfigProfileNewFlag) {
                invoke2(userConfigProfileNewFlag);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserConfigProfileNewFlag userConfigProfileNewFlag) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(userConfigProfileNewFlag, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).PlaceComponentResult(userConfigProfileNewFlag);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$getUserConfigNewBadge$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                if (!(th instanceof BiztypeNotFoundException)) {
                    lazy = MyProfilePresenter.this.I;
                    boolean z = false;
                    ((MyProfileContract.View) lazy.get()).PlaceComponentResult(new UserConfigProfileNewFlag(z, z, 3, null));
                    return;
                }
                MyProfilePresenter.this.PlaceComponentResult(new UserConfigProfileNewFlag(true, true), true);
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void PlaceComponentResult(final UserConfigProfileNewFlag p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getOnBoardingScenario.get().execute(p0, new Function1<Boolean, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$saveUserConfigNewBadge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).MyBillsEntityDataFactory(p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$saveUserConfigNewBadge$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                if (p1) {
                    return;
                }
                lazy = this.I;
                ((MyProfileContract.View) lazy.get()).MyBillsEntityDataFactory(p0);
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final long KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Long blockingFirst = this.DatabaseTableConfigUtil.get().buildUseCase(p0).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).blockingFirst();
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return blockingFirst.longValue();
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SaveLastHideRedDotTimestamp saveLastHideRedDotTimestamp = this.A.get();
        Intrinsics.checkNotNullExpressionValue(saveLastHideRedDotTimestamp, "");
        CompletableUseCase.execute$default(saveLastHideRedDotTimestamp, p0, null, null, 6, null);
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().execute("service_promo_quest", new Function1<ThirdPartyServiceResponse, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$checkPromoQuestService$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                invoke2(thirdPartyServiceResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ThirdPartyServiceResponse thirdPartyServiceResponse) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(thirdPartyServiceResponse, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(thirdPartyServiceResponse);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$checkPromoQuestService$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void lookAheadTest() {
        this.initRecordTimeStamp.get().execute(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$getCountBills$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                StringWrapper.StringValue stringValue;
                StringWrapper.StringValue stringValue2;
                Lazy lazy;
                if (i > 0) {
                    stringValue2 = new StringWrapper.ResValuePlurals(R.plurals.f46692131820555, i, CollectionsKt.listOf(Integer.valueOf(i)));
                } else {
                    StringWrapper.Companion companion = StringWrapper.INSTANCE;
                    stringValue = StringWrapper.PlaceComponentResult;
                    stringValue2 = stringValue;
                }
                lazy = MyProfilePresenter.this.I;
                ((MyProfileContract.View) lazy.get()).getAuthRequestContext(stringValue2);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.myprofile.MyProfilePresenter$getCountBills$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Lazy lazy;
                StringWrapper.StringValue stringValue;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = MyProfilePresenter.this.I;
                MyProfileContract.View view = (MyProfileContract.View) lazy.get();
                StringWrapper.Companion companion = StringWrapper.INSTANCE;
                stringValue = StringWrapper.PlaceComponentResult;
                view.getAuthRequestContext(stringValue);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.getValueOfTouchPositionAbsolute.get().BuiltInFictitiousFunctionClassFactory();
        this.D.get().dispose();
        this.isLayoutRequested.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().dispose();
        this.newProxyInstance.get().dispose();
        this.getOnBoardingScenario.get().dispose();
        this.initRecordTimeStamp.get().dispose();
        this.PrepareContext.get().dispose();
        this.GetContactSyncConfig.get().dispose();
        this.DatabaseTableConfigUtil.get().dispose();
        this.A.get().dispose();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("MyProfilePresenter:onError");
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, sb.toString(), th);
    }

    @Override // id.dana.myprofile.MyProfileContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        DefaultObserver<UserInfoResponse> defaultObserver = this.whenAvailable;
        if (defaultObserver != null) {
            if (defaultObserver != null) {
                defaultObserver.dispose();
            }
            this.whenAvailable = null;
        }
        if (this.whenAvailable == null) {
            this.whenAvailable = new DefaultObserver<UserInfoResponse>() { // from class: id.dana.myprofile.MyProfilePresenter$getUserInfoObserver$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    Lazy lazy;
                    Lazy lazy2;
                    String str;
                    UserInfoResponse userInfoResponse = (UserInfoResponse) obj;
                    Intrinsics.checkNotNullParameter(userInfoResponse, "");
                    lazy = MyProfilePresenter.this.id.dana.sendmoney.summary.SummaryActivity.HOURS java.lang.String;
                    UserInfo MyBillsEntityDataFactory = ((UserInfoMapper) lazy.get()).MyBillsEntityDataFactory(userInfoResponse);
                    MyProfilePresenter.this.AppCompatEmojiTextHelper = MyBillsEntityDataFactory;
                    lazy2 = MyProfilePresenter.this.I;
                    ((MyProfileContract.View) lazy2.get()).MyBillsEntityDataFactory();
                    MyProfilePresenter myProfilePresenter = MyProfilePresenter.this;
                    Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
                    if (!TextUtils.isEmpty(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1) && (str = MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1) != null) {
                        myProfilePresenter.I.get().KClassImpl$Data$declaredNonStaticMembers$2(str);
                    }
                    MyProfilePresenter myProfilePresenter2 = MyProfilePresenter.this;
                    Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
                    if (MyBillsEntityDataFactory.DatabaseTableConfigUtil != null) {
                        KycInfo kycInfo = MyBillsEntityDataFactory.DatabaseTableConfigUtil;
                        if (kycInfo != null && kycInfo.PlaceComponentResult != null) {
                            String str2 = kycInfo.PlaceComponentResult;
                            Intrinsics.checkNotNullExpressionValue(str2, "");
                            myProfilePresenter2.FragmentBottomSheetPaymentSettingBinding = str2;
                        }
                        myProfilePresenter2.I.get().BuiltInFictitiousFunctionClassFactory(kycInfo != null ? kycInfo.PlaceComponentResult : null, kycInfo != null ? kycInfo.getAuthRequestContext : null);
                        if (MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                            myProfilePresenter2.I.get().getAuthRequestContext(MyBillsEntityDataFactory);
                        }
                    }
                    MyProfilePresenter myProfilePresenter3 = MyProfilePresenter.this;
                    String str3 = MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = MyBillsEntityDataFactory.GetContactSyncConfig;
                    if (str4 == null) {
                        str4 = "";
                    }
                    Intrinsics.checkNotNullParameter(str3, "");
                    Intrinsics.checkNotNullParameter(str4, "");
                    if (new Regex("\\d+").matches(str3)) {
                        return;
                    }
                    myProfilePresenter3.I.get().getAuthRequestContext(str4);
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p0) {
                    Lazy lazy;
                    Intrinsics.checkNotNullParameter(p0, "");
                    lazy = MyProfilePresenter.this.I;
                    MyProfileContract.View view = (MyProfileContract.View) lazy.get();
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.PROFILE_TAG, "[ProfileGetUserInfo]MyProfilePresenter:onError", p0);
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onComplete() {
                    MyProfilePresenter myProfilePresenter = MyProfilePresenter.this;
                    myProfilePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new MyProfilePresenter$getAvatarUrl$1(myProfilePresenter));
                }
            };
        }
        DefaultObserver<UserInfoResponse> defaultObserver2 = this.whenAvailable;
        if (defaultObserver2 != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().execute(defaultObserver2, GetUserInfoWithKyc.Params.forParams(true));
        }
    }
}
