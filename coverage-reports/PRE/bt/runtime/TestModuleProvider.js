var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":37,"id":12467,"methods":[{"el":36,"sc":5,"sl":33}],"name":"TestModuleProvider","sl":24},{"el":31,"id":12467,"methods":[{"el":30,"sc":9,"sl":27}],"name":"TestModuleProvider.TestModule","sl":26}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
