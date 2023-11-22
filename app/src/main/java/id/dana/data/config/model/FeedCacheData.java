package id.dana.data.config.model;

import id.dana.data.config.source.sharedpreference.SocialFeedWrapperModelEntityData;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.FeedInit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/config/model/FeedCacheData;", "", "", "isFeedInitFinish", "()Z", "isFeedInitNotActivated", "isFeedInitNull", "isFeedWidgetEnabled", "Lid/dana/domain/social/model/FeedConfig;", "feedConfig", "Lid/dana/domain/social/model/FeedConfig;", "getFeedConfig", "()Lid/dana/domain/social/model/FeedConfig;", "setFeedConfig", "(Lid/dana/domain/social/model/FeedConfig;)V", "Lid/dana/domain/social/model/FeedInit;", "feedInit", "Lid/dana/domain/social/model/FeedInit;", "getFeedInit", "()Lid/dana/domain/social/model/FeedInit;", "setFeedInit", "(Lid/dana/domain/social/model/FeedInit;)V", "Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "socialFeed", "Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "getSocialFeed", "()Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "setSocialFeed", "(Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FeedCacheData {
    private FeedConfig feedConfig;
    private FeedInit feedInit;
    private SocialFeedWrapperModelEntityData socialFeed;

    @JvmName(name = "getFeedInit")
    public final FeedInit getFeedInit() {
        return this.feedInit;
    }

    @JvmName(name = "setFeedInit")
    public final void setFeedInit(FeedInit feedInit) {
        this.feedInit = feedInit;
    }

    @JvmName(name = "getFeedConfig")
    public final FeedConfig getFeedConfig() {
        return this.feedConfig;
    }

    @JvmName(name = "setFeedConfig")
    public final void setFeedConfig(FeedConfig feedConfig) {
        this.feedConfig = feedConfig;
    }

    @JvmName(name = "getSocialFeed")
    public final SocialFeedWrapperModelEntityData getSocialFeed() {
        return this.socialFeed;
    }

    @JvmName(name = "setSocialFeed")
    public final void setSocialFeed(SocialFeedWrapperModelEntityData socialFeedWrapperModelEntityData) {
        this.socialFeed = socialFeedWrapperModelEntityData;
    }

    public final boolean isFeedInitNull() {
        return this.feedInit == null;
    }

    public final boolean isFeedInitFinish() {
        FeedInit feedInit = this.feedInit;
        return feedInit != null && feedInit.getStatus() == InitStatus.FINISH;
    }

    public final boolean isFeedInitNotActivated() {
        FeedInit feedInit = this.feedInit;
        return feedInit != null && feedInit.getStatus() == InitStatus.NOT_ACTIVATED;
    }

    public final boolean isFeedWidgetEnabled() {
        FeedConfig feedConfig = this.feedConfig;
        if (feedConfig != null) {
            return feedConfig.isFeedWidgetEnabled();
        }
        return false;
    }
}
