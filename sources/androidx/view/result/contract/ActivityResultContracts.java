package androidx.view.result.contract;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.view.result.ActivityResult;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContract;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts;", "", "<init>", "()V", "CaptureVideo", "CreateDocument", "GetContent", "GetMultipleContents", "OpenDocument", "OpenDocumentTree", "OpenMultipleDocuments", "PickContact", "RequestMultiplePermissions", "RequestPermission", "StartActivityForResult", "StartIntentSenderForResult", "TakePicture", "TakePicturePreview", "TakeVideo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultContracts {
    private ActivityResultContracts() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ Intent createIntent(Context context, Intent intent) {
            Intent intent2 = intent;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(intent2, "");
            return intent2;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ ActivityResult parseResult(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00062\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            IntentSenderRequest intentSenderRequest2 = intentSenderRequest;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(intentSenderRequest2, "");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            return putExtra;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ ActivityResult parseResult(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2'\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u00060\u00040\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ Intent createIntent(Context context, String[] strArr) {
            String[] strArr2 = strArr;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(strArr2, "");
            return Companion.getAuthRequestContext(strArr2);
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context context, String[] strArr) {
            String[] strArr2 = strArr;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(strArr2, "");
            boolean z = true;
            if (strArr2.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(MapsKt.emptyMap());
            }
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (!(ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, strArr2[i]) == 0)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(strArr2.length), 16));
                for (String str : strArr2) {
                    Pair pair = TuplesKt.to(str, Boolean.TRUE);
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
            }
            return null;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions$Companion;", "", "", "", "p0", "Landroid/content/Intent;", "getAuthRequestContext", "([Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static Intent getAuthRequestContext(String[] p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", p0);
                Intrinsics.checkNotNullExpressionValue(putExtra, "");
                return putExtra;
            }
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ Map<String, Boolean> parseResult(int i, Intent intent) {
            if (i == -1 && intent != null) {
                String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                if (intArrayExtra != null && stringArrayExtra != null) {
                    ArrayList arrayList = new ArrayList(intArrayExtra.length);
                    for (int i2 : intArrayExtra) {
                        arrayList.add(Boolean.valueOf(i2 == 0));
                    }
                    return MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(stringArrayExtra), arrayList));
                }
            }
            return MapsKt.emptyMap();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ Intent createIntent(Context context, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str2, "");
            RequestMultiplePermissions.Companion companion = RequestMultiplePermissions.INSTANCE;
            return RequestMultiplePermissions.Companion.getAuthRequestContext(new String[]{str2});
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str2, "");
            if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, str2) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x0022, code lost:
        
            if (r5 == true) goto L72;
         */
        @Override // androidx.view.result.contract.ActivityResultContract
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final /* synthetic */ java.lang.Boolean parseResult(int r5, android.content.Intent r6) {
            /*
                r4 = this;
                if (r6 == 0) goto L2b
                r0 = -1
                if (r5 != r0) goto L2b
                java.lang.String r5 = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS"
                int[] r5 = r6.getIntArrayExtra(r5)
                r6 = 1
                r0 = 0
                if (r5 == 0) goto L25
                int r1 = r5.length
                r2 = 0
            L11:
                if (r2 >= r1) goto L21
                r3 = r5[r2]
                if (r3 != 0) goto L19
                r3 = 1
                goto L1a
            L19:
                r3 = 0
            L1a:
                if (r3 == 0) goto L1e
                r5 = 1
                goto L22
            L1e:
                int r2 = r2 + 1
                goto L11
            L21:
                r5 = 0
            L22:
                if (r5 != r6) goto L25
                goto L26
            L25:
                r6 = 0
            L26:
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)
                return r5
            L2b:
                java.lang.Boolean r5 = java.lang.Boolean.FALSE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.contract.ActivityResultContracts.RequestPermission.parseResult(int, android.content.Intent):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, Void r2) {
            Intrinsics.checkNotNullParameter(context, "");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Void r2) {
            Intrinsics.checkNotNullParameter(context, "");
            return null;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Bitmap parseResult(int i, Intent intent) {
            if (!(i == -1)) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(uri2, "");
            Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, uri2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            return putExtra;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(uri, "");
            return null;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Boolean parseResult(int i, Intent intent) {
            return Boolean.valueOf(i == -1);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Deprecated(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    /* loaded from: classes.dex */
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(uri2, "");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, uri2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            return putExtra;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(uri, "");
            return null;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Bitmap parseResult(int i, Intent intent) {
            if (!(i == -1)) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra("data");
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(uri2, "");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, uri2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            return putExtra;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(uri, "");
            return null;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Boolean parseResult(int i, Intent intent) {
            return Boolean.valueOf(i == -1);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ Intent createIntent(Context context, Void r3) {
            Intrinsics.checkNotNullParameter(context, "");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(type, "");
            return type;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public final /* synthetic */ Uri parseResult(int i, Intent intent) {
            if (!(i == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str2);
            Intrinsics.checkNotNullExpressionValue(type, "");
            return type;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str, "");
            return null;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Uri parseResult(int i, Intent intent) {
            if (!(i == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \b2\u001b\u0012\u0004\u0012\u00020\u0002\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            return putExtra;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str, "");
            return null;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion;", "", "Landroid/content/Intent;", "", "Landroid/net/Uri;", "MyBillsEntityDataFactory", "(Landroid/content/Intent;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static List<Uri> MyBillsEntityDataFactory(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i = 0; i < itemCount; i++) {
                        Uri uri = clipData.getItemAt(i).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ List<Uri> parseResult(int i, Intent intent) {
            List<Uri> MyBillsEntityDataFactory;
            if (!(i == -1)) {
                intent = null;
            }
            return (intent == null || (MyBillsEntityDataFactory = Companion.MyBillsEntityDataFactory(intent)) == null) ? CollectionsKt.emptyList() : MyBillsEntityDataFactory;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, String[] strArr) {
            String[] strArr2 = strArr;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(strArr2, "");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr2).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "");
            return type;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] strArr) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(strArr, "");
            return null;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Uri parseResult(int i, Intent intent) {
            if (!(i == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u00060\u00040\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, String[] strArr) {
            String[] strArr2 = strArr;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(strArr2, "");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr2).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "");
            return type;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String[] strArr) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(strArr, "");
            return null;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ List<Uri> parseResult(int i, Intent intent) {
            if (!(i == -1)) {
                intent = null;
            }
            if (intent != null) {
                GetMultipleContents.Companion companion = GetMultipleContents.INSTANCE;
                List<Uri> MyBillsEntityDataFactory = GetMultipleContents.Companion.MyBillsEntityDataFactory(intent);
                if (MyBillsEntityDataFactory != null) {
                    return MyBillsEntityDataFactory;
                }
            }
            return CollectionsKt.emptyList();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(context, "");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri2 != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri2);
            }
            return intent;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter(context, "");
            return null;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Uri parseResult(int i, Intent intent) {
            if (!(i == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\t\b\u0017¢\u0006\u0004\b\u0007\u0010\bB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", "p0", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static class CreateDocument extends ActivityResultContract<String, Uri> {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final String KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Intent createIntent(Context context, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intent putExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.KClassImpl$Data$declaredNonStaticMembers$2).putExtra("android.intent.extra.TITLE", str2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            return putExtra;
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str, "");
            return null;
        }

        private CreateDocument(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }

        @Deprecated(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @ReplaceWith(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }

        @Override // androidx.view.result.contract.ActivityResultContract
        public /* synthetic */ Uri parseResult(int i, Intent intent) {
            if (!(i == -1)) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }
}
