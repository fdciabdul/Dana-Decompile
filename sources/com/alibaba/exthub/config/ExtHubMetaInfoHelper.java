package com.alibaba.exthub.config;

import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.NebulaConfigBase;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class ExtHubMetaInfoHelper {
    public static void dumpMetaInfoConfigJava(Map<String, List<NebulaConfigBase<?>>> map, String str) {
        File file;
        if (map == null || map.size() <= 0) {
            file = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("com");
            sb.append(File.separator);
            sb.append("alibaba");
            sb.append(File.separator);
            sb.append("exthub");
            sb.append(File.separator);
            sb.append("config");
            File file2 = new File(str, sb.toString());
            file2.mkdirs();
            file = new File(file2, "ExtraExtHubMainfest.java");
        }
        if (file == null) {
            return;
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("package com.alibaba.exthub.config;\n\nimport com.alibaba.exthub.manifest.ExtHubMainfest;\nimport java.util.ArrayList;\nimport java.util.List;\nimport java.util.Map;\n\nimport com.alibaba.exthub.ExtHubBridgeExtensionManifest;\nimport com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;\n\n/**\n * Created by qipu on 2019/1/20.\n */\npublic class ExtraExtHubMainfest extends ExtHubMainfest {\n\n    private boolean mInited = false;\n    private List<ExtHubBridgeExtensionManifest> mExtensionList;\n\n\n    @Override\n    public List<ExtHubBridgeExtensionManifest> getBridgeExtensions() {\n        if (mInited) {\n            return mExtensionList;\n        }\n        mInited = true;\n\n        initExtension();\n        return mExtensionList;\n}\n\n\n    private void initExtension() {\n        mExtensionList = super.getBridgeExtensions();\n        ExtHubBridgeExtensionManifest extensionManifest = null;\n        ExtensionMetaInfo extension = null;\n\n");
            for (Map.Entry<String, List<NebulaConfigBase<?>>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<NebulaConfigBase<?>> value = entry.getValue();
                if (key != null && key.length() >= 0 && value != null && value.size() >= 0) {
                    for (NebulaConfigBase<?> nebulaConfigBase : value) {
                        if (nebulaConfigBase instanceof ExtensionMetaInfo) {
                            fileWriter.write("        extensionManifest = new ExtHubBridgeExtensionManifest();\n");
                            fileWriter.write("        extensionManifest.isRawType = true;\n");
                            fileWriter.write("        extension = new ExtensionMetaInfo(");
                            String str2 = "";
                            String str3 = (((ExtensionMetaInfo) nebulaConfigBase).bundleName == null || ((ExtensionMetaInfo) nebulaConfigBase).bundleName.length() <= 0) ? "" : ((ExtensionMetaInfo) nebulaConfigBase).bundleName;
                            fileWriter.write("\"");
                            fileWriter.write(str3);
                            fileWriter.write("\"\n");
                            fileWriter.write(", ");
                            fileWriter.write("\"");
                            fileWriter.write(((ExtensionMetaInfo) nebulaConfigBase).extensionClass);
                            fileWriter.write("\"");
                            fileWriter.write(", ");
                            fileWriter.write("\"");
                            fileWriter.write(((ExtensionMetaInfo) nebulaConfigBase).filterStrs);
                            fileWriter.write("\"");
                            fileWriter.write(", ");
                            fileWriter.write("\"");
                            if (((ExtensionMetaInfo) nebulaConfigBase).scopeClassName != null && ((ExtensionMetaInfo) nebulaConfigBase).scopeClassName.length() > 0) {
                                str2 = ((ExtensionMetaInfo) nebulaConfigBase).scopeClassName;
                            }
                            fileWriter.write(str2);
                            fileWriter.write("\"");
                            fileWriter.write(", ");
                            fileWriter.write("\"");
                            fileWriter.write(((ExtensionMetaInfo) nebulaConfigBase).typeString);
                            fileWriter.write("\"");
                            fileWriter.write(", ");
                            fileWriter.write(((ExtensionMetaInfo) nebulaConfigBase).isLazy ? SummaryActivity.CHECKED : "false");
                            fileWriter.write(");\n");
                            fileWriter.write("        extensionManifest.extensionMetaInfo = extension;");
                            fileWriter.write("\n");
                            fileWriter.write("        mExtensionList.add(extensionManifest);");
                            fileWriter.write("\n");
                            fileWriter.write("\n");
                        }
                    }
                }
            }
            fileWriter.write("    }\n\n}");
            fileWriter.flush();
            fileWriter.close();
        } catch (Throwable unused) {
        }
    }

    public static File createExtHubMetaInfoMF(File file, File file2) throws IOException {
        List<NebulaConfigBase<?>> readExtHubMetaInfo = new ExtHubMetaInfoParser().readExtHubMetaInfo(file);
        if (readExtHubMetaInfo == null || readExtHubMetaInfo.isEmpty()) {
            return null;
        }
        File file3 = new File(file2, ExtHubMetaInfoParser.META_INF_EXTHUB_METAINFO_MF);
        if (file3.exists()) {
            file3.delete();
        }
        file3.createNewFile();
        new ExtHubMetaInfoOperator().writeMetaInfo(readExtHubMetaInfo, file3);
        return file3;
    }
}
