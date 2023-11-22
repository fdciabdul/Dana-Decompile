package id.dana.social.model.mapper;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class FeedMapper$getSectionFeed$1 extends FunctionReferenceImpl implements Function2<String, Date, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedMapper$getSectionFeed$1(Object obj) {
        super(2, obj, FeedMapper.class, "composeDateAndYear", "composeDateAndYear(Ljava/lang/String;Ljava/util/Date;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final String invoke(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(date, "");
        return FeedMapper.getAuthRequestContext((FeedMapper) this.receiver, str, date);
    }
}
