package id.dana.feeds.data.storage.preferences;

import id.dana.domain.social.model.FeedInit;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.data.share.source.local.model.CreateFeedActivityEntity;
import id.dana.feeds.domain.share.model.PreviewActivityData;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&¢\u0006\u0004\b\u000b\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0014J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004H&¢\u0006\u0004\b\u0006\u0010\u0010J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0016\u0010\u0010J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u0017J!\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u0018J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\u001aJ\u0019\u0010\u0006\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\u001bJ\u0019\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u001bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\u0017J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\u001e\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u001fJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u001dH&¢\u0006\u0004\b\r\u0010 J\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010!J-\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H&¢\u0006\u0004\b\u000b\u0010#J%\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\tH&¢\u0006\u0004\b\u0016\u0010\fJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u001cH&¢\u0006\u0004\b\r\u0010$J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\u000b\u0010%J%\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b&\u0010\u0017J'\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0011H&¢\u0006\u0004\b\u0016\u0010'J\u001f\u0010(\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b(\u0010\u000eJ\u001f\u0010&\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b&\u0010\u000eJ\u001f\u0010)\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH&¢\u0006\u0004\b)\u0010\u000eJ'\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\"\u001a\u00020*H&¢\u0006\u0004\b\u0016\u0010+J%\u0010\r\u001a\u00020-2\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110,H&¢\u0006\u0004\b\r\u0010.ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/storage/preferences/SocialPreferencesData;", "", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "p0", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)Lio/reactivex/Observable;", "", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/util/List;)Z", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lid/dana/feeds/data/config/model/FeedConfigResult;", "()Lio/reactivex/Observable;", "Lid/dana/feeds/domain/share/model/PreviewActivityData;", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/util/List;", "()Lid/dana/feeds/domain/timeline/model/SocialFeed;", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/domain/share/model/PreviewActivityData;", "", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Set;", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/domain/social/model/FeedInit;", "Lid/dana/feeds/data/share/source/local/model/CreateFeedActivityEntity;", "lookAheadTest", "(I)Z", "(Ljava/lang/String;Lid/dana/feeds/data/share/source/local/model/CreateFeedActivityEntity;)Z", "(Z)Lio/reactivex/Observable;", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Z", "(Ljava/lang/String;Lid/dana/domain/social/model/FeedInit;)Lio/reactivex/Observable;", "(Lid/dana/feeds/data/config/model/FeedConfigResult;)Z", "getErrorConfigVersion", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/feeds/domain/share/model/PreviewActivityData;)Z", "moveToNextValue", "scheduleImpl", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/feeds/domain/timeline/enums/FeedActivityState;)Z", "", "", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SocialPreferencesData {
    Observable<FeedConfigResult> BuiltInFictitiousFunctionClassFactory();

    Observable<FeedInit> BuiltInFictitiousFunctionClassFactory(String p0);

    Set<String> BuiltInFictitiousFunctionClassFactory(String p0, String p1);

    boolean BuiltInFictitiousFunctionClassFactory(FeedConfigResult p0);

    boolean BuiltInFictitiousFunctionClassFactory(String p0, String p1, Set<String> p2);

    boolean BuiltInFictitiousFunctionClassFactory(String p0, List<String> p1);

    Observable<Integer> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(SocialFeed p0);

    String KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1);

    PreviewActivityData MyBillsEntityDataFactory(String p0, String p1);

    Observable<Boolean> MyBillsEntityDataFactory();

    String MyBillsEntityDataFactory(String p0);

    boolean MyBillsEntityDataFactory(int p0);

    boolean MyBillsEntityDataFactory(String p0, String p1, PreviewActivityData p2);

    boolean MyBillsEntityDataFactory(String p0, String p1, FeedActivityState p2);

    boolean MyBillsEntityDataFactory(String p0, List<PreviewActivityData> p1);

    Observable<Boolean> PlaceComponentResult(String p0);

    Observable<Boolean> PlaceComponentResult(String p0, FeedInit p1);

    Observable<Boolean> PlaceComponentResult(boolean p0);

    void PlaceComponentResult(String p0, List<PreviewActivityData> p1);

    boolean PlaceComponentResult(String p0, CreateFeedActivityEntity p1);

    boolean PlaceComponentResult(String p0, String p1);

    SocialFeed getAuthRequestContext();

    List<PreviewActivityData> getAuthRequestContext(String p0);

    boolean getAuthRequestContext(String p0, String p1);

    Observable<Boolean> getErrorConfigVersion(String str);

    boolean getErrorConfigVersion(String p0, String p1);

    List<CreateFeedActivityEntity> lookAheadTest(String p0);

    boolean moveToNextValue(String p0, String p1);

    boolean scheduleImpl(String p0, String p1);
}
