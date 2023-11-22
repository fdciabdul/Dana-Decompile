package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.alipay.alipaysecuritysdk.rds.constant.DictionaryKeys;
import com.alipay.mobile.rome.longlinkservice.LongLinkMsgConstants;
import com.xiaomi.push.ak;
import com.xiaomi.push.au;
import com.xiaomi.push.cu;
import com.xiaomi.push.service.bn;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class be extends bn.a implements ak.a {
    private long KClassImpl$Data$declaredNonStaticMembers$2;
    private XMPushService getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a implements ak.b {
        a() {
        }

        @Override // com.xiaomi.push.ak.b
        public final String BuiltInFictitiousFunctionClassFactory(String str) {
            Context context;
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(DictionaryKeys.V2_SDKVER, "48");
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            StringBuilder sb = new StringBuilder();
            sb.append(Build.MODEL);
            sb.append(":");
            sb.append(Build.VERSION.INCREMENTAL);
            buildUpon.appendQueryParameter(H5GetLogInfoBridge.RESULT_OS, cu.BuiltInFictitiousFunctionClassFactory(sb.toString()));
            buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.channel.commonutils.android.j.PlaceComponentResult()));
            URL url = new URL(buildUpon.toString());
            if (url.getPort() != -1) {
                url.getPort();
            }
            try {
                context = com.xiaomi.channel.commonutils.android.j.BuiltInFictitiousFunctionClassFactory;
                return com.xiaomi.push.y.getAuthRequestContext(context, url);
            } catch (IOException e) {
                throw e;
            }
        }
    }

    /* loaded from: classes8.dex */
    static class b extends com.xiaomi.push.ak {
        protected b(Context context, com.xiaomi.push.aj ajVar, ak.b bVar, String str) {
            super(context, null, bVar, str);
        }

        @Override // com.xiaomi.push.ak
        public final String MyBillsEntityDataFactory(ArrayList<String> arrayList, String str, String str2, boolean z) {
            try {
                return super.MyBillsEntityDataFactory(arrayList, str, str2, z);
            } catch (IOException e) {
                com.xiaomi.push.y.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
                throw e;
            }
        }
    }

    private be(XMPushService xMPushService) {
        this.getAuthRequestContext = xMPushService;
    }

    @Override // com.xiaomi.push.ak.a
    public final com.xiaomi.push.ak BuiltInFictitiousFunctionClassFactory(Context context, ak.b bVar, String str) {
        return new b(context, null, bVar, str);
    }

    @Override // com.xiaomi.push.service.bn.a
    public final void BuiltInFictitiousFunctionClassFactory(au.b bVar) {
        com.xiaomi.push.ag MyBillsEntityDataFactory;
        boolean z;
        if (bVar.BuiltInFictitiousFunctionClassFactory() && bVar.MyBillsEntityDataFactory() && System.currentTimeMillis() - this.KClassImpl$Data$declaredNonStaticMembers$2 > 3600000) {
            StringBuilder sb = new StringBuilder();
            sb.append("fetch bucket :");
            sb.append(bVar.MyBillsEntityDataFactory());
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            this.KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis();
            com.xiaomi.push.ak MyBillsEntityDataFactory2 = com.xiaomi.push.ak.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2();
            MyBillsEntityDataFactory2.getAuthRequestContext();
            com.xiaomi.push.bt m385a = this.getAuthRequestContext.m385a();
            if (m385a == null || (MyBillsEntityDataFactory = MyBillsEntityDataFactory2.MyBillsEntityDataFactory(m385a.MyBillsEntityDataFactory().getAuthRequestContext())) == null) {
                return;
            }
            ArrayList<String> BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
            Iterator<String> it = BuiltInFictitiousFunctionClassFactory.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m385a.lookAheadTest())) {
                    z = false;
                    break;
                }
            }
            if (!z || BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("bucket changed, force reconnect");
            this.getAuthRequestContext.a(0, (Exception) null);
            this.getAuthRequestContext.a(false);
        }
    }

    public static void getAuthRequestContext(XMPushService xMPushService) {
        bn bnVar;
        be beVar = new be(xMPushService);
        bnVar = bn.BuiltInFictitiousFunctionClassFactory;
        synchronized (bnVar) {
            bnVar.getAuthRequestContext.add(beVar);
        }
        synchronized (com.xiaomi.push.ak.class) {
            com.xiaomi.push.ak.PlaceComponentResult(beVar);
            com.xiaomi.push.ak.getAuthRequestContext(xMPushService, new a(), "0", LongLinkMsgConstants.MSG_PACKET_CHANNEL_PUSH, "2.2");
        }
    }
}
