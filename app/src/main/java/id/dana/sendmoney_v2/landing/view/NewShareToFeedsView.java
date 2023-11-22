package id.dana.sendmoney_v2.landing.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.glide.GlideApp;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.sendmoney.feed.ShareToFeedsView;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.v2.view.ActivityFeedView;
import id.dana.social.view.ClickableMovementMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\r¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\r\u0012\u0006\u0010#\u001a\u00020\r¢\u0006\u0004\b!\u0010$J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u0015\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0014\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004R\u0013\u0010\u001b\u001a\u00020\u0018X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/sendmoney_v2/landing/view/NewShareToFeedsView;", "Lid/dana/sendmoney/feed/ShareToFeedsView;", "", "disableShareToFeed", "()V", "", AccountEntityRepository.UpdateType.AVATAR, "displayAvatar", "(Ljava/lang/String;)V", "userName", "displayUserInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "enableShareToFeed", "", "getLayout", "()I", "renderFeedRevamp", "renderShareFeed", "Landroid/text/Spannable;", "textSpan", "setCaption", "(Landroid/text/Spannable;)V", "caption", "setup", "Lcom/afollestad/materialdialogs/MaterialDialog;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewShareToFeedsView extends ShareToFeedsView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewShareToFeedsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewShareToFeedsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.sendmoney.feed.ShareToFeedsView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.sendmoney.feed.ShareToFeedsView
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

    @Override // id.dana.sendmoney.feed.ShareToFeedsView, id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_share_to_feeds_new;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewShareToFeedsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.sendmoney_v2.landing.view.NewShareToFeedsView$feedSharingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2 = NewShareToFeedsView.this.getContext();
                final NewShareToFeedsView newShareToFeedsView = NewShareToFeedsView.this;
                Context context3 = newShareToFeedsView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context3);
                builder.SubSequence = context2.getString(R.string.feed_sharing_activation_dialog_title);
                builder.GetContactSyncConfig = context2.getString(R.string.feed_sharing_activation_dialog_desc);
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2(context2.getString(R.string.option_cancel), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.landing.view.NewShareToFeedsView$feedSharingDialog$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        NewShareToFeedsView.this.disableShareToFeed();
                    }
                }).BuiltInFictitiousFunctionClassFactory(context2.getString(R.string.activate), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.landing.view.NewShareToFeedsView$feedSharingDialog$2$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        NewShareToFeedsView.this.enableShareToFeed();
                        NewShareToFeedsView.access$getSummaryActivity(NewShareToFeedsView.this).getShareToFeedsPresenter().BuiltInFictitiousFunctionClassFactory();
                    }
                });
                BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
                return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    public /* synthetic */ NewShareToFeedsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewShareToFeedsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.sendmoney_v2.landing.view.NewShareToFeedsView$feedSharingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2 = NewShareToFeedsView.this.getContext();
                final NewShareToFeedsView newShareToFeedsView = NewShareToFeedsView.this;
                Context context3 = newShareToFeedsView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context3);
                builder.SubSequence = context2.getString(R.string.feed_sharing_activation_dialog_title);
                builder.GetContactSyncConfig = context2.getString(R.string.feed_sharing_activation_dialog_desc);
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2(context2.getString(R.string.option_cancel), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.landing.view.NewShareToFeedsView$feedSharingDialog$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        NewShareToFeedsView.this.disableShareToFeed();
                    }
                }).BuiltInFictitiousFunctionClassFactory(context2.getString(R.string.activate), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.landing.view.NewShareToFeedsView$feedSharingDialog$2$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        NewShareToFeedsView.this.enableShareToFeed();
                        NewShareToFeedsView.access$getSummaryActivity(NewShareToFeedsView.this).getShareToFeedsPresenter().BuiltInFictitiousFunctionClassFactory();
                    }
                });
                BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
                return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.sendmoney.feed.ShareToFeedsView, id.dana.base.BaseRichView
    public final void setup() {
        super.setup();
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) _$_findCachedViewById(R.id.ConcurrentKt);
        if (appCompatCheckBox != null) {
            appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.sendmoney_v2.landing.view.NewShareToFeedsView$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    NewShareToFeedsView.m2932$r8$lambda$a70IZe9zqFz8dZrSpFiylFDZQs(NewShareToFeedsView.this, compoundButton, z);
                }
            });
        }
    }

    public final void displayAvatar(String avatarUrl) {
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(avatarUrl).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.avatar_placeholder).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) ((CircleImageView) _$_findCachedViewById(R.id.getSendMoneyEstimationTimeValue)));
    }

    public final void displayUserInfo(String avatarUrl, String userName) {
        Intrinsics.checkNotNullParameter(avatarUrl, "");
        Intrinsics.checkNotNullParameter(userName, "");
        ActivityFeedView activityFeedView = (ActivityFeedView) _$_findCachedViewById(R.id.getAuthRequestContext_res_0x7f0a0068);
        if (activityFeedView != null) {
            activityFeedView.setAvatar(avatarUrl);
        }
        ActivityFeedView activityFeedView2 = (ActivityFeedView) _$_findCachedViewById(R.id.getAuthRequestContext_res_0x7f0a0068);
        if (activityFeedView2 != null) {
            String string = getResources().getString(R.string.lookAheadTest);
            Intrinsics.checkNotNullExpressionValue(string, "");
            activityFeedView2.setName(string, userName);
        }
    }

    public final void setCaption(Spannable textSpan) {
        TextView textView;
        Intrinsics.checkNotNullParameter(textSpan, "");
        View _$_findCachedViewById = _$_findCachedViewById(R.id.onCollectWhenDestroy);
        if (_$_findCachedViewById == null || (textView = (TextView) _$_findCachedViewById.findViewById(R.id.In)) == null) {
            return;
        }
        textView.setText(textSpan);
        ClickableMovementMethod.Companion companion = ClickableMovementMethod.INSTANCE;
        textView.setMovementMethod(ClickableMovementMethod.Companion.MyBillsEntityDataFactory());
        textView.setClickable(false);
        textView.setLongClickable(false);
    }

    public final void setCaption(String caption) {
        TextView textView;
        ActivityFeedView activityFeedView = (ActivityFeedView) _$_findCachedViewById(R.id.getAuthRequestContext_res_0x7f0a0068);
        if (activityFeedView == null || (textView = (TextView) activityFeedView._$_findCachedViewById(R.id.res_0x7f0a13f2_daggerreferraltrackercomponent_referraltrackercomponentimpl_providepushverifytrackerprovider)) == null) {
            return;
        }
        FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
        if (caption == null) {
            caption = "";
        }
        FeedsContentUtils.KClassImpl$Data$declaredNonStaticMembers$2(textView, caption);
    }

    public final void enableShareToFeed() {
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) _$_findCachedViewById(R.id.ConcurrentKt);
        if (appCompatCheckBox != null) {
            appCompatCheckBox.setChecked(true);
        }
        setShareFeedConsent(true);
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            ((SummaryActivity) baseActivity).getSendMoneySummaryPresenter().MyBillsEntityDataFactory(SummaryActivity.CHECKED);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.getStackFromEnd_res_0x7f0a037c);
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(R.drawable.bg_rounded_8dp_blue10);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.summary.SummaryActivity");
    }

    public final void disableShareToFeed() {
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) _$_findCachedViewById(R.id.ConcurrentKt);
        if (appCompatCheckBox != null) {
            appCompatCheckBox.setChecked(false);
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            ((SummaryActivity) baseActivity).getSendMoneySummaryPresenter().MyBillsEntityDataFactory("false");
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.getStackFromEnd_res_0x7f0a037c);
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(R.drawable.bg_rounded_8dp_grey10);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.summary.SummaryActivity");
    }

    public final void renderShareFeed() {
        ActivityFeedView activityFeedView = (ActivityFeedView) _$_findCachedViewById(R.id.getAuthRequestContext_res_0x7f0a0068);
        if (activityFeedView != null) {
            activityFeedView.setVisibility(8);
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.onCollectWhenDestroy);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(0);
        }
        CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.getSendMoneyEstimationTimeValue);
        if (circleImageView != null) {
            circleImageView.setVisibility(0);
        }
    }

    /* renamed from: $r8$lambda$a70IZe9zqF-z8dZrSpFiylFDZQs  reason: not valid java name */
    public static /* synthetic */ void m2932$r8$lambda$a70IZe9zqFz8dZrSpFiylFDZQs(NewShareToFeedsView newShareToFeedsView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(newShareToFeedsView, "");
        if (newShareToFeedsView.getIsShareFeedFeatureEnabled()) {
            if (z && !newShareToFeedsView.getShareFeedConsent()) {
                ((MaterialDialog) newShareToFeedsView.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).show();
            } else if (z) {
                newShareToFeedsView.enableShareToFeed();
            } else {
                newShareToFeedsView.disableShareToFeed();
            }
        }
    }

    public static final /* synthetic */ SummaryActivity access$getSummaryActivity(NewShareToFeedsView newShareToFeedsView) {
        BaseActivity baseActivity = newShareToFeedsView.getBaseActivity();
        if (baseActivity != null) {
            return (SummaryActivity) baseActivity;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.summary.SummaryActivity");
    }

    public final void renderFeedRevamp() {
        ActivityFeedView activityFeedView = (ActivityFeedView) _$_findCachedViewById(R.id.getAuthRequestContext_res_0x7f0a0068);
        if (activityFeedView != null) {
            activityFeedView.setupActivityFeed(false, false, false, false, false, false);
            String string = activityFeedView.getContext().getString(R.string.share_activity_send_money);
            Intrinsics.checkNotNullExpressionValue(string, "");
            BaseActivity baseActivity = activityFeedView.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            activityFeedView.setContent(new FeedRegexData(null, string, null, null, baseActivity, null, 45, null));
        }
        ActivityFeedView activityFeedView2 = (ActivityFeedView) _$_findCachedViewById(R.id.getAuthRequestContext_res_0x7f0a0068);
        if (activityFeedView2 != null) {
            activityFeedView2.setVisibility(0);
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.onCollectWhenDestroy);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(8);
        }
        CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.getSendMoneyEstimationTimeValue);
        if (circleImageView != null) {
            circleImageView.setVisibility(8);
        }
    }
}
