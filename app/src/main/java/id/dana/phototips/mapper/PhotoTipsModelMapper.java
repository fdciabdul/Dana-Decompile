package id.dana.phototips.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.dana.data.base.BaseMapper;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.promotion.Space;
import id.dana.phototips.model.PhotoTipsModel;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/phototips/mapper/PhotoTipsModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/promotion/Space;", "", "", "Lid/dana/phototips/model/PhotoTipsModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PhotoTipsModelMapper extends BaseMapper<Space, Map<String, ? extends PhotoTipsModel>> {
    @Inject
    public PhotoTipsModelMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ Map<String, ? extends PhotoTipsModel> map(Space space) {
        List<CdpContent> cdpContents;
        CdpContent cdpContent;
        Space space2 = space;
        String contentValue = (space2 == null || (cdpContents = space2.getCdpContents()) == null || (cdpContent = (CdpContent) CollectionsKt.firstOrNull((List) cdpContents)) == null) ? null : cdpContent.getContentValue();
        if (contentValue == null) {
            contentValue = "";
        }
        String str = contentValue;
        if (str.length() == 0) {
            return null;
        }
        return (Map) new Gson().fromJson(new Regex("[\n\t]").replace(str, ""), new TypeToken<Map<String, ? extends PhotoTipsModel>>() { // from class: id.dana.phototips.mapper.PhotoTipsModelMapper$fromJsonObject$type$1
        }.getType());
    }
}
