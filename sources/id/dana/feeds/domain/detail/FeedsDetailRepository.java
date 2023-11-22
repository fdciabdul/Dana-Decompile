package id.dana.feeds.domain.detail;

import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.detail.model.AddActivityCommentInfo;
import id.dana.feeds.domain.detail.model.FeedCommentResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\u0006H&J9\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0016À\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/detail/FeedsDetailRepository;", "", "addActivityComment", "Lio/reactivex/Observable;", "Lid/dana/feeds/domain/detail/model/AddActivityCommentInfo;", "userId", "", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "content", "parentCommentId", "deleteComment", "", "id", "getFeedComments", "Lid/dana/feeds/domain/detail/model/FeedCommentResult;", "idLastComment", HereUrlConstant.LIMIT, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "submitFeedCommentReport", "commentId", ZdocRecordService.REASON, "feature-feeds_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FeedsDetailRepository {
    Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String str);

    Observable<Boolean> MyBillsEntityDataFactory(String str, String str2, String str3);

    Observable<FeedCommentResult> PlaceComponentResult(String str, String str2, String str3, Integer num);

    Observable<AddActivityCommentInfo> PlaceComponentResult(String str, String str2, String str3, String str4);
}
