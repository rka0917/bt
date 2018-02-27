var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":75,"id":13152,"methods":[{"el":41,"sc":5,"sl":36},{"el":48,"sc":5,"sl":43},{"el":53,"sc":5,"sl":50},{"el":58,"sc":5,"sl":55},{"el":64,"sc":5,"sl":60},{"el":70,"sc":5,"sl":66},{"el":74,"sc":5,"sl":72}],"name":"DefaultSwarmPeerFactory","sl":29}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
