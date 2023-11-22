package com.alibaba.griver.core.utils;

import android.os.Process;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.core.model.share.ShareShortUrlRequest;
import com.alibaba.griver.core.model.share.ShareShortUrlResult;
import com.alibaba.griver.core.rpc.ShareProcessor;
import java.net.URLEncoder;
import o.B;

/* loaded from: classes6.dex */
public class ShareShortenUrlUtils {
    public static void getShortenUrl(final String str, final OnRpcResultListener<ShareShortUrlResult> onRpcResultListener) {
        GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.core.utils.ShareShortenUrlUtils.1
            private static int $10 = 0;
            private static int $11 = 1;
            private static int BuiltInFictitiousFunctionClassFactory = 1257195775;
            private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1228821288;
            private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
            private static short[] PlaceComponentResult;
            private static int lookAheadTest;
            private static byte[] getAuthRequestContext = {75, -33, -44, -41, -97};
            private static int MyBillsEntityDataFactory = -1807055488;

            @Override // java.lang.Runnable
            public final void run() {
                int i = lookAheadTest + 111;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                String str2 = str;
                try {
                    Object[] objArr = new Object[1];
                    a(559559394 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getJumpTapTimeout() >> 16) - 91, (short) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 20), (-64035682) - (Process.myTid() >> 22), (byte) ((-54) - KeyEvent.getDeadChar(0, 0)), objArr);
                    str2 = URLEncoder.encode(str2, ((String) objArr[0]).intern());
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 91;
                    lookAheadTest = i3 % 128;
                    int i4 = i3 % 2;
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Encode url exception...e=");
                    sb.append(th);
                    GriverLogger.e("ShareShortenUrlUtils", sb.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("share url encoded: ");
                sb2.append(str2);
                GriverLogger.d("ShareShortenUrlUtils", sb2.toString());
                String workSpaceId = GriverEnv.getWorkSpaceId();
                ShareShortUrlRequest shareShortUrlRequest = new ShareShortUrlRequest();
                shareShortUrlRequest.walletAppId = GriverEnv.getAppId();
                shareShortUrlRequest.currentWorkspaceId = workSpaceId;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("scheme=");
                sb3.append(str2);
                shareShortUrlRequest.paramData = sb3.toString();
                new ShareProcessor().getShareShortUrl(shareShortUrlRequest, onRpcResultListener);
            }

            private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
                int i4;
                B b2 = new B();
                StringBuilder sb = new StringBuilder();
                int i5 = i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
                boolean z = (i5 == -1 ? '`' : '(') != '(';
                if (z) {
                    int i6 = $10 + 83;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    byte[] bArr = getAuthRequestContext;
                    if (bArr != null) {
                        int length = bArr.length;
                        byte[] bArr2 = new byte[length];
                        for (int i8 = 0; i8 < length; i8++) {
                            bArr2[i8] = (byte) (bArr[i8] ^ 3097486228508854431L);
                        }
                        bArr = bArr2;
                    }
                    if ((bArr != null ? '\'' : (char) 15) != 15) {
                        i5 = (byte) (((byte) (getAuthRequestContext[((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)) + i] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
                        int i9 = $10 + 97;
                        $11 = i9 % 128;
                        int i10 = i9 % 2;
                    } else {
                        i5 = (short) (((short) (PlaceComponentResult[((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)) + i] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
                        int i11 = $10 + 43;
                        $11 = i11 % 128;
                        int i12 = i11 % 2;
                    }
                }
                if (i5 > 0) {
                    int i13 = $10 + 117;
                    $11 = i13 % 128;
                    int i14 = i13 % 2;
                    int i15 = ((i + i5) - 2) + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L));
                    if (z) {
                        int i16 = $10 + 33;
                        $11 = i16 % 128;
                        int i17 = i16 % 2;
                        i4 = 1;
                    } else {
                        int i18 = $10 + 21;
                        $11 = i18 % 128;
                        int i19 = i18 % 2;
                        i4 = 0;
                    }
                    b2.getAuthRequestContext = i15 + i4;
                    b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)));
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    byte[] bArr3 = getAuthRequestContext;
                    if (bArr3 != null) {
                        int length2 = bArr3.length;
                        byte[] bArr4 = new byte[length2];
                        int i20 = 0;
                        while (true) {
                            if ((i20 < length2 ? '\n' : (char) 27) == 27) {
                                break;
                            }
                            bArr4[i20] = (byte) (bArr3[i20] ^ 3097486228508854431L);
                            i20++;
                        }
                        bArr3 = bArr4;
                    }
                    boolean z2 = bArr3 != null;
                    b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                    while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i5) {
                        try {
                            int i21 = $11 + 121;
                            $10 = i21 % 128;
                            int i22 = i21 % 2;
                            if (z2) {
                                int i23 = $11 + 107;
                                $10 = i23 % 128;
                                if ((i23 % 2 != 0 ? (char) 23 : (char) 3) != 3) {
                                    byte[] bArr5 = getAuthRequestContext;
                                    b2.getAuthRequestContext = b2.getAuthRequestContext >>> 1;
                                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult % (((byte) (((byte) (bArr5[r9] - 3097486228508854431L)) * s)) | b));
                                } else {
                                    byte[] bArr6 = getAuthRequestContext;
                                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr6[r9] ^ 3097486228508854431L)) + s)) ^ b));
                                }
                            } else {
                                short[] sArr = PlaceComponentResult;
                                b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                                b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                                int i24 = $10 + 93;
                                $11 = i24 % 128;
                                int i25 = i24 % 2;
                            }
                            sb.append(b2.MyBillsEntityDataFactory);
                            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                            b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                }
                objArr[0] = sb.toString();
            }
        });
    }
}
