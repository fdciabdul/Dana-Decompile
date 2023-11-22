package com.appsflyer.internal;

import android.content.Context;
import android.database.Cursor;
import java.util.Map;

/* loaded from: classes.dex */
public final class bw extends bq {
    public bw(Runnable runnable) {
        super("samsung", runnable);
    }

    @Override // com.appsflyer.internal.bt
    public final void AFInAppEventParameterName(Context context) {
        AFInAppEventParameterName(context, new aw<Map<String, Object>>(context, "com.sec.android.app.samsungapps.referrer", "FBA3AF4E7757D9016E953FB3EE4671CA2BD9AF725F9A53D52ED4A38EAAA08901") { // from class: com.appsflyer.internal.bw.3
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x00bd, code lost:
            
                if (r3 != null) goto L24;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x00d1, code lost:
            
                if (0 == 0) goto L25;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x00d3, code lost:
            
                r3.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00d6, code lost:
            
                r0 = ((android.content.pm.PackageItemInfo) r11.values.getPackageManager().resolveContentProvider(r11.valueOf, 128)).packageName;
                r11.AFInAppEventType.AFKeystoreWrapper.put("api_ver", java.lang.Long.valueOf(com.appsflyer.internal.aa.values(r11.values, r0)));
                r11.AFInAppEventType.AFKeystoreWrapper.put("api_ver_name", com.appsflyer.internal.aa.AFKeystoreWrapper(r11.values, r0));
                r11.AFInAppEventType.AFKeystoreWrapper();
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0111, code lost:
            
                return r11.AFInAppEventType.AFKeystoreWrapper;
             */
            @Override // com.appsflyer.internal.aw
            /* renamed from: AFInAppEventParameterName  reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.Map<java.lang.String, java.lang.Object> AFKeystoreWrapper() {
                /*
                    Method dump skipped, instructions count: 280
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.bw.AnonymousClass3.AFKeystoreWrapper():java.util.Map");
            }

            private static void values(String str, Map<String, Object> map, Cursor cursor) {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1) {
                    return;
                }
                long j = cursor.getLong(columnIndex);
                if (j == 0) {
                    return;
                }
                map.put(str, Long.valueOf(j));
            }

            private static void AFKeystoreWrapper(String str, Map<String, Object> map, Cursor cursor) {
                String string;
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1 || (string = cursor.getString(columnIndex)) == null) {
                    return;
                }
                map.put(str, string);
            }
        });
    }
}
