!function(){var o=worker.__nativeLog__;function e(){}function r(){return[]}function n(){try{for(var e="",r=0;r<arguments.length;r++){var n=arguments[r];0<r&&(e+=" "),n instanceof Error?e+=n.message+"\n"+n.stack:e+="object"==typeof n?JSON.stringify(n):n}o(e)}catch(e){}}worker.__nativeLog__=null,worker.performance={clearMarks:e,clearMeasures:e,clearResourceTimings:e,getEntries:r,getEntriesByName:r,getEntriesByType:r,setResourceTimingBufferSize:e,mark:e,measure:e,now:function(){return Date.now()},toJSON:function(){return{}}},worker.onerror=function(e){try{n("###############################################"),n(e),n("###############################################")}catch(e){}},worker.console={log:n,info:n,debug:n,warn:n,error:n,exception:n,clear:e,count:e,countReset:e,dir:e,dirxml:e,group:e,groupCollapsed:e,groupEnd:e,profile:e,profileEnd:e,table:e,time:e,timeEnd:e,timeLog:e,timeStamp:e,trace:e,assert:function(){arguments[0]||console.warn("Assertion failed:",Array.prototype.slice.call(arguments).slice(1))}}}();