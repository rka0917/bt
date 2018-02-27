var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":162,"id":13584,"methods":[{"el":67,"sc":13,"sl":57},{"el":75,"sc":13,"sl":69},{"el":77,"sc":5,"sl":51},{"el":86,"sc":13,"sl":83},{"el":91,"sc":13,"sl":88},{"el":93,"sc":5,"sl":79},{"el":103,"sc":76,"sl":96},{"el":104,"sc":5,"sl":95},{"el":117,"sc":5,"sl":114},{"el":128,"sc":5,"sl":125},{"el":148,"sc":5,"sl":139},{"el":161,"sc":5,"sl":153}],"name":"ProtocolTestBuilder","sl":45}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
