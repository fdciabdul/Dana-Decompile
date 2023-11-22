package id.dana.nearbyme.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.Tag;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyme/mapper/MerchantReviewTagMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/nearbyme/model/Tag;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewTagModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewTagMapper extends BaseMapper<Tag, MerchantReviewTagModel> {
    @Inject
    public MerchantReviewTagMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ MerchantReviewTagModel map(Tag tag) {
        Tag tag2 = tag;
        Intrinsics.checkNotNullParameter(tag2, "");
        return new MerchantReviewTagModel(tag2.getId(), tag2.getDescription(), tag2.getIconUrl(), tag2.getTagCode(), false, 16, null);
    }
}
