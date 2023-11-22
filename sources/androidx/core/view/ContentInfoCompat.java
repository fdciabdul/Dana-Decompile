package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ContentInfoCompat {
    private final Compat MyBillsEntityDataFactory;

    /* loaded from: classes3.dex */
    interface BuilderCompat {
        void KClassImpl$Data$declaredNonStaticMembers$2(int i);

        void MyBillsEntityDataFactory(Uri uri);

        ContentInfoCompat PlaceComponentResult();

        void getAuthRequestContext(Bundle bundle);
    }

    /* loaded from: classes3.dex */
    interface Compat {
        int KClassImpl$Data$declaredNonStaticMembers$2();

        int MyBillsEntityDataFactory();

        ContentInfo PlaceComponentResult();

        ClipData getAuthRequestContext();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Source {
    }

    static String MyBillsEntityDataFactory(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    static String getAuthRequestContext(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    ContentInfoCompat(Compat compat) {
        this.MyBillsEntityDataFactory = compat;
    }

    public static ContentInfoCompat getAuthRequestContext(ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    public final ContentInfo KClassImpl$Data$declaredNonStaticMembers$2() {
        return (ContentInfo) Objects.requireNonNull(this.MyBillsEntityDataFactory.PlaceComponentResult());
    }

    public final String toString() {
        return this.MyBillsEntityDataFactory.toString();
    }

    public final ClipData PlaceComponentResult() {
        return this.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    public final int MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
    }

    public final int getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* loaded from: classes6.dex */
    static final class Api31Impl {
        private Api31Impl() {
        }
    }

    /* loaded from: classes3.dex */
    static final class CompatImpl implements Compat {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final Uri KClassImpl$Data$declaredNonStaticMembers$2;
        private final ClipData MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        private final Bundle getAuthRequestContext;

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ContentInfo PlaceComponentResult() {
            return null;
        }

        CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.MyBillsEntityDataFactory = (ClipData) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(builderCompatImpl.PlaceComponentResult);
            this.BuiltInFictitiousFunctionClassFactory = Preconditions.BuiltInFictitiousFunctionClassFactory(builderCompatImpl.MyBillsEntityDataFactory, "source");
            this.PlaceComponentResult = Preconditions.BuiltInFictitiousFunctionClassFactory(builderCompatImpl.getAuthRequestContext);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = builderCompatImpl.KClassImpl$Data$declaredNonStaticMembers$2;
            this.getAuthRequestContext = builderCompatImpl.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ClipData getAuthRequestContext() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int MyBillsEntityDataFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult;
        }

        public final String toString() {
            String obj;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.MyBillsEntityDataFactory.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.getAuthRequestContext(this.PlaceComponentResult));
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                obj = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(", hasLinkUri(");
                sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2.toString().length());
                sb2.append(")");
                obj = sb2.toString();
            }
            sb.append(obj);
            sb.append(this.getAuthRequestContext != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    static final class Compat31Impl implements Compat {
        private final ContentInfo KClassImpl$Data$declaredNonStaticMembers$2;

        Compat31Impl(ContentInfo contentInfo) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (ContentInfo) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(contentInfo);
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ContentInfo PlaceComponentResult() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final ClipData getAuthRequestContext() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public final int KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.getFlags();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("}");
            return sb.toString();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private final BuilderCompat KClassImpl$Data$declaredNonStaticMembers$2;

        public Builder(ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new BuilderCompat31Impl(clipData, i);
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new BuilderCompatImpl(clipData, i);
            }
        }

        public final Builder MyBillsEntityDataFactory(int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i);
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(uri);
            return this;
        }

        public final Builder PlaceComponentResult(Bundle bundle) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(bundle);
            return this;
        }

        public final ContentInfoCompat KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
        }
    }

    /* loaded from: classes3.dex */
    static final class BuilderCompatImpl implements BuilderCompat {
        Bundle BuiltInFictitiousFunctionClassFactory;
        Uri KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        ClipData PlaceComponentResult;
        int getAuthRequestContext;

        BuilderCompatImpl(ClipData clipData, int i) {
            this.PlaceComponentResult = clipData;
            this.MyBillsEntityDataFactory = i;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            this.getAuthRequestContext = i;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void MyBillsEntityDataFactory(Uri uri) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = uri;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void getAuthRequestContext(Bundle bundle) {
            this.BuiltInFictitiousFunctionClassFactory = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final ContentInfoCompat PlaceComponentResult() {
            return new ContentInfoCompat(new CompatImpl(this));
        }
    }

    /* loaded from: classes3.dex */
    static final class BuilderCompat31Impl implements BuilderCompat {
        private final ContentInfo.Builder getAuthRequestContext;

        BuilderCompat31Impl(ClipData clipData, int i) {
            this.getAuthRequestContext = new ContentInfo.Builder(clipData, i);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            this.getAuthRequestContext.setFlags(i);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void MyBillsEntityDataFactory(Uri uri) {
            this.getAuthRequestContext.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final void getAuthRequestContext(Bundle bundle) {
            this.getAuthRequestContext.setExtras(bundle);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public final ContentInfoCompat PlaceComponentResult() {
            return new ContentInfoCompat(new Compat31Impl(this.getAuthRequestContext.build()));
        }
    }
}
