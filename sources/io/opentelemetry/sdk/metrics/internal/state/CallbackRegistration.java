package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.internal.ThrowableUtil;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.function.Consumer;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public final class CallbackRegistration {
    private static final Logger logger = Logger.getLogger(CallbackRegistration.class.getName());
    private final Runnable callback;
    private final String callbackDescription;
    private final boolean hasStorages;
    private final List<SdkObservableMeasurement> observableMeasurements;
    private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(logger);

    private CallbackRegistration(List<SdkObservableMeasurement> list, Runnable runnable) {
        this.observableMeasurements = list;
        this.callback = runnable;
        this.callbackDescription = callbackDescription((List) Collection.EL.getAuthRequestContext(list).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda0
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return ((SdkObservableMeasurement) obj).getInstrumentDescriptor();
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory()));
        this.hasStorages = Collection.EL.getAuthRequestContext(list).getAuthRequestContext(new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda1
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                Stream authRequestContext;
                authRequestContext = Collection.EL.getAuthRequestContext(((SdkObservableMeasurement) obj).getStorages());
                return authRequestContext;
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).NetworkUserEntityData$$ExternalSyntheticLambda7().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static CallbackRegistration create(List<SdkObservableMeasurement> list, Runnable runnable) {
        return new CallbackRegistration(list, runnable);
    }

    static String callbackDescription(List<InstrumentDescriptor> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("Callback with no instruments is not allowed");
        }
        if (list.size() == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Instrument ");
            sb.append(list.get(0).getName());
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("BatchCallback(");
        sb2.append((String) Collection.EL.getAuthRequestContext(list).KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda2
            @Override // j$.util.function.Function
            /* renamed from: andThen */
            public final /* synthetic */ Function mo3169andThen(Function function) {
                return Function.CC.getAuthRequestContext(this, function);
            }

            @Override // j$.util.function.Function
            public final Object apply(Object obj) {
                return ((InstrumentDescriptor) obj).getName();
            }

            @Override // j$.util.function.Function
            public final /* synthetic */ Function compose(Function function) {
                return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
            }
        }).BuiltInFictitiousFunctionClassFactory(Collectors.PlaceComponentResult(",", "[", "]")));
        sb2.append(")");
        return sb2.toString();
    }

    public final String getCallbackDescription() {
        return this.callbackDescription;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void invokeCallback(final RegisteredReader registeredReader) {
        List<SdkObservableMeasurement> list;
        Consumer consumer;
        if (this.hasStorages) {
            Iterable.EL.MyBillsEntityDataFactory(this.observableMeasurements, new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda3
                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    ((SdkObservableMeasurement) obj).setActiveReader(RegisteredReader.this);
                }

                @Override // j$.util.function.Consumer
                public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                    return Consumer.CC.PlaceComponentResult(this, consumer2);
                }
            });
            try {
                this.callback.run();
                list = this.observableMeasurements;
                consumer = new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda4
                    @Override // j$.util.function.Consumer
                    public final void accept(Object obj) {
                        ((SdkObservableMeasurement) obj).setActiveReader(null);
                    }

                    @Override // j$.util.function.Consumer
                    public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                        return Consumer.CC.PlaceComponentResult(this, consumer2);
                    }
                };
            } catch (Throwable th) {
                try {
                    ThrowableUtil.propagateIfFatal(th);
                    ThrottlingLogger throttlingLogger = this.throttlingLogger;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder();
                    sb.append("An exception occurred invoking callback for ");
                    sb.append(this.callbackDescription);
                    sb.append(".");
                    throttlingLogger.log(level, sb.toString(), th);
                    list = this.observableMeasurements;
                    consumer = new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda4
                        @Override // j$.util.function.Consumer
                        public final void accept(Object obj) {
                            ((SdkObservableMeasurement) obj).setActiveReader(null);
                        }

                        @Override // j$.util.function.Consumer
                        public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                            return Consumer.CC.PlaceComponentResult(this, consumer2);
                        }
                    };
                } catch (Throwable th2) {
                    Iterable.EL.MyBillsEntityDataFactory(this.observableMeasurements, new Consumer() { // from class: io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration$$ExternalSyntheticLambda4
                        @Override // j$.util.function.Consumer
                        public final void accept(Object obj) {
                            ((SdkObservableMeasurement) obj).setActiveReader(null);
                        }

                        @Override // j$.util.function.Consumer
                        public final /* synthetic */ Consumer andThen(Consumer consumer2) {
                            return Consumer.CC.PlaceComponentResult(this, consumer2);
                        }
                    });
                    throw th2;
                }
            }
            Iterable.EL.MyBillsEntityDataFactory(list, consumer);
        }
    }
}
