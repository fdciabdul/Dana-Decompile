package id.dana.feeds.ui.tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/feeds/ui/tracker/FeedsEvent;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface FeedsEvent {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.PlaceComponentResult;
    public static final String FRIENDSHIP_ACCEPT_REQUEST = "Friendship Friend Accepted";
    public static final String FRIENDSHIP_ACTIVATE = "Friendship Activate";
    public static final String FRIENDSHIP_ACTIVITY_OPEN = "Friendship Activity Open";
    public static final String FRIENDSHIP_DEACTIVATE = "Friendship Deactivate";
    public static final String FRIENDSHIP_DECLINE_REQUEST = "Friendship Friend Declined";
    public static final String FRIENDSHIP_EMOJI_ADD = "Friendship Emoji Add";
    public static final String FRIENDSHIP_FEEDS_COMMENT_ADD = "Friendship Comment Add";
    public static final String FRIENDSHIP_FEEDS_OPEN = "Friendship Feeds Open";
    public static final String FRIENDSHIP_FEEDS_READ = "Friendship Feeds Read";
    public static final String FRIENDSHIP_FEEDS_REPLY_COMMENT_ADD = "Friendship Reply Comment Add";
    public static final String FRIENDSHIP_FEED_ACTIVITY_SUBMIT = "Friendship Feeds Activity Submit";
    public static final String FRIENDSHIP_FRIEND_ADD = "Friendship Friend Add";
    public static final String FRIENDSHIP_FRIEND_PROFILE_OPEN = "Friendship Friend Profile Open";
    public static final String FRIENDSHIP_FRIEND_SEARCH_OPEN = "Friendship Friend Search Open";
    public static final String FRIENDSHIP_INTRODUCTION_OPEN = "Friendship Introduction Open";
    public static final String FRIENDSHIP_NOTIFICATION_OPEN = "Friendship Notification Open";
    public static final String FRIENDSHIP_SET_BLOCK = "Friendship Set Block";
    public static final String FRIENDSHIP_SET_MUTE = "Friendship Set Mute";
    public static final String FRIENDSHIP_SET_PRIVACY = "Friendship Set Privacy";
    public static final String NOTIFICATION_INBOX_READ = "Notification Inbox Read";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/ui/tracker/FeedsEvent$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion PlaceComponentResult = new Companion();

        private Companion() {
        }
    }
}
