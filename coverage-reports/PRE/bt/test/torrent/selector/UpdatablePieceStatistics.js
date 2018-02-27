var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":59,"id":13081,"methods":[{"el":27,"sc":5,"sl":25},{"el":32,"sc":5,"sl":29},{"el":40,"sc":5,"sl":34},{"el":46,"sc":5,"sl":42},{"el":53,"sc":5,"sl":48},{"el":58,"sc":5,"sl":55}],"name":"UpdatablePieceStatistics","sl":21}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
