var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":267,"id":4826,"methods":[{"el":38,"sc":5,"sl":34},{"el":43,"sc":5,"sl":40},{"el":48,"sc":5,"sl":45},{"el":53,"sc":5,"sl":50},{"el":58,"sc":5,"sl":55},{"el":63,"sc":5,"sl":60},{"el":68,"sc":5,"sl":65},{"el":73,"sc":5,"sl":70},{"el":78,"sc":5,"sl":75},{"el":83,"sc":5,"sl":80},{"el":88,"sc":5,"sl":85},{"el":93,"sc":5,"sl":90},{"el":98,"sc":5,"sl":95},{"el":103,"sc":5,"sl":100},{"el":108,"sc":5,"sl":105},{"el":113,"sc":5,"sl":110},{"el":118,"sc":5,"sl":115},{"el":123,"sc":5,"sl":120},{"el":128,"sc":5,"sl":125},{"el":133,"sc":5,"sl":130},{"el":138,"sc":5,"sl":135},{"el":143,"sc":5,"sl":140},{"el":148,"sc":5,"sl":145},{"el":153,"sc":5,"sl":150},{"el":158,"sc":5,"sl":155},{"el":163,"sc":5,"sl":160},{"el":168,"sc":5,"sl":165},{"el":173,"sc":5,"sl":170},{"el":178,"sc":5,"sl":175},{"el":183,"sc":5,"sl":180},{"el":188,"sc":5,"sl":185},{"el":193,"sc":5,"sl":190},{"el":198,"sc":5,"sl":195},{"el":203,"sc":5,"sl":200},{"el":208,"sc":5,"sl":205},{"el":213,"sc":5,"sl":210},{"el":218,"sc":5,"sl":215},{"el":223,"sc":5,"sl":220},{"el":229,"sc":5,"sl":225},{"el":235,"sc":5,"sl":231},{"el":240,"sc":5,"sl":237},{"el":245,"sc":5,"sl":242},{"el":249,"sc":5,"sl":247},{"el":256,"sc":5,"sl":251},{"el":266,"sc":5,"sl":258}],"name":"PathNormalizerTest","sl":29}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
