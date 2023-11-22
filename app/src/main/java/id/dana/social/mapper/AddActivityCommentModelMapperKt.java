package id.dana.social.mapper;

import id.dana.feeds.domain.detail.model.AddActivityCommentInfo;
import id.dana.feeds.ui.model.AddActivityCommentModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/feeds/domain/detail/model/AddActivityCommentInfo;", "Lid/dana/feeds/ui/model/AddActivityCommentModel;", "PlaceComponentResult", "(Lid/dana/feeds/domain/detail/model/AddActivityCommentInfo;)Lid/dana/feeds/ui/model/AddActivityCommentModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddActivityCommentModelMapperKt {
    public static final AddActivityCommentModel PlaceComponentResult(AddActivityCommentInfo addActivityCommentInfo) {
        Intrinsics.checkNotNullParameter(addActivityCommentInfo, "");
        return new AddActivityCommentModel(addActivityCommentInfo.getId(), addActivityCommentInfo.getUserId(), addActivityCommentInfo.getActivityId(), addActivityCommentInfo.getContent(), addActivityCommentInfo.getCreatedTime(), addActivityCommentInfo.getParentCommentId());
    }
}
