package id.dana.feeds.ui.tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/feeds/ui/tracker/FeedsSourceType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface FeedsSourceType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;
    public static final String FEED_DEEPLINK = "Feed Deeplink";
    public static final String FEED_NOTIFICATION_PAGE = "Feed Notification Page";
    public static final String FEED_SETTINGS = "Feed Settings";
    public static final String FEED_WIDGET = "Feed Widget";
    public static final String FIND_AND_ADD_BOTTOM_SHEET = "Find & Add Bottom Sheet";
    public static final String FIND_FRIEND_PAGE = "Find Friend Page";
    public static final String FRIENDSHIP_FRIENDS_FEED = "Friendship Friend Feed";
    public static final String FRIENDSHIP_MY_FEED = "Friendship My Feed";
    public static final String FRIENDS_FEED = "Friends Feed";
    public static final String FRIEND_LIST_PAGE = "Friend List Page";
    public static final String FRIEND_PROFILE_PAGE = "Friends Profile Page";
    public static final String FRIEND_REQUEST_PAGE = "Friend Request Page";
    public static final String INBOX_ICON = "Inbox Icon";
    public static final String OTHER_USER_PROFILE = "Other User Profile";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/ui/tracker/FeedsSourceType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
