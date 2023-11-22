package id.dana.social.contract.friendsfeeds;

import androidx.view.Observer;
import androidx.work.WorkInfo;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.FeedStatus;
import id.dana.domain.social.model.InitFeed;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.feeds.domain.activation.interactor.GetCachedInitAndFeedStatus;
import id.dana.feeds.domain.activation.interactor.InitSocialFeed;
import id.dana.feeds.domain.activation.interactor.ObserveInitFeed;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.notification.interactor.FetchFeedNotificationCount;
import id.dana.feeds.domain.profile.interactor.GetMyFeedsHeaderInfo;
import id.dana.feeds.domain.profile.model.MyFeedsHeaderInfo;
import id.dana.feeds.domain.share.interactor.CheckPendingShareFeedDialog;
import id.dana.feeds.domain.share.interactor.CreateFeedActivity;
import id.dana.feeds.domain.share.interactor.DeleteFeedActivity;
import id.dana.feeds.domain.share.interactor.DeleteLastShareFeedRequest;
import id.dana.feeds.domain.share.interactor.FetchShareableActivities;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SkipShareableActivity;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.share.model.ShareFeedActivity;
import id.dana.feeds.domain.share.model.ShareableActivities;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.interactor.GetTimeline;
import id.dana.feeds.domain.timeline.interactor.GetTimelineWithTopFriends;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.feeds.domain.timeline.model.SocialFeedWithTopFriends;
import id.dana.feeds.ui.model.CreateFeedActivityRequestModel;
import id.dana.feeds.ui.model.CreateFeedActivityRequestModelKt;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.feeds.ui.tracker.FeedsDisplayedErrorOperationType;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.social.FeedUserConfigHelper;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;
import id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.model.mapper.FeedModelMapper;
import id.dana.social.model.mapper.GroupedFeedMapper;
import id.dana.social.utils.FeedsContentAction;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001BÒ\u0002\b\u0007\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020n00\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020T00\u0012\f\u0010p\u001a\b\u0012\u0004\u0012\u00020V00\u0012\f\u0010q\u001a\b\u0012\u0004\u0012\u00020;00\u0012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020=00\u0012\f\u0010s\u001a\b\u0012\u0004\u0012\u00020Z00\u0012\f\u0010t\u001a\b\u0012\u0004\u0012\u00020C00\u0012\f\u0010u\u001a\b\u0012\u0004\u0012\u00020N00\u0012\f\u0010v\u001a\b\u0012\u0004\u0012\u00020_00\u0012\f\u0010w\u001a\b\u0012\u0004\u0012\u00020P00\u0012\f\u0010x\u001a\b\u0012\u0004\u0012\u00020D00\u0012\f\u0010y\u001a\b\u0012\u0004\u0012\u00020X00\u0012\f\u0010z\u001a\b\u0012\u0004\u0012\u00020600\u0012\f\u0010{\u001a\b\u0012\u0004\u0012\u00020R00\u0012\f\u0010|\u001a\b\u0012\u0004\u0012\u00020h00\u0012\f\u0010}\u001a\b\u0012\u0004\u0012\u00020900\u0012\f\u0010~\u001a\b\u0012\u0004\u0012\u00020:00\u0012\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020100\u0012\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020L00\u0012\r\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020I00\u0012\r\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020k00\u0012\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020?00\u0012\r\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020J00¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\fH\u0016¢\u0006\u0004\b\n\u0010\u000eJ%\u0010\r\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0010J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\fH\u0016¢\u0006\u0004\b\b\u0010\u000eJ\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\n\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J;\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u001e\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016¢\u0006\u0004\b\u0003\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010 J\u000f\u0010!\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010#J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010#J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060(j\u0002`)¢\u0006\u0004\b\b\u0010*J\u000f\u0010+\u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020,H\u0016¢\u0006\u0004\b\n\u0010-J\u000f\u0010.\u001a\u00020\u0002H\u0000¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u000201008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010\n\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u00105R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u000206008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00103R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\tX\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u00107R\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00108R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u000209008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u00103R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020:008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u00103R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020;008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00103R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020=008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00103R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020?008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00103R\u0012\u00102\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010BR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020C008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u00103R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020D008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u00103R\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020G0FX\u0086\"¢\u0006\u0006\n\u0004\b\u0013\u0010HR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020I008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u00103R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020J008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u00103R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020L008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u00103R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020N008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u00103R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020P008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u00103R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020R008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u00103R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020T008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u00103R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020V008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u00103R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020X008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u00103R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020Z008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u00103R\u0012\u0010\u0019\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010BR\u001a\u0010Q\u001a\u00020\\8\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u0003\u0010]\u001a\u0004\bA\u0010^R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020_008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b`\u00103R\u001a\u0010S\u001a\u00020\u00058\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0015\u0010B\u001a\u0004\b2\u0010#R\u001a\u0010K\u001a\u00020\u00058\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0014\u0010B\u001a\u0004\b<\u0010#R\u001a\u0010O\u001a\u00020\u00058\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0016\u0010B\u001a\u0004\bE\u0010#R\u0012\u0010W\u001a\u00020\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0018\u00108R\u001e\u0010[\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010U\u001a\b\u0012\u0004\u0012\u00020G0aX\u0081\"¢\u0006\u0006\n\u0004\bA\u0010dR \u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00020e@\u0017X\u0097\n¢\u0006\f\n\u0004\b\u001f\u0010f\"\u0004\b\b\u0010gR\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020h008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bi\u00103R\u0012\u0010j\u001a\u00020\u0005X\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010BR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020k008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bj\u00103R\u001e\u0010m\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010dR\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020n008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u00103"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendsFeedsPresenter;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$Presenter;", "", "PlaceComponentResult", "()V", "", "p0", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;", "MyBillsEntityDataFactory", "(Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Ljava/util/HashMap;", "(Ljava/util/HashMap;)V", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthRequestContext", "scheduleImpl", "getErrorConfigVersion", "lookAheadTest", "()Ljava/lang/String;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lkotlin/Function1;", "Landroidx/lifecycle/Observer;", "", "Landroidx/work/WorkInfo;", "(Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/Observer;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "(ZZ)V", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Z", "DatabaseTableConfigUtil", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "onDestroy", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "(Lid/dana/feeds/domain/share/model/PreviewActivityData;)V", "NetworkUserEntityData$$ExternalSyntheticLambda3", "PrepareContext", "Ldagger/Lazy;", "Lid/dana/feeds/domain/share/interactor/CheckPendingShareFeedDialog;", "GetContactSyncConfig", "Ldagger/Lazy;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "Lid/dana/feeds/domain/share/interactor/CreateFeedActivity;", "Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;", "Ljava/lang/String;", "Lid/dana/feeds/domain/share/interactor/DeleteFeedActivity;", "Lid/dana/feeds/domain/share/interactor/DeleteLastShareFeedRequest;", "Lid/dana/social/model/mapper/FeedMapper;", "isLayoutRequested", "Lid/dana/social/model/mapper/FeedModelMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/social/FeedUserConfigHelper;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "Lid/dana/social/utils/FeedsContentAction;", "Lid/dana/feeds/domain/notification/interactor/FetchFeedNotificationCount;", "FragmentBottomSheetPaymentSettingBinding", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/domain/core/usecase/NoParams;", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/feeds/domain/share/interactor/FetchShareableActivities;", "Lid/dana/feeds/domain/activation/interactor/GetCachedInitAndFeedStatus;", "getCallingPid", "Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "SubSequence", "Lid/dana/feeds/domain/activation/interactor/ObserveInitFeed;", "getSupportButtonTintMode", "Lid/dana/feeds/domain/profile/interactor/GetMyFeedsHeaderInfo;", "whenAvailable", "Lid/dana/feeds/domain/share/interactor/GetShareFeedConsent;", "readMicros", "Lid/dana/feeds/domain/timeline/interactor/GetTimeline;", "C", "Lid/dana/feeds/domain/timeline/interactor/GetTimelineWithTopFriends;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/domain/user/interactor/GetUserInfo;", "A", "Lid/dana/social/model/mapper/GroupedFeedMapper;", DiskFormatter.B, "Lid/dana/domain/social/model/InitFeed;", "Lid/dana/domain/social/model/InitFeed;", "()Lid/dana/domain/social/model/InitFeed;", "Lid/dana/feeds/domain/activation/interactor/InitSocialFeed;", "VerifyPinStateManager$executeRiskChallenge$2$1", "Lid/dana/domain/DefaultObserver;", "Lid/dana/feeds/domain/profile/model/MyFeedsHeaderInfo;", "E", "Lid/dana/domain/DefaultObserver;", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "Lid/dana/feeds/domain/share/interactor/SaveShareFeedConsent;", "getOnBoardingScenario", "getValueOfTouchPositionAbsolute", "Lid/dana/feeds/domain/share/interactor/SkipShareableActivity;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "VerifyPinStateManager$executeRiskChallenge$2$2", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$View;", SummaryActivity.DAYS, "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendsFeedsPresenter implements FriendFeedsContract.Presenter {

    /* renamed from: A  reason: from kotlin metadata */
    private final Lazy<GetUserInfo> NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: B */
    private final Lazy<GroupedFeedMapper> NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private final Lazy<GetTimelineWithTopFriends> NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    CreateFeedActivityRequestModel PlaceComponentResult;

    /* renamed from: C  reason: from kotlin metadata */
    private final Lazy<GetTimeline> FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    final Lazy<FriendFeedsContract.View> id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;

    /* renamed from: E  reason: from kotlin metadata */
    private DefaultObserver<MyFeedsHeaderInfo> com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final Lazy<FetchFeedNotificationCount> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy<CheckPendingShareFeedDialog> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    boolean NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public DefaultObserver<NoParams> C;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    Function0<Unit> A;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final CoroutineScope MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy<FetchShareableActivities> initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final Lazy<FeedsContentAction> DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final Lazy<FeedModelMapper> moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy<FeedUserConfigHelper> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy<DeleteFeedActivity> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    InitFeed whenAvailable;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy<CreateFeedActivity> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private final Lazy<GetFeedConfig> PrepareContext;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private final Lazy<InitSocialFeed> SubSequence;
    private DefaultObserver<SocialFeed> VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public PublishSubject<NoParams> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final Lazy<GetCachedInitAndFeedStatus> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    boolean readMicros;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private final Lazy<SaveShareFeedConsent> VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private final Lazy<ObserveInitFeed> newProxyInstance;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private final Lazy<SkipShareableActivity> getOnBoardingScenario;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    boolean getValueOfTouchPositionAbsolute;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final Lazy<FeedMapper> getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    boolean getSupportButtonTintMode;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    String BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final Lazy<DeleteLastShareFeedRequest> scheduleImpl;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final Lazy<GetShareFeedConsent> isLayoutRequested;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    boolean getCallingPid;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy<GetMyFeedsHeaderInfo> NetworkUserEntityData$$ExternalSyntheticLambda8;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[FeedUserConfigHelper.FeedUserConfigFetchingState.values().length];
            iArr[FeedUserConfigHelper.FeedUserConfigFetchingState.FETCHED.ordinal()] = 1;
            iArr[FeedUserConfigHelper.FeedUserConfigFetchingState.ERROR_REACH_LIMIT.ordinal()] = 2;
            iArr[FeedUserConfigHelper.FeedUserConfigFetchingState.ERROR.ordinal()] = 3;
            iArr[FeedUserConfigHelper.FeedUserConfigFetchingState.LOADING.ordinal()] = 4;
            getAuthRequestContext = iArr;
            int[] iArr2 = new int[InitStatus.values().length];
            iArr2[InitStatus.FINISH.ordinal()] = 1;
            iArr2[InitStatus.INIT.ordinal()] = 2;
            iArr2[InitStatus.NOT_ACTIVATED.ordinal()] = 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr2;
        }
    }

    @Inject
    public FriendsFeedsPresenter(Lazy<FriendFeedsContract.View> lazy, Lazy<GetTimeline> lazy2, Lazy<GetTimelineWithTopFriends> lazy3, Lazy<FeedMapper> lazy4, Lazy<FeedModelMapper> lazy5, Lazy<GroupedFeedMapper> lazy6, Lazy<FeedsContentAction> lazy7, Lazy<ObserveInitFeed> lazy8, Lazy<InitSocialFeed> lazy9, Lazy<GetMyFeedsHeaderInfo> lazy10, Lazy<FetchFeedNotificationCount> lazy11, Lazy<GetUserInfo> lazy12, Lazy<CreateFeedActivity> lazy13, Lazy<GetShareFeedConsent> lazy14, Lazy<SaveShareFeedConsent> lazy15, Lazy<DeleteFeedActivity> lazy16, Lazy<DeleteLastShareFeedRequest> lazy17, Lazy<CheckPendingShareFeedDialog> lazy18, Lazy<GetFeedConfig> lazy19, Lazy<FetchShareableActivities> lazy20, Lazy<SkipShareableActivity> lazy21, Lazy<FeedUserConfigHelper> lazy22, Lazy<GetCachedInitAndFeedStatus> lazy23) {
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
        this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = lazy;
        this.FragmentBottomSheetPaymentSettingBinding = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = lazy3;
        this.getErrorConfigVersion = lazy4;
        this.moveToNextValue = lazy5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = lazy6;
        this.DatabaseTableConfigUtil = lazy7;
        this.newProxyInstance = lazy8;
        this.SubSequence = lazy9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = lazy12;
        this.BuiltInFictitiousFunctionClassFactory = lazy13;
        this.isLayoutRequested = lazy14;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = lazy15;
        this.lookAheadTest = lazy16;
        this.scheduleImpl = lazy17;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy18;
        this.PrepareContext = lazy19;
        this.initRecordTimeStamp = lazy20;
        this.getOnBoardingScenario = lazy21;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy22;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy23;
        this.getAuthRequestContext = "";
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        this.A = new Function0<Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$onFeedInitializing$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.whenAvailable = new InitFeed(InitStatus.NOT_ACTIVATED, 0, null, false, 14, null);
        this.MyBillsEntityDataFactory = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        PublishSubject<NoParams> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult;
        DefaultObserver<NoParams> defaultObserver = null;
        if (PlaceComponentResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            PlaceComponentResult = null;
        }
        Observable<NoParams> observeOn = PlaceComponentResult.debounce(1000L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult());
        DefaultObserver<NoParams> defaultObserver2 = new DefaultObserver<NoParams>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getNotificationCountObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Intrinsics.checkNotNullParameter((NoParams) obj, "");
                FriendsFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda4();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                StringBuilder sb = new StringBuilder();
                sb.append("[FeedNotification] onError:  ");
                sb.append(p0.getLocalizedMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FEED_NOTIFICATION, sb.toString());
            }
        };
        Intrinsics.checkNotNullParameter(defaultObserver2, "");
        this.C = defaultObserver2;
        if (defaultObserver2 != null) {
            defaultObserver = defaultObserver2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        observeOn.subscribe(defaultObserver);
    }

    @JvmName(name = "FragmentBottomSheetPaymentSettingBinding")
    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from getter */
    public final boolean getGetSupportButtonTintMode() {
        return this.getSupportButtonTintMode;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.A = function0;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
    public final InitFeed getWhenAvailable() {
        return this.whenAvailable;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    @JvmName(name = "GetContactSyncConfig")
    /* renamed from: GetContactSyncConfig  reason: from getter */
    public final boolean getReadMicros() {
        return this.readMicros;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    @JvmName(name = "isLayoutRequested")
    /* renamed from: isLayoutRequested  reason: from getter */
    public final boolean getGetCallingPid() {
        return this.getCallingPid;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void scheduleImpl() {
        Completable BuiltInFictitiousFunctionClassFactory = Completable.BuiltInFictitiousFunctionClassFactory(3000L, TimeUnit.MILLISECONDS);
        Action action = new Action() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                FriendsFeedsPresenter.PlaceComponentResult(FriendsFeedsPresenter.this);
            }
        };
        Consumer<? super Disposable> PlaceComponentResult = Functions.PlaceComponentResult();
        Consumer<? super Throwable> PlaceComponentResult2 = Functions.PlaceComponentResult();
        Action action2 = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, PlaceComponentResult2, action, action2, action2, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
        Scheduler PlaceComponentResult3 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult3, "scheduler is null");
        RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult3)).q_();
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().getAuthRequestContext.subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new DefaultObserver<InitFeed>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$initFeedObservable$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                InitFeed initFeed = (InitFeed) obj;
                Intrinsics.checkNotNullParameter(initFeed, "");
                FriendsFeedsPresenter friendsFeedsPresenter = FriendsFeedsPresenter.this;
                Intrinsics.checkNotNullParameter(initFeed, "");
                Intrinsics.checkNotNullParameter(initFeed, "");
                friendsFeedsPresenter.whenAvailable = initFeed;
                int i = FriendsFeedsPresenter.WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[initFeed.getStatus().ordinal()];
                if (i == 1) {
                    friendsFeedsPresenter.A.invoke();
                    friendsFeedsPresenter.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.InitFeedFinished.INSTANCE);
                } else if (i == 2) {
                    friendsFeedsPresenter.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.InitFeedLoading.INSTANCE);
                } else if (i == 3) {
                    friendsFeedsPresenter.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.InitFeedNotActivated.INSTANCE);
                } else {
                    friendsFeedsPresenter.KClassImpl$Data$declaredNonStaticMembers$2(initFeed.getError());
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FriendsFeedsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2(new Exception(p0));
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.newProxyInstance.get().getGetAuthRequestContext();
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        this.getSupportButtonTintMode = false;
        this.getErrorConfigVersion.get().BuiltInFictitiousFunctionClassFactory = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().BuiltInFictitiousFunctionClassFactory = "";
        MyBillsEntityDataFactory(true, true);
        MyBillsEntityDataFactory();
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final Observer<List<WorkInfo>> PlaceComponentResult(final Function1<? super Observer<List<WorkInfo>>, Unit> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return (Observer) new Observer<List<? extends WorkInfo>>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getFullSyncObserver$1

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] PlaceComponentResult;

                static {
                    int[] iArr = new int[WorkInfo.State.values().length];
                    iArr[WorkInfo.State.BLOCKED.ordinal()] = 1;
                    iArr[WorkInfo.State.ENQUEUED.ordinal()] = 2;
                    iArr[WorkInfo.State.RUNNING.ordinal()] = 3;
                    iArr[WorkInfo.State.FAILED.ordinal()] = 4;
                    iArr[WorkInfo.State.CANCELLED.ordinal()] = 5;
                    PlaceComponentResult = iArr;
                }
            }

            @Override // androidx.view.Observer
            public final /* synthetic */ void onChanged(List<? extends WorkInfo> list) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                List<? extends WorkInfo> list2 = list;
                if (list2 != null) {
                    try {
                        WorkInfo workInfo = (WorkInfo) CollectionsKt.firstOrNull((List) list2);
                        if (workInfo != null) {
                            Function1<Observer<List<WorkInfo>>, Unit> function1 = p0;
                            FriendsFeedsPresenter friendsFeedsPresenter = FriendsFeedsPresenter.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append("State: ");
                            sb.append(workInfo.KClassImpl$Data$declaredNonStaticMembers$2);
                            sb.append(", ");
                            sb.append(workInfo.MyBillsEntityDataFactory);
                            DanaLog.getAuthRequestContext("Feeds_SyncContact", sb.toString());
                            if (!workInfo.MyBillsEntityDataFactory.getAuthRequestContext("All_CONTACT_SYNCHED") && workInfo.KClassImpl$Data$declaredNonStaticMembers$2 != WorkInfo.State.SUCCEEDED) {
                                int i = WhenMappings.PlaceComponentResult[workInfo.KClassImpl$Data$declaredNonStaticMembers$2.ordinal()];
                                if (i == 1 || i == 2 || i == 3) {
                                    lazy3 = friendsFeedsPresenter.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                                    ((FriendFeedsContract.View) lazy3.get()).BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.FeedSyncing.INSTANCE);
                                    return;
                                } else if (i == 4 || i == 5) {
                                    function1.invoke(this);
                                    friendsFeedsPresenter.MyBillsEntityDataFactory(false, false);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            function1.invoke(this);
                            lazy2 = friendsFeedsPresenter.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                            ((FriendFeedsContract.View) lazy2.get()).BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.FeedSynced.INSTANCE);
                            friendsFeedsPresenter.MyBillsEntityDataFactory(false, false);
                        }
                    } catch (Exception e) {
                        lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                        ((FriendFeedsContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(new FriendFeedsContract.State.FeedEmpty(false));
                    }
                }
            }
        };
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.get().execute(new GetUserInfo.Param(false), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$checkUsername$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                if (userInfoResponse.getUsername().length() == 0) {
                    lazy2 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy2.get()).BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.UsernameBannerDisplayed.INSTANCE);
                    return;
                }
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.UsernameBannerHidden.INSTANCE);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$checkUsername$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                String message = th.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, message != null ? message : "", th);
            }
        });
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Exception p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        InitFeed initFeed = new InitFeed(InitStatus.ERROR, 0, null, false, 14, null);
        Intrinsics.checkNotNullParameter(initFeed, "");
        this.whenAvailable = initFeed;
        this.newProxyInstance.get().dispose();
        this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.InitFeedError.INSTANCE);
        this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().KClassImpl$Data$declaredNonStaticMembers$2(p0, FeedsDisplayedErrorOperationType.INIT_FEED, this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().KClassImpl$Data$declaredNonStaticMembers$2(), TrackerDataKey.Event.SYNC_CONTACT);
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(ObserveInitFeed.class, getClass(), String.valueOf(p0.getCause())));
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    /* renamed from: lookAheadTest  reason: from getter */
    public final String getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void MyBillsEntityDataFactory(final boolean p0, final boolean p1) {
        this.getSupportButtonTintMode = false;
        DefaultObserver<SocialFeed> defaultObserver = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (defaultObserver != null) {
            defaultObserver.dispose();
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = null;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        this.getErrorConfigVersion.get().BuiltInFictitiousFunctionClassFactory = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().execute(new GetTimelineWithTopFriends.Params(p1), new Function1<SocialFeedWithTopFriends, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getTopFriendsWithTimeline$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SocialFeedWithTopFriends socialFeedWithTopFriends) {
                invoke2(socialFeedWithTopFriends);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SocialFeedWithTopFriends socialFeedWithTopFriends) {
                Lazy lazy;
                Lazy lazy2;
                Lazy lazy3;
                Lazy lazy4;
                Lazy lazy5;
                Lazy lazy6;
                Intrinsics.checkNotNullParameter(socialFeedWithTopFriends, "");
                FriendsFeedsPresenter.this.getAuthRequestContext = socialFeedWithTopFriends.getUserId();
                FriendsFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda4 = socialFeedWithTopFriends.getSocialFeed().getHasMore();
                FriendsFeedsPresenter friendsFeedsPresenter = FriendsFeedsPresenter.this;
                String maxId = socialFeedWithTopFriends.getSocialFeed().getMaxId();
                Intrinsics.checkNotNullParameter(maxId, "");
                friendsFeedsPresenter.BottomSheetCardBindingView$watcherCardNumberView$1 = maxId;
                lazy = FriendsFeedsPresenter.this.getErrorConfigVersion;
                ((FeedMapper) lazy.get()).BuiltInFictitiousFunctionClassFactory = "";
                FriendsFeedsPresenter.this.getSupportButtonTintMode = !r0.getGetSupportButtonTintMode();
                List BuiltInFictitiousFunctionClassFactory = FriendsFeedsPresenter.BuiltInFictitiousFunctionClassFactory(FriendsFeedsPresenter.this, socialFeedWithTopFriends.getSocialFeed());
                if (!BuiltInFictitiousFunctionClassFactory.isEmpty() && !socialFeedWithTopFriends.getTopFriends().isEmpty()) {
                    lazy4 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    FriendFeedsContract.View view = (FriendFeedsContract.View) lazy4.get();
                    lazy5 = FriendsFeedsPresenter.this.getErrorConfigVersion;
                    FeedMapper feedMapper = (FeedMapper) lazy5.get();
                    view.BuiltInFictitiousFunctionClassFactory(new FriendFeedsContract.State.TopFriendSuccess(FeedMapper.PlaceComponentResult(socialFeedWithTopFriends.getTopFriends())));
                    lazy6 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy6.get()).BuiltInFictitiousFunctionClassFactory(new FriendFeedsContract.State.TimelineSuccess(BuiltInFictitiousFunctionClassFactory));
                } else if (p0 && !socialFeedWithTopFriends.getSocialFeed().getFromCache()) {
                    lazy3 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy3.get()).BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.ObserveSyncContact.INSTANCE);
                } else if (socialFeedWithTopFriends.getSocialFeed().getFromCache()) {
                } else {
                    lazy2 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy2.get()).BuiltInFictitiousFunctionClassFactory(new FriendFeedsContract.State.FeedEmpty(p1));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getTopFriendsWithTimeline$2
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
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(new FriendFeedsContract.State.TopFriendError(p1));
            }
        });
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.DatabaseTableConfigUtil.get().getAuthRequestContext(p0);
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(HashMap<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.DatabaseTableConfigUtil.get().KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.DatabaseTableConfigUtil.get().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    @Override // id.dana.social.contract.BaseSocialFeedContract.Presenter
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda4() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda4;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().executeJava1(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getFeedNotificationCount$1
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
                Lazy lazy;
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).MyBillsEntityDataFactory(i);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getFeedNotificationCount$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("[FeedNotification] onError:  ");
                sb.append(th.getLocalizedMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.FEED_NOTIFICATION, sb.toString());
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                return ((FriendFeedsContract.View) lazy.get()).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().getAuthRequestContext());
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        CreateFeedActivityRequestModel createFeedActivityRequestModel = this.PlaceComponentResult;
        if (createFeedActivityRequestModel != null) {
            final CreateFeedActivity.Params KClassImpl$Data$declaredNonStaticMembers$2 = CreateFeedActivityRequestModelKt.KClassImpl$Data$declaredNonStaticMembers$2(createFeedActivityRequestModel);
            if (!createFeedActivityRequestModel.getLookAheadTest()) {
                this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().PlaceComponentResult(createFeedActivityRequestModel);
            }
            this.BuiltInFictitiousFunctionClassFactory.get().executeJava1(KClassImpl$Data$declaredNonStaticMembers$2, new Function1<ActivityResponse, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$submitShareFeedActivity$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ActivityResponse activityResponse) {
                    invoke2(activityResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ActivityResponse activityResponse) {
                    Lazy lazy;
                    Lazy lazy2;
                    Lazy lazy3;
                    Lazy lazy4;
                    CoroutineScope coroutineScope;
                    Intrinsics.checkNotNullParameter(activityResponse, "");
                    FriendsFeedsPresenter.this.PlaceComponentResult = null;
                    lazy = FriendsFeedsPresenter.this.moveToNextValue;
                    FeedModel PlaceComponentResult = ((FeedModelMapper) lazy.get()).PlaceComponentResult(new Date(), activityResponse);
                    if (activityResponse.getState() == FeedActivityState.SUCCESS) {
                        lazy4 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                        ((FriendFeedsContract.View) lazy4.get()).KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
                        coroutineScope = FriendsFeedsPresenter.this.MyBillsEntityDataFactory;
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(FriendsFeedsPresenter.this, null), 3, null);
                    } else {
                        lazy2 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                        FriendFeedsContract.View view = (FriendFeedsContract.View) lazy2.get();
                        FeedModel.Companion companion = FeedModel.INSTANCE;
                        view.BuiltInFictitiousFunctionClassFactory(FeedModel.Companion.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue));
                    }
                    if (activityResponse.isSubmitFeedBanner()) {
                        lazy3 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                        ((FriendFeedsContract.View) lazy3.get()).MyBillsEntityDataFactory();
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                @DebugMetadata(c = "id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$submitShareFeedActivity$1$1$1", f = "FriendsFeedsPresenter.kt", i = {}, l = {482}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$submitShareFeedActivity$1$1$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ FriendsFeedsPresenter this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(FriendsFeedsPresenter friendsFeedsPresenter, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = friendsFeedsPresenter;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda7();
                        return Unit.INSTANCE;
                    }
                }
            }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$submitShareFeedActivity$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Throwable th) {
                    Lazy lazy;
                    Lazy lazy2;
                    Lazy lazy3;
                    Intrinsics.checkNotNullParameter(th, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CREATE_FEED_ACTIVITY, th.getLocalizedMessage(), th);
                    lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    FriendFeedsContract.View view = (FriendFeedsContract.View) lazy.get();
                    FeedModel.Companion companion = FeedModel.INSTANCE;
                    view.BuiltInFictitiousFunctionClassFactory(FeedModel.Companion.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue));
                    lazy2 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy2.get()).MyBillsEntityDataFactory();
                    lazy3 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    return ((FriendFeedsContract.View) lazy3.get()).KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }, this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().getAuthRequestContext());
        }
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void MyBillsEntityDataFactory(CreateFeedActivityRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult = p0;
        this.isLayoutRequested.get().execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$checkShareFeedConsent$1
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
                FriendsFeedsPresenter.this.getValueOfTouchPositionAbsolute = z;
                if (!z) {
                    lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                FriendsFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda3();
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$checkShareFeedConsent$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CREATE_FEED_ACTIVITY, exc.getLocalizedMessage(), exc);
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void getAuthRequestContext() {
        this.VerifyPinStateManager$executeRiskChallenge$2$1.get().execute(Boolean.TRUE, new Function1<Unit, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$enableShareFeedConsent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
                FriendsFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda3();
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$enableShareFeedConsent$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CREATE_FEED_ACTIVITY, exc.getLocalizedMessage(), exc);
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.lookAheadTest.get().execute(new DeleteFeedActivity.Params(p0), new Function0<Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$deleteActivity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).MyBillsEntityDataFactory(p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$deleteActivity$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DELETE_FEED_ACTIVITY, th.getLocalizedMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DeleteLastShareFeedRequest deleteLastShareFeedRequest = this.scheduleImpl.get();
        Intrinsics.checkNotNullExpressionValue(deleteLastShareFeedRequest, "");
        CompletableUseCase.execute$default(deleteLastShareFeedRequest, p0, null, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$deleteShareFeedRequest$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SHARE_FEED_ACTIVITY, th.getLocalizedMessage(), th);
            }
        }, 2, null);
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(Unit.INSTANCE, new Function1<ShareFeedActivity, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$checkPendingShareFeedDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ShareFeedActivity shareFeedActivity) {
                invoke2(shareFeedActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ShareFeedActivity shareFeedActivity) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(shareFeedActivity, "");
                if (shareFeedActivity.isShareFeedActivityValid()) {
                    lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy.get()).PlaceComponentResult(shareFeedActivity);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$checkPendingShareFeedDialog$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SHARE_FEED_ACTIVITY, th.getLocalizedMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void moveToNextValue() {
        this.PrepareContext.get().execute(NoParams.INSTANCE, new Function1<FeedConfig, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getFeedConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FeedConfig feedConfig) {
                invoke2(feedConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FeedConfig feedConfig) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(feedConfig, "");
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).PlaceComponentResult(feedConfig);
                if (feedConfig.isFeedNotificationEnabled()) {
                    FriendsFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda4();
                }
                if (feedConfig.isCreateActivityEnabled() && feedConfig.getShareActivity().getFeedOnlineMerchantBanner()) {
                    lazy2 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy2.get()).BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.UsernameBannerHidden.INSTANCE);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getFeedConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_FEED_CONFIG, th.getLocalizedMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().PlaceComponentResult = p0;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void PlaceComponentResult() {
        GetCachedInitAndFeedStatus getCachedInitAndFeedStatus = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
        Intrinsics.checkNotNullExpressionValue(getCachedInitAndFeedStatus, "");
        BaseUseCase.execute$default(getCachedInitAndFeedStatus, NoParams.INSTANCE, new Function1<FeedStatus, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$checkFirstTimeActivate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FeedStatus feedStatus) {
                invoke2(feedStatus);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FeedStatus feedStatus) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(feedStatus, "");
                FriendsFeedsPresenter.this.readMicros = feedStatus.getInitStatus() == null || !feedStatus.isInitStatusInitOrFinish();
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).scheduleImpl();
            }
        }, null, 4, null);
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void getErrorConfigVersion() {
        this.initRecordTimeStamp.get().executeJava1(NoParams.INSTANCE, new Function1<ShareableActivities, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$fetchShareableActivities$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ShareableActivities shareableActivities) {
                invoke2(shareableActivities);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ShareableActivities shareableActivities) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(shareableActivities, "");
                List<PreviewActivityData> shareableActivities2 = shareableActivities.getShareableActivities();
                if (!(shareableActivities2 == null || shareableActivities2.isEmpty())) {
                    lazy2 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    ((FriendFeedsContract.View) lazy2.get()).getAuthRequestContext(shareableActivities.getShareableActivities());
                    return;
                }
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).PlaceComponentResult();
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$fetchShareableActivities$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Lazy lazy;
                Lazy lazy2;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).PlaceComponentResult();
                lazy2 = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                return ((FriendFeedsContract.View) lazy2.get()).KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().getAuthRequestContext());
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void MyBillsEntityDataFactory(PreviewActivityData p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getOnBoardingScenario.get().execute(new SkipShareableActivity.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$skipShareableActivity$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$skipShareableActivity$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SKIP_SHAREABLE_ACTIVITY, th.getLocalizedMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void PlaceComponentResult(boolean p0) {
        if (!this.GetContactSyncConfig) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().KClassImpl$Data$declaredNonStaticMembers$2.subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new FriendsFeedsPresenter$createFeedUserConfigObserver$1(this));
            this.GetContactSyncConfig = true;
        }
        if (p0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().getAuthRequestContext(p0);
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.newProxyInstance.get().dispose();
        this.SubSequence.get().dispose();
        FeedsContentAction feedsContentAction = this.DatabaseTableConfigUtil.get();
        feedsContentAction.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        feedsContentAction.scheduleImpl.get().dispose();
        this.FragmentBottomSheetPaymentSettingBinding.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        DefaultObserver<NoParams> defaultObserver = this.C;
        if (defaultObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            defaultObserver = null;
        }
        defaultObserver.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.isLayoutRequested.get().dispose();
        this.VerifyPinStateManager$executeRiskChallenge$2$1.get().dispose();
        this.lookAheadTest.get().dispose();
        this.scheduleImpl.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.PrepareContext.get().dispose();
        CoroutineScopeKt.cancel$default(this.MyBillsEntityDataFactory, null, 1, null);
        this.initRecordTimeStamp.get().dispose();
        this.getOnBoardingScenario.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().dispose();
        new FriendsFeedsPresenter$createFeedUserConfigObserver$1(this).dispose();
        this.GetContactSyncConfig = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().BuiltInFictitiousFunctionClassFactory = "";
    }

    public static /* synthetic */ void PlaceComponentResult(FriendsFeedsPresenter friendsFeedsPresenter) {
        Intrinsics.checkNotNullParameter(friendsFeedsPresenter, "");
        friendsFeedsPresenter.MyBillsEntityDataFactory(false, false);
    }

    public static final /* synthetic */ List BuiltInFictitiousFunctionClassFactory(FriendsFeedsPresenter friendsFeedsPresenter, SocialFeed socialFeed) {
        if (socialFeed.isFeedNotVersionTwo()) {
            friendsFeedsPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3.get().KClassImpl$Data$declaredNonStaticMembers$2 = socialFeed.getFeedVersion() >= 5;
            GroupedFeedMapper groupedFeedMapper = friendsFeedsPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3.get();
            Intrinsics.checkNotNullExpressionValue(groupedFeedMapper, "");
            return GroupedFeedMapper.BuiltInFictitiousFunctionClassFactory(groupedFeedMapper, new Date(), socialFeed.getGroupedActivities(), false, null, 12);
        }
        friendsFeedsPresenter.getErrorConfigVersion.get().PlaceComponentResult = false;
        List<? extends FeedViewHolderModel> apply = friendsFeedsPresenter.getErrorConfigVersion.get().apply(socialFeed.getActivities());
        return apply == null ? CollectionsKt.emptyList() : apply;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        DefaultObserver<SocialFeed> defaultObserver = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        if (defaultObserver != null) {
            defaultObserver.dispose();
        }
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = null;
        this.FragmentBottomSheetPaymentSettingBinding.get().execute(new GetTimeline.Params(50, this.BottomSheetCardBindingView$watcherCardNumberView$1, null, CollectionsKt.emptyList()), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getTimeline$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SocialFeed socialFeed) {
                invoke2(socialFeed);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SocialFeed socialFeed) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(socialFeed, "");
                FriendsFeedsPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda4 = socialFeed.getHasMore();
                FriendsFeedsPresenter friendsFeedsPresenter = FriendsFeedsPresenter.this;
                String maxId = socialFeed.getMaxId();
                Intrinsics.checkNotNullParameter(maxId, "");
                friendsFeedsPresenter.BottomSheetCardBindingView$watcherCardNumberView$1 = maxId;
                List BuiltInFictitiousFunctionClassFactory = FriendsFeedsPresenter.BuiltInFictitiousFunctionClassFactory(FriendsFeedsPresenter.this, socialFeed);
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(new FriendFeedsContract.State.TimelineSuccess(BuiltInFictitiousFunctionClassFactory));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getTimeline$2
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
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                ((FriendFeedsContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(new FriendFeedsContract.State.TimelineError(FriendsFeedsPresenter.this.getGetSupportButtonTintMode()));
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void initRecordTimeStamp() {
        DefaultObserver<MyFeedsHeaderInfo> defaultObserver = this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String;
        if (defaultObserver != null) {
            defaultObserver.dispose();
        }
        this.com.alibaba.griver.image.photo.utils.DiskFormatter.B java.lang.String = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().execute(NoParams.INSTANCE, new Function1<MyFeedsHeaderInfo, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getUserInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MyFeedsHeaderInfo myFeedsHeaderInfo) {
                invoke2(myFeedsHeaderInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MyFeedsHeaderInfo myFeedsHeaderInfo) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(myFeedsHeaderInfo, "");
                FriendsFeedsPresenter.this.getAuthRequestContext = myFeedsHeaderInfo.getUserId();
                lazy = FriendsFeedsPresenter.this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                FriendFeedsContract.View view = (FriendFeedsContract.View) lazy.get();
                MyFeedHeaderModel.Companion companion = MyFeedHeaderModel.INSTANCE;
                view.BuiltInFictitiousFunctionClassFactory(MyFeedHeaderModel.Companion.MyBillsEntityDataFactory(myFeedsHeaderInfo));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$getUserInfo$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void DatabaseTableConfigUtil() {
        this.getCallingPid = true;
        this.SubSequence.get().execute(Unit.INSTANCE, new Function1<InitFeed, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$initFeedOneTime$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(InitFeed initFeed) {
                invoke2(initFeed);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(InitFeed initFeed) {
                Intrinsics.checkNotNullParameter(initFeed, "");
                FriendsFeedsPresenter.this.getCallingPid = false;
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter$initFeedOneTime$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(InitSocialFeed.class, FriendsFeedsPresenter.this.getClass(), String.valueOf(exc.getCause())));
                FriendsFeedsPresenter.this.getCallingPid = false;
            }
        });
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final boolean newProxyInstance() {
        return this.whenAvailable.getStatus() == InitStatus.FINISH;
    }

    @Override // id.dana.social.contract.friendsfeeds.FriendFeedsContract.Presenter
    public final void PrepareContext() {
        PublishSubject<NoParams> publishSubject = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (publishSubject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            publishSubject = null;
        }
        publishSubject.onNext(NoParams.INSTANCE);
    }
}
