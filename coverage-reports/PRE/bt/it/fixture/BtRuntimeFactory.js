var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":65,"id":13135,"methods":[{"el":40,"sc":5,"sl":37},{"el":50,"sc":13,"sl":44},{"el":54,"sc":5,"sl":42},{"el":64,"sc":5,"sl":56}],"name":"BtRuntimeFactory","sl":30}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
