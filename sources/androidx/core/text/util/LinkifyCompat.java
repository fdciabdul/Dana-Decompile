package androidx.core.text.util;

import androidx.core.text.util.LinkifyCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Comparator;

/* loaded from: classes6.dex */
public final class LinkifyCompat {
    private static final String[] BuiltInFictitiousFunctionClassFactory = new String[0];
    private static final Comparator<LinkSpec> getAuthRequestContext = new Comparator() { // from class: androidx.core.text.util.LinkifyCompat$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return LinkifyCompat.getAuthRequestContext((LinkifyCompat.LinkSpec) obj, (LinkifyCompat.LinkSpec) obj2);
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LinkifyMask {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int getAuthRequestContext(LinkSpec linkSpec, LinkSpec linkSpec2) {
        if (linkSpec.MyBillsEntityDataFactory < linkSpec2.MyBillsEntityDataFactory) {
            return -1;
        }
        if (linkSpec.MyBillsEntityDataFactory > linkSpec2.MyBillsEntityDataFactory) {
            return 1;
        }
        return Integer.compare(linkSpec2.getAuthRequestContext, linkSpec.getAuthRequestContext);
    }

    private LinkifyCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class LinkSpec {
        int MyBillsEntityDataFactory;
        int getAuthRequestContext;

        LinkSpec() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api24Impl {
        private Api24Impl() {
        }
    }
}
