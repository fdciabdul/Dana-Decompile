package id.dana.tutorial.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.storage.Serializer;
import id.dana.domain.promotion.CdpContent;
import id.dana.tutorial.model.TutorialModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/tutorial/mapper/TutorialModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/promotion/CdpContent;", "Lid/dana/tutorial/model/TutorialModel;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/promotion/CdpContent;)Lid/dana/tutorial/model/TutorialModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TutorialModelMapper extends BaseMapper<CdpContent, TutorialModel> {
    @Inject
    public TutorialModelMapper() {
    }

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ TutorialModel map(CdpContent cdpContent) {
        return BuiltInFictitiousFunctionClassFactory(cdpContent);
    }

    private static TutorialModel BuiltInFictitiousFunctionClassFactory(CdpContent p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        try {
            Serializer serializer = new Serializer();
            String contentValue = p0.getContentValue();
            Intrinsics.checkNotNullExpressionValue(contentValue, "");
            Object deserialize = serializer.deserialize(StringsKt.replace$default(contentValue, "[\n\r]", "", false, 4, (Object) null), TutorialModel.class);
            ((TutorialModel) deserialize).MyBillsEntityDataFactory = p0.getContentId();
            return (TutorialModel) deserialize;
        } catch (Exception unused) {
            return null;
        }
    }
}
