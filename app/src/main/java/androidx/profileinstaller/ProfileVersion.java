package androidx.profileinstaller;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ProfileVersion {
    static final byte[] moveToNextValue = {TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_DIR, 0};
    static final byte[] lookAheadTest = {TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_NORMAL, 0};
    static final byte[] PlaceComponentResult = {TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, 57, 0};
    static final byte[] getAuthRequestContext = {TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, TarHeader.LF_DIR, 0};
    static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, TarHeader.LF_LINK, 0};
    static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, TarHeader.LF_LINK, 0};
    static final byte[] MyBillsEntityDataFactory = {TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, TarHeader.LF_SYMLINK, 0};

    private ProfileVersion() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr) {
        return (Arrays.equals(bArr, BuiltInFictitiousFunctionClassFactory) || Arrays.equals(bArr, getAuthRequestContext)) ? ":" : "!";
    }
}
