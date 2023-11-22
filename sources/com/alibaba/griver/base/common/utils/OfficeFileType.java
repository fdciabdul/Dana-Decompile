package com.alibaba.griver.base.common.utils;

/* loaded from: classes2.dex */
public enum OfficeFileType {
    Doc("doc"),
    Docx("docx"),
    Xls("xls"),
    Xlsx("xlsx"),
    PPt("ppt"),
    PPtx("pptx"),
    Pdf("pdf");

    private String code;

    OfficeFileType(String str) {
        this.code = str;
    }

    public final String fileType() {
        return this.code;
    }

    public final boolean checkType(String str) {
        return this.code.equalsIgnoreCase(str);
    }
}
