package com.xiaomi.push;

import android.text.TextUtils;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import com.xiaomi.push.ch;
import com.xiaomi.push.cl;
import com.xiaomi.push.cn;
import com.xiaomi.push.service.az;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes8.dex */
public class cr {
    private static XmlPullParser PlaceComponentResult;

    private static cn MyBillsEntityDataFactory(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = "-1";
        String str2 = null;
        String str3 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals(ZdocRecordService.REASON)) {
                str2 = xmlPullParser.getAttributeValue("", ZdocRecordService.REASON);
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(xmlPullParser.getNamespace())) {
                        str4 = name;
                    } else {
                        arrayList.add(PlaceComponentResult(xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new cn(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
    }

    private static cg PlaceComponentResult(XmlPullParser xmlPullParser) {
        Object MyBillsEntityDataFactory = cq.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory("all", "xm:chat");
        if (MyBillsEntityDataFactory == null || !(MyBillsEntityDataFactory instanceof com.xiaomi.push.service.k)) {
            return null;
        }
        com.xiaomi.push.service.k kVar = (com.xiaomi.push.service.k) MyBillsEntityDataFactory;
        return com.xiaomi.push.service.k.PlaceComponentResult(xmlPullParser);
    }

    public static cm getAuthRequestContext(XmlPullParser xmlPullParser) {
        cm cmVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                cmVar = new cm(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return cmVar;
    }

    private static String lookAheadTest(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(xmlPullParser.getText());
            str = sb.toString();
        }
    }

    private static String moveToNextValue(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || (HereUrlConstant.LANG.equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static ch getAuthRequestContext(XmlPullParser xmlPullParser, bt btVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", LoginTrackingConstants.LoginParam.TO);
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        ch.a authRequestContext = ch.a.getAuthRequestContext(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        ch chVar = null;
        cn cnVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    cnVar = MyBillsEntityDataFactory(xmlPullParser);
                } else {
                    chVar = new ch();
                    chVar.PrepareContext.add(PlaceComponentResult(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (chVar == null) {
            if (ch.a.PlaceComponentResult == authRequestContext || ch.a.BuiltInFictitiousFunctionClassFactory == authRequestContext) {
                cs csVar = new cs();
                csVar.newProxyInstance = attributeValue;
                csVar.NetworkUserEntityData$$ExternalSyntheticLambda7 = attributeValue3;
                csVar.NetworkUserEntityData$$ExternalSyntheticLambda8 = attributeValue2;
                ch.a aVar = ch.a.MyBillsEntityDataFactory;
                if (aVar == null) {
                    aVar = ch.a.PlaceComponentResult;
                }
                csVar.PlaceComponentResult = aVar;
                csVar.NetworkUserEntityData$$ExternalSyntheticLambda3 = attributeValue4;
                csVar.isLayoutRequested = new cn(cn.a.BuiltInFictitiousFunctionClassFactory);
                btVar.KClassImpl$Data$declaredNonStaticMembers$2(csVar);
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("iq usage error. send packet in packet parser.");
                return null;
            }
            chVar = new ct();
        }
        chVar.newProxyInstance = attributeValue;
        chVar.NetworkUserEntityData$$ExternalSyntheticLambda7 = attributeValue2;
        chVar.NetworkUserEntityData$$ExternalSyntheticLambda3 = attributeValue4;
        chVar.NetworkUserEntityData$$ExternalSyntheticLambda8 = attributeValue3;
        if (authRequestContext == null) {
            authRequestContext = ch.a.PlaceComponentResult;
        }
        chVar.PlaceComponentResult = authRequestContext;
        chVar.isLayoutRequested = cnVar;
        synchronized (chVar) {
            chVar.BuiltInFictitiousFunctionClassFactory.putAll(hashMap);
        }
        return chVar;
    }

    public static cj KClassImpl$Data$declaredNonStaticMembers$2(XmlPullParser xmlPullParser) {
        String str;
        byte[] KClassImpl$Data$declaredNonStaticMembers$2;
        int i = 2;
        String str2 = null;
        cj cjVar = null;
        boolean z = false;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", LoginTrackingConstants.LoginParam.TO);
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            az.b MyBillsEntityDataFactory = com.xiaomi.push.service.az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(attributeValue, attributeValue4);
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = com.xiaomi.push.service.az.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(attributeValue, attributeValue3);
            }
            if (MyBillsEntityDataFactory != null) {
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == i) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new cd("error while receiving a encrypted message with wrong format");
                        }
                        if (xmlPullParser.next() != 4) {
                            throw new cd("error while receiving a encrypted message with wrong format");
                        }
                        String text = xmlPullParser.getText();
                        if (!"5".equals(attributeValue) && !"6".equals(attributeValue)) {
                            KClassImpl$Data$declaredNonStaticMembers$2 = com.xiaomi.push.service.bh.KClassImpl$Data$declaredNonStaticMembers$2(com.xiaomi.push.service.bh.getAuthRequestContext(MyBillsEntityDataFactory.isLayoutRequested, attributeValue2), aa.BuiltInFictitiousFunctionClassFactory(text));
                            if (PlaceComponentResult == null) {
                                try {
                                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                                    PlaceComponentResult = newPullParser;
                                    newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                                } catch (XmlPullParserException unused) {
                                }
                            }
                            PlaceComponentResult.setInput(new InputStreamReader(new ByteArrayInputStream(KClassImpl$Data$declaredNonStaticMembers$2)));
                            PlaceComponentResult.next();
                            cjVar = KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
                        } else {
                            ci ciVar = new ci();
                            ciVar.NetworkUserEntityData$$ExternalSyntheticLambda3 = attributeValue;
                            ciVar.BuiltInFictitiousFunctionClassFactory = true;
                            ciVar.NetworkUserEntityData$$ExternalSyntheticLambda8 = attributeValue3;
                            ciVar.NetworkUserEntityData$$ExternalSyntheticLambda7 = attributeValue4;
                            ciVar.newProxyInstance = attributeValue2;
                            ciVar.PlaceComponentResult = attributeValue5;
                            cg cgVar = new cg("s");
                            if (!TextUtils.isEmpty(text)) {
                                text = cu.BuiltInFictitiousFunctionClassFactory(text);
                            }
                            cgVar.MyBillsEntityDataFactory = text;
                            ciVar.PrepareContext.add(cgVar);
                            return ciVar;
                        }
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        i = 2;
                        z = true;
                    }
                    i = 2;
                }
                if (cjVar != null) {
                    return cjVar;
                }
                throw new cd("error while receiving a encrypted message with wrong format");
            }
            throw new cd("the channel id is wrong while receiving a encrypted message");
        }
        ci ciVar2 = new ci();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        ciVar2.newProxyInstance = attributeValue6;
        ciVar2.NetworkUserEntityData$$ExternalSyntheticLambda7 = xmlPullParser.getAttributeValue("", LoginTrackingConstants.LoginParam.TO);
        ciVar2.NetworkUserEntityData$$ExternalSyntheticLambda8 = xmlPullParser.getAttributeValue("", "from");
        ciVar2.NetworkUserEntityData$$ExternalSyntheticLambda3 = xmlPullParser.getAttributeValue("", "chid");
        ciVar2.scheduleImpl = xmlPullParser.getAttributeValue("", "appid");
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused2) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                ciVar2.NetworkUserEntityData$$ExternalSyntheticLambda0 = attributeValue7;
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                ciVar2.NetworkUserEntityData$$ExternalSyntheticLambda1 = attributeValue8;
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                ciVar2.GetContactSyncConfig = attributeValue9;
            }
        } catch (Exception unused5) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                ciVar2.NetworkUserEntityData$$ExternalSyntheticLambda2 = attributeValue10;
            }
        } catch (Exception unused6) {
        }
        ciVar2.KClassImpl$Data$declaredNonStaticMembers$2 = !TextUtils.isEmpty(str) && str.equalsIgnoreCase(SummaryActivity.CHECKED);
        ciVar2.PlaceComponentResult = xmlPullParser.getAttributeValue("", "type");
        String moveToNextValue = moveToNextValue(xmlPullParser);
        if (moveToNextValue == null || "".equals(moveToNextValue.trim())) {
            cj.PlaceComponentResult();
        } else {
            ciVar2.getAuthRequestContext = moveToNextValue;
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                TextUtils.isEmpty(xmlPullParser.getNamespace());
                if (name.equals("subject")) {
                    moveToNextValue(xmlPullParser);
                    ciVar2.moveToNextValue = lookAheadTest(xmlPullParser);
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String lookAheadTest = lookAheadTest(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        ciVar2.lookAheadTest = lookAheadTest;
                        ciVar2.getErrorConfigVersion = attributeValue11;
                    } else {
                        ciVar2.lookAheadTest = lookAheadTest;
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    ciVar2.isLayoutRequested = MyBillsEntityDataFactory(xmlPullParser);
                } else {
                    ciVar2.PrepareContext.add(PlaceComponentResult(xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        ciVar2.MyBillsEntityDataFactory = str2;
        return ciVar2;
    }

    public static cl BuiltInFictitiousFunctionClassFactory(XmlPullParser xmlPullParser) {
        cl.b bVar = cl.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = cl.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                PrintStream printStream = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append("Found invalid presence type ");
                sb.append(attributeValue);
                printStream.println(sb.toString());
            }
        }
        cl clVar = new cl(bVar);
        clVar.NetworkUserEntityData$$ExternalSyntheticLambda7 = xmlPullParser.getAttributeValue("", LoginTrackingConstants.LoginParam.TO);
        clVar.NetworkUserEntityData$$ExternalSyntheticLambda8 = xmlPullParser.getAttributeValue("", "from");
        clVar.NetworkUserEntityData$$ExternalSyntheticLambda3 = xmlPullParser.getAttributeValue("", "chid");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        clVar.newProxyInstance = attributeValue2;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    clVar.PlaceComponentResult = xmlPullParser.nextText();
                } else if (name.equals("priority")) {
                    try {
                        clVar.MyBillsEntityDataFactory(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        clVar.MyBillsEntityDataFactory(0);
                    }
                } else if (name.equals(ContainerUIProvider.KEY_SHOW)) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        clVar.KClassImpl$Data$declaredNonStaticMembers$2 = cl.a.valueOf(nextText);
                    } catch (IllegalArgumentException unused4) {
                        PrintStream printStream2 = System.err;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Found invalid presence mode ");
                        sb2.append(nextText);
                        printStream2.println(sb2.toString());
                    }
                } else if (name.equals("error")) {
                    clVar.isLayoutRequested = MyBillsEntityDataFactory(xmlPullParser);
                } else {
                    clVar.PrepareContext.add(PlaceComponentResult(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return clVar;
    }
}
