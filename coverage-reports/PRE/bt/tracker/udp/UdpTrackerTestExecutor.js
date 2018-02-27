var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":95,"id":4518,"methods":[{"el":41,"sc":5,"sl":38},{"el":46,"sc":5,"sl":43},{"el":50,"sc":5,"sl":48},{"el":94,"sc":5,"sl":52}],"name":"UdpTrackerTestExecutor","sl":32}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
