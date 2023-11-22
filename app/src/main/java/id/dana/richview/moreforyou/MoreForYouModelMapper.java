package id.dana.richview.moreforyou;

import id.dana.data.base.BaseMapper;
import id.dana.data.storage.Serializer;
import id.dana.domain.promotion.CdpContent;
import id.dana.richview.moreforyou.model.MoreForYouModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/richview/moreforyou/MoreForYouModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/promotion/CdpContent;", "Lid/dana/richview/moreforyou/model/MoreForYouModel;", "oldItem", "map", "(Lid/dana/domain/promotion/CdpContent;)Lid/dana/richview/moreforyou/model/MoreForYouModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoreForYouModelMapper extends BaseMapper<CdpContent, MoreForYouModel> {
    @Inject
    public MoreForYouModelMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final MoreForYouModel map(CdpContent oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        try {
            Serializer serializer = new Serializer();
            String contentValue = oldItem.getContentValue();
            Intrinsics.checkNotNullExpressionValue(contentValue, "");
            Object deserialize = serializer.deserialize(StringsKt.replace$default(contentValue, "[\n\r]", "", false, 4, (Object) null), MoreForYouModel.class);
            MoreForYouModel moreForYouModel = (MoreForYouModel) deserialize;
            moreForYouModel.setRedirectUrl(oldItem.getRedirectUrl());
            moreForYouModel.setContentId(oldItem.getContentId());
            moreForYouModel.setContentName(oldItem.getContentName());
            moreForYouModel.setContentType(oldItem.getContentType());
            moreForYouModel.setSpaceCode(oldItem.getSpaceCode());
            moreForYouModel.setPriority(Integer.valueOf(oldItem.getPriority()));
            moreForYouModel.setExpireDate(oldItem.getExpireDate());
            Intrinsics.checkNotNullExpressionValue(deserialize, "");
            return (MoreForYouModel) deserialize;
        } catch (Exception unused) {
            return new MoreForYouModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
        }
    }
}
