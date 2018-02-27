var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":234,"id":13327,"methods":[{"el":74,"sc":5,"sl":60},{"el":89,"sc":5,"sl":76},{"el":100,"sc":5,"sl":97},{"el":111,"sc":5,"sl":108},{"el":125,"sc":5,"sl":119},{"el":140,"sc":5,"sl":133},{"el":156,"sc":5,"sl":149},{"el":170,"sc":5,"sl":167},{"el":181,"sc":5,"sl":178},{"el":193,"sc":5,"sl":188},{"el":216,"sc":5,"sl":200},{"el":220,"sc":5,"sl":218},{"el":224,"sc":5,"sl":222},{"el":229,"sc":5,"sl":226},{"el":233,"sc":5,"sl":231}],"name":"SwarmBuilder","sl":43}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = $jsonSrcFileLines
