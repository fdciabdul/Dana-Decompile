package com.alipay.mobile.verifyidentity.framework.module;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.verifyidentity.base.log.VILog;
import com.alipay.mobile.verifyidentity.base.message.Message;
import com.alipay.mobile.verifyidentity.base.message.VIRespone;
import com.alipay.mobile.verifyidentity.base.product.IProduct;
import com.alipay.mobile.verifyidentity.base.product.ProductAssembly;
import com.alipay.mobile.verifyidentity.base.product.ProductAssemblyManager;

/* loaded from: classes3.dex */
public class VIModule {
    public static final String TAG = "VIModule";
    private Context context;
    private Message message;
    private ProductAssembly productAssembly;

    /* loaded from: classes3.dex */
    public interface Callback {
        void onAction(String str);

        void onResult(IProduct iProduct, VIRespone vIRespone);
    }

    public void stop() {
    }

    public VIModule(Context context, Message message) {
        this.context = context;
        this.message = message;
    }

    public void setProductAssembly(ProductAssembly productAssembly) {
        this.productAssembly = productAssembly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IProduct createProduct(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("create product ");
        sb.append(str);
        VILog.i(str2, sb.toString());
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                return (IProduct) cls.newInstance();
            }
            return null;
        } catch (Throwable th) {
            VILog.e(TAG, th);
            return null;
        }
    }

    public void start(final Callback callback) {
        ProductAssembly productAssembly = this.productAssembly;
        if (productAssembly == null) {
            if (callback != null) {
                VILog.e(TAG, "not found product");
                callback.onResult(null, new VIRespone(1008));
            }
        } else if (productAssembly.number() > 0) {
            IProduct createProduct = createProduct(this.productAssembly.getFirstProduct());
            if (createProduct != null) {
                createProduct.startProduct(this.context, this.message, new IProduct.ICallback() { // from class: com.alipay.mobile.verifyidentity.framework.module.VIModule.1
                    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct.ICallback
                    public void onAction(String str) {
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.onAction(str);
                        }
                    }

                    @Override // com.alipay.mobile.verifyidentity.base.product.IProduct.ICallback
                    public void onResult(IProduct iProduct, VIRespone vIRespone) {
                        if (vIRespone.getResult() == 1000) {
                            if (VIModule.this.productAssembly.getProcessType() == ProductAssembly.ProcessType.AND) {
                                if (VIModule.this.productAssembly.getNextProduct() == null || VIModule.this.productAssembly.getNextProduct().isEmpty()) {
                                    return;
                                }
                                VIModule vIModule = VIModule.this;
                                IProduct createProduct2 = vIModule.createProduct(vIModule.productAssembly.getNextProduct());
                                if (createProduct2 != null) {
                                    createProduct2.startProduct(VIModule.this.context, VIModule.this.message, this);
                                    return;
                                }
                                String str = VIModule.TAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("no exist this prodct:");
                                sb.append(VIModule.this.productAssembly.getFirstProduct());
                                VILog.e(str, sb.toString());
                                Callback callback2 = callback;
                                if (callback2 != null) {
                                    callback2.onResult(iProduct, new VIRespone(1008));
                                    return;
                                }
                                return;
                            }
                            Callback callback3 = callback;
                            if (callback3 != null) {
                                callback3.onResult(iProduct, vIRespone);
                            }
                        } else if (VIModule.this.productAssembly.getProcessType() == ProductAssembly.ProcessType.OR) {
                            if (VIModule.this.productAssembly.getNextProduct() != null && !VIModule.this.productAssembly.getNextProduct().isEmpty()) {
                                VIModule vIModule2 = VIModule.this;
                                IProduct createProduct3 = vIModule2.createProduct(vIModule2.productAssembly.getNextProduct());
                                if (createProduct3 != null) {
                                    createProduct3.startProduct(VIModule.this.context, VIModule.this.message, this);
                                    return;
                                }
                                String str2 = VIModule.TAG;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("no exist this prodct:");
                                sb2.append(VIModule.this.productAssembly.getFirstProduct());
                                VILog.e(str2, sb2.toString());
                                Callback callback4 = callback;
                                if (callback4 != null) {
                                    callback4.onResult(iProduct, new VIRespone(1008));
                                    return;
                                }
                                return;
                            }
                            Callback callback5 = callback;
                            if (callback5 != null) {
                                callback5.onResult(iProduct, vIRespone);
                            }
                        } else {
                            Callback callback6 = callback;
                            if (callback6 != null) {
                                callback6.onResult(iProduct, vIRespone);
                            }
                        }
                    }
                });
                return;
            }
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("no exist this prodct:");
            sb.append(this.productAssembly.getFirstProduct());
            VILog.e(str, sb.toString());
            if (callback != null) {
                callback.onResult(createProduct, new VIRespone(1008));
            }
        }
    }

    public String getEnvInfo(String str) {
        ProductAssembly productAssembly = this.productAssembly;
        return (productAssembly == null || productAssembly.getEnvInfo() == null) ? "" : this.productAssembly.getEnvInfo().getEnvInfo(this.context, str);
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        public VIModule create(Context context, Message message) {
            if (message != null) {
                String productCode = message.getProductCode();
                message.getNextStep();
                String nextStep = message.getNextStep();
                if (TextUtils.isEmpty(productCode)) {
                    productCode = nextStep;
                }
                ProductAssembly productAssembly = ProductAssemblyManager.getProductAssembly(productCode);
                VIModule vIModule = new VIModule(context, message);
                vIModule.setProductAssembly(productAssembly);
                return vIModule;
            }
            return null;
        }

        public VIModule create(Context context, String str) {
            if (str != null) {
                ProductAssembly productAssembly = ProductAssemblyManager.getProductAssembly(str);
                VIModule vIModule = new VIModule(context, null);
                vIModule.setProductAssembly(productAssembly);
                return vIModule;
            }
            return null;
        }
    }
}
