package zipkin2.reporter.okhttp3;

import java.io.IOException;
import java.io.UncheckedIOException;

/* loaded from: classes6.dex */
abstract class Platform {
    private static final Platform KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult();

    Platform() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RuntimeException PlaceComponentResult(IOException iOException) {
        return new RuntimeException(iOException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Platform MyBillsEntityDataFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private static Platform PlaceComponentResult() {
        try {
            Class.forName("java.io.UncheckedIOException");
            return new Jre8();
        } catch (ClassNotFoundException unused) {
            return Jre6.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Jre8 extends Platform {
        Jre8() {
        }

        @Override // zipkin2.reporter.okhttp3.Platform
        public final RuntimeException PlaceComponentResult(IOException iOException) {
            return new UncheckedIOException(iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class Jre6 extends Platform {
        Jre6() {
        }

        static Jre6 PlaceComponentResult() {
            return new Jre6();
        }
    }
}
