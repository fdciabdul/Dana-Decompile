package id.dana.myprofile.mepagerevamp.profilesettings;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.GriverParams;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.google.common.base.Ascii;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.common.ProfileDividerItemDecoration;
import id.dana.danah5.DanaH5;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.eventbus.base.BaseActivityWithPageLoadTracker;
import id.dana.eventbus.models.TimerEvent;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.mapper.SettingModelMapper;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.MePageRevampModule;
import id.dana.myprofile.mepagerevamp.profilesettings.DaggerProfileSettingsComponent;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract;
import id.dana.myprofile.mepagerevamp.profilesettings.adapter.ProfileSettingsAdapter;
import id.dana.nearbyme.OnRedirectListener;
import id.dana.social.RestrictedContactActivity;
import id.dana.social.view.activity.ChangeUsernameActivity;
import id.dana.utils.ErrorUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.handpick.HandPicked;
import id.dana.utils.handpick.HandPickedResultHandler;
import id.dana.utils.permission.PermissionHelper;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.D;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u0007¢\u0006\u0004\bd\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0004\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0004\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u0019\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\"\u0010\u0005J\u001f\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J!\u0010+\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\u0013H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\u0003H\u0002¢\u0006\u0004\b.\u0010\u0005J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u00102J\u000f\u00103\u001a\u00020\u0003H\u0002¢\u0006\u0004\b3\u0010\u0005J\u0019\u00105\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b5\u00100J\u0017\u00107\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u00100J\u000f\u00108\u001a\u00020\u0003H\u0016¢\u0006\u0004\b8\u0010\u0005J\u000f\u00109\u001a\u00020\u0003H\u0016¢\u0006\u0004\b9\u0010\u0005J\u0017\u0010;\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u00100J\u0017\u0010=\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b=\u00100J\u0017\u0010?\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u00100J\u0017\u0010A\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\bH\u0016¢\u0006\u0004\bA\u00102J\u0017\u0010B\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\bH\u0016¢\u0006\u0004\bB\u00102J\u001f\u0010/\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010DR\u0014\u0010\f\u001a\u00020\u00138CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0015R\"\u0010F\u001a\u00020E8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0006*\u00020L0L8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010MR\u0016\u0010\u0004\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010OR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u0010OR\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u0010YR\u0014\u0010\u001c\u001a\u00020Z8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b.\u0010[R\"\u0010]\u001a\u00020\\8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b3\u0010c"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsActivity;", "Lid/dana/eventbus/base/BaseActivityWithPageLoadTracker;", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$View;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "Lid/dana/domain/profilemenu/model/SettingModel;", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/domain/profilemenu/model/SettingModel;", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)I", "getLayout", "()I", "Lid/dana/myprofile/mepagerevamp/MePageRevampModule;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/myprofile/mepagerevamp/MePageRevampModule;", "", "lookAheadTest", "()Z", "hideNickname", IAPSyncCommand.COMMAND_INIT, "getErrorConfigVersion", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "scheduleImpl", "()Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "moveToNextValue", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onGetUserInfoFailed", "onResume", "Lid/dana/eventbus/models/TimerEvent;", "timerEvent", "", "millisecond", "onTimerEnd", "(Lid/dana/eventbus/models/TimerEvent;J)V", WalletConstant.KYC_LEVEL, "kycCertified", "onUserKycInfo", "(Ljava/lang/String;Z)V", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "initRecordTimeStamp", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "GetContactSyncConfig", GriverParams.ShareParams.IMAGE_URL, "showAvatar", "emailAddress", "showEmailAddress", "showEmailAddressUnset", "showErrorToast", "name", "showNickname", "phoneNumber", "showPhoneNumber", "username", "showUsername", MyProfileBundleKey.SETTING_MODEL, "toggleShareFeedConsentFailed", "toggleShareFeedConsentSuccess", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "Lid/dana/utils/handpick/HandPicked;", "Lid/dana/utils/handpick/HandPicked;", "getAuthRequestContext", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/String;", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "mePageRevampPresenter", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "getMePageRevampPresenter", "()Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "setMePageRevampPresenter", "(Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;)V", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lid/dana/myprofile/mepagerevamp/profilesettings/adapter/ProfileSettingsAdapter;", "Lid/dana/myprofile/mepagerevamp/profilesettings/adapter/ProfileSettingsAdapter;", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$Presenter;", "profileSettingsPresenter", "Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$Presenter;", "getProfileSettingsPresenter", "()Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$Presenter;", "setProfileSettingsPresenter", "(Lid/dana/myprofile/mepagerevamp/profilesettings/ProfileSettingsContract$Presenter;)V", "Lid/dana/domain/profilemenu/model/SettingModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileSettingsActivity extends BaseActivityWithPageLoadTracker implements ProfileSettingsContract.View {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int FragmentBottomSheetPaymentSettingBinding;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda7;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda8;
    private static int PrepareContext;
    private static boolean isLayoutRequested;
    public static final byte[] lookAheadTest;
    private static boolean newProxyInstance;
    public static final int scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private SettingModel lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final HandPicked getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private String PlaceComponentResult;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public MePageRevampContract.Presenter mePageRevampPresenter;
    @Inject
    public ProfileSettingsContract.Presenter profileSettingsPresenter;
    public static final byte[] $$g = {113, 46, 115, -60, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$h = 202;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda3 = 0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final ProfileSettingsAdapter moveToNextValue = new ProfileSettingsAdapter(new OnRedirectListener() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity$profileSettingsAdapter$1
        @Override // id.dana.nearbyme.OnRedirectListener
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
            OnRedirectListener.CC.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // id.dana.nearbyme.OnRedirectListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(TimerEventKey p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ProfileSettingsActivity.this.startTimer(p0);
        }
    });

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final ActivityPermissionRequest scheduleImpl = scheduleImpl();

    static {
        FragmentBottomSheetPaymentSettingBinding = 1;
        PlaceComponentResult();
        lookAheadTest = new byte[]{97, -108, 86, -98, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
        scheduleImpl = 149;
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 71;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
    }

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda8 = -1094665891134158366L;
    }

    static void getAuthRequestContext() {
        int i = FragmentBottomSheetPaymentSettingBinding + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = new char[]{39429, 39542, 39424, 39538, 39543, 39549, 39478, 39539, 39444, 39427, 39425, 39545, 39533, 39441, 39540, 39461, 39536, 39534, 39440, 39548, 39537, 39544, 39471, 39470, 39468, 39476, 39469, 39550, 39474, 39477, 39475, 39472, 39426, 39473, 39466, 39479, 39551, 39541};
        isLayoutRequested = true;
        newProxyInstance = true;
        PrepareContext = 909155300;
        int i3 = FragmentBottomSheetPaymentSettingBinding + 41;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if ((i3 % 2 != 0 ? Typography.quote : Typography.greater) != '>') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0070 -> B:27:0x0052). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r8, byte r9, short r10, java.lang.Object[] r11) {
        /*
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding     // Catch: java.lang.Exception -> L76
            int r0 = r0 + 5
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1     // Catch: java.lang.Exception -> L76
            int r0 = r0 % 2
            r1 = 49
            if (r0 == 0) goto L11
            r0 = 49
            goto L13
        L11:
            r0 = 56
        L13:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L31
            byte[] r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.lookAheadTest
            int r8 = r8 + 4
            int r9 = r9 + 16
            int r10 = 106 - r10
            byte[] r1 = new byte[r9]
            r4 = 75
            if (r0 != 0) goto L28
            r5 = 17
            goto L2a
        L28:
            r5 = 75
        L2a:
            if (r5 == r4) goto L2e
            r4 = 0
            goto L4c
        L2e:
            r4 = r1
            r5 = 0
            goto L46
        L31:
            byte[] r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.lookAheadTest
            int r8 = r8 + 63
            int r9 = r9 + 8
            r1 = 121(0x79, float:1.7E-43)
            int r10 = r1 / r10
            byte[] r1 = new byte[r9]
            if (r0 != 0) goto L41
            r4 = 0
            goto L42
        L41:
            r4 = 1
        L42:
            if (r4 == 0) goto L4b
            r4 = r1
            r5 = 1
        L46:
            r1 = r0
            r0 = r11
            r11 = r10
            r10 = r9
            goto L56
        L4b:
            r4 = 1
        L4c:
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r11
            r11 = r10
            r10 = r9
        L52:
            int r11 = r11 + r9
            int r9 = r11 + (-4)
            r11 = r9
        L56:
            int r9 = r5 + 1
            int r8 = r8 + r3
            byte r6 = (byte) r11
            r4[r5] = r6
            if (r9 != r10) goto L70
            java.lang.String r8 = new java.lang.String
            r8.<init>(r4, r2)
            int r9 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding
            int r9 = r9 + 93
            int r10 = r9 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r10
            int r9 = r9 % 2
            r0[r2] = r8
            return
        L70:
            r5 = r1[r8]
            r7 = r5
            r5 = r9
            r9 = r7
            goto L52
        L76:
            r8 = move-exception
            goto L79
        L78:
            throw r8
        L79:
            goto L78
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.h(short, byte, short, java.lang.Object[]):void");
    }

    private static void j(short s, byte b, int i, Object[] objArr) {
        int i2 = (i * 3) + 21;
        byte[] bArr = $$g;
        int i3 = 46 - b;
        int i4 = 103 - (s * 2);
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i4 = (i3 + i4) - 7;
            i3 = i3;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            int i8 = i3 + 1;
            bArr2[i7] = (byte) i4;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i4 = (i4 + bArr[i8]) - 7;
            i3 = i8;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
    public final void _$_clearFindViewByIdCache() {
        int i = FragmentBottomSheetPaymentSettingBinding + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        this._$_findViewCache.clear();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 109;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        if (i3 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if ((view == null ? 'V' : (char) 15) == 'V') {
            try {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 109;
                FragmentBottomSheetPaymentSettingBinding = i2 % 128;
                int i3 = i2 % 2;
                view = findViewById(i);
                if (!(view == null)) {
                    map.put(Integer.valueOf(i), view);
                } else {
                    view = null;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 25;
        FragmentBottomSheetPaymentSettingBinding = i4 % 128;
        int i5 = i4 % 2;
        return view;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x006c, code lost:
    
        if ((r2 > 99999 ? 25 : 30) != 25) goto L45;
     */
    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r25) {
        /*
            Method dump skipped, instructions count: 2927
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 27;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 39;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        Context applicationContext;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 17;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        if (i % 2 == 0) {
            applicationContext = super.getApplicationContext();
            int i2 = 2 / 0;
        } else {
            applicationContext = super.getApplicationContext();
        }
        try {
            int i3 = FragmentBottomSheetPaymentSettingBinding + 49;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
                int i4 = i3 % 2;
                return applicationContext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        int i = FragmentBottomSheetPaymentSettingBinding + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        Context baseContext = super.getBaseContext();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 57;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        int i4 = i3 % 2;
        return baseContext;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        String authRequestContext;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 125;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        if (!(i % 2 != 0)) {
            authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            Object obj = null;
            obj.hashCode();
        } else {
            authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
        }
        try {
            int i2 = FragmentBottomSheetPaymentSettingBinding + 63;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
                if ((i2 % 2 != 0 ? (char) 15 : '!') != '!') {
                    int i3 = 48 / 0;
                    return authRequestContext;
                }
                return authRequestContext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        int i = FragmentBottomSheetPaymentSettingBinding + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if (i % 2 != 0) {
            Object obj = null;
            obj.hashCode();
            return R.layout.activity_profile_settings;
        }
        return R.layout.activity_profile_settings;
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = FragmentBottomSheetPaymentSettingBinding + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        Resources resources = super.getResources();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 99;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        int i4 = i3 % 2;
        return resources;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 99;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        try {
            AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 113;
            FragmentBottomSheetPaymentSettingBinding = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 88 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void onGetUserInfoFailed() {
        int i = FragmentBottomSheetPaymentSettingBinding + 71;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if ((i % 2 != 0 ? 'M' : (char) 5) != 5) {
            int i2 = 84 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
    
        if ((r1 == null ? 1 : 20) != 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        r1 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 + 49;
        id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        r8 = new java.lang.Object[1];
        h(id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.lookAheadTest[9], (byte) (-id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.lookAheadTest[30]), id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.lookAheadTest[32], r8);
        r1 = java.lang.Class.forName((java.lang.String) r8[0]);
        r9 = new java.lang.Object[1];
        h(id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.lookAheadTest[59], id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.lookAheadTest[56], id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.lookAheadTest[13], r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0081, code lost:
    
        r7 = new java.lang.Object[1];
        k(null, ((android.content.pm.ApplicationInfo) r1.getMethod((java.lang.String) r9[0], null).invoke(r12, null)).targetSdkVersion + 94, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, r7);
        r1 = java.lang.Class.forName((java.lang.String) r7[0]);
        r8 = new java.lang.Object[1];
        k(null, super.getResources().getString(id.dana.R.string.kyc_renewal_dialog_title).substring(1, 2).length() + 126, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, r8);
        r1 = (android.content.Context) r1.getMethod((java.lang.String) r8[0], new java.lang.Class[0]).invoke(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0187, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0188, code lost:
    
        r1 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x018c, code lost:
    
        if (r1 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x018e, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x018f, code lost:
    
        throw r0;
     */
    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onPause() {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.onPause():void");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 117;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        try {
            AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            int i3 = FragmentBottomSheetPaymentSettingBinding + 71;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            if ((i3 % 2 != 0 ? 'T' : 'b') != 'T') {
                return;
            }
            int i4 = 46 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public ProfileSettingsActivity() {
        HandPicked.Builder builder = new HandPicked.Builder(this);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = GriverEnv.getApplicationContext().getString(R.string.pick_profile_photo_title);
        builder.PlaceComponentResult = new HandPickedResultHandler() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity$handPicked$1
            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void MyBillsEntityDataFactory(Uri p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                ProfileSettingsActivity.this.getProfileSettingsPresenter().getAuthRequestContext(FileUtil.MyBillsEntityDataFactory(ProfileSettingsActivity.this.getApplicationContext(), p0.toString()));
            }

            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Exception p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.MyBillsEntityDataFactory("uploadAvatar", p0);
            }
        };
        Application applicationContext = GriverEnv.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        builder.getAuthRequestContext = PermissionHelper.MyBillsEntityDataFactory(applicationContext, "android.permission.CAMERA");
        Application applicationContext2 = GriverEnv.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = PermissionHelper.getAuthRequestContext(applicationContext2);
        this.getAuthRequestContext = new HandPicked(builder, (byte) 0);
    }

    public static final /* synthetic */ SettingModel access$findSetting(ProfileSettingsActivity profileSettingsActivity, String str) {
        try {
            int i = FragmentBottomSheetPaymentSettingBinding + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            SettingModel PlaceComponentResult = profileSettingsActivity.PlaceComponentResult(str);
            int i3 = FragmentBottomSheetPaymentSettingBinding + 45;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
            return PlaceComponentResult;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ HandPicked access$getHandPicked$p(ProfileSettingsActivity profileSettingsActivity) {
        int i = FragmentBottomSheetPaymentSettingBinding + 117;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        HandPicked handPicked = profileSettingsActivity.getAuthRequestContext;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 13;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        int i4 = i3 % 2;
        return handPicked;
    }

    public static final /* synthetic */ boolean access$getKycCertified$p(ProfileSettingsActivity profileSettingsActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 23;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        boolean z = i % 2 != 0;
        boolean z2 = profileSettingsActivity.BuiltInFictitiousFunctionClassFactory;
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return z2;
    }

    public static final /* synthetic */ String access$getKycLevel$p(ProfileSettingsActivity profileSettingsActivity) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 1;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        String str = profileSettingsActivity.PlaceComponentResult;
        try {
            int i3 = FragmentBottomSheetPaymentSettingBinding + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ ProfileSettingsAdapter access$getProfileSettingsAdapter$p(ProfileSettingsActivity profileSettingsActivity) {
        int i = FragmentBottomSheetPaymentSettingBinding + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        try {
            ProfileSettingsAdapter profileSettingsAdapter = profileSettingsActivity.moveToNextValue;
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 109;
                FragmentBottomSheetPaymentSettingBinding = i3 % 128;
                if ((i3 % 2 == 0 ? 'G' : ']') != 'G') {
                    return profileSettingsAdapter;
                }
                int i4 = 24 / 0;
                return profileSettingsAdapter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$profileAdapterOnItemClickListener(ProfileSettingsActivity profileSettingsActivity, SettingModel settingModel) {
        try {
            int i = FragmentBottomSheetPaymentSettingBinding + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            if (i % 2 != 0) {
                profileSettingsActivity.PlaceComponentResult(settingModel);
                int i2 = 50 / 0;
            } else {
                profileSettingsActivity.PlaceComponentResult(settingModel);
            }
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 63;
                FragmentBottomSheetPaymentSettingBinding = i3 % 128;
                if (i3 % 2 != 0) {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void access$setFromFeeds(ProfileSettingsActivity profileSettingsActivity) {
        int i = FragmentBottomSheetPaymentSettingBinding + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        profileSettingsActivity.GetContactSyncConfig();
        int i3 = FragmentBottomSheetPaymentSettingBinding + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if ((i3 % 2 == 0 ? 'H' : '\t') != 'H') {
            Object obj = null;
            obj.hashCode();
        }
    }

    @JvmName(name = "getMePageRevampPresenter")
    public final MePageRevampContract.Presenter getMePageRevampPresenter() {
        try {
            MePageRevampContract.Presenter presenter = this.mePageRevampPresenter;
            Object[] objArr = null;
            if ((presenter != null ? ';' : (char) 4) == ';') {
                int i = FragmentBottomSheetPaymentSettingBinding + 105;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                if ((i % 2 != 0 ? 'V' : 'D') != 'D') {
                    objArr.hashCode();
                    return presenter;
                }
                return presenter;
            }
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i2 = FragmentBottomSheetPaymentSettingBinding + 101;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i2 % 128;
                if (i2 % 2 != 0) {
                    int length = objArr.length;
                    return null;
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setMePageRevampPresenter")
    public final void setMePageRevampPresenter(MePageRevampContract.Presenter presenter) {
        int i = FragmentBottomSheetPaymentSettingBinding + 5;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.mePageRevampPresenter = presenter;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 75;
            FragmentBottomSheetPaymentSettingBinding = i3 % 128;
            if ((i3 % 2 == 0 ? '_' : '#') != '#') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getProfileSettingsPresenter")
    public final ProfileSettingsContract.Presenter getProfileSettingsPresenter() {
        int i = FragmentBottomSheetPaymentSettingBinding + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        ProfileSettingsContract.Presenter presenter = this.profileSettingsPresenter;
        if (presenter == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = FragmentBottomSheetPaymentSettingBinding + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        int i4 = i3 % 2;
        return presenter;
    }

    @JvmName(name = "setProfileSettingsPresenter")
    public final void setProfileSettingsPresenter(ProfileSettingsContract.Presenter presenter) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 119;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(presenter, "");
        this.profileSettingsPresenter = presenter;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 25;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if ((r0 != null) != true) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0029, code lost:
    
        if (r0 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        r1 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 + 95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        if ((r1 % 2) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
    
        if (r3 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003a, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r1 = 60 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x003e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0042, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0047, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getFriendshipAnalyticTracker")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.feeds.ui.tracker.FriendshipAnalyticTracker getFriendshipAnalyticTracker() {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding
            int r0 = r0 + 63
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1
            int r0 = r0 % 2
            r1 = 98
            if (r0 == 0) goto L11
            r0 = 98
            goto L13
        L11:
            r0 = 42
        L13:
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L24
            id.dana.feeds.ui.tracker.FriendshipAnalyticTracker r0 = r5.friendshipAnalyticTracker     // Catch: java.lang.Exception -> L22
            if (r0 == 0) goto L1e
            r1 = 1
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 == r3) goto L2b
            goto L42
        L22:
            r0 = move-exception
            goto L41
        L24:
            id.dana.feeds.ui.tracker.FriendshipAnalyticTracker r0 = r5.friendshipAnalyticTracker
            r2.hashCode()     // Catch: java.lang.Throwable -> L48
            if (r0 == 0) goto L42
        L2b:
            int r1 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3     // Catch: java.lang.Exception -> L22
            int r1 = r1 + 95
            int r2 = r1 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r2     // Catch: java.lang.Exception -> L22
            int r1 = r1 % 2
            if (r1 != 0) goto L38
            r3 = 0
        L38:
            if (r3 == 0) goto L3b
            return r0
        L3b:
            r1 = 60
            int r1 = r1 / r4
            return r0
        L3f:
            r0 = move-exception
            throw r0
        L41:
            throw r0
        L42:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r2
        L48:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.getFriendshipAnalyticTracker():id.dana.feeds.ui.tracker.FriendshipAnalyticTracker");
    }

    @JvmName(name = "setFriendshipAnalyticTracker")
    public final void setFriendshipAnalyticTracker(FriendshipAnalyticTracker friendshipAnalyticTracker) {
        try {
            int i = FragmentBottomSheetPaymentSettingBinding + 107;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(friendshipAnalyticTracker, "");
            this.friendshipAnalyticTracker = friendshipAnalyticTracker;
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 97;
            FragmentBottomSheetPaymentSettingBinding = i3 % 128;
            if ((i3 % 2 == 0 ? '5' : '2') != '5') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 29;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        getErrorConfigVersion();
        moveToNextValue();
        int i3 = FragmentBottomSheetPaymentSettingBinding + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x008d, code lost:
    
        if ((r0 <= 99999) != false) goto L65;
     */
    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r26) {
        /*
            Method dump skipped, instructions count: 1435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0224, code lost:
    
        r2 = r6.getCollection();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "");
        r0.MyBillsEntityDataFactory(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01f2, code lost:
    
        if ((r19.KClassImpl$Data$declaredNonStaticMembers$2) != true) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01fa, code lost:
    
        if (r19.KClassImpl$Data$declaredNonStaticMembers$2 != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01fc, code lost:
    
        r0 = getMePageRevampPresenter();
        r2 = r19.lookAheadTest;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0202, code lost:
    
        if (r2 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0204, code lost:
    
        r2 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding + 87;
        id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x020d, code lost:
    
        if ((r2 % 2) == 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x020f, code lost:
    
        r2 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0212, code lost:
    
        r2 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0213, code lost:
    
        if (r2 == 3) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0215, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x021a, code lost:
    
        r2 = 88 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x021f, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0223, code lost:
    
        r6 = r2;
     */
    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onResume() {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.onResume():void");
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void showAvatar(String imageUrl) {
        SettingModel PlaceComponentResult = PlaceComponentResult(MyProfileMenuAction.SETTING_CHANGE_PROFILE_PICTURE);
        if (PlaceComponentResult != null) {
            try {
                PlaceComponentResult.setAvatarUrl(imageUrl);
                ProfileSettingsAdapter profileSettingsAdapter = this.moveToNextValue;
                String parent = PlaceComponentResult.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "");
                Intrinsics.checkNotNullParameter(parent, "");
                int MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent);
                if (MyBillsEntityDataFactory != -1) {
                    int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 1;
                    FragmentBottomSheetPaymentSettingBinding = i % 128;
                    char c = i % 2 == 0 ? (char) 31 : Typography.greater;
                    profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
                    if (c == 31) {
                        int i2 = 52 / 0;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 85;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
    
        if (r6.BuiltInFictitiousFunctionClassFactory == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (r6.BuiltInFictitiousFunctionClassFactory == false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showNickname(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding
            int r0 = r0 + 117
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1
            r1 = 2
            int r0 = r0 % r1
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r2 = "setting_change_name"
            id.dana.domain.profilemenu.model.SettingModel r2 = r6.PlaceComponentResult(r2)
            r3 = 69
            if (r2 == 0) goto L1c
            r4 = 69
            goto L1d
        L1c:
            r4 = 6
        L1d:
            if (r4 == r3) goto L21
            goto La0
        L21:
            java.lang.String r3 = r6.PlaceComponentResult
            r4 = 82
            if (r3 == 0) goto L2a
            r5 = 82
            goto L2c
        L2a:
            r5 = 85
        L2c:
            if (r5 == r4) goto L2f
            goto L6f
        L2f:
            int r4 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r4 = r4 + 25
            int r5 = r4 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r5
            int r4 = r4 % r1
            java.lang.String r4 = "KYC2"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r3)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L44
            r3 = 1
            goto L45
        L44:
            r3 = 0
        L45:
            if (r3 == r4) goto L48
            goto L61
        L48:
            int r3 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r3 = r3 + 71
            int r4 = r3 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r4
            int r3 = r3 % r1
            if (r3 != 0) goto L5d
            boolean r3 = r6.BuiltInFictitiousFunctionClassFactory
            r4 = 27
            int r4 = r4 / r5
            if (r3 != 0) goto L6f
            goto L61
        L5b:
            r7 = move-exception
            throw r7
        L5d:
            boolean r3 = r6.BuiltInFictitiousFunctionClassFactory
            if (r3 != 0) goto L6f
        L61:
            r3 = 2131952792(0x7f130498, float:1.9542037E38)
            java.lang.String r3 = r6.getString(r3)
            r2.setTitle(r3)
            r2.setViewType(r1)
            goto L7d
        L6f:
            r1 = 2131952791(0x7f130497, float:1.9542035E38)
            java.lang.String r1 = r6.getString(r1)
            r2.setTitle(r1)
            r1 = 4
            r2.setViewType(r1)
        L7d:
            r2.setSubtitle(r7)
            id.dana.myprofile.mepagerevamp.profilesettings.adapter.ProfileSettingsAdapter r7 = r6.moveToNextValue
            java.lang.String r1 = r2.getParent()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r0 = r7.MyBillsEntityDataFactory(r1)
            r1 = -1
            r2 = 30
            if (r0 == r1) goto L98
            r1 = 30
            goto L9a
        L98:
            r1 = 99
        L9a:
            if (r1 == r2) goto L9d
            goto La0
        L9d:
            r7.notifyItemChanged(r0)
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.showNickname(java.lang.String):void");
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void showPhoneNumber(String phoneNumber) {
        SettingModel PlaceComponentResult;
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        if (phoneNumber.length() < 3) {
            return;
        }
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 113;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        if ((i % 2 == 0 ? (char) 16 : 'V') != 16) {
            PlaceComponentResult = PlaceComponentResult(MyProfileMenuAction.SETTING_CHANGE_MOBILE_NUMBER);
            if (PlaceComponentResult == null) {
                return;
            }
        } else {
            PlaceComponentResult = PlaceComponentResult(MyProfileMenuAction.SETTING_CHANGE_MOBILE_NUMBER);
            int i2 = 97 / 0;
            if (PlaceComponentResult == null) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        String substring = phoneNumber.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        sb.append(substring);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(getString(R.string.hide_value_with_space));
        sb.append(InputCardNumberView.DIVIDER);
        String substring2 = phoneNumber.substring(phoneNumber.length() - 4);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        sb.append(substring2);
        PlaceComponentResult.setSubtitle(sb.toString());
        ProfileSettingsAdapter profileSettingsAdapter = this.moveToNextValue;
        String parent = PlaceComponentResult.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "");
        Intrinsics.checkNotNullParameter(parent, "");
        int MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent);
        if (MyBillsEntityDataFactory != -1) {
            profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
            int i3 = FragmentBottomSheetPaymentSettingBinding + 11;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void showEmailAddress(String emailAddress) {
        int i = FragmentBottomSheetPaymentSettingBinding + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(emailAddress, "");
        if (!(emailAddress.length() >= 3)) {
            return;
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 67;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        if ((i3 % 2 == 0 ? ')' : Typography.dollar) != ')') {
            try {
                if (!StringsKt.contains$default((CharSequence) emailAddress, (CharSequence) AUScreenAdaptTool.PREFIX_ID, false, 2, (Object) null)) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            if ((StringsKt.contains$default((CharSequence) emailAddress, (CharSequence) AUScreenAdaptTool.PREFIX_ID, false, 3, (Object) null) ? 'L' : '[') != 'L') {
                return;
            }
        }
        SettingModel PlaceComponentResult = PlaceComponentResult(MyProfileMenuAction.SETTING_CHANGE_EMAIL);
        if (PlaceComponentResult != null) {
            int i4 = FragmentBottomSheetPaymentSettingBinding + 87;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i4 % 128;
            int i5 = i4 % 2;
            PlaceComponentResult.setSubtitle(TextUtil.PlaceComponentResult(this, emailAddress));
            ProfileSettingsAdapter profileSettingsAdapter = this.moveToNextValue;
            String parent = PlaceComponentResult.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "");
            Intrinsics.checkNotNullParameter(parent, "");
            int MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent);
            if (MyBillsEntityDataFactory != -1) {
                try {
                    profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void showEmailAddressUnset() {
        SettingModel PlaceComponentResult = PlaceComponentResult(MyProfileMenuAction.SETTING_CHANGE_EMAIL);
        if ((PlaceComponentResult != null ? ')' : '\b') != ')') {
            return;
        }
        int i = FragmentBottomSheetPaymentSettingBinding + 9;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        PlaceComponentResult.setSubtitle(getString(R.string.security_setting_email_unset));
        ProfileSettingsAdapter profileSettingsAdapter = this.moveToNextValue;
        String parent = PlaceComponentResult.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "");
        Intrinsics.checkNotNullParameter(parent, "");
        int MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent);
        if ((MyBillsEntityDataFactory != -1 ? '6' : '7') != '7') {
            profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
            int i3 = FragmentBottomSheetPaymentSettingBinding + 15;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void toggleShareFeedConsentSuccess(SettingModel settingModel) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 3;
            FragmentBottomSheetPaymentSettingBinding = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(settingModel, "");
            getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(settingModel.isShareFeed());
            int i3 = FragmentBottomSheetPaymentSettingBinding + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void toggleShareFeedConsentFailed(SettingModel settingModel) {
        SettingModel PlaceComponentResult;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 33;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(settingModel, "");
            getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(settingModel.isShareFeed());
            PlaceComponentResult = PlaceComponentResult(MyProfileMenuAction.SHARE_FEED);
            int i2 = 9 / 0;
            if (PlaceComponentResult == null) {
                return;
            }
        } else {
            try {
                Intrinsics.checkNotNullParameter(settingModel, "");
                try {
                    getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(settingModel.isShareFeed());
                    PlaceComponentResult = PlaceComponentResult(MyProfileMenuAction.SHARE_FEED);
                    if (!(PlaceComponentResult != null)) {
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        PlaceComponentResult.setShareFeed(settingModel.isShareFeed());
        ProfileSettingsAdapter profileSettingsAdapter = this.moveToNextValue;
        String parent = PlaceComponentResult.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "");
        Intrinsics.checkNotNullParameter(parent, "");
        int MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent);
        if (!(MyBillsEntityDataFactory != -1)) {
            return;
        }
        profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 15;
        FragmentBottomSheetPaymentSettingBinding = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void onUserKycInfo(String kycLevel, boolean kycCertified) {
        int i = FragmentBottomSheetPaymentSettingBinding + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? '*' : (char) 25) != 25) {
            this.BuiltInFictitiousFunctionClassFactory = kycCertified;
            String string = getString(BuiltInFictitiousFunctionClassFactory(kycLevel));
            Intrinsics.checkNotNullExpressionValue(string, "");
            KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.SETTING_ACCOUNT_TYPE, string);
            int length = objArr.length;
        } else {
            this.BuiltInFictitiousFunctionClassFactory = kycCertified;
            String string2 = getString(BuiltInFictitiousFunctionClassFactory(kycLevel));
            Intrinsics.checkNotNullExpressionValue(string2, "");
            KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.SETTING_ACCOUNT_TYPE, string2);
        }
        try {
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 47;
            FragmentBottomSheetPaymentSettingBinding = i2 % 128;
            if (i2 % 2 == 0) {
                objArr.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsContract.View
    public final void showErrorToast() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 105;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        if (i % 2 != 0) {
            showToast(getString(R.string.SchedulerPoolFactory));
            return;
        }
        showToast(getString(R.string.SchedulerPoolFactory));
        int i2 = 35 / 0;
    }

    private final void getErrorConfigVersion() {
        try {
            DaggerProfileSettingsComponent.Builder MyBillsEntityDataFactory = DaggerProfileSettingsComponent.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (MePageRevampModule) Preconditions.getAuthRequestContext(NetworkUserEntityData$$ExternalSyntheticLambda0());
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ProfileSettingsModule) Preconditions.getAuthRequestContext(new ProfileSettingsModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ProfileSettingsModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MePageRevampModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, ApplicationComponent.class);
            new DaggerProfileSettingsComponent.ProfileSettingsComponentImpl(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
            registerPresenter(getMePageRevampPresenter(), getProfileSettingsPresenter());
            int i = FragmentBottomSheetPaymentSettingBinding + 77;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final MePageRevampModule NetworkUserEntityData$$ExternalSyntheticLambda0() {
        MePageRevampModule mePageRevampModule = new MePageRevampModule(new MePageRevampContract.View() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity$getMePageRevampModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.myprofile.mepagerevamp.MePageRevampContract.View
            public final void getAuthRequestContext(List<? extends SettingModel> p0) {
                if (p0 != null) {
                    p0 = SettingModelMapper.PlaceComponentResult(p0, true);
                }
                ProfileSettingsActivity.access$getProfileSettingsAdapter$p(ProfileSettingsActivity.this).setItems(p0);
                ProfileSettingsActivity.this.getProfileSettingsPresenter().MyBillsEntityDataFactory();
                ProfileSettingsActivity profileSettingsActivity = ProfileSettingsActivity.this;
                profileSettingsActivity.onUserKycInfo(ProfileSettingsActivity.access$getKycLevel$p(profileSettingsActivity), ProfileSettingsActivity.access$getKycCertified$p(ProfileSettingsActivity.this));
                ProfileSettingsActivity.access$setFromFeeds(ProfileSettingsActivity.this);
                ProfileSettingsActivity.this.getProfileSettingsPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                ProfileSettingsActivity.this.getProfileSettingsPresenter().getAuthRequestContext();
            }

            @Override // id.dana.myprofile.mepagerevamp.MePageRevampContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                SettingModel access$findSetting = ProfileSettingsActivity.access$findSetting(ProfileSettingsActivity.this, MyProfileMenuAction.SETTING_CHANGE_PROFILE_PICTURE);
                if (access$findSetting != null) {
                    access$findSetting.setAvatarUrl(p0);
                    ProfileSettingsAdapter access$getProfileSettingsAdapter$p = ProfileSettingsActivity.access$getProfileSettingsAdapter$p(ProfileSettingsActivity.this);
                    String parent = access$findSetting.getParent();
                    Intrinsics.checkNotNullExpressionValue(parent, "");
                    Intrinsics.checkNotNullParameter(parent, "");
                    int MyBillsEntityDataFactory = access$getProfileSettingsAdapter$p.MyBillsEntityDataFactory(parent);
                    if (MyBillsEntityDataFactory != -1) {
                        access$getProfileSettingsAdapter$p.notifyItemChanged(MyBillsEntityDataFactory);
                    }
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                ProfileSettingsActivity profileSettingsActivity = ProfileSettingsActivity.this;
                Toast.makeText(profileSettingsActivity, ErrorUtil.BuiltInFictitiousFunctionClassFactory(profileSettingsActivity), 0).show();
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 23;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        return mePageRevampModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        if (r2 != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if ((r2.length() == 0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory() {
        /*
            r7 = this;
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r0 = r0 + 35
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r1
            int r0 = r0 % 2
            android.content.Intent r0 = r7.getIntent()
            java.lang.String r1 = "settingModel"
            android.os.Parcelable r0 = r0.getParcelableExtra(r1)
            id.dana.domain.profilemenu.model.SettingModel r0 = (id.dana.domain.profilemenu.model.SettingModel) r0
            r1 = 0
            if (r0 == 0) goto L71
            int r2 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding
            int r2 = r2 + 13
            int r3 = r2 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r3
            int r2 = r2 % 2
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.String r2 = r0.getCollection()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L56
            int r5 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding
            int r5 = r5 + 71
            int r6 = r5 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L48
            int r2 = r2.length()
            int r5 = r1.length     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L56
            goto L54
        L46:
            r0 = move-exception
            throw r0
        L48:
            int r2 = r2.length()
            if (r2 == 0) goto L50
            r2 = 0
            goto L51
        L50:
            r2 = 1
        L51:
            if (r2 == 0) goto L54
            goto L56
        L54:
            r2 = 0
            goto L57
        L56:
            r2 = 1
        L57:
            if (r2 == 0) goto L5a
            goto L5b
        L5a:
            r3 = 1
        L5b:
            if (r3 == r4) goto L62
            java.lang.String r2 = "setting_collection_settings"
            r0.setCollection(r2)
        L62:
            r7.lookAheadTest = r0
            java.lang.String r0 = r0.getTitle()
            r7.setTitle(r0)
            r0 = 2131232241(0x7f0805f1, float:1.8080586E38)
            r7.setMenuLeftButton(r0)
        L71:
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r0 = r0 + 101
            int r2 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L81
            int r0 = r1.length     // Catch: java.lang.Throwable -> L7f
            return
        L7f:
            r0 = move-exception
            throw r0
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.BuiltInFictitiousFunctionClassFactory():void");
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
    public final void onTimerEnd(TimerEvent timerEvent, long millisecond) {
        int i = FragmentBottomSheetPaymentSettingBinding + 95;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        if ((i % 2 != 0 ? Typography.less : 'M') != '<') {
            Intrinsics.checkNotNullParameter(timerEvent, "");
            track(this, timerEvent, millisecond);
            finish();
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(timerEvent, "");
            try {
                track(this, timerEvent, millisecond);
                finish();
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void moveToNextValue() {
        this.moveToNextValue.setOnItemClickListener(new GroupedSettingItemClickListener() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity$initSettingsAdapter$1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int p0) {
                SettingModel item = ProfileSettingsActivity.access$getProfileSettingsAdapter$p(ProfileSettingsActivity.this).getItem(p0);
                if (item != null) {
                    ProfileSettingsActivity.access$profileAdapterOnItemClickListener(ProfileSettingsActivity.this, item);
                }
            }

            @Override // id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener
            public final void getAuthRequestContext(SettingModel p0) {
                if (p0 != null) {
                    ProfileSettingsActivity.access$profileAdapterOnItemClickListener(ProfileSettingsActivity.this, p0);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_profile_settings);
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(this.moveToNextValue);
            recyclerView.setNestedScrollingEnabled(false);
            ProfileDividerItemDecoration profileDividerItemDecoration = new ProfileDividerItemDecoration(recyclerView.getContext());
            Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(recyclerView.getContext(), (int) R.drawable.divider_drawable);
            if (PlaceComponentResult == null) {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 49;
                FragmentBottomSheetPaymentSettingBinding = i % 128;
                int i2 = i % 2;
                return;
            }
            if ((PlaceComponentResult != null ? 'W' : '2') != 'W') {
                throw new IllegalArgumentException("Drawable cannot be null.");
            }
            int i3 = FragmentBottomSheetPaymentSettingBinding + 11;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
            profileDividerItemDecoration.MyBillsEntityDataFactory = PlaceComponentResult;
            recyclerView.addItemDecoration(profileDividerItemDecoration);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
    
        if (r0.equals(id.dana.data.profilemenu.MyProfileMenuAction.SHARE_FEED) == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(id.dana.domain.profilemenu.model.SettingModel r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.getAction()
            r1 = 41
            if (r0 == 0) goto Lb
            r2 = 32
            goto Ld
        Lb:
            r2 = 41
        Ld:
            r3 = 0
            r4 = 1
            if (r2 == r1) goto L80
            int r1 = r0.hashCode()
            switch(r1) {
                case 315215690: goto L58;
                case 487954253: goto L4f;
                case 948354699: goto L2e;
                case 1350426073: goto L19;
                default: goto L18;
            }
        L18:
            goto L80
        L19:
            java.lang.String r1 = "change_profile_picture"
            boolean r0 = r0.equals(r1)
            r1 = 39
            if (r0 == 0) goto L26
            r0 = 60
            goto L28
        L26:
            r0 = 39
        L28:
            if (r0 == r1) goto L80
            r6.DatabaseTableConfigUtil()
            return
        L2e:
            java.lang.String r1 = "setting_restricted_contact"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L80
            int r7 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r7 = r7 + 45
            int r0 = r7 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L4b
            r6.initRecordTimeStamp()
            r7 = 17
            int r7 = r7 / r3
            return
        L49:
            r7 = move-exception
            throw r7
        L4b:
            r6.initRecordTimeStamp()
            return
        L4f:
            java.lang.String r1 = "setting_share_feed"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L8a
            goto L80
        L58:
            java.lang.String r1 = r6.getPackageName()
            int r1 = r1.codePointAt(r4)
            int r1 = r1 + (-100)
            r2 = 27
            char[] r2 = new char[r2]
            r2 = {x00b2: FILL_ARRAY_DATA , data: [-19479, -19558, -8457, -9576, 11404, -9269, 9452, -10335, -23640, -13653, 13527, -14382, -27700, -1314, 1165, -2089, -31745, -5612, 5229, -6344, -3306, -26050, 25680, -26860, -7345, -30142, 29749} // fill-array
            java.lang.Object[] r5 = new java.lang.Object[r4]
            g(r1, r2, r5)
            r1 = r5[r3]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r1.intern()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L80
            r6.NetworkUserEntityData$$ExternalSyntheticLambda2()
            return
        L80:
            java.lang.String r7 = r7.getRedirectUrl()
            if (r7 != 0) goto L87
            return
        L87:
            r6.KClassImpl$Data$declaredNonStaticMembers$2(r7)
        L8a:
            int r7 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding
            int r7 = r7 + 37
            int r0 = r7 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r0
            int r7 = r7 % 2
            if (r7 == 0) goto L97
            goto L98
        L97:
            r3 = 1
        L98:
            if (r3 == 0) goto L9b
            return
        L9b:
            r7 = 0
            int r7 = r7.length     // Catch: java.lang.Throwable -> L9e
            return
        L9e:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.PlaceComponentResult(id.dana.domain.profilemenu.model.SettingModel):void");
    }

    private final void DatabaseTableConfigUtil() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 31;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        this.scheduleImpl.check();
        int i3 = FragmentBottomSheetPaymentSettingBinding + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        try {
            startActivity(new Intent(this, ChangeUsernameActivity.class));
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 19;
            FragmentBottomSheetPaymentSettingBinding = i % 128;
            if (i % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void initRecordTimeStamp() {
        try {
            startActivity(new Intent(this, RestrictedContactActivity.class));
            try {
                int i = FragmentBottomSheetPaymentSettingBinding + 29;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
                if ((i % 2 != 0 ? 'X' : '4') != 'X') {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        String authRequestContext = UrlUtil.getAuthRequestContext(p0);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity$openH5Container$$inlined$withDanaH5Callback$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p02) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p02) {
                ProfileSettingsActivity.this.getProfileSettingsPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 9;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SettingModel PlaceComponentResult(String p0) {
        Iterator<SettingModel> it;
        SettingModel settingModel;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 23;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        if (i % 2 != 0) {
            it = this.moveToNextValue.getItems().iterator();
        } else {
            it = this.moveToNextValue.getItems().iterator();
            int i2 = 55 / 0;
        }
        do {
            settingModel = null;
            if ((it.hasNext() ? (char) 28 : ')') != 28) {
                break;
            }
            List<SettingModel> settingChilds = it.next().getSettingChilds();
            Intrinsics.checkNotNullExpressionValue(settingChilds, "");
            Iterator<T> it2 = settingChilds.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 87;
                FragmentBottomSheetPaymentSettingBinding = i3 % 128;
                int i4 = i3 % 2;
                Object next = it2.next();
                if (Intrinsics.areEqual(((SettingModel) next).getName(), p0)) {
                    settingModel = next;
                    break;
                }
            }
            settingModel = settingModel;
        } while (!(settingModel != null));
        int i5 = FragmentBottomSheetPaymentSettingBinding + 81;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i5 % 128;
        int i6 = i5 % 2;
        return settingModel;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 85;
            FragmentBottomSheetPaymentSettingBinding = i % 128;
            int i2 = i % 2;
            Object[] objArr = null;
            SettingModel PlaceComponentResult = PlaceComponentResult(p0);
            if (i2 == 0) {
                int length = objArr.length;
                if (PlaceComponentResult == null) {
                    return;
                }
            } else {
                if ((PlaceComponentResult != null ? 'F' : '#') != 'F') {
                    return;
                }
            }
            PlaceComponentResult.setSubtitle(p1);
            ProfileSettingsAdapter profileSettingsAdapter = this.moveToNextValue;
            String parent = PlaceComponentResult.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "");
            Intrinsics.checkNotNullParameter(parent, "");
            int MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent);
            if (!(MyBillsEntityDataFactory == -1)) {
                try {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 69;
                    FragmentBottomSheetPaymentSettingBinding = i3 % 128;
                    if ((i3 % 2 == 0 ? '%' : '0') != '%') {
                        profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
                        return;
                    }
                    profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
                    int length2 = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final int BuiltInFictitiousFunctionClassFactory(String p0) {
        int i = FragmentBottomSheetPaymentSettingBinding + 113;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
        int i2 = i % 2;
        this.PlaceComponentResult = p0;
        if (!(!KClassImpl$Data$declaredNonStaticMembers$2())) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 45;
            FragmentBottomSheetPaymentSettingBinding = i3 % 128;
            int i4 = i3 % 2;
            return R.string.dana_premium;
        }
        return R.string.dana_user;
    }

    private final boolean lookAheadTest() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 51;
            FragmentBottomSheetPaymentSettingBinding = i % 128;
            if (i % 2 == 0) {
            }
            boolean booleanExtra = getIntent().getBooleanExtra(MyProfileBundleKey.FROM_FEEDS_SETTING_ICON, false);
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 29;
            FragmentBottomSheetPaymentSettingBinding = i2 % 128;
            int i3 = i2 % 2;
            return booleanExtra;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void GetContactSyncConfig() {
        ProfileSettingsAdapter profileSettingsAdapter;
        int MyBillsEntityDataFactory;
        SettingModel PlaceComponentResult = PlaceComponentResult(MyProfileMenuAction.FEED_SHARING);
        if (PlaceComponentResult != null) {
            int i = FragmentBottomSheetPaymentSettingBinding + 19;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            if ((i % 2 != 0 ? 'N' : '%') != '%') {
                PlaceComponentResult.setFromFeeds(lookAheadTest());
                profileSettingsAdapter = this.moveToNextValue;
                String parent = PlaceComponentResult.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "");
                Intrinsics.checkNotNullParameter(parent, "");
                MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent);
                Object[] objArr = null;
                int length = objArr.length;
                if (!(MyBillsEntityDataFactory != -1)) {
                    return;
                }
            } else {
                PlaceComponentResult.setFromFeeds(lookAheadTest());
                profileSettingsAdapter = this.moveToNextValue;
                String parent2 = PlaceComponentResult.getParent();
                Intrinsics.checkNotNullExpressionValue(parent2, "");
                Intrinsics.checkNotNullParameter(parent2, "");
                MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent2);
                if ((MyBillsEntityDataFactory != -1 ? Typography.amp : ':') != '&') {
                    return;
                }
            }
            profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 5;
            FragmentBottomSheetPaymentSettingBinding = i2 % 128;
            int i3 = i2 % 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if ((r0 != null ? '1' : 'P') != 'P') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if ((r0 != null ? '*' : 11) != 11) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual("KYC0", r0) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r0 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        r0 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if (r0 == ':') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding + 123;
        id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004b, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding
            r1 = 11
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 == 0) goto L21
            java.lang.String r0 = r4.PlaceComponentResult
            r1 = 98
            int r1 = r1 / r2
            r1 = 80
            if (r0 == 0) goto L1a
            r3 = 49
            goto L1c
        L1a:
            r3 = 80
        L1c:
            if (r3 == r1) goto L4c
            goto L2c
        L1f:
            r0 = move-exception
            throw r0
        L21:
            java.lang.String r0 = r4.PlaceComponentResult
            if (r0 == 0) goto L28
            r3 = 42
            goto L2a
        L28:
            r3 = 11
        L2a:
            if (r3 == r1) goto L4c
        L2c:
            java.lang.String r1 = "KYC0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            r1 = 58
            if (r0 != 0) goto L39
            r0 = 58
            goto L3b
        L39:
            r0 = 79
        L3b:
            if (r0 == r1) goto L3e
            goto L4c
        L3e:
            r2 = 1
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding     // Catch: java.lang.Exception -> L4a
            int r0 = r0 + 123
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1     // Catch: java.lang.Exception -> L4a
            int r0 = r0 % 2
            goto L4c
        L4a:
            r0 = move-exception
            throw r0
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.KClassImpl$Data$declaredNonStaticMembers$2():boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:19:0x0060
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final com.anggrayudi.storage.permission.ActivityPermissionRequest scheduleImpl() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r0 = r0 + 33
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r1
            int r0 = r0 % 2
            boolean r0 = id.dana.utils.OSUtil.MyBillsEntityDataFactory()
            r1 = 39
            if (r0 == 0) goto L15
            r0 = 81
            goto L17
        L15:
            r0 = 39
        L17:
            java.lang.String r2 = "android.permission.CAMERA"
            if (r0 == r1) goto L2a
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3
            int r0 = r0 + 5
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding = r1
            int r0 = r0 % 2
            java.lang.String[] r0 = new java.lang.String[]{r2}
            goto L30
        L2a:
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String[] r0 = new java.lang.String[]{r2, r0}
        L30:
            com.anggrayudi.storage.permission.ActivityPermissionRequest$Builder r1 = new com.anggrayudi.storage.permission.ActivityPermissionRequest$Builder
            r2 = r4
            androidx.activity.ComponentActivity r2 = (androidx.view.ComponentActivity) r2     // Catch: java.lang.Exception -> L5e
            r1.<init>(r2)
            int r2 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)     // Catch: java.lang.Exception -> L5e
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r3 = r1
            com.anggrayudi.storage.permission.ActivityPermissionRequest$Builder r3 = (com.anggrayudi.storage.permission.ActivityPermissionRequest.Builder) r3
            java.util.Set r0 = kotlin.collections.ArraysKt.toSet(r0)
            r1.PlaceComponentResult = r0
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity$initPermission$1 r0 = new id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity$initPermission$1
            r0.<init>()
            com.anggrayudi.storage.permission.PermissionCallback r0 = (com.anggrayudi.storage.permission.PermissionCallback) r0
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r1.getAuthRequestContext = r0
            com.anggrayudi.storage.permission.ActivityPermissionRequest r0 = r1.PlaceComponentResult()
            return r0
        L5e:
            r0 = move-exception
            goto L62
        L60:
            r0 = move-exception
            throw r0
        L62:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.scheduleImpl():com.anggrayudi.storage.permission.ActivityPermissionRequest");
    }

    private final int MyBillsEntityDataFactory(String p0) {
        try {
            int i = FragmentBottomSheetPaymentSettingBinding + 97;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i % 128;
            int i2 = i % 2;
            List<SettingModel> items = this.moveToNextValue.getItems();
            if ((items != null ? 'L' : (char) 16) != 'L') {
                return -1;
            }
            int i3 = FragmentBottomSheetPaymentSettingBinding + 97;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            int i4 = i3 % 2;
            Iterator<SettingModel> it = items.iterator();
            int i5 = FragmentBottomSheetPaymentSettingBinding + 35;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i5 % 128;
            int i6 = i5 % 2;
            int i7 = 0;
            while (true) {
                if (!it.hasNext()) {
                    return -1;
                }
                int i8 = NetworkUserEntityData$$ExternalSyntheticLambda3 + 97;
                FragmentBottomSheetPaymentSettingBinding = i8 % 128;
                int i9 = i8 % 2;
                if ((Intrinsics.areEqual(it.next().getName(), p0) ? 'O' : (char) 20) == 'O') {
                    int i10 = FragmentBottomSheetPaymentSettingBinding + 33;
                    NetworkUserEntityData$$ExternalSyntheticLambda3 = i10 % 128;
                    int i11 = i10 % 2;
                    return i7;
                }
                i7++;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r0 >= 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        r1 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding + 97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if ((r1 % 2) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
    
        r1 = '8';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        r1 = ']';
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        if (r1 == '8') goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        r1 = r4.moveToNextValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        if (r1.PlaceComponentResult(r0) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        r1 = r4.moveToNextValue;
        r2 = r1.PlaceComponentResult(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0049, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004a, code lost:
    
        r3 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004d, code lost:
    
        if (r2 != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        r2 = kotlin.text.Typography.dollar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r2 = 'S';
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0054, code lost:
    
        if (r2 == '$') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
    
        r1.getItems().remove(r0);
        r1.notifyItemRemoved(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0064, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0065, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0068, code lost:
    
        r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding + 69;
        id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0072, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0 >= 0) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void hideNickname() {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding
            int r0 = r0 + 117
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            java.lang.String r3 = "setting_change_name"
            if (r0 == r1) goto L1c
            int r0 = r4.MyBillsEntityDataFactory(r3)
            if (r0 < 0) goto L66
            goto L25
        L1c:
            int r0 = r4.MyBillsEntityDataFactory(r3)
            r1 = 43
            int r1 = r1 / r2
            if (r0 < 0) goto L66
        L25:
            int r1 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding     // Catch: java.lang.Exception -> L64
            int r1 = r1 + 97
            int r2 = r1 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r2     // Catch: java.lang.Exception -> L71
            int r1 = r1 % 2
            r2 = 56
            if (r1 == 0) goto L36
            r1 = 56
            goto L38
        L36:
            r1 = 93
        L38:
            if (r1 == r2) goto L43
            id.dana.myprofile.mepagerevamp.profilesettings.adapter.ProfileSettingsAdapter r1 = r4.moveToNextValue
            boolean r2 = r1.PlaceComponentResult(r0)
            if (r2 != 0) goto L66
            goto L57
        L43:
            id.dana.myprofile.mepagerevamp.profilesettings.adapter.ProfileSettingsAdapter r1 = r4.moveToNextValue     // Catch: java.lang.Exception -> L64
            boolean r2 = r1.PlaceComponentResult(r0)     // Catch: java.lang.Exception -> L64
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L62
            r3 = 36
            if (r2 != 0) goto L52
            r2 = 36
            goto L54
        L52:
            r2 = 83
        L54:
            if (r2 == r3) goto L57
            goto L66
        L57:
            java.util.List r2 = r1.getItems()
            r2.remove(r0)
            r1.notifyItemRemoved(r0)
            goto L66
        L62:
            r0 = move-exception
            throw r0
        L64:
            r0 = move-exception
            throw r0
        L66:
            int r0 = id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.FragmentBottomSheetPaymentSettingBinding     // Catch: java.lang.Exception -> L71
            int r0 = r0 + 69
            int r1 = r0 % 128
            id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.NetworkUserEntityData$$ExternalSyntheticLambda3 = r1
            int r0 = r0 % 2
            return
        L71:
            r0 = move-exception
            throw r0
        L73:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity.hideNickname():void");
    }

    public final void showUsername(String username) {
        ProfileSettingsAdapter profileSettingsAdapter;
        int MyBillsEntityDataFactory;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda3 + 65;
        FragmentBottomSheetPaymentSettingBinding = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(username, "");
        Object[] objArr = new Object[1];
        g(super.getResources().getString(R.string.hi_check_out_how_dana_works).substring(0, 1).length() - 1, new char[]{46057, 45978, 57079, 55960, 11404, 56267, 9452, 55201, 41896, 51883, 13527, 51154, 37836, 64222, 1165, 63447, 33791, 59924, 5229, 59192, 62230, 39486, 25680, 38676, 58191, 35394, 29749}, objArr);
        SettingModel PlaceComponentResult = PlaceComponentResult(((String) objArr[0]).intern());
        if (PlaceComponentResult != null) {
            int i3 = FragmentBottomSheetPaymentSettingBinding + 85;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i3 % 128;
            Object obj = null;
            if (!(i3 % 2 == 0)) {
                PlaceComponentResult.setUsername(username);
                profileSettingsAdapter = this.moveToNextValue;
                String parent = PlaceComponentResult.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "");
                Intrinsics.checkNotNullParameter(parent, "");
                MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent);
                obj.hashCode();
                if (MyBillsEntityDataFactory == -1) {
                    return;
                }
            } else {
                PlaceComponentResult.setUsername(username);
                profileSettingsAdapter = this.moveToNextValue;
                String parent2 = PlaceComponentResult.getParent();
                Intrinsics.checkNotNullExpressionValue(parent2, "");
                Intrinsics.checkNotNullParameter(parent2, "");
                MyBillsEntityDataFactory = profileSettingsAdapter.MyBillsEntityDataFactory(parent2);
                if (MyBillsEntityDataFactory == -1) {
                    return;
                }
            }
            int i4 = FragmentBottomSheetPaymentSettingBinding + 69;
            NetworkUserEntityData$$ExternalSyntheticLambda3 = i4 % 128;
            char c = i4 % 2 != 0 ? (char) 3 : (char) 1;
            profileSettingsAdapter.notifyItemChanged(MyBillsEntityDataFactory);
            if (c != 3) {
                return;
            }
            obj.hashCode();
        }
    }

    private static void k(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (cArr2 != null) {
            try {
                int i2 = $11 + 119;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i4 = 0;
                while (true) {
                    if ((i4 < length ? 'M' : 'V') == 'V') {
                        break;
                    }
                    cArr3[i4] = (char) (cArr2[i4] ^ 4571606982258105150L);
                    i4++;
                }
                cArr2 = cArr3;
            } catch (Exception e) {
                throw e;
            }
        }
        int i5 = (int) (4571606982258105150L ^ PrepareContext);
        if (newProxyInstance) {
            int i6 = $10 + 7;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
            }
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                int i7 = $10 + 67;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i5);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (isLayoutRequested) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                int i9 = $11 + 95;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i5);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (true) {
                if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    objArr[0] = new String(cArr6);
                    return;
                }
                int i11 = $10 + 73;
                $11 = i11 % 128;
                int i12 = i11 % 2;
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i5);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
        }
    }

    private static void g(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(NetworkUserEntityData$$ExternalSyntheticLambda8 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        try {
            int i2 = $10 + 15;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            while (true) {
                if (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
                    int i4 = $10 + 13;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (NetworkUserEntityData$$ExternalSyntheticLambda8 ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                } else {
                    objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
                    return;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
