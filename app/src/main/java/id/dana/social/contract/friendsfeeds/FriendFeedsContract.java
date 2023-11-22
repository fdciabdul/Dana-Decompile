package id.dana.social.contract.friendsfeeds;

import androidx.view.Observer;
import androidx.work.WorkInfo;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.InitFeed;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.share.model.ShareFeedActivity;
import id.dana.feeds.ui.model.CreateFeedActivityRequestModel;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.MyFeedHeaderModel;
import id.dana.social.contract.BaseSocialFeedContract;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract;", "", "Presenter", TrackerKey.Property.STATE, "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FriendFeedsContract {

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0004\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000eH&¢\u0006\u0004\b\f\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0012H&¢\u0006\u0004\b\f\u0010\u0013J\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0014H&¢\u0006\u0004\b\u0010\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H&¢\u0006\u0004\b\u0006\u0010\u0018J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0019H&¢\u0006\u0004\b\n\u0010\u001aJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u001bH&¢\u0006\u0004\b\f\u0010\u001cJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\rJ\u000f\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\rJ/\u0010\u0004\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010!J\u000f\u0010\"\u001a\u00020\tH&¢\u0006\u0004\b\"\u0010\rJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020#H&¢\u0006\u0004\b\n\u0010$ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$View;", "", "", "Lid/dana/utils/DisplayedErrorMessage;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/social/model/FeedModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/model/FeedModel;)V", "PlaceComponentResult", "()V", "Lid/dana/feeds/domain/share/model/ShareFeedActivity;", "(Lid/dana/feeds/domain/share/model/ShareFeedActivity;)V", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Lid/dana/domain/social/model/FeedConfig;", "(Lid/dana/domain/social/model/FeedConfig;)V", "", "(I)V", "", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "(Ljava/util/List;)V", "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "(Lid/dana/feeds/ui/model/MyFeedHeaderModel;)V", "Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;", "(Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;)V", "", "p1", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "scheduleImpl", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "(Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(MyFeedHeaderModel p0);

        void BuiltInFictitiousFunctionClassFactory(State p0);

        void BuiltInFictitiousFunctionClassFactory(FeedModel p0);

        String KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(FeedModel p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1, String p2, String p3);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(int p0);

        void MyBillsEntityDataFactory(String p0);

        void PlaceComponentResult();

        void PlaceComponentResult(FeedConfig p0);

        void PlaceComponentResult(ShareFeedActivity p0);

        void PlaceComponentResult(CreateFeedActivityRequestModel p0);

        String getAuthRequestContext();

        void getAuthRequestContext(List<PreviewActivityData> p0);

        void scheduleImpl();
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0011\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0011\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "", "<init>", "()V", "ErrorFetchUserConfig", "FeedEmpty", "FeedSynced", "FeedSyncing", "FinishFetchUserConfig", "InitFeedError", "InitFeedFinished", "InitFeedLoading", "InitFeedNotActivated", "LoadingFetchUserConfig", "ObserveSyncContact", "TimelineError", "TimelineSuccess", "TopFriendError", "TopFriendSuccess", "UsernameBannerDisplayed", "UsernameBannerHidden", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$TopFriendSuccess;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$TopFriendError;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$TimelineSuccess;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$TimelineError;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$InitFeedLoading;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$InitFeedFinished;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$InitFeedError;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$InitFeedNotActivated;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$LoadingFetchUserConfig;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$ErrorFetchUserConfig;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$FinishFetchUserConfig;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$FeedEmpty;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$FeedSyncing;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$FeedSynced;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$ObserveSyncContact;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$UsernameBannerDisplayed;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$UsernameBannerHidden;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class State {
        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$TopFriendSuccess;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/feeds/ui/model/FriendModel;", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class TopFriendSuccess extends State {

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            public final List<FriendModel> MyBillsEntityDataFactory;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof TopFriendSuccess) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((TopFriendSuccess) p0).MyBillsEntityDataFactory);
            }

            public final int hashCode() {
                return this.MyBillsEntityDataFactory.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("TopFriendSuccess(MyBillsEntityDataFactory=");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TopFriendSuccess(List<FriendModel> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "");
                this.MyBillsEntityDataFactory = list;
            }
        }

        private State() {
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$TopFriendError;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Z", "PlaceComponentResult", "()Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class TopFriendError extends State {
            private final boolean BuiltInFictitiousFunctionClassFactory;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof TopFriendError) && this.BuiltInFictitiousFunctionClassFactory == ((TopFriendError) p0).BuiltInFictitiousFunctionClassFactory;
            }

            public final int hashCode() {
                boolean z = this.BuiltInFictitiousFunctionClassFactory;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("TopFriendError(BuiltInFictitiousFunctionClassFactory=");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append(')');
                return sb.toString();
            }

            public TopFriendError(boolean z) {
                super(null);
                this.BuiltInFictitiousFunctionClassFactory = z;
            }

            @JvmName(name = "PlaceComponentResult")
            /* renamed from: PlaceComponentResult  reason: from getter */
            public final boolean getBuiltInFictitiousFunctionClassFactory() {
                return this.BuiltInFictitiousFunctionClassFactory;
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$TimelineSuccess;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/social/model/FeedViewHolderModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "PlaceComponentResult", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class TimelineSuccess extends State {

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            public final List<FeedViewHolderModel> PlaceComponentResult;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof TimelineSuccess) && Intrinsics.areEqual(this.PlaceComponentResult, ((TimelineSuccess) p0).PlaceComponentResult);
            }

            public final int hashCode() {
                return this.PlaceComponentResult.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("TimelineSuccess(PlaceComponentResult=");
                sb.append(this.PlaceComponentResult);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TimelineSuccess(List<FeedViewHolderModel> list) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "");
                this.PlaceComponentResult = list;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$TimelineError;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getAuthRequestContext", "()Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class TimelineError extends State {

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            private final boolean getAuthRequestContext;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof TimelineError) && this.getAuthRequestContext == ((TimelineError) p0).getAuthRequestContext;
            }

            public final int hashCode() {
                boolean z = this.getAuthRequestContext;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("TimelineError(getAuthRequestContext=");
                sb.append(this.getAuthRequestContext);
                sb.append(')');
                return sb.toString();
            }

            public TimelineError(boolean z) {
                super(null);
                this.getAuthRequestContext = z;
            }

            @JvmName(name = "getAuthRequestContext")
            /* renamed from: getAuthRequestContext  reason: from getter */
            public final boolean getGetAuthRequestContext() {
                return this.getAuthRequestContext;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$InitFeedLoading;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class InitFeedLoading extends State {
            public static final InitFeedLoading INSTANCE = new InitFeedLoading();

            private InitFeedLoading() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$InitFeedFinished;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class InitFeedFinished extends State {
            public static final InitFeedFinished INSTANCE = new InitFeedFinished();

            private InitFeedFinished() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$InitFeedError;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class InitFeedError extends State {
            public static final InitFeedError INSTANCE = new InitFeedError();

            private InitFeedError() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$InitFeedNotActivated;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class InitFeedNotActivated extends State {
            public static final InitFeedNotActivated INSTANCE = new InitFeedNotActivated();

            private InitFeedNotActivated() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$LoadingFetchUserConfig;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class LoadingFetchUserConfig extends State {
            public static final LoadingFetchUserConfig INSTANCE = new LoadingFetchUserConfig();

            private LoadingFetchUserConfig() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$ErrorFetchUserConfig;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ErrorFetchUserConfig extends State {
            public static final ErrorFetchUserConfig INSTANCE = new ErrorFetchUserConfig();

            private ErrorFetchUserConfig() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$FinishFetchUserConfig;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class FinishFetchUserConfig extends State {
            public static final FinishFetchUserConfig INSTANCE = new FinishFetchUserConfig();

            private FinishFetchUserConfig() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$FeedEmpty;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getAuthRequestContext", "()Z", "PlaceComponentResult", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* data */ class FeedEmpty extends State {

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            private final boolean PlaceComponentResult;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof FeedEmpty) && this.PlaceComponentResult == ((FeedEmpty) p0).PlaceComponentResult;
            }

            public final int hashCode() {
                boolean z = this.PlaceComponentResult;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("FeedEmpty(PlaceComponentResult=");
                sb.append(this.PlaceComponentResult);
                sb.append(')');
                return sb.toString();
            }

            public FeedEmpty(boolean z) {
                super(null);
                this.PlaceComponentResult = z;
            }

            @JvmName(name = "getAuthRequestContext")
            /* renamed from: getAuthRequestContext  reason: from getter */
            public final boolean getPlaceComponentResult() {
                return this.PlaceComponentResult;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$FeedSyncing;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class FeedSyncing extends State {
            public static final FeedSyncing INSTANCE = new FeedSyncing();

            private FeedSyncing() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$FeedSynced;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class FeedSynced extends State {
            public static final FeedSynced INSTANCE = new FeedSynced();

            private FeedSynced() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$ObserveSyncContact;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class ObserveSyncContact extends State {
            public static final ObserveSyncContact INSTANCE = new ObserveSyncContact();

            private ObserveSyncContact() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$UsernameBannerDisplayed;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class UsernameBannerDisplayed extends State {
            public static final UsernameBannerDisplayed INSTANCE = new UsernameBannerDisplayed();

            private UsernameBannerDisplayed() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State$UsernameBannerHidden;", "Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$State;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class UsernameBannerHidden extends State {
            public static final UsernameBannerHidden INSTANCE = new UsernameBannerHidden();

            private UsernameBannerHidden() {
                super(null);
            }
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0016\u001a\u00020\u0011H&J\u0012\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\u0011H&J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0011H&J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 H&J\b\u0010\"\u001a\u00020\u0011H&J\b\u0010#\u001a\u00020\u0011H&J\b\u0010$\u001a\u00020\u0011H&J\b\u0010%\u001a\u00020 H&J\b\u0010&\u001a\u00020\u0011H&J\b\u0010'\u001a\u00020\u0011H&J4\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)2\u001e\u0010,\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)\u0012\u0004\u0012\u00020\u00110-H&J\b\u0010.\u001a\u00020\u0011H&J\u001a\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\t2\b\b\u0002\u00101\u001a\u00020\tH&J\b\u00102\u001a\u00020\u0011H&J\b\u00103\u001a\u00020\tH&J\u0010\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\tH&J\b\u00106\u001a\u00020\u0011H&J\b\u00107\u001a\u00020\tH&J\b\u00108\u001a\u00020\u0011H&J\b\u00109\u001a\u00020\u0011H&J\u0010\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<H&J\b\u0010=\u001a\u00020\u0011H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006>À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendFeedsContract$Presenter;", "Lid/dana/social/contract/BaseSocialFeedContract$Presenter;", "initFeed", "Lid/dana/domain/social/model/InitFeed;", "getInitFeed", "()Lid/dana/domain/social/model/InitFeed;", "setInitFeed", "(Lid/dana/domain/social/model/InitFeed;)V", "isFirstTimeActivate", "", "()Z", "setFirstTimeActivate", "(Z)V", "isInitializingFeed", "setInitializingFeed", "onFeedInitializing", "Lkotlin/Function0;", "", "getOnFeedInitializing", "()Lkotlin/jvm/functions/Function0;", "setOnFeedInitializing", "(Lkotlin/jvm/functions/Function0;)V", "checkFirstTimeActivate", "checkHasFetchedUserConfig", "isFromTryAgain", "checkPendingShareFeedDialog", "checkShareFeedConsent", "createFeedActivityRequest", "Lid/dana/feeds/ui/model/CreateFeedActivityRequestModel;", "checkUsername", "deleteActivity", ExtendInfoUtilKt.SHARE_FEED_REQUEST_ID, "", "deleteShareFeedRequest", "enableShareFeedConsent", "fetchFeedWithBackPressure", "fetchShareableActivities", "getCurrentUserId", "getFeedConfig", "getFeedNotificationCount", "getFullSyncObserver", "Landroidx/lifecycle/Observer;", "", "Landroidx/work/WorkInfo;", "removeObserver", "Lkotlin/Function1;", "getTimeline", "getTopFriendsWithTimeline", "observeSyncIfEmpty", "fromRefresh", "getUserInfo", "hasObserveInitStatus", "initFeedMapper", "shouldAddDateSection", "initFeedOneTime", "isInitFeedFinished", "observeInitFeed", "refreshFeeds", "skipShareableActivity", AkuEventParamsKey.KEY_ACTIVITY, "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "waitToFetchNotificationCount", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends BaseSocialFeedContract.Presenter {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void BuiltInFictitiousFunctionClassFactory(boolean z);

        void DatabaseTableConfigUtil();

        /* renamed from: GetContactSyncConfig */
        boolean getReadMicros();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(Function0<Unit> function0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(PreviewActivityData previewActivityData);

        void MyBillsEntityDataFactory(CreateFeedActivityRequestModel createFeedActivityRequestModel);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(boolean z, boolean z2);

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0 */
        InitFeed getWhenAvailable();

        void NetworkUserEntityData$$ExternalSyntheticLambda1();

        boolean NetworkUserEntityData$$ExternalSyntheticLambda2();

        void NetworkUserEntityData$$ExternalSyntheticLambda7();

        void NetworkUserEntityData$$ExternalSyntheticLambda8();

        Observer<List<WorkInfo>> PlaceComponentResult(Function1<? super Observer<List<WorkInfo>>, Unit> function1);

        void PlaceComponentResult();

        void PlaceComponentResult(boolean z);

        void PrepareContext();

        void getAuthRequestContext();

        void getErrorConfigVersion();

        void initRecordTimeStamp();

        /* renamed from: isLayoutRequested */
        boolean getGetCallingPid();

        /* renamed from: lookAheadTest */
        String getGetAuthRequestContext();

        void moveToNextValue();

        boolean newProxyInstance();

        void scheduleImpl();

        /* renamed from: id.dana.social.contract.friendsfeeds.FriendFeedsContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }
    }
}
