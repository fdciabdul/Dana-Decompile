package id.dana.promoquest.adapter;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.promoquest.model.QuestModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/promoquest/model/QuestModel;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/promoquest/model/QuestModel;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
final class HorizontalQuestAdapter$removeQuest$1 extends Lambda implements Function1<QuestModel, Boolean> {
    final /* synthetic */ String $$id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HorizontalQuestAdapter$removeQuest$1(String str) {
        super(1);
        this.$$id = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(QuestModel questModel) {
        return Boolean.valueOf(Intrinsics.areEqual(questModel != null ? questModel.getErrorConfigVersion : null, this.$$id));
    }
}
