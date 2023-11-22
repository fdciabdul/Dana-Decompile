package com.ta.audid.g;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: classes.dex */
public class c {
    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static String f(String str) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(str));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            char[] cArr = new char[100];
            StringBuilder sb = new StringBuilder("");
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read == -1) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
            String obj = sb.toString();
            try {
                inputStreamReader.close();
            } catch (Exception e) {
                m.e("", e, new Object[0]);
            }
            return obj;
        } catch (Exception unused2) {
            inputStreamReader2 = inputStreamReader;
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (Exception e2) {
                    m.e("", e2, new Object[0]);
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader2 = inputStreamReader;
            if (inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (Exception e3) {
                    m.e("", e3, new Object[0]);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.io.BufferedReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String g(java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.lang.String r1 = r6.readLine()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r6.close()     // Catch: java.lang.Exception -> L16
            goto L1c
        L16:
            r6 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r6, r4)
        L1c:
            r3.close()     // Catch: java.lang.Exception -> L20
            goto L26
        L20:
            r6 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r6, r2)
        L26:
            return r1
        L27:
            r1 = move-exception
            goto L5d
        L29:
            r1 = move-exception
            r5 = r3
            r3 = r1
            goto L33
        L2d:
            r6 = move-exception
            goto L60
        L2f:
            r6 = move-exception
            r5 = r3
            r3 = r6
            r6 = r1
        L33:
            r1 = r5
            goto L3b
        L35:
            r6 = move-exception
            r3 = r1
            goto L60
        L38:
            r6 = move-exception
            r3 = r6
            r6 = r1
        L3b:
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L59
            com.ta.audid.g.m.e(r0, r3, r4)     // Catch: java.lang.Throwable -> L59
            if (r6 == 0) goto L4c
            r6.close()     // Catch: java.lang.Exception -> L46
            goto L4c
        L46:
            r6 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r6, r3)
        L4c:
            if (r1 == 0) goto L58
            r1.close()     // Catch: java.lang.Exception -> L52
            goto L58
        L52:
            r6 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r6, r1)
        L58:
            return r0
        L59:
            r3 = move-exception
            r5 = r3
            r3 = r1
            r1 = r5
        L5d:
            r5 = r1
            r1 = r6
            r6 = r5
        L60:
            if (r1 == 0) goto L6c
            r1.close()     // Catch: java.lang.Exception -> L66
            goto L6c
        L66:
            r1 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r1, r4)
        L6c:
            if (r3 == 0) goto L78
            r3.close()     // Catch: java.lang.Exception -> L72
            goto L78
        L72:
            r1 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r1, r2)
        L78:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.audid.g.c.g(java.lang.String):java.lang.String");
    }

    /*  JADX ERROR: Type inference failed with exception
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:151)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:62)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.tryWiderObjects(TypeInferenceVisitor.java:862)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.deduceType(TypeInferenceVisitor.java:477)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.tryDeduceTypes(TypeInferenceVisitor.java:452)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
        */
    /* JADX WARN: Failed to calculate best type for var: r3v0 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.deduceType(TypeInferenceVisitor.java:469)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.tryDeduceTypes(TypeInferenceVisitor.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Failed to calculate best type for var: r3v0 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:151)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Failed to calculate best type for var: r3v1 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.deduceType(TypeInferenceVisitor.java:469)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.tryDeduceTypes(TypeInferenceVisitor.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Failed to calculate best type for var: r3v1 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:151)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Failed to calculate best type for var: r3v3 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:151)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Failed to calculate best type for var: r3v4 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:151)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Failed to calculate best type for var: r3v5 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:151)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Failed to calculate best type for var: r3v6 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:151)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Failed to calculate best type for var: r3v7 ??
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "changeArg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:418)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.moveListener(TypeUpdate.java:426)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:452)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:172)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.allSameListener(TypeUpdate.java:445)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runListeners(TypeUpdate.java:215)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:196)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdateForSsaVar(TypeUpdate.java:178)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeForSsaVar(TypeUpdate.java:166)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.updateTypeChecked(TypeUpdate.java:149)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:82)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:55)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:214)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:191)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:151)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:151)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x005f: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:39:0x005d */
    public static boolean b(java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            r2 = 0
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3b
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3b
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3b
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L3b
            java.io.BufferedWriter r5 = new java.io.BufferedWriter     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L5c
            r5.<init>(r3)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L5c
            r5.write(r6)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r5.flush()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r5.close()     // Catch: java.lang.Exception -> L1d
            goto L23
        L1d:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r5, r6)
        L23:
            r3.close()     // Catch: java.lang.Exception -> L27
            goto L2d
        L27:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r5, r6)
        L2d:
            r5 = 1
            return r5
        L2f:
            r6 = move-exception
            goto L61
        L31:
            r6 = move-exception
            r1 = r5
            goto L3e
        L34:
            r5 = move-exception
            r6 = r5
            goto L3e
        L37:
            r5 = move-exception
            r6 = r5
            r3 = r1
            goto L62
        L3b:
            r5 = move-exception
            r6 = r5
            r3 = r1
        L3e:
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L5c
            com.ta.audid.g.m.e(r0, r6, r5)     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto L4f
            r1.close()     // Catch: java.lang.Exception -> L49
            goto L4f
        L49:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r5, r6)
        L4f:
            if (r3 == 0) goto L5b
            r3.close()     // Catch: java.lang.Exception -> L55
            goto L5b
        L55:
            r5 = move-exception
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r5, r6)
        L5b:
            return r2
        L5c:
            r5 = move-exception
            r6 = r5
            r5 = r1
            r1 = r3
            r3 = r1
        L61:
            r1 = r5
        L62:
            if (r1 == 0) goto L6e
            r1.close()     // Catch: java.lang.Exception -> L68
            goto L6e
        L68:
            r5 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r5, r1)
        L6e:
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.lang.Exception -> L74
            goto L7a
        L74:
            r5 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r2]
            com.ta.audid.g.m.e(r0, r5, r1)
        L7a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.audid.g.c.b(java.lang.String, java.lang.String):boolean");
    }
}
