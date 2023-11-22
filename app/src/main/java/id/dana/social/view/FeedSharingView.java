package id.dana.social.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.social.PrivacySettingActivity;
import id.dana.social.state.InitFeedState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u00020\f8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/social/view/FeedSharingView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/social/state/InitFeedState;", "state", "", "render", "(Lid/dana/social/state/InitFeedState;)V", "setup", "()V", "", "PlaceComponentResult", "Z", "isFromFeeds", "()Z", "setFromFeeds", "(Z)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedSharingView extends BaseRichView {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean isFromFeeds;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedSharingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedSharingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_feed_sharing;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSharingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FeedSharingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "isFromFeeds")
    /* renamed from: isFromFeeds  reason: from getter */
    public final boolean getIsFromFeeds() {
        return this.isFromFeeds;
    }

    @JvmName(name = "setFromFeeds")
    public final void setFromFeeds(boolean z) {
        this.isFromFeeds = z;
    }

    public final void render(InitFeedState state) {
        Intrinsics.checkNotNullParameter(state, "");
        if (!(state instanceof InitFeedState.NotActivated)) {
            if (!(state instanceof InitFeedState.NoWording)) {
                if (!(state instanceof InitFeedState.Activated)) {
                    throw new NoWhenBranchMatchedException();
                }
                AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.setClientPackageName);
                if (appCompatTextView != null) {
                    appCompatTextView.setText("");
                }
                ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_feed_sharing);
                if (constraintLayout != null) {
                    constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedSharingView$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FeedSharingView.$r8$lambda$v5h77bSsDqkgMC4STWNKky5Ry20(FeedSharingView.this, view);
                        }
                    });
                    return;
                }
                return;
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.setClientPackageName);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText("");
                return;
            }
            return;
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.setClientPackageName);
        if (appCompatTextView3 != null) {
            Context context = getContext();
            appCompatTextView3.setText(context != null ? context.getString(R.string.feed_sharing_state_not_activated) : null);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_feed_sharing);
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedSharingView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedSharingView.m2961$r8$lambda$7ImgOvDw88JEeAhMfoIGAsTftY(FeedSharingView.this, view);
                }
            });
        }
    }

    /* renamed from: $r8$lambda$7ImgOvDw88JEeAhMfoIGAsT-ftY  reason: not valid java name */
    public static /* synthetic */ void m2961$r8$lambda$7ImgOvDw88JEeAhMfoIGAsTftY(FeedSharingView feedSharingView, View view) {
        Intrinsics.checkNotNullParameter(feedSharingView, "");
        Context context = feedSharingView.getContext();
        Intent intent = new Intent(feedSharingView.getContext(), HomeTabActivity.class);
        intent.putExtra("target", "friends");
        intent.putExtra("Source", FeedsSourceType.FEED_SETTINGS);
        intent.setFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
        context.startActivity(intent);
        feedSharingView.getBaseActivity().finish();
    }

    public static /* synthetic */ void $r8$lambda$v5h77bSsDqkgMC4STWNKky5Ry20(FeedSharingView feedSharingView, View view) {
        Intrinsics.checkNotNullParameter(feedSharingView, "");
        Intent intent = new Intent(feedSharingView.getContext(), PrivacySettingActivity.class);
        intent.putExtra(MyProfileBundleKey.FROM_FEEDS_SETTING_ICON, feedSharingView.isFromFeeds);
        BaseActivity baseActivity = feedSharingView.getBaseActivity();
        SettingMoreProfileActivity.Companion companion = SettingMoreProfileActivity.INSTANCE;
        baseActivity.startActivityForResult(intent, SettingMoreProfileActivity.Companion.BuiltInFictitiousFunctionClassFactory());
    }
}
