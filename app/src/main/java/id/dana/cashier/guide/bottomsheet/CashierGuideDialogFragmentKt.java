package id.dana.cashier.guide.bottomsheet;

import id.dana.domain.promotion.CdpContent;
import id.dana.domain.promotion.Space;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0000"}, d2 = {}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierGuideDialogFragmentKt {
    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(Space space) {
        CdpContent cdpContent;
        List<CdpContent> cdpContents = space.getCdpContents();
        String contentValue = (cdpContents == null || (cdpContent = (CdpContent) CollectionsKt.first((List) cdpContents)) == null) ? null : cdpContent.getContentValue();
        String str = contentValue;
        if ((!(str == null || StringsKt.isBlank(str))) == true) {
            return contentValue;
        }
        return null;
    }
}
