var document, AlipayJSBridge, window, self = {};
// window self 指向global 对象
window = self = this;
self.importScript = importScripts;
    var messenger = window.console,
        log = messenger.log;
    var nativeFlushQueueImmediate = function(msg) {
        log.call(messenger, "{bridge_token}h5container.message: " + msg)
    };
self.__APPX_DEVTOOLS_GLOBAL_HOOK__ = {
  setup(runtime, interceptors) {
    interceptors.pageFlexibleLogicInstanceMethodInterceptor.all(
      "setData",
      (context, args) => {
        try {
          let dataLength = JSON.stringify(args[1]).length;
          let page = context.pagePath;
          let viewId = context.pageId;
          AlipayJSBridge.call("handleLoggingAction", {
            subType: "grvOnSetData",
            commonData: { dataLength, page, viewId },
          });
        } catch {}
      },
      () => {}
    );
  },
};
(function() {
    var myeval = self.eval;
    window.onmessage = function(e) {
        var msg = e.data;

        //console.log('recv render data is :' + JSON.stringify(msg));

        if (msg.action === undefined) {
            if (msg.startsWith("console")) {
                myeval(msg);
            } else {
                importScripts(msg);
            }
        } else {
            switch (msg.action) {
                case 'exec':
                    myeval(msg.data);
                    break;
                case 'setMessagePort':
                    console.log('set MessagePort', e.ports);
                    break;
                case 'import':
                    importScripts(msg.data);
                    break;
                case 'log':
                    console.log(msg.data);
                    break;
                case 'callBridge':
                    if (typeof AlipayJSBridge === 'object') {
                        AlipayJSBridge._handleMessageFromNative(JSON.stringify(msg.data));
                    } else {
                        console.log("AlipayJSBridge not ready");
                    }
                    break;
                default:
                    console.log("error action " + JSON.stringify(msg));
                    break;
            }
        }
    }
})();

