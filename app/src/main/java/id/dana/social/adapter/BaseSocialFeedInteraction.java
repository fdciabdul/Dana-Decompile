package id.dana.social.adapter;

import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.model.ReactionCountModel;
import id.dana.social.utils.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/social/adapter/BaseSocialFeedInteraction;", "Lid/dana/social/adapter/SocialFeedClickListener;", "", "p0", "", "PlaceComponentResult", "(I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "()V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/utils/Content;", "getAuthRequestContext", "(Lid/dana/social/utils/Content;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BaseSocialFeedInteraction implements SocialFeedClickListener {
    @Override // id.dana.social.adapter.SocialFeedClickListener
    public void BuiltInFictitiousFunctionClassFactory(int p0) {
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ActivityWidgetModel activityWidgetModel) {
        SocialFeedClickListener.CC.getAuthRequestContext(activityWidgetModel);
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FriendModel friendModel) {
        SocialFeedClickListener.CC.BuiltInFictitiousFunctionClassFactory(friendModel);
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ReactionCountModel reactionCountModel) {
        SocialFeedClickListener.CC.BuiltInFictitiousFunctionClassFactory(reactionCountModel);
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
        SocialFeedClickListener.CC.PlaceComponentResult();
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ProfileCtaConfig profileCtaConfig, String str, String str2) {
        SocialFeedClickListener.CC.getAuthRequestContext(profileCtaConfig, str, str2);
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        SocialFeedClickListener.CC.PlaceComponentResult(str);
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void MyBillsEntityDataFactory() {
        SocialFeedClickListener.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public void MyBillsEntityDataFactory(int p0) {
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public void PlaceComponentResult() {
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public void PlaceComponentResult(int p0) {
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void PlaceComponentResult(String str, String str2) {
        SocialFeedClickListener.CC.MyBillsEntityDataFactory(str, str2);
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void getAuthRequestContext() {
        SocialFeedClickListener.CC.getAuthRequestContext();
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void getAuthRequestContext(int i) {
        SocialFeedClickListener.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public void getAuthRequestContext(Content p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void getAuthRequestContext(String str, DealsPayloadModel dealsPayloadModel) {
        SocialFeedClickListener.CC.getAuthRequestContext(str, dealsPayloadModel);
    }

    @Override // id.dana.social.adapter.SocialFeedClickListener
    public /* synthetic */ void getAuthRequestContext(String str, String str2) {
        SocialFeedClickListener.CC.getAuthRequestContext(str, str2);
    }
}
