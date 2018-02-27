var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":86,"id":13063,"methods":[{"el":41,"sc":9,"sl":38},{"el":46,"sc":9,"sl":43},{"el":51,"sc":9,"sl":48},{"el":56,"sc":9,"sl":53},{"el":62,"sc":9,"sl":58},{"el":85,"sc":5,"sl":74}],"name":"Swarm_EncryptedIT","sl":33}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
