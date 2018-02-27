var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":160,"id":348,"methods":[{"el":35,"sc":5,"sl":32},{"el":40,"sc":5,"sl":37},{"el":45,"sc":5,"sl":42},{"el":50,"sc":5,"sl":47},{"el":55,"sc":5,"sl":52},{"el":60,"sc":5,"sl":57},{"el":65,"sc":5,"sl":62},{"el":75,"sc":5,"sl":71},{"el":81,"sc":5,"sl":77},{"el":87,"sc":5,"sl":83},{"el":93,"sc":5,"sl":89},{"el":99,"sc":5,"sl":95},{"el":106,"sc":5,"sl":101},{"el":112,"sc":5,"sl":108},{"el":118,"sc":5,"sl":114},{"el":124,"sc":5,"sl":120},{"el":131,"sc":5,"sl":126},{"el":142,"sc":5,"sl":137},{"el":149,"sc":5,"sl":144},{"el":155,"sc":5,"sl":151},{"el":159,"sc":5,"sl":157}],"name":"ByteRange_ExceptionsTest","sl":26}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
