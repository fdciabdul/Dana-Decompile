package id.dana.riskChallenges.data.verifypassword.mapper;

import id.dana.riskChallenges.domain.forgetpassword.model.VerificationMethods;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lid/dana/riskChallenges/domain/forgetpassword/model/VerificationMethods;", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/util/List;", "Lid/dana/riskChallenges/data/verifypassword/source/network/result/VerifyPasswordResult;", "Lid/dana/riskChallenges/domain/verifypassword/model/VerifyPassword;", "getAuthRequestContext", "(Lid/dana/riskChallenges/data/verifypassword/source/network/result/VerifyPasswordResult;)Lid/dana/riskChallenges/domain/verifypassword/model/VerifyPassword;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPasswordMapperKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.riskChallenges.domain.verifypassword.model.VerifyPassword getAuthRequestContext(id.dana.riskChallenges.data.verifypassword.source.network.result.VerifyPasswordResult r11) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.data.verifypassword.mapper.VerifyPasswordMapperKt.getAuthRequestContext(id.dana.riskChallenges.data.verifypassword.source.network.result.VerifyPasswordResult):id.dana.riskChallenges.domain.verifypassword.model.VerifyPassword");
    }

    private static List<VerificationMethods> PlaceComponentResult(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return CollectionsKt.emptyList();
        }
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) ",", false, 2, (Object) null)) {
            List split$default = StringsKt.split$default((CharSequence) str2, new String[]{","}, false, 0, 6, (Object) null);
            int size = 100 / split$default.size();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : split$default) {
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str3 = (String) obj;
                VerificationMethods verificationMethods = str3.length() > 0 ? new VerificationMethods(100 - (i * size), str3, str3) : null;
                if (verificationMethods != null) {
                    arrayList.add(verificationMethods);
                }
                i++;
            }
            return arrayList;
        }
        return CollectionsKt.listOf(new VerificationMethods(100, str, str));
    }
}
