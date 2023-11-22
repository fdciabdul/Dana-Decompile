package id.dana.sendmoney.ui.groupsend.summary.util;

import id.dana.sendmoney.R;
import id.dana.sendmoney.ui.groupsend.summary.model.AvatarModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/util/GroupSendAvatarRandomizerEngine;", "", "", "p0", "Lid/dana/sendmoney/ui/groupsend/summary/model/AvatarModel;", "MyBillsEntityDataFactory", "(I)Lid/dana/sendmoney/ui/groupsend/summary/model/AvatarModel;", "", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "", "PlaceComponentResult", "Ljava/util/List;", "Lkotlin/Function1;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "p1", "<init>", "(ILkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupSendAvatarRandomizerEngine {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Function1<AvatarModel, Unit> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int getAuthRequestContext;
    public List<Integer> PlaceComponentResult;

    /* JADX WARN: Multi-variable type inference failed */
    public GroupSendAvatarRandomizerEngine(int i, Function1<? super AvatarModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = function1;
        this.PlaceComponentResult = CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4, 5});
    }

    public static AvatarModel MyBillsEntityDataFactory(int p0) {
        if (p0 != 1) {
            if (p0 != 2) {
                if (p0 != 3) {
                    if (p0 != 4) {
                        if (p0 == 5) {
                            return new AvatarModel(p0, R.drawable.res_0x7f080945_verifypinstatemanager_executeriskchallenge_2_1, getAuthRequestContext("magenta"));
                        }
                        return new AvatarModel(p0, R.drawable.ic_group_avatar_first, getAuthRequestContext("yellow"));
                    }
                    return new AvatarModel(p0, R.drawable.ic_group_avatar_fourth, getAuthRequestContext("darkblue"));
                }
                return new AvatarModel(p0, R.drawable.ic_group_avatar_third, getAuthRequestContext("green"));
            }
            return new AvatarModel(p0, R.drawable.res_0x7f080948_verifypinstatemanager_executeriskchallenge_2_2, getAuthRequestContext("blue"));
        }
        return new AvatarModel(p0, R.drawable.ic_group_avatar_first, getAuthRequestContext("yellow"));
    }

    private static String getAuthRequestContext(String p0) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://a.m.dana.id/resource/icons/send-money-group/x2p-group-icon-");
        sb.append(p0);
        sb.append(".png");
        return sb.toString();
    }
}
