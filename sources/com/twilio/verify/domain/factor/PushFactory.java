package com.twilio.verify.domain.factor;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.common.base.Ascii;
import com.twilio.verify.BuildConfig;
import com.twilio.verify.data.KeyStorage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010"}, d2 = {"Lcom/twilio/verify/domain/factor/PushFactory;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/util/Map;", "PlaceComponentResult", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "Landroid/content/Context;", "Landroid/content/Context;", "Lcom/twilio/verify/domain/factor/FactorProvider;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/domain/factor/FactorProvider;", "Lcom/twilio/verify/data/KeyStorage;", "Lcom/twilio/verify/data/KeyStorage;", "p1", "p2", "<init>", "(Lcom/twilio/verify/domain/factor/FactorProvider;Lcom/twilio/verify/data/KeyStorage;Landroid/content/Context;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class PushFactory {
    final FactorProvider BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;
    final KeyStorage PlaceComponentResult;
    public static final byte[] getAuthRequestContext = {16, -117, -56, -112, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 122;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 4
            int r9 = r9 * 5
            int r9 = r9 + 18
            byte[] r0 = com.twilio.verify.domain.factor.PushFactory.getAuthRequestContext
            int r7 = r7 * 6
            int r7 = r7 + 97
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r7 = r9
            r3 = r1
            r5 = 0
            r9 = r8
            r1 = r0
            r0 = r10
            r10 = r7
            goto L37
        L19:
            r3 = 0
            r6 = r9
            r9 = r7
            r7 = r6
        L1d:
            int r8 = r8 + 1
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L37:
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + (-8)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.domain.factor.PushFactory.a(short, int, int, java.lang.Object[]):void");
    }

    public PushFactory(FactorProvider factorProvider, KeyStorage keyStorage, Context context) {
        Intrinsics.checkParameterIsNotNull(factorProvider, "");
        Intrinsics.checkParameterIsNotNull(keyStorage, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        this.BuiltInFictitiousFunctionClassFactory = factorProvider;
        this.PlaceComponentResult = keyStorage;
        this.getAuthRequestContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String MyBillsEntityDataFactory() {
        List plus = CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', 'Z')), (Iterable) new CharRange('0', '9'));
        IntRange intRange = new IntRange(1, 15);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(Integer.valueOf(Random.INSTANCE.nextInt(0, plus.size())));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Character.valueOf(((Character) plus.get(((Number) it2.next()).intValue())).charValue()));
        }
        return CollectionsKt.joinToString$default(arrayList3, "", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> getAuthRequestContext(String p0) {
        return MapsKt.mapOf(TuplesKt.to("PublicKey", p0), TuplesKt.to("Alg", "ES256"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> PlaceComponentResult(String p0) {
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("SdkVersion", BuildConfig.VERSION_NAME);
        Context context = this.getAuthRequestContext;
        try {
            byte b = getAuthRequestContext[41];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (-b2), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (getAuthRequestContext[5] - 1), (byte) (-getAuthRequestContext[4]), getAuthRequestContext[41], objArr2);
            pairArr[1] = TuplesKt.to("AppId", ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).packageName);
            pairArr[2] = TuplesKt.to("NotificationPlatform", "fcm");
            pairArr[3] = TuplesKt.to("NotificationToken", p0);
            return MapsKt.mapOf(pairArr);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
