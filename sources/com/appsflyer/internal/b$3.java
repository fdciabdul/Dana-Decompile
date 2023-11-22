package com.appsflyer.internal;

import com.alibaba.ariver.kernel.RVParams;
import id.dana.data.here.model.HereUrlConstant;
import java.util.HashMap;

/* loaded from: classes7.dex */
public final class b$3 extends HashMap<String, String> {
    public b$3() {
        put("aa", "ro.arch");
        put("ab", "ro.chipname");
        put("ac", "ro.dalvik.vm.native.bridge");
        put("ad", "persist.sys.nativebridge");
        put("ae", "ro.enable.native.bridge.exec");
        put("af", "dalvik.vm.isa.x86.features");
        put("ag", "dalvik.vm.isa.x86.variant");
        put("ah", "ro.zygote");
        put("ai", "ro.allow.mock.location");
        put("aj", "ro.dalvik.vm.isa.arm");
        put("ak", "dalvik.vm.isa.arm.features");
        put("al", "dalvik.vm.isa.arm.variant");
        put("am", "dalvik.vm.isa.arm64.features");
        put("an", "dalvik.vm.isa.arm64.variant");
        put("ao", "vzw.os.rooted");
        put(RVParams.ANTI_PHISHING, "ro.build.user");
        put("aq", "ro.kernel.qemu");
        put("ar", "ro.hardware");
        put("as", "ro.product.cpu.abi");
        put(HereUrlConstant.AT, "ro.product.cpu.abilist");
        put("au", "ro.product.cpu.abilist32");
        put("av", "ro.product.cpu.abilist64");
    }
}
