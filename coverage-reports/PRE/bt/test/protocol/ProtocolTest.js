var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":203,"id":13511,"methods":[{"el":49,"sc":5,"sl":47},{"el":58,"sc":5,"sl":56},{"el":72,"sc":5,"sl":65},{"el":79,"sc":5,"sl":77},{"el":86,"sc":5,"sl":84},{"el":97,"sc":5,"sl":95},{"el":137,"sc":5,"sl":110},{"el":181,"sc":5,"sl":148},{"el":202,"sc":5,"sl":183}],"name":"ProtocolTest","sl":40}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