(function () {
  var handlers = {};
  var windowHanders = {};
  var sendMessageQueue = [];

  function Event(name) {
    this.name = name;
  }

  Event.prototype = {
    preventDefault: function () {
      this._preventDefault = true;
    },
    initEvent: function(name) {
      this.name = name;
    },
    isDefaultPrevented: function () {
      return !!this._preventDefault;
    }
  };
  function add(eventName, fn) {
    handlers[eventName] || (handlers[eventName] = []);

    var handler = {};
    handler.fn = fn;

    handlers[eventName].push(handler);
  }

  function windowAddEvent(eventName, fn) {
    windowHanders[eventName] || (windowHanders[eventName] = []);

    var handler = {};
    handler.fn = fn;

    windowHanders[eventName].push(handler);
  }

  function remove(eventName, fn) {
    if (handlers[eventName]) {
      for (var i = 0; i < handlers[eventName].length; i++) {
        if (fn === handlers[eventName][i].fn) {
          handlers[eventName].splice(i, 1);
          if (handlers[eventName].length === 0) {
            delete handlers[eventName];
          }
          break;
        }
      }
    }
  }

  function removeWindowEvent(eventName, fn) {
    if (windowHanders[eventName]) {
      for (var i = 0; i < windowHanders[eventName].length; i++) {
        if (fn === windowHanders[eventName][i].fn) {
          windowHanders[eventName].splice(i, 1);
          if (windowHanders[eventName].length === 0) {
            delete windowHanders[eventName];
          }
          break;
        }
      }
    }
  }

  function createEvent(eventName) {
    return new Event(eventName);
  }

  function dispatchEvent(eventName, args) {
    var evt = createEvent(eventName);
    var isDefaultPrevented = false;
    if (handlers[eventName]) {
      for (var i = 0; i < handlers[eventName].length; i++) {
        evt.data = args;
        handlers[eventName][i].fn(evt);
        if (evt.isDefaultPrevented()) {
          isDefaultPrevented = true;
        }
      }
    }

    return !isDefaultPrevented;
  }

  function trigger(eventName, args) {

        var isDefaultPrevented = !dispatchEvent(eventName, args);
        if (args.callbackId) {
            var callbackData = args;
            callbackData.callbackId = args.callbackId;
            callbackData[eventName + 'EventCanceled'] = isDefaultPrevented;
            // AlipayJSBridge.call("__nofunc__",callbackData);
            // delete args.callbackId;
        }
  }

  document = {
    addEventListener: add,
    removeEventListener: remove,
    trigger: trigger,
    sendMessageQueue: sendMessageQueue,
    createEvent: createEvent,
    dispatchEvent: dispatchEvent,
    location: {
      href: 'about:blank',
        toString:function () {
            return location.href;
        }
    },

    title: ''
  };
  window.addEventListener = windowAddEvent;
  window.removeEventListener = removeWindowEvent;
  var msgPortMap = {};

  function trasMsgPort(viewId, pageId, msgPort) {
    msgPort.postMessage = function (data) {
      var _data = {
        data: data,
        type: 'messagePort',
        msgPortId: msgPort.id,
        viewId: viewId,
        pageId: pageId
      };
      AlipayJSBridge.call("postMessage", _data);
    };
    if(!msgPortMap['m_'+viewId]){
      msgPortMap['m_'+viewId] = {};
    }
    if(!msgPortMap['m_' + viewId]['p_' + pageId]){
      msgPortMap['m_' + viewId]['p_' + pageId] = {};
    }
    msgPortMap['m_'+viewId]['p_' + pageId][msgPort.id] = msgPort;
    return msgPort;
  }

  document.addEventListener('push', function (event) {
      var data = event.data.data;
      console.log("onMessage push");
      if (windowHanders['push']) {
        for (var i = 0; i < windowHanders['push'].length; i++) {
          event.data = data;
          windowHanders['push'][i].fn(event);
        }
      }
  });

  document.addEventListener('message', function (event) {
    if (event.data && event.data.type != 'messagePort' && !event.data.beforeunload) {
      var data = event.data.data;
      var eventPorts = event.data.eventPorts;
      var viewId = event.data.viewId;
      var pageId = event.data.pageId || 0;
      if (eventPorts && eventPorts[0]) {
        eventPorts[0] = trasMsgPort(viewId, pageId, eventPorts[0]);
      }
      console.log("onMessage eventPorts");
      if (windowHanders['message']) {
        for (var i = 0; i < windowHanders['message'].length; i++) {
          event.data = data;
          event.ports = eventPorts;
          windowHanders['message'][i].fn(event);
        }
      }
    } else if (event.data && event.data.type == 'messagePort' && event.data.msgPortId) {
      var viewId = event.data.viewId;
      var pageId = event.data.pageId || 0;
      if(!msgPortMap['m_' + viewId] || !msgPortMap['m_' + viewId]['p_' + pageId]){
        console.error('unknown view', event, msgPortMap);
        return;
      }
      var msgPort = msgPortMap['m_' + viewId]['p_' + pageId][event.data.msgPortId];
      if (msgPort && msgPort.onmessage) {
        msgPort.onmessage({
          data: event.data.data
        });
      }
    }  else {
      console.log('unknown event', event);
    }
  });

  Object.defineProperty(document.location, "href", {
    get: function () {
      return document.location._href;
    },

    set: function (newValue) {
      if (typeof newValue !== 'string') return;

      newValue = newValue.trim();
      if(self.AlipayJSBridge._trimLocationHref){
        var rs = self.AlipayJSBridge._trimLocationHref(newValue);
        if(rs){
          for(var key in rs){
            if(key != "href" && typeof rs[key] !== "function"){
                document.location[key] = rs[key];
            }
          }
        }
      }
      document.location._href = newValue;
    }
  });
    /***************Param Type*****************/
    var NEBULA_TYPE_INFO = "NEBULATYPEINFO",NEBULA_TYPE_OF_ARRAYBUFFER = "ArrayBuffer";


    var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    var lookup = new Uint8Array(256);
    for (var i = 0; i < chars.length; i++) {
        lookup[chars.charCodeAt(i)] = i;
    }

    function arrayBufferToBase64(arraybuffer) {
        var bytes = new Uint8Array(arraybuffer),
        i, len = bytes.length, base64 = "";

        for (i = 0; i < len; i+=3) {
          base64 += chars[bytes[i] >> 2];
          base64 += chars[((bytes[i] & 3) << 4) | (bytes[i + 1] >> 4)];
          base64 += chars[((bytes[i + 1] & 15) << 2) | (bytes[i + 2] >> 6)];
          base64 += chars[bytes[i + 2] & 63];
        }

        if ((len % 3) === 2) {
          base64 = base64.substring(0, base64.length - 1) + "=";
        } else if (len % 3 === 1) {
          base64 = base64.substring(0, base64.length - 2) + "==";
        }

        return base64;
    }

    function base64ToArrayBuffer(base64) {
        var bufferLength = base64.length * 0.75,
        len = base64.length, i, p = 0,
        encoded1, encoded2, encoded3, encoded4;

        if (base64[base64.length - 1] === "=") {
          bufferLength--;
          if (base64[base64.length - 2] === "=") {
            bufferLength--;
          }
        }

        var arraybuffer = new ArrayBuffer(bufferLength),
        bytes = new Uint8Array(arraybuffer);

        for (i = 0; i < len; i+=4) {
          encoded1 = lookup[base64.charCodeAt(i)];
          encoded2 = lookup[base64.charCodeAt(i+1)];
          encoded3 = lookup[base64.charCodeAt(i+2)];
          encoded4 = lookup[base64.charCodeAt(i+3)];

          bytes[p++] = (encoded1 << 2) | (encoded2 >> 4);
          bytes[p++] = ((encoded2 & 15) << 4) | (encoded3 >> 2);
          bytes[p++] = ((encoded3 & 3) << 6) | (encoded4 & 63);
        }

        return arraybuffer;
    }

    function transformCallParam(param){
        var result = param;
        for(var key in param){
            if (param.hasOwnProperty(key)) {
                var val = param[key];
                if (val instanceof ArrayBuffer) {
                    param[key] = arrayBufferToBase64(val);
                    if (!result[NEBULA_TYPE_INFO]) {
                        result[NEBULA_TYPE_INFO] = {};
                    }
                    result[NEBULA_TYPE_INFO][key] = {"type" : NEBULA_TYPE_OF_ARRAYBUFFER};
                }
            }
        }
        return result;
    }

    function transformResponseData(responsedata){
        if(responsedata && responsedata[NEBULA_TYPE_INFO]){
            var nebulaTypeInfo = responsedata[NEBULA_TYPE_INFO];
            if (nebulaTypeInfo) {
                for(var key in nebulaTypeInfo){
                    if (nebulaTypeInfo.hasOwnProperty(key)) {
                        var item = nebulaTypeInfo[key];
                        if (item.type) {
                            var typeVal = item["type"];
                            if (typeVal === NEBULA_TYPE_OF_ARRAYBUFFER) {
                                responsedata[key] = base64ToArrayBuffer(responsedata[key]);
                            }
                        }
                    }
                }
            }
        }
        return responsedata;
    }

  var callbackPoll = {};

  AlipayJSBridge = {
    call: function (func, param, callback) {

      if ('string' !== typeof func) {
        return;
      }

      if ('function' === typeof param) {
        callback = param;
        param = null;
      } else if (typeof param !== 'object') {
        param = null;
      }

      var callbackId = func + '_' + new Date().getTime() + (Math.random());
      if ('function' === typeof callback) {
        callbackPoll[callbackId] = callback;
      }

      if (param && param.callbackId) {
        func = {
          responseId: param.callbackId,
          responseData: param
        };
        delete param.callbackId;
      } else {
       var dataJson = transformCallParam(param),targetData;
        try{
          targetData = dataJson;
        }catch(ex){
          console.log(ex);
          targetData = {};
        }
        func = {
          handlerName: func,
          data: targetData
        };
        func.callbackId = '' + callbackId;
      }
//      nativeFlushQueueImmediate([func]);
      nativeFlushQueueImmediate(JSON.stringify(func));
    },

    _handleMessageFromNative: function (message) {
    // Note: 这里需要去掉本地的日志打印。 在appx2.0真机调试时，该日志打印会导致sendSocketMessage无限调用的问题。
    // 原因：该日志打印会触发sendSocketMessage的jsapi调用，该jsapi调用的回调又触发当前所在function，
    // 当前所在function又触发日志打印，进而导致问题。
//      console.log("_handleMessageFromNative " + JSON.stringify(message));
      var resp = JSON.parse(message);
//      var handlerName = resp.handlerName;
//      var data = resp.data;
//      data || (data = {});
//      data.callbackId = resp.callbackId;
      // setTimeout(function() {
      //document.trigger(handlerName, data);
      AlipayJSBridge._invokeJS(resp);
      // },1);
    },

    _invokeJS: function (resp) {
      if (resp.responseId) {
        var func = callbackPoll[resp.responseId];
        if (!(typeof resp.keepCallback == 'boolean' && resp.keepCallback)) {
          delete callbackPoll[resp.responseId];
        }

        if ('function' === typeof func) {
          func(transformResponseData(resp.responseData));
        }
      } else if (resp.handlerName) {
        if (resp.callbackId) {
          resp.data = resp.data || {};
          resp.data.callbackId = resp.callbackId;
        }
        document.trigger(resp.handlerName, resp.data);
      }
    },

    _fetchQueue: function () {
      var messageQueueString = JSON.stringify(document.sendMessageQueue);
      document.sendMessageQueue.length = 0;
      return messageQueueString;
    },

    _domReady: function () {
      GLOBAL.ALIPAYH5STARTUPPARAMS || {};
      GLOBAL.ALIPAYH5STARTUPPARAMS = null;
      document.dispatchEvent('DOMContentLoaded', null);
      document.dispatchEvent('AlipayJSBridgeReady', null);
    }
  };

  window.history = {
    length: 1
  };

  window.location = document.location;
  window.document = document;
})();