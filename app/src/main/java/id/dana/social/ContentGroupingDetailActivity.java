package id.dana.social;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.di.modules.OauthModule;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.adapter.SocialFeedsAdapter;
import id.dana.social.base.BaseSocialFeedsAdapter;
import id.dana.social.contract.ContentGroupingDetailContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.ContentGroupingDetailModule;
import id.dana.social.mapper.FeedViewModelMapperKt;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.utils.Content;
import id.dana.social.utils.SocialScrollListener;
import id.dana.social.v2.adapter.NewSocialFeedsAdapter;
import id.dana.social.view.activity.SocialProfileActivity;
import id.dana.social.view.activity.detail.SocialActivityDetail;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\n\u001a\u00020\u000f8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0017\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010\u0003\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001aR\u0014\u0010'\u001a\u00020$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0019\u001a\u00020(8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lid/dana/social/ContentGroupingDetailActivity;", "Lid/dana/base/BaseActivity;", "", "getAuthRequestContext", "()V", "", "getLayout", "()I", "", "Lid/dana/social/model/FeedViewHolderModel;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/util/List;", IAPSyncCommand.COMMAND_INIT, "Lid/dana/social/model/FeedModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/social/model/FeedModel;)Z", "lookAheadTest", "I", "MyBillsEntityDataFactory", "scheduleImpl", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "Lid/dana/social/contract/ContentGroupingDetailContract$Presenter;", "presenter", "Lid/dana/social/contract/ContentGroupingDetailContract$Presenter;", "getPresenter", "()Lid/dana/social/contract/ContentGroupingDetailContract$Presenter;", "setPresenter", "(Lid/dana/social/contract/ContentGroupingDetailContract$Presenter;)V", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/social/ContentGroupingDetailActivity$socialFeedListener$1;", "GetContactSyncConfig", "Lid/dana/social/ContentGroupingDetailActivity$socialFeedListener$1;", "moveToNextValue", "Lid/dana/social/base/BaseSocialFeedsAdapter;", "initRecordTimeStamp", "Lid/dana/social/base/BaseSocialFeedsAdapter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContentGroupingDetailActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long DatabaseTableConfigUtil;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private BaseSocialFeedsAdapter NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;
    @Inject
    public ContentGroupingDetailContract.Presenter presenter;
    public static final byte[] $$a = {96, 83, 72, -80, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 38;
    public static final byte[] PlaceComponentResult = {15, -40, -114, -21, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 9;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.social.ContentGroupingDetailActivity$isFeedRevamp$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(ContentGroupingDetailActivity.this.getDanaApplication().isFeedRevamp());
        }
    });

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final ContentGroupingDetailActivity$socialFeedListener$1 moveToNextValue = new BaseSocialFeedInteraction() { // from class: id.dana.social.ContentGroupingDetailActivity$socialFeedListener$1
        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(Content p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ContentGroupingDetailContract.Presenter presenter = ContentGroupingDetailActivity.this.getPresenter();
            String str = p0.MyBillsEntityDataFactory;
            presenter.KClassImpl$Data$declaredNonStaticMembers$2(str != null ? str : "");
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter;
            baseSocialFeedsAdapter = ContentGroupingDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (baseSocialFeedsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter = null;
            }
            FeedViewHolderModel item = baseSocialFeedsAdapter.getItem(p0);
            if (item != null) {
                ContentGroupingDetailActivity.access$handleAvatarClick(ContentGroupingDetailActivity.this, item);
            }
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void PlaceComponentResult() {
            BaseSocialFeedsAdapter baseSocialFeedsAdapter;
            baseSocialFeedsAdapter = ContentGroupingDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (baseSocialFeedsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseSocialFeedsAdapter = null;
            }
            if (!baseSocialFeedsAdapter.BuiltInFictitiousFunctionClassFactory() && baseSocialFeedsAdapter.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                baseSocialFeedsAdapter.removeItem(baseSocialFeedsAdapter.getGetAuthRequestContext() - 1);
            }
            ContentGroupingDetailActivity.this.getAuthRequestContext();
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void MyBillsEntityDataFactory(int p0) {
            boolean z;
            BaseSocialFeedsAdapter baseSocialFeedsAdapter;
            boolean z2;
            z = ContentGroupingDetailActivity.this.getAuthRequestContext;
            if (z) {
                baseSocialFeedsAdapter = ContentGroupingDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (baseSocialFeedsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    baseSocialFeedsAdapter = null;
                }
                FeedViewHolderModel item = baseSocialFeedsAdapter.getItem(p0);
                if (item != null) {
                    ContentGroupingDetailActivity contentGroupingDetailActivity = ContentGroupingDetailActivity.this;
                    FeedModel feedModel = item.MyBillsEntityDataFactory;
                    if (feedModel != null) {
                        SocialActivityDetail.Companion companion = SocialActivityDetail.INSTANCE;
                        ContentGroupingDetailActivity contentGroupingDetailActivity2 = contentGroupingDetailActivity;
                        z2 = contentGroupingDetailActivity.KClassImpl$Data$declaredNonStaticMembers$2;
                        SocialActivityDetail.Companion.KClassImpl$Data$declaredNonStaticMembers$2(contentGroupingDetailActivity2, feedModel, z2);
                    }
                }
            }
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void BuiltInFictitiousFunctionClassFactory(ActivityWidgetModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ContentGroupingDetailActivity.this.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0.getAuthRequestContext);
        }

        @Override // id.dana.social.adapter.BaseSocialFeedInteraction, id.dana.social.adapter.SocialFeedClickListener
        public final void getAuthRequestContext(String p0, DealsPayloadModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            ContentGroupingDetailContract.Presenter presenter = ContentGroupingDetailActivity.this.getPresenter();
            String str = (String) MapsKt.getOrImplicitDefaultNullable(p1.PlaceComponentResult, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[1].getName());
            if (str == null) {
                str = "";
            }
            String str2 = (String) MapsKt.getOrImplicitDefaultNullable(p1.BuiltInFictitiousFunctionClassFactory, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[2].getName());
            presenter.MyBillsEntityDataFactory(str, str2 != null ? str2 : "");
        }
    };

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda1 = new char[]{62255, 17949, 39248, 60555, 10197, 30998, 52292, 1995, 23239, 44059, 59228, 15103, 36307, 50996, 6764, 28084, 41192, 64042, 19824, 32944, 56286, 11559, 24578, 47952, 3735, 16863, 20888, 58547, 15347, 20030, 34154, 56228, 28385, 42257, 63587, 3758, 17909, 38925, 12100, 25987, 47321, 52993, 580, 22680, 11176, 40602, 16855, 13324, 65362, 41361, 5315, 57164, 33358, 29855, 16261, 57862, 21863, 8127, 49916, 46399, 30826, 8887, 63993, 19664, 37819, 58954, 11524, 4884, 42621, 31087, 3244, 51175, 39286, 11380, 59312, 47868, 19555, 1826, 56026, 28058, 9992, 64068, 36230, 16578, 6687, 44383, 24773, 15235, 52545, 32894, 23406, 61183, 41445, 31529, 3624, 49597, 38062, 11876, 57637, 46266, 20424, 267, 54349, 28625, 8907, 62485, 36696, 17052, 5504, 44821, 25130, 13629, 51369, 33763, 21877, 6799, 45030, 28834, 1341, 52860, 37094, 9648, 61053, 45922, 17832, 3765, 54084, 25686, 11974, 62345, 33865, 18700, 5073, 42178, 26968, 12878, 50398, 35302, 21158, 59232, 43129, 29413, 2020, 51322, 40291, 10234, 59583, 48429, 18007, 2240, 56705, 26137, 11100, 64976, 34454, 19283, 7195, 42633, 27616, 15601, 49504, 35369, 23786, 57773, 43632, 32563, 496, 51891, 40824, 8192, 60100, 49030, 16458, 5471, 57219, 24723, 13663, 65100, 32990, 62332, 17986, 39249, 60571, 10115, 31048, 52242, 2001, 23198, 44115, 59156, 15072, 36259, 51044, 6696, 28138, 41215, 64038, 19760, 32941, 56248, 11565, 24593, 47878, 3777, 16861, 39749, 60953, 8580, 29889, 52831, 334, 21721, 45047, 57702, 13345, 36792, 49832, 5238, 28477, 41726, 62957, 20349, 33349, 54538, 10439, 25561, 46367, 2136, 17370, 38599, 59404, 8984, 30430, 51702, 864, 22049, 43502, 64677, 13943, 35172, 56562, 6077, 26996, 30730, 52523, 4716, 26533, 44261, 62057, 18211, 36070, 53742, 10022, 27758, 45468, 1680, 19471, 37212, 59011, 11223, 28942, 50780, 2950, 20679, 42512, 60200, 12343, 34237, 51938, 4145, 25983, 43690, 65528, 17717, 35444, 57251, 9421, 27165, 48923, 1173, 18908, 40705, 58374, 10635, 32471, 50185, 2418, 24183, 41909, 59635, 15924, 33633, 51387, 7591, 25395, 43060, 65004, 17113, 34831, 56671, 8857, 30660, 48414, Typography.pound, 46473, 27348, 7939, 54364, 35482};
        DatabaseTableConfigUtil = -2273662955902253453L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 56 - r8
            byte[] r0 = id.dana.social.ContentGroupingDetailActivity.PlaceComponentResult
            int r7 = r7 + 97
            int r6 = r6 + 16
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r7
            r3 = 0
            r7 = r6
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r5
        L28:
            int r8 = r8 + 1
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + (-4)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.ContentGroupingDetailActivity.b(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.social.ContentGroupingDetailActivity.$$a
            int r8 = 47 - r8
            int r6 = r6 * 3
            int r6 = r6 + 21
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + (-7)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.ContentGroupingDetailActivity.c(short, short, int, java.lang.Object[]):void");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18 - Color.alpha(0), 43 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (55430 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(5 - ExpandableListView.getPackedPositionType(0L), 62 - TextUtils.indexOf("", "", 0), (char) (2779 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.keyCodeFromString(""), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((ViewConfiguration.getWindowTouchSlop() >> 8) + 48, 67 - KeyEvent.getDeadChar(0, 0), (char) (View.MeasureSpec.getMode(0) + 57453), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((Process.myTid() >> 22) + 64, 115 - Color.green(0), (char) (59808 - (Process.myPid() >> 22)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((ViewConfiguration.getFadingEdgeLength() >> 16) + 64, TextUtils.lastIndexOf("", '0', 0) + 180, (char) KeyEvent.getDeadChar(0, 0), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(TextUtils.getCapsMode("", 0, 0) + 60, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 243, (char) (35628 - View.MeasureSpec.getSize(0)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(KeyEvent.getDeadChar(0, 0) + 6, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 302, (char) (MotionEvent.axisFromString("") + 62421), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = new Object[1];
                b(PlaceComponentResult[25], (byte) getAuthRequestContext, PlaceComponentResult[0], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = PlaceComponentResult[25];
                byte b2 = (byte) (b | 8);
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 22), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getLongPressTimeout() >> 16), 4 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        byte b3 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b3, b3, $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 14, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - View.MeasureSpec.getMode(0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 815, TextUtils.getCapsMode("", 0, 0) + 29, (char) (KeyEvent.getDeadChar(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSizeAndState(0, 0, 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) (ViewConfiguration.getScrollBarSize() >> 8)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-570752949, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), 18 - Color.alpha(0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
                                        } catch (Throwable th3) {
                                            Throwable cause3 = th3.getCause();
                                            if (cause3 == null) {
                                                throw th3;
                                            }
                                            throw cause3;
                                        }
                                    } catch (Throwable th4) {
                                        Throwable cause4 = th4.getCause();
                                        if (cause4 == null) {
                                            throw th4;
                                        }
                                        throw cause4;
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = new Object[1];
                b(PlaceComponentResult[25], (byte) getAuthRequestContext, PlaceComponentResult[0], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = PlaceComponentResult[25];
                byte b5 = (byte) (b4 | 8);
                Object[] objArr20 = new Object[1];
                b(b4, b5, (byte) (b5 | 22), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.lastIndexOf("", '0', 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 46, (char) Color.green(0));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[9], $$a[84], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - TextUtils.getTrimmedLength(""), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-570752949, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 911, 18 - Drawable.resolveOpacity(0, 0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr25 = new Object[1];
                b(PlaceComponentResult[25], (byte) getAuthRequestContext, PlaceComponentResult[0], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b6 = PlaceComponentResult[25];
                byte b7 = (byte) (b6 | 8);
                Object[] objArr26 = new Object[1];
                b(b6, b7, (byte) (b7 | 22), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 119, 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[9], $$a[84], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-570752949, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr31 = new Object[1];
                b(PlaceComponentResult[25], (byte) getAuthRequestContext, PlaceComponentResult[0], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b8 = PlaceComponentResult[25];
                byte b9 = (byte) (b8 | 8);
                Object[] objArr32 = new Object[1];
                b(b8, b9, (byte) (b9 | 22), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 108, 2 - ExpandableListView.getPackedPositionChild(0L), (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        byte b10 = $$a[8];
                        byte b11 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b10, b11, b11, objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-570752949, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0) + 19, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_content_grouping_detail;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.most_wanted_ongoing_promos).substring(19, 20).codePointAt(0) - 14, super.getResources().getString(R.string.my_bills_zero_subscription).substring(1, 2).length() + 43, (char) (super.getResources().getString(R.string.nearby_header).substring(1, 2).length() + 55430), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(R.string.lets_have_a_good_day).substring(1, 2).codePointAt(0) - 96, super.getResources().getString(R.string.akamai_verify_dialog_title).substring(1, 2).codePointAt(0) - 39, (char) (super.getResources().getString(R.string.msg_location_dialog_verifynumber_desc).substring(142, 144).length() + 2776), objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = PlaceComponentResult[30];
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr4 = new Object[1];
                    b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    b(PlaceComponentResult[8], PlaceComponentResult[5], PlaceComponentResult[25], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 7, getPackageName().codePointAt(4) - 97, (char) ((Process.getThreadPriority(0) + 20) >> 6), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 18;
                    try {
                        byte b3 = PlaceComponentResult[30];
                        byte b4 = PlaceComponentResult[25];
                        Object[] objArr6 = new Object[1];
                        b(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        b(PlaceComponentResult[8], PlaceComponentResult[5], PlaceComponentResult[25], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        a(edgeSlop, ((ApplicationInfo) cls4.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 7, (char) (getPackageName().length() + 41646), objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    a(getPackageName().length() + 41, Color.rgb(0, 0, 0) + 16777283, (char) (getPackageName().length() + 57446), objArr8);
                    String str = (String) objArr8[0];
                    try {
                        byte b5 = PlaceComponentResult[30];
                        byte b6 = PlaceComponentResult[25];
                        Object[] objArr9 = new Object[1];
                        b(b5, b6, (byte) (b6 | TarHeader.LF_BLK), objArr9);
                        Class<?> cls5 = Class.forName((String) objArr9[0]);
                        Object[] objArr10 = new Object[1];
                        b(PlaceComponentResult[8], PlaceComponentResult[5], PlaceComponentResult[25], objArr10);
                        Object[] objArr11 = new Object[1];
                        a(((ApplicationInfo) cls5.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 31, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 114, (char) (super.getResources().getString(R.string.family_member_transaction_limit_slider_min).substring(0, 4).length() + 59804), objArr11);
                        String str2 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(super.getResources().getString(R.string.split_bill_qr_desc_message).substring(17, 18).length() + 63, super.getResources().getString(R.string.category_food_beverages).substring(5, 7).length() + 177, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr12);
                        String str3 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        a(super.getResources().getString(R.string.family_account_setting_maintenance_title).substring(20, 21).codePointAt(0) - 37, super.getResources().getString(R.string.my_bills_swipe_action_history).substring(1, 2).codePointAt(0) + 138, (char) (getPackageName().length() + 35621), objArr13);
                        String str4 = (String) objArr13[0];
                        Object[] objArr14 = new Object[1];
                        a(super.getResources().getString(R.string.zdoc_imperfect_msg).substring(0, 1).length() + 5, getPackageName().length() + 296, (char) (super.getResources().getString(R.string.tap_anywhere_to_close).substring(0, 4).length() + 62416), objArr14);
                        try {
                            Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) ((-1) - Process.getGidForName("")))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr15);
                        } catch (Throwable th3) {
                            Throwable cause3 = th3.getCause();
                            if (cause3 == null) {
                                throw th3;
                            }
                            throw cause3;
                        }
                    } catch (Throwable th4) {
                        Throwable cause4 = th4.getCause();
                        if (cause4 == null) {
                            throw th4;
                        }
                        throw cause4;
                    }
                } catch (Throwable th5) {
                    Throwable cause5 = th5.getCause();
                    if (cause5 == null) {
                        throw th5;
                    }
                    throw cause5;
                }
            }
        }
        try {
            Object[] objArr16 = new Object[1];
            b(PlaceComponentResult[25], (byte) getAuthRequestContext, PlaceComponentResult[0], objArr16);
            Class<?> cls6 = Class.forName((String) objArr16[0]);
            byte b7 = PlaceComponentResult[25];
            byte b8 = (byte) (b7 | 8);
            Object[] objArr17 = new Object[1];
            b(b7, b8, (byte) (b8 | 22), objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 494, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 4, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    byte b9 = $$a[8];
                    byte b10 = (byte) ($$a[78] - 1);
                    Object[] objArr19 = new Object[1];
                    c(b9, b10, b10, objArr19);
                    obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {-593112608, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, 'B' - AndroidCharacter.getMirror('0'), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                }
                super.onCreate(bundle);
            } catch (Throwable th8) {
                Throwable cause8 = th8.getCause();
                if (cause8 == null) {
                    throw th8;
                }
                throw cause8;
            }
        } catch (Throwable th9) {
            Throwable cause9 = th9.getCause();
            if (cause9 == null) {
                throw th9;
            }
            throw cause9;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.label_sorry).substring(5, 6).codePointAt(0) - 20, 1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (super.getResources().getString(R.string.card_binding_camera_helper).substring(0, 5).codePointAt(3) - 110), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().codePointAt(3) - 82, 26 - View.MeasureSpec.getMode(0), (char) (41653 - KeyEvent.keyCodeFromString("")), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 911, (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.btn_reload_error_registration_onboarding_paylater_cicil).substring(6, 7).codePointAt(0) - 39, getPackageName().length() - 7, (char) (getPackageName().length() - 7), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.home_shopping_tutorial_pay_step_3).substring(29, 30).length() + 17, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 25, (char) (ExpandableListView.getPackedPositionType(0L) + 41653), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), Drawable.resolveOpacity(0, 0) + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), Color.blue(0) + 18, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onResume();
    }

    @JvmName(name = "getPresenter")
    public final ContentGroupingDetailContract.Presenter getPresenter() {
        ContentGroupingDetailContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(ContentGroupingDetailContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return ((Boolean) this.BuiltInFictitiousFunctionClassFactory.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        baseSocialFeedsAdapter.appendItems(BuiltInFictitiousFunctionClassFactory());
        getPresenter().PlaceComponentResult();
    }

    private static List<FeedViewHolderModel> BuiltInFictitiousFunctionClassFactory() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            FeedModel.Companion companion = FeedModel.INSTANCE;
            arrayList.add(FeedModel.Companion.BuiltInFictitiousFunctionClassFactory());
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JX\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lid/dana/social/ContentGroupingDetailActivity$Companion;", "", "()V", "BUNDLED_ACTIVITY_IDS", "", "BUNDLED_ACTOR_COUNT", "BUNDLED_IS_REPLY_COMMENT_ENABLED", "BUNDLED_OWN_ACTIVITIES", "BUNDLED_SHOW_CAPTION_SECTION", "BUNDLED_SHOW_COMMENT_BUTTON", "openContentGroupingDetailActivity", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "activityIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "showCommentButton", "", "showCaptionSection", "actorCount", "", "ownActivities", "isReplyCommentEnabled", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void getAuthRequestContext(Context context, ArrayList<String> arrayList, boolean z, boolean z2, int i, boolean z3, boolean z4) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(arrayList, "");
            Intent intent = new Intent(context, ContentGroupingDetailActivity.class);
            intent.putStringArrayListExtra("bundled_activity_ids", arrayList);
            intent.putExtra("bundled_show_comment_button", z);
            intent.putExtra("bundled_show_caption_section", z2);
            intent.putExtra("bundled_actor_count", i);
            intent.putExtra("bundled_own_activities", z3);
            intent.putExtra("bundled_is_reply_comment_enabled", z4);
            context.startActivity(intent);
        }
    }

    public static /* synthetic */ void $r8$lambda$OEG6qp_6lCIfRyCVBTC0j_RrqPQ(ContentGroupingDetailActivity contentGroupingDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(contentGroupingDetailActivity, "");
        ((LinearLayout) contentGroupingDetailActivity._$_findCachedViewById(R.id.cl_content_group_detail)).setVisibility(0);
        contentGroupingDetailActivity._$_findCachedViewById(R.id.res_0x7f0a0438_sightcameraview_icameraframelistener).setVisibility(8);
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = contentGroupingDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        baseSocialFeedsAdapter.getErrorConfigVersion();
        contentGroupingDetailActivity.getAuthRequestContext();
    }

    public static final /* synthetic */ void access$handleAvatarClick(ContentGroupingDetailActivity contentGroupingDetailActivity, FeedViewHolderModel feedViewHolderModel) {
        FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
        if (feedModel != null) {
            if (!contentGroupingDetailActivity.PlaceComponentResult(feedModel)) {
                RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$2 = FeedViewModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(feedModel);
                Context baseContext = contentGroupingDetailActivity.getBaseContext();
                if (baseContext != null) {
                    SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
                    SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseContext, KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                return;
            }
            RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$22 = FeedViewModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(feedModel);
            Intrinsics.checkNotNullParameter("SELF", "");
            KClassImpl$Data$declaredNonStaticMembers$22.getErrorConfigVersion = "SELF";
            Context baseContext2 = contentGroupingDetailActivity.getBaseContext();
            if (baseContext2 != null) {
                SocialProfileActivity.Companion companion2 = SocialProfileActivity.INSTANCE;
                SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseContext2, KClassImpl$Data$declaredNonStaticMembers$22);
            }
        }
    }

    public static final /* synthetic */ void access$hideShimmer(ContentGroupingDetailActivity contentGroupingDetailActivity) {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = contentGroupingDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = null;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        List<FeedViewHolderModel> items = baseSocialFeedsAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        CollectionsKt.removeAll((List) items, (Function1) new Function1<FeedViewHolderModel, Boolean>() { // from class: id.dana.social.ContentGroupingDetailActivity$hideShimmer$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FeedViewHolderModel feedViewHolderModel) {
                return Boolean.valueOf(feedViewHolderModel.getErrorConfigVersion == 0);
            }
        });
        BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = contentGroupingDetailActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseSocialFeedsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            baseSocialFeedsAdapter2 = baseSocialFeedsAdapter3;
        }
        baseSocialFeedsAdapter2.notifyDataSetChanged();
    }

    public static final /* synthetic */ void access$showEmptyState(ContentGroupingDetailActivity contentGroupingDetailActivity) {
        ((LinearLayout) contentGroupingDetailActivity._$_findCachedViewById(R.id.cl_content_group_detail)).setVisibility(8);
        contentGroupingDetailActivity._$_findCachedViewById(R.id.res_0x7f0a0438_sightcameraview_icameraframelistener).setVisibility(0);
    }

    public static final /* synthetic */ void access$showExistState(ContentGroupingDetailActivity contentGroupingDetailActivity) {
        ((LinearLayout) contentGroupingDetailActivity._$_findCachedViewById(R.id.cl_content_group_detail)).setVisibility(0);
        contentGroupingDetailActivity._$_findCachedViewById(R.id.res_0x7f0a0438_sightcameraview_icameraframelistener).setVisibility(8);
    }

    private final boolean PlaceComponentResult(FeedModel p0) {
        HashMap<String, String> hashMap = p0.lookAheadTest;
        return Intrinsics.areEqual(hashMap != null ? ExtendInfoUtilKt.getUserId(hashMap) : null, getPresenter().KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        String string;
        SocialFeedsAdapter socialFeedsAdapter;
        Drawable PlaceComponentResult2;
        SocialCommonComponent socialCommonComponent = getDanaApplication().getSocialCommonComponent();
        byte b = 0;
        if (socialCommonComponent != null) {
            ContentGroupingDetailModule contentGroupingDetailModule = new ContentGroupingDetailModule(new ContentGroupingDetailContract.View() { // from class: id.dana.social.ContentGroupingDetailActivity$initInjector$1
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.social.contract.ContentGroupingDetailContract.View
                public final void MyBillsEntityDataFactory(List<FeedViewHolderModel> p0) {
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter;
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter2;
                    int i;
                    Intrinsics.checkNotNullParameter(p0, "");
                    ContentGroupingDetailActivity.access$hideShimmer(ContentGroupingDetailActivity.this);
                    BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = null;
                    if ((!p0.isEmpty()) != false) {
                        ContentGroupingDetailActivity.access$showExistState(ContentGroupingDetailActivity.this);
                        baseSocialFeedsAdapter2 = ContentGroupingDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (baseSocialFeedsAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            baseSocialFeedsAdapter3 = baseSocialFeedsAdapter2;
                        }
                        ContentGroupingDetailActivity contentGroupingDetailActivity = ContentGroupingDetailActivity.this;
                        baseSocialFeedsAdapter3.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                        FeedViewHolderModel feedViewHolderModel = (FeedViewHolderModel) CollectionsKt.first((List) p0);
                        FeedViewHolderModel feedViewHolderModel2 = (FeedViewHolderModel) CollectionsKt.last((List) p0);
                        i = contentGroupingDetailActivity.MyBillsEntityDataFactory;
                        Intrinsics.checkNotNullParameter(feedViewHolderModel, "");
                        Intrinsics.checkNotNullParameter(feedViewHolderModel2, "");
                        baseSocialFeedsAdapter3.getAuthRequestContext = new Triple<>(feedViewHolderModel, feedViewHolderModel2, Integer.valueOf(i));
                    } else if (!ContentGroupingDetailActivity.this.getPresenter().getAuthRequestContext()) {
                        baseSocialFeedsAdapter = ContentGroupingDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (baseSocialFeedsAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            baseSocialFeedsAdapter3 = baseSocialFeedsAdapter;
                        }
                        if (baseSocialFeedsAdapter3.BuiltInFictitiousFunctionClassFactory() || !baseSocialFeedsAdapter3.NetworkUserEntityData$$ExternalSyntheticLambda2() || baseSocialFeedsAdapter3.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                            return;
                        }
                        baseSocialFeedsAdapter3.appendItem(new FeedViewHolderModel(7, null, null, null, null, false, 60, null));
                    } else {
                        ContentGroupingDetailActivity.access$showEmptyState(ContentGroupingDetailActivity.this);
                    }
                }

                @Override // id.dana.social.contract.ContentGroupingDetailContract.View
                public final void PlaceComponentResult() {
                    ContentGroupingDetailActivity.access$hideShimmer(ContentGroupingDetailActivity.this);
                    ContentGroupingDetailActivity.access$showEmptyState(ContentGroupingDetailActivity.this);
                }

                @Override // id.dana.social.contract.ContentGroupingDetailContract.View
                public final String BuiltInFictitiousFunctionClassFactory() {
                    try {
                        TextView textView = (TextView) ((ViewGroup) ContentGroupingDetailActivity.this.findViewById(16908290)).getRootView().findViewWithTag(ContentGroupingDetailActivity.this.getResources().getString(R.string.error_message_tag));
                        Intrinsics.checkNotNullExpressionValue(textView, "");
                        return textView.getVisibility() == 0 ? textView.getText().toString() : "";
                    } catch (Exception unused) {
                        return "";
                    }
                }
            });
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            ContentGroupingDetailActivity contentGroupingDetailActivity = this;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = contentGroupingDetailActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = FeedsSourceType.FRIENDSHIP_FRIENDS_FEED;
            DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b);
            Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = contentGroupingDetailActivity;
            ScanQrModule scanQrModule = new ScanQrModule(authRequestContext, b);
            Intrinsics.checkNotNullExpressionValue(scanQrModule, "");
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = contentGroupingDetailActivity;
            RestoreUrlModule restoreUrlModule = new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b);
            Intrinsics.checkNotNullExpressionValue(restoreUrlModule, "");
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = contentGroupingDetailActivity;
            FeatureModule featureModule = new FeatureModule(MyBillsEntityDataFactory, b);
            Intrinsics.checkNotNullExpressionValue(featureModule, "");
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = contentGroupingDetailActivity;
            OauthModule oauthModule = new OauthModule(BuiltInFictitiousFunctionClassFactory, b);
            Intrinsics.checkNotNullExpressionValue(oauthModule, "");
            socialCommonComponent.BuiltInFictitiousFunctionClassFactory(contentGroupingDetailModule, deepLinkModule, scanQrModule, restoreUrlModule, featureModule, oauthModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.social.ContentGroupingDetailActivity$initInjector$2
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionFailed(String str) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                    ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                    ServicesContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onEmptySearchService() {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onFeatureServices(List list) {
                    ServicesContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetThirdPartyServices(List list) {
                    ServicesContract.View.CC.getAuthRequestContext(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onShowTooltip(boolean z) {
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            })).KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
        registerPresenter(getPresenter());
        setMenuLeftButton(R.drawable.btn_arrow_left);
        if (!KClassImpl$Data$declaredNonStaticMembers$2()) {
            string = "Feed";
        } else if (getIntent().getBooleanExtra("bundled_own_activities", false)) {
            string = getString(R.string.own_activity);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else {
            string = getString(R.string.friends_activity);
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        setCenterTitle(string);
        TextView textView = (TextView) _$_findCachedViewById(R.id.DanapolyPlayData);
        if (textView != null) {
            textView.setVisibility(KClassImpl$Data$declaredNonStaticMembers$2() ^ true ? 0 : 8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.allowedTargets);
        if (constraintLayout != null) {
            if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                PlaceComponentResult2 = ContextCompat.PlaceComponentResult(this, (int) R.color.f27072131100488);
            } else {
                PlaceComponentResult2 = ContextCompat.PlaceComponentResult(this, (int) R.color.f23942131099989);
            }
            constraintLayout.setBackground(PlaceComponentResult2);
        }
        ContentGroupingDetailContract.Presenter presenter = getPresenter();
        Bundle extras = getIntent().getExtras();
        BaseSocialFeedsAdapter baseSocialFeedsAdapter = null;
        ArrayList<String> stringArrayList = extras != null ? extras.getStringArrayList("bundled_activity_ids") : null;
        presenter.MyBillsEntityDataFactory(stringArrayList == null ? CollectionsKt.emptyList() : stringArrayList);
        Bundle extras2 = getIntent().getExtras();
        this.getAuthRequestContext = extras2 != null ? extras2.getBoolean("bundled_show_comment_button") : false;
        Bundle extras3 = getIntent().getExtras();
        this.PlaceComponentResult = extras3 != null ? extras3.getBoolean("bundled_show_caption_section") : false;
        Bundle extras4 = getIntent().getExtras();
        this.MyBillsEntityDataFactory = extras4 != null ? extras4.getInt("bundled_actor_count") : 0;
        Bundle extras5 = getIntent().getExtras();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = extras5 != null ? extras5.getBoolean("bundled_is_reply_comment_enabled") : false;
        getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2());
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            socialFeedsAdapter = new NewSocialFeedsAdapter();
        } else {
            socialFeedsAdapter = new SocialFeedsAdapter();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = socialFeedsAdapter;
        ContentGroupingDetailActivity$socialFeedListener$1 contentGroupingDetailActivity$socialFeedListener$1 = this.moveToNextValue;
        Intrinsics.checkNotNullParameter(contentGroupingDetailActivity$socialFeedListener$1, "");
        socialFeedsAdapter.getErrorConfigVersion = contentGroupingDetailActivity$socialFeedListener$1;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseSocialFeedsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter2 = null;
        }
        baseSocialFeedsAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseSocialFeedsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter3 = null;
        }
        baseSocialFeedsAdapter3.PlaceComponentResult = this.getAuthRequestContext;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseSocialFeedsAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter4 = null;
        }
        baseSocialFeedsAdapter4.MyBillsEntityDataFactory = this.PlaceComponentResult;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.BlockedFragmentComponent);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), 1, false));
        BaseSocialFeedsAdapter baseSocialFeedsAdapter5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseSocialFeedsAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            baseSocialFeedsAdapter = baseSocialFeedsAdapter5;
        }
        recyclerView.setAdapter(baseSocialFeedsAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.BlockedFragmentComponent);
        final View _$_findCachedViewById = _$_findCachedViewById(R.id.BlockedFragmentComponent);
        recyclerView2.addOnScrollListener(new SocialScrollListener(_$_findCachedViewById) { // from class: id.dana.social.ContentGroupingDetailActivity$setupRecycler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Illegal instructions before constructor call */
            {
                /*
                    r0 = this;
                    id.dana.social.ContentGroupingDetailActivity.this = r1
                    androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
                    java.lang.String r1 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
                    r0.<init>(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.social.ContentGroupingDetailActivity$setupRecycler$2.<init>(id.dana.social.ContentGroupingDetailActivity, android.view.View):void");
            }

            @Override // id.dana.social.utils.SocialScrollListener
            public final boolean getAuthRequestContext() {
                return ContentGroupingDetailActivity.this.getPresenter().MyBillsEntityDataFactory();
            }

            @Override // id.dana.social.utils.SocialScrollListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                BaseSocialFeedsAdapter baseSocialFeedsAdapter6;
                baseSocialFeedsAdapter6 = ContentGroupingDetailActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (baseSocialFeedsAdapter6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    baseSocialFeedsAdapter6 = null;
                }
                if (baseSocialFeedsAdapter6.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                    return;
                }
                ContentGroupingDetailActivity.this.getAuthRequestContext();
            }
        });
        getAuthRequestContext();
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btn_try_again_empty_state);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.ContentGroupingDetailActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContentGroupingDetailActivity.$r8$lambda$OEG6qp_6lCIfRyCVBTC0j_RrqPQ(ContentGroupingDetailActivity.this, view);
                }
            });
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (NetworkUserEntityData$$ExternalSyntheticLambda1[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ DatabaseTableConfigUtil))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
